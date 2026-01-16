package ir.nasim;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.CompoundButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.checkbox.MaterialCheckBox;
import ir.nasim.AbstractC20283rl;
import ir.nasim.InterfaceC23337wl;
import ir.nasim.animation.view.transition.sharedelement.Corners;
import ir.nasim.designsystem.ImageViewCrossFade;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.DocumentStateButton;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.vX3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC22608vX3 extends AbstractC20283rl {
    private static final a f = new a(null);
    public static final int g = 8;
    private static final float h = AbstractC8943Xx1.c(10);
    private final C9263Ze3 d;
    private final Corners e;

    /* renamed from: ir.nasim.vX3$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.vX3$b */
    public static abstract class b implements AbstractC20283rl.a {
        @Override // ir.nasim.AbstractC20283rl.a
        public final AbstractC20283rl a(ViewGroup viewGroup, InterfaceC11285cl interfaceC11285cl) {
            AbstractC13042fc3.i(viewGroup, "parent");
            AbstractC13042fc3.i(interfaceC11285cl, "albumClickListener");
            C9263Ze3 c9263Ze3C = C9263Ze3.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c9263Ze3C, "inflate(...)");
            return (AbstractC20283rl) b().invoke(c9263Ze3C, interfaceC11285cl);
        }

        public abstract InterfaceC14603iB2 b();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AbstractC22608vX3(C9263Ze3 c9263Ze3, InterfaceC11285cl interfaceC11285cl) {
        AbstractC13042fc3.i(c9263Ze3, "binding");
        AbstractC13042fc3.i(interfaceC11285cl, "documentClickListener");
        ConstraintLayout root = c9263Ze3.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        super(root, interfaceC11285cl);
        this.d = c9263Ze3;
        this.e = new Corners(0.0f, 0.0f, 0.0f, 0.0f, 15, null);
        c9263Ze3.getRoot().setImportantForAccessibility(1);
        c9263Ze3.g.setImportantForAccessibility(2);
        c9263Ze3.b.setImportantForAccessibility(2);
        BubbleTextView bubbleTextView = c9263Ze3.g;
        bubbleTextView.setTypeface(C6011Lu2.k());
        bubbleTextView.setTextSize(2, 10.0f);
        DocumentStateButton documentStateButton = c9263Ze3.b;
        AbstractC13042fc3.f(documentStateButton);
        ViewGroup.LayoutParams layoutParams = documentStateButton.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        layoutParams.width = AbstractC8943Xx1.c(34);
        layoutParams.height = AbstractC8943Xx1.c(34);
        documentStateButton.setLayoutParams(layoutParams);
        DocumentStateButton.setIconSize$default(documentStateButton, AbstractC8943Xx1.c(34), 0, 2, null);
        documentStateButton.setIconPadding(AbstractC8943Xx1.c(6));
        DocumentStateButton.setProgressBarSize$default(documentStateButton, AbstractC8943Xx1.c(32), 0, 2, null);
        documentStateButton.setProgressStrokeWidth(AbstractC8943Xx1.a(1.5d));
        Context context = c9263Ze3.getRoot().getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        documentStateButton.setTintColor(OY0.b(context, AbstractC21139tA5.colorOnPrimary));
        Context context2 = c9263Ze3.getRoot().getContext();
        AbstractC13042fc3.h(context2, "getContext(...)");
        documentStateButton.setBackgroundColor(OY0.b(context2, AbstractC21139tA5.bubble_background_icon), PorterDuff.Mode.MULTIPLY);
    }

    private final void A(final C14339hl c14339hl) {
        this.d.e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ir.nasim.rX3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AbstractC22608vX3.B(this.a, c14339hl, compoundButton, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(AbstractC22608vX3 abstractC22608vX3, C14339hl c14339hl, CompoundButton compoundButton, boolean z) {
        AbstractC13042fc3.i(abstractC22608vX3, "this$0");
        AbstractC13042fc3.i(c14339hl, "$albumData");
        abstractC22608vX3.m().e(c14339hl, z);
    }

    private final ViewPropertyAnimator E() {
        final MaterialCheckBox materialCheckBox = this.d.e;
        ViewPropertyAnimator viewPropertyAnimatorWithEndAction = materialCheckBox.animate().alpha(0.0f).setDuration(150L).withEndAction(new Runnable() { // from class: ir.nasim.tX3
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC22608vX3.F(materialCheckBox);
            }
        });
        AbstractC13042fc3.h(viewPropertyAnimatorWithEndAction, "with(...)");
        return viewPropertyAnimatorWithEndAction;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(MaterialCheckBox materialCheckBox) {
        AbstractC13042fc3.i(materialCheckBox, "$this_with");
        materialCheckBox.setVisibility(8);
    }

    private final void G() {
        MaterialCheckBox materialCheckBox = this.d.e;
        materialCheckBox.setAlpha(0.0f);
        AbstractC13042fc3.f(materialCheckBox);
        materialCheckBox.setVisibility(0);
        materialCheckBox.animate().alpha(1.0f).setDuration(150L);
    }

    private final void H() {
        this.d.e.setOnCheckedChangeListener(null);
    }

    protected void C(C14339hl c14339hl) {
        AbstractC13042fc3.i(c14339hl, "albumData");
        MaterialCheckBox materialCheckBox = this.d.e;
        if (c14339hl.e() == null) {
            AbstractC13042fc3.f(materialCheckBox);
            materialCheckBox.setVisibility(8);
        } else {
            AbstractC13042fc3.f(materialCheckBox);
            materialCheckBox.setVisibility(0);
            materialCheckBox.setChecked(c14339hl.e().booleanValue());
        }
    }

    protected final C9263Ze3 D() {
        return this.d;
    }

    @Override // ir.nasim.AbstractC20283rl
    public void a() {
        super.a();
        H();
    }

    @Override // ir.nasim.InterfaceC9437Zx6
    public C8948Xx6 b() {
        ImageViewCrossFade imageViewCrossFade = this.d.c;
        String strJ = AbstractC12990fW7.J(imageViewCrossFade);
        if (!(!(strJ == null || AbstractC20762sZ6.n0(strJ)))) {
            imageViewCrossFade = null;
        }
        if (imageViewCrossFade != null) {
            return new C8948Xx6(imageViewCrossFade, Corners.b(this.e, 0.0f, 0.0f, 0.0f, 0.0f, 15, null));
        }
        return null;
    }

    @Override // ir.nasim.AbstractC20283rl
    public final void c(C14339hl c14339hl, AbstractC15537jl abstractC15537jl, String str) {
        AbstractC13042fc3.i(c14339hl, "albumData");
        AbstractC13042fc3.i(abstractC15537jl, "extras");
        AbstractC13042fc3.i(str, "contentDescription");
        y(c14339hl, (C17177mX3) abstractC15537jl, str);
    }

    @Override // ir.nasim.AbstractC20283rl
    public void f(InterfaceC23337wl interfaceC23337wl) {
        AbstractC13042fc3.i(interfaceC23337wl, "payload");
        if (interfaceC23337wl instanceof InterfaceC23337wl.c) {
            if (((InterfaceC23337wl.c) interfaceC23337wl).a()) {
                G();
                return;
            } else {
                E();
                return;
            }
        }
        if (!(interfaceC23337wl instanceof InterfaceC23337wl.b)) {
            if (!(interfaceC23337wl instanceof InterfaceC23337wl.a)) {
                throw new NoWhenBranchMatchedException();
            }
            q(((InterfaceC23337wl.a) interfaceC23337wl).a());
        } else {
            H();
            InterfaceC23337wl.b bVar = (InterfaceC23337wl.b) interfaceC23337wl;
            C(bVar.a());
            A(bVar.a());
        }
    }

    @Override // ir.nasim.AbstractC20283rl
    public void q(C14339hl c14339hl) {
        AbstractC13042fc3.i(c14339hl, "albumData");
        super.q(c14339hl);
        A(c14339hl);
    }

    public void y(C14339hl c14339hl, C17177mX3 c17177mX3, String str) {
        AbstractC13042fc3.i(c14339hl, "albumData");
        AbstractC13042fc3.i(c17177mX3, "extras");
        AbstractC13042fc3.i(str, "contentDescription");
        C9263Ze3 c9263Ze3 = this.d;
        super.c(c14339hl, c17177mX3, str);
        ConstraintLayout root = c9263Ze3.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        layoutParams.width = ((Number) c17177mX3.d().e()).intValue();
        layoutParams.height = ((Number) c17177mX3.d().f()).intValue();
        root.setLayoutParams(layoutParams);
        AbstractC12990fW7.L0(c9263Ze3.c, "thumb_" + c17177mX3.a());
        Corners corners = this.e;
        C13746gl c13746gl = C13746gl.a;
        int iC = c17177mX3.c();
        float f2 = h;
        corners.g(c13746gl.e(iC, f2), c13746gl.d(c17177mX3.c(), f2), c13746gl.b(c17177mX3.c(), f2), c13746gl.a(c17177mX3.c(), f2));
        c9263Ze3.c.setCorners(this.e.getTopRight(), this.e.getTopLeft(), this.e.getBottomRight(), this.e.getBottomLeft());
        H();
        C(c14339hl);
        A(c14339hl);
    }
}
