package org.linphone.mediastream;

/* loaded from: classes3.dex */
public class Factory {
    public static final int DEVICE_HAS_BUILTIN_AEC = 1;
    public static final int DEVICE_HAS_BUILTIN_AEC_CRAPPY = 2;
    public static final int DEVICE_HAS_BUILTIN_OPENSLES_AEC = 8;
    public static final int DEVICE_HAS_CRAPPY_AAUDIO = 4096;
    public static final int DEVICE_HAS_CRAPPY_ANDROID_FASTRECORD = 32;
    public static final int DEVICE_HAS_CRAPPY_ANDROID_FASTTRACK = 16;
    public static final int DEVICE_HAS_CRAPPY_OPENGL = 128;
    public static final int DEVICE_HAS_CRAPPY_OPENSLES = 256;
    public static final int DEVICE_HAS_UNSTANDARD_LIBMEDIA = 64;
    public static final int DEVICE_MCH264ENC_NO_PIX_FMT_CONV = 1024;
    public static final int DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS = 2048;
    public static final int DEVICE_USE_ANDROID_CAMCORDER = 512;
    public static final int DEVICE_USE_ANDROID_MIC = 4;
    private long mNativePtr;

    private native void enableFilterFromName(long j, String str, boolean z);

    private native boolean filterFromNameEnabled(long j, String str);

    private native String getDecoderText(long j, String str);

    private native int getDeviceFlags(long j);

    private native String getEncoderText(long j, String str);

    private native void setDeviceInfo(long j, String str, String str2, String str3, int i, int i2, int i3);

    private Factory(long j) {
        this.mNativePtr = j;
    }

    public void enableFilterFromName(String str, boolean z) {
        enableFilterFromName(this.mNativePtr, str, z);
    }

    public boolean filterFromNameEnabled(String str) {
        return filterFromNameEnabled(this.mNativePtr, str);
    }

    public void setDeviceInfo(String str, String str2, String str3, int i, int i2, int i3) {
        setDeviceInfo(this.mNativePtr, str, str2, str3, i, i2, i3);
    }

    public int getDeviceFlags() {
        return getDeviceFlags(this.mNativePtr);
    }

    public String getEncoderText(String str) {
        return getEncoderText(this.mNativePtr, str);
    }

    public String getDecoderText(String str) {
        return getDecoderText(this.mNativePtr, str);
    }
}
