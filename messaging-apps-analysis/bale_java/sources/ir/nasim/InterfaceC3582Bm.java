package ir.nasim;

import android.os.Looper;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.z0;
import ir.nasim.InterfaceC10699c30;
import java.util.List;

/* renamed from: ir.nasim.Bm, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC3582Bm extends z0.d, MediaSourceEventListener, InterfaceC10699c30.a, com.google.android.exoplayer2.drm.h {
    void A(JB1 jb1);

    void D(JB1 jb1);

    void E(com.google.android.exoplayer2.X x, MB1 mb1);

    void G(int i, long j);

    void I(Object obj, long j);

    void L(Exception exc);

    void M(com.google.android.exoplayer2.X x, MB1 mb1);

    void N(int i, long j, long j2);

    void N0();

    void O(long j, int i);

    void V3(List list, MediaSource.MediaPeriodId mediaPeriodId);

    void c(Exception exc);

    void c5(InterfaceC6170Mm interfaceC6170Mm);

    void d(JB1 jb1);

    void d5(InterfaceC6170Mm interfaceC6170Mm);

    void f(String str);

    void g(String str, long j, long j2);

    void j(JB1 jb1);

    void m(String str);

    void n(String str, long j, long j2);

    void n1(com.google.android.exoplayer2.z0 z0Var, Looper looper);

    void release();

    void w(long j);

    void y(Exception exc);
}
