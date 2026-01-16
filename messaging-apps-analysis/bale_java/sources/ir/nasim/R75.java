package ir.nasim;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.textview.MaterialTextView;
import ir.nasim.contact.data.ContactItem;
import ir.nasim.designsystem.avatar.AvatarViewGlide;

/* loaded from: classes4.dex */
public final class R75 extends AbstractC20225rf3 {
    public static final a y = new a(null);
    public static final int z = 8;
    private final C7088Qf3 w;
    private final InterfaceC22483vJ4 x;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public R75(C7088Qf3 c7088Qf3, InterfaceC22483vJ4 interfaceC22483vJ4, InterfaceC22483vJ4 interfaceC22483vJ42) {
        AbstractC13042fc3.i(c7088Qf3, "binding");
        AbstractC13042fc3.i(interfaceC22483vJ4, "listener");
        ConstraintLayout root = c7088Qf3.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        super(root, interfaceC22483vJ42 == null ? interfaceC22483vJ4 : interfaceC22483vJ42, null, 4, null);
        this.w = c7088Qf3;
        this.x = interfaceC22483vJ4;
        T0();
    }

    private final void Q0(AvatarViewGlide avatarViewGlide, ContactItem.PhoneBookContactItem phoneBookContactItem) {
        try {
            Character chV1 = AbstractC22039uZ6.v1(phoneBookContactItem.getPhoneNumber());
            AvatarViewGlide.v(avatarViewGlide, null, XY6.v(phoneBookContactItem.getName()), chV1 != null ? AbstractC11632dL0.g(chV1.charValue()) : 0, false, null, 16, null);
        } catch (Exception e) {
            C19406qI3.d("PhoneContactHolder", e);
        }
    }

    private final String S0(ContactItem.PhoneBookContactItem phoneBookContactItem) {
        if (!AbstractC20153rZ6.S(phoneBookContactItem.getPhoneNumber(), "98", false, 2, null) && !AbstractC20153rZ6.S(phoneBookContactItem.getPhoneNumber(), GY6.a("98"), false, 2, null)) {
            return XY6.v(phoneBookContactItem.getPhoneNumber());
        }
        String strV = XY6.v("0");
        String strSubstring = phoneBookContactItem.getPhoneNumber().substring(2);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        return strV + XY6.v(strSubstring);
    }

    private final MaterialTextView T0() {
        C7088Qf3 c7088Qf3 = this.w;
        c7088Qf3.b.B(18.0f, true);
        c7088Qf3.d.setTypeface(C6011Lu2.k());
        MaterialTextView materialTextView = c7088Qf3.e;
        materialTextView.setTypeface(C6011Lu2.k());
        AbstractC13042fc3.h(materialTextView, "with(...)");
        return materialTextView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V0(R75 r75, ContactItem.PhoneBookContactItem phoneBookContactItem, View view) {
        AbstractC13042fc3.i(r75, "this$0");
        AbstractC13042fc3.i(phoneBookContactItem, "$item");
        r75.x.e(phoneBookContactItem);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC20225rf3
    /* renamed from: U0, reason: merged with bridge method [inline-methods] */
    public void H0(final ContactItem.PhoneBookContactItem phoneBookContactItem) {
        AbstractC13042fc3.i(phoneBookContactItem, "item");
        C7088Qf3 c7088Qf3 = this.w;
        c7088Qf3.f.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Q75
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                R75.V0(this.a, phoneBookContactItem, view);
            }
        });
        AvatarViewGlide avatarViewGlide = c7088Qf3.b;
        AbstractC13042fc3.h(avatarViewGlide, "contactImage");
        Q0(avatarViewGlide, phoneBookContactItem);
        c7088Qf3.d.setText(XY6.v(phoneBookContactItem.getName()));
        c7088Qf3.e.setText(S0(phoneBookContactItem));
    }

    @Override // ir.nasim.AbstractC20225rf3
    public void a() {
        this.w.b.D();
    }
}
