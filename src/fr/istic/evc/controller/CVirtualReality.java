package fr.istic.evc.controller;

import fr.istic.evc.abstraction.VirtualReality;
import fr.istic.evc.presentation.VirtualRealityFrame;

public class CVirtualReality extends VirtualReality {
	
	private VirtualRealityFrame presentation;

	public CVirtualReality() {
		this.presentation = new VirtualRealityFrame(this);
	}
	
	public VirtualRealityFrame getPresentation() {
		return presentation;
	}

	public void p2cMove(float dx, float dy, float dz) {
		this.presentation.c2pMoveRelative(dx, dy, dz);
	}

	public void p2cRotate(float rx, float ry, float rz) {
		this.presentation.c2pOrientRelative(rx, ry, rz);
	}
}
