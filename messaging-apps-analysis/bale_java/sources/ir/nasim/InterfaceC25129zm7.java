package ir.nasim;

import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.zm7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC25129zm7 {
    public static final a a = a.a;

    /* renamed from: ir.nasim.zm7$a */
    public static final class a {
        static final /* synthetic */ a a = new a();

        private a() {
        }

        public final InterfaceC25129zm7 a(AbstractC12520el0 abstractC12520el0, float f) {
            if (abstractC12520el0 == null) {
                return b.b;
            }
            if (abstractC12520el0 instanceof CH6) {
                return b(AbstractC5000Hl7.c(((CH6) abstractC12520el0).b(), f));
            }
            if (abstractC12520el0 instanceof AbstractC4147Dw6) {
                return new C15538jl0((AbstractC4147Dw6) abstractC12520el0, f);
            }
            throw new NoWhenBranchMatchedException();
        }

        public final InterfaceC25129zm7 b(long j) {
            return j != 16 ? new NY0(j, null) : b.b;
        }
    }

    /* renamed from: ir.nasim.zm7$b */
    public static final class b implements InterfaceC25129zm7 {
        public static final b b = new b();

        private b() {
        }

        @Override // ir.nasim.InterfaceC25129zm7
        public float a() {
            return Float.NaN;
        }

        @Override // ir.nasim.InterfaceC25129zm7
        public long d() {
            return C24381yX0.b.i();
        }

        @Override // ir.nasim.InterfaceC25129zm7
        public AbstractC12520el0 e() {
            return null;
        }
    }

    /* renamed from: ir.nasim.zm7$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {
        c() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Float invoke() {
            return Float.valueOf(InterfaceC25129zm7.this.a());
        }
    }

    /* renamed from: ir.nasim.zm7$d */
    static final class d extends AbstractC8614Ws3 implements SA2 {
        d() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC25129zm7 invoke() {
            return InterfaceC25129zm7.this;
        }
    }

    float a();

    default InterfaceC25129zm7 b(InterfaceC25129zm7 interfaceC25129zm7) {
        boolean z = interfaceC25129zm7 instanceof C15538jl0;
        return (z && (this instanceof C15538jl0)) ? new C15538jl0(((C15538jl0) interfaceC25129zm7).f(), AbstractC5000Hl7.d(interfaceC25129zm7.a(), new c())) : (!z || (this instanceof C15538jl0)) ? (z || !(this instanceof C15538jl0)) ? interfaceC25129zm7.c(new d()) : this : interfaceC25129zm7;
    }

    default InterfaceC25129zm7 c(SA2 sa2) {
        return !AbstractC13042fc3.d(this, b.b) ? this : (InterfaceC25129zm7) sa2.invoke();
    }

    long d();

    AbstractC12520el0 e();
}
