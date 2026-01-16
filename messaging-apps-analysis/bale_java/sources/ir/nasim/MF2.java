package ir.nasim;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public abstract class MF2 {
    public static C12401eZ0 a(List list) {
        C12401eZ0 c12401eZ0 = new C12401eZ0();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AbstractC20556sC7 abstractC20556sC7 = (AbstractC20556sC7) it.next();
            if (abstractC20556sC7 instanceof CE7) {
                c12401eZ0.g((CE7) abstractC20556sC7);
            } else if (abstractC20556sC7 instanceof QE7) {
                QE7 qe7 = (QE7) abstractC20556sC7;
                qe7.a();
                c12401eZ0.h(qe7.a(), qe7.b());
            } else if (abstractC20556sC7 instanceof UE7) {
                UE7 ue7 = (UE7) abstractC20556sC7;
                ue7.a();
                c12401eZ0.j(ue7.a(), ue7.b());
            } else if (abstractC20556sC7 instanceof RE7) {
                RE7 re7 = (RE7) abstractC20556sC7;
                c12401eZ0.i(re7.b(), re7.c(), re7.d() != null ? re7.d().intValue() : 0, re7.a() != null ? re7.a().longValue() : 0L);
            } else {
                c12401eZ0.b().add(abstractC20556sC7);
            }
        }
        return c12401eZ0;
    }
}
