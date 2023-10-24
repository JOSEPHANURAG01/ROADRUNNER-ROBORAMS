package org.firstinspires.ftc.teamcode.drive;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
@Config
@Autonomous(group = "drive")
public class myopmode extends LinearOpMode {


    @Override
    public void runOpMode() {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        waitForStart();

        if (isStopRequested()) return;

        Trajectory traj = drive.trajectoryBuilder(new Pose2d())
                .strafeRight(40)

                .build();



        Trajectory traj2 = drive.trajectoryBuilder(traj.end())
                .forward(40)
                .build();



                Trajectory traj3 =
                drive.trajectoryBuilder(traj2.end(),true)
                        .splineTo(new Vector2d(0, 0), Math.toRadians(180))
                        .build();



        drive.followTrajectory(traj);
        sleep(2000);

        drive.followTrajectory(traj2);
        sleep(2000);




    }
}
