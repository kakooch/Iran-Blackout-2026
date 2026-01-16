package ir.nasim;

import com.google.android.exoplayer2.source.ShuffleOrder;

/* loaded from: classes5.dex */
public final class D16 implements ShuffleOrder {
    private final int a;

    public D16(int i) {
        this.a = i;
    }

    @Override // com.google.android.exoplayer2.source.ShuffleOrder
    public ShuffleOrder a(int i, int i2) {
        return new D16((this.a - i2) + i);
    }

    @Override // com.google.android.exoplayer2.source.ShuffleOrder
    public int b(int i) {
        int i2 = i + 1;
        if (i2 < this.a) {
            return i2;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.source.ShuffleOrder
    public int c(int i) {
        int i2 = i - 1;
        if (i2 >= 0) {
            return i2;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.source.ShuffleOrder
    public int d() {
        return this.a > 0 ? 0 : -1;
    }

    @Override // com.google.android.exoplayer2.source.ShuffleOrder
    public ShuffleOrder e() {
        return new D16(0);
    }

    @Override // com.google.android.exoplayer2.source.ShuffleOrder
    public int f() {
        int i = this.a;
        if (i > 0) {
            return i - 1;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.source.ShuffleOrder
    public ShuffleOrder g(int i, int i2) {
        return new D16(this.a + i2);
    }

    @Override // com.google.android.exoplayer2.source.ShuffleOrder
    public int getLength() {
        return this.a;
    }
}
