package ir.nasim;

import java.util.Arrays;

/* renamed from: ir.nasim.wo0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C23368wo0 extends AbstractC22207uq5 {
    private byte[] a;
    private int b;

    public C23368wo0(byte[] bArr) {
        AbstractC13042fc3.i(bArr, "bufferWithData");
        this.a = bArr;
        this.b = bArr.length;
        b(10);
    }

    @Override // ir.nasim.AbstractC22207uq5
    public void b(int i) {
        byte[] bArr = this.a;
        if (bArr.length < i) {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, AbstractC23053wG5.e(i, bArr.length * 2));
            AbstractC13042fc3.h(bArrCopyOf, "copyOf(...)");
            this.a = bArrCopyOf;
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
        bArr[iD] = b;
    }

    @Override // ir.nasim.AbstractC22207uq5
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public byte[] a() {
        byte[] bArrCopyOf = Arrays.copyOf(this.a, d());
        AbstractC13042fc3.h(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }
}
