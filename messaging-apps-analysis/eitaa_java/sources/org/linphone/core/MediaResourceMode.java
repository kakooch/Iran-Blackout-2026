package org.linphone.core;

/* loaded from: classes3.dex */
public enum MediaResourceMode {
    ExclusiveMediaResources(0),
    SharedMediaResources(1);

    protected final int mValue;

    MediaResourceMode(int i) {
        this.mValue = i;
    }

    public static MediaResourceMode fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return ExclusiveMediaResources;
        }
        if (i == 1) {
            return SharedMediaResources;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for MediaResourceMode");
    }

    protected static MediaResourceMode[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        MediaResourceMode[] mediaResourceModeArr = new MediaResourceMode[length];
        for (int i = 0; i < length; i++) {
            mediaResourceModeArr[i] = fromInt(iArr[i]);
        }
        return mediaResourceModeArr;
    }

    protected static int[] toIntArray(MediaResourceMode[] mediaResourceModeArr) throws RuntimeException {
        int length = mediaResourceModeArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = mediaResourceModeArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
