package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class T_DCMotor extends T_Hardware {

    private DcMotor dcMotor;

    public T_DCMotor(String name, boolean isEnabled) {
        setEnabled(isEnabled);
        this.name = name;
    }

    public T_DCMotor(String name) {
        this(name, true);
    }

    public DcMotor getDcMotor() {
        return dcMotor;
    }

    @Override
    public void init(HardwareMap hwMap) {
        if (isEnabled) {
            dcMotor = hwMap.dcMotor.get(name);

            dcMotor.setPower(0);
            dcMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
    }

}
