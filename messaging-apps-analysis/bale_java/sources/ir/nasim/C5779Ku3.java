package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import ir.nasim.story.ui.viewfragment.views.ReactionButton;

/* renamed from: ir.nasim.Ku3, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C5779Ku3 implements InterfaceC9764aW7 {
    private final View a;
    public final LinearLayout b;
    public final AppCompatEditText c;
    public final AppCompatImageView d;
    public final AppCompatImageView e;
    public final ReactionButton f;

    private C5779Ku3(View view, LinearLayout linearLayout, AppCompatEditText appCompatEditText, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, ReactionButton reactionButton) {
        this.a = view;
        this.b = linearLayout;
        this.c = appCompatEditText;
        this.d = appCompatImageView;
        this.e = appCompatImageView2;
        this.f = reactionButton;
    }

    public static C5779Ku3 a(View view) {
        int i = AbstractC18172oC5.containerReply;
        LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
        if (linearLayout != null) {
            i = AbstractC18172oC5.etReplyStory;
            AppCompatEditText appCompatEditText = (AppCompatEditText) AbstractC11738dW7.a(view, i);
            if (appCompatEditText != null) {
                i = AbstractC18172oC5.ivEmojiReplyStory;
                AppCompatImageView appCompatImageView = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                if (appCompatImageView != null) {
                    i = AbstractC18172oC5.ivSendReplyStory;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                    if (appCompatImageView2 != null) {
                        i = AbstractC18172oC5.reactionBtn;
                        ReactionButton reactionButton = (ReactionButton) AbstractC11738dW7.a(view, i);
                        if (reactionButton != null) {
                            return new C5779Ku3(view, linearLayout, appCompatEditText, appCompatImageView, appCompatImageView2, reactionButton);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C5779Ku3 b(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(RC5.layout_reply_story, viewGroup);
        return a(viewGroup);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    public View getRoot() {
        return this.a;
    }
}
