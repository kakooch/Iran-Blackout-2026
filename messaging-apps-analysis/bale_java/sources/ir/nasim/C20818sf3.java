package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.google.android.material.card.MaterialCardView;

/* renamed from: ir.nasim.sf3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C20818sf3 implements InterfaceC9764aW7 {
    private final MaterialCardView a;
    public final ImageView b;
    public final ImageButton c;

    private C20818sf3(MaterialCardView materialCardView, ImageView imageView, ImageButton imageButton) {
        this.a = materialCardView;
        this.b = imageView;
        this.c = imageButton;
    }

    public static C20818sf3 a(View view) {
        int i = BC5.image;
        ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
        if (imageView != null) {
            i = BC5.remove;
            ImageButton imageButton = (ImageButton) AbstractC11738dW7.a(view, i);
            if (imageButton != null) {
                return new C20818sf3((MaterialCardView) view, imageView, imageButton);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C20818sf3 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.item_imported_photo_rectangle, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public MaterialCardView getRoot() {
        return this.a;
    }
}
