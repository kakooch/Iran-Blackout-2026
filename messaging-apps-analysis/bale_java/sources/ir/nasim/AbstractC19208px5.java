package ir.nasim;

import ir.nasim.InterfaceC15194jA0;

/* renamed from: ir.nasim.px5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC19208px5 {

    /* renamed from: ir.nasim.px5$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[EnumC8184Uw5.values().length];
            iArr[EnumC8184Uw5.DECLARATION.ordinal()] = 1;
            iArr[EnumC8184Uw5.FAKE_OVERRIDE.ordinal()] = 2;
            iArr[EnumC8184Uw5.DELEGATION.ordinal()] = 3;
            iArr[EnumC8184Uw5.SYNTHESIZED.ordinal()] = 4;
            a = iArr;
            int[] iArr2 = new int[InterfaceC15194jA0.a.values().length];
            iArr2[InterfaceC15194jA0.a.DECLARATION.ordinal()] = 1;
            iArr2[InterfaceC15194jA0.a.FAKE_OVERRIDE.ordinal()] = 2;
            iArr2[InterfaceC15194jA0.a.DELEGATION.ordinal()] = 3;
            iArr2[InterfaceC15194jA0.a.SYNTHESIZED.ordinal()] = 4;
            b = iArr2;
            int[] iArr3 = new int[EnumC15071ix5.values().length];
            iArr3[EnumC15071ix5.INTERNAL.ordinal()] = 1;
            iArr3[EnumC15071ix5.PRIVATE.ordinal()] = 2;
            iArr3[EnumC15071ix5.PRIVATE_TO_THIS.ordinal()] = 3;
            iArr3[EnumC15071ix5.PROTECTED.ordinal()] = 4;
            iArr3[EnumC15071ix5.PUBLIC.ordinal()] = 5;
            iArr3[EnumC15071ix5.LOCAL.ordinal()] = 6;
            c = iArr3;
        }
    }

    public static final RI1 a(C18617ox5 c18617ox5, EnumC15071ix5 enumC15071ix5) {
        AbstractC13042fc3.i(c18617ox5, "<this>");
        switch (enumC15071ix5 == null ? -1 : a.c[enumC15071ix5.ordinal()]) {
            case 1:
                RI1 ri1 = QI1.d;
                AbstractC13042fc3.h(ri1, "INTERNAL");
                return ri1;
            case 2:
                RI1 ri12 = QI1.a;
                AbstractC13042fc3.h(ri12, "PRIVATE");
                return ri12;
            case 3:
                RI1 ri13 = QI1.b;
                AbstractC13042fc3.h(ri13, "PRIVATE_TO_THIS");
                return ri13;
            case 4:
                RI1 ri14 = QI1.c;
                AbstractC13042fc3.h(ri14, "PROTECTED");
                return ri14;
            case 5:
                RI1 ri15 = QI1.e;
                AbstractC13042fc3.h(ri15, "PUBLIC");
                return ri15;
            case 6:
                RI1 ri16 = QI1.f;
                AbstractC13042fc3.h(ri16, "LOCAL");
                return ri16;
            default:
                RI1 ri17 = QI1.a;
                AbstractC13042fc3.h(ri17, "PRIVATE");
                return ri17;
        }
    }

    public static final InterfaceC15194jA0.a b(C18617ox5 c18617ox5, EnumC8184Uw5 enumC8184Uw5) {
        AbstractC13042fc3.i(c18617ox5, "<this>");
        int i = enumC8184Uw5 == null ? -1 : a.a[enumC8184Uw5.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? InterfaceC15194jA0.a.DECLARATION : InterfaceC15194jA0.a.SYNTHESIZED : InterfaceC15194jA0.a.DELEGATION : InterfaceC15194jA0.a.FAKE_OVERRIDE : InterfaceC15194jA0.a.DECLARATION;
    }
}
