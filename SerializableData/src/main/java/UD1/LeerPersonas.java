package UD1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

import exercisesXML.Persona;

public class LeerPersonas {

	public static void main(String[] args) throws FileNotFoundException {
		XStream xstream = new XStream();
		
		xstream.alias("ListaPersonasMunicipio", ListaPersonas.class);
		xstream.alias("DatosPersona", Persona.class);
		xstream.addImplicitCollection(ListaPersonas.class, "lista");
		xstream.addPermission(AnyTypePermission.ANY);
		
		ListaPersonas listadoTodas = (ListaPersonas) xstream.fromXML(
				new FileInputStream(".\\src\\main\\resources\\Personas.xml"));
		
		System.out.println("Numero de personas: " + listadoTodas.getListaPersonas().size());
		
		List<Persona> listaPersonas = new ArrayList<Persona>();
		listaPersonas = listadoTodas.getListaPersonas();
		
		listaPersonas.forEach(p -> {
			System.out.printf("\tNombre: %s (%d años) %n", p.getNombre(), p.getEdad());
		});
		System.out.println("Fin de listado");

	}

}
