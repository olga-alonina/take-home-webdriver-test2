package com.dotdash.utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.io.File;
import java.util.Objects;

import static java.lang.Character.*;


public class methods {
    public static void dragAndDropJS(WebElement source, WebElement target) throws InterruptedException {
        final String java_script =
                "var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEffe" +
                        "ct:'',effectAllowed:'all',files:[],items:{},types:[],setData:fun" +
                        "ction(format,data){this.items[format]=data;this.types.append(for" +
                        "mat);},getData:function(format){return this.items[format];},clea" +
                        "rData:function(format){}};var emit=function(event,target){var ev" +
                        "t=document.createEvent('Event');evt.initEvent(event,true,false);" +
                        "evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);};emit('" +
                        "dragstart',src);emit('dragenter',tgt);emit('dragover',tgt);emit(" +
                        "'drop',tgt);emit('dragend',src);";

        ((JavascriptExecutor) Driver.get()).executeScript(java_script, source, target);
    }

    public static int countFilesInFolder() {
        File directory = new File("/Users/olga/Downloads");
        int fileCount = Objects.requireNonNull(directory.list()).length;
        return fileCount;
    }

    public static boolean JSLogsInfoTest(String expectedErrorMsg) {
        LogEntries logEntries = Driver.get().manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            if (entry.getMessage().contains(expectedErrorMsg)) {
                return true;
            }
        }
        return false;
    }

    public static void calcButtons(char number) {
        if (number == '.' || number == '+' || number == '÷' || number == '×' || number == '−' || number == '=') {
            Driver.get().findElement(By.xpath("//table[@class='ElumCf']//div//div[.=" + "\"" + number + "\"" + "]")).click();
        } else {
            Driver.get().findElement(By.xpath("//table[@class='ElumCf']//div//div[.=" + number + "]")).click();
        }
    }

    public static void actions(String action) {
        //setup
        Driver.get().get("https://www.google.com");
        Driver.get().findElement(By.cssSelector("[class='gLFyf gsfi']")).sendKeys("calculator" + Keys.ENTER);
        String temp2 = "";
        int shrink = 0;
        char[] temp = action.toCharArray();
        for (Character each : temp) {
            if (isLetter(each)) {
                switch (each) {
                    case 'C':
                    case 'E':
                    case 'A':
                        temp2 += each;
                        if (temp2.length() == 2 && (temp2.equals("AC") || temp2.equals("CE"))) {
                            Driver.get().findElement(By.cssSelector("[jsname='H7sWPd']")).click();
                            temp2 = "";
                            shrink++;
                        }
                }
            } else {
                calcButtons(each);
            }
        }
        calcButtons('=');
        String result = Driver.get().findElement(By.cssSelector("[jsname='VssY5c']")).getText();
        Integer numResult = Integer.parseInt(result);
        if (action.contains("AC") || action.contains("CE")) {
            Assert.assertEquals((action.length() - (shrink*2L+shrink)), result.length());
            System.out.println("shrink works normally");
        }
        System.out.println(action + " = " + numResult);
    }
}


