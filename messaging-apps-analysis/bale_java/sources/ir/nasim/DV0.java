package ir.nasim;

/* loaded from: classes.dex */
public class DV0 {
    private static DV0 b = new DV0("1.4.0");
    private final WR7 a;

    public DV0(String str) {
        this.a = WR7.s(str);
    }

    public static DV0 a() {
        return b;
    }

    public static boolean c(WR7 wr7) {
        return a().a.a(wr7.p(), wr7.q()) >= 0;
    }

    public WR7 b() {
        return this.a;
    }

    public String d() {
        return this.a.toString();
    }
}
