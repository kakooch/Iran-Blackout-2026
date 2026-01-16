package org.linphone.core;

/* loaded from: classes3.dex */
public enum TransportType {
    Udp(0),
    Tcp(1),
    Tls(2),
    Dtls(3);

    protected final int mValue;

    TransportType(int i) {
        this.mValue = i;
    }

    public static TransportType fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return Udp;
        }
        if (i == 1) {
            return Tcp;
        }
        if (i == 2) {
            return Tls;
        }
        if (i == 3) {
            return Dtls;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for TransportType");
    }

    protected static TransportType[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        TransportType[] transportTypeArr = new TransportType[length];
        for (int i = 0; i < length; i++) {
            transportTypeArr[i] = fromInt(iArr[i]);
        }
        return transportTypeArr;
    }

    protected static int[] toIntArray(TransportType[] transportTypeArr) throws RuntimeException {
        int length = transportTypeArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = transportTypeArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
