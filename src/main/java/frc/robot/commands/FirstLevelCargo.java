/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class FirstLevelCargo extends CommandGroup 
{
  /**
   * Cargo to First Level
   */
  public FirstLevelCargo() 
  {
    addSequential(new ElbowToNinety()); //sets the elbow to full upright using limit switch
    Timer.delay(1); //pause for effect
    addSequential(new LiftToHeight(24)); //lift to 4 inches below port hole
    addSequential(new StallLift(), 5); //stalls lift for 5 seconds
    addParallel(new ElbowToAngle(45)); //changes Angle
    Timer.delay(1); //pause for effect
    addSequential(new Out(), 2); //pushes cargo out
  }
}
