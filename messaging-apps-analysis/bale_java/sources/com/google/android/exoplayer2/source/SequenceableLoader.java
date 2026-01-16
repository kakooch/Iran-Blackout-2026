package com.google.android.exoplayer2.source;

/* loaded from: classes2.dex */
public interface SequenceableLoader {

    public interface Callback<T extends SequenceableLoader> {
        void g(SequenceableLoader sequenceableLoader);
    }

    long a();

    boolean c();

    boolean d(long j);

    long e();

    void f(long j);
}
