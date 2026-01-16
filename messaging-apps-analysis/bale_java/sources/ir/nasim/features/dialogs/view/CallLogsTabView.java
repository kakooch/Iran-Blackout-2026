package ir.nasim.features.dialogs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.EP1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lir/nasim/features/dialogs/view/CallLogsTabView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "title", "Lir/nasim/rB7;", "setTitle", "(Ljava/lang/String;)V", "Lir/nasim/EP1;", "a", "Lir/nasim/EP1;", "getBinding", "()Lir/nasim/EP1;", "binding", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class CallLogsTabView extends FrameLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private final EP1 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallLogsTabView(Context context) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        EP1 ep1C = EP1.c(LayoutInflater.from(context), this, true);
        AbstractC13042fc3.h(ep1C, "inflate(...)");
        this.binding = ep1C;
    }

    public final EP1 getBinding() {
        return this.binding;
    }

    public final void setTitle(String title) {
        AbstractC13042fc3.i(title, "title");
        this.binding.b.setText(title);
    }
}
