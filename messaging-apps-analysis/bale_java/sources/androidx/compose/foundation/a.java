package androidx.compose.foundation;

import android.view.KeyEvent;
import androidx.compose.ui.focus.u;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14680iJ3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20111rV0;
import ir.nasim.AbstractC20906so1;
import ir.nasim.AbstractC21071t37;
import ir.nasim.AbstractC23371wo3;
import ir.nasim.AbstractC23831xb3;
import ir.nasim.AbstractC4236Eg5;
import ir.nasim.AbstractC4663Ga3;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC9939ao6;
import ir.nasim.B26;
import ir.nasim.C12403eZ2;
import ir.nasim.C13012fZ2;
import ir.nasim.C19938rB7;
import ir.nasim.C22045ua3;
import ir.nasim.C22166um4;
import ir.nasim.C3534Bg5;
import ir.nasim.C6717Or2;
import ir.nasim.EB2;
import ir.nasim.ED1;
import ir.nasim.EnumC4002Dg5;
import ir.nasim.HG1;
import ir.nasim.InterfaceC11943do6;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC17521n63;
import ir.nasim.InterfaceC18507om4;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC22335v37;
import ir.nasim.InterfaceC24551yo3;
import ir.nasim.InterfaceC6194Mo5;
import ir.nasim.InterfaceC6693Oo5;
import ir.nasim.InterfaceC7163Qn6;
import ir.nasim.InterfaceC8508Wg5;
import ir.nasim.InterfaceC8645Wv7;
import ir.nasim.InterfaceC9049Yg5;
import ir.nasim.JG1;
import ir.nasim.RG1;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.ZG4;

/* loaded from: classes.dex */
public abstract class a extends RG1 implements InterfaceC8508Wg5, InterfaceC24551yo3, InterfaceC7163Qn6, InterfaceC8645Wv7 {
    public static final C0029a Z = new C0029a(null);
    public static final int z0 = 8;
    private InterfaceC6693Oo5.b A;
    private C12403eZ2 B;
    private final C22166um4 D;
    private long G;
    private InterfaceC18507om4 H;
    private boolean J;
    private final Object Y;
    private InterfaceC18507om4 q;
    private InterfaceC17521n63 r;
    private String s;
    private B26 t;
    private boolean u;
    private SA2 v;
    private final boolean w;
    private final C6717Or2 x;
    private InterfaceC22335v37 y;
    private JG1 z;

    /* renamed from: androidx.compose.foundation.a$a, reason: collision with other inner class name */
    public static final class C0029a {
        private C0029a() {
        }

        public /* synthetic */ C0029a(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC8614Ws3 implements SA2 {
        b() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            a.this.P2().invoke();
            return Boolean.TRUE;
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC18507om4 c;
        final /* synthetic */ C12403eZ2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(InterfaceC18507om4 interfaceC18507om4, C12403eZ2 c12403eZ2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC18507om4;
            this.d = c12403eZ2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC18507om4 interfaceC18507om4 = this.c;
                C12403eZ2 c12403eZ2 = this.d;
                this.b = 1;
                if (interfaceC18507om4.c(c12403eZ2, this) == objE) {
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
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC18507om4 c;
        final /* synthetic */ C13012fZ2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(InterfaceC18507om4 interfaceC18507om4, C13012fZ2 c13012fZ2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC18507om4;
            this.d = c13012fZ2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new d(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC18507om4 interfaceC18507om4 = this.c;
                C13012fZ2 c13012fZ2 = this.d;
                this.b = 1;
                if (interfaceC18507om4.c(c13012fZ2, this) == objE) {
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

    /* synthetic */ class e extends EB2 implements UA2 {
        e(Object obj) {
            super(1, obj, a.class, "onFocusChange", "onFocusChange(Z)V", 0);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            y(((Boolean) obj).booleanValue());
            return C19938rB7.a;
        }

        public final void y(boolean z) {
            ((a) this.receiver).V2(z);
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        boolean b;
        int c;
        private /* synthetic */ Object d;
        final /* synthetic */ InterfaceC6194Mo5 e;
        final /* synthetic */ long f;
        final /* synthetic */ InterfaceC18507om4 g;
        final /* synthetic */ a h;

        /* renamed from: androidx.compose.foundation.a$f$a, reason: collision with other inner class name */
        static final class C0030a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            Object b;
            int c;
            final /* synthetic */ a d;
            final /* synthetic */ long e;
            final /* synthetic */ InterfaceC18507om4 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0030a(a aVar, long j, InterfaceC18507om4 interfaceC18507om4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = aVar;
                this.e = j;
                this.f = interfaceC18507om4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C0030a(this.d, this.e, this.f, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                InterfaceC6693Oo5.b bVar;
                Object objE = AbstractC14862ic3.e();
                int i = this.c;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    if (this.d.K2()) {
                        long jA = AbstractC20111rV0.a();
                        this.c = 1;
                        if (HG1.b(jA, this) == objE) {
                            return objE;
                        }
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        bVar = (InterfaceC6693Oo5.b) this.b;
                        AbstractC10685c16.b(obj);
                        this.d.A = bVar;
                        return C19938rB7.a;
                    }
                    AbstractC10685c16.b(obj);
                }
                InterfaceC6693Oo5.b bVar2 = new InterfaceC6693Oo5.b(this.e, null);
                InterfaceC18507om4 interfaceC18507om4 = this.f;
                this.b = bVar2;
                this.c = 2;
                if (interfaceC18507om4.c(bVar2, this) == objE) {
                    return objE;
                }
                bVar = bVar2;
                this.d.A = bVar;
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0030a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(InterfaceC6194Mo5 interfaceC6194Mo5, long j, InterfaceC18507om4 interfaceC18507om4, a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = interfaceC6194Mo5;
            this.f = j;
            this.g = interfaceC18507om4;
            this.h = aVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            f fVar = new f(this.e, this.f, this.g, this.h, interfaceC20295rm1);
            fVar.d = obj;
            return fVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0088  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00ae A[RETURN] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r17) {
            /*
                Method dump skipped, instructions count: 217
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.a.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC6693Oo5.b d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(InterfaceC6693Oo5.b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = bVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return a.this.new g(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC18507om4 interfaceC18507om4 = a.this.q;
                if (interfaceC18507om4 != null) {
                    InterfaceC6693Oo5.a aVar = new InterfaceC6693Oo5.a(this.d);
                    this.b = 1;
                    if (interfaceC18507om4.c(aVar, this) == objE) {
                        return objE;
                    }
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
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC6693Oo5.b d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(InterfaceC6693Oo5.b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = bVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return a.this.new h(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC18507om4 interfaceC18507om4 = a.this.q;
                if (interfaceC18507om4 != null) {
                    InterfaceC6693Oo5.b bVar = this.d;
                    this.b = 1;
                    if (interfaceC18507om4.c(bVar, this) == objE) {
                        return objE;
                    }
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
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC6693Oo5.b d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(InterfaceC6693Oo5.b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = bVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return a.this.new i(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC18507om4 interfaceC18507om4 = a.this.q;
                if (interfaceC18507om4 != null) {
                    InterfaceC6693Oo5.c cVar = new InterfaceC6693Oo5.c(this.d);
                    this.b = 1;
                    if (interfaceC18507om4.c(cVar, this) == objE) {
                        return objE;
                    }
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
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        j(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return a.this.new j(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            a.this.M2();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return a.this.new k(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            a.this.N2();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class l implements PointerInputEventHandler {
        l() {
        }

        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
        public final Object invoke(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objJ2 = a.this.J2(interfaceC9049Yg5, interfaceC20295rm1);
            return objJ2 == AbstractC14862ic3.e() ? objJ2 : C19938rB7.a;
        }
    }

    public /* synthetic */ a(InterfaceC18507om4 interfaceC18507om4, InterfaceC17521n63 interfaceC17521n63, boolean z, String str, B26 b26, SA2 sa2, ED1 ed1) {
        this(interfaceC18507om4, interfaceC17521n63, z, str, b26, sa2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean K2() {
        return androidx.compose.foundation.e.k(this) || AbstractC20111rV0.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M2() {
        if (this.B == null) {
            C12403eZ2 c12403eZ2 = new C12403eZ2();
            InterfaceC18507om4 interfaceC18507om4 = this.q;
            if (interfaceC18507om4 != null) {
                AbstractC10533bm0.d(U1(), null, null, new c(interfaceC18507om4, c12403eZ2, null), 3, null);
            }
            this.B = c12403eZ2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N2() {
        C12403eZ2 c12403eZ2 = this.B;
        if (c12403eZ2 != null) {
            C13012fZ2 c13012fZ2 = new C13012fZ2(c12403eZ2);
            InterfaceC18507om4 interfaceC18507om4 = this.q;
            if (interfaceC18507om4 != null) {
                AbstractC10533bm0.d(U1(), null, null, new d(interfaceC18507om4, c13012fZ2, null), 3, null);
            }
            this.B = null;
        }
    }

    private final void R2() {
        InterfaceC17521n63 interfaceC17521n63;
        if (this.z == null && (interfaceC17521n63 = this.r) != null) {
            if (this.q == null) {
                this.q = AbstractC23831xb3.a();
            }
            this.x.K2(this.q);
            InterfaceC18507om4 interfaceC18507om4 = this.q;
            AbstractC13042fc3.f(interfaceC18507om4);
            JG1 jg1B = interfaceC17521n63.b(interfaceC18507om4);
            v2(jg1B);
            this.z = jg1B;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void V2(boolean r19) {
        /*
            r18 = this;
            r0 = r18
            if (r19 == 0) goto L8
            r18.R2()
            goto L6a
        L8:
            ir.nasim.om4 r1 = r0.q
            if (r1 == 0) goto L62
            ir.nasim.um4 r1 = r0.D
            java.lang.Object[] r2 = r1.c
            long[] r1 = r1.a
            int r3 = r1.length
            int r3 = r3 + (-2)
            if (r3 < 0) goto L62
            r4 = 0
            r5 = r4
        L19:
            r6 = r1[r5]
            long r8 = ~r6
            r10 = 7
            long r8 = r8 << r10
            long r8 = r8 & r6
            r10 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r8 = r8 & r10
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 == 0) goto L5d
            int r8 = r5 - r3
            int r8 = ~r8
            int r8 = r8 >>> 31
            r9 = 8
            int r8 = 8 - r8
            r10 = r4
        L33:
            if (r10 >= r8) goto L5b
            r11 = 255(0xff, double:1.26E-321)
            long r11 = r11 & r6
            r13 = 128(0x80, double:6.3E-322)
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 >= 0) goto L57
            int r11 = r5 << 3
            int r11 = r11 + r10
            r11 = r2[r11]
            ir.nasim.Oo5$b r11 = (ir.nasim.InterfaceC6693Oo5.b) r11
            ir.nasim.ro1 r12 = r18.U1()
            androidx.compose.foundation.a$g r15 = new androidx.compose.foundation.a$g
            r13 = 0
            r15.<init>(r11, r13)
            r16 = 3
            r17 = 0
            r14 = 0
            ir.nasim.AbstractC9323Zl0.d(r12, r13, r14, r15, r16, r17)
        L57:
            long r6 = r6 >> r9
            int r10 = r10 + 1
            goto L33
        L5b:
            if (r8 != r9) goto L62
        L5d:
            if (r5 == r3) goto L62
            int r5 = r5 + 1
            goto L19
        L62:
            ir.nasim.um4 r1 = r0.D
            r1.g()
            r18.S2()
        L6a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.a.V2(boolean):void");
    }

    private final boolean X2() {
        return this.H == null && this.r != null;
    }

    public abstract Object J2(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC20295rm1 interfaceC20295rm1);

    @Override // ir.nasim.InterfaceC7163Qn6
    public final boolean L1() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final void L2() {
        /*
            r15 = this;
            ir.nasim.om4 r0 = r15.q
            if (r0 == 0) goto L68
            ir.nasim.Oo5$b r1 = r15.A
            if (r1 == 0) goto L10
            ir.nasim.Oo5$a r2 = new ir.nasim.Oo5$a
            r2.<init>(r1)
            r0.a(r2)
        L10:
            ir.nasim.eZ2 r1 = r15.B
            if (r1 == 0) goto L1c
            ir.nasim.fZ2 r2 = new ir.nasim.fZ2
            r2.<init>(r1)
            r0.a(r2)
        L1c:
            ir.nasim.um4 r1 = r15.D
            java.lang.Object[] r2 = r1.c
            long[] r1 = r1.a
            int r3 = r1.length
            int r3 = r3 + (-2)
            if (r3 < 0) goto L68
            r4 = 0
            r5 = r4
        L29:
            r6 = r1[r5]
            long r8 = ~r6
            r10 = 7
            long r8 = r8 << r10
            long r8 = r8 & r6
            r10 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r8 = r8 & r10
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 == 0) goto L63
            int r8 = r5 - r3
            int r8 = ~r8
            int r8 = r8 >>> 31
            r9 = 8
            int r8 = 8 - r8
            r10 = r4
        L43:
            if (r10 >= r8) goto L61
            r11 = 255(0xff, double:1.26E-321)
            long r11 = r11 & r6
            r13 = 128(0x80, double:6.3E-322)
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 >= 0) goto L5d
            int r11 = r5 << 3
            int r11 = r11 + r10
            r11 = r2[r11]
            ir.nasim.Oo5$b r11 = (ir.nasim.InterfaceC6693Oo5.b) r11
            ir.nasim.Oo5$a r12 = new ir.nasim.Oo5$a
            r12.<init>(r11)
            r0.a(r12)
        L5d:
            long r6 = r6 >> r9
            int r10 = r10 + 1
            goto L43
        L61:
            if (r8 != r9) goto L68
        L63:
            if (r5 == r3) goto L68
            int r5 = r5 + 1
            goto L29
        L68:
            r0 = 0
            r15.A = r0
            r15.B = r0
            ir.nasim.um4 r0 = r15.D
            r0.g()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.a.L2():void");
    }

    @Override // ir.nasim.InterfaceC24551yo3
    public final boolean O0(KeyEvent keyEvent) {
        return false;
    }

    protected final boolean O2() {
        return this.u;
    }

    @Override // ir.nasim.InterfaceC8645Wv7
    public Object P() {
        return this.Y;
    }

    protected final SA2 P2() {
        return this.v;
    }

    protected final Object Q2(InterfaceC6194Mo5 interfaceC6194Mo5, long j2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objE;
        InterfaceC18507om4 interfaceC18507om4 = this.q;
        return (interfaceC18507om4 == null || (objE = AbstractC20906so1.e(new f(interfaceC6194Mo5, j2, interfaceC18507om4, this, null), interfaceC20295rm1)) != AbstractC14862ic3.e()) ? C19938rB7.a : objE;
    }

    protected void S2() {
    }

    protected abstract boolean T2(KeyEvent keyEvent);

    @Override // ir.nasim.InterfaceC7163Qn6
    public final void U0(InterfaceC11943do6 interfaceC11943do6) {
        B26 b26 = this.t;
        if (b26 != null) {
            AbstractC13042fc3.f(b26);
            AbstractC9939ao6.p0(interfaceC11943do6, b26.p());
        }
        AbstractC9939ao6.A(interfaceC11943do6, this.s, new b());
        if (this.u) {
            this.x.U0(interfaceC11943do6);
        } else {
            AbstractC9939ao6.k(interfaceC11943do6);
        }
        I2(interfaceC11943do6);
    }

    protected abstract boolean U2(KeyEvent keyEvent);

    protected final C19938rB7 W2() {
        InterfaceC22335v37 interfaceC22335v37 = this.y;
        if (interfaceC22335v37 == null) {
            return null;
        }
        interfaceC22335v37.N0();
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final void Y2(ir.nasim.InterfaceC18507om4 r3, ir.nasim.InterfaceC17521n63 r4, boolean r5, java.lang.String r6, ir.nasim.B26 r7, ir.nasim.SA2 r8) {
        /*
            r2 = this;
            ir.nasim.om4 r0 = r2.H
            boolean r0 = ir.nasim.AbstractC13042fc3.d(r0, r3)
            r1 = 1
            if (r0 != 0) goto L12
            r2.L2()
            r2.H = r3
            r2.q = r3
            r3 = r1
            goto L13
        L12:
            r3 = 0
        L13:
            ir.nasim.n63 r0 = r2.r
            boolean r0 = ir.nasim.AbstractC13042fc3.d(r0, r4)
            if (r0 != 0) goto L1e
            r2.r = r4
            r3 = r1
        L1e:
            boolean r4 = r2.u
            if (r4 == r5) goto L37
            if (r5 == 0) goto L2a
            ir.nasim.Or2 r4 = r2.x
            r2.v2(r4)
            goto L32
        L2a:
            ir.nasim.Or2 r4 = r2.x
            r2.y2(r4)
            r2.L2()
        L32:
            ir.nasim.AbstractC7397Rn6.b(r2)
            r2.u = r5
        L37:
            java.lang.String r4 = r2.s
            boolean r4 = ir.nasim.AbstractC13042fc3.d(r4, r6)
            if (r4 != 0) goto L44
            r2.s = r6
            ir.nasim.AbstractC7397Rn6.b(r2)
        L44:
            ir.nasim.B26 r4 = r2.t
            boolean r4 = ir.nasim.AbstractC13042fc3.d(r4, r7)
            if (r4 != 0) goto L51
            r2.t = r7
            ir.nasim.AbstractC7397Rn6.b(r2)
        L51:
            r2.v = r8
            boolean r4 = r2.J
            boolean r5 = r2.X2()
            if (r4 == r5) goto L68
            boolean r4 = r2.X2()
            r2.J = r4
            if (r4 != 0) goto L68
            ir.nasim.JG1 r4 = r2.z
            if (r4 != 0) goto L68
            goto L69
        L68:
            r1 = r3
        L69:
            if (r1 == 0) goto L7e
            ir.nasim.JG1 r3 = r2.z
            if (r3 != 0) goto L73
            boolean r4 = r2.J
            if (r4 != 0) goto L7e
        L73:
            if (r3 == 0) goto L78
            r2.y2(r3)
        L78:
            r3 = 0
            r2.z = r3
            r2.R2()
        L7e:
            ir.nasim.Or2 r3 = r2.x
            ir.nasim.om4 r4 = r2.q
            r3.K2(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.a.Y2(ir.nasim.om4, ir.nasim.n63, boolean, java.lang.String, ir.nasim.B26, ir.nasim.SA2):void");
    }

    @Override // androidx.compose.ui.e.c
    /* renamed from: Z1 */
    public final boolean getShouldAutoInvalidate() {
        return this.w;
    }

    @Override // androidx.compose.ui.e.c
    public final void e2() {
        if (!this.J) {
            R2();
        }
        if (this.u) {
            v2(this.x);
        }
    }

    @Override // androidx.compose.ui.e.c
    public final void f2() {
        L2();
        if (this.H == null) {
            this.q = null;
        }
        JG1 jg1 = this.z;
        if (jg1 != null) {
            y2(jg1);
        }
        this.z = null;
    }

    @Override // ir.nasim.InterfaceC24551yo3
    public final boolean g1(KeyEvent keyEvent) {
        boolean z;
        R2();
        long jA = AbstractC23371wo3.a(keyEvent);
        if (this.u && androidx.compose.foundation.e.n(keyEvent)) {
            if (this.D.a(jA)) {
                z = false;
            } else {
                InterfaceC6693Oo5.b bVar = new InterfaceC6693Oo5.b(this.G, null);
                this.D.q(jA, bVar);
                if (this.q != null) {
                    AbstractC10533bm0.d(U1(), null, null, new h(bVar, null), 3, null);
                }
                z = true;
            }
            if (T2(keyEvent) || z) {
                return true;
            }
        } else if (this.u && androidx.compose.foundation.e.l(keyEvent)) {
            InterfaceC6693Oo5.b bVar2 = (InterfaceC6693Oo5.b) this.D.n(jA);
            if (bVar2 != null) {
                if (this.q != null) {
                    AbstractC10533bm0.d(U1(), null, null, new i(bVar2, null), 3, null);
                }
                U2(keyEvent);
            }
            if (bVar2 != null) {
                return true;
            }
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC8508Wg5
    public final void i1() {
        C12403eZ2 c12403eZ2;
        InterfaceC18507om4 interfaceC18507om4 = this.q;
        if (interfaceC18507om4 != null && (c12403eZ2 = this.B) != null) {
            interfaceC18507om4.a(new C13012fZ2(c12403eZ2));
        }
        this.B = null;
        InterfaceC22335v37 interfaceC22335v37 = this.y;
        if (interfaceC22335v37 != null) {
            interfaceC22335v37.i1();
        }
    }

    @Override // ir.nasim.InterfaceC8508Wg5
    public final void k1(C3534Bg5 c3534Bg5, EnumC4002Dg5 enumC4002Dg5, long j2) {
        long jB = AbstractC4663Ga3.b(j2);
        float fK = C22045ua3.k(jB);
        float fL = C22045ua3.l(jB);
        this.G = ZG4.e((Float.floatToRawIntBits(fK) << 32) | (Float.floatToRawIntBits(fL) & 4294967295L));
        R2();
        if (this.u && enumC4002Dg5 == EnumC4002Dg5.b) {
            int iG = c3534Bg5.g();
            AbstractC4236Eg5.a aVar = AbstractC4236Eg5.a;
            if (AbstractC4236Eg5.i(iG, aVar.a())) {
                AbstractC10533bm0.d(U1(), null, null, new j(null), 3, null);
            } else if (AbstractC4236Eg5.i(iG, aVar.b())) {
                AbstractC10533bm0.d(U1(), null, null, new k(null), 3, null);
            }
        }
        if (this.y == null) {
            this.y = (InterfaceC22335v37) v2(AbstractC21071t37.a(new l()));
        }
        InterfaceC22335v37 interfaceC22335v37 = this.y;
        if (interfaceC22335v37 != null) {
            interfaceC22335v37.k1(c3534Bg5, enumC4002Dg5, j2);
        }
    }

    private a(InterfaceC18507om4 interfaceC18507om4, InterfaceC17521n63 interfaceC17521n63, boolean z, String str, B26 b26, SA2 sa2) {
        this.q = interfaceC18507om4;
        this.r = interfaceC17521n63;
        this.s = str;
        this.t = b26;
        this.u = z;
        this.v = sa2;
        this.x = new C6717Or2(this.q, u.a.c(), new e(this), null);
        this.D = AbstractC14680iJ3.a();
        this.G = ZG4.b.c();
        this.H = this.q;
        this.J = X2();
        this.Y = Z;
    }

    public void I2(InterfaceC11943do6 interfaceC11943do6) {
    }
}
