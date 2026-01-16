package ir.nasim;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: ir.nasim.yX7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C24388yX7 {
    private Interpolator c;
    InterfaceC24982zX7 d;
    private boolean e;
    private long b = -1;
    private final AX7 f = new a();
    final ArrayList a = new ArrayList();

    /* renamed from: ir.nasim.yX7$a */
    class a extends AX7 {
        private boolean a = false;
        private int b = 0;

        a() {
        }

        @Override // ir.nasim.InterfaceC24982zX7
        public void b(View view) {
            int i = this.b + 1;
            this.b = i;
            if (i == C24388yX7.this.a.size()) {
                InterfaceC24982zX7 interfaceC24982zX7 = C24388yX7.this.d;
                if (interfaceC24982zX7 != null) {
                    interfaceC24982zX7.b(null);
                }
                d();
            }
        }

        @Override // ir.nasim.AX7, ir.nasim.InterfaceC24982zX7
        public void c(View view) {
            if (this.a) {
                return;
            }
            this.a = true;
            InterfaceC24982zX7 interfaceC24982zX7 = C24388yX7.this.d;
            if (interfaceC24982zX7 != null) {
                interfaceC24982zX7.c(null);
            }
        }

        void d() {
            this.b = 0;
            this.a = false;
            C24388yX7.this.b();
        }
    }

    public void a() {
        if (this.e) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((C23798xX7) it.next()).c();
            }
            this.e = false;
        }
    }

    void b() {
        this.e = false;
    }

    public C24388yX7 c(C23798xX7 c23798xX7) {
        if (!this.e) {
            this.a.add(c23798xX7);
        }
        return this;
    }

    public C24388yX7 d(C23798xX7 c23798xX7, C23798xX7 c23798xX72) {
        this.a.add(c23798xX7);
        c23798xX72.j(c23798xX7.d());
        this.a.add(c23798xX72);
        return this;
    }

    public C24388yX7 e(long j) {
        if (!this.e) {
            this.b = j;
        }
        return this;
    }

    public C24388yX7 f(Interpolator interpolator) {
        if (!this.e) {
            this.c = interpolator;
        }
        return this;
    }

    public C24388yX7 g(InterfaceC24982zX7 interfaceC24982zX7) {
        if (!this.e) {
            this.d = interfaceC24982zX7;
        }
        return this;
    }

    public void h() {
        if (this.e) {
            return;
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            C23798xX7 c23798xX7 = (C23798xX7) it.next();
            long j = this.b;
            if (j >= 0) {
                c23798xX7.f(j);
            }
            Interpolator interpolator = this.c;
            if (interpolator != null) {
                c23798xX7.g(interpolator);
            }
            if (this.d != null) {
                c23798xX7.h(this.f);
            }
            c23798xX7.l();
        }
        this.e = true;
    }
}
