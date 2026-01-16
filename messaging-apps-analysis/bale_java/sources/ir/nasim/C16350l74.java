package ir.nasim;

import ai.bale.proto.MessagingStruct$MessageReaction;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.l74, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16350l74 implements SB3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public List a(List list) {
        AbstractC13042fc3.i(list, "input");
        List<MessagingStruct$MessageReaction> list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        for (MessagingStruct$MessageReaction messagingStruct$MessageReaction : list2) {
            String code = messagingStruct$MessageReaction.getCode();
            AbstractC13042fc3.h(code, "getCode(...)");
            List<Integer> usersList = messagingStruct$MessageReaction.getUsersList();
            AbstractC13042fc3.h(usersList, "getUsersList(...)");
            arrayList.add(new GG5(code, usersList, messagingStruct$MessageReaction.getCardinality().getValue()));
        }
        return arrayList;
    }
}
