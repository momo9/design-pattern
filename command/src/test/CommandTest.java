package test;

import static org.junit.Assert.*;

import org.junit.Test;

import command.Command;
import command.Fan;
import command.FanHighCommand;
import command.FanLowCommand;
import command.FanMediumCommand;
import command.FanOffCommand;
import command.Invoker;
import command.Light;
import command.LightOnCommand;
import command.MacroCommand;

public class CommandTest {

    @Test
    public void lightTest() {
        System.out.println("------" + 
            Thread.currentThread().getStackTrace()[1].getMethodName() +
            "--------");
        Invoker inv = new Invoker();
        Light light = new Light();
        Command cmd = new LightOnCommand(light);
        inv.setCommand(0, cmd);
        inv.press(0);
        inv.undo();
    }
    
    @Test
    public void allTest() {
        System.out.println("------" + 
                Thread.currentThread().getStackTrace()[1].getMethodName() +
                "--------");
        Invoker inv = new Invoker();
        Light light = new Light();
        Fan fan = new Fan();

        inv.setCommand(0, new LightOnCommand(light));
        inv.setCommand(1, new FanOffCommand(fan));
        inv.setCommand(2, new FanLowCommand(fan));
        inv.setCommand(3, new FanMediumCommand(fan));
        inv.setCommand(4, new FanHighCommand(fan));

        inv.press(0);
        inv.undo();
        inv.press(1);
        inv.undo();
        inv.press(2);
        inv.press(3);
        inv.undo();
        inv.press(4);
        inv.undo();
    }
    
    @Test
    public void macroTest() {
        System.out.println("------" + 
                Thread.currentThread().getStackTrace()[1].getMethodName() +
                "--------");
        Light light = new Light();
        Fan fan = new Fan();
        Command[] cmds = {new LightOnCommand(light), new FanHighCommand(fan)};
        MacroCommand macroCmd = new MacroCommand(cmds);
        Invoker inv = new Invoker();
        inv.setCommand(0, macroCmd);
        inv.setCommand(1, new FanLowCommand(fan));
        inv.press(0);
        inv.press(1);
        inv.undo();
    }

}
