package ir.nasim;

import ir.nasim.core.modules.profile.entity.ExPeerType;

/* loaded from: classes8.dex */
public final class GM2 {
    public static final GM2 a = new GM2();

    private GM2() {
    }

    public static final boolean a(C14733iO2 c14733iO2, boolean z) {
        AbstractC13042fc3.i(c14733iO2, "groupVM");
        ExPeerType exPeerTypeP = c14733iO2.p();
        ExPeerType exPeerType = ExPeerType.GROUP;
        return exPeerTypeP == exPeerType ? FM2.a.c(c14733iO2, z) : c14733iO2.p() == exPeerType || c14733iO2.x() == AbstractC5969Lp4.f() || c14733iO2.z().b() == null || ((C24119y45) c14733iO2.z().b()).q();
    }

    public static /* synthetic */ boolean b(C14733iO2 c14733iO2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return a(c14733iO2, z);
    }

    public static final void c(C14733iO2 c14733iO2, SA2 sa2) {
        AbstractC13042fc3.i(c14733iO2, "groupVM");
        AbstractC13042fc3.i(sa2, "onChannel");
        if (c14733iO2.p() == ExPeerType.CHANNEL) {
            sa2.invoke();
        }
    }

    public static final void d(C14733iO2 c14733iO2, SA2 sa2) {
        AbstractC13042fc3.i(c14733iO2, "groupVM");
        AbstractC13042fc3.i(sa2, "onGroup");
        if (c14733iO2.p() == ExPeerType.GROUP) {
            sa2.invoke();
        }
    }
}
