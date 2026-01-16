package com.google.android.exoplayer2.ui;

/* loaded from: classes2.dex */
public interface B {

    public interface a {
        void a(B b, long j);

        void e(B b, long j, boolean z);

        void h(B b, long j);
    }

    void a(a aVar);

    long getPreferredUpdateDelay();

    void setAdGroupTimesMs(long[] jArr, boolean[] zArr, int i);

    void setBufferedPosition(long j);

    void setDuration(long j);

    void setEnabled(boolean z);

    void setPosition(long j);
}
