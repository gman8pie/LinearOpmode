package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@Autonomous(name = "Autonomy: Main", group = "Autonomy")
@Disabled
// TODO: Enable
public class AutonomyOpMain extends OpMode {
    // Define Pushbot hardware; should be changed to custom hardware configuration class in future
    private HardwareTest robotHardware = new HardwareTest();

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
         speed changes, all the sensor data reading, all of it happens heres
         */

        /*
        If ultraSonicSensorDetectionDistance < 21 inches Then
            robot go backwards x inches
            turn 180deg in right direction
        End If
        */
    }
}
