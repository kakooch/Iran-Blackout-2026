package ir.nasim;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.designsystem.avatar.AvatarViewGlide;

/* renamed from: ir.nasim.dh1, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C11869dh1 extends RecyclerView.C {
    private final C16854ly6 u;
    private final UA2 v;
    private InterfaceC20315ro1 w;
    private final UA2 x;
    private C3512Be1 y;

    /* renamed from: ir.nasim.dh1$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C11869dh1.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            String strY;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C14375ho5 c14375ho5N = AbstractC5969Lp4.e().N();
                long jR = C11869dh1.this.y != null ? r1.r() : 0L;
                this.b = 1;
                obj = c14375ho5N.E(jR, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            PI7 pi7 = (PI7) obj;
            TextView textView = C11869dh1.this.u.e;
            if (pi7 == null) {
                strY = "";
            } else {
                Context context = C11869dh1.this.u.getRoot().getContext();
                AbstractC13042fc3.h(context, "getContext(...)");
                strY = C14593iA1.y(context, pi7, false, 4, null);
            }
            textView.setText(strY);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11869dh1(C16854ly6 c16854ly6, UA2 ua2) {
        super(c16854ly6.getRoot());
        AbstractC13042fc3.i(c16854ly6, "binding");
        AbstractC13042fc3.i(ua2, "onContactClick");
        this.u = c16854ly6;
        this.v = ua2;
        this.w = AbstractC20906so1.a(C12366eV1.c());
        this.x = new UA2() { // from class: ir.nasim.bh1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C11869dh1.L0(this.a, (C3512Be1) obj);
            }
        };
        c16854ly6.d.setTypeface(C6011Lu2.k());
        c16854ly6.e.setTypeface(C6011Lu2.k());
        c16854ly6.b.B(18.0f, true);
        c16854ly6.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ch1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C11869dh1.E0(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(C11869dh1 c11869dh1, View view) {
        AbstractC13042fc3.i(c11869dh1, "this$0");
        C3512Be1 c3512Be1 = c11869dh1.y;
        if (c3512Be1 != null) {
            c11869dh1.x.invoke(c3512Be1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 L0(C11869dh1 c11869dh1, C3512Be1 c3512Be1) {
        AbstractC13042fc3.i(c11869dh1, "this$0");
        AbstractC13042fc3.i(c3512Be1, "item");
        c11869dh1.v.invoke(c3512Be1);
        return C19938rB7.a;
    }

    public final void J0(C3512Be1 c3512Be1) {
        this.y = c3512Be1;
        if (c3512Be1 != null) {
            this.u.d.setText(c3512Be1.getName());
            if (c3512Be1.q() != null) {
                AvatarViewGlide.v(this.u.b, c3512Be1.q(), c3512Be1.getName(), c3512Be1.r(), false, null, 16, null);
            } else {
                AvatarViewGlide avatarViewGlide = this.u.b;
                String name = c3512Be1.getName();
                AbstractC13042fc3.h(name, "getName(...)");
                avatarViewGlide.setImageBitmap(C16670lg0.g(name, c3512Be1.r(), AbstractC8943Xx1.c(44), AbstractC8943Xx1.c(44)));
            }
            AbstractC10533bm0.d(this.w, null, null, new a(null), 3, null);
        }
    }

    public final void a() {
        this.u.b.D();
        AbstractC20267rj3.j(this.w.getCoroutineContext(), null, 1, null);
    }
}
