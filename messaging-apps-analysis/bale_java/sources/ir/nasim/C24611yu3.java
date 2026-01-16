package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

/* renamed from: ir.nasim.yu3, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C24611yu3 implements InterfaceC9764aW7 {
    private final View a;
    public final MaterialButton b;
    public final LinearLayoutCompat c;
    public final View d;
    public final AppCompatImageView e;
    public final AppCompatImageView f;
    public final MaterialTextView g;
    public final AppCompatTextView h;

    private C24611yu3(View view, MaterialButton materialButton, LinearLayoutCompat linearLayoutCompat, View view2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, MaterialTextView materialTextView, AppCompatTextView appCompatTextView) {
        this.a = view;
        this.b = materialButton;
        this.c = linearLayoutCompat;
        this.d = view2;
        this.e = appCompatImageView;
        this.f = appCompatImageView2;
        this.g = materialTextView;
        this.h = appCompatTextView;
    }

    public static C24611yu3 a(View view) {
        View viewA;
        int i = AbstractC18172oC5.btnAddStory;
        MaterialButton materialButton = (MaterialButton) AbstractC11738dW7.a(view, i);
        if (materialButton != null) {
            i = AbstractC18172oC5.container;
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) AbstractC11738dW7.a(view, i);
            if (linearLayoutCompat != null && (viewA = AbstractC11738dW7.a(view, (i = AbstractC18172oC5.divider))) != null) {
                i = AbstractC18172oC5.ivReactionCount;
                AppCompatImageView appCompatImageView = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                if (appCompatImageView != null) {
                    i = AbstractC18172oC5.ivViewerCount;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                    if (appCompatImageView2 != null) {
                        i = AbstractC18172oC5.tvReactionCount;
                        MaterialTextView materialTextView = (MaterialTextView) AbstractC11738dW7.a(view, i);
                        if (materialTextView != null) {
                            i = AbstractC18172oC5.tvViewerCount;
                            AppCompatTextView appCompatTextView = (AppCompatTextView) AbstractC11738dW7.a(view, i);
                            if (appCompatTextView != null) {
                                return new C24611yu3(view, materialButton, linearLayoutCompat, viewA, appCompatImageView, appCompatImageView2, materialTextView, appCompatTextView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C24611yu3 b(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(RC5.layout_my_story_status, viewGroup);
        return a(viewGroup);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    public View getRoot() {
        return this.a;
    }
}
