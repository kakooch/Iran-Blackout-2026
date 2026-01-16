package ir.nasim;

import ir.nasim.AbstractC25199zt7;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import kotlin.NoWhenBranchMatchedException;
import livekit.org.webrtc.MediaStreamTrack;

/* renamed from: ir.nasim.tt7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC21649tt7 {
    static final /* synthetic */ InterfaceC5239Im3[] j = {AbstractC10882cM5.f(new C5942Lm4(AbstractC21649tt7.class, "streamState", "getStreamState()Lio/livekit/android/room/track/Track$StreamState;", 0))};
    private final MediaStreamTrack a;
    private final FF5 b;
    private final C9080Yk0 c;
    private final InterfaceC7983Ua2 d;
    private String e;
    private f f;
    private String g;
    private final C9927an4 h;
    private UA2 i;

    /* renamed from: ir.nasim.tt7$a */
    public static final class a implements Callable {
        final /* synthetic */ FF5 a;
        final /* synthetic */ AbstractC21649tt7 b;
        final /* synthetic */ Object c;
        final /* synthetic */ AbstractC21649tt7 d;

        public a(FF5 ff5, AbstractC21649tt7 abstractC21649tt7, Object obj, AbstractC21649tt7 abstractC21649tt72) {
            this.a = ff5;
            this.b = abstractC21649tt7;
            this.c = obj;
            this.d = abstractC21649tt72;
        }

        @Override // java.util.concurrent.Callable
        public final Object call() {
            if (this.a.a()) {
                return null;
            }
            if (this.b.j()) {
                return this.c;
            }
            this.b.h();
            this.d.h().dispose();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.tt7$b */
    public static final class b implements Callable {
        final /* synthetic */ FF5 a;
        final /* synthetic */ AbstractC21649tt7 b;
        final /* synthetic */ Object c;
        final /* synthetic */ AbstractC21649tt7 d;

        public b(FF5 ff5, AbstractC21649tt7 abstractC21649tt7, Object obj, AbstractC21649tt7 abstractC21649tt72) {
            this.a = ff5;
            this.b = abstractC21649tt7;
            this.c = obj;
            this.d = abstractC21649tt72;
        }

        @Override // java.util.concurrent.Callable
        public final Object call() {
            if (this.a.a()) {
                return null;
            }
            if (this.b.j()) {
                return this.c;
            }
            this.b.h();
            return Boolean.valueOf(this.d.h().enabled());
        }
    }

    /* renamed from: ir.nasim.tt7$c */
    public static final class c implements Callable {
        final /* synthetic */ FF5 a;
        final /* synthetic */ AbstractC21649tt7 b;
        final /* synthetic */ Object c;
        final /* synthetic */ AbstractC21649tt7 d;
        final /* synthetic */ boolean e;

        public c(FF5 ff5, AbstractC21649tt7 abstractC21649tt7, Object obj, AbstractC21649tt7 abstractC21649tt72, boolean z) {
            this.a = ff5;
            this.b = abstractC21649tt7;
            this.c = obj;
            this.d = abstractC21649tt72;
            this.e = z;
        }

        @Override // java.util.concurrent.Callable
        public final Object call() {
            if (this.a.a()) {
                return null;
            }
            if (this.b.j()) {
                return this.c;
            }
            this.b.h();
            return Boolean.valueOf(this.d.h().setEnabled(this.e));
        }
    }

    /* renamed from: ir.nasim.tt7$d */
    static final class d extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        d() {
            super(2);
        }

        public final void a(h hVar, h hVar2) {
            AbstractC13042fc3.i(hVar, "newValue");
            AbstractC13042fc3.i(hVar2, "oldValue");
            if (hVar != hVar2) {
                AbstractC21649tt7.this.c().f(new AbstractC25199zt7.a(AbstractC21649tt7.this, hVar));
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((h) obj, (h) obj2);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.tt7$e */
    public static final class e {
        private final int a;
        private final int b;

        public e(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public final int a() {
            return this.a;
        }

        public final int b() {
            return this.b;
        }

        public final int c() {
            return this.b;
        }

        public final int d() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return this.a == eVar.a && this.b == eVar.b;
        }

        public int hashCode() {
            return (Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b);
        }

        public String toString() {
            return "Dimensions(width=" + this.a + ", height=" + this.b + ')';
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.tt7$f */
    public static final class f {
        public static final a Companion;
        public static final f b = new f("AUDIO", 0, MediaStreamTrack.AUDIO_TRACK_KIND);
        public static final f c = new f("VIDEO", 1, MediaStreamTrack.VIDEO_TRACK_KIND);
        public static final f d = new f("UNRECOGNIZED", 2, "unrecognized");
        private static final /* synthetic */ f[] e;
        private static final /* synthetic */ F92 f;
        private final String a;

        /* renamed from: ir.nasim.tt7$f$a */
        public static final class a {

            /* renamed from: ir.nasim.tt7$f$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C1609a {
                public static final /* synthetic */ int[] a;

                static {
                    int[] iArr = new int[EnumC10201bF3.values().length];
                    try {
                        iArr[EnumC10201bF3.AUDIO.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[EnumC10201bF3.VIDEO.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[EnumC10201bF3.DATA.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[EnumC10201bF3.UNRECOGNIZED.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    a = iArr;
                }
            }

            private a() {
            }

            public final f a(EnumC10201bF3 enumC10201bF3) {
                AbstractC13042fc3.i(enumC10201bF3, "tt");
                int i = C1609a.a[enumC10201bF3.ordinal()];
                if (i == 1) {
                    return f.b;
                }
                if (i == 2) {
                    return f.c;
                }
                if (i == 3 || i == 4) {
                    return f.d;
                }
                throw new NoWhenBranchMatchedException();
            }

            public /* synthetic */ a(ED1 ed1) {
                this();
            }
        }

        /* renamed from: ir.nasim.tt7$f$b */
        public /* synthetic */ class b {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[f.values().length];
                try {
                    iArr[f.b.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[f.c.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[f.d.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                a = iArr;
            }
        }

        static {
            f[] fVarArrA = a();
            e = fVarArrA;
            f = G92.a(fVarArrA);
            Companion = new a(null);
        }

        private f(String str, int i, String str2) {
            this.a = str2;
        }

        private static final /* synthetic */ f[] a() {
            return new f[]{b, c, d};
        }

        public static f valueOf(String str) {
            return (f) Enum.valueOf(f.class, str);
        }

        public static f[] values() {
            return (f[]) e.clone();
        }

        public final EnumC10201bF3 j() {
            int i = b.a[ordinal()];
            if (i == 1) {
                return EnumC10201bF3.AUDIO;
            }
            if (i == 2) {
                return EnumC10201bF3.VIDEO;
            }
            if (i == 3) {
                return EnumC10201bF3.UNRECOGNIZED;
            }
            throw new NoWhenBranchMatchedException();
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.a;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.tt7$g */
    public static final class g {
        public static final a Companion;
        public static final g a = new g("UNKNOWN", 0);
        public static final g b = new g("CAMERA", 1);
        public static final g c = new g("MICROPHONE", 2);
        public static final g d = new g("SCREEN_SHARE", 3);
        public static final g e = new g("SCREEN_SHARE_AUDIO", 4);
        private static final /* synthetic */ g[] f;
        private static final /* synthetic */ F92 g;

        /* renamed from: ir.nasim.tt7$g$a */
        public static final class a {

            /* renamed from: ir.nasim.tt7$g$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C1610a {
                public static final /* synthetic */ int[] a;

                static {
                    int[] iArr = new int[EnumC9607aF3.values().length];
                    try {
                        iArr[EnumC9607aF3.CAMERA.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[EnumC9607aF3.MICROPHONE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[EnumC9607aF3.SCREEN_SHARE.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[EnumC9607aF3.SCREEN_SHARE_AUDIO.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[EnumC9607aF3.UNKNOWN.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    try {
                        iArr[EnumC9607aF3.UNRECOGNIZED.ordinal()] = 6;
                    } catch (NoSuchFieldError unused6) {
                    }
                    a = iArr;
                }
            }

            private a() {
            }

            public final g a(EnumC9607aF3 enumC9607aF3) {
                AbstractC13042fc3.i(enumC9607aF3, "source");
                switch (C1610a.a[enumC9607aF3.ordinal()]) {
                    case 1:
                        return g.b;
                    case 2:
                        return g.c;
                    case 3:
                        return g.d;
                    case 4:
                        return g.e;
                    case 5:
                    case 6:
                        return g.a;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }

            public /* synthetic */ a(ED1 ed1) {
                this();
            }
        }

        /* renamed from: ir.nasim.tt7$g$b */
        public /* synthetic */ class b {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[g.values().length];
                try {
                    iArr[g.a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[g.b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[g.c.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[g.d.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[g.e.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                a = iArr;
            }
        }

        static {
            g[] gVarArrA = a();
            f = gVarArrA;
            g = G92.a(gVarArrA);
            Companion = new a(null);
        }

        private g(String str, int i) {
        }

        private static final /* synthetic */ g[] a() {
            return new g[]{a, b, c, d, e};
        }

        public static F92 j() {
            return g;
        }

        public static g valueOf(String str) {
            return (g) Enum.valueOf(g.class, str);
        }

        public static g[] values() {
            return (g[]) f.clone();
        }

        public final EnumC9607aF3 p() {
            int i = b.a[ordinal()];
            if (i == 1) {
                return EnumC9607aF3.UNKNOWN;
            }
            if (i == 2) {
                return EnumC9607aF3.CAMERA;
            }
            if (i == 3) {
                return EnumC9607aF3.MICROPHONE;
            }
            if (i == 4) {
                return EnumC9607aF3.SCREEN_SHARE;
            }
            if (i == 5) {
                return EnumC9607aF3.SCREEN_SHARE_AUDIO;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.tt7$h */
    public static final class h {
        public static final a Companion;
        public static final h a = new h("ACTIVE", 0);
        public static final h b = new h("PAUSED", 1);
        public static final h c = new h("UNKNOWN", 2);
        private static final /* synthetic */ h[] d;
        private static final /* synthetic */ F92 e;

        /* renamed from: ir.nasim.tt7$h$a */
        public static final class a {

            /* renamed from: ir.nasim.tt7$h$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C1611a {
                public static final /* synthetic */ int[] a;

                static {
                    int[] iArr = new int[EnumC18788pF3.values().length];
                    try {
                        iArr[EnumC18788pF3.ACTIVE.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[EnumC18788pF3.PAUSED.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[EnumC18788pF3.UNRECOGNIZED.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    a = iArr;
                }
            }

            private a() {
            }

            public final h a(EnumC18788pF3 enumC18788pF3) {
                AbstractC13042fc3.i(enumC18788pF3, "state");
                int i = C1611a.a[enumC18788pF3.ordinal()];
                if (i == 1) {
                    return h.a;
                }
                if (i == 2) {
                    return h.b;
                }
                if (i == 3) {
                    return h.c;
                }
                throw new NoWhenBranchMatchedException();
            }

            public /* synthetic */ a(ED1 ed1) {
                this();
            }
        }

        static {
            h[] hVarArrA = a();
            d = hVarArrA;
            e = G92.a(hVarArrA);
            Companion = new a(null);
        }

        private h(String str, int i) {
        }

        private static final /* synthetic */ h[] a() {
            return new h[]{a, b, c};
        }

        public static h valueOf(String str) {
            return (h) Enum.valueOf(h.class, str);
        }

        public static h[] values() {
            return (h[]) d.clone();
        }
    }

    public AbstractC21649tt7(String str, f fVar, MediaStreamTrack mediaStreamTrack, FF5 ff5) {
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(fVar, "kind");
        AbstractC13042fc3.i(mediaStreamTrack, "rtcTrack");
        AbstractC13042fc3.i(ff5, "rtcThreadToken");
        this.a = mediaStreamTrack;
        this.b = ff5;
        C9080Yk0 c9080Yk0 = new C9080Yk0();
        this.c = c9080Yk0;
        this.d = c9080Yk0.e();
        this.e = str;
        this.f = fVar;
        this.h = AbstractC5508Jq2.a(h.b, new d());
    }

    public void a() {
        C19938rB7 c19938rB7 = C19938rB7.a;
        if (j()) {
            return;
        }
        FF5 ff5G = g();
        if (ff5G.a()) {
            return;
        }
        String name = Thread.currentThread().getName();
        AbstractC13042fc3.h(name, "getName(...)");
        if (!AbstractC20153rZ6.S(name, "LK_RTC_THREAD", false, 2, null)) {
            IF5.b.submit(new a(ff5G, this, c19938rB7, this)).get();
        } else {
            if (j()) {
                return;
            }
            h();
            h().dispose();
        }
    }

    public final boolean b() throws ExecutionException, InterruptedException {
        Object objValueOf;
        Object obj = Boolean.FALSE;
        if (!j()) {
            FF5 ff5G = g();
            Object obj2 = null;
            if (!ff5G.a()) {
                String name = Thread.currentThread().getName();
                AbstractC13042fc3.h(name, "getName(...)");
                if (!AbstractC20153rZ6.S(name, "LK_RTC_THREAD", false, 2, null)) {
                    objValueOf = IF5.b.submit(new b(ff5G, this, obj, this)).get();
                } else if (j()) {
                    objValueOf = obj;
                } else {
                    h();
                    objValueOf = Boolean.valueOf(h().enabled());
                }
                obj2 = objValueOf;
            }
            if (obj2 != null) {
                obj = obj2;
            }
        }
        return ((Boolean) obj).booleanValue();
    }

    protected final C9080Yk0 c() {
        return this.c;
    }

    public final InterfaceC7983Ua2 d() {
        return this.d;
    }

    public final f e() {
        return this.f;
    }

    public final String f() {
        return this.e;
    }

    public final FF5 g() {
        return this.b;
    }

    public abstract MediaStreamTrack h();

    public final String i() {
        return this.g;
    }

    public final boolean j() {
        return h().isDisposed();
    }

    public final void k(boolean z) throws ExecutionException, InterruptedException {
        C19938rB7 c19938rB7 = C19938rB7.a;
        if (j()) {
            return;
        }
        FF5 ff5G = g();
        if (ff5G.a()) {
            return;
        }
        String name = Thread.currentThread().getName();
        AbstractC13042fc3.h(name, "getName(...)");
        if (!AbstractC20153rZ6.S(name, "LK_RTC_THREAD", false, 2, null)) {
            IF5.b.submit(new c(ff5G, this, c19938rB7, this, z)).get();
        } else {
            if (j()) {
                return;
            }
            h();
            h().setEnabled(z);
        }
    }

    public final void l(String str) {
        AbstractC13042fc3.i(str, "<set-?>");
        this.e = str;
    }

    public final void m(String str) {
        this.g = str;
    }

    public final void n(UA2 ua2) {
        this.i = ua2;
    }

    public final void o(h hVar) {
        AbstractC13042fc3.i(hVar, "<set-?>");
        this.h.i(this, j[0], hVar);
    }

    public void p() {
        k(true);
    }

    public void q() {
        k(false);
    }
}
