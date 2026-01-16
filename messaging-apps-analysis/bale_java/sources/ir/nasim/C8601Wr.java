package ir.nasim;

import android.os.Build;
import android.view.ViewConfiguration;

/* renamed from: ir.nasim.Wr, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C8601Wr implements InterfaceC18354oW7 {
    private final ViewConfiguration a;

    public C8601Wr(ViewConfiguration viewConfiguration) {
        this.a = viewConfiguration;
    }

    @Override // ir.nasim.InterfaceC18354oW7
    public long a() {
        return ViewConfiguration.getDoubleTapTimeout();
    }

    @Override // ir.nasim.InterfaceC18354oW7
    public long b() {
        return 40L;
    }

    @Override // ir.nasim.InterfaceC18354oW7
    public long c() {
        return ViewConfiguration.getLongPressTimeout();
    }

    @Override // ir.nasim.InterfaceC18354oW7
    public float d() {
        return Build.VERSION.SDK_INT >= 34 ? C9376Zr.a.b(this.a) : super.d();
    }

    @Override // ir.nasim.InterfaceC18354oW7
    public float f() {
        return this.a.getScaledMaximumFlingVelocity();
    }

    @Override // ir.nasim.InterfaceC18354oW7
    public float g() {
        return this.a.getScaledTouchSlop();
    }

    @Override // ir.nasim.InterfaceC18354oW7
    public float h() {
        return Build.VERSION.SDK_INT >= 34 ? C9376Zr.a.a(this.a) : super.h();
    }
}
