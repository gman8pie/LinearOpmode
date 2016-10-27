package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.UltrasonicSensor;

public class T_UltrasonicSensor extends T_Hardware {

    private UltrasonicSensor dcMotor;

    public T_UltrasonicSensor(String name, boolean isEnabled) {
        setEnabled(isEnabled);
        this.name = name;
    }

    public T_UltrasonicSensor(String name) {
        this(name, true);
    }

    public UltrasonicSensor getDcMotor() {
        return dcMotor;
    }

    @Override
    public void init(HardwareMap hwMap) {
        if (isEnabled) {
            dcMotor = hwMap.ultrasonicSensor.get(name);
        }
    }

}
