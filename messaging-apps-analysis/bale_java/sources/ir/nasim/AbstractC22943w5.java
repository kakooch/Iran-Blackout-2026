package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;

/* renamed from: ir.nasim.w5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC22943w5 {

    /* renamed from: ir.nasim.w5$a */
    public static final class a extends AbstractC22943w5 {
        private final InterfaceC10258bL6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterfaceC10258bL6 interfaceC10258bL6) {
            super(null);
            AbstractC13042fc3.i(interfaceC10258bL6, "count");
            this.a = interfaceC10258bL6;
        }

        public final InterfaceC10258bL6 a() {
            return this.a;
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
            return "SeenCountText(count=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.w5$b */
    public static final class b extends AbstractC22943w5 {
        private final int a;

        public b(int i) {
            super(null);
            this.a = i;
        }

        public final int a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && this.a == ((b) obj).a;
        }

        public int hashCode() {
            return Integer.hashCode(this.a);
        }

        public String toString() {
            return "StringResource(textRes=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.w5$c */
    public static final class c extends AbstractC22943w5 {
        private final String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(null);
            AbstractC13042fc3.i(str, ParameterNames.TEXT);
            this.a = str;
        }

        public final String a() {
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
            return "Text(text=" + this.a + Separators.RPAREN;
        }
    }

    private AbstractC22943w5() {
    }

    public /* synthetic */ AbstractC22943w5(ED1 ed1) {
        this();
    }
}
