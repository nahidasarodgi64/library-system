package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Database.DBconnection;
import model.Book;
import Services.Bookservices;

public  class Bookdaoimplementation implements Bookdao {
	// ConnectionFactory ConnectionFactory;

	public Bookdaoimplementation() {

		// ConnectionFactory = new ConnectionFactory();
	}

	@Override
	public List<Book> getAllBooks() {
		ArrayList<Book> bookList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		final String QUERY = "select * from books";
		try {
			connection = DBconnection.getConnection();
			preparedStatement = connection.prepareStatement(QUERY);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Book book = new Book();
				book.setBook_id(resultSet.getInt("book_id"));
				book.setBook_name(resultSet.getString("book_name"));
				book.setAuthor_id(resultSet.getInt("author_id"));
				book.setBook_price(resultSet.getInt("book_price"));
				book.setCategory_id(resultSet.getInt("category_id"));

		bookList.add(book);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return bookList;
	}
	
	@Override
	public int addBook(Book book) {
		System.out.println(book);
		int status = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBconnection.getConnection();
			preparedStatement = connection.prepareStatement("insert into books values(?,?,?,?,?)");
			preparedStatement.setInt(1, book.getBook_id());
			preparedStatement.setString(2,book.getBook_name());
			preparedStatement.setInt(4, book.getAuthor_id());
			preparedStatement.setInt(3, book.getBook_price());
			preparedStatement.setInt(5, book.getCategory_id());
			
			status=preparedStatement.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
				try {
					if(preparedStatement!=null)
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					if(connection!=null)
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		// TODO Auto-generated method stub
		return status;
	}

	@Override
	public int deleteBook(int book_id1) {
		System.out.println(book_id1);
		int status1= 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBconnection.getConnection();
			preparedStatement = connection.prepareStatement("delete from books where book_id=?");
			preparedStatement.setInt(1,book_id1);
		
		status1=preparedStatement.executeUpdate();
          System.out.println(status1);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
				try {
					if(preparedStatement!=null)
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					if(connection!=null)
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		// TODO Auto-generated method stub
		return status1;
	}
	
	public int updateBook(int book_id2,int book_price1,int category_id1)
			{
		int r=0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBconnection.getConnection();
			preparedStatement = connection.prepareStatement("update books set price=?,category_id=?	where book_id=?");
			preparedStatement.setInt(1,book_id2);
			preparedStatement.setInt(2,book_price1);
			preparedStatement.setInt(3,category_id1);
			
		
		r=preparedStatement.executeUpdate();
          System.out.println("updated successfully"+r);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
				try {
					if(preparedStatement!=null)
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					if(connection!=null)
					connection.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
		
		return r;
	}
	
	
	}


