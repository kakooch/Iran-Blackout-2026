package com.fasterxml.jackson.core.util;

import java.lang.ref.SoftReference;

/* loaded from: classes.dex */
public class BufferRecyclers {
    private static final ThreadLocalBufferManager _bufferRecyclerTracker;
    protected static final ThreadLocal<SoftReference<BufferRecycler>> _recyclerRef;

    static {
        boolean zEquals;
        try {
            zEquals = "true".equals(System.getProperty("com.fasterxml.jackson.core.util.BufferRecyclers.trackReusableBuffers"));
        } catch (SecurityException unused) {
            zEquals = false;
        }
        _bufferRecyclerTracker = zEquals ? ThreadLocalBufferManager.instance() : null;
        _recyclerRef = new ThreadLocal<>();
    }

    public static BufferRecycler getBufferRecycler() {
        SoftReference<BufferRecycler> softReference;
        ThreadLocal<SoftReference<BufferRecycler>> threadLocal = _recyclerRef;
        SoftReference<BufferRecycler> softReference2 = threadLocal.get();
        BufferRecycler bufferRecycler = softReference2 == null ? null : softReference2.get();
        if (bufferRecycler == null) {
            bufferRecycler = new BufferRecycler();
            ThreadLocalBufferManager threadLocalBufferManager = _bufferRecyclerTracker;
            if (threadLocalBufferManager != null) {
                softReference = threadLocalBufferManager.wrapAndTrack(bufferRecycler);
            } else {
                softReference = new SoftReference<>(bufferRecycler);
            }
            threadLocal.set(softReference);
        }
        return bufferRecycler;
    }
}
