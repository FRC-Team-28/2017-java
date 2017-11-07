package org.usfirst.frc.team28.robot;

import edu.wpi.first.wpilibj.RobotDrive;

public class Movement {
	private Rotaion rotaion = new Rotaion(PinConstants.GYRO_PIN);
	private RobotDrive robotDrive = new RobotDrive(PinConstants.FL_MOTOR, PinConstants.BL_MOTOR, PinConstants.FR_MOTOR, PinConstants.BR_MOTOR);
	private Controller controller;
	private double spin, gyroAngle;
	
	public Movement(Controller newController){
		controller = newController;
	}
	
 	public void update(){
		rotaion.update();
		robotDrive.mecanumDrive_Cartesian(controller.getAxis("sideways"), controller.getAxis("forward"), spin, gyroAngle);
	}
	
	
}
