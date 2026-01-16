package org.linphone.core;

/* loaded from: classes3.dex */
public enum RecorderFileFormat {
    Unknown(0),
    Wav(1),
    Mkv(2);

    protected final int mValue;

    RecorderFileFormat(int i) {
        this.mValue = i;
    }

    public static RecorderFileFormat fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return Unknown;
        }
        if (i == 1) {
            return Wav;
        }
        if (i == 2) {
            return Mkv;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for RecorderFileFormat");
    }

    protected static RecorderFileFormat[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        RecorderFileFormat[] recorderFileFormatArr = new RecorderFileFormat[length];
        for (int i = 0; i < length; i++) {
            recorderFileFormatArr[i] = fromInt(iArr[i]);
        }
        return recorderFileFormatArr;
    }

    protected static int[] toIntArray(RecorderFileFormat[] recorderFileFormatArr) throws RuntimeException {
        int length = recorderFileFormatArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = recorderFileFormatArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
