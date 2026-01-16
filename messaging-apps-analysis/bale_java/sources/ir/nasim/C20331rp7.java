package ir.nasim;

import ir.nasim.EX1;
import ir.nasim.core.network.RpcException;
import java.net.SocketTimeoutException;

/* renamed from: ir.nasim.rp7, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C20331rp7 implements InterfaceC14123hO3 {
    public static final C20331rp7 a = new C20331rp7();

    private C20331rp7() {
    }

    private final EX1.c c(RpcException rpcException) {
        String str = rpcException.getAndroid.gov.nist.javax.sip.header.ParameterNames.TAG java.lang.String();
        int iHashCode = str.hashCode();
        if (iHashCode != -2026498511) {
            if (iHashCode != -528297648) {
                if (iHashCode == -487563364 && str.equals("Bucket is disabled")) {
                    return EX1.c.b.b;
                }
            } else if (str.equals("File is banned")) {
                return EX1.c.a.b;
            }
        } else if (str.equals("File Not Found")) {
            return EX1.c.b.b;
        }
        return C20645sM6.a.b(rpcException.getCode());
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public EX1.c a(Throwable th) {
        AbstractC13042fc3.i(th, "input");
        if (th instanceof SocketTimeoutException) {
            return EX1.c.h.b;
        }
        if (th instanceof RpcException) {
            return c((RpcException) th);
        }
        return null;
    }
}
