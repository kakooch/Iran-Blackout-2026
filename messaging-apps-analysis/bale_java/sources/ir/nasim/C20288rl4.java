package ir.nasim;

import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* renamed from: ir.nasim.rl4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C20288rl4 implements BI5 {
    private Map a;
    private BI5[] b;

    private X06 b(C6338Ne0 c6338Ne0) throws NotFoundException {
        BI5[] bi5Arr = this.b;
        if (bi5Arr != null) {
            for (BI5 bi5 : bi5Arr) {
                try {
                    return bi5.a(c6338Ne0, this.a);
                } catch (ReaderException unused) {
                }
            }
        }
        throw NotFoundException.a();
    }

    @Override // ir.nasim.BI5
    public X06 a(C6338Ne0 c6338Ne0, Map map) {
        d(map);
        return b(c6338Ne0);
    }

    public X06 c(C6338Ne0 c6338Ne0) {
        if (this.b == null) {
            d(null);
        }
        return b(c6338Ne0);
    }

    public void d(Map map) {
        this.a = map;
        boolean z = map != null && map.containsKey(EnumC19932rB1.TRY_HARDER);
        Collection collection = map == null ? null : (Collection) map.get(EnumC19932rB1.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            boolean z2 = collection.contains(EnumC9549a90.UPC_A) || collection.contains(EnumC9549a90.UPC_E) || collection.contains(EnumC9549a90.EAN_13) || collection.contains(EnumC9549a90.EAN_8) || collection.contains(EnumC9549a90.CODABAR) || collection.contains(EnumC9549a90.CODE_39) || collection.contains(EnumC9549a90.CODE_93) || collection.contains(EnumC9549a90.CODE_128) || collection.contains(EnumC9549a90.ITF) || collection.contains(EnumC9549a90.RSS_14) || collection.contains(EnumC9549a90.RSS_EXPANDED);
            if (z2 && !z) {
                arrayList.add(new C19679ql4(map));
            }
            if (collection.contains(EnumC9549a90.QR_CODE)) {
                arrayList.add(new C22293uz5());
            }
            if (collection.contains(EnumC9549a90.DATA_MATRIX)) {
                arrayList.add(new C10660bz1());
            }
            if (collection.contains(EnumC9549a90.AZTEC)) {
                arrayList.add(new GV());
            }
            if (collection.contains(EnumC9549a90.PDF_417)) {
                arrayList.add(new DO4());
            }
            if (collection.contains(EnumC9549a90.MAXICODE)) {
                arrayList.add(new XV3());
            }
            if (z2 && z) {
                arrayList.add(new C19679ql4(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (!z) {
                arrayList.add(new C19679ql4(map));
            }
            arrayList.add(new C22293uz5());
            arrayList.add(new C10660bz1());
            arrayList.add(new GV());
            arrayList.add(new DO4());
            arrayList.add(new XV3());
            if (z) {
                arrayList.add(new C19679ql4(map));
            }
        }
        this.b = (BI5[]) arrayList.toArray(new BI5[arrayList.size()]);
    }

    @Override // ir.nasim.BI5
    public void reset() {
        BI5[] bi5Arr = this.b;
        if (bi5Arr != null) {
            for (BI5 bi5 : bi5Arr) {
                bi5.reset();
            }
        }
    }
}
