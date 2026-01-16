package ir.nasim;

import java.util.NoSuchElementException;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class CS7 {
    public static final a Companion;
    public static final CS7 b = new CS7("VP8", 0, "vp8");
    public static final CS7 c = new CS7("H264", 1, "h264");
    public static final CS7 d = new CS7("VP9", 2, "vp9");
    public static final CS7 e = new CS7("AV1", 3, "av1");
    public static final CS7 f = new CS7("H265", 4, "h265");
    private static final /* synthetic */ CS7[] g;
    private static final /* synthetic */ F92 h;
    private final String a;

    public static final class a {
        private a() {
        }

        public final CS7 a(String str) {
            AbstractC13042fc3.i(str, "codecName");
            for (CS7 cs7 : CS7.p()) {
                if (AbstractC20153rZ6.D(cs7.j(), str, true)) {
                    return cs7;
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        CS7[] cs7ArrA = a();
        g = cs7ArrA;
        h = G92.a(cs7ArrA);
        Companion = new a(null);
    }

    private CS7(String str, int i, String str2) {
        this.a = str2;
    }

    private static final /* synthetic */ CS7[] a() {
        return new CS7[]{b, c, d, e, f};
    }

    public static F92 p() {
        return h;
    }

    public static CS7 valueOf(String str) {
        return (CS7) Enum.valueOf(CS7.class, str);
    }

    public static CS7[] values() {
        return (CS7[]) g.clone();
    }

    public final String j() {
        return this.a;
    }
}
