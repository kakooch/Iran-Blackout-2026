package ir.nasim;

/* renamed from: ir.nasim.Ay5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC3457Ay5 {
    public static final a d = new a(null);
    public static final int e = 8;
    private final AbstractC4398Ey5 a;
    private final HD4 b;
    private final CE4 c;

    /* renamed from: ir.nasim.Ay5$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public AbstractC3457Ay5(AbstractC4398Ey5 abstractC4398Ey5, HD4 hd4, CE4 ce4) {
        AbstractC13042fc3.i(abstractC4398Ey5, "pushNotification");
        AbstractC13042fc3.i(hd4, "notificationRecordDao");
        AbstractC13042fc3.i(ce4, "notificationUIManager");
        this.a = abstractC4398Ey5;
        this.b = hd4;
        this.c = ce4;
    }

    protected final HD4 a() {
        return this.b;
    }

    protected final CE4 b() {
        return this.c;
    }

    protected AbstractC4398Ey5 c() {
        return this.a;
    }

    public final boolean d() {
        C19406qI3.a("PushHandler", String.valueOf(c()), new Object[0]);
        if (h()) {
            C19406qI3.a("PushHandler", "should return. no need to handle notification", new Object[0]);
            return false;
        }
        if (e()) {
            f();
            g();
            return true;
        }
        C19406qI3.a("PushHandler", "notification db handled. no need for any UI changes", new Object[0]);
        g();
        return false;
    }

    protected abstract boolean e();

    protected abstract void f();

    protected abstract void g();

    protected abstract boolean h();
}
