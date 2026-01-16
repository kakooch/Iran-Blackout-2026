package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: Channel.kt */
/* loaded from: classes4.dex */
public final class ChannelKt {
    public static /* synthetic */ Channel Channel$default(int i, BufferOverflow bufferOverflow, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        return Channel(i, bufferOverflow, function1);
    }

    public static final <E> Channel<E> Channel(int i, BufferOverflow bufferOverflow, Function1<? super E, Unit> function1) {
        if (i == -2) {
            return new ArrayChannel(bufferOverflow == BufferOverflow.SUSPEND ? Channel.Factory.getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core() : 1, bufferOverflow, function1);
        }
        if (i == -1) {
            if ((bufferOverflow != BufferOverflow.SUSPEND ? 0 : 1) == 0) {
                throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
            }
            return new ConflatedChannel(function1);
        }
        if (i == 0) {
            if (bufferOverflow == BufferOverflow.SUSPEND) {
                return new RendezvousChannel(function1);
            }
            return new ArrayChannel(1, bufferOverflow, function1);
        }
        if (i == Integer.MAX_VALUE) {
            return new LinkedListChannel(function1);
        }
        if (i == 1 && bufferOverflow == BufferOverflow.DROP_OLDEST) {
            return new ConflatedChannel(function1);
        }
        return new ArrayChannel(i, bufferOverflow, function1);
    }
}
