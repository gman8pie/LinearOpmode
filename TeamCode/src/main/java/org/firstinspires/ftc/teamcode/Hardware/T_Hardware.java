package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.UltrasonicSensor;

public abstract class T_Hardware {

    protected String name;
    boolean isEnabled;

    public boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

//    public abstract HardwareDevice getComponent();

    public abstract void init(HardwareMap hwMap);

//    public DcMotor getDcMotor() { return null; }
//    public UltrasonicSensor getUltrasonicSensor() { return null; }
//
//    public void controlWithGP() {}

}
