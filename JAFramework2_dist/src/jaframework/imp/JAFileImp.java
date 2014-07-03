package jaframework.imp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import jaframework.def.JAFile;

public class JAFileImp<T> implements JAFile<T> {

	private int filepos;
	private String filepath;
//	private String filename;
	private String alias;
	private RandomAccessFile raf;
	
	@Override
	public void reset() {
		try {
			raf = new RandomAccessFile(filepath, "r");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean eof() {
		try {
			return raf.getFilePointer()==raf.length();
		} catch (IOException e) {
			return false;
		}
	}

	@Override
	public boolean read(T record) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int filePos() {
		try {
			return (int) raf.getFilePointer();
		} catch (IOException e) {
			return 0;
		}
	}

	@Override
	public void write(T record) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seek(int n) {
		try {
			raf.seek(n);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int fileSize() {
		try {
			return (int) raf.length();
		} catch (IOException e) {
			return 0;
		}
	}

	@Override
	public void close() {
		try {
			raf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public String getAlias() {
		return alias;
	}
	
	public void setAlias(String alias) {
		this.alias = alias;
	}

	@Override
	public void rewrite() {
		try {
			raf = new RandomAccessFile(filepath, "rw");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
//	public String getFilename() {
//		return filename;
//	}
//
//	public void setFilename(String filename) {
//		this.filename = filename;
//	}
	
	public int getFilepos() {
		return filepos;
	}

	public void setFilepos(int filepos) {
		this.filepos = filepos;
	}

}
