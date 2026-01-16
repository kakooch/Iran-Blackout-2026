package ir.nasim;

/* renamed from: ir.nasim.mH6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C17036mH6 {
    private int a;
    private int[] b = new int[16];
    private F48[] c = new F48[16];

    private final int b(Object obj, int i) {
        int i2 = this.a - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            int i5 = this.b[i4];
            if (i5 < i) {
                i3 = i4 + 1;
            } else {
                if (i5 <= i) {
                    F48 f48 = this.c[i4];
                    return obj == (f48 != null ? f48.get() : null) ? i4 : c(i4, obj, i);
                }
                i2 = i4 - 1;
            }
        }
        return -(i3 + 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001d, code lost:
    
        r4 = r4 + 1;
        r0 = r3.a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0021, code lost:
    
        if (r4 >= r0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0027, code lost:
    
        if (r3.b[r4] == r6) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002c, code lost:
    
        return -(r4 + 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002d, code lost:
    
        r2 = r3.c[r4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0031, code lost:
    
        if (r2 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0033, code lost:
    
        r2 = r2.get();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0038, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0039, code lost:
    
        if (r2 != r5) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003b, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003c, code lost:
    
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003f, code lost:
    
        r4 = r3.a;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int c(int r4, java.lang.Object r5, int r6) {
        /*
            r3 = this;
            int r0 = r4 + (-1)
        L2:
            r1 = 0
            r2 = -1
            if (r2 >= r0) goto L1d
            int[] r2 = r3.b
            r2 = r2[r0]
            if (r2 == r6) goto Ld
            goto L1d
        Ld:
            ir.nasim.F48[] r2 = r3.c
            r2 = r2[r0]
            if (r2 == 0) goto L17
            java.lang.Object r1 = r2.get()
        L17:
            if (r1 != r5) goto L1a
            return r0
        L1a:
            int r0 = r0 + (-1)
            goto L2
        L1d:
            int r4 = r4 + 1
            int r0 = r3.a
        L21:
            if (r4 >= r0) goto L3f
            int[] r2 = r3.b
            r2 = r2[r4]
            if (r2 == r6) goto L2d
        L29:
            int r4 = r4 + 1
            int r4 = -r4
            return r4
        L2d:
            ir.nasim.F48[] r2 = r3.c
            r2 = r2[r4]
            if (r2 == 0) goto L38
            java.lang.Object r2 = r2.get()
            goto L39
        L38:
            r2 = r1
        L39:
            if (r2 != r5) goto L3c
            return r4
        L3c:
            int r4 = r4 + 1
            goto L21
        L3f:
            int r4 = r3.a
            goto L29
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C17036mH6.c(int, java.lang.Object, int):int");
    }

    public final boolean a(Object obj) {
        int iB;
        int i = this.a;
        int iA = BN7.a(obj);
        if (i > 0) {
            iB = b(obj, iA);
            if (iB >= 0) {
                return false;
            }
        } else {
            iB = -1;
        }
        int i2 = -(iB + 1);
        F48[] f48Arr = this.c;
        int length = f48Arr.length;
        if (i == length) {
            int i3 = length * 2;
            F48[] f48Arr2 = new F48[i3];
            int[] iArr = new int[i3];
            int i4 = i2 + 1;
            System.arraycopy(f48Arr, i2, f48Arr2, i4, i - i2);
            System.arraycopy(this.c, 0, f48Arr2, 0, i2);
            AbstractC9648aK.j(this.b, iArr, i4, i2, i);
            AbstractC9648aK.o(this.b, iArr, 0, 0, i2, 6, null);
            this.c = f48Arr2;
            this.b = iArr;
        } else {
            int i5 = i2 + 1;
            System.arraycopy(f48Arr, i2, f48Arr, i5, i - i2);
            int[] iArr2 = this.b;
            AbstractC9648aK.j(iArr2, iArr2, i5, i2, i);
        }
        this.c[i2] = new F48(obj);
        this.b[i2] = iA;
        this.a++;
        return true;
    }

    public final int[] d() {
        return this.b;
    }

    public final int e() {
        return this.a;
    }

    public final F48[] f() {
        return this.c;
    }

    public final void g(int i) {
        this.a = i;
    }
}
