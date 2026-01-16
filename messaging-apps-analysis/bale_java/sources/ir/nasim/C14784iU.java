package ir.nasim;

import android.view.View;
import android.view.autofill.AutofillManager;

/* renamed from: ir.nasim.iU, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C14784iU {
    public static final C14784iU a = new C14784iU();

    private C14784iU() {
    }

    public final void a(View view, AutofillManager autofillManager, int i, boolean z) {
        autofillManager.notifyViewVisibilityChanged(view, i, z);
    }
}
