package ir.nasim;

/* renamed from: ir.nasim.Fl2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4512Fl2 implements InterfaceC18505om2 {
    private final String a;
    private final int b;
    public final String c;
    public final String d;

    public C4512Fl2(String str, int i, String str2, String str3) {
        AbstractC13042fc3.i(str, "fileName");
        AbstractC13042fc3.i(str2, "fileDescriptor");
        this.a = str;
        this.b = i;
        this.c = str2;
        this.d = str3;
    }

    @Override // ir.nasim.InterfaceC18505om2
    public String a() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC18505om2
    public int f() {
        return this.b;
    }
}
