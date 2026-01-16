package ir.nasim;

/* renamed from: ir.nasim.Dp2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC4080Dp2 {
    private final int a;
    private final String b;
    private final Object c;

    /* renamed from: ir.nasim.Dp2$a */
    public static class a extends AbstractC4080Dp2 {
        public a(int i, String str, Boolean bool) {
            super(i, str, bool);
        }
    }

    private AbstractC4080Dp2(int i, String str, Object obj) {
        this.a = i;
        this.b = str;
        this.c = obj;
        ID6.a().a(this);
    }

    public static a a(int i, String str, Boolean bool) {
        return new a(i, str, bool);
    }
}
