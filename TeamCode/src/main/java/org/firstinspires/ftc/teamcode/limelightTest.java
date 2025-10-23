package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class limelightTest extends OpMode {

    private Limelight3A limelight3A;

    @Override
    public void init() {
        limelight3A = hardwareMap.get(Limelight3A.class, "limelight");
        limelight3A.start();
    }

    @Override
    public void loop() {
        limelight3A.pipelineSwitch(0);  // בדיקה ירוק
        LLResult greenResult = limelight3A.getLatestResult();

        if (greenResult != null && greenResult.isValid()) {
            telemetry.addData("Color", "Green");
            telemetry.addData("X offset", greenResult.getTx());
            telemetry.addData("Y offset", greenResult.getTy());
            telemetry.addData("Area", greenResult.getTa());
        } else {
            telemetry.addLine("Green: Not detected");
        }

        limelight3A.pipelineSwitch(1);
        LLResult purpleResult = limelight3A.getLatestResult(); // בדיקה סגול

        if (purpleResult != null && purpleResult.isValid()) {
            telemetry.addData("Color", "Purple");
            telemetry.addData("X offset", purpleResult.getTx());
            telemetry.addData("Y offset", purpleResult.getTy());
            telemetry.addData("Area", purpleResult.getTa());
        } else {
            telemetry.addLine("Purple: Not detected");
        }

        telemetry.update();
    }
}
