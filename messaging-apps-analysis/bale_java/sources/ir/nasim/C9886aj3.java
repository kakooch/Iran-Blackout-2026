package ir.nasim;

import ir.nasim.EY7;

/* renamed from: ir.nasim.aj3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C9886aj3 extends GY7 {
    public static final C9886aj3 c = new C9886aj3();

    private C9886aj3() {
        super("package", false);
    }

    @Override // ir.nasim.GY7
    public Integer a(GY7 gy7) {
        AbstractC13042fc3.i(gy7, "visibility");
        if (this == gy7) {
            return 0;
        }
        return EY7.a.b(gy7) ? 1 : -1;
    }

    @Override // ir.nasim.GY7
    public String b() {
        return "public/*package*/";
    }

    @Override // ir.nasim.GY7
    public GY7 d() {
        return EY7.g.c;
    }
}
