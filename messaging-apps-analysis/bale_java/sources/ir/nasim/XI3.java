package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public abstract class XI3 {
    private final EnumC23849xd1 a;

    public static final class a extends XI3 {
        private final EnumC23849xd1 b;
        private final String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(EnumC23849xd1 enumC23849xd1, String str) {
            super(enumC23849xd1, null);
            AbstractC13042fc3.i(enumC23849xd1, "connectionMode");
            this.b = enumC23849xd1;
            this.c = str;
        }

        public static /* synthetic */ a c(a aVar, EnumC23849xd1 enumC23849xd1, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                enumC23849xd1 = aVar.b;
            }
            if ((i & 2) != 0) {
                str = aVar.c;
            }
            return aVar.b(enumC23849xd1, str);
        }

        public final a b(EnumC23849xd1 enumC23849xd1, String str) {
            AbstractC13042fc3.i(enumC23849xd1, "connectionMode");
            return new a(enumC23849xd1, str);
        }

        public final String d() {
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
            return this.b == aVar.b && AbstractC13042fc3.d(this.c, aVar.c);
        }

        public int hashCode() {
            int iHashCode = this.b.hashCode() * 31;
            String str = this.c;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "AnimationFromJson(connectionMode=" + this.b + ", jsonString=" + this.c + Separators.RPAREN;
        }
    }

    public static final class b extends XI3 {
        private final EnumC23849xd1 b;
        private final int c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(EnumC23849xd1 enumC23849xd1, int i) {
            super(enumC23849xd1, null);
            AbstractC13042fc3.i(enumC23849xd1, "connectionMode");
            this.b = enumC23849xd1;
            this.c = i;
        }

        public static /* synthetic */ b c(b bVar, EnumC23849xd1 enumC23849xd1, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                enumC23849xd1 = bVar.b;
            }
            if ((i2 & 2) != 0) {
                i = bVar.c;
            }
            return bVar.b(enumC23849xd1, i);
        }

        public final b b(EnumC23849xd1 enumC23849xd1, int i) {
            AbstractC13042fc3.i(enumC23849xd1, "connectionMode");
            return new b(enumC23849xd1, i);
        }

        public final int d() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.b == bVar.b && this.c == bVar.c;
        }

        public int hashCode() {
            return (this.b.hashCode() * 31) + Integer.hashCode(this.c);
        }

        public String toString() {
            return "AnimationFromResource(connectionMode=" + this.b + ", animationResId=" + this.c + Separators.RPAREN;
        }
    }

    public static final class c extends XI3 {
        private final EnumC23849xd1 b;
        private final int c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(EnumC23849xd1 enumC23849xd1, int i) {
            super(enumC23849xd1, null);
            AbstractC13042fc3.i(enumC23849xd1, "connectionMode");
            this.b = enumC23849xd1;
            this.c = i;
        }

        public static /* synthetic */ c c(c cVar, EnumC23849xd1 enumC23849xd1, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                enumC23849xd1 = cVar.b;
            }
            if ((i2 & 2) != 0) {
                i = cVar.c;
            }
            return cVar.b(enumC23849xd1, i);
        }

        public final c b(EnumC23849xd1 enumC23849xd1, int i) {
            AbstractC13042fc3.i(enumC23849xd1, "connectionMode");
            return new c(enumC23849xd1, i);
        }

        public final int d() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.b == cVar.b && this.c == cVar.c;
        }

        public int hashCode() {
            return (this.b.hashCode() * 31) + Integer.hashCode(this.c);
        }

        public String toString() {
            return "Image(connectionMode=" + this.b + ", resId=" + this.c + Separators.RPAREN;
        }
    }

    public /* synthetic */ XI3(EnumC23849xd1 enumC23849xd1, ED1 ed1) {
        this(enumC23849xd1);
    }

    public final EnumC23849xd1 a() {
        return this.a;
    }

    private XI3(EnumC23849xd1 enumC23849xd1) {
        this.a = enumC23849xd1;
    }
}
