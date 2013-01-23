package fr.istic.evc;

import fr.istic.evc.controller.CVirtualReality;

public class VirtualRealityApp {
	
	public static void main(String[] args) {
		VirtualRealityApp vrApp = new VirtualRealityApp();
		vrApp.init();
	}

	public void init() {
		CVirtualReality cvr = new CVirtualReality();
		cvr.getPresentation().setVisible(true);
	}
	
}
