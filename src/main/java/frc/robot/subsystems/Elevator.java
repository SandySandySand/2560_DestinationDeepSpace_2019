/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Elevator extends Subsystem 
{
  CANSparkMax lift;

  public Elevator()
  {
    lift = new CANSparkMax(RobotMap.elevatorMotor, MotorType.kBrushless);
  }

  public void liftUp(double power)
  {
    lift.set(power);
  }

  public void goDown(double power)
  {
    lift.set(-power);
  }

  public void stop()
  {
    lift.stopMotor();
  }

  @Override
  public void initDefaultCommand() 
  {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
