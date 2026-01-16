package ir.nasim;

import java.util.Set;

/* renamed from: ir.nasim.ly7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC16855ly7 {
    public static final C8056Ui3 a(EnumC14043hF4 enumC14043hF4, EnumC11300cm4 enumC11300cm4, boolean z, boolean z2) {
        return (z2 && enumC14043hF4 == EnumC14043hF4.NOT_NULL) ? new C8056Ui3(enumC14043hF4, enumC11300cm4, true, z) : new C8056Ui3(enumC14043hF4, enumC11300cm4, false, z);
    }

    public static final boolean b(InterfaceC5819Ky7 interfaceC5819Ky7, InterfaceC5050Hr3 interfaceC5050Hr3) {
        AbstractC13042fc3.i(interfaceC5819Ky7, "<this>");
        AbstractC13042fc3.i(interfaceC5050Hr3, "type");
        C9424Zw2 c9424Zw2 = AbstractC24521yl3.q;
        AbstractC13042fc3.h(c9424Zw2, "ENHANCED_NULLABILITY_ANNOTATION");
        return interfaceC5819Ky7.k(interfaceC5050Hr3, c9424Zw2);
    }

    public static final EnumC14043hF4 c(Set set, EnumC14043hF4 enumC14043hF4, boolean z) {
        AbstractC13042fc3.i(set, "<this>");
        EnumC14043hF4 enumC14043hF42 = EnumC14043hF4.FORCE_FLEXIBILITY;
        return enumC14043hF4 == enumC14043hF42 ? enumC14043hF42 : (EnumC14043hF4) d(set, EnumC14043hF4.NOT_NULL, EnumC14043hF4.NULLABLE, enumC14043hF4, z);
    }

    public static final Object d(Set set, Object obj, Object obj2, Object obj3, boolean z) {
        Set setR1;
        AbstractC13042fc3.i(set, "<this>");
        AbstractC13042fc3.i(obj, "low");
        AbstractC13042fc3.i(obj2, "high");
        if (!z) {
            if (obj3 != null && (setR1 = AbstractC15401jX0.r1(AbstractC4846Gu6.m(set, obj3))) != null) {
                set = setR1;
            }
            return AbstractC15401jX0.W0(set);
        }
        Object obj4 = set.contains(obj) ? obj : set.contains(obj2) ? obj2 : null;
        if (AbstractC13042fc3.d(obj4, obj) && AbstractC13042fc3.d(obj3, obj2)) {
            return null;
        }
        return obj3 == null ? obj4 : obj3;
    }
}
