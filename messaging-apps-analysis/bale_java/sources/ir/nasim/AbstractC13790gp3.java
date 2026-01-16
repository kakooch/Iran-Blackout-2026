package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;

/* renamed from: ir.nasim.gp3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC13790gp3 {

    /* renamed from: ir.nasim.gp3$a */
    public static final class a extends AbstractC13790gp3 {
        private final String a;
        private final String b;
        private final TO5 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, TO5 to5) {
            super(null);
            AbstractC13042fc3.i(str, ParameterNames.TEXT);
            AbstractC13042fc3.i(str2, "id");
            AbstractC13042fc3.i(to5, "actionType");
            this.a = str;
            this.b = str2;
            this.c = to5;
        }

        @Override // ir.nasim.AbstractC13790gp3
        public String a() {
            return this.a;
        }

        public final TO5 b() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC13042fc3.d(this.a, aVar.a) && AbstractC13042fc3.d(this.b, aVar.b) && AbstractC13042fc3.d(this.c, aVar.c);
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "CustomAction(text=" + this.a + ", id=" + this.b + ", actionType=" + this.c + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.gp3$b */
    public static final class b extends AbstractC13790gp3 {
        private final String a;
        private final String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2) {
            super(null);
            AbstractC13042fc3.i(str, ParameterNames.TEXT);
            AbstractC13042fc3.i(str2, "url");
            this.a = str;
            this.b = str2;
        }

        @Override // ir.nasim.AbstractC13790gp3
        public String a() {
            return this.a;
        }

        public final String b() {
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
            return AbstractC13042fc3.d(this.a, bVar.a) && AbstractC13042fc3.d(this.b, bVar.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            return "OpenWebApp(text=" + this.a + ", url=" + this.b + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.gp3$c */
    public static final class c extends AbstractC13790gp3 {
        private final String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(null);
            AbstractC13042fc3.i(str, ParameterNames.TEXT);
            this.a = str;
        }

        @Override // ir.nasim.AbstractC13790gp3
        public String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && AbstractC13042fc3.d(this.a, ((c) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "RequestContact(text=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.gp3$d */
    public static final class d extends AbstractC13790gp3 {
        private final String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str) {
            super(null);
            AbstractC13042fc3.i(str, ParameterNames.TEXT);
            this.a = str;
        }

        @Override // ir.nasim.AbstractC13790gp3
        public String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && AbstractC13042fc3.d(this.a, ((d) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "RequestLocation(text=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.gp3$e */
    public static final class e extends AbstractC13790gp3 {
        private final String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str) {
            super(null);
            AbstractC13042fc3.i(str, ParameterNames.TEXT);
            this.a = str;
        }

        @Override // ir.nasim.AbstractC13790gp3
        public String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof e) && AbstractC13042fc3.d(this.a, ((e) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "SendMessage(text=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.gp3$f */
    public static final class f extends AbstractC13790gp3 {
        public static final f a = new f();

        private f() {
            super(null);
        }

        @Override // ir.nasim.AbstractC13790gp3
        public String a() {
            return "/start";
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof f);
        }

        public int hashCode() {
            return -459776122;
        }

        public String toString() {
            return "SendStart";
        }
    }

    /* renamed from: ir.nasim.gp3$g */
    public static final class g extends AbstractC13790gp3 {
        private final String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str) {
            super(null);
            AbstractC13042fc3.i(str, ParameterNames.TEXT);
            this.a = str;
        }

        @Override // ir.nasim.AbstractC13790gp3
        public String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof g) && AbstractC13042fc3.d(this.a, ((g) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "Unsupported(text=" + this.a + Separators.RPAREN;
        }
    }

    private AbstractC13790gp3() {
    }

    public abstract String a();

    public /* synthetic */ AbstractC13790gp3(ED1 ed1) {
        this();
    }
}
