package ir.nasim;

import ir.nasim.C13245fu;

/* renamed from: ir.nasim.gA3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC13406gA3 implements C13245fu.a {

    /* renamed from: ir.nasim.gA3$a */
    public static final class a extends AbstractC13406gA3 {
        private final String a;
        private final C17929nn7 b;
        private final InterfaceC16379lA3 c;

        public a(String str, C17929nn7 c17929nn7, InterfaceC16379lA3 interfaceC16379lA3) {
            super(null);
            this.a = str;
            this.b = c17929nn7;
            this.c = interfaceC16379lA3;
        }

        @Override // ir.nasim.AbstractC13406gA3
        public InterfaceC16379lA3 a() {
            return this.c;
        }

        @Override // ir.nasim.AbstractC13406gA3
        public C17929nn7 b() {
            return this.b;
        }

        public final String c() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC13042fc3.d(this.a, aVar.a) && AbstractC13042fc3.d(b(), aVar.b()) && AbstractC13042fc3.d(a(), aVar.a());
        }

        public int hashCode() {
            int iHashCode = this.a.hashCode() * 31;
            C17929nn7 c17929nn7B = b();
            int iHashCode2 = (iHashCode + (c17929nn7B != null ? c17929nn7B.hashCode() : 0)) * 31;
            InterfaceC16379lA3 interfaceC16379lA3A = a();
            return iHashCode2 + (interfaceC16379lA3A != null ? interfaceC16379lA3A.hashCode() : 0);
        }

        public String toString() {
            return "LinkAnnotation.Clickable(tag=" + this.a + ')';
        }
    }

    /* renamed from: ir.nasim.gA3$b */
    public static final class b extends AbstractC13406gA3 {
        private final String a;
        private final C17929nn7 b;
        private final InterfaceC16379lA3 c;

        public /* synthetic */ b(String str, C17929nn7 c17929nn7, InterfaceC16379lA3 interfaceC16379lA3, int i, ED1 ed1) {
            this(str, (i & 2) != 0 ? null : c17929nn7, (i & 4) != 0 ? null : interfaceC16379lA3);
        }

        @Override // ir.nasim.AbstractC13406gA3
        public InterfaceC16379lA3 a() {
            return this.c;
        }

        @Override // ir.nasim.AbstractC13406gA3
        public C17929nn7 b() {
            return this.b;
        }

        public final String c() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC13042fc3.d(this.a, bVar.a) && AbstractC13042fc3.d(b(), bVar.b()) && AbstractC13042fc3.d(a(), bVar.a());
        }

        public int hashCode() {
            int iHashCode = this.a.hashCode() * 31;
            C17929nn7 c17929nn7B = b();
            int iHashCode2 = (iHashCode + (c17929nn7B != null ? c17929nn7B.hashCode() : 0)) * 31;
            InterfaceC16379lA3 interfaceC16379lA3A = a();
            return iHashCode2 + (interfaceC16379lA3A != null ? interfaceC16379lA3A.hashCode() : 0);
        }

        public String toString() {
            return "LinkAnnotation.Url(url=" + this.a + ')';
        }

        public b(String str, C17929nn7 c17929nn7, InterfaceC16379lA3 interfaceC16379lA3) {
            super(null);
            this.a = str;
            this.b = c17929nn7;
            this.c = interfaceC16379lA3;
        }
    }

    private AbstractC13406gA3() {
    }

    public abstract InterfaceC16379lA3 a();

    public abstract C17929nn7 b();

    public /* synthetic */ AbstractC13406gA3(ED1 ed1) {
        this();
    }
}
