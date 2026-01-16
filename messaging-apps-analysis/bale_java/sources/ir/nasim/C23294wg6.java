package ir.nasim;

/* renamed from: ir.nasim.wg6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C23294wg6 implements InterfaceC15283jK {
    private final C11458d25 a;
    private final long b;
    private final EnumC19631qg6 c;
    private final EnumC7325Rf6 d;

    public C23294wg6(C11458d25 c11458d25, long j, EnumC19631qg6 enumC19631qg6, EnumC7325Rf6 enumC7325Rf6) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(enumC19631qg6, "loadMode");
        AbstractC13042fc3.i(enumC7325Rf6, "contentType");
        this.a = c11458d25;
        this.b = j;
        this.c = enumC19631qg6;
        this.d = enumC7325Rf6;
    }

    public final EnumC7325Rf6 a() {
        return this.d;
    }

    public final long b() {
        return this.b;
    }

    public final EnumC19631qg6 c() {
        return this.c;
    }

    public final C11458d25 d() {
        return this.a;
    }
}
