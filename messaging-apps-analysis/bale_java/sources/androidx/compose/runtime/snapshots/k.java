package androidx.compose.runtime.snapshots;

import ir.nasim.AbstractC10222bH6;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC16176kp7;
import ir.nasim.AbstractC16775lq5;
import ir.nasim.AbstractC19601qd6;
import ir.nasim.AbstractC19810qy7;
import ir.nasim.AbstractC5138Ib1;
import ir.nasim.AbstractC5214Ij5;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC9648aK;
import ir.nasim.AbstractC9766aX0;
import ir.nasim.C12544en4;
import ir.nasim.C19938rB7;
import ir.nasim.C3348Am4;
import ir.nasim.C7386Rm4;
import ir.nasim.C7620Sm4;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC19404qI1;
import ir.nasim.InterfaceC19995rI1;
import ir.nasim.RG4;
import ir.nasim.SA2;
import ir.nasim.UA2;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;

/* loaded from: classes.dex */
public final class k {
    public static final int l = 8;
    private final UA2 a;
    private boolean c;
    private RG4 h;
    private boolean i;
    private a j;
    private final AtomicReference b = new AtomicReference(null);
    private final InterfaceC14603iB2 d = new b();
    private final UA2 e = new c();
    private final C12544en4 f = new C12544en4(new a[16], 0);
    private final Object g = new Object();
    private long k = -1;

    private static final class a {
        private final UA2 a;
        private Object b;
        private C3348Am4 c;
        private int j;
        private int d = -1;
        private final C7386Rm4 e = AbstractC19601qd6.d(null, 1, null);
        private final C7386Rm4 f = new C7386Rm4(0, 1, null);
        private final C7620Sm4 g = new C7620Sm4(0, 1, null);
        private final C12544en4 h = new C12544en4(new InterfaceC19404qI1[16], 0);
        private final InterfaceC19995rI1 i = new C0060a();
        private final C7386Rm4 k = AbstractC19601qd6.d(null, 1, null);
        private final HashMap l = new HashMap();

        /* renamed from: androidx.compose.runtime.snapshots.k$a$a, reason: collision with other inner class name */
        public static final class C0060a implements InterfaceC19995rI1 {
            C0060a() {
            }

            @Override // ir.nasim.InterfaceC19995rI1
            public void a(InterfaceC19404qI1 interfaceC19404qI1) {
                a aVar = a.this;
                aVar.j--;
            }

            @Override // ir.nasim.InterfaceC19995rI1
            public void b(InterfaceC19404qI1 interfaceC19404qI1) {
                a.this.j++;
            }
        }

        public a(UA2 ua2) {
            this.a = ua2;
        }

        private final void d(Object obj) {
            int i = this.d;
            C3348Am4 c3348Am4 = this.c;
            if (c3348Am4 == null) {
                return;
            }
            long[] jArr = c3348Am4.a;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i2 = 0;
            while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8 - ((~(i2 - length)) >>> 31);
                    for (int i4 = 0; i4 < i3; i4++) {
                        if ((255 & j) < 128) {
                            int i5 = (i2 << 3) + i4;
                            Object obj2 = c3348Am4.b[i5];
                            boolean z = c3348Am4.c[i5] != i;
                            if (z) {
                                m(obj, obj2);
                            }
                            if (z) {
                                c3348Am4.s(i5);
                            }
                        }
                        j >>= 8;
                    }
                    if (i3 != 8) {
                        return;
                    }
                }
                if (i2 == length) {
                    return;
                } else {
                    i2++;
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0089  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final void l(java.lang.Object r21, int r22, java.lang.Object r23, ir.nasim.C3348Am4 r24) {
            /*
                r20 = this;
                r0 = r20
                r1 = r21
                r2 = r22
                int r3 = r0.j
                if (r3 <= 0) goto Lb
                return
            Lb:
                r3 = -1
                r4 = r24
                int r4 = r4.q(r1, r2, r3)
                boolean r5 = r1 instanceof ir.nasim.InterfaceC19404qI1
                r6 = 2
                if (r5 == 0) goto L91
                if (r4 == r2) goto L91
                r2 = r1
                ir.nasim.qI1 r2 = (ir.nasim.InterfaceC19404qI1) r2
                ir.nasim.qI1$a r2 = r2.y()
                java.util.HashMap r5 = r0.l
                java.lang.Object r7 = r2.a()
                r5.put(r1, r7)
                ir.nasim.tG4 r2 = r2.b()
                ir.nasim.Rm4 r5 = r0.k
                ir.nasim.AbstractC19601qd6.h(r5, r1)
                java.lang.Object[] r7 = r2.b
                long[] r2 = r2.a
                int r8 = r2.length
                int r8 = r8 - r6
                if (r8 < 0) goto L8f
                r10 = 0
            L3b:
                r11 = r2[r10]
                long r13 = ~r11
                r15 = 7
                long r13 = r13 << r15
                long r13 = r13 & r11
                r15 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
                long r13 = r13 & r15
                int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
                if (r13 == 0) goto L89
                int r13 = r10 - r8
                int r13 = ~r13
                int r13 = r13 >>> 31
                r14 = 8
                int r13 = 8 - r13
                r15 = 0
            L55:
                if (r15 >= r13) goto L86
                r16 = 255(0xff, double:1.26E-321)
                long r16 = r11 & r16
                r18 = 128(0x80, double:6.3E-322)
                int r16 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
                if (r16 >= 0) goto L7f
                int r16 = r10 << 3
                int r16 = r16 + r15
                r16 = r7[r16]
                r9 = r16
                ir.nasim.iL6 r9 = (ir.nasim.InterfaceC14710iL6) r9
                boolean r3 = r9 instanceof ir.nasim.AbstractC15299jL6
                if (r3 == 0) goto L79
                r3 = r9
                ir.nasim.jL6 r3 = (ir.nasim.AbstractC15299jL6) r3
                int r14 = androidx.compose.runtime.snapshots.e.a(r6)
                r3.A(r14)
            L79:
                ir.nasim.AbstractC19601qd6.a(r5, r9, r1)
                r3 = 8
                goto L80
            L7f:
                r3 = r14
            L80:
                long r11 = r11 >> r3
                int r15 = r15 + 1
                r14 = r3
                r3 = -1
                goto L55
            L86:
                r3 = r14
                if (r13 != r3) goto L8f
            L89:
                if (r10 == r8) goto L8f
                int r10 = r10 + 1
                r3 = -1
                goto L3b
            L8f:
                r2 = -1
                goto L92
            L91:
                r2 = r3
            L92:
                if (r4 != r2) goto La9
                boolean r2 = r1 instanceof ir.nasim.AbstractC15299jL6
                if (r2 == 0) goto La2
                r2 = r1
                ir.nasim.jL6 r2 = (ir.nasim.AbstractC15299jL6) r2
                int r3 = androidx.compose.runtime.snapshots.e.a(r6)
                r2.A(r3)
            La2:
                ir.nasim.Rm4 r2 = r0.e
                r3 = r23
                ir.nasim.AbstractC19601qd6.a(r2, r1, r3)
            La9:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.k.a.l(java.lang.Object, int, java.lang.Object, ir.nasim.Am4):void");
        }

        private final void m(Object obj, Object obj2) {
            AbstractC19601qd6.g(this.e, obj2, obj);
            if (!(obj2 instanceof InterfaceC19404qI1) || AbstractC19601qd6.e(this.e, obj2)) {
                return;
            }
            AbstractC19601qd6.h(this.k, obj2);
            this.l.remove(obj2);
        }

        public final void c() {
            AbstractC19601qd6.b(this.e);
            this.f.k();
            AbstractC19601qd6.b(this.k);
            this.l.clear();
        }

        public final void e(Object obj) {
            C3348Am4 c3348Am4 = (C3348Am4) this.f.u(obj);
            if (c3348Am4 == null) {
                return;
            }
            Object[] objArr = c3348Am4.b;
            int[] iArr = c3348Am4.c;
            long[] jArr = c3348Am4.a;
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
                            int i4 = (i << 3) + i3;
                            Object obj2 = objArr[i4];
                            int i5 = iArr[i4];
                            m(obj, obj2);
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

        public final UA2 f() {
            return this.a;
        }

        public final boolean g() {
            return this.f.i();
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0044  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void h() {
            /*
                r17 = this;
                r0 = r17
                ir.nasim.Sm4 r1 = r0.g
                ir.nasim.UA2 r2 = r0.a
                java.lang.Object[] r3 = r1.b
                long[] r4 = r1.a
                int r5 = r4.length
                int r5 = r5 + (-2)
                if (r5 < 0) goto L49
                r6 = 0
                r7 = r6
            L11:
                r8 = r4[r7]
                long r10 = ~r8
                r12 = 7
                long r10 = r10 << r12
                long r10 = r10 & r8
                r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
                long r10 = r10 & r12
                int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
                if (r10 == 0) goto L44
                int r10 = r7 - r5
                int r10 = ~r10
                int r10 = r10 >>> 31
                r11 = 8
                int r10 = 8 - r10
                r12 = r6
            L2b:
                if (r12 >= r10) goto L42
                r13 = 255(0xff, double:1.26E-321)
                long r13 = r13 & r8
                r15 = 128(0x80, double:6.3E-322)
                int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
                if (r13 >= 0) goto L3e
                int r13 = r7 << 3
                int r13 = r13 + r12
                r13 = r3[r13]
                r2.invoke(r13)
            L3e:
                long r8 = r8 >> r11
                int r12 = r12 + 1
                goto L2b
            L42:
                if (r10 != r11) goto L49
            L44:
                if (r7 == r5) goto L49
                int r7 = r7 + 1
                goto L11
            L49:
                r1.m()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.k.a.h():void");
        }

        public final void i(Object obj, UA2 ua2, SA2 sa2) {
            Object obj2 = this.b;
            C3348Am4 c3348Am4 = this.c;
            int i = this.d;
            this.b = obj;
            this.c = (C3348Am4) this.f.e(obj);
            if (this.d == -1) {
                this.d = Long.hashCode(j.I().i());
            }
            InterfaceC19995rI1 interfaceC19995rI1 = this.i;
            C12544en4 c12544en4C = AbstractC10222bH6.c();
            try {
                c12544en4C.d(interfaceC19995rI1);
                g.e.g(ua2, null, sa2);
                c12544en4C.w(c12544en4C.o() - 1);
                Object obj3 = this.b;
                AbstractC13042fc3.f(obj3);
                d(obj3);
                this.b = obj2;
                this.c = c3348Am4;
                this.d = i;
            } catch (Throwable th) {
                c12544en4C.w(c12544en4C.o() - 1);
                throw th;
            }
        }

        /*  JADX ERROR: Type inference failed
            jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
            */
        public final boolean j(java.util.Set r43) {
            /*
                Method dump skipped, instructions count: 1682
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.k.a.j(java.util.Set):boolean");
        }

        public final void k(Object obj) {
            Object obj2 = this.b;
            AbstractC13042fc3.f(obj2);
            int i = this.d;
            C3348Am4 c3348Am4 = this.c;
            if (c3348Am4 == null) {
                c3348Am4 = new C3348Am4(0, 1, null);
                this.c = c3348Am4;
                this.f.x(obj2, c3348Am4);
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
            l(obj, i, obj2, c3348Am4);
        }

        public final void n(UA2 ua2) {
            long[] jArr;
            int i;
            long[] jArr2;
            int i2;
            long j;
            int i3;
            long j2;
            int i4;
            C7386Rm4 c7386Rm4 = this.f;
            long[] jArr3 = c7386Rm4.a;
            int length = jArr3.length - 2;
            if (length < 0) {
                return;
            }
            int i5 = 0;
            while (true) {
                long j3 = jArr3[i5];
                long j4 = -9187201950435737472L;
                if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8;
                    int i7 = 8 - ((~(i5 - length)) >>> 31);
                    int i8 = 0;
                    while (i8 < i7) {
                        if ((j3 & 255) < 128) {
                            int i9 = (i5 << 3) + i8;
                            Object obj = c7386Rm4.b[i9];
                            C3348Am4 c3348Am4 = (C3348Am4) c7386Rm4.c[i9];
                            Boolean bool = (Boolean) ua2.invoke(obj);
                            if (bool.booleanValue()) {
                                Object[] objArr = c3348Am4.b;
                                int[] iArr = c3348Am4.c;
                                long[] jArr4 = c3348Am4.a;
                                int length2 = jArr4.length - 2;
                                jArr2 = jArr3;
                                if (length2 >= 0) {
                                    i3 = i7;
                                    int i10 = 0;
                                    while (true) {
                                        long j5 = jArr4[i10];
                                        i2 = i5;
                                        j = j3;
                                        j2 = -9187201950435737472L;
                                        if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i11 = 8 - ((~(i10 - length2)) >>> 31);
                                            for (int i12 = 0; i12 < i11; i12++) {
                                                if ((j5 & 255) < 128) {
                                                    int i13 = (i10 << 3) + i12;
                                                    Object obj2 = objArr[i13];
                                                    int i14 = iArr[i13];
                                                    m(obj, obj2);
                                                }
                                                j5 >>= 8;
                                            }
                                            if (i11 != 8) {
                                                break;
                                            }
                                        }
                                        if (i10 == length2) {
                                            break;
                                        }
                                        i10++;
                                        i5 = i2;
                                        j3 = j;
                                    }
                                } else {
                                    i2 = i5;
                                    j = j3;
                                    i3 = i7;
                                    j2 = -9187201950435737472L;
                                }
                            } else {
                                jArr2 = jArr3;
                                i2 = i5;
                                j = j3;
                                i3 = i7;
                                j2 = j4;
                            }
                            if (bool.booleanValue()) {
                                c7386Rm4.v(i9);
                            }
                            i4 = 8;
                        } else {
                            jArr2 = jArr3;
                            i2 = i5;
                            j = j3;
                            i3 = i7;
                            j2 = j4;
                            i4 = i6;
                        }
                        j3 = j >> i4;
                        i8++;
                        i6 = i4;
                        j4 = j2;
                        jArr3 = jArr2;
                        i7 = i3;
                        i5 = i2;
                    }
                    jArr = jArr3;
                    int i15 = i5;
                    if (i7 != i6) {
                        return;
                    } else {
                        i = i15;
                    }
                } else {
                    jArr = jArr3;
                    i = i5;
                }
                if (i == length) {
                    return;
                }
                i5 = i + 1;
                jArr3 = jArr;
            }
        }

        public final void o(InterfaceC19404qI1 interfaceC19404qI1) {
            long[] jArr;
            long[] jArr2;
            int i;
            C3348Am4 c3348Am4;
            C7386Rm4 c7386Rm4 = this.f;
            int iHashCode = Long.hashCode(j.I().i());
            Object objE = this.e.e(interfaceC19404qI1);
            if (objE == null) {
                return;
            }
            if (!(objE instanceof C7620Sm4)) {
                C3348Am4 c3348Am42 = (C3348Am4) c7386Rm4.e(objE);
                if (c3348Am42 == null) {
                    c3348Am42 = new C3348Am4(0, 1, null);
                    c7386Rm4.x(objE, c3348Am42);
                    C19938rB7 c19938rB7 = C19938rB7.a;
                }
                l(interfaceC19404qI1, iHashCode, objE, c3348Am42);
                return;
            }
            C7620Sm4 c7620Sm4 = (C7620Sm4) objE;
            Object[] objArr = c7620Sm4.b;
            long[] jArr3 = c7620Sm4.a;
            int length = jArr3.length - 2;
            if (length < 0) {
                return;
            }
            int i2 = 0;
            while (true) {
                long j = jArr3[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8;
                    int i4 = 8 - ((~(i2 - length)) >>> 31);
                    int i5 = 0;
                    while (i5 < i4) {
                        if ((j & 255) < 128) {
                            Object obj = objArr[(i2 << 3) + i5];
                            C3348Am4 c3348Am43 = (C3348Am4) c7386Rm4.e(obj);
                            jArr2 = jArr3;
                            if (c3348Am43 == null) {
                                c3348Am4 = new C3348Am4(0, 1, null);
                                c7386Rm4.x(obj, c3348Am4);
                                C19938rB7 c19938rB72 = C19938rB7.a;
                            } else {
                                c3348Am4 = c3348Am43;
                            }
                            l(interfaceC19404qI1, iHashCode, obj, c3348Am4);
                            i = 8;
                        } else {
                            jArr2 = jArr3;
                            i = i3;
                        }
                        j >>= i;
                        i5++;
                        i3 = i;
                        jArr3 = jArr2;
                    }
                    jArr = jArr3;
                    if (i4 != i3) {
                        return;
                    }
                } else {
                    jArr = jArr3;
                }
                if (i2 == length) {
                    return;
                }
                i2++;
                jArr3 = jArr;
            }
        }
    }

    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        b() {
            super(2);
        }

        public final void a(Set set, g gVar) {
            k.this.j(set);
            if (k.this.n()) {
                k.this.s();
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((Set) obj, (g) obj2);
            return C19938rB7.a;
        }
    }

    static final class c extends AbstractC8614Ws3 implements UA2 {
        c() {
            super(1);
        }

        public final void a(Object obj) {
            if (k.this.i) {
                return;
            }
            Object obj2 = k.this.g;
            k kVar = k.this;
            synchronized (obj2) {
                a aVar = kVar.j;
                AbstractC13042fc3.f(aVar);
                aVar.k(obj);
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(obj);
            return C19938rB7.a;
        }
    }

    static final class d extends AbstractC8614Ws3 implements SA2 {
        d() {
            super(0);
        }

        public final void a() {
            do {
                Object obj = k.this.g;
                k kVar = k.this;
                synchronized (obj) {
                    try {
                        if (!kVar.c) {
                            kVar.c = true;
                            try {
                                C12544en4 c12544en4 = kVar.f;
                                Object[] objArr = c12544en4.a;
                                int iO = c12544en4.o();
                                for (int i = 0; i < iO; i++) {
                                    ((a) objArr[i]).h();
                                }
                                kVar.c = false;
                            } finally {
                            }
                        }
                        C19938rB7 c19938rB7 = C19938rB7.a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } while (k.this.n());
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    public k(UA2 ua2) {
        this.a = ua2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void j(Set set) {
        Object obj;
        List listR0;
        do {
            obj = this.b.get();
            if (obj == null) {
                listR0 = set;
            } else if (obj instanceof Set) {
                listR0 = AbstractC10360bX0.p(obj, set);
            } else {
                if (!(obj instanceof List)) {
                    r();
                    throw new KotlinNothingValueException();
                }
                listR0 = AbstractC15401jX0.R0((Collection) obj, AbstractC9766aX0.e(set));
            }
        } while (!AbstractC16775lq5.a(this.b, obj, listR0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean n() {
        boolean z;
        synchronized (this.g) {
            z = this.c;
        }
        if (z) {
            return false;
        }
        boolean z2 = false;
        while (true) {
            Set setQ = q();
            if (setQ == null) {
                return z2;
            }
            synchronized (this.g) {
                try {
                    C12544en4 c12544en4 = this.f;
                    Object[] objArr = c12544en4.a;
                    int iO = c12544en4.o();
                    for (int i = 0; i < iO; i++) {
                        z2 = ((a) objArr[i]).j(setQ) || z2;
                    }
                    C19938rB7 c19938rB7 = C19938rB7.a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private final a o(UA2 ua2) {
        Object obj;
        C12544en4 c12544en4 = this.f;
        Object[] objArr = c12544en4.a;
        int iO = c12544en4.o();
        int i = 0;
        while (true) {
            if (i >= iO) {
                obj = null;
                break;
            }
            obj = objArr[i];
            if (((a) obj).f() == ua2) {
                break;
            }
            i++;
        }
        a aVar = (a) obj;
        if (aVar != null) {
            return aVar;
        }
        AbstractC13042fc3.g(ua2, "null cannot be cast to non-null type kotlin.Function1<kotlin.Any, kotlin.Unit>");
        a aVar2 = new a((UA2) AbstractC19810qy7.g(ua2, 1));
        this.f.d(aVar2);
        return aVar2;
    }

    private final Set q() {
        Object obj;
        Object objSubList;
        Set set;
        do {
            obj = this.b.get();
            objSubList = null;
            if (obj == null) {
                return null;
            }
            if (obj instanceof Set) {
                set = (Set) obj;
            } else {
                if (!(obj instanceof List)) {
                    r();
                    throw new KotlinNothingValueException();
                }
                List list = (List) obj;
                Set set2 = (Set) list.get(0);
                if (list.size() == 2) {
                    objSubList = list.get(1);
                } else if (list.size() > 2) {
                    objSubList = list.subList(1, list.size());
                }
                set = set2;
            }
        } while (!AbstractC16775lq5.a(this.b, obj, objSubList));
        return set;
    }

    private final Void r() {
        AbstractC5138Ib1.t("Unexpected notification");
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s() {
        this.a.invoke(new d());
    }

    public final void k() {
        synchronized (this.g) {
            try {
                C12544en4 c12544en4 = this.f;
                Object[] objArr = c12544en4.a;
                int iO = c12544en4.o();
                for (int i = 0; i < iO; i++) {
                    ((a) objArr[i]).c();
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void l(Object obj) {
        synchronized (this.g) {
            try {
                C12544en4 c12544en4 = this.f;
                int iO = c12544en4.o();
                int i = 0;
                for (int i2 = 0; i2 < iO; i2++) {
                    ((a) c12544en4.a[i2]).e(obj);
                    if (!r5.g()) {
                        i++;
                    } else if (i > 0) {
                        Object[] objArr = c12544en4.a;
                        objArr[i2 - i] = objArr[i2];
                    }
                }
                int i3 = iO - i;
                AbstractC9648aK.v(c12544en4.a, null, i3, iO);
                c12544en4.B(i3);
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m(UA2 ua2) {
        synchronized (this.g) {
            try {
                C12544en4 c12544en4 = this.f;
                int iO = c12544en4.o();
                int i = 0;
                for (int i2 = 0; i2 < iO; i2++) {
                    ((a) c12544en4.a[i2]).n(ua2);
                    if (!r5.g()) {
                        i++;
                    } else if (i > 0) {
                        Object[] objArr = c12544en4.a;
                        objArr[i2 - i] = objArr[i2];
                    }
                }
                int i3 = iO - i;
                AbstractC9648aK.v(c12544en4.a, null, i3, iO);
                c12544en4.B(i3);
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void p(Object obj, UA2 ua2, SA2 sa2) {
        a aVarO;
        synchronized (this.g) {
            aVarO = o(ua2);
        }
        boolean z = this.i;
        a aVar = this.j;
        long j = this.k;
        if (j != -1) {
            if (!(j == AbstractC16176kp7.a())) {
                AbstractC5214Ij5.a("Detected multithreaded access to SnapshotStateObserver: previousThreadId=" + j + "), currentThread={id=" + AbstractC16176kp7.a() + ", name=" + AbstractC16176kp7.b() + "}. Note that observation on multiple threads in layout/draw is not supported. Make sure your measure/layout/draw for each Owner (AndroidComposeView) is executed on the same thread.");
            }
        }
        try {
            this.i = false;
            this.j = aVarO;
            this.k = AbstractC16176kp7.a();
            aVarO.i(obj, this.e, sa2);
        } finally {
            this.j = aVar;
            this.i = z;
            this.k = j;
        }
    }

    public final void t() {
        this.h = g.e.h(this.d);
    }

    public final void u() {
        RG4 rg4 = this.h;
        if (rg4 != null) {
            rg4.dispose();
        }
    }
}
