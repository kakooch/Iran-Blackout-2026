package org.linphone.core;

/* loaded from: classes3.dex */
public enum AddressFamily {
    Inet(0),
    Inet6(1),
    Unspec(2);

    protected final int mValue;

    AddressFamily(int i) {
        this.mValue = i;
    }

    public static AddressFamily fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return Inet;
        }
        if (i == 1) {
            return Inet6;
        }
        if (i == 2) {
            return Unspec;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for AddressFamily");
    }

    protected static AddressFamily[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        AddressFamily[] addressFamilyArr = new AddressFamily[length];
        for (int i = 0; i < length; i++) {
            addressFamilyArr[i] = fromInt(iArr[i]);
        }
        return addressFamilyArr;
    }

    protected static int[] toIntArray(AddressFamily[] addressFamilyArr) throws RuntimeException {
        int length = addressFamilyArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = addressFamilyArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
