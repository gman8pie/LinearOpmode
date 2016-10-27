package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.HardwareMap;

public abstract class T_Hardware {

    protected String name;
    boolean isEnabled;

    public boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public abstract void init(HardwareMap hwMap);

}
