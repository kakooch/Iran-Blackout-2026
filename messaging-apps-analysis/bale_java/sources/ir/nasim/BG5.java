package ir.nasim;

import android.content.Context;
import android.widget.TextView;

/* loaded from: classes4.dex */
public abstract class BG5 {
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void e(final ir.nasim.EnumC7123Qj2 r31, final ir.nasim.InterfaceC8037Ug2 r32, final ir.nasim.UA2 r33, ir.nasim.InterfaceC22053ub1 r34, final int r35) {
        /*
            Method dump skipped, instructions count: 707
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.BG5.e(ir.nasim.Qj2, ir.nasim.Ug2, ir.nasim.UA2, ir.nasim.ub1, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(EnumC7123Qj2 enumC7123Qj2, TextView textView) {
        AbstractC13042fc3.i(enumC7123Qj2, "$feedbackRate");
        AbstractC13042fc3.i(textView, "it");
        textView.setText(R62.V(textView.getContext().getString(enumC7123Qj2.p()), textView.getPaint().getFontMetricsInt(), false));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextView g(Context context) {
        AbstractC13042fc3.i(context, "context");
        return new TextView(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h(EnumC7123Qj2 enumC7123Qj2, InterfaceC8037Ug2 interfaceC8037Ug2, UA2 ua2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(enumC7123Qj2, "$feedbackRate");
        AbstractC13042fc3.i(interfaceC8037Ug2, "$selectedRate");
        AbstractC13042fc3.i(ua2, "$onClick");
        e(enumC7123Qj2, interfaceC8037Ug2, ua2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    private static final boolean i(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j(UA2 ua2, EnumC7123Qj2 enumC7123Qj2) {
        AbstractC13042fc3.i(ua2, "$onClick");
        AbstractC13042fc3.i(enumC7123Qj2, "$feedbackRate");
        ua2.invoke(enumC7123Qj2);
        return C19938rB7.a;
    }
}
