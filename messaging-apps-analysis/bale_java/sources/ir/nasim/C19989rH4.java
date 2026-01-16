package ir.nasim;

import android.os.SystemClock;
import ir.nasim.C9475a16;
import ir.nasim.core.network.dns.model.DnsResolution;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.Dns;

/* renamed from: ir.nasim.rH4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19989rH4 implements Dns {
    private static final b d = new b(null);
    private final SA2 a;
    private final C19596qd1 b;
    private final InterfaceC9173Yu3 c;

    /* renamed from: ir.nasim.rH4$a */
    /* synthetic */ class a extends EB2 implements SA2 {
        public static final a a = new a();

        a() {
            super(0, SystemClock.class, "elapsedRealtime", "elapsedRealtime()J", 0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final Long invoke() {
            return Long.valueOf(SystemClock.elapsedRealtime());
        }
    }

    /* renamed from: ir.nasim.rH4$b */
    private static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    public C19989rH4(SA2 sa2, final InterfaceC7720Sx5 interfaceC7720Sx5, C19596qd1 c19596qd1) {
        AbstractC13042fc3.i(sa2, "timeProvider");
        AbstractC13042fc3.i(interfaceC7720Sx5, "dnsResolverProvider");
        AbstractC13042fc3.i(c19596qd1, "connectionHealthChecker");
        this.a = sa2;
        this.b = c19596qd1;
        this.c = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.qH4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C19989rH4.b(interfaceC7720Sx5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC12984fW1 b(InterfaceC7720Sx5 interfaceC7720Sx5) {
        AbstractC13042fc3.i(interfaceC7720Sx5, "$dnsResolverProvider");
        InterfaceC12984fW1 interfaceC12984fW1 = (InterfaceC12984fW1) interfaceC7720Sx5.get();
        interfaceC12984fW1.initialize();
        return interfaceC12984fW1;
    }

    private final InterfaceC12984fW1 c() {
        return (InterfaceC12984fW1) this.c.getValue();
    }

    private final InetAddress d(String str, String str2) {
        Object objB;
        try {
            C9475a16.a aVar = C9475a16.b;
            objB = C9475a16.b(InetAddress.getByAddress(str, InetAddress.getByName(str2).getAddress()));
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        if (C9475a16.e(objB) != null) {
            C19406qI3.b("OkHttpDnsWithCache", "Failed to map " + str2 + " to InetAddress!");
        }
        if (C9475a16.g(objB)) {
            objB = null;
        }
        return (InetAddress) objB;
    }

    @Override // okhttp3.Dns
    public List lookup(String str) throws UnknownHostException {
        AbstractC13042fc3.i(str, "hostname");
        long jLongValue = ((Number) this.a.invoke()).longValue();
        try {
            DnsResolution dnsResolutionB = c().b(str);
            if (dnsResolutionB == null) {
                throw new UnknownHostException();
            }
            List<String> addresses = dnsResolutionB.getAddresses();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = addresses.iterator();
            while (it.hasNext()) {
                InetAddress inetAddressD = d(str, (String) it.next());
                if (inetAddressD != null) {
                    arrayList.add(inetAddressD);
                }
            }
            if (!(!arrayList.isEmpty())) {
                arrayList = null;
            }
            if (arrayList != null) {
                return arrayList;
            }
            throw new UnknownHostException();
        } catch (UnknownHostException e) {
            this.b.f(str, String.valueOf(((Number) this.a.invoke()).longValue() - jLongValue));
            throw e;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C19989rH4(InterfaceC7720Sx5 interfaceC7720Sx5, C19596qd1 c19596qd1) {
        this(a.a, interfaceC7720Sx5, c19596qd1);
        AbstractC13042fc3.i(interfaceC7720Sx5, "dnsResolverProvider");
        AbstractC13042fc3.i(c19596qd1, "connectionHealthChecker");
    }
}
