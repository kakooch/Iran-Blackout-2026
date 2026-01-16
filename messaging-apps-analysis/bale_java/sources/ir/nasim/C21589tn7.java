package ir.nasim;

import ai.bale.proto.MessagingStruct$Message;
import ai.bale.proto.MessagingStruct$ServiceEx;
import android.content.Context;
import ir.nasim.GI7;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.database.dailogLists.DialogLastMessage;
import ir.nasim.database.dailogLists.MessageState;
import org.xbill.DNS.Type;

/* renamed from: ir.nasim.tn7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21589tn7 implements Z64 {
    private final Context a;
    private final GI7 b;
    private final int c;
    private final MessagingStruct$Message.b d;

    public C21589tn7(Context context, GI7 gi7, int i) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(gi7, "userNamePlaceHolderManager");
        this.a = context;
        this.b = gi7;
        this.c = i;
        this.d = MessagingStruct$Message.b.TEXT_MESSAGE;
    }

    private final DialogLastMessage.Text f(final String str, final int i, final ExPeerType exPeerType, final MessageState messageState) {
        return (DialogLastMessage.Text) this.b.b(new UA2() { // from class: ir.nasim.sn7
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C21589tn7.g(str, this, i, exPeerType, messageState, (GI7.a) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DialogLastMessage.Text g(String str, C21589tn7 c21589tn7, int i, ExPeerType exPeerType, MessageState messageState, GI7.a aVar) {
        AbstractC13042fc3.i(c21589tn7, "this$0");
        AbstractC13042fc3.i(exPeerType, "$exPeerType");
        AbstractC13042fc3.i(messageState, "$state");
        AbstractC13042fc3.i(aVar, "$this$withPlaceHolders");
        return new DialogLastMessage.Text(AbstractC24601yt3.a(str, c21589tn7.a), AbstractC10360bX0.m(), (EnumC22968w74) null, aVar.c(i, exPeerType), i == c21589tn7.c, i, messageState, aVar.b(), (MessagingStruct$ServiceEx.b) null, Type.AMTRELAY, (ED1) null);
    }

    @Override // ir.nasim.Z64
    public DialogLastMessage b(MessagingStruct$Message messagingStruct$Message, int i, ExPeerType exPeerType, MessageState messageState) {
        AbstractC13042fc3.i(messagingStruct$Message, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(messageState, "state");
        return f(messagingStruct$Message.getTextMessage().getText(), i, exPeerType, messageState);
    }

    @Override // ir.nasim.Z64
    public DialogLastMessage c(AbstractC17457n0 abstractC17457n0, int i, ExPeerType exPeerType, MessageState messageState) {
        AbstractC13042fc3.i(abstractC17457n0, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(messageState, "state");
        C23345wl7 c23345wl7L = abstractC17457n0.l();
        return f(c23345wl7L != null ? c23345wl7L.v() : null, i, exPeerType, messageState);
    }

    @Override // ir.nasim.Z64
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public MessagingStruct$Message.b a() {
        return this.d;
    }
}
