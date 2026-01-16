package ir.nasim;

import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes3.dex */
public abstract class F26 {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[RE3.values().length];
            try {
                iArr[RE3.CLIENT_INITIATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RE3.DUPLICATE_IDENTITY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RE3.SERVER_SHUTDOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RE3.PARTICIPANT_REMOVED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[RE3.ROOM_DELETED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[RE3.STATE_MISMATCH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[RE3.JOIN_FAILURE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[RE3.MIGRATION.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[RE3.SIGNAL_CLOSE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[RE3.ROOM_CLOSED.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[RE3.USER_UNAVAILABLE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[RE3.USER_REJECTED.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[RE3.SIP_TRUNK_FAILURE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[RE3.CONNECTION_TIMEOUT.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[RE3.MEDIA_FAILURE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[RE3.UNKNOWN_REASON.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[RE3.UNRECOGNIZED.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            a = iArr;
        }
    }

    public static final UT1 a(RE3 re3) {
        switch (re3 == null ? -1 : a.a[re3.ordinal()]) {
            case -1:
            case 16:
            case 17:
                return UT1.a;
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                return UT1.b;
            case 2:
                return UT1.c;
            case 3:
                return UT1.d;
            case 4:
                return UT1.e;
            case 5:
                return UT1.f;
            case 6:
                return UT1.g;
            case 7:
                return UT1.h;
            case 8:
                return UT1.i;
            case 9:
                return UT1.j;
            case 10:
                return UT1.k;
            case 11:
                return UT1.l;
            case 12:
                return UT1.m;
            case 13:
                return UT1.n;
            case 14:
                return UT1.o;
            case 15:
                return UT1.p;
        }
    }
}
