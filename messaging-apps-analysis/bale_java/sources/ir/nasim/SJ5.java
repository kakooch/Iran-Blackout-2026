package ir.nasim;

import androidx.compose.runtime.ComposeRuntimeError;
import androidx.compose.runtime.snapshots.g;
import androidx.compose.runtime.snapshots.h;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.C9475a16;
import ir.nasim.HE0;
import ir.nasim.InterfaceC13730gj3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class SJ5 extends AbstractC7050Qb1 {
    public static final a C = new a(null);
    public static final int D = 8;
    private static final InterfaceC9336Zm4 E = AbstractC12281eL6.a(AbstractC7078Qe2.b());
    private static final AtomicReference F = new AtomicReference(Boolean.FALSE);
    private C3587Bm4 A;
    private final c B;
    private long a;
    private final C9314Zk0 b;
    private final Object c;
    private InterfaceC13730gj3 d;
    private Throwable e;
    private final List f;
    private List g;
    private C7620Sm4 h;
    private final C12544en4 i;
    private final List j;
    private final List k;
    private final C7386Rm4 l;
    private final C22796vq4 m;
    private final C7386Rm4 n;
    private final C7386Rm4 o;
    private List p;
    private Set q;
    private HE0 r;
    private int s;
    private boolean t;
    private b u;
    private boolean v;
    private final InterfaceC9336Zm4 w;
    private final C15854kH6 x;
    private final InterfaceC24075y01 y;
    private final InterfaceC11938do1 z;

    public static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void c(c cVar) {
            InterfaceC21763u55 interfaceC21763u55;
            InterfaceC21763u55 interfaceC21763u55Add;
            do {
                interfaceC21763u55 = (InterfaceC21763u55) SJ5.E.getValue();
                interfaceC21763u55Add = interfaceC21763u55.add((Object) cVar);
                if (interfaceC21763u55 == interfaceC21763u55Add) {
                    return;
                }
            } while (!SJ5.E.f(interfaceC21763u55, interfaceC21763u55Add));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d(c cVar) {
            InterfaceC21763u55 interfaceC21763u55;
            InterfaceC21763u55 interfaceC21763u55Remove;
            do {
                interfaceC21763u55 = (InterfaceC21763u55) SJ5.E.getValue();
                interfaceC21763u55Remove = interfaceC21763u55.remove((Object) cVar);
                if (interfaceC21763u55 == interfaceC21763u55Remove) {
                    return;
                }
            } while (!SJ5.E.f(interfaceC21763u55, interfaceC21763u55Remove));
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private static final class b {
        private final boolean a;
        private final Throwable b;

        public b(boolean z, Throwable th) {
            this.a = z;
            this.b = th;
        }

        public Throwable a() {
            return this.b;
        }
    }

    private final class c {
        public c() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class d {
        public static final d a = new d("ShutDown", 0);
        public static final d b = new d("ShuttingDown", 1);
        public static final d c = new d("Inactive", 2);
        public static final d d = new d("InactivePendingWork", 3);
        public static final d e = new d("Idle", 4);
        public static final d f = new d("PendingWork", 5);
        private static final /* synthetic */ d[] g;
        private static final /* synthetic */ F92 h;

        static {
            d[] dVarArrA = a();
            g = dVarArrA;
            h = G92.a(dVarArrA);
        }

        private d(String str, int i) {
        }

        private static final /* synthetic */ d[] a() {
            return new d[]{a, b, c, d, e, f};
        }

        public static d valueOf(String str) {
            return (d) Enum.valueOf(d.class, str);
        }

        public static d[] values() {
            return (d[]) g.clone();
        }
    }

    static final class e extends AbstractC8614Ws3 implements SA2 {
        e() {
            super(0);
        }

        public final void a() {
            HE0 he0A0;
            Object obj = SJ5.this.c;
            SJ5 sj5 = SJ5.this;
            synchronized (obj) {
                he0A0 = sj5.a0();
                if (((d) sj5.w.getValue()).compareTo(d.b) <= 0) {
                    throw AbstractC15450jc2.a("Recomposer shutdown; frame clock awaiter will never resume", sj5.e);
                }
            }
            if (he0A0 != null) {
                C9475a16.a aVar = C9475a16.b;
                he0A0.resumeWith(C9475a16.b(C19938rB7.a));
            }
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    static final class f extends AbstractC8614Ws3 implements UA2 {

        static final class a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ SJ5 e;
            final /* synthetic */ Throwable f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(SJ5 sj5, Throwable th) {
                super(1);
                this.e = sj5;
                this.f = th;
            }

            public final void a(Throwable th) {
                Object obj = this.e.c;
                SJ5 sj5 = this.e;
                Throwable th2 = this.f;
                synchronized (obj) {
                    if (th2 == null) {
                        th2 = null;
                    } else if (th != null) {
                        try {
                            if (th instanceof CancellationException) {
                                th = null;
                            }
                            if (th != null) {
                                AbstractC16632lc2.a(th2, th);
                            }
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                    sj5.e = th2;
                    sj5.w.setValue(d.a);
                    C19938rB7 c19938rB7 = C19938rB7.a;
                }
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((Throwable) obj);
                return C19938rB7.a;
            }
        }

        f() {
            super(1);
        }

        public final void a(Throwable th) {
            HE0 he0;
            HE0 he02;
            CancellationException cancellationExceptionA = AbstractC15450jc2.a("Recomposer effect job completed", th);
            Object obj = SJ5.this.c;
            SJ5 sj5 = SJ5.this;
            synchronized (obj) {
                try {
                    InterfaceC13730gj3 interfaceC13730gj3 = sj5.d;
                    he0 = null;
                    if (interfaceC13730gj3 != null) {
                        sj5.w.setValue(d.b);
                        if (sj5.t) {
                            if (sj5.r != null) {
                                he02 = sj5.r;
                            }
                            sj5.r = null;
                            interfaceC13730gj3.s(new a(sj5, th));
                            he0 = he02;
                        } else {
                            interfaceC13730gj3.g(cancellationExceptionA);
                        }
                        he02 = null;
                        sj5.r = null;
                        interfaceC13730gj3.s(new a(sj5, th));
                        he0 = he02;
                    } else {
                        sj5.e = cancellationExceptionA;
                        sj5.w.setValue(d.a);
                        C19938rB7 c19938rB7 = C19938rB7.a;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (he0 != null) {
                C9475a16.a aVar = C9475a16.b;
                he0.resumeWith(C9475a16.b(C19938rB7.a));
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return C19938rB7.a;
        }
    }

    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            g gVar = new g(interfaceC20295rm1);
            gVar.c = obj;
            return gVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return AbstractC6392Nk0.a(((d) this.c) == d.a);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(d dVar, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(dVar, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class h extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ C7620Sm4 e;
        final /* synthetic */ InterfaceC25123zm1 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(C7620Sm4 c7620Sm4, InterfaceC25123zm1 interfaceC25123zm1) {
            super(0);
            this.e = c7620Sm4;
            this.f = interfaceC25123zm1;
        }

        public final void a() {
            C7620Sm4 c7620Sm4 = this.e;
            InterfaceC25123zm1 interfaceC25123zm1 = this.f;
            Object[] objArr = c7620Sm4.b;
            long[] jArr = c7620Sm4.a;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            interfaceC25123zm1.q(objArr[(i << 3) + i3]);
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i == length) {
                    return;
                } else {
                    i++;
                }
            }
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    static final class i extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC25123zm1 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(InterfaceC25123zm1 interfaceC25123zm1) {
            super(1);
            this.e = interfaceC25123zm1;
        }

        public final void a(Object obj) {
            this.e.b(obj);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(obj);
            return C19938rB7.a;
        }
    }

    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        private /* synthetic */ Object d;
        final /* synthetic */ InterfaceC15796kB2 f;
        final /* synthetic */ InterfaceC15522jj4 g;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ InterfaceC15796kB2 d;
            final /* synthetic */ InterfaceC15522jj4 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC15796kB2 interfaceC15796kB2, InterfaceC15522jj4 interfaceC15522jj4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC15796kB2;
                this.e = interfaceC15522jj4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                    InterfaceC15796kB2 interfaceC15796kB2 = this.d;
                    InterfaceC15522jj4 interfaceC15522jj4 = this.e;
                    this.b = 1;
                    if (interfaceC15796kB2.q(interfaceC20315ro1, interfaceC15522jj4, this) == objE) {
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
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            final /* synthetic */ SJ5 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(SJ5 sj5) {
                super(2);
                this.e = sj5;
            }

            /* JADX WARN: Removed duplicated region for block: B:30:0x0084  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void a(java.util.Set r20, androidx.compose.runtime.snapshots.g r21) {
                /*
                    r19 = this;
                    r1 = r19
                    r0 = r20
                    r2 = 1
                    ir.nasim.SJ5 r3 = r1.e
                    java.lang.Object r3 = ir.nasim.SJ5.G(r3)
                    ir.nasim.SJ5 r4 = r1.e
                    monitor-enter(r3)
                    ir.nasim.Zm4 r5 = ir.nasim.SJ5.J(r4)     // Catch: java.lang.Throwable -> L74
                    java.lang.Object r5 = r5.getValue()     // Catch: java.lang.Throwable -> L74
                    ir.nasim.SJ5$d r5 = (ir.nasim.SJ5.d) r5     // Catch: java.lang.Throwable -> L74
                    ir.nasim.SJ5$d r6 = ir.nasim.SJ5.d.e     // Catch: java.lang.Throwable -> L74
                    int r5 = r5.compareTo(r6)     // Catch: java.lang.Throwable -> L74
                    if (r5 < 0) goto Lb3
                    ir.nasim.Sm4 r5 = ir.nasim.SJ5.F(r4)     // Catch: java.lang.Throwable -> L74
                    boolean r6 = r0 instanceof ir.nasim.C23844xc6     // Catch: java.lang.Throwable -> L74
                    if (r6 == 0) goto L88
                    ir.nasim.xc6 r0 = (ir.nasim.C23844xc6) r0     // Catch: java.lang.Throwable -> L74
                    ir.nasim.vc6 r0 = r0.f()     // Catch: java.lang.Throwable -> L74
                    java.lang.Object[] r6 = r0.b     // Catch: java.lang.Throwable -> L74
                    long[] r0 = r0.a     // Catch: java.lang.Throwable -> L74
                    int r7 = r0.length     // Catch: java.lang.Throwable -> L74
                    int r7 = r7 + (-2)
                    if (r7 < 0) goto Lae
                    r9 = 0
                L38:
                    r10 = r0[r9]     // Catch: java.lang.Throwable -> L74
                    long r12 = ~r10     // Catch: java.lang.Throwable -> L74
                    r14 = 7
                    long r12 = r12 << r14
                    long r12 = r12 & r10
                    r14 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
                    long r12 = r12 & r14
                    int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
                    if (r12 == 0) goto L84
                    int r12 = r9 - r7
                    int r12 = ~r12     // Catch: java.lang.Throwable -> L74
                    int r12 = r12 >>> 31
                    r13 = 8
                    int r12 = 8 - r12
                    r14 = 0
                L52:
                    if (r14 >= r12) goto L81
                    r15 = 255(0xff, double:1.26E-321)
                    long r15 = r15 & r10
                    r17 = 128(0x80, double:6.3E-322)
                    int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
                    if (r15 >= 0) goto L7c
                    int r15 = r9 << 3
                    int r15 = r15 + r14
                    r15 = r6[r15]     // Catch: java.lang.Throwable -> L74
                    boolean r8 = r15 instanceof ir.nasim.AbstractC15299jL6     // Catch: java.lang.Throwable -> L74
                    if (r8 == 0) goto L76
                    r8 = r15
                    ir.nasim.jL6 r8 = (ir.nasim.AbstractC15299jL6) r8     // Catch: java.lang.Throwable -> L74
                    int r13 = androidx.compose.runtime.snapshots.e.a(r2)     // Catch: java.lang.Throwable -> L74
                    boolean r8 = r8.z(r13)     // Catch: java.lang.Throwable -> L74
                    if (r8 != 0) goto L76
                    goto L79
                L74:
                    r0 = move-exception
                    goto Lc3
                L76:
                    r5.h(r15)     // Catch: java.lang.Throwable -> L74
                L79:
                    r8 = 8
                    goto L7d
                L7c:
                    r8 = r13
                L7d:
                    long r10 = r10 >> r8
                    int r14 = r14 + r2
                    r13 = r8
                    goto L52
                L81:
                    r8 = r13
                    if (r12 != r8) goto Lae
                L84:
                    if (r9 == r7) goto Lae
                    int r9 = r9 + r2
                    goto L38
                L88:
                    java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Throwable -> L74
                    java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L74
                L8e:
                    boolean r6 = r0.hasNext()     // Catch: java.lang.Throwable -> L74
                    if (r6 == 0) goto Lae
                    java.lang.Object r6 = r0.next()     // Catch: java.lang.Throwable -> L74
                    boolean r7 = r6 instanceof ir.nasim.AbstractC15299jL6     // Catch: java.lang.Throwable -> L74
                    if (r7 == 0) goto Laa
                    r7 = r6
                    ir.nasim.jL6 r7 = (ir.nasim.AbstractC15299jL6) r7     // Catch: java.lang.Throwable -> L74
                    int r8 = androidx.compose.runtime.snapshots.e.a(r2)     // Catch: java.lang.Throwable -> L74
                    boolean r7 = r7.z(r8)     // Catch: java.lang.Throwable -> L74
                    if (r7 != 0) goto Laa
                    goto L8e
                Laa:
                    r5.h(r6)     // Catch: java.lang.Throwable -> L74
                    goto L8e
                Lae:
                    ir.nasim.HE0 r0 = ir.nasim.SJ5.t(r4)     // Catch: java.lang.Throwable -> L74
                    goto Lb4
                Lb3:
                    r0 = 0
                Lb4:
                    monitor-exit(r3)
                    if (r0 == 0) goto Lc2
                    ir.nasim.a16$a r2 = ir.nasim.C9475a16.b
                    ir.nasim.rB7 r2 = ir.nasim.C19938rB7.a
                    java.lang.Object r2 = ir.nasim.C9475a16.b(r2)
                    r0.resumeWith(r2)
                Lc2:
                    return
                Lc3:
                    monitor-exit(r3)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.SJ5.j.b.a(java.util.Set, androidx.compose.runtime.snapshots.g):void");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((Set) obj, (androidx.compose.runtime.snapshots.g) obj2);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(InterfaceC15796kB2 interfaceC15796kB2, InterfaceC15522jj4 interfaceC15522jj4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.f = interfaceC15796kB2;
            this.g = interfaceC15522jj4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            j jVar = SJ5.this.new j(this.f, this.g, interfaceC20295rm1);
            jVar.d = obj;
            return jVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:56:0x00cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:58:0x009c A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 233
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.SJ5.j.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class k extends AbstractC19859r37 implements InterfaceC15796kB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        Object g;
        Object h;
        Object i;
        int j;
        /* synthetic */ Object k;

        static final class a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ SJ5 e;
            final /* synthetic */ C7620Sm4 f;
            final /* synthetic */ C7620Sm4 g;
            final /* synthetic */ List h;
            final /* synthetic */ List i;
            final /* synthetic */ C7620Sm4 j;
            final /* synthetic */ List k;
            final /* synthetic */ C7620Sm4 l;
            final /* synthetic */ Set m;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(SJ5 sj5, C7620Sm4 c7620Sm4, C7620Sm4 c7620Sm42, List list, List list2, C7620Sm4 c7620Sm43, List list3, C7620Sm4 c7620Sm44, Set set) {
                super(1);
                this.e = sj5;
                this.f = c7620Sm4;
                this.g = c7620Sm42;
                this.h = list;
                this.i = list2;
                this.j = c7620Sm43;
                this.k = list3;
                this.l = c7620Sm44;
                this.m = set;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:207:0x01ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:216:0x0236 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:222:0x011d A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:88:0x01a5  */
            /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Object] */
            /* JADX WARN: Type inference failed for: r7v1 */
            /* JADX WARN: Type inference failed for: r7v13 */
            /* JADX WARN: Type inference failed for: r7v2 */
            /* JADX WARN: Type inference failed for: r7v33 */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void a(long r28) throws java.lang.Throwable {
                /*
                    Method dump skipped, instructions count: 891
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.SJ5.k.a.a(long):void");
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) throws Throwable {
                a(((Number) obj).longValue());
                return C19938rB7.a;
            }
        }

        k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void D(List list, SJ5 sj5) {
            list.clear();
            synchronized (sj5.c) {
                try {
                    List list2 = sj5.k;
                    int size = list2.size();
                    for (int i = 0; i < size; i++) {
                        list.add((C20869sk4) list2.get(i));
                    }
                    sj5.k.clear();
                    C19938rB7 c19938rB7 = C19938rB7.a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00d5  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static final void z(ir.nasim.SJ5 r23, java.util.List r24, java.util.List r25, java.util.List r26, ir.nasim.C7620Sm4 r27, ir.nasim.C7620Sm4 r28, ir.nasim.C7620Sm4 r29, ir.nasim.C7620Sm4 r30) {
            /*
                Method dump skipped, instructions count: 327
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.SJ5.k.z(ir.nasim.SJ5, java.util.List, java.util.List, java.util.List, ir.nasim.Sm4, ir.nasim.Sm4, ir.nasim.Sm4, ir.nasim.Sm4):void");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:13:0x00be  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x00ed  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0151  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0166  */
        /* JADX WARN: Type inference failed for: r10v11, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r10v14, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r11v11, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r11v14, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r9v12, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r9v15, types: [java.util.List] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0139 -> B:23:0x0142). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0151 -> B:24:0x014d). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r26) {
            /*
                Method dump skipped, instructions count: 361
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.SJ5.k.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final Object q(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC15522jj4 interfaceC15522jj4, InterfaceC20295rm1 interfaceC20295rm1) {
            k kVar = SJ5.this.new k(interfaceC20295rm1);
            kVar.k = interfaceC15522jj4;
            return kVar.invokeSuspend(C19938rB7.a);
        }
    }

    static final class l extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC25123zm1 e;
        final /* synthetic */ C7620Sm4 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(InterfaceC25123zm1 interfaceC25123zm1, C7620Sm4 c7620Sm4) {
            super(1);
            this.e = interfaceC25123zm1;
            this.f = c7620Sm4;
        }

        public final void a(Object obj) {
            this.e.q(obj);
            C7620Sm4 c7620Sm4 = this.f;
            if (c7620Sm4 != null) {
                c7620Sm4.h(obj);
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(obj);
            return C19938rB7.a;
        }
    }

    public SJ5(InterfaceC11938do1 interfaceC11938do1) {
        C9314Zk0 c9314Zk0 = new C9314Zk0(new e());
        this.b = c9314Zk0;
        this.c = new Object();
        this.f = new ArrayList();
        this.h = new C7620Sm4(0, 1, null);
        this.i = new C12544en4(new InterfaceC25123zm1[16], 0);
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.l = C6405Nl4.e(null, 1, null);
        this.m = new C22796vq4();
        this.n = AbstractC22068uc6.b();
        this.o = C6405Nl4.e(null, 1, null);
        this.w = AbstractC12281eL6.a(d.c);
        this.x = new C15854kH6();
        InterfaceC24075y01 interfaceC24075y01A = AbstractC19067pj3.a((InterfaceC13730gj3) interfaceC11938do1.a(InterfaceC13730gj3.n0));
        interfaceC24075y01A.s(new f());
        this.y = interfaceC24075y01A;
        this.z = interfaceC11938do1.X(c9314Zk0).X(interfaceC24075y01A);
        this.B = new c();
    }

    private final UA2 A0(InterfaceC25123zm1 interfaceC25123zm1, C7620Sm4 c7620Sm4) {
        return new l(interfaceC25123zm1, c7620Sm4);
    }

    private final void V(InterfaceC25123zm1 interfaceC25123zm1) {
        this.f.add(interfaceC25123zm1);
        this.g = null;
        C3587Bm4 c3587Bm4 = this.A;
        if (c3587Bm4 != null) {
            Object[] objArr = c3587Bm4.a;
            if (c3587Bm4.b <= 0) {
                return;
            }
            AbstractC18350oW3.a(objArr[0]);
            throw null;
        }
    }

    private final void W(androidx.compose.runtime.snapshots.b bVar) {
        try {
            if (bVar.C() instanceof h.a) {
                throw new IllegalStateException("Unsupported concurrent change during composition. A state object was modified by composition as well as being modified outside composition.".toString());
            }
        } finally {
            bVar.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object X(InterfaceC20295rm1 interfaceC20295rm1) {
        IE0 ie0;
        if (h0()) {
            return C19938rB7.a;
        }
        IE0 ie02 = new IE0(AbstractC14251hc3.c(interfaceC20295rm1), 1);
        ie02.w();
        synchronized (this.c) {
            if (h0()) {
                ie0 = ie02;
            } else {
                this.r = ie02;
                ie0 = null;
            }
        }
        if (ie0 != null) {
            C9475a16.a aVar = C9475a16.b;
            ie0.resumeWith(C9475a16.b(C19938rB7.a));
        }
        Object objT = ie02.t();
        if (objT == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objT == AbstractC14862ic3.e() ? objT : C19938rB7.a;
    }

    private final void Z() {
        C3587Bm4 c3587Bm4 = this.A;
        if (c3587Bm4 != null) {
            Object[] objArr = c3587Bm4.a;
            int i2 = c3587Bm4.b;
            for (int i3 = 0; i3 < i2; i3++) {
                AbstractC18350oW3.a(objArr[i3]);
                Iterator it = i0().iterator();
                if (it.hasNext()) {
                    throw null;
                }
            }
        }
        this.f.clear();
        this.g = AbstractC10360bX0.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HE0 a0() {
        d dVar;
        if (((d) this.w.getValue()).compareTo(d.b) <= 0) {
            Z();
            this.h = new C7620Sm4(0, 1, null);
            this.i.k();
            this.j.clear();
            this.k.clear();
            this.p = null;
            HE0 he0 = this.r;
            if (he0 != null) {
                HE0.a.a(he0, null, 1, null);
            }
            this.r = null;
            this.u = null;
            return null;
        }
        if (this.u != null) {
            dVar = d.c;
        } else if (this.d == null) {
            this.h = new C7620Sm4(0, 1, null);
            this.i.k();
            dVar = f0() ? d.d : d.c;
        } else {
            dVar = (this.i.o() != 0 || this.h.e() || (this.j.isEmpty() ^ true) || (this.k.isEmpty() ^ true) || this.s > 0 || f0()) ? d.f : d.e;
        }
        this.w.setValue(dVar);
        if (dVar != d.f) {
            return null;
        }
        HE0 he02 = this.r;
        this.r = null;
        return he02;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0() {
        int i2;
        AbstractC23052wG4 abstractC23052wG4F;
        synchronized (this.c) {
            try {
                if (C6405Nl4.j(this.l)) {
                    AbstractC23052wG4 abstractC23052wG4P = C6405Nl4.p(this.l);
                    C6405Nl4.c(this.l);
                    this.m.a();
                    C6405Nl4.c(this.o);
                    C3587Bm4 c3587Bm4 = new C3587Bm4(abstractC23052wG4P.e());
                    Object[] objArr = abstractC23052wG4P.a;
                    int i3 = abstractC23052wG4P.b;
                    for (int i4 = 0; i4 < i3; i4++) {
                        C20869sk4 c20869sk4 = (C20869sk4) objArr[i4];
                        c3587Bm4.n(AbstractC4616Fw7.a(c20869sk4, this.n.e(c20869sk4)));
                    }
                    this.n.k();
                    abstractC23052wG4F = c3587Bm4;
                } else {
                    abstractC23052wG4F = AbstractC23642xG4.f();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Object[] objArr2 = abstractC23052wG4F.a;
        int i5 = abstractC23052wG4F.b;
        for (i2 = 0; i2 < i5; i2++) {
            XV4 xv4 = (XV4) objArr2[i2];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e0() {
        boolean zF0;
        synchronized (this.c) {
            zF0 = f0();
        }
        return zF0;
    }

    private final boolean f0() {
        return !this.v && this.b.v();
    }

    private final boolean g0() {
        return this.i.o() != 0 || f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean h0() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.c
            monitor-enter(r0)
            ir.nasim.Sm4 r1 = r2.h     // Catch: java.lang.Throwable -> L1d
            boolean r1 = r1.e()     // Catch: java.lang.Throwable -> L1d
            if (r1 != 0) goto L1f
            ir.nasim.en4 r1 = r2.i     // Catch: java.lang.Throwable -> L1d
            int r1 = r1.o()     // Catch: java.lang.Throwable -> L1d
            if (r1 == 0) goto L14
            goto L1f
        L14:
            boolean r1 = r2.f0()     // Catch: java.lang.Throwable -> L1d
            if (r1 == 0) goto L1b
            goto L1f
        L1b:
            r1 = 0
            goto L20
        L1d:
            r1 = move-exception
            goto L22
        L1f:
            r1 = 1
        L20:
            monitor-exit(r0)
            return r1
        L22:
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.SJ5.h0():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List i0() {
        List listM = this.g;
        if (listM == null) {
            List list = this.f;
            listM = list.isEmpty() ? AbstractC10360bX0.m() : new ArrayList(list);
            this.g = listM;
        }
        return listM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j0() {
        boolean z;
        synchronized (this.c) {
            z = !this.t;
        }
        if (z) {
            return true;
        }
        Iterator it = this.y.d().iterator();
        while (it.hasNext()) {
            if (((InterfaceC13730gj3) it.next()).b()) {
                return true;
            }
        }
        return false;
    }

    private final void m0(InterfaceC25123zm1 interfaceC25123zm1) {
        synchronized (this.c) {
            List list = this.k;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (AbstractC13042fc3.d(((C20869sk4) list.get(i2)).b(), interfaceC25123zm1)) {
                    C19938rB7 c19938rB7 = C19938rB7.a;
                    ArrayList arrayList = new ArrayList();
                    n0(arrayList, this, interfaceC25123zm1);
                    while (!arrayList.isEmpty()) {
                        o0(arrayList, null);
                        n0(arrayList, this, interfaceC25123zm1);
                    }
                    return;
                }
            }
        }
    }

    private static final void n0(List list, SJ5 sj5, InterfaceC25123zm1 interfaceC25123zm1) {
        list.clear();
        synchronized (sj5.c) {
            try {
                Iterator it = sj5.k.iterator();
                while (it.hasNext()) {
                    C20869sk4 c20869sk4 = (C20869sk4) it.next();
                    if (AbstractC13042fc3.d(c20869sk4.b(), interfaceC25123zm1)) {
                        list.add(c20869sk4);
                        it.remove();
                    }
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x012e, code lost:
    
        r3 = r10.size();
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0133, code lost:
    
        if (r4 >= r3) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x013f, code lost:
    
        if (((ir.nasim.XV4) r10.get(r4)).f() == null) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0141, code lost:
    
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0144, code lost:
    
        r3 = new java.util.ArrayList(r10.size());
        r4 = r10.size();
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0152, code lost:
    
        if (r9 >= r4) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0154, code lost:
    
        r11 = (ir.nasim.XV4) r10.get(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x015e, code lost:
    
        if (r11.f() != null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0160, code lost:
    
        r11 = (ir.nasim.C20869sk4) r11.e();
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0169, code lost:
    
        r11 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x016a, code lost:
    
        if (r11 == null) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x016c, code lost:
    
        r3.add(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x016f, code lost:
    
        r9 = r9 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0172, code lost:
    
        r4 = r16.c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0174, code lost:
    
        monitor-enter(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0175, code lost:
    
        r0 = ir.nasim.AbstractC13610gX0.D(r16.k, r3);
        r3 = ir.nasim.C19938rB7.a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x017e, code lost:
    
        monitor-exit(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x017f, code lost:
    
        r3 = new java.util.ArrayList(r10.size());
        r4 = r10.size();
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x018d, code lost:
    
        if (r9 >= r4) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x018f, code lost:
    
        r11 = r10.get(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x019a, code lost:
    
        if (((ir.nasim.XV4) r11).f() == null) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x019c, code lost:
    
        r3.add(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x019f, code lost:
    
        r9 = r9 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01a2, code lost:
    
        r10 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List o0(java.util.List r17, ir.nasim.C7620Sm4 r18) {
        /*
            Method dump skipped, instructions count: 459
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.SJ5.o0(java.util.List, ir.nasim.Sm4):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC25123zm1 p0(InterfaceC25123zm1 interfaceC25123zm1, C7620Sm4 c7620Sm4) {
        Set set;
        if (interfaceC25123zm1.p() || interfaceC25123zm1.a() || ((set = this.q) != null && set.contains(interfaceC25123zm1))) {
            return null;
        }
        androidx.compose.runtime.snapshots.b bVarN = androidx.compose.runtime.snapshots.g.e.n(s0(interfaceC25123zm1), A0(interfaceC25123zm1, c7620Sm4));
        try {
            androidx.compose.runtime.snapshots.g gVarL = bVarN.l();
            if (c7620Sm4 != null) {
                try {
                    if (c7620Sm4.e()) {
                        interfaceC25123zm1.g(new h(c7620Sm4, interfaceC25123zm1));
                    }
                } catch (Throwable th) {
                    bVarN.s(gVarL);
                    throw th;
                }
            }
            boolean zH = interfaceC25123zm1.h();
            bVarN.s(gVarL);
            if (zH) {
                return interfaceC25123zm1;
            }
            return null;
        } finally {
            W(bVarN);
        }
    }

    private final void q0(Throwable th, InterfaceC25123zm1 interfaceC25123zm1, boolean z) throws Throwable {
        if (!((Boolean) F.get()).booleanValue() || (th instanceof ComposeRuntimeError)) {
            synchronized (this.c) {
                b bVar = this.u;
                if (bVar != null) {
                    throw bVar.a();
                }
                this.u = new b(false, th);
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
            throw th;
        }
        synchronized (this.c) {
            try {
                AN7.a("Error was captured in composition while live edit was enabled.", th);
                this.j.clear();
                this.i.k();
                this.h = new C7620Sm4(0, 1, null);
                this.k.clear();
                C6405Nl4.c(this.l);
                this.n.k();
                this.u = new b(z, th);
                if (interfaceC25123zm1 != null) {
                    v0(interfaceC25123zm1);
                }
                a0();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    static /* synthetic */ void r0(SJ5 sj5, Throwable th, InterfaceC25123zm1 interfaceC25123zm1, boolean z, int i2, Object obj) throws Throwable {
        if ((i2 & 2) != 0) {
            interfaceC25123zm1 = null;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        sj5.q0(th, interfaceC25123zm1, z);
    }

    private final UA2 s0(InterfaceC25123zm1 interfaceC25123zm1) {
        return new i(interfaceC25123zm1);
    }

    private final Object t0(InterfaceC15796kB2 interfaceC15796kB2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(this.b, new j(interfaceC15796kB2, AbstractC16704lj4.a(interfaceC20295rm1.getContext()), null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean u0() {
        List listI0;
        boolean zG0;
        synchronized (this.c) {
            if (this.h.d()) {
                return g0();
            }
            Set setA = AbstractC24434yc6.a(this.h);
            this.h = new C7620Sm4(0, 1, null);
            synchronized (this.c) {
                listI0 = i0();
            }
            try {
                int size = listI0.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((InterfaceC25123zm1) listI0.get(i2)).n(setA);
                    if (((d) this.w.getValue()).compareTo(d.b) <= 0) {
                        break;
                    }
                }
                synchronized (this.c) {
                    this.h = new C7620Sm4(0, 1, null);
                    C19938rB7 c19938rB7 = C19938rB7.a;
                }
                synchronized (this.c) {
                    if (a0() != null) {
                        throw new IllegalStateException("called outside of runRecomposeAndApplyChanges".toString());
                    }
                    zG0 = g0();
                }
                return zG0;
            } catch (Throwable th) {
                synchronized (this.c) {
                    this.h.j(setA);
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v0(InterfaceC25123zm1 interfaceC25123zm1) {
        List arrayList = this.p;
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.p = arrayList;
        }
        if (!arrayList.contains(interfaceC25123zm1)) {
            arrayList.add(interfaceC25123zm1);
        }
        x0(interfaceC25123zm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w0(InterfaceC13730gj3 interfaceC13730gj3) {
        synchronized (this.c) {
            Throwable th = this.e;
            if (th != null) {
                throw th;
            }
            if (((d) this.w.getValue()).compareTo(d.b) <= 0) {
                throw new IllegalStateException("Recomposer shut down".toString());
            }
            if (this.d != null) {
                throw new IllegalStateException("Recomposer already running".toString());
            }
            this.d = interfaceC13730gj3;
            a0();
        }
    }

    private final void x0(InterfaceC25123zm1 interfaceC25123zm1) {
        if (this.f.remove(interfaceC25123zm1)) {
            this.g = null;
            C3587Bm4 c3587Bm4 = this.A;
            if (c3587Bm4 != null) {
                Object[] objArr = c3587Bm4.a;
                if (c3587Bm4.b <= 0) {
                    return;
                }
                AbstractC18350oW3.a(objArr[0]);
                throw null;
            }
        }
    }

    public final void Y() {
        synchronized (this.c) {
            try {
                if (((d) this.w.getValue()).compareTo(d.e) >= 0) {
                    this.w.setValue(d.b);
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        InterfaceC13730gj3.a.a(this.y, null, 1, null);
    }

    @Override // ir.nasim.AbstractC7050Qb1
    public void a(InterfaceC25123zm1 interfaceC25123zm1, InterfaceC14603iB2 interfaceC14603iB2) throws Throwable {
        boolean zP = interfaceC25123zm1.p();
        try {
            g.a aVar = androidx.compose.runtime.snapshots.g.e;
            androidx.compose.runtime.snapshots.b bVarN = aVar.n(s0(interfaceC25123zm1), A0(interfaceC25123zm1, null));
            try {
                androidx.compose.runtime.snapshots.g gVarL = bVarN.l();
                try {
                    interfaceC25123zm1.t(interfaceC14603iB2);
                    C19938rB7 c19938rB7 = C19938rB7.a;
                    if (!zP) {
                        aVar.f();
                    }
                    synchronized (this.c) {
                        if (((d) this.w.getValue()).compareTo(d.b) > 0 && !i0().contains(interfaceC25123zm1)) {
                            V(interfaceC25123zm1);
                        }
                    }
                    try {
                        m0(interfaceC25123zm1);
                        try {
                            interfaceC25123zm1.o();
                            interfaceC25123zm1.e();
                            if (zP) {
                                return;
                            }
                            aVar.f();
                        } catch (Throwable th) {
                            r0(this, th, null, false, 6, null);
                        }
                    } catch (Throwable th2) {
                        q0(th2, interfaceC25123zm1, true);
                    }
                } finally {
                    bVarN.s(gVarL);
                }
            } finally {
                W(bVarN);
            }
        } catch (Throwable th3) {
            q0(th3, interfaceC25123zm1, true);
        }
    }

    @Override // ir.nasim.AbstractC7050Qb1
    public boolean c() {
        return ((Boolean) F.get()).booleanValue();
    }

    public final long c0() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC7050Qb1
    public boolean d() {
        return false;
    }

    public final InterfaceC10258bL6 d0() {
        return this.w;
    }

    @Override // ir.nasim.AbstractC7050Qb1
    public boolean e() {
        return false;
    }

    @Override // ir.nasim.AbstractC7050Qb1
    public int g() {
        return AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
    }

    @Override // ir.nasim.AbstractC7050Qb1
    public InterfaceC11938do1 h() {
        return this.z;
    }

    @Override // ir.nasim.AbstractC7050Qb1
    public void j(C20869sk4 c20869sk4) {
        HE0 he0A0;
        synchronized (this.c) {
            this.k.add(c20869sk4);
            he0A0 = a0();
        }
        if (he0A0 != null) {
            C9475a16.a aVar = C9475a16.b;
            he0A0.resumeWith(C9475a16.b(C19938rB7.a));
        }
    }

    @Override // ir.nasim.AbstractC7050Qb1
    public void k(InterfaceC25123zm1 interfaceC25123zm1) {
        HE0 he0A0;
        synchronized (this.c) {
            if (this.i.l(interfaceC25123zm1)) {
                he0A0 = null;
            } else {
                this.i.d(interfaceC25123zm1);
                he0A0 = a0();
            }
        }
        if (he0A0 != null) {
            C9475a16.a aVar = C9475a16.b;
            he0A0.resumeWith(C9475a16.b(C19938rB7.a));
        }
    }

    public final Object k0(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objH = AbstractC6459Nq2.H(d0(), new g(null), interfaceC20295rm1);
        return objH == AbstractC14862ic3.e() ? objH : C19938rB7.a;
    }

    @Override // ir.nasim.AbstractC7050Qb1
    public AbstractC20278rk4 l(C20869sk4 c20869sk4) {
        AbstractC20278rk4 abstractC20278rk4;
        synchronized (this.c) {
            abstractC20278rk4 = (AbstractC20278rk4) this.n.u(c20869sk4);
        }
        return abstractC20278rk4;
    }

    public final void l0() {
        synchronized (this.c) {
            this.v = true;
            C19938rB7 c19938rB7 = C19938rB7.a;
        }
    }

    @Override // ir.nasim.AbstractC7050Qb1
    public void o(InterfaceC25123zm1 interfaceC25123zm1) {
        synchronized (this.c) {
            try {
                Set linkedHashSet = this.q;
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet();
                    this.q = linkedHashSet;
                }
                linkedHashSet.add(interfaceC25123zm1);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ir.nasim.AbstractC7050Qb1
    public void r(InterfaceC25123zm1 interfaceC25123zm1) {
        synchronized (this.c) {
            x0(interfaceC25123zm1);
            this.i.t(interfaceC25123zm1);
            this.j.remove(interfaceC25123zm1);
            C19938rB7 c19938rB7 = C19938rB7.a;
        }
    }

    public final void y0() {
        HE0 he0A0;
        synchronized (this.c) {
            if (this.v) {
                this.v = false;
                he0A0 = a0();
            } else {
                he0A0 = null;
            }
        }
        if (he0A0 != null) {
            C9475a16.a aVar = C9475a16.b;
            he0A0.resumeWith(C9475a16.b(C19938rB7.a));
        }
    }

    public final Object z0(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objT0 = t0(new k(null), interfaceC20295rm1);
        return objT0 == AbstractC14862ic3.e() ? objT0 : C19938rB7.a;
    }

    @Override // ir.nasim.AbstractC7050Qb1
    public void m(Set set) {
    }
}
