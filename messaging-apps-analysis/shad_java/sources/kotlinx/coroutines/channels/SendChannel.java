package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* compiled from: Channel.kt */
/* loaded from: classes4.dex */
public interface SendChannel<E> {
    boolean close(Throwable th);

    void invokeOnClose(Function1<? super Throwable, Unit> function1);

    boolean isClosedForSend();

    boolean offer(E e);

    Object send(E e, Continuation<? super Unit> continuation);

    /* compiled from: Channel.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ boolean close$default(SendChannel sendChannel, Throwable th, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
            }
            if ((i & 1) != 0) {
                th = null;
            }
            return sendChannel.close(th);
        }
    }
}
