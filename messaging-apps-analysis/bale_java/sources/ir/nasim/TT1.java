package ir.nasim;

import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public abstract class TT1 {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[K04.values().length];
            try {
                iArr[K04.CallDiscardReason_UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[K04.CallDiscardReason_MISSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[K04.CallDiscardReason_DISCONNECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[K04.CallDiscardReason_HANGUP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[K04.CallDiscardReason_BUSY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[K04.UNRECOGNIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnumC12029dv0 b(K04 k04) {
        switch (k04 == null ? -1 : a.a[k04.ordinal()]) {
            case -1:
                return null;
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                return EnumC12029dv0.a;
            case 2:
                return EnumC12029dv0.b;
            case 3:
                return EnumC12029dv0.c;
            case 4:
                return EnumC12029dv0.d;
            case 5:
                return EnumC12029dv0.e;
            case 6:
                return EnumC12029dv0.a;
        }
    }
}
