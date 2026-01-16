package ir.nasim.features.conversation;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC14869id0;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.BC5;
import ir.nasim.C11458d25;
import ir.nasim.C14733iO2;
import ir.nasim.C21231tK7;
import ir.nasim.C6011Lu2;
import ir.nasim.KB5;
import ir.nasim.designsystem.avatar.AvatarViewGlide;
import ir.nasim.features.conversation.b;

/* loaded from: classes5.dex */
public class a extends RecyclerView.C {
    private AvatarViewGlide u;
    private TextView v;
    private b.a w;

    public a(View view, b.a aVar) {
        super(view);
        this.w = aVar;
    }

    private void E0(ImageView imageView, RelativeLayout relativeLayout) {
        imageView.setVisibility(0);
        relativeLayout.setBackgroundResource(KB5.ba_bg_check_forward_icon);
    }

    private void J0(View view, AbstractC14869id0 abstractC14869id0) {
        final ImageView imageView = (ImageView) view.findViewById(BC5.selected_icon);
        final RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(BC5.relative_layout);
        final C11458d25 c11458d25O0 = O0(abstractC14869id0);
        T0(abstractC14869id0, view);
        W0(abstractC14869id0, view);
        N0(c11458d25O0, imageView, relativeLayout);
        view.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Ib
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.Q0(c11458d25O0, imageView, relativeLayout, view2);
            }
        });
    }

    private void L0(View view) {
        final C11458d25 c11458d25E = C11458d25.E(AbstractC5969Lp4.f());
        final ImageView imageView = (ImageView) view.findViewById(BC5.selected_icon);
        final RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(BC5.relative_layout);
        U0(view);
        V0(view);
        N0(c11458d25E, imageView, relativeLayout);
        view.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Hb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.S0(c11458d25E, imageView, relativeLayout, view2);
            }
        });
    }

    private void M0(ImageView imageView, RelativeLayout relativeLayout) {
        imageView.setVisibility(8);
        relativeLayout.setBackground(null);
    }

    private void N0(C11458d25 c11458d25, ImageView imageView, RelativeLayout relativeLayout) {
        if (this.w.c(c11458d25)) {
            E0(imageView, relativeLayout);
        } else {
            M0(imageView, relativeLayout);
        }
    }

    private C11458d25 O0(AbstractC14869id0 abstractC14869id0) {
        if (abstractC14869id0 instanceof C21231tK7) {
            return C11458d25.E(((C21231tK7) abstractC14869id0).o());
        }
        if (abstractC14869id0 instanceof C14733iO2) {
            return C11458d25.y(((C14733iO2) abstractC14869id0).r());
        }
        return null;
    }

    private void P0(C11458d25 c11458d25, ImageView imageView, RelativeLayout relativeLayout) {
        if (imageView.getVisibility() != 8) {
            M0(imageView, relativeLayout);
            this.w.d(c11458d25);
        } else if (this.w.e(c11458d25)) {
            E0(imageView, relativeLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q0(C11458d25 c11458d25, ImageView imageView, RelativeLayout relativeLayout, View view) {
        P0(c11458d25, imageView, relativeLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S0(C11458d25 c11458d25, ImageView imageView, RelativeLayout relativeLayout, View view) {
        P0(c11458d25, imageView, relativeLayout);
    }

    private void T0(AbstractC14869id0 abstractC14869id0, View view) {
        AvatarViewGlide avatarViewGlide = (AvatarViewGlide) view.findViewById(BC5.avatar_view);
        this.u = avatarViewGlide;
        avatarViewGlide.B(18.0f, true);
        if (abstractC14869id0 instanceof C21231tK7) {
            this.u.r((C21231tK7) abstractC14869id0);
        } else if (abstractC14869id0 instanceof C14733iO2) {
            this.u.q((C14733iO2) abstractC14869id0);
        }
    }

    private void U0(View view) {
        AvatarViewGlide avatarViewGlide = (AvatarViewGlide) view.findViewById(BC5.avatar_view);
        this.u = avatarViewGlide;
        avatarViewGlide.B(18.0f, true);
        this.u.D();
        this.u.setImageResource(KB5.ic_saved_message);
    }

    private void V0(View view) {
        TextView textView = (TextView) view.findViewById(BC5.dialog_name);
        this.v = textView;
        textView.setMaxLines(2);
        this.v.setEllipsize(TextUtils.TruncateAt.END);
        this.v.setTypeface(C6011Lu2.k());
        this.v.setText(AbstractC12217eE5.settings_saved_messages);
        this.v.setGravity(49);
        this.v.setCompoundDrawables(null, null, null, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void W0(ir.nasim.AbstractC14869id0 r5, android.view.View r6) {
        /*
            r4 = this;
            int r0 = ir.nasim.BC5.dialog_name
            android.view.View r6 = r6.findViewById(r0)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r4.v = r6
            r0 = 2
            r6.setMaxLines(r0)
            android.widget.TextView r6 = r4.v
            android.text.TextUtils$TruncateAt r0 = android.text.TextUtils.TruncateAt.END
            r6.setEllipsize(r0)
            android.widget.TextView r6 = r4.v
            android.graphics.Typeface r0 = ir.nasim.C6011Lu2.k()
            r6.setTypeface(r0)
            boolean r6 = r5 instanceof ir.nasim.C21231tK7
            r0 = 0
            r1 = 49
            if (r6 == 0) goto L59
            android.widget.TextView r6 = r4.v
            ir.nasim.tK7 r5 = (ir.nasim.C21231tK7) r5
            ir.nasim.bZ6 r2 = r5.r()
            java.lang.Object r2 = r2.b()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r6.setText(r2)
            ir.nasim.O92 r5 = r5.x()
            java.lang.Object r5 = r5.b()
            ir.nasim.features.mxp.entity.a r5 = (ir.nasim.features.mxp.entity.a) r5
            if (r5 == 0) goto L6e
            boolean r6 = r5.s()
            if (r6 == 0) goto L6e
            android.view.View r6 = r4.a
            android.content.Context r6 = r6.getContext()
            int r5 = r5.p()
            android.graphics.drawable.Drawable r5 = ir.nasim.AbstractC4043Dl1.f(r6, r5)
            r1 = 17
            goto L6f
        L59:
            boolean r6 = r5 instanceof ir.nasim.C14733iO2
            if (r6 == 0) goto L6e
            android.widget.TextView r6 = r4.v
            ir.nasim.iO2 r5 = (ir.nasim.C14733iO2) r5
            ir.nasim.bZ6 r5 = r5.v()
            java.lang.Object r5 = r5.b()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r6.setText(r5)
        L6e:
            r5 = r0
        L6f:
            if (r5 == 0) goto L7f
            r6 = 1101004800(0x41a00000, float:20.0)
            int r2 = ir.nasim.C22078ud6.a(r6)
            int r6 = ir.nasim.C22078ud6.a(r6)
            r3 = 0
            r5.setBounds(r3, r3, r2, r6)
        L7f:
            android.widget.TextView r6 = r4.v
            r6.setGravity(r1)
            boolean r6 = ir.nasim.JF5.g()
            if (r6 == 0) goto L90
            android.widget.TextView r6 = r4.v
            r6.setCompoundDrawables(r0, r0, r5, r0)
            goto L95
        L90:
            android.widget.TextView r6 = r4.v
            r6.setCompoundDrawables(r5, r0, r0, r0)
        L95:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.conversation.a.W0(ir.nasim.id0, android.view.View):void");
    }

    void F0(a aVar, AbstractC14869id0 abstractC14869id0) {
        J0(aVar.a, abstractC14869id0);
    }

    public void H0(a aVar) {
        L0(aVar.a);
    }
}
