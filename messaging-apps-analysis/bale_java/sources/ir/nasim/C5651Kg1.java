package ir.nasim;

/* renamed from: ir.nasim.Kg1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5651Kg1 {
    private final EnumC5885Lg1 a;
    private final String b;
    private final String c;

    public C5651Kg1(EnumC5885Lg1 enumC5885Lg1, String str, String str2) {
        AbstractC13042fc3.i(enumC5885Lg1, "recordType");
        AbstractC13042fc3.i(str, "recordData");
        AbstractC13042fc3.i(str2, "recordTitle");
        this.a = enumC5885Lg1;
        this.b = str;
        this.c = str2;
    }

    public final String a() {
        return this.b;
    }

    public final String b() {
        return this.c;
    }

    public final EnumC5885Lg1 c() {
        return this.a;
    }
}
