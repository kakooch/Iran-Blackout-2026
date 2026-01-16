package ir.nasim;

import android.content.Context;
import android.graphics.Point;
import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.designsystem.avatar.AvatarViewGlide;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageEmojiTextView;

/* renamed from: ir.nasim.lC7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16401lC7 extends AbstractC19821r0 {
    public static final a A = new a(null);
    public static final int B = 8;
    private final C16072kf3 w;
    private final InterfaceC12810fC7 x;
    private J44 y;
    private InterfaceC7857Tm2 z;

    /* renamed from: ir.nasim.lC7$a */
    public static final class a {
        private a() {
        }

        public final C16401lC7 a(ViewGroup viewGroup, LayoutInflater layoutInflater, boolean z, boolean z2, InterfaceC12810fC7 interfaceC12810fC7) {
            AbstractC13042fc3.i(viewGroup, "parent");
            AbstractC13042fc3.i(layoutInflater, "inflater");
            AbstractC13042fc3.i(interfaceC12810fC7, "unsupportedMessageClickListener");
            C16072kf3 c16072kf3C = C16072kf3.c(layoutInflater, viewGroup, false);
            AbstractC13042fc3.h(c16072kf3C, "inflate(...)");
            return new C16401lC7(c16072kf3C, z, z2, interfaceC12810fC7, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C16401lC7(C16072kf3 c16072kf3, boolean z, boolean z2, InterfaceC12810fC7 interfaceC12810fC7, ED1 ed1) {
        this(c16072kf3, z, z2, interfaceC12810fC7);
    }

    private final void O0(final C20610sI7 c20610sI7) {
        this.w.e.setImageDrawable(c20610sI7 != null ? c20610sI7.c() : null);
        W0(c20610sI7 != null ? c20610sI7.b() : null, new SA2() { // from class: ir.nasim.gC7
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C16401lC7.P0(this.a, c20610sI7);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 P0(C16401lC7 c16401lC7, C20610sI7 c20610sI7) {
        AbstractC13042fc3.i(c16401lC7, "this$0");
        X0(c16401lC7, c20610sI7 != null ? c20610sI7.a() : null, null, 2, null);
        return C19938rB7.a;
    }

    private final void Q0(C16072kf3 c16072kf3, final J44 j44) {
        c16072kf3.e.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.iC7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C16401lC7.U0(this.a, j44, view);
            }
        });
        final ConstraintLayout root = c16072kf3.getRoot();
        root.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.jC7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C16401lC7.T0(this.a, root, j44, view);
            }
        });
        root.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.nasim.kC7
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return C16401lC7.S0(this.a, j44, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean S0(C16401lC7 c16401lC7, J44 j44, View view) {
        AbstractC13042fc3.i(c16401lC7, "this$0");
        AbstractC13042fc3.i(j44, "$message");
        return c16401lC7.x.b(j44);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T0(C16401lC7 c16401lC7, ConstraintLayout constraintLayout, J44 j44, View view) {
        AbstractC13042fc3.i(c16401lC7, "this$0");
        AbstractC13042fc3.i(constraintLayout, "$this_apply");
        AbstractC13042fc3.i(j44, "$message");
        InterfaceC12810fC7 interfaceC12810fC7 = c16401lC7.x;
        View rootView = constraintLayout.getRootView();
        AbstractC13042fc3.h(rootView, "getRootView(...)");
        interfaceC12810fC7.c(rootView, j44);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(C16401lC7 c16401lC7, J44 j44, View view) {
        AbstractC13042fc3.i(c16401lC7, "this$0");
        AbstractC13042fc3.i(j44, "$message");
        c16401lC7.x.a(j44.U());
    }

    private final void V0(Spannable spannable) {
        this.w.d.r(spannable);
    }

    private final void W0(FileReference fileReference, SA2 sa2) {
        if (fileReference != null) {
            this.z = AbstractC5969Lp4.d().q(fileReference, true, new b(sa2));
        } else if (sa2 != null) {
            sa2.invoke();
        }
    }

    static /* synthetic */ void X0(C16401lC7 c16401lC7, FileReference fileReference, SA2 sa2, int i, Object obj) {
        if ((i & 2) != 0) {
            sa2 = null;
        }
        c16401lC7.W0(fileReference, sa2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Y0(View view, MotionEvent motionEvent) {
        AbstractC5770Kt3.b(new Point((int) motionEvent.getRawX(), (int) motionEvent.getRawY()));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z0(ImageView imageView, String str) {
        Context context = imageView.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        QI2.c(str, context, imageView.getHeight(), imageView.getWidth()).Q0(imageView);
    }

    @Override // ir.nasim.AbstractC19821r0
    public void a() {
        this.y = null;
        InterfaceC7857Tm2 interfaceC7857Tm2 = this.z;
        if (interfaceC7857Tm2 != null) {
            interfaceC7857Tm2.b();
        }
        this.z = null;
        C16072kf3 c16072kf3 = this.w;
        ConstraintLayout root = c16072kf3.getRoot();
        root.setOnClickListener(null);
        root.setOnLongClickListener(null);
        AvatarViewGlide avatarViewGlide = c16072kf3.e;
        avatarViewGlide.setOnClickListener(null);
        OI2.b(C5721Ko.a.d()).n(avatarViewGlide);
    }

    public final void a1(J44 j44, Spannable spannable, C20610sI7 c20610sI7) {
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(spannable, "state");
        C16072kf3 c16072kf3 = this.w;
        J44 j442 = this.y;
        if (j442 == null || j442.U() != j44.U()) {
            O0(c20610sI7);
        }
        CharSequence text = c16072kf3.d.getText();
        if (!AbstractC20153rZ6.y(text instanceof Spannable ? (Spannable) text : null, spannable)) {
            V0(spannable);
        }
        Q0(c16072kf3, j44);
        this.y = j44;
    }

    private C16401lC7(C16072kf3 c16072kf3, boolean z, boolean z2, InterfaceC12810fC7 interfaceC12810fC7) {
        super(c16072kf3.getRoot());
        this.w = c16072kf3;
        this.x = interfaceC12810fC7;
        LinearLayout linearLayout = c16072kf3.b;
        if (z) {
            linearLayout.setBackgroundResource(KB5.bubble_in);
        } else {
            linearLayout.setBackgroundResource(KB5.bubble_out);
        }
        AbstractC13042fc3.f(linearLayout);
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.F = z ? 0.0f : 1.0f;
        linearLayout.setLayoutParams(layoutParams2);
        AvatarViewGlide avatarViewGlide = c16072kf3.e;
        if (z2) {
            avatarViewGlide.B(18.0f, true);
        } else {
            AbstractC13042fc3.f(avatarViewGlide);
            avatarViewGlide.setVisibility(8);
        }
        MessageEmojiTextView messageEmojiTextView = c16072kf3.c;
        messageEmojiTextView.setTypeface(C6011Lu2.k());
        messageEmojiTextView.setText(AbstractC12217eE5.chat_unsupported_title);
        c16072kf3.getRoot().setOnTouchListener(new View.OnTouchListener() { // from class: ir.nasim.hC7
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return C16401lC7.Y0(view, motionEvent);
            }
        });
    }

    /* renamed from: ir.nasim.lC7$b */
    public static final class b implements InterfaceC8091Um2 {
        final /* synthetic */ SA2 b;

        b(SA2 sa2) {
            this.b = sa2;
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            AvatarViewGlide avatarViewGlide = C16401lC7.this.w.e;
            C16401lC7 c16401lC7 = C16401lC7.this;
            AbstractC13042fc3.f(avatarViewGlide);
            c16401lC7.Z0(avatarViewGlide, interfaceC3346Am2.getDescriptor());
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void e() {
            InterfaceC7857Tm2 interfaceC7857Tm2 = C16401lC7.this.z;
            if (interfaceC7857Tm2 != null) {
                interfaceC7857Tm2.b();
            }
            C16401lC7.this.z = null;
            SA2 sa2 = this.b;
            if (sa2 != null) {
                sa2.invoke();
            }
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void c(float f) {
        }
    }
}
