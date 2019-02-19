/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.Timer;

public class ThirdLevelHatchPanel extends CommandGroup 
{
  /**
   * Third Level Hatch Panel
   */
  public ThirdLevelHatchPanel() 
  {
    addSequential(new LiftToHeight(75)); // lifts to third level
     Timer.delay(5); //pause for effect (mostly testing)
    // addSequential(new StallLift(), 2);
    addParallel(new HatchPanelPopOn(), 3); //place hatch on
    Timer.delay(5); //pause for effect (mostly testing)
    addSequential(new DropToHeight(1)); //drop to lowest
  }
}
