package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Hardware.T_DCMotor;

@Autonomous(name = "Autonomy: Main", group = "Autonomy")
//@Disabled
// TODO: Enable
public class AutonomyOpMain extends OpMode {
    // Define Pushbot hardware; should be changed to custom hardware configuration class in future
    private HardwareTest robotHardware = new HardwareTest();
	private boolean isAutonomy = true;
	
    /*
     Runs ONCE as autonomy is initialized
     */
    @Override
    public void init() {
        // Initialize Pushbt hardware
        robotHardware.init(hardwareMap);

        // Convey message to driver (even though they're not really driving here) indicating autonomy has started
        telemetry.addData("Autonomy", "Running");
        telemetry.update();
    }

    @Override
    public void loop() {
        /**
         Repeatedly running, this is where the meat of the autonomous operations goes. All the motor
         speed changes, all the sensor data reading, all of it happens here:
        */

        final int MOTOR_MULTS[] = {-1, -1};

        if (isAutonomy) {
//            for (int IMotor = 0; IMotor < robotHardware.hardwareDevicesMap.get("DC Motors").size(); IMotor++) {
//                T_DCMotor motor = (T_DCMotor) robotHardware.hardwareDevicesMap.get("DC Motors").get(IMotor);
//                motor.move(MOTOR_MULTS[IMotor], 3000);
//            }

            T_DCMotor motor1 = (T_DCMotor) robotHardware.hardwareDevicesMap.get("DC Motors").get(0);
            T_DCMotor motor2 = (T_DCMotor) robotHardware.hardwareDevicesMap.get("DC Motors").get(1);
            motor1.getDcMotor().setPower(1);
            motor2.getDcMotor().setPower(-1);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            motor1.getDcMotor().setPower(0);
            motor2.getDcMotor().setPower(0);

            isAutonomy = false;
        }

//        left = -gamepad1.left_stick_y;
//        right = -gamepad1.right_stick_y;
//        robot.leftMotor.setPower(-gamepad1.left_stick_y);
//        robot.rightMotor.setPower(right);

        /*
        If ultraSonicSensorDetectionDistance < 21 inches Then
            robot go backwards x inches
            turn 180deg in right direction
        End If
        */

		/*
		if (robotHardware.uSS.getUltrasonicLevel() < 21) {
			
			robotHardware.leftMotor.setDirection(DcMotor.Direction.REVERSE);
			robotHardware.rightMotor.setDirection(DcMotor.Direction.REVERSE);
			
			for (int i = 0; i <= 2; i++) {
				robotHardware.leftMotor.setPower(1);
				robotHardware.rightMotor.setPower(1);
			}
			
			robotHardware.leftMotor.setDirection(DcMotor.Direction.FORWARD);
			for (int i = 0; i <= 2; i++) {
				robotHardware.leftMotor.setPower(0.75);
				robotHardware.rightMotor.setPower(0.75);
			}
		}*/

        telemetry.addData("isAutonomy", isAutonomy);
        telemetry.update();
		
    }

    @Override
    public void stop() {
        super.stop();
    }
}
