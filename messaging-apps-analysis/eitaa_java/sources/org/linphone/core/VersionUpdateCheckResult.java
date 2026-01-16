package org.linphone.core;

/* loaded from: classes3.dex */
public enum VersionUpdateCheckResult {
    UpToDate(0),
    NewVersionAvailable(1),
    Error(2);

    protected final int mValue;

    VersionUpdateCheckResult(int i) {
        this.mValue = i;
    }

    public static VersionUpdateCheckResult fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return UpToDate;
        }
        if (i == 1) {
            return NewVersionAvailable;
        }
        if (i == 2) {
            return Error;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for VersionUpdateCheckResult");
    }

    protected static VersionUpdateCheckResult[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        VersionUpdateCheckResult[] versionUpdateCheckResultArr = new VersionUpdateCheckResult[length];
        for (int i = 0; i < length; i++) {
            versionUpdateCheckResultArr[i] = fromInt(iArr[i]);
        }
        return versionUpdateCheckResultArr;
    }

    protected static int[] toIntArray(VersionUpdateCheckResult[] versionUpdateCheckResultArr) throws RuntimeException {
        int length = versionUpdateCheckResultArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = versionUpdateCheckResultArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
