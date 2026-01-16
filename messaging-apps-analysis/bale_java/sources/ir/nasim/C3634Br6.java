package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.Br6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C3634Br6 extends AbstractC12586er6 implements InterfaceC4499Fj7 {
    private int d;
    private String e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3634Br6(C11909dl1 c11909dl1) {
        super(c11909dl1, (ED1) null);
        AbstractC13042fc3.i(c11909dl1, "contentContainer");
        AbstractC24063xz abstractC24063xzC = c11909dl1.c();
        C23011wC c23011wC = abstractC24063xzC instanceof C23011wC ? (C23011wC) abstractC24063xzC : null;
        AbstractC17902nl0 abstractC17902nl0U = c23011wC != null ? c23011wC.u() : null;
        C22415vC c22415vC = abstractC17902nl0U instanceof C22415vC ? (C22415vC) abstractC17902nl0U : null;
        t(c22415vC != null ? c22415vC.u() : 0);
    }

    @Override // ir.nasim.InterfaceC13222fr6
    public String a(Context context, int i, String str, boolean z) {
        AbstractC13042fc3.i(context, "context");
        if (c() != 0) {
            i = c();
        }
        if (c() != 0) {
            str = s();
        }
        return AbstractC20655sN7.b(AbstractC20655sN7.c(context, z ? AbstractC12217eE5.service_holder_group_member_left : AbstractC12217eE5.service_holder_channel_member_left, C24847zI7.a.a(context, i, str, i != AbstractC5969Lp4.f())), context, i == AbstractC5969Lp4.f());
    }

    @Override // ir.nasim.InterfaceC4499Fj7
    public int c() {
        return this.d;
    }

    @Override // ir.nasim.InterfaceC4499Fj7
    public void d(String str) {
        this.e = str;
    }

    public String s() {
        return this.e;
    }

    public void t(int i) {
        this.d = i;
    }

    public C3634Br6(int i) {
        this(new C11909dl1(new C23011wC("User leave", new C22415vC(i))));
    }
}
