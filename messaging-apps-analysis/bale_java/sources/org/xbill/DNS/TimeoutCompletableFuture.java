package org.xbill.DNS;

import ir.nasim.OI3;
import ir.nasim.RI3;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.BiConsumer;
import lombok.Generated;
import org.xbill.DNS.TimeoutCompletableFuture;

/* loaded from: classes8.dex */
class TimeoutCompletableFuture<T> extends CompletableFuture<T> {

    @Generated
    private static final OI3 log = RI3.i(TimeoutCompletableFuture.class);
    private static final Method orTimeoutMethod;

    /* JADX INFO: Access modifiers changed from: private */
    static final class TimeoutScheduler {
        private static final ScheduledThreadPoolExecutor executor;

        static {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new ThreadFactory() { // from class: org.xbill.DNS.z
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    return TimeoutCompletableFuture.TimeoutScheduler.lambda$static$0(runnable);
                }
            });
            executor = scheduledThreadPoolExecutor;
            scheduledThreadPoolExecutor.setRemoveOnCancelPolicy(true);
        }

        private TimeoutScheduler() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Thread lambda$static$0(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            thread.setName("dnsjava AsyncSemaphoreTimeoutScheduler");
            return thread;
        }
    }

    static {
        Method method = null;
        if (!System.getProperty("java.version").startsWith("1.")) {
            try {
                method = CompletableFuture.class.getMethod("orTimeout", Long.TYPE, TimeUnit.class);
            } catch (NoSuchMethodException e) {
                log.m("CompletableFuture.orTimeout method not found in Java 9+, using custom implementation", e);
            }
        }
        orTimeoutMethod = method;
    }

    TimeoutCompletableFuture() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$orTimeout$0(CompletableFuture completableFuture) {
        if (completableFuture.isDone()) {
            return;
        }
        completableFuture.completeExceptionally(new TimeoutException());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$orTimeout$1(ScheduledFuture scheduledFuture, Object obj, Throwable th) {
        if (th != null || scheduledFuture.isDone()) {
            return;
        }
        scheduledFuture.cancel(false);
    }

    private static <T> CompletableFuture<T> orTimeout(final CompletableFuture<T> completableFuture, long j, TimeUnit timeUnit) {
        final ScheduledFuture<?> scheduledFutureSchedule = TimeoutScheduler.executor.schedule(new Runnable() { // from class: org.xbill.DNS.x
            @Override // java.lang.Runnable
            public final void run() {
                TimeoutCompletableFuture.lambda$orTimeout$0(completableFuture);
            }
        }, j, timeUnit);
        completableFuture.whenComplete((BiConsumer) new BiConsumer() { // from class: org.xbill.DNS.y
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                TimeoutCompletableFuture.lambda$orTimeout$1(scheduledFutureSchedule, obj, (Throwable) obj2);
            }
        });
        return completableFuture;
    }

    public CompletableFuture<T> compatTimeout(long j, TimeUnit timeUnit) {
        return compatTimeout(this, j, timeUnit);
    }

    public static <T> CompletableFuture<T> compatTimeout(CompletableFuture<T> completableFuture, long j, TimeUnit timeUnit) {
        Method method = orTimeoutMethod;
        if (method == null) {
            return orTimeout(completableFuture, j, timeUnit);
        }
        try {
            return (CompletableFuture) method.invoke(completableFuture, Long.valueOf(j), timeUnit);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return orTimeout(completableFuture, j, timeUnit);
        }
    }
}
