package ir.nasim;

import ir.nasim.core.runtime.mtproto.ConnectionEndpoint;

/* loaded from: classes5.dex */
final class S92 extends ConnectionEndpoint {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public S92(ConnectionEndpoint connectionEndpoint, SA2 sa2) {
        super(connectionEndpoint.getId() * (-1), connectionEndpoint.getType(), connectionEndpoint.getPort(), connectionEndpoint.getHost(), connectionEndpoint.getTlsPublicKeyHashes(), sa2);
        AbstractC13042fc3.i(connectionEndpoint, "original");
    }

    @Override // ir.nasim.core.runtime.mtproto.ConnectionEndpoint
    public String toString() {
        return "Ephemeral" + super.toString();
    }
}
