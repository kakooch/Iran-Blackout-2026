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

/* renamed from: ir.nasim.ns6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C17978ns6 implements Z64 {
    private final Context a;
    private final int b;
    private final GI7 c;
    private final MessagingStruct$ServiceEx.b d;

    public C17978ns6(Context context, int i, GI7 gi7) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(gi7, "userNamePlaceHolderManager");
        this.a = context;
        this.b = i;
        this.c = gi7;
        this.d = MessagingStruct$ServiceEx.b.SERVICE_EX_USER_KICKED;
    }

    private final DialogLastMessage.Text f(final int i, final ExPeerType exPeerType, final int i2, final MessageState messageState) {
        return (DialogLastMessage.Text) this.c.b(new UA2() { // from class: ir.nasim.ms6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C17978ns6.g(i, this, exPeerType, i2, messageState, (GI7.a) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DialogLastMessage.Text g(int i, C17978ns6 c17978ns6, ExPeerType exPeerType, int i2, MessageState messageState, GI7.a aVar) {
        String string;
        AbstractC13042fc3.i(c17978ns6, "this$0");
        AbstractC13042fc3.i(exPeerType, "$exPeerType");
        AbstractC13042fc3.i(messageState, "$state");
        AbstractC13042fc3.i(aVar, "$this$withPlaceHolders");
        if (i == c17978ns6.b) {
            string = c17978ns6.a.getString(exPeerType == ExPeerType.GROUP ? AbstractC12217eE5.service_holder_group_member_kicked_you : AbstractC12217eE5.service_holder_channel_member_kicked_you, aVar.d(i2, true));
        } else {
            string = c17978ns6.a.getString(exPeerType == ExPeerType.GROUP ? AbstractC12217eE5.service_holder_group_member_kicked : AbstractC12217eE5.service_holder_channel_member_kicked, aVar.d(i, true), GI7.a.e(aVar, i2, false, 2, null));
        }
        String str = string;
        AbstractC13042fc3.f(str);
        return new DialogLastMessage.Text(str, (List) null, (EnumC22968w74) null, (String) null, i2 == c17978ns6.b, i2, messageState, aVar.b(), (MessagingStruct$ServiceEx.b) null, 270, (ED1) null);
    }

    @Override // ir.nasim.Z64
    public DialogLastMessage b(MessagingStruct$Message messagingStruct$Message, int i, ExPeerType exPeerType, MessageState messageState) {
        AbstractC13042fc3.i(messagingStruct$Message, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(messageState, "state");
        return f(messagingStruct$Message.getServiceMessage().getExt().getServiceExUserKicked().getKickedUid(), exPeerType, i, messageState);
    }

    @Override // ir.nasim.Z64
    public DialogLastMessage c(AbstractC17457n0 abstractC17457n0, int i, ExPeerType exPeerType, MessageState messageState) {
        AbstractC13042fc3.i(abstractC17457n0, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(messageState, "state");
        return f(((C3395Ar6) abstractC17457n0).c(), exPeerType, i, messageState);
    }

    @Override // ir.nasim.Z64
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public MessagingStruct$ServiceEx.b a() {
        return this.d;
    }
}
