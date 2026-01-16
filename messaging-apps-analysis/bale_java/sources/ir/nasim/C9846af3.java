package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import com.google.android.material.imageview.ShapeableImageView;
import ir.nasim.designsystem.avatar.AvatarViewGlide;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;

/* renamed from: ir.nasim.af3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C9846af3 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final ShapeableImageView b;
    public final ViewStub c;
    public final BubbleTextView d;
    public final ShapeableImageView e;
    public final Guideline f;
    public final BubbleTextView g;
    public final ShapeableImageView h;
    public final AvatarViewGlide i;

    private C9846af3(ConstraintLayout constraintLayout, ShapeableImageView shapeableImageView, ViewStub viewStub, BubbleTextView bubbleTextView, ShapeableImageView shapeableImageView2, Guideline guideline, BubbleTextView bubbleTextView2, ShapeableImageView shapeableImageView3, AvatarViewGlide avatarViewGlide) {
        this.a = constraintLayout;
        this.b = shapeableImageView;
        this.c = viewStub;
        this.d = bubbleTextView;
        this.e = shapeableImageView2;
        this.f = guideline;
        this.g = bubbleTextView2;
        this.h = shapeableImageView3;
        this.i = avatarViewGlide;
    }

    public static C9846af3 a(View view) {
        int i = BC5.add_to_story;
        ShapeableImageView shapeableImageView = (ShapeableImageView) AbstractC11738dW7.a(view, i);
        if (shapeableImageView != null) {
            i = BC5.bubbleStub;
            ViewStub viewStub = (ViewStub) AbstractC11738dW7.a(view, i);
            if (viewStub != null) {
                i = BC5.date_separator;
                BubbleTextView bubbleTextView = (BubbleTextView) AbstractC11738dW7.a(view, i);
                if (bubbleTextView != null) {
                    i = BC5.forward_image_view;
                    ShapeableImageView shapeableImageView2 = (ShapeableImageView) AbstractC11738dW7.a(view, i);
                    if (shapeableImageView2 != null) {
                        i = BC5.guideline;
                        Guideline guideline = (Guideline) AbstractC11738dW7.a(view, i);
                        if (guideline != null) {
                            i = BC5.new_message_separator;
                            BubbleTextView bubbleTextView2 = (BubbleTextView) AbstractC11738dW7.a(view, i);
                            if (bubbleTextView2 != null) {
                                i = BC5.up_vote_image_view;
                                ShapeableImageView shapeableImageView3 = (ShapeableImageView) AbstractC11738dW7.a(view, i);
                                if (shapeableImageView3 != null) {
                                    i = BC5.user_avatar;
                                    AvatarViewGlide avatarViewGlide = (AvatarViewGlide) AbstractC11738dW7.a(view, i);
                                    if (avatarViewGlide != null) {
                                        return new C9846af3((ConstraintLayout) view, shapeableImageView, viewStub, bubbleTextView, shapeableImageView2, guideline, bubbleTextView2, shapeableImageView3, avatarViewGlide);
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

    public static C9846af3 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.item_chat_incoming_message, viewGroup, false);
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
