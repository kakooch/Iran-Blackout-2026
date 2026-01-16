package ir.nasim;

import android.gov.nist.core.Separators;
import java.lang.reflect.Method;

/* loaded from: classes8.dex */
public abstract class B76 {

    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(Class cls) {
            AbstractC13042fc3.h(cls, "it");
            return AbstractC21912uL5.c(cls);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(Method method) {
        StringBuilder sb = new StringBuilder();
        sb.append(method.getName());
        Class<?>[] parameterTypes = method.getParameterTypes();
        AbstractC13042fc3.h(parameterTypes, "parameterTypes");
        sb.append(AbstractC10242bK.D0(parameterTypes, "", Separators.LPAREN, Separators.RPAREN, 0, null, a.e, 24, null));
        Class<?> returnType = method.getReturnType();
        AbstractC13042fc3.h(returnType, "returnType");
        sb.append(AbstractC21912uL5.c(returnType));
        return sb.toString();
    }
}
