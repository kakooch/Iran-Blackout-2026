package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.Ar6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C3395Ar6 extends AbstractC12586er6 implements InterfaceC4499Fj7 {
    private int d;
    private String e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3395Ar6(C11909dl1 c11909dl1) {
        super(c11909dl1, (ED1) null);
        AbstractC13042fc3.i(c11909dl1, "contentContainer");
        AbstractC24063xz abstractC24063xzC = c11909dl1.c();
        C23011wC c23011wC = abstractC24063xzC instanceof C23011wC ? (C23011wC) abstractC24063xzC : null;
        AbstractC17902nl0 abstractC17902nl0U = c23011wC != null ? c23011wC.u() : null;
        C21825uC c21825uC = abstractC17902nl0U instanceof C21825uC ? (C21825uC) abstractC17902nl0U : null;
        t(c21825uC != null ? c21825uC.u() : 0);
    }

    @Override // ir.nasim.InterfaceC13222fr6
    public String a(Context context, int i, String str, boolean z) {
        AbstractC13042fc3.i(context, "context");
        int i2 = z ? AbstractC12217eE5.service_holder_group_member_kicked : AbstractC12217eE5.service_holder_channel_member_kicked;
        C24847zI7 c24847zI7 = C24847zI7.a;
        return AbstractC20655sN7.b(AbstractC20655sN7.c(context, i2, c24847zI7.a(context, c(), s(), true), C24847zI7.b(c24847zI7, context, i, str, false, 8, null)), context, c() == AbstractC5969Lp4.f());
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

    public C3395Ar6(int i) {
        this(new C11909dl1(new C23011wC("User kicked", new C21825uC(i))));
    }
}
