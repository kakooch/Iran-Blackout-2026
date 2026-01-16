package ir.nasim;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;

/* renamed from: ir.nasim.Ue5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C8022Ue5 implements InterfaceC6598Oe5 {
    private final AutofillManager a;

    public C8022Ue5(AutofillManager autofillManager) {
        this.a = autofillManager;
    }

    @Override // ir.nasim.InterfaceC6598Oe5
    public void a(View view, int i, AutofillValue autofillValue) {
        this.a.notifyValueChanged(view, i, autofillValue);
    }

    @Override // ir.nasim.InterfaceC6598Oe5
    public void b(View view, int i) {
        this.a.notifyViewExited(view, i);
    }

    @Override // ir.nasim.InterfaceC6598Oe5
    public void c(View view, int i, Rect rect) {
        this.a.requestAutofill(view, i, rect);
    }

    @Override // ir.nasim.InterfaceC6598Oe5
    public void commit() {
        this.a.commit();
    }

    @Override // ir.nasim.InterfaceC6598Oe5
    public void d(View view, int i, boolean z) {
        if (Build.VERSION.SDK_INT >= 27) {
            C14784iU.a.a(view, this.a, i, z);
        }
    }

    @Override // ir.nasim.InterfaceC6598Oe5
    public void e(View view, int i, Rect rect) {
        this.a.notifyViewEntered(view, i, rect);
    }
}
