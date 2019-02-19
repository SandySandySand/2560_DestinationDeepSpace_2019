/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.RobotMap;

/**
 * Subsystem to 
 */
public class Elbow extends Subsystem 
{ 
  public Spark drop;
  public Encoder dropCount;
  public DigitalInput ninetyLim, zeroLim;

  public final double NO_BELOW = 110.0; //temp value
  public final double TICKS_PER_DEGREE = 1.29; //temp value

  public Elbow()
  {
    drop = new Spark(RobotMap.drop);
    dropCount = new Encoder(RobotMap.channelA, RobotMap.channelB, false, EncodingType.k4X);
    ninetyLim = new DigitalInput(RobotMap.ninetyLimit);
    zeroLim = new DigitalInput(RobotMap.zeroLimit);
  }

  //elbow power methods
  public void dropElbow(double power)
  {
    drop.set(-power);
  }

  public void liftElbow(double power)
  {
    drop.set(power);
  }

  public void stopElbow()
  {
    drop.stopMotor();
  }

  //elbow sensing methods
  public int getPosition()
  {
    return dropCount.get();
  }

  public void resetEnc()
  {
    dropCount.reset();
  }

  //elbow limit sensing methods
  public boolean getNinety()
  {
    return ninetyLim.get();
  }

  public boolean getZero()
  {
    return zeroLim.get();
  }

  @Override
  public void initDefaultCommand() 
  {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
