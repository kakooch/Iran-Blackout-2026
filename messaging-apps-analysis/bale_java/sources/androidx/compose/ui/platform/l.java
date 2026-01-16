package androidx.compose.ui.platform;

import android.content.Context;
import android.view.PointerIcon;
import android.view.View;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C6206Mq;
import ir.nasim.InterfaceC4953Hg5;

/* loaded from: classes2.dex */
final class l {
    public static final l a = new l();

    private l() {
    }

    public final void a(View view, InterfaceC4953Hg5 interfaceC4953Hg5) {
        PointerIcon pointerIconB = b(view.getContext(), interfaceC4953Hg5);
        if (AbstractC13042fc3.d(view.getPointerIcon(), pointerIconB)) {
            return;
        }
        view.setPointerIcon(pointerIconB);
    }

    public final PointerIcon b(Context context, InterfaceC4953Hg5 interfaceC4953Hg5) {
        return interfaceC4953Hg5 instanceof C6206Mq ? PointerIcon.getSystemIcon(context, ((C6206Mq) interfaceC4953Hg5).a()) : PointerIcon.getSystemIcon(context, AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
    }
}
