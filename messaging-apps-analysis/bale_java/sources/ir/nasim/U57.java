package ir.nasim;

/* loaded from: classes7.dex */
public abstract class U57 extends AbstractC12724f57 {
    public int b;
    public boolean c;
    public boolean d;
    public int e;
    public Z57 f;
    public int g;
    public long h;
    public long i;
    public int j;

    public static U57 d(T1 t1, int i, boolean z) {
        U57 c7533Sc7 = i != -1667711039 ? i != -1495959709 ? null : new C7533Sc7() : new C7770Tc7();
        if (c7533Sc7 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in MessageReplyHeader", Integer.valueOf(i)));
        }
        if (c7533Sc7 != null) {
            c7533Sc7.b(t1, z);
        }
        return c7533Sc7;
    }
}
