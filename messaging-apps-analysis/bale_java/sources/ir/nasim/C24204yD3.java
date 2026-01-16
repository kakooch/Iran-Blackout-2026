package ir.nasim;

import ai.bale.proto.MessagingStruct$Message;
import android.content.Context;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.database.dailogLists.DialogLastMessage;
import ir.nasim.database.dailogLists.MessageState;

/* renamed from: ir.nasim.yD3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24204yD3 implements Z64 {
    private final Context a;
    private final int b;
    private final MessagingStruct$Message.b c;

    public C24204yD3(Context context, int i) {
        AbstractC13042fc3.i(context, "context");
        this.a = context;
        this.b = i;
        this.c = MessagingStruct$Message.b.LIVE_MESSAGE;
    }

    private final DialogLastMessage e(String str, int i, MessageState messageState) {
        if (str == null) {
            str = this.a.getString(AbstractC12217eE5.message_holder_content_live);
            AbstractC13042fc3.h(str, "getString(...)");
        }
        return new DialogLastMessage.Live(str, i == this.b, i, messageState);
    }

    @Override // ir.nasim.Z64
    public DialogLastMessage b(MessagingStruct$Message messagingStruct$Message, int i, ExPeerType exPeerType, MessageState messageState) {
        AbstractC13042fc3.i(messagingStruct$Message, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(messageState, "state");
        return e(messagingStruct$Message.getLiveMessage().getMedia().getCaption().getText(), i, messageState);
    }

    @Override // ir.nasim.Z64
    public DialogLastMessage c(AbstractC17457n0 abstractC17457n0, int i, ExPeerType exPeerType, MessageState messageState) {
        AbstractC13042fc3.i(abstractC17457n0, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(messageState, "state");
        return e(((LC3) abstractC17457n0).u().t().v(), i, messageState);
    }

    @Override // ir.nasim.Z64
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public MessagingStruct$Message.b a() {
        return this.c;
    }
}
