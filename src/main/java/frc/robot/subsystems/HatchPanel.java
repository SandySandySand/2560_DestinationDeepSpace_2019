/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * 
 */
public class HatchPanel extends Subsystem 
{

  public DoubleSolenoid hpSole;

  public HatchPanel()
  {
    hpSole = new DoubleSolenoid(RobotMap.hpPortOne, RobotMap.hpPortTwo);
  }

  public void set()
  {
    hpSole.set(DoubleSolenoid.Value.kForward);
  }

  public void unset()
  {
    hpSole.set(DoubleSolenoid.Value.kReverse);
  }

  public void off()
  {
    hpSole.set(DoubleSolenoid.Value.kOff);
  }

  @Override
  public void initDefaultCommand() 
  {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
