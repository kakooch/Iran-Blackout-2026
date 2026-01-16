package ir.nasim;

/* renamed from: ir.nasim.h57, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC13951h57 extends AbstractC12724f57 {
    public long b;
    public long c;
    public int d;
    public int e;
    public String f;
    public int g;
    public int h;
    public long i;
    public byte[] j;
    public byte[] k;

    public static AbstractC13951h57 d(T1 t1, int i, boolean z) {
        AbstractC13951h57 c21101t67;
        switch (i) {
            case -945003370:
                c21101t67 = new C21101t67();
                break;
            case -102543275:
                c21101t67 = new C20498s67();
                break;
            case 1114908135:
                c21101t67 = new C21775u67();
                break;
            case 1431655926:
                c21101t67 = new C19889r67();
                break;
            case 1483311320:
                c21101t67 = new C19298q67();
                break;
            default:
                c21101t67 = null;
                break;
        }
        if (c21101t67 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in Audio", Integer.valueOf(i)));
        }
        if (c21101t67 != null) {
            c21101t67.b(t1, z);
        }
        return c21101t67;
    }
}
