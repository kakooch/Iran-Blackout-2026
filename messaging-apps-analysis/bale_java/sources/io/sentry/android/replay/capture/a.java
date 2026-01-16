package io.sentry.android.replay.capture;

import android.view.MotionEvent;
import io.sentry.AbstractC3141l;
import io.sentry.C3155n3;
import io.sentry.C3160o3;
import io.sentry.Y2;
import io.sentry.Z;
import io.sentry.android.replay.capture.h;
import io.sentry.android.replay.u;
import io.sentry.protocol.v;
import io.sentry.transport.p;
import ir.nasim.AI5;
import ir.nasim.AbstractC10882cM5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC13610gX0;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C19938rB7;
import ir.nasim.C5942Lm4;
import ir.nasim.ED1;
import ir.nasim.InterfaceC5239Im3;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.SA2;
import ir.nasim.UA2;
import java.util.Date;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public abstract class a implements io.sentry.android.replay.capture.h {
    private final C3155n3 b;
    private final Z c;
    private final p d;
    private final ScheduledExecutorService e;
    private final UA2 f;
    private final InterfaceC9173Yu3 g;
    private final io.sentry.android.replay.gestures.b h;
    private final AtomicBoolean i;
    private io.sentry.android.replay.h j;
    private final AI5 k;
    private final AI5 l;
    private final AtomicLong m;
    private final AI5 n;
    private final AI5 o;
    private final AI5 p;
    private final AI5 q;
    private final Deque r;
    static final /* synthetic */ InterfaceC5239Im3[] t = {AbstractC10882cM5.f(new C5942Lm4(a.class, "recorderConfig", "getRecorderConfig()Lio/sentry/android/replay/ScreenshotRecorderConfig;", 0)), AbstractC10882cM5.f(new C5942Lm4(a.class, "segmentTimestamp", "getSegmentTimestamp()Ljava/util/Date;", 0)), AbstractC10882cM5.f(new C5942Lm4(a.class, "screenAtStart", "getScreenAtStart()Ljava/lang/String;", 0)), AbstractC10882cM5.f(new C5942Lm4(a.class, "currentReplayId", "getCurrentReplayId()Lio/sentry/protocol/SentryId;", 0)), AbstractC10882cM5.f(new C5942Lm4(a.class, "currentSegment", "getCurrentSegment()I", 0)), AbstractC10882cM5.f(new C5942Lm4(a.class, "replayType", "getReplayType()Lio/sentry/SentryReplayEvent$ReplayType;", 0))};
    public static final C0232a s = new C0232a(null);
    public static final int u = 8;

    /* renamed from: io.sentry.android.replay.capture.a$a, reason: collision with other inner class name */
    public static final class C0232a {
        private C0232a() {
        }

        public /* synthetic */ C0232a(ED1 ed1) {
            this();
        }
    }

    private static final class b implements ThreadFactory {
        private int a;

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            AbstractC13042fc3.i(runnable, "r");
            StringBuilder sb = new StringBuilder();
            sb.append("SentryReplayPersister-");
            int i = this.a;
            this.a = i + 1;
            sb.append(i);
            Thread thread = new Thread(runnable, sb.toString());
            thread.setDaemon(true);
            return thread;
        }
    }

    static final class c extends AbstractC8614Ws3 implements SA2 {
        public static final c e = new c();

        c() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ScheduledExecutorService invoke() {
            return Executors.newSingleThreadScheduledExecutor(new b());
        }
    }

    public static final class d implements AI5 {
        private final AtomicReference a;
        final /* synthetic */ a b;
        final /* synthetic */ String c;
        final /* synthetic */ a d;
        final /* synthetic */ String e;

        /* renamed from: io.sentry.android.replay.capture.a$d$a, reason: collision with other inner class name */
        public static final class RunnableC0233a implements Runnable {
            final /* synthetic */ SA2 a;

            public RunnableC0233a(SA2 sa2) {
                this.a = sa2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.invoke();
            }
        }

        public static final class b extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ String e;
            final /* synthetic */ Object f;
            final /* synthetic */ Object g;
            final /* synthetic */ a h;
            final /* synthetic */ String i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str, Object obj, Object obj2, a aVar, String str2) {
                super(0);
                this.e = str;
                this.f = obj;
                this.g = obj2;
                this.h = aVar;
                this.i = str2;
            }

            public final void a() throws Exception {
                Object obj = this.g;
                io.sentry.android.replay.h hVarO = this.h.o();
                if (hVarO != null) {
                    hVarO.s(this.i, String.valueOf(obj));
                }
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() throws Exception {
                a();
                return C19938rB7.a;
            }
        }

        public d(Object obj, a aVar, String str, a aVar2, String str2) {
            this.b = aVar;
            this.c = str;
            this.d = aVar2;
            this.e = str2;
            this.a = new AtomicReference(obj);
        }

        private final void c(SA2 sa2) {
            if (this.b.b.getThreadChecker().a()) {
                io.sentry.android.replay.util.g.e(this.b.q(), this.b.b, "CaptureStrategy.runInBackground", new RunnableC0233a(sa2));
                return;
            }
            try {
                sa2.invoke();
            } catch (Throwable th) {
                this.b.b.getLogger().b(Y2.ERROR, "Failed to execute task CaptureStrategy.runInBackground", th);
            }
        }

        @Override // ir.nasim.AI5, ir.nasim.InterfaceC23661xI5
        public Object a(Object obj, InterfaceC5239Im3 interfaceC5239Im3) {
            AbstractC13042fc3.i(interfaceC5239Im3, "property");
            return this.a.get();
        }

        @Override // ir.nasim.AI5
        public void b(Object obj, InterfaceC5239Im3 interfaceC5239Im3, Object obj2) {
            AbstractC13042fc3.i(interfaceC5239Im3, "property");
            Object andSet = this.a.getAndSet(obj2);
            if (AbstractC13042fc3.d(andSet, obj2)) {
                return;
            }
            c(new b(this.c, andSet, obj2, this.d, this.e));
        }
    }

    public static final class e implements AI5 {
        private final AtomicReference a;
        final /* synthetic */ a b;
        final /* synthetic */ String c;
        final /* synthetic */ a d;
        final /* synthetic */ String e;

        /* renamed from: io.sentry.android.replay.capture.a$e$a, reason: collision with other inner class name */
        public static final class RunnableC0234a implements Runnable {
            final /* synthetic */ SA2 a;

            public RunnableC0234a(SA2 sa2) {
                this.a = sa2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.invoke();
            }
        }

        public static final class b extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ String e;
            final /* synthetic */ Object f;
            final /* synthetic */ Object g;
            final /* synthetic */ a h;
            final /* synthetic */ String i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str, Object obj, Object obj2, a aVar, String str2) {
                super(0);
                this.e = str;
                this.f = obj;
                this.g = obj2;
                this.h = aVar;
                this.i = str2;
            }

            public final void a() throws Exception {
                Object obj = this.g;
                io.sentry.android.replay.h hVarO = this.h.o();
                if (hVarO != null) {
                    hVarO.s(this.i, String.valueOf(obj));
                }
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() throws Exception {
                a();
                return C19938rB7.a;
            }
        }

        public e(Object obj, a aVar, String str, a aVar2, String str2) {
            this.b = aVar;
            this.c = str;
            this.d = aVar2;
            this.e = str2;
            this.a = new AtomicReference(obj);
        }

        private final void c(SA2 sa2) {
            if (this.b.b.getThreadChecker().a()) {
                io.sentry.android.replay.util.g.e(this.b.q(), this.b.b, "CaptureStrategy.runInBackground", new RunnableC0234a(sa2));
                return;
            }
            try {
                sa2.invoke();
            } catch (Throwable th) {
                this.b.b.getLogger().b(Y2.ERROR, "Failed to execute task CaptureStrategy.runInBackground", th);
            }
        }

        @Override // ir.nasim.AI5, ir.nasim.InterfaceC23661xI5
        public Object a(Object obj, InterfaceC5239Im3 interfaceC5239Im3) {
            AbstractC13042fc3.i(interfaceC5239Im3, "property");
            return this.a.get();
        }

        @Override // ir.nasim.AI5
        public void b(Object obj, InterfaceC5239Im3 interfaceC5239Im3, Object obj2) {
            AbstractC13042fc3.i(interfaceC5239Im3, "property");
            Object andSet = this.a.getAndSet(obj2);
            if (AbstractC13042fc3.d(andSet, obj2)) {
                return;
            }
            c(new b(this.c, andSet, obj2, this.d, this.e));
        }
    }

    public static final class f implements AI5 {
        private final AtomicReference a;
        final /* synthetic */ a b;
        final /* synthetic */ String c;
        final /* synthetic */ a d;
        final /* synthetic */ String e;

        /* renamed from: io.sentry.android.replay.capture.a$f$a, reason: collision with other inner class name */
        public static final class RunnableC0235a implements Runnable {
            final /* synthetic */ SA2 a;

            public RunnableC0235a(SA2 sa2) {
                this.a = sa2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.invoke();
            }
        }

        public static final class b extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ String e;
            final /* synthetic */ Object f;
            final /* synthetic */ Object g;
            final /* synthetic */ a h;
            final /* synthetic */ String i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str, Object obj, Object obj2, a aVar, String str2) {
                super(0);
                this.e = str;
                this.f = obj;
                this.g = obj2;
                this.h = aVar;
                this.i = str2;
            }

            public final void a() throws Exception {
                Object obj = this.g;
                io.sentry.android.replay.h hVarO = this.h.o();
                if (hVarO != null) {
                    hVarO.s(this.i, String.valueOf(obj));
                }
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() throws Exception {
                a();
                return C19938rB7.a;
            }
        }

        public f(Object obj, a aVar, String str, a aVar2, String str2) {
            this.b = aVar;
            this.c = str;
            this.d = aVar2;
            this.e = str2;
            this.a = new AtomicReference(obj);
        }

        private final void c(SA2 sa2) {
            if (this.b.b.getThreadChecker().a()) {
                io.sentry.android.replay.util.g.e(this.b.q(), this.b.b, "CaptureStrategy.runInBackground", new RunnableC0235a(sa2));
                return;
            }
            try {
                sa2.invoke();
            } catch (Throwable th) {
                this.b.b.getLogger().b(Y2.ERROR, "Failed to execute task CaptureStrategy.runInBackground", th);
            }
        }

        @Override // ir.nasim.AI5, ir.nasim.InterfaceC23661xI5
        public Object a(Object obj, InterfaceC5239Im3 interfaceC5239Im3) {
            AbstractC13042fc3.i(interfaceC5239Im3, "property");
            return this.a.get();
        }

        @Override // ir.nasim.AI5
        public void b(Object obj, InterfaceC5239Im3 interfaceC5239Im3, Object obj2) {
            AbstractC13042fc3.i(interfaceC5239Im3, "property");
            Object andSet = this.a.getAndSet(obj2);
            if (AbstractC13042fc3.d(andSet, obj2)) {
                return;
            }
            c(new b(this.c, andSet, obj2, this.d, this.e));
        }
    }

    public static final class g implements AI5 {
        private final AtomicReference a;
        final /* synthetic */ a b;
        final /* synthetic */ String c;
        final /* synthetic */ a d;

        /* renamed from: io.sentry.android.replay.capture.a$g$a, reason: collision with other inner class name */
        public static final class RunnableC0236a implements Runnable {
            final /* synthetic */ SA2 a;

            public RunnableC0236a(SA2 sa2) {
                this.a = sa2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.invoke();
            }
        }

        public static final class b extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ String e;
            final /* synthetic */ Object f;
            final /* synthetic */ Object g;
            final /* synthetic */ a h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str, Object obj, Object obj2, a aVar) {
                super(0);
                this.e = str;
                this.f = obj;
                this.g = obj2;
                this.h = aVar;
            }

            public final void a() throws Exception {
                Object obj = this.f;
                u uVar = (u) this.g;
                if (uVar == null) {
                    return;
                }
                io.sentry.android.replay.h hVarO = this.h.o();
                if (hVarO != null) {
                    hVarO.s("config.height", String.valueOf(uVar.c()));
                }
                io.sentry.android.replay.h hVarO2 = this.h.o();
                if (hVarO2 != null) {
                    hVarO2.s("config.width", String.valueOf(uVar.d()));
                }
                io.sentry.android.replay.h hVarO3 = this.h.o();
                if (hVarO3 != null) {
                    hVarO3.s("config.frame-rate", String.valueOf(uVar.b()));
                }
                io.sentry.android.replay.h hVarO4 = this.h.o();
                if (hVarO4 != null) {
                    hVarO4.s("config.bit-rate", String.valueOf(uVar.a()));
                }
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() throws Exception {
                a();
                return C19938rB7.a;
            }
        }

        public g(Object obj, a aVar, String str, a aVar2) {
            this.b = aVar;
            this.c = str;
            this.d = aVar2;
            this.a = new AtomicReference(obj);
        }

        private final void c(SA2 sa2) {
            if (this.b.b.getThreadChecker().a()) {
                io.sentry.android.replay.util.g.e(this.b.q(), this.b.b, "CaptureStrategy.runInBackground", new RunnableC0236a(sa2));
                return;
            }
            try {
                sa2.invoke();
            } catch (Throwable th) {
                this.b.b.getLogger().b(Y2.ERROR, "Failed to execute task CaptureStrategy.runInBackground", th);
            }
        }

        @Override // ir.nasim.AI5, ir.nasim.InterfaceC23661xI5
        public Object a(Object obj, InterfaceC5239Im3 interfaceC5239Im3) {
            AbstractC13042fc3.i(interfaceC5239Im3, "property");
            return this.a.get();
        }

        @Override // ir.nasim.AI5
        public void b(Object obj, InterfaceC5239Im3 interfaceC5239Im3, Object obj2) {
            AbstractC13042fc3.i(interfaceC5239Im3, "property");
            Object andSet = this.a.getAndSet(obj2);
            if (AbstractC13042fc3.d(andSet, obj2)) {
                return;
            }
            c(new b(this.c, andSet, obj2, this.d));
        }
    }

    public static final class h implements AI5 {
        private final AtomicReference a;
        final /* synthetic */ a b;
        final /* synthetic */ String c;
        final /* synthetic */ a d;

        /* renamed from: io.sentry.android.replay.capture.a$h$a, reason: collision with other inner class name */
        public static final class RunnableC0237a implements Runnable {
            final /* synthetic */ SA2 a;

            public RunnableC0237a(SA2 sa2) {
                this.a = sa2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.invoke();
            }
        }

        public static final class b extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ String e;
            final /* synthetic */ Object f;
            final /* synthetic */ Object g;
            final /* synthetic */ a h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str, Object obj, Object obj2, a aVar) {
                super(0);
                this.e = str;
                this.f = obj;
                this.g = obj2;
                this.h = aVar;
            }

            public final void a() throws Exception {
                Object obj = this.f;
                Date date = (Date) this.g;
                io.sentry.android.replay.h hVarO = this.h.o();
                if (hVarO != null) {
                    hVarO.s("segment.timestamp", date == null ? null : AbstractC3141l.h(date));
                }
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() throws Exception {
                a();
                return C19938rB7.a;
            }
        }

        public h(Object obj, a aVar, String str, a aVar2) {
            this.b = aVar;
            this.c = str;
            this.d = aVar2;
            this.a = new AtomicReference(obj);
        }

        private final void c(SA2 sa2) {
            if (this.b.b.getThreadChecker().a()) {
                io.sentry.android.replay.util.g.e(this.b.q(), this.b.b, "CaptureStrategy.runInBackground", new RunnableC0237a(sa2));
                return;
            }
            try {
                sa2.invoke();
            } catch (Throwable th) {
                this.b.b.getLogger().b(Y2.ERROR, "Failed to execute task CaptureStrategy.runInBackground", th);
            }
        }

        @Override // ir.nasim.AI5, ir.nasim.InterfaceC23661xI5
        public Object a(Object obj, InterfaceC5239Im3 interfaceC5239Im3) {
            AbstractC13042fc3.i(interfaceC5239Im3, "property");
            return this.a.get();
        }

        @Override // ir.nasim.AI5
        public void b(Object obj, InterfaceC5239Im3 interfaceC5239Im3, Object obj2) {
            AbstractC13042fc3.i(interfaceC5239Im3, "property");
            Object andSet = this.a.getAndSet(obj2);
            if (AbstractC13042fc3.d(andSet, obj2)) {
                return;
            }
            c(new b(this.c, andSet, obj2, this.d));
        }
    }

    public static final class i implements AI5 {
        private final AtomicReference a;
        final /* synthetic */ a b;
        final /* synthetic */ String c;
        final /* synthetic */ a d;
        final /* synthetic */ String e;

        /* renamed from: io.sentry.android.replay.capture.a$i$a, reason: collision with other inner class name */
        public static final class RunnableC0238a implements Runnable {
            final /* synthetic */ SA2 a;

            public RunnableC0238a(SA2 sa2) {
                this.a = sa2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.invoke();
            }
        }

        public static final class b extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ String e;
            final /* synthetic */ Object f;
            final /* synthetic */ Object g;
            final /* synthetic */ a h;
            final /* synthetic */ String i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str, Object obj, Object obj2, a aVar, String str2) {
                super(0);
                this.e = str;
                this.f = obj;
                this.g = obj2;
                this.h = aVar;
                this.i = str2;
            }

            public final void a() throws Exception {
                Object obj = this.g;
                io.sentry.android.replay.h hVarO = this.h.o();
                if (hVarO != null) {
                    hVarO.s(this.i, String.valueOf(obj));
                }
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() throws Exception {
                a();
                return C19938rB7.a;
            }
        }

        public i(Object obj, a aVar, String str, a aVar2, String str2) {
            this.b = aVar;
            this.c = str;
            this.d = aVar2;
            this.e = str2;
            this.a = new AtomicReference(obj);
        }

        private final void c(SA2 sa2) {
            if (this.b.b.getThreadChecker().a()) {
                io.sentry.android.replay.util.g.e(this.b.q(), this.b.b, "CaptureStrategy.runInBackground", new RunnableC0238a(sa2));
                return;
            }
            try {
                sa2.invoke();
            } catch (Throwable th) {
                this.b.b.getLogger().b(Y2.ERROR, "Failed to execute task CaptureStrategy.runInBackground", th);
            }
        }

        @Override // ir.nasim.AI5, ir.nasim.InterfaceC23661xI5
        public Object a(Object obj, InterfaceC5239Im3 interfaceC5239Im3) {
            AbstractC13042fc3.i(interfaceC5239Im3, "property");
            return this.a.get();
        }

        @Override // ir.nasim.AI5
        public void b(Object obj, InterfaceC5239Im3 interfaceC5239Im3, Object obj2) {
            AbstractC13042fc3.i(interfaceC5239Im3, "property");
            Object andSet = this.a.getAndSet(obj2);
            if (AbstractC13042fc3.d(andSet, obj2)) {
                return;
            }
            c(new b(this.c, andSet, obj2, this.d, this.e));
        }
    }

    public a(C3155n3 c3155n3, Z z, p pVar, ScheduledExecutorService scheduledExecutorService, UA2 ua2) {
        AbstractC13042fc3.i(c3155n3, "options");
        AbstractC13042fc3.i(pVar, "dateProvider");
        AbstractC13042fc3.i(scheduledExecutorService, "replayExecutor");
        this.b = c3155n3;
        this.c = z;
        this.d = pVar;
        this.e = scheduledExecutorService;
        this.f = ua2;
        this.g = AbstractC13269fw3.a(c.e);
        this.h = new io.sentry.android.replay.gestures.b(pVar);
        this.i = new AtomicBoolean(false);
        this.k = new g(null, this, "", this);
        this.l = new h(null, this, "segment.timestamp", this);
        this.m = new AtomicLong();
        this.n = new i(null, this, "replay.screen-at-start", this, "replay.screen-at-start");
        this.o = new d(v.b, this, "replay.id", this, "replay.id");
        this.p = new e(-1, this, "segment.id", this, "segment.id");
        this.q = new f(null, this, "replay.type", this, "replay.type");
        this.r = new ConcurrentLinkedDeque();
    }

    public static /* synthetic */ h.c n(a aVar, long j, Date date, v vVar, int i2, int i3, int i4, int i5, int i6, C3160o3.b bVar, io.sentry.android.replay.h hVar, String str, List list, Deque deque, int i7, Object obj) {
        if (obj == null) {
            return aVar.m(j, date, vVar, i2, i3, i4, i5, i6, (i7 & 256) != 0 ? aVar.u() : bVar, (i7 & 512) != 0 ? aVar.j : hVar, (i7 & 1024) != 0 ? aVar.w() : str, (i7 & 2048) != 0 ? null : list, (i7 & 4096) != 0 ? aVar.r : deque);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createSegmentInternal");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ScheduledExecutorService q() {
        Object value = this.g.getValue();
        AbstractC13042fc3.h(value, "<get-persistingExecutor>(...)");
        return (ScheduledExecutorService) value;
    }

    public void A(v vVar) {
        AbstractC13042fc3.i(vVar, "<set-?>");
        this.o.b(this, t[3], vVar);
    }

    protected final void B(u uVar) {
        this.k.b(this, t[0], uVar);
    }

    public void C(C3160o3.b bVar) {
        AbstractC13042fc3.i(bVar, "<set-?>");
        this.q.b(this, t[5], bVar);
    }

    protected final void D(String str) {
        this.n.b(this, t[2], str);
    }

    @Override // io.sentry.android.replay.capture.h
    public void a(MotionEvent motionEvent) {
        List listA;
        AbstractC13042fc3.i(motionEvent, "event");
        u uVarR = r();
        if (uVarR == null || (listA = this.h.a(motionEvent, uVarR)) == null) {
            return;
        }
        AbstractC13610gX0.D(this.r, listA);
    }

    @Override // io.sentry.android.replay.capture.h
    public v c() {
        return (v) this.o.a(this, t[3]);
    }

    @Override // io.sentry.android.replay.capture.h
    public void d(int i2) {
        this.p.b(this, t[4], Integer.valueOf(i2));
    }

    @Override // io.sentry.android.replay.capture.h
    public int e() {
        return ((Number) this.p.a(this, t[4])).intValue();
    }

    @Override // io.sentry.android.replay.capture.h
    public void h() {
    }

    @Override // io.sentry.android.replay.capture.h
    public void i(int i2, v vVar, C3160o3.b bVar) {
        io.sentry.android.replay.h hVar;
        AbstractC13042fc3.i(vVar, "replayId");
        UA2 ua2 = this.f;
        if (ua2 == null || (hVar = (io.sentry.android.replay.h) ua2.invoke(vVar)) == null) {
            hVar = new io.sentry.android.replay.h(this.b, vVar);
        }
        this.j = hVar;
        A(vVar);
        d(i2);
        if (bVar == null) {
            bVar = this instanceof m ? C3160o3.b.SESSION : C3160o3.b.BUFFER;
        }
        C(bVar);
        j(AbstractC3141l.d());
        this.m.set(this.d.a());
    }

    @Override // io.sentry.android.replay.capture.h
    public void j(Date date) {
        this.l.b(this, t[1], date);
    }

    protected final h.c m(long j, Date date, v vVar, int i2, int i3, int i4, int i5, int i6, C3160o3.b bVar, io.sentry.android.replay.h hVar, String str, List list, Deque deque) {
        AbstractC13042fc3.i(date, "currentSegmentTimestamp");
        AbstractC13042fc3.i(vVar, "replayId");
        AbstractC13042fc3.i(bVar, "replayType");
        AbstractC13042fc3.i(deque, "events");
        return io.sentry.android.replay.capture.h.a.c(this.c, this.b, j, date, vVar, i2, i3, i4, bVar, hVar, i5, i6, str, list, deque);
    }

    protected final io.sentry.android.replay.h o() {
        return this.j;
    }

    protected final Deque p() {
        return this.r;
    }

    protected final u r() {
        return (u) this.k.a(this, t[0]);
    }

    protected final ScheduledExecutorService s() {
        return this.e;
    }

    @Override // io.sentry.android.replay.capture.h
    public void stop() throws Exception {
        io.sentry.android.replay.h hVar = this.j;
        if (hVar != null) {
            hVar.close();
        }
        this.m.set(0L);
        j(null);
        v vVar = v.b;
        AbstractC13042fc3.h(vVar, "EMPTY_ID");
        A(vVar);
    }

    protected final AtomicLong t() {
        return this.m;
    }

    public C3160o3.b u() {
        return (C3160o3.b) this.q.a(this, t[5]);
    }

    @Override // io.sentry.android.replay.capture.h
    public void v() {
        j(AbstractC3141l.d());
    }

    protected final String w() {
        return (String) this.n.a(this, t[2]);
    }

    @Override // io.sentry.android.replay.capture.h
    public void x(u uVar) {
        AbstractC13042fc3.i(uVar, "recorderConfig");
        B(uVar);
    }

    public Date y() {
        return (Date) this.l.a(this, t[1]);
    }

    protected final AtomicBoolean z() {
        return this.i;
    }
}
