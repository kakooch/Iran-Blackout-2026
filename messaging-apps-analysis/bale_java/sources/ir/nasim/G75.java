package ir.nasim;

import android.view.View;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes5.dex */
public final class G75 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final Flow b;

    private G75(ConstraintLayout constraintLayout, Flow flow) {
        this.a = constraintLayout;
        this.b = flow;
    }

    public static G75 a(View view) {
        int i = BC5.flow;
        Flow flow = (Flow) AbstractC11738dW7.a(view, i);
        if (flow != null) {
            return new G75((ConstraintLayout) view, flow);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
