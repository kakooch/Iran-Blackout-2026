package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.Avatar;

/* renamed from: ir.nasim.Gz1, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC4886Gz1 {

    /* renamed from: ir.nasim.Gz1$a */
    public static final class a extends AbstractC4886Gz1 {
        private final float a;

        public a(float f) {
            super(null);
            this.a = f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Float.compare(this.a, ((a) obj).a) == 0;
        }

        public int hashCode() {
            return Float.hashCode(this.a);
        }

        public String toString() {
            return "LoadingState(progress=" + this.a + Separators.RPAREN;
        }
    }

    private AbstractC4886Gz1() {
    }

    /* renamed from: ir.nasim.Gz1$b */
    public static final class b extends AbstractC4886Gz1 {
        public static final int q = C24119y45.r;
        private final int a;
        private final String b;
        private final String c;
        private final String d;
        private final String e;
        private final Avatar f;
        private final C24119y45 g;
        private final E25 h;
        private final ir.nasim.features.mxp.entity.a i;
        private final Integer j;
        private final String k;
        private final boolean l;
        private final boolean m;
        private final C5504Jp7 n;
        private final boolean o;
        private final String p;

        public /* synthetic */ b(int i, String str, String str2, String str3, String str4, Avatar avatar, C24119y45 c24119y45, E25 e25, ir.nasim.features.mxp.entity.a aVar, Integer num, String str5, boolean z, boolean z2, C5504Jp7 c5504Jp7, boolean z3, String str6, int i2, ED1 ed1) {
            this((i2 & 1) != 0 ? RD5.Done : i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? null : str4, (i2 & 32) != 0 ? null : avatar, (i2 & 64) != 0 ? null : c24119y45, (i2 & 128) != 0 ? null : e25, (i2 & 256) != 0 ? null : aVar, (i2 & 512) != 0 ? null : num, (i2 & 1024) != 0 ? null : str5, (i2 & 2048) != 0 ? false : z, (i2 & 4096) != 0 ? false : z2, (i2 & 8192) != 0 ? null : c5504Jp7, (i2 & 16384) != 0 ? false : z3, (i2 & 32768) != 0 ? null : str6);
        }

        public final b a(int i, String str, String str2, String str3, String str4, Avatar avatar, C24119y45 c24119y45, E25 e25, ir.nasim.features.mxp.entity.a aVar, Integer num, String str5, boolean z, boolean z2, C5504Jp7 c5504Jp7, boolean z3, String str6) {
            return new b(i, str, str2, str3, str4, avatar, c24119y45, e25, aVar, num, str5, z, z2, c5504Jp7, z3, str6);
        }

        public final String c() {
            return this.b;
        }

        public final Avatar d() {
            return this.f;
        }

        public final String e() {
            return this.k;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && AbstractC13042fc3.d(this.b, bVar.b) && AbstractC13042fc3.d(this.c, bVar.c) && AbstractC13042fc3.d(this.d, bVar.d) && AbstractC13042fc3.d(this.e, bVar.e) && AbstractC13042fc3.d(this.f, bVar.f) && AbstractC13042fc3.d(this.g, bVar.g) && this.h == bVar.h && this.i == bVar.i && AbstractC13042fc3.d(this.j, bVar.j) && AbstractC13042fc3.d(this.k, bVar.k) && this.l == bVar.l && this.m == bVar.m && AbstractC13042fc3.d(this.n, bVar.n) && this.o == bVar.o && AbstractC13042fc3.d(this.p, bVar.p);
        }

        public final boolean f() {
            return this.m;
        }

        public final Integer g() {
            return this.j;
        }

        public final String h() {
            return this.e;
        }

        public int hashCode() {
            int iHashCode = Integer.hashCode(this.a) * 31;
            String str = this.b;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.c;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.d;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.e;
            int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Avatar avatar = this.f;
            int iHashCode6 = (iHashCode5 + (avatar == null ? 0 : avatar.hashCode())) * 31;
            C24119y45 c24119y45 = this.g;
            int iHashCode7 = (iHashCode6 + (c24119y45 == null ? 0 : c24119y45.hashCode())) * 31;
            E25 e25 = this.h;
            int iHashCode8 = (iHashCode7 + (e25 == null ? 0 : e25.hashCode())) * 31;
            ir.nasim.features.mxp.entity.a aVar = this.i;
            int iHashCode9 = (iHashCode8 + (aVar == null ? 0 : aVar.hashCode())) * 31;
            Integer num = this.j;
            int iHashCode10 = (iHashCode9 + (num == null ? 0 : num.hashCode())) * 31;
            String str5 = this.k;
            int iHashCode11 = (((((iHashCode10 + (str5 == null ? 0 : str5.hashCode())) * 31) + Boolean.hashCode(this.l)) * 31) + Boolean.hashCode(this.m)) * 31;
            C5504Jp7 c5504Jp7 = this.n;
            int iHashCode12 = (((iHashCode11 + (c5504Jp7 == null ? 0 : c5504Jp7.hashCode())) * 31) + Boolean.hashCode(this.o)) * 31;
            String str6 = this.p;
            return iHashCode12 + (str6 != null ? str6.hashCode() : 0);
        }

        public final E25 i() {
            return this.h;
        }

        public final C24119y45 j() {
            return this.g;
        }

        public final String k() {
            return this.d;
        }

        public final String l() {
            return this.p;
        }

        public final ir.nasim.features.mxp.entity.a m() {
            return this.i;
        }

        public final boolean n() {
            return this.l;
        }

        public final C5504Jp7 o() {
            return this.n;
        }

        public final String p() {
            return this.c;
        }

        public final boolean q() {
            return this.o;
        }

        public String toString() {
            return "SuccessState(message=" + this.a + ", about=" + this.b + ", userName=" + this.c + ", phone=" + this.d + ", name=" + this.e + ", avatar=" + this.f + ", permissions=" + this.g + ", peerIdentity=" + this.h + ", puppetType=" + this.i + ", membersCount=" + this.j + ", botActiveUsers=" + this.k + ", showAddBotButton=" + this.l + ", hasMainWebApp=" + this.m + ", timche=" + this.n + ", isAddStoryEnabled=" + this.o + ", premiumBadgeContent=" + this.p + Separators.RPAREN;
        }

        public b(int i, String str, String str2, String str3, String str4, Avatar avatar, C24119y45 c24119y45, E25 e25, ir.nasim.features.mxp.entity.a aVar, Integer num, String str5, boolean z, boolean z2, C5504Jp7 c5504Jp7, boolean z3, String str6) {
            super(null);
            this.a = i;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = avatar;
            this.g = c24119y45;
            this.h = e25;
            this.i = aVar;
            this.j = num;
            this.k = str5;
            this.l = z;
            this.m = z2;
            this.n = c5504Jp7;
            this.o = z3;
            this.p = str6;
        }
    }

    public /* synthetic */ AbstractC4886Gz1(ED1 ed1) {
        this();
    }
}
