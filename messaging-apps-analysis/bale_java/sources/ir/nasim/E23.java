package ir.nasim;

import android.util.Size;
import androidx.camera.core.e;
import androidx.camera.core.impl.i;
import androidx.camera.core.impl.v;
import ir.nasim.QF0;
import java.util.Objects;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class E23 {
    static final C21417td2 f = new C21417td2();
    private final androidx.camera.core.impl.m a;
    private final androidx.camera.core.impl.i b;
    private final QF0 c;
    private final C11982ds5 d;
    private final QF0.c e;

    public E23(androidx.camera.core.impl.m mVar, Size size, YC0 yc0, boolean z, Size size2, int i) {
        AbstractC17949np7.a();
        this.a = mVar;
        this.b = i.a.i(mVar).h();
        QF0 qf0 = new QF0();
        this.c = qf0;
        Executor executorZ = mVar.Z(AbstractC20567sE0.b());
        Objects.requireNonNull(executorZ);
        C11982ds5 c11982ds5 = new C11982ds5(executorZ, null);
        this.d = c11982ds5;
        int inputFormat = mVar.getInputFormat();
        int iD = d();
        mVar.Y();
        QF0.c cVarL = QF0.c.l(size, inputFormat, iD, z, null, size2, i);
        this.e = cVarL;
        c11982ds5.x(qf0.v(cVarL));
    }

    private int d() {
        Integer num = (Integer) this.a.g(androidx.camera.core.impl.m.L, null);
        if (num != null) {
            return num.intValue();
        }
        Integer num2 = (Integer) this.a.g(androidx.camera.core.impl.n.h, null);
        return (num2 == null || num2.intValue() != 4101) ? 256 : 4101;
    }

    public void a() {
        AbstractC17949np7.a();
        this.c.r();
        this.d.v();
    }

    public v.b b(Size size) {
        v.b bVarP = v.b.p(this.a, size);
        bVarP.h(this.e.j());
        if (this.e.g() != null) {
            bVarP.u(this.e.g());
        }
        return bVarP;
    }

    public int c() {
        AbstractC17949np7.a();
        return this.c.h();
    }

    public void e(e.a aVar) {
        AbstractC17949np7.a();
        this.c.u(aVar);
    }
}
