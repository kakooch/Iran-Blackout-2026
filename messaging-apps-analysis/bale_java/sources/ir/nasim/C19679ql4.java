package ir.nasim;

import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* renamed from: ir.nasim.ql4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C19679ql4 extends MK4 {
    private final MK4[] a;

    public C19679ql4(Map map) {
        Collection collection = map == null ? null : (Collection) map.get(EnumC19932rB1.POSSIBLE_FORMATS);
        boolean z = (map == null || map.get(EnumC19932rB1.ASSUME_CODE_39_CHECK_DIGIT) == null) ? false : true;
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(EnumC9549a90.EAN_13) || collection.contains(EnumC9549a90.UPC_A) || collection.contains(EnumC9549a90.EAN_8) || collection.contains(EnumC9549a90.UPC_E)) {
                arrayList.add(new C20879sl4(map));
            }
            if (collection.contains(EnumC9549a90.CODE_39)) {
                arrayList.add(new C24966zW0(z));
            }
            if (collection.contains(EnumC9549a90.CODE_93)) {
                arrayList.add(new AW0());
            }
            if (collection.contains(EnumC9549a90.CODE_128)) {
                arrayList.add(new C24372yW0());
            }
            if (collection.contains(EnumC9549a90.ITF)) {
                arrayList.add(new C13897h03());
            }
            if (collection.contains(EnumC9549a90.CODABAR)) {
                arrayList.add(new C23782xW0());
            }
            if (collection.contains(EnumC9549a90.RSS_14)) {
                arrayList.add(new C11583dF5());
            }
            if (collection.contains(EnumC9549a90.RSS_EXPANDED)) {
                arrayList.add(new C12226eF5());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new C20879sl4(map));
            arrayList.add(new C24966zW0());
            arrayList.add(new C23782xW0());
            arrayList.add(new AW0());
            arrayList.add(new C24372yW0());
            arrayList.add(new C13897h03());
            arrayList.add(new C11583dF5());
            arrayList.add(new C12226eF5());
        }
        this.a = (MK4[]) arrayList.toArray(new MK4[arrayList.size()]);
    }

    @Override // ir.nasim.MK4
    public X06 b(int i, C3988Df0 c3988Df0, Map map) throws NotFoundException {
        for (MK4 mk4 : this.a) {
            try {
                return mk4.b(i, c3988Df0, map);
            } catch (ReaderException unused) {
            }
        }
        throw NotFoundException.a();
    }

    @Override // ir.nasim.MK4, ir.nasim.BI5
    public void reset() {
        for (MK4 mk4 : this.a) {
            mk4.reset();
        }
    }
}
