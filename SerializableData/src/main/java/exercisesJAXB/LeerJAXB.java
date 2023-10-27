package exercisesJAXB;

import java.io.FileReader;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class LeerJAXB {

	public static void main(String[] args) {
		System.out.println("Leo el XML");
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(Libreria.class);
			Unmarshaller unmars = context.createUnmarshaller();
			
			Libreria lib = (Libreria) unmars.unmarshal(new FileReader(".\\src\\main\\resources\\Libreria.xml"));
			System.out.printf("Nombre: %s\n", lib.getNombre());
			System.out.printf("Lugar: %s\n", lib.getLugar());
			System.out.println("Libros: ");
			
			ArrayList<Libro> lista = lib.getListaLibro();
			lista.forEach(l -> System.out.printf("\tTitulo: %s - Autor: %s - ISBN: %s\n",l.getNombre(), l.getAutor(), l.getIsbn()));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}