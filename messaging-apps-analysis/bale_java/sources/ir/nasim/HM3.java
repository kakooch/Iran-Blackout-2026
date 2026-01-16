package ir.nasim;

import ai.bale.proto.MessagingStruct$HistoryMessageIdentifier;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class HM3 {
    private List a = AbstractC10360bX0.m();

    public final JM3 a(long j) {
        List list = this.a;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((MessagingStruct$HistoryMessageIdentifier) it.next()).getRandomId() == j) {
                    return JM3.a;
                }
            }
        }
        return JM3.c;
    }

    public final void b(List list) {
        AbstractC13042fc3.i(list, "<set-?>");
        this.a = list;
    }
}
