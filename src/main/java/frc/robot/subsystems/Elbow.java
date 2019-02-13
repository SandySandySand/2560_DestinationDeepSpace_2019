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
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Elbow extends Subsystem 
{
  
  public Spark drop;
  public Encoder dropCount;

  public Elbow()
  {
    drop = new Spark(RobotMap.drop);

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

  //elbow sensing methods

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
