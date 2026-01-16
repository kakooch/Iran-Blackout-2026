package ir.nasim;

/* loaded from: classes3.dex */
public class J47 implements PV0 {
    private static J47 a;

    private J47() {
    }

    public static J47 a() {
        if (a == null) {
            a = new J47();
        }
        return a;
    }

    @Override // ir.nasim.PV0
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}
