package ir.nasim;

/* renamed from: ir.nasim.rG1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C19977rG1 {
    private IG3 a = new IG3(false, false, false, false, false, 31, null);
    private C23718xP b = new C23718xP(null, false, false, 7, null);
    private C23060wH3 c = new C23060wH3(false, null, null, null, 15, null);
    private FV7 d;
    private C23060wH3 e;
    private FV7 f;
    private boolean g;

    /* JADX WARN: Multi-variable type inference failed */
    public C19977rG1() {
        String str = null;
        this.d = new FV7(null, false, null, str, null, null, null, 127, null);
        EnumC4444Fd6 enumC4444Fd6 = EnumC4444Fd6.j;
        this.e = new C23060wH3(true, null, null, enumC4444Fd6.a(), 6, null);
        Object[] objArr = 0 == true ? 1 : 0;
        Object[] objArr2 = 0 == true ? 1 : 0;
        Object[] objArr3 = 0 == true ? 1 : 0;
        this.f = new FV7(enumC4444Fd6.j(), false, str, objArr2, objArr, objArr3, null, 126, null);
    }

    public final IG3 a() {
        return this.a;
    }

    public final C23718xP b() {
        return this.b;
    }

    public final C23060wH3 c() {
        return this.e;
    }

    public final FV7 d() {
        return this.f;
    }

    public final C23060wH3 e() {
        return this.c;
    }

    public final FV7 f() {
        return this.d;
    }

    public final boolean g() {
        return this.g;
    }

    public final void h(IG3 ig3) {
        AbstractC13042fc3.i(ig3, "<set-?>");
        this.a = ig3;
    }

    public final void i(C23718xP c23718xP) {
        AbstractC13042fc3.i(c23718xP, "<set-?>");
        this.b = c23718xP;
    }

    public final void j(C23060wH3 c23060wH3) {
        AbstractC13042fc3.i(c23060wH3, "<set-?>");
        this.e = c23060wH3;
    }

    public final void k(FV7 fv7) {
        AbstractC13042fc3.i(fv7, "<set-?>");
        this.f = fv7;
    }

    public final void l(C23060wH3 c23060wH3) {
        AbstractC13042fc3.i(c23060wH3, "<set-?>");
        this.c = c23060wH3;
    }

    public final void m(FV7 fv7) {
        AbstractC13042fc3.i(fv7, "<set-?>");
        this.d = fv7;
    }
}
