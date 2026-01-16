package ir.nasim;

import ir.nasim.InterfaceC18892pR;
import ir.nasim.core.network.RpcException;
import java.util.Map;

/* loaded from: classes5.dex */
public final class T66 implements InterfaceC14123hO3 {
    public static final T66 a = new T66();
    private static final Map b = AbstractC20051rO3.n(AbstractC4616Fw7.a(7, InterfaceC18892pR.b.a), AbstractC4616Fw7.a(10, InterfaceC18892pR.c.a), AbstractC4616Fw7.a(3, InterfaceC18892pR.a.a));
    private static final Map c = AbstractC19460qO3.g(AbstractC4616Fw7.a("TIMEOUT", InterfaceC18892pR.d.a));

    private T66() {
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public InterfaceC18892pR a(RpcException rpcException) {
        AbstractC13042fc3.i(rpcException, "input");
        InterfaceC18892pR interfaceC18892pR = (InterfaceC18892pR) b.get(Integer.valueOf(rpcException.getCode()));
        if (interfaceC18892pR != null) {
            return interfaceC18892pR;
        }
        InterfaceC18892pR.d dVar = (InterfaceC18892pR.d) c.get(rpcException.getAndroid.gov.nist.javax.sip.header.ParameterNames.TAG java.lang.String());
        return dVar != null ? dVar : InterfaceC18892pR.e.a;
    }
}
