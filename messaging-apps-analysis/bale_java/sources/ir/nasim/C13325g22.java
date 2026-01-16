package ir.nasim;

import com.google.android.exoplayer2.source.TrackGroupArray;
import ir.nasim.Q12;

/* renamed from: ir.nasim.g22, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C13325g22 implements RF3 {
    private final C17595nE1 a;
    private final long b;
    private final long c;
    private boolean d;

    public C13325g22(C17595nE1 c17595nE1, long j, long j2) {
        AbstractC13042fc3.i(c17595nE1, "defaultLoadControl");
        this.a = c17595nE1;
        this.b = j;
        this.c = j2;
    }

    @Override // ir.nasim.RF3
    public boolean a() {
        return this.a.a();
    }

    @Override // ir.nasim.RF3
    public void b() {
        this.d = false;
        this.a.b();
    }

    @Override // ir.nasim.RF3
    public long c() {
        return this.a.c();
    }

    @Override // ir.nasim.RF3
    public boolean d(long j, float f, boolean z, long j2) {
        boolean z2 = this.d;
        boolean z3 = j >= (!z2 ? this.b : this.c);
        if (z3 && !z2) {
            this.d = true;
        }
        return z3 || this.a.d(j, f, z, j2);
    }

    @Override // ir.nasim.RF3
    public InterfaceC19684qm e() {
        InterfaceC19684qm interfaceC19684qmE = this.a.e();
        AbstractC13042fc3.h(interfaceC19684qmE, "getAllocator(...)");
        return interfaceC19684qmE;
    }

    @Override // ir.nasim.RF3
    public void f() {
        this.a.f();
    }

    @Override // ir.nasim.RF3
    public void g(com.google.android.exoplayer2.D0[] d0Arr, TrackGroupArray trackGroupArray, InterfaceC13679ge2[] interfaceC13679ge2Arr) {
        AbstractC13042fc3.i(d0Arr, "p0");
        AbstractC13042fc3.i(trackGroupArray, "p1");
        AbstractC13042fc3.i(interfaceC13679ge2Arr, "p2");
        this.a.g(d0Arr, trackGroupArray, interfaceC13679ge2Arr);
    }

    @Override // ir.nasim.RF3
    public void h() {
        this.a.h();
    }

    @Override // ir.nasim.RF3
    public boolean i(long j, long j2, float f) {
        return this.a.i(j, j2, f);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ C13325g22(C17595nE1 c17595nE1, long j, long j2, int i, ED1 ed1) {
        if ((i & 2) != 0) {
            Q12.a aVar = Q12.b;
            j = Q12.z(T12.r(0.1d, W12.e));
        }
        long j3 = j;
        if ((i & 4) != 0) {
            Q12.a aVar2 = Q12.b;
            j2 = Q12.z(T12.r(0.5d, W12.e));
        }
        this(c17595nE1, j3, j2);
    }
}
