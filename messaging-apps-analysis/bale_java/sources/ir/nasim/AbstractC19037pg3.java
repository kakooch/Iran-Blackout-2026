package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;

/* renamed from: ir.nasim.pg3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC19037pg3 extends AbstractC12465ef5 {

    /* renamed from: ir.nasim.pg3$a */
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
    public void a(Throwable th, Throwable th2) {
        AbstractC13042fc3.i(th, ParameterNames.CAUSE);
        AbstractC13042fc3.i(th2, "exception");
        if (c(19)) {
            th.addSuppressed(th2);
        } else {
            super.a(th, th2);
        }
    }
}
