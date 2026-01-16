package ir.nasim.features.root;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import ir.nasim.EnumC16477lL2;
import ir.nasim.W06;
import ir.nasim.ZN2;
import ir.nasim.core.modules.profile.entity.Avatar;
import java.util.List;

/* renamed from: ir.nasim.features.root.a, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC13083a {

    /* renamed from: ir.nasim.features.root.a$a, reason: collision with other inner class name */
    public static final class C1214a extends AbstractC13083a {
        private final Throwable a;

        public C1214a(Throwable th) {
            super(null);
            this.a = th;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof C1214a) && AbstractC13042fc3.d(this.a, ((C1214a) obj).a);
        }

        public int hashCode() {
            Throwable th = this.a;
            if (th == null) {
                return 0;
            }
            return th.hashCode();
        }

        public String toString() {
            return "Error(error=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.features.root.a$b */
    public static final class b extends AbstractC13083a {
        public static final b a = new b();

        private b() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return -426907508;
        }

        public String toString() {
            return "Idle";
        }
    }

    /* renamed from: ir.nasim.features.root.a$c */
    public static final class c extends AbstractC13083a {
        private final int a;
        private final EnumC16477lL2 b;
        private final String c;
        private final Avatar d;
        private final int e;
        private final ZN2 f;
        private final W06 g;
        private final List h;
        private final String i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i, EnumC16477lL2 enumC16477lL2, String str, Avatar avatar, int i2, ZN2 zn2, W06 w06, List list, String str2) {
            super(null);
            AbstractC13042fc3.i(enumC16477lL2, "action");
            AbstractC13042fc3.i(str, "name");
            AbstractC13042fc3.i(zn2, "groupType");
            AbstractC13042fc3.i(list, "membersList");
            AbstractC13042fc3.i(str2, "token");
            this.a = i;
            this.b = enumC16477lL2;
            this.c = str;
            this.d = avatar;
            this.e = i2;
            this.f = zn2;
            this.g = w06;
            this.h = list;
            this.i = str2;
        }

        public final EnumC16477lL2 a() {
            return this.b;
        }

        public final Avatar b() {
            return this.d;
        }

        public final W06 c() {
            return this.g;
        }

        public final ZN2 d() {
            return this.f;
        }

        public final int e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.a == cVar.a && this.b == cVar.b && AbstractC13042fc3.d(this.c, cVar.c) && AbstractC13042fc3.d(this.d, cVar.d) && this.e == cVar.e && this.f == cVar.f && this.g == cVar.g && AbstractC13042fc3.d(this.h, cVar.h) && AbstractC13042fc3.d(this.i, cVar.i);
        }

        public final int f() {
            return this.e;
        }

        public final List g() {
            return this.h;
        }

        public final String h() {
            return this.c;
        }

        public int hashCode() {
            int iHashCode = ((((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
            Avatar avatar = this.d;
            int iHashCode2 = (((((iHashCode + (avatar == null ? 0 : avatar.hashCode())) * 31) + Integer.hashCode(this.e)) * 31) + this.f.hashCode()) * 31;
            W06 w06 = this.g;
            return ((((iHashCode2 + (w06 != null ? w06.hashCode() : 0)) * 31) + this.h.hashCode()) * 31) + this.i.hashCode();
        }

        public final String i() {
            return this.i;
        }

        public String toString() {
            return "Success(id=" + this.a + ", action=" + this.b + ", name=" + this.c + ", groupAvatar=" + this.d + ", membersCount=" + this.e + ", groupType=" + this.f + ", groupRestriction=" + this.g + ", membersList=" + this.h + ", token=" + this.i + Separators.RPAREN;
        }
    }

    private AbstractC13083a() {
    }

    public /* synthetic */ AbstractC13083a(ED1 ed1) {
        this();
    }
}
