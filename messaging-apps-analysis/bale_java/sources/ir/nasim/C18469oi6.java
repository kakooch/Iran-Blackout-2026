package ir.nasim;

/* renamed from: ir.nasim.oi6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C18469oi6 {
    private final C8575Wo0 a;

    private C18469oi6(C8575Wo0 c8575Wo0) {
        this.a = c8575Wo0;
    }

    public static C18469oi6 a(byte[] bArr, C19060pi6 c19060pi6) {
        if (c19060pi6 != null) {
            return new C18469oi6(C8575Wo0.a(bArr));
        }
        throw new NullPointerException("SecretKeyAccess required");
    }

    public int b() {
        return this.a.c();
    }

    public byte[] c(C19060pi6 c19060pi6) {
        if (c19060pi6 != null) {
            return this.a.d();
        }
        throw new NullPointerException("SecretKeyAccess required");
    }
}
