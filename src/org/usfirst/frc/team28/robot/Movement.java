package org.usfirst.frc.team28.robot;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Movement {
	private Rotaion rotaion = new Rotaion(PinConstants.GYRO_PIN);
	private Controller controller;
	private double spin, gyroAngle;
	private Spark bR = new Spark(PinConstants.BR_MOTOR);
	private Spark bL = new Spark(PinConstants.BL_MOTOR);
	private CANTalon fL = new CANTalon(PinConstants.FL_MOTOR);
	private CANTalon fR = new CANTalon(PinConstants.FR_MOTOR);
		
	private Spark test = new Spark(5);
	public Movement(Controller newController){
		controller = newController;
		
	}
	
 	public void update(){
 		double turnRight = rotaion.update(controller.getAxis("turnRight"));
 		
		fR.set(-1 * (controller.getAxis("forward")) + controller.getAxis("right") + turnRight);
		fL.set(controller.getAxis("forward") + controller.getAxis("right") + turnRight);
		bR.set(-1 * (controller.getAxis("forward")) -1 * (controller.getAxis("right")) + turnRight);
		bL.set(controller.getAxis("forward") -1 * (controller.getAxis("right")) + turnRight);
		
		//test.set(0.5);
		//rotaion.reset();
		
		SmartDashboard.putNumber("front right speed", fR.getEncVelocity());
		SmartDashboard.putNumber("front left speed", fL.getEncVelocity());
		
		/*
		if ((-1 * (controller.getAxis("forward")) + controller.getAxis("right") + rotaion.update(controller.getAxis("turnRight"))) == 0){
			//System.out.println("nothing wrong");
		}
		else
			System.out.println("everything is wrong");
		*/
			
	}
	
	
}
