package androidx.work;

import androidx.work.b;
import ir.nasim.AbstractC18142o93;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class OverwritingInputMerger extends AbstractC18142o93 {
    @Override // ir.nasim.AbstractC18142o93
    public b b(List list) {
        b.a aVar = new b.a();
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            map.putAll(((b) it.next()).k());
        }
        aVar.d(map);
        return aVar.a();
    }
}
