package ir.nasim;

import ai.bale.proto.MessagingStruct$Message;
import ai.bale.proto.MessagingStruct$ServiceEx;
import android.content.Context;
import ir.nasim.C9475a16;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.database.dailogLists.DialogLastMessage;
import ir.nasim.database.dailogLists.MessageState;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Qk3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7133Qk3 implements Z64 {
    private final Context a;
    private final int b;
    private final MessagingStruct$Message.b c;
    private final AbstractC11279ck3 d;

    /* renamed from: ir.nasim.Qk3$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC6655Ok3.values().length];
            try {
                iArr[EnumC6655Ok3.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC6655Ok3.c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC6655Ok3.d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    public C7133Qk3(Context context, int i) {
        AbstractC13042fc3.i(context, "context");
        this.a = context;
        this.b = i;
        this.c = MessagingStruct$Message.b.JSON_MESSAGE;
        this.d = AbstractC4987Hk3.b(null, new UA2() { // from class: ir.nasim.Pk3
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C7133Qk3.f((C14333hk3) obj);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(C14333hk3 c14333hk3) {
        AbstractC13042fc3.i(c14333hk3, "$this$Json");
        c14333hk3.e(AbstractC19668qk3.a());
        return C19938rB7.a;
    }

    private final DialogLastMessage g(EnumC6655Ok3 enumC6655Ok3, int i, MessageState messageState) {
        String string;
        int i2 = enumC6655Ok3 == null ? -1 : a.a[enumC6655Ok3.ordinal()];
        if (i2 == -1) {
            string = this.a.getString(FD5.message_holder_content_template);
        } else if (i2 == 1) {
            string = this.a.getString(FD5.last_message_location);
        } else if (i2 != 2) {
            if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            string = this.a.getString(FD5.message_holder_content_template);
        } else {
            string = this.a.getString(FD5.last_message_contact);
        }
        String str = string;
        AbstractC13042fc3.f(str);
        return new DialogLastMessage.Text(str, (List) null, (EnumC22968w74) null, (String) null, i == this.b, i, messageState, (Set) null, (MessagingStruct$ServiceEx.b) null, 398, (ED1) null);
    }

    private final AbstractC5923Lk3 h(String str) {
        try {
            C9475a16.a aVar = C9475a16.b;
            return (AbstractC5923Lk3) this.d.b(AbstractC5923Lk3.INSTANCE.serializer(), str);
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            Object objB = C9475a16.b(AbstractC10685c16.a(th));
            if (C9475a16.g(objB)) {
                objB = null;
            }
            return (AbstractC5923Lk3) objB;
        }
    }

    @Override // ir.nasim.Z64
    public DialogLastMessage b(MessagingStruct$Message messagingStruct$Message, int i, ExPeerType exPeerType, MessageState messageState) {
        AbstractC13042fc3.i(messagingStruct$Message, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(messageState, "state");
        String rawJson = messagingStruct$Message.getJsonMessage().getRawJson();
        AbstractC13042fc3.h(rawJson, "getRawJson(...)");
        AbstractC5923Lk3 abstractC5923Lk3H = h(rawJson);
        return g(abstractC5923Lk3H != null ? abstractC5923Lk3H.getDataType() : null, i, messageState);
    }

    @Override // ir.nasim.Z64
    public DialogLastMessage c(AbstractC17457n0 abstractC17457n0, int i, ExPeerType exPeerType, MessageState messageState) {
        AbstractC13042fc3.i(abstractC17457n0, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(messageState, "state");
        return g(abstractC17457n0 instanceof C10844cI3 ? EnumC6655Ok3.b : abstractC17457n0 instanceof C6833Pe1 ? EnumC6655Ok3.c : null, i, messageState);
    }

    @Override // ir.nasim.Z64
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public MessagingStruct$Message.b a() {
        return this.c;
    }
}
