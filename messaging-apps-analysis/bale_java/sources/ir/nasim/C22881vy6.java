package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.cardview.widget.CardView;
import ir.nasim.sharedmedia.ui.SquareImageView;

/* renamed from: ir.nasim.vy6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C22881vy6 implements InterfaceC9764aW7 {
    private final CardView a;
    public final AppCompatCheckBox b;
    public final ImageView c;
    public final CardView d;
    public final SquareImageView e;
    public final TextView f;

    private C22881vy6(CardView cardView, AppCompatCheckBox appCompatCheckBox, ImageView imageView, CardView cardView2, SquareImageView squareImageView, TextView textView) {
        this.a = cardView;
        this.b = appCompatCheckBox;
        this.c = imageView;
        this.d = cardView2;
        this.e = squareImageView;
        this.f = textView;
    }

    public static C22881vy6 a(View view) {
        int i = AbstractC17581nC5.chb_selected;
        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) AbstractC11738dW7.a(view, i);
        if (appCompatCheckBox != null) {
            i = AbstractC17581nC5.img_downloadState;
            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
            if (imageView != null) {
                i = AbstractC17581nC5.img_downloadState_container;
                CardView cardView = (CardView) AbstractC11738dW7.a(view, i);
                if (cardView != null) {
                    i = AbstractC17581nC5.img_main_pic;
                    SquareImageView squareImageView = (SquareImageView) AbstractC11738dW7.a(view, i);
                    if (squareImageView != null) {
                        i = AbstractC17581nC5.txt_size;
                        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView != null) {
                            return new C22881vy6((CardView) view, appCompatCheckBox, imageView, cardView, squareImageView, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C22881vy6 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(QC5.shared_media_photo_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public CardView getRoot() {
        return this.a;
    }
}
