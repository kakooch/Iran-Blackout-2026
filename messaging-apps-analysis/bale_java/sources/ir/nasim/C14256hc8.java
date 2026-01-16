package ir.nasim;

import android.os.SystemClock;
import ir.nasim.C9475a16;
import ir.nasim.core.network.dns.model.DnsResolution;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import org.xbill.DNS.ARecord;
import org.xbill.DNS.Lookup;
import org.xbill.DNS.Record;
import org.xbill.DNS.Resolver;

/* renamed from: ir.nasim.hc8, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14256hc8 implements InterfaceC12984fW1 {
    private final String b;
    private final UA2 c;
    private final SA2 d;

    /* renamed from: ir.nasim.hc8$a */
    /* synthetic */ class a extends EB2 implements SA2 {
        public static final a a = new a();

        a() {
            super(0, SystemClock.class, "uptimeMillis", "uptimeMillis()J", 0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final Long invoke() {
            return Long.valueOf(SystemClock.uptimeMillis());
        }
    }

    public C14256hc8(String str, UA2 ua2, SA2 sa2) {
        AbstractC13042fc3.i(str, "dnsServer");
        AbstractC13042fc3.i(ua2, "lookupProvider");
        AbstractC13042fc3.i(sa2, "timeInMillisProvider");
        this.b = str;
        this.c = ua2;
        this.d = sa2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Lookup d(Resolver resolver, String str) {
        AbstractC13042fc3.i(resolver, "$resolver");
        AbstractC13042fc3.i(str, "host");
        Lookup lookup = new Lookup(str, 1);
        lookup.setResolver(resolver);
        return lookup;
    }

    private final DnsResolution e(String str) {
        Record[] recordArrRun = ((Lookup) this.c.invoke(str)).run();
        if (recordArrRun == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Record record : recordArrRun) {
            if (record instanceof ARecord) {
                arrayList.add(record);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            InetAddress address = ((ARecord) it.next()).getAddress();
            String hostAddress = address != null ? address.getHostAddress() : null;
            if (hostAddress != null) {
                arrayList2.add(hostAddress);
            }
        }
        ArrayList arrayList3 = arrayList2.isEmpty() ^ true ? arrayList2 : null;
        if (arrayList3 == null) {
            return null;
        }
        DnsResolution dnsResolution = new DnsResolution(str, ((Number) this.d.invoke()).longValue() - 1, arrayList3, false, 8, null);
        C19406qI3.a("DnsResolver", dnsResolution + " resolved from " + this.b, new Object[0]);
        return dnsResolution;
    }

    @Override // ir.nasim.InterfaceC12984fW1
    public DnsResolution b(String str) {
        Object objB;
        AbstractC13042fc3.i(str, "host");
        try {
            C9475a16.a aVar = C9475a16.b;
            objB = C9475a16.b(e(str));
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        if (C9475a16.g(objB)) {
            objB = null;
        }
        return (DnsResolution) objB;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C14256hc8(String str, final Resolver resolver, SA2 sa2) {
        this(str, new UA2() { // from class: ir.nasim.gc8
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C14256hc8.d(resolver, (String) obj);
            }
        }, sa2);
        AbstractC13042fc3.i(str, "dnsServer");
        AbstractC13042fc3.i(resolver, "resolver");
        AbstractC13042fc3.i(sa2, "timeInMillisProvider");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C14256hc8(String str, Resolver resolver) {
        this(str, resolver, a.a);
        AbstractC13042fc3.i(str, "dnsServer");
        AbstractC13042fc3.i(resolver, "resolver");
    }
}
