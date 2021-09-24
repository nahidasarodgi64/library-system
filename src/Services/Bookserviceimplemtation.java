package Services;
import dao.Bookdaoimplementation;
import java.util.List;
import dao.Bookdao;
import model.Book;

public  class Bookserviceimplemtation implements Bookservices {
	
	Bookdao booKDao;
 
 public Bookserviceimplementation() {
	
	 booKDao = new Bookdaoimplementation();
 }
	public Bookserviceimplementation(Bookdao booKDao) {
	this.booKDao = booKDao;
}
	

	public Bookdao getBooKDao() {
		return booKDao;
	}


	public void setBooKDao(Bookdao booKDao) {
		this.booKDao = booKDao;
	}


	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return booKDao.getAllBooks();
	}
	@Override
	public int addBook(Book book) {
		// TODO Auto-generated method stub
		return booKDao.addBook(book);
		
	}
	@Override
	public int deleteBook(int book_id1) {
		// TODO Auto-generated method stub
		return booKDao.deleteBook(book_id1);
	}
	public int updateBook(int book_id2,int book_price1,int category_id1) {
		// TODO Auto-generated method stub
		return booKDao.updateBook( book_id2, book_price1, category_id1);
		
	}
	
	}
