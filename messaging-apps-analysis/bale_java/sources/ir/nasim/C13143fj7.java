package ir.nasim;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.fj7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C13143fj7 {
    public static final b e = new b(null);
    public final String a;
    public final Map b;
    public final Set c;
    public final Set d;

    /* renamed from: ir.nasim.fj7$a */
    public static final class a {
        public static final C1238a h = new C1238a(null);
        public final String a;
        public final String b;
        public final boolean c;
        public final int d;
        public final String e;
        public final int f;
        public final int g;

        /* renamed from: ir.nasim.fj7$a$a, reason: collision with other inner class name */
        public static final class C1238a {
            private C1238a() {
            }

            private final boolean a(String str) {
                if (str.length() == 0) {
                    return false;
                }
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                while (i < str.length()) {
                    char cCharAt = str.charAt(i);
                    int i4 = i3 + 1;
                    if (i3 == 0 && cCharAt != '(') {
                        return false;
                    }
                    if (cCharAt == '(') {
                        i2++;
                    } else if (cCharAt == ')' && i2 - 1 == 0 && i3 != str.length() - 1) {
                        return false;
                    }
                    i++;
                    i3 = i4;
                }
                return i2 == 0;
            }

            public final boolean b(String str, String str2) {
                AbstractC13042fc3.i(str, "current");
                if (AbstractC13042fc3.d(str, str2)) {
                    return true;
                }
                if (!a(str)) {
                    return false;
                }
                String strSubstring = str.substring(1, str.length() - 1);
                AbstractC13042fc3.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                return AbstractC13042fc3.d(AbstractC20762sZ6.n1(strSubstring).toString(), str2);
            }

            public /* synthetic */ C1238a(ED1 ed1) {
                this();
            }
        }

        public a(String str, String str2, boolean z, int i, String str3, int i2) {
            AbstractC13042fc3.i(str, "name");
            AbstractC13042fc3.i(str2, "type");
            this.a = str;
            this.b = str2;
            this.c = z;
            this.d = i;
            this.e = str3;
            this.f = i2;
            this.g = a(str2);
        }

        private final int a(String str) {
            if (str == null) {
                return 5;
            }
            Locale locale = Locale.US;
            AbstractC13042fc3.h(locale, "US");
            String upperCase = str.toUpperCase(locale);
            AbstractC13042fc3.h(upperCase, "this as java.lang.String).toUpperCase(locale)");
            if (AbstractC20762sZ6.X(upperCase, "INT", false, 2, null)) {
                return 3;
            }
            if (AbstractC20762sZ6.X(upperCase, "CHAR", false, 2, null) || AbstractC20762sZ6.X(upperCase, "CLOB", false, 2, null) || AbstractC20762sZ6.X(upperCase, "TEXT", false, 2, null)) {
                return 2;
            }
            if (AbstractC20762sZ6.X(upperCase, "BLOB", false, 2, null)) {
                return 5;
            }
            return (AbstractC20762sZ6.X(upperCase, "REAL", false, 2, null) || AbstractC20762sZ6.X(upperCase, "FLOA", false, 2, null) || AbstractC20762sZ6.X(upperCase, "DOUB", false, 2, null)) ? 4 : 1;
        }

        public boolean equals(Object obj) {
            String str;
            String str2;
            String str3;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a) || this.d != ((a) obj).d) {
                return false;
            }
            a aVar = (a) obj;
            if (!AbstractC13042fc3.d(this.a, aVar.a) || this.c != aVar.c) {
                return false;
            }
            if (this.f == 1 && aVar.f == 2 && (str3 = this.e) != null && !h.b(str3, aVar.e)) {
                return false;
            }
            if (this.f == 2 && aVar.f == 1 && (str2 = aVar.e) != null && !h.b(str2, this.e)) {
                return false;
            }
            int i = this.f;
            return (i == 0 || i != aVar.f || ((str = this.e) == null ? aVar.e == null : h.b(str, aVar.e))) && this.g == aVar.g;
        }

        public int hashCode() {
            return (((((this.a.hashCode() * 31) + this.g) * 31) + (this.c ? 1231 : 1237)) * 31) + this.d;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Column{name='");
            sb.append(this.a);
            sb.append("', type='");
            sb.append(this.b);
            sb.append("', affinity='");
            sb.append(this.g);
            sb.append("', notNull=");
            sb.append(this.c);
            sb.append(", primaryKeyPosition=");
            sb.append(this.d);
            sb.append(", defaultValue='");
            String str = this.e;
            if (str == null) {
                str = StringUtils.UNDEFINED;
            }
            sb.append(str);
            sb.append("'}");
            return sb.toString();
        }
    }

    /* renamed from: ir.nasim.fj7$b */
    public static final class b {
        private b() {
        }

        public final C13143fj7 a(InterfaceC12694f27 interfaceC12694f27, String str) {
            AbstractC13042fc3.i(interfaceC12694f27, "database");
            AbstractC13042fc3.i(str, "tableName");
            return AbstractC13734gj7.f(interfaceC12694f27, str);
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.fj7$c */
    public static final class c {
        public final String a;
        public final String b;
        public final String c;
        public final List d;
        public final List e;

        public c(String str, String str2, String str3, List list, List list2) {
            AbstractC13042fc3.i(str, "referenceTable");
            AbstractC13042fc3.i(str2, "onDelete");
            AbstractC13042fc3.i(str3, "onUpdate");
            AbstractC13042fc3.i(list, "columnNames");
            AbstractC13042fc3.i(list2, "referenceColumnNames");
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = list;
            this.e = list2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (AbstractC13042fc3.d(this.a, cVar.a) && AbstractC13042fc3.d(this.b, cVar.b) && AbstractC13042fc3.d(this.c, cVar.c) && AbstractC13042fc3.d(this.d, cVar.d)) {
                return AbstractC13042fc3.d(this.e, cVar.e);
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
        }

        public String toString() {
            return "ForeignKey{referenceTable='" + this.a + "', onDelete='" + this.b + " +', onUpdate='" + this.c + "', columnNames=" + this.d + ", referenceColumnNames=" + this.e + '}';
        }
    }

    /* renamed from: ir.nasim.fj7$d */
    public static final class d implements Comparable {
        private final int a;
        private final int b;
        private final String c;
        private final String d;

        public d(int i, int i2, String str, String str2) {
            AbstractC13042fc3.i(str, "from");
            AbstractC13042fc3.i(str2, "to");
            this.a = i;
            this.b = i2;
            this.c = str;
            this.d = str2;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            AbstractC13042fc3.i(dVar, "other");
            int i = this.a - dVar.a;
            return i == 0 ? this.b - dVar.b : i;
        }

        public final String h() {
            return this.c;
        }

        public final int i() {
            return this.a;
        }

        public final String j() {
            return this.d;
        }
    }

    public C13143fj7(String str, Map map, Set set, Set set2) {
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(map, "columns");
        AbstractC13042fc3.i(set, "foreignKeys");
        this.a = str;
        this.b = map;
        this.c = set;
        this.d = set2;
    }

    public static final C13143fj7 a(InterfaceC12694f27 interfaceC12694f27, String str) {
        return e.a(interfaceC12694f27, str);
    }

    public boolean equals(Object obj) {
        Set set;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C13143fj7)) {
            return false;
        }
        C13143fj7 c13143fj7 = (C13143fj7) obj;
        if (!AbstractC13042fc3.d(this.a, c13143fj7.a) || !AbstractC13042fc3.d(this.b, c13143fj7.b) || !AbstractC13042fc3.d(this.c, c13143fj7.c)) {
            return false;
        }
        Set set2 = this.d;
        if (set2 == null || (set = c13143fj7.d) == null) {
            return true;
        }
        return AbstractC13042fc3.d(set2, set);
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "TableInfo{name='" + this.a + "', columns=" + this.b + ", foreignKeys=" + this.c + ", indices=" + this.d + '}';
    }

    /* renamed from: ir.nasim.fj7$e */
    public static final class e {
        public static final a e = new a(null);
        public final String a;
        public final boolean b;
        public final List c;
        public List d;

        /* renamed from: ir.nasim.fj7$e$a */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(ED1 ed1) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.util.Collection] */
        /* JADX WARN: Type inference failed for: r5v2 */
        /* JADX WARN: Type inference failed for: r5v4, types: [java.util.ArrayList] */
        public e(String str, boolean z, List list, List list2) {
            AbstractC13042fc3.i(str, "name");
            AbstractC13042fc3.i(list, "columns");
            AbstractC13042fc3.i(list2, "orders");
            this.a = str;
            this.b = z;
            this.c = list;
            this.d = list2;
            List arrayList = list2;
            if (arrayList.isEmpty()) {
                int size = list.size();
                arrayList = new ArrayList(size);
                for (int i = 0; i < size; i++) {
                    arrayList.add(EnumC11496d63.ASC.name());
                }
            }
            this.d = (List) arrayList;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            if (this.b == eVar.b && AbstractC13042fc3.d(this.c, eVar.c) && AbstractC13042fc3.d(this.d, eVar.d)) {
                return AbstractC20153rZ6.S(this.a, "index_", false, 2, null) ? AbstractC20153rZ6.S(eVar.a, "index_", false, 2, null) : AbstractC13042fc3.d(this.a, eVar.a);
            }
            return false;
        }

        public int hashCode() {
            return ((((((AbstractC20153rZ6.S(this.a, "index_", false, 2, null) ? -1184239155 : this.a.hashCode()) * 31) + (this.b ? 1 : 0)) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public String toString() {
            return "Index{name='" + this.a + "', unique=" + this.b + ", columns=" + this.c + ", orders=" + this.d + "'}";
        }

        public e(String str, boolean z, List list) {
            AbstractC13042fc3.i(str, "name");
            AbstractC13042fc3.i(list, "columns");
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                arrayList.add(EnumC11496d63.ASC.name());
            }
            this(str, z, list, arrayList);
        }
    }
}
