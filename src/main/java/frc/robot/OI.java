/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import frc.robot.commands.LiftUp;
import frc.robot.commands.DropElbowGroup;
import frc.robot.commands.GoDown;
import frc.robot.commands.LiftElbowGroup;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI 
{
   Joystick joy1;
   JoystickButton up, down, dropElbow, liftElbow;

   public OI()
   {
      joy1 = new Joystick(1);

      up = new JoystickButton(joy1, RobotMap.up);
      up.whileHeld(new LiftUp());

      down = new JoystickButton(joy1, RobotMap.down);
      down.whileHeld(new GoDown());

      dropElbow = new JoystickButton(joy1, RobotMap.dropElbow);
      dropElbow.whenPressed(new DropElbowGroup());

      liftElbow = new JoystickButton(joy1, RobotMap.liftElbow);
      liftElbow.whenPressed(new LiftElbowGroup());
   }

   public Joystick getJoy1()
	 {
       return joy1;
	 }
}
