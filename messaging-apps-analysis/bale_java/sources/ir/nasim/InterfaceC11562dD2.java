package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.dD2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public interface InterfaceC11562dD2 {

    /* renamed from: ir.nasim.dD2$a */
    public static final class a implements InterfaceC11562dD2 {
        public static final a a = new a();
        private static final int b = KB5.icon_emoji;

        private a() {
        }

        @Override // ir.nasim.InterfaceC11562dD2
        public int a() {
            return b;
        }
    }

    /* renamed from: ir.nasim.dD2$b */
    public static final class b implements InterfaceC11562dD2 {
        private final int a;
        private final int b = KB5.icon_emoji;

        public b(int i) {
            this.a = i;
        }

        @Override // ir.nasim.InterfaceC11562dD2
        public int a() {
            return this.b;
        }

        public final int b() {
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
            return "DefaultKeyboard(height=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.dD2$c */
    public static final class c implements InterfaceC11562dD2 {
        private final Integer a;
        private final int b = KB5.ic_keyboard;

        public c(Integer num) {
            this.a = num;
        }

        @Override // ir.nasim.InterfaceC11562dD2
        public int a() {
            return this.b;
        }

        public final Integer b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && AbstractC13042fc3.d(this.a, ((c) obj).a);
        }

        public int hashCode() {
            Integer num = this.a;
            if (num == null) {
                return 0;
            }
            return num.hashCode();
        }

        public String toString() {
            return "SmileKeyboard(height=" + this.a + Separators.RPAREN;
        }
    }

    int a();
}
