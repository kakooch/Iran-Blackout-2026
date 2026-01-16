package ir.nasim;

import com.google.android.gms.internal.measurement.C2125i0;
import com.google.android.gms.internal.measurement.C2129k0;
import com.google.android.gms.internal.measurement.C2135n0;
import com.google.android.gms.internal.measurement.zzd;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class Ik8 {
    final C25140zn8 a;
    C20322ro8 b;
    final C18461oh8 c;
    private final Pv8 d;

    public Ik8() {
        C25140zn8 c25140zn8 = new C25140zn8();
        this.a = c25140zn8;
        this.b = c25140zn8.b.a();
        this.c = new C18461oh8();
        this.d = new Pv8();
        c25140zn8.d.a("internal.registerCallback", new Callable() { // from class: ir.nasim.Lg8
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.b();
            }
        });
        c25140zn8.d.a("internal.eventLogger", new Callable() { // from class: ir.nasim.fj8
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new C13815gr8(this.a.c);
            }
        });
    }

    public final C18461oh8 a() {
        return this.c;
    }

    final /* synthetic */ Vh8 b() {
        return new C18601ov8(this.d);
    }

    public final void c(C2129k0 c2129k0) throws zzd {
        Vh8 vh8;
        try {
            this.b = this.a.b.a();
            if (this.a.a(this.b, (C2135n0[]) c2129k0.C().toArray(new C2135n0[0])) instanceof Lh8) {
                throw new IllegalStateException("Program loading failed");
            }
            for (C2125i0 c2125i0 : c2129k0.A().D()) {
                List listC = c2125i0.C();
                String strB = c2125i0.B();
                Iterator it = listC.iterator();
                while (it.hasNext()) {
                    InterfaceC22720vi8 interfaceC22720vi8A = this.a.a(this.b, (C2135n0) it.next());
                    if (!(interfaceC22720vi8A instanceof C17289mi8)) {
                        throw new IllegalArgumentException("Invalid rule definition");
                    }
                    C20322ro8 c20322ro8 = this.b;
                    if (c20322ro8.h(strB)) {
                        InterfaceC22720vi8 interfaceC22720vi8D = c20322ro8.d(strB);
                        if (!(interfaceC22720vi8D instanceof Vh8)) {
                            throw new IllegalStateException("Invalid function name: ".concat(String.valueOf(strB)));
                        }
                        vh8 = (Vh8) interfaceC22720vi8D;
                    } else {
                        vh8 = null;
                    }
                    if (vh8 == null) {
                        throw new IllegalStateException("Rule function is undefined: ".concat(String.valueOf(strB)));
                    }
                    vh8.a(this.b, Collections.singletonList(interfaceC22720vi8A));
                }
            }
        } catch (Throwable th) {
            throw new zzd(th);
        }
    }

    public final void d(String str, Callable callable) {
        this.a.d.a(str, callable);
    }

    public final boolean e(C16097kh8 c16097kh8) throws zzd {
        try {
            this.c.d(c16097kh8);
            this.a.c.g("runtime.counter", new Ph8(Double.valueOf(0.0d)));
            this.d.b(this.b.a(), this.c);
            if (g()) {
                return true;
            }
            return f();
        } catch (Throwable th) {
            throw new zzd(th);
        }
    }

    public final boolean f() {
        return !this.c.c().isEmpty();
    }

    public final boolean g() {
        C18461oh8 c18461oh8 = this.c;
        return !c18461oh8.b().equals(c18461oh8.a());
    }
}
