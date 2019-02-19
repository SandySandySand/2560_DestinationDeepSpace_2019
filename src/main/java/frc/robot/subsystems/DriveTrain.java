/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SerialPort.Port;
import frc.robot.RobotMap;
import frc.robot.commands.DriveWithGamepad;

/**
 *  
 */
public class DriveTrain extends Subsystem implements PIDOutput 
{
  WPI_TalonSRX left, right, leftFollow, rightFollow;
  AHRS navx;
  DifferentialDrive myDrive;
  public PIDController rotatePID;

  protected double kPr = 0.3;
	protected double kIr = 0;
	protected double kDr = 0;

  public DriveTrain()
  {
    //master drive motors with encoders
    left = new WPI_TalonSRX(RobotMap.leftMotor);
    left.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    right = new WPI_TalonSRX(RobotMap.rightMotor);
    right.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    
    //follower drive motors
    leftFollow = new WPI_TalonSRX(RobotMap.leftFollowMotor);
    rightFollow = new WPI_TalonSRX(RobotMap.rightFollowMotor);
    
    //setting the controllers to follow the others
    leftFollow.follow(left);
    rightFollow.follow(right);

    myDrive = new DifferentialDrive(left, right);

    //initalizing the navx
    navx = new AHRS(Port.kUSB1); //subject to change

    //PID Controller Init for Gyro
    rotatePID = new PIDController(kPr, kIr, kDr, navx, this);
    rotatePID.setInputRange(-360, 360);
    rotatePID.setOutputRange(-1.0, 1.0);
  }  

  public void pidWrite(double output) 
  {
		// does nothing
	}

  //driving methods
  public void arcaDrive(double speed, double rotate)
  {
    myDrive.arcadeDrive(speed, rotate);
  }

  public void stop()
  {
    myDrive.tankDrive(0, 0);
  }

  //Gyro Methods
  public void reset()
	{
		navx.reset();
	}

	public double getAngle()
	{
		return navx.getAngle();
	}

  @Override
  public void initDefaultCommand() 
  {
    setDefaultCommand(new DriveWithGamepad());
  }
}
