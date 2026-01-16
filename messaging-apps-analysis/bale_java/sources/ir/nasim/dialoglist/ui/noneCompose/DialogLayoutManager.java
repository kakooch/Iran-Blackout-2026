package ir.nasim.dialoglist.ui.noneCompose;

import android.content.Context;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C19406qI3;
import ir.nasim.ED1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0007*\u0001#\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001(B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB)\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u001a\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\f\u0010\u0019\u001a\b\u0018\u00010\u0018R\u00020\u0014H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ%\u0010\u001e\u001a\u00020\u000f2\f\u0010\u0019\u001a\b\u0018\u00010\u0018R\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lir/nasim/dialoglist/ui/noneCompose/DialogLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroid/content/Context;", "context", "", "orientation", "", "reverseLayout", "<init>", "(Landroid/content/Context;IZ)V", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Lir/nasim/rB7;", "U2", "()V", "P1", "()Z", "Landroidx/recyclerview/widget/RecyclerView;", "view", "J0", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Landroidx/recyclerview/widget/RecyclerView$v;", "recycler", "L0", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$v;)V", "Landroidx/recyclerview/widget/RecyclerView$z;", "state", "a1", "(Landroidx/recyclerview/widget/RecyclerView$v;Landroidx/recyclerview/widget/RecyclerView$z;)V", TokenNames.I, "Z", "isScrolling", "ir/nasim/dialoglist/ui/noneCompose/a", "J", "Lir/nasim/dialoglist/ui/noneCompose/a;", "scrollListener", TokenNames.K, "a", "dialogList_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class DialogLayoutManager extends LinearLayoutManager {
    private static final a K = new a(null);
    public static final int L = 8;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isScrolling;

    /* renamed from: J, reason: from kotlin metadata */
    private final ir.nasim.dialoglist.ui.noneCompose.a scrollListener;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
        AbstractC13042fc3.i(context, "context");
        this.scrollListener = new ir.nasim.dialoglist.ui.noneCompose.a(this);
    }

    private final void U2() {
        View viewJ = J(0);
        if (viewJ != null) {
            int iV = V(viewJ);
            int iK = K();
            for (int i = 0; i < iK; i++) {
                View viewJ2 = J(i);
                if (viewJ2 != null) {
                    int iV2 = V(viewJ2);
                    if (Math.abs(iV2 - iV) > 1.0f) {
                        C19406qI3.b("DialogLayoutManager", "Misplacement detected at index " + i + ". Expected top: " + iV + ", Actual top: " + iV2 + ". Correcting...");
                        B0(viewJ2, R(viewJ2), iV, U(viewJ2), iV + S(viewJ2));
                    }
                    iV += S(viewJ2);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void J0(RecyclerView view) {
        super.J0(view);
        if (view != null) {
            view.addOnScrollListener(this.scrollListener);
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
    public void L0(RecyclerView view, RecyclerView.v recycler) {
        if (view != null) {
            view.removeOnScrollListener(this.scrollListener);
        }
        super.L0(view, recycler);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
    public boolean P1() {
        return false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
    public void a1(RecyclerView.v recycler, RecyclerView.z state) {
        AbstractC13042fc3.i(state, "state");
        super.a1(recycler, state);
        if (this.isScrolling || K() <= 0) {
            return;
        }
        U2();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(attributeSet, "attrs");
        this.scrollListener = new ir.nasim.dialoglist.ui.noneCompose.a(this);
    }
}
