package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;

/* compiled from: Channel.kt */
/* loaded from: classes4.dex */
public interface ReceiveChannel<E> {
    void cancel(CancellationException cancellationException);

    boolean isClosedForReceive();

    /* renamed from: receiveOrClosed-ZYPwvRU */
    Object mo546receiveOrClosedZYPwvRU(Continuation<? super ValueOrClosed<? extends E>> continuation);
}
