package androidx.compose.ui.platform;

import android.view.View;
import ir.nasim.AbstractC17763nW7;
import ir.nasim.AbstractC19059pi5;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C12889fL5;
import ir.nasim.C19938rB7;
import ir.nasim.InterfaceC18633oz3;
import ir.nasim.InterfaceC19650qi5;
import ir.nasim.M73;
import ir.nasim.SA2;
import ir.nasim.VX7;
import kotlin.KotlinNothingValueException;

/* loaded from: classes2.dex */
public interface v {
    public static final a a = a.a;

    public static final class a {
        static final /* synthetic */ a a = new a();

        private a() {
        }

        public final v a() {
            return c.b;
        }
    }

    public static final class b implements v {
        public static final b b = new b();

        static final class a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ AbstractComposeView e;
            final /* synthetic */ ViewOnAttachStateChangeListenerC0067b f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(AbstractComposeView abstractComposeView, ViewOnAttachStateChangeListenerC0067b viewOnAttachStateChangeListenerC0067b) {
                super(0);
                this.e = abstractComposeView;
                this.f = viewOnAttachStateChangeListenerC0067b;
            }

            public final void a() {
                this.e.removeOnAttachStateChangeListener(this.f);
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return C19938rB7.a;
            }
        }

        /* renamed from: androidx.compose.ui.platform.v$b$b, reason: collision with other inner class name */
        public static final class ViewOnAttachStateChangeListenerC0067b implements View.OnAttachStateChangeListener {
            final /* synthetic */ AbstractComposeView a;

            ViewOnAttachStateChangeListenerC0067b(AbstractComposeView abstractComposeView) {
                this.a = abstractComposeView;
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                this.a.h();
            }
        }

        private b() {
        }

        @Override // androidx.compose.ui.platform.v
        public SA2 a(AbstractComposeView abstractComposeView) {
            ViewOnAttachStateChangeListenerC0067b viewOnAttachStateChangeListenerC0067b = new ViewOnAttachStateChangeListenerC0067b(abstractComposeView);
            abstractComposeView.addOnAttachStateChangeListener(viewOnAttachStateChangeListenerC0067b);
            return new a(abstractComposeView, viewOnAttachStateChangeListenerC0067b);
        }
    }

    public static final class c implements v {
        public static final c b = new c();

        static final class a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ AbstractComposeView e;
            final /* synthetic */ b f;
            final /* synthetic */ InterfaceC19650qi5 g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(AbstractComposeView abstractComposeView, b bVar, InterfaceC19650qi5 interfaceC19650qi5) {
                super(0);
                this.e = abstractComposeView;
                this.f = bVar;
                this.g = interfaceC19650qi5;
            }

            public final void a() {
                this.e.removeOnAttachStateChangeListener(this.f);
                AbstractC19059pi5.e(this.e, this.g);
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return C19938rB7.a;
            }
        }

        public static final class b implements View.OnAttachStateChangeListener {
            final /* synthetic */ AbstractComposeView a;

            b(AbstractComposeView abstractComposeView) {
                this.a = abstractComposeView;
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (AbstractC19059pi5.d(this.a)) {
                    return;
                }
                this.a.h();
            }
        }

        private c() {
        }

        @Override // androidx.compose.ui.platform.v
        public SA2 a(final AbstractComposeView abstractComposeView) {
            b bVar = new b(abstractComposeView);
            abstractComposeView.addOnAttachStateChangeListener(bVar);
            InterfaceC19650qi5 interfaceC19650qi5 = new InterfaceC19650qi5() { // from class: ir.nasim.lW7
            };
            AbstractC19059pi5.a(abstractComposeView, interfaceC19650qi5);
            return new a(abstractComposeView, bVar, interfaceC19650qi5);
        }
    }

    public static final class d implements v {
        public static final d b = new d();

        static final class a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ AbstractComposeView e;
            final /* synthetic */ c f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(AbstractComposeView abstractComposeView, c cVar) {
                super(0);
                this.e = abstractComposeView;
                this.f = cVar;
            }

            public final void a() {
                this.e.removeOnAttachStateChangeListener(this.f);
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return C19938rB7.a;
            }
        }

        static final class b extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ C12889fL5 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C12889fL5 c12889fL5) {
                super(0);
                this.e = c12889fL5;
            }

            public final void a() {
                ((SA2) this.e.a).invoke();
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return C19938rB7.a;
            }
        }

        public static final class c implements View.OnAttachStateChangeListener {
            final /* synthetic */ AbstractComposeView a;
            final /* synthetic */ C12889fL5 b;

            c(AbstractComposeView abstractComposeView, C12889fL5 c12889fL5) {
                this.a = abstractComposeView;
                this.b = c12889fL5;
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                InterfaceC18633oz3 interfaceC18633oz3A = VX7.a(this.a);
                AbstractComposeView abstractComposeView = this.a;
                if (interfaceC18633oz3A != null) {
                    this.b.a = AbstractC17763nW7.c(abstractComposeView, interfaceC18633oz3A.getLifecycle());
                    this.a.removeOnAttachStateChangeListener(this);
                } else {
                    M73.c("View tree for " + abstractComposeView + " has no ViewTreeLifecycleOwner");
                    throw new KotlinNothingValueException();
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }
        }

        private d() {
        }

        @Override // androidx.compose.ui.platform.v
        public SA2 a(AbstractComposeView abstractComposeView) {
            if (!abstractComposeView.isAttachedToWindow()) {
                C12889fL5 c12889fL5 = new C12889fL5();
                c cVar = new c(abstractComposeView, c12889fL5);
                abstractComposeView.addOnAttachStateChangeListener(cVar);
                c12889fL5.a = new a(abstractComposeView, cVar);
                return new b(c12889fL5);
            }
            InterfaceC18633oz3 interfaceC18633oz3A = VX7.a(abstractComposeView);
            if (interfaceC18633oz3A != null) {
                return AbstractC17763nW7.c(abstractComposeView, interfaceC18633oz3A.getLifecycle());
            }
            M73.c("View tree for " + abstractComposeView + " has no ViewTreeLifecycleOwner");
            throw new KotlinNothingValueException();
        }
    }

    SA2 a(AbstractComposeView abstractComposeView);
}
