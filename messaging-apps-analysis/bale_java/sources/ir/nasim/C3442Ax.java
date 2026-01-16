package ir.nasim;

import ai.bale.proto.MessagingStruct$DialogGroup;
import ai.bale.proto.MessagingStruct$DialogShort;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Ax, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C3442Ax implements InterfaceC14123hO3 {
    private final C3915Cx a;

    public C3442Ax(C3915Cx c3915Cx) {
        AbstractC13042fc3.i(c3915Cx, "apiDialogShortMapper");
        this.a = c3915Cx;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C25229zx a(MessagingStruct$DialogGroup messagingStruct$DialogGroup) {
        AbstractC13042fc3.i(messagingStruct$DialogGroup, "input");
        String title = messagingStruct$DialogGroup.getTitle();
        String key = messagingStruct$DialogGroup.getKey();
        List<MessagingStruct$DialogShort> dialogsList = messagingStruct$DialogGroup.getDialogsList();
        AbstractC13042fc3.h(dialogsList, "getDialogsList(...)");
        List<MessagingStruct$DialogShort> list = dialogsList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (MessagingStruct$DialogShort messagingStruct$DialogShort : list) {
            C3915Cx c3915Cx = this.a;
            AbstractC13042fc3.f(messagingStruct$DialogShort);
            arrayList.add(c3915Cx.a(messagingStruct$DialogShort));
        }
        return new C25229zx(title, key, arrayList);
    }
}
