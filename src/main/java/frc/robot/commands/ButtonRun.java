/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ButtonRun extends Command {

    public ButtonRun() {
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.m_neo.buttonRun();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
