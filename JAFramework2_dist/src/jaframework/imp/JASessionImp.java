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
		return this.getFileByAlias(recClazz.getAnnotation(File.class).alias());
	}

	@Override
	public <T> JAFile<T> getFileByAlias(String alias) {
		JAFactory.getClasses().get(alias);
		
		JAFileModel filemodel = JAFactory.getClasses().get(alias);
		
		JAFileImp<T> file = new JAFileImp<T>(filemodel.getClazz());
		file.setFilepath(filemodel.getName());
		file.setAlias(alias);
		
		return file;
	}

	@Override
	public <T> JAIndex<T> getIndexByAlias(JAFile<T> jafile, String indexAlias) {
		return null;
	}
	
}
