package ir.nasim;

import ir.nasim.EnumC24185yB2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.dm0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C11918dm0 implements InterfaceC22578vU0 {
    private final ON6 a;
    private final InterfaceC8507Wg4 b;

    public C11918dm0(ON6 on6, InterfaceC8507Wg4 interfaceC8507Wg4) {
        AbstractC13042fc3.i(on6, "storageManager");
        AbstractC13042fc3.i(interfaceC8507Wg4, "module");
        this.a = on6;
        this.b = interfaceC8507Wg4;
    }

    @Override // ir.nasim.InterfaceC22578vU0
    public InterfaceC21331tU0 a(C24948zU0 c24948zU0) {
        AbstractC13042fc3.i(c24948zU0, "classId");
        if (c24948zU0.k() || c24948zU0.l()) {
            return null;
        }
        String strB = c24948zU0.i().b();
        AbstractC13042fc3.h(strB, "classId.relativeClassName.asString()");
        if (!AbstractC20762sZ6.X(strB, "Function", false, 2, null)) {
            return null;
        }
        C9424Zw2 c9424Zw2H = c24948zU0.h();
        AbstractC13042fc3.h(c9424Zw2H, "classId.packageFqName");
        EnumC24185yB2.a.C1777a c1777aC = EnumC24185yB2.c.c(strB, c9424Zw2H);
        if (c1777aC == null) {
            return null;
        }
        EnumC24185yB2 enumC24185yB2A = c1777aC.a();
        int iB = c1777aC.b();
        List listJ0 = this.b.z0(c9424Zw2H).j0();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listJ0) {
            if (obj instanceof InterfaceC14958im0) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            it.next();
        }
        AbstractC18350oW3.a(AbstractC15401jX0.s0(arrayList2));
        return new C23595xB2(this.a, (InterfaceC14958im0) AbstractC15401jX0.q0(arrayList), enumC24185yB2A, iB);
    }

    @Override // ir.nasim.InterfaceC22578vU0
    public boolean b(C9424Zw2 c9424Zw2, C6432No4 c6432No4) {
        AbstractC13042fc3.i(c9424Zw2, "packageFqName");
        AbstractC13042fc3.i(c6432No4, "name");
        String strH = c6432No4.h();
        AbstractC13042fc3.h(strH, "name.asString()");
        return (AbstractC20153rZ6.S(strH, "Function", false, 2, null) || AbstractC20153rZ6.S(strH, "KFunction", false, 2, null) || AbstractC20153rZ6.S(strH, "SuspendFunction", false, 2, null) || AbstractC20153rZ6.S(strH, "KSuspendFunction", false, 2, null)) && EnumC24185yB2.c.c(strH, c9424Zw2) != null;
    }

    @Override // ir.nasim.InterfaceC22578vU0
    public Collection c(C9424Zw2 c9424Zw2) {
        AbstractC13042fc3.i(c9424Zw2, "packageFqName");
        return AbstractC4597Fu6.d();
    }
}
