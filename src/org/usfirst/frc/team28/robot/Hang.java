package org.usfirst.frc.team28.robot;

import edu.wpi.first.wpilibj.PWMSpeedController;

public class Hang {
	PWMSpeedController motor;
	
	public Hang(PWMSpeedController motor){
		this.motor = motor;
	}
	
	public void update(double speed){
		if (speed < 0){
			speed = 0;
		}
		motor.set(speed);
	}
}
