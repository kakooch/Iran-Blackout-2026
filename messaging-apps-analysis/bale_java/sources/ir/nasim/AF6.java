package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.features.smiles.panel.SmileKeyboardContainer;

/* loaded from: classes5.dex */
public final class AF6 implements InterfaceC9764aW7 {
    private final SmileKeyboardContainer a;
    public final AppCompatImageView b;
    public final ConstraintLayout c;
    public final EditText d;
    public final LinearLayout e;
    public final ConstraintLayout f;
    public final AppCompatImageView g;
    public final AppCompatImageView h;
    public final LinearLayout i;
    public final ImageView j;
    public final ImageView k;
    public final ImageView l;

    private AF6(SmileKeyboardContainer smileKeyboardContainer, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout, EditText editText, LinearLayout linearLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, LinearLayout linearLayout2, ImageView imageView, ImageView imageView2, ImageView imageView3) {
        this.a = smileKeyboardContainer;
        this.b = appCompatImageView;
        this.c = constraintLayout;
        this.d = editText;
        this.e = linearLayout;
        this.f = constraintLayout2;
        this.g = appCompatImageView2;
        this.h = appCompatImageView3;
        this.i = linearLayout2;
        this.j = imageView;
        this.k = imageView2;
        this.l = imageView3;
    }

    public static AF6 a(View view) {
        int i = BC5.avatarPaint;
        AppCompatImageView appCompatImageView = (AppCompatImageView) AbstractC11738dW7.a(view, i);
        if (appCompatImageView != null) {
            i = BC5.avatarSelectLayout;
            ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
            if (constraintLayout != null) {
                i = BC5.captionEditText;
                EditText editText = (EditText) AbstractC11738dW7.a(view, i);
                if (editText != null) {
                    i = BC5.editTextLayout;
                    LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
                    if (linearLayout != null) {
                        i = BC5.inputBarLayout;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                        if (constraintLayout2 != null) {
                            i = BC5.itemCrop;
                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                            if (appCompatImageView2 != null) {
                                i = BC5.itemPaint;
                                AppCompatImageView appCompatImageView3 = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                                if (appCompatImageView3 != null) {
                                    i = BC5.itemsContainer;
                                    LinearLayout linearLayout2 = (LinearLayout) AbstractC11738dW7.a(view, i);
                                    if (linearLayout2 != null) {
                                        i = BC5.keyboardModeImageView;
                                        ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                                        if (imageView != null) {
                                            i = BC5.sendImageView;
                                            ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                                            if (imageView2 != null) {
                                                i = BC5.setAvatarView;
                                                ImageView imageView3 = (ImageView) AbstractC11738dW7.a(view, i);
                                                if (imageView3 != null) {
                                                    return new AF6((SmileKeyboardContainer) view, appCompatImageView, constraintLayout, editText, linearLayout, constraintLayout2, appCompatImageView2, appCompatImageView3, linearLayout2, imageView, imageView2, imageView3);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static AF6 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static AF6 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.smile_keyboard_panel, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public SmileKeyboardContainer getRoot() {
        return this.a;
    }
}
