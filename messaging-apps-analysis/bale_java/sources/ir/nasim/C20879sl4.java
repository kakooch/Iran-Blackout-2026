package ir.nasim;

import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* renamed from: ir.nasim.sl4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C20879sl4 extends MK4 {
    private final AbstractC20538sA7[] a;

    public C20879sl4(Map map) {
        Collection collection = map == null ? null : (Collection) map.get(EnumC19932rB1.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(EnumC9549a90.EAN_13)) {
                arrayList.add(new D22());
            } else if (collection.contains(EnumC9549a90.UPC_A)) {
                arrayList.add(new C18156oA7());
            }
            if (collection.contains(EnumC9549a90.EAN_8)) {
                arrayList.add(new E22());
            }
            if (collection.contains(EnumC9549a90.UPC_E)) {
                arrayList.add(new C21141tA7());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new D22());
            arrayList.add(new E22());
            arrayList.add(new C21141tA7());
        }
        this.a = (AbstractC20538sA7[]) arrayList.toArray(new AbstractC20538sA7[arrayList.size()]);
    }

    @Override // ir.nasim.MK4
    public X06 b(int i, C3988Df0 c3988Df0, Map map) throws NotFoundException {
        int[] iArrO = AbstractC20538sA7.o(c3988Df0);
        for (AbstractC20538sA7 abstractC20538sA7 : this.a) {
            try {
                X06 x06L = abstractC20538sA7.l(i, c3988Df0, iArrO, map);
                boolean z = x06L.b() == EnumC9549a90.EAN_13 && x06L.f().charAt(0) == '0';
                Collection collection = map == null ? null : (Collection) map.get(EnumC19932rB1.POSSIBLE_FORMATS);
                boolean z2 = collection == null || collection.contains(EnumC9549a90.UPC_A);
                if (!z || !z2) {
                    return x06L;
                }
                X06 x06 = new X06(x06L.f().substring(1), x06L.c(), x06L.e(), EnumC9549a90.UPC_A);
                x06.g(x06L.d());
                return x06;
            } catch (ReaderException unused) {
            }
        }
        throw NotFoundException.a();
    }

    @Override // ir.nasim.MK4, ir.nasim.BI5
    public void reset() {
        for (AbstractC20538sA7 abstractC20538sA7 : this.a) {
            abstractC20538sA7.reset();
        }
    }
}
