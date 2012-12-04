package fr.istic.evc.presentation;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.vecmath.Vector3d;
import javax.xml.crypto.dsig.Transform;

import com.sun.j3d.utils.universe.SimpleUniverse;

import fr.istic.evc.controller.CVirtualReality;

public class VirtualRealityFrame extends JFrame {
	
	private static final long serialVersionUID = -7459376830120915468L;
	
	private static final String FRAME_TITLE = "EVC - VirtualReality";

	private CVirtualReality controller;
	
	private SimpleUniverse universe;
	
	// Buttons
	private JButton rotateXPositiveBtn;
	private JButton rotateXNegativeBtn;
	private JButton rotateYPositiveBtn;
	private JButton rotateYNegativeBtn;
	private JButton rotateZPositiveBtn;
	private JButton rotateZNegativeBtn;
	private JButton moveForwardBtn;
	private JButton moveBackwardBtn;
	private JButton moveUpBtn;
	private JButton moveDownBtn;
	private JButton moveLeftBtn;
	private JButton moveRightBtn;

	public VirtualRealityFrame(CVirtualReality ctrl) {
		super(FRAME_TITLE);
		
		this.controller = ctrl;
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1024, 768);
		setLocationRelativeTo(null);
		
		this.initLayout();
		this.initListeners();
	}
	
	/**
	 * Initialize the graphic components
	 */
	private void initLayout() {
		GraphicsConfiguration config = SimpleUniverse
				.getPreferredConfiguration();
		
		Canvas3D canvas3d = new Canvas3D(config);
		
		BranchGroup scene = createSceneGraph();
		
		this.universe = new SimpleUniverse(canvas3d);
		this.universe.getViewingPlatform().setNominalViewingTransform();
		this.universe.addBranchGraph(scene);

		JPanel leftPanel = new JPanel(new GridLayout(6, 1));
		moveForwardBtn = new JButton("Move Forward");
		moveBackwardBtn = new JButton("Move Backward");
		moveUpBtn = new JButton("Move Up");
		moveDownBtn = new JButton("Move Down");
		moveLeftBtn = new JButton("Move Left");
		moveRightBtn = new JButton("Move Right");
		leftPanel.add(moveForwardBtn);
		leftPanel.add(moveBackwardBtn);
		leftPanel.add(moveUpBtn);
		leftPanel.add(moveDownBtn);
		leftPanel.add(moveLeftBtn);
		leftPanel.add(moveRightBtn);

		JPanel bottomPanel = new JPanel(new GridLayout(4, 1));
		rotateXNegativeBtn = new JButton("Rotate Upward");
		rotateXPositiveBtn = new JButton("Rotate Downward");
		rotateYNegativeBtn = new JButton("Rotate Right");
		rotateYPositiveBtn = new JButton("Rotate Left");
		rotateZNegativeBtn = new JButton("Roll Right");
		rotateZPositiveBtn = new JButton("Roll Left");
		bottomPanel.add(rotateXPositiveBtn);
		bottomPanel.add(rotateXNegativeBtn);
		bottomPanel.add(rotateYPositiveBtn);
		bottomPanel.add(rotateYNegativeBtn);
		bottomPanel.add(rotateZPositiveBtn);
		bottomPanel.add(rotateZNegativeBtn);

		this.setLayout(new BorderLayout());
		this.add(leftPanel, BorderLayout.WEST);
		this.add(canvas3d, BorderLayout.CENTER);
		this.add(bottomPanel, BorderLayout.SOUTH);
	}
	
	/**
	 * Initialize the listeners
	 */
	private void initListeners() {
		moveForwardBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.p2cMove(0, 0, -0.1f);
			}
		});
		moveBackwardBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.p2cMove(0, 0, 0.1f);
			}
		});
		moveUpBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.p2cMove(0, 0.1f, 0);
			}
		});
		moveDownBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.p2cMove(0, -0.1f, 0);
			}
		});
		moveLeftBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.p2cMove(-0.1f, 0, 0);
			}
		});
		moveRightBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.p2cMove(0.1f, 0, 0);
			}
		});

		rotateXPositiveBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.p2cRotate(0.1f, 0, 0);
			}
		});
		rotateXNegativeBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.p2cRotate(-0.1f, 0, 0);
			}
		});
		rotateYPositiveBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.p2cRotate(0, 0.1f, 0);
			}
		});
		rotateYNegativeBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.p2cRotate(0, -0.1f, 0);
			}
		});
		rotateZPositiveBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.p2cRotate(0, 0, 0.1f);
			}
		});
		rotateZNegativeBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.p2cRotate(0, 0, -0.1f);
			}
		});
	}
	
	/**
	 * Create the 3D elements
	 * @return the branch group created
	 */
	public BranchGroup createSceneGraph() {
		BranchGroup objRoot = new BranchGroup();
		
		// Cube
		CubeVO cube = new CubeVO(0.2f);
		cube.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		
		objRoot.addChild(cube);
		
		// Rotation
		/*Transform3D yAxis = new Transform3D();
		Alpha rotationAlpha = new Alpha(-1, 2000);
		RotationInterpolator rotator = new RotationInterpolator(rotationAlpha,
				cube, yAxis, 0.0f, (float) Math.PI * 2.0f);
		BoundingSphere bounds = new BoundingSphere();
		rotator.setSchedulingBounds(bounds);
		cube.addChild(rotator);*/
		
		// Compile
		objRoot.compile();
		
		return objRoot;
	}
	
	/**
	 * Move relatively to the current point of view
	 * @param dx
	 * @param dy
	 * @param dz
	 */
	public void c2pMoveRelative(float dx, float dy, float dz) {
		TransformGroup vpTrans = universe.getViewingPlatform().getViewPlatformTransform();
		
		Transform3D oldT3D = new Transform3D();
		vpTrans.getTransform(oldT3D);

		Vector3d translate = new Vector3d();
		translate.set(dx, dy, dz);
		
		Transform3D localT3D = new Transform3D();
		localT3D.setTranslation(translate);
		
		Transform3D newT3D = new Transform3D();
		newT3D.mul(oldT3D, localT3D);
		
		vpTrans.setTransform(newT3D);
	}
	
	/**
	 * Move on an absolute position
	 * @param dx
	 * @param dy
	 * @param dz
	 */
	public void c2pMoveAbsolute(float dx, float dy, float dz) {
		TransformGroup vpTrans = universe.getViewingPlatform().getViewPlatformTransform();
		
		Vector3d translate = new Vector3d();
		translate.set(dx, dy, dz);
		
		Transform3D t3d = new Transform3D();
		vpTrans.getTransform(t3d);
		t3d.setTranslation(translate);
		vpTrans.setTransform(t3d);
	}
	
	/**
	 * Orientate relatively to the current point of view
	 * @param h
	 * @param p
	 * @param r
	 */
	public void c2pOrientRelative(float h, float p, float r) {
		TransformGroup vpTrans = universe.getViewingPlatform().getViewPlatformTransform();
		
		Transform3D oldT3D = new Transform3D();
		vpTrans.getTransform(oldT3D);
		
		Vector3d rotate = new Vector3d();
		rotate.set(h, p, r);
		
		Transform3D localT3D = new Transform3D();
		localT3D.setEuler(rotate);
		
		Transform3D newT3D = new Transform3D();
		newT3D.mul(oldT3D, localT3D);
		
		vpTrans.setTransform(newT3D);
	}
	
	/**
	 * Orientate on an absolute angle
	 * @param h
	 * @param p
	 * @param r
	 */
	public void c2pOrientAbsolute(float h, float p, float r) {
		TransformGroup vpTrans = universe.getViewingPlatform().getViewPlatformTransform();
		
		Vector3d rotate = new Vector3d();
		rotate.set(h, p, r);
		
		Transform3D t3d = new Transform3D();
		vpTrans.getTransform(t3d);
		
		Vector3d translate = new Vector3d();
		t3d.get(translate);
		t3d.setEuler(rotate);
		t3d.setTranslation(translate);
		
		vpTrans.setTransform(t3d);
	}
}
