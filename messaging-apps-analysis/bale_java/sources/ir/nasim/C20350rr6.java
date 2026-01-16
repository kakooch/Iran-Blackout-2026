package ir.nasim;

import ai.bale.proto.MessagingStruct$Message;
import ai.bale.proto.MessagingStruct$ServiceEx;
import android.content.Context;
import ir.nasim.GI7;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.database.dailogLists.DialogLastMessage;
import ir.nasim.database.dailogLists.MessageState;
import java.util.List;
import java.util.Set;

/* renamed from: ir.nasim.rr6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C20350rr6 implements Z64 {
    private final Context a;
    private final int b;
    private final GI7 c;
    private final MessagingStruct$ServiceEx.b d;

    public C20350rr6(Context context, int i, GI7 gi7) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(gi7, "userNamePlaceHolderManager");
        this.a = context;
        this.b = i;
        this.c = gi7;
        this.d = MessagingStruct$ServiceEx.b.SERVICE_EX_GROUP_CALL_STARTED;
    }

    private final DialogLastMessage.Text f(final int i, final Integer num, final ExPeerType exPeerType, final MessageState messageState) {
        return (DialogLastMessage.Text) this.c.b(new UA2() { // from class: ir.nasim.qr6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C20350rr6.g(exPeerType, num, this, i, messageState, (GI7.a) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DialogLastMessage.Text g(ExPeerType exPeerType, Integer num, C20350rr6 c20350rr6, int i, MessageState messageState, GI7.a aVar) {
        AbstractC13042fc3.i(exPeerType, "$exPeerType");
        AbstractC13042fc3.i(c20350rr6, "this$0");
        AbstractC13042fc3.i(messageState, "$state");
        AbstractC13042fc3.i(aVar, "$this$withPlaceHolders");
        if (exPeerType != ExPeerType.GROUP || num == null) {
            String string = c20350rr6.a.getString(FD5.message_holder_content_template);
            AbstractC13042fc3.h(string, "getString(...)");
            return new DialogLastMessage.Text(string, (List) null, (EnumC22968w74) null, (String) null, num != null && num.intValue() == c20350rr6.b, i, messageState, (Set) null, (MessagingStruct$ServiceEx.b) null, 398, (ED1) null);
        }
        String string2 = num.intValue() == c20350rr6.b ? c20350rr6.a.getString(FD5.group_you_call_started_service_message) : c20350rr6.a.getString(FD5.group_other_call_started_service_message, GI7.a.e(aVar, num.intValue(), false, 2, null));
        AbstractC13042fc3.f(string2);
        return new DialogLastMessage.Text(string2, (List) null, (EnumC22968w74) null, (String) null, i == c20350rr6.b, i, messageState, aVar.b(), (MessagingStruct$ServiceEx.b) null, 270, (ED1) null);
    }

    @Override // ir.nasim.Z64
    public DialogLastMessage b(MessagingStruct$Message messagingStruct$Message, int i, ExPeerType exPeerType, MessageState messageState) {
        AbstractC13042fc3.i(messagingStruct$Message, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(messageState, "state");
        return f(i, Integer.valueOf(messagingStruct$Message.getServiceMessage().getExt().getServiceExGroupCallStarted().getGroupCall().getInitiatorUserId()), exPeerType, messageState);
    }

    @Override // ir.nasim.Z64
    public DialogLastMessage c(AbstractC17457n0 abstractC17457n0, int i, ExPeerType exPeerType, MessageState messageState) {
        AbstractC13042fc3.i(abstractC17457n0, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(messageState, "state");
        return f(i, ((C19150pr6) abstractC17457n0).s(), exPeerType, messageState);
    }

    @Override // ir.nasim.Z64
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public MessagingStruct$ServiceEx.b a() {
        return this.d;
    }
}
