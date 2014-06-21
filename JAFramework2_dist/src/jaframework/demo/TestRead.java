package jaframework.demo;

import jaframework.imp.JAFactory;
import jaframework.def.JAFile;
import jaframework.def.JASession;

public class TestRead
{
	public static void main(String[] args)
	{
		// registro los mappings
		JAFactory.registerMapping(Alumno.class);
		
		// obtengo la session
		JASession session = JAFactory.getSession();
		
		// pido el file
		JAFile<Alumno> f = session.getFileByAlias("ALUMNOS");
		f.reset();
		
		
		Alumno a = new Alumno();
		while( f.read(a) )
		{
			System.out.println(a);
		}
		 
		f.close();
	}
}
