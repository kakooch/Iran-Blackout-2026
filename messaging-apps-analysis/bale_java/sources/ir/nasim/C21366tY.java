package ir.nasim;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.textview.MaterialTextView;
import ir.nasim.C20919sp4;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.PI7;
import ir.nasim.contact.data.ContactItem;
import ir.nasim.designsystem.avatar.AvatarViewGlide;

/* renamed from: ir.nasim.tY, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C21366tY extends AbstractC20225rf3 {
    public static final a Y = new a(null);
    public static final int Z = 8;
    private final InterfaceC9173Yu3 A;
    private final InterfaceC9173Yu3 B;
    private final InterfaceC9173Yu3 D;
    private C20919sp4.b G;
    private TextWatcher H;
    private InterfaceC13730gj3 J;
    private final C6341Ne3 w;
    private final XI4 x;
    private final boolean y;
    private final UW7 z;

    /* renamed from: ir.nasim.tY$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.tY$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ ContactItem.BaleContactItem d;
        final /* synthetic */ C6341Ne3 e;

        /* renamed from: ir.nasim.tY$b$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C21366tY a;
            final /* synthetic */ C6341Ne3 b;

            a(C21366tY c21366tY, C6341Ne3 c6341Ne3) {
                this.a = c21366tY;
                this.b = c6341Ne3;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(PI7 pi7, InterfaceC20295rm1 interfaceC20295rm1) {
                this.a.Z0(pi7);
                ImageView imageView = this.b.f;
                AbstractC13042fc3.h(imageView, "onlineCircle");
                imageView.setVisibility(0);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ContactItem.BaleContactItem baleContactItem, C6341Ne3 c6341Ne3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = baleContactItem;
            this.e = c6341Ne3;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21366tY.this.new b(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C14375ho5 c14375ho5E0 = C21366tY.this.a1().e0();
                long id = this.d.getId();
                this.b = 1;
                obj = c14375ho5E0.F(id, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                AbstractC10685c16.b(obj);
            }
            InterfaceC4557Fq2 interfaceC4557Fq2F = AbstractC6459Nq2.F((InterfaceC4557Fq2) obj);
            a aVar = new a(C21366tY.this, this.e);
            this.b = 2;
            if (interfaceC4557Fq2F.b(aVar, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public /* synthetic */ C21366tY(C6341Ne3 c6341Ne3, XI4 xi4, boolean z, UW7 uw7, int i, ED1 ed1) {
        this(c6341Ne3, xi4, z, (i & 8) != 0 ? new UW7() : uw7);
    }

    private final void W0(AvatarViewGlide avatarViewGlide, ContactItem.BaleContactItem baleContactItem) {
        ContactItem.BaleContactItem.b image = baleContactItem.getImage();
        try {
            if (image instanceof ContactItem.BaleContactItem.b.C0986b) {
                avatarViewGlide.setImageResource(((ContactItem.BaleContactItem.b.C0986b) image).a());
            } else {
                ContactItem.BaleContactItem.b.a aVar = image instanceof ContactItem.BaleContactItem.b.a ? (ContactItem.BaleContactItem.b.a) image : null;
                AvatarViewGlide.v(avatarViewGlide, aVar != null ? aVar.a() : null, XY6.v(baleContactItem.getName()), baleContactItem.getId(), false, null, 16, null);
            }
        } catch (Exception e) {
            C19406qI3.d("BaleContactHolder", e);
        }
    }

    private final void X0() {
        C6341Ne3 c6341Ne3 = this.w;
        c6341Ne3.c.setText(c6341Ne3.getRoot().getContext().getString(AbstractC12217eE5.members_adapter_bot_online_status));
        ImageView imageView = c6341Ne3.f;
        AbstractC13042fc3.h(imageView, "onlineCircle");
        imageView.setVisibility(8);
    }

    private final void Y0(ContactItem.BaleContactItem baleContactItem) {
        C6341Ne3 c6341Ne3 = this.w;
        InterfaceC13730gj3 interfaceC13730gj3 = this.J;
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
        this.J = AbstractC10533bm0.d(androidx.lifecycle.o.a(this.z.getLifecycle()), null, null, new b(baleContactItem, c6341Ne3, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z0(PI7 pi7) {
        C6341Ne3 c6341Ne3 = this.w;
        Context context = c6341Ne3.c.getContext();
        AbstractC13042fc3.f(context);
        String strY = C14593iA1.y(context, pi7, false, 4, null);
        if (pi7.u() == PI7.a.ONLINE) {
            c6341Ne3.c.setTextColor(C5495Jo7.a.e2());
            c6341Ne3.f.setImageResource(KB5.ic_online_circle);
        } else {
            c6341Ne3.c.setTextColor(C5495Jo7.a.n0());
            c6341Ne3.f.setImageResource(KB5.ic_online_circle_gray);
        }
        c6341Ne3.c.setText(strY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C11335cq a1() {
        return (C11335cq) this.B.getValue();
    }

    private final int c1() {
        return ((Number) this.A.getValue()).intValue();
    }

    private final C20919sp4 d1() {
        return (C20919sp4) this.D.getValue();
    }

    private final void e1(C6341Ne3 c6341Ne3) {
        ImageButton imageButton = c6341Ne3.e;
        AbstractC13042fc3.h(imageButton, "contactVoiceCall");
        imageButton.setVisibility(8);
    }

    private final void f1(C6341Ne3 c6341Ne3) {
        MaterialTextView materialTextView = c6341Ne3.c;
        AbstractC13042fc3.h(materialTextView, "contactLastSeen");
        materialTextView.setVisibility(8);
        ImageView imageView = c6341Ne3.f;
        AbstractC13042fc3.h(imageView, "onlineCircle");
        imageView.setVisibility(8);
    }

    private final MaterialTextView g1() {
        C6341Ne3 c6341Ne3 = this.w;
        c6341Ne3.b.B(18.0f, true);
        c6341Ne3.e.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.sY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C21366tY.i1(this.a, view);
            }
        });
        c6341Ne3.d.setTypeface(C6011Lu2.k());
        MaterialTextView materialTextView = c6341Ne3.c;
        materialTextView.setTypeface(C6011Lu2.k());
        AbstractC13042fc3.h(materialTextView, "with(...)");
        return materialTextView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(C21366tY c21366tY, View view) {
        AbstractC13042fc3.i(c21366tY, "this$0");
        ContactItem.BaleContactItem baleContactItem = (ContactItem.BaleContactItem) c21366tY.F0();
        if (baleContactItem != null) {
            c21366tY.x.l5(baleContactItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C11335cq l1() {
        return AbstractC5969Lp4.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int n1() {
        return AbstractC5969Lp4.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C20919sp4 o1() {
        return new C20919sp4();
    }

    private final void p1(ContactItem.BaleContactItem baleContactItem) {
        this.w.e.setContentDescription(this.a.getContext().getString(AbstractC12217eE5.all_ic_voice_call_content_description, baleContactItem.getName()));
    }

    private final void q1(C6341Ne3 c6341Ne3, ContactItem.BaleContactItem baleContactItem) {
        MaterialTextView materialTextView = c6341Ne3.c;
        AbstractC13042fc3.h(materialTextView, "contactLastSeen");
        c cVar = new c(baleContactItem, c6341Ne3);
        materialTextView.addTextChangedListener(cVar);
        this.H = cVar;
    }

    private final void r1(C6341Ne3 c6341Ne3) {
        ImageButton imageButton = c6341Ne3.e;
        AbstractC13042fc3.h(imageButton, "contactVoiceCall");
        imageButton.setVisibility(0);
    }

    @Override // ir.nasim.AbstractC20225rf3
    public void a() {
        this.w.b.D();
        C20919sp4.b bVar = this.G;
        if (bVar != null) {
            d1().c0(bVar);
        }
        this.H = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC20225rf3
    /* renamed from: j1, reason: merged with bridge method [inline-methods] */
    public void H0(ContactItem.BaleContactItem baleContactItem) {
        AbstractC13042fc3.i(baleContactItem, "item");
        C6341Ne3 c6341Ne3 = this.w;
        AvatarViewGlide avatarViewGlide = c6341Ne3.b;
        AbstractC13042fc3.h(avatarViewGlide, "contactImage");
        W0(avatarViewGlide, baleContactItem);
        c6341Ne3.d.setText(XY6.v(baleContactItem.getName()));
        if (baleContactItem.getId() == c1()) {
            e1(c6341Ne3);
            f1(c6341Ne3);
        } else {
            MaterialTextView materialTextView = c6341Ne3.c;
            AbstractC13042fc3.h(materialTextView, "contactLastSeen");
            materialTextView.setVisibility(0);
            if (baleContactItem.getIsBot()) {
                e1(c6341Ne3);
                X0();
            } else if (this.y) {
                r1(c6341Ne3);
                Y0(baleContactItem);
            } else {
                e1(c6341Ne3);
                Y0(baleContactItem);
            }
        }
        q1(c6341Ne3, baleContactItem);
        p1(baleContactItem);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C21366tY(C6341Ne3 c6341Ne3, XI4 xi4, boolean z, UW7 uw7) {
        AbstractC13042fc3.i(c6341Ne3, "binding");
        AbstractC13042fc3.i(xi4, "listener");
        AbstractC13042fc3.i(uw7, "viewLifecycleHolder");
        ConstraintLayout root = c6341Ne3.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        super(root, xi4, uw7);
        this.w = c6341Ne3;
        this.x = xi4;
        this.y = z;
        this.z = uw7;
        this.A = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.pY
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Integer.valueOf(C21366tY.n1());
            }
        });
        this.B = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.qY
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21366tY.l1();
            }
        });
        this.D = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.rY
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21366tY.o1();
            }
        });
        g1();
    }

    /* renamed from: ir.nasim.tY$c */
    public static final class c implements TextWatcher {
        final /* synthetic */ ContactItem.BaleContactItem b;
        final /* synthetic */ C6341Ne3 c;

        public c(ContactItem.BaleContactItem baleContactItem, C6341Ne3 c6341Ne3) {
            this.b = baleContactItem;
            this.c = c6341Ne3;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (charSequence == null || charSequence.length() == 0) {
                return;
            }
            View view = C21366tY.this.a;
            view.setContentDescription(view.getContext().getString(AbstractC12217eE5.contacts_fragment_contact_item_content_descriptopn, this.b.getName(), this.c.c.getText()));
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
