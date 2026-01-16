package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.ny7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC18037ny7 {
    private static final X82 a;
    private static final X82 b;

    /* renamed from: ir.nasim.ny7$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[EnumC11300cm4.valuesCustom().length];
            iArr[EnumC11300cm4.READ_ONLY.ordinal()] = 1;
            iArr[EnumC11300cm4.MUTABLE.ordinal()] = 2;
            a = iArr;
            int[] iArr2 = new int[EnumC14043hF4.valuesCustom().length];
            iArr2[EnumC14043hF4.NULLABLE.ordinal()] = 1;
            iArr2[EnumC14043hF4.NOT_NULL.ordinal()] = 2;
            b = iArr2;
        }
    }

    static {
        C9424Zw2 c9424Zw2 = AbstractC24521yl3.q;
        AbstractC13042fc3.h(c9424Zw2, "ENHANCED_NULLABILITY_ANNOTATION");
        a = new X82(c9424Zw2);
        C9424Zw2 c9424Zw22 = AbstractC24521yl3.r;
        AbstractC13042fc3.h(c9424Zw22, "ENHANCED_MUTABILITY_ANNOTATION");
        b = new X82(c9424Zw22);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC4356Eu d(List list) {
        int size = list.size();
        if (size != 0) {
            return size != 1 ? new C5840Lb1(AbstractC15401jX0.m1(list)) : (InterfaceC4356Eu) AbstractC15401jX0.V0(list);
        }
        throw new IllegalStateException("At least one Annotations object expected".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y82 e(MU0 mu0, C8056Ui3 c8056Ui3, EnumC12655ey7 enumC12655ey7) {
        if (!AbstractC13291fy7.a(enumC12655ey7)) {
            return j(mu0);
        }
        if (!(mu0 instanceof InterfaceC21331tU0)) {
            return j(mu0);
        }
        C5437Ji3 c5437Ji3 = C5437Ji3.a;
        EnumC11300cm4 enumC11300cm4B = c8056Ui3.b();
        int i = enumC11300cm4B == null ? -1 : a.a[enumC11300cm4B.ordinal()];
        if (i != 1) {
            if (i == 2 && enumC12655ey7 == EnumC12655ey7.FLEXIBLE_UPPER) {
                InterfaceC21331tU0 interfaceC21331tU0 = (InterfaceC21331tU0) mu0;
                if (c5437Ji3.e(interfaceC21331tU0)) {
                    return f(c5437Ji3.b(interfaceC21331tU0));
                }
            }
        } else if (enumC12655ey7 == EnumC12655ey7.FLEXIBLE_LOWER) {
            InterfaceC21331tU0 interfaceC21331tU02 = (InterfaceC21331tU0) mu0;
            if (c5437Ji3.c(interfaceC21331tU02)) {
                return f(c5437Ji3.a(interfaceC21331tU02));
            }
        }
        return j(mu0);
    }

    private static final Y82 f(Object obj) {
        return new Y82(obj, b);
    }

    private static final Y82 g(Object obj) {
        return new Y82(obj, a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y82 h(AbstractC4099Dr3 abstractC4099Dr3, C8056Ui3 c8056Ui3, EnumC12655ey7 enumC12655ey7) {
        if (!AbstractC13291fy7.a(enumC12655ey7)) {
            return j(Boolean.valueOf(abstractC4099Dr3.L0()));
        }
        EnumC14043hF4 enumC14043hF4C = c8056Ui3.c();
        int i = enumC14043hF4C == null ? -1 : a.b[enumC14043hF4C.ordinal()];
        return i != 1 ? i != 2 ? j(Boolean.valueOf(abstractC4099Dr3.L0())) : g(Boolean.FALSE) : g(Boolean.TRUE);
    }

    public static final boolean i(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "<this>");
        return AbstractC16855ly7.b(CC6.a, abstractC4099Dr3);
    }

    private static final Y82 j(Object obj) {
        return new Y82(obj, null);
    }
}
