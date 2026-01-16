package ir.nasim;

import android.gov.nist.core.Separators;
import android.os.SystemClock;
import ir.nasim.Q12;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public final class XR {
    private static final b e = new b(null);
    private static final long f;
    private final long a;
    private final SA2 b;
    private final InterfaceC13140fj4 c;
    private final InterfaceC9173Yu3 d;

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

    private static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    private static final class c {
        private final String a;
        private final long b;

        public c(String str, long j) {
            AbstractC13042fc3.i(str, "identifier");
            this.a = str;
            this.b = j;
        }

        public final long a() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return AbstractC13042fc3.d(this.a, cVar.a) && this.b == cVar.b;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + Long.hashCode(this.b);
        }

        public String toString() {
            return "EventState(identifier=" + this.a + ", lastSentTimeInMillis=" + this.b + Separators.RPAREN;
        }
    }

    /* synthetic */ class d extends EB2 implements SA2 {
        public static final d a = new d();

        d() {
            super(0, ConcurrentHashMap.class, "<init>", "<init>()V", 0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final ConcurrentHashMap invoke() {
            return new ConcurrentHashMap();
        }
    }

    static {
        Q12.a aVar = Q12.b;
        f = Q12.A(T12.s(1, W12.g));
    }

    public XR(long j, SA2 sa2, InterfaceC13140fj4 interfaceC13140fj4) {
        AbstractC13042fc3.i(sa2, "timeProviderInMillis");
        AbstractC13042fc3.i(interfaceC13140fj4, "monitoringRepository");
        this.a = j;
        this.b = sa2;
        this.c = interfaceC13140fj4;
        this.d = AbstractC13269fw3.a(d.a);
    }

    private final Map a() {
        return (Map) this.d.getValue();
    }

    public final void b(String str, UA2 ua2) {
        AbstractC13042fc3.i(str, "identifier");
        AbstractC13042fc3.i(ua2, "block");
        long jLongValue = ((Number) this.b.invoke()).longValue();
        c cVar = (c) a().get(str);
        if (jLongValue - (cVar != null ? cVar.a() : -2147483648L) > this.a) {
            a().put(str, new c(str, jLongValue));
            ua2.invoke(this.c);
            return;
        }
        C19406qI3.a("AuthorizeMonitoringUseCase", "Event ignored with identifier: \"" + str + Separators.DOUBLE_QUOTE, new Object[0]);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public XR(InterfaceC13140fj4 interfaceC13140fj4) {
        this(f, a.a, interfaceC13140fj4);
        AbstractC13042fc3.i(interfaceC13140fj4, "monitoringRepository");
    }
}
