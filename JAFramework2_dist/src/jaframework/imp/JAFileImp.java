package jaframework.imp;

import java.io.RandomAccessFile;

import jaframework.def.JAFile;

public class JAFileImp<T> implements JAFile<T> {

	private int filepos;
	private RandomAccessFile ram;
	
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

}
