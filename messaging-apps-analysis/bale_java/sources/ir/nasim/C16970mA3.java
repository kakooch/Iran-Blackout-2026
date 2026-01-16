package ir.nasim;

import android.gov.nist.core.Separators;
import androidx.recyclerview.widget.RecyclerView;
import com.google.protobuf.BytesValue;
import java.util.List;

/* renamed from: ir.nasim.mA3, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C16970mA3 extends YT4 {
    private final EA3 b;

    /* renamed from: ir.nasim.mA3$a */
    public static final class a {
        private final List a;
        private final BytesValue b;

        public a(List list, BytesValue bytesValue) {
            AbstractC13042fc3.i(list, "data");
            AbstractC13042fc3.i(bytesValue, "loadKey");
            this.a = list;
            this.b = bytesValue;
        }

        public final List a() {
            return this.a;
        }

        public final BytesValue b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC13042fc3.d(this.a, aVar.a) && AbstractC13042fc3.d(this.b, aVar.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            return "LinkPage(data=" + this.a + ", loadKey=" + this.b + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.mA3$b */
    public static final class b {
        public static final a b = new a(null);
        private static final b c;
        private final BytesValue a;

        /* renamed from: ir.nasim.mA3$b$a */
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

    /* renamed from: ir.nasim.mA3$c */
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
            return C16970mA3.this.f(null, this);
        }
    }

    public C16970mA3(EA3 ea3) {
        AbstractC13042fc3.i(ea3, "linkDataSource");
        this.b = ea3;
    }

    private final Object j(b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
        return bVar.b().getValue().isEmpty() ? EA3.k(this.b, null, null, false, interfaceC20295rm1, 7, null) : this.b.i(bVar.b(), interfaceC20295rm1);
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
            boolean r0 = r6 instanceof ir.nasim.C16970mA3.c
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.mA3$c r0 = (ir.nasim.C16970mA3.c) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.mA3$c r0 = new ir.nasim.mA3$c
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.a
            ir.nasim.mA3$b r5 = (ir.nasim.C16970mA3.b) r5
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
            ir.nasim.mA3$b r5 = (ir.nasim.C16970mA3.b) r5
            if (r5 != 0) goto L46
            ir.nasim.mA3$b$a r5 = ir.nasim.C16970mA3.b.b
            ir.nasim.mA3$b r5 = r5.a()
        L46:
            r0.a = r5
            r0.d = r3
            java.lang.Object r6 = r4.j(r5, r0)
            if (r6 != r1) goto L51
            return r1
        L51:
            ir.nasim.mA3$a r6 = (ir.nasim.C16970mA3.a) r6
            java.util.List r0 = r6.a()
            boolean r0 = r0.isEmpty()
            ir.nasim.YT4$b$c r1 = new ir.nasim.YT4$b$c
            java.util.List r2 = r6.a()
            com.google.protobuf.BytesValue r6 = r6.b()
            ir.nasim.mA3$b r5 = r5.c(r6, r0)
            r6 = 0
            r1.<init>(r2, r6, r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C16970mA3.f(ir.nasim.YT4$a, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.YT4
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public b d(ZT4 zt4) {
        AbstractC13042fc3.i(zt4, "state");
        return null;
    }
}
