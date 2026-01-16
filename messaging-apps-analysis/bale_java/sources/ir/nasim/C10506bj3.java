package ir.nasim;

import ir.nasim.EY7;

/* renamed from: ir.nasim.bj3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C10506bj3 extends GY7 {
    public static final C10506bj3 c = new C10506bj3();

    private C10506bj3() {
        super("protected_and_package", true);
    }

    @Override // ir.nasim.GY7
    public Integer a(GY7 gy7) {
        AbstractC13042fc3.i(gy7, "visibility");
        if (AbstractC13042fc3.d(this, gy7)) {
            return 0;
        }
        if (gy7 == EY7.b.c) {
            return null;
        }
        return Integer.valueOf(EY7.a.b(gy7) ? 1 : -1);
    }

    @Override // ir.nasim.GY7
    public String b() {
        return "protected/*protected and package*/";
    }

    @Override // ir.nasim.GY7
    public GY7 d() {
        return EY7.g.c;
    }
}
