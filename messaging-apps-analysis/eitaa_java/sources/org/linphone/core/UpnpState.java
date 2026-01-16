package org.linphone.core;

/* loaded from: classes3.dex */
public enum UpnpState {
    Idle(0),
    Pending(1),
    Adding(2),
    Removing(3),
    NotAvailable(4),
    Ok(5),
    Ko(6),
    Blacklisted(7);

    protected final int mValue;

    UpnpState(int i) {
        this.mValue = i;
    }

    public static UpnpState fromInt(int i) throws RuntimeException {
        switch (i) {
            case 0:
                return Idle;
            case 1:
                return Pending;
            case 2:
                return Adding;
            case 3:
                return Removing;
            case 4:
                return NotAvailable;
            case 5:
                return Ok;
            case 6:
                return Ko;
            case 7:
                return Blacklisted;
            default:
                throw new RuntimeException("Unhandled enum value " + i + " for UpnpState");
        }
    }

    protected static UpnpState[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        UpnpState[] upnpStateArr = new UpnpState[length];
        for (int i = 0; i < length; i++) {
            upnpStateArr[i] = fromInt(iArr[i]);
        }
        return upnpStateArr;
    }

    protected static int[] toIntArray(UpnpState[] upnpStateArr) throws RuntimeException {
        int length = upnpStateArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = upnpStateArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
