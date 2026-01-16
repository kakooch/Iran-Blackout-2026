package ir.nasim;

/* renamed from: ir.nasim.mi5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C17286mi5 extends AbstractC24641yx5 {
    private long a;

    public C17286mi5(C9207Yy1 c9207Yy1) {
        super(c9207Yy1);
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected byte d() {
        return (byte) 2;
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected void e(C9207Yy1 c9207Yy1) {
        this.a = c9207Yy1.e();
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected void f(C12658ez1 c12658ez1) {
        c12658ez1.i(this.a);
    }

    public String toString() {
        return "Pong{" + this.a + "}";
    }
}
