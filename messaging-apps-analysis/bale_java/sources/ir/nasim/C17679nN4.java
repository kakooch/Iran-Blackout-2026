package ir.nasim;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;

/* renamed from: ir.nasim.nN4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C17679nN4 extends C17088mN4 {
    C17679nN4(int i, Surface surface) {
        this(new OutputConfiguration(i, surface));
    }

    static C17679nN4 m(OutputConfiguration outputConfiguration) {
        return new C17679nN4(outputConfiguration);
    }

    @Override // ir.nasim.AbstractC18270oN4, ir.nasim.C15315jN4.a
    public void a(long j) {
        if (j == -1) {
            return;
        }
        ((OutputConfiguration) h()).setStreamUseCase(j);
    }

    @Override // ir.nasim.C16497lN4, ir.nasim.AbstractC18270oN4, ir.nasim.C15315jN4.a
    public /* bridge */ /* synthetic */ void b(Surface surface) {
        super.b(surface);
    }

    @Override // ir.nasim.C17088mN4, ir.nasim.C16497lN4, ir.nasim.C15906kN4, ir.nasim.C15315jN4.a
    public void c(long j) {
        ((OutputConfiguration) h()).setDynamicRangeProfile(j);
    }

    @Override // ir.nasim.C17088mN4, ir.nasim.C16497lN4, ir.nasim.C15906kN4, ir.nasim.C15315jN4.a
    public /* bridge */ /* synthetic */ void d(String str) {
        super.d(str);
    }

    @Override // ir.nasim.C17088mN4, ir.nasim.C16497lN4, ir.nasim.C15906kN4, ir.nasim.C15315jN4.a
    public /* bridge */ /* synthetic */ String e() {
        return super.e();
    }

    @Override // ir.nasim.AbstractC18270oN4
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // ir.nasim.C16497lN4, ir.nasim.C15906kN4, ir.nasim.C15315jN4.a
    public /* bridge */ /* synthetic */ void f() {
        super.f();
    }

    @Override // ir.nasim.AbstractC18270oN4, ir.nasim.C15315jN4.a
    public void g(int i) {
        ((OutputConfiguration) h()).setMirrorMode(i);
    }

    @Override // ir.nasim.C15906kN4, ir.nasim.AbstractC18270oN4, ir.nasim.C15315jN4.a
    public /* bridge */ /* synthetic */ Surface getSurface() {
        return super.getSurface();
    }

    @Override // ir.nasim.C17088mN4, ir.nasim.C16497lN4, ir.nasim.C15906kN4, ir.nasim.C15315jN4.a
    public Object h() {
        AbstractC4980Hj5.a(this.a instanceof OutputConfiguration);
        return this.a;
    }

    @Override // ir.nasim.AbstractC18270oN4
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    C17679nN4(Object obj) {
        super(obj);
    }
}
