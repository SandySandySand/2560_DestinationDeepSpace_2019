/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ElbowToAngle extends Command 
{

  private double requiredAngle, ticksTo;
  private boolean fin;

  public ElbowToAngle(double requiredAngle) 
  {
    requires(Robot.elbow);
    this.requiredAngle = requiredAngle;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() 
  {
    Robot.elbow.resetEnc();
    ticksTo = requiredAngle * Robot.elbow.TICKS_PER_DEGREE;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() 
  {
    Robot.elbow.liftElbow(0.45);

    if(Robot.elbow.getPosition() >= ticksTo)
      fin = true;
    else
      fin = false;
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() 
  {
    return fin;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() 
  {
    Robot.elbow.stopElbow();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() 
  {
    end();
  }
}
