package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.InterfaceC18557or4;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Qv1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C7230Qv1 implements XK6 {
    private static final a e = new a(null);
    private final int a;
    private final int b;
    private int c;
    private Boolean d;

    /* renamed from: ir.nasim.Qv1$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C7230Qv1(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    @Override // ir.nasim.XK6
    public C17072mL6 a(InterfaceC18557or4 interfaceC18557or4, QV qv) {
        C17072mL6 c17072mL6;
        AbstractC13042fc3.i(interfaceC18557or4, "sample");
        AbstractC13042fc3.i(qv, "profile");
        PV pvC = qv.c();
        if (interfaceC18557or4 instanceof InterfaceC18557or4.a) {
            return new C17072mL6(new VZ1(pvC), qv);
        }
        if (!(interfaceC18557or4 instanceof InterfaceC18557or4.b)) {
            throw new NoWhenBranchMatchedException();
        }
        InterfaceC18557or4.b bVar = (InterfaceC18557or4.b) interfaceC18557or4;
        if (bVar.b() <= pvC.g() && qv.d() <= pvC.h()) {
            return new C17072mL6(new QK6(pvC), qv);
        }
        int i = this.c;
        this.c = i + 1;
        if (i < 20) {
            this.d = null;
            return new C17072mL6(this, qv);
        }
        this.c = 0;
        if (bVar.b() > this.b) {
            this.d = Boolean.FALSE;
            c17072mL6 = new C17072mL6(this, qv.a((35 & 1) != 0 ? qv.a : 0L, (35 & 2) != 0 ? qv.b : qv.d() - this.a, (35 & 4) != 0 ? qv.c : 0.0d, (35 & 8) != 0 ? qv.d : 0.0d, (35 & 16) != 0 ? qv.e : 0.0d, (35 & 32) != 0 ? qv.f : null));
        } else {
            this.d = Boolean.TRUE;
            c17072mL6 = new C17072mL6(this, qv.a((35 & 1) != 0 ? qv.a : 0L, (35 & 2) != 0 ? qv.b : qv.d() + this.a, (35 & 4) != 0 ? qv.c : 0.0d, (35 & 8) != 0 ? qv.d : 0.0d, (35 & 16) != 0 ? qv.e : 0.0d, (35 & 32) != 0 ? qv.f : null));
        }
        return c17072mL6;
    }

    public String toString() {
        String str;
        Boolean bool = this.d;
        if (AbstractC13042fc3.d(bool, Boolean.TRUE)) {
            str = "↑";
        } else if (AbstractC13042fc3.d(bool, Boolean.FALSE)) {
            str = "↓";
        } else {
            if (bool != null) {
                throw new NoWhenBranchMatchedException();
            }
            str = "-";
        }
        return "CruiseState(" + str + Separators.RPAREN;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C7230Qv1(PV pv) {
        this(pv.b(), pv.e() * 1000000);
        AbstractC13042fc3.i(pv, "optimizerConfiguration");
    }
}
