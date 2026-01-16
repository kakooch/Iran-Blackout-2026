package ir.nasim;

/* renamed from: ir.nasim.Zt7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C9402Zt7 {
    public final EnumC9168Yt7 a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return EnumC9168Yt7.valueOf(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public final String b(EnumC9168Yt7 enumC9168Yt7) {
        if (enumC9168Yt7 != null) {
            return enumC9168Yt7.name();
        }
        return null;
    }
}
