package ir.nasim;

import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageEmojiTextView;

/* renamed from: ir.nasim.ff3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C13099ff3 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final LinearLayout b;
    public final MaterialButton c;
    public final MessageEmojiTextView d;
    public final MessageEmojiTextView e;
    public final MessageEmojiTextView f;
    public final RecyclerView g;
    public final Barrier h;

    private C13099ff3(ConstraintLayout constraintLayout, LinearLayout linearLayout, MaterialButton materialButton, MessageEmojiTextView messageEmojiTextView, MessageEmojiTextView messageEmojiTextView2, MessageEmojiTextView messageEmojiTextView3, RecyclerView recyclerView, Barrier barrier) {
        this.a = constraintLayout;
        this.b = linearLayout;
        this.c = materialButton;
        this.d = messageEmojiTextView;
        this.e = messageEmojiTextView2;
        this.f = messageEmojiTextView3;
        this.g = recyclerView;
        this.h = barrier;
    }

    public static C13099ff3 a(View view) {
        int i = BC5.answersLayout;
        LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
        if (linearLayout != null) {
            i = BC5.btnSubmit;
            MaterialButton materialButton = (MaterialButton) AbstractC11738dW7.a(view, i);
            if (materialButton != null) {
                i = BC5.seeResultsTextView;
                MessageEmojiTextView messageEmojiTextView = (MessageEmojiTextView) AbstractC11738dW7.a(view, i);
                if (messageEmojiTextView != null) {
                    i = BC5.textViewPollQuestion;
                    MessageEmojiTextView messageEmojiTextView2 = (MessageEmojiTextView) AbstractC11738dW7.a(view, i);
                    if (messageEmojiTextView2 != null) {
                        i = BC5.textViewPollType;
                        MessageEmojiTextView messageEmojiTextView3 = (MessageEmojiTextView) AbstractC11738dW7.a(view, i);
                        if (messageEmojiTextView3 != null) {
                            i = BC5.voterAvatarsRecycler;
                            RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
                            if (recyclerView != null) {
                                i = BC5.voterBarrier;
                                Barrier barrier = (Barrier) AbstractC11738dW7.a(view, i);
                                if (barrier != null) {
                                    return new C13099ff3((ConstraintLayout) view, linearLayout, materialButton, messageEmojiTextView, messageEmojiTextView2, messageEmojiTextView3, recyclerView, barrier);
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
