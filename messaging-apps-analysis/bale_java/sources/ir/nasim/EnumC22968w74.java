package ir.nasim;

import android.gov.nist.javax.sip.header.SIPHeaderNames;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.w74, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC22968w74 {
    public static final EnumC22968w74 b = new EnumC22968w74("Voice", 0, "🎙️");
    public static final EnumC22968w74 c = new EnumC22968w74("Photo", 1, "🏞️");
    public static final EnumC22968w74 d = new EnumC22968w74("Audio", 2, "🎵");
    public static final EnumC22968w74 e = new EnumC22968w74("Video", 3, "🎞️");
    public static final EnumC22968w74 f = new EnumC22968w74("Gif", 4, "🎥");
    public static final EnumC22968w74 g = new EnumC22968w74(SIPHeaderNames.CONTACT, 5, "📒");
    public static final EnumC22968w74 h = new EnumC22968w74("Location", 6, "🌍");
    public static final EnumC22968w74 i = new EnumC22968w74("File", 7, "📂");
    public static final EnumC22968w74 j = new EnumC22968w74("Crowdfunding", 8, "💰");
    public static final EnumC22968w74 k = new EnumC22968w74("Purchase", 9, "💶");
    public static final EnumC22968w74 l = new EnumC22968w74("Gift", 10, "🎁");
    public static final EnumC22968w74 m = new EnumC22968w74("Link", 11, "🔗");
    public static final EnumC22968w74 n = new EnumC22968w74("Unknown", 12, null);
    public static final EnumC22968w74 o = new EnumC22968w74("Forward", 13, "↩️");
    public static final EnumC22968w74 p = new EnumC22968w74("Reply", 14, "↪️");
    private static final /* synthetic */ EnumC22968w74[] q;
    private static final /* synthetic */ F92 r;
    private final String a;

    static {
        EnumC22968w74[] enumC22968w74ArrA = a();
        q = enumC22968w74ArrA;
        r = G92.a(enumC22968w74ArrA);
    }

    private EnumC22968w74(String str, int i2, String str2) {
        this.a = str2;
    }

    private static final /* synthetic */ EnumC22968w74[] a() {
        return new EnumC22968w74[]{b, c, d, e, f, g, h, i, j, k, l, m, n, o, p};
    }

    public static EnumC22968w74 valueOf(String str) {
        return (EnumC22968w74) Enum.valueOf(EnumC22968w74.class, str);
    }

    public static EnumC22968w74[] values() {
        return (EnumC22968w74[]) q.clone();
    }

    public final String j() {
        return this.a;
    }
}
