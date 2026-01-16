package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.ExPeerType;

/* loaded from: classes6.dex */
public abstract class IK4 {

    public static final class a extends IK4 {
        public static final a a = new a();

        private a() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return -1657837403;
        }

        public String toString() {
            return "CloseOnboarding";
        }
    }

    public static final class b extends IK4 {
        private final int a;
        private final ExPeerType b;
        private final UA2 c;

        static final class a extends AbstractC19859r37 implements UA2 {
            int b;

            a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(1, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                return C19938rB7.a;
            }

            @Override // ir.nasim.UA2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i, ExPeerType exPeerType, UA2 ua2) {
            super(null);
            AbstractC13042fc3.i(ua2, "preJoinAction");
            this.a = i;
            this.b = exPeerType;
            this.c = ua2;
        }

        public final int a() {
            return this.a;
        }

        public final ExPeerType b() {
            return this.b;
        }

        public final UA2 c() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && this.b == bVar.b && AbstractC13042fc3.d(this.c, bVar.c);
        }

        public int hashCode() {
            int iHashCode = Integer.hashCode(this.a) * 31;
            ExPeerType exPeerType = this.b;
            return ((iHashCode + (exPeerType == null ? 0 : exPeerType.hashCode())) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "JoinOrStartPeer(peerId=" + this.a + ", peerType=" + this.b + ", preJoinAction=" + this.c + Separators.RPAREN;
        }

        public /* synthetic */ b(int i, ExPeerType exPeerType, UA2 ua2, int i2, ED1 ed1) {
            this(i, exPeerType, (i2 & 4) != 0 ? new a(null) : ua2);
        }
    }

    public static final class c extends IK4 {
        public static final c a = new c();

        private c() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public int hashCode() {
            return 120713725;
        }

        public String toString() {
            return "LoadPeers";
        }
    }

    public static final class d extends IK4 {
        private final M72 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(M72 m72) {
            super(null);
            AbstractC13042fc3.i(m72, "emptyStateOnboardingType");
            this.a = m72;
        }

        public final M72 a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && this.a == ((d) obj).a;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "LoadPeersEmptyStateSpot(emptyStateOnboardingType=" + this.a + Separators.RPAREN;
        }
    }

    public static final class e extends IK4 {
        private final int a;

        public e(int i) {
            super(null);
            this.a = i;
        }

        public final int a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof e) && this.a == ((e) obj).a;
        }

        public int hashCode() {
            return Integer.hashCode(this.a);
        }

        public String toString() {
            return "OpenDialog(peerId=" + this.a + Separators.RPAREN;
        }
    }

    public static final class f extends IK4 {
        public static final f a = new f();

        private f() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof f);
        }

        public int hashCode() {
            return -654242945;
        }

        public String toString() {
            return "ScreenView";
        }
    }

    private IK4() {
    }

    public /* synthetic */ IK4(ED1 ed1) {
        this();
    }
}
