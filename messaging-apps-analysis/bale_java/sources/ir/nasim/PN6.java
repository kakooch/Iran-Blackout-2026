package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* loaded from: classes7.dex */
public final class PN6 {
    private final List a;
    private final a b;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class a {
        public static final a a = new a("ENABLED", 0);
        public static final a b = new a("DISABLED", 1);
        public static final a c = new a("LOADING", 2);
        private static final /* synthetic */ a[] d;
        private static final /* synthetic */ F92 e;

        static {
            a[] aVarArrA = a();
            d = aVarArrA;
            e = G92.a(aVarArrA);
        }

        private a(String str, int i) {
        }

        private static final /* synthetic */ a[] a() {
            return new a[]{a, b, c};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) d.clone();
        }
    }

    public interface b {

        public static final class a implements b {
            private final long a;
            private final long b;
            private final boolean c;

            public a(long j, long j2, boolean z) {
                this.a = j;
                this.b = j2;
                this.c = z;
            }

            @Override // ir.nasim.PN6.b
            public boolean a() {
                return this.c;
            }

            @Override // ir.nasim.PN6.b
            public long b() {
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

            @Override // ir.nasim.PN6.b
            public long getId() {
                return this.a;
            }

            public int hashCode() {
                return (((Long.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31) + Boolean.hashCode(this.c);
            }

            public String toString() {
                return "Audios(id=" + this.a + ", allocatedSize=" + this.b + ", isSelected=" + this.c + Separators.RPAREN;
            }
        }

        /* renamed from: ir.nasim.PN6$b$b, reason: collision with other inner class name */
        public static final class C0575b implements b {
            private final long a;
            private final long b;
            private final boolean c;

            public C0575b(long j, long j2, boolean z) {
                this.a = j;
                this.b = j2;
                this.c = z;
            }

            @Override // ir.nasim.PN6.b
            public boolean a() {
                return this.c;
            }

            @Override // ir.nasim.PN6.b
            public long b() {
                return this.b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0575b)) {
                    return false;
                }
                C0575b c0575b = (C0575b) obj;
                return this.a == c0575b.a && this.b == c0575b.b && this.c == c0575b.c;
            }

            @Override // ir.nasim.PN6.b
            public long getId() {
                return this.a;
            }

            public int hashCode() {
                return (((Long.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31) + Boolean.hashCode(this.c);
            }

            public String toString() {
                return "Documents(id=" + this.a + ", allocatedSize=" + this.b + ", isSelected=" + this.c + Separators.RPAREN;
            }
        }

        public static final class c implements b {
            private final long a;
            private final long b;
            private final boolean c;

            public c(long j, long j2, boolean z) {
                this.a = j;
                this.b = j2;
                this.c = z;
            }

            @Override // ir.nasim.PN6.b
            public boolean a() {
                return this.c;
            }

            @Override // ir.nasim.PN6.b
            public long b() {
                return this.b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof c)) {
                    return false;
                }
                c cVar = (c) obj;
                return this.a == cVar.a && this.b == cVar.b && this.c == cVar.c;
            }

            @Override // ir.nasim.PN6.b
            public long getId() {
                return this.a;
            }

            public int hashCode() {
                return (((Long.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31) + Boolean.hashCode(this.c);
            }

            public String toString() {
                return "Images(id=" + this.a + ", allocatedSize=" + this.b + ", isSelected=" + this.c + Separators.RPAREN;
            }
        }

        public static final class d implements b {
            private final long a;
            private final long b;
            private final boolean c;

            public d(long j, long j2, boolean z) {
                this.a = j;
                this.b = j2;
                this.c = z;
            }

            @Override // ir.nasim.PN6.b
            public boolean a() {
                return this.c;
            }

            @Override // ir.nasim.PN6.b
            public long b() {
                return this.b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof d)) {
                    return false;
                }
                d dVar = (d) obj;
                return this.a == dVar.a && this.b == dVar.b && this.c == dVar.c;
            }

            @Override // ir.nasim.PN6.b
            public long getId() {
                return this.a;
            }

            public int hashCode() {
                return (((Long.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31) + Boolean.hashCode(this.c);
            }

            public String toString() {
                return "Stories(id=" + this.a + ", allocatedSize=" + this.b + ", isSelected=" + this.c + Separators.RPAREN;
            }
        }

        public static final class e implements b {
            private final long a;
            private final long b;
            private final boolean c;

            public e(long j, long j2, boolean z) {
                this.a = j;
                this.b = j2;
                this.c = z;
            }

            @Override // ir.nasim.PN6.b
            public boolean a() {
                return this.c;
            }

            @Override // ir.nasim.PN6.b
            public long b() {
                return this.b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof e)) {
                    return false;
                }
                e eVar = (e) obj;
                return this.a == eVar.a && this.b == eVar.b && this.c == eVar.c;
            }

            @Override // ir.nasim.PN6.b
            public long getId() {
                return this.a;
            }

            public int hashCode() {
                return (((Long.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31) + Boolean.hashCode(this.c);
            }

            public String toString() {
                return "Videos(id=" + this.a + ", allocatedSize=" + this.b + ", isSelected=" + this.c + Separators.RPAREN;
            }
        }

        boolean a();

        long b();

        long getId();
    }

    public PN6(List list, a aVar) {
        AbstractC13042fc3.i(list, "items");
        AbstractC13042fc3.i(aVar, "buttonState");
        this.a = list;
        this.b = aVar;
    }

    public final a a() {
        return this.b;
    }

    public final List b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PN6)) {
            return false;
        }
        PN6 pn6 = (PN6) obj;
        return AbstractC13042fc3.d(this.a, pn6.a) && this.b == pn6.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "StorageManagerBottomSheetState(items=" + this.a + ", buttonState=" + this.b + Separators.RPAREN;
    }
}
