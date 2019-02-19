/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Turn extends Command
{
  //angle variable 
  private double requiredAngle;

  public Turn(double requiredAngle) 
  {
    requires(Robot.drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() 
  {
    Robot.drivetrain.rotatePID.setSetpoint(requiredAngle);
    Robot.drivetrain.rotatePID.enable();
    Robot.drivetrain.rotatePID.setAbsoluteTolerance(0.005);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() 
  {
    double currentAngle = Robot.drivetrain.getAngle();
    Robot.drivetrain.arcaDrive(0, Robot.drivetrain.rotatePID.get());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() 
  {
    return Robot.drivetrain.rotatePID.onTarget();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() 
  {
    Robot.drivetrain.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() 
  {
    end();
  }
}