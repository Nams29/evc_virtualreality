package fr.istic.evc.presentation;

import javax.media.j3d.Appearance;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;

import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.geometry.Sphere;

import fr.istic.evc.controller.CVirtualObject;
import fr.istic.evc.controller.CVirtualObject.Shape;

public class PVirtualObject extends TransformGroup {
	
	private CVirtualObject controller;
	private Shape shape;
	
	public PVirtualObject(Transform3D t3d, CVirtualObject controller, float size, Appearance app) {
		super(t3d);
		this.controller = controller;
		this.shape = this.controller.getShape();
		this.createObject(size, app);
	}
	
	public PVirtualObject(CVirtualObject controller, float size, Appearance app) {
		super();
		this.controller = controller;
		this.shape = this.controller.getShape();
		this.createObject(size, app);
	}
	
	private void createObject(float size, Appearance app) {
		switch (shape) {
		case BOX:
			this.addChild(new Box(size, size, size, app));
		case SPHERE:
			this.addChild(new Sphere(size, app));
		}
	}
	
	@Override
	public void setTransform(Transform3D t1) {
		this.controller.p2cTransform(t1);
	}
	
	public void c2pTransform(Transform3D t1) {
		super.setTransform(t1);
	}
}
