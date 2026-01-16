package ir.nasim;

import android.gov.nist.core.Separators;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public abstract class TR {
    public static final int c = 0;
    private final String a;
    private final int b;

    public static final class a extends TR {
        private final int d;
        private final int e;
        private final KR f;
        private final int g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i, int i2, KR kr, int i3) {
            super("bot", i3, null);
            AbstractC13042fc3.i(kr, "openType");
            this.d = i;
            this.e = i2;
            this.f = kr;
            this.g = i3;
        }

        @Override // ir.nasim.TR
        public int a() {
            return this.g;
        }

        public final int d() {
            return this.e;
        }

        public final KR e() {
            return this.f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.d == aVar.d && this.e == aVar.e && this.f == aVar.f && this.g == aVar.g;
        }

        public final int f() {
            return this.d;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.d) * 31) + Integer.hashCode(this.e)) * 31) + this.f.hashCode()) * 31) + Integer.hashCode(this.g);
        }

        public String toString() {
            return "Bot(peerId=" + this.d + ", messageId=" + this.e + ", openType=" + this.f + ", randomId=" + this.g + Separators.RPAREN;
        }
    }

    public static final class b extends TR {
        private final int d;

        public b(int i) {
            super("card_to_card", i, null);
            this.d = i;
        }

        @Override // ir.nasim.TR
        public int a() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && this.d == ((b) obj).d;
        }

        public int hashCode() {
            return Integer.hashCode(this.d);
        }

        public String toString() {
            return "CardToCard(randomId=" + this.d + Separators.RPAREN;
        }
    }

    public static final class c extends TR {
        private final int d;

        public c(int i) {
            super("gold_action", i, null);
            this.d = i;
        }

        @Override // ir.nasim.TR
        public int a() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && this.d == ((c) obj).d;
        }

        public int hashCode() {
            return Integer.hashCode(this.d);
        }

        public String toString() {
            return "GoldOperations(randomId=" + this.d + Separators.RPAREN;
        }
    }

    public static final class d extends TR {
        private final int d;

        public d(int i) {
            super("setting", i, null);
            this.d = i;
        }

        @Override // ir.nasim.TR
        public int a() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && this.d == ((d) obj).d;
        }

        public int hashCode() {
            return Integer.hashCode(this.d);
        }

        public String toString() {
            return "Setting(randomId=" + this.d + Separators.RPAREN;
        }
    }

    public /* synthetic */ class e {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[KR.values().length];
            try {
                iArr[KR.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KR.c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KR.d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[KR.e.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    public /* synthetic */ TR(String str, int i, ED1 ed1) {
        this(str, i);
    }

    public abstract int a();

    public final String b() {
        return this.a;
    }

    public final SR c() {
        if (!(this instanceof a)) {
            if (this instanceof b) {
                return SR.a;
            }
            if (this instanceof d) {
                return null;
            }
            if (this instanceof c) {
                return SR.b;
            }
            throw new NoWhenBranchMatchedException();
        }
        int i = e.a[((a) this).e().ordinal()];
        if (i == 1) {
            return SR.c;
        }
        if (i == 2) {
            return SR.b;
        }
        if (i == 3) {
            return null;
        }
        if (i == 4) {
            return SR.d;
        }
        throw new NoWhenBranchMatchedException();
    }

    private TR(String str, int i) {
        this.a = str;
        this.b = i;
    }
}
