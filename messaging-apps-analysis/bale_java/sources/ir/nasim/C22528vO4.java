package ir.nasim;

import ai.bale.proto.Misc$ResponseVoid;
import ai.bale.proto.PresenceOuterClass$RequestStopTyping;
import ai.bale.proto.PresenceOuterClass$RequestTyping;

/* renamed from: ir.nasim.vO4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C22528vO4 extends AbstractC6360Ng4 {
    private final C9057Yh4 m;
    private long n;
    private long o;
    private FE0 p;

    /* renamed from: ir.nasim.vO4$a */
    private static class a {
        private C11458d25 a;

        public a(C11458d25 c11458d25) {
            this.a = c11458d25;
        }

        public C11458d25 a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.vO4$b */
    public static class b {
        private C11458d25 a;

        public b(C11458d25 c11458d25) {
            this.a = c11458d25;
        }
    }

    /* renamed from: ir.nasim.vO4$c */
    public static class c {
        private C11458d25 a;
        private EnumC5360Iz7 b;

        public c(C11458d25 c11458d25, EnumC5360Iz7 enumC5360Iz7) {
            this.a = c11458d25;
            this.b = enumC5360Iz7;
        }

        public C11458d25 a() {
            return this.a;
        }

        public EnumC5360Iz7 b() {
            return this.b;
        }
    }

    public C22528vO4(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        this.n = 0L;
        this.o = 0L;
        this.m = c9057Yh4;
    }

    private void e0() {
        long j = this.o;
        if (j != 0) {
            Q(j);
            this.o = 0L;
        }
    }

    public static C9528a7 f0(final C9057Yh4 c9057Yh4) {
        return C12736f7.n().d("actor/typing/own", new V6() { // from class: ir.nasim.uO4
            @Override // ir.nasim.V6
            public final K6 create() {
                return C22528vO4.g0(c9057Yh4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ K6 g0(C9057Yh4 c9057Yh4) {
        return new C22528vO4(c9057Yh4);
    }

    private void h0(C11458d25 c11458d25) {
        C17557nA c17557nAN = this.m.n(c11458d25);
        if (c17557nAN == null) {
            return;
        }
        e0();
        this.o = X(new C22871vx5("/bale.presence.v1.Presence/StopTyping", PresenceOuterClass$RequestStopTyping.newBuilder().A(C18732p92.a.y1(c17557nAN)).B(EnumC5025Ho5.TypingType_TEXT).a(), Misc$ResponseVoid.getDefaultInstance()));
    }

    private void i0() {
        e0();
        this.n = 0L;
        FE0 fe0 = this.p;
        if (fe0 != null) {
            fe0.cancel();
            this.p = null;
        }
    }

    private void k0(C11458d25 c11458d25, EnumC5360Iz7 enumC5360Iz7, Integer num, Integer num2) {
        if (AbstractC4699Ge3.d(enumC5360Iz7)) {
            return;
        }
        if (num2 != null) {
            this.p = q(new d(c11458d25, enumC5360Iz7, num, null), num2.intValue());
        } else if (enumC5360Iz7 == EnumC5360Iz7.c) {
            l0(c11458d25);
        } else {
            m0(c11458d25, enumC5360Iz7, num);
        }
    }

    private void l0(C11458d25 c11458d25) {
        if (AbstractC13372g7.a() - this.n < 3000) {
            return;
        }
        this.n = AbstractC13372g7.a();
        C17557nA c17557nAN = this.m.n(c11458d25);
        if (c17557nAN == null) {
            return;
        }
        e0();
        this.o = X(new C22871vx5("/bale.presence.v1.Presence/Typing", PresenceOuterClass$RequestTyping.newBuilder().A(C18732p92.a.y1(c17557nAN)).B(EnumC5025Ho5.TypingType_TEXT).a(), Misc$ResponseVoid.getDefaultInstance()));
        FE0 fe0 = this.p;
        if (fe0 != null) {
            fe0.cancel();
            this.p = null;
        }
        this.p = q(new a(c11458d25), 4000L);
    }

    private void m0(C11458d25 c11458d25, EnumC5360Iz7 enumC5360Iz7, Integer num) {
        C17557nA c17557nAN = this.m.n(c11458d25);
        if (c17557nAN == null) {
            return;
        }
        e0();
        this.o = X(new C22871vx5("/bale.presence.v1.Presence/Typing", PresenceOuterClass$RequestTyping.newBuilder().A(C18732p92.a.y1(c17557nAN)).B(enumC5360Iz7.r()).a(), Misc$ResponseVoid.getDefaultInstance()));
        FE0 fe0 = this.p;
        if (fe0 != null) {
            fe0.cancel();
            this.p = null;
        }
        if (num != null) {
            if (num.intValue() <= 0) {
                return;
            } else {
                num = Integer.valueOf(num.intValue() - 1);
            }
        }
        this.p = q(new d(c11458d25, enumC5360Iz7, num, null), 4000L);
    }

    public void j0(C11458d25 c11458d25, EnumC5360Iz7 enumC5360Iz7) {
        FE0 fe0;
        if (AbstractC4699Ge3.d(enumC5360Iz7) || (fe0 = this.p) == null) {
            return;
        }
        fe0.cancel();
        e0();
        C17557nA c17557nAN = this.m.n(c11458d25);
        if (c17557nAN == null) {
            return;
        }
        this.o = X(new C22871vx5("/bale.presence.v1.Presence/StopTyping", PresenceOuterClass$RequestStopTyping.newBuilder().A(C18732p92.a.y1(c17557nAN)).B(enumC5360Iz7.r()).a(), Misc$ResponseVoid.getDefaultInstance()));
    }

    @Override // ir.nasim.AbstractC17647nK, ir.nasim.K6
    public void m(Object obj) throws Exception {
        if (obj instanceof d) {
            d dVar = (d) obj;
            k0(dVar.c(), dVar.d(), dVar.b(), dVar.a());
            return;
        }
        if (obj instanceof b) {
            i0();
            return;
        }
        if (obj instanceof a) {
            h0(((a) obj).a());
        } else if (!(obj instanceof c)) {
            super.m(obj);
        } else {
            c cVar = (c) obj;
            j0(cVar.a(), cVar.b());
        }
    }

    /* renamed from: ir.nasim.vO4$d */
    public static class d {
        private C11458d25 a;
        private EnumC5360Iz7 b;
        private Integer c;
        private Integer d;

        public d(C11458d25 c11458d25, EnumC5360Iz7 enumC5360Iz7) {
            this.a = c11458d25;
            this.b = enumC5360Iz7;
        }

        public Integer a() {
            return this.d;
        }

        public Integer b() {
            return this.c;
        }

        public C11458d25 c() {
            return this.a;
        }

        public EnumC5360Iz7 d() {
            return this.b;
        }

        public d(C11458d25 c11458d25, EnumC5360Iz7 enumC5360Iz7, Integer num, Integer num2) {
            this.a = c11458d25;
            this.b = enumC5360Iz7;
            this.d = num2;
            this.c = num;
        }
    }
}
