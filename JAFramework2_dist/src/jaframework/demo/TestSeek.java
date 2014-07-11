package jaframework.demo;

import jaframework.imp.JAFactory;
import jaframework.def.JAFile;
import jaframework.def.JASession;

public class TestSeek
{
	public static void main(String[] args)
	{
		// registro los mappings
		JAFactory.registerMapping(Alumno.class);
		JASession session = JAFactory.getSession();
		
		JAFile<Alumno> f = session.getFileByAlias("ALUMNOS");
		f.reset();
		
		Alumno a = new Alumno();
		for(int i=0; i<f.fileSize(); i++ )
		{
			f.seek(i);
			System.out.println("recpos="+f.filePos());
			f.read(a);
			System.out.println(a);
		}
		 
		f.close();
	}
}
