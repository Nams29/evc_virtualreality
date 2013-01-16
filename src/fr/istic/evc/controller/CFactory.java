package fr.istic.evc.controller;

import javax.media.j3d.Appearance;

import fr.istic.evc.controller.CVirtualObject.Shape;

public class CFactory {
	
	public static CVirtualObject newVirtualCube(float size, Appearance app) {
		return new CVirtualObject(size, app);
	}
	
	public static CVirtualObject newVirtualSphere(float size, Appearance app) {
		CVirtualObject obj = new CVirtualObject(size, app, Shape.SPHERE);
		return obj;
	}
	
}
