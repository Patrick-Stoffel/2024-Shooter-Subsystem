// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.AmpShootCmd;
import frc.robot.commands.PodiumShootCmd;
import frc.robot.commands.SubwooferShootCmd;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();


  private final CommandXboxController operatorXboxController =
      new CommandXboxController(OperatorConstants.kOperatorControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    configureBindings();
  }


  private void configureBindings() {


    operatorXboxController.a().whileTrue(new AmpShootCmd(shooterSubsystem, Constants.OperatorConstants.kAmpShootCmdVolts));
    operatorXboxController.b().whileTrue(new SubwooferShootCmd(shooterSubsystem, Constants.OperatorConstants.kSubwooferShootCmdVolts));
    operatorXboxController.x().whileTrue(new PodiumShootCmd(shooterSubsystem, Constants.OperatorConstants.kPodiumShootCmdVolts));
  

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return null;
  }
}
