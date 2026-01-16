package ir.nasim;

import android.view.View;
import com.google.android.material.card.MaterialCardView;
import ir.nasim.contact.data.ContactItem;

/* loaded from: classes4.dex */
public final class E35 extends AbstractC20225rf3 {
    private final C8788Xi1 w;

    /* JADX WARN: Illegal instructions before constructor call */
    public E35(C8788Xi1 c8788Xi1, SA2 sa2) {
        AbstractC13042fc3.i(c8788Xi1, "binding");
        AbstractC13042fc3.i(sa2, "onRequestPermission");
        MaterialCardView root = c8788Xi1.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        super(root, null, null, 4, null);
        this.w = c8788Xi1;
        U0();
        S0(sa2);
    }

    private final void S0(final SA2 sa2) {
        this.w.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.D35
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                E35.T0(sa2, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T0(SA2 sa2, View view) {
        AbstractC13042fc3.i(sa2, "$onRequestPermission");
        sa2.invoke();
    }

    private final void U0() {
        C8788Xi1 c8788Xi1 = this.w;
        c8788Xi1.e.setTypeface(C6011Lu2.i());
        c8788Xi1.d.setTypeface(C6011Lu2.k());
        c8788Xi1.c.setTypeface(C6011Lu2.i());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC20225rf3
    /* renamed from: Q0, reason: merged with bridge method [inline-methods] */
    public void H0(ContactItem.PermissionCard permissionCard) {
        AbstractC13042fc3.i(permissionCard, "item");
    }

    @Override // ir.nasim.AbstractC20225rf3
    public void a() {
    }
}
