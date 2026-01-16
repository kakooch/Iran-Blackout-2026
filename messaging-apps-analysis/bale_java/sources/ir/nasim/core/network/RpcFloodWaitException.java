package ir.nasim.core.network;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lir/nasim/core/network/RpcFloodWaitException;", "Lir/nasim/core/network/RpcException;", "<init>", "()V", "base_productionRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RpcFloodWaitException extends RpcException {
    public RpcFloodWaitException() {
        super("FLOOD_WAIT", 501, "Server error", true);
    }
}
