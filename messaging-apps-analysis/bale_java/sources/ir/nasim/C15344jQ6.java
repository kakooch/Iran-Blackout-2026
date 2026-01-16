package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.jQ6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C15344jQ6 {
    public static final C15344jQ6 a = new C15344jQ6();
    private static final InterfaceC9336Zm4 b = AbstractC12281eL6.a(AbstractC10360bX0.m());
    private static final C10312bR6 c = new C10312bR6();
    public static final int d = 8;

    private C15344jQ6() {
    }

    public final InterfaceC9336Zm4 a() {
        return b;
    }

    public final Object b(Map map, InterfaceC20295rm1 interfaceC20295rm1) {
        ArrayList arrayList = new ArrayList();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            QQ6 qq6 = (QQ6) AbstractC15401jX0.F0((List) ((Map.Entry) it.next()).getValue());
            if (qq6 != null) {
                arrayList.add(qq6);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            QQ6 qq62 = (QQ6) obj;
            if (qq62.p() != AbstractC5969Lp4.f() && !qq62.E()) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList(AbstractC10976cX0.x(arrayList2, 10));
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(c.a((QQ6) it2.next()));
        }
        Object objA = b.a(arrayList3, interfaceC20295rm1);
        return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
    }
}
