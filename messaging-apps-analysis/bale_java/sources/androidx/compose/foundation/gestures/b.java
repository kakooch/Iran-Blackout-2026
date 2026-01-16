package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.a;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC18309oR7;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20906so1;
import ir.nasim.AbstractC21071t37;
import ir.nasim.AbstractC21968uR7;
import ir.nasim.AbstractC22163um1;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C12889fL5;
import ir.nasim.C19938rB7;
import ir.nasim.C20082rR7;
import ir.nasim.C3534Bg5;
import ir.nasim.C6616Og5;
import ir.nasim.DJ0;
import ir.nasim.EnumC24286yM4;
import ir.nasim.EnumC4002Dg5;
import ir.nasim.FZ1;
import ir.nasim.GJ0;
import ir.nasim.GZ1;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC17639nJ0;
import ir.nasim.InterfaceC18507om4;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC22335v37;
import ir.nasim.InterfaceC8508Wg5;
import ir.nasim.InterfaceC9049Yg5;
import ir.nasim.NZ1;
import ir.nasim.RG1;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.ZG4;

/* loaded from: classes.dex */
public abstract class b extends RG1 implements InterfaceC8508Wg5 {
    private EnumC24286yM4 q;
    private UA2 r;
    private boolean s;
    private InterfaceC18507om4 t;
    private final UA2 u = new a();
    private InterfaceC17639nJ0 v;
    private GZ1 w;
    private boolean x;
    private InterfaceC22335v37 y;

    static final class a extends AbstractC8614Ws3 implements UA2 {
        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(C6616Og5 c6616Og5) {
            return (Boolean) b.this.L2().invoke(c6616Og5);
        }
    }

    /* renamed from: androidx.compose.foundation.gestures.b$b, reason: collision with other inner class name */
    static final class C0035b implements PointerInputEventHandler {

        /* renamed from: androidx.compose.foundation.gestures.b$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ b d;
            final /* synthetic */ InterfaceC9049Yg5 e;
            final /* synthetic */ InterfaceC15796kB2 f;
            final /* synthetic */ UA2 g;
            final /* synthetic */ SA2 h;
            final /* synthetic */ SA2 i;
            final /* synthetic */ InterfaceC14603iB2 j;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(b bVar, InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC15796kB2 interfaceC15796kB2, UA2 ua2, SA2 sa2, SA2 sa22, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = bVar;
                this.e = interfaceC9049Yg5;
                this.f = interfaceC15796kB2;
                this.g = ua2;
                this.h = sa2;
                this.i = sa22;
                this.j = interfaceC14603iB2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, this.f, this.g, this.h, this.i, this.j, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:20:0x004e  */
            /* JADX WARN: Removed duplicated region for block: B:25:0x0060  */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r13) {
                /*
                    r12 = this;
                    java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                    int r1 = r12.b
                    r2 = 1
                    if (r1 == 0) goto L1d
                    if (r1 != r2) goto L15
                    java.lang.Object r0 = r12.c
                    ir.nasim.ro1 r0 = (ir.nasim.InterfaceC20315ro1) r0
                    ir.nasim.AbstractC10685c16.b(r13)     // Catch: java.util.concurrent.CancellationException -> L13
                    goto L5d
                L13:
                    r13 = move-exception
                    goto L46
                L15:
                    java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r13.<init>(r0)
                    throw r13
                L1d:
                    ir.nasim.AbstractC10685c16.b(r13)
                    java.lang.Object r13 = r12.c
                    ir.nasim.ro1 r13 = (ir.nasim.InterfaceC20315ro1) r13
                    androidx.compose.foundation.gestures.b r1 = r12.d     // Catch: java.util.concurrent.CancellationException -> L42
                    ir.nasim.yM4 r8 = androidx.compose.foundation.gestures.b.C2(r1)     // Catch: java.util.concurrent.CancellationException -> L42
                    ir.nasim.Yg5 r3 = r12.e     // Catch: java.util.concurrent.CancellationException -> L42
                    ir.nasim.kB2 r4 = r12.f     // Catch: java.util.concurrent.CancellationException -> L42
                    ir.nasim.UA2 r5 = r12.g     // Catch: java.util.concurrent.CancellationException -> L42
                    ir.nasim.SA2 r6 = r12.h     // Catch: java.util.concurrent.CancellationException -> L42
                    ir.nasim.SA2 r7 = r12.i     // Catch: java.util.concurrent.CancellationException -> L42
                    ir.nasim.iB2 r9 = r12.j     // Catch: java.util.concurrent.CancellationException -> L42
                    r12.c = r13     // Catch: java.util.concurrent.CancellationException -> L42
                    r12.b = r2     // Catch: java.util.concurrent.CancellationException -> L42
                    r10 = r12
                    java.lang.Object r13 = ir.nasim.EZ1.e(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.util.concurrent.CancellationException -> L42
                    if (r13 != r0) goto L5d
                    return r0
                L42:
                    r0 = move-exception
                    r11 = r0
                    r0 = r13
                    r13 = r11
                L46:
                    androidx.compose.foundation.gestures.b r1 = r12.d
                    ir.nasim.nJ0 r1 = androidx.compose.foundation.gestures.b.B2(r1)
                    if (r1 == 0) goto L57
                    androidx.compose.foundation.gestures.a$a r2 = androidx.compose.foundation.gestures.a.C0034a.a
                    java.lang.Object r1 = r1.h(r2)
                    ir.nasim.GJ0.b(r1)
                L57:
                    boolean r0 = ir.nasim.AbstractC20906so1.g(r0)
                    if (r0 == 0) goto L60
                L5d:
                    ir.nasim.rB7 r13 = ir.nasim.C19938rB7.a
                    return r13
                L60:
                    throw r13
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.b.C0035b.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: androidx.compose.foundation.gestures.b$b$b, reason: collision with other inner class name */
        static final class C0036b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            final /* synthetic */ C20082rR7 e;
            final /* synthetic */ b f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0036b(C20082rR7 c20082rR7, b bVar) {
                super(2);
                this.e = c20082rR7;
                this.f = bVar;
            }

            public final void a(C6616Og5 c6616Og5, long j) {
                AbstractC21968uR7.c(this.e, c6616Og5);
                InterfaceC17639nJ0 interfaceC17639nJ0 = this.f.v;
                if (interfaceC17639nJ0 != null) {
                    GJ0.b(interfaceC17639nJ0.h(new a.b(j, null)));
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((C6616Og5) obj, ((ZG4) obj2).t());
                return C19938rB7.a;
            }
        }

        /* renamed from: androidx.compose.foundation.gestures.b$b$c */
        static final class c extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ b e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(b bVar) {
                super(0);
                this.e = bVar;
            }

            public final void a() {
                InterfaceC17639nJ0 interfaceC17639nJ0 = this.e.v;
                if (interfaceC17639nJ0 != null) {
                    GJ0.b(interfaceC17639nJ0.h(a.C0034a.a));
                }
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return C19938rB7.a;
            }
        }

        /* renamed from: androidx.compose.foundation.gestures.b$b$d */
        static final class d extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ C20082rR7 e;
            final /* synthetic */ InterfaceC9049Yg5 f;
            final /* synthetic */ b g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(C20082rR7 c20082rR7, InterfaceC9049Yg5 interfaceC9049Yg5, b bVar) {
                super(1);
                this.e = c20082rR7;
                this.f = interfaceC9049Yg5;
                this.g = bVar;
            }

            public final void a(C6616Og5 c6616Og5) {
                AbstractC21968uR7.c(this.e, c6616Og5);
                float f = this.f.getViewConfiguration().f();
                long jB = this.e.b(AbstractC18309oR7.a(f, f));
                this.e.e();
                InterfaceC17639nJ0 interfaceC17639nJ0 = this.g.v;
                if (interfaceC17639nJ0 != null) {
                    GJ0.b(interfaceC17639nJ0.h(new a.d(NZ1.l(jB), null)));
                }
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((C6616Og5) obj);
                return C19938rB7.a;
            }
        }

        /* renamed from: androidx.compose.foundation.gestures.b$b$e */
        static final class e extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
            final /* synthetic */ b e;
            final /* synthetic */ C20082rR7 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            e(b bVar, C20082rR7 c20082rR7) {
                super(3);
                this.e = bVar;
                this.f = c20082rR7;
            }

            public final void a(C6616Og5 c6616Og5, C6616Og5 c6616Og52, long j) {
                if (((Boolean) this.e.L2().invoke(c6616Og5)).booleanValue()) {
                    if (!this.e.x) {
                        if (this.e.v == null) {
                            this.e.v = DJ0.b(Integer.MAX_VALUE, null, null, 6, null);
                        }
                        this.e.U2();
                    }
                    AbstractC21968uR7.c(this.f, c6616Og5);
                    long jP = ZG4.p(c6616Og52.h(), j);
                    InterfaceC17639nJ0 interfaceC17639nJ0 = this.e.v;
                    if (interfaceC17639nJ0 != null) {
                        GJ0.b(interfaceC17639nJ0.h(new a.c(jP, null)));
                    }
                }
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                a((C6616Og5) obj, (C6616Og5) obj2, ((ZG4) obj3).t());
                return C19938rB7.a;
            }
        }

        /* renamed from: androidx.compose.foundation.gestures.b$b$f */
        static final class f extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ b e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            f(b bVar) {
                super(0);
                this.e = bVar;
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke() {
                return Boolean.valueOf(!this.e.T2());
            }
        }

        C0035b() {
        }

        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
        public final Object invoke(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC20295rm1 interfaceC20295rm1) {
            C20082rR7 c20082rR7 = new C20082rR7();
            Object objE = AbstractC20906so1.e(new a(b.this, interfaceC9049Yg5, new e(b.this, c20082rR7), new d(c20082rR7, interfaceC9049Yg5, b.this), new c(b.this), new f(b.this), new C0036b(c20082rR7, b.this), null), interfaceC20295rm1);
            return objE == AbstractC14862ic3.e() ? objE : C19938rB7.a;
        }
    }

    static final class c extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return b.this.Q2(this);
        }
    }

    static final class d extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return b.this.R2(null, this);
        }
    }

    static final class e extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return b.this.S2(null, this);
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;
        private /* synthetic */ Object e;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            Object b;
            int c;
            /* synthetic */ Object d;
            final /* synthetic */ C12889fL5 e;
            final /* synthetic */ b f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C12889fL5 c12889fL5, b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.e = c12889fL5;
                this.f = bVar;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.e, this.f, interfaceC20295rm1);
                aVar.d = obj;
                return aVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0049 -> B:25:0x005b). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0055 -> B:24:0x0058). Please report as a decompilation issue!!! */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r6) {
                /*
                    r5 = this;
                    java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                    int r1 = r5.c
                    r2 = 1
                    if (r1 == 0) goto L1f
                    if (r1 != r2) goto L17
                    java.lang.Object r1 = r5.b
                    ir.nasim.fL5 r1 = (ir.nasim.C12889fL5) r1
                    java.lang.Object r3 = r5.d
                    ir.nasim.UA2 r3 = (ir.nasim.UA2) r3
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L58
                L17:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r0)
                    throw r6
                L1f:
                    ir.nasim.AbstractC10685c16.b(r6)
                    java.lang.Object r6 = r5.d
                    ir.nasim.UA2 r6 = (ir.nasim.UA2) r6
                    r3 = r6
                L27:
                    ir.nasim.fL5 r6 = r5.e
                    java.lang.Object r6 = r6.a
                    boolean r1 = r6 instanceof androidx.compose.foundation.gestures.a.d
                    if (r1 != 0) goto L5e
                    boolean r1 = r6 instanceof androidx.compose.foundation.gestures.a.C0034a
                    if (r1 != 0) goto L5e
                    boolean r1 = r6 instanceof androidx.compose.foundation.gestures.a.b
                    r4 = 0
                    if (r1 == 0) goto L3b
                    androidx.compose.foundation.gestures.a$b r6 = (androidx.compose.foundation.gestures.a.b) r6
                    goto L3c
                L3b:
                    r6 = r4
                L3c:
                    if (r6 == 0) goto L41
                    r3.invoke(r6)
                L41:
                    ir.nasim.fL5 r1 = r5.e
                    androidx.compose.foundation.gestures.b r6 = r5.f
                    ir.nasim.nJ0 r6 = androidx.compose.foundation.gestures.b.B2(r6)
                    if (r6 == 0) goto L5b
                    r5.d = r3
                    r5.b = r1
                    r5.c = r2
                    java.lang.Object r6 = r6.i(r5)
                    if (r6 != r0) goto L58
                    return r0
                L58:
                    r4 = r6
                    androidx.compose.foundation.gestures.a r4 = (androidx.compose.foundation.gestures.a) r4
                L5b:
                    r1.a = r4
                    goto L27
                L5e:
                    ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.b.f.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(ua2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            f fVar = b.this.new f(interfaceC20295rm1);
            fVar.e = obj;
            return fVar;
        }

        /* JADX WARN: Can't wrap try/catch for region: R(7:34|35|(1:37)|14|57|38|(2:44|(2:46|(1:48)))(2:40|(1:42))) */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00d7, code lost:
        
            r1 = r4;
         */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x008f  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00b9 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00c0 A[Catch: CancellationException -> 0x00d7, TryCatch #1 {CancellationException -> 0x00d7, blocks: (B:38:0x00ba, B:40:0x00c0, B:44:0x00d9, B:46:0x00dd), top: B:57:0x00ba }] */
        /* JADX WARN: Removed duplicated region for block: B:44:0x00d9 A[Catch: CancellationException -> 0x00d7, TryCatch #1 {CancellationException -> 0x00d7, blocks: (B:38:0x00ba, B:40:0x00c0, B:44:0x00d9, B:46:0x00dd), top: B:57:0x00ba }] */
        /* JADX WARN: Removed duplicated region for block: B:51:0x00fc A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00fd  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x008d -> B:19:0x005e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00d4 -> B:19:0x005e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00db -> B:19:0x005e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00ea -> B:19:0x005e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x00fa -> B:11:0x0027). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                Method dump skipped, instructions count: 274
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.b.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public b(UA2 ua2, boolean z, InterfaceC18507om4 interfaceC18507om4, EnumC24286yM4 enumC24286yM4) {
        this.q = enumC24286yM4;
        this.r = ua2;
        this.s = z;
        this.t = interfaceC18507om4;
    }

    private final InterfaceC22335v37 N2() {
        return AbstractC21071t37.a(new C0035b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object Q2(ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.compose.foundation.gestures.b.c
            if (r0 == 0) goto L13
            r0 = r6
            androidx.compose.foundation.gestures.b$c r0 = (androidx.compose.foundation.gestures.b.c) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.b$c r0 = new androidx.compose.foundation.gestures.b$c
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.a
            androidx.compose.foundation.gestures.b r0 = (androidx.compose.foundation.gestures.b) r0
            ir.nasim.AbstractC10685c16.b(r6)
            goto L51
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L35:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.GZ1 r6 = r5.w
            if (r6 == 0) goto L55
            ir.nasim.om4 r2 = r5.t
            if (r2 == 0) goto L50
            ir.nasim.FZ1 r4 = new ir.nasim.FZ1
            r4.<init>(r6)
            r0.a = r5
            r0.d = r3
            java.lang.Object r6 = r2.c(r4, r0)
            if (r6 != r1) goto L50
            return r1
        L50:
            r0 = r5
        L51:
            r6 = 0
            r0.w = r6
            goto L56
        L55:
            r0 = r5
        L56:
            ir.nasim.nR7$a r6 = ir.nasim.C17718nR7.b
            long r1 = r6.a()
            r0.P2(r1)
            ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.b.Q2(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object R2(androidx.compose.foundation.gestures.a.c r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof androidx.compose.foundation.gestures.b.d
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.foundation.gestures.b$d r0 = (androidx.compose.foundation.gestures.b.d) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.b$d r0 = new androidx.compose.foundation.gestures.b$d
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.d
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4c
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r7 = r0.c
            ir.nasim.GZ1 r7 = (ir.nasim.GZ1) r7
            java.lang.Object r1 = r0.b
            androidx.compose.foundation.gestures.a$c r1 = (androidx.compose.foundation.gestures.a.c) r1
            java.lang.Object r0 = r0.a
            androidx.compose.foundation.gestures.b r0 = (androidx.compose.foundation.gestures.b) r0
            ir.nasim.AbstractC10685c16.b(r8)
            goto L85
        L38:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L40:
            java.lang.Object r7 = r0.b
            androidx.compose.foundation.gestures.a$c r7 = (androidx.compose.foundation.gestures.a.c) r7
            java.lang.Object r2 = r0.a
            androidx.compose.foundation.gestures.b r2 = (androidx.compose.foundation.gestures.b) r2
            ir.nasim.AbstractC10685c16.b(r8)
            goto L6a
        L4c:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.GZ1 r8 = r6.w
            if (r8 == 0) goto L69
            ir.nasim.om4 r2 = r6.t
            if (r2 == 0) goto L69
            ir.nasim.FZ1 r5 = new ir.nasim.FZ1
            r5.<init>(r8)
            r0.a = r6
            r0.b = r7
            r0.f = r4
            java.lang.Object r8 = r2.c(r5, r0)
            if (r8 != r1) goto L69
            return r1
        L69:
            r2 = r6
        L6a:
            ir.nasim.GZ1 r8 = new ir.nasim.GZ1
            r8.<init>()
            ir.nasim.om4 r4 = r2.t
            if (r4 == 0) goto L88
            r0.a = r2
            r0.b = r7
            r0.c = r8
            r0.f = r3
            java.lang.Object r0 = r4.c(r8, r0)
            if (r0 != r1) goto L82
            return r1
        L82:
            r1 = r7
            r7 = r8
            r0 = r2
        L85:
            r8 = r7
            r2 = r0
            r7 = r1
        L88:
            r2.w = r8
            long r7 = r7.a()
            r2.O2(r7)
            ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.b.R2(androidx.compose.foundation.gestures.a$c, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object S2(androidx.compose.foundation.gestures.a.d r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.compose.foundation.gestures.b.e
            if (r0 == 0) goto L13
            r0 = r7
            androidx.compose.foundation.gestures.b$e r0 = (androidx.compose.foundation.gestures.b.e) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.b$e r0 = new androidx.compose.foundation.gestures.b$e
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r6 = r0.b
            androidx.compose.foundation.gestures.a$d r6 = (androidx.compose.foundation.gestures.a.d) r6
            java.lang.Object r0 = r0.a
            androidx.compose.foundation.gestures.b r0 = (androidx.compose.foundation.gestures.b) r0
            ir.nasim.AbstractC10685c16.b(r7)
            goto L57
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L39:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.GZ1 r7 = r5.w
            if (r7 == 0) goto L5b
            ir.nasim.om4 r2 = r5.t
            if (r2 == 0) goto L56
            ir.nasim.HZ1 r4 = new ir.nasim.HZ1
            r4.<init>(r7)
            r0.a = r5
            r0.b = r6
            r0.e = r3
            java.lang.Object r7 = r2.c(r4, r0)
            if (r7 != r1) goto L56
            return r1
        L56:
            r0 = r5
        L57:
            r7 = 0
            r0.w = r7
            goto L5c
        L5b:
            r0 = r5
        L5c:
            long r6 = r6.a()
            r0.P2(r6)
            ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.b.S2(androidx.compose.foundation.gestures.a$d, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U2() {
        this.x = true;
        AbstractC10533bm0.d(U1(), null, null, new f(null), 3, null);
    }

    public final void J2() {
        GZ1 gz1 = this.w;
        if (gz1 != null) {
            InterfaceC18507om4 interfaceC18507om4 = this.t;
            if (interfaceC18507om4 != null) {
                interfaceC18507om4.a(new FZ1(gz1));
            }
            this.w = null;
        }
    }

    public abstract Object K2(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1);

    protected final UA2 L2() {
        return this.r;
    }

    protected final boolean M2() {
        return this.s;
    }

    public abstract void O2(long j);

    public abstract void P2(long j);

    public abstract boolean T2();

    public final void V2(UA2 ua2, boolean z, InterfaceC18507om4 interfaceC18507om4, EnumC24286yM4 enumC24286yM4, boolean z2) {
        InterfaceC22335v37 interfaceC22335v37;
        this.r = ua2;
        boolean z3 = true;
        if (this.s != z) {
            this.s = z;
            if (!z) {
                J2();
                InterfaceC22335v37 interfaceC22335v372 = this.y;
                if (interfaceC22335v372 != null) {
                    y2(interfaceC22335v372);
                }
                this.y = null;
            }
            z2 = true;
        }
        if (!AbstractC13042fc3.d(this.t, interfaceC18507om4)) {
            J2();
            this.t = interfaceC18507om4;
        }
        if (this.q != enumC24286yM4) {
            this.q = enumC24286yM4;
        } else {
            z3 = z2;
        }
        if (!z3 || (interfaceC22335v37 = this.y) == null) {
            return;
        }
        interfaceC22335v37.N0();
    }

    @Override // androidx.compose.ui.e.c
    public void f2() {
        this.x = false;
        J2();
    }

    @Override // ir.nasim.InterfaceC8508Wg5
    public void i1() {
        InterfaceC22335v37 interfaceC22335v37 = this.y;
        if (interfaceC22335v37 != null) {
            interfaceC22335v37.i1();
        }
    }

    @Override // ir.nasim.InterfaceC8508Wg5
    public void k1(C3534Bg5 c3534Bg5, EnumC4002Dg5 enumC4002Dg5, long j) {
        if (this.s && this.y == null) {
            this.y = (InterfaceC22335v37) v2(N2());
        }
        InterfaceC22335v37 interfaceC22335v37 = this.y;
        if (interfaceC22335v37 != null) {
            interfaceC22335v37.k1(c3534Bg5, enumC4002Dg5, j);
        }
    }
}
