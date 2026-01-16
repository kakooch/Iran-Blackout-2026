package ir.nasim;

import android.gov.nist.core.Separators;
import android.os.SystemClock;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.InterfaceC18557or4;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes6.dex */
public final class QK6 implements XK6 {
    private static final a h = new a(null);
    private final int a;
    private final int b;
    private final int c;
    private int d;
    private int e;
    private long f;
    private int g;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public QK6(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = 1;
        this.e = 1;
    }

    @Override // ir.nasim.XK6
    public C17072mL6 a(InterfaceC18557or4 interfaceC18557or4, QV qv) {
        QV qvA;
        AbstractC13042fc3.i(interfaceC18557or4, "sample");
        AbstractC13042fc3.i(qv, "profile");
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (jUptimeMillis - this.f > this.b * AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT) {
            this.e = this.d;
        }
        this.f = jUptimeMillis;
        PV pvC = qv.c();
        if (interfaceC18557or4 instanceof InterfaceC18557or4.a) {
            return new C17072mL6(new VZ1(pvC), qv);
        }
        if (!(interfaceC18557or4 instanceof InterfaceC18557or4.b)) {
            throw new NoWhenBranchMatchedException();
        }
        if (((InterfaceC18557or4.b) interfaceC18557or4).b() > this.c) {
            int i = this.g;
            this.g = i + 1;
            if (i >= 5) {
                return new C17072mL6(new VZ1(pvC), qv);
            }
        }
        int i2 = this.e;
        this.e = i2 - 1;
        if (i2 == 0) {
            this.g = 0;
            int i3 = this.d * this.a;
            this.d = i3;
            this.e = i3;
            qvA = qv.a((35 & 1) != 0 ? qv.a : 0L, (35 & 2) != 0 ? qv.b : qv.d() * this.a, (35 & 4) != 0 ? qv.c : 0.0d, (35 & 8) != 0 ? qv.d : 0.0d, (35 & 16) != 0 ? qv.e : 0.0d, (35 & 32) != 0 ? qv.f : null);
        } else {
            qvA = qv;
        }
        return new C17072mL6(this, qvA);
    }

    public String toString() {
        return "StartupState(pace=" + this.d + Separators.RPAREN;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QK6(PV pv) {
        this(pv.i(), pv.j(), pv.e() * 1000000);
        AbstractC13042fc3.i(pv, "optimizerConfiguration");
    }
}
