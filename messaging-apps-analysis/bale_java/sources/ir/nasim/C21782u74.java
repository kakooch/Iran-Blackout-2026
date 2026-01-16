package ir.nasim;

import android.gov.nist.core.Separators;
import androidx.recyclerview.widget.RecyclerView;
import com.google.protobuf.BytesValue;

/* renamed from: ir.nasim.u74, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C21782u74 extends YT4 {
    private final RT4 b;

    /* renamed from: ir.nasim.u74$a */
    public static final class a {
        public static final C1623a b = new C1623a(null);
        private static final a c;
        private final BytesValue a;

        /* renamed from: ir.nasim.u74$a$a, reason: collision with other inner class name */
        public static final class C1623a {
            private C1623a() {
            }

            public final a a() {
                return a.c;
            }

            public /* synthetic */ C1623a(ED1 ed1) {
                this();
            }
        }

        static {
            BytesValue defaultInstance = BytesValue.getDefaultInstance();
            AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
            c = new a(defaultInstance);
        }

        public a(BytesValue bytesValue) {
            AbstractC13042fc3.i(bytesValue, "load");
            this.a = bytesValue;
        }

        public final BytesValue b() {
            return this.a;
        }

        public final a c(BytesValue bytesValue, boolean z) {
            AbstractC13042fc3.i(bytesValue, "load");
            if (z) {
                return null;
            }
            return new a(bytesValue);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && AbstractC13042fc3.d(this.a, ((a) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "SearchPage(load=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.u74$b */
    static final class b extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C21782u74.this.f(null, this);
        }
    }

    public C21782u74(RT4 rt4) {
        AbstractC13042fc3.i(rt4, "searchListDataLoader");
        this.b = rt4;
    }

    private final Object j(a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
        return this.b.a(aVar.b(), interfaceC20295rm1);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.YT4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(ir.nasim.YT4.a r5, ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ir.nasim.C21782u74.b
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.u74$b r0 = (ir.nasim.C21782u74.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.u74$b r0 = new ir.nasim.u74$b
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.a
            ir.nasim.u74$a r5 = (ir.nasim.C21782u74.a) r5
            ir.nasim.AbstractC10685c16.b(r6)
            goto L51
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            ir.nasim.AbstractC10685c16.b(r6)
            java.lang.Object r5 = r5.a()
            ir.nasim.u74$a r5 = (ir.nasim.C21782u74.a) r5
            if (r5 != 0) goto L46
            ir.nasim.u74$a$a r5 = ir.nasim.C21782u74.a.b
            ir.nasim.u74$a r5 = r5.a()
        L46:
            r0.a = r5
            r0.d = r3
            java.lang.Object r6 = r4.j(r5, r0)
            if (r6 != r1) goto L51
            return r1
        L51:
            ir.nasim.XV4 r6 = (ir.nasim.XV4) r6
            java.lang.Object r0 = r6.e()
            java.util.List r0 = (java.util.List) r0
            boolean r0 = r0.isEmpty()
            ir.nasim.YT4$b$c r1 = new ir.nasim.YT4$b$c
            java.lang.Object r2 = r6.e()
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r6 = r6.f()
            com.google.protobuf.BytesValue r6 = (com.google.protobuf.BytesValue) r6
            ir.nasim.u74$a r5 = r5.c(r6, r0)
            r6 = 0
            r1.<init>(r2, r6, r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21782u74.f(ir.nasim.YT4$a, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.YT4
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public a d(ZT4 zt4) {
        AbstractC13042fc3.i(zt4, "state");
        return null;
    }
}
