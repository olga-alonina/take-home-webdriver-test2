package com.dotdash.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.io.File;
import java.util.Objects;


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
}


