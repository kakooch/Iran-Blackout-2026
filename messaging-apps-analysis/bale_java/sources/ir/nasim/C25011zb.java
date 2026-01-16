package ir.nasim;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

/* renamed from: ir.nasim.zb, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C25011zb implements InterfaceC24417yb {
    @Override // ir.nasim.InterfaceC24417yb
    public Fragment a(int i, int i2, boolean z, C23104wM2 c23104wM2, boolean z2) {
        C23827xb c23827xb = new C23827xb();
        Bundle bundleB = AbstractC23348wm0.b(AbstractC4616Fw7.a("userId", Integer.valueOf(i)), AbstractC4616Fw7.a("groupId", Integer.valueOf(i2)), AbstractC4616Fw7.a("isFirst", Boolean.valueOf(z)), AbstractC4616Fw7.a("IS_OWNER", Boolean.valueOf(z2)));
        if (c23104wM2 != null) {
            bundleB.putSerializable("ARG_GROUP_MEMBER", c23104wM2);
        }
        c23827xb.a8(bundleB);
        return c23827xb;
    }
}
