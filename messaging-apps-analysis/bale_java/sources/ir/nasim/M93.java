package ir.nasim;

import android.os.Build;
import android.view.View;
import ir.nasim.B98;
import java.util.List;

/* loaded from: classes.dex */
final class M93 extends B98.b implements Runnable, InterfaceC22474vI4, View.OnAttachStateChangeListener {
    private final C20773sa8 c;
    private boolean d;
    private boolean e;
    private O98 f;

    public M93(C20773sa8 c20773sa8) {
        super(!c20773sa8.c() ? 1 : 0);
        this.c = c20773sa8;
    }

    @Override // ir.nasim.InterfaceC22474vI4
    public O98 b(View view, O98 o98) {
        this.f = o98;
        this.c.o(o98);
        if (this.d) {
            if (Build.VERSION.SDK_INT == 30) {
                view.post(this);
            }
        } else if (!this.e) {
            this.c.n(o98);
            C20773sa8.m(this.c, o98, 0, 2, null);
        }
        return this.c.c() ? O98.b : o98;
    }

    @Override // ir.nasim.B98.b
    public void c(B98 b98) {
        this.d = false;
        this.e = false;
        O98 o98 = this.f;
        if (b98.a() != 0 && o98 != null) {
            this.c.n(o98);
            this.c.o(o98);
            C20773sa8.m(this.c, o98, 0, 2, null);
        }
        this.f = null;
        super.c(b98);
    }

    @Override // ir.nasim.B98.b
    public void d(B98 b98) {
        this.d = true;
        this.e = true;
        super.d(b98);
    }

    @Override // ir.nasim.B98.b
    public O98 e(O98 o98, List list) {
        C20773sa8.m(this.c, o98, 0, 2, null);
        return this.c.c() ? O98.b : o98;
    }

    @Override // ir.nasim.B98.b
    public B98.a f(B98 b98, B98.a aVar) {
        this.d = false;
        return super.f(b98, aVar);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        view.requestApplyInsets();
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.d) {
            this.d = false;
            this.e = false;
            O98 o98 = this.f;
            if (o98 != null) {
                this.c.n(o98);
                C20773sa8.m(this.c, o98, 0, 2, null);
                this.f = null;
            }
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
    }
}
