package ir.nasim;

import ir.nasim.AbstractC16407lD4;

/* renamed from: ir.nasim.f42, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C12709f42 extends AbstractC3457Ay5 {
    public static final a f = new a(null);

    /* renamed from: ir.nasim.f42$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12709f42(C13345g42 c13345g42, HD4 hd4, CE4 ce4) {
        super(c13345g42, hd4, ce4);
        AbstractC13042fc3.i(c13345g42, "editPushNotification");
        AbstractC13042fc3.i(hd4, "notificationRecordDao");
        AbstractC13042fc3.i(ce4, "notificationUIManager");
    }

    @Override // ir.nasim.AbstractC3457Ay5
    protected boolean e() {
        a().u(c().j(), c().h(), c().g(), EnumC13889gz5.d);
        if (c().e() != null && HD4.r(a(), c().h(), c().g(), null, 4, null) != null) {
            C19406qI3.a("EditPushHandler", "handleNotificationDB, it's comment reply, so return true", new Object[0]);
            return true;
        }
        if (HD4.j(a(), c().j(), c().h(), c().g(), null, null, null, 56, null) != null) {
            C19406qI3.a("EditPushHandler", "handleNotificationDB, message to edit exists so return true", new Object[0]);
            return true;
        }
        C19406qI3.a("EditPushHandler", "handleNotificationDB, message to edit doesn't exist so return false", new Object[0]);
        return false;
    }

    @Override // ir.nasim.AbstractC3457Ay5
    protected void f() {
        long jG = c().g();
        if (jG == 0) {
            C19406qI3.a("EditPushHandler", "handleNotificationUI messageDate is 0, so return!", new Object[0]);
            return;
        }
        AbstractC16407lD4.i iVarX = CE4.x(b(), c().i(), jG, c().f(), null, 8, null);
        if (iVarX != null) {
            b().h0(iVarX, c().i().getPeerId());
        }
        C22033uZ0 c22033uZ0E = c().e();
        if (c22033uZ0E != null) {
            long jC = c22033uZ0E.c();
            AbstractC16407lD4.i iVarW = b().w(c().i(), jG, c().f(), c().e());
            if (iVarW != null) {
                b().h0(iVarW, (int) jC);
            }
        }
    }

    @Override // ir.nasim.AbstractC3457Ay5
    protected void g() {
        a().p(new JD4(0L, c().j(), c().h(), c().g(), EnumC13889gz5.d, c().k(), c().f(), null, 1, null));
    }

    @Override // ir.nasim.AbstractC3457Ay5
    protected boolean h() {
        if (j()) {
            C19406qI3.a("EditPushHandler", "EditPushHandler: should return. duplicate push notification", new Object[0]);
            return true;
        }
        JD4 jd4K = HD4.k(a(), c().j(), null, 2, null);
        if (a().s(c().j(), c().h(), c().g(), EnumC13889gz5.c) != null || (jd4K != null && jd4K.c() >= c().k())) {
            C19406qI3.a("EditPushHandler", "EditPushHandler: should return. message is either read or deleted", new Object[0]);
            return true;
        }
        JD4 jd4S = a().s(c().j(), c().h(), c().g(), EnumC13889gz5.d);
        if (jd4S == null || jd4S.f() < c().k()) {
            return false;
        }
        C19406qI3.a("EditPushHandler", "EditPushHandler: should return. newer edit push already exists", new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC3457Ay5
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C13345g42 c() {
        AbstractC4398Ey5 abstractC4398Ey5C = super.c();
        AbstractC13042fc3.g(abstractC4398Ey5C, "null cannot be cast to non-null type ir.nasim.features.firebase.newPush.model.EditPushNotification");
        return (C13345g42) abstractC4398Ey5C;
    }

    protected boolean j() {
        return a().t(c().j(), c().h(), c().g(), c().c(), c().f()) != null;
    }
}
