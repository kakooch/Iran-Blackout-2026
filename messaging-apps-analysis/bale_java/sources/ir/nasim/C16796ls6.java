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

/* renamed from: ir.nasim.ls6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16796ls6 implements Z64 {
    private final Context a;
    private final int b;
    private final GI7 c;
    private final MessagingStruct$ServiceEx.b d;

    public C16796ls6(Context context, int i, GI7 gi7) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(gi7, "userNamePlaceHolderManager");
        this.a = context;
        this.b = i;
        this.c = gi7;
        this.d = MessagingStruct$ServiceEx.b.SERVICE_EX_USER_JOINED;
    }

    private final DialogLastMessage.Text f(final int i, final ExPeerType exPeerType, final int i2, final MessageState messageState) {
        return (DialogLastMessage.Text) this.c.b(new UA2() { // from class: ir.nasim.ks6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C16796ls6.g(exPeerType, this, i, i2, messageState, (GI7.a) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DialogLastMessage.Text g(ExPeerType exPeerType, C16796ls6 c16796ls6, int i, int i2, MessageState messageState, GI7.a aVar) {
        String string;
        AbstractC13042fc3.i(exPeerType, "$exPeerType");
        AbstractC13042fc3.i(c16796ls6, "this$0");
        AbstractC13042fc3.i(messageState, "$state");
        AbstractC13042fc3.i(aVar, "$this$withPlaceHolders");
        boolean z = exPeerType == ExPeerType.GROUP;
        String strI = AbstractC20655sN7.i(c16796ls6.a, z, false, 2, null);
        if (i == c16796ls6.b) {
            string = c16796ls6.a.getString(AbstractC12217eE5.service_holder_you_joined_to, strI);
        } else {
            string = c16796ls6.a.getString(z ? AbstractC12217eE5.service_holder_group_member_joined : AbstractC12217eE5.service_holder_channel_member_joined, GI7.a.e(aVar, i, false, 2, null));
        }
        AbstractC13042fc3.f(string);
        return new DialogLastMessage.Text(string, (List) null, (EnumC22968w74) null, (String) null, i2 == c16796ls6.b, i2, messageState, aVar.b(), (MessagingStruct$ServiceEx.b) null, 270, (ED1) null);
    }

    @Override // ir.nasim.Z64
    public DialogLastMessage b(MessagingStruct$Message messagingStruct$Message, int i, ExPeerType exPeerType, MessageState messageState) {
        AbstractC13042fc3.i(messagingStruct$Message, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(messageState, "state");
        return f(i, exPeerType, i, messageState);
    }

    @Override // ir.nasim.Z64
    public DialogLastMessage c(AbstractC17457n0 abstractC17457n0, int i, ExPeerType exPeerType, MessageState messageState) {
        AbstractC13042fc3.i(abstractC17457n0, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(messageState, "state");
        return f(i, exPeerType, i, messageState);
    }

    @Override // ir.nasim.Z64
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public MessagingStruct$ServiceEx.b a() {
        return this.d;
    }
}
