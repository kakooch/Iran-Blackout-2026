package ir.nasim;

import com.google.android.exoplayer2.ParserException;

/* renamed from: ir.nasim.iH4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C14663iH4 {
    public int a;
    public int b;
    public long c;
    public long d;
    public long e;
    public long f;
    public int g;
    public int h;
    public int i;
    public final int[] j = new int[255];
    private final EW4 k = new EW4(255);

    C14663iH4() {
    }

    public boolean a(InterfaceC9845af2 interfaceC9845af2, boolean z) throws ParserException {
        b();
        this.k.O(27);
        if (!AbstractC11055cf2.b(interfaceC9845af2, this.k.e(), 0, 27, z) || this.k.H() != 1332176723) {
            return false;
        }
        int iF = this.k.F();
        this.a = iF;
        if (iF != 0) {
            if (z) {
                return false;
            }
            throw ParserException.d("unsupported bit stream revision");
        }
        this.b = this.k.F();
        this.c = this.k.t();
        this.d = this.k.v();
        this.e = this.k.v();
        this.f = this.k.v();
        int iF2 = this.k.F();
        this.g = iF2;
        this.h = iF2 + 27;
        this.k.O(iF2);
        if (!AbstractC11055cf2.b(interfaceC9845af2, this.k.e(), 0, this.g, z)) {
            return false;
        }
        for (int i = 0; i < this.g; i++) {
            this.j[i] = this.k.F();
            this.i += this.j[i];
        }
        return true;
    }

    public void b() {
        this.a = 0;
        this.b = 0;
        this.c = 0L;
        this.d = 0L;
        this.e = 0L;
        this.f = 0L;
        this.g = 0;
        this.h = 0;
        this.i = 0;
    }

    public boolean c(InterfaceC9845af2 interfaceC9845af2) {
        return d(interfaceC9845af2, -1L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
    
        if (r10 == (-1)) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0059, code lost:
    
        if (r9.getPosition() >= r10) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0060, code lost:
    
        if (r9.a(1) == (-1)) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0063, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean d(ir.nasim.InterfaceC9845af2 r9, long r10) {
        /*
            r8 = this;
            long r0 = r9.getPosition()
            long r2 = r9.g()
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
            r0 = r2
            goto L11
        L10:
            r0 = r1
        L11:
            ir.nasim.AbstractC20011rK.a(r0)
            ir.nasim.EW4 r0 = r8.k
            r3 = 4
            r0.O(r3)
        L1a:
            r4 = -1
            int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r0 == 0) goto L2b
            long r4 = r9.getPosition()
            r6 = 4
            long r4 = r4 + r6
            int r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r4 >= 0) goto L51
        L2b:
            ir.nasim.EW4 r4 = r8.k
            byte[] r4 = r4.e()
            boolean r4 = ir.nasim.AbstractC11055cf2.b(r9, r4, r1, r3, r2)
            if (r4 == 0) goto L51
            ir.nasim.EW4 r0 = r8.k
            r0.S(r1)
            ir.nasim.EW4 r0 = r8.k
            long r4 = r0.H()
            r6 = 1332176723(0x4f676753, double:6.58182753E-315)
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L4d
            r9.e()
            return r2
        L4d:
            r9.k(r2)
            goto L1a
        L51:
            if (r0 == 0) goto L5b
            long r3 = r9.getPosition()
            int r3 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r3 >= 0) goto L63
        L5b:
            int r3 = r9.a(r2)
            r4 = -1
            if (r3 == r4) goto L63
            goto L51
        L63:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C14663iH4.d(ir.nasim.af2, long):boolean");
    }
}
