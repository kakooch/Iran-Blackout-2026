package ir.nasim;

import android.view.View;

/* renamed from: ir.nasim.ts4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC21636ts4 {
    private InterfaceC11950dp3 a;
    private int b;
    private int c;
    private boolean d;
    private boolean e;

    public AbstractC21636ts4(InterfaceC11950dp3 interfaceC11950dp3) {
        this.a = interfaceC11950dp3;
    }

    public void a() {
        if (this.d) {
            InterfaceC11950dp3 interfaceC11950dp3 = this.a;
            if (interfaceC11950dp3 != null) {
                interfaceC11950dp3.a();
            }
            this.d = false;
        }
    }

    public final boolean b() {
        return this.e;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.b;
    }

    public abstract View e();

    public final boolean f() {
        return this.d;
    }

    public abstract boolean g();

    public final void h(boolean z) {
        InterfaceC11950dp3 interfaceC11950dp3 = this.a;
        if (interfaceC11950dp3 != null) {
            interfaceC11950dp3.b(z);
        }
        this.e = z;
    }

    protected void i(int i) {
        this.c = i;
    }

    public void j(int i) {
        this.b = i;
    }

    public void k(int i) {
        if (this.d && i == c()) {
            return;
        }
        i(i);
        InterfaceC11950dp3 interfaceC11950dp3 = this.a;
        if (interfaceC11950dp3 != null) {
            interfaceC11950dp3.c(c(), e());
        }
        this.d = true;
    }

    public void l(int i) {
        if (i == c() || !this.d) {
            return;
        }
        k(i);
    }
}
