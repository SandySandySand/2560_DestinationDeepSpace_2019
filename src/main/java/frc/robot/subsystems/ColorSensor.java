/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem for Color Sensor
 * Credit to team7034 on ChiefDelphi for the code on reading the sensor
 */
public class ColorSensor extends Subsystem 
{
  protected final static int CMD = 0x80;
  protected final static int MULTI_BYTE_BIT = 0x20;
  protected final static int ENABLE_REGISTER  = 0x00;
  protected final static int ATIME_REGISTER   = 0x01;
  protected final static int PPULSE_REGISTER  = 0x0E;

  protected final static int ID_REGISTER     = 0x12;
  protected final static int CDATA_REGISTER  = 0x14;
  protected final static int RDATA_REGISTER  = 0x16;
  protected final static int GDATA_REGISTER  = 0x18;
  protected final static int BDATA_REGISTER  = 0x1A;
  protected final static int PDATA_REGISTER  = 0x1C;

  protected final static int PON   = 0b00000001;
  protected final static int AEN   = 0b00000010;
  protected final static int PEN   = 0b00000100;
  protected final static int WEN   = 0b00001000;
  protected final static int AIEN  = 0b00010000;
  protected final static int PIEN  = 0b00100000;

  protected final double integrationTime = 10;

  //sets byteBuffer
  private ByteBuffer buffer = ByteBuffer.allocate(8);

  private I2C colorSensor;

  public ColorSensor(I2C.Port port)
  {
    //create and address i2c sensor
    colorSensor = new I2C(port, 0x12);
    
    //sets the sensor to turn on, enable RGB Sensing and Proximity Sensing
    colorSensor.write(CMD | 0x00, PON | AEN | PEN); 

    //configures the integration time
    colorSensor.write(CMD | 0x01, (int) (256-integrationTime/2.38));
  }

  //reads the values of the sensor
  public void read()
  {
    buffer.clear();

    colorSensor.read(CMD | MULTI_BYTE_BIT | RDATA_REGISTER, 8, buffer);


  }

  //returns status
  public int status()
  {
    buffer.clear();
    colorSensor.read(CMD | 0x13, 1, buffer);
    return buffer.get(0);
  }

  //frees the sensor
  public void free()
  {
    colorSensor.free();
  }

  @Override
  public void initDefaultCommand() 
  {
  }
}
