package jaframework.demo;

import jaframework.imp.JAFactory;
import jaframework.def.JAFile;
import jaframework.def.JASession;

public class TestWrite2
{
	public static void main(String[] args)
	{
		JAFactory.registerMapping(Alumno.class);
		
		JASession session = JAFactory.getSession();
		JAFile<Alumno> f = session.getFileByAlias("ALUMNOS");
		
		Alumno a = new Alumno();
		
		for(int i=0; i<f.fileSize(); i++)
		{
			// me posiciono
			f.seek(i);

			// leo
			f.read(a);
			
			// subo la nota
			a.setNota(a.getNota()+1);
			
			// me vuelvo a posicionar
			f.seek(i);
			
			f.write(a);
		}
		
		f.close();
	}
}
