package ir.nasim;

/* loaded from: classes.dex */
final class KM5 extends PH6 {
    private final PH6 a;
    private final int b;

    public KM5(PH6 ph6, int i) {
        super(null);
        this.a = ph6;
        this.b = i;
    }

    @Override // ir.nasim.PH6
    public Object a(C21850uE6 c21850uE6) {
        return new RH6(this.a.a(c21850uE6), this.b);
    }
}
