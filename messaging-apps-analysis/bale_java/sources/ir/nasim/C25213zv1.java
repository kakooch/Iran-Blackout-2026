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

/* renamed from: ir.nasim.zv1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C25213zv1 implements Z64 {
    private final Context a;
    private final GI7 b;
    private final int c;
    private final MessagingStruct$Message.b d;

    public C25213zv1(Context context, GI7 gi7, int i) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(gi7, "userNamePlaceHolderManager");
        this.a = context;
        this.b = gi7;
        this.c = i;
        this.d = MessagingStruct$Message.b.CROWD_FUNDING_MESSAGE;
    }

    private final DialogLastMessage.Text f(final int i, final ExPeerType exPeerType, final MessageState messageState) {
        return (DialogLastMessage.Text) this.b.b(new UA2() { // from class: ir.nasim.yv1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C25213zv1.g(this.a, i, exPeerType, messageState, (GI7.a) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DialogLastMessage.Text g(C25213zv1 c25213zv1, int i, ExPeerType exPeerType, MessageState messageState, GI7.a aVar) {
        AbstractC13042fc3.i(c25213zv1, "this$0");
        AbstractC13042fc3.i(exPeerType, "$exPeerType");
        AbstractC13042fc3.i(messageState, "$state");
        AbstractC13042fc3.i(aVar, "$this$withPlaceHolders");
        String string = c25213zv1.a.getString(FD5.last_message_service_crowdfunding);
        AbstractC13042fc3.h(string, "getString(...)");
        return new DialogLastMessage.Text(string, (List) null, (EnumC22968w74) null, aVar.c(i, exPeerType), i == c25213zv1.c, i, messageState, aVar.b(), (MessagingStruct$ServiceEx.b) null, 262, (ED1) null);
    }

    @Override // ir.nasim.Z64
    public DialogLastMessage b(MessagingStruct$Message messagingStruct$Message, int i, ExPeerType exPeerType, MessageState messageState) {
        AbstractC13042fc3.i(messagingStruct$Message, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(messageState, "state");
        return f(i, exPeerType, messageState);
    }

    @Override // ir.nasim.Z64
    public DialogLastMessage c(AbstractC17457n0 abstractC17457n0, int i, ExPeerType exPeerType, MessageState messageState) {
        AbstractC13042fc3.i(abstractC17457n0, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(messageState, "state");
        return f(i, exPeerType, messageState);
    }

    @Override // ir.nasim.Z64
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public MessagingStruct$Message.b a() {
        return this.d;
    }
}
