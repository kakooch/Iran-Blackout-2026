package ir.nasim;

import ir.nasim.LZ2;
import ir.nasim.core.runtime.mtproto.ConnectionEndpoint;

/* renamed from: ir.nasim.os5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C18568os5 {
    public static final C18568os5 a = new C18568os5();

    private C18568os5() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LZ2 c(C18610ow7[] c18610ow7Arr, ConnectionEndpoint[] connectionEndpointArr, SA2 sa2) {
        AbstractC13042fc3.i(c18610ow7Arr, "trustedKeys");
        AbstractC13042fc3.i(connectionEndpointArr, "endPoints");
        AbstractC13042fc3.i(sa2, "myUidProvider");
        return new L82(connectionEndpointArr, c18610ow7Arr, sa2);
    }

    public final LZ2.a b() {
        return new LZ2.a() { // from class: ir.nasim.ns5
            @Override // ir.nasim.LZ2.a
            public final LZ2 a(C18610ow7[] c18610ow7Arr, ConnectionEndpoint[] connectionEndpointArr, SA2 sa2) {
                return C18568os5.c(c18610ow7Arr, connectionEndpointArr, sa2);
            }
        };
    }
}
