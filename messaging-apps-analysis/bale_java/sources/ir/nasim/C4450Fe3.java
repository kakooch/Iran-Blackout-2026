package ir.nasim;

import ir.nasim.C15898kM5;
import ir.nasim.InterfaceC15947kS0;

/* renamed from: ir.nasim.Fe3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C4450Fe3 implements InterfaceC15947kS0 {
    public static final C4450Fe3 a = new C4450Fe3();
    private static final String b = "second parameter must be of type KProperty<*> or its supertype";

    private C4450Fe3() {
    }

    @Override // ir.nasim.InterfaceC15947kS0
    public boolean a(AB2 ab2) {
        AbstractC13042fc3.i(ab2, "functionDescriptor");
        InterfaceC24919zQ7 interfaceC24919zQ7 = (InterfaceC24919zQ7) ab2.h().get(1);
        C15898kM5.b bVar = C15898kM5.k;
        AbstractC13042fc3.h(interfaceC24919zQ7, "secondParameter");
        AbstractC4099Dr3 abstractC4099Dr3A = bVar.a(PI1.l(interfaceC24919zQ7));
        if (abstractC4099Dr3A == null) {
            return false;
        }
        AbstractC4099Dr3 type = interfaceC24919zQ7.getType();
        AbstractC13042fc3.h(type, "secondParameter.type");
        return AbstractC7731Sy7.g(abstractC4099Dr3A, AbstractC7731Sy7.j(type));
    }

    @Override // ir.nasim.InterfaceC15947kS0
    public String b(AB2 ab2) {
        return InterfaceC15947kS0.a.a(this, ab2);
    }

    @Override // ir.nasim.InterfaceC15947kS0
    public String getDescription() {
        return b;
    }
}
