package jaframework.demo;

import jaframework.imp.JAFactory;
import jaframework.def.JAFile;
import jaframework.def.JAIndex;
import jaframework.def.JASession;

public class TestIndices
{
	public static void main(String[] args)
	{
		JAFactory.registerMapping(Alumno.class);
		JASession session = JAFactory.getSession();
		
		JAFile<Alumno> f = session.getFileByAlias("ALUMNOS");
		
		JAIndex<Alumno> idx = session.getIndexByAlias(f, "IDX1");
				
		idx.reset();
		Alumno r = new Alumno();
		while( idx.read(r) )
		{
			System.out.println(r);
		}
		
		idx.close();
		f.close();
	}
}
