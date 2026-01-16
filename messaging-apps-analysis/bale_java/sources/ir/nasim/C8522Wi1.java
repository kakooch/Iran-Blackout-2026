package ir.nasim;

import androidx.fragment.app.Fragment;
import java.util.List;

/* renamed from: ir.nasim.Wi1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C8522Wi1 implements InterfaceC8288Vi1 {
    @Override // ir.nasim.InterfaceC8288Vi1
    public C22042ua0 a(String str, String str2, String str3, String str4, ZN2 zn2, boolean z, EnumC6357Ng1 enumC6357Ng1, Integer num, boolean z2, boolean z3, Integer num2, boolean z4, List list) {
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(zn2, "groupType");
        AbstractC13042fc3.i(enumC6357Ng1, "contactSelectionType");
        AbstractC13042fc3.i(list, "groupMembers");
        return C8261Vf1.INSTANCE.a(str, str2, str3, str4, zn2, z ? PM2.c : PM2.b, enumC6357Ng1, num, z2, z3, num2, z4, list);
    }

    @Override // ir.nasim.InterfaceC8288Vi1
    public Fragment b(EnumC6843Pf2 enumC6843Pf2) {
        AbstractC13042fc3.i(enumC6843Pf2, "contactsFragmentNavigationEvent");
        return C8386Vt0.a.s8() ? C6229Ms4.INSTANCE.a(false, enumC6843Pf2) : C20253ri1.INSTANCE.a(false, enumC6843Pf2);
    }

    @Override // ir.nasim.InterfaceC8288Vi1
    public Fragment d(EnumC6843Pf2 enumC6843Pf2) {
        AbstractC13042fc3.i(enumC6843Pf2, "contactsFragmentNavigationEvent");
        return C8386Vt0.a.s8() ? C6229Ms4.INSTANCE.a(true, enumC6843Pf2) : C20253ri1.INSTANCE.a(true, enumC6843Pf2);
    }
}
