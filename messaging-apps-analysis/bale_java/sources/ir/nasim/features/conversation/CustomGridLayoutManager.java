package ir.nasim.features.conversation;

import android.content.Context;
import android.gov.nist.javax.sip.parser.TokenNames;
import androidx.recyclerview.widget.GridLayoutManager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lir/nasim/features/conversation/CustomGridLayoutManager;", "Landroidx/recyclerview/widget/GridLayoutManager;", "Landroid/content/Context;", "context", "", "spanCount", "<init>", "(Landroid/content/Context;I)V", "", "canScrollVertically", "Lir/nasim/rB7;", "m3", "(Z)V", "l", "()Z", "m", TokenNames.R, "Z", "isCanScrollVertically", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class CustomGridLayoutManager extends GridLayoutManager {

    /* renamed from: R, reason: from kotlin metadata */
    private boolean isCanScrollVertically;

    public CustomGridLayoutManager(Context context, int i) {
        super(context, i);
        this.isCanScrollVertically = true;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
    public boolean l() {
        return false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
    public boolean m() {
        return super.m() && this.isCanScrollVertically;
    }

    public final void m3(boolean canScrollVertically) {
        this.isCanScrollVertically = canScrollVertically;
    }
}
