package save_load;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class classLoader extends ClassLoader {

	private String directoryPath = "res";
	private static  ArrayList<Class<?>> classes;

	public classLoader(ClassLoader parent) {
		super(parent);
	}

	public static ArrayList<Class<?>> getShapes() throws Exception{
		ClassLoader parentClassLoader = classLoader.class.getClassLoader();
		classLoader classLoader = new classLoader(parentClassLoader);
		classLoader.getClasses();
		return classes;
	}
	
	

	private void getClasses() throws Exception {
		classes = new ArrayList<Class<?>>();
		File dir = new File(directoryPath);
		File[] directoryListing = dir.listFiles();
		if (directoryListing != null) {
			for (File child : directoryListing) {
				if (child.getAbsolutePath().matches(".*\\.class")) {
					classes.add(loadClass(child));
				}
			}
		} else {
		}
	}

	private Class<?> loadClass(File f) throws ClassNotFoundException,
			IOException {
		String url = f.toURI().toString();
		URL myUrl = new URL(url);
		URLConnection connection = myUrl.openConnection();
		InputStream input = connection.getInputStream();
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		int data = input.read();

		while (data != -1) {
			buffer.write(data);
			data = input.read();
		}
		input.close();
		byte[] classData = buffer.toByteArray();
		return defineClass(classData, 0, classData.length);
	}

//	public static void main(String[] args) throws Exception {
//		
//		Object o = classLoader.classes.get(0).newInstance();
//		Constructor<?> gg = classLoader.classes.get(0).getConstructor(Integer.class);
//		 
//		gg.
//		System.out.println(classLoader.classes.get(1).getName());
//
//	}

}
