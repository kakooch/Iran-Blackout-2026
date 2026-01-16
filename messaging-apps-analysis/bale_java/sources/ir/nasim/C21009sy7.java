package ir.nasim;

import ir.nasim.InterfaceC20419ry7;
import java.util.Collection;

/* renamed from: ir.nasim.sy7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C21009sy7 implements InterfaceC20419ry7 {
    public static final C21009sy7 a = new C21009sy7();

    private C21009sy7() {
    }

    @Override // ir.nasim.InterfaceC20419ry7
    public AbstractC4099Dr3 a(AbstractC4099Dr3 abstractC4099Dr3) {
        return InterfaceC20419ry7.a.b(this, abstractC4099Dr3);
    }

    @Override // ir.nasim.InterfaceC20419ry7
    public boolean c() {
        return InterfaceC20419ry7.a.c(this);
    }

    @Override // ir.nasim.InterfaceC20419ry7
    public String d(InterfaceC21331tU0 interfaceC21331tU0) {
        AbstractC13042fc3.i(interfaceC21331tU0, "classDescriptor");
        return null;
    }

    @Override // ir.nasim.InterfaceC20419ry7
    public String e(InterfaceC21331tU0 interfaceC21331tU0) {
        return InterfaceC20419ry7.a.a(this, interfaceC21331tU0);
    }

    @Override // ir.nasim.InterfaceC20419ry7
    public AbstractC4099Dr3 f(Collection collection) {
        AbstractC13042fc3.i(collection, "types");
        throw new AssertionError(AbstractC13042fc3.q("There should be no intersection type in existing descriptors, but found: ", AbstractC15401jX0.A0(collection, null, null, null, 0, null, null, 63, null)));
    }

    @Override // ir.nasim.InterfaceC20419ry7
    public void g(AbstractC4099Dr3 abstractC4099Dr3, InterfaceC21331tU0 interfaceC21331tU0) {
        AbstractC13042fc3.i(abstractC4099Dr3, "kotlinType");
        AbstractC13042fc3.i(interfaceC21331tU0, "descriptor");
    }

    @Override // ir.nasim.InterfaceC20419ry7
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public AbstractC8317Vl3 b(InterfaceC21331tU0 interfaceC21331tU0) {
        AbstractC13042fc3.i(interfaceC21331tU0, "classDescriptor");
        return null;
    }
}
