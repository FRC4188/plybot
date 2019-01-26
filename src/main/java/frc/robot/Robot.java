package frc.robot;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

public class Robot extends TimedRobot {

    public static OI m_oi;
    public static Drivetrain m_drivetrain;
	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	@Override
	public void robotInit() {
		m_oi = new OI();
		RobotMap.init();
        m_drivetrain = new Drivetrain();
		
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
    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void testPeriodic() {
    }

}
