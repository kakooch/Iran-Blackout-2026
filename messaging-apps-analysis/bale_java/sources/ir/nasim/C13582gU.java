package ir.nasim;

import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;

/* renamed from: ir.nasim.gU, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C13582gU {
    public static final C13582gU a = new C13582gU();

    private C13582gU() {
    }

    public final void A(ViewStructure viewStructure, int i) {
        viewStructure.setVisibility(i);
    }

    public final CharSequence B(AutofillValue autofillValue) {
        return autofillValue.getTextValue();
    }

    public final int a(ViewStructure viewStructure, int i) {
        return viewStructure.addChildCount(i);
    }

    public final AutofillValue b(String str) {
        return AutofillValue.forText(str);
    }

    public final boolean c(AutofillValue autofillValue) {
        return autofillValue.isDate();
    }

    public final boolean d(AutofillValue autofillValue) {
        return autofillValue.isList();
    }

    public final boolean e(AutofillValue autofillValue) {
        return autofillValue.isText();
    }

    public final boolean f(AutofillValue autofillValue) {
        return autofillValue.isToggle();
    }

    public final ViewStructure g(ViewStructure viewStructure, int i) {
        return viewStructure.newChild(i);
    }

    public final void h(ViewStructure viewStructure, String[] strArr) {
        viewStructure.setAutofillHints(strArr);
    }

    public final void i(ViewStructure viewStructure, AutofillId autofillId, int i) {
        viewStructure.setAutofillId(autofillId, i);
    }

    public final void j(ViewStructure viewStructure, int i) {
        viewStructure.setAutofillType(i);
    }

    public final void k(ViewStructure viewStructure, AutofillValue autofillValue) {
        viewStructure.setAutofillValue(autofillValue);
    }

    public final void l(ViewStructure viewStructure, boolean z) {
        viewStructure.setCheckable(z);
    }

    public final void m(ViewStructure viewStructure, boolean z) {
        viewStructure.setChecked(z);
    }

    public final void n(ViewStructure viewStructure, String str) {
        viewStructure.setClassName(str);
    }

    public final void o(ViewStructure viewStructure, boolean z) {
        viewStructure.setClickable(z);
    }

    public final void p(ViewStructure viewStructure, CharSequence charSequence) {
        viewStructure.setContentDescription(charSequence);
    }

    public final void q(ViewStructure viewStructure, boolean z) {
        viewStructure.setDataIsSensitive(z);
    }

    public final void r(ViewStructure viewStructure, int i, int i2, int i3, int i4, int i5, int i6) {
        viewStructure.setDimens(i, i2, i3, i4, i5, i6);
    }

    public final void s(ViewStructure viewStructure, boolean z) {
        viewStructure.setEnabled(z);
    }

    public final void t(ViewStructure viewStructure, boolean z) {
        viewStructure.setFocusable(z);
    }

    public final void u(ViewStructure viewStructure, boolean z) {
        viewStructure.setFocused(z);
    }

    public final void v(ViewStructure viewStructure, int i, String str, String str2, String str3) {
        viewStructure.setId(i, str, str2, str3);
    }

    public final void w(ViewStructure viewStructure, int i) {
        viewStructure.setInputType(i);
    }

    public final void x(ViewStructure viewStructure, boolean z) {
        viewStructure.setLongClickable(z);
    }

    public final void y(ViewStructure viewStructure, boolean z) {
        viewStructure.setSelected(z);
    }

    public final void z(ViewStructure viewStructure, CharSequence charSequence) {
        viewStructure.setText(charSequence);
    }
}
