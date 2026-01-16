package ir.nasim;

import ir.nasim.InterfaceC15947kS0;

/* renamed from: ir.nasim.v24, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC22322v24 implements InterfaceC15947kS0 {
    private final String a;

    /* renamed from: ir.nasim.v24$a */
    public static final class a extends AbstractC22322v24 {
        public static final a b = new a();

        private a() {
            super("must be a member function", null);
        }

        @Override // ir.nasim.InterfaceC15947kS0
        public boolean a(AB2 ab2) {
            AbstractC13042fc3.i(ab2, "functionDescriptor");
            return ab2.N() != null;
        }
    }

    /* renamed from: ir.nasim.v24$b */
    public static final class b extends AbstractC22322v24 {
        public static final b b = new b();

        private b() {
            super("must be a member or an extension function", null);
        }

        @Override // ir.nasim.InterfaceC15947kS0
        public boolean a(AB2 ab2) {
            AbstractC13042fc3.i(ab2, "functionDescriptor");
            return (ab2.N() == null && ab2.Q() == null) ? false : true;
        }
    }

    public /* synthetic */ AbstractC22322v24(String str, ED1 ed1) {
        this(str);
    }

    @Override // ir.nasim.InterfaceC15947kS0
    public String b(AB2 ab2) {
        return InterfaceC15947kS0.a.a(this, ab2);
    }

    @Override // ir.nasim.InterfaceC15947kS0
    public String getDescription() {
        return this.a;
    }

    private AbstractC22322v24(String str) {
        this.a = str;
    }
}
