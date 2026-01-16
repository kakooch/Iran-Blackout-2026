package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC15520jj2;

/* renamed from: ir.nasim.sX7, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C20745sX7 {
    private long a;
    private long b;

    public void a() {
        this.a = System.currentTimeMillis();
    }

    public void b(RecyclerView recyclerView, int i, InterfaceC16978mB2 interfaceC16978mB2, InterfaceC14603iB2 interfaceC14603iB2) {
        C4743Gj2 c4743Gj2N3;
        C5886Lg2 c5886Lg2E;
        AbstractC13042fc3.i(recyclerView, "recyclerView");
        AbstractC13042fc3.i(interfaceC16978mB2, "sendPostDurationEventVideo");
        AbstractC13042fc3.i(interfaceC14603iB2, "sendPostDurationEventSimple");
        this.b = System.currentTimeMillis() - this.a;
        RecyclerView.C cFindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(i);
        JA2 ja2 = cFindViewHolderForAdapterPosition instanceof JA2 ? (JA2) cFindViewHolderForAdapterPosition : null;
        if (ja2 != null && (c4743Gj2N3 = ja2.n3()) != null && (c5886Lg2E = c4743Gj2N3.e()) != null) {
            if (c5886Lg2E.i() instanceof AbstractC15520jj2.h) {
                interfaceC16978mB2.e(Integer.valueOf((int) (this.b / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT)), Integer.valueOf(((AbstractC15520jj2.h) c5886Lg2E.i()).h()), Integer.valueOf(((int) C24480yh2.a.c().D0()) / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT), c5886Lg2E);
            } else {
                interfaceC14603iB2.invoke(Integer.valueOf((int) (this.b / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT)), c5886Lg2E);
            }
        }
        this.b = 0L;
    }
}
