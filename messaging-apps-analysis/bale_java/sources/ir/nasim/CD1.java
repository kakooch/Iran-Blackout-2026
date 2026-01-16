package ir.nasim;

import android.content.Context;
import ir.nasim.InterfaceC4439Fd1;

/* loaded from: classes2.dex */
final class CD1 implements InterfaceC4439Fd1 {
    private final Context a;
    final InterfaceC4439Fd1.a b;

    CD1(Context context, InterfaceC4439Fd1.a aVar) {
        this.a = context.getApplicationContext();
        this.b = aVar;
    }

    private void b() {
        FD6.a(this.a).d(this.b);
    }

    private void d() {
        FD6.a(this.a).e(this.b);
    }

    @Override // ir.nasim.InterfaceC17451mz3
    public void f() {
        b();
    }

    @Override // ir.nasim.InterfaceC17451mz3
    public void i() {
        d();
    }

    @Override // ir.nasim.InterfaceC17451mz3
    public void onDestroy() {
    }
}
