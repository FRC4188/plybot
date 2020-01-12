package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.GenericHID.Hand;

/**
 * The VM is configured to automatically run this class, and to call the functions
 * corresponding to each mode, as described in the TimedRobot documentation.
 */
public class Robot extends TimedRobot {

    // talon initialization
    private WPI_TalonSRX talon1 = new WPI_TalonSRX(1);
    private WPI_TalonSRX talon2 = new WPI_TalonSRX(2);
    private WPI_TalonSRX talon3 = new WPI_TalonSRX(3);
    private WPI_TalonSRX talon4 = new WPI_TalonSRX(4);

    // spark intialization
    private CANSparkMax spark1 = new CANSparkMax(11, MotorType.kBrushless);
    private CANSparkMax spark2 = new CANSparkMax(12, MotorType.kBrushless);
    private CANSparkMax spark3 = new CANSparkMax(14, MotorType.kBrushless);
    private CANSparkMax spark4 = new CANSparkMax(11, MotorType.kBrushless);

    // solenoid initialization
    private DoubleSolenoid solenoid = new DoubleSolenoid(0, 1);

    // controller initialization
    private XboxController controller = new XboxController(0);

    @Override
    public void robotInit() {

        // talon configuration
        talon1.setInverted(false);
        talon2.setInverted(false);
        talon3.setInverted(false);
        talon4.setInverted(false);

        // spark configuration
        spark1.setInverted(false);
        spark2.setInverted(false);
        spark3.setInverted(false);
        spark4.setInverted(false);
    
    }

    @Override
    public void robotPeriodic() {
    }

    @Override
    public void autonomousInit() {
    }

    @Override
    public void autonomousPeriodic() {
    }

    @Override
    public void teleopPeriodic() {

        // set talons to left stick Y
        double leftY = controller.getY(Hand.kLeft) * -1;
        talon1.set(leftY);
        talon2.set(leftY);
        talon3.set(leftY);
        talon4.set(leftY);

        // set sparks to right stick Y
        double rightY = controller.getY(Hand.kRight) * -1;
        spark1.set(rightY);
        spark2.set(rightY);
        spark3.set(rightY);
        spark4.set(rightY);

        // open solenoid on A, close on B
        if (controller.getAButtonPressed()) solenoid.set(Value.kForward);
        else if (controller.getBButtonPressed()) solenoid.set(Value.kReverse);
        else solenoid.set(Value.kOff);

    }

    @Override
    public void testPeriodic() {
    }

}
