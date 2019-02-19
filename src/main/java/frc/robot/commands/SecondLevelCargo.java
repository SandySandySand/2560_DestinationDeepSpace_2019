/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class SecondLevelCargo extends CommandGroup 
{
  /**
   * Cargo to Second Level
   */
  public SecondLevelCargo() 
  {
    addSequential(new ElbowToNinety()); //sets the elbow to full upright using limit switch
    Timer.delay(1); //pause for effect
    addSequential(new LiftToHeight(52)); //lift to 4 inches below port hole
    addSequential(new StallLift(), 5); //stalls lift for 5 seconds
    addParallel(new ElbowToAngle(45)); //changes Angle
    Timer.delay(1); //pause for effect
    addSequential(new Out(), 2); //pushes cargo out
  }
}