package androidx.compose.material.ripple;

import android.content.Context;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.view.ViewGroup;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC13610gX0;
import ir.nasim.AbstractC22421vC5;
import ir.nasim.InterfaceC21734u26;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J7\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\f\u001a\u00020\u0017*\u00020\u0016¢\u0006\u0004\b\f\u0010\u0018J\u0011\u0010\u0019\u001a\u00020\r*\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0019\u0010\u001bR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00170\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001eR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00170\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u001eR\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010\u001b¨\u0006("}, d2 = {"Landroidx/compose/material/ripple/RippleContainer;", "Landroid/view/ViewGroup;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "changed", "", "l", "t", "r", "b", "Lir/nasim/rB7;", "onLayout", "(ZIIII)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "requestLayout", "()V", "Lir/nasim/u26;", "Landroidx/compose/material/ripple/RippleHostView;", "(Lir/nasim/u26;)Landroidx/compose/material/ripple/RippleHostView;", "a", "(Lir/nasim/u26;)V", TokenNames.I, "MaxRippleHosts", "", "Ljava/util/List;", "rippleHosts", "c", "unusedRippleHosts", "Landroidx/compose/material/ripple/c;", "d", "Landroidx/compose/material/ripple/c;", "rippleHostMap", "e", "nextHostIndex", "material-ripple_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final class RippleContainer extends ViewGroup {

    /* renamed from: a, reason: from kotlin metadata */
    private final int MaxRippleHosts;

    /* renamed from: b, reason: from kotlin metadata */
    private final List rippleHosts;

    /* renamed from: c, reason: from kotlin metadata */
    private final List unusedRippleHosts;

    /* renamed from: d, reason: from kotlin metadata */
    private final c rippleHostMap;

    /* renamed from: e, reason: from kotlin metadata */
    private int nextHostIndex;

    public RippleContainer(Context context) {
        super(context);
        this.MaxRippleHosts = 5;
        ArrayList arrayList = new ArrayList();
        this.rippleHosts = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.unusedRippleHosts = arrayList2;
        this.rippleHostMap = new c();
        setClipChildren(false);
        RippleHostView rippleHostView = new RippleHostView(context);
        addView(rippleHostView);
        arrayList.add(rippleHostView);
        arrayList2.add(rippleHostView);
        this.nextHostIndex = 1;
        setTag(AbstractC22421vC5.hide_in_inspector_tag, Boolean.TRUE);
    }

    public final void a(InterfaceC21734u26 interfaceC21734u26) {
        interfaceC21734u26.j1();
        RippleHostView rippleHostViewA = this.rippleHostMap.a(interfaceC21734u26);
        if (rippleHostViewA != null) {
            rippleHostViewA.d();
            this.rippleHostMap.c(interfaceC21734u26);
            this.unusedRippleHosts.add(rippleHostViewA);
        }
    }

    public final RippleHostView b(InterfaceC21734u26 interfaceC21734u26) {
        RippleHostView rippleHostViewA = this.rippleHostMap.a(interfaceC21734u26);
        if (rippleHostViewA != null) {
            return rippleHostViewA;
        }
        RippleHostView rippleHostView = (RippleHostView) AbstractC13610gX0.M(this.unusedRippleHosts);
        if (rippleHostView == null) {
            if (this.nextHostIndex > AbstractC10360bX0.o(this.rippleHosts)) {
                rippleHostView = new RippleHostView(getContext());
                addView(rippleHostView);
                this.rippleHosts.add(rippleHostView);
            } else {
                rippleHostView = (RippleHostView) this.rippleHosts.get(this.nextHostIndex);
                InterfaceC21734u26 interfaceC21734u26B = this.rippleHostMap.b(rippleHostView);
                if (interfaceC21734u26B != null) {
                    interfaceC21734u26B.j1();
                    this.rippleHostMap.c(interfaceC21734u26B);
                    rippleHostView.d();
                }
            }
            int i = this.nextHostIndex;
            if (i < this.MaxRippleHosts - 1) {
                this.nextHostIndex = i + 1;
            } else {
                this.nextHostIndex = 0;
            }
        }
        this.rippleHostMap.d(interfaceC21734u26, rippleHostView);
        return rippleHostView;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
    }
}
