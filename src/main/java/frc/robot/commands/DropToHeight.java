/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DropToHeight extends Command 
{
  public double requiredHeight;
  public boolean fin;

  public DropToHeight(double requiredHeight) 
  {
    requires(Robot.elevator);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() 
  {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() 
  {
    //ticksTo = level height (in) * ticks per inch
    double ticksTo = requiredHeight * Robot.elevator.TICKS_PER_INCH;
    //runs elevator
    Robot.elevator.goDown(0.35);

    if(Robot.elevator.getEncoderPos() <= ticksTo)
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
    Robot.elevator.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() 
  {
    end();
  }
}
