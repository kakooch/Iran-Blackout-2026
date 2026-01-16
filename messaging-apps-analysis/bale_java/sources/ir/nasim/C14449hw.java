package ir.nasim;

/* renamed from: ir.nasim.hw, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C14449hw extends AbstractC24063xz {
    private EnumC9412Zv a;

    public C14449hw(EnumC9412Zv enumC9412Zv) {
        this.a = enumC9412Zv;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        int iH = c19084pl0.h(1, 0);
        if (iH != 0) {
            this.a = EnumC9412Zv.p(iH);
        }
    }

    @Override // ir.nasim.AbstractC24063xz
    public int s() {
        return 25;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        EnumC9412Zv enumC9412Zv = this.a;
        if (enumC9412Zv != null) {
            c19675ql0.f(1, enumC9412Zv.j());
        }
    }

    public String toString() {
        return "struct BannedMessage{}";
    }

    public EnumC9412Zv u() {
        return this.a;
    }

    public C14449hw() {
    }
}
