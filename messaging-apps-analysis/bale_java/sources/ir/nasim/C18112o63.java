package ir.nasim;

import android.os.SystemClock;
import ir.nasim.C9475a16;
import ir.nasim.core.network.dns.model.DnsResolution;
import java.net.InetAddress;
import java.util.ArrayList;

/* renamed from: ir.nasim.o63, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C18112o63 implements InterfaceC12984fW1 {
    private final SA2 b;

    /* renamed from: ir.nasim.o63$a */
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

    public C18112o63(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "timeInMillisProvider");
        this.b = sa2;
    }

    @Override // ir.nasim.InterfaceC12984fW1
    public DnsResolution b(String str) {
        Object objB;
        DnsResolution dnsResolution;
        AbstractC13042fc3.i(str, "host");
        try {
            C9475a16.a aVar = C9475a16.b;
            InetAddress[] allByName = InetAddress.getAllByName(str);
            AbstractC13042fc3.h(allByName, "getAllByName(...)");
            ArrayList arrayList = new ArrayList();
            for (InetAddress inetAddress : allByName) {
                String hostAddress = inetAddress.getHostAddress();
                if (hostAddress != null) {
                    arrayList.add(hostAddress);
                }
            }
            ArrayList arrayList2 = arrayList.isEmpty() ^ true ? arrayList : null;
            if (arrayList2 == null) {
                dnsResolution = null;
            } else {
                dnsResolution = new DnsResolution(str, ((Number) this.b.invoke()).longValue() - 1, arrayList2, false, 8, null);
                C19406qI3.a("DnsResolver", dnsResolution + " resolved from phone dns.", new Object[0]);
            }
            objB = C9475a16.b(dnsResolution);
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        return (DnsResolution) (C9475a16.g(objB) ? null : objB);
    }

    public C18112o63() {
        this(a.a);
    }
}
