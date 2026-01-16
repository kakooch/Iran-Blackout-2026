package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.xr6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C23994xr6 extends AbstractC12586er6 {
    private final String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C23994xr6(C11909dl1 c11909dl1) {
        super(c11909dl1, (ED1) null);
        AbstractC13042fc3.i(c11909dl1, "remoteContainer");
        AbstractC24063xz abstractC24063xzC = c11909dl1.c();
        AbstractC13042fc3.g(abstractC24063xzC, "null cannot be cast to non-null type ir.nasim.core.api.ApiServiceMessage");
        VB vbU = ((C23011wC) abstractC24063xzC).u();
        AbstractC13042fc3.g(vbU, "null cannot be cast to non-null type ir.nasim.core.api.ApiServiceExChangedTopic");
        this.d = ((C11550dC) vbU).u();
    }

    @Override // ir.nasim.InterfaceC13222fr6
    public String a(Context context, int i, String str, boolean z) {
        AbstractC13042fc3.i(context, "context");
        int i2 = AbstractC12217eE5.service_holder_group_topic_changed;
        String strB = C24847zI7.b(C24847zI7.a, context, i, str, false, 8, null);
        String strI = AbstractC20655sN7.i(context, z, false, 2, null);
        String str2 = this.d;
        if (str2 == null) {
            str2 = "";
        }
        return AbstractC20655sN7.b(AbstractC20655sN7.c(context, i2, strB, strI, str2), context, i == AbstractC5969Lp4.f());
    }
}
