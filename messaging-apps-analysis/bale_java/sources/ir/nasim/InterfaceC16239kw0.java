package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.kw0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC16239kw0 {

    /* renamed from: ir.nasim.kw0$a */
    public interface a extends InterfaceC16239kw0 {
        Integer a();

        EnumC23944xm6 b();

        InterfaceC5308Iu0 c();

        int d();

        String getDescription();

        long getId();

        String getName();
    }

    /* renamed from: ir.nasim.kw0$b */
    public static final class b implements InterfaceC16239kw0 {
        private final boolean a;

        public b(boolean z) {
            this.a = z;
        }

        public final boolean e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && this.a == ((b) obj).a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.a);
        }

        public String toString() {
            return "DeleteAllSeparator(isAllSelected=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.kw0$d */
    public static final class d implements InterfaceC16239kw0 {
        public static final d a = new d();

        private d() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof d);
        }

        public int hashCode() {
            return -25384438;
        }

        public String toString() {
            return "HeaderSeparator";
        }
    }

    /* renamed from: ir.nasim.kw0$f */
    public static final class f implements InterfaceC16239kw0 {
        public static final f a = new f();

        private f() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof f);
        }

        public int hashCode() {
            return 1049725292;
        }

        public String toString() {
            return "OnBoardSeparator";
        }
    }

    /* renamed from: ir.nasim.kw0$c */
    public static final class c implements a {
        private final long a;
        private final String b;
        private final String c;
        private final int d;
        private final EnumC23944xm6 e;
        private final InterfaceC5308Iu0 f;
        private final Integer g;

        public c(long j, String str, String str2, int i, EnumC23944xm6 enumC23944xm6, InterfaceC5308Iu0 interfaceC5308Iu0, Integer num) {
            AbstractC13042fc3.i(str, "name");
            AbstractC13042fc3.i(str2, "description");
            AbstractC13042fc3.i(enumC23944xm6, "selectState");
            AbstractC13042fc3.i(interfaceC5308Iu0, "avatar");
            this.a = j;
            this.b = str;
            this.c = str2;
            this.d = i;
            this.e = enumC23944xm6;
            this.f = interfaceC5308Iu0;
            this.g = num;
        }

        @Override // ir.nasim.InterfaceC16239kw0.a
        public Integer a() {
            return this.g;
        }

        @Override // ir.nasim.InterfaceC16239kw0.a
        public EnumC23944xm6 b() {
            return this.e;
        }

        @Override // ir.nasim.InterfaceC16239kw0.a
        public InterfaceC5308Iu0 c() {
            return this.f;
        }

        @Override // ir.nasim.InterfaceC16239kw0.a
        public int d() {
            return this.d;
        }

        public final c e(long j, String str, String str2, int i, EnumC23944xm6 enumC23944xm6, InterfaceC5308Iu0 interfaceC5308Iu0, Integer num) {
            AbstractC13042fc3.i(str, "name");
            AbstractC13042fc3.i(str2, "description");
            AbstractC13042fc3.i(enumC23944xm6, "selectState");
            AbstractC13042fc3.i(interfaceC5308Iu0, "avatar");
            return new c(j, str, str2, i, enumC23944xm6, interfaceC5308Iu0, num);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.a == cVar.a && AbstractC13042fc3.d(this.b, cVar.b) && AbstractC13042fc3.d(this.c, cVar.c) && this.d == cVar.d && this.e == cVar.e && AbstractC13042fc3.d(this.f, cVar.f) && AbstractC13042fc3.d(this.g, cVar.g);
        }

        @Override // ir.nasim.InterfaceC16239kw0.a
        public String getDescription() {
            return this.c;
        }

        @Override // ir.nasim.InterfaceC16239kw0.a
        public long getId() {
            return this.a;
        }

        @Override // ir.nasim.InterfaceC16239kw0.a
        public String getName() {
            return this.b;
        }

        public int hashCode() {
            int iHashCode = ((((((((((Long.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + Integer.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
            Integer num = this.g;
            return iHashCode + (num == null ? 0 : num.hashCode());
        }

        public String toString() {
            return "GroupCallCallLog(id=" + this.a + ", name=" + this.b + ", description=" + this.c + ", iconId=" + this.d + ", selectState=" + this.e + ", avatar=" + this.f + ", peerId=" + this.g + Separators.RPAREN;
        }

        public /* synthetic */ c(long j, String str, String str2, int i, EnumC23944xm6 enumC23944xm6, InterfaceC5308Iu0 interfaceC5308Iu0, Integer num, int i2, ED1 ed1) {
            this(j, str, str2, i, (i2 & 16) != 0 ? EnumC23944xm6.c : enumC23944xm6, interfaceC5308Iu0, num);
        }
    }

    /* renamed from: ir.nasim.kw0$e */
    public static final class e implements a {
        private final long a;
        private final String b;
        private final String c;
        private final int d;
        private final EnumC23944xm6 e;
        private final InterfaceC5308Iu0 f;
        private final Integer g;

        public e(long j, String str, String str2, int i, EnumC23944xm6 enumC23944xm6, InterfaceC5308Iu0 interfaceC5308Iu0, Integer num) {
            AbstractC13042fc3.i(str, "name");
            AbstractC13042fc3.i(str2, "description");
            AbstractC13042fc3.i(enumC23944xm6, "selectState");
            AbstractC13042fc3.i(interfaceC5308Iu0, "avatar");
            this.a = j;
            this.b = str;
            this.c = str2;
            this.d = i;
            this.e = enumC23944xm6;
            this.f = interfaceC5308Iu0;
            this.g = num;
        }

        @Override // ir.nasim.InterfaceC16239kw0.a
        public Integer a() {
            return this.g;
        }

        @Override // ir.nasim.InterfaceC16239kw0.a
        public EnumC23944xm6 b() {
            return this.e;
        }

        @Override // ir.nasim.InterfaceC16239kw0.a
        public InterfaceC5308Iu0 c() {
            return this.f;
        }

        @Override // ir.nasim.InterfaceC16239kw0.a
        public int d() {
            return this.d;
        }

        public final e e(long j, String str, String str2, int i, EnumC23944xm6 enumC23944xm6, InterfaceC5308Iu0 interfaceC5308Iu0, Integer num) {
            AbstractC13042fc3.i(str, "name");
            AbstractC13042fc3.i(str2, "description");
            AbstractC13042fc3.i(enumC23944xm6, "selectState");
            AbstractC13042fc3.i(interfaceC5308Iu0, "avatar");
            return new e(j, str, str2, i, enumC23944xm6, interfaceC5308Iu0, num);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return this.a == eVar.a && AbstractC13042fc3.d(this.b, eVar.b) && AbstractC13042fc3.d(this.c, eVar.c) && this.d == eVar.d && this.e == eVar.e && AbstractC13042fc3.d(this.f, eVar.f) && AbstractC13042fc3.d(this.g, eVar.g);
        }

        @Override // ir.nasim.InterfaceC16239kw0.a
        public String getDescription() {
            return this.c;
        }

        @Override // ir.nasim.InterfaceC16239kw0.a
        public long getId() {
            return this.a;
        }

        @Override // ir.nasim.InterfaceC16239kw0.a
        public String getName() {
            return this.b;
        }

        public int hashCode() {
            int iHashCode = ((((((((((Long.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + Integer.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
            Integer num = this.g;
            return iHashCode + (num == null ? 0 : num.hashCode());
        }

        public String toString() {
            return "MultiPeerCallCallLog(id=" + this.a + ", name=" + this.b + ", description=" + this.c + ", iconId=" + this.d + ", selectState=" + this.e + ", avatar=" + this.f + ", peerId=" + this.g + Separators.RPAREN;
        }

        public /* synthetic */ e(long j, String str, String str2, int i, EnumC23944xm6 enumC23944xm6, InterfaceC5308Iu0 interfaceC5308Iu0, Integer num, int i2, ED1 ed1) {
            this(j, str, str2, i, (i2 & 16) != 0 ? EnumC23944xm6.c : enumC23944xm6, interfaceC5308Iu0, num);
        }
    }

    /* renamed from: ir.nasim.kw0$g */
    public static final class g implements a {
        private final long a;
        private final String b;
        private final String c;
        private final int d;
        private final EnumC23944xm6 e;
        private final InterfaceC5308Iu0 f;
        private final Integer g;

        public g(long j, String str, String str2, int i, EnumC23944xm6 enumC23944xm6, InterfaceC5308Iu0 interfaceC5308Iu0, Integer num) {
            AbstractC13042fc3.i(str, "name");
            AbstractC13042fc3.i(str2, "description");
            AbstractC13042fc3.i(enumC23944xm6, "selectState");
            AbstractC13042fc3.i(interfaceC5308Iu0, "avatar");
            this.a = j;
            this.b = str;
            this.c = str2;
            this.d = i;
            this.e = enumC23944xm6;
            this.f = interfaceC5308Iu0;
            this.g = num;
        }

        @Override // ir.nasim.InterfaceC16239kw0.a
        public Integer a() {
            return this.g;
        }

        @Override // ir.nasim.InterfaceC16239kw0.a
        public EnumC23944xm6 b() {
            return this.e;
        }

        @Override // ir.nasim.InterfaceC16239kw0.a
        public InterfaceC5308Iu0 c() {
            return this.f;
        }

        @Override // ir.nasim.InterfaceC16239kw0.a
        public int d() {
            return this.d;
        }

        public final g e(long j, String str, String str2, int i, EnumC23944xm6 enumC23944xm6, InterfaceC5308Iu0 interfaceC5308Iu0, Integer num) {
            AbstractC13042fc3.i(str, "name");
            AbstractC13042fc3.i(str2, "description");
            AbstractC13042fc3.i(enumC23944xm6, "selectState");
            AbstractC13042fc3.i(interfaceC5308Iu0, "avatar");
            return new g(j, str, str2, i, enumC23944xm6, interfaceC5308Iu0, num);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return this.a == gVar.a && AbstractC13042fc3.d(this.b, gVar.b) && AbstractC13042fc3.d(this.c, gVar.c) && this.d == gVar.d && this.e == gVar.e && AbstractC13042fc3.d(this.f, gVar.f) && AbstractC13042fc3.d(this.g, gVar.g);
        }

        @Override // ir.nasim.InterfaceC16239kw0.a
        public String getDescription() {
            return this.c;
        }

        @Override // ir.nasim.InterfaceC16239kw0.a
        public long getId() {
            return this.a;
        }

        @Override // ir.nasim.InterfaceC16239kw0.a
        public String getName() {
            return this.b;
        }

        public int hashCode() {
            int iHashCode = ((((((((((Long.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + Integer.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
            Integer num = this.g;
            return iHashCode + (num == null ? 0 : num.hashCode());
        }

        public String toString() {
            return "PersonalCallCallLog(id=" + this.a + ", name=" + this.b + ", description=" + this.c + ", iconId=" + this.d + ", selectState=" + this.e + ", avatar=" + this.f + ", peerId=" + this.g + Separators.RPAREN;
        }

        public /* synthetic */ g(long j, String str, String str2, int i, EnumC23944xm6 enumC23944xm6, InterfaceC5308Iu0 interfaceC5308Iu0, Integer num, int i2, ED1 ed1) {
            this(j, str, str2, i, (i2 & 16) != 0 ? EnumC23944xm6.c : enumC23944xm6, interfaceC5308Iu0, num);
        }
    }
}
