/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SecondLevelCargo extends CommandGroup 
{
  /**
   * Cargo to Second Level
   */
  public SecondLevelCargo() 
  {
    addSequential(new ElbowToNinety()); //sets the elbow to full upright using limit switch
    addSequential(new LiftToHeight(52)); //lift to 4 inches below port hole
    addParallel(new StallLift(), 5); //stalls lift for 5 seconds
    addSequential(new ElbowToAngle(45)); //changes Angle
    addSequential(new Out(), 0.35); //pushes cargo out
    addSequential(new ElbowToNinety()); //sets the elbow to full upright
    addSequential(new DropToHeight(1)); //drops to bottom
  }
}