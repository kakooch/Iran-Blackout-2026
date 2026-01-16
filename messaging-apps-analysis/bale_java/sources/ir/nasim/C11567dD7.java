package ir.nasim;

import ai.bale.proto.MessagingOuterClass$UpdateChatGroupsChanged;
import ai.bale.proto.MessagingStruct$DialogGroup;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.dD7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C11567dD7 implements InterfaceC14123hO3 {
    private final C3442Ax a;

    public C11567dD7(C3442Ax c3442Ax) {
        AbstractC13042fc3.i(c3442Ax, "apiDialogGroupMapper");
        this.a = c3442Ax;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C10803cD7 a(MessagingOuterClass$UpdateChatGroupsChanged messagingOuterClass$UpdateChatGroupsChanged) {
        AbstractC13042fc3.i(messagingOuterClass$UpdateChatGroupsChanged, "input");
        List<MessagingStruct$DialogGroup> dialogsList = messagingOuterClass$UpdateChatGroupsChanged.getDialogsList();
        AbstractC13042fc3.h(dialogsList, "getDialogsList(...)");
        List<MessagingStruct$DialogGroup> list = dialogsList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (MessagingStruct$DialogGroup messagingStruct$DialogGroup : list) {
            C3442Ax c3442Ax = this.a;
            AbstractC13042fc3.f(messagingStruct$DialogGroup);
            arrayList.add(c3442Ax.a(messagingStruct$DialogGroup));
        }
        return new C10803cD7(arrayList);
    }
}
