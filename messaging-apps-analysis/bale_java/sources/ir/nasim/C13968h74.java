package ir.nasim;

/* renamed from: ir.nasim.h74, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C13968h74 extends AbstractC3457Ay5 {
    public static final a f = new a(null);

    /* renamed from: ir.nasim.h74$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C13968h74(C14566i74 c14566i74, HD4 hd4, CE4 ce4) {
        super(c14566i74, hd4, ce4);
        AbstractC13042fc3.i(c14566i74, "messagePushNotification");
        AbstractC13042fc3.i(hd4, "notificationRecordDao");
        AbstractC13042fc3.i(ce4, "notificationUIManager");
    }

    private final boolean j(AbstractC24063xz abstractC24063xz) {
        Integer num;
        if (!(abstractC24063xz instanceof ZC)) {
            return false;
        }
        ZC zc = (ZC) abstractC24063xz;
        return zc.w().size() == 1 && (num = (Integer) zc.w().get(0)) != null && num.intValue() == -1;
    }

    private final boolean k() {
        AbstractC24063xz abstractC24063xzE = c().e();
        if (abstractC24063xzE == null) {
            return false;
        }
        return j(abstractC24063xzE);
    }

    private final boolean l() {
        JD4 jd4K = HD4.k(a(), c().o(), null, 2, null);
        if (a().s(c().o(), c().g(), c().f(), EnumC13889gz5.c) == null && (jd4K == null || jd4K.c() < c().f())) {
            return false;
        }
        C19406qI3.a("MessagePushHandler", "isMessageReadOrDeleted return true, because message is either read or deleted!", new Object[0]);
        return true;
    }

    private final boolean m() {
        return a().s(c().o(), c().g(), c().f(), EnumC13889gz5.b) != null;
    }

    @Override // ir.nasim.AbstractC3457Ay5
    protected boolean e() {
        HD4 hd4A = a();
        String strO = c().o();
        String strG = c().g();
        long jF = c().f();
        EnumC13889gz5 enumC13889gz5 = EnumC13889gz5.d;
        JD4 jd4S = hd4A.s(strO, strG, jF, enumC13889gz5);
        if (jd4S == null) {
            return true;
        }
        C19406qI3.a("MessagePushHandler", "MessagePushHandler: early edit push exists", new Object[0]);
        C14566i74 c14566i74C = c();
        String strA = jd4S.a();
        if (strA == null) {
            strA = "";
        }
        c14566i74C.r(strA);
        a().u(c().o(), c().g(), c().f(), enumC13889gz5);
        return true;
    }

    @Override // ir.nasim.AbstractC3457Ay5
    protected void f() {
        C19406qI3.a("MessagePushHandler", "handleNotificationUI , peerUserId: " + c().o(), new Object[0]);
        if (k() && c().n() == null) {
            c().q(EnumC13889gz5.h);
        }
        b().N(c());
    }

    @Override // ir.nasim.AbstractC3457Ay5
    protected void g() {
        a().p(new JD4(0L, c().o(), c().g(), c().f(), c().c(), c().p(), null, null, 1, null));
    }

    @Override // ir.nasim.AbstractC3457Ay5
    protected boolean h() {
        if (!n()) {
            return l();
        }
        C19406qI3.a("MessagePushHandler", "shouldReturn: true because of duplicate push notification", new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC3457Ay5
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C14566i74 c() {
        AbstractC4398Ey5 abstractC4398Ey5C = super.c();
        AbstractC13042fc3.g(abstractC4398Ey5C, "null cannot be cast to non-null type ir.nasim.features.firebase.newPush.model.MessagePushNotification");
        return (C14566i74) abstractC4398Ey5C;
    }

    protected boolean n() {
        return m();
    }
}
