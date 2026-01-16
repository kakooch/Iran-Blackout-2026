package org.xbill.DNS;

import ir.nasim.OI3;
import ir.nasim.RI3;
import java.time.Duration;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import lombok.Generated;
import org.xbill.DNS.AsyncSemaphore;

/* loaded from: classes8.dex */
final class AsyncSemaphore {

    @Generated
    private static final OI3 log = RI3.i(AsyncSemaphore.class);
    private volatile int permits;
    private final Queue<CompletableFuture<Permit>> queue = new ArrayDeque();
    private final Permit singletonPermit = new Permit();

    final class Permit {
        Permit() {
        }

        public void release() {
            synchronized (AsyncSemaphore.this.queue) {
                try {
                    CompletableFuture completableFuture = (CompletableFuture) AsyncSemaphore.this.queue.poll();
                    if (completableFuture == null) {
                        AsyncSemaphore.access$108(AsyncSemaphore.this);
                    } else {
                        completableFuture.complete(this);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    AsyncSemaphore(int i) {
        this.permits = i;
    }

    static /* synthetic */ int access$108(AsyncSemaphore asyncSemaphore) {
        int i = asyncSemaphore.permits;
        asyncSemaphore.permits = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$acquire$0(TimeoutCompletableFuture timeoutCompletableFuture, Permit permit, Throwable th) {
        this.queue.remove(timeoutCompletableFuture);
    }

    CompletionStage<Permit> acquire(Duration duration) {
        synchronized (this.queue) {
            try {
                if (this.permits > 0) {
                    this.permits--;
                    return CompletableFuture.completedFuture(this.singletonPermit);
                }
                final TimeoutCompletableFuture timeoutCompletableFuture = new TimeoutCompletableFuture();
                timeoutCompletableFuture.compatTimeout(duration.toNanos(), TimeUnit.NANOSECONDS).whenComplete(new BiConsumer() { // from class: org.xbill.DNS.a
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) {
                        this.a.lambda$acquire$0(timeoutCompletableFuture, (AsyncSemaphore.Permit) obj, (Throwable) obj2);
                    }
                });
                this.queue.add(timeoutCompletableFuture);
                return timeoutCompletableFuture;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
