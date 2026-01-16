package ir.nasim;

import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.FragmentContainerView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;

/* renamed from: ir.nasim.Ly2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C6047Ly2 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final AppBarLayout b;
    public final AppCompatImageButton c;
    public final FragmentContainerView d;
    public final ImageView e;
    public final FrameLayout f;
    public final RecyclerView g;
    public final EditText h;

    private C6047Ly2(LinearLayout linearLayout, AppBarLayout appBarLayout, AppCompatImageButton appCompatImageButton, FragmentContainerView fragmentContainerView, ImageView imageView, FrameLayout frameLayout, RecyclerView recyclerView, EditText editText) {
        this.a = linearLayout;
        this.b = appBarLayout;
        this.c = appCompatImageButton;
        this.d = fragmentContainerView;
        this.e = imageView;
        this.f = frameLayout;
        this.g = recyclerView;
        this.h = editText;
    }

    public static C6047Ly2 a(View view) {
        int i = AbstractC12808fC5.appbar;
        AppBarLayout appBarLayout = (AppBarLayout) AbstractC11738dW7.a(view, i);
        if (appBarLayout != null) {
            i = AbstractC12808fC5.back_input_search;
            AppCompatImageButton appCompatImageButton = (AppCompatImageButton) AbstractC11738dW7.a(view, i);
            if (appCompatImageButton != null) {
                i = AbstractC12808fC5.channel_suggestion_container;
                FragmentContainerView fragmentContainerView = (FragmentContainerView) AbstractC11738dW7.a(view, i);
                if (fragmentContainerView != null) {
                    i = AbstractC12808fC5.close_input_search;
                    ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                    if (imageView != null) {
                        i = AbstractC12808fC5.main_container;
                        FrameLayout frameLayout = (FrameLayout) AbstractC11738dW7.a(view, i);
                        if (frameLayout != null) {
                            i = AbstractC12808fC5.search_suggestion;
                            RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
                            if (recyclerView != null) {
                                i = AbstractC12808fC5.search_text_input;
                                EditText editText = (EditText) AbstractC11738dW7.a(view, i);
                                if (editText != null) {
                                    return new C6047Ly2((LinearLayout) view, appBarLayout, appCompatImageButton, fragmentContainerView, imageView, frameLayout, recyclerView, editText);
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
