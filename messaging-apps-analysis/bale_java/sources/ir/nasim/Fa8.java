package ir.nasim;

import android.view.View;
import ir.nasim.InterfaceC13730gj3;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class Fa8 {
    public static final Fa8 a = new Fa8();
    private static final AtomicReference b = new AtomicReference(Ea8.a.c());
    public static final int c = 8;

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ SJ5 c;
        final /* synthetic */ View d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(SJ5 sj5, View view, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = sj5;
            this.d = view;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            View view;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            try {
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    SJ5 sj5 = this.c;
                    this.b = 1;
                    if (sj5.k0(this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                if (Ga8.f(view) == this.c) {
                    Ga8.i(this.d, null);
                }
                return C19938rB7.a;
            } finally {
                if (Ga8.f(this.d) == this.c) {
                    Ga8.i(this.d, null);
                }
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    private Fa8() {
    }

    public final SJ5 a(View view) {
        SJ5 sj5A = ((Ea8) b.get()).a(view);
        Ga8.i(view, sj5A);
        view.addOnAttachStateChangeListener(new a(AbstractC10533bm0.d(C17050mJ2.a, AbstractC21324tT2.b(view.getHandler(), "windowRecomposer cleanup").F0(), null, new b(sj5A, view, null), 2, null)));
        return sj5A;
    }

    public static final class a implements View.OnAttachStateChangeListener {
        final /* synthetic */ InterfaceC13730gj3 a;

        a(InterfaceC13730gj3 interfaceC13730gj3) {
            this.a = interfaceC13730gj3;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            view.removeOnAttachStateChangeListener(this);
            InterfaceC13730gj3.a.a(this.a, null, 1, null);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }
    }
}
