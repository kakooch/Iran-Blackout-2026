package ir.nasim;

import java.util.Arrays;

/* loaded from: classes5.dex */
public class L44 extends AbstractC24641yx5 {
    public long[] a;

    public L44(C9207Yy1 c9207Yy1) {
        super(c9207Yy1);
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected byte d() {
        return (byte) 6;
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected void e(C9207Yy1 c9207Yy1) {
        this.a = c9207Yy1.h();
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected void f(C12658ez1 c12658ez1) {
        c12658ez1.l(this.a);
    }

    public String toString() {
        return "Ack " + Arrays.toString(this.a) + "";
    }

    public L44(long[] jArr) {
        this.a = jArr;
    }
}
