package ir.nasim.tgwidgets.editor.ui.stories.bale.views;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC23598xB5;
import ir.nasim.AbstractC24188yB5;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC8081Ul1;
import ir.nasim.C19938rB7;
import ir.nasim.C5161Id6;
import ir.nasim.C6745Ou3;
import ir.nasim.ED1;
import ir.nasim.GY;
import ir.nasim.InterfaceC18899pR6;
import ir.nasim.InterfaceC19490qR6;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.JF5;
import ir.nasim.RS4;
import ir.nasim.SA2;
import ir.nasim.TD5;
import ir.nasim.tgwidgets.editor.ui.stories.bale.views.StoryLinkCustomView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u0000 @2\u00020\u0001:\u0001#B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\n¢\u0006\u0004\b\u0018\u0010\u000eJ\u0015\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010!\u001a\u00020\f2\u0006\u0010 \u001a\u00020\n¢\u0006\u0004\b!\u0010\u000eR\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001b\u00102\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001b\u00106\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010/\u001a\u0004\b4\u00105R\u0018\u00109\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010?\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>¨\u0006A"}, d2 = {"Lir/nasim/tgwidgets/editor/ui/stories/bale/views/StoryLinkCustomView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "isSelect", "Lir/nasim/rB7;", "o", "(Z)V", "Landroid/view/View$OnClickListener;", "l", "setOnClickListener", "(Landroid/view/View$OnClickListener;)V", "Lir/nasim/qR6;", "storyLinkEditor", "p", "(Lir/nasim/qR6;)V", "editable", "setEditable", "Lir/nasim/pR6;", "storyLinkCustomViewActions", "setListener", "(Lir/nasim/pR6;)V", "visibility", "setVisibility", "(I)V", "isVisible", "setProgressBarVisibility", "Lir/nasim/Ou3;", "a", "Lir/nasim/Ou3;", "binding", "b", "Lir/nasim/qR6;", "currentEntry", "Lir/nasim/Ul1$b;", "c", "Lir/nasim/Ul1$b;", "itemBuilder", "Lir/nasim/GY;", "d", "Lir/nasim/Yu3;", "getContextMenu", "()Lir/nasim/GY;", "contextMenu", "e", "getYOffset", "()I", "yOffset", "f", "Landroid/view/View$OnClickListener;", "onClickListener", "g", "Z", "isEditable", "h", "Lir/nasim/pR6;", "listener", "i", "tgwidgets_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes7.dex */
public final class StoryLinkCustomView extends FrameLayout {

    /* renamed from: i, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int j = 8;
    private static final int k = C5161Id6.e(62.0f);

    /* renamed from: a, reason: from kotlin metadata */
    private final C6745Ou3 binding;

    /* renamed from: b, reason: from kotlin metadata */
    private InterfaceC19490qR6 currentEntry;

    /* renamed from: c, reason: from kotlin metadata */
    private final AbstractC8081Ul1.b itemBuilder;

    /* renamed from: d, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 contextMenu;

    /* renamed from: e, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 yOffset;

    /* renamed from: f, reason: from kotlin metadata */
    private View.OnClickListener onClickListener;

    /* renamed from: g, reason: from kotlin metadata */
    private boolean isEditable;

    /* renamed from: h, reason: from kotlin metadata */
    private InterfaceC18899pR6 listener;

    /* renamed from: ir.nasim.tgwidgets.editor.ui.stories.bale.views.StoryLinkCustomView$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final int a() {
            return StoryLinkCustomView.k;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StoryLinkCustomView(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    private final GY getContextMenu() {
        return (GY) this.contextMenu.getValue();
    }

    private final int getYOffset() {
        return ((Number) this.yOffset.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GY i(final StoryLinkCustomView storyLinkCustomView) {
        AbstractC13042fc3.i(storyLinkCustomView, "this$0");
        View rootView = storyLinkCustomView.getRootView();
        AbstractC13042fc3.g(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
        return new GY.a(storyLinkCustomView, (ViewGroup) rootView, null, 4, null).d(true).g(new RS4(4.0f, 4.0f, 4.0f, 4.0f)).e(new Runnable() { // from class: ir.nasim.oR6
            @Override // java.lang.Runnable
            public final void run() {
                StoryLinkCustomView.j(this.a);
            }
        }).f(true).h(new Point(0, -4)).b(storyLinkCustomView.itemBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(StoryLinkCustomView storyLinkCustomView) {
        AbstractC13042fc3.i(storyLinkCustomView, "this$0");
        storyLinkCustomView.binding.getRoot().setSelected(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k(StoryLinkCustomView storyLinkCustomView) {
        AbstractC13042fc3.i(storyLinkCustomView, "this$0");
        InterfaceC18899pR6 interfaceC18899pR6 = storyLinkCustomView.listener;
        if (interfaceC18899pR6 != null) {
            interfaceC18899pR6.remove();
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(StoryLinkCustomView storyLinkCustomView) {
        AbstractC13042fc3.i(storyLinkCustomView, "this$0");
        InterfaceC18899pR6 interfaceC18899pR6 = storyLinkCustomView.listener;
        if (interfaceC18899pR6 != null) {
            interfaceC18899pR6.edit();
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m(StoryLinkCustomView storyLinkCustomView) {
        AbstractC13042fc3.i(storyLinkCustomView, "this$0");
        InterfaceC18899pR6 interfaceC18899pR6 = storyLinkCustomView.listener;
        if (interfaceC18899pR6 != null) {
            interfaceC18899pR6.a();
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(StoryLinkCustomView storyLinkCustomView, FrameLayout frameLayout, View view) {
        AbstractC13042fc3.i(storyLinkCustomView, "this$0");
        AbstractC13042fc3.i(frameLayout, "$this_apply");
        View.OnClickListener onClickListener = storyLinkCustomView.onClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        if (storyLinkCustomView.isEditable) {
            frameLayout.setSelected(!frameLayout.isSelected());
            storyLinkCustomView.o(frameLayout.isSelected());
        }
    }

    private final void o(boolean isSelect) {
        if (isSelect) {
            getContextMenu().showAtLocation(this, 49, 0, getYOffset());
        } else {
            getContextMenu().dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int q(StoryLinkCustomView storyLinkCustomView) {
        AbstractC13042fc3.i(storyLinkCustomView, "this$0");
        int[] iArr = new int[2];
        storyLinkCustomView.getLocationInWindow(iArr);
        return iArr[1] - C5161Id6.e(176.0f);
    }

    public final void p(InterfaceC19490qR6 storyLinkEditor) {
        AbstractC13042fc3.i(storyLinkEditor, "storyLinkEditor");
        C6745Ou3 c6745Ou3 = this.binding;
        if (AbstractC13042fc3.d(storyLinkEditor, this.currentEntry)) {
            return;
        }
        this.currentEntry = storyLinkEditor;
        if (AbstractC13042fc3.d(storyLinkEditor, InterfaceC19490qR6.a.a)) {
            setVisibility(8);
            return;
        }
        if (!(storyLinkEditor instanceof InterfaceC19490qR6.b)) {
            throw new NoWhenBranchMatchedException();
        }
        String strA = storyLinkEditor.a();
        boolean zJ = JF5.j(strA);
        c6745Ou3.c.setText(strA);
        Drawable drawableF = AbstractC4043Dl1.f(getContext(), AbstractC23598xB5.link);
        if (drawableF != null) {
            drawableF.setBounds(0, 0, C5161Id6.e(20.0f), C5161Id6.e(20.0f));
        } else {
            drawableF = null;
        }
        if (zJ) {
            c6745Ou3.c.setCompoundDrawables(null, null, drawableF, null);
        } else {
            c6745Ou3.c.setCompoundDrawables(drawableF, null, null, null);
        }
        setVisibility(0);
    }

    public final void setEditable(boolean editable) {
        this.isEditable = editable;
        if (editable) {
            return;
        }
        this.binding.getRoot().setSelected(false);
        o(false);
    }

    public final void setListener(InterfaceC18899pR6 storyLinkCustomViewActions) {
        AbstractC13042fc3.i(storyLinkCustomViewActions, "storyLinkCustomViewActions");
        this.listener = storyLinkCustomViewActions;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener l) {
        this.onClickListener = l;
    }

    public final void setProgressBarVisibility(boolean isVisible) {
        ProgressBar progressBar = this.binding.b;
        AbstractC13042fc3.h(progressBar, "progressBar");
        progressBar.setVisibility(isVisible ? 0 : 8);
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility((AbstractC13042fc3.d(this.currentEntry, InterfaceC19490qR6.a.a) || visibility != 0) ? 8 : 0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StoryLinkCustomView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ StoryLinkCustomView(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoryLinkCustomView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        this.currentEntry = InterfaceC19490qR6.a.a;
        C6745Ou3 c6745Ou3C = C6745Ou3.c(LayoutInflater.from(context), this, true);
        this.binding = c6745Ou3C;
        final FrameLayout root = c6745Ou3C.getRoot();
        root.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.iR6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StoryLinkCustomView.n(this.a, root, view);
            }
        });
        AbstractC8081Ul1.b bVar = new AbstractC8081Ul1.b();
        AbstractC8081Ul1.b.k(bVar, TD5.tgwidget_remove, AbstractC24188yB5.delete, null, new SA2() { // from class: ir.nasim.jR6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return StoryLinkCustomView.k(this.a);
            }
        }, 4, null);
        AbstractC8081Ul1.b.k(bVar, TD5.tgwidget_edit, AbstractC24188yB5.edit, null, new SA2() { // from class: ir.nasim.kR6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return StoryLinkCustomView.l(this.a);
            }
        }, 4, null);
        AbstractC8081Ul1.b.k(bVar, TD5.tgwidget_show_link, AbstractC24188yB5.show, null, new SA2() { // from class: ir.nasim.lR6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return StoryLinkCustomView.m(this.a);
            }
        }, 4, null);
        this.itemBuilder = bVar;
        this.contextMenu = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.mR6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return StoryLinkCustomView.i(this.a);
            }
        });
        this.yOffset = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.nR6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Integer.valueOf(StoryLinkCustomView.q(this.a));
            }
        });
    }
}
