package com.example.flutter_to_native;

import io.flutter.embedding.android.FlutterActivity;
import androidx.annotation.NonNull;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodCall;

import java.util.Timer;
import java.util.TimerTask;


import java.io.*;
import android.os.Looper;
import android.os.Handler;
import java.util.Base64;
import java.util.Arrays;

public class MainActivity extends FlutterActivity {
    private static final String CHANNEL = "flutter.native/helper";

    private MethodChannel.Result result;

    public int i = 0;
    MethodChannel channel;
    //private Timer timer = new Timer();
    //private TimerTask task = new TimerHelper();

    @Override
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        new MethodChannel(flutterEngine.getDartExecutor(), CHANNEL).setMethodCallHandler(
                new MethodChannel.MethodCallHandler() {
                    @Override
                    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                        MainActivity.this.result = result;
                        if (methodCall.method.equals("helloFromNativeCode")) {
                            String greetings = helloFromNativeCode();
                            result.success(greetings);
                        } else {
                            result.notImplemented();
                        }
                    }
                }
        );

        channel = new MethodChannel(flutterEngine.getDartExecutor(), "flutter.native/receiver");

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                //System.out.println("This was called " + i++ + " times");
                callChannel();
            }
        }, 0, 1000);
    }

    private String helloFromNativeCode() {
        System.out.println(
                "Current Thread ID: "
                        + Thread.currentThread().getId());
        return "Hello from Native Android Code";
    }

    private void callChannel() {

        System.out.println(
                "Current Thread ID: "
                        + Thread.currentThread().getId());

        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                // Call the desired channel message here.
                System.out.println(
                        "Looper Thread ID: "
                                + Thread.currentThread().getId());

                channel.invokeMethod("string_method", null, new MethodChannel.Result(){
                    @Override
                    public void notImplemented() {
                        //Really can't do much but print out here because method channel might not be complete
                        //Should be able to assert if original method channel starts this timer task
                        System.out.println("Not Implemented Error");
                        //assert(false);
                    }

                    @Override
                    public void error(String s, String s1, Object o) {
                        //This gets called if a Platform Exception occurs
                        //Throwing won't do anything so you'll have to either handle exception or kill program somehow
                        //In this example I used assert but commented it out.
                        System.out.println("Platform Error Occurred");
                        //assert(false);
                    }

                    @Override
                    public void success(Object o) {
                        System.out.println(o.toString());
                    }
                });

                channel.invokeMethod("bool_method", null, new MethodChannel.Result(){
                    @Override
                    public void notImplemented() {
                        //Really can't do much but print out here because method channel might not be complete
                        //Should be able to assert if original method channel starts this timer task
                        System.out.println("Not Implemented Error");
                        //assert(false);
                    }

                    @Override
                    public void error(String s, String s1, Object o) {
                        //This gets called if a Platform Exception occurs
                        //Throwing won't do anything so you'll have to either handle exception or kill program somehow
                        //In this example I used assert but commented it out.
                        System.out.println("Platform Error Occurred");
                        //assert(false);
                    }

                    @Override
                    public void success(Object o) {
                        System.out.println(o.toString());
                    }
                });

                channel.invokeMethod("int_method", null, new MethodChannel.Result(){
                    @Override
                    public void notImplemented() {
                        //Really can't do much but print out here because method channel might not be complete
                        //Should be able to assert if original method channel starts this timer task
                        System.out.println("Not Implemented Error");
                        //assert(false);
                    }

                    @Override
                    public void error(String s, String s1, Object o) {
                        //This gets called if a Platform Exception occurs
                        //Throwing won't do anything so you'll have to either handle exception or kill program somehow
                        //In this example I used assert but commented it out.
                        System.out.println("Platform Error Occurred");
                        //assert(false);
                    }

                    @Override
                    public void success(Object o) {
                        System.out.println(o.toString());
                    }
                });

                channel.invokeMethod("long_method", null, new MethodChannel.Result(){
                    @Override
                    public void notImplemented() {
                        //Really can't do much but print out here because method channel might not be complete
                        //Should be able to assert if original method channel starts this timer task
                        System.out.println("Not Implemented Error");
                        //assert(false);
                    }

                    @Override
                    public void error(String s, String s1, Object o) {
                        //This gets called if a Platform Exception occurs
                        //Throwing won't do anything so you'll have to either handle exception or kill program somehow
                        //In this example I used assert but commented it out.
                        System.out.println("Platform Error Occurred");
                        //assert(false);
                    }

                    @Override
                    public void success(Object o) {
                        System.out.println(o.toString());
                    }
                });

                channel.invokeMethod("double_method", null, new MethodChannel.Result(){
                    @Override
                    public void notImplemented() {
                        //Really can't do much but print out here because method channel might not be complete
                        //Should be able to assert if original method channel starts this timer task
                        System.out.println("Not Implemented Error");
                        //assert(false);
                    }

                    @Override
                    public void error(String s, String s1, Object o) {
                        //This gets called if a Platform Exception occurs
                        //Throwing won't do anything so you'll have to either handle exception or kill program somehow
                        //In this example I used assert but commented it out.
                        System.out.println("Platform Error Occurred");
                        //assert(false);
                    }

                    @Override
                    public void success(Object o) {
                        System.out.println(o.toString());
                    }
                });

                channel.invokeMethod("byte_method", null, new MethodChannel.Result(){
                    @Override
                    public void notImplemented() {
                        //Really can't do much but print out here because method channel might not be complete
                        //Should be able to assert if original method channel starts this timer task
                        System.out.println("Not Implemented Error");
                        //assert(false);
                    }

                    @Override
                    public void error(String s, String s1, Object o) {
                        //This gets called if a Platform Exception occurs
                        //Throwing won't do anything so you'll have to either handle exception or kill program somehow
                        //In this example I used assert but commented it out.
                        System.out.println("Platform Error Occurred");
                        //assert(false);
                    }

                    @Override
                    public void success(Object o) {
                        byte[] b = (byte[])o;
                        System.out.println(Arrays.toString(b));
                    }
                });

                channel.invokeMethod("list_method", null, new MethodChannel.Result(){
                    @Override
                    public void notImplemented() {
                        //Really can't do much but print out here because method channel might not be complete
                        //Should be able to assert if original method channel starts this timer task
                        System.out.println("Not Implemented Error");
                        //assert(false);
                    }

                    @Override
                    public void error(String s, String s1, Object o) {
                        //This gets called if a Platform Exception occurs
                        //Throwing won't do anything so you'll have to either handle exception or kill program somehow
                        //In this example I used assert but commented it out.
                        System.out.println("Platform Error Occurred");
                        //assert(false);
                    }

                    @Override
                    public void success(Object o) {
                        System.out.println(o.toString());
                    }
                });
            }
        });
    }
}