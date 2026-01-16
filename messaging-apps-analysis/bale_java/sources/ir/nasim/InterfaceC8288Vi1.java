package ir.nasim;

import androidx.fragment.app.Fragment;
import java.util.List;

/* renamed from: ir.nasim.Vi1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC8288Vi1 {
    static /* synthetic */ C22042ua0 c(InterfaceC8288Vi1 interfaceC8288Vi1, String str, String str2, String str3, String str4, ZN2 zn2, boolean z, EnumC6357Ng1 enumC6357Ng1, Integer num, boolean z2, boolean z3, Integer num2, boolean z4, List list, int i, Object obj) {
        if (obj == null) {
            return interfaceC8288Vi1.a(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, zn2, (i & 32) != 0 ? false : z, enumC6357Ng1, (i & 128) != 0 ? null : num, (i & 256) != 0 ? false : z2, (i & 512) != 0 ? false : z3, (i & 1024) != 0 ? null : num2, (i & 2048) != 0 ? false : z4, (i & 4096) != 0 ? AbstractC10360bX0.m() : list);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContactSelectionListFragment");
    }

    C22042ua0 a(String str, String str2, String str3, String str4, ZN2 zn2, boolean z, EnumC6357Ng1 enumC6357Ng1, Integer num, boolean z2, boolean z3, Integer num2, boolean z4, List list);

    Fragment b(EnumC6843Pf2 enumC6843Pf2);

    Fragment d(EnumC6843Pf2 enumC6843Pf2);
}
