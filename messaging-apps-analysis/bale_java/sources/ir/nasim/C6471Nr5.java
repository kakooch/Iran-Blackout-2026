package ir.nasim;

import android.content.Context;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import ir.nasim.AbstractC16967mA0;
import ir.nasim.C19958rE0;
import ir.nasim.C6471Nr5;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.Nr5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C6471Nr5 implements BD0 {
    public static final a i = new a(null);
    private static final C6471Nr5 j = new C6471Nr5();
    private final Object a = new Object();
    private C19958rE0.b b;
    private InterfaceFutureC15215jC3 c;
    private InterfaceFutureC15215jC3 d;
    private final C13887gz3 e;
    private C19367qE0 f;
    private Context g;
    private final Map h;

    /* renamed from: ir.nasim.Nr5$a */
    public static final class a {

        /* renamed from: ir.nasim.Nr5$a$a, reason: collision with other inner class name */
        static final class C0539a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ Context e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0539a(Context context) {
                super(1);
                this.e = context;
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final C6471Nr5 invoke(C19367qE0 c19367qE0) {
                C6471Nr5 c6471Nr5 = C6471Nr5.j;
                AbstractC13042fc3.h(c19367qE0, "cameraX");
                c6471Nr5.w(c19367qE0);
                C6471Nr5 c6471Nr52 = C6471Nr5.j;
                Context contextA = AbstractC17322mm1.a(this.e);
                AbstractC13042fc3.h(contextA, "getApplicationContext(context)");
                c6471Nr52.x(contextA);
                return C6471Nr5.j;
            }
        }

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C6471Nr5 c(UA2 ua2, Object obj) {
            AbstractC13042fc3.i(ua2, "$tmp0");
            return (C6471Nr5) ua2.invoke(obj);
        }

        public final InterfaceFutureC15215jC3 b(Context context) {
            AbstractC13042fc3.i(context, "context");
            AbstractC4980Hj5.g(context);
            InterfaceFutureC15215jC3 interfaceFutureC15215jC3S = C6471Nr5.j.s(context);
            final C0539a c0539a = new C0539a(context);
            InterfaceFutureC15215jC3 interfaceFutureC15215jC3Y = WB2.y(interfaceFutureC15215jC3S, new InterfaceC21819uB2() { // from class: ir.nasim.Mr5
                @Override // ir.nasim.InterfaceC21819uB2
                public final Object apply(Object obj) {
                    return C6471Nr5.a.c(c0539a, obj);
                }
            }, AbstractC20567sE0.a());
            AbstractC13042fc3.h(interfaceFutureC15215jC3Y, "context: Context): Liste…tExecutor()\n            )");
            return interfaceFutureC15215jC3Y;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Nr5$b */
    public static final class b implements MB2 {
        final /* synthetic */ AbstractC16967mA0.a a;
        final /* synthetic */ C19367qE0 b;

        b(AbstractC16967mA0.a aVar, C19367qE0 c19367qE0) {
            this.a = aVar;
            this.b = c19367qE0;
        }

        @Override // ir.nasim.MB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r2) {
            this.a.c(this.b);
        }

        @Override // ir.nasim.MB2
        public void onFailure(Throwable th) {
            AbstractC13042fc3.i(th, "t");
            this.a.f(th);
        }
    }

    /* renamed from: ir.nasim.Nr5$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C19367qE0 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C19367qE0 c19367qE0) {
            super(1);
            this.e = c19367qE0;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceFutureC15215jC3 invoke(Void r1) {
            return this.e.i();
        }
    }

    private C6471Nr5() {
        InterfaceFutureC15215jC3 interfaceFutureC15215jC3L = WB2.l(null);
        AbstractC13042fc3.h(interfaceFutureC15215jC3L, "immediateFuture<Void>(null)");
        this.d = interfaceFutureC15215jC3L;
        this.e = new C13887gz3();
        this.h = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final androidx.camera.core.impl.f p(ED0 ed0, InterfaceC14021hD0 interfaceC14021hD0) {
        Iterator it = ed0.c().iterator();
        androidx.camera.core.impl.f fVar = null;
        while (it.hasNext()) {
            Object next = it.next();
            AbstractC13042fc3.h(next, "cameraSelector.cameraFilterSet");
            InterfaceC12203eD0 interfaceC12203eD0 = (InterfaceC12203eD0) next;
            if (!AbstractC13042fc3.d(interfaceC12203eD0.getIdentifier(), InterfaceC12203eD0.a)) {
                InterfaceC21152tC0 interfaceC21152tC0A = AbstractC3981De2.a(interfaceC12203eD0.getIdentifier());
                Context context = this.g;
                AbstractC13042fc3.f(context);
                androidx.camera.core.impl.f fVarA = interfaceC21152tC0A.a(interfaceC14021hD0, context);
                if (fVarA == null) {
                    continue;
                } else {
                    if (fVar != null) {
                        throw new IllegalArgumentException("Cannot apply multiple extended camera configs at the same time.");
                    }
                    fVar = fVarA;
                }
            }
        }
        return fVar == null ? AbstractC21826uC0.a() : fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int r() {
        C19367qE0 c19367qE0 = this.f;
        if (c19367qE0 == null) {
            return 0;
        }
        AbstractC13042fc3.f(c19367qE0);
        return c19367qE0.e().d().c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceFutureC15215jC3 s(Context context) {
        synchronized (this.a) {
            InterfaceFutureC15215jC3 interfaceFutureC15215jC3 = this.c;
            if (interfaceFutureC15215jC3 != null) {
                AbstractC13042fc3.g(interfaceFutureC15215jC3, "null cannot be cast to non-null type com.google.common.util.concurrent.ListenableFuture<androidx.camera.core.CameraX>");
                return interfaceFutureC15215jC3;
            }
            final C19367qE0 c19367qE0 = new C19367qE0(context, this.b);
            InterfaceFutureC15215jC3 interfaceFutureC15215jC3A = AbstractC16967mA0.a(new AbstractC16967mA0.c() { // from class: ir.nasim.Kr5
                @Override // ir.nasim.AbstractC16967mA0.c
                public final Object a(AbstractC16967mA0.a aVar) {
                    return C6471Nr5.t(this.a, c19367qE0, aVar);
                }
            });
            this.c = interfaceFutureC15215jC3A;
            AbstractC13042fc3.g(interfaceFutureC15215jC3A, "null cannot be cast to non-null type com.google.common.util.concurrent.ListenableFuture<androidx.camera.core.CameraX>");
            return interfaceFutureC15215jC3A;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object t(C6471Nr5 c6471Nr5, C19367qE0 c19367qE0, AbstractC16967mA0.a aVar) {
        AbstractC13042fc3.i(c6471Nr5, "this$0");
        AbstractC13042fc3.i(c19367qE0, "$cameraX");
        AbstractC13042fc3.i(aVar, "completer");
        synchronized (c6471Nr5.a) {
            NB2 nb2A = NB2.a(c6471Nr5.d);
            final c cVar = new c(c19367qE0);
            NB2 nb2E = nb2A.e(new FK() { // from class: ir.nasim.Lr5
                @Override // ir.nasim.FK
                public final InterfaceFutureC15215jC3 apply(Object obj) {
                    return C6471Nr5.u(cVar, obj);
                }
            }, AbstractC20567sE0.a());
            AbstractC13042fc3.h(nb2E, "cameraX = CameraX(contex…                        )");
            WB2.g(nb2E, new b(aVar, c19367qE0), AbstractC20567sE0.a());
            C19938rB7 c19938rB7 = C19938rB7.a;
        }
        return "ProcessCameraProvider-initializeCameraX";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceFutureC15215jC3 u(UA2 ua2, Object obj) {
        AbstractC13042fc3.i(ua2, "$tmp0");
        return (InterfaceFutureC15215jC3) ua2.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(int i2) {
        C19367qE0 c19367qE0 = this.f;
        if (c19367qE0 == null) {
            return;
        }
        AbstractC13042fc3.f(c19367qE0);
        c19367qE0.e().d().d(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(C19367qE0 c19367qE0) {
        this.f = c19367qE0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(Context context) {
        this.g = context;
    }

    public final HB0 n(InterfaceC18633oz3 interfaceC18633oz3, ED0 ed0, AbstractC15273jI7... abstractC15273jI7Arr) {
        AbstractC13042fc3.i(interfaceC18633oz3, "lifecycleOwner");
        AbstractC13042fc3.i(ed0, "cameraSelector");
        AbstractC13042fc3.i(abstractC15273jI7Arr, "useCases");
        C16807lt7.a("CX:bindToLifecycle");
        try {
            if (r() == 2) {
                throw new UnsupportedOperationException("bindToLifecycle for single camera is not supported in concurrent camera mode, call unbindAll() first");
            }
            v(1);
            C6012Lu3 c6012Lu3 = C6012Lu3.f;
            AbstractC13042fc3.h(c6012Lu3, "DEFAULT");
            AbstractC13042fc3.h(c6012Lu3, "DEFAULT");
            return o(interfaceC18633oz3, ed0, null, c6012Lu3, c6012Lu3, null, AbstractC10360bX0.m(), (AbstractC15273jI7[]) Arrays.copyOf(abstractC15273jI7Arr, abstractC15273jI7Arr.length));
        } finally {
            C16807lt7.b();
        }
    }

    public final HB0 o(InterfaceC18633oz3 interfaceC18633oz3, ED0 ed0, ED0 ed02, C6012Lu3 c6012Lu3, C6012Lu3 c6012Lu32, C22022uX7 c22022uX7, List list, AbstractC15273jI7... abstractC15273jI7Arr) {
        InterfaceC15221jD0 interfaceC15221jD0;
        S06 s06;
        AbstractC13042fc3.i(interfaceC18633oz3, "lifecycleOwner");
        AbstractC13042fc3.i(ed0, "primaryCameraSelector");
        AbstractC13042fc3.i(c6012Lu3, "primaryLayoutSettings");
        AbstractC13042fc3.i(c6012Lu32, "secondaryLayoutSettings");
        AbstractC13042fc3.i(list, "effects");
        AbstractC13042fc3.i(abstractC15273jI7Arr, "useCases");
        C16807lt7.a("CX:bindToLifecycle-internal");
        try {
            AbstractC17949np7.a();
            C19367qE0 c19367qE0 = this.f;
            AbstractC13042fc3.f(c19367qE0);
            InterfaceC15221jD0 interfaceC15221jD0E = ed0.e(c19367qE0.f().a());
            AbstractC13042fc3.h(interfaceC15221jD0E, "primaryCameraSelector.se…cameraRepository.cameras)");
            interfaceC15221jD0E.q(true);
            InterfaceC14021hD0 interfaceC14021hD0Q = q(ed0);
            AbstractC13042fc3.g(interfaceC14021hD0Q, "null cannot be cast to non-null type androidx.camera.core.impl.RestrictedCameraInfo");
            S06 s062 = (S06) interfaceC14021hD0Q;
            if (ed02 != null) {
                C19367qE0 c19367qE02 = this.f;
                AbstractC13042fc3.f(c19367qE02);
                InterfaceC15221jD0 interfaceC15221jD0E2 = ed02.e(c19367qE02.f().a());
                interfaceC15221jD0E2.q(false);
                InterfaceC14021hD0 interfaceC14021hD0Q2 = q(ed02);
                AbstractC13042fc3.g(interfaceC14021hD0Q2, "null cannot be cast to non-null type androidx.camera.core.impl.RestrictedCameraInfo");
                interfaceC15221jD0 = interfaceC15221jD0E2;
                s06 = (S06) interfaceC14021hD0Q2;
            } else {
                interfaceC15221jD0 = null;
                s06 = null;
            }
            C13296fz3 c13296fz3C = this.e.c(interfaceC18633oz3, CameraUseCaseAdapter.A(s062, s06));
            Collection collectionE = this.e.e();
            for (AbstractC15273jI7 abstractC15273jI7 : AbstractC10242bK.Y(abstractC15273jI7Arr)) {
                for (Object obj : collectionE) {
                    AbstractC13042fc3.h(obj, "lifecycleCameras");
                    C13296fz3 c13296fz3 = (C13296fz3) obj;
                    if (c13296fz3.v(abstractC15273jI7) && !AbstractC13042fc3.d(c13296fz3, c13296fz3C)) {
                        DY6 dy6 = DY6.a;
                        String str = String.format("Use case %s already bound to a different lifecycle.", Arrays.copyOf(new Object[]{abstractC15273jI7}, 1));
                        AbstractC13042fc3.h(str, "format(format, *args)");
                        throw new IllegalStateException(str);
                    }
                }
            }
            if (c13296fz3C == null) {
                C13887gz3 c13887gz3 = this.e;
                C19367qE0 c19367qE03 = this.f;
                AbstractC13042fc3.f(c19367qE03);
                MC0 mc0D = c19367qE03.e().d();
                C19367qE0 c19367qE04 = this.f;
                AbstractC13042fc3.f(c19367qE04);
                XC0 xc0D = c19367qE04.d();
                C19367qE0 c19367qE05 = this.f;
                AbstractC13042fc3.f(c19367qE05);
                c13296fz3C = c13887gz3.b(interfaceC18633oz3, new CameraUseCaseAdapter(interfaceC15221jD0E, interfaceC15221jD0, s062, s06, c6012Lu3, c6012Lu32, mc0D, xc0D, c19367qE05.h()));
            }
            if (abstractC15273jI7Arr.length == 0) {
                AbstractC13042fc3.f(c13296fz3C);
            } else {
                C13887gz3 c13887gz32 = this.e;
                AbstractC13042fc3.f(c13296fz3C);
                List listP = AbstractC10360bX0.p(Arrays.copyOf(abstractC15273jI7Arr, abstractC15273jI7Arr.length));
                C19367qE0 c19367qE06 = this.f;
                AbstractC13042fc3.f(c19367qE06);
                c13887gz32.a(c13296fz3C, c22022uX7, list, listP, c19367qE06.e().d());
            }
            C16807lt7.b();
            return c13296fz3C;
        } catch (Throwable th) {
            C16807lt7.b();
            throw th;
        }
    }

    public InterfaceC14021hD0 q(ED0 ed0) {
        Object s06;
        AbstractC13042fc3.i(ed0, "cameraSelector");
        C16807lt7.a("CX:getCameraInfo");
        try {
            C19367qE0 c19367qE0 = this.f;
            AbstractC13042fc3.f(c19367qE0);
            InterfaceC14623iD0 interfaceC14623iD0J = ed0.e(c19367qE0.f().a()).j();
            AbstractC13042fc3.h(interfaceC14623iD0J, "cameraSelector.select(mC…meras).cameraInfoInternal");
            androidx.camera.core.impl.f fVarP = p(ed0, interfaceC14623iD0J);
            CameraUseCaseAdapter.a aVarA = CameraUseCaseAdapter.a.a(interfaceC14623iD0J.b(), fVarP.Q());
            AbstractC13042fc3.h(aVarA, "create(\n                …ilityId\n                )");
            synchronized (this.a) {
                try {
                    s06 = this.h.get(aVarA);
                    if (s06 == null) {
                        s06 = new S06(interfaceC14623iD0J, fVarP);
                        this.h.put(aVarA, s06);
                    }
                    C19938rB7 c19938rB7 = C19938rB7.a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return (S06) s06;
        } finally {
            C16807lt7.b();
        }
    }

    public void y() {
        C16807lt7.a("CX:unbindAll");
        try {
            AbstractC17949np7.a();
            v(0);
            this.e.k();
            C19938rB7 c19938rB7 = C19938rB7.a;
        } finally {
            C16807lt7.b();
        }
    }
}
