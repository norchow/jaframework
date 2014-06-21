package jaframework.demo;

import jaframework.imp.JAFactory;
import jaframework.def.JAFile;
import jaframework.def.JASession;

public class AlumnoDemo1
{
	public static void main(String[] args)
	{
		// registro los mappings
		JAFactory.registerMapping(Alumno.class);
		
		// obtengo la session
		JASession session  = JAFactory.getSession();
		
		// pido el archivo por su alias 
		JAFile<Alumno> f = session.getFileByAlias("ALUMNOS");		
		
		// muevo el apuntador hacia el primer registro
		f.reset();
		
		// instancio un alumno
		Alumno a = new Alumno();
		
		while( f.read(a) )
		{
			System.out.println(a);
		}
		
		f.close();
		
	}
}
