package ir.nasim;

import ir.nasim.AbstractC5270Ip7;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Gw0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4858Gw0 extends AbstractC5270Ip7.c {
    @Override // ir.nasim.AbstractC5270Ip7.c
    protected void i(int i, String str, String str2, Throwable th) {
        AbstractC13042fc3.i(str2, DialogEntity.COLUMN_MESSAGE);
        if (AbstractC20762sZ6.X(str2, "onConnectionChange", false, 2, null) || AbstractC20762sZ6.X(str2, "received ice candidate from peer", false, 2, null) || AbstractC20762sZ6.X(str2, " trickle {", false, 2, null) || AbstractC20762sZ6.X(str2, " answer {", false, 2, null) || AbstractC20762sZ6.X(str2, "received server answer:", false, 2, null) || AbstractC20762sZ6.X(str2, "primary ICE", false, 2, null) || AbstractC20762sZ6.X(str2, "onIceCandidate:", false, 2, null) || AbstractC20762sZ6.X(str2, "sdp type:", false, 2, null)) {
            C19406qI3.a("ICE_STATE", str2, new Object[0]);
        } else if (AbstractC20762sZ6.X(str2, "join {", false, 2, null)) {
            C19406qI3.a("ICE_STATE", String.valueOf(n(str2)), new Object[0]);
        }
    }

    public final List n(String str) {
        AbstractC13042fc3.i(str, "input");
        ArrayList arrayList = new ArrayList();
        OU3 ou3C = C20644sM5.c(new C20644sM5("join\\s*\\{([\\s\\S]*?)^\\}", EnumC23107wM5.d), str, 0, 2, null);
        if (ou3C == null) {
            return AbstractC10360bX0.m();
        }
        Iterator it = C20644sM5.e(new C20644sM5("ice_servers\\s*\\{[\\s\\S]*?\\}"), (String) ou3C.b().get(1), 0, 2, null).iterator();
        while (it.hasNext()) {
            arrayList.add(((OU3) it.next()).getValue());
        }
        return arrayList;
    }
}
