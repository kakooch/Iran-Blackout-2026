package ir.nasim;

/* renamed from: ir.nasim.Al1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC3336Al1 {

    /* renamed from: ir.nasim.Al1$a */
    public static final class a extends AbstractC3336Al1 {
        private final String a;
        private final C15539jl1 b;
        private final InterfaceC4557Fq2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, C15539jl1 c15539jl1, InterfaceC4557Fq2 interfaceC4557Fq2) {
            super(null);
            AbstractC13042fc3.i(str, "transitionName");
            AbstractC13042fc3.i(c15539jl1, "contentSize");
            AbstractC13042fc3.i(interfaceC4557Fq2, "flow");
            this.a = str;
            this.b = c15539jl1;
            this.c = interfaceC4557Fq2;
        }

        @Override // ir.nasim.AbstractC3336Al1
        public InterfaceC4557Fq2 a() {
            return this.c;
        }

        public final C15539jl1 b() {
            return this.b;
        }
    }

    /* renamed from: ir.nasim.Al1$b */
    public static final class b extends AbstractC3336Al1 {
        private final String a;
        private final C15539jl1 b;
        private final InterfaceC4557Fq2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, C15539jl1 c15539jl1, InterfaceC4557Fq2 interfaceC4557Fq2) {
            super(null);
            AbstractC13042fc3.i(str, "transitionName");
            AbstractC13042fc3.i(c15539jl1, "contentSize");
            AbstractC13042fc3.i(interfaceC4557Fq2, "flow");
            this.a = str;
            this.b = c15539jl1;
            this.c = interfaceC4557Fq2;
        }

        @Override // ir.nasim.AbstractC3336Al1
        public InterfaceC4557Fq2 a() {
            return this.c;
        }

        public final C15539jl1 b() {
            return this.b;
        }

        public final String c() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.Al1$c */
    public static final class c extends AbstractC3336Al1 {
        private final String a;
        private final String b;
        private final InterfaceC4557Fq2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, String str2, InterfaceC4557Fq2 interfaceC4557Fq2) {
            super(null);
            AbstractC13042fc3.i(str, "transitionName");
            AbstractC13042fc3.i(str2, "thumbnailTransitionName");
            AbstractC13042fc3.i(interfaceC4557Fq2, "flow");
            this.a = str;
            this.b = str2;
            this.c = interfaceC4557Fq2;
        }

        @Override // ir.nasim.AbstractC3336Al1
        public InterfaceC4557Fq2 a() {
            return this.c;
        }

        public final String b() {
            return this.b;
        }

        public final String c() {
            return this.a;
        }
    }

    private AbstractC3336Al1() {
    }

    public abstract InterfaceC4557Fq2 a();

    public /* synthetic */ AbstractC3336Al1(ED1 ed1) {
        this();
    }
}
