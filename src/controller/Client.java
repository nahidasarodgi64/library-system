package controller;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import dao.BookDaoImplementation;
import model.Book;
import Services.Bookserviceimplemtation;
import Services.Bookservices;

public class Client {


	public static void main(String[] args) {
		String str;
	BookService bookService = new BookServiceImplementation();
	do
	{
	Scanner scanner=new Scanner(System.in);
	System.out.println("1.Book_Details"+"\n"+"2.Add_Book"+"\n"+"3.Delete_Record"+"\n"+"4.Update_Record");
	System.out.println("\nEnter Choice");
	int choice = scanner.nextInt();

	List<Book> bookList=bookService.getAllBooks();
	Iterator<Book> itr=bookList.iterator();
	switch(choice)
	{
	case 1:
	System.out.println("**********   All book details ***************");
	while (itr.hasNext()) {
		Book book = (Book) itr.next();
		System.out.println("book_id:- "+ book.getBook_id());
		System.out.println("book_name:- "+ book.getBook_name());
		System.out.println("book_price:- "+ book.getBook_price());
		System.out.println("author_id:- "+ book.getAuthor_id());
		System.out.println("category_id:- "+ book.getCategory_id());

		System.out.println("**************************************");
	}
	
	break;
	case 2:
		System.out.println("Fill Informantion");
		System.out.println("Fill Up Book ID");
		int book_id = scanner.nextInt();
		System.out.println("Fill Up Book Name");
		String book_name = scanner.next();	
		System.out.println("Fill Up Book Price");
		int book_price = scanner.nextInt();
		System.out.println("Fill Up Author ID");
		int author_id = scanner.nextInt();	
		System.out.println("Fill Up Category_Id");
		int category_id = scanner.nextInt();
	 Book book= new Book( book_id,book_name,book_price,author_id,category_id);
	 int status=bookService.addBook(book);
	    if(status>0) {
	    	System.out.println("Book added sucessfully.....");
	    }else {
	    	System.out.println("Unable to add book.........");
	    }
	break;
	
case 3:
	System.out.println("Delete Book");
	System.out.println("Fill Up Book ID");
	
	int book_id1 = scanner.nextInt();
int status1=bookService.deleteBook(book_id1);
       	
    if(status1>0) {
    	System.out.println("Book Delete sucessfully.....");
    }else {
    	System.out.println("Unable to delete book......");
    }
break;
	
	/*case 4:
	System.out.println("Enter Book Id To Update Record");*/
	case 4:
		System.out.println("Enter Book Id to update record");
	int book_id2 = scanner.nextInt();
	System.out.println("Enter Book price to update");
	int book_price1 = scanner.nextInt();
	System.out.println("Enter category id to update");
	int category_id1= scanner.nextInt();
	
	bookService.updateBook(book_id2, book_price1, category_id1);
break;}
System.out.println("");
	System.out.println("You Want Do More Opretions Yes/No");
	str=scanner.next();
	}while(str.equals("YES")||str.equals("yes"));
	}
	}
© 2021 GitHub, Inc.