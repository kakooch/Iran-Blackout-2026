package io.sentry.android.replay.capture;

import android.graphics.Bitmap;
import io.sentry.C3155n3;
import io.sentry.C3160o3;
import io.sentry.D1;
import io.sentry.X;
import io.sentry.Y2;
import io.sentry.Z;
import io.sentry.android.replay.capture.h;
import io.sentry.android.replay.u;
import io.sentry.protocol.v;
import io.sentry.transport.p;
import io.sentry.util.AbstractC3209h;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C19938rB7;
import ir.nasim.ED1;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.UA2;
import java.io.File;
import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes3.dex */
public final class m extends io.sentry.android.replay.capture.a {
    public static final a y = new a(null);
    public static final int z = 8;
    private final C3155n3 v;
    private final Z w;
    private final p x;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        b() {
            super(1);
        }

        public final void a(h.c cVar) {
            AbstractC13042fc3.i(cVar, "segment");
            if (cVar instanceof h.c.a) {
                h.c.a aVar = (h.c.a) cVar;
                h.c.a.b(aVar, m.this.w, null, 2, null);
                m mVar = m.this;
                mVar.d(mVar.e() + 1);
                m.this.j(aVar.c().h0());
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((h.c) obj);
            return C19938rB7.a;
        }
    }

    static final class c extends AbstractC8614Ws3 implements UA2 {
        c() {
            super(1);
        }

        public final void a(h.c cVar) {
            AbstractC13042fc3.i(cVar, "segment");
            if (cVar instanceof h.c.a) {
                h.c.a.b((h.c.a) cVar, m.this.w, null, 2, null);
                m mVar = m.this;
                mVar.d(mVar.e() + 1);
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((h.c) obj);
            return C19938rB7.a;
        }
    }

    static final class d extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ File f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(File file) {
            super(1);
            this.f = file;
        }

        public final void a(h.c cVar) {
            AbstractC13042fc3.i(cVar, "segment");
            if (cVar instanceof h.c.a) {
                h.c.a.b((h.c.a) cVar, m.this.w, null, 2, null);
            }
            m.this.d(-1);
            AbstractC3209h.a(this.f);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((h.c) obj);
            return C19938rB7.a;
        }
    }

    public /* synthetic */ m(C3155n3 c3155n3, Z z2, p pVar, ScheduledExecutorService scheduledExecutorService, UA2 ua2, int i, ED1 ed1) {
        this(c3155n3, z2, pVar, scheduledExecutorService, (i & 16) != 0 ? null : ua2);
    }

    private final void J(String str, final UA2 ua2) {
        final u uVarR = r();
        if (uVarR == null) {
            this.v.getLogger().c(Y2.DEBUG, "Recorder config is not set, not creating segment for task: " + str, new Object[0]);
            return;
        }
        long jA = this.x.a();
        final Date dateY = y();
        if (dateY == null) {
            return;
        }
        final long time = jA - dateY.getTime();
        final v vVarC = c();
        io.sentry.android.replay.util.g.e(s(), this.v, "SessionCaptureStrategy." + str, new Runnable() { // from class: io.sentry.android.replay.capture.i
            @Override // java.lang.Runnable
            public final void run() {
                m.K(this.a, time, dateY, vVarC, uVarR, ua2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(m mVar, long j, Date date, v vVar, u uVar, UA2 ua2) {
        AbstractC13042fc3.i(mVar, "this$0");
        AbstractC13042fc3.i(date, "$currentSegmentTimestamp");
        AbstractC13042fc3.i(vVar, "$replayId");
        AbstractC13042fc3.i(ua2, "$onSegmentCreated");
        ua2.invoke(io.sentry.android.replay.capture.a.n(mVar, j, date, vVar, mVar.e(), uVar.c(), uVar.d(), uVar.b(), uVar.a(), null, null, null, null, null, 7936, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(m mVar, InterfaceC14603iB2 interfaceC14603iB2, long j, u uVar) {
        m mVar2;
        AbstractC13042fc3.i(mVar, "this$0");
        AbstractC13042fc3.i(interfaceC14603iB2, "$store");
        io.sentry.android.replay.h hVarO = mVar.o();
        if (hVarO != null) {
            interfaceC14603iB2.invoke(hVarO, Long.valueOf(j));
        }
        Date dateY = mVar.y();
        if (dateY == null) {
            mVar.v.getLogger().c(Y2.DEBUG, "Segment timestamp is not set, not recording frame", new Object[0]);
            return;
        }
        if (mVar.z().get()) {
            mVar.v.getLogger().c(Y2.DEBUG, "Not capturing segment, because the app is terminating, will be captured on next launch", new Object[0]);
            return;
        }
        if (uVar == null) {
            mVar.v.getLogger().c(Y2.DEBUG, "Recorder config is not set, not recording frame", new Object[0]);
            return;
        }
        long jA = mVar.x.a();
        if (jA - dateY.getTime() >= mVar.v.getSessionReplay().l()) {
            h.c cVarN = io.sentry.android.replay.capture.a.n(mVar, mVar.v.getSessionReplay().l(), dateY, mVar.c(), mVar.e(), uVar.c(), uVar.d(), uVar.b(), uVar.a(), null, null, null, null, null, 7936, null);
            if (cVarN instanceof h.c.a) {
                h.c.a aVar = (h.c.a) cVarN;
                mVar2 = mVar;
                h.c.a.b(aVar, mVar2.w, null, 2, null);
                mVar2.d(mVar.e() + 1);
                mVar2.j(aVar.c().h0());
            } else {
                mVar2 = mVar;
            }
        } else {
            mVar2 = mVar;
        }
        if (jA - mVar.t().get() >= mVar2.v.getSessionReplay().j()) {
            mVar2.v.getReplayController().stop();
            mVar2.v.getLogger().c(Y2.INFO, "Session replay deadline exceeded (1h), stopping recording", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(m mVar, X x) {
        AbstractC13042fc3.i(mVar, "this$0");
        AbstractC13042fc3.i(x, "it");
        x.k(mVar.c());
        String strS = x.s();
        mVar.D(strS != null ? AbstractC20762sZ6.c1(strS, '.', null, 2, null) : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(X x) {
        AbstractC13042fc3.i(x, "it");
        x.k(v.b);
    }

    @Override // io.sentry.android.replay.capture.h
    public void b(Bitmap bitmap, final InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(interfaceC14603iB2, "store");
        final u uVarR = r();
        final long jA = this.x.a();
        io.sentry.android.replay.util.g.e(s(), this.v, "SessionCaptureStrategy.add_frame", new Runnable() { // from class: io.sentry.android.replay.capture.l
            @Override // java.lang.Runnable
            public final void run() {
                m.L(this.a, interfaceC14603iB2, jA, uVarR);
            }
        });
    }

    @Override // io.sentry.android.replay.capture.h
    public void f(boolean z2, UA2 ua2) {
        AbstractC13042fc3.i(ua2, "onSegmentSent");
        if (this.v.getSessionReplay().o()) {
            this.v.getLogger().c(Y2.DEBUG, "Replay is already running in 'session' mode, not capturing for event", new Object[0]);
        }
        z().set(z2);
    }

    @Override // io.sentry.android.replay.capture.h
    public h g() {
        return this;
    }

    @Override // io.sentry.android.replay.capture.a, io.sentry.android.replay.capture.h
    public void h() {
        J("pause", new c());
        super.h();
    }

    @Override // io.sentry.android.replay.capture.a, io.sentry.android.replay.capture.h
    public void i(int i, v vVar, C3160o3.b bVar) {
        AbstractC13042fc3.i(vVar, "replayId");
        super.i(i, vVar, bVar);
        Z z2 = this.w;
        if (z2 != null) {
            z2.z(new D1() { // from class: io.sentry.android.replay.capture.j
                @Override // io.sentry.D1
                public final void a(X x) {
                    m.M(this.a, x);
                }
            });
        }
    }

    @Override // io.sentry.android.replay.capture.a, io.sentry.android.replay.capture.h
    public void stop() throws Exception {
        io.sentry.android.replay.h hVarO = o();
        J("stop", new d(hVarO != null ? hVarO.q() : null));
        Z z2 = this.w;
        if (z2 != null) {
            z2.z(new D1() { // from class: io.sentry.android.replay.capture.k
                @Override // io.sentry.D1
                public final void a(X x) {
                    m.N(x);
                }
            });
        }
        super.stop();
    }

    @Override // io.sentry.android.replay.capture.a, io.sentry.android.replay.capture.h
    public void x(u uVar) {
        AbstractC13042fc3.i(uVar, "recorderConfig");
        J("onConfigurationChanged", new b());
        super.x(uVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(C3155n3 c3155n3, Z z2, p pVar, ScheduledExecutorService scheduledExecutorService, UA2 ua2) {
        super(c3155n3, z2, pVar, scheduledExecutorService, ua2);
        AbstractC13042fc3.i(c3155n3, "options");
        AbstractC13042fc3.i(pVar, "dateProvider");
        AbstractC13042fc3.i(scheduledExecutorService, "executor");
        this.v = c3155n3;
        this.w = z2;
        this.x = pVar;
    }
}
