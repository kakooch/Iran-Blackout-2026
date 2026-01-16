package ir.nasim;

import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public final class JL1 {
    private final C11458d25 a;
    private final J44 b;
    private final String c;
    private long d;
    private Avatar e;
    private int f;
    private Long g;
    private Long h;
    private ExPeerType i;
    private E25 j;
    private boolean k;
    private boolean l;
    private String m;
    private boolean n;
    private Long o;
    private Long p;
    private ir.nasim.features.mxp.entity.a q;
    private long r;
    private C15280jJ5 s;
    private List t;
    private List u;

    public JL1(C11458d25 c11458d25, J44 j44, String str) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(str, DialogEntity.COLUMN_DIALOG_TITLE);
        this.r = -1L;
        this.t = AbstractC10360bX0.m();
        this.u = AbstractC10360bX0.m();
        this.a = c11458d25;
        this.b = j44;
        this.c = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f(Q64 q64, Q64 q642) {
        AbstractC13042fc3.i(q64, "$unreadMention");
        AbstractC13042fc3.i(q642, "it");
        return q642.i() == q64.i() && q642.h() == q64.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h(Q64 q64, Q64 q642) {
        AbstractC13042fc3.i(q64, "$unreadReaction");
        AbstractC13042fc3.i(q642, "it");
        return q642.i() == q64.i() && q642.h() == q64.h();
    }

    public final JL1 c(Q64 q64) {
        AbstractC13042fc3.i(q64, "unreadReaction");
        if (C8386Vt0.W5()) {
            List listP1 = AbstractC15401jX0.p1(this.u);
            List<Q64> list = this.t;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
            for (Q64 q642 : list) {
                arrayList.add(AbstractC4616Fw7.a(Long.valueOf(q642.i()), Long.valueOf(q642.h())));
            }
            if (!arrayList.contains(AbstractC4616Fw7.a(Long.valueOf(q64.i()), Long.valueOf(q64.h())))) {
                listP1.add(q64);
            }
            this.u = AbstractC15401jX0.m1(listP1);
        }
        return this;
    }

    public final C17067mL1 d() {
        return new C17067mL1(this.a, this.b, this.d, this.c, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.r, this.m, this.p, this.n, this.q, this.s, this.t, this.u, this.o);
    }

    public final JL1 e(final Q64 q64) {
        AbstractC13042fc3.i(q64, "unreadMention");
        if (C8386Vt0.U5()) {
            List listP1 = AbstractC15401jX0.p1(this.t);
            AbstractC13610gX0.K(listP1, new UA2() { // from class: ir.nasim.IL1
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(JL1.f(q64, (Q64) obj));
                }
            });
            this.t = AbstractC15401jX0.m1(listP1);
        }
        return this;
    }

    public final JL1 g(final Q64 q64) {
        AbstractC13042fc3.i(q64, "unreadReaction");
        if (C8386Vt0.W5()) {
            List listP1 = AbstractC15401jX0.p1(this.u);
            AbstractC13610gX0.K(listP1, new UA2() { // from class: ir.nasim.HL1
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(JL1.h(q64, (Q64) obj));
                }
            });
            this.u = AbstractC15401jX0.m1(listP1);
        }
        return this;
    }

    public final JL1 i(boolean z) {
        this.l = z;
        return this;
    }

    public final JL1 j(Avatar avatar) {
        this.e = avatar;
        return this;
    }

    public final JL1 k(String str) {
        this.m = str;
        return this;
    }

    public final JL1 l(ExPeerType exPeerType) {
        this.i = exPeerType;
        return this;
    }

    public final JL1 m(boolean z) {
        this.k = z;
        return this;
    }

    public final JL1 n(boolean z) {
        this.n = z;
        return this;
    }

    public final JL1 o(Long l) {
        this.o = l;
        return this;
    }

    public final JL1 p(E25 e25) {
        this.j = e25;
        return this;
    }

    public final JL1 q(long j) {
        this.r = j;
        return this;
    }

    public final JL1 r(ir.nasim.features.mxp.entity.a aVar) {
        this.q = aVar;
        return this;
    }

    public final JL1 s(C15280jJ5 c15280jJ5) {
        AbstractC13042fc3.i(c15280jJ5, "recommendedData");
        this.s = c15280jJ5;
        return this;
    }

    public final JL1 t(long j) {
        this.d = j;
        return this;
    }

    public final JL1 u(int i) {
        this.f = i;
        return this;
    }

    public final JL1 v(List list) {
        AbstractC13042fc3.i(list, DialogEntity.COLUMN_UNREAD_MENTIONS_DATE);
        if (C8386Vt0.U5()) {
            this.t = list;
        }
        return this;
    }

    public final JL1 w(List list) {
        AbstractC13042fc3.i(list, "unreadReactions");
        if (C8386Vt0.W5()) {
            this.u = list;
        }
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final ir.nasim.JL1 x(java.lang.Long r5) {
        /*
            r4 = this;
            if (r5 == 0) goto L17
            java.lang.Long r0 = r4.p
            if (r0 == 0) goto L15
            ir.nasim.AbstractC13042fc3.f(r0)
            long r0 = r0.longValue()
            long r2 = r5.longValue()
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L17
        L15:
            r4.p = r5
        L17:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.JL1.x(java.lang.Long):ir.nasim.JL1");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final ir.nasim.JL1 y(java.lang.Long r5) {
        /*
            r4 = this;
            if (r5 == 0) goto L17
            java.lang.Long r0 = r4.g
            if (r0 == 0) goto L15
            ir.nasim.AbstractC13042fc3.f(r0)
            long r0 = r0.longValue()
            long r2 = r5.longValue()
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L17
        L15:
            r4.g = r5
        L17:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.JL1.y(java.lang.Long):ir.nasim.JL1");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final ir.nasim.JL1 z(java.lang.Long r5) {
        /*
            r4 = this;
            if (r5 == 0) goto L17
            java.lang.Long r0 = r4.h
            if (r0 == 0) goto L15
            ir.nasim.AbstractC13042fc3.f(r0)
            long r0 = r0.longValue()
            long r2 = r5.longValue()
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L17
        L15:
            r4.h = r5
        L17:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.JL1.z(java.lang.Long):ir.nasim.JL1");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JL1(C17067mL1 c17067mL1) {
        this(c17067mL1.R(), c17067mL1.Q(), c17067mL1.J());
        AbstractC13042fc3.i(c17067mL1, "dialog");
        this.e = c17067mL1.H();
        this.f = c17067mL1.Y();
        this.m = c17067mL1.K();
        this.p = c17067mL1.L();
        this.g = c17067mL1.N();
        this.h = c17067mL1.O();
        this.i = c17067mL1.getExPeerType();
        this.j = c17067mL1.S();
        this.k = c17067mL1.M();
        this.l = c17067mL1.c0();
        this.n = c17067mL1.d0();
        this.o = c17067mL1.P();
        this.d = c17067mL1.X();
        this.r = c17067mL1.T();
        this.q = c17067mL1.U();
        this.t = c17067mL1.a0();
        this.u = c17067mL1.b0();
    }
}
