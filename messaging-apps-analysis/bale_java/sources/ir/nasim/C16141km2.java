package ir.nasim;

import android.gov.nist.core.Separators;
import androidx.recyclerview.widget.RecyclerView;
import com.google.protobuf.BytesValue;
import java.util.ArrayList;

/* renamed from: ir.nasim.km2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C16141km2 extends YT4 {
    private final C11458d25 b;
    private final String c;
    private final C13168fm2 d;
    private final InterfaceC20315ro1 e;

    /* renamed from: ir.nasim.km2$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.km2$a$a, reason: collision with other inner class name */
        static final class C1361a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C16141km2 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1361a(C16141km2 c16141km2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c16141km2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C1361a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.c.e();
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(ArrayList arrayList, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1361a) create(arrayList, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C16141km2.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10040ay6 interfaceC10040ay6C = C16141km2.this.d.c();
                C1361a c1361a = new C1361a(C16141km2.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10040ay6C, c1361a, this) == objE) {
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
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.km2$b */
    public static final class b {
        public static final a b = new a(null);
        private static final b c;
        private final BytesValue a;

        /* renamed from: ir.nasim.km2$b$a */
        public static final class a {
            private a() {
            }

            public final b a() {
                return b.c;
            }

            public /* synthetic */ a(ED1 ed1) {
                this();
            }
        }

        static {
            BytesValue defaultInstance = BytesValue.getDefaultInstance();
            AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
            c = new b(defaultInstance);
        }

        public b(BytesValue bytesValue) {
            AbstractC13042fc3.i(bytesValue, "load");
            this.a = bytesValue;
        }

        public final BytesValue b() {
            return this.a;
        }

        public final b c(BytesValue bytesValue, boolean z) {
            AbstractC13042fc3.i(bytesValue, "load");
            if (z) {
                return null;
            }
            return new b(bytesValue);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && AbstractC13042fc3.d(this.a, ((b) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "SearchPage(load=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.km2$c */
    static final class c extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C16141km2.this.f(null, this);
        }
    }

    public C16141km2(C11458d25 c11458d25, String str, C13168fm2 c13168fm2, InterfaceC20315ro1 interfaceC20315ro1) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(str, "query");
        AbstractC13042fc3.i(c13168fm2, "repository");
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        this.b = c11458d25;
        this.c = str;
        this.d = c13168fm2;
        this.e = interfaceC20315ro1;
        AbstractC10533bm0.d(interfaceC20315ro1, null, null, new a(null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.YT4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(ir.nasim.YT4.a r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof ir.nasim.C16141km2.c
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.km2$c r0 = (ir.nasim.C16141km2.c) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.km2$c r0 = new ir.nasim.km2$c
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r7 = r0.a
            ir.nasim.km2$b r7 = (ir.nasim.C16141km2.b) r7
            ir.nasim.AbstractC10685c16.b(r8)
            goto L5b
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            ir.nasim.AbstractC10685c16.b(r8)
            java.lang.Object r7 = r7.a()
            ir.nasim.km2$b r7 = (ir.nasim.C16141km2.b) r7
            if (r7 != 0) goto L46
            ir.nasim.km2$b$a r7 = ir.nasim.C16141km2.b.b
            ir.nasim.km2$b r7 = r7.a()
        L46:
            ir.nasim.fm2 r8 = r6.d
            ir.nasim.d25 r2 = r6.b
            com.google.protobuf.BytesValue r4 = r7.b()
            java.lang.String r5 = r6.c
            r0.a = r7
            r0.d = r3
            java.lang.Object r8 = r8.j(r2, r4, r5, r0)
            if (r8 != r1) goto L5b
            return r1
        L5b:
            ir.nasim.XV4 r8 = (ir.nasim.XV4) r8
            java.lang.Object r0 = r8.e()
            java.util.List r0 = (java.util.List) r0
            boolean r0 = r0.isEmpty()
            ir.nasim.YT4$b$c r1 = new ir.nasim.YT4$b$c
            java.lang.Object r2 = r8.e()
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r8 = r8.f()
            com.google.protobuf.BytesValue r8 = (com.google.protobuf.BytesValue) r8
            ir.nasim.km2$b r7 = r7.c(r8, r0)
            r8 = 0
            r1.<init>(r2, r8, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C16141km2.f(ir.nasim.YT4$a, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.YT4
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public b d(ZT4 zt4) {
        AbstractC13042fc3.i(zt4, "state");
        return null;
    }
}
