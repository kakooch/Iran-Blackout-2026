package ir.nasim;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.List;

/* renamed from: ir.nasim.yL5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public interface InterfaceC24278yL5 extends InterfaceC5194Ih3 {

    /* renamed from: ir.nasim.yL5$a */
    public static final class a {
        public static C22502vL5 a(InterfaceC24278yL5 interfaceC24278yL5, C9424Zw2 c9424Zw2) {
            Annotation[] declaredAnnotations;
            AbstractC13042fc3.i(interfaceC24278yL5, "this");
            AbstractC13042fc3.i(c9424Zw2, "fqName");
            AnnotatedElement annotatedElementR = interfaceC24278yL5.r();
            if (annotatedElementR == null || (declaredAnnotations = annotatedElementR.getDeclaredAnnotations()) == null) {
                return null;
            }
            return AbstractC24872zL5.a(declaredAnnotations, c9424Zw2);
        }

        public static List b(InterfaceC24278yL5 interfaceC24278yL5) {
            AbstractC13042fc3.i(interfaceC24278yL5, "this");
            AnnotatedElement annotatedElementR = interfaceC24278yL5.r();
            Annotation[] declaredAnnotations = annotatedElementR == null ? null : annotatedElementR.getDeclaredAnnotations();
            return declaredAnnotations == null ? AbstractC10360bX0.m() : AbstractC24872zL5.b(declaredAnnotations);
        }

        public static boolean c(InterfaceC24278yL5 interfaceC24278yL5) {
            AbstractC13042fc3.i(interfaceC24278yL5, "this");
            return false;
        }
    }

    AnnotatedElement r();
}
