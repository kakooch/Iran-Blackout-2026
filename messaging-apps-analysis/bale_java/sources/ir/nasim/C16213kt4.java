package ir.nasim;

import ir.nasim.C5210Ij1;
import java.util.HashMap;
import java.util.List;

/* renamed from: ir.nasim.kt4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16213kt4 extends AbstractC21707u0 implements InterfaceC25225zw4 {
    private final C9057Yh4 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C16213kt4(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        this.b = c9057Yh4;
    }

    @Override // ir.nasim.InterfaceC25225zw4
    public C6517Nv5 a(AbstractC20556sC7 abstractC20556sC7) {
        AbstractC13042fc3.i(abstractC20556sC7, "update");
        if (!(abstractC20556sC7 instanceof C13437gD7)) {
            if (!(abstractC20556sC7 instanceof C14630iD7)) {
                return null;
            }
            C14630iD7 c14630iD7 = (C14630iD7) abstractC20556sC7;
            int size = c14630iD7.a().size();
            int[] iArr = new int[size];
            for (int i = 0; i < size; i++) {
                iArr[i] = ((Number) c14630iD7.a().get(i)).intValue();
            }
            this.b.A().l0().d(new C5210Ij1.c(iArr));
            return C6517Nv5.l0(C14505i18.a);
        }
        C13437gD7 c13437gD7 = (C13437gD7) abstractC20556sC7;
        int size2 = c13437gD7.b().size();
        int[] iArr2 = new int[size2];
        for (int i2 = 0; i2 < size2; i2++) {
            iArr2[i2] = ((Number) c13437gD7.b().get(i2)).intValue();
        }
        HashMap map = new HashMap();
        C19811qz c19811qzA = c13437gD7.a();
        if (c19811qzA != null) {
            List<C20420rz> listU = c19811qzA.u();
            AbstractC13042fc3.h(listU, "getItems(...)");
            for (C20420rz c20420rz : listU) {
                String key = c20420rz.getKey();
                AbstractC17566nB abstractC17566nBQ = c20420rz.q();
                AbstractC13042fc3.g(abstractC17566nBQ, "null cannot be cast to non-null type ir.nasim.core.api.ApiInt64Value");
                map.put(key, Long.valueOf(((C5811Ky) abstractC17566nBQ).u()));
            }
        } else {
            C19406qI3.a("UpdateContactsAdded", "apiPhonesMapValue is null", new Object[0]);
        }
        this.b.A().l0().d(new C5210Ij1.b(iArr2, map));
        return C6517Nv5.l0(C14505i18.a);
    }
}
