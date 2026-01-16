package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;

/* renamed from: ir.nasim.ef3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C12463ef3 implements InterfaceC9764aW7 {
    private final View a;
    public final View b;
    public final ImageView c;
    public final ImageView d;
    public final Group e;
    public final TextView f;

    private C12463ef3(View view, View view2, ImageView imageView, ImageView imageView2, Group group, TextView textView) {
        this.a = view;
        this.b = view2;
        this.c = imageView;
        this.d = imageView2;
        this.e = group;
        this.f = textView;
    }

    public static C12463ef3 a(View view) {
        int i = BC5.dividerPfm;
        View viewA = AbstractC11738dW7.a(view, i);
        if (viewA != null) {
            i = BC5.imageViewPfm;
            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
            if (imageView != null) {
                i = BC5.imageViewPfmArrow;
                ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                if (imageView2 != null) {
                    i = BC5.pfmGroupContainer;
                    Group group = (Group) AbstractC11738dW7.a(view, i);
                    if (group != null) {
                        i = BC5.textViewPfm;
                        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView != null) {
                            return new C12463ef3(view, viewA, imageView, imageView2, group, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C12463ef3 b(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(AbstractC12208eD5.item_chat_pfm_text_bubble, viewGroup);
        return a(viewGroup);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    public View getRoot() {
        return this.a;
    }
}
