package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.view.ViewGroup;
import androidx.camera.view.PreviewView;
import ir.nasim.C8112Uo5;
import ir.nasim.ED0;
import ir.nasim.InterfaceC22053ub1;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes5.dex */
public abstract class AD0 {

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Context c;
        final /* synthetic */ int d;
        final /* synthetic */ InterfaceFutureC15215jC3 e;
        final /* synthetic */ InterfaceC9102Ym4 f;

        /* renamed from: ir.nasim.AD0$a$a, reason: collision with other inner class name */
        static final class C0256a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InterfaceFutureC15215jC3 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0256a(InterfaceFutureC15215jC3 interfaceFutureC15215jC3, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = interfaceFutureC15215jC3;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C0256a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                return this.c.get();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0256a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, int i, InterfaceFutureC15215jC3 interfaceFutureC15215jC3, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = context;
            this.d = i;
            this.e = interfaceFutureC15215jC3;
            this.f = interfaceC9102Ym4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                AbstractC13778go1 abstractC13778go1B = C12366eV1.b();
                C0256a c0256a = new C0256a(this.e, null);
                this.b = 1;
                obj = AbstractC9323Zl0.g(abstractC13778go1B, c0256a, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            C6471Nr5 c6471Nr5 = (C6471Nr5) obj;
            Context context = this.c;
            AbstractC13042fc3.f(c6471Nr5);
            AD0.k(context, c6471Nr5, AD0.g(this.f), this.d);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class b implements KV1 {
        final /* synthetic */ ExecutorService a;

        public b(ExecutorService executorService) {
            this.a = executorService;
        }

        @Override // ir.nasim.KV1
        public void dispose() {
            this.a.shutdown();
        }
    }

    public static final void d(final Context context, final int i, final XV4 xv4, final androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        Integer num;
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(xv4, "cameraViewScale");
        AbstractC13042fc3.i(eVar, "modifier");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1282662733);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.D(context) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.e(i) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= interfaceC22053ub1J.V(xv4) ? 256 : 128;
        }
        if ((i2 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i3 |= interfaceC22053ub1J.V(eVar) ? 2048 : 1024;
        }
        int i4 = i3;
        if ((i4 & 1171) == 1170 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            interfaceC22053ub1J.W(-1443642648);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = C6471Nr5.i.b(context);
                interfaceC22053ub1J.s(objB);
            }
            InterfaceFutureC15215jC3 interfaceFutureC15215jC3 = (InterfaceFutureC15215jC3) objB;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(-1443639694);
            Object objB2 = interfaceC22053ub1J.B();
            if (objB2 == aVar.a()) {
                objB2 = AbstractC13472gH6.d(null, null, 2, null);
                interfaceC22053ub1J.s(objB2);
            }
            final InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB2;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(-1443637247);
            Object objB3 = interfaceC22053ub1J.B();
            if (objB3 == aVar.a()) {
                objB3 = Executors.newSingleThreadExecutor();
                interfaceC22053ub1J.s(objB3);
            }
            final ExecutorService executorService = (ExecutorService) objB3;
            interfaceC22053ub1J.Q();
            AbstractC13042fc3.f(executorService);
            C19938rB7 c19938rB7 = C19938rB7.a;
            interfaceC22053ub1J.W(-1443634776);
            boolean zD = interfaceC22053ub1J.D(executorService);
            Object objB4 = interfaceC22053ub1J.B();
            if (zD || objB4 == aVar.a()) {
                objB4 = new UA2() { // from class: ir.nasim.xD0
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AD0.i(executorService, (LV1) obj);
                    }
                };
                interfaceC22053ub1J.s(objB4);
            }
            interfaceC22053ub1J.Q();
            AbstractC10721c52.a(c19938rB7, (UA2) objB4, interfaceC22053ub1J, 6);
            interfaceC22053ub1J.W(-1443631604);
            boolean z = (i4 & 896) == 256;
            Object objB5 = interfaceC22053ub1J.B();
            if (z || objB5 == aVar.a()) {
                objB5 = new UA2() { // from class: ir.nasim.yD0
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AD0.e(xv4, interfaceC9102Ym4, (Context) obj);
                    }
                };
                interfaceC22053ub1J.s(objB5);
            }
            interfaceC22053ub1J.Q();
            AbstractC11355cs.a((UA2) objB5, eVar, null, interfaceC22053ub1J, (i4 >> 6) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, 4);
            Integer numValueOf = Integer.valueOf(i);
            interfaceC22053ub1J.W(-1443618939);
            boolean zD2 = interfaceC22053ub1J.D(interfaceFutureC15215jC3) | interfaceC22053ub1J.D(context);
            int i5 = i4 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER;
            boolean z2 = zD2 | (i5 == 32);
            Object objB6 = interfaceC22053ub1J.B();
            if (z2 || objB6 == aVar.a()) {
                num = numValueOf;
                a aVar2 = new a(context, i, interfaceFutureC15215jC3, interfaceC9102Ym4, null);
                interfaceC22053ub1J.s(aVar2);
                objB6 = aVar2;
            } else {
                num = numValueOf;
            }
            interfaceC22053ub1J.Q();
            AbstractC10721c52.f(interfaceFutureC15215jC3, num, (InterfaceC14603iB2) objB6, interfaceC22053ub1J, i5);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.zD0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AD0.f(context, i, xv4, eVar, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PreviewView e(XV4 xv4, InterfaceC9102Ym4 interfaceC9102Ym4, Context context) {
        AbstractC13042fc3.i(xv4, "$cameraViewScale");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$previewView$delegate");
        AbstractC13042fc3.i(context, "ctx");
        PreviewView previewView = new PreviewView(context);
        previewView.setLayoutParams(new ViewGroup.LayoutParams(((Number) xv4.e()).intValue(), ((Number) xv4.f()).intValue()));
        h(interfaceC9102Ym4, previewView);
        return previewView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(Context context, int i, XV4 xv4, androidx.compose.ui.e eVar, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(context, "$context");
        AbstractC13042fc3.i(xv4, "$cameraViewScale");
        AbstractC13042fc3.i(eVar, "$modifier");
        d(context, i, xv4, eVar, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PreviewView g(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return (PreviewView) interfaceC9102Ym4.getValue();
    }

    private static final void h(InterfaceC9102Ym4 interfaceC9102Ym4, PreviewView previewView) {
        interfaceC9102Ym4.setValue(previewView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KV1 i(ExecutorService executorService, LV1 lv1) {
        AbstractC13042fc3.i(executorService, "$cameraExecutor");
        AbstractC13042fc3.i(lv1, "$this$DisposableEffect");
        return new b(executorService);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void k(Context context, C6471Nr5 c6471Nr5, PreviewView previewView, int i) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(c6471Nr5, "cameraProvider");
        C8112Uo5 c8112Uo5C = new C8112Uo5.a().c();
        c8112Uo5C.h0(previewView != null ? previewView.getSurfaceProvider() : null);
        AbstractC13042fc3.h(c8112Uo5C, "also(...)");
        ED0 ed0A = new ED0.a().b(i).a();
        AbstractC13042fc3.h(ed0A, "build(...)");
        c6471Nr5.y();
        c6471Nr5.n((InterfaceC18633oz3) context, ed0A, c8112Uo5C);
    }
}
