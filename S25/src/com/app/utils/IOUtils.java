package com.app.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class IOUtils <T>{

	
	public  void saveTofile(T obj, String fileName) throws Exception {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));) {
			out.writeObject(obj);
		}
	}

	
	@SuppressWarnings("unchecked")
	public T getFromFile(String fileName) throws Exception {
		File file = new File(fileName);
		if (file.exists()) {
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
				return (T)in.readObject();
			}
		}
		return null;
	}
}