package jaframework.imp;

import jaframework.def.JAFile;
import jaframework.def.JAIndex;

public class JAIndexImp<T> implements JAIndex<T>{

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean eof() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean read(T record) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int filePos() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void write(T record) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seek(int n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int fileSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getAlias() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void rewrite() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JAFile<T> getFile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(T key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int search(T toSearch) {
		// TODO Auto-generated method stub
		return 0;
	}

}
