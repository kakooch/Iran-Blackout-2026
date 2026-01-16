package io.sentry.android.replay;

import android.content.Context;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.MotionEvent;
import io.sentry.C3155n3;
import io.sentry.C3165p3;
import io.sentry.D1;
import io.sentry.EnumC3136k;
import io.sentry.I;
import io.sentry.InterfaceC3097c0;
import io.sentry.InterfaceC3102d0;
import io.sentry.InterfaceC3157o0;
import io.sentry.InterfaceC3212v1;
import io.sentry.InterfaceC3217w1;
import io.sentry.M0;
import io.sentry.N;
import io.sentry.W2;
import io.sentry.X;
import io.sentry.Y2;
import io.sentry.Z;
import io.sentry.android.replay.capture.h;
import io.sentry.android.replay.h;
import io.sentry.android.replay.u;
import io.sentry.transport.A;
import io.sentry.util.AbstractC3209h;
import io.sentry.util.C3202a;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC14155hS;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C12889fL5;
import ir.nasim.C19938rB7;
import ir.nasim.ED1;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.SA2;
import ir.nasim.UA2;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 -2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b:\u0003KC'BA\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0010¢\u0006\u0004\b\u0014\u0010\u0015B\u0019\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001b\u0010\u0019J\u000f\u0010\u001c\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001c\u0010\u0019J\u000f\u0010\u001d\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001d\u0010\u0019J\u0019\u0010 \u001a\u00020\u00172\b\b\u0002\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\"\u0010\u0019J\u001f\u0010'\u001a\u00020\u00172\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0017H\u0016¢\u0006\u0004\b,\u0010\u0019J\u000f\u0010-\u001a\u00020\u0017H\u0016¢\u0006\u0004\b-\u0010\u0019J\u0019\u0010/\u001a\u00020\u00172\b\u0010.\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0011H\u0016¢\u0006\u0004\b1\u00102J\u0017\u00105\u001a\u00020\u00172\u0006\u00104\u001a\u000203H\u0016¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u000203H\u0016¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\u0017H\u0016¢\u0006\u0004\b9\u0010\u0019J\u000f\u0010:\u001a\u00020)H\u0016¢\u0006\u0004\b:\u0010+J\u000f\u0010;\u001a\u00020\u0017H\u0016¢\u0006\u0004\b;\u0010\u0019J\u0017\u0010>\u001a\u00020\u00172\u0006\u0010=\u001a\u00020<H\u0016¢\u0006\u0004\b>\u0010?J\u000f\u0010@\u001a\u00020\u0017H\u0016¢\u0006\u0004\b@\u0010\u0019J\u0017\u0010C\u001a\u00020\u00172\u0006\u0010B\u001a\u00020AH\u0016¢\u0006\u0004\bC\u0010DJ\u0017\u0010G\u001a\u00020\u00172\u0006\u0010F\u001a\u00020EH\u0016¢\u0006\u0004\bG\u0010HJ\u0017\u0010K\u001a\u00020\u00172\u0006\u0010J\u001a\u00020IH\u0016¢\u0006\u0004\bK\u0010LJ\u001f\u0010P\u001a\u00020\u00172\u0006\u0010N\u001a\u00020M2\u0006\u0010O\u001a\u00020MH\u0016¢\u0006\u0004\bP\u0010QJ\u0015\u0010T\u001a\u00020\u00172\u0006\u0010S\u001a\u00020R¢\u0006\u0004\bT\u0010UR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010VR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010WR\u001c\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010XR\"\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010YR\u0016\u0010Z\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u00105R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010]R\u0018\u0010_\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010^R\u0018\u0010c\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u001b\u0010h\u001a\u00020d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010e\u001a\u0004\bf\u0010gR\u001b\u0010m\u001a\u00020i8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\bj\u0010e\u001a\u0004\bk\u0010lR#\u0010s\u001a\n o*\u0004\u0018\u00010n0n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bp\u0010e\u001a\u0004\bq\u0010rR\u001a\u0010y\u001a\u00020t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bu\u0010v\u001a\u0004\bw\u0010xR\u001a\u0010|\u001a\u00020t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bz\u0010v\u001a\u0004\b{\u0010xR\u0019\u0010\u0080\u0001\u001a\u0004\u0018\u00010}8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u0018\u0010\u0082\u0001\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u001b\u0010\u0081\u0001R%\u0010\u0083\u0001\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020}\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010YR\u001a\u0010\u0087\u0001\u001a\u00030\u0084\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R \u0010\u0089\u0001\u001a\n\u0012\u0004\u0012\u00020`\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0088\u0001\u0010XR\u0018\u0010\u008d\u0001\u001a\u00030\u008a\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0017\u0010\u0090\u0001\u001a\u00030\u008e\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\"\u0010\u008f\u0001¨\u0006\u0091\u0001"}, d2 = {"Lio/sentry/android/replay/ReplayIntegration;", "Lio/sentry/o0;", "Ljava/io/Closeable;", "Lio/sentry/android/replay/t;", "Lio/sentry/android/replay/gestures/c;", "Lio/sentry/w1;", "Lio/sentry/N$b;", "Lio/sentry/transport/A$b;", "Lio/sentry/android/replay/w;", "Landroid/content/Context;", "context", "Lio/sentry/transport/p;", "dateProvider", "Lkotlin/Function0;", "Lio/sentry/android/replay/f;", "recorderProvider", "Lkotlin/Function1;", "Lio/sentry/protocol/v;", "Lio/sentry/android/replay/h;", "replayCacheProvider", "<init>", "(Landroid/content/Context;Lio/sentry/transport/p;Lir/nasim/SA2;Lir/nasim/UA2;)V", "(Landroid/content/Context;Lio/sentry/transport/p;)V", "Lir/nasim/rB7;", TokenNames.X, "()V", TokenNames.T, "p", TokenNames.U, "d0", "", "unfinishedReplayId", "q", "(Ljava/lang/String;)V", "u", "Lio/sentry/Z;", "scopes", "Lio/sentry/n3;", "options", "c", "(Lio/sentry/Z;Lio/sentry/n3;)V", "", "P", "()Z", "start", "v", "isTerminating", "y", "(Ljava/lang/Boolean;)V", "j", "()Lio/sentry/protocol/v;", "Lio/sentry/v1;", "converter", "Z", "(Lio/sentry/v1;)V", "G", "()Lio/sentry/v1;", "h", "z", "stop", "Landroid/graphics/Bitmap;", "bitmap", "e", "(Landroid/graphics/Bitmap;)V", "close", "Lio/sentry/N$a;", "status", "b", "(Lio/sentry/N$a;)V", "Lio/sentry/transport/A;", "rateLimiter", "g", "(Lio/sentry/transport/A;)V", "Landroid/view/MotionEvent;", "event", "a", "(Landroid/view/MotionEvent;)V", "", "width", "height", "d", "(II)V", "Lio/sentry/android/replay/u;", "config", "x", "(Lio/sentry/android/replay/u;)V", "Landroid/content/Context;", "Lio/sentry/transport/p;", "Lir/nasim/SA2;", "Lir/nasim/UA2;", "debugMaskingEnabled", "f", "Lio/sentry/n3;", "Lio/sentry/Z;", "Lio/sentry/android/replay/f;", "recorder", "Lio/sentry/android/replay/gestures/a;", "i", "Lio/sentry/android/replay/gestures/a;", "gestureRecorder", "Lio/sentry/util/x;", "Lir/nasim/Yu3;", "J", "()Lio/sentry/util/x;", "random", "Lio/sentry/android/replay/o;", "k", TokenNames.M, "()Lio/sentry/android/replay/o;", "rootViewsSpy", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "l", TokenNames.K, "()Ljava/util/concurrent/ScheduledExecutorService;", "replayExecutor", "Ljava/util/concurrent/atomic/AtomicBoolean;", "m", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isEnabled$sentry_android_replay_release", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "isEnabled", "n", "isManualPause$sentry_android_replay_release", "isManualPause", "Lio/sentry/android/replay/capture/h;", "o", "Lio/sentry/android/replay/capture/h;", "captureStrategy", "Lio/sentry/v1;", "replayBreadcrumbConverter", "replayCaptureStrategyProvider", "Lio/sentry/android/replay/util/j;", "r", "Lio/sentry/android/replay/util/j;", "mainLooperHandler", "s", "gestureRecorderProvider", "Lio/sentry/util/a;", "t", "Lio/sentry/util/a;", "lifecycleLock", "Lio/sentry/android/replay/l;", "Lio/sentry/android/replay/l;", "lifecycle", "sentry-android-replay_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final class ReplayIntegration implements InterfaceC3157o0, Closeable, t, io.sentry.android.replay.gestures.c, InterfaceC3217w1, N.b, A.b, w {
    private static final a v = new a(null);
    public static final int w = 8;

    /* renamed from: a, reason: from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: from kotlin metadata */
    private final io.sentry.transport.p dateProvider;

    /* renamed from: c, reason: from kotlin metadata */
    private final SA2 recorderProvider;

    /* renamed from: d, reason: from kotlin metadata */
    private final UA2 replayCacheProvider;

    /* renamed from: e, reason: from kotlin metadata */
    private boolean debugMaskingEnabled;

    /* renamed from: f, reason: from kotlin metadata */
    private C3155n3 options;

    /* renamed from: g, reason: from kotlin metadata */
    private Z scopes;

    /* renamed from: h, reason: from kotlin metadata */
    private io.sentry.android.replay.f recorder;

    /* renamed from: i, reason: from kotlin metadata */
    private io.sentry.android.replay.gestures.a gestureRecorder;

    /* renamed from: j, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 random;

    /* renamed from: k, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 rootViewsSpy;

    /* renamed from: l, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 replayExecutor;

    /* renamed from: m, reason: from kotlin metadata */
    private final AtomicBoolean isEnabled;

    /* renamed from: n, reason: from kotlin metadata */
    private final AtomicBoolean isManualPause;

    /* renamed from: o, reason: from kotlin metadata */
    private io.sentry.android.replay.capture.h captureStrategy;

    /* renamed from: p, reason: from kotlin metadata */
    private InterfaceC3212v1 replayBreadcrumbConverter;

    /* renamed from: q, reason: from kotlin metadata */
    private UA2 replayCaptureStrategyProvider;

    /* renamed from: r, reason: from kotlin metadata */
    private io.sentry.android.replay.util.j mainLooperHandler;

    /* renamed from: s, reason: from kotlin metadata */
    private SA2 gestureRecorderProvider;

    /* renamed from: t, reason: from kotlin metadata */
    private final C3202a lifecycleLock;

    /* renamed from: u, reason: from kotlin metadata */
    private final l lifecycle;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private static final class b implements io.sentry.hints.c {
        @Override // io.sentry.hints.c
        public boolean a() {
            return false;
        }
    }

    private static final class c implements ThreadFactory {
        private int a;

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            AbstractC13042fc3.i(runnable, "r");
            StringBuilder sb = new StringBuilder();
            sb.append("SentryReplayIntegration-");
            int i = this.a;
            this.a = i + 1;
            sb.append(i);
            Thread thread = new Thread(runnable, sb.toString());
            thread.setDaemon(true);
            return thread;
        }
    }

    static final class d extends AbstractC8614Ws3 implements UA2 {
        d() {
            super(1);
        }

        public final void a(Date date) {
            AbstractC13042fc3.i(date, "newTimestamp");
            io.sentry.android.replay.capture.h hVar = ReplayIntegration.this.captureStrategy;
            if (hVar != null) {
                io.sentry.android.replay.capture.h hVar2 = ReplayIntegration.this.captureStrategy;
                Integer numValueOf = hVar2 != null ? Integer.valueOf(hVar2.e()) : null;
                AbstractC13042fc3.f(numValueOf);
                hVar.d(numValueOf.intValue() + 1);
            }
            io.sentry.android.replay.capture.h hVar3 = ReplayIntegration.this.captureStrategy;
            if (hVar3 == null) {
                return;
            }
            hVar3.j(date);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Date) obj);
            return C19938rB7.a;
        }
    }

    static final class e extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ Bitmap e;
        final /* synthetic */ C12889fL5 f;
        final /* synthetic */ ReplayIntegration g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(Bitmap bitmap, C12889fL5 c12889fL5, ReplayIntegration replayIntegration) {
            super(2);
            this.e = bitmap;
            this.f = c12889fL5;
            this.g = replayIntegration;
        }

        public final void a(io.sentry.android.replay.h hVar, long j) throws Exception {
            AbstractC13042fc3.i(hVar, "$this$onScreenshotRecorded");
            hVar.g(this.e, j, (String) this.f.a);
            this.g.p();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws Exception {
            a((io.sentry.android.replay.h) obj, ((Number) obj2).longValue());
            return C19938rB7.a;
        }
    }

    static final class f extends AbstractC8614Ws3 implements SA2 {
        public static final f e = new f();

        f() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final io.sentry.util.x invoke() {
            return new io.sentry.util.x();
        }
    }

    static final class g extends AbstractC8614Ws3 implements SA2 {
        public static final g e = new g();

        g() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ScheduledExecutorService invoke() {
            return Executors.newSingleThreadScheduledExecutor(new c());
        }
    }

    static final class h extends AbstractC8614Ws3 implements SA2 {
        public static final h e = new h();

        h() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final o invoke() {
            return o.e.b();
        }
    }

    static {
        W2.d().b("maven:io.sentry:sentry-android-replay", "8.20.0");
    }

    public ReplayIntegration(Context context, io.sentry.transport.p pVar, SA2 sa2, UA2 ua2) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(pVar, "dateProvider");
        this.context = context;
        this.dateProvider = pVar;
        this.recorderProvider = sa2;
        this.replayCacheProvider = ua2;
        this.random = AbstractC13269fw3.a(f.e);
        this.rootViewsSpy = AbstractC13269fw3.a(h.e);
        this.replayExecutor = AbstractC13269fw3.a(g.e);
        this.isEnabled = new AtomicBoolean(false);
        this.isManualPause = new AtomicBoolean(false);
        M0 m0B = M0.b();
        AbstractC13042fc3.h(m0B, "getInstance()");
        this.replayBreadcrumbConverter = m0B;
        this.mainLooperHandler = new io.sentry.android.replay.util.j(null, 1, null);
        this.lifecycleLock = new C3202a();
        this.lifecycle = new l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(ReplayIntegration replayIntegration) throws IOException {
        C3155n3 c3155n3;
        AbstractC13042fc3.i(replayIntegration, "this$0");
        C3155n3 c3155n32 = replayIntegration.options;
        if (c3155n32 == null) {
            AbstractC13042fc3.y("options");
            c3155n32 = null;
        }
        io.sentry.cache.q qVarFindPersistingScopeObserver = c3155n32.findPersistingScopeObserver();
        if (qVarFindPersistingScopeObserver != null) {
            C3155n3 c3155n33 = replayIntegration.options;
            if (c3155n33 == null) {
                AbstractC13042fc3.y("options");
                c3155n33 = null;
            }
            String str = (String) qVarFindPersistingScopeObserver.z(c3155n33, "replay.json", String.class);
            if (str != null) {
                io.sentry.protocol.v vVar = new io.sentry.protocol.v(str);
                if (AbstractC13042fc3.d(vVar, io.sentry.protocol.v.b)) {
                    s(replayIntegration, null, 1, null);
                    return;
                }
                h.a aVar = io.sentry.android.replay.h.k;
                C3155n3 c3155n34 = replayIntegration.options;
                if (c3155n34 == null) {
                    AbstractC13042fc3.y("options");
                    c3155n34 = null;
                }
                io.sentry.android.replay.c cVarC = aVar.c(c3155n34, vVar, replayIntegration.replayCacheProvider);
                if (cVarC == null) {
                    s(replayIntegration, null, 1, null);
                    return;
                }
                C3155n3 c3155n35 = replayIntegration.options;
                if (c3155n35 == null) {
                    AbstractC13042fc3.y("options");
                    c3155n35 = null;
                }
                Object objZ = qVarFindPersistingScopeObserver.z(c3155n35, "breadcrumbs.json", List.class);
                List list = objZ instanceof List ? (List) objZ : null;
                h.a aVar2 = io.sentry.android.replay.capture.h.a;
                Z z = replayIntegration.scopes;
                C3155n3 c3155n36 = replayIntegration.options;
                if (c3155n36 == null) {
                    AbstractC13042fc3.y("options");
                    c3155n3 = null;
                } else {
                    c3155n3 = c3155n36;
                }
                h.c cVarC2 = aVar2.c(z, c3155n3, cVarC.b(), cVarC.h(), vVar, cVarC.d(), cVarC.e().c(), cVarC.e().d(), cVarC.f(), cVarC.a(), cVarC.e().b(), cVarC.e().a(), cVarC.g(), list, new LinkedList(cVarC.c()));
                if (cVarC2 instanceof h.c.a) {
                    I iE = io.sentry.util.m.e(new b());
                    Z z2 = replayIntegration.scopes;
                    AbstractC13042fc3.h(iE, "hint");
                    ((h.c.a) cVarC2).a(z2, iE);
                }
                replayIntegration.q(str);
                return;
            }
        }
        s(replayIntegration, null, 1, null);
    }

    private final io.sentry.util.x J() {
        return (io.sentry.util.x) this.random.getValue();
    }

    private final ScheduledExecutorService K() {
        return (ScheduledExecutorService) this.replayExecutor.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(C12889fL5 c12889fL5, X x) {
        AbstractC13042fc3.i(c12889fL5, "$screen");
        AbstractC13042fc3.i(x, "it");
        String strS = x.s();
        c12889fL5.a = strS != null ? AbstractC20762sZ6.c1(strS, '.', null, 2, null) : null;
    }

    private final void T() throws Exception {
        InterfaceC3102d0 interfaceC3102d0A = this.lifecycleLock.a();
        try {
            if (this.isEnabled.get()) {
                l lVar = this.lifecycle;
                m mVar = m.PAUSED;
                if (lVar.b(mVar)) {
                    io.sentry.android.replay.f fVar = this.recorder;
                    if (fVar != null) {
                        fVar.h();
                    }
                    io.sentry.android.replay.capture.h hVar = this.captureStrategy;
                    if (hVar != null) {
                        hVar.h();
                    }
                    this.lifecycle.d(mVar);
                    C19938rB7 c19938rB7 = C19938rB7.a;
                    AbstractC14155hS.a(interfaceC3102d0A, null);
                    return;
                }
            }
            AbstractC14155hS.a(interfaceC3102d0A, null);
        } finally {
        }
    }

    private final void U() {
        if (this.recorder instanceof io.sentry.android.replay.d) {
            CopyOnWriteArrayList copyOnWriteArrayListD = M().d();
            io.sentry.android.replay.f fVar = this.recorder;
            AbstractC13042fc3.g(fVar, "null cannot be cast to non-null type io.sentry.android.replay.OnRootViewsChangedListener");
            copyOnWriteArrayListD.add((io.sentry.android.replay.d) fVar);
        }
        M().d().add(this.gestureRecorder);
    }

    private final void X() throws Exception {
        Z z;
        Z z2;
        io.sentry.transport.A aW;
        io.sentry.transport.A aW2;
        InterfaceC3102d0 interfaceC3102d0A = this.lifecycleLock.a();
        try {
            if (this.isEnabled.get()) {
                l lVar = this.lifecycle;
                m mVar = m.RESUMED;
                if (lVar.b(mVar)) {
                    if (!this.isManualPause.get()) {
                        C3155n3 c3155n3 = this.options;
                        if (c3155n3 == null) {
                            AbstractC13042fc3.y("options");
                            c3155n3 = null;
                        }
                        if (c3155n3.getConnectionStatusProvider().w0() != N.a.DISCONNECTED && (((z = this.scopes) == null || (aW2 = z.w()) == null || !aW2.l(EnumC3136k.All)) && ((z2 = this.scopes) == null || (aW = z2.w()) == null || !aW.l(EnumC3136k.Replay)))) {
                            this.lifecycle.d(mVar);
                            io.sentry.android.replay.capture.h hVar = this.captureStrategy;
                            if (hVar != null) {
                                hVar.v();
                            }
                            io.sentry.android.replay.f fVar = this.recorder;
                            if (fVar != null) {
                                fVar.v();
                                C19938rB7 c19938rB7 = C19938rB7.a;
                            }
                            AbstractC14155hS.a(interfaceC3102d0A, null);
                            return;
                        }
                    }
                    AbstractC14155hS.a(interfaceC3102d0A, null);
                    return;
                }
            }
            AbstractC14155hS.a(interfaceC3102d0A, null);
        } finally {
        }
    }

    private final void d0() {
        if (this.recorder instanceof io.sentry.android.replay.d) {
            CopyOnWriteArrayList copyOnWriteArrayListD = M().d();
            io.sentry.android.replay.f fVar = this.recorder;
            AbstractC13042fc3.g(fVar, "null cannot be cast to non-null type io.sentry.android.replay.OnRootViewsChangedListener");
            copyOnWriteArrayListD.remove((io.sentry.android.replay.d) fVar);
        }
        M().d().remove(this.gestureRecorder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() throws Exception {
        Z z;
        Z z2;
        io.sentry.transport.A aW;
        io.sentry.transport.A aW2;
        if (this.captureStrategy instanceof io.sentry.android.replay.capture.m) {
            C3155n3 c3155n3 = this.options;
            if (c3155n3 == null) {
                AbstractC13042fc3.y("options");
                c3155n3 = null;
            }
            if (c3155n3.getConnectionStatusProvider().w0() == N.a.DISCONNECTED || !(((z = this.scopes) == null || (aW2 = z.w()) == null || !aW2.l(EnumC3136k.All)) && ((z2 = this.scopes) == null || (aW = z2.w()) == null || !aW.l(EnumC3136k.Replay)))) {
                T();
            }
        }
    }

    private final void q(String unfinishedReplayId) {
        File[] fileArrListFiles;
        C3155n3 c3155n3 = this.options;
        if (c3155n3 == null) {
            AbstractC13042fc3.y("options");
            c3155n3 = null;
        }
        String cacheDirPath = c3155n3.getCacheDirPath();
        if (cacheDirPath == null || (fileArrListFiles = new File(cacheDirPath).listFiles()) == null) {
            return;
        }
        AbstractC13042fc3.h(fileArrListFiles, "listFiles()");
        for (File file : fileArrListFiles) {
            String name = file.getName();
            AbstractC13042fc3.h(name, "name");
            if (AbstractC20153rZ6.S(name, "replay_", false, 2, null)) {
                String string = j().toString();
                AbstractC13042fc3.h(string, "replayId.toString()");
                if (!AbstractC20762sZ6.X(name, string, false, 2, null) && (!(!AbstractC20762sZ6.n0(unfinishedReplayId)) || !AbstractC20762sZ6.X(name, unfinishedReplayId, false, 2, null))) {
                    AbstractC3209h.a(file);
                }
            }
        }
    }

    static /* synthetic */ void s(ReplayIntegration replayIntegration, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        replayIntegration.q(str);
    }

    private final void u() {
        C3155n3 c3155n3 = this.options;
        C3155n3 c3155n32 = null;
        if (c3155n3 == null) {
            AbstractC13042fc3.y("options");
            c3155n3 = null;
        }
        InterfaceC3097c0 executorService = c3155n3.getExecutorService();
        AbstractC13042fc3.h(executorService, "options.executorService");
        C3155n3 c3155n33 = this.options;
        if (c3155n33 == null) {
            AbstractC13042fc3.y("options");
        } else {
            c3155n32 = c3155n33;
        }
        io.sentry.android.replay.util.g.d(executorService, c3155n32, "ReplayIntegration.finalize_previous_replay", new Runnable() { // from class: io.sentry.android.replay.j
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                ReplayIntegration.H(this.a);
            }
        });
    }

    @Override // io.sentry.InterfaceC3217w1
    /* renamed from: G, reason: from getter */
    public InterfaceC3212v1 getReplayBreadcrumbConverter() {
        return this.replayBreadcrumbConverter;
    }

    public final o M() {
        return (o) this.rootViewsSpy.getValue();
    }

    public boolean P() {
        return this.lifecycle.a().compareTo(m.STARTED) >= 0 && this.lifecycle.a().compareTo(m.STOPPED) < 0;
    }

    public void Z(InterfaceC3212v1 converter) {
        AbstractC13042fc3.i(converter, "converter");
        this.replayBreadcrumbConverter = converter;
    }

    @Override // io.sentry.android.replay.gestures.c
    public void a(MotionEvent event) {
        io.sentry.android.replay.capture.h hVar;
        AbstractC13042fc3.i(event, "event");
        if (this.isEnabled.get() && this.lifecycle.c() && (hVar = this.captureStrategy) != null) {
            hVar.a(event);
        }
    }

    @Override // io.sentry.N.b
    public void b(N.a status) throws Exception {
        AbstractC13042fc3.i(status, "status");
        if (this.captureStrategy instanceof io.sentry.android.replay.capture.m) {
            if (status == N.a.DISCONNECTED) {
                T();
            } else {
                X();
            }
        }
    }

    @Override // io.sentry.InterfaceC3157o0
    public void c(Z scopes, C3155n3 options) {
        io.sentry.android.replay.f yVar;
        io.sentry.android.replay.gestures.a aVar;
        AbstractC13042fc3.i(scopes, "scopes");
        AbstractC13042fc3.i(options, "options");
        this.options = options;
        if (Build.VERSION.SDK_INT < 26) {
            options.getLogger().c(Y2.INFO, "Session replay is only supported on API 26 and above", new Object[0]);
            return;
        }
        if (!options.getSessionReplay().p() && !options.getSessionReplay().q()) {
            options.getLogger().c(Y2.INFO, "Session replay is disabled, no sample rate specified", new Object[0]);
            return;
        }
        this.scopes = scopes;
        SA2 sa2 = this.recorderProvider;
        if (sa2 == null || (yVar = (io.sentry.android.replay.f) sa2.invoke()) == null) {
            io.sentry.android.replay.util.j jVar = this.mainLooperHandler;
            ScheduledExecutorService scheduledExecutorServiceK = K();
            AbstractC13042fc3.h(scheduledExecutorServiceK, "replayExecutor");
            yVar = new y(options, this, this, jVar, scheduledExecutorServiceK);
        }
        this.recorder = yVar;
        SA2 sa22 = this.gestureRecorderProvider;
        if (sa22 == null || (aVar = (io.sentry.android.replay.gestures.a) sa22.invoke()) == null) {
            aVar = new io.sentry.android.replay.gestures.a(options, this);
        }
        this.gestureRecorder = aVar;
        this.isEnabled.set(true);
        options.getConnectionStatusProvider().v1(this);
        io.sentry.transport.A aW = scopes.w();
        if (aW != null) {
            aW.e(this);
        }
        io.sentry.util.o.a("Replay");
        u();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Exception {
        io.sentry.transport.A aW;
        InterfaceC3102d0 interfaceC3102d0A = this.lifecycleLock.a();
        try {
            if (this.isEnabled.get()) {
                l lVar = this.lifecycle;
                m mVar = m.CLOSED;
                if (lVar.b(mVar)) {
                    C3155n3 c3155n3 = this.options;
                    if (c3155n3 == null) {
                        AbstractC13042fc3.y("options");
                        c3155n3 = null;
                    }
                    c3155n3.getConnectionStatusProvider().L1(this);
                    Z z = this.scopes;
                    if (z != null && (aW = z.w()) != null) {
                        aW.G(this);
                    }
                    stop();
                    io.sentry.android.replay.f fVar = this.recorder;
                    if (fVar != null) {
                        fVar.close();
                    }
                    this.recorder = null;
                    M().close();
                    ScheduledExecutorService scheduledExecutorServiceK = K();
                    AbstractC13042fc3.h(scheduledExecutorServiceK, "replayExecutor");
                    C3155n3 c3155n32 = this.options;
                    if (c3155n32 == null) {
                        AbstractC13042fc3.y("options");
                        c3155n32 = null;
                    }
                    io.sentry.android.replay.util.g.c(scheduledExecutorServiceK, c3155n32);
                    this.lifecycle.d(mVar);
                    C19938rB7 c19938rB7 = C19938rB7.a;
                    AbstractC14155hS.a(interfaceC3102d0A, null);
                    return;
                }
            }
            AbstractC14155hS.a(interfaceC3102d0A, null);
        } finally {
        }
    }

    @Override // io.sentry.android.replay.w
    public void d(int width, int height) {
        if (this.isEnabled.get() && P()) {
            C3155n3 c3155n3 = this.options;
            C3155n3 c3155n32 = null;
            if (c3155n3 == null) {
                AbstractC13042fc3.y("options");
                c3155n3 = null;
            }
            if (c3155n3.getSessionReplay().r()) {
                u.a aVar = u.g;
                Context context = this.context;
                C3155n3 c3155n33 = this.options;
                if (c3155n33 == null) {
                    AbstractC13042fc3.y("options");
                } else {
                    c3155n32 = c3155n33;
                }
                C3165p3 sessionReplay = c3155n32.getSessionReplay();
                AbstractC13042fc3.h(sessionReplay, "options.sessionReplay");
                x(aVar.b(context, sessionReplay, width, height));
            }
        }
    }

    @Override // io.sentry.android.replay.t
    public void e(Bitmap bitmap) {
        AbstractC13042fc3.i(bitmap, "bitmap");
        final C12889fL5 c12889fL5 = new C12889fL5();
        Z z = this.scopes;
        if (z != null) {
            z.z(new D1() { // from class: io.sentry.android.replay.k
                @Override // io.sentry.D1
                public final void a(X x) {
                    ReplayIntegration.S(c12889fL5, x);
                }
            });
        }
        io.sentry.android.replay.capture.h hVar = this.captureStrategy;
        if (hVar != null) {
            hVar.b(bitmap, new e(bitmap, c12889fL5, this));
        }
    }

    @Override // io.sentry.transport.A.b
    public void g(io.sentry.transport.A rateLimiter) throws Exception {
        AbstractC13042fc3.i(rateLimiter, "rateLimiter");
        if (this.captureStrategy instanceof io.sentry.android.replay.capture.m) {
            if (rateLimiter.l(EnumC3136k.All) || rateLimiter.l(EnumC3136k.Replay)) {
                T();
            } else {
                X();
            }
        }
    }

    @Override // io.sentry.InterfaceC3217w1
    public void h() throws Exception {
        this.isManualPause.set(true);
        T();
    }

    @Override // io.sentry.InterfaceC3217w1
    public io.sentry.protocol.v j() {
        io.sentry.protocol.v vVarC;
        io.sentry.android.replay.capture.h hVar = this.captureStrategy;
        if (hVar != null && (vVarC = hVar.c()) != null) {
            return vVarC;
        }
        io.sentry.protocol.v vVar = io.sentry.protocol.v.b;
        AbstractC13042fc3.h(vVar, "EMPTY_ID");
        return vVar;
    }

    @Override // io.sentry.InterfaceC3217w1
    public void start() throws Exception {
        io.sentry.android.replay.capture.h fVar;
        io.sentry.android.replay.capture.h hVar;
        C3155n3 c3155n3;
        InterfaceC3102d0 interfaceC3102d0A = this.lifecycleLock.a();
        try {
            if (!this.isEnabled.get()) {
                AbstractC14155hS.a(interfaceC3102d0A, null);
                return;
            }
            l lVar = this.lifecycle;
            m mVar = m.STARTED;
            if (!lVar.b(mVar)) {
                C3155n3 c3155n32 = this.options;
                if (c3155n32 == null) {
                    AbstractC13042fc3.y("options");
                    c3155n32 = null;
                }
                c3155n32.getLogger().c(Y2.DEBUG, "Session replay is already being recorded, not starting a new one", new Object[0]);
                AbstractC14155hS.a(interfaceC3102d0A, null);
                return;
            }
            io.sentry.util.x xVarJ = J();
            C3155n3 c3155n33 = this.options;
            if (c3155n33 == null) {
                AbstractC13042fc3.y("options");
                c3155n33 = null;
            }
            boolean zA = io.sentry.android.replay.util.l.a(xVarJ, c3155n33.getSessionReplay().k());
            if (!zA) {
                C3155n3 c3155n34 = this.options;
                if (c3155n34 == null) {
                    AbstractC13042fc3.y("options");
                    c3155n34 = null;
                }
                if (!c3155n34.getSessionReplay().q()) {
                    C3155n3 c3155n35 = this.options;
                    if (c3155n35 == null) {
                        AbstractC13042fc3.y("options");
                        c3155n35 = null;
                    }
                    c3155n35.getLogger().c(Y2.INFO, "Session replay is not started, full session was not sampled and onErrorSampleRate is not specified", new Object[0]);
                    AbstractC14155hS.a(interfaceC3102d0A, null);
                    return;
                }
            }
            this.lifecycle.d(mVar);
            UA2 ua2 = this.replayCaptureStrategyProvider;
            if (ua2 == null || (hVar = (io.sentry.android.replay.capture.h) ua2.invoke(Boolean.valueOf(zA))) == null) {
                if (zA) {
                    C3155n3 c3155n36 = this.options;
                    if (c3155n36 == null) {
                        AbstractC13042fc3.y("options");
                        c3155n3 = null;
                    } else {
                        c3155n3 = c3155n36;
                    }
                    Z z = this.scopes;
                    io.sentry.transport.p pVar = this.dateProvider;
                    ScheduledExecutorService scheduledExecutorServiceK = K();
                    AbstractC13042fc3.h(scheduledExecutorServiceK, "replayExecutor");
                    fVar = new io.sentry.android.replay.capture.m(c3155n3, z, pVar, scheduledExecutorServiceK, this.replayCacheProvider);
                } else {
                    C3155n3 c3155n37 = this.options;
                    if (c3155n37 == null) {
                        AbstractC13042fc3.y("options");
                        c3155n37 = null;
                    }
                    Z z2 = this.scopes;
                    io.sentry.transport.p pVar2 = this.dateProvider;
                    io.sentry.util.x xVarJ2 = J();
                    ScheduledExecutorService scheduledExecutorServiceK2 = K();
                    AbstractC13042fc3.h(scheduledExecutorServiceK2, "replayExecutor");
                    fVar = new io.sentry.android.replay.capture.f(c3155n37, z2, pVar2, xVarJ2, scheduledExecutorServiceK2, this.replayCacheProvider);
                }
                hVar = fVar;
            }
            this.captureStrategy = hVar;
            io.sentry.android.replay.f fVar2 = this.recorder;
            if (fVar2 != null) {
                fVar2.start();
            }
            io.sentry.android.replay.capture.h hVar2 = this.captureStrategy;
            if (hVar2 != null) {
                h.b.a(hVar2, 0, null, null, 7, null);
            }
            U();
            C19938rB7 c19938rB7 = C19938rB7.a;
            AbstractC14155hS.a(interfaceC3102d0A, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AbstractC14155hS.a(interfaceC3102d0A, th);
                throw th2;
            }
        }
    }

    @Override // io.sentry.InterfaceC3217w1
    public void stop() throws Exception {
        InterfaceC3102d0 interfaceC3102d0A = this.lifecycleLock.a();
        try {
            if (this.isEnabled.get()) {
                l lVar = this.lifecycle;
                m mVar = m.STOPPED;
                if (lVar.b(mVar)) {
                    d0();
                    io.sentry.android.replay.f fVar = this.recorder;
                    if (fVar != null) {
                        fVar.reset();
                    }
                    io.sentry.android.replay.f fVar2 = this.recorder;
                    if (fVar2 != null) {
                        fVar2.stop();
                    }
                    io.sentry.android.replay.gestures.a aVar = this.gestureRecorder;
                    if (aVar != null) {
                        aVar.c();
                    }
                    io.sentry.android.replay.capture.h hVar = this.captureStrategy;
                    if (hVar != null) {
                        hVar.stop();
                    }
                    this.captureStrategy = null;
                    this.lifecycle.d(mVar);
                    C19938rB7 c19938rB7 = C19938rB7.a;
                    AbstractC14155hS.a(interfaceC3102d0A, null);
                    return;
                }
            }
            AbstractC14155hS.a(interfaceC3102d0A, null);
        } finally {
        }
    }

    @Override // io.sentry.InterfaceC3217w1
    public void v() throws Exception {
        this.isManualPause.set(false);
        X();
    }

    public final void x(u config) {
        io.sentry.android.replay.f fVar;
        AbstractC13042fc3.i(config, "config");
        if (this.isEnabled.get() && P()) {
            io.sentry.android.replay.capture.h hVar = this.captureStrategy;
            if (hVar != null) {
                hVar.x(config);
            }
            io.sentry.android.replay.f fVar2 = this.recorder;
            if (fVar2 != null) {
                fVar2.x(config);
            }
            if (this.lifecycle.a() != m.PAUSED || (fVar = this.recorder) == null) {
                return;
            }
            fVar.h();
        }
    }

    @Override // io.sentry.InterfaceC3217w1
    public void y(Boolean isTerminating) {
        if (this.isEnabled.get() && P()) {
            io.sentry.protocol.v vVar = io.sentry.protocol.v.b;
            io.sentry.android.replay.capture.h hVar = this.captureStrategy;
            C3155n3 c3155n3 = null;
            if (vVar.equals(hVar != null ? hVar.c() : null)) {
                C3155n3 c3155n32 = this.options;
                if (c3155n32 == null) {
                    AbstractC13042fc3.y("options");
                } else {
                    c3155n3 = c3155n32;
                }
                c3155n3.getLogger().c(Y2.DEBUG, "Replay id is not set, not capturing for event", new Object[0]);
                return;
            }
            io.sentry.android.replay.capture.h hVar2 = this.captureStrategy;
            if (hVar2 != null) {
                hVar2.f(AbstractC13042fc3.d(isTerminating, Boolean.TRUE), new d());
            }
            io.sentry.android.replay.capture.h hVar3 = this.captureStrategy;
            this.captureStrategy = hVar3 != null ? hVar3.g() : null;
        }
    }

    @Override // io.sentry.InterfaceC3217w1
    /* renamed from: z, reason: from getter */
    public boolean getDebugMaskingEnabled() {
        return this.debugMaskingEnabled;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ReplayIntegration(Context context, io.sentry.transport.p pVar) {
        this(io.sentry.android.replay.util.c.a(context), pVar, null, null);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(pVar, "dateProvider");
    }
}
