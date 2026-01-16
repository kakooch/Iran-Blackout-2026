package ir.nasim;

import android.text.Layout;
import java.text.Bidi;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.fu3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C13249fu3 {
    private final Layout a;
    private final List b;
    private final List c;
    private final boolean[] d;
    private char[] e;
    private final int f;

    /* renamed from: ir.nasim.fu3$a */
    public static final class a {
        private final int a;
        private final int b;
        private final boolean c;

        public a(int i, int i2, boolean z) {
            this.a = i;
            this.b = i2;
            this.c = z;
        }

        public final int a() {
            return this.b;
        }

        public final int b() {
            return this.a;
        }

        public final boolean c() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b && this.c == aVar.c;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b)) * 31) + Boolean.hashCode(this.c);
        }

        public String toString() {
            return "BidiRun(start=" + this.a + ", end=" + this.b + ", isRtl=" + this.c + ')';
        }
    }

    public C13249fu3(Layout layout) {
        this.a = layout;
        ArrayList arrayList = new ArrayList();
        int length = 0;
        do {
            int iK0 = AbstractC20762sZ6.k0(this.a.getText(), '\n', length, false, 4, null);
            length = iK0 < 0 ? this.a.getText().length() : iK0 + 1;
            arrayList.add(Integer.valueOf(length));
        } while (length < this.a.getText().length());
        this.b = arrayList;
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList2.add(null);
        }
        this.c = arrayList2;
        this.d = new boolean[this.b.size()];
        this.f = this.b.size();
    }

    private final float b(int i, boolean z) {
        int i2 = AbstractC23053wG5.i(i, this.a.getLineEnd(this.a.getLineForOffset(i)));
        return z ? this.a.getPrimaryHorizontal(i2) : this.a.getSecondaryHorizontal(i2);
    }

    public static /* synthetic */ int g(C13249fu3 c13249fu3, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return c13249fu3.f(i, z);
    }

    private final int k(int i, int i2) {
        while (i > i2 && i(this.a.getText().charAt(i - 1))) {
            i--;
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.text.Bidi a(int r12) {
        /*
            r11 = this;
            boolean[] r0 = r11.d
            boolean r0 = r0[r12]
            if (r0 == 0) goto Lf
            java.util.List r0 = r11.c
            java.lang.Object r12 = r0.get(r12)
            java.text.Bidi r12 = (java.text.Bidi) r12
            return r12
        Lf:
            r0 = 0
            if (r12 != 0) goto L14
            r1 = r0
            goto L22
        L14:
            java.util.List r1 = r11.b
            int r2 = r12 + (-1)
            java.lang.Object r1 = r1.get(r2)
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
        L22:
            java.util.List r2 = r11.b
            java.lang.Object r2 = r2.get(r12)
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            int r8 = r2 - r1
            char[] r3 = r11.e
            if (r3 == 0) goto L3a
            int r4 = r3.length
            if (r4 >= r8) goto L38
            goto L3a
        L38:
            r10 = r3
            goto L3d
        L3a:
            char[] r3 = new char[r8]
            goto L38
        L3d:
            android.text.Layout r3 = r11.a
            java.lang.CharSequence r3 = r3.getText()
            android.text.TextUtils.getChars(r3, r1, r2, r10, r0)
            boolean r0 = java.text.Bidi.requiresBidi(r10, r0, r8)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L62
            boolean r9 = r11.j(r12)
            java.text.Bidi r0 = new java.text.Bidi
            r6 = 0
            r7 = 0
            r5 = 0
            r3 = r0
            r4 = r10
            r3.<init>(r4, r5, r6, r7, r8, r9)
            int r3 = r0.getRunCount()
            if (r3 != r2) goto L63
        L62:
            r0 = r1
        L63:
            java.util.List r3 = r11.c
            r3.set(r12, r0)
            boolean[] r3 = r11.d
            r3[r12] = r2
            if (r0 == 0) goto L75
            char[] r12 = r11.e
            if (r10 != r12) goto L74
            r10 = r1
            goto L75
        L74:
            r10 = r12
        L75:
            r11.e = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C13249fu3.a(int):java.text.Bidi");
    }

    public final float c(int i, boolean z, boolean z2) {
        int iK = i;
        if (!z2) {
            return b(i, z);
        }
        int iA = AbstractC10616bu3.a(this.a, iK, z2);
        int lineStart = this.a.getLineStart(iA);
        int lineEnd = this.a.getLineEnd(iA);
        if (iK != lineStart && iK != lineEnd) {
            return b(i, z);
        }
        if (iK == 0 || iK == this.a.getText().length()) {
            return b(i, z);
        }
        int iF = f(iK, z2);
        boolean zJ = j(iF);
        int iK2 = k(lineEnd, lineStart);
        int iH = h(iF);
        int i2 = lineStart - iH;
        int i3 = iK2 - iH;
        Bidi bidiA = a(iF);
        Bidi bidiCreateLineBidi = bidiA != null ? bidiA.createLineBidi(i2, i3) : null;
        boolean z3 = false;
        if (bidiCreateLineBidi == null || bidiCreateLineBidi.getRunCount() == 1) {
            boolean zIsRtlCharAt = this.a.isRtlCharAt(lineStart);
            if (z || zJ == zIsRtlCharAt) {
                zJ = !zJ;
            }
            if (iK == lineStart) {
                z3 = zJ;
            } else if (!zJ) {
                z3 = true;
            }
            Layout layout = this.a;
            return z3 ? layout.getLineLeft(iA) : layout.getLineRight(iA);
        }
        int runCount = bidiCreateLineBidi.getRunCount();
        a[] aVarArr = new a[runCount];
        for (int i4 = 0; i4 < runCount; i4++) {
            aVarArr[i4] = new a(bidiCreateLineBidi.getRunStart(i4) + lineStart, bidiCreateLineBidi.getRunLimit(i4) + lineStart, bidiCreateLineBidi.getRunLevel(i4) % 2 == 1);
        }
        int runCount2 = bidiCreateLineBidi.getRunCount();
        byte[] bArr = new byte[runCount2];
        for (int i5 = 0; i5 < runCount2; i5++) {
            bArr[i5] = (byte) bidiCreateLineBidi.getRunLevel(i5);
        }
        Bidi.reorderVisually(bArr, 0, aVarArr, 0, runCount);
        int i6 = -1;
        if (iK == lineStart) {
            int i7 = 0;
            while (true) {
                if (i7 >= runCount) {
                    break;
                }
                if (aVarArr[i7].b() == iK) {
                    i6 = i7;
                    break;
                }
                i7++;
            }
            a aVar = aVarArr[i6];
            if (z || zJ == aVar.c()) {
                zJ = !zJ;
            }
            return (i6 == 0 && zJ) ? this.a.getLineLeft(iA) : (i6 != AbstractC10242bK.l0(aVarArr) || zJ) ? zJ ? this.a.getPrimaryHorizontal(aVarArr[i6 - 1].b()) : this.a.getPrimaryHorizontal(aVarArr[i6 + 1].b()) : this.a.getLineRight(iA);
        }
        if (iK > iK2) {
            iK = k(iK, lineStart);
        }
        int i8 = 0;
        while (true) {
            if (i8 >= runCount) {
                break;
            }
            if (aVarArr[i8].a() == iK) {
                i6 = i8;
                break;
            }
            i8++;
        }
        a aVar2 = aVarArr[i6];
        if (!z && zJ != aVar2.c()) {
            zJ = !zJ;
        }
        return (i6 == 0 && zJ) ? this.a.getLineLeft(iA) : (i6 != AbstractC10242bK.l0(aVarArr) || zJ) ? zJ ? this.a.getPrimaryHorizontal(aVarArr[i6 - 1].a()) : this.a.getPrimaryHorizontal(aVarArr[i6 + 1].a()) : this.a.getLineRight(iA);
    }

    public final a[] d(int i) {
        Bidi bidiCreateLineBidi;
        int lineStart = this.a.getLineStart(i);
        int lineEnd = this.a.getLineEnd(i);
        int iG = g(this, lineStart, false, 2, null);
        int iH = h(iG);
        int i2 = lineStart - iH;
        int i3 = lineEnd - iH;
        Bidi bidiA = a(iG);
        if (bidiA == null || (bidiCreateLineBidi = bidiA.createLineBidi(i2, i3)) == null) {
            return new a[]{new a(lineStart, lineEnd, this.a.isRtlCharAt(lineStart))};
        }
        int runCount = bidiCreateLineBidi.getRunCount();
        a[] aVarArr = new a[runCount];
        for (int i4 = 0; i4 < runCount; i4++) {
            int runStart = bidiCreateLineBidi.getRunStart(i4) + lineStart;
            int runLimit = bidiCreateLineBidi.getRunLimit(i4) + lineStart;
            boolean z = true;
            if (bidiCreateLineBidi.getRunLevel(i4) % 2 != 1) {
                z = false;
            }
            aVarArr[i4] = new a(runStart, runLimit, z);
        }
        return aVarArr;
    }

    public final int e(int i) {
        return k(this.a.getLineEnd(i), this.a.getLineStart(i));
    }

    public final int f(int i, boolean z) {
        int iL = AbstractC10360bX0.l(this.b, Integer.valueOf(i), 0, 0, 6, null);
        int i2 = iL < 0 ? -(iL + 1) : iL + 1;
        if (z && i2 > 0) {
            int i3 = i2 - 1;
            if (i == ((Number) this.b.get(i3)).intValue()) {
                return i3;
            }
        }
        return i2;
    }

    public final int h(int i) {
        if (i == 0) {
            return 0;
        }
        return ((Number) this.b.get(i - 1)).intValue();
    }

    public final boolean i(char c) {
        return c == ' ' || c == '\n' || c == 5760 || (AbstractC13042fc3.k(c, 8192) >= 0 && AbstractC13042fc3.k(c, 8202) <= 0 && c != 8199) || c == 8287 || c == 12288;
    }

    public final boolean j(int i) {
        return this.a.getParagraphDirection(this.a.getLineForOffset(h(i))) == -1;
    }
}
