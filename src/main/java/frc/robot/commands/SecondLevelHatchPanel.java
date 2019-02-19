/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.Timer;

public class SecondLevelHatchPanel extends CommandGroup 
{
  /**
   * Places a Hatch Panel on the Second Level
   */
  public SecondLevelHatchPanel() 
  {
    addSequential(new LiftToHeight(47)); //lifts to second level
     Timer.delay(5); //pause for effect
    // addSequential(new StallLift(), 2);
    addParallel(new HatchPanelPopOn(), 2);
    addSequential(new HatchPanelRetract(), 1); //line and line above pop the panel off
    Timer.delay(5); //pause for effect
    addSequential(new DropToHeight(1)); //drops lift
  }
}
