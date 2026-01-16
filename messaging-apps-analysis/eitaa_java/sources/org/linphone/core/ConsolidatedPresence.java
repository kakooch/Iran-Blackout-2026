package org.linphone.core;

/* loaded from: classes3.dex */
public enum ConsolidatedPresence {
    Online(0),
    Busy(1),
    DoNotDisturb(2),
    Offline(3);

    protected final int mValue;

    ConsolidatedPresence(int i) {
        this.mValue = i;
    }

    public static ConsolidatedPresence fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return Online;
        }
        if (i == 1) {
            return Busy;
        }
        if (i == 2) {
            return DoNotDisturb;
        }
        if (i == 3) {
            return Offline;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for ConsolidatedPresence");
    }

    protected static ConsolidatedPresence[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        ConsolidatedPresence[] consolidatedPresenceArr = new ConsolidatedPresence[length];
        for (int i = 0; i < length; i++) {
            consolidatedPresenceArr[i] = fromInt(iArr[i]);
        }
        return consolidatedPresenceArr;
    }

    protected static int[] toIntArray(ConsolidatedPresence[] consolidatedPresenceArr) throws RuntimeException {
        int length = consolidatedPresenceArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = consolidatedPresenceArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
