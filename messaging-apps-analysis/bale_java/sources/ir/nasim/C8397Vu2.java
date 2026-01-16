package ir.nasim;

import androidx.camera.camera2.internal.compat.quirk.CaptureSessionOnClosedNotCalledQuirk;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* renamed from: ir.nasim.Vu2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C8397Vu2 {
    private final CaptureSessionOnClosedNotCalledQuirk a;

    /* renamed from: ir.nasim.Vu2$a */
    public interface a {
        void a(InterfaceC18096o47 interfaceC18096o47);
    }

    public C8397Vu2(C6293Mz5 c6293Mz5) {
        this.a = (CaptureSessionOnClosedNotCalledQuirk) c6293Mz5.b(CaptureSessionOnClosedNotCalledQuirk.class);
    }

    private void a(Set set) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            InterfaceC18096o47 interfaceC18096o47 = (InterfaceC18096o47) it.next();
            interfaceC18096o47.c().q(interfaceC18096o47);
        }
    }

    private void b(Set set) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            InterfaceC18096o47 interfaceC18096o47 = (InterfaceC18096o47) it.next();
            interfaceC18096o47.c().r(interfaceC18096o47);
        }
    }

    public void c(InterfaceC18096o47 interfaceC18096o47, List list, List list2, a aVar) {
        InterfaceC18096o47 interfaceC18096o472;
        InterfaceC18096o47 interfaceC18096o473;
        if (d()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator it = list.iterator();
            while (it.hasNext() && (interfaceC18096o473 = (InterfaceC18096o47) it.next()) != interfaceC18096o47) {
                linkedHashSet.add(interfaceC18096o473);
            }
            b(linkedHashSet);
        }
        aVar.a(interfaceC18096o47);
        if (d()) {
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            Iterator it2 = list2.iterator();
            while (it2.hasNext() && (interfaceC18096o472 = (InterfaceC18096o47) it2.next()) != interfaceC18096o47) {
                linkedHashSet2.add(interfaceC18096o472);
            }
            a(linkedHashSet2);
        }
    }

    public boolean d() {
        return this.a != null;
    }
}
