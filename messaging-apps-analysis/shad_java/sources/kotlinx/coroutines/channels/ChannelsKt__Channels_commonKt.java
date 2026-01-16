package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.ExceptionsKt;

/* compiled from: Channels.common.kt */
/* loaded from: classes4.dex */
final /* synthetic */ class ChannelsKt__Channels_commonKt {
    public static final void cancelConsumed(ReceiveChannel<?> receiveChannel, Throwable th) {
        CancellationException CancellationException = null;
        if (th != null) {
            CancellationException = (CancellationException) (th instanceof CancellationException ? th : null);
            if (CancellationException == null) {
                CancellationException = ExceptionsKt.CancellationException("Channel was consumed, consumer had failed", th);
            }
        }
        receiveChannel.cancel(CancellationException);
    }
}
