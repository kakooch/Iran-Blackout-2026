package org.webrtc;

/* loaded from: classes3.dex */
class Histogram {
    private final long handle;

    private static native void nativeAddSample(long handle, int sample);

    private static native long nativeCreateCounts(String name, int min, int max, int bucketCount);

    private static native long nativeCreateEnumeration(String name, int max);

    private Histogram(long handle) {
        this.handle = handle;
    }

    public static Histogram createCounts(String name, int min, int max, int bucketCount) {
        return new Histogram(nativeCreateCounts(name, min, max, bucketCount));
    }

    public static Histogram createEnumeration(String name, int max) {
        return new Histogram(nativeCreateEnumeration(name, max));
    }

    public void addSample(int sample) {
        nativeAddSample(this.handle, sample);
    }
}
