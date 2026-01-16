package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC19200pw6;
import java.util.List;

/* renamed from: ir.nasim.gw6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC13863gw6 {
    private static final a a = new a(null);
    private static final List b = AbstractC10360bX0.m();

    /* renamed from: ir.nasim.gw6$a */
    private static final class a {
        private a() {
        }

        public final List a() {
            return AbstractC13863gw6.b;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.gw6$b */
    public static final class b extends AbstractC13863gw6 {
        private final int c;
        private final boolean d;
        private final int e;
        private final int f;

        public b(int i, boolean z) {
            super(null);
            this.c = i;
            this.d = z;
            this.e = 1;
            this.f = i;
        }

        @Override // ir.nasim.AbstractC13863gw6
        public int e() {
            return this.e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.c == bVar.c && this.d == bVar.d;
        }

        @Override // ir.nasim.AbstractC13863gw6
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Integer d() {
            return Integer.valueOf(this.f);
        }

        public final int g() {
            return this.c;
        }

        public final boolean h() {
            return this.d;
        }

        public int hashCode() {
            return (Integer.hashCode(this.c) * 31) + Boolean.hashCode(this.d);
        }

        public String toString() {
            return "Description(stringRes=" + this.c + ", isGroup=" + this.d + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.gw6$c */
    public static final class c extends AbstractC13863gw6 {
        private final int c;
        private final int d;
        private final boolean e;
        private final int f;
        private final int g;

        public c(int i, int i2, boolean z) {
            super(null);
            this.c = i;
            this.d = i2;
            this.e = z;
            this.g = i;
        }

        @Override // ir.nasim.AbstractC13863gw6
        public List c(AbstractC13863gw6 abstractC13863gw6) {
            AbstractC13042fc3.i(abstractC13863gw6, "other");
            c cVar = abstractC13863gw6 instanceof c ? (c) abstractC13863gw6 : null;
            if (cVar == null) {
                return null;
            }
            boolean z = cVar.e;
            return z != this.e ? AbstractC9766aX0.e(new AbstractC19200pw6.a(cVar, z)) : AbstractC13863gw6.a.a();
        }

        @Override // ir.nasim.AbstractC13863gw6
        public int e() {
            return this.f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.c == cVar.c && this.d == cVar.d && this.e == cVar.e;
        }

        @Override // ir.nasim.AbstractC13863gw6
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Integer d() {
            return Integer.valueOf(this.g);
        }

        public final int g() {
            return this.c;
        }

        public final int h() {
            return this.d;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.c) * 31) + Integer.hashCode(this.d)) * 31) + Boolean.hashCode(this.e);
        }

        public final boolean i() {
            return this.e;
        }

        public String toString() {
            return "Option(optionId=" + this.c + ", stringRes=" + this.d + ", isChecked=" + this.e + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.gw6$d */
    public static final class d extends AbstractC13863gw6 {
        private final String c;
        private final String d;
        private final boolean e;
        private final int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, String str2, boolean z) {
            super(null);
            AbstractC13042fc3.i(str, "reactionCode");
            AbstractC13042fc3.i(str2, "reaction");
            this.c = str;
            this.d = str2;
            this.e = z;
            this.f = 3;
        }

        @Override // ir.nasim.AbstractC13863gw6
        public List c(AbstractC13863gw6 abstractC13863gw6) {
            AbstractC13042fc3.i(abstractC13863gw6, "other");
            d dVar = abstractC13863gw6 instanceof d ? (d) abstractC13863gw6 : null;
            if (dVar == null) {
                return null;
            }
            boolean z = dVar.e;
            return z != this.e ? AbstractC9766aX0.e(new AbstractC19200pw6.a(dVar, z)) : AbstractC13863gw6.a.a();
        }

        @Override // ir.nasim.AbstractC13863gw6
        public int e() {
            return this.f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return AbstractC13042fc3.d(this.c, dVar.c) && AbstractC13042fc3.d(this.d, dVar.d) && this.e == dVar.e;
        }

        @Override // ir.nasim.AbstractC13863gw6
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public String d() {
            return this.c;
        }

        public final String g() {
            return this.d;
        }

        public final String h() {
            return this.c;
        }

        public int hashCode() {
            return (((this.c.hashCode() * 31) + this.d.hashCode()) * 31) + Boolean.hashCode(this.e);
        }

        public final boolean i() {
            return this.e;
        }

        public String toString() {
            return "ReactionItem(reactionCode=" + this.c + ", reaction=" + this.d + ", isSelected=" + this.e + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.gw6$e */
    public static final class e extends AbstractC13863gw6 {
        private final int c;
        private final int d;
        private final int e;

        public e(int i) {
            super(null);
            this.c = i;
            this.d = 2;
            this.e = i;
        }

        @Override // ir.nasim.AbstractC13863gw6
        public int e() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof e) && this.c == ((e) obj).c;
        }

        @Override // ir.nasim.AbstractC13863gw6
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Integer d() {
            return Integer.valueOf(this.e);
        }

        public final int g() {
            return this.c;
        }

        public int hashCode() {
            return Integer.hashCode(this.c);
        }

        public String toString() {
            return "ReactionsHeader(stringRes=" + this.c + Separators.RPAREN;
        }
    }

    private AbstractC13863gw6() {
    }

    public List c(AbstractC13863gw6 abstractC13863gw6) {
        AbstractC13042fc3.i(abstractC13863gw6, "other");
        return null;
    }

    public abstract Object d();

    public abstract int e();

    public /* synthetic */ AbstractC13863gw6(ED1 ed1) {
        this();
    }
}
