package ir.nasim;

import android.content.Intent;

/* renamed from: ir.nasim.Bp, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC3609Bp implements InterfaceC21014sz3 {
    private AbstractC3843Cp a;

    public AbstractC3609Bp(AbstractC3843Cp abstractC3843Cp) {
        this.a = abstractC3843Cp;
    }

    @Override // ir.nasim.InterfaceC21014sz3
    public InterfaceC22912w18 a() {
        return this.a.c();
    }

    @Override // ir.nasim.InterfaceC21014sz3
    public void b() {
        this.a.d();
    }

    @Override // ir.nasim.InterfaceC21014sz3
    public boolean c() {
        return this.a.g();
    }

    @Override // ir.nasim.InterfaceC21014sz3
    public void d() {
        this.a.e();
    }

    @Override // ir.nasim.InterfaceC21014sz3
    public void e(Intent intent) {
        this.a.f(intent);
    }

    @Override // ir.nasim.InterfaceC21014sz3
    public void f() {
        this.a.b();
    }

    @Override // ir.nasim.InterfaceC21014sz3
    public String getVersion() {
        return this.a.a();
    }
}
