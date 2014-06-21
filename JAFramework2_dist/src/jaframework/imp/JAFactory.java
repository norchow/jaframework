package jaframework.imp;

import jaframework.def.JASession;

public class JAFactory {
	
	public static JASession getSession(){
		return new JASessionImp();
	}
	
	public static <T> void registerMapping(Class<T> clazz){
		
	}
}
