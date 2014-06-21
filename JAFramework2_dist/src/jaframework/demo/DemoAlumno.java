package jaframework.demo;

import jaframework.imp.JAFactory;
import jaframework.def.JAFile;
import jaframework.def.JAIndex;

public class DemoAlumno
{
	public static void main(String[] args)
	{
		JAFactory.registerMapping(Alumno.class);
		JAFile<Alumno> f = JAFactory.getSession().getFile(Alumno.class);
		JAIndex<Alumno> i = JAFactory.getSession().getIndexByAlias(f, "LEG");
		
		Alumno reg = new Alumno();
		while( i.read(reg) )
		{
			System.out.println(reg);
		}
	}
}
