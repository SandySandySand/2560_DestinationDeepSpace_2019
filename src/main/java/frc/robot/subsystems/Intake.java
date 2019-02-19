/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
* Code to run the intake wheels
*/
public class Intake extends Subsystem 
{
  Spark leftWheel, rightWheel;
  DigitalInput item;

  public Intake()
  {
    leftWheel = new Spark(RobotMap.leftIntake);
    rightWheel = new Spark(RobotMap.rightIntake);

    item  = new DigitalInput(RobotMap.itemLimit);
  }

  public void grab(double speed)
  {
    leftWheel.set(speed);
    rightWheel.set(speed);
  }

  public void outtake(double speed)
  {
    leftWheel.set(-speed);
    rightWheel.set(-speed);
  }

  public void stopIntake()
  {
    leftWheel.stopMotor();
    rightWheel.stopMotor();
  }

  public boolean getLimit()
  {
    return item.get();
  }

  @Override
  public void initDefaultCommand() 
  {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
