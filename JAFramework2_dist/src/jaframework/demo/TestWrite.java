package jaframework.demo;

import jaframework.imp.JAFactory;
import jaframework.def.JAFile;
import jaframework.def.JASession;

public class TestWrite
{
	public static void main(String[] args)
	{
		JAFactory.registerMapping(Alumno.class);
		
		JASession session = JAFactory.getSession();
		JAFile<Alumno> f = session.getFileByAlias("ALUMNOS");
		f.rewrite();
		
		Alumno a = new Alumno();
		a.setFechaIngreso("02/05/2012");
		a.setLegajo(23);
		a.setName("Jose");
		a.setSexo('M');	
		
		// me muevo al final del archivo
		f.seek(f.fileSize());
		
		// grabo
		f.write(a);
		
		f.close();
	}
}
