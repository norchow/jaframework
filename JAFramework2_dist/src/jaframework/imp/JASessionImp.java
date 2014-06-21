package jaframework.imp;

import jaframework.def.JAFile;
import jaframework.def.JAIndex;
import jaframework.def.JASession;
import jaframework.def.annotations.File;

public class JASessionImp implements JASession{

	
	public JASessionImp() {

	}
	
	@Override
	public <T> JAFile<T> getFile(Class<T> recClazz) {
		String filepath = recClazz.getAnnotation(File.class).name();
		
		return new JAFileImp<T>();
	}

	@Override
	public <T> JAFile<T> getFileByAlias(String alias) {
		return new JAFileImp<T>();
	}

	@Override
	public <T> JAIndex<T> getIndexByAlias(JAFile<T> jafile, String indexAlias) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
