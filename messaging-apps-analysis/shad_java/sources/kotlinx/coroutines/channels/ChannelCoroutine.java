package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;

/* compiled from: ChannelCoroutine.kt */
/* loaded from: classes4.dex */
public class ChannelCoroutine<E> extends AbstractCoroutine<Unit> implements Channel<E> {
    private final Channel<E> _channel;

    /* renamed from: receiveOrClosed-ZYPwvRU$suspendImpl, reason: not valid java name */
    static /* synthetic */ Object m547receiveOrClosedZYPwvRU$suspendImpl(ChannelCoroutine channelCoroutine, Continuation continuation) {
        return channelCoroutine._channel.mo546receiveOrClosedZYPwvRU(continuation);
    }

    static /* synthetic */ Object send$suspendImpl(ChannelCoroutine channelCoroutine, Object obj, Continuation continuation) {
        return channelCoroutine._channel.send(obj, continuation);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable th) {
        return this._channel.close(th);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(Function1<? super Throwable, Unit> function1) {
        this._channel.invokeOnClose(function1);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isClosedForReceive() {
        return this._channel.isClosedForReceive();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return this._channel.isClosedForSend();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean offer(E e) {
        return this._channel.offer(e);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: receiveOrClosed-ZYPwvRU */
    public Object mo546receiveOrClosedZYPwvRU(Continuation<? super ValueOrClosed<? extends E>> continuation) {
        return m547receiveOrClosedZYPwvRU$suspendImpl(this, continuation);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object send(E e, Continuation<? super Unit> continuation) {
        return send$suspendImpl(this, e, continuation);
    }

    protected final Channel<E> get_channel() {
        return this._channel;
    }

    public ChannelCoroutine(CoroutineContext coroutineContext, Channel<E> channel, boolean z) {
        super(coroutineContext, z);
        this._channel = channel;
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public final void cancel(CancellationException cancellationException) {
        if (isClosedForReceive()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(cancellationException);
    }

    @Override // kotlinx.coroutines.JobSupport
    public void cancelInternal(Throwable th) {
        CancellationException cancellationException$default = JobSupport.toCancellationException$default(this, th, null, 1, null);
        this._channel.cancel(cancellationException$default);
        cancelCoroutine(cancellationException$default);
    }
}
