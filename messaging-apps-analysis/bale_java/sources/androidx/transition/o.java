package androidx.transition;

import android.view.ViewGroup;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.TB5;

/* loaded from: classes2.dex */
public abstract class o {
    public static o a(ViewGroup viewGroup) {
        AbstractC18350oW3.a(viewGroup.getTag(TB5.transition_current_scene));
        return null;
    }

    static void b(ViewGroup viewGroup, o oVar) {
        viewGroup.setTag(TB5.transition_current_scene, oVar);
    }
}
