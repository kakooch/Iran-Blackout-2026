package ir.nasim;

import ir.nasim.UO1;
import ir.nasim.database.dailogLists.MessageState;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.y74, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC24148y74 {

    /* renamed from: ir.nasim.y74$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[MessageState.values().length];
            try {
                iArr[MessageState.Sent.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MessageState.Read.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MessageState.Pending.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MessageState.Failed.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MessageState.Unknown.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            a = iArr;
            int[] iArr2 = new int[EnumC16043kc4.values().length];
            try {
                iArr2[EnumC16043kc4.MessageState_SENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[EnumC16043kc4.MessageState_RECEIVED.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[EnumC16043kc4.MessageState_READ.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[EnumC16043kc4.UNRECOGNIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            b = iArr2;
            int[] iArr3 = new int[EnumC4884Gz.values().length];
            try {
                iArr3[EnumC4884Gz.SENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[EnumC4884Gz.READ.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[EnumC4884Gz.RECEIVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr3[EnumC4884Gz.UNSUPPORTED_VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError unused13) {
            }
            c = iArr3;
        }
    }

    public static final Integer a(MessageState messageState) {
        AbstractC13042fc3.i(messageState, "<this>");
        int i = a.a[messageState.ordinal()];
        if (i == 1) {
            return Integer.valueOf(UD5.sent_content_description);
        }
        if (i == 2) {
            return Integer.valueOf(UD5.read_content_description);
        }
        if (i == 3) {
            return Integer.valueOf(UD5.pending_content_description);
        }
        if (i == 4 || i == 5) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Integer b(MessageState messageState) {
        AbstractC13042fc3.i(messageState, "<this>");
        int i = a.a[messageState.ordinal()];
        if (i == 1) {
            return Integer.valueOf(AbstractC24188yB5.sent);
        }
        if (i == 2) {
            return Integer.valueOf(AbstractC24188yB5.deliver);
        }
        if (i == 3) {
            return Integer.valueOf(AbstractC24188yB5.time_circle);
        }
        if (i == 4) {
            return Integer.valueOf(AbstractC24188yB5.danger);
        }
        if (i == 5) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Integer c(MessageState messageState) {
        AbstractC13042fc3.i(messageState, "<this>");
        int i = a.a[messageState.ordinal()];
        if (i == 1) {
            return Integer.valueOf(AbstractC15199jA5.n200);
        }
        if (i == 2) {
            return Integer.valueOf(AbstractC15199jA5.colorSuccess);
        }
        if (i == 3) {
            return Integer.valueOf(AbstractC15199jA5.n200);
        }
        if (i != 4) {
            return null;
        }
        return Integer.valueOf(AbstractC15199jA5.colorError);
    }

    public static final MessageState d(EnumC16043kc4 enumC16043kc4) {
        int i = enumC16043kc4 == null ? -1 : a.b[enumC16043kc4.ordinal()];
        if (i != -1) {
            if (i == 1) {
                return MessageState.Sent;
            }
            if (i == 2) {
                return MessageState.Sent;
            }
            if (i == 3) {
                return MessageState.Read;
            }
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
        }
        UO1.b.b(UO1.b.a, "MessagingStruct.MessageState." + enumC16043kc4 + " is not supported by MessageState", null, null, 6, null);
        return MessageState.Unknown;
    }
}
