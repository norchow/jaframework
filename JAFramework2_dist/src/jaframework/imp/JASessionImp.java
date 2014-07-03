package jaframework.imp;

import java.io.RandomAccessFile;

import jaframework.def.JAFile;
import jaframework.def.JAIndex;
import jaframework.def.JASession;
import jaframework.def.annotations.File;

public class JASessionImp implements JASession{

	
	public JASessionImp() {

	}
	
	@Override
	public <T> JAFile<T> getFile(Class<T> recClazz) {
//		JAFileImp<T> file = new JAFileImp<T>();
//		file.setFilepath(recClazz.getAnnotation(File.class).name());
//		file.setAlias(recClazz.getAnnotation(File.class).alias());
//		return file;
		return this.getFileByAlias(recClazz.getAnnotation(File.class).alias());
	}

	@Override
	public <T> JAFile<T> getFileByAlias(String alias) {
		JAFactory.getClasses().get(alias);
		
		JAFileImp<T> file = new JAFileImp<T>();
		// TODO Guardar la clase en el diccionario de factory y usarlo aca
		// para ponerlo en T
		
//		file.setFilepath(recClazz.getAnnotation(File.class).name());
//		file.setAlias(recClazz.getAnnotation(File.class).alias());
		
		return new JAFileImp<T>();
	}

	@Override
	public <T> JAIndex<T> getIndexByAlias(JAFile<T> jafile, String indexAlias) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
