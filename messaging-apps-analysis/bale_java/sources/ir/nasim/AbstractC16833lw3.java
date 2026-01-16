package ir.nasim;

import ir.nasim.C4861Gw3;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.lw3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC16833lw3 {
    public static final List a(InterfaceC20397rw3 interfaceC20397rw3, C4861Gw3 c4861Gw3, C15060iw3 c15060iw3) {
        if (!c15060iw3.d() && c4861Gw3.isEmpty()) {
            return AbstractC10360bX0.m();
        }
        ArrayList arrayList = new ArrayList();
        C24411ya3 c24411ya3 = c15060iw3.d() ? new C24411ya3(c15060iw3.c(), Math.min(c15060iw3.b(), interfaceC20397rw3.a() - 1)) : C24411ya3.e.a();
        int size = c4861Gw3.size();
        for (int i = 0; i < size; i++) {
            C4861Gw3.a aVar = (C4861Gw3.a) c4861Gw3.get(i);
            int iA = AbstractC20987sw3.a(interfaceC20397rw3, aVar.getKey(), aVar.getIndex());
            int iO = c24411ya3.o();
            if ((iA > c24411ya3.t() || iO > iA) && iA >= 0 && iA < interfaceC20397rw3.a()) {
                arrayList.add(Integer.valueOf(iA));
            }
        }
        int iO2 = c24411ya3.o();
        int iT = c24411ya3.t();
        if (iO2 <= iT) {
            while (true) {
                arrayList.add(Integer.valueOf(iO2));
                if (iO2 == iT) {
                    break;
                }
                iO2++;
            }
        }
        return arrayList;
    }
}
