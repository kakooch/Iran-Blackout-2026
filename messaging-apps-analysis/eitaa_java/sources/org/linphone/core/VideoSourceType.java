package org.linphone.core;

/* loaded from: classes3.dex */
public enum VideoSourceType {
    Unknown(0),
    Call(1),
    Camera(2),
    Image(3);

    protected final int mValue;

    VideoSourceType(int i) {
        this.mValue = i;
    }

    public static VideoSourceType fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return Unknown;
        }
        if (i == 1) {
            return Call;
        }
        if (i == 2) {
            return Camera;
        }
        if (i == 3) {
            return Image;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for VideoSourceType");
    }

    protected static VideoSourceType[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        VideoSourceType[] videoSourceTypeArr = new VideoSourceType[length];
        for (int i = 0; i < length; i++) {
            videoSourceTypeArr[i] = fromInt(iArr[i]);
        }
        return videoSourceTypeArr;
    }

    protected static int[] toIntArray(VideoSourceType[] videoSourceTypeArr) throws RuntimeException {
        int length = videoSourceTypeArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = videoSourceTypeArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
