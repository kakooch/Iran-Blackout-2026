package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.features.pfm.tags.PFMTag;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public abstract class KQ4 extends RecyclerView.C {
    private Map u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KQ4(View view) {
        super(view);
        AbstractC13042fc3.i(view, "itemView");
        this.u = new LinkedHashMap();
    }

    public void C0(PFMTag pFMTag, boolean z, Long l) {
        AbstractC13042fc3.i(pFMTag, ParameterNames.TAG);
    }

    public final Map D0() {
        return this.u;
    }

    public final void E0(Map map) {
        this.u = map;
    }
}
