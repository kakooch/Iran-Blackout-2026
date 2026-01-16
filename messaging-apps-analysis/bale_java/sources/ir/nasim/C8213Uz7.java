package ir.nasim;

import java.util.Arrays;

/* renamed from: ir.nasim.Uz7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C8213Uz7 extends AbstractC22207uq5 {
    private byte[] a;
    private int b;

    public /* synthetic */ C8213Uz7(byte[] bArr, ED1 ed1) {
        this(bArr);
    }

    @Override // ir.nasim.AbstractC22207uq5
    public /* bridge */ /* synthetic */ Object a() {
        return C7979Tz7.f(f());
    }

    @Override // ir.nasim.AbstractC22207uq5
    public void b(int i) {
        if (C7979Tz7.B(this.a) < i) {
            byte[] bArr = this.a;
            byte[] bArrCopyOf = Arrays.copyOf(bArr, AbstractC23053wG5.e(i, C7979Tz7.B(bArr) * 2));
            AbstractC13042fc3.h(bArrCopyOf, "copyOf(...)");
            this.a = C7979Tz7.i(bArrCopyOf);
        }
    }

    @Override // ir.nasim.AbstractC22207uq5
    public int d() {
        return this.b;
    }

    public final void e(byte b) {
        AbstractC22207uq5.c(this, 0, 1, null);
        byte[] bArr = this.a;
        int iD = d();
        this.b = iD + 1;
        C7979Tz7.I(bArr, iD, b);
    }

    public byte[] f() {
        byte[] bArrCopyOf = Arrays.copyOf(this.a, d());
        AbstractC13042fc3.h(bArrCopyOf, "copyOf(...)");
        return C7979Tz7.i(bArrCopyOf);
    }

    private C8213Uz7(byte[] bArr) {
        AbstractC13042fc3.i(bArr, "bufferWithData");
        this.a = bArr;
        this.b = C7979Tz7.B(bArr);
        b(10);
    }
}
