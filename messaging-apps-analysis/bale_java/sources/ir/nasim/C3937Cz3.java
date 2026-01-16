package ir.nasim;

import ir.nasim.FT1;

/* renamed from: ir.nasim.Cz3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C3937Cz3 implements InterfaceC17740nU2 {
    public static final a b = new a(null);
    private final II3 a;

    /* renamed from: ir.nasim.Cz3$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C3937Cz3(II3 ii3) {
        this.a = ii3;
    }

    @Override // ir.nasim.InterfaceC17740nU2
    public boolean a() {
        return C13158fl2.a.b(this.a);
    }

    @Override // ir.nasim.InterfaceC17740nU2
    public boolean b(PD6 pd6) {
        FT1 ft1D = pd6.d();
        if ((ft1D instanceof FT1.a ? ((FT1.a) ft1D).a : Integer.MAX_VALUE) > 100) {
            FT1 ft1C = pd6.c();
            if ((ft1C instanceof FT1.a ? ((FT1.a) ft1C).a : Integer.MAX_VALUE) > 100) {
                return true;
            }
        }
        return false;
    }
}
