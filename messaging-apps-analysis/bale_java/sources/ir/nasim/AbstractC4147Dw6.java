package ir.nasim;

import android.graphics.Shader;
import ir.nasim.C24381yX0;

/* renamed from: ir.nasim.Dw6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC4147Dw6 extends AbstractC12520el0 {
    private Shader c;
    private long d;

    public AbstractC4147Dw6() {
        super(null);
        this.d = OD6.b.a();
    }

    @Override // ir.nasim.AbstractC12520el0
    public final void a(long j, InterfaceC12969fU4 interfaceC12969fU4, float f) {
        Shader shaderB = this.c;
        if (shaderB == null || !OD6.f(this.d, j)) {
            if (OD6.k(j)) {
                shaderB = null;
                this.c = null;
                this.d = OD6.b.a();
            } else {
                shaderB = b(j);
                this.c = shaderB;
                this.d = j;
            }
        }
        long jD = interfaceC12969fU4.d();
        C24381yX0.a aVar = C24381yX0.b;
        if (!C24381yX0.q(jD, aVar.a())) {
            interfaceC12969fU4.k(aVar.a());
        }
        if (!AbstractC13042fc3.d(interfaceC12969fU4.r(), shaderB)) {
            interfaceC12969fU4.q(shaderB);
        }
        if (interfaceC12969fU4.a() == f) {
            return;
        }
        interfaceC12969fU4.c(f);
    }

    public abstract Shader b(long j);
}
