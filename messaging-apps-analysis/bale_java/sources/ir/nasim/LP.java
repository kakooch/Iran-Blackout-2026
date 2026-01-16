package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes4.dex */
public abstract class LP {
    public static final b a = new b(null);

    public static final class b {
        private b() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:84:0x0174  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x017f  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x0185  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final ir.nasim.LP a(java.lang.Throwable r11, ir.nasim.EnumC10415ba2 r12) {
            /*
                Method dump skipped, instructions count: 490
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.LP.b.a(java.lang.Throwable, ir.nasim.ba2):ir.nasim.LP");
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    public static final class c extends LP {
        public static final c b = new c();

        private c() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public int hashCode() {
            return -330346704;
        }

        public String toString() {
            return "Empty";
        }
    }

    private LP() {
    }

    public static final class a extends LP {
        private final Integer b;
        private final String c;
        private final Integer d;
        private final boolean e;
        private final EnumC10415ba2 f;
        private final String g;

        public /* synthetic */ a(Integer num, String str, Integer num2, boolean z, EnumC10415ba2 enumC10415ba2, String str2, int i, ED1 ed1) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? null : num2, z, enumC10415ba2, str2);
        }

        public final boolean a() {
            return this.e;
        }

        public final EnumC10415ba2 b() {
            return this.f;
        }

        public final String c() {
            return this.g;
        }

        public final Integer d() {
            return this.b;
        }

        public final String e() {
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
            return AbstractC13042fc3.d(this.b, aVar.b) && AbstractC13042fc3.d(this.c, aVar.c) && AbstractC13042fc3.d(this.d, aVar.d) && this.e == aVar.e && this.f == aVar.f && AbstractC13042fc3.d(this.g, aVar.g);
        }

        public final Integer f() {
            return this.d;
        }

        public int hashCode() {
            Integer num = this.b;
            int iHashCode = (((num == null ? 0 : num.hashCode()) * 31) + this.c.hashCode()) * 31;
            Integer num2 = this.d;
            int iHashCode2 = (((((iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31) + Boolean.hashCode(this.e)) * 31) + this.f.hashCode()) * 31;
            String str = this.g;
            return iHashCode2 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "Active(messageResourceId=" + this.b + ", messageText=" + this.c + ", titleResourceId=" + this.d + ", canTryAgain=" + this.e + ", errorOrigin=" + this.f + ", errorType=" + this.g + Separators.RPAREN;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Integer num, String str, Integer num2, boolean z, EnumC10415ba2 enumC10415ba2, String str2) {
            super(null);
            AbstractC13042fc3.i(str, "messageText");
            AbstractC13042fc3.i(enumC10415ba2, "errorOrigin");
            this.b = num;
            this.c = str;
            this.d = num2;
            this.e = z;
            this.f = enumC10415ba2;
            this.g = str2;
        }
    }

    public /* synthetic */ LP(ED1 ed1) {
        this();
    }
}
