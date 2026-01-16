package ir.nasim;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.compose.ui.platform.ComposeView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.G;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ+\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0003J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lir/nasim/v82;", "Landroidx/fragment/app/l;", "<init>", "()V", "Lir/nasim/rB7;", "U8", "", "endForEveryOne", "S8", "(Z)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "h7", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "Lir/nasim/fA0;", "r1", "Lir/nasim/Yu3;", "T8", "()Lir/nasim/fA0;", "viewModel", "call_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.v82, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C22380v82 extends EW2 {

    /* renamed from: r1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C12767fA0.class), new b(this), new c(null, this), new d(this));

    /* renamed from: ir.nasim.v82$a */
    static final class a implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.v82$a$a, reason: collision with other inner class name */
        static final class C1655a implements InterfaceC14603iB2 {
            final /* synthetic */ C22380v82 a;

            /* renamed from: ir.nasim.v82$a$a$a, reason: collision with other inner class name */
            /* synthetic */ class C1656a extends EB2 implements SA2 {
                C1656a(Object obj) {
                    super(0, obj, C22380v82.class, "onClosePressed", "onClosePressed()V", 0);
                }

                @Override // ir.nasim.SA2
                public /* bridge */ /* synthetic */ Object invoke() {
                    y();
                    return C19938rB7.a;
                }

                public final void y() {
                    ((C22380v82) this.receiver).U8();
                }
            }

            /* renamed from: ir.nasim.v82$a$a$b */
            /* synthetic */ class b extends EB2 implements UA2 {
                b(Object obj) {
                    super(1, obj, C22380v82.class, "endGroupCall", "endGroupCall(Z)V", 0);
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    y(((Boolean) obj).booleanValue());
                    return C19938rB7.a;
                }

                public final void y(boolean z) {
                    ((C22380v82) this.receiver).S8(z);
                }
            }

            C1655a(C22380v82 c22380v82) {
                this.a = c22380v82;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                C22380v82 c22380v82 = this.a;
                interfaceC22053ub1.W(-1931957794);
                boolean zD = interfaceC22053ub1.D(c22380v82);
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new C1656a(c22380v82);
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                SA2 sa2 = (SA2) ((InterfaceC16733lm3) objB);
                C22380v82 c22380v822 = this.a;
                interfaceC22053ub1.W(-1931955972);
                boolean zD2 = interfaceC22053ub1.D(c22380v822);
                Object objB2 = interfaceC22053ub1.B();
                if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new b(c22380v822);
                    interfaceC22053ub1.s(objB2);
                }
                interfaceC22053ub1.Q();
                AbstractC21790u82.e(sa2, (UA2) ((InterfaceC16733lm3) objB2), interfaceC22053ub1, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(-1895191488, true, new C1655a(C22380v82.this), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.v82$b */
    public static final class b extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return this.e.Q7().d1();
        }
    }

    /* renamed from: ir.nasim.v82$c */
    public static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ Fragment f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(SA2 sa2, Fragment fragment) {
            super(0);
            this.e = sa2;
            this.f = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC20375ru1 invoke() {
            AbstractC20375ru1 abstractC20375ru1;
            SA2 sa2 = this.e;
            return (sa2 == null || (abstractC20375ru1 = (AbstractC20375ru1) sa2.invoke()) == null) ? this.f.Q7().p3() : abstractC20375ru1;
        }
    }

    /* renamed from: ir.nasim.v82$d */
    public static final class d extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            return this.e.Q7().n3();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S8(boolean endForEveryOne) {
        T8().Q1(endForEveryOne);
    }

    private final C12767fA0 T8() {
        return (C12767fA0) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U8() {
        x8();
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Window window;
        AbstractC13042fc3.i(inflater, "inflater");
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        ComposeView composeView = new ComposeView(contextS7, null, 0, 6, null);
        Dialog dialogY8 = y8();
        if (dialogY8 != null && (window = dialogY8.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        composeView.setContent(AbstractC19242q11.c(730738117, true, new a()));
        return composeView;
    }

    @Override // androidx.fragment.app.Fragment
    public void h7() {
        Window window;
        WindowManager.LayoutParams attributes;
        Window window2;
        super.h7();
        Dialog dialogY8 = y8();
        if (dialogY8 == null || (window = dialogY8.getWindow()) == null || (attributes = window.getAttributes()) == null) {
            return;
        }
        ((ViewGroup.LayoutParams) attributes).width = -1;
        Dialog dialogY82 = y8();
        if (dialogY82 == null || (window2 = dialogY82.getWindow()) == null) {
            return;
        }
        window2.setAttributes(attributes);
    }

    @Override // androidx.fragment.app.l, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        AbstractC13042fc3.i(dialog, "dialog");
        T8().C1();
        super.onDismiss(dialog);
    }
}
