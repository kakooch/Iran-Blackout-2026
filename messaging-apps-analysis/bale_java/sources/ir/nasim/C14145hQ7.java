package ir.nasim;

import java.util.Collections;

/* renamed from: ir.nasim.hQ7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C14145hQ7 extends AbstractC24408ya0 {
    private final Object i;

    public C14145hQ7(C13505gL3 c13505gL3) {
        this(c13505gL3, null);
    }

    @Override // ir.nasim.AbstractC24408ya0
    float c() {
        return 1.0f;
    }

    @Override // ir.nasim.AbstractC24408ya0
    public Object h() {
        C13505gL3 c13505gL3 = this.e;
        Object obj = this.i;
        return c13505gL3.b(0.0f, 0.0f, obj, obj, f(), f(), f());
    }

    @Override // ir.nasim.AbstractC24408ya0
    Object i(C24561yp3 c24561yp3, float f) {
        return h();
    }

    @Override // ir.nasim.AbstractC24408ya0
    public void l() {
        if (this.e != null) {
            super.l();
        }
    }

    @Override // ir.nasim.AbstractC24408ya0
    public void n(float f) {
        this.d = f;
    }

    public C14145hQ7(C13505gL3 c13505gL3, Object obj) {
        super(Collections.emptyList());
        o(c13505gL3);
        this.i = obj;
    }
}
