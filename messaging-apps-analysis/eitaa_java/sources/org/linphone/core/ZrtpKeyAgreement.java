package org.linphone.core;

/* loaded from: classes3.dex */
public enum ZrtpKeyAgreement {
    Invalid(0),
    Dh2K(1),
    Dh3K(2),
    Ec25(3),
    Ec38(4),
    Ec52(5),
    X255(6),
    X448(7),
    K255(8),
    K448(9),
    Kyb1(10),
    Kyb2(11),
    Kyb3(12),
    Hqc1(13),
    Hqc2(14),
    Hqc3(15),
    K255Kyb512(16),
    K255Hqc128(17),
    K448Kyb1024(18),
    K448Hqc256(19),
    K255Kyb512Hqc128(20),
    K448Kyb1024Hqc256(21);

    protected final int mValue;

    ZrtpKeyAgreement(int i) {
        this.mValue = i;
    }

    public static ZrtpKeyAgreement fromInt(int i) throws RuntimeException {
        switch (i) {
            case 0:
                return Invalid;
            case 1:
                return Dh2K;
            case 2:
                return Dh3K;
            case 3:
                return Ec25;
            case 4:
                return Ec38;
            case 5:
                return Ec52;
            case 6:
                return X255;
            case 7:
                return X448;
            case 8:
                return K255;
            case 9:
                return K448;
            case 10:
                return Kyb1;
            case 11:
                return Kyb2;
            case 12:
                return Kyb3;
            case 13:
                return Hqc1;
            case 14:
                return Hqc2;
            case 15:
                return Hqc3;
            case 16:
                return K255Kyb512;
            case 17:
                return K255Hqc128;
            case 18:
                return K448Kyb1024;
            case 19:
                return K448Hqc256;
            case 20:
                return K255Kyb512Hqc128;
            case 21:
                return K448Kyb1024Hqc256;
            default:
                throw new RuntimeException("Unhandled enum value " + i + " for ZrtpKeyAgreement");
        }
    }

    protected static ZrtpKeyAgreement[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        ZrtpKeyAgreement[] zrtpKeyAgreementArr = new ZrtpKeyAgreement[length];
        for (int i = 0; i < length; i++) {
            zrtpKeyAgreementArr[i] = fromInt(iArr[i]);
        }
        return zrtpKeyAgreementArr;
    }

    protected static int[] toIntArray(ZrtpKeyAgreement[] zrtpKeyAgreementArr) throws RuntimeException {
        int length = zrtpKeyAgreementArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = zrtpKeyAgreementArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
