package ir.nasim;

import ai.bale.proto.MessagingStruct$Message;
import ai.bale.proto.MessagingStruct$ServiceEx;
import android.content.Context;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.database.dailogLists.DialogLastMessage;
import ir.nasim.database.dailogLists.MessageState;
import java.util.List;
import java.util.Set;

/* renamed from: ir.nasim.v80, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22378v80 implements Z64 {
    private final Context a;
    private final int b;
    private final MessagingStruct$Message.b c;

    public C22378v80(Context context, int i) {
        AbstractC13042fc3.i(context, "context");
        this.a = context;
        this.b = i;
        this.c = MessagingStruct$Message.b.BANNED_MESSAGE;
    }

    private final DialogLastMessage e(int i, MessageState messageState) {
        String string = this.a.getString(AbstractC12217eE5.blocked_message);
        AbstractC13042fc3.h(string, "getString(...)");
        return new DialogLastMessage.Text(string, (List) null, (EnumC22968w74) null, (String) null, i == this.b, i, messageState, (Set) null, (MessagingStruct$ServiceEx.b) null, 398, (ED1) null);
    }

    @Override // ir.nasim.Z64
    public DialogLastMessage b(MessagingStruct$Message messagingStruct$Message, int i, ExPeerType exPeerType, MessageState messageState) {
        AbstractC13042fc3.i(messagingStruct$Message, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(messageState, "state");
        return e(i, messageState);
    }

    @Override // ir.nasim.Z64
    public DialogLastMessage c(AbstractC17457n0 abstractC17457n0, int i, ExPeerType exPeerType, MessageState messageState) {
        AbstractC13042fc3.i(abstractC17457n0, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(messageState, "state");
        return e(i, messageState);
    }

    @Override // ir.nasim.Z64
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public MessagingStruct$Message.b a() {
        return this.c;
    }
}
