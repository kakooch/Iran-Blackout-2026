package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.textview.MaterialTextView;

/* renamed from: ir.nasim.mH1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C17031mH1 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final CheckBox b;
    public final ConstraintLayout c;
    public final MaterialTextView d;

    private C17031mH1(ConstraintLayout constraintLayout, CheckBox checkBox, ConstraintLayout constraintLayout2, MaterialTextView materialTextView) {
        this.a = constraintLayout;
        this.b = checkBox;
        this.c = constraintLayout2;
        this.d = materialTextView;
    }

    public static C17031mH1 a(View view) {
        int i = YB5.check;
        CheckBox checkBox = (CheckBox) AbstractC11738dW7.a(view, i);
        if (checkBox != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            int i2 = YB5.title;
            MaterialTextView materialTextView = (MaterialTextView) AbstractC11738dW7.a(view, i2);
            if (materialTextView != null) {
                return new C17031mH1(constraintLayout, checkBox, constraintLayout, materialTextView);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C17031mH1 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC9591aD5.delete_all_separator_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
