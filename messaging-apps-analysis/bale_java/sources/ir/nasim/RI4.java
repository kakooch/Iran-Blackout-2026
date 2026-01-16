package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.platform.v;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes4.dex */
public final class RI4 extends RecyclerView.C {
    private final SA2 u;
    private final UA2 v;
    private final InterfaceC10258bL6 w;
    private final InterfaceC10258bL6 x;
    private final SA2 y;
    public static final b z = new b(null);
    public static final int A = 8;
    private static final int B = AbstractC9591aD5.on_board_separator;

    static final class a implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.RI4$a$a, reason: collision with other inner class name */
        static final class C0596a implements InterfaceC14603iB2 {
            final /* synthetic */ RI4 a;
            final /* synthetic */ InterfaceC9664aL6 b;
            final /* synthetic */ InterfaceC9664aL6 c;

            C0596a(RI4 ri4, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62) {
                this.a = ri4;
                this.b = interfaceC9664aL6;
                this.c = interfaceC9664aL62;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    LI4.d(a.f(this.b) ? androidx.compose.foundation.layout.q.m(androidx.compose.ui.e.a, 0.0f, C17784nZ1.q(SetRpcStruct$ComposedRpc.MESSAGE_REMOVE_REACTION_FIELD_NUMBER), 0.0f, 0.0f, 13, null) : androidx.compose.foundation.layout.q.m(androidx.compose.ui.e.a, 0.0f, C17784nZ1.q(70), 0.0f, 0.0f, 13, null), this.a.u, this.a.v, null, 0L, true, !a.d(this.c), this.a.y, interfaceC22053ub1, 196608, 24);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean d(InterfaceC9664aL6 interfaceC9664aL6) {
            return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean f(InterfaceC9664aL6 interfaceC9664aL6) {
            return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
        }

        public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            InterfaceC9664aL6 interfaceC9664aL6B = AbstractC10222bH6.b(RI4.this.x, null, interfaceC22053ub1, 0, 1);
            M10.f(false, AbstractC19242q11.e(1870900391, true, new C0596a(RI4.this, AbstractC10222bH6.b(RI4.this.w, null, interfaceC22053ub1, 0, 1), interfaceC9664aL6B), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final class b {
        private b() {
        }

        public final int a() {
            return RI4.B;
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RI4(GI4 gi4, SA2 sa2, UA2 ua2, InterfaceC10258bL6 interfaceC10258bL6, InterfaceC10258bL6 interfaceC10258bL62, SA2 sa22) {
        super(gi4.getRoot());
        AbstractC13042fc3.i(gi4, "binding");
        AbstractC13042fc3.i(sa2, "showContactCallFragment");
        AbstractC13042fc3.i(ua2, "showStoryFragment");
        AbstractC13042fc3.i(interfaceC10258bL6, "isCallLogListEmpty");
        AbstractC13042fc3.i(interfaceC10258bL62, "permissionState");
        AbstractC13042fc3.i(sa22, "showPermissionDialog");
        this.u = sa2;
        this.v = ua2;
        this.w = interfaceC10258bL6;
        this.x = interfaceC10258bL62;
        this.y = sa22;
        gi4.b.setViewCompositionStrategy(v.b.b);
        gi4.b.setContent(AbstractC19242q11.c(-1819385748, true, new a()));
    }
}
