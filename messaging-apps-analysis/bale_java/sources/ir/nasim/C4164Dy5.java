package ir.nasim;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Dy5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4164Dy5 {
    private boolean a;

    /* renamed from: ir.nasim.Dy5$a */
    static final class a extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return C4164Dy5.this.e(this);
        }
    }

    /* renamed from: ir.nasim.Dy5$b */
    static final class b implements UA2 {
        final /* synthetic */ InterfaceC20295rm1 a;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            this.a = interfaceC20295rm1;
        }

        public final void a(String str) {
            C19406qI3.a("PushManager", "getFirebaseToken success", new Object[0]);
            this.a.resumeWith(C9475a16.b(str));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((String) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Dy5$c */
    static final class c implements InterfaceC14681iJ4 {
        final /* synthetic */ InterfaceC20295rm1 a;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            this.a = interfaceC20295rm1;
        }

        @Override // ir.nasim.InterfaceC14681iJ4
        public final void a(Exception exc) {
            AbstractC13042fc3.i(exc, "it");
            C19406qI3.j("PushManager", "getFirebaseToken failure: " + exc, new Object[0]);
            this.a.resumeWith(C9475a16.b(null));
        }
    }

    /* renamed from: ir.nasim.Dy5$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        private /* synthetic */ Object d;
        final /* synthetic */ Context f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Context context, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.f = context;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            d dVar = C4164Dy5.this.new d(this.f, interfaceC20295rm1);
            dVar.d = obj;
            return dVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x00ae A[Catch: Exception -> 0x0032, TryCatch #0 {Exception -> 0x0032, blocks: (B:21:0x0094, B:24:0x00aa, B:26:0x00ae, B:27:0x00be, B:10:0x002d), top: B:35:0x002d }] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00be A[Catch: Exception -> 0x0032, TRY_LEAVE, TryCatch #0 {Exception -> 0x0032, blocks: (B:21:0x0094, B:24:0x00aa, B:26:0x00ae, B:27:0x00be, B:10:0x002d), top: B:35:0x002d }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00f0 -> B:19:0x008e). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                Method dump skipped, instructions count: 246
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4164Dy5.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Dy5$e */
    static final class e implements InterfaceC13497gK4 {
        private final /* synthetic */ UA2 a;

        e(UA2 ua2) {
            AbstractC13042fc3.i(ua2, "function");
            this.a = ua2;
        }

        @Override // ir.nasim.InterfaceC13497gK4
        public final /* synthetic */ void onSuccess(Object obj) {
            this.a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean d(Context context) {
        try {
            int iG = com.google.android.gms.common.a.m().g(context);
            if (iG != 0) {
                C19406qI3.j("PushManager", "isGooglePlayServicesAvailable not true! result code: " + iG, new Object[0]);
            }
            return iG == 0;
        } catch (Exception e2) {
            C19406qI3.j("PushManager", "isGooglePlayServicesAvailable exception: " + e2, new Object[0]);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ir.nasim.C4164Dy5.a
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.Dy5$a r0 = (ir.nasim.C4164Dy5.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.Dy5$a r0 = new ir.nasim.Dy5$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r6)
            goto L6d
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r6)
            r0.c = r3
            ir.nasim.m96 r6 = new ir.nasim.m96
            ir.nasim.rm1 r2 = ir.nasim.AbstractC13660gc3.c(r0)
            r6.<init>(r2)
            com.google.firebase.messaging.FirebaseMessaging r2 = com.google.firebase.messaging.FirebaseMessaging.n()
            com.google.android.gms.tasks.Task r2 = r2.q()
            ir.nasim.Dy5$b r3 = new ir.nasim.Dy5$b
            r3.<init>(r6)
            ir.nasim.Dy5$e r4 = new ir.nasim.Dy5$e
            r4.<init>(r3)
            com.google.android.gms.tasks.Task r2 = r2.f(r4)
            ir.nasim.Dy5$c r3 = new ir.nasim.Dy5$c
            r3.<init>(r6)
            r2.d(r3)
            java.lang.Object r6 = r6.a()
            java.lang.Object r2 = ir.nasim.AbstractC13660gc3.e()
            if (r6 != r2) goto L6a
            ir.nasim.WA1.c(r0)
        L6a:
            if (r6 != r1) goto L6d
            return r1
        L6d:
            java.lang.String r6 = (java.lang.String) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4164Dy5.e(ir.nasim.rm1):java.lang.Object");
    }

    public final void f(String str) {
        AbstractC13042fc3.i(str, "token");
        C19406qI3.a("PushManager", "onPushTokenSuccess: Going to call registerGooglePush RPC", new Object[0]);
        this.a = true;
        C5735Kp4.w().i().j1(C5735Kp4.w().j(), "FCM_" + str);
    }

    public final void g(Context context) {
        AbstractC13042fc3.i(context, "context");
        AbstractC10533bm0.d(C17050mJ2.a, C12366eV1.b(), null, new d(context, null), 2, null);
    }
}
