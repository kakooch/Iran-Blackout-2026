package ir.nasim;

import ai.bale.proto.MessagingStruct$MessagesViews;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public final class T84 implements SB3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public List a(List list) {
        AbstractC13042fc3.i(list, "input");
        List<MessagingStruct$MessagesViews> list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        for (MessagingStruct$MessagesViews messagingStruct$MessagesViews : list2) {
            arrayList.add(new C23807xY7(messagingStruct$MessagesViews.getMId().getRid(), messagingStruct$MessagesViews.getMId().getDate(), messagingStruct$MessagesViews.getViews().getValue()));
        }
        return arrayList;
    }
}
