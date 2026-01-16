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

/* renamed from: ir.nasim.tr6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21628tr6 implements Z64 {
    private final Context a;
    private final int b;
    private final MessagingStruct$ServiceEx.b c;

    public C21628tr6(Context context, int i) {
        AbstractC13042fc3.i(context, "context");
        this.a = context;
        this.b = i;
        this.c = MessagingStruct$ServiceEx.b.SERVICE_EX_GROUP_CREATED;
    }

    private final DialogLastMessage.Text e(ExPeerType exPeerType, int i, MessageState messageState) {
        Context context = this.a;
        return new DialogLastMessage.Text(AbstractC20655sN7.c(context, AbstractC12217eE5.service_holder_group_created, AbstractC20655sN7.i(context, exPeerType == ExPeerType.GROUP, false, 2, null)), (List) null, (EnumC22968w74) null, (String) null, i == this.b, i, messageState, (Set) null, (MessagingStruct$ServiceEx.b) null, 398, (ED1) null);
    }

    @Override // ir.nasim.Z64
    public DialogLastMessage b(MessagingStruct$Message messagingStruct$Message, int i, ExPeerType exPeerType, MessageState messageState) {
        AbstractC13042fc3.i(messagingStruct$Message, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(messageState, "state");
        return e(exPeerType, i, messageState);
    }

    @Override // ir.nasim.Z64
    public DialogLastMessage c(AbstractC17457n0 abstractC17457n0, int i, ExPeerType exPeerType, MessageState messageState) {
        AbstractC13042fc3.i(abstractC17457n0, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(messageState, "state");
        return e(exPeerType, i, messageState);
    }

    @Override // ir.nasim.Z64
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public MessagingStruct$ServiceEx.b a() {
        return this.c;
    }
}
