package ir.nasim;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import ir.nasim.contact.data.ContactItem;

/* renamed from: ir.nasim.Xg1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C8770Xg1 extends AbstractC20225rf3 {
    private final C5678Kj1 w;
    private final boolean x;

    /* JADX WARN: Illegal instructions before constructor call */
    public C8770Xg1(C5678Kj1 c5678Kj1, UA2 ua2, boolean z) {
        AbstractC13042fc3.i(c5678Kj1, "binding");
        LinearLayout root = c5678Kj1.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        super(root, null, null, 4, null);
        this.w = c5678Kj1;
        this.x = z;
        Q0();
        if (ua2 != null) {
            T0(ua2);
        }
    }

    private final void Q0() {
        this.w.c.setTypeface(C6011Lu2.i());
    }

    private final void T0(final UA2 ua2) {
        this.w.b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Wg1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C8770Xg1.U0(this.a, ua2, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(C8770Xg1 c8770Xg1, UA2 ua2, View view) {
        Integer iconResourceId;
        AbstractC13042fc3.i(c8770Xg1, "this$0");
        AbstractC13042fc3.i(ua2, "$onIconClickListener");
        ContactItem.SeparatorTitleItem separatorTitleItem = (ContactItem.SeparatorTitleItem) c8770Xg1.F0();
        if (separatorTitleItem == null || (iconResourceId = separatorTitleItem.getIconResourceId()) == null) {
            return;
        }
        ua2.invoke(iconResourceId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC20225rf3
    /* renamed from: S0, reason: merged with bridge method [inline-methods] */
    public void H0(ContactItem.SeparatorTitleItem separatorTitleItem) {
        AbstractC13042fc3.i(separatorTitleItem, "item");
        C5678Kj1 c5678Kj1 = this.w;
        c5678Kj1.c.setText(separatorTitleItem.getTextResourceId());
        ImageView imageView = c5678Kj1.b;
        AbstractC13042fc3.f(imageView);
        imageView.setVisibility(separatorTitleItem.getIconResourceId() != null && this.x ? 0 : 8);
        Integer iconResourceId = separatorTitleItem.getIconResourceId();
        if (iconResourceId != null) {
            imageView.setImageResource(iconResourceId.intValue());
        }
    }

    @Override // ir.nasim.AbstractC20225rf3
    public void a() {
    }
}
