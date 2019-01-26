/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class RobotMap {

	public static DoubleSolenoid gearShift;
	public static WPI_TalonSRX talon1, talon2, talon3, talon4;
	public static CANSparkMax spark1, spark2, spark3, spark4, spark5;
	public static SpeedControllerGroup leftSet, rightSet;
	public static DifferentialDrive drive;

	public static void init() {	

		gearShift = new DoubleSolenoid(0,1);

		talon1 = new WPI_TalonSRX(12);
		talon2 = new WPI_TalonSRX(17);
		talon3 = new WPI_TalonSRX(3);
		talon4 = new WPI_TalonSRX(4);

		spark1 = new CANSparkMax(20, MotorType.kBrushless);
		spark2 = new CANSparkMax(21, MotorType.kBrushless);
		spark3 = new CANSparkMax(22, MotorType.kBrushless);
		spark4 = new CANSparkMax(23, MotorType.kBrushless);
		spark5 = new CANSparkMax(24, MotorType.kBrushless);

		leftSet = new SpeedControllerGroup(spark1, spark2);
		rightSet = new SpeedControllerGroup(spark3, spark4);

		drive = new DifferentialDrive(leftSet, rightSet);

	}
	
}
