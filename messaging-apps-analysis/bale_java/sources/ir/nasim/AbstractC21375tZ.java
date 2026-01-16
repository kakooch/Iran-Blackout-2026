package ir.nasim;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.compose.ui.platform.ComposeView;

/* renamed from: ir.nasim.tZ, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC21375tZ {

    /* renamed from: ir.nasim.tZ$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC15796kB2 a;
        final /* synthetic */ Dialog b;

        /* renamed from: ir.nasim.tZ$a$a, reason: collision with other inner class name */
        static final class C1576a implements InterfaceC14603iB2 {
            final /* synthetic */ InterfaceC15796kB2 a;
            final /* synthetic */ Dialog b;

            C1576a(InterfaceC15796kB2 interfaceC15796kB2, Dialog dialog) {
                this.a = interfaceC15796kB2;
                this.b = dialog;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    this.a.q(this.b, interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a(InterfaceC15796kB2 interfaceC15796kB2, Dialog dialog) {
            this.a = interfaceC15796kB2;
            this.b = dialog;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(-974669518, true, new C1576a(this.a, this.b), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final Dialog b(Context context, InterfaceC18633oz3 interfaceC18633oz3, final SA2 sa2, InterfaceC15796kB2 interfaceC15796kB2) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(interfaceC18633oz3, "viewLifecycleOwner");
        AbstractC13042fc3.i(interfaceC15796kB2, "composeBaleDialog");
        Dialog dialog = new Dialog(context);
        ComposeView composeView = new ComposeView(context, null, 0, 6, null);
        composeView.setContent(AbstractC19242q11.c(-1873330035, true, new a(interfaceC15796kB2, dialog)));
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setId(android.R.id.content);
        frameLayout.setLayoutDirection(JF5.g() ? 1 : 2);
        VX7.b(composeView, interfaceC18633oz3);
        XX7.b(frameLayout, (InterfaceC7760Tb6) interfaceC18633oz3);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams((int) ((e(context) * AbstractC3742Cd6.c()) + 0.5d), -2));
        frameLayout.addView(composeView, frameLayout.getLayoutParams());
        dialog.setContentView(frameLayout);
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.nasim.sZ
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                AbstractC21375tZ.d(sa2, dialogInterface);
            }
        });
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        return dialog;
    }

    public static /* synthetic */ Dialog c(Context context, InterfaceC18633oz3 interfaceC18633oz3, SA2 sa2, InterfaceC15796kB2 interfaceC15796kB2, int i, Object obj) {
        if ((i & 4) != 0) {
            sa2 = null;
        }
        return b(context, interfaceC18633oz3, sa2, interfaceC15796kB2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(SA2 sa2, DialogInterface dialogInterface) {
        if (sa2 != null) {
            sa2.invoke();
        }
    }

    public static final int e(Context context) {
        AbstractC13042fc3.i(context, "context");
        return Math.min(context.getResources().getConfiguration().screenWidthDp - 24, 406);
    }
}
