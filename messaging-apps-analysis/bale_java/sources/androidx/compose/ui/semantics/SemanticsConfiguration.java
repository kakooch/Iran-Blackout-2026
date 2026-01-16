package androidx.compose.ui.semantics;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC22068uc6;
import ir.nasim.C11322co6;
import ir.nasim.C20450s2;
import ir.nasim.C7386Rm4;
import ir.nasim.InterfaceC11943do6;
import ir.nasim.InterfaceC17915nm3;
import ir.nasim.InterfaceC18751pB2;
import ir.nasim.SA2;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public final class SemanticsConfiguration implements InterfaceC11943do6, Iterable, InterfaceC17915nm3 {
    private final C7386Rm4 a = AbstractC22068uc6.b();
    private Map b;
    private boolean c;
    private boolean d;

    public final C7386Rm4 A() {
        return this.a;
    }

    public final boolean B() {
        return this.d;
    }

    public final boolean C() {
        return this.c;
    }

    public final void E(SemanticsConfiguration semanticsConfiguration) {
        C7386Rm4 c7386Rm4 = semanticsConfiguration.a;
        Object[] objArr = c7386Rm4.b;
        Object[] objArr2 = c7386Rm4.c;
        long[] jArr = c7386Rm4.a;
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
                        Object obj = objArr[i4];
                        Object obj2 = objArr2[i4];
                        C11322co6 c11322co6 = (C11322co6) obj;
                        Object objE = this.a.e(c11322co6);
                        AbstractC13042fc3.g(c11322co6, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsPropertyKey<kotlin.Any?>");
                        Object objC = c11322co6.c(objE, obj2);
                        if (objC != null) {
                            this.a.x(c11322co6, objC);
                        }
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

    public final void F(boolean z) {
        this.d = z;
    }

    public final void I(boolean z) {
        this.c = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SemanticsConfiguration)) {
            return false;
        }
        SemanticsConfiguration semanticsConfiguration = (SemanticsConfiguration) obj;
        return AbstractC13042fc3.d(this.a, semanticsConfiguration.a) && this.c == semanticsConfiguration.c && this.d == semanticsConfiguration.d;
    }

    @Override // ir.nasim.InterfaceC11943do6
    public void f(C11322co6 c11322co6, Object obj) {
        if (!(obj instanceof C20450s2) || !i(c11322co6)) {
            this.a.x(c11322co6, obj);
            return;
        }
        Object objE = this.a.e(c11322co6);
        AbstractC13042fc3.g(objE, "null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>");
        C20450s2 c20450s2 = (C20450s2) objE;
        C7386Rm4 c7386Rm4 = this.a;
        C20450s2 c20450s22 = (C20450s2) obj;
        String strB = c20450s22.b();
        if (strB == null) {
            strB = c20450s2.b();
        }
        InterfaceC18751pB2 interfaceC18751pB2A = c20450s22.a();
        if (interfaceC18751pB2A == null) {
            interfaceC18751pB2A = c20450s2.a();
        }
        c7386Rm4.x(c11322co6, new C20450s2(strB, interfaceC18751pB2A));
    }

    public final void h(SemanticsConfiguration semanticsConfiguration) {
        int i;
        if (semanticsConfiguration.c) {
            this.c = true;
        }
        if (semanticsConfiguration.d) {
            this.d = true;
        }
        C7386Rm4 c7386Rm4 = semanticsConfiguration.a;
        Object[] objArr = c7386Rm4.b;
        Object[] objArr2 = c7386Rm4.c;
        long[] jArr = c7386Rm4.a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            long j = jArr[i2];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8;
                int i4 = 8 - ((~(i2 - length)) >>> 31);
                int i5 = 0;
                while (i5 < i4) {
                    if ((255 & j) < 128) {
                        int i6 = (i2 << 3) + i5;
                        Object obj = objArr[i6];
                        Object obj2 = objArr2[i6];
                        C11322co6 c11322co6 = (C11322co6) obj;
                        if (!this.a.b(c11322co6)) {
                            this.a.x(c11322co6, obj2);
                        } else if (obj2 instanceof C20450s2) {
                            Object objE = this.a.e(c11322co6);
                            AbstractC13042fc3.g(objE, "null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>");
                            C20450s2 c20450s2 = (C20450s2) objE;
                            C7386Rm4 c7386Rm42 = this.a;
                            String strB = c20450s2.b();
                            if (strB == null) {
                                strB = ((C20450s2) obj2).b();
                            }
                            String str = strB;
                            InterfaceC18751pB2 interfaceC18751pB2A = c20450s2.a();
                            if (interfaceC18751pB2A == null) {
                                interfaceC18751pB2A = ((C20450s2) obj2).a();
                            }
                            c7386Rm42.x(c11322co6, new C20450s2(str, interfaceC18751pB2A));
                        }
                        i = 8;
                    } else {
                        i = i3;
                    }
                    j >>= i;
                    i5++;
                    i3 = i;
                }
                if (i4 != i3) {
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

    public int hashCode() {
        return (((this.a.hashCode() * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d);
    }

    public final boolean i(C11322co6 c11322co6) {
        return this.a.c(c11322co6);
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        Map mapA = this.b;
        if (mapA == null) {
            mapA = this.a.a();
            this.b = mapA;
        }
        return mapA.entrySet().iterator();
    }

    public final boolean j() {
        C7386Rm4 c7386Rm4 = this.a;
        Object[] objArr = c7386Rm4.b;
        Object[] objArr2 = c7386Rm4.c;
        long[] jArr = c7386Rm4.a;
        int length = jArr.length - 2;
        if (length < 0) {
            return false;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        int i4 = (i << 3) + i3;
                        Object obj = objArr[i4];
                        Object obj2 = objArr2[i4];
                        if (((C11322co6) obj).b()) {
                            return true;
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return false;
                }
            }
            if (i == length) {
                return false;
            }
            i++;
        }
    }

    public final SemanticsConfiguration o() {
        SemanticsConfiguration semanticsConfiguration = new SemanticsConfiguration();
        semanticsConfiguration.c = this.c;
        semanticsConfiguration.d = this.d;
        semanticsConfiguration.a.s(this.a);
        return semanticsConfiguration;
    }

    public final Object t(C11322co6 c11322co6) {
        Object objE = this.a.e(c11322co6);
        if (objE != null) {
            return objE;
        }
        throw new IllegalStateException("Key not present: " + c11322co6 + " - consider getOrElse or getOrNull");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x007b A[PHI: r4
      0x007b: PHI (r4v4 java.lang.String) = (r4v3 java.lang.String), (r4v5 java.lang.String) binds: [B:12:0x0042, B:19:0x0079] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            r19 = this;
            r0 = r19
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            boolean r2 = r0.c
            java.lang.String r3 = ", "
            java.lang.String r4 = ""
            if (r2 == 0) goto L18
            r1.append(r4)
            java.lang.String r2 = "mergeDescendants=true"
            r1.append(r2)
            r4 = r3
        L18:
            boolean r2 = r0.d
            if (r2 == 0) goto L25
            r1.append(r4)
            java.lang.String r2 = "isClearingSemantics=true"
            r1.append(r2)
            r4 = r3
        L25:
            ir.nasim.Rm4 r2 = r0.a
            java.lang.Object[] r5 = r2.b
            java.lang.Object[] r6 = r2.c
            long[] r2 = r2.a
            int r7 = r2.length
            int r7 = r7 + (-2)
            if (r7 < 0) goto L80
            r8 = 0
            r9 = r8
        L34:
            r10 = r2[r9]
            long r12 = ~r10
            r14 = 7
            long r12 = r12 << r14
            long r12 = r12 & r10
            r14 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r12 = r12 & r14
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 == 0) goto L7b
            int r12 = r9 - r7
            int r12 = ~r12
            int r12 = r12 >>> 31
            r13 = 8
            int r12 = 8 - r12
            r14 = r8
        L4e:
            if (r14 >= r12) goto L79
            r15 = 255(0xff, double:1.26E-321)
            long r15 = r15 & r10
            r17 = 128(0x80, double:6.3E-322)
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 >= 0) goto L75
            int r15 = r9 << 3
            int r15 = r15 + r14
            r16 = r5[r15]
            r15 = r6[r15]
            ir.nasim.co6 r16 = (ir.nasim.C11322co6) r16
            r1.append(r4)
            java.lang.String r4 = r16.a()
            r1.append(r4)
            java.lang.String r4 = " : "
            r1.append(r4)
            r1.append(r15)
            r4 = r3
        L75:
            long r10 = r10 >> r13
            int r14 = r14 + 1
            goto L4e
        L79:
            if (r12 != r13) goto L80
        L7b:
            if (r9 == r7) goto L80
            int r9 = r9 + 1
            goto L34
        L80:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r3 = 0
            java.lang.String r3 = ir.nasim.AbstractC23931xl3.a(r0, r3)
            r2.append(r3)
            java.lang.String r3 = "{ "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = " }"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.semantics.SemanticsConfiguration.toString():java.lang.String");
    }

    public final Object v(C11322co6 c11322co6, SA2 sa2) {
        Object objE = this.a.e(c11322co6);
        return objE == null ? sa2.invoke() : objE;
    }

    public final Object x(C11322co6 c11322co6, SA2 sa2) {
        Object objE = this.a.e(c11322co6);
        return objE == null ? sa2.invoke() : objE;
    }
}
