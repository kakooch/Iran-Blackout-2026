package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.yr6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24584yr6 extends AbstractC12586er6 implements InterfaceC4499Fj7 {
    public static final a f = new a(null);
    public static final int g = 8;
    private int d;
    private String e;

    /* renamed from: ir.nasim.yr6$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C24584yr6(C11909dl1 c11909dl1) {
        super(c11909dl1, (ED1) null);
        AbstractC13042fc3.i(c11909dl1, "contentContainer");
        AbstractC24063xz abstractC24063xzC = c11909dl1.c();
        C23011wC c23011wC = abstractC24063xzC instanceof C23011wC ? (C23011wC) abstractC24063xzC : null;
        AbstractC17902nl0 abstractC17902nl0U = c23011wC != null ? c23011wC.u() : null;
        C20548sC c20548sC = abstractC17902nl0U instanceof C20548sC ? (C20548sC) abstractC17902nl0U : null;
        t(c20548sC != null ? c20548sC.u() : 0);
    }

    @Override // ir.nasim.InterfaceC13222fr6
    public String a(Context context, int i, String str, boolean z) {
        AbstractC13042fc3.i(context, "context");
        if (i == 0) {
            if (z) {
                return AbstractC20655sN7.b(AbstractC20655sN7.c(context, AbstractC12217eE5.service_holder_group_member_joined, C24847zI7.a.a(context, c(), str, true)), context, c() == AbstractC5969Lp4.f());
            }
            String string = context.getString(AbstractC12217eE5.service_holder_channel_member_joined);
            AbstractC13042fc3.f(string);
            return string;
        }
        if (z) {
            boolean z2 = c() == AbstractC5969Lp4.f();
            int i2 = AbstractC12217eE5.service_holder_group_member_invited;
            C24847zI7 c24847zI7 = C24847zI7.a;
            return AbstractC20655sN7.b(AbstractC20655sN7.c(context, i2, c24847zI7.a(context, c(), s(), !z2), c24847zI7.a(context, i, str, z2)), context, c() == AbstractC5969Lp4.f());
        }
        if (c() != AbstractC5969Lp4.f()) {
            return AbstractC20655sN7.c(context, AbstractC12217eE5.service_holder_channel_member_invited_by_me, C24847zI7.b(C24847zI7.a, context, c(), s(), false, 8, null));
        }
        String string2 = context.getString(AbstractC12217eE5.service_holder_channel_member_invited);
        AbstractC13042fc3.f(string2);
        return string2;
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

    public C24584yr6(int i) {
        this(new C11909dl1(new C23011wC("User added", new C20548sC(i))));
    }
}
