package ir.nasim;

/* renamed from: ir.nasim.u66, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21774u66 implements InterfaceC15283jK {
    private final String a;
    private final String b;
    private final long c;
    private final N38 d;
    private final String e;

    public C21774u66(String str, String str2, long j, N38 n38, String str3) {
        AbstractC13042fc3.i(str, "sourceWallet");
        AbstractC13042fc3.i(str2, "targetWallet");
        AbstractC13042fc3.i(n38, "currency");
        AbstractC13042fc3.i(str3, "regarding");
        this.a = str;
        this.b = str2;
        this.c = j;
        this.d = n38;
        this.e = str3;
    }

    public final long a() {
        return this.c;
    }

    public final N38 b() {
        return this.d;
    }

    public final String c() {
        return this.e;
    }

    public final String d() {
        return this.a;
    }

    public final String e() {
        return this.b;
    }
}
