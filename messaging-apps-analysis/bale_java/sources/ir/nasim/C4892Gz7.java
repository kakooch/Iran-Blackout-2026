package ir.nasim;

import ir.nasim.C22528vO4;
import java.util.HashMap;

/* renamed from: ir.nasim.Gz7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C4892Gz7 extends AbstractC21707u0 {
    private final C9528a7 b;
    private final C9528a7 c;
    private final HashMap d;
    private final HashMap e;

    public C4892Gz7(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        this.d = new HashMap();
        this.e = new HashMap();
        this.b = C22528vO4.f0(c9057Yh4);
        this.c = C4409Ez7.e0(c9057Yh4);
    }

    public C12304eO2 A(int i) {
        C12304eO2 c12304eO2;
        synchronized (this.e) {
            try {
                if (!this.e.containsKey(Integer.valueOf(i))) {
                    this.e.put(Integer.valueOf(i), new C12304eO2(i));
                }
                c12304eO2 = (C12304eO2) this.e.get(Integer.valueOf(i));
            } catch (Throwable th) {
                throw th;
            }
        }
        return c12304eO2;
    }

    public C20019rK7 B(int i) {
        C20019rK7 c20019rK7;
        synchronized (this.d) {
            try {
                if (!this.d.containsKey(Integer.valueOf(i))) {
                    this.d.put(Integer.valueOf(i), new C20019rK7(i));
                }
                c20019rK7 = (C20019rK7) this.d.get(Integer.valueOf(i));
            } catch (Throwable th) {
                throw th;
            }
        }
        return c20019rK7;
    }

    public void C(C11458d25 c11458d25) {
        this.b.d(new C22528vO4.b(c11458d25));
    }

    public void D(C11458d25 c11458d25, EnumC5360Iz7 enumC5360Iz7) {
        this.b.d(new C22528vO4.d(c11458d25, enumC5360Iz7));
    }

    public void E(C11458d25 c11458d25, EnumC5360Iz7 enumC5360Iz7, Integer num, Integer num2) {
        this.b.d(new C22528vO4.d(c11458d25, enumC5360Iz7, num, num2));
    }

    public void F(C11458d25 c11458d25, EnumC5360Iz7 enumC5360Iz7) {
        this.b.d(new C22528vO4.c(c11458d25, enumC5360Iz7));
    }
}
