/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap 
{
  //can id
  public static int leftMotor = 1;
  public static int leftFollowMotor = 3;
  public static int rightMotor = 2;
  public static int rightFollowMotor = 4;
  public static int elevatorMotor = 5;

  //multiplier values
  public static double arcaSpeedMulti = 0.85;
  public static double arcaRotateMulti = 0.95;

  //Buttons Controller 1
  public static int oneHP = 1;
  public static int twoHP = 2;
  public static int oneC = 4;
  public static int twoC = 3;
  public static int thrHP = 5;
  public static int thrC = 6;
  //public static int endgameOne = 7;
  //public static int endgameTwo = 8;
  public static int stall = 9;

  //buttons Controller 2
  public static int downElbow = 1;
  public static int liftElbow = 3;
  public static int down = 2;
  public static int up = 4;
  public static int popIn = 5;
  public static int popOut = 6;
  public static int intake = 7;
  public static int outtake = 8;

  //PWM Values
  public static int drop = 0;
  public static int leftIntake = 1;
  public static int rightIntake = 2;

  //DIO Values
  public static int channelA = 0;
  public static int channelB = 1;
  public static int itemLimit = 2;
  public static int ninetyLimit = 3;
  public static int zeroLimit = 4;

  //Solenoid Ports
  public static int hpPortOne = 4;
  public static int hpPortTwo = 5;
}
