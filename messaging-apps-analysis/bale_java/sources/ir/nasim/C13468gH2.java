package ir.nasim;

/* renamed from: ir.nasim.gH2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C13468gH2 extends D02 implements B73 {
    public C13468gH2(C11598dH2 c11598dH2) {
        super(c11598dH2);
    }

    @Override // ir.nasim.DW5
    public void a() {
        ((C11598dH2) this.a).stop();
        ((C11598dH2) this.a).k();
    }

    @Override // ir.nasim.DW5
    public Class b() {
        return C11598dH2.class;
    }

    @Override // ir.nasim.DW5
    public int f() {
        return ((C11598dH2) this.a).i();
    }

    @Override // ir.nasim.D02, ir.nasim.B73
    public void initialize() {
        ((C11598dH2) this.a).e().prepareToDraw();
    }
}
