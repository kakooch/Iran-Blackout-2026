package ir.nasim;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.webkit.GeolocationPermissions;
import android.webkit.PermissionRequest;
import android.webkit.WebView;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC10213bG6;
import ir.nasim.AbstractC13801gq4;
import ir.nasim.AbstractC20942sr7;
import ir.nasim.AbstractC9256Zd5;
import ir.nasim.C21753u45;
import ir.nasim.C9475a16;
import ir.nasim.Y48;
import ir.nasim.core.model.webapp.WebAppArguments;
import ir.nasim.core.model.webapp.WebAppRestoreState;
import ir.nasim.core.model.webapp.WebAppType;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.core.shortcut.ShortcutShortcutReceiver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.c78, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C10747c78 extends VW7 {
    public static final a B = new a(null);
    public static final int D = 8;
    private final InterfaceC9173Yu3 A;
    private final HG2 b;
    private final C21855uF2 c;
    private final C24554yo6 d;
    private final C3368Ao6 e;
    private final InterfaceC11621dJ7 f;
    private final InterfaceC13727gj0 g;
    private final C6409Nm h;
    private final C19711qo6 i;
    private final SettingsModule j;
    private final LE k;
    private final Context l;
    private final int m;
    private final WebAppArguments n;
    private final InterfaceC3570Bk5 o;
    private final E84 p;
    private final FD7 q;
    private final KF3 r;
    private final InterfaceC20315ro1 s;
    private final C15753k68 t;
    private C17637nI7 u;
    private final boolean v;
    private long w;
    private String x;
    private boolean y;
    private final InterfaceC9336Zm4 z;

    /* renamed from: ir.nasim.c78$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.c78$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[C21753u45.g.values().length];
            try {
                iArr[C21753u45.g.e.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[C21753u45.g.f.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[C21753u45.g.g.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[C21753u45.g.h.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.c78$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10747c78.this.new c(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC13727gj0 interfaceC13727gj0 = C10747c78.this.g;
                int botId = C10747c78.this.G1().getBotId();
                String str = this.d;
                this.b = 1;
                if (interfaceC13727gj0.d(botId, str, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                ((C9475a16) obj).l();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.c78$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.c78$d$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C10747c78 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C10747c78 c10747c78, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c10747c78;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                C21159tC7 c21159tC7 = (C21159tC7) this.c;
                C22132uj0 c22132uj0 = new C22132uj0(c21159tC7.c(), c21159tC7.b());
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.d.z;
                while (true) {
                    Object value = interfaceC9336Zm4.getValue();
                    R68 r68 = (R68) value;
                    C22132uj0 c22132uj02 = c22132uj0;
                    if (interfaceC9336Zm4.f(value, r68.a((14680063 & 1) != 0 ? r68.a : null, (14680063 & 2) != 0 ? r68.b : null, (14680063 & 4) != 0 ? r68.c : false, (14680063 & 8) != 0 ? r68.d : null, (14680063 & 16) != 0 ? r68.e : false, (14680063 & 32) != 0 ? r68.f : null, (14680063 & 64) != 0 ? r68.g : false, (14680063 & 128) != 0 ? r68.h : false, (14680063 & 256) != 0 ? r68.i : false, (14680063 & 512) != 0 ? r68.j : null, (14680063 & 1024) != 0 ? r68.k : false, (14680063 & 2048) != 0 ? r68.l : false, (14680063 & 4096) != 0 ? r68.m : false, (14680063 & 8192) != 0 ? r68.n : null, (14680063 & 16384) != 0 ? r68.o : null, (14680063 & 32768) != 0 ? r68.p : false, (14680063 & 65536) != 0 ? r68.q : null, (14680063 & 131072) != 0 ? r68.r : false, (14680063 & 262144) != 0 ? r68.s : 0, (14680063 & 524288) != 0 ? r68.t : false, (14680063 & 1048576) != 0 ? r68.u : false, (14680063 & 2097152) != 0 ? r68.v : c22132uj02, (14680063 & 4194304) != 0 ? r68.w : null, (14680063 & 8388608) != 0 ? r68.x : false))) {
                        return C19938rB7.a;
                    }
                    c22132uj0 = c22132uj02;
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C21159tC7 c21159tC7, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(c21159tC7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.c78$d$b */
        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;
            final /* synthetic */ C10747c78 b;

            /* renamed from: ir.nasim.c78$d$b$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;
                final /* synthetic */ C10747c78 b;

                /* renamed from: ir.nasim.c78$d$b$a$a, reason: collision with other inner class name */
                public static final class C0929a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0929a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2, C10747c78 c10747c78) {
                    this.a = interfaceC4806Gq2;
                    this.b = c10747c78;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r6, ir.nasim.InterfaceC20295rm1 r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof ir.nasim.C10747c78.d.b.a.C0929a
                        if (r0 == 0) goto L13
                        r0 = r7
                        ir.nasim.c78$d$b$a$a r0 = (ir.nasim.C10747c78.d.b.a.C0929a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.c78$d$b$a$a r0 = new ir.nasim.c78$d$b$a$a
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r7)
                        goto L52
                    L29:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L31:
                        ir.nasim.AbstractC10685c16.b(r7)
                        ir.nasim.Gq2 r7 = r5.a
                        r2 = r6
                        ir.nasim.tC7 r2 = (ir.nasim.C21159tC7) r2
                        int r2 = r2.a()
                        ir.nasim.c78 r4 = r5.b
                        ir.nasim.core.model.webapp.WebAppArguments r4 = r4.G1()
                        int r4 = r4.getBotId()
                        if (r2 != r4) goto L52
                        r0.b = r3
                        java.lang.Object r6 = r7.a(r6, r0)
                        if (r6 != r1) goto L52
                        return r1
                    L52:
                        ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10747c78.d.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public b(InterfaceC4557Fq2 interfaceC4557Fq2, C10747c78 c10747c78) {
                this.a = interfaceC4557Fq2;
                this.b = c10747c78;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.c78$d$c */
        public static final class c implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.c78$d$c$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.c78$d$c$a$a, reason: collision with other inner class name */
                public static final class C0930a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0930a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof ir.nasim.C10747c78.d.c.a.C0930a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.c78$d$c$a$a r0 = (ir.nasim.C10747c78.d.c.a.C0930a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.c78$d$c$a$a r0 = new ir.nasim.c78$d$c$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L43
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.Gq2 r6 = r4.a
                        boolean r2 = r5 instanceof ir.nasim.C21159tC7
                        if (r2 == 0) goto L43
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L43
                        return r1
                    L43:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10747c78.d.c.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public c(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10747c78.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                b bVar = new b(new c(C10747c78.this.q.c()), C10747c78.this);
                a aVar = new a(C10747c78.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(bVar, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.c78$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ WeakReference e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(WeakReference weakReference, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = weakReference;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10747c78.this.new e(this.e, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:39:0x00d9  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00e8  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r31) {
            /*
                Method dump skipped, instructions count: 246
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10747c78.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.c78$f */
    static final class f extends AbstractC22163um1 {
        Object a;
        int b;
        boolean c;
        /* synthetic */ Object d;
        int f;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C10747c78.this.N1(this);
        }
    }

    /* renamed from: ir.nasim.c78$g */
    static final class g extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C10747c78.this.P1(null, null, this);
        }
    }

    /* renamed from: ir.nasim.c78$h */
    static final class h extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C10747c78.this.V1(this);
        }
    }

    /* renamed from: ir.nasim.c78$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10747c78.this.new i(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.b = 1;
                if (HG1.b(50L, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            C10747c78.this.t.h();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.c78$j */
    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        int e;
        private /* synthetic */ Object f;
        final /* synthetic */ C24732z68 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(C24732z68 c24732z68, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.h = c24732z68;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            j jVar = C10747c78.this.new j(this.h, interfaceC20295rm1);
            jVar.f = obj;
            return jVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x00d0 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00d1  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00ea A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00eb  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0103  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0120  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0123  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x0187 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0188  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x018a A[LOOP:1: B:42:0x00f5->B:55:0x018a, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0196  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x0164 A[EDGE_INSN: B:67:0x0164->B:51:0x0164 BREAK  A[LOOP:1: B:42:0x00f5->B:55:0x018a], SYNTHETIC] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r39) {
            /*
                Method dump skipped, instructions count: 471
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10747c78.j.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.c78$k */
    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ WebView d;
        final /* synthetic */ C12144e68 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(WebView webView, C12144e68 c12144e68, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = webView;
            this.e = c12144e68;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10747c78.this.new k(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            WebAppArguments webAppArgumentsB;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C4226Ef4 c4226Ef4D = C10747c78.this.t.d();
            C17637nI7 c17637nI7 = null;
            if (!AbstractC13042fc3.d((c4226Ef4D == null || (webAppArgumentsB = c4226Ef4D.b()) == null) ? null : webAppArgumentsB.f(), C10747c78.this.G1().f())) {
                C10747c78.this.t.a();
            }
            C10747c78.this.F2();
            C15753k68 c15753k68 = C10747c78.this.t;
            WebAppArguments webAppArgumentsG1 = C10747c78.this.G1();
            C10747c78 c10747c78 = C10747c78.this;
            WebAppArguments webAppArgumentsA = webAppArgumentsG1.a((95 & 1) != 0 ? webAppArgumentsG1.botId : 0, (95 & 2) != 0 ? webAppArgumentsG1.webAppType : null, (95 & 4) != 0 ? webAppArgumentsG1.openType : null, (95 & 8) != 0 ? webAppArgumentsG1.eventRandomId : 0, (95 & 16) != 0 ? webAppArgumentsG1.chatExPeer : null, (95 & 32) != 0 ? webAppArgumentsG1.webAppRestoreState : c10747c78.O1((R68) c10747c78.M1().getValue()), (95 & 64) != 0 ? webAppArgumentsG1.screenMode : null, (95 & 128) != 0 ? webAppArgumentsG1.isRestore : true);
            WebView webView = this.d;
            C12144e68 c12144e68 = this.e;
            C17637nI7 c17637nI72 = C10747c78.this.u;
            if (c17637nI72 == null) {
                AbstractC13042fc3.y("bot");
            } else {
                c17637nI7 = c17637nI72;
            }
            c15753k68.g(webAppArgumentsA, webView, c12144e68, c17637nI7);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.c78$l */
    static final class l extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        l(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10747c78.this.new l(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objC;
            Y48.d dVar;
            Object value;
            R68 r68;
            C19482qQ7 c19482qQ7U;
            ArrayList arrayList;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                KF3 kf3 = C10747c78.this.r;
                this.b = 1;
                objC = kf3.c(this);
                if (objC == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objC = obj;
            }
            C21231tK7 c21231tK7 = (C21231tK7) objC;
            NI7 ni7 = (c21231tK7 == null || (c19482qQ7U = c21231tK7.u()) == null || (arrayList = (ArrayList) c19482qQ7U.b()) == null) ? null : (NI7) AbstractC15401jX0.s0(arrayList);
            if (ni7 != null) {
                dVar = new Y48.d("+" + ni7.a());
            } else {
                dVar = new Y48.d(null);
            }
            InterfaceC9336Zm4 interfaceC9336Zm4 = C10747c78.this.z;
            do {
                value = interfaceC9336Zm4.getValue();
                r68 = (R68) value;
            } while (!interfaceC9336Zm4.f(value, r68.a((14680063 & 1) != 0 ? r68.a : null, (14680063 & 2) != 0 ? r68.b : null, (14680063 & 4) != 0 ? r68.c : false, (14680063 & 8) != 0 ? r68.d : null, (14680063 & 16) != 0 ? r68.e : false, (14680063 & 32) != 0 ? r68.f : null, (14680063 & 64) != 0 ? r68.g : false, (14680063 & 128) != 0 ? r68.h : false, (14680063 & 256) != 0 ? r68.i : false, (14680063 & 512) != 0 ? r68.j : null, (14680063 & 1024) != 0 ? r68.k : false, (14680063 & 2048) != 0 ? r68.l : false, (14680063 & 4096) != 0 ? r68.m : false, (14680063 & 8192) != 0 ? r68.n : null, (14680063 & 16384) != 0 ? r68.o : null, (14680063 & 32768) != 0 ? r68.p : false, (14680063 & 65536) != 0 ? r68.q : dVar, (14680063 & 131072) != 0 ? r68.r : false, (14680063 & 262144) != 0 ? r68.s : 0, (14680063 & 524288) != 0 ? r68.t : false, (14680063 & 1048576) != 0 ? r68.u : false, (14680063 & 2097152) != 0 ? r68.v : null, (14680063 & 4194304) != 0 ? r68.w : null, (14680063 & 8388608) != 0 ? r68.x : false)));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((l) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.c78$m */
    static final class m extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        m(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10747c78.this.new m(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            R68 r68;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.b = 1;
                if (HG1.b(250L, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            InterfaceC9336Zm4 interfaceC9336Zm4 = C10747c78.this.z;
            do {
                value = interfaceC9336Zm4.getValue();
                r68 = (R68) value;
            } while (!interfaceC9336Zm4.f(value, r68.a((14680063 & 1) != 0 ? r68.a : null, (14680063 & 2) != 0 ? r68.b : null, (14680063 & 4) != 0 ? r68.c : false, (14680063 & 8) != 0 ? r68.d : null, (14680063 & 16) != 0 ? r68.e : true, (14680063 & 32) != 0 ? r68.f : null, (14680063 & 64) != 0 ? r68.g : false, (14680063 & 128) != 0 ? r68.h : false, (14680063 & 256) != 0 ? r68.i : false, (14680063 & 512) != 0 ? r68.j : null, (14680063 & 1024) != 0 ? r68.k : false, (14680063 & 2048) != 0 ? r68.l : false, (14680063 & 4096) != 0 ? r68.m : false, (14680063 & 8192) != 0 ? r68.n : null, (14680063 & 16384) != 0 ? r68.o : null, (14680063 & 32768) != 0 ? r68.p : false, (14680063 & 65536) != 0 ? r68.q : null, (14680063 & 131072) != 0 ? r68.r : false, (14680063 & 262144) != 0 ? r68.s : 0, (14680063 & 524288) != 0 ? r68.t : true, (14680063 & 1048576) != 0 ? r68.u : false, (14680063 & 2097152) != 0 ? r68.v : null, (14680063 & 4194304) != 0 ? r68.w : null, (14680063 & 8388608) != 0 ? r68.x : false)));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((m) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.c78$n */
    static final class n extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ WebAppRestoreState d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(WebAppRestoreState webAppRestoreState, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = webAppRestoreState;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10747c78.this.new n(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C10747c78.this.U2();
                C10747c78 c10747c78 = C10747c78.this;
                this.b = 1;
                if (c10747c78.V1(this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            InterfaceC9336Zm4 interfaceC9336Zm4 = C10747c78.this.z;
            C10747c78 c10747c782 = C10747c78.this;
            WebAppRestoreState webAppRestoreState = this.d;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, c10747c782.b3((R68) value, webAppRestoreState)));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((n) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.c78$o */
    static final class o extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        o(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10747c78.this.new o(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C19711qo6 c19711qo6 = C10747c78.this.i;
                C17637nI7 c17637nI7 = C10747c78.this.u;
                if (c17637nI7 == null) {
                    AbstractC13042fc3.y("bot");
                    c17637nI7 = null;
                }
                C11458d25 c11458d25U0 = c17637nI7.u0();
                AbstractC13042fc3.h(c11458d25U0, "peer(...)");
                long j = C10747c78.this.m;
                this.b = 1;
                if (c19711qo6.a(c11458d25U0, j, null, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                ((C9475a16) obj).l();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((o) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.c78$p */
    static final class p extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        p(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10747c78.this.new p(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objA;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C3368Ao6 c3368Ao6 = C10747c78.this.e;
                int botId = C10747c78.this.G1().getBotId();
                String str = this.d;
                String str2 = C10747c78.this.x;
                this.b = 1;
                objA = c3368Ao6.a(botId, str, str2, this);
                if (objA == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objA = ((C9475a16) obj).l();
            }
            C10747c78 c10747c78 = C10747c78.this;
            if (C9475a16.j(objA)) {
                c10747c78.Y1(AbstractC6392Nk0.a(false));
            }
            Throwable thE = C9475a16.e(objA);
            if (thE != null) {
                C19406qI3.a("WEBAPP", "Can not send data. error message: " + thE.getMessage(), new Object[0]);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((p) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.c78$q */
    static final class q extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;
        final /* synthetic */ String e;
        final /* synthetic */ UA2 f;
        final /* synthetic */ UA2 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        q(String str, String str2, UA2 ua2, UA2 ua22, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
            this.e = str2;
            this.f = ua2;
            this.g = ua22;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10747c78.this.new q(this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objA;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C24554yo6 c24554yo6 = C10747c78.this.d;
                int botId = C10747c78.this.G1().getBotId();
                String str = this.d;
                String str2 = this.e;
                this.b = 1;
                objA = c24554yo6.a(botId, str, str2, this);
                if (objA == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objA = ((C9475a16) obj).l();
            }
            UA2 ua2 = this.f;
            if (C9475a16.j(objA)) {
                ua2.invoke((String) objA);
            }
            UA2 ua22 = this.g;
            Throwable thE = C9475a16.e(objA);
            if (thE != null) {
                String message = thE.getMessage();
                if (message == null) {
                    message = "";
                }
                ua22.invoke(message);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((q) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.c78$r */
    static final class r extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        r(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10747c78.this.new r(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            R68 r68;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = C10747c78.this.z;
                do {
                    value = interfaceC9336Zm4.getValue();
                    r68 = (R68) value;
                } while (!interfaceC9336Zm4.f(value, r68.a((14680063 & 1) != 0 ? r68.a : null, (14680063 & 2) != 0 ? r68.b : null, (14680063 & 4) != 0 ? r68.c : false, (14680063 & 8) != 0 ? r68.d : null, (14680063 & 16) != 0 ? r68.e : false, (14680063 & 32) != 0 ? r68.f : null, (14680063 & 64) != 0 ? r68.g : false, (14680063 & 128) != 0 ? r68.h : false, (14680063 & 256) != 0 ? r68.i : false, (14680063 & 512) != 0 ? r68.j : null, (14680063 & 1024) != 0 ? r68.k : false, (14680063 & 2048) != 0 ? r68.l : false, (14680063 & 4096) != 0 ? r68.m : false, (14680063 & 8192) != 0 ? r68.n : null, (14680063 & 16384) != 0 ? r68.o : null, (14680063 & 32768) != 0 ? r68.p : false, (14680063 & 65536) != 0 ? r68.q : null, (14680063 & 131072) != 0 ? r68.r : false, (14680063 & 262144) != 0 ? r68.s : 0, (14680063 & 524288) != 0 ? r68.t : false, (14680063 & 1048576) != 0 ? r68.u : false, (14680063 & 2097152) != 0 ? r68.v : null, (14680063 & 4194304) != 0 ? r68.w : null, (14680063 & 8388608) != 0 ? r68.x : false)));
                InterfaceC13727gj0 interfaceC13727gj0 = C10747c78.this.g;
                int botId = C10747c78.this.G1().getBotId();
                this.b = 1;
                if (InterfaceC13727gj0.e(interfaceC13727gj0, botId, null, null, this, 6, null) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                ((C9475a16) obj).l();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((r) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.c78$s */
    static final class s extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;
        final /* synthetic */ String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        s(int i, String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
            this.e = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10747c78.this.new s(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            R68 r68;
            Object objL;
            Object value2;
            R68 r682;
            Object value3;
            R68 r683;
            AbstractC10213bG6.b bVar;
            AbstractC13801gq4.a aVar;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = C10747c78.this.z;
                do {
                    value = interfaceC9336Zm4.getValue();
                    r68 = (R68) value;
                } while (!interfaceC9336Zm4.f(value, r68.a((14680063 & 1) != 0 ? r68.a : null, (14680063 & 2) != 0 ? r68.b : null, (14680063 & 4) != 0 ? r68.c : false, (14680063 & 8) != 0 ? r68.d : null, (14680063 & 16) != 0 ? r68.e : false, (14680063 & 32) != 0 ? r68.f : null, (14680063 & 64) != 0 ? r68.g : false, (14680063 & 128) != 0 ? r68.h : false, (14680063 & 256) != 0 ? r68.i : false, (14680063 & 512) != 0 ? r68.j : null, (14680063 & 1024) != 0 ? r68.k : false, (14680063 & 2048) != 0 ? r68.l : false, (14680063 & 4096) != 0 ? r68.m : false, (14680063 & 8192) != 0 ? r68.n : null, (14680063 & 16384) != 0 ? r68.o : null, (14680063 & 32768) != 0 ? r68.p : false, (14680063 & 65536) != 0 ? r68.q : null, (14680063 & 131072) != 0 ? r68.r : false, (14680063 & 262144) != 0 ? r68.s : 0, (14680063 & 524288) != 0 ? r68.t : false, (14680063 & 1048576) != 0 ? r68.u : false, (14680063 & 2097152) != 0 ? r68.v : null, (14680063 & 4194304) != 0 ? r68.w : null, (14680063 & 8388608) != 0 ? r68.x : false)));
                InterfaceC13727gj0 interfaceC13727gj0 = C10747c78.this.g;
                int botId = C10747c78.this.G1().getBotId();
                Integer numD = AbstractC6392Nk0.d(this.d);
                String str = this.e;
                this.b = 1;
                Object objF = interfaceC13727gj0.f(botId, numD, str, this);
                if (objF == objE) {
                    return objE;
                }
                objL = objF;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objL = ((C9475a16) obj).l();
            }
            C10747c78 c10747c78 = C10747c78.this;
            if (C9475a16.j(objL)) {
                boolean zBooleanValue = ((Boolean) objL).booleanValue();
                InterfaceC9336Zm4 interfaceC9336Zm42 = c10747c78.z;
                do {
                    value3 = interfaceC9336Zm42.getValue();
                    r683 = (R68) value3;
                    bVar = AbstractC10213bG6.b.b;
                    C17637nI7 c17637nI7 = null;
                    if (zBooleanValue) {
                        C17637nI7 c17637nI72 = c10747c78.u;
                        if (c17637nI72 == null) {
                            AbstractC13042fc3.y("bot");
                        } else {
                            c17637nI7 = c17637nI72;
                        }
                        aVar = new AbstractC13801gq4.a(c17637nI7.u0().getPeerId());
                    } else {
                        aVar = null;
                    }
                } while (!interfaceC9336Zm42.f(value3, r683.a((14680063 & 1) != 0 ? r683.a : null, (14680063 & 2) != 0 ? r683.b : null, (14680063 & 4) != 0 ? r683.c : false, (14680063 & 8) != 0 ? r683.d : null, (14680063 & 16) != 0 ? r683.e : false, (14680063 & 32) != 0 ? r683.f : null, (14680063 & 64) != 0 ? r683.g : false, (14680063 & 128) != 0 ? r683.h : false, (14680063 & 256) != 0 ? r683.i : false, (14680063 & 512) != 0 ? r683.j : null, (14680063 & 1024) != 0 ? r683.k : false, (14680063 & 2048) != 0 ? r683.l : false, (14680063 & 4096) != 0 ? r683.m : false, (14680063 & 8192) != 0 ? r683.n : null, (14680063 & 16384) != 0 ? r683.o : bVar, (14680063 & 32768) != 0 ? r683.p : false, (14680063 & 65536) != 0 ? r683.q : null, (14680063 & 131072) != 0 ? r683.r : false, (14680063 & 262144) != 0 ? r683.s : 0, (14680063 & 524288) != 0 ? r683.t : false, (14680063 & 1048576) != 0 ? r683.u : false, (14680063 & 2097152) != 0 ? r683.v : null, (14680063 & 4194304) != 0 ? r683.w : aVar, (14680063 & 8388608) != 0 ? r683.x : false)));
            }
            C10747c78 c10747c782 = C10747c78.this;
            if (C9475a16.e(objL) != null) {
                InterfaceC9336Zm4 interfaceC9336Zm43 = c10747c782.z;
                do {
                    value2 = interfaceC9336Zm43.getValue();
                    r682 = (R68) value2;
                } while (!interfaceC9336Zm43.f(value2, r682.a((14680063 & 1) != 0 ? r682.a : null, (14680063 & 2) != 0 ? r682.b : null, (14680063 & 4) != 0 ? r682.c : false, (14680063 & 8) != 0 ? r682.d : null, (14680063 & 16) != 0 ? r682.e : false, (14680063 & 32) != 0 ? r682.f : null, (14680063 & 64) != 0 ? r682.g : false, (14680063 & 128) != 0 ? r682.h : false, (14680063 & 256) != 0 ? r682.i : false, (14680063 & 512) != 0 ? r682.j : null, (14680063 & 1024) != 0 ? r682.k : false, (14680063 & 2048) != 0 ? r682.l : false, (14680063 & 4096) != 0 ? r682.m : false, (14680063 & 8192) != 0 ? r682.n : null, (14680063 & 16384) != 0 ? r682.o : AbstractC10213bG6.a.b, (14680063 & 32768) != 0 ? r682.p : false, (14680063 & 65536) != 0 ? r682.q : null, (14680063 & 131072) != 0 ? r682.r : false, (14680063 & 262144) != 0 ? r682.s : 0, (14680063 & 524288) != 0 ? r682.t : false, (14680063 & 1048576) != 0 ? r682.u : false, (14680063 & 2097152) != 0 ? r682.v : null, (14680063 & 4194304) != 0 ? r682.w : null, (14680063 & 8388608) != 0 ? r682.x : false)));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((s) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.c78$t */
    static final class t extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        t(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10747c78.this.new t(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE;
            Object objE2 = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC11621dJ7 interfaceC11621dJ7 = C10747c78.this.f;
                int botId = C10747c78.this.G1().getBotId();
                this.b = 1;
                objE = interfaceC11621dJ7.e(botId, this);
                if (objE == objE2) {
                    return objE2;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objE = ((C9475a16) obj).l();
            }
            C10747c78 c10747c78 = C10747c78.this;
            if (C9475a16.j(objE)) {
                c10747c78.I2();
            }
            C10747c78.this.z1();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((t) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C10747c78(HG2 hg2, C21855uF2 c21855uF2, C24554yo6 c24554yo6, C3368Ao6 c3368Ao6, InterfaceC11621dJ7 interfaceC11621dJ7, InterfaceC13727gj0 interfaceC13727gj0, C6409Nm c6409Nm, C19711qo6 c19711qo6, SettingsModule settingsModule, LE le, Context context, int i2, WebAppArguments webAppArguments, InterfaceC3570Bk5 interfaceC3570Bk5, E84 e84, FD7 fd7, KF3 kf3, InterfaceC20315ro1 interfaceC20315ro1, C15753k68 c15753k68) {
        AbstractC13042fc3.i(hg2, "getWebAppUrlUseCase");
        AbstractC13042fc3.i(c21855uF2, "getAvatarFileSystemRefUseCase");
        AbstractC13042fc3.i(c24554yo6, "sendInvokeCustomMethodUseCase");
        AbstractC13042fc3.i(c3368Ao6, "sendMiniAppDataUseCase");
        AbstractC13042fc3.i(interfaceC11621dJ7, "userRepository");
        AbstractC13042fc3.i(interfaceC13727gj0, "botRepository");
        AbstractC13042fc3.i(c6409Nm, "analyticsRepository");
        AbstractC13042fc3.i(c19711qo6, "sendContactUseCase");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(le, "appShortcutHelper");
        AbstractC13042fc3.i(context, "appContext");
        AbstractC13042fc3.i(webAppArguments, "argument");
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferences");
        AbstractC13042fc3.i(e84, "messagesModule");
        AbstractC13042fc3.i(fd7, "updateGateway");
        AbstractC13042fc3.i(kf3, "loadAndGetMyUserVmUseCase");
        AbstractC13042fc3.i(interfaceC20315ro1, "applicationScope");
        AbstractC13042fc3.i(c15753k68, "minimizeManager");
        this.b = hg2;
        this.c = c21855uF2;
        this.d = c24554yo6;
        this.e = c3368Ao6;
        this.f = interfaceC11621dJ7;
        this.g = interfaceC13727gj0;
        this.h = c6409Nm;
        this.i = c19711qo6;
        this.j = settingsModule;
        this.k = le;
        this.l = context;
        this.m = i2;
        this.n = webAppArguments;
        this.o = interfaceC3570Bk5;
        this.p = e84;
        this.q = fd7;
        this.r = kf3;
        this.s = interfaceC20315ro1;
        this.t = c15753k68;
        boolean isRestore = webAppArguments.getIsRestore();
        this.v = isRestore;
        this.w = System.currentTimeMillis();
        this.z = AbstractC12281eL6.a(new R68(null, null, false, null, false, null, false, false, false, null, false, false, false, null, null, false, null, false, 0, false, false, null, null, false, 16777215, null));
        H2();
        if (isRestore) {
            x2();
        }
        if (C8386Vt0.a.P4()) {
            D1();
        }
        this.A = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.a78
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Boolean.valueOf(C10747c78.U1(this.a));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean B1() {
        WebAppType webAppType = this.n.getWebAppType();
        if ((webAppType instanceof WebAppType.Main) || (webAppType instanceof WebAppType.Menu)) {
            return true;
        }
        if ((webAppType instanceof WebAppType.Bot) || (webAppType instanceof WebAppType.DirectLink)) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void D1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new d(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 D2(SA2 sa2, Throwable th) {
        AbstractC13042fc3.i(sa2, "$invokeOnCompletion");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PendingIntent F1(WeakReference weakReference) {
        AbstractC4277El1.c(this.l, new ShortcutShortcutReceiver(weakReference), new IntentFilter("android.intent.action.CREATE_SHORTCUT"), false, 4, null);
        PendingIntent broadcast = PendingIntent.getBroadcast(this.l, 0, new Intent("android.intent.action.CREATE_SHORTCUT"), 67108864);
        AbstractC13042fc3.h(broadcast, "getBroadcast(...)");
        return broadcast;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F2() {
        ExPeerType exPeerType;
        long jCurrentTimeMillis = (System.currentTimeMillis() - this.w) / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
        C6409Nm c6409Nm = this.h;
        XV4 xv4A = AbstractC4616Fw7.a("peer_id", Integer.valueOf(this.n.getBotId()));
        ExPeer chatExPeer = this.n.getChatExPeer();
        c6409Nm.d("mini_apps", AbstractC20051rO3.n(xv4A, AbstractC4616Fw7.a("peer_type", Integer.valueOf((chatExPeer == null || (exPeerType = chatExPeer.getExPeerType()) == null) ? ExPeerType.BOT.getValue() : exPeerType.getValue())), AbstractC4616Fw7.a("duration_seconds", Long.valueOf(jCurrentTimeMillis)), AbstractC4616Fw7.a("action_type", Integer.valueOf(H48.j.j())), AbstractC4616Fw7.a("random_id", Integer.valueOf(this.n.getEventRandomId()))));
    }

    private final C21753u45.g H1(List list) {
        boolean zContains = list.contains("android.webkit.resource.AUDIO_CAPTURE");
        boolean zContains2 = list.contains("android.webkit.resource.VIDEO_CAPTURE");
        if (zContains && zContains2) {
            return C21753u45.g.h;
        }
        if (zContains) {
            return C21753u45.g.f;
        }
        if (zContains2) {
            return C21753u45.g.e;
        }
        return null;
    }

    private final void H2() {
        C6409Nm c6409Nm = this.h;
        XV4 xv4A = AbstractC4616Fw7.a("peer_id", Integer.valueOf(this.n.getBotId()));
        XV4 xv4A2 = AbstractC4616Fw7.a("peer_type", Integer.valueOf(ExPeerType.BOT.getValue()));
        XV4 xv4A3 = AbstractC4616Fw7.a("action_type", Integer.valueOf(this.n.getOpenType().j()));
        XV4 xv4A4 = AbstractC4616Fw7.a("random_id", Integer.valueOf(this.n.getEventRandomId()));
        String strL1 = L1();
        if (strL1 == null) {
            strL1 = "";
        }
        c6409Nm.d("mini_apps", AbstractC20051rO3.n(xv4A, xv4A2, xv4A3, xv4A4, AbstractC4616Fw7.a("link_title", strL1)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I2() {
        E84 e84 = this.p;
        C17637nI7 c17637nI7 = this.u;
        if (c17637nI7 == null) {
            AbstractC13042fc3.y("bot");
            c17637nI7 = null;
        }
        e84.A2(c17637nI7.u0(), "/start", null, true, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AbstractC9256Zd5 K1() {
        AbstractC9256Zd5 cVar;
        WebAppType webAppType = this.n.getWebAppType();
        C17637nI7 c17637nI7 = null;
        if (webAppType instanceof WebAppType.Menu) {
            C17637nI7 c17637nI72 = this.u;
            if (c17637nI72 == null) {
                AbstractC13042fc3.y("bot");
            } else {
                c17637nI7 = c17637nI72;
            }
            cVar = new AbstractC9256Zd5.d(c17637nI7.u0().getPeerId());
        } else {
            if (!(webAppType instanceof WebAppType.Main)) {
                if ((webAppType instanceof WebAppType.Bot) || (webAppType instanceof WebAppType.DirectLink)) {
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }
            C17637nI7 c17637nI73 = this.u;
            if (c17637nI73 == null) {
                AbstractC13042fc3.y("bot");
            } else {
                c17637nI7 = c17637nI73;
            }
            cVar = new AbstractC9256Zd5.c(c17637nI7.u0().getPeerId());
        }
        return cVar;
    }

    private final void K2(long j2) {
        this.h.d("mini_apps", AbstractC20051rO3.n(AbstractC4616Fw7.a("peer_id", Integer.valueOf(this.n.getBotId())), AbstractC4616Fw7.a("peer_type", Integer.valueOf(ExPeerType.BOT.getValue())), AbstractC4616Fw7.a("duration_seconds", Long.valueOf(j2)), AbstractC4616Fw7.a("random_id", Integer.valueOf(this.n.getEventRandomId()))));
    }

    private final String L1() {
        WebAppType webAppType = this.n.getWebAppType();
        WebAppType.DirectLink directLink = webAppType instanceof WebAppType.DirectLink ? (WebAppType.DirectLink) webAppType : null;
        if (directLink != null) {
            return directLink.getShortName();
        }
        return null;
    }

    private final void L2(EnumC18117o68 enumC18117o68) {
        this.h.d("mini_apps", AbstractC20051rO3.n(AbstractC4616Fw7.a("peer_id", Integer.valueOf(this.n.getBotId())), AbstractC4616Fw7.a("peer_type", Integer.valueOf(ExPeerType.BOT.getValue())), AbstractC4616Fw7.a("event_type", Integer.valueOf(enumC18117o68.j())), AbstractC4616Fw7.a("random_id", Integer.valueOf(this.n.getEventRandomId()))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object N1(ir.nasim.InterfaceC20295rm1 r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof ir.nasim.C10747c78.f
            if (r0 == 0) goto L13
            r0 = r12
            ir.nasim.c78$f r0 = (ir.nasim.C10747c78.f) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            ir.nasim.c78$f r0 = new ir.nasim.c78$f
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.d
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.f
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            boolean r1 = r0.c
            int r2 = r0.b
            java.lang.Object r0 = r0.a
            ir.nasim.c78 r0 = (ir.nasim.C10747c78) r0
            ir.nasim.AbstractC10685c16.b(r12)
            goto L9a
        L31:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L39:
            ir.nasim.AbstractC10685c16.b(r12)
            ir.nasim.E84 r12 = r11.p
            ir.nasim.core.model.webapp.WebAppArguments r2 = r11.n
            int r2 = r2.getBotId()
            ir.nasim.d25 r2 = ir.nasim.C11458d25.E(r2)
            ir.nasim.In1 r12 = r12.B0(r2)
            ir.nasim.Wh0 r12 = r12.e()
            java.lang.Object r12 = r12.b()
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            if (r12 == 0) goto L5e
            boolean r12 = r12.booleanValue()
            r2 = r12
            goto L5f
        L5e:
            r2 = r3
        L5f:
            ir.nasim.H48 r4 = ir.nasim.H48.c
            ir.nasim.H48 r5 = ir.nasim.H48.e
            ir.nasim.H48 r6 = ir.nasim.H48.i
            ir.nasim.H48 r7 = ir.nasim.H48.d
            ir.nasim.H48 r8 = ir.nasim.H48.f
            ir.nasim.H48 r9 = ir.nasim.H48.g
            ir.nasim.H48 r10 = ir.nasim.H48.h
            ir.nasim.H48[] r12 = new ir.nasim.H48[]{r4, r5, r6, r7, r8, r9, r10}
            java.util.Set r12 = ir.nasim.AbstractC4129Du6.i(r12)
            ir.nasim.core.model.webapp.WebAppArguments r4 = r11.n
            ir.nasim.H48 r4 = r4.getOpenType()
            boolean r12 = r12.contains(r4)
            ir.nasim.dJ7 r4 = r11.f
            ir.nasim.core.model.webapp.WebAppArguments r5 = r11.n
            int r5 = r5.getBotId()
            long r5 = (long) r5
            r0.a = r11
            r0.b = r2
            r0.c = r12
            r0.f = r3
            java.lang.Object r0 = r4.m(r5, r0)
            if (r0 != r1) goto L97
            return r1
        L97:
            r1 = r12
            r12 = r0
            r0 = r11
        L9a:
            ir.nasim.tK7 r12 = (ir.nasim.C21231tK7) r12
            r4 = 0
            if (r12 == 0) goto Lac
            ir.nasim.Wh0 r12 = r12.p()
            if (r12 == 0) goto Lac
            java.lang.Object r12 = r12.b()
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            goto Lad
        Lac:
            r12 = r4
        Lad:
            java.lang.Boolean r3 = ir.nasim.AbstractC6392Nk0.a(r3)
            boolean r12 = ir.nasim.AbstractC13042fc3.d(r12, r3)
            if (r12 == 0) goto Lba
            ir.nasim.Y48$f r4 = ir.nasim.Y48.f.a
            goto Ld7
        Lba:
            if (r2 == 0) goto Ld1
            if (r1 == 0) goto Ld1
            ir.nasim.core.modules.settings.SettingsModule r12 = r0.j
            boolean r12 = r12.u2()
            if (r12 != 0) goto Ld1
            ir.nasim.Vt0 r12 = ir.nasim.C8386Vt0.a
            boolean r12 = r12.wa()
            if (r12 == 0) goto Ld1
            ir.nasim.Y48$e r4 = ir.nasim.Y48.e.a
            goto Ld7
        Ld1:
            if (r2 == 0) goto Ld7
            if (r1 == 0) goto Ld7
            ir.nasim.Y48$a r4 = ir.nasim.Y48.a.a
        Ld7:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10747c78.N1(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WebAppRestoreState O1(R68 r68) {
        return new WebAppRestoreState(r68.s(), r68.c(), r68.l(), r68.m(), r68.k(), r68.p(), r68.i(), r68.t(), r68.v(), r68.j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0159 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x01ff -> B:13:0x003b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object P1(ir.nasim.C24732z68 r41, ir.nasim.C23270we2 r42, ir.nasim.InterfaceC20295rm1 r43) {
        /*
            Method dump skipped, instructions count: 547
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10747c78.P1(ir.nasim.z68, ir.nasim.we2, ir.nasim.rm1):java.lang.Object");
    }

    private final boolean Q1(C21753u45.g gVar) {
        int i2 = b.a[gVar.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (!C8386Vt0.Zb() && !C8386Vt0.nc()) {
                        return true;
                    }
                } else if (!C8386Vt0.fc()) {
                    return true;
                }
            } else if (!C8386Vt0.nc()) {
                return true;
            }
        } else if (!C8386Vt0.Zb()) {
            return true;
        }
        return AbstractC20762sZ6.X(this.j.G4(), String.valueOf(this.n.getBotId()), false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean U1(C10747c78 c10747c78) {
        AbstractC13042fc3.i(c10747c78, "this$0");
        return c10747c78.o.h("PREF_KEY_WEB_VIEW_DEBUG_OPTION", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U2() {
        Object value;
        R68 r68;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.z;
        do {
            value = interfaceC9336Zm4.getValue();
            r68 = (R68) value;
        } while (!interfaceC9336Zm4.f(value, r68.a((14680063 & 1) != 0 ? r68.a : null, (14680063 & 2) != 0 ? r68.b : null, (14680063 & 4) != 0 ? r68.c : false, (14680063 & 8) != 0 ? r68.d : null, (14680063 & 16) != 0 ? r68.e : false, (14680063 & 32) != 0 ? r68.f : null, (14680063 & 64) != 0 ? r68.g : false, (14680063 & 128) != 0 ? r68.h : false, (14680063 & 256) != 0 ? r68.i : false, (14680063 & 512) != 0 ? r68.j : null, (14680063 & 1024) != 0 ? r68.k : false, (14680063 & 2048) != 0 ? r68.l : false, (14680063 & 4096) != 0 ? r68.m : false, (14680063 & 8192) != 0 ? r68.n : null, (14680063 & 16384) != 0 ? r68.o : null, (14680063 & 32768) != 0 ? r68.p : false, (14680063 & 65536) != 0 ? r68.q : null, (14680063 & 131072) != 0 ? r68.r : false, (14680063 & 262144) != 0 ? r68.s : 0, (14680063 & 524288) != 0 ? r68.t : false, (14680063 & 1048576) != 0 ? r68.u : false, (14680063 & 2097152) != 0 ? r68.v : null, (14680063 & 4194304) != 0 ? r68.w : null, (14680063 & 8388608) != 0 ? r68.x : false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object V1(ir.nasim.InterfaceC20295rm1 r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof ir.nasim.C10747c78.h
            if (r0 == 0) goto L14
            r0 = r9
            ir.nasim.c78$h r0 = (ir.nasim.C10747c78.h) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.d = r1
        L12:
            r5 = r0
            goto L1a
        L14:
            ir.nasim.c78$h r0 = new ir.nasim.c78$h
            r0.<init>(r9)
            goto L12
        L1a:
            java.lang.Object r9 = r5.b
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r5.d
            r2 = 1
            if (r1 == 0) goto L3d
            if (r1 != r2) goto L35
            java.lang.Object r0 = r5.a
            ir.nasim.c78 r0 = (ir.nasim.C10747c78) r0
            ir.nasim.AbstractC10685c16.b(r9)
            ir.nasim.a16 r9 = (ir.nasim.C9475a16) r9
            java.lang.Object r9 = r9.l()
            goto L5a
        L35:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L3d:
            ir.nasim.AbstractC10685c16.b(r9)
            ir.nasim.dJ7 r1 = r8.f
            ir.nasim.core.model.webapp.WebAppArguments r9 = r8.n
            int r9 = r9.getBotId()
            long r3 = (long) r9
            r5.a = r8
            r5.d = r2
            r9 = 0
            r6 = 2
            r7 = 0
            r2 = r3
            r4 = r9
            java.lang.Object r9 = ir.nasim.InterfaceC11621dJ7.q(r1, r2, r4, r5, r6, r7)
            if (r9 != r0) goto L59
            return r0
        L59:
            r0 = r8
        L5a:
            ir.nasim.C9475a16.g(r9)
            ir.nasim.dJ7 r9 = r0.f
            ir.nasim.core.model.webapp.WebAppArguments r0 = r0.n
            int r0 = r0.getBotId()
            long r0 = (long) r0
            ir.nasim.nI7 r9 = r9.p(r0)
            if (r9 == 0) goto L6d
            return r9
        L6d:
            r9 = 0
            java.lang.Object[] r9 = new java.lang.Object[r9]
            java.lang.String r0 = "WEBAPP"
            java.lang.String r1 = "Cant load bot."
            ir.nasim.C19406qI3.a(r0, r1, r9)
            r9 = 0
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10747c78.V1(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final R68 b3(R68 r68, WebAppRestoreState webAppRestoreState) {
        return r68.a((14680063 & 1) != 0 ? r68.a : webAppRestoreState.getWebAppUrl(), (14680063 & 2) != 0 ? r68.b : webAppRestoreState.getWebAppName(), (14680063 & 4) != 0 ? r68.c : true, (14680063 & 8) != 0 ? r68.d : webAppRestoreState.getScreenMode(), (14680063 & 16) != 0 ? r68.e : true, (14680063 & 32) != 0 ? r68.f : null, (14680063 & 64) != 0 ? r68.g : webAppRestoreState.getShowBackButton(), (14680063 & 128) != 0 ? r68.h : webAppRestoreState.getShowSettingButton(), (14680063 & 256) != 0 ? r68.i : webAppRestoreState.getShowAddToHomeScreenButton(), (14680063 & 512) != 0 ? r68.j : webAppRestoreState.getToolbarColor(), (14680063 & 1024) != 0 ? r68.k : false, (14680063 & 2048) != 0 ? r68.l : false, (14680063 & 4096) != 0 ? r68.m : webAppRestoreState.getNeedToConfirmForClose(), (14680063 & 8192) != 0 ? r68.n : null, (14680063 & 16384) != 0 ? r68.o : null, (14680063 & 32768) != 0 ? r68.p : webAppRestoreState.getWebViewDebuggingEnabled(), (14680063 & 65536) != 0 ? r68.q : null, (14680063 & 131072) != 0 ? r68.r : false, (14680063 & 262144) != 0 ? r68.s : 0, (14680063 & 524288) != 0 ? r68.t : true, (14680063 & 1048576) != 0 ? r68.u : false, (14680063 & 2097152) != 0 ? r68.v : null, (14680063 & 4194304) != 0 ? r68.w : null, (14680063 & 8388608) != 0 ? r68.x : false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i2(GeolocationPermissions.Callback callback, String str, SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onPermissionGranted");
        if (callback != null) {
            callback.invoke(str, true, false);
        }
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j2(GeolocationPermissions.Callback callback, String str) {
        if (callback != null) {
            callback.invoke(str, false, false);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m2(PermissionRequest permissionRequest, List list, C10747c78 c10747c78, C21753u45.g gVar) {
        AbstractC13042fc3.i(permissionRequest, "$permissionRequest");
        AbstractC13042fc3.i(list, "$resources");
        AbstractC13042fc3.i(c10747c78, "this$0");
        AbstractC13042fc3.i(gVar, "$type");
        permissionRequest.grant((String[]) list.toArray(new String[0]));
        c10747c78.r2(gVar);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n2(PermissionRequest permissionRequest) {
        AbstractC13042fc3.i(permissionRequest, "$permissionRequest");
        permissionRequest.deny();
        return C19938rB7.a;
    }

    private final void r2(C21753u45.g gVar) {
        L2(EnumC18117o68.b.a(gVar));
    }

    private final void x2() {
        Object value;
        R68 r68;
        C17637nI7 c17637nI7A;
        C4226Ef4 c4226Ef4D = this.t.d();
        if (c4226Ef4D != null && (c17637nI7A = c4226Ef4D.a()) != null) {
            this.u = c17637nI7A;
            return;
        }
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.z;
        do {
            value = interfaceC9336Zm4.getValue();
            r68 = (R68) value;
        } while (!interfaceC9336Zm4.f(value, r68.a((14680063 & 1) != 0 ? r68.a : null, (14680063 & 2) != 0 ? r68.b : null, (14680063 & 4) != 0 ? r68.c : false, (14680063 & 8) != 0 ? r68.d : null, (14680063 & 16) != 0 ? r68.e : false, (14680063 & 32) != 0 ? r68.f : null, (14680063 & 64) != 0 ? r68.g : false, (14680063 & 128) != 0 ? r68.h : false, (14680063 & 256) != 0 ? r68.i : false, (14680063 & 512) != 0 ? r68.j : null, (14680063 & 1024) != 0 ? r68.k : true, (14680063 & 2048) != 0 ? r68.l : false, (14680063 & 4096) != 0 ? r68.m : false, (14680063 & 8192) != 0 ? r68.n : AbstractC20942sr7.a.b, (14680063 & 16384) != 0 ? r68.o : null, (14680063 & 32768) != 0 ? r68.p : false, (14680063 & 65536) != 0 ? r68.q : null, (14680063 & 131072) != 0 ? r68.r : false, (14680063 & 262144) != 0 ? r68.s : 0, (14680063 & 524288) != 0 ? r68.t : false, (14680063 & 1048576) != 0 ? r68.u : false, (14680063 & 2097152) != 0 ? r68.v : null, (14680063 & 4194304) != 0 ? r68.w : null, (14680063 & 8388608) != 0 ? r68.x : false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z1() {
        Object value;
        R68 r68;
        this.j.X6(true);
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.z;
        do {
            value = interfaceC9336Zm4.getValue();
            r68 = (R68) value;
        } while (!interfaceC9336Zm4.f(value, r68.a((14680063 & 1) != 0 ? r68.a : null, (14680063 & 2) != 0 ? r68.b : null, (14680063 & 4) != 0 ? r68.c : true, (14680063 & 8) != 0 ? r68.d : null, (14680063 & 16) != 0 ? r68.e : false, (14680063 & 32) != 0 ? r68.f : null, (14680063 & 64) != 0 ? r68.g : false, (14680063 & 128) != 0 ? r68.h : false, (14680063 & 256) != 0 ? r68.i : false, (14680063 & 512) != 0 ? r68.j : null, (14680063 & 1024) != 0 ? r68.k : false, (14680063 & 2048) != 0 ? r68.l : false, (14680063 & 4096) != 0 ? r68.m : false, (14680063 & 8192) != 0 ? r68.n : null, (14680063 & 16384) != 0 ? r68.o : null, (14680063 & 32768) != 0 ? r68.p : false, (14680063 & 65536) != 0 ? r68.q : null, (14680063 & 131072) != 0 ? r68.r : false, (14680063 & 262144) != 0 ? r68.s : 0, (14680063 & 524288) != 0 ? r68.t : false, (14680063 & 1048576) != 0 ? r68.u : false, (14680063 & 2097152) != 0 ? r68.v : null, (14680063 & 4194304) != 0 ? r68.w : null, (14680063 & 8388608) != 0 ? r68.x : false)));
    }

    public final void A1(String str) {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new c(str, null), 3, null);
    }

    public final void A2(String str) {
        AbstractC13042fc3.i(str, "data");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new p(str, null), 3, null);
    }

    public final void C1() {
        Object value;
        R68 r68;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.z;
        do {
            value = interfaceC9336Zm4.getValue();
            r68 = (R68) value;
        } while (!interfaceC9336Zm4.f(value, r68.a((14680063 & 1) != 0 ? r68.a : null, (14680063 & 2) != 0 ? r68.b : null, (14680063 & 4) != 0 ? r68.c : false, (14680063 & 8) != 0 ? r68.d : null, (14680063 & 16) != 0 ? r68.e : false, (14680063 & 32) != 0 ? r68.f : null, (14680063 & 64) != 0 ? r68.g : false, (14680063 & 128) != 0 ? r68.h : false, (14680063 & 256) != 0 ? r68.i : false, (14680063 & 512) != 0 ? r68.j : null, (14680063 & 1024) != 0 ? r68.k : false, (14680063 & 2048) != 0 ? r68.l : false, (14680063 & 4096) != 0 ? r68.m : false, (14680063 & 8192) != 0 ? r68.n : null, (14680063 & 16384) != 0 ? r68.o : null, (14680063 & 32768) != 0 ? r68.p : false, (14680063 & 65536) != 0 ? r68.q : null, (14680063 & 131072) != 0 ? r68.r : false, (14680063 & 262144) != 0 ? r68.s : 0, (14680063 & 524288) != 0 ? r68.t : false, (14680063 & 1048576) != 0 ? r68.u : true, (14680063 & 2097152) != 0 ? r68.v : null, (14680063 & 4194304) != 0 ? r68.w : null, (14680063 & 8388608) != 0 ? r68.x : false)));
    }

    public final void C2(String str, String str2, UA2 ua2, UA2 ua22, final SA2 sa2) {
        AbstractC13042fc3.i(str, "methodName");
        AbstractC13042fc3.i(str2, "params");
        AbstractC13042fc3.i(ua2, "successCallBack");
        AbstractC13042fc3.i(ua22, "errorCallBack");
        AbstractC13042fc3.i(sa2, "invokeOnCompletion");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new q(str, str2, ua2, ua22, null), 3, null).s(new UA2() { // from class: ir.nasim.b78
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C10747c78.D2(sa2, (Throwable) obj);
            }
        });
    }

    public final void E1(WeakReference weakReference) {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new e(weakReference, null), 3, null);
    }

    public final void E2() {
        ExPeerType exPeerType;
        C6409Nm c6409Nm = this.h;
        XV4 xv4A = AbstractC4616Fw7.a("peer_id", Integer.valueOf(this.n.getBotId()));
        ExPeer chatExPeer = this.n.getChatExPeer();
        c6409Nm.d("mini_apps", AbstractC20051rO3.n(xv4A, AbstractC4616Fw7.a("peer_type", Integer.valueOf((chatExPeer == null || (exPeerType = chatExPeer.getExPeerType()) == null) ? ExPeerType.BOT.getValue() : exPeerType.getValue())), AbstractC4616Fw7.a("action_type", Integer.valueOf(H48.k.j())), AbstractC4616Fw7.a("random_id", Integer.valueOf(this.n.getEventRandomId()))));
    }

    public final WebAppArguments G1() {
        return this.n;
    }

    public final void G2(EnumC8066Uj4 enumC8066Uj4) {
        AbstractC13042fc3.i(enumC8066Uj4, "eventType");
        this.h.d("mini_apps", AbstractC20051rO3.n(AbstractC4616Fw7.a("peer_id", Integer.valueOf(this.n.getBotId())), AbstractC4616Fw7.a("peer_type", Integer.valueOf(ExPeerType.BOT.getValue())), AbstractC4616Fw7.a("event_type", Integer.valueOf(enumC8066Uj4.j())), AbstractC4616Fw7.a("random_id", Integer.valueOf(this.n.getEventRandomId()))));
    }

    public final C12144e68 I1() {
        C4226Ef4 c4226Ef4D = this.t.d();
        if (c4226Ef4D != null) {
            return c4226Ef4D.d();
        }
        return null;
    }

    public final WebView J1() {
        C4226Ef4 c4226Ef4D = this.t.d();
        if (c4226Ef4D != null) {
            return c4226Ef4D.c();
        }
        return null;
    }

    public final void J2(String str) {
        AbstractC13042fc3.i(str, "methodName");
        this.h.d("miniapp_callbacks", AbstractC20051rO3.n(AbstractC4616Fw7.a("peer_id", Integer.valueOf(this.n.getBotId())), AbstractC4616Fw7.a("peer_type", Integer.valueOf(ExPeerType.BOT.getValue())), AbstractC4616Fw7.a("type", str), AbstractC4616Fw7.a("random_id", Integer.valueOf(this.n.getEventRandomId()))));
    }

    public final InterfaceC10258bL6 M1() {
        return this.z;
    }

    public final void M2(boolean z) {
        Object value;
        R68 r68;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.z;
        do {
            value = interfaceC9336Zm4.getValue();
            r68 = (R68) value;
        } while (!interfaceC9336Zm4.f(value, r68.a((14680063 & 1) != 0 ? r68.a : null, (14680063 & 2) != 0 ? r68.b : null, (14680063 & 4) != 0 ? r68.c : false, (14680063 & 8) != 0 ? r68.d : null, (14680063 & 16) != 0 ? r68.e : false, (14680063 & 32) != 0 ? r68.f : null, (14680063 & 64) != 0 ? r68.g : false, (14680063 & 128) != 0 ? r68.h : false, (14680063 & 256) != 0 ? r68.i : false, (14680063 & 512) != 0 ? r68.j : null, (14680063 & 1024) != 0 ? r68.k : false, (14680063 & 2048) != 0 ? r68.l : false, (14680063 & 4096) != 0 ? r68.m : z, (14680063 & 8192) != 0 ? r68.n : null, (14680063 & 16384) != 0 ? r68.o : null, (14680063 & 32768) != 0 ? r68.p : false, (14680063 & 65536) != 0 ? r68.q : null, (14680063 & 131072) != 0 ? r68.r : false, (14680063 & 262144) != 0 ? r68.s : 0, (14680063 & 524288) != 0 ? r68.t : false, (14680063 & 1048576) != 0 ? r68.u : false, (14680063 & 2097152) != 0 ? r68.v : null, (14680063 & 4194304) != 0 ? r68.w : null, (14680063 & 8388608) != 0 ? r68.x : false)));
    }

    public final void N2(EnumC23552x68 enumC23552x68) {
        AbstractC13042fc3.i(enumC23552x68, "screenMode");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.z;
        while (true) {
            Object value = interfaceC9336Zm4.getValue();
            R68 r68 = (R68) value;
            InterfaceC9336Zm4 interfaceC9336Zm42 = interfaceC9336Zm4;
            if (interfaceC9336Zm42.f(value, r68.a((14680063 & 1) != 0 ? r68.a : null, (14680063 & 2) != 0 ? r68.b : null, (14680063 & 4) != 0 ? r68.c : false, (14680063 & 8) != 0 ? r68.d : enumC23552x68, (14680063 & 16) != 0 ? r68.e : false, (14680063 & 32) != 0 ? r68.f : null, (14680063 & 64) != 0 ? r68.g : false, (14680063 & 128) != 0 ? r68.h : false, (14680063 & 256) != 0 ? r68.i : false, (14680063 & 512) != 0 ? r68.j : null, (14680063 & 1024) != 0 ? r68.k : false, (14680063 & 2048) != 0 ? r68.l : false, (14680063 & 4096) != 0 ? r68.m : false, (14680063 & 8192) != 0 ? r68.n : null, (14680063 & 16384) != 0 ? r68.o : null, (14680063 & 32768) != 0 ? r68.p : false, (14680063 & 65536) != 0 ? r68.q : null, (14680063 & 131072) != 0 ? r68.r : false, (14680063 & 262144) != 0 ? r68.s : 0, (14680063 & 524288) != 0 ? r68.t : false, (14680063 & 1048576) != 0 ? r68.u : false, (14680063 & 2097152) != 0 ? r68.v : null, (14680063 & 4194304) != 0 ? r68.w : null, (14680063 & 8388608) != 0 ? r68.x : false))) {
                return;
            } else {
                interfaceC9336Zm4 = interfaceC9336Zm42;
            }
        }
    }

    public final void O2(boolean z) {
        Object value;
        R68 r68;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.z;
        do {
            value = interfaceC9336Zm4.getValue();
            r68 = (R68) value;
        } while (!interfaceC9336Zm4.f(value, r68.a((14680063 & 1) != 0 ? r68.a : null, (14680063 & 2) != 0 ? r68.b : null, (14680063 & 4) != 0 ? r68.c : false, (14680063 & 8) != 0 ? r68.d : null, (14680063 & 16) != 0 ? r68.e : false, (14680063 & 32) != 0 ? r68.f : null, (14680063 & 64) != 0 ? r68.g : z, (14680063 & 128) != 0 ? r68.h : false, (14680063 & 256) != 0 ? r68.i : false, (14680063 & 512) != 0 ? r68.j : null, (14680063 & 1024) != 0 ? r68.k : false, (14680063 & 2048) != 0 ? r68.l : false, (14680063 & 4096) != 0 ? r68.m : false, (14680063 & 8192) != 0 ? r68.n : null, (14680063 & 16384) != 0 ? r68.o : null, (14680063 & 32768) != 0 ? r68.p : false, (14680063 & 65536) != 0 ? r68.q : null, (14680063 & 131072) != 0 ? r68.r : false, (14680063 & 262144) != 0 ? r68.s : 0, (14680063 & 524288) != 0 ? r68.t : false, (14680063 & 1048576) != 0 ? r68.u : false, (14680063 & 2097152) != 0 ? r68.v : null, (14680063 & 4194304) != 0 ? r68.w : null, (14680063 & 8388608) != 0 ? r68.x : false)));
    }

    public final void P2(boolean z) {
        Object value;
        R68 r68;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.z;
        do {
            value = interfaceC9336Zm4.getValue();
            r68 = (R68) value;
        } while (!interfaceC9336Zm4.f(value, r68.a((14680063 & 1) != 0 ? r68.a : null, (14680063 & 2) != 0 ? r68.b : null, (14680063 & 4) != 0 ? r68.c : false, (14680063 & 8) != 0 ? r68.d : null, (14680063 & 16) != 0 ? r68.e : false, (14680063 & 32) != 0 ? r68.f : null, (14680063 & 64) != 0 ? r68.g : false, (14680063 & 128) != 0 ? r68.h : z, (14680063 & 256) != 0 ? r68.i : false, (14680063 & 512) != 0 ? r68.j : null, (14680063 & 1024) != 0 ? r68.k : false, (14680063 & 2048) != 0 ? r68.l : false, (14680063 & 4096) != 0 ? r68.m : false, (14680063 & 8192) != 0 ? r68.n : null, (14680063 & 16384) != 0 ? r68.o : null, (14680063 & 32768) != 0 ? r68.p : false, (14680063 & 65536) != 0 ? r68.q : null, (14680063 & 131072) != 0 ? r68.r : false, (14680063 & 262144) != 0 ? r68.s : 0, (14680063 & 524288) != 0 ? r68.t : false, (14680063 & 1048576) != 0 ? r68.u : false, (14680063 & 2097152) != 0 ? r68.v : null, (14680063 & 4194304) != 0 ? r68.w : null, (14680063 & 8388608) != 0 ? r68.x : false)));
    }

    public final void Q2(int i2) {
        Object value;
        R68 r68;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.z;
        do {
            value = interfaceC9336Zm4.getValue();
            r68 = (R68) value;
        } while (!interfaceC9336Zm4.f(value, r68.a((14680063 & 1) != 0 ? r68.a : null, (14680063 & 2) != 0 ? r68.b : null, (14680063 & 4) != 0 ? r68.c : false, (14680063 & 8) != 0 ? r68.d : null, (14680063 & 16) != 0 ? r68.e : false, (14680063 & 32) != 0 ? r68.f : null, (14680063 & 64) != 0 ? r68.g : false, (14680063 & 128) != 0 ? r68.h : false, (14680063 & 256) != 0 ? r68.i : false, (14680063 & 512) != 0 ? r68.j : Integer.valueOf(i2), (14680063 & 1024) != 0 ? r68.k : false, (14680063 & 2048) != 0 ? r68.l : false, (14680063 & 4096) != 0 ? r68.m : false, (14680063 & 8192) != 0 ? r68.n : null, (14680063 & 16384) != 0 ? r68.o : null, (14680063 & 32768) != 0 ? r68.p : false, (14680063 & 65536) != 0 ? r68.q : null, (14680063 & 131072) != 0 ? r68.r : false, (14680063 & 262144) != 0 ? r68.s : 0, (14680063 & 524288) != 0 ? r68.t : false, (14680063 & 1048576) != 0 ? r68.u : false, (14680063 & 2097152) != 0 ? r68.v : null, (14680063 & 4194304) != 0 ? r68.w : null, (14680063 & 8388608) != 0 ? r68.x : false)));
    }

    public final boolean R1() {
        return this.v;
    }

    public final void R2() {
        AbstractC10533bm0.d(this.s, null, null, new r(null), 3, null);
    }

    public final boolean S1() {
        AbstractC9256Zd5 abstractC9256Zd5K1 = K1();
        if (abstractC9256Zd5K1 == null) {
            return false;
        }
        return this.k.b(abstractC9256Zd5K1.b());
    }

    public final void S2() {
        I2();
        z1();
    }

    public final boolean T1() {
        return ((Boolean) this.A.getValue()).booleanValue();
    }

    public final void W1(C24732z68 c24732z68) {
        WebAppArguments webAppArgumentsB;
        AbstractC13042fc3.i(c24732z68, "webAppThemeParams");
        if (this.y) {
            return;
        }
        this.y = true;
        C4226Ef4 c4226Ef4D = this.t.d();
        if (!AbstractC13042fc3.d((c4226Ef4D == null || (webAppArgumentsB = c4226Ef4D.b()) == null) ? null : webAppArgumentsB.f(), this.n.f())) {
            AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new j(c24732z68, null), 3, null);
            return;
        }
        U2();
        C1();
        AbstractC10533bm0.d(this.s, null, null, new i(null), 3, null);
    }

    public final void W2(int i2, String str) {
        AbstractC13042fc3.i(str, "comment");
        AbstractC10533bm0.d(this.s, null, null, new s(i2, str, null), 3, null);
    }

    public final void X1(WebView webView, C12144e68 c12144e68) {
        AbstractC13042fc3.i(webView, "webView");
        AbstractC13042fc3.i(c12144e68, "webAppInterface");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new k(webView, c12144e68, null), 3, null);
    }

    public final void Y1(Boolean bool) {
        Object value;
        R68 r68A;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.z;
        do {
            value = interfaceC9336Zm4.getValue();
            R68 r68 = (R68) value;
            if (bool != null && bool.booleanValue() && r68.i()) {
                r68A = r68.a((14680063 & 1) != 0 ? r68.a : null, (14680063 & 2) != 0 ? r68.b : null, (14680063 & 4) != 0 ? r68.c : false, (14680063 & 8) != 0 ? r68.d : null, (14680063 & 16) != 0 ? r68.e : false, (14680063 & 32) != 0 ? r68.f : null, (14680063 & 64) != 0 ? r68.g : false, (14680063 & 128) != 0 ? r68.h : false, (14680063 & 256) != 0 ? r68.i : false, (14680063 & 512) != 0 ? r68.j : null, (14680063 & 1024) != 0 ? r68.k : false, (14680063 & 2048) != 0 ? r68.l : false, (14680063 & 4096) != 0 ? r68.m : false, (14680063 & 8192) != 0 ? r68.n : null, (14680063 & 16384) != 0 ? r68.o : null, (14680063 & 32768) != 0 ? r68.p : false, (14680063 & 65536) != 0 ? r68.q : Y48.b.a, (14680063 & 131072) != 0 ? r68.r : false, (14680063 & 262144) != 0 ? r68.s : 0, (14680063 & 524288) != 0 ? r68.t : false, (14680063 & 1048576) != 0 ? r68.u : false, (14680063 & 2097152) != 0 ? r68.v : null, (14680063 & 4194304) != 0 ? r68.w : null, (14680063 & 8388608) != 0 ? r68.x : false);
            } else {
                this.t.b(this.n);
                r68A = r68.a((14680063 & 1) != 0 ? r68.a : null, (14680063 & 2) != 0 ? r68.b : null, (14680063 & 4) != 0 ? r68.c : false, (14680063 & 8) != 0 ? r68.d : null, (14680063 & 16) != 0 ? r68.e : false, (14680063 & 32) != 0 ? r68.f : null, (14680063 & 64) != 0 ? r68.g : false, (14680063 & 128) != 0 ? r68.h : false, (14680063 & 256) != 0 ? r68.i : false, (14680063 & 512) != 0 ? r68.j : null, (14680063 & 1024) != 0 ? r68.k : true, (14680063 & 2048) != 0 ? r68.l : false, (14680063 & 4096) != 0 ? r68.m : false, (14680063 & 8192) != 0 ? r68.n : null, (14680063 & 16384) != 0 ? r68.o : null, (14680063 & 32768) != 0 ? r68.p : false, (14680063 & 65536) != 0 ? r68.q : null, (14680063 & 131072) != 0 ? r68.r : false, (14680063 & 262144) != 0 ? r68.s : 0, (14680063 & 524288) != 0 ? r68.t : false, (14680063 & 1048576) != 0 ? r68.u : false, (14680063 & 2097152) != 0 ? r68.v : null, (14680063 & 4194304) != 0 ? r68.w : null, (14680063 & 8388608) != 0 ? r68.x : false);
            }
        } while (!interfaceC9336Zm4.f(value, r68A));
    }

    public final void Y2() {
        S2();
    }

    public final void Z1() {
        Object value;
        R68 r68;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.z;
        do {
            value = interfaceC9336Zm4.getValue();
            r68 = (R68) value;
        } while (!interfaceC9336Zm4.f(value, r68.a((14680063 & 1) != 0 ? r68.a : null, (14680063 & 2) != 0 ? r68.b : null, (14680063 & 4) != 0 ? r68.c : false, (14680063 & 8) != 0 ? r68.d : null, (14680063 & 16) != 0 ? r68.e : false, (14680063 & 32) != 0 ? r68.f : null, (14680063 & 64) != 0 ? r68.g : false, (14680063 & 128) != 0 ? r68.h : false, (14680063 & 256) != 0 ? r68.i : false, (14680063 & 512) != 0 ? r68.j : null, (14680063 & 1024) != 0 ? r68.k : false, (14680063 & 2048) != 0 ? r68.l : true, (14680063 & 4096) != 0 ? r68.m : false, (14680063 & 8192) != 0 ? r68.n : null, (14680063 & 16384) != 0 ? r68.o : null, (14680063 & 32768) != 0 ? r68.p : false, (14680063 & 65536) != 0 ? r68.q : null, (14680063 & 131072) != 0 ? r68.r : false, (14680063 & 262144) != 0 ? r68.s : 0, (14680063 & 524288) != 0 ? r68.t : false, (14680063 & 1048576) != 0 ? r68.u : false, (14680063 & 2097152) != 0 ? r68.v : null, (14680063 & 4194304) != 0 ? r68.w : null, (14680063 & 8388608) != 0 ? r68.x : false)));
    }

    public final void a2() {
        K2((System.currentTimeMillis() - this.w) / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
    }

    public final void a3() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new t(null), 3, null);
    }

    public final void c2() {
        this.w = System.currentTimeMillis();
    }

    public final void d2(String str) {
        Object value;
        R68 r68;
        if (C8386Vt0.bc()) {
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.z;
            do {
                value = interfaceC9336Zm4.getValue();
                r68 = (R68) value;
            } while (!interfaceC9336Zm4.f(value, r68.a((14680063 & 1) != 0 ? r68.a : null, (14680063 & 2) != 0 ? r68.b : null, (14680063 & 4) != 0 ? r68.c : false, (14680063 & 8) != 0 ? r68.d : null, (14680063 & 16) != 0 ? r68.e : false, (14680063 & 32) != 0 ? r68.f : new C9517a58(str), (14680063 & 64) != 0 ? r68.g : false, (14680063 & 128) != 0 ? r68.h : false, (14680063 & 256) != 0 ? r68.i : false, (14680063 & 512) != 0 ? r68.j : null, (14680063 & 1024) != 0 ? r68.k : false, (14680063 & 2048) != 0 ? r68.l : false, (14680063 & 4096) != 0 ? r68.m : false, (14680063 & 8192) != 0 ? r68.n : null, (14680063 & 16384) != 0 ? r68.o : null, (14680063 & 32768) != 0 ? r68.p : false, (14680063 & 65536) != 0 ? r68.q : null, (14680063 & 131072) != 0 ? r68.r : false, (14680063 & 262144) != 0 ? r68.s : 0, (14680063 & 524288) != 0 ? r68.t : false, (14680063 & 1048576) != 0 ? r68.u : false, (14680063 & 2097152) != 0 ? r68.v : null, (14680063 & 4194304) != 0 ? r68.w : null, (14680063 & 8388608) != 0 ? r68.x : false)));
        }
    }

    public final void e2() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new l(null), 3, null);
    }

    public final void f2() {
        Object value;
        R68 r68;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.z;
        do {
            value = interfaceC9336Zm4.getValue();
            r68 = (R68) value;
        } while (!interfaceC9336Zm4.f(value, r68.a((14680063 & 1) != 0 ? r68.a : null, (14680063 & 2) != 0 ? r68.b : null, (14680063 & 4) != 0 ? r68.c : false, (14680063 & 8) != 0 ? r68.d : null, (14680063 & 16) != 0 ? r68.e : true, (14680063 & 32) != 0 ? r68.f : null, (14680063 & 64) != 0 ? r68.g : false, (14680063 & 128) != 0 ? r68.h : false, (14680063 & 256) != 0 ? r68.i : false, (14680063 & 512) != 0 ? r68.j : null, (14680063 & 1024) != 0 ? r68.k : false, (14680063 & 2048) != 0 ? r68.l : false, (14680063 & 4096) != 0 ? r68.m : false, (14680063 & 8192) != 0 ? r68.n : null, (14680063 & 16384) != 0 ? r68.o : null, (14680063 & 32768) != 0 ? r68.p : false, (14680063 & 65536) != 0 ? r68.q : null, (14680063 & 131072) != 0 ? r68.r : false, (14680063 & 262144) != 0 ? r68.s : 0, (14680063 & 524288) != 0 ? r68.t : true, (14680063 & 1048576) != 0 ? r68.u : false, (14680063 & 2097152) != 0 ? r68.v : null, (14680063 & 4194304) != 0 ? r68.w : null, (14680063 & 8388608) != 0 ? r68.x : false)));
    }

    public final void g2() {
        Object value;
        R68 r68;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.z;
        do {
            value = interfaceC9336Zm4.getValue();
            r68 = (R68) value;
        } while (!interfaceC9336Zm4.f(value, r68.a((14680063 & 1) != 0 ? r68.a : null, (14680063 & 2) != 0 ? r68.b : null, (14680063 & 4) != 0 ? r68.c : false, (14680063 & 8) != 0 ? r68.d : null, (14680063 & 16) != 0 ? r68.e : false, (14680063 & 32) != 0 ? r68.f : null, (14680063 & 64) != 0 ? r68.g : false, (14680063 & 128) != 0 ? r68.h : false, (14680063 & 256) != 0 ? r68.i : false, (14680063 & 512) != 0 ? r68.j : null, (14680063 & 1024) != 0 ? r68.k : false, (14680063 & 2048) != 0 ? r68.l : false, (14680063 & 4096) != 0 ? r68.m : false, (14680063 & 8192) != 0 ? r68.n : null, (14680063 & 16384) != 0 ? r68.o : null, (14680063 & 32768) != 0 ? r68.p : false, (14680063 & 65536) != 0 ? r68.q : null, (14680063 & 131072) != 0 ? r68.r : false, (14680063 & 262144) != 0 ? r68.s : 0, (14680063 & 524288) != 0 ? r68.t : false, (14680063 & 1048576) != 0 ? r68.u : false, (14680063 & 2097152) != 0 ? r68.v : null, (14680063 & 4194304) != 0 ? r68.w : null, (14680063 & 8388608) != 0 ? r68.x : false)));
    }

    public final void h2(final String str, final GeolocationPermissions.Callback callback, final SA2 sa2) {
        Object value;
        R68 r68;
        AbstractC13042fc3.i(sa2, "onPermissionGranted");
        if (C8386Vt0.dc()) {
            C21753u45.g gVar = C21753u45.g.g;
            if (Q1(gVar)) {
                Y48.c cVar = new Y48.c(((R68) this.z.getValue()).c(), new D88(gVar, new SA2() { // from class: ir.nasim.Y68
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C10747c78.i2(callback, str, sa2);
                    }
                }, new SA2() { // from class: ir.nasim.Z68
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C10747c78.j2(callback, str);
                    }
                }));
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.z;
                do {
                    value = interfaceC9336Zm4.getValue();
                    r68 = (R68) value;
                } while (!interfaceC9336Zm4.f(value, r68.a((14680063 & 1) != 0 ? r68.a : null, (14680063 & 2) != 0 ? r68.b : null, (14680063 & 4) != 0 ? r68.c : false, (14680063 & 8) != 0 ? r68.d : null, (14680063 & 16) != 0 ? r68.e : false, (14680063 & 32) != 0 ? r68.f : null, (14680063 & 64) != 0 ? r68.g : false, (14680063 & 128) != 0 ? r68.h : false, (14680063 & 256) != 0 ? r68.i : false, (14680063 & 512) != 0 ? r68.j : null, (14680063 & 1024) != 0 ? r68.k : false, (14680063 & 2048) != 0 ? r68.l : false, (14680063 & 4096) != 0 ? r68.m : false, (14680063 & 8192) != 0 ? r68.n : null, (14680063 & 16384) != 0 ? r68.o : null, (14680063 & 32768) != 0 ? r68.p : false, (14680063 & 65536) != 0 ? r68.q : cVar, (14680063 & 131072) != 0 ? r68.r : false, (14680063 & 262144) != 0 ? r68.s : 0, (14680063 & 524288) != 0 ? r68.t : false, (14680063 & 1048576) != 0 ? r68.u : false, (14680063 & 2097152) != 0 ? r68.v : null, (14680063 & 4194304) != 0 ? r68.w : null, (14680063 & 8388608) != 0 ? r68.x : false)));
                return;
            }
        }
        if (callback != null) {
            callback.invoke(str, false, false);
        }
    }

    public final void k2() {
        Object value;
        R68 r68;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.z;
        do {
            value = interfaceC9336Zm4.getValue();
            r68 = (R68) value;
        } while (!interfaceC9336Zm4.f(value, r68.a((14680063 & 1) != 0 ? r68.a : null, (14680063 & 2) != 0 ? r68.b : null, (14680063 & 4) != 0 ? r68.c : false, (14680063 & 8) != 0 ? r68.d : null, (14680063 & 16) != 0 ? r68.e : false, (14680063 & 32) != 0 ? r68.f : null, (14680063 & 64) != 0 ? r68.g : false, (14680063 & 128) != 0 ? r68.h : false, (14680063 & 256) != 0 ? r68.i : false, (14680063 & 512) != 0 ? r68.j : null, (14680063 & 1024) != 0 ? r68.k : false, (14680063 & 2048) != 0 ? r68.l : false, (14680063 & 4096) != 0 ? r68.m : false, (14680063 & 8192) != 0 ? r68.n : AbstractC20942sr7.b.b, (14680063 & 16384) != 0 ? r68.o : null, (14680063 & 32768) != 0 ? r68.p : false, (14680063 & 65536) != 0 ? r68.q : null, (14680063 & 131072) != 0 ? r68.r : false, (14680063 & 262144) != 0 ? r68.s : 0, (14680063 & 524288) != 0 ? r68.t : false, (14680063 & 1048576) != 0 ? r68.u : false, (14680063 & 2097152) != 0 ? r68.v : null, (14680063 & 4194304) != 0 ? r68.w : null, (14680063 & 8388608) != 0 ? r68.x : false)));
        C1();
    }

    public final void l2(final PermissionRequest permissionRequest) {
        Object value;
        R68 r68;
        AbstractC13042fc3.i(permissionRequest, "permissionRequest");
        String[] resources = permissionRequest.getResources();
        AbstractC13042fc3.h(resources, "getResources(...)");
        final ArrayList arrayList = new ArrayList();
        for (String str : resources) {
            if ((AbstractC13042fc3.d(str, "android.webkit.resource.AUDIO_CAPTURE") && C8386Vt0.lc()) || (AbstractC13042fc3.d(str, "android.webkit.resource.VIDEO_CAPTURE") && C8386Vt0.Xb())) {
                arrayList.add(str);
            }
        }
        final C21753u45.g gVarH1 = H1(arrayList);
        if (gVarH1 == null) {
            permissionRequest.deny();
            return;
        }
        if (!Q1(gVarH1)) {
            permissionRequest.deny();
            return;
        }
        Y48.c cVar = new Y48.c(((R68) this.z.getValue()).c(), new D88(gVarH1, new SA2() { // from class: ir.nasim.W68
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C10747c78.m2(permissionRequest, arrayList, this, gVarH1);
            }
        }, new SA2() { // from class: ir.nasim.X68
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C10747c78.n2(permissionRequest);
            }
        }));
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.z;
        do {
            value = interfaceC9336Zm4.getValue();
            r68 = (R68) value;
        } while (!interfaceC9336Zm4.f(value, r68.a((14680063 & 1) != 0 ? r68.a : null, (14680063 & 2) != 0 ? r68.b : null, (14680063 & 4) != 0 ? r68.c : false, (14680063 & 8) != 0 ? r68.d : null, (14680063 & 16) != 0 ? r68.e : false, (14680063 & 32) != 0 ? r68.f : null, (14680063 & 64) != 0 ? r68.g : false, (14680063 & 128) != 0 ? r68.h : false, (14680063 & 256) != 0 ? r68.i : false, (14680063 & 512) != 0 ? r68.j : null, (14680063 & 1024) != 0 ? r68.k : false, (14680063 & 2048) != 0 ? r68.l : false, (14680063 & 4096) != 0 ? r68.m : false, (14680063 & 8192) != 0 ? r68.n : null, (14680063 & 16384) != 0 ? r68.o : null, (14680063 & 32768) != 0 ? r68.p : false, (14680063 & 65536) != 0 ? r68.q : cVar, (14680063 & 131072) != 0 ? r68.r : false, (14680063 & 262144) != 0 ? r68.s : 0, (14680063 & 524288) != 0 ? r68.t : false, (14680063 & 1048576) != 0 ? r68.u : false, (14680063 & 2097152) != 0 ? r68.v : null, (14680063 & 4194304) != 0 ? r68.w : null, (14680063 & 8388608) != 0 ? r68.x : false)));
    }

    public final void o2(int i2) {
        Object value;
        R68 r68;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.z;
        do {
            value = interfaceC9336Zm4.getValue();
            r68 = (R68) value;
        } while (!interfaceC9336Zm4.f(value, r68.a((14680063 & 1) != 0 ? r68.a : null, (14680063 & 2) != 0 ? r68.b : null, (14680063 & 4) != 0 ? r68.c : false, (14680063 & 8) != 0 ? r68.d : null, (14680063 & 16) != 0 ? r68.e : false, (14680063 & 32) != 0 ? r68.f : null, (14680063 & 64) != 0 ? r68.g : false, (14680063 & 128) != 0 ? r68.h : false, (14680063 & 256) != 0 ? r68.i : false, (14680063 & 512) != 0 ? r68.j : null, (14680063 & 1024) != 0 ? r68.k : false, (14680063 & 2048) != 0 ? r68.l : false, (14680063 & 4096) != 0 ? r68.m : false, (14680063 & 8192) != 0 ? r68.n : null, (14680063 & 16384) != 0 ? r68.o : null, (14680063 & 32768) != 0 ? r68.p : false, (14680063 & 65536) != 0 ? r68.q : null, (14680063 & 131072) != 0 ? r68.r : false, (14680063 & 262144) != 0 ? r68.s : i2, (14680063 & 524288) != 0 ? r68.t : false, (14680063 & 1048576) != 0 ? r68.u : false, (14680063 & 2097152) != 0 ? r68.v : null, (14680063 & 4194304) != 0 ? r68.w : null, (14680063 & 8388608) != 0 ? r68.x : false)));
        if (i2 == 100) {
            AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new m(null), 3, null);
        }
    }

    public final void p2() {
        L2(EnumC18117o68.g);
    }

    public final void s2(Context context) {
        AbstractC13042fc3.i(context, "context");
        try {
            C9475a16.a aVar = C9475a16.b;
            AbstractC7426Rr.a.A(context, Uri.parse(this.j.O4()));
            C9475a16.b(C19938rB7.a);
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            C9475a16.b(AbstractC10685c16.a(th));
        }
    }

    public final void t2() {
        Object value;
        R68 r68;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.z;
        do {
            value = interfaceC9336Zm4.getValue();
            r68 = (R68) value;
        } while (!interfaceC9336Zm4.f(value, r68.a((14680063 & 1) != 0 ? r68.a : null, (14680063 & 2) != 0 ? r68.b : null, (14680063 & 4) != 0 ? r68.c : false, (14680063 & 8) != 0 ? r68.d : null, (14680063 & 16) != 0 ? r68.e : false, (14680063 & 32) != 0 ? r68.f : null, (14680063 & 64) != 0 ? r68.g : false, (14680063 & 128) != 0 ? r68.h : false, (14680063 & 256) != 0 ? r68.i : false, (14680063 & 512) != 0 ? r68.j : null, (14680063 & 1024) != 0 ? r68.k : false, (14680063 & 2048) != 0 ? r68.l : false, (14680063 & 4096) != 0 ? r68.m : false, (14680063 & 8192) != 0 ? r68.n : null, (14680063 & 16384) != 0 ? r68.o : null, (14680063 & 32768) != 0 ? r68.p : false, (14680063 & 65536) != 0 ? r68.q : null, (14680063 & 131072) != 0 ? r68.r : false, (14680063 & 262144) != 0 ? r68.s : 0, (14680063 & 524288) != 0 ? r68.t : false, (14680063 & 1048576) != 0 ? r68.u : false, (14680063 & 2097152) != 0 ? r68.v : null, (14680063 & 4194304) != 0 ? r68.w : null, (14680063 & 8388608) != 0 ? r68.x : false)));
    }

    public final void u2() {
        Object value;
        R68 r68;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.z;
        do {
            value = interfaceC9336Zm4.getValue();
            r68 = (R68) value;
        } while (!interfaceC9336Zm4.f(value, r68.a((14680063 & 1) != 0 ? r68.a : null, (14680063 & 2) != 0 ? r68.b : null, (14680063 & 4) != 0 ? r68.c : false, (14680063 & 8) != 0 ? r68.d : null, (14680063 & 16) != 0 ? r68.e : false, (14680063 & 32) != 0 ? r68.f : null, (14680063 & 64) != 0 ? r68.g : false, (14680063 & 128) != 0 ? r68.h : false, (14680063 & 256) != 0 ? r68.i : false, (14680063 & 512) != 0 ? r68.j : null, (14680063 & 1024) != 0 ? r68.k : false, (14680063 & 2048) != 0 ? r68.l : false, (14680063 & 4096) != 0 ? r68.m : false, (14680063 & 8192) != 0 ? r68.n : null, (14680063 & 16384) != 0 ? r68.o : null, (14680063 & 32768) != 0 ? r68.p : false, (14680063 & 65536) != 0 ? r68.q : null, (14680063 & 131072) != 0 ? r68.r : false, (14680063 & 262144) != 0 ? r68.s : 0, (14680063 & 524288) != 0 ? r68.t : false, (14680063 & 1048576) != 0 ? r68.u : false, (14680063 & 2097152) != 0 ? r68.v : null, (14680063 & 4194304) != 0 ? r68.w : null, (14680063 & 8388608) != 0 ? r68.x : false)));
    }

    public final void v2() {
        Object value;
        R68 r68;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.z;
        do {
            value = interfaceC9336Zm4.getValue();
            r68 = (R68) value;
        } while (!interfaceC9336Zm4.f(value, r68.a((14680063 & 1) != 0 ? r68.a : null, (14680063 & 2) != 0 ? r68.b : null, (14680063 & 4) != 0 ? r68.c : false, (14680063 & 8) != 0 ? r68.d : null, (14680063 & 16) != 0 ? r68.e : false, (14680063 & 32) != 0 ? r68.f : null, (14680063 & 64) != 0 ? r68.g : false, (14680063 & 128) != 0 ? r68.h : false, (14680063 & 256) != 0 ? r68.i : false, (14680063 & 512) != 0 ? r68.j : null, (14680063 & 1024) != 0 ? r68.k : false, (14680063 & 2048) != 0 ? r68.l : false, (14680063 & 4096) != 0 ? r68.m : false, (14680063 & 8192) != 0 ? r68.n : null, (14680063 & 16384) != 0 ? r68.o : null, (14680063 & 32768) != 0 ? r68.p : false, (14680063 & 65536) != 0 ? r68.q : null, (14680063 & 131072) != 0 ? r68.r : false, (14680063 & 262144) != 0 ? r68.s : 0, (14680063 & 524288) != 0 ? r68.t : false, (14680063 & 1048576) != 0 ? r68.u : false, (14680063 & 2097152) != 0 ? r68.v : null, (14680063 & 4194304) != 0 ? r68.w : null, (14680063 & 8388608) != 0 ? r68.x : false)));
    }

    public final void w2() {
        Object value;
        R68 r68;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.z;
        do {
            value = interfaceC9336Zm4.getValue();
            r68 = (R68) value;
        } while (!interfaceC9336Zm4.f(value, r68.a((14680063 & 1) != 0 ? r68.a : null, (14680063 & 2) != 0 ? r68.b : null, (14680063 & 4) != 0 ? r68.c : false, (14680063 & 8) != 0 ? r68.d : null, (14680063 & 16) != 0 ? r68.e : false, (14680063 & 32) != 0 ? r68.f : null, (14680063 & 64) != 0 ? r68.g : false, (14680063 & 128) != 0 ? r68.h : false, (14680063 & 256) != 0 ? r68.i : false, (14680063 & 512) != 0 ? r68.j : null, (14680063 & 1024) != 0 ? r68.k : false, (14680063 & 2048) != 0 ? r68.l : false, (14680063 & 4096) != 0 ? r68.m : false, (14680063 & 8192) != 0 ? r68.n : null, (14680063 & 16384) != 0 ? r68.o : null, (14680063 & 32768) != 0 ? r68.p : false, (14680063 & 65536) != 0 ? r68.q : null, (14680063 & 131072) != 0 ? r68.r : false, (14680063 & 262144) != 0 ? r68.s : 0, (14680063 & 524288) != 0 ? r68.t : false, (14680063 & 1048576) != 0 ? r68.u : false, (14680063 & 2097152) != 0 ? r68.v : null, (14680063 & 4194304) != 0 ? r68.w : null, (14680063 & 8388608) != 0 ? r68.x : false)));
    }

    public final void y2(C24732z68 c24732z68) {
        AbstractC13042fc3.i(c24732z68, "webAppThemeParams");
        if (this.y) {
            return;
        }
        this.y = true;
        WebAppRestoreState webAppRestoreState = this.n.getWebAppRestoreState();
        if (webAppRestoreState == null || AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new n(webAppRestoreState, null), 3, null) == null) {
            W1(c24732z68);
            C19938rB7 c19938rB7 = C19938rB7.a;
        }
    }

    public final void z2() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new o(null), 3, null);
    }
}
