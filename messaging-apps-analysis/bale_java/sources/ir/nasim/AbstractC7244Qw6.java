package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.Qw6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC7244Qw6 {

    /* renamed from: ir.nasim.Qw6$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ Map e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Map map) {
            super(1);
            this.e = map;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List invoke(C7000Pw6 c7000Pw6) {
            Map map = this.e;
            InterfaceC16813lu3 interfaceC16813lu3D = c7000Pw6.d();
            List list = (List) map.get(interfaceC16813lu3D != null ? interfaceC16813lu3D.a() : null);
            return list == null ? AbstractC10360bX0.m() : list;
        }
    }

    /* renamed from: ir.nasim.Qw6$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C7000Pw6 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C7000Pw6 c7000Pw6) {
            super(1);
            this.e = c7000Pw6;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(XV4 xv4) {
            return Boolean.valueOf(!AbstractC13042fc3.d(((C7000Pw6) xv4.f()).a(), this.e));
        }
    }

    /* renamed from: ir.nasim.Qw6$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        public static final c e = new c();

        c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C7000Pw6 invoke(XV4 xv4) {
            return (C7000Pw6) xv4.b();
        }
    }

    public static final List a(List list) {
        if (list.size() < 2) {
            return list;
        }
        List list2 = list;
        ArrayList<C7000Pw6> arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(new C7000Pw6((LW7) it.next()));
        }
        ArrayList<C7000Pw6> arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            AbstractC13610gX0.C(arrayList2, ((C7000Pw6) it2.next()).b());
        }
        ArrayList arrayList3 = new ArrayList(AbstractC10976cX0.x(arrayList2, 10));
        for (C7000Pw6 c7000Pw6 : arrayList2) {
            arrayList3.add(AbstractC4616Fw7.a(c7000Pw6.d(), c7000Pw6));
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj : arrayList3) {
            if (((XV4) obj).e() != null) {
                arrayList4.add(obj);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj2 : arrayList4) {
            InterfaceC16813lu3 interfaceC16813lu3 = (InterfaceC16813lu3) ((XV4) obj2).e();
            Object arrayList5 = linkedHashMap.get(interfaceC16813lu3);
            if (arrayList5 == null) {
                arrayList5 = new ArrayList();
                linkedHashMap.put(interfaceC16813lu3, arrayList5);
            }
            ((List) arrayList5).add(obj2);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(arrayList);
        for (C7000Pw6 c7000Pw62 : arrayList) {
            C7000Pw6 c7000Pw63 = (C7000Pw6) AbstractC11342cq6.v(AbstractC11342cq6.C(AbstractC11342cq6.r(AbstractC11342cq6.x(c7000Pw62.b(), new a(linkedHashMap)), new b(c7000Pw62)), c.e));
            if (c7000Pw63 != null) {
                c7000Pw62.e(c7000Pw63);
                linkedHashSet.remove(c7000Pw62);
            }
        }
        ArrayList arrayList6 = new ArrayList(AbstractC10976cX0.x(linkedHashSet, 10));
        Iterator it3 = linkedHashSet.iterator();
        while (it3.hasNext()) {
            arrayList6.add(((C7000Pw6) it3.next()).f());
        }
        return arrayList6;
    }
}
