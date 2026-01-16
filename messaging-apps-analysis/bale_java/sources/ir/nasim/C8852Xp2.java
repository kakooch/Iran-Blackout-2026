package ir.nasim;

import java.util.Arrays;

/* renamed from: ir.nasim.Xp2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C8852Xp2 extends AbstractC22207uq5 {
    private float[] a;
    private int b;

    public C8852Xp2(float[] fArr) {
        AbstractC13042fc3.i(fArr, "bufferWithData");
        this.a = fArr;
        this.b = fArr.length;
        b(10);
    }

    @Override // ir.nasim.AbstractC22207uq5
    public void b(int i) {
        float[] fArr = this.a;
        if (fArr.length < i) {
            float[] fArrCopyOf = Arrays.copyOf(fArr, AbstractC23053wG5.e(i, fArr.length * 2));
            AbstractC13042fc3.h(fArrCopyOf, "copyOf(...)");
            this.a = fArrCopyOf;
        }
    }

    @Override // ir.nasim.AbstractC22207uq5
    public int d() {
        return this.b;
    }

    public final void e(float f) {
        AbstractC22207uq5.c(this, 0, 1, null);
        float[] fArr = this.a;
        int iD = d();
        this.b = iD + 1;
        fArr[iD] = f;
    }

    @Override // ir.nasim.AbstractC22207uq5
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public float[] a() {
        float[] fArrCopyOf = Arrays.copyOf(this.a, d());
        AbstractC13042fc3.h(fArrCopyOf, "copyOf(...)");
        return fArrCopyOf;
    }
}
