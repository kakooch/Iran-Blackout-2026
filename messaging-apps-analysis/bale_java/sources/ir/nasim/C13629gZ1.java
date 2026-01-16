package ir.nasim;

import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC9905al2;
import ir.nasim.SY1;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.gZ1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C13629gZ1 implements ZY1 {
    private static final a f = new a(null);
    public static final int g = 8;
    private final InterfaceC11759dZ1 a;
    private final InterfaceC20315ro1 b;
    private final C9528a7 c;
    private final MX1 d;
    private InterfaceC13730gj3 e;

    /* renamed from: ir.nasim.gZ1$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.gZ1$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.gZ1$b$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C13629gZ1 a;

            a(C13629gZ1 c13629gZ1) {
                this.a = c13629gZ1;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(SY1 sy1, InterfaceC20295rm1 interfaceC20295rm1) {
                String string;
                if (sy1 instanceof SY1.a) {
                    C9528a7 c9528a7 = this.a.c;
                    long jB = this.a.d.c().b();
                    InterfaceC9905al2 interfaceC9905al2A = ((SY1.a) sy1).a();
                    c9528a7.d(new C13488gJ4(jB, interfaceC9905al2A instanceof InterfaceC9905al2.a ? new C9115Yo(((InterfaceC9905al2.a) interfaceC9905al2A).a()) : new C9115Yo("")));
                } else if (sy1 instanceof SY1.b) {
                    this.a.c.d(new C12870fJ4(this.a.d.c().b(), ((SY1.b) sy1).a()));
                } else {
                    if (!(sy1 instanceof SY1.c)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    C9528a7 c9528a72 = this.a.c;
                    long jB2 = this.a.d.c().b();
                    EX1 ex1A = ((SY1.c) sy1).a();
                    c9528a72.d(new C14079hJ4(jB2, (ex1A == null || (string = ex1A.toString()) == null) ? null : new Exception(string)));
                }
                Object objB = HG1.b(60L, interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C13629gZ1.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2A = C13629gZ1.this.a.a(C13629gZ1.this.d, new FY1(null, 1, null));
                a aVar = new a(C13629gZ1.this);
                this.b = 1;
                if (interfaceC4557Fq2A.b(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C13629gZ1(InterfaceC11759dZ1 interfaceC11759dZ1, InterfaceC20315ro1 interfaceC20315ro1, C9528a7 c9528a7, MX1 mx1) {
        AbstractC13042fc3.i(interfaceC11759dZ1, "downloader");
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        AbstractC13042fc3.i(c9528a7, "manager");
        AbstractC13042fc3.i(mx1, "input");
        this.a = interfaceC11759dZ1;
        this.b = interfaceC20315ro1;
        this.c = c9528a7;
        this.d = mx1;
    }

    @Override // ir.nasim.ZY1
    public void cancel() {
        InterfaceC13730gj3 interfaceC13730gj3 = this.e;
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
        this.e = null;
    }

    @Override // ir.nasim.ZY1
    public void start() {
        InterfaceC13730gj3 interfaceC13730gj3 = this.e;
        if (interfaceC13730gj3 == null || !interfaceC13730gj3.b()) {
            this.e = AbstractC10533bm0.d(this.b, null, null, new b(null), 3, null);
        }
    }
}
