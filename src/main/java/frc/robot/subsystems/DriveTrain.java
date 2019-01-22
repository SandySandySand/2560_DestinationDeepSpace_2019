/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveWithGamepad;

/**
 *  
 */
public class DriveTrain extends Subsystem 
{
  WPI_TalonSRX left, right, leftFollow, rightFollow;
  DifferentialDrive myDrive;

  public DriveTrain()
  {
    left = new WPI_TalonSRX(RobotMap.leftMotor);
    right = new WPI_TalonSRX(RobotMap.rightMotor);
    leftFollow = new WPI_TalonSRX(RobotMap.leftFollowMotor);
    rightFollow = new WPI_TalonSRX(RobotMap.rightFollowMotor);

    leftFollow.follow(left);
    rightFollow.follow(right);

    myDrive = new DifferentialDrive(left, right);
  }  

  public void arcaDrive(double speed, double rotate)
  {
    myDrive.arcadeDrive(speed, rotate);
  }

  @Override
  public void initDefaultCommand() 
  {
    setDefaultCommand(new DriveWithGamepad());
  }
}
