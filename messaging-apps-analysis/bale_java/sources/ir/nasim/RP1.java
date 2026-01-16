package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.database.dailogLists.DialogLastMessage;
import ir.nasim.database.dailogLists.MessageState;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/* loaded from: classes5.dex */
public interface RP1 {

    public static final class a implements RP1 {
        private final long a;

        public a(long j) {
            this.a = j;
        }

        public final long a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && this.a == ((a) obj).a;
        }

        public int hashCode() {
            return Long.hashCode(this.a);
        }

        public String toString() {
            return "DeleteDialogs(peerUid=" + this.a + Separators.RPAREN;
        }
    }

    public static final class b implements RP1 {
        private final List a;

        public b(List list) {
            AbstractC13042fc3.i(list, "peerUids");
            this.a = list;
        }

        public final List a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && AbstractC13042fc3.d(this.a, ((b) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "DialogsDeletedLocally(peerUids=" + this.a + Separators.RPAREN;
        }
    }

    public static final class c implements RP1 {
        private final List a;

        public c(List list) {
            AbstractC13042fc3.i(list, "peerUids");
            this.a = list;
        }

        public final List a() {
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
            return "DialogsRestored(peerUids=" + this.a + Separators.RPAREN;
        }
    }

    public static final class d implements RP1 {
        private final long a;
        private final String b;
        private final Long c;
        private final DialogLastMessage d;

        public d(long j, String str, Long l, DialogLastMessage dialogLastMessage) {
            AbstractC13042fc3.i(str, DialogEntity.COLUMN_DRAFT);
            this.a = j;
            this.b = str;
            this.c = l;
            this.d = dialogLastMessage;
        }

        public final String a() {
            return this.b;
        }

        public final Long b() {
            return this.c;
        }

        public final long c() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.a == dVar.a && AbstractC13042fc3.d(this.b, dVar.b) && AbstractC13042fc3.d(this.c, dVar.c) && AbstractC13042fc3.d(this.d, dVar.d);
        }

        public int hashCode() {
            int iHashCode = ((Long.hashCode(this.a) * 31) + this.b.hashCode()) * 31;
            Long l = this.c;
            int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
            DialogLastMessage dialogLastMessage = this.d;
            return iHashCode2 + (dialogLastMessage != null ? dialogLastMessage.hashCode() : 0);
        }

        public String toString() {
            return "DraftChanged(peerUid=" + this.a + ", draft=" + this.b + ", draftDate=" + this.c + ", lastMessage=" + this.d + Separators.RPAREN;
        }
    }

    public static final class e implements RP1 {
        private final long a;
        private final String b;
        private final byte[] c;
        private final E25 d;

        public e(long j, String str, byte[] bArr, E25 e25) {
            AbstractC13042fc3.i(str, "title");
            this.a = j;
            this.b = str;
            this.c = bArr;
            this.d = e25;
        }

        public final E25 a() {
            return this.d;
        }

        public final long b() {
            return this.a;
        }

        public final String c() {
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
            return this.a == eVar.a && AbstractC13042fc3.d(this.b, eVar.b) && AbstractC13042fc3.d(this.c, eVar.c) && this.d == eVar.d;
        }

        public int hashCode() {
            int iHashCode = ((Long.hashCode(this.a) * 31) + this.b.hashCode()) * 31;
            byte[] bArr = this.c;
            int iHashCode2 = (iHashCode + (bArr == null ? 0 : Arrays.hashCode(bArr))) * 31;
            E25 e25 = this.d;
            return iHashCode2 + (e25 != null ? e25.hashCode() : 0);
        }

        public String toString() {
            return "GroupChanged(peerUid=" + this.a + ", title=" + this.b + ", avatar=" + Arrays.toString(this.c) + ", peerIdentity=" + this.d + Separators.RPAREN;
        }
    }

    public static final class f implements RP1 {
        private final Set a;
        private final boolean b;

        public f(Set set, boolean z) {
            AbstractC13042fc3.i(set, "peerUIds");
            this.a = set;
            this.b = z;
        }

        public final Set a() {
            return this.a;
        }

        public final boolean b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return AbstractC13042fc3.d(this.a, fVar.a) && this.b == fVar.b;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + Boolean.hashCode(this.b);
        }

        public String toString() {
            return "MarkedAsUnReadChanged(peerUIds=" + this.a + ", isMarkedAsUnRead=" + this.b + Separators.RPAREN;
        }
    }

    public static final class g implements RP1 {
        private final long a;
        private final boolean b;

        public g(long j, boolean z) {
            this.a = j;
            this.b = z;
        }

        public final boolean a() {
            return this.b;
        }

        public final long b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return this.a == gVar.a && this.b == gVar.b;
        }

        public int hashCode() {
            return (Long.hashCode(this.a) * 31) + Boolean.hashCode(this.b);
        }

        public String toString() {
            return "MentionRead(peerUid=" + this.a + ", hasMention=" + this.b + Separators.RPAREN;
        }
    }

    public static final class i implements RP1 {
        private final Set a;
        private final boolean b;

        public i(Set set, boolean z) {
            AbstractC13042fc3.i(set, "peerUIds");
            this.a = set;
            this.b = z;
        }

        public final Set a() {
            return this.a;
        }

        public final boolean b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return AbstractC13042fc3.d(this.a, iVar.a) && this.b == iVar.b;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + Boolean.hashCode(this.b);
        }

        public String toString() {
            return "NotificationChanged(peerUIds=" + this.a + ", isNotificationEnabled=" + this.b + Separators.RPAREN;
        }
    }

    public static final class j implements RP1 {
        private final long a;
        private final MessageState b;
        private final long c;

        public j(long j, MessageState messageState, long j2) {
            this.a = j;
            this.b = messageState;
            this.c = j2;
        }

        public final long a() {
            return this.c;
        }

        public final MessageState b() {
            return this.b;
        }

        public final long c() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            return this.a == jVar.a && this.b == jVar.b && this.c == jVar.c;
        }

        public int hashCode() {
            int iHashCode = Long.hashCode(this.a) * 31;
            MessageState messageState = this.b;
            return ((iHashCode + (messageState == null ? 0 : messageState.hashCode())) * 31) + Long.hashCode(this.c);
        }

        public String toString() {
            return "PeerRead(peerUid=" + this.a + ", messageState=" + this.b + ", date=" + this.c + Separators.RPAREN;
        }
    }

    public static final class k implements RP1 {
        private final long a;
        private final String b;

        public k(long j, String str) {
            this.a = j;
            this.b = str;
        }

        public final String a() {
            return this.b;
        }

        public final long b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof k)) {
                return false;
            }
            k kVar = (k) obj;
            return this.a == kVar.a && AbstractC13042fc3.d(this.b, kVar.b);
        }

        public int hashCode() {
            int iHashCode = Long.hashCode(this.a) * 31;
            String str = this.b;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "ReactionStateChange(peerUid=" + this.a + ", lastReaction=" + this.b + Separators.RPAREN;
        }
    }

    public static final class l implements RP1 {
        private final long a;
        private final int b;

        public l(long j, int i) {
            this.a = j;
            this.b = i;
        }

        public final long a() {
            return this.a;
        }

        public final int b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof l)) {
                return false;
            }
            l lVar = (l) obj;
            return this.a == lVar.a && this.b == lVar.b;
        }

        public int hashCode() {
            return (Long.hashCode(this.a) * 31) + Integer.hashCode(this.b);
        }

        public String toString() {
            return "UnreadCountChanged(peerUid=" + this.a + ", unreadCount=" + this.b + Separators.RPAREN;
        }
    }

    public static final class m implements RP1 {
        private final long a;
        private final String b;
        private final byte[] c;
        private final boolean d;
        private final E25 e;

        public m(long j, String str, byte[] bArr, boolean z, E25 e25) {
            AbstractC13042fc3.i(str, "title");
            this.a = j;
            this.b = str;
            this.c = bArr;
            this.d = z;
            this.e = e25;
        }

        public final E25 a() {
            return this.e;
        }

        public final long b() {
            return this.a;
        }

        public final String c() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof m)) {
                return false;
            }
            m mVar = (m) obj;
            return this.a == mVar.a && AbstractC13042fc3.d(this.b, mVar.b) && AbstractC13042fc3.d(this.c, mVar.c) && this.d == mVar.d && this.e == mVar.e;
        }

        public int hashCode() {
            int iHashCode = ((Long.hashCode(this.a) * 31) + this.b.hashCode()) * 31;
            byte[] bArr = this.c;
            int iHashCode2 = (((iHashCode + (bArr == null ? 0 : Arrays.hashCode(bArr))) * 31) + Boolean.hashCode(this.d)) * 31;
            E25 e25 = this.e;
            return iHashCode2 + (e25 != null ? e25.hashCode() : 0);
        }

        public String toString() {
            return "UserChanged(peerUid=" + this.a + ", title=" + this.b + ", avatar=" + Arrays.toString(this.c) + ", isDeletedAccount=" + this.d + ", peerIdentity=" + this.e + Separators.RPAREN;
        }
    }

    public static final class h implements RP1 {
        public static final int g = 8;
        private final long a;
        private final long b;
        private final DialogLastMessage c;
        private final Long d;
        private final Boolean e;
        private final int f;

        public h(long j, long j2, DialogLastMessage dialogLastMessage, Long l, Boolean bool, int i) {
            AbstractC13042fc3.i(dialogLastMessage, DialogEntity.COLUMN_MESSAGE);
            this.a = j;
            this.b = j2;
            this.c = dialogLastMessage;
            this.d = l;
            this.e = bool;
            this.f = i;
        }

        public final DialogLastMessage a() {
            return this.c;
        }

        public final long b() {
            return this.a;
        }

        public final long c() {
            return this.b;
        }

        public final int d() {
            return this.f;
        }

        public final Long e() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return this.a == hVar.a && this.b == hVar.b && AbstractC13042fc3.d(this.c, hVar.c) && AbstractC13042fc3.d(this.d, hVar.d) && AbstractC13042fc3.d(this.e, hVar.e) && this.f == hVar.f;
        }

        public final Boolean f() {
            return this.e;
        }

        public int hashCode() {
            int iHashCode = ((((Long.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31) + this.c.hashCode()) * 31;
            Long l = this.d;
            int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
            Boolean bool = this.e;
            return ((iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31) + Integer.hashCode(this.f);
        }

        public String toString() {
            return "NewMessage(peerUid=" + this.a + ", rid=" + this.b + ", message=" + this.c + ", sortDate=" + this.d + ", isForwarded=" + this.e + ", senderUid=" + this.f + Separators.RPAREN;
        }

        public /* synthetic */ h(long j, long j2, DialogLastMessage dialogLastMessage, Long l, Boolean bool, int i, int i2, ED1 ed1) {
            this(j, j2, dialogLastMessage, (i2 & 8) != 0 ? null : l, (i2 & 16) != 0 ? null : bool, i);
        }
    }
}
