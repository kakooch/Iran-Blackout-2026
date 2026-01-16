package ir.nasim;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.recyclerview.widget.RecyclerView;
import coil.memory.MemoryCache;
import ir.nasim.C19558qZ2;
import ir.nasim.C20286rl2;
import ir.nasim.C20876sl1;
import ir.nasim.C22487vK;
import ir.nasim.C24666z02;
import ir.nasim.C4303Eo0;
import ir.nasim.C9035Yf0;
import ir.nasim.C9269Zf0;
import ir.nasim.InterfaceC14371ho1;
import ir.nasim.InterfaceC18663p23;
import ir.nasim.InterfaceC8217Va2;
import ir.nasim.SW5;
import ir.nasim.W23;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.HttpUrl;

/* loaded from: classes2.dex */
public final class FI5 implements InterfaceC18663p23 {
    public static final a p = new a(null);
    private final Context a;
    private final NE1 b;
    private final InterfaceC9173Yu3 c;
    private final InterfaceC9173Yu3 d;
    private final InterfaceC9173Yu3 e;
    private final InterfaceC8217Va2.c f;
    private final C12087e11 g;
    private final C22321v23 h;
    private final II3 i;
    private final InterfaceC20315ro1 j = AbstractC20906so1.a(P17.b(null, 1, null).X(C12366eV1.c().F0()).X(new f(InterfaceC14371ho1.h0, this)));
    private final I47 k;
    private final C19525qV5 l;
    private final C12087e11 m;
    private final List n;
    private final AtomicBoolean o;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ W23 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(W23 w23, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = w23;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return FI5.this.new b(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            II3 ii3N;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                FI5 fi5 = FI5.this;
                W23 w23 = this.d;
                this.b = 1;
                obj = fi5.h(w23, 0, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            FI5 fi52 = FI5.this;
            Y23 y23 = (Y23) obj;
            if ((y23 instanceof C12412ea2) && (ii3N = fi52.n()) != null) {
                AbstractC16274l.a(ii3N, "RealImageLoader", ((C12412ea2) y23).c());
            }
            return obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ W23 d;
        final /* synthetic */ FI5 e;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ FI5 c;
            final /* synthetic */ W23 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(FI5 fi5, W23 w23, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = fi5;
                this.d = w23;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    FI5 fi5 = this.c;
                    W23 w23 = this.d;
                    this.b = 1;
                    obj = fi5.h(w23, 1, this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return obj;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(W23 w23, FI5 fi5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = w23;
            this.e = fi5;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            c cVar = new c(this.d, this.e, interfaceC20295rm1);
            cVar.c = obj;
            return cVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC24823zG1 interfaceC24823zG1B = AbstractC10533bm0.b((InterfaceC20315ro1) this.c, C12366eV1.c().F0(), null, new a(this.e, this.d, null), 2, null);
                this.d.M();
                this.b = 1;
                obj = interfaceC24823zG1B.y(this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class d extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        /* synthetic */ Object f;
        int h;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= RecyclerView.UNDEFINED_DURATION;
            return FI5.this.h(null, 0, this);
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ W23 c;
        final /* synthetic */ FI5 d;
        final /* synthetic */ PD6 e;
        final /* synthetic */ InterfaceC8217Va2 f;
        final /* synthetic */ Bitmap g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(W23 w23, FI5 fi5, PD6 pd6, InterfaceC8217Va2 interfaceC8217Va2, Bitmap bitmap, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = w23;
            this.d = fi5;
            this.e = pd6;
            this.f = interfaceC8217Va2;
            this.g = bitmap;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new e(this.c, this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GI5 gi5 = new GI5(this.c, this.d.n, 0, this.c, this.e, this.f, this.g != null);
                W23 w23 = this.c;
                this.b = 1;
                obj = gi5.g(w23, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class f extends L0 implements InterfaceC14371ho1 {
        final /* synthetic */ FI5 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(InterfaceC14371ho1.a aVar, FI5 fi5) {
            super(aVar);
            this.b = fi5;
        }

        @Override // ir.nasim.InterfaceC14371ho1
        public void m(InterfaceC11938do1 interfaceC11938do1, Throwable th) {
            II3 ii3N = this.b.n();
            if (ii3N != null) {
                AbstractC16274l.a(ii3N, "RealImageLoader", th);
            }
        }
    }

    public FI5(Context context, NE1 ne1, InterfaceC9173Yu3 interfaceC9173Yu3, InterfaceC9173Yu3 interfaceC9173Yu32, InterfaceC9173Yu3 interfaceC9173Yu33, InterfaceC8217Va2.c cVar, C12087e11 c12087e11, C22321v23 c22321v23, II3 ii3) {
        this.a = context;
        this.b = ne1;
        this.c = interfaceC9173Yu3;
        this.d = interfaceC9173Yu32;
        this.e = interfaceC9173Yu33;
        this.f = cVar;
        this.g = c12087e11;
        this.h = c22321v23;
        this.i = ii3;
        I47 i47 = new I47(this);
        this.k = i47;
        C19525qV5 c19525qV5 = new C19525qV5(this, i47, ii3);
        this.l = c19525qV5;
        this.m = c12087e11.h().d(new C20758sZ2(), HttpUrl.class).d(new PY6(), String.class).d(new C5472Jm2(), Uri.class).d(new UW5(), Uri.class).d(new OW5(), Integer.class).d(new C24548yo0(), byte[].class).c(new C10232bI7(), Uri.class).c(new C22744vl2(c22321v23.c()), File.class).b(new C19558qZ2.b(interfaceC9173Yu33, interfaceC9173Yu32, c22321v23.g()), Uri.class).b(new C20286rl2.a(), File.class).b(new C22487vK.a(), Uri.class).b(new C20876sl1.a(), Uri.class).b(new SW5.b(), Uri.class).b(new C24666z02.a(), Drawable.class).b(new C9269Zf0.a(), Bitmap.class).b(new C4303Eo0.a(), ByteBuffer.class).a(new C9035Yf0.c(c22321v23.e(), c22321v23.d())).e();
        this.n = AbstractC15401jX0.S0(getComponents().c(), new Q82(this, i47, c19525qV5, ii3));
        this.o = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0113 A[Catch: all -> 0x0103, TryCatch #2 {all -> 0x0103, blocks: (B:44:0x00f2, B:46:0x00f8, B:48:0x00fe, B:53:0x010b, B:56:0x0113, B:58:0x0125, B:60:0x012b, B:61:0x012e, B:63:0x0137, B:64:0x013a, B:57:0x0121), top: B:97:0x00f2 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0121 A[Catch: all -> 0x0103, TryCatch #2 {all -> 0x0103, blocks: (B:44:0x00f2, B:46:0x00f8, B:48:0x00fe, B:53:0x010b, B:56:0x0113, B:58:0x0125, B:60:0x012b, B:61:0x012e, B:63:0x0137, B:64:0x013a, B:57:0x0121), top: B:97:0x00f2 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x012b A[Catch: all -> 0x0103, TryCatch #2 {all -> 0x0103, blocks: (B:44:0x00f2, B:46:0x00f8, B:48:0x00fe, B:53:0x010b, B:56:0x0113, B:58:0x0125, B:60:0x012b, B:61:0x012e, B:63:0x0137, B:64:0x013a, B:57:0x0121), top: B:97:0x00f2 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0137 A[Catch: all -> 0x0103, TryCatch #2 {all -> 0x0103, blocks: (B:44:0x00f2, B:46:0x00f8, B:48:0x00fe, B:53:0x010b, B:56:0x0113, B:58:0x0125, B:60:0x012b, B:61:0x012e, B:63:0x0137, B:64:0x013a, B:57:0x0121), top: B:97:0x00f2 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0153 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0185 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0190 A[Catch: all -> 0x004b, TryCatch #5 {all -> 0x004b, blocks: (B:14:0x0046, B:72:0x018a, B:74:0x0190, B:75:0x019b, B:77:0x019f), top: B:101:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x019b A[Catch: all -> 0x004b, TryCatch #5 {all -> 0x004b, blocks: (B:14:0x0046, B:72:0x018a, B:74:0x0190, B:75:0x019b, B:77:0x019f), top: B:101:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01b7 A[Catch: all -> 0x01c8, TRY_LEAVE, TryCatch #3 {all -> 0x01c8, blocks: (B:82:0x01b3, B:84:0x01b7, B:89:0x01ca, B:90:0x01cd), top: B:99:0x01b3 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01ca A[Catch: all -> 0x01c8, TRY_ENTER, TryCatch #3 {all -> 0x01c8, blocks: (B:82:0x01b3, B:84:0x01b7, B:89:0x01ca, B:90:0x01cd), top: B:99:0x01b3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(ir.nasim.W23 r21, int r22, ir.nasim.InterfaceC20295rm1 r23) {
        /*
            Method dump skipped, instructions count: 466
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.FI5.h(ir.nasim.W23, int, ir.nasim.rm1):java.lang.Object");
    }

    private final void q(W23 w23, InterfaceC8217Va2 interfaceC8217Va2) {
        II3 ii3 = this.i;
        if (ii3 != null && ii3.a() <= 4) {
            ii3.b("RealImageLoader", 4, "🏗  Cancelled - " + w23.m(), null);
        }
        interfaceC8217Va2.a(w23);
        W23.b bVarA = w23.A();
        if (bVarA != null) {
            bVarA.a(w23);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void r(ir.nasim.C12412ea2 r7, ir.nasim.InterfaceC22139uj7 r8, ir.nasim.InterfaceC8217Va2 r9) {
        /*
            r6 = this;
            ir.nasim.W23 r0 = r7.b()
            ir.nasim.II3 r1 = r6.i
            if (r1 == 0) goto L36
            int r2 = r1.a()
            r3 = 4
            if (r2 > r3) goto L36
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "🚨 Failed - "
            r2.append(r4)
            java.lang.Object r4 = r0.m()
            r2.append(r4)
            java.lang.String r4 = " - "
            r2.append(r4)
            java.lang.Throwable r4 = r7.c()
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r4 = 0
            java.lang.String r5 = "RealImageLoader"
            r1.b(r5, r3, r2, r4)
        L36:
            boolean r1 = r8 instanceof ir.nasim.InterfaceC4856Gv7
            if (r1 != 0) goto L3d
            if (r8 == 0) goto L69
            goto L50
        L3d:
            ir.nasim.W23 r1 = r7.b()
            ir.nasim.uv7$a r1 = r1.P()
            r2 = r8
            ir.nasim.Gv7 r2 = (ir.nasim.InterfaceC4856Gv7) r2
            ir.nasim.uv7 r1 = r1.a(r2, r7)
            boolean r2 = r1 instanceof ir.nasim.C18762pC4
            if (r2 == 0) goto L58
        L50:
            android.graphics.drawable.Drawable r1 = r7.a()
            r8.c(r1)
            goto L69
        L58:
            ir.nasim.W23 r8 = r7.b()
            r9.l(r8, r1)
            r1.a()
            ir.nasim.W23 r8 = r7.b()
            r9.n(r8, r1)
        L69:
            r9.d(r0, r7)
            ir.nasim.W23$b r8 = r0.A()
            if (r8 == 0) goto L75
            r8.d(r0, r7)
        L75:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.FI5.r(ir.nasim.ea2, ir.nasim.uj7, ir.nasim.Va2):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void s(ir.nasim.I07 r7, ir.nasim.InterfaceC22139uj7 r8, ir.nasim.InterfaceC8217Va2 r9) {
        /*
            r6 = this;
            ir.nasim.W23 r0 = r7.b()
            ir.nasim.tz1 r1 = r7.c()
            ir.nasim.II3 r2 = r6.i
            if (r2 == 0) goto L41
            int r3 = r2.a()
            r4 = 4
            if (r3 > r4) goto L41
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = ir.nasim.AbstractC18638p.g(r1)
            r3.append(r5)
            java.lang.String r5 = " Successful ("
            r3.append(r5)
            java.lang.String r1 = r1.name()
            r3.append(r1)
            java.lang.String r1 = ") - "
            r3.append(r1)
            java.lang.Object r1 = r0.m()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r3 = 0
            java.lang.String r5 = "RealImageLoader"
            r2.b(r5, r4, r1, r3)
        L41:
            boolean r1 = r8 instanceof ir.nasim.InterfaceC4856Gv7
            if (r1 != 0) goto L48
            if (r8 == 0) goto L74
            goto L5b
        L48:
            ir.nasim.W23 r1 = r7.b()
            ir.nasim.uv7$a r1 = r1.P()
            r2 = r8
            ir.nasim.Gv7 r2 = (ir.nasim.InterfaceC4856Gv7) r2
            ir.nasim.uv7 r1 = r1.a(r2, r7)
            boolean r2 = r1 instanceof ir.nasim.C18762pC4
            if (r2 == 0) goto L63
        L5b:
            android.graphics.drawable.Drawable r1 = r7.a()
            r8.a(r1)
            goto L74
        L63:
            ir.nasim.W23 r8 = r7.b()
            r9.l(r8, r1)
            r1.a()
            ir.nasim.W23 r8 = r7.b()
            r9.n(r8, r1)
        L74:
            r9.c(r0, r7)
            ir.nasim.W23$b r8 = r0.A()
            if (r8 == 0) goto L80
            r8.c(r0, r7)
        L80:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.FI5.s(ir.nasim.I07, ir.nasim.uj7, ir.nasim.Va2):void");
    }

    @Override // ir.nasim.InterfaceC18663p23
    public Object a(W23 w23, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC20906so1.e(new c(w23, this, null), interfaceC20295rm1);
    }

    @Override // ir.nasim.InterfaceC18663p23
    public NE1 b() {
        return this.b;
    }

    @Override // ir.nasim.InterfaceC18663p23
    public InterfaceC18663p23.a c() {
        return new InterfaceC18663p23.a(this);
    }

    @Override // ir.nasim.InterfaceC18663p23
    public IV1 d(W23 w23) {
        InterfaceC24823zG1 interfaceC24823zG1B = AbstractC10533bm0.b(this.j, null, null, new b(w23, null), 3, null);
        w23.M();
        return new NK4(interfaceC24823zG1B);
    }

    @Override // ir.nasim.InterfaceC18663p23
    public MemoryCache e() {
        return (MemoryCache) this.c.getValue();
    }

    @Override // ir.nasim.InterfaceC18663p23
    public C12087e11 getComponents() {
        return this.m;
    }

    public final InterfaceC9173Yu3 i() {
        return this.e;
    }

    public final C12087e11 j() {
        return this.g;
    }

    public final Context k() {
        return this.a;
    }

    public final InterfaceC9173Yu3 l() {
        return this.d;
    }

    public final InterfaceC8217Va2.c m() {
        return this.f;
    }

    public final II3 n() {
        return this.i;
    }

    public final InterfaceC9173Yu3 o() {
        return this.c;
    }

    public final C22321v23 p() {
        return this.h;
    }

    public final void t(int i) {
        MemoryCache memoryCache;
        InterfaceC9173Yu3 interfaceC9173Yu3 = this.c;
        if (interfaceC9173Yu3 == null || (memoryCache = (MemoryCache) interfaceC9173Yu3.getValue()) == null) {
            return;
        }
        memoryCache.a(i);
    }
}
