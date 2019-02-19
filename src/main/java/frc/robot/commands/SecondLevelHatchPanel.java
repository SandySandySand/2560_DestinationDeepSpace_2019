/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class SecondLevelHatchPanel extends CommandGroup 
{
  /**
   * Places a Hatch Panel on the Second Level
   */
  public SecondLevelHatchPanel() 
  {
    addSequential(new ElbowToNinety());
    addSequential(new LiftToHeight(47)); //lifts to second level
    addSequential(new StallLift(), 2);
    Timer.delay(2);
    addSequential(new DropToHeight(1)); //drops lift
  }
}