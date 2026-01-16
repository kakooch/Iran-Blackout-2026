package ir.nasim;

import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButton;
import ir.nasim.designsystem.avatar.AvatarViewGlide;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageEmojiTextView;

/* renamed from: ir.nasim.Ue3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8020Ue3 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final MaterialButton b;
    public final MaterialButton c;
    public final MaterialButton d;
    public final AvatarViewGlide e;
    public final LinearLayout f;
    public final BubbleTextView g;
    public final MessageEmojiTextView h;

    private C8020Ue3(ConstraintLayout constraintLayout, MaterialButton materialButton, MaterialButton materialButton2, MaterialButton materialButton3, AvatarViewGlide avatarViewGlide, LinearLayout linearLayout, BubbleTextView bubbleTextView, MessageEmojiTextView messageEmojiTextView) {
        this.a = constraintLayout;
        this.b = materialButton;
        this.c = materialButton2;
        this.d = materialButton3;
        this.e = avatarViewGlide;
        this.f = linearLayout;
        this.g = bubbleTextView;
        this.h = messageEmojiTextView;
    }

    public static C8020Ue3 a(View view) {
        int i = BC5.btn_add_send_message;
        MaterialButton materialButton = (MaterialButton) AbstractC11738dW7.a(view, i);
        if (materialButton != null) {
            i = BC5.btn_add_to_contact;
            MaterialButton materialButton2 = (MaterialButton) AbstractC11738dW7.a(view, i);
            if (materialButton2 != null) {
                i = BC5.btn_see_profile;
                MaterialButton materialButton3 = (MaterialButton) AbstractC11738dW7.a(view, i);
                if (materialButton3 != null) {
                    i = BC5.imageview_avatar;
                    AvatarViewGlide avatarViewGlide = (AvatarViewGlide) AbstractC11738dW7.a(view, i);
                    if (avatarViewGlide != null) {
                        i = BC5.notContactButtons;
                        LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
                        if (linearLayout != null) {
                            i = BC5.textview_info;
                            BubbleTextView bubbleTextView = (BubbleTextView) AbstractC11738dW7.a(view, i);
                            if (bubbleTextView != null) {
                                i = BC5.textview_name;
                                MessageEmojiTextView messageEmojiTextView = (MessageEmojiTextView) AbstractC11738dW7.a(view, i);
                                if (messageEmojiTextView != null) {
                                    return new C8020Ue3((ConstraintLayout) view, materialButton, materialButton2, materialButton3, avatarViewGlide, linearLayout, bubbleTextView, messageEmojiTextView);
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
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
