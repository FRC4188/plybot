package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.ManualDrive;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {
    
    DoubleSolenoid gearShift = RobotMap.gearShift;
        
	public void initDefaultCommand() {
        setDefaultCommand(new ManualDrive());
    }

    public void shiftGearIn() {
    	gearShift.set(Value.kForward);
    }
    
    public void shiftGearOut() {
    	gearShift.set(Value.kReverse);
    }

    public void gearShiftOff() {
      gearShift.set(Value.kOff);
    }

}
