// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
   

      private final TalonFX leftShooterFX  = new TalonFX(10, "rio");
      private final TalonFX rightShooterFX = new TalonFX(11, "rio");



  public ShooterSubsystem() {

            /* Reset Talon Configs -- Clears out old values */
      leftShooterFX.getConfigurator().apply(new TalonFXConfiguration());
      rightShooterFX.getConfigurator().apply(new TalonFXConfiguration());

            /* Set followers to follow leader */
        rightShooterFX.setControl(new Follower(leftShooterFX.getDeviceID(), true));
  }








  @Override
  public void periodic() {
    
 //     SmartDashboard.putNumber("Shooter Velocity", leftShooterFX.getVelocity().getValueAsDouble());  // NOW IN REV/SEC

  }


  public void setShooterSpeeds(double voltage) {
//      leftShooterFX.setVoltage(voltage);

  }

  


}
