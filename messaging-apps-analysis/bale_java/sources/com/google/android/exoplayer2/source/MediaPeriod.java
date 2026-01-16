package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.SequenceableLoader;
import ir.nasim.C22738vk6;
import ir.nasim.InterfaceC13679ge2;

/* loaded from: classes2.dex */
public interface MediaPeriod extends SequenceableLoader {

    public interface Callback extends SequenceableLoader.Callback<MediaPeriod> {
        void j(MediaPeriod mediaPeriod);
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    long a();

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    boolean c();

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    boolean d(long j);

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    long e();

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    void f(long j);

    long i(InterfaceC13679ge2[] interfaceC13679ge2Arr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j);

    long k(long j);

    long l();

    void m(Callback callback, long j);

    void q();

    long r(long j, C22738vk6 c22738vk6);

    TrackGroupArray t();

    void u(long j, boolean z);
}
