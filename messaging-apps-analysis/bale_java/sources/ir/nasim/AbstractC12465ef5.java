package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import java.lang.reflect.Method;

/* renamed from: ir.nasim.ef5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC12465ef5 {

    /* renamed from: ir.nasim.ef5$a */
    private static final class a {
        public static final a a = new a();
        public static final Method b;
        public static final Method c;

        static {
            Method method;
            Method method2;
            Method[] methods = Throwable.class.getMethods();
            AbstractC13042fc3.f(methods);
            int length = methods.length;
            int i = 0;
            int i2 = 0;
            while (true) {
                method = null;
                if (i2 >= length) {
                    method2 = null;
                    break;
                }
                method2 = methods[i2];
                if (AbstractC13042fc3.d(method2.getName(), "addSuppressed")) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    AbstractC13042fc3.h(parameterTypes, "getParameterTypes(...)");
                    if (AbstractC13042fc3.d(AbstractC10242bK.O0(parameterTypes), Throwable.class)) {
                        break;
                    }
                }
                i2++;
            }
            b = method2;
            int length2 = methods.length;
            while (true) {
                if (i >= length2) {
                    break;
                }
                Method method3 = methods[i];
                if (AbstractC13042fc3.d(method3.getName(), "getSuppressed")) {
                    method = method3;
                    break;
                }
                i++;
            }
            c = method;
        }

        private a() {
        }
    }

    public void a(Throwable th, Throwable th2) {
        AbstractC13042fc3.i(th, ParameterNames.CAUSE);
        AbstractC13042fc3.i(th2, "exception");
        Method method = a.b;
        if (method != null) {
            method.invoke(th, th2);
        }
    }

    public AbstractC17026mG5 b() {
        return new C6110Mf2();
    }
}
