package ir.nasim.features.root;

import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC10976cX0;
import ir.nasim.AbstractC12281eL6;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13610gX0;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC22735vk3;
import ir.nasim.AbstractC6459Nq2;
import ir.nasim.AbstractC9083Yk3;
import ir.nasim.C13149fk3;
import ir.nasim.C14505i18;
import ir.nasim.C15913kO2;
import ir.nasim.C25254zz6;
import ir.nasim.C4588Ft6;
import ir.nasim.C7183Qq;
import ir.nasim.C8386Vt0;
import ir.nasim.C8542Wk3;
import ir.nasim.E84;
import ir.nasim.InterfaceC10258bL6;
import ir.nasim.InterfaceC24449ye1;
import ir.nasim.InterfaceC9336Zm4;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.features.root.J;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes6.dex */
public final class K {
    private final SettingsModule a;
    private final E84 b;
    private final InterfaceC9336Zm4 c;
    private final InterfaceC10258bL6 d;
    private C4588Ft6 e;

    public K(SettingsModule settingsModule, E84 e84) {
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(e84, "messageModule");
        this.a = settingsModule;
        this.b = e84;
        e84.T0().l();
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(Boolean.FALSE);
        this.c = interfaceC9336Zm4A;
        this.d = AbstractC6459Nq2.c(interfaceC9336Zm4A);
    }

    private final Set c() {
        CopyOnWriteArrayList copyOnWriteArrayListQ = this.b.N0().q();
        AbstractC13042fc3.h(copyOnWriteArrayListQ, "getGroups(...)");
        ArrayList arrayList = new ArrayList();
        Iterator it = copyOnWriteArrayListQ.iterator();
        while (it.hasNext()) {
            CopyOnWriteArrayList copyOnWriteArrayListQ2 = ((C15913kO2) it.next()).q();
            AbstractC13042fc3.h(copyOnWriteArrayListQ2, "getShortDialogs(...)");
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = copyOnWriteArrayListQ2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(Integer.valueOf(((C25254zz6) it2.next()).w().getPeerId()));
            }
            AbstractC13610gX0.D(arrayList, arrayList2);
        }
        return AbstractC15401jX0.r1(arrayList);
    }

    private final C4588Ft6 h(String str) {
        String strV;
        ArrayList arrayList;
        List listP;
        try {
            C8542Wk3 c8542Wk3O = AbstractC9083Yk3.c(str).o();
            AbstractC22735vk3 abstractC22735vk3L = c8542Wk3O.L("title");
            if (abstractC22735vk3L == null || (strV = abstractC22735vk3L.v()) == null) {
                strV = "";
            }
            String str2 = strV;
            AbstractC22735vk3 abstractC22735vk3L2 = c8542Wk3O.L("maxWidth");
            Integer numValueOf = abstractC22735vk3L2 != null ? Integer.valueOf(abstractC22735vk3L2.i()) : null;
            AbstractC22735vk3 abstractC22735vk3L3 = c8542Wk3O.L("maxWidthAndroid");
            Integer numValueOf2 = abstractC22735vk3L3 != null ? Integer.valueOf(abstractC22735vk3L3.i()) : null;
            AbstractC22735vk3 abstractC22735vk3L4 = c8542Wk3O.L("relatedPeers");
            if (abstractC22735vk3L4 != null) {
                C13149fk3 c13149fk3J = abstractC22735vk3L4.j();
                AbstractC13042fc3.h(c13149fk3J, "getAsJsonArray(...)");
                arrayList = new ArrayList(AbstractC10976cX0.x(c13149fk3J, 10));
                Iterator it = c13149fk3J.iterator();
                while (it.hasNext()) {
                    arrayList.add(Integer.valueOf(((AbstractC22735vk3) it.next()).i()));
                }
            } else {
                arrayList = null;
            }
            AbstractC22735vk3 abstractC22735vk3L5 = c8542Wk3O.L("maxNumRelatedPeersToShow");
            Integer numValueOf3 = Integer.valueOf(abstractC22735vk3L5 != null ? abstractC22735vk3L5.i() : 3);
            AbstractC22735vk3 abstractC22735vk3L6 = c8542Wk3O.L("intervalBetweenShowInDays");
            if (abstractC22735vk3L6 != null) {
                C13149fk3 c13149fk3J2 = abstractC22735vk3L6.j();
                AbstractC13042fc3.h(c13149fk3J2, "getAsJsonArray(...)");
                ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(c13149fk3J2, 10));
                Iterator it2 = c13149fk3J2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(Integer.valueOf(((AbstractC22735vk3) it2.next()).i()));
                }
                listP = arrayList2;
            } else {
                listP = AbstractC10360bX0.p(14, 30);
            }
            return new C4588Ft6(str2, numValueOf, numValueOf2, arrayList, numValueOf3, listP);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private final void i() {
        this.b.T0().l().m0(new InterfaceC24449ye1() { // from class: ir.nasim.fs6
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                ir.nasim.features.root.K.j(this.a, (C14505i18) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(K k, C14505i18 c14505i18) {
        int size;
        Object value;
        Integer numB;
        List listD;
        AbstractC13042fc3.i(k, "this$0");
        C4588Ft6 c4588Ft6 = k.e;
        int iIntValue = 0;
        if (c4588Ft6 == null || (listD = c4588Ft6.d()) == null) {
            size = 0;
        } else {
            ArrayList arrayList = new ArrayList();
            for (Object obj : listD) {
                if (k.c().contains(Integer.valueOf(((Number) obj).intValue()))) {
                    arrayList.add(obj);
                }
            }
            size = arrayList.size();
        }
        C4588Ft6 c4588Ft62 = k.e;
        if (c4588Ft62 != null && (numB = c4588Ft62.b()) != null) {
            iIntValue = numB.intValue();
        }
        if (size <= iIntValue) {
            InterfaceC9336Zm4 interfaceC9336Zm4 = k.c;
            do {
                value = interfaceC9336Zm4.getValue();
                ((Boolean) value).booleanValue();
            } while (!interfaceC9336Zm4.f(value, Boolean.TRUE));
        }
    }

    private final void k() {
        SettingsModule settingsModule = this.a;
        settingsModule.y7(settingsModule.a4() + 1);
        this.a.z7(System.currentTimeMillis());
    }

    public final boolean b() {
        Integer num;
        List listA;
        List listA2;
        int size;
        Integer numB;
        List listD;
        long millis = TimeUnit.DAYS.toMillis(1L);
        long j = C7183Qq.p().getLong("arg_in_app_message_last_seen_mills", -1L);
        boolean z = j == -1 || System.currentTimeMillis() - j > millis;
        boolean z2 = this.a.a4() < this.a.Y3();
        long days = TimeUnit.MILLISECONDS.toDays(System.currentTimeMillis() - this.a.b4());
        this.e = h(this.a.Z3());
        if (this.a.a4() == 0) {
            num = 0;
        } else {
            C4588Ft6 c4588Ft6 = this.e;
            Object obj = null;
            if (c4588Ft6 == null || (listA = c4588Ft6.a()) == null) {
                num = null;
            } else {
                int iA4 = this.a.a4() - 1;
                if (iA4 < 0 || iA4 >= listA.size()) {
                    C4588Ft6 c4588Ft62 = this.e;
                    if (c4588Ft62 != null && (listA2 = c4588Ft62.a()) != null) {
                        obj = (Integer) AbstractC15401jX0.F0(listA2);
                    }
                } else {
                    obj = listA.get(iA4);
                }
                num = (Integer) obj;
            }
        }
        boolean z3 = this.e != null && (num == null || days >= ((long) num.intValue()));
        C4588Ft6 c4588Ft63 = this.e;
        if (c4588Ft63 == null || (listD = c4588Ft63.d()) == null) {
            size = 0;
        } else {
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : listD) {
                if (c().contains(Integer.valueOf(((Number) obj2).intValue()))) {
                    arrayList.add(obj2);
                }
            }
            size = arrayList.size();
        }
        C4588Ft6 c4588Ft64 = this.e;
        return C8386Vt0.pa() && z && z2 && z3 && (size <= ((c4588Ft64 == null || (numB = c4588Ft64.b()) == null) ? 0 : numB.intValue()));
    }

    public final InterfaceC10258bL6 d() {
        return this.d;
    }

    public final Integer e() {
        C4588Ft6 c4588Ft6 = this.e;
        if (c4588Ft6 != null) {
            return c4588Ft6.c();
        }
        return null;
    }

    public final String f() {
        String strE;
        C4588Ft6 c4588Ft6 = this.e;
        return (c4588Ft6 == null || (strE = c4588Ft6.e()) == null) ? "" : strE;
    }

    public final void g(J j) {
        Object value;
        AbstractC13042fc3.i(j, "serviceToolTipAction");
        if (AbstractC13042fc3.d(j, J.c.a)) {
            k();
            return;
        }
        if (AbstractC13042fc3.d(j, J.a.a)) {
            i();
        } else {
            if (!AbstractC13042fc3.d(j, J.b.a)) {
                throw new NoWhenBranchMatchedException();
            }
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.c;
            do {
                value = interfaceC9336Zm4.getValue();
                ((Boolean) value).booleanValue();
            } while (!interfaceC9336Zm4.f(value, Boolean.FALSE));
        }
    }
}
