package ir.nasim;

import ai.bale.proto.MessagingStruct$Message;
import android.content.Context;
import ir.nasim.C9475a16;
import ir.nasim.GI7;
import ir.nasim.UO1;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.database.dailogLists.DialogLastMessage;
import ir.nasim.database.dailogLists.FastThumbnailItemEntity;
import ir.nasim.database.dailogLists.MessageState;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.xt3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24011xt3 {
    private final C21171tE1 a;
    private final GI7 b;
    private final Context c;
    private final int d;
    private final Map e;

    /* renamed from: ir.nasim.xt3$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[MessagingStruct$Message.b.values().length];
            try {
                iArr[MessagingStruct$Message.b.BANK_MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MessagingStruct$Message.b.DOCUMENT_MESSAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MessagingStruct$Message.b.ORDER_MESSAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MessagingStruct$Message.b.PURCHASE_MESSAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MessagingStruct$Message.b.SERVICE_MESSAGE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[MessagingStruct$Message.b.STICKER_MESSAGE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[MessagingStruct$Message.b.TEXT_MESSAGE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[MessagingStruct$Message.b.GIFT_PACKET_MESSAGE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[MessagingStruct$Message.b.CROWD_FUNDING_MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[MessagingStruct$Message.b.ANIMATED_STICKER_MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[MessagingStruct$Message.b.TEMPLATE_MESSAGE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[MessagingStruct$Message.b.LIVE_MESSAGE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[MessagingStruct$Message.b.JSON_MESSAGE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[MessagingStruct$Message.b.POLL_MESSAGE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[MessagingStruct$Message.b.NASIM_ENCRYPTED_MESSAGE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[MessagingStruct$Message.b.BINARY_MESSAGE.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[MessagingStruct$Message.b.EMPTY_MESSAGE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[MessagingStruct$Message.b.DELETED_MESSAGE.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[MessagingStruct$Message.b.TEMPLATE_MESSAGE_RESPONSE.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[MessagingStruct$Message.b.UNSUPPORTED_MESSAGE.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[MessagingStruct$Message.b.PREMIUM_MESSAGE.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[MessagingStruct$Message.b.NEW_PREMIUM_MESSAGE.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[MessagingStruct$Message.b.BOUGHT_PREMIUM_MESSAGE.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[MessagingStruct$Message.b.ADVERTISEMENT_MESSAGE.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[MessagingStruct$Message.b.BANNED_MESSAGE.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[MessagingStruct$Message.b.STORY.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[MessagingStruct$Message.b.PROTECTED_MESSAGE.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[MessagingStruct$Message.b.TRAIT_NOT_SET.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[MessagingStruct$Message.b.GOLD_GIFT_PACKET_MESSAGE.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            a = iArr;
        }
    }

    public C24011xt3(Set set, C21171tE1 c21171tE1, GI7 gi7, Context context, int i) {
        AbstractC13042fc3.i(set, "strategiesSet");
        AbstractC13042fc3.i(c21171tE1, "defaultMessageStrategy");
        AbstractC13042fc3.i(gi7, "userNamePlaceHolderManager");
        AbstractC13042fc3.i(context, "context");
        this.a = c21171tE1;
        this.b = gi7;
        this.c = context;
        this.d = i;
        Set set2 = set;
        LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC23053wG5.e(AbstractC19460qO3.f(AbstractC10976cX0.x(set2, 10)), 16));
        for (Object obj : set2) {
            linkedHashMap.put((MessagingStruct$Message.b) ((Z64) obj).a(), obj);
        }
        this.e = linkedHashMap;
    }

    private final DialogLastMessage.Album b(final C11907dl c11907dl, final int i, final ExPeerType exPeerType, final MessageState messageState) {
        return (DialogLastMessage.Album) this.b.b(new UA2() { // from class: ir.nasim.wt3
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C24011xt3.c(c11907dl, this, i, exPeerType, messageState, (GI7.a) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final ir.nasim.database.dailogLists.DialogLastMessage.Album c(ir.nasim.C11907dl r14, ir.nasim.C24011xt3 r15, int r16, ir.nasim.core.modules.profile.entity.ExPeerType r17, ir.nasim.database.dailogLists.MessageState r18, ir.nasim.GI7.a r19) {
        /*
            Method dump skipped, instructions count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C24011xt3.c(ir.nasim.dl, ir.nasim.xt3, int, ir.nasim.core.modules.profile.entity.ExPeerType, ir.nasim.database.dailogLists.MessageState, ir.nasim.GI7$a):ir.nasim.database.dailogLists.DialogLastMessage$Album");
    }

    private final Z64 d(MessagingStruct$Message.b bVar) {
        Z64 z64;
        switch (bVar == null ? -1 : a.a[bVar.ordinal()]) {
            case -1:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
                UO1.b.b(UO1.b.a, "No strategies defined for this type.", bVar != null ? bVar.name() : null, null, 4, null);
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
                z64 = (Z64) this.e.get(bVar);
                break;
        }
        if (z64 != null) {
            return z64;
        }
        UO1.b.b(UO1.b.a, "Important: Tried to use a strategy that is not provided.", bVar != null ? bVar.name() : null, null, 4, null);
        return this.a;
    }

    private final FastThumbnailItemEntity g(C22694vg2 c22694vg2, boolean z) {
        byte[] bArrC = c22694vg2.c();
        if (bArrC == null) {
            return null;
        }
        if (!(!(bArrC.length == 0))) {
            bArrC = null;
        }
        if (bArrC != null) {
            return new FastThumbnailItemEntity(bArrC, c22694vg2.d(), c22694vg2.b(), z);
        }
        return null;
    }

    private final MessagingStruct$Message.b h(AbstractC17457n0 abstractC17457n0) {
        return abstractC17457n0 instanceof LC3 ? MessagingStruct$Message.b.LIVE_MESSAGE : abstractC17457n0 instanceof C11907dl ? MessagingStruct$Message.b.DOCUMENT_MESSAGE : abstractC17457n0 instanceof C16799lt ? MessagingStruct$Message.b.ANIMATED_STICKER_MESSAGE : abstractC17457n0 instanceof TM ? MessagingStruct$Message.b.DOCUMENT_MESSAGE : abstractC17457n0 instanceof C21788u80 ? MessagingStruct$Message.b.BANNED_MESSAGE : abstractC17457n0 instanceof ir.nasim.core.modules.messaging.entity.content.a ? MessagingStruct$Message.b.CROWD_FUNDING_MESSAGE : abstractC17457n0 instanceof XG2 ? MessagingStruct$Message.b.DOCUMENT_MESSAGE : abstractC17457n0 instanceof V73 ? MessagingStruct$Message.b.UNSUPPORTED_MESSAGE : abstractC17457n0 instanceof C13388g85 ? MessagingStruct$Message.b.DOCUMENT_MESSAGE : abstractC17457n0 instanceof C15080iy5 ? MessagingStruct$Message.b.ORDER_MESSAGE : abstractC17457n0 instanceof C18626oy5 ? MessagingStruct$Message.b.PURCHASE_MESSAGE : abstractC17457n0 instanceof UO5 ? MessagingStruct$Message.b.UNSUPPORTED_MESSAGE : abstractC17457n0 instanceof XO5 ? MessagingStruct$Message.b.UNSUPPORTED_MESSAGE : abstractC17457n0 instanceof AbstractC12586er6 ? MessagingStruct$Message.b.SERVICE_MESSAGE : abstractC17457n0 instanceof C12872fJ6 ? MessagingStruct$Message.b.ADVERTISEMENT_MESSAGE : abstractC17457n0 instanceof C23345wl7 ? MessagingStruct$Message.b.TEXT_MESSAGE : abstractC17457n0 instanceof GS7 ? MessagingStruct$Message.b.DOCUMENT_MESSAGE : abstractC17457n0 instanceof J08 ? MessagingStruct$Message.b.DOCUMENT_MESSAGE : abstractC17457n0 instanceof E50 ? MessagingStruct$Message.b.BANK_MESSAGE : abstractC17457n0 instanceof C20212re0 ? MessagingStruct$Message.b.ORDER_MESSAGE : abstractC17457n0 instanceof C15284jK0 ? MessagingStruct$Message.b.ORDER_MESSAGE : abstractC17457n0 instanceof C6833Pe1 ? MessagingStruct$Message.b.JSON_MESSAGE : abstractC17457n0 instanceof NH1 ? MessagingStruct$Message.b.DELETED_MESSAGE : abstractC17457n0 instanceof C24967zW1 ? MessagingStruct$Message.b.DOCUMENT_MESSAGE : abstractC17457n0 instanceof C18121o72 ? MessagingStruct$Message.b.EMPTY_MESSAGE : abstractC17457n0 instanceof C22472vI2 ? MessagingStruct$Message.b.GIFT_PACKET_MESSAGE : abstractC17457n0 instanceof BJ2 ? MessagingStruct$Message.b.GOLD_GIFT_PACKET_MESSAGE : abstractC17457n0 instanceof C16122kk3 ? MessagingStruct$Message.b.JSON_MESSAGE : abstractC17457n0 instanceof C10844cI3 ? MessagingStruct$Message.b.JSON_MESSAGE : abstractC17457n0 instanceof C24562yp4 ? MessagingStruct$Message.b.NASIM_ENCRYPTED_MESSAGE : abstractC17457n0 instanceof OL4 ? MessagingStruct$Message.b.ORDER_MESSAGE : abstractC17457n0 instanceof JM6 ? MessagingStruct$Message.b.STICKER_MESSAGE : abstractC17457n0 instanceof C22149uk7 ? MessagingStruct$Message.b.TEMPLATE_MESSAGE : abstractC17457n0 instanceof C5331Iw5 ? MessagingStruct$Message.b.PROTECTED_MESSAGE : abstractC17457n0 instanceof C22739vk7 ? MessagingStruct$Message.b.TEMPLATE_MESSAGE_RESPONSE : abstractC17457n0 instanceof C19049ph5 ? MessagingStruct$Message.b.POLL_MESSAGE : abstractC17457n0 instanceof C11558dC7 ? MessagingStruct$Message.b.UNSUPPORTED_MESSAGE : MessagingStruct$Message.b.TRAIT_NOT_SET;
    }

    public final DialogLastMessage e(MessagingStruct$Message messagingStruct$Message, int i, ExPeerType exPeerType, MessageState messageState) {
        Object objB;
        AbstractC13042fc3.i(messagingStruct$Message, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(messageState, "messageState");
        try {
            C9475a16.a aVar = C9475a16.b;
            if (messagingStruct$Message.getTraitCase() == MessagingStruct$Message.b.TEMPLATE_MESSAGE) {
                messagingStruct$Message = messagingStruct$Message.getTemplateMessage().getGeneralMessage();
            }
            Z64 z64D = d(messagingStruct$Message.getTraitCase());
            AbstractC13042fc3.f(messagingStruct$Message);
            objB = C9475a16.b(z64D.b(messagingStruct$Message, i, exPeerType, messageState));
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        DialogLastMessage.Unknown unknown = new DialogLastMessage.Unknown(0, (MessageState) null, false, 7, (ED1) null);
        if (C9475a16.g(objB)) {
            objB = unknown;
        }
        return (DialogLastMessage) objB;
    }

    public final DialogLastMessage f(AbstractC17457n0 abstractC17457n0, int i, ExPeerType exPeerType, MessageState messageState) {
        Object objB;
        AbstractC13042fc3.i(abstractC17457n0, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(messageState, "messageState");
        if (abstractC17457n0 instanceof C11907dl) {
            return b((C11907dl) abstractC17457n0, i, exPeerType, messageState);
        }
        if (abstractC17457n0 instanceof C22149uk7) {
            abstractC17457n0 = ((C22149uk7) abstractC17457n0).t();
        }
        try {
            C9475a16.a aVar = C9475a16.b;
            AbstractC13042fc3.f(abstractC17457n0);
            objB = C9475a16.b(d(h(abstractC17457n0)).c(abstractC17457n0, i, exPeerType, messageState));
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        DialogLastMessage.Unknown unknown = new DialogLastMessage.Unknown(0, (MessageState) null, false, 7, (ED1) null);
        if (C9475a16.g(objB)) {
            objB = unknown;
        }
        return (DialogLastMessage) objB;
    }
}
