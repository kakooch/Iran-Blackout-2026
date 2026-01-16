package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.og4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC18447og4 {

    /* renamed from: ir.nasim.og4$a */
    class a implements InterfaceC16674lg4 {
        final /* synthetic */ List a;

        a(List list) {
            this.a = list;
        }

        @Override // ir.nasim.InterfaceC16674lg4
        public List a(ArrayList arrayList) {
            ArrayList arrayList2 = new ArrayList();
            AbstractC18447og4.o(this.a, arrayList, arrayList2);
            return arrayList2;
        }
    }

    /* renamed from: ir.nasim.og4$b */
    class b implements InterfaceC16674lg4 {
        final /* synthetic */ long[] a;

        b(long[] jArr) {
            this.a = jArr;
        }

        @Override // ir.nasim.InterfaceC16674lg4
        public List a(ArrayList arrayList) {
            ArrayList arrayList2 = new ArrayList();
            int i = 0;
            while (i < arrayList.size()) {
                HB3 hb3 = (HB3) arrayList.get(i);
                long[] jArr = this.a;
                int length = jArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 < length) {
                        if (hb3.a() == jArr[i2]) {
                            arrayList.remove(i);
                            arrayList2.add(C20603sI0.j(i));
                            i--;
                            break;
                        }
                        i2++;
                    }
                }
                i++;
            }
            return arrayList2;
        }
    }

    /* renamed from: ir.nasim.og4$c */
    class c implements InterfaceC16674lg4 {
        c() {
        }

        @Override // ir.nasim.InterfaceC16674lg4
        public List a(ArrayList arrayList) {
            ArrayList arrayList2 = new ArrayList();
            if (arrayList.size() != 0) {
                arrayList2.add(C20603sI0.k(0, arrayList.size()));
                arrayList.clear();
            }
            return arrayList2;
        }
    }

    public static InterfaceC16674lg4 d(final List list) {
        return new InterfaceC16674lg4() { // from class: ir.nasim.ng4
            @Override // ir.nasim.InterfaceC16674lg4
            public final List a(ArrayList arrayList) {
                return AbstractC18447og4.j(list, arrayList);
            }
        };
    }

    public static InterfaceC16674lg4 e(HB3 hb3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(hb3);
        return f(arrayList);
    }

    public static InterfaceC16674lg4 f(final List list) {
        return new InterfaceC16674lg4() { // from class: ir.nasim.mg4
            @Override // ir.nasim.InterfaceC16674lg4
            public final List a(ArrayList arrayList) {
                return AbstractC18447og4.k(list, arrayList);
            }
        };
    }

    private static void g(HB3 hb3, ArrayList arrayList, ArrayList arrayList2, boolean z) {
        long jA = hb3.a();
        long j = hb3.j();
        int size = -1;
        int i = 0;
        int i2 = -1;
        while (i < arrayList.size()) {
            HB3 hb32 = (HB3) arrayList.get(i);
            if (hb32.a() != jA) {
                if (size < 0 && j > hb32.j()) {
                    arrayList.add(i, hb3);
                    int i3 = i;
                    i++;
                    size = i3;
                }
                if (size >= 0 && i2 >= 0) {
                    break;
                }
            } else {
                if (z) {
                    return;
                }
                arrayList.remove(i);
                i2 = size >= 0 ? i - 1 : i;
                i--;
            }
            i++;
        }
        if (size < 0) {
            size = arrayList.size();
            arrayList.add(arrayList.size(), hb3);
        }
        if (size == i2) {
            arrayList2.add(C20603sI0.l(size, hb3));
        } else if (i2 < 0) {
            arrayList2.add(C20603sI0.a(size, hb3));
        } else {
            arrayList2.add(C20603sI0.l(i2, hb3));
            arrayList2.add(C20603sI0.i(i2, size));
        }
    }

    private static void h(List list, ArrayList arrayList, ArrayList arrayList2, boolean z) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            g((HB3) it.next(), arrayList, arrayList2, z);
        }
    }

    public static InterfaceC16674lg4 i() {
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List j(List list, ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        h(list, arrayList, arrayList2, true);
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List k(List list, ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        h(list, arrayList, arrayList2, false);
        return arrayList2;
    }

    public static InterfaceC16674lg4 l(long j) {
        return m(new long[]{j});
    }

    public static InterfaceC16674lg4 m(long[] jArr) {
        return new b(jArr);
    }

    public static InterfaceC16674lg4 n(List list) {
        return new a(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void o(List list, ArrayList arrayList, ArrayList arrayList2) {
        int i = 0;
        while (i < arrayList.size()) {
            long jA = ((HB3) arrayList.get(i)).a();
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    arrayList2.add(C20603sI0.j(i));
                    arrayList.remove(i);
                    i--;
                    break;
                } else if (((HB3) it.next()).a() == jA) {
                    break;
                }
            }
            i++;
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            g((HB3) it2.next(), arrayList, arrayList2, false);
        }
    }
}
