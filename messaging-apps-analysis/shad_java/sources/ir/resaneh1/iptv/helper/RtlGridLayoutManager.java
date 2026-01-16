package ir.resaneh1.iptv.helper;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;

/* loaded from: classes3.dex */
public class RtlGridLayoutManager extends GridLayoutManager {
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    protected boolean isLayoutRTL() {
        return true;
    }

    public RtlGridLayoutManager(Context context, int i) {
        super(context, i);
    }
}
