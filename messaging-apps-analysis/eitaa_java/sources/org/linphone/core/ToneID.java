package org.linphone.core;

/* loaded from: classes3.dex */
public enum ToneID {
    Undefined(0),
    Busy(1),
    CallWaiting(2),
    CallOnHold(3),
    CallLost(4),
    CallEnd(5),
    CallNotAnswered(6);

    protected final int mValue;

    ToneID(int i) {
        this.mValue = i;
    }

    public static ToneID fromInt(int i) throws RuntimeException {
        switch (i) {
            case 0:
                return Undefined;
            case 1:
                return Busy;
            case 2:
                return CallWaiting;
            case 3:
                return CallOnHold;
            case 4:
                return CallLost;
            case 5:
                return CallEnd;
            case 6:
                return CallNotAnswered;
            default:
                throw new RuntimeException("Unhandled enum value " + i + " for ToneID");
        }
    }

    protected static ToneID[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        ToneID[] toneIDArr = new ToneID[length];
        for (int i = 0; i < length; i++) {
            toneIDArr[i] = fromInt(iArr[i]);
        }
        return toneIDArr;
    }

    protected static int[] toIntArray(ToneID[] toneIDArr) throws RuntimeException {
        int length = toneIDArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = toneIDArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
