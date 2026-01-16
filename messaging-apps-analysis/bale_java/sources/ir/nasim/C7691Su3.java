package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.progressindicator.CircularProgressIndicator;

/* renamed from: ir.nasim.Su3, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C7691Su3 implements InterfaceC9764aW7 {
    private final View a;
    public final AppCompatTextView b;
    public final CircularProgressIndicator c;

    private C7691Su3(View view, AppCompatTextView appCompatTextView, CircularProgressIndicator circularProgressIndicator) {
        this.a = view;
        this.b = appCompatTextView;
        this.c = circularProgressIndicator;
    }

    public static C7691Su3 a(View view) {
        int i = AbstractC18172oC5.noticeText;
        AppCompatTextView appCompatTextView = (AppCompatTextView) AbstractC11738dW7.a(view, i);
        if (appCompatTextView != null) {
            i = AbstractC18172oC5.progressBar;
            CircularProgressIndicator circularProgressIndicator = (CircularProgressIndicator) AbstractC11738dW7.a(view, i);
            if (circularProgressIndicator != null) {
                return new C7691Su3(view, appCompatTextView, circularProgressIndicator);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C7691Su3 b(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(RC5.layout_uploading_story, viewGroup);
        return a(viewGroup);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    public View getRoot() {
        return this.a;
    }
}
