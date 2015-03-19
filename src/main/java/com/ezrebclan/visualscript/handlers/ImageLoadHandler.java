package com.ezrebclan.visualscript.handlers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Set;

import javax.imageio.ImageIO;

import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import com.ezrebclan.visualscript.VisualScript;
import com.ezrebclan.visualscript.refrence.Superglobals;

public class ImageLoadHandler {

	public static void loadImagesFromMethods() {
		Reflections searcher = new Reflections(new ConfigurationBuilder().setUrls(ClasspathHelper.forPackage("com.ezrebclan")).setScanners(new MethodAnnotationsScanner()));
		Set<Method> toRun = searcher.getMethodsAnnotatedWith(ImageLoad.class);
		//System.out.println("Loading methods");
		for (Method method : toRun) {
			//System.out.println(method.getName()+" "+method.getDeclaringClass().toString()+" "+Modifier.isStatic(method.getModifiers()));
			if(Modifier.isStatic(method.getModifiers())) {
				try {
					method.invoke(null, (Object[]) null);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		//System.out.println("done loading methods");
	}
	public static void loadImagesFromFields() {
		Reflections searcher = new Reflections(new ConfigurationBuilder().setUrls(ClasspathHelper.forPackage("com.ezrebclan")).setScanners(new FieldAnnotationsScanner()));
		Set<Field> toLoad = searcher.getFieldsAnnotatedWith(ImageLoad.class);
		for (Field field : toLoad) {
			ImageLoad annotation = field.getAnnotation(ImageLoad.class);
			String imagePath = annotation.imagePath()+annotation.imageName();
			InputStream imageStream = Superglobals.resourceLoader.getResourceAsStream(imagePath);
			try {
				field.set(null, ImageIO.read(imageStream));
			} catch (IllegalArgumentException e) {
				System.err.println("Image not found");
			} catch (IllegalAccessException e) {
				System.err.println("Image unavailiable");
			} catch (IOException e) {
				System.err.println("IO Error while loading image");
			}
		}
	}
}
