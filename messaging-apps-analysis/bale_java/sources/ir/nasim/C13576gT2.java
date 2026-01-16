package ir.nasim;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import ir.nasim.C13576gT2;
import ir.nasim.C17448mz0;

/* renamed from: ir.nasim.gT2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C13576gT2 {
    public static final a d = new a(null);
    public static final int e = 8;
    private final Context a;
    private final TK4 b;
    private final NotificationManager c;

    /* renamed from: ir.nasim.gT2$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.gT2$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long c;
        final /* synthetic */ Context d;
        final /* synthetic */ C8942Xx0 e;
        final /* synthetic */ C13576gT2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(long j, Context context, C8942Xx0 c8942Xx0, C13576gT2 c13576gT2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = j;
            this.d = context;
            this.e = c8942Xx0;
            this.f = c13576gT2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y(C13576gT2 c13576gT2, long j, Notification notification) {
            if (((C17448mz0) C18039nz0.a.d().getValue()).e() == C17448mz0.a.e) {
                c13576gT2.c.notify((int) j, notification);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            long j = this.c;
            C19406qI3.a("HandleIncomingNotificationUseCase", "showIncomingCallNotification " + j + " | " + ((int) j), new Object[0]);
            C5335Ix0 c5335Ix0 = C5335Ix0.a;
            Context context = this.d;
            C8942Xx0 c8942Xx0 = this.e;
            final long j2 = this.c;
            final C13576gT2 c13576gT2 = this.f;
            this.f.c.notify((int) this.c, c5335Ix0.C(context, c8942Xx0, j2, false, new UA2() { // from class: ir.nasim.hT2
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj2) {
                    return C13576gT2.b.y(c13576gT2, j2, (Notification) obj2);
                }
            }));
            C19406qI3.a("HandleIncomingNotificationUseCase", "showIncomingCallNotification end", new Object[0]);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C13576gT2(Context context, TK4 tk4, NotificationManager notificationManager) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(tk4, "openCallActivityUseCase");
        AbstractC13042fc3.i(notificationManager, "notificationManager");
        this.a = context;
        this.b = tk4;
        this.c = notificationManager;
    }

    private final Object c(C8942Xx0 c8942Xx0, long j, Context context, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(C12366eV1.c(), new b(j, context, c8942Xx0, this, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    public final Object b(C8942Xx0 c8942Xx0, long j, InterfaceC20295rm1 interfaceC20295rm1) {
        C19406qI3.a("HandleIncomingNotificationUseCase", "SHOW INCOMING NOTIFICATION WITH ID $" + ((int) j), new Object[0]);
        if (!AD4.e(this.a).a()) {
            this.b.a();
            return C19938rB7.a;
        }
        Object objC = c(c8942Xx0, j, this.a, interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }
}
