package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.iW4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C14807iW4 extends B0 {
    private final C9761aW4 a = new C9761aW4();
    private C22997wA3 b = new C22997wA3();

    @Override // ir.nasim.B0, ir.nasim.InterfaceC15498jh0
    public void c(Z73 z73) {
        CharSequence charSequenceD = this.b.d();
        if (charSequenceD.length() > 0) {
            z73.i(charSequenceD.toString(), this.a);
        }
    }

    @Override // ir.nasim.InterfaceC15498jh0
    public AbstractC11868dh0 d(NW4 nw4) {
        return !nw4.c() ? AbstractC11868dh0.b(nw4.getIndex()) : AbstractC11868dh0.c();
    }

    @Override // ir.nasim.B0, ir.nasim.InterfaceC15498jh0
    public boolean e() {
        return true;
    }

    @Override // ir.nasim.InterfaceC15498jh0
    public AbstractC10483bh0 f() {
        return this.a;
    }

    @Override // ir.nasim.B0, ir.nasim.InterfaceC15498jh0
    public void g(CharSequence charSequence) {
        this.b.f(charSequence);
    }

    @Override // ir.nasim.B0, ir.nasim.InterfaceC15498jh0
    public void h() {
        if (this.b.d().length() == 0) {
            this.a.l();
        }
    }

    public CharSequence i() {
        return this.b.d();
    }

    public List j() {
        return this.b.c();
    }
}
