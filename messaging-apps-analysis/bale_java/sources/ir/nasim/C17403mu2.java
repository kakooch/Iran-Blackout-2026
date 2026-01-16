package ir.nasim;

import ir.nasim.C4593Fu2;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.mu2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C17403mu2 {
    public final List a(List list, C4593Fu2 c4593Fu2, int i) {
        ArrayList arrayList = new ArrayList(list.size());
        List list2 = list;
        int size = list2.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            InterfaceC8154Ut2 interfaceC8154Ut2 = (InterfaceC8154Ut2) obj;
            if (AbstractC13042fc3.d(interfaceC8154Ut2.b(), c4593Fu2) && C3418Au2.f(interfaceC8154Ut2.c(), i)) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(list.size());
        int size2 = list2.size();
        for (int i4 = 0; i4 < size2; i4++) {
            Object obj2 = list.get(i4);
            if (C3418Au2.f(((InterfaceC8154Ut2) obj2).c(), i)) {
                arrayList2.add(obj2);
            }
        }
        if (!arrayList2.isEmpty()) {
            list = arrayList2;
        }
        List list3 = list;
        C4593Fu2.a aVar = C4593Fu2.b;
        C4593Fu2 c4593Fu22 = null;
        if (c4593Fu2.compareTo(aVar.f()) < 0) {
            List list4 = list3;
            int size3 = list4.size();
            C4593Fu2 c4593Fu23 = null;
            int i5 = 0;
            while (true) {
                if (i5 >= size3) {
                    break;
                }
                C4593Fu2 c4593Fu2B = ((InterfaceC8154Ut2) list3.get(i5)).b();
                if (c4593Fu2B.compareTo(c4593Fu2) >= 0) {
                    if (c4593Fu2B.compareTo(c4593Fu2) <= 0) {
                        c4593Fu22 = c4593Fu2B;
                        c4593Fu23 = c4593Fu22;
                        break;
                    }
                    if (c4593Fu23 == null || c4593Fu2B.compareTo(c4593Fu23) < 0) {
                        c4593Fu23 = c4593Fu2B;
                    }
                } else if (c4593Fu22 == null || c4593Fu2B.compareTo(c4593Fu22) > 0) {
                    c4593Fu22 = c4593Fu2B;
                }
                i5++;
            }
            if (c4593Fu22 == null) {
                c4593Fu22 = c4593Fu23;
            }
            ArrayList arrayList3 = new ArrayList(list3.size());
            int size4 = list4.size();
            while (i2 < size4) {
                Object obj3 = list3.get(i2);
                if (AbstractC13042fc3.d(((InterfaceC8154Ut2) obj3).b(), c4593Fu22)) {
                    arrayList3.add(obj3);
                }
                i2++;
            }
            return arrayList3;
        }
        if (c4593Fu2.compareTo(aVar.g()) > 0) {
            List list5 = list3;
            int size5 = list5.size();
            C4593Fu2 c4593Fu24 = null;
            int i6 = 0;
            while (true) {
                if (i6 >= size5) {
                    break;
                }
                C4593Fu2 c4593Fu2B2 = ((InterfaceC8154Ut2) list3.get(i6)).b();
                if (c4593Fu2B2.compareTo(c4593Fu2) >= 0) {
                    if (c4593Fu2B2.compareTo(c4593Fu2) <= 0) {
                        c4593Fu22 = c4593Fu2B2;
                        c4593Fu24 = c4593Fu22;
                        break;
                    }
                    if (c4593Fu24 == null || c4593Fu2B2.compareTo(c4593Fu24) < 0) {
                        c4593Fu24 = c4593Fu2B2;
                    }
                } else if (c4593Fu22 == null || c4593Fu2B2.compareTo(c4593Fu22) > 0) {
                    c4593Fu22 = c4593Fu2B2;
                }
                i6++;
            }
            if (c4593Fu24 != null) {
                c4593Fu22 = c4593Fu24;
            }
            ArrayList arrayList4 = new ArrayList(list3.size());
            int size6 = list5.size();
            while (i2 < size6) {
                Object obj4 = list3.get(i2);
                if (AbstractC13042fc3.d(((InterfaceC8154Ut2) obj4).b(), c4593Fu22)) {
                    arrayList4.add(obj4);
                }
                i2++;
            }
            return arrayList4;
        }
        C4593Fu2 c4593Fu2G = aVar.g();
        List list6 = list3;
        int size7 = list6.size();
        C4593Fu2 c4593Fu25 = null;
        C4593Fu2 c4593Fu26 = null;
        int i7 = 0;
        while (true) {
            if (i7 >= size7) {
                break;
            }
            C4593Fu2 c4593Fu2B3 = ((InterfaceC8154Ut2) list3.get(i7)).b();
            if (c4593Fu2G == null || c4593Fu2B3.compareTo(c4593Fu2G) <= 0) {
                if (c4593Fu2B3.compareTo(c4593Fu2) >= 0) {
                    if (c4593Fu2B3.compareTo(c4593Fu2) <= 0) {
                        c4593Fu25 = c4593Fu2B3;
                        c4593Fu26 = c4593Fu25;
                        break;
                    }
                    if (c4593Fu26 == null || c4593Fu2B3.compareTo(c4593Fu26) < 0) {
                        c4593Fu26 = c4593Fu2B3;
                    }
                } else if (c4593Fu25 == null || c4593Fu2B3.compareTo(c4593Fu25) > 0) {
                    c4593Fu25 = c4593Fu2B3;
                }
            }
            i7++;
        }
        if (c4593Fu26 != null) {
            c4593Fu25 = c4593Fu26;
        }
        ArrayList arrayList5 = new ArrayList(list3.size());
        int size8 = list6.size();
        for (int i8 = 0; i8 < size8; i8++) {
            Object obj5 = list3.get(i8);
            if (AbstractC13042fc3.d(((InterfaceC8154Ut2) obj5).b(), c4593Fu25)) {
                arrayList5.add(obj5);
            }
        }
        if (!arrayList5.isEmpty()) {
            return arrayList5;
        }
        C4593Fu2 c4593Fu2G2 = C4593Fu2.b.g();
        int size9 = list6.size();
        C4593Fu2 c4593Fu27 = null;
        int i9 = 0;
        while (true) {
            if (i9 >= size9) {
                break;
            }
            C4593Fu2 c4593Fu2B4 = ((InterfaceC8154Ut2) list3.get(i9)).b();
            if (c4593Fu2G2 == null || c4593Fu2B4.compareTo(c4593Fu2G2) >= 0) {
                if (c4593Fu2B4.compareTo(c4593Fu2) >= 0) {
                    if (c4593Fu2B4.compareTo(c4593Fu2) <= 0) {
                        c4593Fu22 = c4593Fu2B4;
                        c4593Fu27 = c4593Fu22;
                        break;
                    }
                    if (c4593Fu27 == null || c4593Fu2B4.compareTo(c4593Fu27) < 0) {
                        c4593Fu27 = c4593Fu2B4;
                    }
                } else if (c4593Fu22 == null || c4593Fu2B4.compareTo(c4593Fu22) > 0) {
                    c4593Fu22 = c4593Fu2B4;
                }
            }
            i9++;
        }
        if (c4593Fu27 != null) {
            c4593Fu22 = c4593Fu27;
        }
        ArrayList arrayList6 = new ArrayList(list3.size());
        int size10 = list6.size();
        while (i2 < size10) {
            Object obj6 = list3.get(i2);
            if (AbstractC13042fc3.d(((InterfaceC8154Ut2) obj6).b(), c4593Fu22)) {
                arrayList6.add(obj6);
            }
            i2++;
        }
        return arrayList6;
    }
}
