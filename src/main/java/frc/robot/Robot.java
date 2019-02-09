package frc.robot;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;

public class Robot extends TimedRobot {

    public static OI m_oi;
    public static Drivetrain m_drivetrain;
	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();
    private static I2C Wire;

	@Override
	public void robotInit() {
        m_oi = new OI();
		RobotMap.init();
        m_drivetrain = new Drivetrain();
        Wire = new I2C(Port.kOnboard, 4);
	}

    @Override
    public void robotPeriodic() {
    }

    @Override
    public void disabledInit() {
    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
        m_autonomousCommand = m_chooser.getSelected();
        if (m_autonomousCommand != null) {
            m_autonomousCommand.start();
        }
    }

    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        if (m_autonomousCommand != null) {
            m_autonomousCommand.cancel();
        }

        byte[] command = new byte[1];
        Wire.transaction(command, command.length, null, 0);
    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void testPeriodic() {
    }

}
