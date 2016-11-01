package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.UltrasonicSensor;

public class T_UltrasonicSensor extends T_Hardware {

    private UltrasonicSensor ultrasonicSensor;

    public T_UltrasonicSensor(String name, boolean isEnabled) {
        setEnabled(isEnabled);
        this.name = name;
    }

    public T_UltrasonicSensor(String name) {
        this(name, true);
    }

//    @Override
    public UltrasonicSensor getUltrasonicSensor() {
        return ultrasonicSensor;
    }

//    @Override
//    public HardwareDevice getComponent() {
//        return getUltrasonicSensor();
//    }

    @Override
    public void init(HardwareMap hwMap) {
        if (isEnabled) {
            ultrasonicSensor = hwMap.ultrasonicSensor.get(name);
        }
    }

}
