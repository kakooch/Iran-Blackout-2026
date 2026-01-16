package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public abstract class MW1 {
    private final InterfaceC18505om2 a;

    public static final class a extends MW1 {
        private final long b;
        private final boolean c;
        private final C4512Fl2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j, boolean z, C4512Fl2 c4512Fl2) {
            super(c4512Fl2, null);
            AbstractC13042fc3.i(c4512Fl2, "source");
            this.b = j;
            this.c = z;
            this.d = c4512Fl2;
        }

        public final boolean b() {
            return this.c;
        }

        public final long c() {
            return this.b;
        }

        @Override // ir.nasim.MW1
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public C4512Fl2 a() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.b == aVar.b && this.c == aVar.c && AbstractC13042fc3.d(this.d, aVar.d);
        }

        public int hashCode() {
            return (((Long.hashCode(this.b) * 31) + Boolean.hashCode(this.c)) * 31) + this.d.hashCode();
        }

        public String toString() {
            return "Local(rid=" + this.b + ", needToBeUploaded=" + this.c + ", source=" + this.d + Separators.RPAREN;
        }
    }

    public static final class b extends MW1 {
        private final C11920dm2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(C11920dm2 c11920dm2) {
            super(c11920dm2, null);
            AbstractC13042fc3.i(c11920dm2, "source");
            this.b = c11920dm2;
        }

        @Override // ir.nasim.MW1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C11920dm2 a() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && AbstractC13042fc3.d(this.b, ((b) obj).b);
        }

        public int hashCode() {
            return this.b.hashCode();
        }

        public String toString() {
            return "Remote(source=" + this.b + Separators.RPAREN;
        }
    }

    public /* synthetic */ MW1(InterfaceC18505om2 interfaceC18505om2, ED1 ed1) {
        this(interfaceC18505om2);
    }

    public abstract InterfaceC18505om2 a();

    private MW1(InterfaceC18505om2 interfaceC18505om2) {
        this.a = interfaceC18505om2;
    }
}
