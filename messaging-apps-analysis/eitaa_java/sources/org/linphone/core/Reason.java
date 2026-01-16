package org.linphone.core;

/* loaded from: classes3.dex */
public enum Reason {
    None(0),
    NoResponse(1),
    Forbidden(2),
    Declined(3),
    NotFound(4),
    NotAnswered(5),
    Busy(6),
    UnsupportedContent(7),
    BadEvent(8),
    IOError(9),
    DoNotDisturb(10),
    Unauthorized(11),
    NotAcceptable(12),
    NoMatch(13),
    MovedPermanently(14),
    Gone(15),
    TemporarilyUnavailable(16),
    AddressIncomplete(17),
    NotImplemented(18),
    BadGateway(19),
    SessionIntervalTooSmall(20),
    ServerTimeout(21),
    Unknown(22),
    Transferred(23);

    protected final int mValue;

    Reason(int i) {
        this.mValue = i;
    }

    public static Reason fromInt(int i) throws RuntimeException {
        switch (i) {
            case 0:
                return None;
            case 1:
                return NoResponse;
            case 2:
                return Forbidden;
            case 3:
                return Declined;
            case 4:
                return NotFound;
            case 5:
                return NotAnswered;
            case 6:
                return Busy;
            case 7:
                return UnsupportedContent;
            case 8:
                return BadEvent;
            case 9:
                return IOError;
            case 10:
                return DoNotDisturb;
            case 11:
                return Unauthorized;
            case 12:
                return NotAcceptable;
            case 13:
                return NoMatch;
            case 14:
                return MovedPermanently;
            case 15:
                return Gone;
            case 16:
                return TemporarilyUnavailable;
            case 17:
                return AddressIncomplete;
            case 18:
                return NotImplemented;
            case 19:
                return BadGateway;
            case 20:
                return SessionIntervalTooSmall;
            case 21:
                return ServerTimeout;
            case 22:
                return Unknown;
            case 23:
                return Transferred;
            default:
                throw new RuntimeException("Unhandled enum value " + i + " for Reason");
        }
    }

    protected static Reason[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        Reason[] reasonArr = new Reason[length];
        for (int i = 0; i < length; i++) {
            reasonArr[i] = fromInt(iArr[i]);
        }
        return reasonArr;
    }

    protected static int[] toIntArray(Reason[] reasonArr) throws RuntimeException {
        int length = reasonArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = reasonArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
