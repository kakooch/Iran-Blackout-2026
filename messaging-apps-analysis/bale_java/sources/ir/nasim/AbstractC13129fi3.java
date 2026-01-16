package ir.nasim;

import java.util.HashMap;
import java.util.Map;

/* renamed from: ir.nasim.fi3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC13129fi3 {
    public static final RI1 a;
    public static final RI1 b;
    public static final RI1 c;
    private static final Map d;

    /* renamed from: ir.nasim.fi3$a */
    static class a extends OG1 {
        a(GY7 gy7) {
            super(gy7);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$1";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // ir.nasim.RI1
        public boolean e(InterfaceC10239bJ5 interfaceC10239bJ5, InterfaceC16977mB1 interfaceC16977mB1, InterfaceC12795fB1 interfaceC12795fB1) {
            if (interfaceC16977mB1 == null) {
                g(0);
            }
            if (interfaceC12795fB1 == null) {
                g(1);
            }
            return AbstractC13129fi3.d(interfaceC16977mB1, interfaceC12795fB1);
        }
    }

    /* renamed from: ir.nasim.fi3$b */
    static class b extends OG1 {
        b(GY7 gy7) {
            super(gy7);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$2";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // ir.nasim.RI1
        public boolean e(InterfaceC10239bJ5 interfaceC10239bJ5, InterfaceC16977mB1 interfaceC16977mB1, InterfaceC12795fB1 interfaceC12795fB1) {
            if (interfaceC16977mB1 == null) {
                g(0);
            }
            if (interfaceC12795fB1 == null) {
                g(1);
            }
            return AbstractC13129fi3.e(interfaceC10239bJ5, interfaceC16977mB1, interfaceC12795fB1);
        }
    }

    /* renamed from: ir.nasim.fi3$c */
    static class c extends OG1 {
        c(GY7 gy7) {
            super(gy7);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$3";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // ir.nasim.RI1
        public boolean e(InterfaceC10239bJ5 interfaceC10239bJ5, InterfaceC16977mB1 interfaceC16977mB1, InterfaceC12795fB1 interfaceC12795fB1) {
            if (interfaceC16977mB1 == null) {
                g(0);
            }
            if (interfaceC12795fB1 == null) {
                g(1);
            }
            return AbstractC13129fi3.e(interfaceC10239bJ5, interfaceC16977mB1, interfaceC12795fB1);
        }
    }

    static {
        a aVar = new a(C9886aj3.c);
        a = aVar;
        b bVar = new b(C11269cj3.c);
        b = bVar;
        c cVar = new c(C10506bj3.c);
        c = cVar;
        d = new HashMap();
        f(aVar);
        f(bVar);
        f(cVar);
    }

    private static /* synthetic */ void a(int i) {
        String str = (i == 5 || i == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 5 || i == 6) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "from";
                break;
            case 2:
                objArr[0] = "first";
                break;
            case 3:
                objArr[0] = "second";
                break;
            case 4:
                objArr[0] = "visibility";
                break;
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
                break;
            default:
                objArr[0] = "what";
                break;
        }
        if (i == 5 || i == 6) {
            objArr[1] = "toDescriptorVisibility";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
        }
        if (i == 2 || i == 3) {
            objArr[2] = "areInSamePackage";
        } else if (i == 4) {
            objArr[2] = "toDescriptorVisibility";
        } else if (i != 5 && i != 6) {
            objArr[2] = "isVisibleForProtectedAndPackage";
        }
        String str2 = String.format(str, objArr);
        if (i != 5 && i != 6) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(InterfaceC12795fB1 interfaceC12795fB1, InterfaceC12795fB1 interfaceC12795fB12) {
        if (interfaceC12795fB1 == null) {
            a(2);
        }
        if (interfaceC12795fB12 == null) {
            a(3);
        }
        InterfaceC24340yS4 interfaceC24340yS4 = (InterfaceC24340yS4) OI1.r(interfaceC12795fB1, InterfaceC24340yS4.class, false);
        InterfaceC24340yS4 interfaceC24340yS42 = (InterfaceC24340yS4) OI1.r(interfaceC12795fB12, InterfaceC24340yS4.class, false);
        return (interfaceC24340yS42 == null || interfaceC24340yS4 == null || !interfaceC24340yS4.e().equals(interfaceC24340yS42.e())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean e(InterfaceC10239bJ5 interfaceC10239bJ5, InterfaceC16977mB1 interfaceC16977mB1, InterfaceC12795fB1 interfaceC12795fB1) {
        if (interfaceC16977mB1 == null) {
            a(0);
        }
        if (interfaceC12795fB1 == null) {
            a(1);
        }
        if (d(OI1.M(interfaceC16977mB1), interfaceC12795fB1)) {
            return true;
        }
        return QI1.c.e(interfaceC10239bJ5, interfaceC16977mB1, interfaceC12795fB1);
    }

    private static void f(RI1 ri1) {
        d.put(ri1.b(), ri1);
    }

    public static RI1 g(GY7 gy7) {
        if (gy7 == null) {
            a(4);
        }
        RI1 ri1 = (RI1) d.get(gy7);
        if (ri1 != null) {
            return ri1;
        }
        RI1 ri1J = QI1.j(gy7);
        if (ri1J == null) {
            a(5);
        }
        return ri1J;
    }
}
