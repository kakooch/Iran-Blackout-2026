package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.ExPeerType;

/* renamed from: ir.nasim.pK4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public interface InterfaceC18834pK4 {

    /* renamed from: ir.nasim.pK4$a */
    public static final class a implements InterfaceC18834pK4 {
        private final int a;

        public a(int i) {
            this.a = i;
        }

        public final int a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && this.a == ((a) obj).a;
        }

        public int hashCode() {
            return Integer.hashCode(this.a);
        }

        public String toString() {
            return "ClickBanner(folderId=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.pK4$b */
    public static final class b implements InterfaceC18834pK4 {
        private final int a;

        public b(int i) {
            this.a = i;
        }

        public final int a() {
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
            return "CloseBanner(folderId=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.pK4$c */
    public static final class c implements InterfaceC18834pK4 {
        public static final c a = new c();

        private c() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public int hashCode() {
            return -1916029077;
        }

        public String toString() {
            return "InitializeBanner";
        }
    }

    /* renamed from: ir.nasim.pK4$d */
    public static final class d implements InterfaceC18834pK4 {
        private final int a;
        private final int b;
        private final ExPeerType c;
        private final UA2 d;

        public d(int i, int i2, ExPeerType exPeerType, UA2 ua2) {
            AbstractC13042fc3.i(ua2, "preJoinAction");
            this.a = i;
            this.b = i2;
            this.c = exPeerType;
            this.d = ua2;
        }

        public final int a() {
            return this.a;
        }

        public final int b() {
            return this.b;
        }

        public final ExPeerType c() {
            return this.c;
        }

        public final UA2 d() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.a == dVar.a && this.b == dVar.b && this.c == dVar.c && AbstractC13042fc3.d(this.d, dVar.d);
        }

        public int hashCode() {
            int iHashCode = ((Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b)) * 31;
            ExPeerType exPeerType = this.c;
            return ((iHashCode + (exPeerType == null ? 0 : exPeerType.hashCode())) * 31) + this.d.hashCode();
        }

        public String toString() {
            return "JoinOrStartPeer(folderId=" + this.a + ", peerId=" + this.b + ", peerType=" + this.c + ", preJoinAction=" + this.d + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.pK4$e */
    public static final class e implements InterfaceC18834pK4 {
        public static final e a = new e();

        private e() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof e);
        }

        public int hashCode() {
            return -742886399;
        }

        public String toString() {
            return "OpenDialog";
        }
    }

    /* renamed from: ir.nasim.pK4$f */
    public static final class f implements InterfaceC18834pK4 {
        private final int a;

        public f(int i) {
            this.a = i;
        }

        public final int a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof f) && this.a == ((f) obj).a;
        }

        public int hashCode() {
            return Integer.hashCode(this.a);
        }

        public String toString() {
            return "ViewBanner(folderId=" + this.a + Separators.RPAREN;
        }
    }
}
