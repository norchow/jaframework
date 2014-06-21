package jaframework.demo;

import jaframework.imp.JAFactory;
import jaframework.def.JAFile;
import jaframework.def.JAIndex;
import jaframework.def.JASession;

public class TestEmpleado
{
	public static void main(String[] args)
	{
		JAFactory.registerMapping(Empleado.class);
		
		JASession session  = JAFactory.getSession();
		
		JAFile<Empleado> f = session.getFile(Empleado.class);
		System.out.println(f.fileSize());
		f.reset();
		
		Empleado e = new Empleado();
		
//		while( f.read(e) )
//		{
//			System.out.println(e);
//		}
		
		JAIndex<Empleado> i1=session.getIndexByAlias(f,"legajo");
		i1.reset();
		
		while( i1.read(e) )
		{
			System.out.println(e);
		}
				
		f.close();
	}
}
