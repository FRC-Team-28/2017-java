package org.usfirst.frc.team28.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.interfaces.Gyro;

public class Rotaion{
	AnalogGyro gyro;
	double header;
	PID pid;
	
	public Rotaion(int channel){
		gyro = new AnalogGyro(channel);
		header = gyro.getAngle();
		pid = new PID(1, 0, 0, 0);
	}
	public void reset(){
		header = gyro.getAngle();
	}
	public double update(double turnRight){
		if (turnRight == 0) {
			return pid.update((header - gyro.getAngle()) % 180);
		} else {
			return turnRight;
		}
	}
	public static double DiffAngle(int current, int target){
		return Math.floorMod(target - current + 180, 360)-180;
	}
}
