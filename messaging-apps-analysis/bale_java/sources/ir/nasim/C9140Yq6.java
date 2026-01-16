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

/* renamed from: ir.nasim.Yq6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C9140Yq6 implements Z64 {
    private final Context a;
    private final int b;
    private final GI7 c;
    private final MessagingStruct$ServiceEx.b d;

    public C9140Yq6(Context context, int i, GI7 gi7) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(gi7, "userNamePlaceHolderManager");
        this.a = context;
        this.b = i;
        this.c = gi7;
        this.d = MessagingStruct$ServiceEx.b.SERVICE_EX_CHANGED_TOPIC;
    }

    private final DialogLastMessage f(final String str, final int i, final ExPeerType exPeerType, final int i2, final MessageState messageState) {
        return (DialogLastMessage) this.c.b(new UA2() { // from class: ir.nasim.Xq6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C9140Yq6.g(i, this, exPeerType, str, i2, messageState, (GI7.a) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DialogLastMessage.Text g(int i, C9140Yq6 c9140Yq6, ExPeerType exPeerType, String str, int i2, MessageState messageState, GI7.a aVar) {
        String string;
        AbstractC13042fc3.i(c9140Yq6, "this$0");
        AbstractC13042fc3.i(exPeerType, "$exPeerType");
        AbstractC13042fc3.i(str, "$newTopic");
        AbstractC13042fc3.i(messageState, "$state");
        AbstractC13042fc3.i(aVar, "$this$withPlaceHolders");
        if (i == c9140Yq6.b) {
            Context context = c9140Yq6.a;
            string = context.getString(AbstractC12217eE5.service_holder_group_topic_changed_by_you, AbstractC20655sN7.i(context, exPeerType == ExPeerType.GROUP, false, 2, null), str);
        } else {
            string = c9140Yq6.a.getString(AbstractC12217eE5.service_holder_group_topic_changed, GI7.a.e(aVar, i, false, 2, null), AbstractC20655sN7.i(c9140Yq6.a, exPeerType == ExPeerType.GROUP, false, 2, null), str);
        }
        String str2 = string;
        AbstractC13042fc3.f(str2);
        return new DialogLastMessage.Text(str2, (List) null, (EnumC22968w74) null, (String) null, i2 == c9140Yq6.b, i2, messageState, aVar.b(), (MessagingStruct$ServiceEx.b) null, 270, (ED1) null);
    }

    @Override // ir.nasim.Z64
    public DialogLastMessage b(MessagingStruct$Message messagingStruct$Message, int i, ExPeerType exPeerType, MessageState messageState) {
        AbstractC13042fc3.i(messagingStruct$Message, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(messageState, "state");
        String value = messagingStruct$Message.getServiceMessage().getExt().getServiceExChangedTopic().getTopic().getValue();
        AbstractC13042fc3.h(value, "getValue(...)");
        return f(value, i, exPeerType, i, messageState);
    }

    @Override // ir.nasim.Z64
    public DialogLastMessage c(AbstractC17457n0 abstractC17457n0, int i, ExPeerType exPeerType, MessageState messageState) {
        AbstractC13042fc3.i(abstractC17457n0, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(messageState, "state");
        Object objI = abstractC17457n0.i();
        AbstractC13042fc3.g(objI, "null cannot be cast to non-null type ir.nasim.core.api.ApiServiceMessage");
        VB vbU = ((C23011wC) objI).u();
        AbstractC13042fc3.g(vbU, "null cannot be cast to non-null type ir.nasim.core.api.ApiServiceExChangedTopic");
        String strU = ((C11550dC) vbU).u();
        if (strU == null) {
            strU = "";
        }
        return f(strU, i, exPeerType, i, messageState);
    }

    @Override // ir.nasim.Z64
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public MessagingStruct$ServiceEx.b a() {
        return this.d;
    }
}
