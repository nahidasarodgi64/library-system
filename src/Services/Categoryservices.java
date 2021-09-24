package Services;
import java.util.List;

import model.Category;

public interface Categoryservices {
	List<Categoryservices> getAllCategorys();
	int addBook(Category category);

}
