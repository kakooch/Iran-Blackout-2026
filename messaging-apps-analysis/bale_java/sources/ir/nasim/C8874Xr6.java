package ir.nasim;

import ai.bale.proto.MessagingStruct$Message;
import ai.bale.proto.MessagingStruct$ServiceEx;
import ai.bale.proto.MessagingStruct$ServiceExPhoneCall;
import android.content.Context;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.database.dailogLists.DialogLastMessage;
import ir.nasim.database.dailogLists.MessageState;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Xr6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8874Xr6 implements Z64 {
    private final Context a;
    private final int b;
    private final MessagingStruct$ServiceEx.b c;

    /* renamed from: ir.nasim.Xr6$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[EnumC12029dv0.values().length];
            try {
                iArr[EnumC12029dv0.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC12029dv0.c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC12029dv0.d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC12029dv0.e.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EnumC12029dv0.a.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            a = iArr;
            int[] iArr2 = new int[EnumC5091Hw.values().length];
            try {
                iArr2[EnumC5091Hw.MISSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[EnumC5091Hw.DISCONNECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[EnumC5091Hw.HANGUP.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[EnumC5091Hw.BUSY.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[EnumC5091Hw.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[EnumC5091Hw.UNSUPPORTED_VALUE.ordinal()] = 6;
            } catch (NoSuchFieldError unused11) {
            }
            b = iArr2;
            int[] iArr3 = new int[K04.values().length];
            try {
                iArr3[K04.CallDiscardReason_MISSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr3[K04.CallDiscardReason_DISCONNECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr3[K04.CallDiscardReason_HANGUP.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr3[K04.CallDiscardReason_BUSY.ordinal()] = 4;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr3[K04.CallDiscardReason_UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr3[K04.UNRECOGNIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused17) {
            }
            c = iArr3;
        }
    }

    public C8874Xr6(Context context, int i) {
        AbstractC13042fc3.i(context, "context");
        this.a = context;
        this.b = i;
        this.c = MessagingStruct$ServiceEx.b.SERVICE_EX_PHONE_CALL;
    }

    private final String d(boolean z, String str) {
        String string = this.a.getString(z ? FD5.dialog_call_ended_unsuccessful : FD5.dialog_call_rejected, str);
        AbstractC13042fc3.h(string, "getString(...)");
        return string;
    }

    private final ir.nasim.database.dailogLists.g e(EnumC12029dv0 enumC12029dv0, int i, boolean z) {
        int i2 = a.a[enumC12029dv0.ordinal()];
        if (i2 == 1) {
            return ir.nasim.database.dailogLists.g.c;
        }
        if (i2 != 2) {
            if (i2 == 3) {
                return i > 0 ? ir.nasim.database.dailogLists.g.b : !z ? ir.nasim.database.dailogLists.g.c : ir.nasim.database.dailogLists.g.c;
            }
            if (i2 != 4 && i2 != 5) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return ir.nasim.database.dailogLists.g.c;
    }

    private final int f(boolean z) {
        return z ? FD5.dialog_call_type_video : FD5.dialog_call_type_voice;
    }

    private final String g(int i, boolean z, String str) {
        String string = this.a.getString(i > 0 ? z ? FD5.dialog_call_ended_successful_outgoing : FD5.dialog_call_ended_successful_incoming : z ? FD5.dialog_call_cancelled : FD5.dialog_call_missed, str);
        AbstractC13042fc3.h(string, "getString(...)");
        return string;
    }

    private final String h(boolean z, String str) {
        if (z) {
            String string = this.a.getString(FD5.dialog_call_ended_unresponsive);
            AbstractC13042fc3.f(string);
            return string;
        }
        String string2 = this.a.getString(FD5.dialog_call_missed, str);
        AbstractC13042fc3.f(string2);
        return string2;
    }

    private final DialogLastMessage j(EnumC12029dv0 enumC12029dv0, int i, int i2, boolean z, MessageState messageState) {
        String strH;
        String string = this.a.getString(f(z));
        AbstractC13042fc3.h(string, "getString(...)");
        boolean z2 = i2 == this.b;
        int i3 = a.a[enumC12029dv0.ordinal()];
        if (i3 == 1) {
            strH = h(z2, string);
        } else if (i3 == 2) {
            strH = this.a.getString(FD5.dialog_call_disconnected, string);
            AbstractC13042fc3.h(strH, "getString(...)");
        } else if (i3 == 3) {
            strH = g(i, z2, string);
        } else if (i3 == 4) {
            strH = d(z2, string);
        } else {
            if (i3 != 5) {
                throw new NoWhenBranchMatchedException();
            }
            strH = this.a.getString(FD5.dialog_call_ended);
            AbstractC13042fc3.h(strH, "getString(...)");
        }
        return new DialogLastMessage.Call(e(enumC12029dv0, i, z2), strH, i2 == this.b, (Set) null, i2, messageState, 8, (ED1) null);
    }

    private final EnumC12029dv0 k(EnumC5091Hw enumC5091Hw) {
        switch (enumC5091Hw == null ? -1 : a.b[enumC5091Hw.ordinal()]) {
            case -1:
            case 5:
            case 6:
                return EnumC12029dv0.a;
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                return EnumC12029dv0.b;
            case 2:
                return EnumC12029dv0.c;
            case 3:
                return EnumC12029dv0.d;
            case 4:
                return EnumC12029dv0.e;
        }
    }

    private final EnumC12029dv0 l(K04 k04) {
        switch (k04 == null ? -1 : a.c[k04.ordinal()]) {
            case -1:
            case 5:
            case 6:
                return EnumC12029dv0.a;
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                return EnumC12029dv0.b;
            case 2:
                return EnumC12029dv0.c;
            case 3:
                return EnumC12029dv0.d;
            case 4:
                return EnumC12029dv0.e;
        }
    }

    @Override // ir.nasim.Z64
    public DialogLastMessage b(MessagingStruct$Message messagingStruct$Message, int i, ExPeerType exPeerType, MessageState messageState) {
        AbstractC13042fc3.i(messagingStruct$Message, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(messageState, "state");
        MessagingStruct$ServiceExPhoneCall serviceExPhoneCall = messagingStruct$Message.getServiceMessage().getExt().getServiceExPhoneCall();
        return j(l(serviceExPhoneCall.getDiscardReason()), serviceExPhoneCall.getDuration(), i, serviceExPhoneCall.getIsVideo().getValue(), messageState);
    }

    @Override // ir.nasim.Z64
    public DialogLastMessage c(AbstractC17457n0 abstractC17457n0, int i, ExPeerType exPeerType, MessageState messageState) {
        AbstractC13042fc3.i(abstractC17457n0, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(messageState, "state");
        boolean z = abstractC17457n0 instanceof C20360rs6;
        C5980Lq6 c5980Lq6 = abstractC17457n0 instanceof C5980Lq6 ? (C5980Lq6) abstractC17457n0 : null;
        if (c5980Lq6 != null) {
            return j(k(c5980Lq6.t()), c5980Lq6.u(), i, z, messageState);
        }
        String string = this.a.getString(FD5.dialog_call_ended);
        AbstractC13042fc3.h(string, "getString(...)");
        return new DialogLastMessage.Text(string, (List) null, (EnumC22968w74) null, (String) null, false, 0, (MessageState) null, (Set) null, (MessagingStruct$ServiceEx.b) null, 510, (ED1) null);
    }

    @Override // ir.nasim.Z64
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public MessagingStruct$ServiceEx.b a() {
        return this.c;
    }
}
