package ir.nasim;

/* renamed from: ir.nasim.ux5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C22275ux5 implements InterfaceC20931sq6 {
    private final C8575Wo0 a;
    private final C6691Oo3 b;

    private C22275ux5(C6691Oo3 c6691Oo3, C8575Wo0 c8575Wo0) {
        this.b = c6691Oo3;
        this.a = c8575Wo0;
    }

    public static C22275ux5 b(C6691Oo3 c6691Oo3) {
        return new C22275ux5(c6691Oo3, AbstractC10893cN7.b(c6691Oo3.X()));
    }

    public static C22275ux5 c(C6691Oo3 c6691Oo3) {
        return new C22275ux5(c6691Oo3, AbstractC10893cN7.h(c6691Oo3.X()));
    }

    @Override // ir.nasim.InterfaceC20931sq6
    public C8575Wo0 a() {
        return this.a;
    }

    public C6691Oo3 d() {
        return this.b;
    }
}
