package ir.nasim.story.ui.viewfragment.views;

import android.animation.LayoutTransition;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatEditText;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.C19938rB7;
import ir.nasim.C5779Ku3;
import ir.nasim.ED1;
import ir.nasim.InterfaceC12925fP5;
import ir.nasim.story.ui.viewfragment.views.ReplyStoryView;
import ir.nasim.story.ui.viewfragment.views.a;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0016\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\n¢\u0006\u0004\b\u0018\u0010\fJ\u0015\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cR$\u0010$\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006)"}, d2 = {"Lir/nasim/story/ui/viewfragment/views/ReplyStoryView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/rB7;", "g", "()V", "n", "k", "Landroid/animation/LayoutTransition;", "getLayoutTransition", "()Landroid/animation/LayoutTransition;", "", "showReply", "", "replyText", "j", "(ZLjava/lang/String;)Lir/nasim/rB7;", "f", "Lir/nasim/story/ui/viewfragment/views/a;", "reactionButtonState", "setReaction", "(Lir/nasim/story/ui/viewfragment/views/a;)V", "Lir/nasim/fP5;", "a", "Lir/nasim/fP5;", "getListener", "()Lir/nasim/fP5;", "setListener", "(Lir/nasim/fP5;)V", "listener", "Lir/nasim/Ku3;", "b", "Lir/nasim/Ku3;", "binding", "story_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes7.dex */
public final class ReplyStoryView extends LinearLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private InterfaceC12925fP5 listener;

    /* renamed from: b, reason: from kotlin metadata */
    private final C5779Ku3 binding;

    public static final class a implements TextWatcher {
        final /* synthetic */ C5779Ku3 b;

        public a(C5779Ku3 c5779Ku3) {
            this.b = c5779Ku3;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (charSequence == null || AbstractC20762sZ6.n0(charSequence)) {
                ReplyStoryView.this.binding.f.setVisibility(0);
                this.b.e.setVisibility(8);
            } else {
                ReplyStoryView.this.binding.f.setVisibility(8);
                this.b.e.setVisibility(0);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ReplyStoryView(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    private final void g() {
        ReactionButton reactionButton = this.binding.f;
        reactionButton.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.bP5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReplyStoryView.h(this.a, view);
            }
        });
        reactionButton.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.nasim.cP5
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return ReplyStoryView.i(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(ReplyStoryView replyStoryView, View view) {
        AbstractC13042fc3.i(replyStoryView, "this$0");
        replyStoryView.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean i(ReplyStoryView replyStoryView, View view) {
        AbstractC13042fc3.i(replyStoryView, "this$0");
        InterfaceC12925fP5 interfaceC12925fP5 = replyStoryView.listener;
        if (interfaceC12925fP5 != null) {
            return interfaceC12925fP5.a();
        }
        return false;
    }

    private final void k() {
        final C5779Ku3 c5779Ku3 = this.binding;
        AppCompatEditText appCompatEditText = c5779Ku3.c;
        AbstractC13042fc3.h(appCompatEditText, "etReplyStory");
        appCompatEditText.addTextChangedListener(new a(c5779Ku3));
        c5779Ku3.c.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.dP5
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                ReplyStoryView.l(this.a, view, z);
            }
        });
        c5779Ku3.e.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.eP5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReplyStoryView.m(this.a, c5779Ku3, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(ReplyStoryView replyStoryView, View view, boolean z) {
        AbstractC13042fc3.i(replyStoryView, "this$0");
        InterfaceC12925fP5 interfaceC12925fP5 = replyStoryView.listener;
        if (interfaceC12925fP5 != null) {
            interfaceC12925fP5.c(!z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(ReplyStoryView replyStoryView, C5779Ku3 c5779Ku3, View view) {
        AbstractC13042fc3.i(replyStoryView, "this$0");
        AbstractC13042fc3.i(c5779Ku3, "$this_with");
        InterfaceC12925fP5 interfaceC12925fP5 = replyStoryView.listener;
        if (interfaceC12925fP5 != null) {
            interfaceC12925fP5.d(String.valueOf(c5779Ku3.c.getText()));
        }
    }

    private final void n() {
        ir.nasim.story.ui.viewfragment.views.a state = this.binding.f.getState();
        if ((state instanceof a.C1549a) || (state instanceof a.b)) {
            this.binding.f.setState(new a.c(false, 1, null));
        } else {
            if (!(state instanceof a.c)) {
                throw new NoWhenBranchMatchedException();
            }
            this.binding.f.setState(new a.C1549a(false, 1, null));
        }
        C19938rB7 c19938rB7 = C19938rB7.a;
        InterfaceC12925fP5 interfaceC12925fP5 = this.listener;
        if (interfaceC12925fP5 != null) {
            interfaceC12925fP5.b(this.binding.f.getState());
        }
    }

    public final void f() {
        this.binding.c.setText("");
    }

    @Override // android.view.ViewGroup
    public LayoutTransition getLayoutTransition() {
        return new LayoutTransition();
    }

    public final InterfaceC12925fP5 getListener() {
        return this.listener;
    }

    public final C19938rB7 j(boolean showReply, String replyText) {
        C5779Ku3 c5779Ku3 = this.binding;
        c5779Ku3.b.setVisibility(showReply ? 0 : 4);
        if (replyText == null) {
            return null;
        }
        c5779Ku3.c.setText(replyText);
        return C19938rB7.a;
    }

    public final void setListener(InterfaceC12925fP5 interfaceC12925fP5) {
        this.listener = interfaceC12925fP5;
    }

    public final void setReaction(ir.nasim.story.ui.viewfragment.views.a reactionButtonState) {
        AbstractC13042fc3.i(reactionButtonState, "reactionButtonState");
        this.binding.f.setState(reactionButtonState);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ReplyStoryView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ ReplyStoryView(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReplyStoryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        this.binding = C5779Ku3.b(LayoutInflater.from(context), this);
        setGravity(17);
        g();
        k();
    }
}
