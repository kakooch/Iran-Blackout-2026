package ir.nasim;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.card.MaterialCardView;
import ir.nasim.components.appbar.view.BaleToolbar;

/* renamed from: ir.nasim.Hz2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C5121Hz2 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final RecyclerView b;
    public final LinearLayout c;
    public final ImageView d;
    public final TextView e;
    public final ProgressBar f;
    public final AppBarLayout g;
    public final MaterialCardView h;
    public final ImageView i;
    public final EditText j;
    public final BaleToolbar k;

    private C5121Hz2(LinearLayout linearLayout, RecyclerView recyclerView, LinearLayout linearLayout2, ImageView imageView, TextView textView, ProgressBar progressBar, AppBarLayout appBarLayout, MaterialCardView materialCardView, ImageView imageView2, EditText editText, BaleToolbar baleToolbar) {
        this.a = linearLayout;
        this.b = recyclerView;
        this.c = linearLayout2;
        this.d = imageView;
        this.e = textView;
        this.f = progressBar;
        this.g = appBarLayout;
        this.h = materialCardView;
        this.i = imageView2;
        this.j = editText;
        this.k = baleToolbar;
    }

    public static C5121Hz2 a(View view) {
        int i = AbstractC17581nC5.contacts;
        RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
        if (recyclerView != null) {
            i = AbstractC17581nC5.emptyState_container;
            LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
            if (linearLayout != null) {
                i = AbstractC17581nC5.emptyState_img;
                ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                if (imageView != null) {
                    i = AbstractC17581nC5.empty_txt;
                    TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView != null) {
                        i = AbstractC17581nC5.progressbar;
                        ProgressBar progressBar = (ProgressBar) AbstractC11738dW7.a(view, i);
                        if (progressBar != null) {
                            i = AbstractC17581nC5.report_error_appbar;
                            AppBarLayout appBarLayout = (AppBarLayout) AbstractC11738dW7.a(view, i);
                            if (appBarLayout != null) {
                                i = AbstractC17581nC5.search_container;
                                MaterialCardView materialCardView = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                if (materialCardView != null) {
                                    i = AbstractC17581nC5.search_img;
                                    ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                                    if (imageView2 != null) {
                                        i = AbstractC17581nC5.search_txt;
                                        EditText editText = (EditText) AbstractC11738dW7.a(view, i);
                                        if (editText != null) {
                                            i = AbstractC17581nC5.transferring_owner_toolbar;
                                            BaleToolbar baleToolbar = (BaleToolbar) AbstractC11738dW7.a(view, i);
                                            if (baleToolbar != null) {
                                                return new C5121Hz2((LinearLayout) view, recyclerView, linearLayout, imageView, textView, progressBar, appBarLayout, materialCardView, imageView2, editText, baleToolbar);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
