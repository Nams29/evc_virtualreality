package fr.istic.evc.presentation;

import javax.media.j3d.Appearance;

import com.sun.j3d.utils.geometry.Box;

public class CubeVO extends VirtualObject {
	
	public CubeVO(float size) {
		this(size, new Appearance());
	}
	
	public CubeVO(float size, Appearance app) {
		super();
		addChild(new Box(size, size, size, app));
	}
	
}
