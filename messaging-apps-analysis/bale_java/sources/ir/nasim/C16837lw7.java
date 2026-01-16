package ir.nasim;

import ir.nasim.AbstractC24408ya0;
import ir.nasim.C4156Dx6;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.lw7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C16837lw7 implements InterfaceC14939ik1, AbstractC24408ya0.b {
    private final String a;
    private final boolean b;
    private final List c = new ArrayList();
    private final C4156Dx6.a d;
    private final AbstractC24408ya0 e;
    private final AbstractC24408ya0 f;
    private final AbstractC24408ya0 g;

    public C16837lw7(AbstractC3236Aa0 abstractC3236Aa0, C4156Dx6 c4156Dx6) {
        this.a = c4156Dx6.c();
        this.b = c4156Dx6.g();
        this.d = c4156Dx6.f();
        C11959dq2 c11959dq2J = c4156Dx6.e().j();
        this.e = c11959dq2J;
        C11959dq2 c11959dq2J2 = c4156Dx6.b().j();
        this.f = c11959dq2J2;
        C11959dq2 c11959dq2J3 = c4156Dx6.d().j();
        this.g = c11959dq2J3;
        abstractC3236Aa0.j(c11959dq2J);
        abstractC3236Aa0.j(c11959dq2J2);
        abstractC3236Aa0.j(c11959dq2J3);
        c11959dq2J.a(this);
        c11959dq2J2.a(this);
        c11959dq2J3.a(this);
    }

    @Override // ir.nasim.AbstractC24408ya0.b
    public void a() {
        for (int i = 0; i < this.c.size(); i++) {
            ((AbstractC24408ya0.b) this.c.get(i)).a();
        }
    }

    void c(AbstractC24408ya0.b bVar) {
        this.c.add(bVar);
    }

    public AbstractC24408ya0 f() {
        return this.f;
    }

    public AbstractC24408ya0 h() {
        return this.g;
    }

    public AbstractC24408ya0 j() {
        return this.e;
    }

    C4156Dx6.a k() {
        return this.d;
    }

    public boolean l() {
        return this.b;
    }

    @Override // ir.nasim.InterfaceC14939ik1
    public void b(List list, List list2) {
    }
}
