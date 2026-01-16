package ir.nasim;

/* renamed from: ir.nasim.yI5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24251yI5 extends AbstractC3457Ay5 {
    public static final a f = new a(null);

    /* renamed from: ir.nasim.yI5$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C24251yI5(C24845zI5 c24845zI5, HD4 hd4, CE4 ce4) {
        super(c24845zI5, hd4, ce4);
        AbstractC13042fc3.i(c24845zI5, "readPushNotification");
        AbstractC13042fc3.i(hd4, "notificationRecordDao");
        AbstractC13042fc3.i(ce4, "notificationUIManager");
    }

    @Override // ir.nasim.AbstractC3457Ay5
    protected boolean e() {
        HD4.h(a(), c().g(), c().e(), null, 4, null);
        return true;
    }

    @Override // ir.nasim.AbstractC3457Ay5
    protected void f() {
        if (b().r().length == 0) {
            C19406qI3.a("ReadPushHandler", "handleNotificationUI return, because activeNotifications is empty!", new Object[0]);
        } else {
            CE4.S(b(), c().f().getPeerId(), null, 2, null);
        }
    }

    @Override // ir.nasim.AbstractC3457Ay5
    protected void g() {
        a().p(new JD4(0L, c().g(), "", c().e(), EnumC13889gz5.e, c().h(), null, null, 1, null));
    }

    @Override // ir.nasim.AbstractC3457Ay5
    protected boolean h() {
        if (j()) {
            C19406qI3.a("ReadPushHandler", "shouldReturn: true, because duplicate push notification!", new Object[0]);
            return true;
        }
        JD4 jd4K = HD4.k(a(), c().g(), null, 2, null);
        if (jd4K == null || jd4K.c() < c().e()) {
            return false;
        }
        C19406qI3.a("ReadPushHandler", "shouldReturn: true, because newer read already exists!", new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC3457Ay5
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C24845zI5 c() {
        AbstractC4398Ey5 abstractC4398Ey5C = super.c();
        AbstractC13042fc3.g(abstractC4398Ey5C, "null cannot be cast to non-null type ir.nasim.features.firebase.newPush.model.ReadPushNotification");
        return (C24845zI5) abstractC4398Ey5C;
    }

    protected boolean j() {
        return false;
    }
}
