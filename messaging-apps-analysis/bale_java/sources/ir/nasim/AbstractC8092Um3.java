package ir.nasim;

import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Um3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC8092Um3 {
    public static final InterfaceC11299cm3 a(InterfaceC14961im3 interfaceC14961im3) {
        Object obj;
        InterfaceC11299cm3 interfaceC11299cm3B;
        AbstractC13042fc3.i(interfaceC14961im3, "$this$jvmErasure");
        if (interfaceC14961im3 instanceof InterfaceC11299cm3) {
            return (InterfaceC11299cm3) interfaceC14961im3;
        }
        if (!(interfaceC14961im3 instanceof InterfaceC6907Pm3)) {
            throw new C25175zr3("Cannot calculate JVM erasure for type: " + interfaceC14961im3);
        }
        List upperBounds = ((InterfaceC6907Pm3) interfaceC14961im3).getUpperBounds();
        Iterator it = upperBounds.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            InterfaceC5941Lm3 interfaceC5941Lm3 = (InterfaceC5941Lm3) next;
            if (interfaceC5941Lm3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
            }
            Object objD = ((C6673Om3) interfaceC5941Lm3).i().K0().t();
            InterfaceC21331tU0 interfaceC21331tU0 = (InterfaceC21331tU0) (objD instanceof InterfaceC21331tU0 ? objD : null);
            if (interfaceC21331tU0 != null && interfaceC21331tU0.f() != AU0.INTERFACE && interfaceC21331tU0.f() != AU0.ANNOTATION_CLASS) {
                obj = next;
                break;
            }
        }
        InterfaceC5941Lm3 interfaceC5941Lm32 = (InterfaceC5941Lm3) obj;
        if (interfaceC5941Lm32 == null) {
            interfaceC5941Lm32 = (InterfaceC5941Lm3) AbstractC15401jX0.s0(upperBounds);
        }
        return (interfaceC5941Lm32 == null || (interfaceC11299cm3B = b(interfaceC5941Lm32)) == null) ? AbstractC10882cM5.b(Object.class) : interfaceC11299cm3B;
    }

    public static final InterfaceC11299cm3 b(InterfaceC5941Lm3 interfaceC5941Lm3) {
        InterfaceC11299cm3 interfaceC11299cm3A;
        AbstractC13042fc3.i(interfaceC5941Lm3, "$this$jvmErasure");
        InterfaceC14961im3 interfaceC14961im3A = interfaceC5941Lm3.a();
        if (interfaceC14961im3A != null && (interfaceC11299cm3A = a(interfaceC14961im3A)) != null) {
            return interfaceC11299cm3A;
        }
        throw new C25175zr3("Cannot calculate JVM erasure for type: " + interfaceC5941Lm3);
    }
}
