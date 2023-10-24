package org.firstinspires.ftc.teamcode.drive;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Config
@Autonomous(group = "drive")
public class fieldpravtice extends LinearOpMode {
    public static double ANGLE = 90; // deg

    @Override
    public void runOpMode() throws InterruptedException {
 int size = 24;

        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        waitForStart();


        Trajectory traj = drive.trajectoryBuilder(new Pose2d())
                .forward(size+4)
                .addTemporalMarker(2, () -> drive.pushServo.setPosition(1))
                .build();
   /*
        Trajectory traj2 = drive.trajectoryBuilder(traj.end())
                .back(size)
                .build();

        Trajectory traj3 = drive.trajectoryBuilder(traj2.end())
                .strafeLeft(size*2)
                .build();

Trajectory traj4 = drive.trajectoryBuilder(traj3.end())
                .forward(size)
                        .build();

        Trajectory traj5 = drive.trajectoryBuilder(traj4.end())
                .strafeLeft(size)
                .build();

;


        drive.followTrajectory(traj2);
        traj2.getPath();
        sleep(10);

        drive.followTrajectory(traj3);
        sleep(10);
        drive.followTrajectory(traj4);
        sleep(10);
        drive.followTrajectory(traj5);
        sleep(10);


        drive.turn(Math.toRadians(ANGLE));

        Trajectory forwardTrajectory = drive.trajectoryBuilder(drive.getPoseEstimate())
                .forward(4) // Adjust the distance as needed
                .build();


        drive.followTrajectory(forwardTrajectory);

*/
        drive.followTrajectory(traj);
        sleep(10);
        Pose2d poseEstimate = drive.getPoseEstimate();
        telemetry.addData("X", poseEstimate.getX());
        telemetry.addData("Y", poseEstimate.getY());



    }
}
