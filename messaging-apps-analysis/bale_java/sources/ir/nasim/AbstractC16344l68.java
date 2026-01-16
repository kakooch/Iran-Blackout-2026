package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.model.webapp.WebAppArguments;

/* renamed from: ir.nasim.l68, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC16344l68 {

    /* renamed from: ir.nasim.l68$a */
    public static final class a extends AbstractC16344l68 {
        public static final a a = new a();

        private a() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return 1522493072;
        }

        public String toString() {
            return "Dismissed";
        }
    }

    /* renamed from: ir.nasim.l68$b */
    public static final class b extends AbstractC16344l68 {
        private final String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(null);
            AbstractC13042fc3.i(str, "webAppName");
            this.a = str;
        }

        public final String a() {
            return this.a;
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
            return "Minimized(webAppName=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.l68$c */
    public static final class c extends AbstractC16344l68 {
        private final WebAppArguments a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(WebAppArguments webAppArguments) {
            super(null);
            AbstractC13042fc3.i(webAppArguments, "webAppArguments");
            this.a = webAppArguments;
        }

        public final WebAppArguments a() {
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
            return "Restoring(webAppArguments=" + this.a + Separators.RPAREN;
        }
    }

    private AbstractC16344l68() {
    }

    public /* synthetic */ AbstractC16344l68(ED1 ed1) {
        this();
    }
}
