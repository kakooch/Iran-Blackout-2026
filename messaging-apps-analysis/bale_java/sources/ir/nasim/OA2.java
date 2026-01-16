package ir.nasim;

import livekit.org.webrtc.PeerConnectionFactory;

/* loaded from: classes4.dex */
public abstract class OA2 implements InterfaceC19114po0 {
    public static final int a = 0;

    public static final class a extends OA2 {
        public static final a b = new a();

        private a() {
            super(null);
        }

        @Override // ir.nasim.InterfaceC19114po0
        public C5947Ln0 a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(1412861103);
            C5947Ln0 c5947Ln0E = AbstractC6419Nn0.e(interfaceC22053ub1, 0);
            interfaceC22053ub1.Q();
            return c5947Ln0E;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return -1368975514;
        }

        public String toString() {
            return "Loading";
        }
    }

    public static abstract class b extends OA2 {
        public static final int b = 0;

        public static final class a extends b {
            public static final a c = new a();

            private a() {
                super(null);
            }

            @Override // ir.nasim.InterfaceC19114po0
            public C5947Ln0 a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                interfaceC22053ub1.W(-918117695);
                C5947Ln0 c5947Ln0D = AbstractC6419Nn0.d(interfaceC22053ub1, 0);
                interfaceC22053ub1.Q();
                return c5947Ln0D;
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof a);
            }

            public int hashCode() {
                return -2067448290;
            }

            public String toString() {
                return "Disabled";
            }
        }

        /* renamed from: ir.nasim.OA2$b$b, reason: collision with other inner class name */
        public static final class C0545b extends b {
            public static final C0545b c = new C0545b();
            public static final int d = 0;

            private C0545b() {
                super(null);
            }

            @Override // ir.nasim.InterfaceC19114po0
            public C5947Ln0 a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                interfaceC22053ub1.W(-1570893006);
                C5947Ln0 c5947Ln0E = AbstractC6419Nn0.e(interfaceC22053ub1, 0);
                interfaceC22053ub1.Q();
                return c5947Ln0E;
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof C0545b);
            }

            public int hashCode() {
                return -1685025953;
            }

            public String toString() {
                return PeerConnectionFactory.TRIAL_ENABLED;
            }
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }

        private b() {
            super(null);
        }
    }

    public static abstract class c extends OA2 {

        public static final class a extends c {
            public static final a b = new a();

            private a() {
                super(null);
            }

            @Override // ir.nasim.InterfaceC19114po0
            public C5947Ln0 a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                interfaceC22053ub1.W(2091768292);
                C5947Ln0 c5947Ln0F = AbstractC6419Nn0.f(interfaceC22053ub1, 0);
                interfaceC22053ub1.Q();
                return c5947Ln0F;
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof a);
            }

            public int hashCode() {
                return 789838417;
            }

            public String toString() {
                return PeerConnectionFactory.TRIAL_ENABLED;
            }
        }

        public /* synthetic */ c(ED1 ed1) {
            this();
        }

        private c() {
            super(null);
        }
    }

    private OA2() {
    }

    @Override // ir.nasim.InterfaceC19114po0
    public C10493bi0 b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
        interfaceC22053ub1.W(793942341);
        C10493bi0 c10493bi0D = C11878di0.a.d(interfaceC22053ub1, 6);
        interfaceC22053ub1.Q();
        return c10493bi0D;
    }

    public /* synthetic */ OA2(ED1 ed1) {
        this();
    }
}
