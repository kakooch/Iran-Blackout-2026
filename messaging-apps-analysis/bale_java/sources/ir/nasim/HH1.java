package ir.nasim;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class HH1 extends AbstractC3457Ay5 {
    public static final a f = new a(null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HH1(IH1 ih1, HD4 hd4, CE4 ce4) {
        super(ih1, hd4, ce4);
        AbstractC13042fc3.i(ih1, "deletePushNotification");
        AbstractC13042fc3.i(hd4, "notificationRecordDao");
        AbstractC13042fc3.i(ce4, "notificationUIManager");
    }

    @Override // ir.nasim.AbstractC3457Ay5
    protected boolean e() {
        for (XV4 xv4 : AbstractC15401jX0.v1(c().f(), c().e())) {
            HD4.i(a(), c().i(), (String) xv4.e(), ((Number) xv4.f()).longValue(), null, null, 24, null);
        }
        return true;
    }

    @Override // ir.nasim.AbstractC3457Ay5
    protected void f() {
        CE4.X(b(), c().h(), AbstractC15401jX0.n1(c().e()), null, 4, null);
        if (c().g().isEmpty()) {
            C19406qI3.a("DeletePushHandler", "handleNotificationUI, messageThreadRids is empty, so return!", new Object[0]);
            return;
        }
        Iterator it = AbstractC15401jX0.j0(c().g()).iterator();
        while (it.hasNext()) {
            b().W(c().h(), AbstractC15401jX0.n1(c().e()), Long.valueOf(Long.parseLong((String) it.next())));
        }
    }

    @Override // ir.nasim.AbstractC3457Ay5
    protected void g() {
        for (XV4 xv4 : AbstractC15401jX0.v1(c().f(), c().e())) {
            a().p(new JD4(0L, c().i(), (String) xv4.e(), ((Number) xv4.f()).longValue(), EnumC13889gz5.c, c().j(), null, null, 1, null));
        }
    }

    @Override // ir.nasim.AbstractC3457Ay5
    protected boolean h() {
        if (!j()) {
            return false;
        }
        C19406qI3.a("DeletePushHandler", "DeletePushHandler: should return. duplicate push notification", new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC3457Ay5
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public IH1 c() {
        AbstractC4398Ey5 abstractC4398Ey5C = super.c();
        AbstractC13042fc3.g(abstractC4398Ey5C, "null cannot be cast to non-null type ir.nasim.features.firebase.newPush.model.DeletePushNotification");
        return (IH1) abstractC4398Ey5C;
    }

    protected boolean j() {
        List<XV4> listV1 = AbstractC15401jX0.v1(c().f(), c().e());
        if ((listV1 instanceof Collection) && listV1.isEmpty()) {
            return true;
        }
        for (XV4 xv4 : listV1) {
            if (a().s(c().i(), (String) xv4.e(), ((Number) xv4.f()).longValue(), c().c()) == null) {
                return false;
            }
        }
        return true;
    }
}
