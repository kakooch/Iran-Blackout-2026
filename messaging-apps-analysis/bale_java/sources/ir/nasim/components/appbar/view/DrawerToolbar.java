package ir.nasim.components.appbar.view;

import android.content.Context;
import android.util.AttributeSet;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC24188yB5;
import ir.nasim.C15225jD4;
import ir.nasim.C5054Hr7;
import ir.nasim.ED1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001 B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J/\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\n2\u0016\u0010\u001c\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001b0\u001a\"\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lir/nasim/components/appbar/view/DrawerToolbar;", "Lir/nasim/components/appbar/view/BaleToolbar;", "Lir/nasim/jD4$b;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/rB7;", "B0", "()V", "onDetachedFromWindow", "", "showBadge", "setNavigationDrawerFragment", "(Z)V", "", "progress", "setMenuIconForDownloadState", "(ZF)V", "id", "", "", "args", "didReceivedNotification", "(I[Ljava/lang/Object;)V", "a1", "a", "ui_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes4.dex */
public final class DrawerToolbar extends BaleToolbar implements C15225jD4.b {

    /* renamed from: a1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static boolean b1;

    /* renamed from: ir.nasim.components.appbar.view.DrawerToolbar$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final void a(boolean z) {
            DrawerToolbar.b1 = z;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawerToolbar(Context context) {
        super(context);
        AbstractC13042fc3.i(context, "context");
    }

    private final void B0() {
        C15225jD4.b().a(this, C15225jD4.G);
    }

    public static /* synthetic */ void setMenuIconForDownloadState$default(DrawerToolbar drawerToolbar, boolean z, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        drawerToolbar.setMenuIconForDownloadState(z, f);
    }

    public static /* synthetic */ void setNavigationDrawerFragment$default(DrawerToolbar drawerToolbar, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        drawerToolbar.setNavigationDrawerFragment(z);
    }

    @Override // ir.nasim.C15225jD4.b
    public void didReceivedNotification(int id, Object... args) {
        AbstractC13042fc3.i(args, "args");
        if (id == C15225jD4.G) {
            setNavigationIcon(AbstractC24188yB5.ic_drawer_menu);
            b1 = true;
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C15225jD4.b().e(this, C15225jD4.G);
    }

    public final void setMenuIconForDownloadState(boolean showBadge, float progress) {
        if (showBadge) {
            setNavigationIcon(AbstractC24188yB5.ic_drawer_menu_badge);
            return;
        }
        if (progress == 0.0f) {
            return;
        }
        int i = AbstractC24188yB5.menu_loading;
        Context applicationContext = getContext().getApplicationContext();
        AbstractC13042fc3.h(applicationContext, "getApplicationContext(...)");
        C5054Hr7 c5054Hr7 = new C5054Hr7(i, applicationContext, 0, 0, 0, 0.0f, 0.0f, 124, null);
        c5054Hr7.a((int) (progress * 100));
        setNavigationIcon(c5054Hr7);
    }

    public final void setNavigationDrawerFragment(boolean showBadge) {
        B0();
        if (b1 || !showBadge) {
            setNavigationIcon(AbstractC24188yB5.ic_drawer_menu);
        } else {
            setNavigationIcon(AbstractC24188yB5.ic_drawer_menu_badge);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawerToolbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AbstractC13042fc3.i(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawerToolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
    }
}
