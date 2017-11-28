package pkgLibrary;

import java.util.ArrayList;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Catalog {

	@XmlAttribute
	int id;	
	
	@XmlElement(name="book")
	ArrayList<Book> books;
	
	
	public int getId() {
		return id;
	}
	

	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Book> getBooks() {
		return books;
	}
	

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}
	
	public Object GetBook(String ID) throws BookException {
			for (Book b : this.getBooks()) {
			if (b.getId() == ID) {
				return b; 
			}
			else {
				throw new BookException();
			}
		}
			return null;
	}
	
public void AddBook(int ID, Book b) throws BookException {
	for (Book n : this.getBooks()) {
		if (b.getId() == n.getId()) {
			throw new BookException();
		}
		else {
			this.getBooks().add(b);
		}
	}
}
		}
	

