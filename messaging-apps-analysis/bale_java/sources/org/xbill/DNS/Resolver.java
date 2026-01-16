package org.xbill.DNS;

import android.gov.nist.core.Separators;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.BiFunction;
import org.xbill.DNS.Message;
import org.xbill.DNS.Resolver;

/* loaded from: classes8.dex */
public interface Resolver {
    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ Object lambda$sendAsync$0(ResolverListener resolverListener, Object obj, Message message, Throwable th) {
        if (th != null) {
            resolverListener.handleException(obj, th instanceof Exception ? (Exception) th : new Exception(th));
            return null;
        }
        resolverListener.receiveMessage(obj, message);
        return null;
    }

    default Duration getTimeout() {
        return Duration.ofSeconds(10L);
    }

    default Message send(Message message) throws IOException {
        try {
            return sendAsync(message).toCompletableFuture().get(getTimeout().toMillis(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IOException(e);
        } catch (ExecutionException e2) {
            if (e2.getCause() instanceof IOException) {
                throw ((IOException) e2.getCause());
            }
            if (e2.getCause() != null) {
                throw new IOException(e2.getCause());
            }
            throw new IOException(e2);
        } catch (TimeoutException e3) {
            throw new IOException("Timed out while trying to resolve " + message.getQuestion().getName() + Separators.SLASH + Type.string(message.getQuestion().type) + ", id=" + message.getHeader().getID(), e3);
        }
    }

    default CompletionStage<Message> sendAsync(Message message) {
        return sendAsync(message, ForkJoinPool.commonPool());
    }

    default void setEDNS(int i) {
        setEDNS(i, 0, 0, Collections.emptyList());
    }

    void setEDNS(int i, int i2, int i3, List<EDNSOption> list);

    void setIgnoreTruncation(boolean z);

    void setPort(int i);

    void setTCP(boolean z);

    void setTSIGKey(TSIG tsig);

    @Deprecated
    default void setTimeout(int i, int i2) {
        setTimeout(Duration.ofMillis((i * 1000) + i2));
    }

    void setTimeout(Duration duration);

    default CompletionStage<Message> sendAsync(Message message, Executor executor) {
        final CompletableFuture completableFuture = new CompletableFuture();
        sendAsync(message, new ResolverListener() { // from class: org.xbill.DNS.Resolver.1
            @Override // org.xbill.DNS.ResolverListener
            public void handleException(Object obj, Exception exc) {
                completableFuture.completeExceptionally(exc);
            }

            @Override // org.xbill.DNS.ResolverListener
            public void receiveMessage(Object obj, Message message2) {
                completableFuture.complete(message2);
            }
        });
        return completableFuture;
    }

    default void setEDNS(int i, int i2, int i3, EDNSOption... eDNSOptionArr) {
        setEDNS(i, i2, i3, eDNSOptionArr == null ? Collections.emptyList() : Arrays.asList(eDNSOptionArr));
    }

    @Deprecated
    default void setTimeout(int i) {
        setTimeout(Duration.ofSeconds(i));
    }

    @Deprecated
    default Object sendAsync(Message message, final ResolverListener resolverListener) {
        final Object obj = new Object();
        sendAsync(message).handleAsync(new BiFunction() { // from class: ir.nasim.CW5
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj2, Object obj3) {
                return Resolver.lambda$sendAsync$0(resolverListener, obj, (Message) obj2, (Throwable) obj3);
            }
        });
        return obj;
    }
}
