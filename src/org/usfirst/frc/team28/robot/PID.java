package org.usfirst.frc.team28.robot;

import edu.wpi.first.wpilibj.Preferences;

public class PID {
	double kP;
	double kI;
	double kD;
	double setpoint;
	double integral = 0.0;
	double derivitive = 0.0;
	double prevError = 0.0;
	double error = 0.0;
	Preferences prefs;
	
	public PID(double kP, double kI, double kD, double setpoint) {
		this.kP = kP;
		this.kI = kI;
		this.kD = kD;
		this.setpoint = setpoint;
	}
	public double getSetpoint() {
		return setpoint;
	}
	public void setSetpoint(double setpoint) {
		this.setpoint = setpoint;
	}
	public double update(double processVariable) {
		prefs = prefs.getInstance();
		
		kP = prefs.getDouble("Proportion", 0.5);
		kI = prefs.getDouble("Integral", 0.0);
		kD = prefs.getDouble("Derivative", 0.0);
		
		prevError = error;
		error = setpoint - processVariable;
		integral = integral + error;
		return kP * error + kI * integral + kD * (error - prevError);
	}
}
