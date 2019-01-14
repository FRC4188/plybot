/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


import frc.robot.commands.ButtonKill;
import frc.robot.commands.ButtonRun;
import frc.robot.commands.GearShiftIn;
import frc.robot.commands.GearShiftOut;
import frc.robot.commands.GearShiftOff;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  public XboxController pilot;
  
	public JoystickButton pilot9;
	public JoystickButton pilot10;


  public Joystick rocketBox;

	public JoystickButton rocketBox1, rocketBox2;
	
	public OI() {
		pilot = new XboxController(0);
		pilot9 = new JoystickButton(pilot, 9);
		pilot10 = new JoystickButton(pilot, 10);
		
		rocketBox = new Joystick(1);
		rocketBox1 = new JoystickButton(rocketBox, 1);

    pilot9.whenPressed(new GearShiftIn());
    pilot9.whenReleased(new GearShiftOff());
    pilot10.whenPressed(new GearShiftOut());
	pilot10.whenReleased(new GearShiftOff());
	
	rocketBox1.whenPressed(new ButtonRun());
	rocketBox2.whenPressed(new ButtonKill());
	
	}

}
