package ir.nasim;

/* loaded from: classes8.dex */
public class OB3 extends B0 {
    private final NB3 a = new NB3();
    private int b;
    private boolean c;

    public OB3(int i) {
        this.b = i;
    }

    @Override // ir.nasim.B0, ir.nasim.InterfaceC15498jh0
    public boolean a(AbstractC10483bh0 abstractC10483bh0) {
        if (!this.c) {
            return true;
        }
        AbstractC10483bh0 abstractC10483bh0F = this.a.f();
        if (!(abstractC10483bh0F instanceof AbstractC24186yB3)) {
            return true;
        }
        ((AbstractC24186yB3) abstractC10483bh0F).o(false);
        return true;
    }

    @Override // ir.nasim.B0, ir.nasim.InterfaceC15498jh0
    public boolean b() {
        return true;
    }

    @Override // ir.nasim.InterfaceC15498jh0
    public AbstractC11868dh0 d(NW4 nw4) {
        if (!nw4.c()) {
            return nw4.a() >= this.b ? AbstractC11868dh0.a(nw4.b() + this.b) : AbstractC11868dh0.c();
        }
        if (this.a.c() == null) {
            return AbstractC11868dh0.c();
        }
        AbstractC10483bh0 abstractC10483bh0F = nw4.f().f();
        this.c = (abstractC10483bh0F instanceof C9761aW4) || (abstractC10483bh0F instanceof NB3);
        return AbstractC11868dh0.b(nw4.e());
    }

    @Override // ir.nasim.InterfaceC15498jh0
    public AbstractC10483bh0 f() {
        return this.a;
    }
}
