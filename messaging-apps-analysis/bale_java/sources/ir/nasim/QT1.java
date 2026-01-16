package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* loaded from: classes7.dex */
public abstract class QT1 {
    private final long a;

    public static final class a extends QT1 {
        private final List b;
        private final InterfaceC6897Pl2 c;
        private final UA2 d;
        private final UA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(List list, InterfaceC6897Pl2 interfaceC6897Pl2, UA2 ua2, UA2 ua22) {
            super(4L, null);
            AbstractC13042fc3.i(list, "roots");
            AbstractC13042fc3.i(interfaceC6897Pl2, "fileMatcher");
            AbstractC13042fc3.i(ua2, "onBeforeDeleting");
            AbstractC13042fc3.i(ua22, "onAfterDeleting");
            this.b = list;
            this.c = interfaceC6897Pl2;
            this.d = ua2;
            this.e = ua22;
        }

        @Override // ir.nasim.QT1
        public InterfaceC6897Pl2 a() {
            return this.c;
        }

        @Override // ir.nasim.QT1
        public UA2 c() {
            return this.e;
        }

        @Override // ir.nasim.QT1
        public UA2 d() {
            return this.d;
        }

        @Override // ir.nasim.QT1
        public List e() {
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
            return AbstractC13042fc3.d(this.b, aVar.b) && AbstractC13042fc3.d(this.c, aVar.c) && AbstractC13042fc3.d(this.d, aVar.d) && AbstractC13042fc3.d(this.e, aVar.e);
        }

        public int hashCode() {
            return (((((this.b.hashCode() * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
        }

        public String toString() {
            return "Audios(roots=" + this.b + ", fileMatcher=" + this.c + ", onBeforeDeleting=" + this.d + ", onAfterDeleting=" + this.e + Separators.RPAREN;
        }
    }

    public static final class b extends QT1 {
        private final List b;
        private final InterfaceC6897Pl2 c;
        private final UA2 d;
        private final UA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(List list, InterfaceC6897Pl2 interfaceC6897Pl2, UA2 ua2, UA2 ua22) {
            super(3L, null);
            AbstractC13042fc3.i(list, "roots");
            AbstractC13042fc3.i(interfaceC6897Pl2, "fileMatcher");
            AbstractC13042fc3.i(ua2, "onBeforeDeleting");
            AbstractC13042fc3.i(ua22, "onAfterDeleting");
            this.b = list;
            this.c = interfaceC6897Pl2;
            this.d = ua2;
            this.e = ua22;
        }

        @Override // ir.nasim.QT1
        public InterfaceC6897Pl2 a() {
            return this.c;
        }

        @Override // ir.nasim.QT1
        public UA2 c() {
            return this.e;
        }

        @Override // ir.nasim.QT1
        public UA2 d() {
            return this.d;
        }

        @Override // ir.nasim.QT1
        public List e() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC13042fc3.d(this.b, bVar.b) && AbstractC13042fc3.d(this.c, bVar.c) && AbstractC13042fc3.d(this.d, bVar.d) && AbstractC13042fc3.d(this.e, bVar.e);
        }

        public int hashCode() {
            return (((((this.b.hashCode() * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
        }

        public String toString() {
            return "Documents(roots=" + this.b + ", fileMatcher=" + this.c + ", onBeforeDeleting=" + this.d + ", onAfterDeleting=" + this.e + Separators.RPAREN;
        }
    }

    public static final class c extends QT1 {
        private final List b;
        private final InterfaceC6897Pl2 c;
        private final UA2 d;
        private final UA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(List list, InterfaceC6897Pl2 interfaceC6897Pl2, UA2 ua2, UA2 ua22) {
            super(1L, null);
            AbstractC13042fc3.i(list, "roots");
            AbstractC13042fc3.i(interfaceC6897Pl2, "fileMatcher");
            AbstractC13042fc3.i(ua2, "onBeforeDeleting");
            AbstractC13042fc3.i(ua22, "onAfterDeleting");
            this.b = list;
            this.c = interfaceC6897Pl2;
            this.d = ua2;
            this.e = ua22;
        }

        @Override // ir.nasim.QT1
        public InterfaceC6897Pl2 a() {
            return this.c;
        }

        @Override // ir.nasim.QT1
        public UA2 c() {
            return this.e;
        }

        @Override // ir.nasim.QT1
        public UA2 d() {
            return this.d;
        }

        @Override // ir.nasim.QT1
        public List e() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return AbstractC13042fc3.d(this.b, cVar.b) && AbstractC13042fc3.d(this.c, cVar.c) && AbstractC13042fc3.d(this.d, cVar.d) && AbstractC13042fc3.d(this.e, cVar.e);
        }

        public int hashCode() {
            return (((((this.b.hashCode() * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
        }

        public String toString() {
            return "Images(roots=" + this.b + ", fileMatcher=" + this.c + ", onBeforeDeleting=" + this.d + ", onAfterDeleting=" + this.e + Separators.RPAREN;
        }
    }

    public static final class d extends QT1 {
        private final List b;
        private final InterfaceC6897Pl2 c;
        private final UA2 d;
        private final UA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(List list, InterfaceC6897Pl2 interfaceC6897Pl2, UA2 ua2, UA2 ua22) {
            super(5L, null);
            AbstractC13042fc3.i(list, "roots");
            AbstractC13042fc3.i(interfaceC6897Pl2, "fileMatcher");
            AbstractC13042fc3.i(ua2, "onBeforeDeleting");
            AbstractC13042fc3.i(ua22, "onAfterDeleting");
            this.b = list;
            this.c = interfaceC6897Pl2;
            this.d = ua2;
            this.e = ua22;
        }

        @Override // ir.nasim.QT1
        public InterfaceC6897Pl2 a() {
            return this.c;
        }

        @Override // ir.nasim.QT1
        public UA2 c() {
            return this.e;
        }

        @Override // ir.nasim.QT1
        public UA2 d() {
            return this.d;
        }

        @Override // ir.nasim.QT1
        public List e() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return AbstractC13042fc3.d(this.b, dVar.b) && AbstractC13042fc3.d(this.c, dVar.c) && AbstractC13042fc3.d(this.d, dVar.d) && AbstractC13042fc3.d(this.e, dVar.e);
        }

        public int hashCode() {
            return (((((this.b.hashCode() * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
        }

        public String toString() {
            return "Stories(roots=" + this.b + ", fileMatcher=" + this.c + ", onBeforeDeleting=" + this.d + ", onAfterDeleting=" + this.e + Separators.RPAREN;
        }
    }

    public static final class e extends QT1 {
        private final List b;
        private final InterfaceC6897Pl2 c;
        private final UA2 d;
        private final UA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(List list, InterfaceC6897Pl2 interfaceC6897Pl2, UA2 ua2, UA2 ua22) {
            super(2L, null);
            AbstractC13042fc3.i(list, "roots");
            AbstractC13042fc3.i(interfaceC6897Pl2, "fileMatcher");
            AbstractC13042fc3.i(ua2, "onBeforeDeleting");
            AbstractC13042fc3.i(ua22, "onAfterDeleting");
            this.b = list;
            this.c = interfaceC6897Pl2;
            this.d = ua2;
            this.e = ua22;
        }

        @Override // ir.nasim.QT1
        public InterfaceC6897Pl2 a() {
            return this.c;
        }

        @Override // ir.nasim.QT1
        public UA2 c() {
            return this.e;
        }

        @Override // ir.nasim.QT1
        public UA2 d() {
            return this.d;
        }

        @Override // ir.nasim.QT1
        public List e() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return AbstractC13042fc3.d(this.b, eVar.b) && AbstractC13042fc3.d(this.c, eVar.c) && AbstractC13042fc3.d(this.d, eVar.d) && AbstractC13042fc3.d(this.e, eVar.e);
        }

        public int hashCode() {
            return (((((this.b.hashCode() * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
        }

        public String toString() {
            return "Videos(roots=" + this.b + ", fileMatcher=" + this.c + ", onBeforeDeleting=" + this.d + ", onAfterDeleting=" + this.e + Separators.RPAREN;
        }
    }

    public /* synthetic */ QT1(long j, ED1 ed1) {
        this(j);
    }

    public abstract InterfaceC6897Pl2 a();

    public final long b() {
        return this.a;
    }

    public abstract UA2 c();

    public abstract UA2 d();

    public abstract List e();

    private QT1(long j) {
        this.a = j;
    }
}
