package ir.nasim;

/* loaded from: classes2.dex */
public final class WV1 {
    public static final WV1 a = new WV1();

    private WV1() {
    }

    private final void a(InterfaceC12197eC3 interfaceC12197eC3, int i, int i2, int i3, int i4, Object obj) {
        int i5 = i - i3;
        if (i5 > 0) {
            interfaceC12197eC3.c(i3, i5, obj);
        }
        int i6 = i4 - i2;
        if (i6 > 0) {
            interfaceC12197eC3.c(i2, i6, obj);
        }
    }

    public final void b(InterfaceC12197eC3 interfaceC12197eC3, InterfaceC3516Be5 interfaceC3516Be5, InterfaceC3516Be5 interfaceC3516Be52) {
        AbstractC13042fc3.i(interfaceC12197eC3, "callback");
        AbstractC13042fc3.i(interfaceC3516Be5, "oldList");
        AbstractC13042fc3.i(interfaceC3516Be52, "newList");
        int iMax = Math.max(interfaceC3516Be5.b(), interfaceC3516Be52.b());
        int iMin = Math.min(interfaceC3516Be5.b() + interfaceC3516Be5.a(), interfaceC3516Be52.b() + interfaceC3516Be52.a());
        int i = iMin - iMax;
        if (i > 0) {
            interfaceC12197eC3.b(iMax, i);
            interfaceC12197eC3.a(iMax, i);
        }
        int iMin2 = Math.min(iMax, iMin);
        int iMax2 = Math.max(iMax, iMin);
        a(interfaceC12197eC3, iMin2, iMax2, AbstractC23053wG5.i(interfaceC3516Be5.b(), interfaceC3516Be52.f()), AbstractC23053wG5.i(interfaceC3516Be5.b() + interfaceC3516Be5.a(), interfaceC3516Be52.f()), AT1.ITEM_TO_PLACEHOLDER);
        a(interfaceC12197eC3, iMin2, iMax2, AbstractC23053wG5.i(interfaceC3516Be52.b(), interfaceC3516Be5.f()), AbstractC23053wG5.i(interfaceC3516Be52.b() + interfaceC3516Be52.a(), interfaceC3516Be5.f()), AT1.PLACEHOLDER_TO_ITEM);
        int iF = interfaceC3516Be52.f() - interfaceC3516Be5.f();
        if (iF > 0) {
            interfaceC12197eC3.a(interfaceC3516Be5.f(), iF);
        } else if (iF < 0) {
            interfaceC12197eC3.b(interfaceC3516Be5.f() + iF, -iF);
        }
    }
}
