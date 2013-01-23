package fr.istic.evc.controller;

import fr.istic.evc.abstraction.VirtualReality;
import fr.istic.evc.presentation.PVirtualReality;

public class CVirtualReality extends VirtualReality {
	
	private PVirtualReality presentation;

	public CVirtualReality() {
		this.presentation = new PVirtualReality(this);
	}
	
	public PVirtualReality getPresentation() {
		return presentation;
	}

	public void p2cMove(float dx, float dy, float dz) {
		this.presentation.c2pMoveRelative(dx, dy, dz);
	}
	
	public void p2cMoveAbsolute(float dx, float dy, float dz) {
		this.presentation.c2pMoveAbsolute(dx, dy, dz);
	}
	
	public void p2cRotate(float rx, float ry, float rz) {
		this.presentation.c2pOrientRelative(rx, ry, rz);
	}
	
	public void p2cRotateAbsolute(float dx, float dy, float dz) {
		this.presentation.c2pOrientAbsolute(dx, dy, dz);
	}
}
