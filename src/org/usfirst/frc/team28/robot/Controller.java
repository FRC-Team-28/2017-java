package org.usfirst.frc.team28.robot;

import java.util.*;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;

public class Controller {
	
	private Map<String,Double> axisMap = new HashMap <>();
	private Map<String, Boolean> buttonMap = new HashMap<>();
	private XboxController Controller1 = new XboxController(0);
	private XboxController Controller2 = new XboxController(1);
	
	public Controller()
	{
		update();
	}
	
	public void update()
	{
		axisMap.put("forward", Controller1.getY(GenericHID.Hand.kLeft)); 
		axisMap.put("right", Controller1.getX(GenericHID.Hand.kLeft));
		
	}
	
	public double getAxis(String name)
	{
	  return axisMap.get(name);
	}
}
 