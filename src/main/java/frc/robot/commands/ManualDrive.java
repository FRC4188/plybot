package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

public class ManualDrive extends Command {

    public ManualDrive() {
        requires(Robot.m_drivetrain);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        
        RobotMap.talon1.set(ControlMode.PercentOutput, Robot.m_oi.copilot.getY(Hand.kLeft));
        RobotMap.talon2.set(ControlMode.PercentOutput, Robot.m_oi.copilot.getY(Hand.kLeft));
        RobotMap.talon3.set(ControlMode.PercentOutput, Robot.m_oi.copilot.getY(Hand.kLeft));
        RobotMap.talon4.set(ControlMode.PercentOutput, Robot.m_oi.copilot.getY(Hand.kLeft));

        RobotMap.spark5.set(Robot.m_oi.copilot.getX(Hand.kRight));
        
        RobotMap.drive.arcadeDrive(Robot.m_oi.pilot.getY(Hand.kLeft), 
             -Robot.m_oi.pilot.getX(Hand.kRight));

    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    }

    @Override
    protected void interrupted() {
    }
    
}
