package ir.nasim;

import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;

/* renamed from: ir.nasim.Qt7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC7218Qt7 {
    private a a;
    private InterfaceC10699c30 b;

    /* renamed from: ir.nasim.Qt7$a */
    public interface a {
        void a();
    }

    protected final InterfaceC10699c30 a() {
        return (InterfaceC10699c30) AbstractC20011rK.i(this.b);
    }

    public abstract C6740Ot7 b();

    public void c(a aVar, InterfaceC10699c30 interfaceC10699c30) {
        this.a = aVar;
        this.b = interfaceC10699c30;
    }

    protected final void d() {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a();
        }
    }

    public abstract boolean e();

    public abstract void f(Object obj);

    public void g() {
        this.a = null;
        this.b = null;
    }

    public abstract C7452Rt7 h(InterfaceC24899zO5[] interfaceC24899zO5Arr, TrackGroupArray trackGroupArray, MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.J0 j0);

    public abstract void i(com.google.android.exoplayer2.audio.a aVar);

    public abstract void j(C6740Ot7 c6740Ot7);
}
