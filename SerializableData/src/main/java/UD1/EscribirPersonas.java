package UD1;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

import exercisesXML.Persona;

public class EscribirPersonas {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		File fic = new File(".\\src\\main\\resources\\FichPersona.dat");

		FileInputStream filein = new FileInputStream(fic);
		
		ObjectInputStream objectIS = new ObjectInputStream(filein);
		
		System.out.println("Comienza el proceso de creacion del ficero a XML");
		
		ListaPersonas listaper = new ListaPersonas();
		
		try {
			while(true) {
				Persona p = (Persona) objectIS.readObject();
				listaper.add(p);
			}
		} catch (EOFException e) {
		}
		objectIS.close();
		try {
			XStream xstream = new XStream();
			xstream.alias("ListaPersonasMunicipio", ListaPersonas.class);
			xstream.alias("DatosPersona", Persona.class);
			xstream.addPermission(AnyTypePermission.ANY);
			xstream.addImplicitCollection(ListaPersonas.class, "lista");
			
			xstream.toXML(listaper, new FileOutputStream(".\\src\\main\\resources\\Personas.xml"));
			System.out.println("Creado fichero XML");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
