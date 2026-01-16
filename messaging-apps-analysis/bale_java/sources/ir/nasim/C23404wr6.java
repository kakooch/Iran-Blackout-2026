package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.wr6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C23404wr6 extends AbstractC12586er6 {
    private final String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C23404wr6(C11909dl1 c11909dl1) {
        super(c11909dl1, (ED1) null);
        AbstractC13042fc3.i(c11909dl1, "remoteContainer");
        AbstractC24063xz abstractC24063xzC = c11909dl1.c();
        AbstractC13042fc3.g(abstractC24063xzC, "null cannot be cast to non-null type ir.nasim.core.api.ApiServiceMessage");
        VB vbU = ((C23011wC) abstractC24063xzC).u();
        AbstractC13042fc3.g(vbU, "null cannot be cast to non-null type ir.nasim.core.api.ApiServiceExChangedTitle");
        this.d = ((C10786cC) vbU).u();
    }

    @Override // ir.nasim.InterfaceC13222fr6
    public String a(Context context, int i, String str, boolean z) {
        AbstractC13042fc3.i(context, "context");
        if (!z) {
            String string = context.getString(AbstractC12217eE5.service_holder_channel_title_changed, this.d);
            AbstractC13042fc3.f(string);
            return string;
        }
        if (i != AbstractC5969Lp4.f()) {
            return AbstractC20655sN7.b(AbstractC20655sN7.c(context, AbstractC12217eE5.service_holder_group_title_changed_by, C24847zI7.b(C24847zI7.a, context, i, str, false, 8, null), this.d), context, i == AbstractC5969Lp4.f());
        }
        String string2 = context.getString(AbstractC12217eE5.service_holder_group_title_changed_by_me, this.d);
        AbstractC13042fc3.f(string2);
        return string2;
    }

    public final String s() {
        return this.d;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C23404wr6(String str) {
        this(new C11909dl1(new C23011wC("Title changed", new C10786cC(str))));
        AbstractC13042fc3.i(str, "title");
    }
}
