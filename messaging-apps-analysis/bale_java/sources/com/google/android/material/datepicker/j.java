package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import ir.nasim.YJ4;
import java.util.LinkedHashSet;

/* loaded from: classes3.dex */
abstract class j extends Fragment {
    protected final LinkedHashSet W0 = new LinkedHashSet();

    j() {
    }

    boolean r8(YJ4 yj4) {
        return this.W0.add(yj4);
    }

    void s8() {
        this.W0.clear();
    }
}
