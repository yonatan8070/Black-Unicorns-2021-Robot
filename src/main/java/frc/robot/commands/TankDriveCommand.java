/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class TankDriveCommand extends CommandBase {
  private DriveSubsystem drive;

  private Joystick rightJoystick;
  private Joystick leftJoystick;

  /**
   * Creates a new DriveCommand.
   */
  public TankDriveCommand(DriveSubsystem drive) {
    this.drive = drive;
    addRequirements(drive);

    rightJoystick = new Joystick(0);
    leftJoystick = new Joystick(1);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftSpeed = leftJoystick.getY();
    double rightSpeed = rightJoystick.getY();

    drive.tankDrive(leftSpeed, rightSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
