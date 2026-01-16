package ir.nasim;

/* renamed from: ir.nasim.qg3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C19628qg3 extends AbstractC19037pg3 {

    /* renamed from: ir.nasim.qg3$a */
    private static final class a {
        public static final a a = new a();
        public static final Integer b;

        static {
            Object obj;
            Integer num = null;
            try {
                obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (Throwable unused) {
            }
            Integer num2 = obj instanceof Integer ? (Integer) obj : null;
            if (num2 != null && num2.intValue() > 0) {
                num = num2;
            }
            b = num;
        }

        private a() {
        }
    }

    private final boolean c(int i) {
        Integer num = a.b;
        return num == null || num.intValue() >= i;
    }

    @Override // ir.nasim.AbstractC12465ef5
    public AbstractC17026mG5 b() {
        return c(34) ? new C23873xf5() : super.b();
    }
}
