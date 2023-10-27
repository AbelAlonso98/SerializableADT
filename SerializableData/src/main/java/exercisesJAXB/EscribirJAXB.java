package exercisesJAXB;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class EscribirJAXB {

	public static void main(String[] args) {
		ArrayList<Libro> libroLista = new ArrayList<Libro>();

		Libro l1 = new Libro("Libro1", "Autor1", "Editorial1", "isbn1");
		Libro l2 = new Libro("Libro2", "Autor2", "Editorial2", "isbn2");
		libroLista.add(l1);
		libroLista.add(l2);

		Libreria miLibreria = new Libreria(libroLista, "LibreriaJAXB", "Uvieu");

		JAXBContext context;
		try {
			context = JAXBContext.newInstance(Libreria.class);

			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(miLibreria, System.out);
			m.marshal(miLibreria, new File(".\\src\\main\\resources\\Libreria.xml"));
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}
