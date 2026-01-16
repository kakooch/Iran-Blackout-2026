package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.pr6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19150pr6 extends AbstractC12586er6 {
    private final C11909dl1 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C19150pr6(C11909dl1 c11909dl1) {
        super(c11909dl1, (ED1) null);
        AbstractC13042fc3.i(c11909dl1, "contentContainer");
        this.d = c11909dl1;
    }

    @Override // ir.nasim.InterfaceC13222fr6
    public String a(Context context, int i, String str, boolean z) {
        AbstractC13042fc3.i(context, "context");
        AbstractC24063xz abstractC24063xzC = this.d.c();
        AbstractC13042fc3.g(abstractC24063xzC, "null cannot be cast to non-null type ir.nasim.core.api.ApiServiceMessage");
        VB vbU = ((C23011wC) abstractC24063xzC).u();
        AbstractC13042fc3.g(vbU, "null cannot be cast to non-null type ir.nasim.core.api.ApiServiceExGroupCallStarted");
        C15802kC c15802kC = (C15802kC) vbU;
        if (!z) {
            return r();
        }
        C24054xy c24054xyU = c15802kC.u();
        if (c24054xyU == null) {
            return r();
        }
        int iR = c24054xyU.r();
        boolean z2 = iR == AbstractC5969Lp4.f();
        String string = z2 ? context.getString(AbstractC12217eE5.f71me) : C24847zI7.b(C24847zI7.a, context, iR, null, false, 12, null);
        AbstractC13042fc3.f(string);
        String string2 = context.getString(z2 ? AbstractC12217eE5.group_you_call_started_service_message : AbstractC12217eE5.group_other_call_started_service_message, string);
        AbstractC13042fc3.h(string2, "getString(...)");
        return string2;
    }

    public final Integer s() {
        AbstractC24063xz abstractC24063xzC = this.d.c();
        AbstractC13042fc3.g(abstractC24063xzC, "null cannot be cast to non-null type ir.nasim.core.api.ApiServiceMessage");
        VB vbU = ((C23011wC) abstractC24063xzC).u();
        AbstractC13042fc3.g(vbU, "null cannot be cast to non-null type ir.nasim.core.api.ApiServiceExGroupCallStarted");
        C24054xy c24054xyU = ((C15802kC) vbU).u();
        if (c24054xyU != null) {
            return Integer.valueOf(c24054xyU.r());
        }
        return null;
    }
}
