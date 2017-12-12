package org.usfirst.frc.team28.robot;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;

public class Movement {
	private Rotaion rotaion = new Rotaion(PinConstants.GYRO_PIN);
    private Spark bR, bL, fR, fL;
	private Controller controller;
	private double spin, gyroAngle;
	
	public Movement(Controller newController){
		controller = newController;
		Spark bR = new Spark(PinConstants.BR_MOTOR);
		Spark bL = new Spark(PinConstants.BL_MOTOR);
		Spark fL = new Spark(PinConstants.FL_MOTOR);
		Spark fR = new Spark(PinConstants.FR_MOTOR);
	}
	
 	public void update(){
		if(controller.getAxis("forward") != 0)
		{
			fR.set(-1.0 * (controller.getAxis("forward")));
			fL.set(1.0 * (controller.getAxis("forward")));
			bR.set(-1.0 * (controller.getAxis("forward")));
			bL.set(1.0 * (controller.getAxis("forward")));
		}
 		
		if(controller.getAxis("right") != 0)
		{
			fR.set(1.0 * (controller.getAxis("right")));
			fL.set(1.0 * (controller.getAxis("right")));
			bR.set(-1.0 * (controller.getAxis("right")));
			bL.set(-1.0 * (controller.getAxis("right")));
		}
		
		if(controller.getAxis("forward") != 0)
		{
			fR.set(1.0 * (controller.getAxis("turnRight")));
			fL.set(1.0 * (controller.getAxis("turnRight")));
			bR.set(1.0 * (controller.getAxis("turnRight")));
			bL.set(1.0 * (controller.getAxis("turnRight")));
		}
		else
		{
			fR.set(0);
			fL.set(0);
			bR.set(0);
			bL.set(0);
		}
		
	}
	
	
}
