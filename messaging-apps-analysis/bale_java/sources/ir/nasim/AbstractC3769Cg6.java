package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.mxp.entity.PuppetGroup;
import ir.nasim.features.mxp.entity.PuppetUser;

/* renamed from: ir.nasim.Cg6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC3769Cg6 {

    /* renamed from: ir.nasim.Cg6$d */
    public static final class d extends AbstractC3769Cg6 {
        private static final Avatar c = null;
        private static final C11458d25 e;
        private static final Long f = null;
        public static final d a = new d();
        private static final String b = "";
        private static final ExPeerType d = ExPeerType.UNKNOWN;

        static {
            C11458d25 c11458d25Y = C11458d25.y(0);
            AbstractC13042fc3.h(c11458d25Y, "group(...)");
            e = c11458d25Y;
        }

        private d() {
            super(null);
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public Avatar a() {
            return c;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public Long b() {
            return f;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public ExPeerType c() {
            return d;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public C11458d25 d() {
            return e;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public String e() {
            return b;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof d);
        }

        public int hashCode() {
            return 617915420;
        }

        public String toString() {
            return "Empty";
        }
    }

    /* renamed from: ir.nasim.Cg6$e */
    public static final class e extends AbstractC3769Cg6 {
        private final int a;
        private final String b;
        private final InterfaceC4557Fq2 c;
        private final C11458d25 d;
        private final String e;
        private final Avatar f;
        private final ExPeerType g;
        private final Long h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(int i, String str, InterfaceC4557Fq2 interfaceC4557Fq2, C11458d25 c11458d25, String str2, Avatar avatar, ExPeerType exPeerType, Long l) {
            super(null);
            AbstractC13042fc3.i(interfaceC4557Fq2, "isMember");
            AbstractC13042fc3.i(c11458d25, "peer");
            AbstractC13042fc3.i(str2, "title");
            AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
            this.a = i;
            this.b = str;
            this.c = interfaceC4557Fq2;
            this.d = c11458d25;
            this.e = str2;
            this.f = avatar;
            this.g = exPeerType;
            this.h = l;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public Avatar a() {
            return this.f;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public Long b() {
            return this.h;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public ExPeerType c() {
            return this.g;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public C11458d25 d() {
            return this.d;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public String e() {
            return this.e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return this.a == eVar.a && AbstractC13042fc3.d(this.b, eVar.b) && AbstractC13042fc3.d(this.c, eVar.c) && AbstractC13042fc3.d(this.d, eVar.d) && AbstractC13042fc3.d(this.e, eVar.e) && AbstractC13042fc3.d(this.f, eVar.f) && this.g == eVar.g && AbstractC13042fc3.d(this.h, eVar.h);
        }

        public final String f() {
            return this.b;
        }

        public final int g() {
            return this.a;
        }

        public final InterfaceC4557Fq2 h() {
            return this.c;
        }

        public int hashCode() {
            int iHashCode = Integer.hashCode(this.a) * 31;
            String str = this.b;
            int iHashCode2 = (((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
            Avatar avatar = this.f;
            int iHashCode3 = (((iHashCode2 + (avatar == null ? 0 : avatar.hashCode())) * 31) + this.g.hashCode()) * 31;
            Long l = this.h;
            return iHashCode3 + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            return "GlobalChannel(membersCount=" + this.a + ", id=" + this.b + ", isMember=" + this.c + ", peer=" + this.d + ", title=" + this.e + ", avatar=" + this.f + ", exPeerType=" + this.g + ", engineId=" + this.h + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.Cg6$f */
    public static final class f extends AbstractC3769Cg6 {
        private final int a;
        private final String b;
        private final InterfaceC4557Fq2 c;
        private final C11458d25 d;
        private final String e;
        private final Avatar f;
        private final ExPeerType g;
        private final Long h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(int i, String str, InterfaceC4557Fq2 interfaceC4557Fq2, C11458d25 c11458d25, String str2, Avatar avatar, ExPeerType exPeerType, Long l) {
            super(null);
            AbstractC13042fc3.i(interfaceC4557Fq2, "isMember");
            AbstractC13042fc3.i(c11458d25, "peer");
            AbstractC13042fc3.i(str2, "title");
            AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
            this.a = i;
            this.b = str;
            this.c = interfaceC4557Fq2;
            this.d = c11458d25;
            this.e = str2;
            this.f = avatar;
            this.g = exPeerType;
            this.h = l;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public Avatar a() {
            return this.f;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public Long b() {
            return this.h;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public ExPeerType c() {
            return this.g;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public C11458d25 d() {
            return this.d;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public String e() {
            return this.e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return this.a == fVar.a && AbstractC13042fc3.d(this.b, fVar.b) && AbstractC13042fc3.d(this.c, fVar.c) && AbstractC13042fc3.d(this.d, fVar.d) && AbstractC13042fc3.d(this.e, fVar.e) && AbstractC13042fc3.d(this.f, fVar.f) && this.g == fVar.g && AbstractC13042fc3.d(this.h, fVar.h);
        }

        public final String f() {
            return this.b;
        }

        public final int g() {
            return this.a;
        }

        public final InterfaceC4557Fq2 h() {
            return this.c;
        }

        public int hashCode() {
            int iHashCode = Integer.hashCode(this.a) * 31;
            String str = this.b;
            int iHashCode2 = (((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
            Avatar avatar = this.f;
            int iHashCode3 = (((iHashCode2 + (avatar == null ? 0 : avatar.hashCode())) * 31) + this.g.hashCode()) * 31;
            Long l = this.h;
            return iHashCode3 + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            return "GlobalGroup(membersCount=" + this.a + ", id=" + this.b + ", isMember=" + this.c + ", peer=" + this.d + ", title=" + this.e + ", avatar=" + this.f + ", exPeerType=" + this.g + ", engineId=" + this.h + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.Cg6$i */
    public static final class i extends AbstractC3769Cg6 {
        private final long a;
        private final long b;
        private final AbstractC17457n0 c;
        private final int d;
        private final C11458d25 e;
        private final String f;
        private final Avatar g;
        private final ExPeerType h;
        private final Long i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(long j, long j2, AbstractC17457n0 abstractC17457n0, int i, C11458d25 c11458d25, String str, Avatar avatar, ExPeerType exPeerType, Long l) {
            super(null);
            AbstractC13042fc3.i(abstractC17457n0, "content");
            AbstractC13042fc3.i(c11458d25, "peer");
            AbstractC13042fc3.i(str, "title");
            AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
            this.a = j;
            this.b = j2;
            this.c = abstractC17457n0;
            this.d = i;
            this.e = c11458d25;
            this.f = str;
            this.g = avatar;
            this.h = exPeerType;
            this.i = l;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public Avatar a() {
            return this.g;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public Long b() {
            return this.i;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public ExPeerType c() {
            return this.h;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public C11458d25 d() {
            return this.e;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public String e() {
            return this.f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return this.a == iVar.a && this.b == iVar.b && AbstractC13042fc3.d(this.c, iVar.c) && this.d == iVar.d && AbstractC13042fc3.d(this.e, iVar.e) && AbstractC13042fc3.d(this.f, iVar.f) && AbstractC13042fc3.d(this.g, iVar.g) && this.h == iVar.h && AbstractC13042fc3.d(this.i, iVar.i);
        }

        public final AbstractC17457n0 f() {
            return this.c;
        }

        public final long g() {
            return this.b;
        }

        public final long h() {
            return this.a;
        }

        public int hashCode() {
            int iHashCode = ((((((((((Long.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31) + this.c.hashCode()) * 31) + Integer.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
            Avatar avatar = this.g;
            int iHashCode2 = (((iHashCode + (avatar == null ? 0 : avatar.hashCode())) * 31) + this.h.hashCode()) * 31;
            Long l = this.i;
            return iHashCode2 + (l != null ? l.hashCode() : 0);
        }

        public final int i() {
            return this.d;
        }

        public String toString() {
            return "Message(rid=" + this.a + ", date=" + this.b + ", content=" + this.c + ", senderId=" + this.d + ", peer=" + this.e + ", title=" + this.f + ", avatar=" + this.g + ", exPeerType=" + this.h + ", engineId=" + this.i + Separators.RPAREN;
        }
    }

    private AbstractC3769Cg6() {
    }

    public abstract Avatar a();

    public abstract Long b();

    public abstract ExPeerType c();

    public abstract C11458d25 d();

    public abstract String e();

    /* renamed from: ir.nasim.Cg6$a */
    public static final class a extends AbstractC3769Cg6 {
        private final String a;
        private final boolean b;
        private final String c;
        private final boolean d;
        private final C11458d25 e;
        private final String f;
        private final Avatar g;
        private final ExPeerType h;
        private final Long i;

        public /* synthetic */ a(String str, boolean z, String str2, boolean z2, C11458d25 c11458d25, String str3, Avatar avatar, ExPeerType exPeerType, Long l, int i, ED1 ed1) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? false : z, str2, z2, c11458d25, str3, avatar, (i & 128) != 0 ? ExPeerType.BOT : exPeerType, l);
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public Avatar a() {
            return this.g;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public Long b() {
            return this.i;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public ExPeerType c() {
            return this.h;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public C11458d25 d() {
            return this.e;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public String e() {
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
            return AbstractC13042fc3.d(this.a, aVar.a) && this.b == aVar.b && AbstractC13042fc3.d(this.c, aVar.c) && this.d == aVar.d && AbstractC13042fc3.d(this.e, aVar.e) && AbstractC13042fc3.d(this.f, aVar.f) && AbstractC13042fc3.d(this.g, aVar.g) && this.h == aVar.h && AbstractC13042fc3.d(this.i, aVar.i);
        }

        public final String f() {
            return this.c;
        }

        public final boolean g() {
            return this.d;
        }

        public final String h() {
            return this.a;
        }

        public int hashCode() {
            String str = this.a;
            int iHashCode = (((str == null ? 0 : str.hashCode()) * 31) + Boolean.hashCode(this.b)) * 31;
            String str2 = this.c;
            int iHashCode2 = (((((((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + Boolean.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
            Avatar avatar = this.g;
            int iHashCode3 = (((iHashCode2 + (avatar == null ? 0 : avatar.hashCode())) * 31) + this.h.hashCode()) * 31;
            Long l = this.i;
            return iHashCode3 + (l != null ? l.hashCode() : 0);
        }

        public final boolean i() {
            return this.b;
        }

        public String toString() {
            return "Bot(id=" + this.a + ", isGlobal=" + this.b + ", activeUsers=" + this.c + ", hasMainWebApp=" + this.d + ", peer=" + this.e + ", title=" + this.f + ", avatar=" + this.g + ", exPeerType=" + this.h + ", engineId=" + this.i + Separators.RPAREN;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, boolean z, String str2, boolean z2, C11458d25 c11458d25, String str3, Avatar avatar, ExPeerType exPeerType, Long l) {
            super(null);
            AbstractC13042fc3.i(c11458d25, "peer");
            AbstractC13042fc3.i(str3, "title");
            AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
            this.a = str;
            this.b = z;
            this.c = str2;
            this.d = z2;
            this.e = c11458d25;
            this.f = str3;
            this.g = avatar;
            this.h = exPeerType;
            this.i = l;
        }
    }

    /* renamed from: ir.nasim.Cg6$b */
    public static final class b extends AbstractC3769Cg6 {
        private final W06 a;
        private final int b;
        private final String c;
        private final boolean d;
        private final C11458d25 e;
        private final String f;
        private final Avatar g;
        private final ExPeerType h;
        private final Long i;

        public /* synthetic */ b(W06 w06, int i, String str, boolean z, C11458d25 c11458d25, String str2, Avatar avatar, ExPeerType exPeerType, Long l, int i2, ED1 ed1) {
            this(w06, i, str, z, c11458d25, str2, avatar, (i2 & 128) != 0 ? ExPeerType.CHANNEL : exPeerType, l);
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public Avatar a() {
            return this.g;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public Long b() {
            return this.i;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public ExPeerType c() {
            return this.h;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public C11458d25 d() {
            return this.e;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public String e() {
            return this.f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && this.b == bVar.b && AbstractC13042fc3.d(this.c, bVar.c) && this.d == bVar.d && AbstractC13042fc3.d(this.e, bVar.e) && AbstractC13042fc3.d(this.f, bVar.f) && AbstractC13042fc3.d(this.g, bVar.g) && this.h == bVar.h && AbstractC13042fc3.d(this.i, bVar.i);
        }

        public final String f() {
            return this.c;
        }

        public final int g() {
            return this.b;
        }

        public final boolean h() {
            return this.d;
        }

        public int hashCode() {
            W06 w06 = this.a;
            int iHashCode = (((w06 == null ? 0 : w06.hashCode()) * 31) + Integer.hashCode(this.b)) * 31;
            String str = this.c;
            int iHashCode2 = (((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
            Avatar avatar = this.g;
            int iHashCode3 = (((iHashCode2 + (avatar == null ? 0 : avatar.hashCode())) * 31) + this.h.hashCode()) * 31;
            Long l = this.i;
            return iHashCode3 + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            return "Channel(restriction=" + this.a + ", membersCount=" + this.b + ", id=" + this.c + ", isMember=" + this.d + ", peer=" + this.e + ", title=" + this.f + ", avatar=" + this.g + ", exPeerType=" + this.h + ", engineId=" + this.i + Separators.RPAREN;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(W06 w06, int i, String str, boolean z, C11458d25 c11458d25, String str2, Avatar avatar, ExPeerType exPeerType, Long l) {
            super(null);
            AbstractC13042fc3.i(c11458d25, "peer");
            AbstractC13042fc3.i(str2, "title");
            AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
            this.a = w06;
            this.b = i;
            this.c = str;
            this.d = z;
            this.e = c11458d25;
            this.f = str2;
            this.g = avatar;
            this.h = exPeerType;
            this.i = l;
        }
    }

    /* renamed from: ir.nasim.Cg6$c */
    public static final class c extends AbstractC3769Cg6 {
        private final InterfaceC4557Fq2 a;
        private final C11458d25 b;
        private final String c;
        private final Avatar d;
        private final ExPeerType e;
        private final Long f;
        private final boolean g;
        private final String h;

        public /* synthetic */ c(InterfaceC4557Fq2 interfaceC4557Fq2, C11458d25 c11458d25, String str, Avatar avatar, ExPeerType exPeerType, Long l, boolean z, String str2, int i, ED1 ed1) {
            this(interfaceC4557Fq2, c11458d25, str, avatar, (i & 16) != 0 ? ExPeerType.PRIVATE : exPeerType, l, (i & 64) != 0 ? false : z, (i & 128) != 0 ? null : str2);
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public Avatar a() {
            return this.d;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public Long b() {
            return this.f;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public ExPeerType c() {
            return this.e;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public C11458d25 d() {
            return this.b;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public String e() {
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
            return AbstractC13042fc3.d(this.a, cVar.a) && AbstractC13042fc3.d(this.b, cVar.b) && AbstractC13042fc3.d(this.c, cVar.c) && AbstractC13042fc3.d(this.d, cVar.d) && this.e == cVar.e && AbstractC13042fc3.d(this.f, cVar.f) && this.g == cVar.g && AbstractC13042fc3.d(this.h, cVar.h);
        }

        public final String f() {
            return this.h;
        }

        public final InterfaceC4557Fq2 g() {
            return this.a;
        }

        public final boolean h() {
            return this.g;
        }

        public int hashCode() {
            int iHashCode = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
            Avatar avatar = this.d;
            int iHashCode2 = (((iHashCode + (avatar == null ? 0 : avatar.hashCode())) * 31) + this.e.hashCode()) * 31;
            Long l = this.f;
            int iHashCode3 = (((iHashCode2 + (l == null ? 0 : l.hashCode())) * 31) + Boolean.hashCode(this.g)) * 31;
            String str = this.h;
            return iHashCode3 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "Contact(lastSeen=" + this.a + ", peer=" + this.b + ", title=" + this.c + ", avatar=" + this.d + ", exPeerType=" + this.e + ", engineId=" + this.f + ", isGlobal=" + this.g + ", id=" + this.h + Separators.RPAREN;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(InterfaceC4557Fq2 interfaceC4557Fq2, C11458d25 c11458d25, String str, Avatar avatar, ExPeerType exPeerType, Long l, boolean z, String str2) {
            super(null);
            AbstractC13042fc3.i(interfaceC4557Fq2, "lastSeen");
            AbstractC13042fc3.i(c11458d25, "peer");
            AbstractC13042fc3.i(str, "title");
            AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
            this.a = interfaceC4557Fq2;
            this.b = c11458d25;
            this.c = str;
            this.d = avatar;
            this.e = exPeerType;
            this.f = l;
            this.g = z;
            this.h = str2;
        }
    }

    /* renamed from: ir.nasim.Cg6$g */
    public static final class g extends AbstractC3769Cg6 {
        private final W06 a;
        private final int b;
        private final String c;
        private final boolean d;
        private final C11458d25 e;
        private final String f;
        private final Avatar g;
        private final ExPeerType h;
        private final Long i;

        public /* synthetic */ g(W06 w06, int i, String str, boolean z, C11458d25 c11458d25, String str2, Avatar avatar, ExPeerType exPeerType, Long l, int i2, ED1 ed1) {
            this(w06, i, str, z, c11458d25, str2, avatar, (i2 & 128) != 0 ? ExPeerType.GROUP : exPeerType, l);
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public Avatar a() {
            return this.g;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public Long b() {
            return this.i;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public ExPeerType c() {
            return this.h;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public C11458d25 d() {
            return this.e;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public String e() {
            return this.f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return this.a == gVar.a && this.b == gVar.b && AbstractC13042fc3.d(this.c, gVar.c) && this.d == gVar.d && AbstractC13042fc3.d(this.e, gVar.e) && AbstractC13042fc3.d(this.f, gVar.f) && AbstractC13042fc3.d(this.g, gVar.g) && this.h == gVar.h && AbstractC13042fc3.d(this.i, gVar.i);
        }

        public final String f() {
            return this.c;
        }

        public final int g() {
            return this.b;
        }

        public final boolean h() {
            return this.d;
        }

        public int hashCode() {
            W06 w06 = this.a;
            int iHashCode = (((w06 == null ? 0 : w06.hashCode()) * 31) + Integer.hashCode(this.b)) * 31;
            String str = this.c;
            int iHashCode2 = (((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
            Avatar avatar = this.g;
            int iHashCode3 = (((iHashCode2 + (avatar == null ? 0 : avatar.hashCode())) * 31) + this.h.hashCode()) * 31;
            Long l = this.i;
            return iHashCode3 + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            return "Group(restriction=" + this.a + ", membersCount=" + this.b + ", id=" + this.c + ", isMember=" + this.d + ", peer=" + this.e + ", title=" + this.f + ", avatar=" + this.g + ", exPeerType=" + this.h + ", engineId=" + this.i + Separators.RPAREN;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(W06 w06, int i, String str, boolean z, C11458d25 c11458d25, String str2, Avatar avatar, ExPeerType exPeerType, Long l) {
            super(null);
            AbstractC13042fc3.i(c11458d25, "peer");
            AbstractC13042fc3.i(str2, "title");
            AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
            this.a = w06;
            this.b = i;
            this.c = str;
            this.d = z;
            this.e = c11458d25;
            this.f = str2;
            this.g = avatar;
            this.h = exPeerType;
            this.i = l;
        }
    }

    public /* synthetic */ AbstractC3769Cg6(ED1 ed1) {
        this();
    }

    /* renamed from: ir.nasim.Cg6$h */
    public static final class h extends AbstractC3769Cg6 {
        private final int a;
        private final String b;
        private final Avatar c;
        private final ExPeerType d;
        private final C11458d25 e;
        private final Long f;

        public /* synthetic */ h(int i, String str, Avatar avatar, ExPeerType exPeerType, C11458d25 c11458d25, Long l, int i2, ED1 ed1) {
            this(i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? null : avatar, (i2 & 8) != 0 ? ExPeerType.UNKNOWN : exPeerType, (i2 & 16) != 0 ? C11458d25.y(0) : c11458d25, (i2 & 32) != 0 ? null : l);
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public Avatar a() {
            return this.c;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public Long b() {
            return this.f;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public ExPeerType c() {
            return this.d;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public C11458d25 d() {
            return this.e;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public String e() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return this.a == hVar.a && AbstractC13042fc3.d(this.b, hVar.b) && AbstractC13042fc3.d(this.c, hVar.c) && this.d == hVar.d && AbstractC13042fc3.d(this.e, hVar.e) && AbstractC13042fc3.d(this.f, hVar.f);
        }

        public final int f() {
            return this.a;
        }

        public int hashCode() {
            int iHashCode = ((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31;
            Avatar avatar = this.c;
            int iHashCode2 = (((((iHashCode + (avatar == null ? 0 : avatar.hashCode())) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
            Long l = this.f;
            return iHashCode2 + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            return "Header(text=" + this.a + ", title=" + this.b + ", avatar=" + this.c + ", exPeerType=" + this.d + ", peer=" + this.e + ", engineId=" + this.f + Separators.RPAREN;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(int i, String str, Avatar avatar, ExPeerType exPeerType, C11458d25 c11458d25, Long l) {
            super(null);
            AbstractC13042fc3.i(str, "title");
            AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
            AbstractC13042fc3.i(c11458d25, "peer");
            this.a = i;
            this.b = str;
            this.c = avatar;
            this.d = exPeerType;
            this.e = c11458d25;
            this.f = l;
        }
    }

    /* renamed from: ir.nasim.Cg6$j */
    public static final class j extends AbstractC3769Cg6 {
        private final PuppetGroup a;
        private final C11458d25 b;
        private final String c;
        private final Avatar d;
        private final ExPeerType e;
        private final Long f;

        public /* synthetic */ j(PuppetGroup puppetGroup, C11458d25 c11458d25, String str, Avatar avatar, ExPeerType exPeerType, Long l, int i, ED1 ed1) {
            this(puppetGroup, (i & 2) != 0 ? C11458d25.E(((PuppetUser) AbstractC15401jX0.q0(puppetGroup.getPuppets())).getUserId()) : c11458d25, (i & 4) != 0 ? puppetGroup.getName() : str, (i & 8) != 0 ? null : avatar, (i & 16) != 0 ? ExPeerType.PRIVATE : exPeerType, (i & 32) != 0 ? null : l);
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public Avatar a() {
            return this.d;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public Long b() {
            return this.f;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public ExPeerType c() {
            return this.e;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public C11458d25 d() {
            return this.b;
        }

        @Override // ir.nasim.AbstractC3769Cg6
        public String e() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            return AbstractC13042fc3.d(this.a, jVar.a) && AbstractC13042fc3.d(this.b, jVar.b) && AbstractC13042fc3.d(this.c, jVar.c) && AbstractC13042fc3.d(this.d, jVar.d) && this.e == jVar.e && AbstractC13042fc3.d(this.f, jVar.f);
        }

        public final PuppetGroup f() {
            return this.a;
        }

        public int hashCode() {
            int iHashCode = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
            Avatar avatar = this.d;
            int iHashCode2 = (((iHashCode + (avatar == null ? 0 : avatar.hashCode())) * 31) + this.e.hashCode()) * 31;
            Long l = this.f;
            return iHashCode2 + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            return "Mxp(puppet=" + this.a + ", peer=" + this.b + ", title=" + this.c + ", avatar=" + this.d + ", exPeerType=" + this.e + ", engineId=" + this.f + Separators.RPAREN;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(PuppetGroup puppetGroup, C11458d25 c11458d25, String str, Avatar avatar, ExPeerType exPeerType, Long l) {
            super(null);
            AbstractC13042fc3.i(puppetGroup, "puppet");
            AbstractC13042fc3.i(c11458d25, "peer");
            AbstractC13042fc3.i(str, "title");
            AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
            this.a = puppetGroup;
            this.b = c11458d25;
            this.c = str;
            this.d = avatar;
            this.e = exPeerType;
            this.f = l;
        }
    }
}
