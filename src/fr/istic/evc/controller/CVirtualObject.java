package fr.istic.evc.controller;

import javax.media.j3d.Appearance;
import javax.media.j3d.Transform3D;

import fr.istic.evc.presentation.PVirtualObject;

public class CVirtualObject {
	
	private PVirtualObject presentation;
	private Shape shape = Shape.BOX;
	
	public CVirtualObject(float size, Appearance app) {
		this.presentation = new PVirtualObject(this, size, app);
	}
	
	public CVirtualObject(float size, Appearance app, Shape shape) {
		this.shape = shape;
		this.presentation = new PVirtualObject(this, size, app);
	}
	
	public PVirtualObject getPresentation() {
		return presentation;
	}

	public void p2cTransform(Transform3D t1) {
		// TODO
		if (true) {
			this.presentation.c2pTransform(t1);
		}
	}
	
	/**
	 * @return the shape
	 */
	public Shape getShape() {
		return shape;
	}

	/**
	 * @param shape the shape to set
	 */
	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public enum Shape {
	    BOX, SPHERE
	}
}
