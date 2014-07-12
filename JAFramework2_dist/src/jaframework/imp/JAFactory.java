package jaframework.imp;

import java.beans.Statement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
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
		model.setAtributos(clazz.getDeclaredFields());
		model.setClazz(clazz);
		
		classes.put(alias, model);
	}

	public static int getRegisterSize(Class<?> clazz) {
		JAFileModel filemodel = classes.get(clazz.getAnnotation(File.class).alias());
		int sum = 0;
		for(Field f : filemodel.getAtributos()){
			sum += f.getAnnotation(jaframework.def.annotations.Field.class).size() + 1;//sumo uno por la coma
		}
		return sum-1;//resto la ultima coma
	}
	
	public static void getObject(Object obj, byte[] reg){
		JAFileModel filemodel = classes.get(obj.getClass().getAnnotation(File.class).alias());
		int regindex = 0;
		for(Field f : filemodel.getAtributos()){
			try {
				Class<?> type = f.getType();
				byte[] register = Arrays.copyOfRange(reg, regindex, regindex + f.getAnnotation(jaframework.def.annotations.Field.class).size());
				
				Statement statement = new Statement(obj, "set"+f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1), new Object[]{castValue(register, type)});
				statement.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
			regindex += f.getAnnotation(jaframework.def.annotations.Field.class).size()+1;
		}
	}
	
	public static byte[] buildByteArray(Object obj){
		byte[] value = new byte[JAFactory.getRegisterSize(obj.getClass())];
		JAFileModel filemodel = classes.get(obj.getClass().getAnnotation(File.class).alias());
		int regindex = 0;
		for(Field f : filemodel.getAtributos()){
			try {
				
				Class<?> type = f.getType();
				
				Method getter = obj.getClass().getMethod("get"+f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1));
				byte[] objValue = getter.invoke(obj).toString().getBytes();
				objValue = completeByteArray(objValue, type, f.getAnnotation(jaframework.def.annotations.Field.class).size());
				int i=0;
				for(i=0;i<f.getAnnotation(jaframework.def.annotations.Field.class).size();i++){
					value[regindex+i] = objValue[i];
				}
				if(regindex+i<JAFactory.getRegisterSize(obj.getClass()))
					value[regindex+i] = ',';
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			regindex += f.getAnnotation(jaframework.def.annotations.Field.class).size()+1;
		}
		return value;
	}
	
	private static byte[] completeByteArray(byte[] objValue, Class<?> type,int size) {
		byte[] objDef = new byte[size];
		byte[] objComp = new byte[size-objValue.length];
		if(type.equals(Integer.TYPE)){
			for(int i = 0; i<(size-objValue.length);i++){
				objComp[i] = '0';
			}
			//concateno el array de complemento con el de valores para armar el definitivo
			System.arraycopy(objComp, 0, objDef, 0, objComp.length);
			System.arraycopy(objValue, 0, objDef, objComp.length, objValue.length);
		}else{
			for(int i = 0; i<size; i++){
				try{
					objDef[i] = objValue[i];
				}catch(Exception ex){
					objDef[i] = ' ';
				}
			}
		}
		return objDef;
	}

	private static Object castValue(byte[] value, Class<?> type){
		if(type.equals(Integer.TYPE)){ return Integer.parseInt(new String(value));};
		if(type.equals(Character.TYPE)){ return (char) value[0];};
		if(type.equals(String.class)){ return new String(value).trim();}; 
		if(type.equals(Double.TYPE)){return new Double(new String(value));};
		if(type.equals(Float.TYPE)){return new Float(new String(value));};
		if(type.equals(Long.TYPE)){return new Long(new String(value));};
		if(type.equals(Boolean.TYPE)){return new Boolean(new String(value));};
		return null;
	}

}
