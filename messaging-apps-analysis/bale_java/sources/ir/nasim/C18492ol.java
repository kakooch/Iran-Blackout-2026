package ir.nasim;

import ir.nasim.database.dailogLists.DialogEntity;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* renamed from: ir.nasim.ol, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C18492ol {
    public static final C18492ol a = new C18492ol();

    /* renamed from: ir.nasim.ol$a */
    public static final class a implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return AbstractC18050o01.d(Long.valueOf(((J44) obj).h()), Long.valueOf(((J44) obj2).h()));
        }
    }

    private C18492ol() {
    }

    private final J44 a(List list, Long l) {
        if (l == null) {
            throw new IllegalStateException();
        }
        if (list.isEmpty()) {
            throw new IllegalStateException();
        }
        List listA1 = AbstractC15401jX0.a1(list, new a());
        J44 j44 = (J44) AbstractC15401jX0.C0(listA1);
        C11907dl c11907dl = new C11907dl(listA1);
        return new J44(l.longValue(), j44.W(), j44.h(), j44.U(), j44.L(), c11907dl, AbstractC12519el.a(c11907dl), 0, j44.Q(), null, 0L, null, null, false, null, j44.T(), j44.K(), null, null, 425600, null);
    }

    private final List g(List list) {
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            J44 j44 = (J44) it.next();
            if (j44.F() instanceof C11907dl) {
                Integer num = (Integer) linkedHashMap.get(Long.valueOf(j44.i()));
                if (num == null) {
                    linkedHashMap.put(Long.valueOf(j44.i()), Integer.valueOf(arrayList.size()));
                    arrayList.add(j44);
                } else {
                    J44 j44F = f((J44) arrayList.get(num.intValue()), j44);
                    if (j44F != null) {
                        arrayList.set(num.intValue(), j44F);
                    }
                }
            } else {
                arrayList.add(j44);
            }
        }
        return arrayList;
    }

    public final J44 b(J44 j44, long j) {
        Object obj = null;
        AbstractC17457n0 abstractC17457n0F = j44 != null ? j44.F() : null;
        C11907dl c11907dl = abstractC17457n0F instanceof C11907dl ? (C11907dl) abstractC17457n0F : null;
        if (c11907dl == null) {
            return null;
        }
        Iterator it = c11907dl.r().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((J44) next).i() == j) {
                obj = next;
                break;
            }
        }
        return (J44) obj;
    }

    public final List c(List list) {
        AbstractC13042fc3.i(list, "messages");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        Long l = null;
        while (it.hasNext()) {
            J44 j44 = (J44) it.next();
            if (j44.F() instanceof C24967zW1) {
                Long lJ = j44.J();
                if (!j44.a0()) {
                    if (!arrayList2.isEmpty()) {
                        arrayList.add(a(arrayList2, l));
                        arrayList2 = new ArrayList();
                        l = null;
                    }
                    arrayList.add(j44);
                } else if (AbstractC13042fc3.d(l, lJ)) {
                    arrayList2.add(j44);
                } else {
                    if (l == null) {
                        arrayList2.add(j44);
                    } else {
                        arrayList.add(a(arrayList2, l));
                        arrayList2 = new ArrayList();
                        arrayList2.add(j44);
                    }
                    l = lJ;
                }
            } else {
                if (!arrayList2.isEmpty()) {
                    arrayList.add(a(arrayList2, l));
                    arrayList2 = new ArrayList();
                    l = null;
                }
                arrayList.add(j44);
            }
        }
        if (!arrayList2.isEmpty()) {
            arrayList.add(a(arrayList2, l));
        }
        return g(arrayList);
    }

    public final void d(C4275El c4275El, long j, J44 j44) {
        AbstractC13042fc3.i(c4275El, "dataSource");
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        AbstractC17457n0 abstractC17457n0F = j44.F();
        if (abstractC17457n0F instanceof C11907dl) {
            long jI = j44.i();
            List<J44> listR = ((C11907dl) abstractC17457n0F).r();
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listR, 10));
            for (J44 j442 : listR) {
                arrayList.add(AbstractC4616Fw7.a(Long.valueOf(j442.i()), Long.valueOf(j442.h())));
            }
            c4275El.d(j, jI, arrayList);
        }
    }

    public final void e(C4275El c4275El, long j, List list) {
        AbstractC13042fc3.i(c4275El, "dataSource");
        AbstractC13042fc3.i(list, "messages");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a.d(c4275El, j, (J44) it.next());
        }
    }

    public final J44 f(J44 j44, J44 j442) {
        AbstractC13042fc3.i(j44, "oldAlbum");
        AbstractC13042fc3.i(j442, "newAlbum");
        if (j44.i() != j442.i() || !(j44.F() instanceof C11907dl) || !(j442.F() instanceof C11907dl)) {
            return null;
        }
        AbstractC17457n0 abstractC17457n0F = j44.F();
        AbstractC13042fc3.g(abstractC17457n0F, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.AlbumContent");
        List listR = ((C11907dl) abstractC17457n0F).r();
        AbstractC17457n0 abstractC17457n0F2 = j442.F();
        AbstractC13042fc3.g(abstractC17457n0F2, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.AlbumContent");
        List listR0 = AbstractC15401jX0.R0(listR, ((C11907dl) abstractC17457n0F2).r());
        LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC23053wG5.e(AbstractC19460qO3.f(AbstractC10976cX0.x(listR0, 10)), 16));
        for (Object obj : listR0) {
            linkedHashMap.put(Long.valueOf(((J44) obj).i()), obj);
        }
        return a(AbstractC15401jX0.m1(linkedHashMap.values()), Long.valueOf(j44.i()));
    }

    public final J44 h(long j, J44 j44, long j2) {
        AbstractC13042fc3.i(j44, "album");
        AbstractC17457n0 abstractC17457n0F = j44.F();
        C11907dl c11907dl = abstractC17457n0F instanceof C11907dl ? (C11907dl) abstractC17457n0F : null;
        if (c11907dl == null) {
            return null;
        }
        List listR = c11907dl.r();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listR) {
            if (((J44) obj).i() != j2) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (arrayList.size() == 1) {
            J44 j442 = (J44) AbstractC15401jX0.q0(arrayList);
            if (j442.L() == EnumC23558x74.PENDING) {
                return J44.D(j442, 0L, 0L, 0L, 0, null, null, null, 0, j44.Q(), null, 0L, null, null, false, null, false, null, null, 245503, null);
            }
        }
        J44 j443 = (J44) AbstractC15401jX0.q0(arrayList);
        C11907dl c11907dl2 = new C11907dl(arrayList);
        return J44.D(j44, j, j443.W(), j443.h(), j443.U(), j443.L(), c11907dl2, AbstractC12519el.a(c11907dl2), 0, null, null, 0L, null, null, false, null, false, null, null, 262016, null);
    }

    public final C11907dl i(C11907dl c11907dl, long j) {
        AbstractC13042fc3.i(c11907dl, "albumContent");
        List listR = c11907dl.r();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listR) {
            if (((J44) obj).i() != j) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new C11907dl(arrayList);
    }
}
