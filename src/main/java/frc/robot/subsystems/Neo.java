/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.commands.NeoDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;



public class Neo extends Subsystem {
        
	public void initDefaultCommand() {
        setDefaultCommand(new NeoDrive());
    }

    public void buttonRun(){
        RobotMap.spark1.set(.2);
    }

    public void buttonKill(){
        RobotMap.spark1.set(0);
    }
}
