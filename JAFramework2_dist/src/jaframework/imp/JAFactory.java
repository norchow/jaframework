package jaframework.imp;

import java.lang.reflect.Field;
import java.util.HashMap;

import jaframework.def.JASession;
import jaframework.def.annotations.File;

public class JAFactory {
	
	private static HashMap<String, JAFileModel> classes = new HashMap<String, JAFileModel>();
	
	public static HashMap<String, JAFileModel> getClasses() {
		return classes;
	}

	public static void setClasses(HashMap<String, JAFileModel> classes) {
		JAFactory.classes = classes;
	}

	public static JASession getSession(){
		return new JASessionImp();
	}
	
	public static <T> void registerMapping(Class<T> clazz){
		JAFileModel model = new JAFileModel();
		
		String alias = clazz.getAnnotation(File.class).alias();
		model.setName(clazz.getAnnotation(File.class).name());
		
		HashMap<String, Integer> attributes = new HashMap<String, Integer>(); 
		for(Field field : clazz.getFields()){
			attributes.put(field.getName(), field.getAnnotation(jaframework.def.annotations.Field.class).size());
		}
		
		model.setAtributos(attributes);
		
		classes.put(alias, model);
	}
}
