/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.sun.tools.javac.code.Attribute;

/**
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When a selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

public class Autonomous {

    // Declare OpMode members.
    private static ElapsedTime runtime = new ElapsedTime();
    public static final int right = 1;
    public static final int left = 2;
    public static final int forward = 3;
    public static final int backward = 4;
    // Diagonal Right Forward
    public static final int dRF = 5;
    // Diagonal Right Backward
    public static final int dRB = 6;
    // Diagonal Left Forward
    public static final int dLF = 7;
    // Diagonal Left Backward
    public static final int dLB = 8;
    // Left Motors
    private static DcMotor MOne = null;
    private static DcMotor MTwo = null;
    // Right Motors
    private static DcMotor MThree = null;
    private static DcMotor MFour = null;
    //test
    public static void omniDrive(double power, byte direction, int time){
        switch (direction) {
            case right:
                MOne.setPower(-power);
                MTwo.setPower(power);
                MThree.setPower(power);
                MFour.setPower(-power);
                break;
            case left:
                MOne.setPower(power);
                MTwo.setPower(-power);
                MThree.setPower(-power);
                MFour.setPower(power);
                break;
            case forward:
                MOne.setPower(power);
                MTwo.setPower(power);
                MThree.setPower(-power);
                MFour.setPower(-power);
                break;
            case backward:
                MOne.setPower(-power);
                MTwo.setPower(-power);
                MThree.setPower(power);
                MFour.setPower(power);
                break;
            case dRF:
                MOne.setPower(0);
                MTwo.setPower(power);
                MThree.setPower(0);
                MFour.setPower(-power);
                break;
            case dRB:
                MOne.setPower(0);
                MTwo.setPower(-power);
                MThree.setPower(0);
                MFour.setPower(power);
                break;
            case dLF:
                MOne.setPower(power);
                MTwo.setPower(0);
                MThree.setPower(-power);
                MFour.setPower(0);
                break;
            case dLB:
                MOne.setPower(-power);
                MTwo.setPower(0);
                MThree.setPower(power);
                MFour.setPower(0);
                break;

            default:return;

        }
        chersTimer(time);
    }

    public static void drive(double power, int time)
    {
        MOne.setPower(power);
        MTwo.setPower(power);
        MThree.setPower(power);
        MFour.setPower(power);

        chersTimer(time);

        stopDriving();
    }



    //for the turn functionS, get rid of time parameter and replace with set time, for 90 degree rotation
    public static void turnLeft(double power, int time)
    {

        MOne.setPower(-power);
        MTwo.setPower(-power);
        MThree.setPower(power);
        MFour.setPower(power);

        chersTimer(time);
        stopDriving();
    }

    public static void turnRight(double power, int time)
    {

        MOne.setPower(power);
        MTwo.setPower(power);
        MThree.setPower(-power);
        MFour.setPower(-power);


        chersTimer(time);
        stopDriving();
    }

    public static void stopDriving()
    {
        drive(0,0);
    }

    public static void chersTimer(int time){
        long startTime = System.currentTimeMillis();
        while((System.currentTimeMillis() - startTime)<time)
        {
        }
    }
    /*

     */



}
