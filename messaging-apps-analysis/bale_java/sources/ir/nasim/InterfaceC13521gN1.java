package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.gN1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC13521gN1 {

    /* renamed from: ir.nasim.gN1$c */
    public static final class c implements InterfaceC13521gN1 {
        public static final c a = new c();
        private static final boolean b = false;
        private static final int c = 0;

        private c() {
        }

        @Override // ir.nasim.InterfaceC13521gN1
        public boolean a() {
            return b;
        }

        @Override // ir.nasim.InterfaceC13521gN1
        public int b() {
            return c;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public int hashCode() {
            return -505858186;
        }

        public String toString() {
            return "Loading";
        }
    }

    boolean a();

    int b();

    /* renamed from: ir.nasim.gN1$a */
    public static final class a implements InterfaceC13521gN1 {
        private final int a;
        private final int b;
        private final boolean c;

        public a(int i, int i2, boolean z) {
            this.a = i;
            this.b = i2;
            this.c = z;
        }

        @Override // ir.nasim.InterfaceC13521gN1
        public boolean a() {
            return this.c;
        }

        @Override // ir.nasim.InterfaceC13521gN1
        public int b() {
            return this.a;
        }

        public final int c() {
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
            return this.a == aVar.a && this.b == aVar.b && this.c == aVar.c;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b)) * 31) + Boolean.hashCode(this.c);
        }

        public String toString() {
            return "CallLogs(badgeCount=" + this.a + ", titleResId=" + this.b + ", hasEndDivider=" + this.c + Separators.RPAREN;
        }

        public /* synthetic */ a(int i, int i2, boolean z, int i3, ED1 ed1) {
            this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? AbstractC12217eE5.call_log_dialog_tab_type_title : i2, (i3 & 4) != 0 ? true : z);
        }
    }

    /* renamed from: ir.nasim.gN1$b */
    public static final class b implements InterfaceC13521gN1 {
        private final int a;
        private final a b;
        private final boolean c;
        private final boolean d;
        private final int e;

        public b(int i, a aVar, boolean z, boolean z2, int i2) {
            AbstractC13042fc3.i(aVar, "title");
            this.a = i;
            this.b = aVar;
            this.c = z;
            this.d = z2;
            this.e = i2;
        }

        public static /* synthetic */ b d(b bVar, int i, a aVar, boolean z, boolean z2, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = bVar.a;
            }
            if ((i3 & 2) != 0) {
                aVar = bVar.b;
            }
            a aVar2 = aVar;
            if ((i3 & 4) != 0) {
                z = bVar.c;
            }
            boolean z3 = z;
            if ((i3 & 8) != 0) {
                z2 = bVar.d;
            }
            boolean z4 = z2;
            if ((i3 & 16) != 0) {
                i2 = bVar.e;
            }
            return bVar.c(i, aVar2, z3, z4, i2);
        }

        @Override // ir.nasim.InterfaceC13521gN1
        public boolean a() {
            return this.d;
        }

        @Override // ir.nasim.InterfaceC13521gN1
        public int b() {
            return this.e;
        }

        public final b c(int i, a aVar, boolean z, boolean z2, int i2) {
            AbstractC13042fc3.i(aVar, "title");
            return new b(i, aVar, z, z2, i2);
        }

        public final int e() {
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
            return this.a == bVar.a && AbstractC13042fc3.d(this.b, bVar.b) && this.c == bVar.c && this.d == bVar.d && this.e == bVar.e;
        }

        public final a f() {
            return this.b;
        }

        public final boolean g() {
            return this.c;
        }

        public b h(int i) {
            return d(this, 0, null, false, false, i, 15, null);
        }

        public int hashCode() {
            return (((((((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31) + Integer.hashCode(this.e);
        }

        public String toString() {
            return "Folder(folderId=" + this.a + ", title=" + this.b + ", isReserved=" + this.c + ", hasEndDivider=" + this.d + ", badgeCount=" + this.e + Separators.RPAREN;
        }

        public /* synthetic */ b(int i, a aVar, boolean z, boolean z2, int i2, int i3, ED1 ed1) {
            this(i, aVar, (i3 & 4) != 0 ? false : z, (i3 & 8) != 0 ? false : z2, i2);
        }

        /* renamed from: ir.nasim.gN1$b$a */
        public interface a {

            /* renamed from: ir.nasim.gN1$b$a$b, reason: collision with other inner class name */
            public static final class C1253b implements a {
                private final String a;

                private /* synthetic */ C1253b(String str) {
                    this.a = str;
                }

                public static String b(String str, Context context) {
                    AbstractC13042fc3.i(context, "context");
                    return str;
                }

                public static final /* synthetic */ C1253b c(String str) {
                    return new C1253b(str);
                }

                public static String d(String str) {
                    AbstractC13042fc3.i(str, "title");
                    return str;
                }

                public static boolean e(String str, Object obj) {
                    return (obj instanceof C1253b) && AbstractC13042fc3.d(str, ((C1253b) obj).h());
                }

                public static int f(String str) {
                    return str.hashCode();
                }

                public static String g(String str) {
                    return "UserDefined(title=" + str + Separators.RPAREN;
                }

                @Override // ir.nasim.InterfaceC13521gN1.b.a
                public String a(Context context) {
                    AbstractC13042fc3.i(context, "context");
                    return b(this.a, context);
                }

                public boolean equals(Object obj) {
                    return e(this.a, obj);
                }

                public final /* synthetic */ String h() {
                    return this.a;
                }

                public int hashCode() {
                    return f(this.a);
                }

                public String toString() {
                    return g(this.a);
                }
            }

            String a(Context context);

            /* renamed from: ir.nasim.gN1$b$a$a, reason: collision with other inner class name */
            public static final class C1252a implements a {
                private final int a;

                private /* synthetic */ C1252a(int i) {
                    this.a = i;
                }

                public static String b(int i, Context context) {
                    AbstractC13042fc3.i(context, "context");
                    String string = context.getString(i);
                    AbstractC13042fc3.h(string, "getString(...)");
                    return string;
                }

                public static final /* synthetic */ C1252a c(int i) {
                    return new C1252a(i);
                }

                public static boolean e(int i, Object obj) {
                    return (obj instanceof C1252a) && i == ((C1252a) obj).h();
                }

                public static int f(int i) {
                    return Integer.hashCode(i);
                }

                public static String g(int i) {
                    return "Predefined(titleRes=" + i + Separators.RPAREN;
                }

                @Override // ir.nasim.InterfaceC13521gN1.b.a
                public String a(Context context) {
                    AbstractC13042fc3.i(context, "context");
                    return b(this.a, context);
                }

                public boolean equals(Object obj) {
                    return e(this.a, obj);
                }

                public final /* synthetic */ int h() {
                    return this.a;
                }

                public int hashCode() {
                    return f(this.a);
                }

                public String toString() {
                    return g(this.a);
                }

                public static int d(int i) {
                    return i;
                }
            }
        }
    }
}
