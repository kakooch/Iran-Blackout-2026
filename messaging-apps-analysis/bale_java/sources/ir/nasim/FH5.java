package ir.nasim;

import ir.nasim.AbstractC16407lD4;

/* loaded from: classes5.dex */
public final class FH5 extends AbstractC3457Ay5 {
    private int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FH5(GH5 gh5, HD4 hd4, CE4 ce4) {
        super(gh5, hd4, ce4);
        AbstractC13042fc3.i(gh5, "reactionPushNotification");
        AbstractC13042fc3.i(hd4, "notificationRecordDao");
        AbstractC13042fc3.i(ce4, "notificationUIManager");
    }

    @Override // ir.nasim.AbstractC3457Ay5
    protected boolean e() {
        if (AbstractC13042fc3.d(c().s(), "2")) {
            return true;
        }
        HD4.b(a(), c().u(), c().g(), c().f(), c().q(), c().r(), null, 32, null);
        return true;
    }

    @Override // ir.nasim.AbstractC3457Ay5
    protected void f() {
        String strS = c().s();
        if (AbstractC13042fc3.d(strS, "1") || AbstractC13042fc3.d(strS, "2")) {
            if (!c().t()) {
                C11458d25 c11458d25 = new C11458d25(AbstractC13042fc3.d(strS, "1") ? W25.a : W25.b, Integer.parseInt(c().u()));
                long jF = c().f();
                if (jF != 0) {
                    CE4.X(b(), c11458d25, new long[]{jF}, null, 4, null);
                    return;
                }
                C19406qI3.a("PushHandler", "Dislike reaction ignored, because its date is: " + jF, new Object[0]);
                return;
            }
            C11458d25 c11458d252 = new C11458d25(AbstractC13042fc3.d(c().s(), "2") ? W25.b : W25.a, Integer.parseInt(c().u()));
            if (!(true ^ b().C(c11458d252, Long.parseLong(c().g())).isEmpty()) || !AbstractC13042fc3.d(strS, "2")) {
                a().q(c().u(), c().g(), c().f(), EnumC13889gz5.f, c().v());
                c().x(Long.parseLong(c().p()));
                b().N(c());
                return;
            }
            Integer numD = a().d(c().u(), c().g(), c().f(), EnumC13889gz5.f);
            this.f = numD != null ? numD.intValue() : 0;
            c().w(this.f + c().v());
            AbstractC16407lD4.i iVarA = b().A(c11458d252, Long.parseLong(c().g()), b().y(c11458d252, c()));
            if (iVarA != null) {
                b().h0(iVarA, c11458d252.getPeerId());
            }
        }
    }

    @Override // ir.nasim.AbstractC3457Ay5
    protected void g() {
        if (AbstractC13042fc3.d(c().s(), "2")) {
            HD4.a(a(), c().u(), c().g(), c().f(), c().q(), null, 16, null);
        }
        a().p(new JD4(0L, c().u(), c().g(), c().f(), EnumC13889gz5.f, c().q(), c().r(), Integer.valueOf(c().v()), 1, null));
    }

    @Override // ir.nasim.AbstractC3457Ay5
    protected boolean h() {
        if (j()) {
            C19406qI3.a("PushHandler", "ReactionPushHandler: should return. duplicate push notification", new Object[0]);
            return true;
        }
        JD4 jd4K = HD4.k(a(), c().p(), null, 2, null);
        if (a().s(c().u(), c().g(), c().f(), EnumC13889gz5.c) != null || (jd4K != null && jd4K.c() >= c().q())) {
            C19406qI3.a("PushHandler", "ReactionPushHandler: should return. message is either read or deleted", new Object[0]);
            return true;
        }
        JD4 jd4F = HD4.f(a(), c().u(), c().g(), c().f(), c().r(), null, 16, null);
        if (jd4F == null || jd4F.f() < c().q()) {
            return false;
        }
        C19406qI3.a("PushHandler", "ReactionPushHandler: should return. newer reaction push already exists", new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC3457Ay5
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public GH5 c() {
        AbstractC4398Ey5 abstractC4398Ey5C = super.c();
        AbstractC13042fc3.g(abstractC4398Ey5C, "null cannot be cast to non-null type ir.nasim.features.firebase.newPush.model.ReactionPushNotification");
        return (GH5) abstractC4398Ey5C;
    }

    protected boolean j() {
        return a().m(c().u(), c().g(), c().f(), c().c(), c().q(), c().l(), Integer.valueOf(c().v())) != null;
    }
}
