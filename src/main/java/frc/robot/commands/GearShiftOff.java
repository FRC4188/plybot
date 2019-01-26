package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class GearShiftOff extends Command {

  public GearShiftOff() {
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.m_drivetrain.gearShiftOff();
  }

  @Override
  protected boolean isFinished() {
    return true;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
  }
  
}
