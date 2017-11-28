package pkgEmpty;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

import pkgLibrary.Book;
import pkgLibrary.BookException;
import pkgLibrary.Catalog;


public class testGetBooks {
	Catalog cat = ReadXMLFile();
	
	private static Catalog ReadXMLFile() {

		Catalog cat = null;

		String basePath = new File("").getAbsolutePath();
		basePath = basePath + "/src/main/resources/XMLFiles/Books.xml";
		File file = new File(basePath);

		System.out.println(file.getAbsolutePath());
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			cat = (Catalog) jaxbUnmarshaller.unmarshal(file);
			System.out.println(cat);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return cat;

	}
	
	Book newbook = new Book();
	Book book1 = cat.getBooks().get(0);

	@Test
	public void test() throws BookException {
		String id = book1.getId();
		assertEquals(cat.GetBook(id), book1); 
	}
	@Test(expected = BookException.class)
	public void test2() throws BookException {
		cat.GetBook("bk113");
	}
	
	@Test
	public void test3() throws BookException {
		ArrayList<Book> booklist = cat.getBooks();
		booklist.remove(0);
		cat.AddBook(0, book1);
		
		assertEquals(cat.getBooks().indexOf(0), book1);
	}
	
	@Test(expected = BookException.class)
	public void test4() throws BookException {
		cat.AddBook(0, book1);
	}

}
