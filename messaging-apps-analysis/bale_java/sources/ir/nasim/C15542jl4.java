package ir.nasim;

import ir.nasim.C9475a16;
import java.util.Iterator;

/* renamed from: ir.nasim.jl4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C15542jl4 {
    public static final C15542jl4 a = new C15542jl4();

    private C15542jl4() {
    }

    private final boolean c(InterfaceC3570Bk5 interfaceC3570Bk5) {
        Object objB;
        String str = "app.android." + EnumC4716Gg2.b2.getValue();
        try {
            C9475a16.a aVar = C9475a16.b;
            String strE = interfaceC3570Bk5.e("app.settings." + str);
            objB = C9475a16.b(Integer.valueOf(strE != null ? Integer.parseInt(strE) : Integer.MAX_VALUE));
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        if (C9475a16.g(objB)) {
            objB = Integer.MAX_VALUE;
        }
        int iIntValue = ((Number) objB).intValue();
        String strR = AbstractC20507s76.r();
        AbstractC13042fc3.h(strR, "getVersion(...)");
        return ZI2.b(strR) >= iIntValue;
    }

    public final boolean a() {
        return C13923h3.a.k().getSyncContacts();
    }

    public final boolean b() {
        Iterator it = C13923h3.a.o().iterator();
        while (it.hasNext()) {
            InterfaceC3570Bk5 interfaceC3570Bk5R = C7183Qq.r(C13923h3.r((String) it.next()));
            C15542jl4 c15542jl4 = a;
            AbstractC13042fc3.f(interfaceC3570Bk5R);
            if (c15542jl4.c(interfaceC3570Bk5R)) {
                return true;
            }
        }
        return false;
    }
}
