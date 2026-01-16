package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import java.util.List;

/* renamed from: ir.nasim.zt3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC25195zt3 {

    /* renamed from: ir.nasim.zt3$a */
    public static final class a extends AbstractC25195zt3 {
        private final String a;
        private final ir.nasim.database.dailogLists.g b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, ir.nasim.database.dailogLists.g gVar) {
            super(null);
            AbstractC13042fc3.i(str, ParameterNames.TEXT);
            this.a = str;
            this.b = gVar;
        }

        public final String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC13042fc3.d(this.a, aVar.a) && this.b == aVar.b;
        }

        public int hashCode() {
            int iHashCode = this.a.hashCode() * 31;
            ir.nasim.database.dailogLists.g gVar = this.b;
            return iHashCode + (gVar == null ? 0 : gVar.hashCode());
        }

        public String toString() {
            return "CallMessage(text=" + this.a + ", callType=" + this.b + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.zt3$b */
    public static final class b extends AbstractC25195zt3 {
        private final NP1 a;
        private final String b;
        private final boolean c;
        private final C24381yX0 d;
        private final boolean e;

        public /* synthetic */ b(NP1 np1, String str, boolean z, C24381yX0 c24381yX0, boolean z2, ED1 ed1) {
            this(np1, str, z, c24381yX0, z2);
        }

        public final NP1 a() {
            return this.a;
        }

        public final String b() {
            return this.b;
        }

        public final boolean c() {
            return this.e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a.b(bVar.a) && AbstractC13042fc3.d(this.b, bVar.b) && this.c == bVar.c && AbstractC13042fc3.d(this.d, bVar.d) && this.e == bVar.e;
        }

        public int hashCode() {
            int iHashCode = this.a.a().hashCode() * 31;
            String str = this.b;
            int iHashCode2 = (((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + Boolean.hashCode(this.c)) * 31;
            C24381yX0 c24381yX0 = this.d;
            return ((iHashCode2 + (c24381yX0 != null ? C24381yX0.w(c24381yX0.y()) : 0)) * 31) + Boolean.hashCode(this.e);
        }

        public String toString() {
            return "ContentMessage(content=" + this.a + ", senderName=" + this.b + ", isReplay=" + this.c + ", iconTintColor=" + this.d + ", isContactRegistered=" + this.e + Separators.RPAREN;
        }

        public /* synthetic */ b(NP1 np1, String str, boolean z, C24381yX0 c24381yX0, boolean z2, int i, ED1 ed1) {
            this(np1, (i & 2) != 0 ? null : str, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : c24381yX0, (i & 16) != 0 ? false : z2, null);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private b(NP1 np1, String str, boolean z, C24381yX0 c24381yX0, boolean z2) {
            super(null);
            AbstractC13042fc3.i(np1, "content");
            this.a = np1;
            this.b = str;
            this.c = z;
            this.d = c24381yX0;
            this.e = z2;
        }
    }

    /* renamed from: ir.nasim.zt3$c */
    public static final class c extends AbstractC25195zt3 {
        private final String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(null);
            AbstractC13042fc3.i(str, "actionType");
            this.a = str;
        }

        public final String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && AbstractC13042fc3.d(this.a, ((c) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "ConversationAction(actionType=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.zt3$d */
    public static final class d extends AbstractC25195zt3 {
        private final NP1 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(NP1 np1) {
            super(null);
            AbstractC13042fc3.i(np1, "content");
            this.a = np1;
        }

        public final NP1 a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof d) {
                return this.a.b(((d) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.a().hashCode();
        }

        public String toString() {
            return "DraftMessage(content=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.zt3$e */
    public static final class e extends AbstractC25195zt3 {
        private final NP1 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(NP1 np1) {
            super(null);
            AbstractC13042fc3.i(np1, "caption");
            this.a = np1;
        }

        public final NP1 a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof e) {
                return this.a.b(((e) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.a().hashCode();
        }

        public String toString() {
            return "LiveMessage(caption=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.zt3$f */
    public static final class f extends AbstractC25195zt3 {
        private final NP1 a;
        private final String b;
        private final boolean c;
        private final List d;

        public /* synthetic */ f(NP1 np1, String str, boolean z, List list, int i, ED1 ed1) {
            this(np1, (i & 2) != 0 ? null : str, (i & 4) != 0 ? false : z, list);
        }

        public final NP1 a() {
            return this.a;
        }

        public final String b() {
            return this.b;
        }

        public final List c() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return this.a.b(fVar.a) && AbstractC13042fc3.d(this.b, fVar.b) && this.c == fVar.c && AbstractC13042fc3.d(this.d, fVar.d);
        }

        public int hashCode() {
            int iHashCode = this.a.a().hashCode() * 31;
            String str = this.b;
            return ((((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + Boolean.hashCode(this.c)) * 31) + this.d.hashCode();
        }

        public String toString() {
            return "Thumbnail(content=" + this.a + ", senderName=" + this.b + ", isFromYou=" + this.c + ", thumbnailItems=" + this.d + Separators.RPAREN;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(NP1 np1, String str, boolean z, List list) {
            super(null);
            AbstractC13042fc3.i(np1, "content");
            AbstractC13042fc3.i(list, "thumbnailItems");
            this.a = np1;
            this.b = str;
            this.c = z;
            this.d = list;
        }
    }

    private AbstractC25195zt3() {
    }

    public /* synthetic */ AbstractC25195zt3(ED1 ed1) {
        this();
    }
}
