package frc.robot;

import frc.robot.commands.GearShiftIn;
import frc.robot.commands.GearShiftOut;
import frc.robot.commands.GearShiftOff;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {

	public XboxController pilot;
	public XboxController copilot;
	
	public JoystickButton pilot9;
	public JoystickButton pilot10;
	
	public OI() {
		
		pilot = new XboxController(0);
		copilot = new XboxController(1);
		pilot9 = new JoystickButton(pilot, 9);
		pilot10 = new JoystickButton(pilot, 10);
		
		pilot9.whenPressed(new GearShiftIn());
		pilot9.whenReleased(new GearShiftOff());
		pilot10.whenPressed(new GearShiftOut());
		pilot10.whenReleased(new GearShiftOff());

	}

}
