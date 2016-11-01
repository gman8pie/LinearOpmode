package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareDevice;
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

//    @Override
    public DcMotor getDcMotor() {
        return dcMotor;
    }

//    @Override
    public void controlWithGP(double gamePad, double mult) {
        getDcMotor().setPower(mult * gamePad);
    }

    public void moveWithPower(float power) {
        dcMotor.setPower(power);
    }

//    @Override
//    public <T extends HardwareDevice> T getComponent(Class<T> tClass) {
//        return (T) getDcMotor();
////        return getDcMotor();
//    }

    @Override
    public void init(HardwareMap hwMap) {
        if (isEnabled) {
            dcMotor = hwMap.dcMotor.get(name);

            dcMotor.setPower(0);
            dcMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
    }

}
