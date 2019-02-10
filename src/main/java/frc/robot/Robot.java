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
    I2C Wire = new I2C(Port.kOnboard, 8);

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

    //Commands sent as int value
    //Ill make some enums or some shit

    
    String command;
    int i = 0;

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        if(i%60 == 0){  
            if(command == "1") 
                command = "2";
            else command = "1";    
        }
        char[] commandC = command.toCharArray();
        byte[] commandB = new byte[commandC.length];
        byte[] inC = new byte[0];

        for(int i = 0; i < commandC.length; i++){
            commandB[i] = (byte)commandC[i];
        }
        //Wire.write(4, commandB);
        i++;
        Wire.transaction(commandB, commandB.length, inC, 0);
    }

    @Override
    public void testPeriodic() {
    }

}
