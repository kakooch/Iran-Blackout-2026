package com.google.android.exoplayer2;

import com.google.android.exoplayer2.A0;
import com.google.android.exoplayer2.source.SampleStream;
import ir.nasim.AO5;
import ir.nasim.C15493jg5;
import ir.nasim.InterfaceC22009uW3;
import ir.nasim.InterfaceC24899zO5;

/* loaded from: classes2.dex */
public interface D0 extends A0.b {

    public interface a {
        void a();

        void b();
    }

    void B(long j, long j2);

    long C();

    void D(long j);

    InterfaceC22009uW3 E();

    boolean d();

    void f();

    int g();

    String getName();

    int getState();

    boolean h();

    SampleStream i();

    boolean j();

    void l();

    void m(AO5 ao5, X[] xArr, SampleStream sampleStream, long j, boolean z, boolean z2, long j2, long j3);

    void r();

    void reset();

    boolean s();

    void start();

    void stop();

    void t(X[] xArr, SampleStream sampleStream, long j, long j2);

    void u(int i, C15493jg5 c15493jg5);

    InterfaceC24899zO5 w();

    default void z(float f, float f2) {
    }
}
