package org.linphone.core;

/* loaded from: classes3.dex */
public enum StreamType {
    Audio(0),
    Video(1),
    Text(2),
    Unknown(3);

    protected final int mValue;

    StreamType(int i) {
        this.mValue = i;
    }

    public static StreamType fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return Audio;
        }
        if (i == 1) {
            return Video;
        }
        if (i == 2) {
            return Text;
        }
        if (i == 3) {
            return Unknown;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for StreamType");
    }

    protected static StreamType[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        StreamType[] streamTypeArr = new StreamType[length];
        for (int i = 0; i < length; i++) {
            streamTypeArr[i] = fromInt(iArr[i]);
        }
        return streamTypeArr;
    }

    protected static int[] toIntArray(StreamType[] streamTypeArr) throws RuntimeException {
        int length = streamTypeArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = streamTypeArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
