/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI 
{
   Joystick joy1, joy2;
   JoystickButton oneHatch, twoHatch, threeHatch, oneCargo, twoCargo, threeCargo, stall, up, down, liftElbow, dropElbow, intake, outtake, popOut, popIn;

   public OI()
   {
      joy1 = new Joystick(1);
      joy2 = new Joystick(2);

      // joy2 buttons (Single Commands)
      up = new JoystickButton(joy2, RobotMap.up);
      up.whileHeld(new LiftUp());

      down = new JoystickButton(joy2, RobotMap.down);
      down.whileHeld(new GoDown());

      dropElbow = new JoystickButton(joy2, RobotMap.downElbow);
      dropElbow.whileHeld(new DropElbow());

      liftElbow = new JoystickButton(joy2, RobotMap.liftElbow);
      liftElbow.whileHeld(new LiftElbow());

      intake = new JoystickButton(joy2, RobotMap.intake);
      intake.whileHeld(new Grab());

      outtake = new JoystickButton(joy2, RobotMap.outtake);
      outtake.whileHeld(new Out());

      popIn = new JoystickButton(joy2, RobotMap.popIn);
      popIn.whileHeld(new HatchPanelRetract());

      popOut = new JoystickButton(joy2, RobotMap.popOut);
      popOut.whileHeld(new HatchPanelPopOn());

      // Controller Buttons (auto scoring)
      oneHatch = new JoystickButton(joy1, RobotMap.oneHP);
      oneHatch.whenPressed(new FirstLevelHatchPanel());

      twoHatch = new JoystickButton(joy1, RobotMap.twoHP);
      twoHatch.whenPressed(new SecondLevelHatchPanel());

      threeHatch = new JoystickButton(joy1, RobotMap.thrHP);
      threeHatch.whenPressed(new ThirdLevelHatchPanel());

      oneCargo = new JoystickButton(joy1, RobotMap.oneC);
      oneCargo.whenPressed(new FirstLevelCargo());

      twoCargo = new JoystickButton(joy1, RobotMap.twoC);
      twoCargo.whenPressed(new SecondLevelCargo());

      threeCargo = new JoystickButton(joy1, RobotMap.thrC);
      threeCargo.whenPressed(new ThirdLevelCargo());

      stall = new JoystickButton(joy1, RobotMap.stall);
      stall.whileHeld(new StallLift());
   }

   public Joystick getJoy1()
	 {
       return joy1;
	 }
}
