package archivos;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Clase con los m�todos necesarios para leer objetos tipo <T> de un archivo
 * @author Fausto Redrovan
 * @version 15/06/2023
 *
 * @param <T> Clase gen�rica para el tipo de los objetos que son recuperados del archivo
 */
public class Lectura<T> {
	private String nombreArchivo;
	private FileInputStream archivo;
	private ObjectInputStream lectura;

	/**
	 * Constructor que inicializa el nombre del archivo de lectura
	 * @param nombreArchivo Ruta y nombre del archivo que contiene los objetos a leer
	 */
	public Lectura(String nombreArchivo) {
		super();
		this.nombreArchivo = nombreArchivo;
	}

	/**
	 * Abre el flujo para la carga de objetos desde el archivo <em>nombreArchivo</em>
	 * @throws IOException Lanza la excepci�n de I/O ante cualquier error con el archivo
	 */
	public void abrir() throws IOException {
		archivo = new FileInputStream(nombreArchivo);
		lectura = new ObjectInputStream(archivo);
	}
	
	/**
	 * Lee un solo objeto del archivo a trav�s del flujo configurado
	 * @return El objeto de tipo <T> recuperado del archivo
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public T leer() throws ClassNotFoundException, IOException {
		try {
			if(lectura !=null)
				return (T) lectura.readObject();
			else
				return null;
		}
		catch(EOFException eof) {
			return null;
		}		
	}
	
	/**
	 * Cierra el flujo para desbloquear el archivo
	 * @throws IOException
	 */
	public void cerrar() throws IOException {
		if(lectura != null) {
			lectura.close();
		}
	}
	
}
