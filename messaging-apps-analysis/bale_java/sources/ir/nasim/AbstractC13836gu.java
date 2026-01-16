package ir.nasim;

import ir.nasim.C13245fu;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* renamed from: ir.nasim.gu, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC13836gu {
    private static final C13245fu a = new C13245fu("", null, 2, 0 == true ? 1 : 0);

    /* renamed from: ir.nasim.gu$a */
    public static final class a implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return AbstractC18050o01.d(Integer.valueOf(((C13245fu.d) obj).h()), Integer.valueOf(((C13245fu.d) obj2).h()));
        }
    }

    /* renamed from: ir.nasim.gu$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(C13245fu.a aVar) {
            return Boolean.valueOf(!(aVar instanceof C15396jW4));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List d(List list, List list2) {
        if (list.isEmpty() && list2.isEmpty()) {
            return null;
        }
        if (list2.isEmpty()) {
            return list;
        }
        if (list.isEmpty()) {
            return list2;
        }
        ArrayList arrayList = new ArrayList(list.size() + list2.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add((C13245fu.d) list.get(i));
        }
        int size2 = list2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            arrayList.add((C13245fu.d) list2.get(i2));
        }
        return arrayList;
    }

    public static final C13245fu e() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List f(List list, int i, int i2) {
        if (!(i <= i2)) {
            N73.a("start (" + i + ") should be less than or equal to end (" + i2 + ')');
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            C13245fu.d dVar = (C13245fu.d) list.get(i3);
            if (i(i, i2, dVar.h(), dVar.f())) {
                arrayList.add(new C13245fu.d(dVar.g(), Math.max(i, dVar.h()) - i, Math.min(i2, dVar.f()) - i, dVar.i()));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    private static final List g(C13245fu c13245fu, int i, int i2, UA2 ua2) {
        List listC;
        if (i == i2 || (listC = c13245fu.c()) == null) {
            return null;
        }
        if (i != 0 || i2 < c13245fu.k().length()) {
            ArrayList arrayList = new ArrayList(listC.size());
            int size = listC.size();
            for (int i3 = 0; i3 < size; i3++) {
                C13245fu.d dVar = (C13245fu.d) listC.get(i3);
                if ((ua2 != null ? ((Boolean) ua2.invoke(dVar.g())).booleanValue() : true) && i(i, i2, dVar.h(), dVar.f())) {
                    arrayList.add(new C13245fu.d((C13245fu.a) dVar.g(), AbstractC23053wG5.m(dVar.h(), i, i2) - i, AbstractC23053wG5.m(dVar.f(), i, i2) - i, dVar.i()));
                }
            }
            return arrayList;
        }
        if (ua2 == null) {
            return listC;
        }
        ArrayList arrayList2 = new ArrayList(listC.size());
        int size2 = listC.size();
        for (int i4 = 0; i4 < size2; i4++) {
            Object obj = listC.get(i4);
            if (((Boolean) ua2.invoke(((C13245fu.d) obj).g())).booleanValue()) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    static /* synthetic */ List h(C13245fu c13245fu, int i, int i2, UA2 ua2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            ua2 = null;
        }
        return g(c13245fu, i, i2, ua2);
    }

    public static final boolean i(int i, int i2, int i3, int i4) {
        return ((i < i4) & (i3 < i2)) | (((i == i2) | (i3 == i4)) & (i == i3));
    }

    public static final List j(C13245fu c13245fu, C15396jW4 c15396jW4) {
        List listM;
        List listF = c13245fu.f();
        if (listF == null || (listM = AbstractC15401jX0.a1(listF, new a())) == null) {
            listM = AbstractC10360bX0.m();
        }
        ArrayList arrayList = new ArrayList();
        BJ bj = new BJ();
        int size = listM.size();
        int iF = 0;
        for (int i = 0; i < size; i++) {
            C13245fu.d dVar = (C13245fu.d) listM.get(i);
            C13245fu.d dVarE = C13245fu.d.e(dVar, c15396jW4.l((C15396jW4) dVar.g()), 0, 0, null, 14, null);
            while (iF < dVarE.h() && (!bj.isEmpty())) {
                C13245fu.d dVar2 = (C13245fu.d) bj.last();
                if (dVarE.h() < dVar2.f()) {
                    arrayList.add(new C13245fu.d(dVar2.g(), iF, dVarE.h()));
                    iF = dVarE.h();
                } else {
                    arrayList.add(new C13245fu.d(dVar2.g(), iF, dVar2.f()));
                    iF = dVar2.f();
                    while ((!bj.isEmpty()) && iF == ((C13245fu.d) bj.last()).f()) {
                        bj.removeLast();
                    }
                }
            }
            if (iF < dVarE.h()) {
                arrayList.add(new C13245fu.d(c15396jW4, iF, dVarE.h()));
                iF = dVarE.h();
            }
            C13245fu.d dVar3 = (C13245fu.d) bj.P();
            if (dVar3 == null) {
                bj.add(new C13245fu.d(dVarE.g(), dVarE.h(), dVarE.f()));
            } else if (dVar3.h() == dVarE.h() && dVar3.f() == dVarE.f()) {
                bj.removeLast();
                bj.add(new C13245fu.d(((C15396jW4) dVar3.g()).l((C15396jW4) dVarE.g()), dVarE.h(), dVarE.f()));
            } else if (dVar3.h() == dVar3.f()) {
                arrayList.add(new C13245fu.d(dVar3.g(), dVar3.h(), dVar3.f()));
                bj.removeLast();
                bj.add(new C13245fu.d(dVarE.g(), dVarE.h(), dVarE.f()));
            } else {
                if (dVar3.f() < dVarE.f()) {
                    throw new IllegalArgumentException();
                }
                bj.add(new C13245fu.d(((C15396jW4) dVar3.g()).l((C15396jW4) dVarE.g()), dVarE.h(), dVarE.f()));
            }
        }
        while (iF <= c13245fu.k().length() && (!bj.isEmpty())) {
            C13245fu.d dVar4 = (C13245fu.d) bj.last();
            arrayList.add(new C13245fu.d(dVar4.g(), iF, dVar4.f()));
            iF = dVar4.f();
            while ((!bj.isEmpty()) && iF == ((C13245fu.d) bj.last()).f()) {
                bj.removeLast();
            }
        }
        if (iF < c13245fu.k().length()) {
            arrayList.add(new C13245fu.d(c15396jW4, iF, c13245fu.k().length()));
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new C13245fu.d(c15396jW4, 0, 0));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C13245fu k(C13245fu c13245fu, int i, int i2) {
        String strSubstring;
        if (i != i2) {
            strSubstring = c13245fu.k().substring(i, i2);
            AbstractC13042fc3.h(strSubstring, "substring(...)");
        } else {
            strSubstring = "";
        }
        List listG = g(c13245fu, i, i2, b.e);
        if (listG == null) {
            listG = AbstractC10360bX0.m();
        }
        return new C13245fu(strSubstring, listG);
    }
}
