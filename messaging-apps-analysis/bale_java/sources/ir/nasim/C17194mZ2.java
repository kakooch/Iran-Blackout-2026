package ir.nasim;

import ir.nasim.InterfaceC13701gg4;

/* renamed from: ir.nasim.mZ2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C17194mZ2 implements InterfaceC13701gg4 {
    public static final C23097wL4 b = C23097wL4.f("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);
    private final C13110fg4 a;

    /* renamed from: ir.nasim.mZ2$a */
    public static class a implements InterfaceC14292hg4 {
        private final C13110fg4 a = new C13110fg4(500);

        @Override // ir.nasim.InterfaceC14292hg4
        public InterfaceC13701gg4 d(C23932xl4 c23932xl4) {
            return new C17194mZ2(this.a);
        }
    }

    public C17194mZ2(C13110fg4 c13110fg4) {
        this.a = c13110fg4;
    }

    @Override // ir.nasim.InterfaceC13701gg4
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC13701gg4.a b(YI2 yi2, int i, int i2, HL4 hl4) {
        C13110fg4 c13110fg4 = this.a;
        if (c13110fg4 != null) {
            YI2 yi22 = (YI2) c13110fg4.a(yi2, 0, 0);
            if (yi22 == null) {
                this.a.b(yi2, 0, 0, yi2);
            } else {
                yi2 = yi22;
            }
        }
        return new InterfaceC13701gg4.a(yi2, new C20149rZ2(yi2, ((Integer) hl4.c(b)).intValue()));
    }

    @Override // ir.nasim.InterfaceC13701gg4
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(YI2 yi2) {
        return true;
    }
}
