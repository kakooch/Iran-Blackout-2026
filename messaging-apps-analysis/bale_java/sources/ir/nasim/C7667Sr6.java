package ir.nasim;

import ai.bale.proto.MessagingStruct$Message;
import ai.bale.proto.MessagingStruct$ServiceEx;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.database.dailogLists.DialogLastMessage;
import ir.nasim.database.dailogLists.MessageState;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Sr6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7667Sr6 implements Z64 {
    private final C21171tE1 a;
    private final int b;
    private final Map c;
    private final MessagingStruct$Message.b d;

    /* renamed from: ir.nasim.Sr6$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[MessagingStruct$ServiceEx.b.values().length];
            try {
                iArr[MessagingStruct$ServiceEx.b.SERVICE_EX_CHANGED_ABOUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MessagingStruct$ServiceEx.b.SERVICE_EX_CHANGED_AVATAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MessagingStruct$ServiceEx.b.SERVICE_EX_CHANGED_TITLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MessagingStruct$ServiceEx.b.SERVICE_EX_CHANGED_TOPIC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MessagingStruct$ServiceEx.b.SERVICE_EX_CONTACT_REGISTERED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[MessagingStruct$ServiceEx.b.SERVICE_EX_GROUP_CREATED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[MessagingStruct$ServiceEx.b.SERVICE_EX_PHONE_CALL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[MessagingStruct$ServiceEx.b.SERVICE_EX_PHONE_MISSED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[MessagingStruct$ServiceEx.b.SERVICE_EX_USER_INVITED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[MessagingStruct$ServiceEx.b.SERVICE_EX_USER_JOINED.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[MessagingStruct$ServiceEx.b.SERVICE_EX_USER_KICKED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[MessagingStruct$ServiceEx.b.SERVICE_EX_USER_LEFT.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[MessagingStruct$ServiceEx.b.SERVICE_EX_GIFT_PACKET_OPENED.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[MessagingStruct$ServiceEx.b.SERVICE_EX_GIFT_PACKET_OPENED_COMPACT.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[MessagingStruct$ServiceEx.b.SERVICE_EX_NEW_USER_WELCOME.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[MessagingStruct$ServiceEx.b.SERVICE_EX_GROUP_CALL_STARTED.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[MessagingStruct$ServiceEx.b.SERVICE_EX_GROUP_CALL_ENDED.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[MessagingStruct$ServiceEx.b.SERVICE_EX_ANONYMOUS_CONTACT.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[MessagingStruct$ServiceEx.b.SERVICE_EX_BECAME_ORPHANED.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[MessagingStruct$ServiceEx.b.SERVICE_EX_CHANGED_NICK.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[MessagingStruct$ServiceEx.b.SERVICE_EX_CHAT_ARCHIVED.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[MessagingStruct$ServiceEx.b.SERVICE_EX_CHAT_RESTORED.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[MessagingStruct$ServiceEx.b.TRAIT_NOT_SET.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[MessagingStruct$ServiceEx.b.SERVICE_EX_CALL_RECORD_STATE_CHANGED.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[MessagingStruct$ServiceEx.b.SERVICE_EX_MINI_APP_DATA_SENT.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[MessagingStruct$ServiceEx.b.SERVICE_EX_PASSPORT_DATA_SENT.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            a = iArr;
        }
    }

    public C7667Sr6(Set set, C21171tE1 c21171tE1, int i) {
        AbstractC13042fc3.i(set, "strategiesSet");
        AbstractC13042fc3.i(c21171tE1, "defaultMessageStrategy");
        this.a = c21171tE1;
        this.b = i;
        Set set2 = set;
        LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC23053wG5.e(AbstractC19460qO3.f(AbstractC10976cX0.x(set2, 10)), 16));
        for (Object obj : set2) {
            linkedHashMap.put((MessagingStruct$ServiceEx.b) ((Z64) obj).a(), obj);
        }
        this.c = linkedHashMap;
        this.d = MessagingStruct$Message.b.SERVICE_MESSAGE;
    }

    private final Z64 d(MessagingStruct$ServiceEx.b bVar) {
        Z64 z64;
        switch (bVar == null ? -1 : a.a[bVar.ordinal()]) {
            case -1:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
                z64 = this.a;
                break;
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                z64 = (Z64) this.c.get(bVar);
                break;
        }
        return z64 == null ? this.a : z64;
    }

    private final MessagingStruct$ServiceEx.b f(AbstractC17457n0 abstractC17457n0) {
        return abstractC17457n0 instanceof C20360rs6 ? MessagingStruct$ServiceEx.b.SERVICE_EX_PHONE_CALL : abstractC17457n0 instanceof C5980Lq6 ? MessagingStruct$ServiceEx.b.SERVICE_EX_PHONE_CALL : abstractC17457n0 instanceof C6213Mq6 ? MessagingStruct$ServiceEx.b.SERVICE_EX_PHONE_MISSED : abstractC17457n0 instanceof C16195kr6 ? MessagingStruct$ServiceEx.b.SERVICE_EX_CHANGED_ABOUT : abstractC17457n0 instanceof C16786lr6 ? MessagingStruct$ServiceEx.b.SERVICE_EX_CHANGED_AVATAR : abstractC17457n0 instanceof C17377mr6 ? MessagingStruct$ServiceEx.b.SERVICE_EX_GROUP_CALL_ENDED : abstractC17457n0 instanceof C19150pr6 ? MessagingStruct$ServiceEx.b.SERVICE_EX_GROUP_CALL_STARTED : abstractC17457n0 instanceof C20941sr6 ? MessagingStruct$ServiceEx.b.SERVICE_EX_GROUP_CREATED : abstractC17457n0 instanceof C22218ur6 ? MessagingStruct$ServiceEx.b.SERVICE_EX_GIFT_PACKET_OPENED : abstractC17457n0 instanceof C22808vr6 ? MessagingStruct$ServiceEx.b.SERVICE_EX_GIFT_PACKET_OPENED_COMPACT : abstractC17457n0 instanceof C23404wr6 ? MessagingStruct$ServiceEx.b.SERVICE_EX_CHANGED_TITLE : abstractC17457n0 instanceof C23994xr6 ? MessagingStruct$ServiceEx.b.SERVICE_EX_CHANGED_TOPIC : abstractC17457n0 instanceof C24584yr6 ? MessagingStruct$ServiceEx.b.SERVICE_EX_USER_INVITED : abstractC17457n0 instanceof C25178zr6 ? MessagingStruct$ServiceEx.b.SERVICE_EX_USER_JOINED : abstractC17457n0 instanceof C3395Ar6 ? MessagingStruct$ServiceEx.b.SERVICE_EX_USER_KICKED : abstractC17457n0 instanceof C3634Br6 ? MessagingStruct$ServiceEx.b.SERVICE_EX_USER_LEFT : abstractC17457n0 instanceof C7906Tr6 ? MessagingStruct$ServiceEx.b.SERVICE_EX_NEW_USER_WELCOME : abstractC17457n0 instanceof C19751qs6 ? MessagingStruct$ServiceEx.b.SERVICE_EX_CONTACT_REGISTERED : abstractC17457n0 instanceof C20951ss6 ? MessagingStruct$ServiceEx.b.SERVICE_EX_MINI_APP_DATA_SENT : abstractC17457n0 instanceof C8608Wr6 ? MessagingStruct$ServiceEx.b.SERVICE_EX_PASSPORT_DATA_SENT : MessagingStruct$ServiceEx.b.TRAIT_NOT_SET;
    }

    @Override // ir.nasim.Z64
    public DialogLastMessage b(MessagingStruct$Message messagingStruct$Message, int i, ExPeerType exPeerType, MessageState messageState) {
        AbstractC13042fc3.i(messagingStruct$Message, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(messageState, "state");
        return d(messagingStruct$Message.getServiceMessage().getExt().getTraitCase()).b(messagingStruct$Message, i, exPeerType, MessageState.Unknown);
    }

    @Override // ir.nasim.Z64
    public DialogLastMessage c(AbstractC17457n0 abstractC17457n0, int i, ExPeerType exPeerType, MessageState messageState) {
        AbstractC13042fc3.i(abstractC17457n0, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(messageState, "state");
        return d(f(abstractC17457n0)).c(abstractC17457n0, i, exPeerType, messageState);
    }

    @Override // ir.nasim.Z64
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public MessagingStruct$Message.b a() {
        return this.d;
    }
}
