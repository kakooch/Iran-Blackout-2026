package ir.nasim;

/* renamed from: ir.nasim.Fw5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4614Fw5 {
    private final V6 a;
    private final String b;
    private final InterfaceC10738c7 c;

    private C4614Fw5(String str, V6 v6, InterfaceC10738c7 interfaceC10738c7) {
        this.a = v6;
        this.b = str;
        this.c = interfaceC10738c7;
    }

    public static C4614Fw5 d(V6 v6) {
        return new C4614Fw5(null, v6, null);
    }

    public C4614Fw5 a(String str) {
        return new C4614Fw5(str, this.a, this.c);
    }

    public C4614Fw5 b(InterfaceC10738c7 interfaceC10738c7) {
        return new C4614Fw5(this.b, this.a, interfaceC10738c7);
    }

    public K6 c() {
        return this.a.create();
    }

    public String e() {
        return this.b;
    }

    public InterfaceC10738c7 f() {
        return this.c;
    }
}
