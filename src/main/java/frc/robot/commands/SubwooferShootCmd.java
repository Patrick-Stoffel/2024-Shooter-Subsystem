// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

public class SubwooferShootCmd extends Command {
 
  private final ShooterSubsystem shooterSubsystem;
  private double voltage;


  public SubwooferShootCmd(ShooterSubsystem shooterSubsystem, double voltage) {
    
    this.shooterSubsystem = shooterSubsystem;
    this.voltage = voltage;
    addRequirements(shooterSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("SubwooferShootCmd started");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooterSubsystem.setShooterSpeeds(voltage);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooterSubsystem.setShooterSpeeds(0);
    System.out.println("SubwooferShootCmd ended");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
