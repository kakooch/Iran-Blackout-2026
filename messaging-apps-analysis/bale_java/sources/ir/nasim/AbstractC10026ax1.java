package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.SIPHeaderNames;

/* renamed from: ir.nasim.ax1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC10026ax1 {

    /* renamed from: ir.nasim.ax1$a */
    public static final class a extends AbstractC10026ax1 {
        public static final a a = new a();

        private a() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return -1336742016;
        }

        public String toString() {
            return "DoNothing";
        }
    }

    /* renamed from: ir.nasim.ax1$b */
    public static final class b extends AbstractC10026ax1 {
        private final String a;
        private final String b;
        private final boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2, boolean z) {
            super(null);
            AbstractC13042fc3.i(str, "url");
            AbstractC13042fc3.i(str2, "buttonTitle");
            this.a = str;
            this.b = str2;
            this.c = z;
        }

        public final String a() {
            return this.b;
        }

        public final boolean b() {
            return this.c;
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
            return AbstractC13042fc3.d(this.a, bVar.a) && AbstractC13042fc3.d(this.b, bVar.b) && this.c == bVar.c;
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + Boolean.hashCode(this.c);
        }

        public String toString() {
            return "OpenUrl(url=" + this.a + ", buttonTitle=" + this.b + ", showInternally=" + this.c + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.ax1$c */
    public static final class c extends AbstractC10026ax1 {
        public static final c a = new c();

        private c() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public int hashCode() {
            return -305460877;
        }

        public String toString() {
            return SIPHeaderNames.UNSUPPORTED;
        }
    }

    private AbstractC10026ax1() {
    }

    public /* synthetic */ AbstractC10026ax1(ED1 ed1) {
        this();
    }
}
