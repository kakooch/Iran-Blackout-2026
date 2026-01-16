package ir.nasim;

import ai.bale.proto.MessagingStruct$MessageId;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class R64 implements SB3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public List a(List list) {
        AbstractC13042fc3.i(list, "input");
        List<Q64> list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        for (Q64 q64 : list2) {
            arrayList.add((MessagingStruct$MessageId) MessagingStruct$MessageId.newBuilder().B(q64.i()).A(q64.h()).a());
        }
        return arrayList;
    }
}
