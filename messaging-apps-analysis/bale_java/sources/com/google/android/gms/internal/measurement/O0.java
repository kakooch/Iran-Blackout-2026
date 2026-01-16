package com.google.android.gms.internal.measurement;

import ir.nasim.AbstractC20342rq8;
import java.io.IOException;

/* loaded from: classes3.dex */
public abstract class O0 extends AbstractC20342rq8 {
    private final P0 a;
    protected P0 b;

    protected O0(P0 p0) {
        this.a = p0;
        if (p0.u()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.b = p0.i();
    }

    private static void i(Object obj, Object obj2) {
        l1.a().b(obj.getClass()).k(obj, obj2);
    }

    @Override // ir.nasim.AbstractC20342rq8
    public final /* bridge */ /* synthetic */ AbstractC20342rq8 f(byte[] bArr, int i, int i2) throws zzkp {
        l(bArr, 0, i2, H0.c);
        return this;
    }

    @Override // ir.nasim.AbstractC20342rq8
    public final /* bridge */ /* synthetic */ AbstractC20342rq8 h(byte[] bArr, int i, int i2, H0 h0) throws zzkp {
        l(bArr, 0, i2, h0);
        return this;
    }

    public final O0 k(P0 p0) {
        if (!this.a.equals(p0)) {
            if (!this.b.u()) {
                p();
            }
            i(this.b, p0);
        }
        return this;
    }

    public final O0 l(byte[] bArr, int i, int i2, H0 h0) throws zzkp {
        if (!this.b.u()) {
            p();
        }
        try {
            l1.a().b(this.b.getClass()).n(this.b, bArr, 0, i2, new C2142r0(h0));
            return this;
        } catch (zzkp e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzkp.f();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002e, code lost:
    
        if (r3 != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.measurement.P0 m() {
        /*
            r5 = this;
            com.google.android.gms.internal.measurement.P0 r0 = r5.S()
            r1 = 1
            r2 = 0
            java.lang.Object r3 = r0.z(r1, r2, r2)
            java.lang.Byte r3 = (java.lang.Byte) r3
            byte r3 = r3.byteValue()
            if (r3 != r1) goto L13
            goto L30
        L13:
            if (r3 == 0) goto L31
            com.google.android.gms.internal.measurement.l1 r3 = com.google.android.gms.internal.measurement.l1.a()
            java.lang.Class r4 = r0.getClass()
            com.google.android.gms.internal.measurement.o1 r3 = r3.b(r4)
            boolean r3 = r3.a(r0)
            if (r1 == r3) goto L29
            r1 = r2
            goto L2a
        L29:
            r1 = r0
        L2a:
            r4 = 2
            r0.z(r4, r1, r2)
            if (r3 == 0) goto L31
        L30:
            return r0
        L31:
            com.google.android.gms.internal.measurement.zzmn r1 = new com.google.android.gms.internal.measurement.zzmn
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.O0.m():com.google.android.gms.internal.measurement.P0");
    }

    @Override // ir.nasim.Pr8
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public P0 S() {
        if (!this.b.u()) {
            return this.b;
        }
        this.b.q();
        return this.b;
    }

    protected final void o() {
        if (this.b.u()) {
            return;
        }
        p();
    }

    protected void p() {
        P0 p0I = this.a.i();
        i(p0I, this.b);
        this.b = p0I;
    }

    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public final O0 clone() {
        O0 o0 = (O0) this.a.z(5, null, null);
        o0.b = S();
        return o0;
    }
}
