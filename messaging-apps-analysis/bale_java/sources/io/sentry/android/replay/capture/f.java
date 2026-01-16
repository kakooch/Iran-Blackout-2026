package io.sentry.android.replay.capture;

import android.graphics.Bitmap;
import android.view.MotionEvent;
import io.sentry.AbstractC3141l;
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
import io.sentry.util.x;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13610gX0;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C19938rB7;
import ir.nasim.C9663aL5;
import ir.nasim.ED1;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.UA2;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes3.dex */
public final class f extends io.sentry.android.replay.capture.a {
    public static final a A = new a(null);
    public static final int B = 8;
    private final C3155n3 v;
    private final Z w;
    private final p x;
    private final x y;
    private final List z;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(UA2 ua2) {
            super(1);
            this.f = ua2;
        }

        public final void a(h.c cVar) throws InterruptedException {
            AbstractC13042fc3.i(cVar, "segment");
            f fVar = f.this;
            fVar.M(fVar.z);
            if (cVar instanceof h.c.a) {
                h.c.a aVar = (h.c.a) cVar;
                h.c.a.b(aVar, f.this.w, null, 2, null);
                UA2 ua2 = this.f;
                Date dateH0 = aVar.c().h0();
                AbstractC13042fc3.h(dateH0, "segment.replay.timestamp");
                ua2.invoke(dateH0);
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) throws InterruptedException {
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
                f.this.z.add(cVar);
                f fVar = f.this;
                fVar.d(fVar.e() + 1);
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((h.c) obj);
            return C19938rB7.a;
        }
    }

    static final class d extends AbstractC8614Ws3 implements UA2 {
        d() {
            super(1);
        }

        public final void a(h.c cVar) {
            AbstractC13042fc3.i(cVar, "segment");
            if (cVar instanceof h.c.a) {
                f.this.z.add(cVar);
                f fVar = f.this;
                fVar.d(fVar.e() + 1);
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((h.c) obj);
            return C19938rB7.a;
        }
    }

    static final class e extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ long e;
        final /* synthetic */ f f;
        final /* synthetic */ C9663aL5 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(long j, f fVar, C9663aL5 c9663aL5) {
            super(1);
            this.e = j;
            this.f = fVar;
            this.g = c9663aL5;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(h.c.a aVar) {
            AbstractC13042fc3.i(aVar, "it");
            if (aVar.c().h0().getTime() >= this.e) {
                return Boolean.FALSE;
            }
            this.f.d(r0.e() - 1);
            this.f.Q(aVar.c().i0());
            this.g.a = true;
            return Boolean.TRUE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(C3155n3 c3155n3, Z z, p pVar, x xVar, ScheduledExecutorService scheduledExecutorService, UA2 ua2) {
        super(c3155n3, z, pVar, scheduledExecutorService, ua2);
        AbstractC13042fc3.i(c3155n3, "options");
        AbstractC13042fc3.i(pVar, "dateProvider");
        AbstractC13042fc3.i(xVar, "random");
        AbstractC13042fc3.i(scheduledExecutorService, "executor");
        this.v = c3155n3;
        this.w = z;
        this.x = pVar;
        this.y = xVar;
        this.z = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(List list) throws InterruptedException {
        h.c.a aVar = (h.c.a) AbstractC13610gX0.M(list);
        while (aVar != null) {
            h.c.a.b(aVar, this.w, null, 2, null);
            aVar = (h.c.a) AbstractC13610gX0.M(list);
            Thread.sleep(100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(f fVar, X x) {
        AbstractC13042fc3.i(fVar, "this$0");
        AbstractC13042fc3.i(x, "it");
        x.k(fVar.c());
    }

    private final void O(String str, final UA2 ua2) {
        Date dateE;
        List listN;
        final u uVarR = r();
        if (uVarR == null) {
            this.v.getLogger().c(Y2.DEBUG, "Recorder config is not set, not creating segment for task: " + str, new Object[0]);
            return;
        }
        long jC = this.v.getSessionReplay().c();
        long jA = this.x.a();
        io.sentry.android.replay.h hVarO = o();
        if (hVarO == null || (listN = hVarO.n()) == null || !(!listN.isEmpty())) {
            dateE = AbstractC3141l.e(jA - jC);
        } else {
            io.sentry.android.replay.h hVarO2 = o();
            AbstractC13042fc3.f(hVarO2);
            dateE = AbstractC3141l.e(((io.sentry.android.replay.i) AbstractC15401jX0.q0(hVarO2.n())).c());
        }
        final Date date = dateE;
        AbstractC13042fc3.h(date, "if (cache?.frames?.isNot…orReplayDuration)\n      }");
        final long time = jA - date.getTime();
        final v vVarC = c();
        io.sentry.android.replay.util.g.e(s(), this.v, "BufferCaptureStrategy." + str, new Runnable() { // from class: io.sentry.android.replay.capture.b
            @Override // java.lang.Runnable
            public final void run() {
                f.P(this.a, time, date, vVarC, uVarR, ua2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(f fVar, long j, Date date, v vVar, u uVar, UA2 ua2) {
        AbstractC13042fc3.i(fVar, "this$0");
        AbstractC13042fc3.i(date, "$currentSegmentTimestamp");
        AbstractC13042fc3.i(vVar, "$replayId");
        AbstractC13042fc3.i(ua2, "$onSegmentCreated");
        ua2.invoke(io.sentry.android.replay.capture.a.n(fVar, j, date, vVar, fVar.e(), uVar.c(), uVar.d(), uVar.b(), uVar.a(), null, null, null, null, null, 7936, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q(File file) {
        if (file == null) {
            return;
        }
        try {
            if (file.delete()) {
                return;
            }
            this.v.getLogger().c(Y2.ERROR, "Failed to delete replay segment: %s", file.getAbsolutePath());
        } catch (Throwable th) {
            this.v.getLogger().a(Y2.ERROR, th, "Failed to delete replay segment: %s", file.getAbsolutePath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(f fVar, InterfaceC14603iB2 interfaceC14603iB2, long j) {
        AbstractC13042fc3.i(fVar, "this$0");
        AbstractC13042fc3.i(interfaceC14603iB2, "$store");
        io.sentry.android.replay.h hVarO = fVar.o();
        if (hVarO != null) {
            interfaceC14603iB2.invoke(hVarO, Long.valueOf(j));
        }
        long jA = fVar.x.a() - fVar.v.getSessionReplay().c();
        io.sentry.android.replay.h hVarO2 = fVar.o();
        fVar.D(hVarO2 != null ? hVarO2.u(jA) : null);
        fVar.S(fVar.z, jA);
    }

    private final void S(List list, long j) {
        C9663aL5 c9663aL5 = new C9663aL5();
        AbstractC13610gX0.K(list, new e(j, this, c9663aL5));
        if (c9663aL5.a) {
            int i = 0;
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    AbstractC10360bX0.w();
                }
                ((h.c.a) obj).d(i);
                i = i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(File file, f fVar) {
        AbstractC13042fc3.i(fVar, "this$0");
        AbstractC3209h.a(file);
        fVar.d(-1);
    }

    @Override // io.sentry.android.replay.capture.a, io.sentry.android.replay.capture.h
    public void a(MotionEvent motionEvent) {
        AbstractC13042fc3.i(motionEvent, "event");
        super.a(motionEvent);
        h.a.h(h.a, p(), this.x.a() - this.v.getSessionReplay().c(), null, 4, null);
    }

    @Override // io.sentry.android.replay.capture.h
    public void b(Bitmap bitmap, final InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(interfaceC14603iB2, "store");
        final long jA = this.x.a();
        io.sentry.android.replay.util.g.e(s(), this.v, "BufferCaptureStrategy.add_frame", new Runnable() { // from class: io.sentry.android.replay.capture.e
            @Override // java.lang.Runnable
            public final void run() {
                f.R(this.a, interfaceC14603iB2, jA);
            }
        });
    }

    @Override // io.sentry.android.replay.capture.h
    public void f(boolean z, UA2 ua2) {
        AbstractC13042fc3.i(ua2, "onSegmentSent");
        if (!io.sentry.android.replay.util.l.a(this.y, this.v.getSessionReplay().g())) {
            this.v.getLogger().c(Y2.INFO, "Replay wasn't sampled by onErrorSampleRate, not capturing for event", new Object[0]);
            return;
        }
        Z z2 = this.w;
        if (z2 != null) {
            z2.z(new D1() { // from class: io.sentry.android.replay.capture.c
                @Override // io.sentry.D1
                public final void a(X x) {
                    f.N(this.a, x);
                }
            });
        }
        if (!z) {
            O("capture_replay", new b(ua2));
        } else {
            z().set(true);
            this.v.getLogger().c(Y2.DEBUG, "Not capturing replay for crashed event, will be captured on next launch", new Object[0]);
        }
    }

    @Override // io.sentry.android.replay.capture.h
    public h g() {
        if (z().get()) {
            this.v.getLogger().c(Y2.DEBUG, "Not converting to session mode, because the process is about to terminate", new Object[0]);
            return this;
        }
        m mVar = new m(this.v, this.w, this.x, s(), null, 16, null);
        mVar.i(e(), c(), C3160o3.b.BUFFER);
        return mVar;
    }

    @Override // io.sentry.android.replay.capture.a, io.sentry.android.replay.capture.h
    public void h() {
        O("pause", new d());
        super.h();
    }

    @Override // io.sentry.android.replay.capture.a, io.sentry.android.replay.capture.h
    public void stop() throws Exception {
        io.sentry.android.replay.h hVarO = o();
        final File fileQ = hVarO != null ? hVarO.q() : null;
        io.sentry.android.replay.util.g.e(s(), this.v, "BufferCaptureStrategy.stop", new Runnable() { // from class: io.sentry.android.replay.capture.d
            @Override // java.lang.Runnable
            public final void run() {
                f.T(fileQ, this);
            }
        });
        super.stop();
    }

    @Override // io.sentry.android.replay.capture.a, io.sentry.android.replay.capture.h
    public void x(u uVar) {
        AbstractC13042fc3.i(uVar, "recorderConfig");
        O("configuration_changed", new c());
        super.x(uVar);
    }
}
