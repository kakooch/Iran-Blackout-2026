package com.google.firebase.inappmessaging.internal;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class DeveloperListenerManager {
    private static final ThreadPoolExecutor CALLBACK_QUEUE_EXECUTOR;
    private static BlockingQueue<Runnable> mCallbackQueue;

    public DeveloperListenerManager() {
        new HashMap();
        new HashMap();
        new HashMap();
        new HashMap();
    }

    static {
        new DeveloperListenerManager();
        mCallbackQueue = new LinkedBlockingQueue();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 15L, TimeUnit.SECONDS, mCallbackQueue, new FIAMThreadFactory("EventListeners-"));
        CALLBACK_QUEUE_EXECUTOR = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    static class FIAMThreadFactory implements ThreadFactory {
        private final String mNameSuffix;
        private final AtomicInteger threadNumber = new AtomicInteger(1);

        FIAMThreadFactory(String str) {
            this.mNameSuffix = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "FIAM-" + this.mNameSuffix + this.threadNumber.getAndIncrement());
            thread.setDaemon(false);
            thread.setPriority(9);
            return thread;
        }
    }
}
