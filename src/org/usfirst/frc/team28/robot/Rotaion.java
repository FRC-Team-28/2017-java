package org.usfirst.frc.team28.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Rotaion{
	AnalogGyro gyro;
	double header;
	PID pid;
	Preferences prefs;
	
	public Rotaion(int channel){
		gyro = new AnalogGyro(channel);
		header = gyro.getAngle();
		prefs = prefs.getInstance();
		
		pid = new PID(prefs.getDouble("Proportion", 0.5), prefs.getDouble("Integral", 0.0), prefs.getDouble("Derivative", 0.0), header);
	}
	
	public void reset(){
		header = gyro.getAngle();
	}
	
	public double update(double turnRight){
		SmartDashboard.putNumber("gyroAngle", gyro.getAngle());
		
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
