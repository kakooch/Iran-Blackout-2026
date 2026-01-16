package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.Xa6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C8721Xa6 {
    private final AbstractC13778go1 a;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.Xa6$a */
    public static final class a {
        public static final a b = new a("IMAGE", 0, 0);
        public static final a c = new a("GIF", 1, 1);
        public static final a d = new a("VIDEO", 2, 1);
        private static final /* synthetic */ a[] e;
        private static final /* synthetic */ F92 f;
        private final int a;

        static {
            a[] aVarArrA = a();
            e = aVarArrA;
            f = G92.a(aVarArrA);
        }

        private a(String str, int i, int i2) {
            this.a = i2;
        }

        private static final /* synthetic */ a[] a() {
            return new a[]{b, c, d};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) e.clone();
        }

        public final int j() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.Xa6$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;
        final /* synthetic */ Context d;
        final /* synthetic */ a e;
        final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, Context context, a aVar, String str2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
            this.d = context;
            this.e = aVar;
            this.f = str2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C6906Pm2.A(this.c, this.d, this.e.j(), null, this.f);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C8721Xa6(AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(abstractC13778go1, "mainDispatcher");
        this.a = abstractC13778go1;
    }

    public final Object a(Context context, String str, String str2, a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(this.a, new b(str, context, aVar, str2, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }
}
