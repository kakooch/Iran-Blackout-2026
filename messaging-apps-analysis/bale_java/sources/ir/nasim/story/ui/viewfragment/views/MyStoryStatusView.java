package ir.nasim.story.ui.viewfragment.views;

import android.animation.LayoutTransition;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC23035wE5;
import ir.nasim.AbstractC3742Cd6;
import ir.nasim.C16731lm1;
import ir.nasim.C24611yu3;
import ir.nasim.C6011Lu2;
import ir.nasim.ED1;
import ir.nasim.InterfaceC5024Ho4;
import ir.nasim.XY6;
import ir.nasim.story.ui.viewfragment.views.MyStoryStatusView;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0010R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lir/nasim/story/ui/viewfragment/views/MyStoryStatusView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/rB7;", "h0", "()V", "f0", "count", "setViewCount", "(I)V", "setReactionCount", "Lir/nasim/Ho4;", "y", "Lir/nasim/Ho4;", "getListener", "()Lir/nasim/Ho4;", "setListener", "(Lir/nasim/Ho4;)V", "listener", "Lir/nasim/yu3;", "z", "Lir/nasim/yu3;", "binding", "story_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes7.dex */
public final class MyStoryStatusView extends ConstraintLayout {

    /* renamed from: y, reason: from kotlin metadata */
    private InterfaceC5024Ho4 listener;

    /* renamed from: z, reason: from kotlin metadata */
    private final C24611yu3 binding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MyStoryStatusView(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    private final void f0() {
        this.binding.b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Fo4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyStoryStatusView.g0(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(MyStoryStatusView myStoryStatusView, View view) {
        AbstractC13042fc3.i(myStoryStatusView, "this$0");
        InterfaceC5024Ho4 interfaceC5024Ho4 = myStoryStatusView.listener;
        if (interfaceC5024Ho4 != null) {
            interfaceC5024Ho4.r();
        }
    }

    private final void h0() {
        this.binding.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Go4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyStoryStatusView.i0(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(MyStoryStatusView myStoryStatusView, View view) {
        AbstractC13042fc3.i(myStoryStatusView, "this$0");
        InterfaceC5024Ho4 interfaceC5024Ho4 = myStoryStatusView.listener;
        if (interfaceC5024Ho4 != null) {
            interfaceC5024Ho4.s();
        }
    }

    public final InterfaceC5024Ho4 getListener() {
        return this.listener;
    }

    public final void setListener(InterfaceC5024Ho4 interfaceC5024Ho4) {
        this.listener = interfaceC5024Ho4;
    }

    public final void setReactionCount(int count) {
        if (count <= 0) {
            this.binding.d.setVisibility(8);
            this.binding.g.setVisibility(8);
            this.binding.e.setVisibility(8);
        } else {
            this.binding.d.setVisibility(0);
            this.binding.g.setVisibility(0);
            this.binding.e.setVisibility(0);
            this.binding.g.setText(XY6.e(XY6.i(count)));
        }
    }

    public final void setViewCount(int count) {
        this.binding.h.setText(XY6.e(XY6.i(count)));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MyStoryStatusView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ MyStoryStatusView(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyStoryStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        C24611yu3 c24611yu3B = C24611yu3.b(LayoutInflater.from(new C16731lm1(context, AbstractC23035wE5.Theme_Bale_Base)), this);
        double d = 12;
        setPadding((int) ((AbstractC3742Cd6.c() * d) + 0.5d), 0, (int) ((d * AbstractC3742Cd6.c()) + 0.5d), 0);
        setLayoutTransition(new LayoutTransition());
        c24611yu3B.b.setTypeface(C6011Lu2.i());
        this.binding = c24611yu3B;
        h0();
        f0();
    }
}
