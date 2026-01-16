package ir.nasim;

import ir.nasim.InterfaceC15947kS0;

/* renamed from: ir.nasim.xQ7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC23735xQ7 implements InterfaceC15947kS0 {
    private final String a;

    /* renamed from: ir.nasim.xQ7$a */
    public static final class a extends AbstractC23735xQ7 {
        private final int b;

        public a(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append("must have at least ");
            sb.append(i);
            sb.append(" value parameter");
            sb.append(i > 1 ? "s" : "");
            super(sb.toString(), null);
            this.b = i;
        }

        @Override // ir.nasim.InterfaceC15947kS0
        public boolean a(AB2 ab2) {
            AbstractC13042fc3.i(ab2, "functionDescriptor");
            return ab2.h().size() >= this.b;
        }
    }

    /* renamed from: ir.nasim.xQ7$b */
    public static final class b extends AbstractC23735xQ7 {
        private final int b;

        public b(int i) {
            super("must have exactly " + i + " value parameters", null);
            this.b = i;
        }

        @Override // ir.nasim.InterfaceC15947kS0
        public boolean a(AB2 ab2) {
            AbstractC13042fc3.i(ab2, "functionDescriptor");
            return ab2.h().size() == this.b;
        }
    }

    /* renamed from: ir.nasim.xQ7$c */
    public static final class c extends AbstractC23735xQ7 {
        public static final c b = new c();

        private c() {
            super("must have no value parameters", null);
        }

        @Override // ir.nasim.InterfaceC15947kS0
        public boolean a(AB2 ab2) {
            AbstractC13042fc3.i(ab2, "functionDescriptor");
            return ab2.h().isEmpty();
        }
    }

    /* renamed from: ir.nasim.xQ7$d */
    public static final class d extends AbstractC23735xQ7 {
        public static final d b = new d();

        private d() {
            super("must have a single value parameter", null);
        }

        @Override // ir.nasim.InterfaceC15947kS0
        public boolean a(AB2 ab2) {
            AbstractC13042fc3.i(ab2, "functionDescriptor");
            return ab2.h().size() == 1;
        }
    }

    public /* synthetic */ AbstractC23735xQ7(String str, ED1 ed1) {
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

    private AbstractC23735xQ7(String str) {
        this.a = str;
    }
}
