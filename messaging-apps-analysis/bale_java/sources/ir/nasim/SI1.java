package ir.nasim;

import ir.nasim.InterfaceC15194jA0;

/* loaded from: classes8.dex */
public abstract class SI1 {
    private static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        if (i == 1 || i == 2) {
            objArr[0] = "companionObject";
        } else if (i != 3) {
            objArr[0] = "propertyDescriptor";
        } else {
            objArr[0] = "memberDescriptor";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/DescriptorsJvmAbiUtil";
        if (i == 1) {
            objArr[2] = "isClassCompanionObjectWithBackingFieldsInOuter";
        } else if (i == 2) {
            objArr[2] = "isMappedIntrinsicCompanionObject";
        } else if (i != 3) {
            objArr[2] = "isPropertyWithBackingFieldInOuterClass";
        } else {
            objArr[2] = "hasJvmFieldAnnotation";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static boolean b(InterfaceC15194jA0 interfaceC15194jA0) {
        InterfaceC25104zk2 interfaceC25104zk2V0;
        if (interfaceC15194jA0 == null) {
            a(3);
        }
        if ((interfaceC15194jA0 instanceof InterfaceC20989sw5) && (interfaceC25104zk2V0 = ((InterfaceC20989sw5) interfaceC15194jA0).v0()) != null && interfaceC25104zk2V0.getAnnotations().M1(C23341wl3.b)) {
            return true;
        }
        return interfaceC15194jA0.getAnnotations().M1(C23341wl3.b);
    }

    public static boolean c(InterfaceC12795fB1 interfaceC12795fB1) {
        if (interfaceC12795fB1 == null) {
            a(1);
        }
        return OI1.x(interfaceC12795fB1) && OI1.w(interfaceC12795fB1.b()) && !d((InterfaceC21331tU0) interfaceC12795fB1);
    }

    public static boolean d(InterfaceC21331tU0 interfaceC21331tU0) {
        if (interfaceC21331tU0 == null) {
            a(2);
        }
        return AbstractC14488i01.a(C13895h01.a, interfaceC21331tU0);
    }

    public static boolean e(InterfaceC20989sw5 interfaceC20989sw5) {
        if (interfaceC20989sw5 == null) {
            a(0);
        }
        if (interfaceC20989sw5.f() == InterfaceC15194jA0.a.FAKE_OVERRIDE) {
            return false;
        }
        if (c(interfaceC20989sw5.b())) {
            return true;
        }
        return OI1.x(interfaceC20989sw5.b()) && b(interfaceC20989sw5);
    }
}
