package ir.nasim;

/* loaded from: classes8.dex */
public abstract class OG1 extends RI1 {
    private final GY7 a;

    public OG1(GY7 gy7) {
        AbstractC13042fc3.i(gy7, "delegate");
        this.a = gy7;
    }

    @Override // ir.nasim.RI1
    public GY7 b() {
        return this.a;
    }

    @Override // ir.nasim.RI1
    public String c() {
        return b().b();
    }

    @Override // ir.nasim.RI1
    public RI1 f() {
        RI1 ri1J = QI1.j(b().d());
        AbstractC13042fc3.h(ri1J, "toDescriptorVisibility(delegate.normalize())");
        return ri1J;
    }
}
