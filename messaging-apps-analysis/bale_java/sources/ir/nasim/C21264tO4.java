package ir.nasim;

import ai.bale.proto.Misc$ResponseVoid;
import ai.bale.proto.PresenceOuterClass$RequestSetOnline;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.database.dailogLists.DialogEntity;

/* renamed from: ir.nasim.tO4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21264tO4 extends AbstractC6360Ng4 {
    public static final a q = new a(null);
    public static final int r = 8;
    private final C9057Yh4 m;
    private boolean n;
    private long o;
    private FE0 p;

    /* renamed from: ir.nasim.tO4$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.tO4$b */
    private static final class b {
    }

    /* renamed from: ir.nasim.tO4$c */
    private static final class c {
    }

    /* renamed from: ir.nasim.tO4$d */
    private static final class d {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C21264tO4(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        this.m = c9057Yh4;
    }

    private final void d0() {
        this.n = false;
        g0(0L);
    }

    private final void e0() {
        this.n = true;
        g0(0L);
    }

    private final void f0() {
        long j = this.o;
        if (j != 0) {
            Q(j);
            this.o = 0L;
        }
        boolean z = this.n;
        GeneratedMessageLite generatedMessageLiteA = PresenceOuterClass$RequestSetOnline.newBuilder().A(z).B(90000L).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        this.o = X(new C22871vx5("/bale.presence.v1.Presence/SetOnline", generatedMessageLiteA, defaultInstance));
        if (z) {
            g0(60000L);
        }
    }

    private final void g0(long j) {
        FE0 fe0 = this.p;
        if (fe0 != null) {
            AbstractC13042fc3.f(fe0);
            fe0.cancel();
            this.p = null;
        }
        this.p = q(new d(), j);
    }

    @Override // ir.nasim.AbstractC6360Ng4, ir.nasim.InterfaceC3817Cm0
    /* renamed from: g */
    public void T(AbstractC18385oa2 abstractC18385oa2) {
        AbstractC13042fc3.i(abstractC18385oa2, "event");
        if (abstractC18385oa2 instanceof XE) {
            if (((XE) abstractC18385oa2).a) {
                r().d(new c());
            } else {
                r().d(new b());
            }
        }
    }

    @Override // ir.nasim.AbstractC17647nK, ir.nasim.K6
    public void m(Object obj) throws Exception {
        AbstractC13042fc3.i(obj, DialogEntity.COLUMN_MESSAGE);
        if (obj instanceof c) {
            e0();
            return;
        }
        if (obj instanceof b) {
            d0();
        } else if (obj instanceof d) {
            f0();
        } else {
            super.m(obj);
        }
    }

    @Override // ir.nasim.K6
    public void o() {
        this.m.a().h(this, "app_visible_changed");
    }
}
