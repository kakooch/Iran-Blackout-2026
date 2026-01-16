package ir.nasim;

import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.C20882sl7;
import ir.nasim.database.dailogLists.DialogEntity;

/* loaded from: classes5.dex */
public final class MI5 extends C20882sl7 {
    public static final a s = new a(null);
    public static final int t = 8;
    private final ConstraintLayout r;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final class b extends C20882sl7.b {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(boolean z, AbstractC23538x54 abstractC23538x54) {
            super(z, abstractC23538x54);
            AbstractC13042fc3.i(abstractC23538x54, "bubbleClickListener");
        }

        @Override // ir.nasim.C20882sl7.b
        protected InterfaceC20284rl0 b(C15481jf3 c15481jf3, boolean z) {
            AbstractC13042fc3.i(c15481jf3, "binding");
            return new MI5(c15481jf3, z, c(), null);
        }
    }

    public /* synthetic */ MI5(C15481jf3 c15481jf3, boolean z, AbstractC23538x54 abstractC23538x54, ED1 ed1) {
        this(c15481jf3, z, abstractC23538x54);
    }

    private final int a1(int i) {
        return Math.min(i, (int) (x0().getRoot().getResources().getDisplayMetrics().widthPixels * 0.75d));
    }

    @Override // ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    /* renamed from: D0 */
    public ConstraintLayout d() {
        return this.r;
    }

    @Override // ir.nasim.C20882sl7
    protected void W0(boolean z) {
        x0().f.setBackgroundResource(KB5.message_holder_receipt_bubble_background);
    }

    @Override // ir.nasim.C20882sl7
    protected void X0(XV4 xv4) {
        AbstractC13042fc3.i(xv4, "maxAvailableSpace");
        B0().s((a1(((Number) xv4.e()).intValue()) - x0().getRoot().getPaddingLeft()) - x0().getRoot().getPaddingRight());
    }

    @Override // ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    public void o(C8967Xz7 c8967Xz7, XV4 xv4, EnumC8893Xt7 enumC8893Xt7) {
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(xv4, "maxAvailableSpace");
        super.o(c8967Xz7, xv4, enumC8893Xt7);
        ConstraintLayout root = x0().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = a1(((Number) xv4.e()).intValue());
        root.setLayoutParams(layoutParams2);
    }

    private MI5(C15481jf3 c15481jf3, boolean z, AbstractC23538x54 abstractC23538x54) {
        super(c15481jf3, z, abstractC23538x54);
        ConstraintLayout constraintLayout = c15481jf3.f;
        AbstractC13042fc3.h(constraintLayout, "layout");
        this.r = constraintLayout;
    }
}
