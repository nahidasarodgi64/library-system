package Services;
import java.util.List;

import model.Author;
public interface  AuthorServices {
	List<Author> getAllAuthors();
	int addBook(Author author);

}
