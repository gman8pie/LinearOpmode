package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Hardware.T_Hardware;
import org.firstinspires.ftc.teamcode.Hardware.T_DCMotor;
import org.firstinspires.ftc.teamcode.Hardware.T_UltrasonicSensor;

import java.util.ArrayList;
import java.util.HashMap;

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
    public HashMap<String, ArrayList<T_Hardware>> hardwareDevicesMap;

    // Map of hardware components (configured on robot controller device)
    HardwareMap hwMap;
    // Elapsed time of program execution
    private ElapsedTime period = new ElapsedTime();

    /* Constructor */
    HardwareTest() {

    }

    private void initHWDevices(HashMap<String, ArrayList<T_Hardware>> _hardwareDevicesMap,
                               HardwareMap _hwMap) {
        for (HashMap.Entry pair : _hardwareDevicesMap.entrySet()) {
            @SuppressWarnings("unchecked")
            ArrayList<T_Hardware> hardwareDevices = (ArrayList<T_Hardware>) pair.getValue();

            for (int IHardwareDevice = 0; IHardwareDevice < hardwareDevices.size(); IHardwareDevice++) {
                hardwareDevices.get(IHardwareDevice).init(_hwMap);
            }
        }
    }

    /* Initialize standard T_Hardware interfaces. To be called ONCE when driver hits INIT */
    public void init(HardwareMap ahwMap) {
        // Save reference to T_Hardware map (for performance)
        hwMap = ahwMap;
        hardwareDevicesMap = new HashMap<>();
        new HashMap<>();
        hardwareDevicesMap.put("DC Motors", new ArrayList<T_Hardware>() {{
            add(new T_DCMotor("left_drive"));
            add(new T_DCMotor("right_drive"));
        }});

        initHWDevices(hardwareDevicesMap, hwMap);

//        // Define and Initialize Motors
//        // NOTE: names such as left_drive, left_arm, etc. are configured on CS device
//        leftMotor = hwMap.dcMotor.get("left_drive");
//        rightMotor = hwMap.dcMotor.get("right_drive");
////        opticalDistanceSensor = hwMap.opticalDistanceSensor.get("od_sensor");
//        IRSSensor = hwMap.irSeekerSensor.get("IRS_Sensor");
//
////        leftMotor.setDirection(DcMotor.Direction.FORWARD); 	// Set to REVERSE if using AndyMark motors
////        rightMotor.setDirection(DcMotor.Direction.REVERSE);	// Set to FORWARD if using AndyMark motors
//        opticalDistanceSensor.enableLed(false);            // Disable LED on program init
////        IRSSensor.
//        // Set all motors to zero power
//        leftMotor.setPower(0);
//        rightMotor.setPower(0);
//
//        // Set all motors to run without encoders.
//        // May want to use RUN_USING_ENCODERS if encoders are installed.
//        leftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        rightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//
//        uSS = hwMap.ultrasonicSensor.get("Ultrasonic_Sensor");
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

