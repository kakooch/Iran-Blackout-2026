package ir.nasim;

import ir.nasim.C9475a16;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public abstract class UG3 {
    private static final AbstractC6535Nx5 a;

    static final class a extends AbstractC8614Ws3 implements SA2 {
        public static final a e = new a();

        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC18633oz3 invoke() {
            throw new IllegalStateException("CompositionLocal LocalLifecycleOwner not present".toString());
        }
    }

    static {
        Object objB;
        AbstractC6535Nx5 abstractC6535Nx5;
        try {
            C9475a16.a aVar = C9475a16.b;
            ClassLoader classLoader = InterfaceC18633oz3.class.getClassLoader();
            AbstractC13042fc3.f(classLoader);
            Method method = classLoader.loadClass("androidx.compose.ui.platform.AndroidCompositionLocals_androidKt").getMethod("getLocalLifecycleOwner", null);
            Annotation[] annotations = method.getAnnotations();
            int length = annotations.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    Object objInvoke = method.invoke(null, null);
                    if (objInvoke instanceof AbstractC6535Nx5) {
                        abstractC6535Nx5 = (AbstractC6535Nx5) objInvoke;
                    }
                } else if (annotations[i] instanceof InterfaceC14067hI1) {
                    break;
                } else {
                    i++;
                }
            }
            abstractC6535Nx5 = null;
            objB = C9475a16.b(abstractC6535Nx5);
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        AbstractC6535Nx5 abstractC6535Nx5F = (AbstractC6535Nx5) (C9475a16.g(objB) ? null : objB);
        if (abstractC6535Nx5F == null) {
            abstractC6535Nx5F = AbstractC11024cc1.f(a.e);
        }
        a = abstractC6535Nx5F;
    }

    public static final AbstractC6535Nx5 a() {
        return a;
    }
}
