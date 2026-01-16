package ir.nasim;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.textview.MaterialTextView;
import ir.nasim.contact.data.ContactItem;
import ir.nasim.designsystem.avatar.AvatarViewGlide;
import ir.nasim.features.mxp.entity.PuppetUser;

/* renamed from: ir.nasim.fo4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C13190fo4 extends AbstractC20225rf3 {
    public static final a y = new a(null);
    public static final int z = 8;
    private final C6844Pf3 w;
    private final EJ4 x;

    /* renamed from: ir.nasim.fo4$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C13190fo4(C6844Pf3 c6844Pf3, EJ4 ej4) {
        AbstractC13042fc3.i(c6844Pf3, "binding");
        AbstractC13042fc3.i(ej4, "listener");
        ConstraintLayout root = c6844Pf3.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        super(root, ej4, null, 4, null);
        this.w = c6844Pf3;
        this.x = ej4;
        S0();
    }

    private final void Q0(AvatarViewGlide avatarViewGlide, ContactItem.MxpPuppetContactItem mxpPuppetContactItem) {
        try {
            String strV = XY6.v(mxpPuppetContactItem.getName());
            PuppetUser puppetUser = (PuppetUser) AbstractC15401jX0.s0(mxpPuppetContactItem.getPuppets());
            AvatarViewGlide.v(avatarViewGlide, null, strV, puppetUser != null ? puppetUser.getUserId() : 0, false, null, 16, null);
        } catch (Exception e) {
            C19406qI3.d("MxpPuppetContactHolder", e);
        }
    }

    private final MaterialTextView S0() {
        C6844Pf3 c6844Pf3 = this.w;
        c6844Pf3.b.B(18.0f, true);
        c6844Pf3.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.eo4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C13190fo4.T0(this.a, view);
            }
        });
        MaterialTextView materialTextView = c6844Pf3.d;
        materialTextView.setTypeface(C6011Lu2.k());
        AbstractC13042fc3.h(materialTextView, "with(...)");
        return materialTextView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T0(C13190fo4 c13190fo4, View view) {
        AbstractC13042fc3.i(c13190fo4, "this$0");
        ContactItem.MxpPuppetContactItem mxpPuppetContactItem = (ContactItem.MxpPuppetContactItem) c13190fo4.F0();
        if (mxpPuppetContactItem != null) {
            c13190fo4.x.L0(mxpPuppetContactItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC20225rf3
    /* renamed from: U0, reason: merged with bridge method [inline-methods] */
    public void H0(ContactItem.MxpPuppetContactItem mxpPuppetContactItem) {
        AbstractC13042fc3.i(mxpPuppetContactItem, "item");
        C6844Pf3 c6844Pf3 = this.w;
        AvatarViewGlide avatarViewGlide = c6844Pf3.b;
        AbstractC13042fc3.h(avatarViewGlide, "puppetImage");
        Q0(avatarViewGlide, mxpPuppetContactItem);
        c6844Pf3.d.setText(XY6.v(mxpPuppetContactItem.getName()));
    }

    @Override // ir.nasim.AbstractC20225rf3
    public void a() {
        this.w.b.D();
    }
}
