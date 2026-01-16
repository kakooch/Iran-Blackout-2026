package ir.nasim.contact.data;

import android.gov.nist.core.Separators;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC22163um1;
import ir.nasim.ED1;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.YT4;
import ir.nasim.ZT4;
import java.util.List;

/* loaded from: classes4.dex */
public final class b extends YT4 {
    private final int b;
    private final d c;
    private final d d;

    public static final class a {
        public static final C0989a c = new C0989a(null);
        private final int a;
        private final int b;

        /* renamed from: ir.nasim.contact.data.b$a$a, reason: collision with other inner class name */
        public static final class C0989a {
            private C0989a() {
            }

            public final a a(int i) {
                return new a(0, i);
            }

            public /* synthetic */ C0989a(ED1 ed1) {
                this();
            }
        }

        public a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public static /* synthetic */ a d(a aVar, boolean z, int i, int i2, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                i2 = aVar.b;
            }
            return aVar.c(z, i, i2);
        }

        public static /* synthetic */ a f(a aVar, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = aVar.b;
            }
            return aVar.e(i);
        }

        public final int a() {
            return this.b;
        }

        public final int b() {
            return this.a;
        }

        public final a c(boolean z, int i, int i2) {
            if (z) {
                return null;
            }
            return new a(this.a + i, i2);
        }

        public final a e(int i) {
            int i2 = this.a;
            if (i2 == 0) {
                return null;
            }
            return new a(Math.max(i2 - i, 0), Math.min(i, this.a));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b;
        }

        public int hashCode() {
            return (Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b);
        }

        public String toString() {
            return "ContactsPage(offset=" + this.a + ", loadSize=" + this.b + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.contact.data.b$b, reason: collision with other inner class name */
    static final class C0990b extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        C0990b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return b.this.f(null, this);
        }
    }

    public b(int i, d dVar, d dVar2) {
        AbstractC13042fc3.i(dVar, "baleContactDataLoader");
        AbstractC13042fc3.i(dVar2, "phoneContactDataLoader");
        this.b = i;
        this.c = dVar;
        this.d = dVar2;
    }

    private final Object j(a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
        int iB = aVar.b();
        int iA = aVar.a();
        int i = this.b;
        if (iB < i) {
            Object objA = this.c.a(iB, iA, interfaceC20295rm1);
            return objA == AbstractC14862ic3.e() ? objA : (List) objA;
        }
        Object objA2 = this.d.a(iB - i, iA, interfaceC20295rm1);
        return objA2 == AbstractC14862ic3.e() ? objA2 : (List) objA2;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.YT4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(ir.nasim.YT4.a r11, ir.nasim.InterfaceC20295rm1 r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof ir.nasim.contact.data.b.C0990b
            if (r0 == 0) goto L13
            r0 = r12
            ir.nasim.contact.data.b$b r0 = (ir.nasim.contact.data.b.C0990b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.contact.data.b$b r0 = new ir.nasim.contact.data.b$b
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r11 = r0.a
            ir.nasim.contact.data.b$a r11 = (ir.nasim.contact.data.b.a) r11
            ir.nasim.AbstractC10685c16.b(r12)
        L2c:
            r4 = r11
            goto L58
        L2e:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L36:
            ir.nasim.AbstractC10685c16.b(r12)
            java.lang.Object r12 = r11.a()
            ir.nasim.contact.data.b$a r12 = (ir.nasim.contact.data.b.a) r12
            if (r12 != 0) goto L4c
            ir.nasim.contact.data.b$a$a r12 = ir.nasim.contact.data.b.a.c
            int r11 = r11.b()
            ir.nasim.contact.data.b$a r11 = r12.a(r11)
            goto L4d
        L4c:
            r11 = r12
        L4d:
            r0.a = r11
            r0.d = r3
            java.lang.Object r12 = r10.j(r11, r0)
            if (r12 != r1) goto L2c
            return r1
        L58:
            java.util.List r12 = (java.util.List) r12
            boolean r5 = r12.isEmpty()
            ir.nasim.YT4$b$c r11 = new ir.nasim.YT4$b$c
            r0 = 0
            r1 = 0
            ir.nasim.contact.data.b$a r0 = ir.nasim.contact.data.b.a.f(r4, r0, r3, r1)
            int r6 = r12.size()
            r8 = 4
            r9 = 0
            r7 = 0
            ir.nasim.contact.data.b$a r1 = ir.nasim.contact.data.b.a.d(r4, r5, r6, r7, r8, r9)
            r11.<init>(r12, r0, r1)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.contact.data.b.f(ir.nasim.YT4$a, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.YT4
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public a d(ZT4 zt4) {
        AbstractC13042fc3.i(zt4, "state");
        int i = zt4.d().a;
        Integer numC = zt4.c();
        return numC != null ? new a(Math.max(numC.intValue() - (i / 2), 0), i) : a.c.a(i);
    }
}
