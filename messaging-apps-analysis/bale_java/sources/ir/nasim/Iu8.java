package ir.nasim;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
final class Iu8 {
    private final ConcurrentHashMap a = new ConcurrentHashMap(16, 0.75f, 10);
    private final ReferenceQueue b = new ReferenceQueue();

    Iu8() {
    }

    public final List a(Throwable th, boolean z) {
        Reference referencePoll = this.b.poll();
        while (referencePoll != null) {
            this.a.remove(referencePoll);
            referencePoll = this.b.poll();
        }
        List list = (List) this.a.get(new Wu8(th, null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List list2 = (List) this.a.putIfAbsent(new Wu8(th, this.b), vector);
        return list2 == null ? vector : list2;
    }
}
