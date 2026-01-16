package ir.nasim;

/* loaded from: classes5.dex */
public class VS2 implements CT1 {
    private CT1 a;
    private final byte[] b;
    private final byte[] c;
    private final byte[] d;

    /* JADX WARN: Removed duplicated region for block: B:14:0x0049 A[LOOP:0: B:12:0x0044->B:14:0x0049, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public VS2(byte[] r6, ir.nasim.CT1 r7) {
        /*
            r5 = this;
            r5.<init>()
            r5.a = r7
            int r0 = r7.b()
            byte[] r1 = new byte[r0]
            int r2 = r6.length
            int r3 = r7.b()
            r4 = 0
            if (r2 <= r3) goto L1e
            r7.reset()
            int r0 = r6.length
            r7.c(r6, r4, r0)
            r7.a(r1, r4)
            goto L31
        L1e:
            int r2 = r6.length
            int r3 = r7.b()
            if (r2 >= r3) goto L32
            int r2 = r6.length
            ir.nasim.AbstractC8107Uo0.i(r1, r4, r6, r4, r2)
            int r6 = r6.length
        L2a:
            if (r6 >= r0) goto L31
            r1[r6] = r4
            int r6 = r6 + 1
            goto L2a
        L31:
            r6 = r1
        L32:
            r5.b = r6
            int r6 = r7.b()
            byte[] r6 = new byte[r6]
            r5.c = r6
            int r6 = r7.b()
            byte[] r6 = new byte[r6]
            r5.d = r6
        L44:
            byte[] r6 = r5.c
            int r7 = r6.length
            if (r4 >= r7) goto L5e
            byte[] r7 = r5.b
            r0 = r7[r4]
            r0 = r0 ^ 92
            byte r0 = (byte) r0
            r6[r4] = r0
            byte[] r6 = r5.d
            r7 = r7[r4]
            r7 = r7 ^ 54
            byte r7 = (byte) r7
            r6[r4] = r7
            int r4 = r4 + 1
            goto L44
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.VS2.<init>(byte[], ir.nasim.CT1):void");
    }

    @Override // ir.nasim.CT1
    public void a(byte[] bArr, int i) {
        int iB = this.a.b();
        byte[] bArr2 = new byte[iB];
        this.a.a(bArr2, 0);
        this.a.reset();
        CT1 ct1 = this.a;
        byte[] bArr3 = this.c;
        ct1.c(bArr3, 0, bArr3.length);
        this.a.c(bArr2, 0, iB);
        this.a.a(bArr, i);
        reset();
    }

    @Override // ir.nasim.CT1
    public int b() {
        return this.a.b();
    }

    @Override // ir.nasim.CT1
    public void c(byte[] bArr, int i, int i2) {
        this.a.c(bArr, i, i2);
    }

    @Override // ir.nasim.CT1
    public void reset() {
        this.a.reset();
        CT1 ct1 = this.a;
        byte[] bArr = this.d;
        ct1.c(bArr, 0, bArr.length);
    }
}
