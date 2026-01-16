package ir.nasim;

/* loaded from: classes7.dex */
public abstract class B57 extends AbstractC12724f57 {
    public int b;
    public double c;
    public double d;
    public int e;

    public static B57 d(T1 t1, int i, boolean z) {
        B57 x87 = i != -457104426 ? i != 1210199983 ? null : new X87() : new Y87();
        if (x87 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in InputGeoPoint", Integer.valueOf(i)));
        }
        if (x87 != null) {
            x87.b(t1, z);
        }
        return x87;
    }
}
