package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.er6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC12586er6 extends AbstractC17457n0 implements InterfaceC13222fr6 {
    private final String c;

    public /* synthetic */ AbstractC12586er6(C8540Wk1 c8540Wk1, ED1 ed1) {
        this(c8540Wk1);
    }

    @Override // ir.nasim.InterfaceC25103zk1
    public String b(Context context, int i, String str, boolean z) {
        AbstractC13042fc3.i(context, "context");
        return a(context, i, str, z);
    }

    @Override // ir.nasim.AbstractC17457n0
    public C23345wl7 l() {
        return null;
    }

    public final String r() {
        return this.c;
    }

    public /* synthetic */ AbstractC12586er6(C11909dl1 c11909dl1, ED1 ed1) {
        this(c11909dl1);
    }

    private AbstractC12586er6(C11909dl1 c11909dl1) {
        super(c11909dl1);
        AbstractC24063xz abstractC24063xzC = c11909dl1.c();
        AbstractC13042fc3.g(abstractC24063xzC, "null cannot be cast to non-null type ir.nasim.core.api.ApiServiceMessage");
        this.c = ((C23011wC) abstractC24063xzC).w();
    }

    private AbstractC12586er6(C8540Wk1 c8540Wk1) {
        super(c8540Wk1);
        this.c = "";
    }
}
