package ir.nasim;

import ai.bale.proto.MessagingStruct$Message;
import ai.bale.proto.MessagingStruct$ServiceEx;
import android.content.Context;
import ir.nasim.GI7;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.database.dailogLists.DialogLastMessage;
import ir.nasim.database.dailogLists.MessageState;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* renamed from: ir.nasim.or6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C18559or6 implements Z64 {
    private final Context a;
    private final int b;
    private final GI7 c;
    private final MessagingStruct$ServiceEx.b d;

    public C18559or6(Context context, int i, GI7 gi7) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(gi7, "userNamePlaceHolderManager");
        this.a = context;
        this.b = i;
        this.c = gi7;
        this.d = MessagingStruct$ServiceEx.b.SERVICE_EX_GROUP_CALL_ENDED;
    }

    private final String e(Context context, long j) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long hours = timeUnit.toHours(j);
        long j2 = 60;
        long minutes = timeUnit.toMinutes(j) % j2;
        long seconds = timeUnit.toSeconds(j) % j2;
        if (hours > 0) {
            String string = minutes > 0 ? context.getString(FD5.time_duration_hours_minutes, String.valueOf(hours), String.valueOf(minutes)) : context.getString(FD5.time_duration_hours, String.valueOf(hours));
            AbstractC13042fc3.f(string);
            return string;
        }
        if (minutes > 0) {
            String string2 = seconds > 0 ? context.getString(FD5.time_duration_minutes_seconds, String.valueOf(minutes), String.valueOf(seconds)) : context.getString(FD5.time_duration_minutes, String.valueOf(minutes));
            AbstractC13042fc3.f(string2);
            return string2;
        }
        String string3 = context.getString(FD5.time_duration_seconds, String.valueOf(seconds));
        AbstractC13042fc3.h(string3, "getString(...)");
        return string3;
    }

    private final DialogLastMessage g(final int i, final long j, final boolean z, final MessageState messageState) {
        return (DialogLastMessage) this.c.b(new UA2() { // from class: ir.nasim.nr6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C18559or6.h(i, this, z, j, messageState, (GI7.a) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DialogLastMessage.Call h(int i, C18559or6 c18559or6, boolean z, long j, MessageState messageState, GI7.a aVar) {
        String string;
        AbstractC13042fc3.i(c18559or6, "this$0");
        AbstractC13042fc3.i(messageState, "$state");
        AbstractC13042fc3.i(aVar, "$this$withPlaceHolders");
        boolean z2 = i == c18559or6.b;
        String strE = GI7.a.e(aVar, i, false, 2, null);
        if (z) {
            string = c18559or6.a.getString(FD5.group_call_missed_service_message, strE);
        } else {
            string = c18559or6.a.getString(z2 ? FD5.group_you_call_ended_service_message : FD5.group_other_call_ended_service_message, strE, c18559or6.e(c18559or6.a, j));
        }
        AbstractC13042fc3.f(string);
        return new DialogLastMessage.Call((z || j < 1000) ? ir.nasim.database.dailogLists.g.c : ir.nasim.database.dailogLists.g.b, string, i == c18559or6.b, aVar.b(), i, messageState);
    }

    @Override // ir.nasim.Z64
    public DialogLastMessage b(MessagingStruct$Message messagingStruct$Message, int i, ExPeerType exPeerType, MessageState messageState) {
        AbstractC13042fc3.i(messagingStruct$Message, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(messageState, "state");
        return g(i, r7.getGroupCall().getDuration().getValue(), messagingStruct$Message.getServiceMessage().getExt().getServiceExGroupCallEnded().getMissed(), messageState);
    }

    @Override // ir.nasim.Z64
    public DialogLastMessage c(AbstractC17457n0 abstractC17457n0, int i, ExPeerType exPeerType, MessageState messageState) {
        C24054xy c24054xyW;
        C5577Jy c5577JyQ;
        List listU;
        Object next;
        AbstractC17566nB abstractC17566nBQ;
        AbstractC13042fc3.i(abstractC17457n0, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(messageState, "state");
        String string = this.a.getString(FD5.message_holder_content_message);
        AbstractC13042fc3.h(string, "getString(...)");
        DialogLastMessage.Text text = new DialogLastMessage.Text(string, (List) null, (EnumC22968w74) null, (String) null, i == this.b, i, messageState, (Set) null, (MessagingStruct$ServiceEx.b) null, 398, (ED1) null);
        C17377mr6 c17377mr6 = abstractC17457n0 instanceof C17377mr6 ? (C17377mr6) abstractC17457n0 : null;
        if (c17377mr6 == null) {
            return text;
        }
        AbstractC24063xz abstractC24063xzC = c17377mr6.s().c();
        C23011wC c23011wC = abstractC24063xzC instanceof C23011wC ? (C23011wC) abstractC24063xzC : null;
        if (c23011wC == null) {
            return text;
        }
        VB vbU = c23011wC.u();
        C15211jC c15211jC = vbU instanceof C15211jC ? (C15211jC) vbU : null;
        if (c15211jC != null && exPeerType == ExPeerType.GROUP && (c24054xyW = c15211jC.w()) != null && (c5577JyQ = c24054xyW.q()) != null) {
            long jU = c5577JyQ.u();
            C19811qz c19811qzU = c15211jC.u();
            if (c19811qzU != null && (listU = c19811qzU.u()) != null) {
                Iterator it = listU.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (AbstractC13042fc3.d(((C20420rz) next).getKey(), "finisher")) {
                        break;
                    }
                }
                C20420rz c20420rz = (C20420rz) next;
                if (c20420rz != null && (abstractC17566nBQ = c20420rz.q()) != null) {
                    C5577Jy c5577Jy = abstractC17566nBQ instanceof C5577Jy ? (C5577Jy) abstractC17566nBQ : null;
                    Integer numValueOf = c5577Jy != null ? Integer.valueOf(c5577Jy.u()) : null;
                    if (numValueOf != null) {
                        return g(numValueOf.intValue(), jU, c15211jC.y(), messageState);
                    }
                }
            }
        }
        return text;
    }

    @Override // ir.nasim.Z64
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public MessagingStruct$ServiceEx.b a() {
        return this.d;
    }
}
