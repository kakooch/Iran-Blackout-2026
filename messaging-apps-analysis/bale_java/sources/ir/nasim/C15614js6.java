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

/* renamed from: ir.nasim.js6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15614js6 implements Z64 {
    public static final a e = new a(null);
    public static final int f = 8;
    private final Context a;
    private final int b;
    private final GI7 c;
    private final MessagingStruct$ServiceEx.b d;

    /* renamed from: ir.nasim.js6$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.js6$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ExPeerType.values().length];
            try {
                iArr[ExPeerType.GROUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ExPeerType.CHANNEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    public C15614js6(Context context, int i, GI7 gi7) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(gi7, "placeHolderManager");
        this.a = context;
        this.b = i;
        this.c = gi7;
        this.d = MessagingStruct$ServiceEx.b.SERVICE_EX_USER_INVITED;
    }

    private final DialogLastMessage.Text h(final int i) {
        return (DialogLastMessage.Text) this.c.b(new UA2() { // from class: ir.nasim.hs6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C15614js6.i(i, this, (GI7.a) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DialogLastMessage.Text i(int i, C15614js6 c15614js6, GI7.a aVar) {
        AbstractC13042fc3.i(c15614js6, "this$0");
        AbstractC13042fc3.i(aVar, "$this$withPlaceHolders");
        String string = i == c15614js6.b ? c15614js6.a.getString(AbstractC12217eE5.service_holder_channel_member_invited) : c15614js6.a.getString(FD5.service_holder_channel_member_invited_by_me, GI7.a.e(aVar, i, false, 2, null));
        AbstractC13042fc3.f(string);
        return new DialogLastMessage.Text(string, (List) null, (EnumC22968w74) null, (String) null, false, 0, (MessageState) null, aVar.b(), (MessagingStruct$ServiceEx.b) null, 382, (ED1) null);
    }

    private final DialogLastMessage.Text j(final int i, final int i2) {
        return (DialogLastMessage.Text) this.c.b(new UA2() { // from class: ir.nasim.is6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C15614js6.k(i, this, i2, (GI7.a) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DialogLastMessage.Text k(int i, C15614js6 c15614js6, int i2, GI7.a aVar) {
        AbstractC13042fc3.i(c15614js6, "this$0");
        AbstractC13042fc3.i(aVar, "$this$withPlaceHolders");
        String string = i == c15614js6.b ? c15614js6.a.getString(FD5.you_added_to_group_by_user, GI7.a.e(aVar, i2, false, 2, null)) : c15614js6.a.getString(FD5.added_to_group_by_member, GI7.a.e(aVar, i, false, 2, null), GI7.a.e(aVar, i2, false, 2, null));
        AbstractC13042fc3.f(string);
        return new DialogLastMessage.Text(string, (List) null, (EnumC22968w74) null, (String) null, false, 0, (MessageState) null, aVar.b(), (MessagingStruct$ServiceEx.b) null, 382, (ED1) null);
    }

    private final DialogLastMessage.Text l(final int i, final ExPeerType exPeerType) {
        return (DialogLastMessage.Text) this.c.b(new UA2() { // from class: ir.nasim.gs6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C15614js6.m(exPeerType, i, this, (GI7.a) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DialogLastMessage.Text m(ExPeerType exPeerType, int i, C15614js6 c15614js6, GI7.a aVar) {
        AbstractC13042fc3.i(exPeerType, "$exPeerType");
        AbstractC13042fc3.i(c15614js6, "this$0");
        AbstractC13042fc3.i(aVar, "$this$withPlaceHolders");
        int i2 = b.a[exPeerType.ordinal()];
        String string = i2 != 1 ? i2 != 2 ? c15614js6.a.getString(FD5.message_holder_content_template) : c15614js6.a.getString(FD5.service_holder_channel_member_joined) : i == c15614js6.b ? c15614js6.a.getString(FD5.you_joined_to_group_via_link) : AbstractC20655sN7.c(c15614js6.a, FD5.service_holder_group_member_joined, GI7.a.e(aVar, i, false, 2, null));
        AbstractC13042fc3.f(string);
        return new DialogLastMessage.Text(string, (List) null, (EnumC22968w74) null, (String) null, false, 0, (MessageState) null, aVar.b(), (MessagingStruct$ServiceEx.b) null, 382, (ED1) null);
    }

    private final DialogLastMessage.Text n(int i, int i2, ExPeerType exPeerType) {
        return i2 == 0 ? l(i, exPeerType) : exPeerType == ExPeerType.GROUP ? j(i, i2) : h(i);
    }

    @Override // ir.nasim.Z64
    public DialogLastMessage b(MessagingStruct$Message messagingStruct$Message, int i, ExPeerType exPeerType, MessageState messageState) {
        AbstractC13042fc3.i(messagingStruct$Message, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(messageState, "state");
        return DialogLastMessage.Text.copy$default(n(messagingStruct$Message.getServiceMessage().getExt().getServiceExUserInvited().getInvitedUid(), i, exPeerType), null, null, null, null, i == this.b, i, messageState, null, null, 399, null);
    }

    @Override // ir.nasim.Z64
    public DialogLastMessage c(AbstractC17457n0 abstractC17457n0, int i, ExPeerType exPeerType, MessageState messageState) {
        AbstractC13042fc3.i(abstractC17457n0, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(messageState, "state");
        return DialogLastMessage.Text.copy$default(n(((C24584yr6) abstractC17457n0).c(), i, exPeerType), null, null, null, null, i == this.b, i, messageState, null, null, 399, null);
    }

    @Override // ir.nasim.Z64
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public MessagingStruct$ServiceEx.b a() {
        return this.d;
    }
}
