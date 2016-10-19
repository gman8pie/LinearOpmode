package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This is NOT an opmode.
 * <p>
 * This class can be used to define all the specific hardware for a single robot. These include all the motors, sensors, etc. that are connected
 * to the robot in use.
 * <p>
 * This hardware class assumes the following configured hardware componenets are connected and configured on the robot controller station device.
 */
public class HardwareTest {
    // Declare components fields
    // They are outside any method so they can be accessed by the entire class)
    // And they are unitialized because the initializing happens in the init method, which eventually gets called in the OpMode init method
    public DcMotor leftMotor;
    public DcMotor rightMotor;
    public OpticalDistanceSensor opticalDistanceSensor;

    // Map of hardware components (configured on robot controller device)
    HardwareMap hwMap = null;
    // Elapsed time of program execution
    private ElapsedTime period = new ElapsedTime();

    /* Constructor */
    public HardwareTest() {

    }

    /* Initialize standard Hardware interfaces. To be called ONCE when driver hits INIT */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map (for performance)
        hwMap = ahwMap;

        // Define and Initialize Motors
        // NOTE: names such as left_drive, left_arm, etc. are configured on CS device
        leftMotor = hwMap.dcMotor.get("left_drive");
        rightMotor = hwMap.dcMotor.get("right_drive");
        opticalDistanceSensor = hwMap.opticalDistanceSensor.get("od_sensor");

        leftMotor.setDirection(DcMotor.Direction.FORWARD); 	// Set to REVERSE if using AndyMark motors
        rightMotor.setDirection(DcMotor.Direction.REVERSE);	// Set to FORWARD if using AndyMark motors
        opticalDistanceSensor.enableLed(false);			// Disable LED on init

        // Set all motors to zero power
        leftMotor.setPower(0);
        rightMotor.setPower(0);

        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        leftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    /***
     * waitForTick implements a periodic delay. However, this acts like a metronome with a regular
     * periodic tick.  This is used to compensate for varying processing times for each cycle.
     * The function looks at the elapsed cycle time, and sleeps for the remaining time interval.
     *
     * @param periodMs Length of wait cycle in mSec.
     * @throws InterruptedException
     */
    public void waitForTick(long periodMs) throws InterruptedException {

        long remaining = periodMs - (long) period.milliseconds();

        // sleep for the remaining portion of the regular cycle period.
        if (remaining > 0)
            Thread.sleep(remaining);

        // Reset the cycle clock for the next pass.
        period.reset();
    }
}

