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

/* renamed from: ir.nasim.hr6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14406hr6 implements Z64 {
    private final Context a;
    private final GI7 b;
    private final int c;
    private final MessagingStruct$ServiceEx.b d;

    public C14406hr6(Context context, GI7 gi7, int i) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(gi7, "userNamePlaceHolderManager");
        this.a = context;
        this.b = gi7;
        this.c = i;
        this.d = MessagingStruct$ServiceEx.b.SERVICE_EX_GIFT_PACKET_OPENED_COMPACT;
    }

    private final DialogLastMessage f(final int i, final int i2, final MessageState messageState) {
        return (DialogLastMessage) this.b.b(new UA2() { // from class: ir.nasim.gr6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C14406hr6.g(i, this, i2, messageState, (GI7.a) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DialogLastMessage.Text g(int i, C14406hr6 c14406hr6, int i2, MessageState messageState, GI7.a aVar) {
        String string;
        AbstractC13042fc3.i(c14406hr6, "this$0");
        AbstractC13042fc3.i(messageState, "$state");
        AbstractC13042fc3.i(aVar, "$this$withPlaceHolders");
        if (i == c14406hr6.c) {
            string = i2 > 0 ? c14406hr6.a.getString(AbstractC12217eE5.service_holder_gift_packet_opened_compact_you, String.valueOf(i2)) : c14406hr6.a.getString(AbstractC12217eE5.service_holder_gift_packet_opened_by_you);
        } else {
            String strE = GI7.a.e(aVar, i, false, 2, null);
            string = i2 > 0 ? c14406hr6.a.getString(AbstractC12217eE5.service_holder_gift_packet_opened_compact, strE, String.valueOf(i2)) : c14406hr6.a.getString(AbstractC12217eE5.service_holder_gift_packet_opened, strE);
        }
        AbstractC13042fc3.f(string);
        return new DialogLastMessage.Text(string, (List) null, (EnumC22968w74) null, (String) null, i == c14406hr6.c, i, messageState, aVar.b(), (MessagingStruct$ServiceEx.b) null, 270, (ED1) null);
    }

    @Override // ir.nasim.Z64
    public DialogLastMessage b(MessagingStruct$Message messagingStruct$Message, int i, ExPeerType exPeerType, MessageState messageState) {
        AbstractC13042fc3.i(messagingStruct$Message, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(messageState, "state");
        return f(i, messagingStruct$Message.getServiceMessage().getExt().getServiceExGiftPacketOpenedCompact().getOthersCount(), messageState);
    }

    @Override // ir.nasim.Z64
    public DialogLastMessage c(AbstractC17457n0 abstractC17457n0, int i, ExPeerType exPeerType, MessageState messageState) {
        AbstractC13042fc3.i(abstractC17457n0, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(messageState, "state");
        return f(i, ((C22808vr6) abstractC17457n0).s(), messageState);
    }

    @Override // ir.nasim.Z64
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public MessagingStruct$ServiceEx.b a() {
        return this.d;
    }
}
