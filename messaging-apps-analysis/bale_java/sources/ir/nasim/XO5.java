package ir.nasim;

import android.content.Context;

/* loaded from: classes5.dex */
public final class XO5 extends AbstractC17457n0 {
    private boolean c;
    private Boolean d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XO5(C11909dl1 c11909dl1) {
        super(c11909dl1);
        AbstractC13042fc3.i(c11909dl1, "contentRemoteContainer");
        AbstractC24063xz abstractC24063xzC = c11909dl1.c();
        AbstractC13042fc3.g(abstractC24063xzC, "null cannot be cast to non-null type ir.nasim.core.api.ApiTemplateMessage");
        TC tc = (TC) abstractC24063xzC;
        if (tc.z() != null) {
            AB abZ = tc.z();
            AbstractC13042fc3.f(abZ);
            this.c = abZ.q();
            AB abZ2 = tc.z();
            AbstractC13042fc3.f(abZ2);
            this.d = abZ2.r();
        }
    }

    @Override // ir.nasim.InterfaceC25103zk1
    public String b(Context context, int i, String str, boolean z) {
        AbstractC13042fc3.i(context, "context");
        return InterfaceC25103zk1.a.a(context);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC13042fc3.d(XO5.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.ReplyKeyboardRemove");
        XO5 xo5 = (XO5) obj;
        return this.c == xo5.c && AbstractC13042fc3.d(this.d, xo5.d);
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.c) * 31;
        Boolean bool = this.d;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }

    @Override // ir.nasim.AbstractC17457n0
    public C23345wl7 l() {
        return null;
    }

    public final boolean r() {
        return this.c;
    }
}
