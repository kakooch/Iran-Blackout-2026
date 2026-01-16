package ir.nasim;

import android.view.View;

/* renamed from: ir.nasim.zi2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC25084zi2 {
    private static final void c(final View view, final boolean z, long j) {
        view.animate().setDuration(j).alpha(z ? 1.0f : 0.0f).withEndAction(new Runnable() { // from class: ir.nasim.xi2
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC25084zi2.e(z, view);
            }
        }).withStartAction(new Runnable() { // from class: ir.nasim.yi2
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC25084zi2.f(z, view);
            }
        }).start();
    }

    static /* synthetic */ void d(View view, boolean z, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 200;
        }
        c(view, z, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(boolean z, View view) {
        AbstractC13042fc3.i(view, "$this_toggleAnimatedVisibilityWithDuration");
        if (z) {
            return;
        }
        view.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(boolean z, View view) {
        AbstractC13042fc3.i(view, "$this_toggleAnimatedVisibilityWithDuration");
        if (z) {
            view.setVisibility(z ? 0 : 8);
        }
    }
}
