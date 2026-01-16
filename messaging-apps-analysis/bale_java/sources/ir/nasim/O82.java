package ir.nasim;

import ir.nasim.C9475a16;
import ir.nasim.core.network.dns.model.DnsResolution;
import ir.nasim.core.network.util.ConnectionEndpoints;
import ir.nasim.core.runtime.mtproto.ConnectionEndpoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public final class O82 {
    private static final a e = new a(null);
    private final KS2 a;
    private final InterfaceC3570Bk5 b;
    private final InterfaceC12984fW1 c;
    private final InterfaceC9173Yu3 d;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public O82(List list) {
        this(list, null, null, null, 14, null);
        AbstractC13042fc3.i(list, "defaultEndpoints");
    }

    private final ConnectionEndpoints c(List list) {
        List<ConnectionEndpoint> list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        for (final ConnectionEndpoint connectionEndpoint : list2) {
            arrayList.add(connectionEndpoint.hasKnownIp() ? AbstractC10360bX0.p(connectionEndpoint, new S92(connectionEndpoint, null)) : AbstractC10360bX0.p(new S92(connectionEndpoint, new SA2() { // from class: ir.nasim.N82
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return O82.d(this.a, connectionEndpoint);
                }
            }), connectionEndpoint));
        }
        List listZ = AbstractC10976cX0.z(arrayList);
        ConnectionEndpoints connectionEndpoints = new ConnectionEndpoints();
        connectionEndpoints.addAll(listZ);
        return connectionEndpoints;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String d(O82 o82, ConnectionEndpoint connectionEndpoint) {
        List<String> addresses;
        AbstractC13042fc3.i(o82, "this$0");
        AbstractC13042fc3.i(connectionEndpoint, "$endpoint");
        DnsResolution dnsResolutionB = o82.c.b(connectionEndpoint.getHost());
        if (dnsResolutionB == null || (addresses = dnsResolutionB.getAddresses()) == null) {
            return null;
        }
        return (String) AbstractC15401jX0.s0(addresses);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConnectionEndpoints e(O82 o82, List list) {
        AbstractC13042fc3.i(o82, "this$0");
        AbstractC13042fc3.i(list, "$defaultEndpoints");
        ConnectionEndpoints connectionEndpointsH = o82.h();
        if (connectionEndpointsH == null) {
            connectionEndpointsH = new ConnectionEndpoints();
            connectionEndpointsH.addAll(list);
            o82.n(connectionEndpointsH);
        }
        return o82.c(connectionEndpointsH);
    }

    private final ConnectionEndpoints f() {
        return (ConnectionEndpoints) this.d.getValue();
    }

    private final ConnectionEndpoints h() {
        Object objB;
        String strE;
        try {
            C9475a16.a aVar = C9475a16.b;
            strE = this.b.e("endpoints");
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        if (strE == null) {
            return null;
        }
        Object objK = this.a.k(strE, ConnectionEndpoints.class);
        AbstractC13042fc3.f((ConnectionEndpoints) objK);
        if (!(!r2.isEmpty())) {
            objK = null;
        }
        objB = C9475a16.b((ConnectionEndpoints) objK);
        Throwable thE = C9475a16.e(objB);
        if (thE != null) {
            C19406qI3.c("EndpointsStorage", "Failed to load endpoints", thE);
        }
        return (ConnectionEndpoints) (C9475a16.g(objB) ? null : objB);
    }

    private final synchronized void i(ConnectionEndpoint connectionEndpoint) {
        f().remove((Object) connectionEndpoint);
        f().add(0, connectionEndpoint);
    }

    private final synchronized void j(ConnectionEndpoint connectionEndpoint) {
        f().remove((Object) connectionEndpoint);
        f().add(connectionEndpoint);
    }

    private final Object n(ConnectionEndpoints connectionEndpoints) {
        Object objB;
        try {
            C9475a16.a aVar = C9475a16.b;
            KS2 ks2 = this.a;
            ArrayList arrayList = new ArrayList();
            for (ConnectionEndpoint connectionEndpoint : connectionEndpoints) {
                if (!(connectionEndpoint instanceof S92)) {
                    arrayList.add(connectionEndpoint);
                }
            }
            this.b.putString("endpoints", ks2.t(arrayList));
            objB = C9475a16.b(C19938rB7.a);
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        Throwable thE = C9475a16.e(objB);
        if (thE != null) {
            C19406qI3.c("EndpointsStorage", "Failed to store endpoints", thE);
        }
        return objB;
    }

    static /* synthetic */ Object o(O82 o82, ConnectionEndpoints connectionEndpoints, int i, Object obj) {
        if ((i & 1) != 0) {
            connectionEndpoints = o82.f();
        }
        return o82.n(connectionEndpoints);
    }

    public final synchronized List g() {
        return new ArrayList(f());
    }

    public final synchronized void k(ConnectionEndpoint connectionEndpoint) {
        AbstractC13042fc3.i(connectionEndpoint, "endpoint");
        if (f().contains((Object) connectionEndpoint)) {
            i(connectionEndpoint);
            o(this, null, 1, null);
        }
    }

    public final synchronized void l(ConnectionEndpoint connectionEndpoint) {
        AbstractC13042fc3.i(connectionEndpoint, "endpoint");
        if (f().contains((Object) connectionEndpoint)) {
            j(connectionEndpoint);
            o(this, null, 1, null);
        }
    }

    public final synchronized void m(List list) {
        AbstractC13042fc3.i(list, "endpoints");
        if (list.isEmpty()) {
            return;
        }
        f().clear();
        f().addAll(c(list));
        o(this, null, 1, null);
    }

    public O82(final List list, KS2 ks2, InterfaceC3570Bk5 interfaceC3570Bk5, InterfaceC12984fW1 interfaceC12984fW1) {
        AbstractC13042fc3.i(list, "defaultEndpoints");
        AbstractC13042fc3.i(ks2, "gson");
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferencesStorage");
        AbstractC13042fc3.i(interfaceC12984fW1, "dnsResolver");
        this.a = ks2;
        this.b = interfaceC3570Bk5;
        this.c = interfaceC12984fW1;
        this.d = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.M82
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return O82.e(this.a, list);
            }
        });
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ O82(List list, KS2 ks2, InterfaceC3570Bk5 interfaceC3570Bk5, InterfaceC12984fW1 interfaceC12984fW1, int i, ED1 ed1) {
        ks2 = (i & 2) != 0 ? C19231q00.b.a() : ks2;
        interfaceC3570Bk5 = (i & 4) != 0 ? C7183Qq.q(EnumC18608ow5.n) : interfaceC3570Bk5;
        if ((i & 8) != 0) {
            C92 c92 = C92.a;
            interfaceC12984fW1 = ((InterfaceC8129Uq4) C92.a(C5721Ko.a.d(), InterfaceC8129Uq4.class)).j0();
        }
        this(list, ks2, interfaceC3570Bk5, interfaceC12984fW1);
    }
}
