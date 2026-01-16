package androidx.work.impl;

import android.content.Context;
import androidx.work.impl.a;
import ir.nasim.C13405gA2;
import ir.nasim.C26;
import ir.nasim.D26;
import ir.nasim.InterfaceC11606dI1;
import ir.nasim.InterfaceC11816db8;
import ir.nasim.InterfaceC12694f27;
import ir.nasim.InterfaceC13330g27;
import ir.nasim.InterfaceC13655gb8;
import ir.nasim.InterfaceC14943ik5;
import ir.nasim.InterfaceC18401ob8;
import ir.nasim.InterfaceC20190rb8;
import ir.nasim.P47;
import ir.nasim.Qa8;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public abstract class WorkDatabase extends D26 {
    private static final long p = TimeUnit.DAYS.toMillis(1);

    class a implements InterfaceC13330g27.c {
        final /* synthetic */ Context a;

        a(Context context) {
            this.a = context;
        }

        @Override // ir.nasim.InterfaceC13330g27.c
        public InterfaceC13330g27 a(InterfaceC13330g27.b bVar) {
            InterfaceC13330g27.b.a aVarA = InterfaceC13330g27.b.a(this.a);
            aVarA.c(bVar.b).b(bVar.c).d(true);
            return new C13405gA2().a(aVarA.a());
        }
    }

    class b extends D26.b {
        b() {
        }

        @Override // ir.nasim.D26.b
        public void c(InterfaceC12694f27 interfaceC12694f27) {
            super.c(interfaceC12694f27);
            interfaceC12694f27.I();
            try {
                interfaceC12694f27.O(WorkDatabase.L());
                interfaceC12694f27.h0();
            } finally {
                interfaceC12694f27.t0();
            }
        }
    }

    public static WorkDatabase H(Context context, Executor executor, boolean z) {
        D26.a aVarA;
        if (z) {
            aVarA = C26.c(context, WorkDatabase.class).d();
        } else {
            aVarA = C26.a(context, WorkDatabase.class, Qa8.d());
            aVarA.h(new a(context));
        }
        return (WorkDatabase) aVarA.i(executor).a(J()).b(androidx.work.impl.a.a).b(new a.h(context, 2, 3)).b(androidx.work.impl.a.b).b(androidx.work.impl.a.c).b(new a.h(context, 5, 6)).b(androidx.work.impl.a.d).b(androidx.work.impl.a.e).b(androidx.work.impl.a.f).b(new a.i(context)).b(new a.h(context, 10, 11)).b(androidx.work.impl.a.g).g().e();
    }

    static D26.b J() {
        return new b();
    }

    static long K() {
        return System.currentTimeMillis() - p;
    }

    static String L() {
        return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (period_start_time + minimum_retention_duration) < " + K() + " AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
    }

    public abstract InterfaceC11606dI1 I();

    public abstract InterfaceC14943ik5 M();

    public abstract P47 N();

    public abstract InterfaceC11816db8 O();

    public abstract InterfaceC13655gb8 P();

    public abstract InterfaceC18401ob8 Q();

    public abstract InterfaceC20190rb8 R();
}
