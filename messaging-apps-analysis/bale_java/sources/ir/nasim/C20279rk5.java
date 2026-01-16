package ir.nasim;

import android.os.SystemClock;
import ir.nasim.C9475a16;
import ir.nasim.core.network.dns.model.DnsResolution;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/* renamed from: ir.nasim.rk5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C20279rk5 implements InterfaceC11732dW1 {
    public static final b e = new b(null);
    private final KS2 a;
    private final SA2 b;
    private final InterfaceC3570Bk5 c;
    private HashMap d;

    /* renamed from: ir.nasim.rk5$a */
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

    /* renamed from: ir.nasim.rk5$b */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    public C20279rk5(KS2 ks2, SA2 sa2, InterfaceC3570Bk5 interfaceC3570Bk5) {
        AbstractC13042fc3.i(ks2, "gson");
        AbstractC13042fc3.i(sa2, "timeInMillisProvider");
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferencesStorage");
        this.a = ks2;
        this.b = sa2;
        this.c = interfaceC3570Bk5;
    }

    private final Object b(String str) {
        Object objB;
        try {
            C9475a16.a aVar = C9475a16.b;
            Object objK = this.a.k(str, DnsResolution[].class);
            AbstractC13042fc3.h(objK, "fromJson(...)");
            ArrayList<DnsResolution> arrayList = new ArrayList();
            for (Object obj : (Object[]) objK) {
                if (c((DnsResolution) obj)) {
                    arrayList.add(obj);
                }
            }
            for (DnsResolution dnsResolution : arrayList) {
                HashMap map = this.d;
                if (map == null) {
                    AbstractC13042fc3.y("cachedDnsResolutions");
                    map = null;
                }
                map.put(dnsResolution.getHost(), dnsResolution);
            }
            objB = C9475a16.b(C19938rB7.a);
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        Throwable thE = C9475a16.e(objB);
        if (thE != null) {
            C19406qI3.b("PreferencesHostCache", "Failed to fill the map: " + thE);
        }
        return objB;
    }

    private final boolean c(DnsResolution dnsResolution) {
        return dnsResolution.isVerified() && dnsResolution.getTtlInMillis() > ((Number) this.b.invoke()).longValue();
    }

    private final void d(DnsResolution dnsResolution) {
        HashMap map = this.d;
        if (map == null) {
            AbstractC13042fc3.y("cachedDnsResolutions");
            map = null;
        }
        map.put(dnsResolution.getHost(), dnsResolution);
        f();
    }

    private final void e(String str) {
        HashMap map = this.d;
        if (map == null) {
            AbstractC13042fc3.y("cachedDnsResolutions");
            map = null;
        }
        if (((DnsResolution) map.remove(str)) == null) {
            return;
        }
        f();
    }

    private final Object f() {
        Object objB;
        try {
            C9475a16.a aVar = C9475a16.b;
            KS2 ks2 = this.a;
            HashMap map = this.d;
            if (map == null) {
                AbstractC13042fc3.y("cachedDnsResolutions");
                map = null;
            }
            Collection collectionValues = map.values();
            AbstractC13042fc3.h(collectionValues, "<get-values>(...)");
            this.c.putString("host_cache", ks2.t(AbstractC15401jX0.m1(collectionValues)));
            objB = C9475a16.b(C19938rB7.a);
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        Throwable thE = C9475a16.e(objB);
        if (thE != null) {
            C19406qI3.b("PreferencesHostCache", "Failed to update preferences: " + thE);
        }
        return objB;
    }

    @Override // ir.nasim.InterfaceC11732dW1
    public void a(DnsResolution dnsResolution) {
        AbstractC13042fc3.i(dnsResolution, "dnsResolution");
        synchronized (this) {
            d(dnsResolution);
            C19938rB7 c19938rB7 = C19938rB7.a;
        }
    }

    @Override // ir.nasim.InterfaceC11732dW1
    public DnsResolution get(String str) {
        DnsResolution dnsResolution;
        AbstractC13042fc3.i(str, "host");
        synchronized (this) {
            try {
                HashMap map = this.d;
                dnsResolution = null;
                if (map == null) {
                    AbstractC13042fc3.y("cachedDnsResolutions");
                    map = null;
                }
                DnsResolution dnsResolution2 = (DnsResolution) map.get(str);
                if (dnsResolution2 != null && c(dnsResolution2)) {
                    dnsResolution = dnsResolution2;
                }
                if (dnsResolution == null) {
                    e(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return dnsResolution;
    }

    @Override // ir.nasim.InterfaceC11732dW1
    public void initialize() {
        synchronized (this) {
            try {
                if (this.d == null) {
                    this.d = new HashMap();
                    String strE = this.c.e("host_cache");
                    if (strE != null) {
                        C9475a16.a(b(strE));
                    }
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C20279rk5(KS2 ks2, InterfaceC3570Bk5 interfaceC3570Bk5) {
        this(ks2, a.a, interfaceC3570Bk5);
        AbstractC13042fc3.i(ks2, "gson");
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferencesStorage");
    }
}
