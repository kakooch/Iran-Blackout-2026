package org.linphone.core;

/* loaded from: classes3.dex */
public enum SrtpSuite {
    AESCM128HMACSHA180(0),
    AESCM128HMACSHA132(1),
    AES192CMHMACSHA180(2),
    AES192CMHMACSHA132(3),
    AES256CMHMACSHA180(4),
    AES256CMHMACSHA132(5),
    AEADAES128GCM(6),
    AEADAES256GCM(7),
    Invalid(255);

    protected final int mValue;

    SrtpSuite(int i) {
        this.mValue = i;
    }

    public static SrtpSuite fromInt(int i) throws RuntimeException {
        if (i != 255) {
            switch (i) {
                case 0:
                    return AESCM128HMACSHA180;
                case 1:
                    return AESCM128HMACSHA132;
                case 2:
                    return AES192CMHMACSHA180;
                case 3:
                    return AES192CMHMACSHA132;
                case 4:
                    return AES256CMHMACSHA180;
                case 5:
                    return AES256CMHMACSHA132;
                case 6:
                    return AEADAES128GCM;
                case 7:
                    return AEADAES256GCM;
                default:
                    throw new RuntimeException("Unhandled enum value " + i + " for SrtpSuite");
            }
        }
        return Invalid;
    }

    protected static SrtpSuite[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        SrtpSuite[] srtpSuiteArr = new SrtpSuite[length];
        for (int i = 0; i < length; i++) {
            srtpSuiteArr[i] = fromInt(iArr[i]);
        }
        return srtpSuiteArr;
    }

    protected static int[] toIntArray(SrtpSuite[] srtpSuiteArr) throws RuntimeException {
        int length = srtpSuiteArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = srtpSuiteArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
