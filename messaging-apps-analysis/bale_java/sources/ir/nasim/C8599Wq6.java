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

/* renamed from: ir.nasim.Wq6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8599Wq6 implements Z64 {
    private final Context a;
    private final int b;
    private final GI7 c;
    private final MessagingStruct$ServiceEx.b d;

    public C8599Wq6(Context context, int i, GI7 gi7) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(gi7, "placeHolderManager");
        this.a = context;
        this.b = i;
        this.c = gi7;
        this.d = MessagingStruct$ServiceEx.b.SERVICE_EX_CHANGED_TITLE;
    }

    private final DialogLastMessage.Text f(final String str, final int i, final MessageState messageState) {
        return (DialogLastMessage.Text) this.c.b(new UA2() { // from class: ir.nasim.Vq6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C8599Wq6.g(i, this, str, messageState, (GI7.a) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DialogLastMessage.Text g(int i, C8599Wq6 c8599Wq6, String str, MessageState messageState, GI7.a aVar) {
        AbstractC13042fc3.i(c8599Wq6, "this$0");
        AbstractC13042fc3.i(str, "$newName");
        AbstractC13042fc3.i(messageState, "$state");
        AbstractC13042fc3.i(aVar, "$this$withPlaceHolders");
        String string = i == c8599Wq6.b ? c8599Wq6.a.getString(FD5.service_holder_group_title_changed_by_me, str) : c8599Wq6.a.getString(FD5.service_holder_group_title_changed_by, GI7.a.e(aVar, i, false, 2, null), str);
        AbstractC13042fc3.f(string);
        return new DialogLastMessage.Text(string, (List) null, (EnumC22968w74) null, (String) null, i == c8599Wq6.b, i, messageState, aVar.b(), (MessagingStruct$ServiceEx.b) null, 270, (ED1) null);
    }

    @Override // ir.nasim.Z64
    public DialogLastMessage b(MessagingStruct$Message messagingStruct$Message, int i, ExPeerType exPeerType, MessageState messageState) {
        AbstractC13042fc3.i(messagingStruct$Message, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(messageState, "state");
        String title = messagingStruct$Message.getServiceMessage().getExt().getServiceExChangedTitle().getTitle();
        AbstractC13042fc3.h(title, "getTitle(...)");
        return f(title, i, messageState);
    }

    @Override // ir.nasim.Z64
    public DialogLastMessage c(AbstractC17457n0 abstractC17457n0, int i, ExPeerType exPeerType, MessageState messageState) {
        AbstractC13042fc3.i(abstractC17457n0, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(messageState, "state");
        return f(((C23404wr6) abstractC17457n0).s(), i, messageState);
    }

    @Override // ir.nasim.Z64
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public MessagingStruct$ServiceEx.b a() {
        return this.d;
    }
}
