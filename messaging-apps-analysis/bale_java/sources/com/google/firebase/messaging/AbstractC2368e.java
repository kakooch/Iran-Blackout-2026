package com.google.firebase.messaging;

import ir.nasim.AbstractC18468oi5;
import ir.nasim.EnumC10570bp7;
import ir.nasim.ThreadFactoryC8579Wo4;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.firebase.messaging.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC2368e {
    private static Executor a(String str) {
        return new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC8579Wo4(str));
    }

    static Executor b() {
        return a("Firebase-Messaging-File-Io");
    }

    static ScheduledExecutorService c() {
        return new ScheduledThreadPoolExecutor(1, new ThreadFactoryC8579Wo4("Firebase-Messaging-Init"));
    }

    static ExecutorService d() {
        return AbstractC18468oi5.a().a(new ThreadFactoryC8579Wo4("Firebase-Messaging-Intent-Handle"), EnumC10570bp7.HIGH_SPEED);
    }

    static ExecutorService e() {
        return Executors.newSingleThreadExecutor(new ThreadFactoryC8579Wo4("Firebase-Messaging-Network-Io"));
    }

    static ExecutorService f() {
        return Executors.newSingleThreadExecutor(new ThreadFactoryC8579Wo4("Firebase-Messaging-Task"));
    }

    static ScheduledExecutorService g() {
        return new ScheduledThreadPoolExecutor(1, new ThreadFactoryC8579Wo4("Firebase-Messaging-Topics-Io"));
    }
}
