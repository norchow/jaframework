package jaframework.imp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import jaframework.def.JAFile;

public class JAFileImp<T> implements JAFile<T> {

//	private int filepos;
	private String filepath;
//	private String filename;
	private String alias;
	private RandomAccessFile raf;
	private int registerSize;
	
	public JAFileImp(Class<?> clazz) {
		this.setRegisterSize(JAFactory.getRegisterSize(clazz));
	}

	@Override
	public void reset() {
		try {
			raf = new RandomAccessFile(filepath, "r");
			raf.seek(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean eof() {
		return this.filePos() == this.fileSize();
	}

	@Override
	public boolean read(T object) {
		byte[] reg = new byte[this.getRegisterSize()];
		try {
			if(!this.eof()){
				raf.read(reg); //El reg va por referencia y trae un registro del archivo
				JAFactory.getObject(object, reg);
				raf.seek(raf.getFilePointer()+2); //salvo el salto de linea
				return true;
			}
			else
				return false;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int filePos() {
		try {
			return (int) raf.getFilePointer() / this.getRegisterSize();
		} catch (IOException e) {
			return -1;
		}
	}

	@Override
	public void write(T object) {
		byte[] reg = JAFactory.buildByteArray(object);
		try {
			raf.write(reg);
			raf.writeBytes("\r\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void seek(int n) {
		try {
			raf.seek(n * (this.getRegisterSize()+2));//salvo los saltos de linea
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int fileSize() {
		try {
			return (int) raf.length() / (this.getRegisterSize()+2);//salvo los saltos de linea
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

	public int getRegisterSize() {
		return registerSize;
	}

	public void setRegisterSize(int registerSize) {
		this.registerSize = registerSize;
	}


}
