package ir.nasim;

import android.content.Context;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.j;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.PI7;
import ir.nasim.designsystem.avatar.AvatarViewGlide;
import ir.nasim.features.payment.view.activity.CardPaymentActivity;

/* renamed from: ir.nasim.df1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C11849df1 extends AbstractC22092uf0 implements InterfaceC21596to4, InterfaceC18633oz3 {
    private TextView A;
    androidx.lifecycle.p A0;
    private CheckBox B;
    private ImageView D;
    private final FrameLayout G;
    private final boolean H;
    private final InterfaceC22483vJ4 J;
    private final View Y;
    private final Context Z;
    private ImageView w;
    private AvatarViewGlide x;
    private TextView y;
    private TextView z;
    private int z0;

    public C11849df1(FrameLayout frameLayout, boolean z, Context context, InterfaceC22483vJ4 interfaceC22483vJ4, boolean z2) {
        super(frameLayout);
        androidx.lifecycle.p pVar = new androidx.lifecycle.p(this);
        this.A0 = pVar;
        pVar.i(j.a.ON_CREATE);
        this.Z = context;
        this.J = interfaceC22483vJ4;
        this.H = z;
        int iA = C22078ud6.a(16.0f);
        frameLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        frameLayout.setMinimumHeight(C22078ud6.a(56.0f));
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        frameLayout.setBackgroundColor(c5495Jo7.O0());
        FrameLayout frameLayout2 = new FrameLayout(context);
        this.G = frameLayout2;
        frameLayout2.setBackground(AbstractC4310Eo7.g());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        JF5.l(layoutParams, C22078ud6.a(0.0f));
        frameLayout.addView(frameLayout2, layoutParams);
        new View(context).setBackgroundColor(c5495Jo7.O0());
        RelativeLayout relativeLayout = new RelativeLayout(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(C22078ud6.a(44.0f), C22078ud6.a(44.0f));
        layoutParams2.gravity = 8388627;
        layoutParams2.gravity = JF5.g() ? 21 : 19;
        JF5.l(layoutParams2, C22078ud6.a(12.0f));
        layoutParams2.topMargin = C22078ud6.a(6.0f);
        layoutParams2.bottomMargin = C22078ud6.a(6.0f);
        relativeLayout.setLayoutParams(layoutParams2);
        AvatarViewGlide avatarViewGlide = new AvatarViewGlide(context);
        this.x = avatarViewGlide;
        avatarViewGlide.B(18.0f, true);
        this.x.setId(BC5.avatar_view);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(C22078ud6.a(44.0f), C22078ud6.a(44.0f));
        layoutParams3.gravity = 17;
        relativeLayout.addView(this.x, layoutParams3);
        this.w = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(C22078ud6.a(14.0f), C22078ud6.a(14.0f));
        layoutParams4.addRule(8, BC5.avatar_view);
        layoutParams4.addRule(19, BC5.avatar_view);
        this.w.setLayoutParams(layoutParams4);
        this.w.setVisibility(8);
        relativeLayout.addView(this.w);
        frameLayout2.addView(relativeLayout, layoutParams2);
        TextView textView = new TextView(context);
        this.A = textView;
        textView.setTextColor(c5495Jo7.t2());
        this.A.setTextSize(18.0f);
        this.A.setGravity(17);
        this.A.setTypeface(C6011Lu2.i());
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(C22078ud6.a(40.0f), -2);
        JF5.l(layoutParams5, C22078ud6.a(6.0f));
        layoutParams5.gravity = JF5.g() ? 21 : 19;
        frameLayout.addView(this.A, layoutParams5);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(48);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams6.gravity = JF5.g() ? 21 : 19;
        layoutParams6.topMargin = C22078ud6.a(5.0f);
        layoutParams6.bottomMargin = C22078ud6.a(5.0f);
        frameLayout2.addView(linearLayout, layoutParams6);
        TextView textView2 = new TextView(context);
        this.y = textView2;
        textView2.setTextColor(c5495Jo7.g1());
        JF5.n(this.y, C22078ud6.a(62.0f), C22078ud6.a(-2.0f), (z ? C22078ud6.a(64.0f) : 0) + C22078ud6.a(8.0f), 0);
        this.y.setTextSize(2, 15.0f);
        this.y.setSingleLine(true);
        TextView textView3 = this.y;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView3.setEllipsize(truncateAt);
        this.y.setTypeface(C6011Lu2.k());
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams7.gravity = JF5.g() ? 53 : 51;
        linearLayout.addView(this.y, layoutParams7);
        TextView textView4 = new TextView(context);
        this.z = textView4;
        textView4.setTextColor(c5495Jo7.f1());
        JF5.n(this.z, C22078ud6.a(64.0f), 0, (z ? C22078ud6.a(64.0f) : 0) + C22078ud6.a(8.0f), 0);
        this.z.setTextSize(2, 13.0f);
        this.z.setSingleLine(true);
        this.z.setEllipsize(truncateAt);
        this.z.setTypeface(C6011Lu2.k());
        this.z.setIncludeFontPadding(false);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams8.gravity = JF5.g() ? 53 : 51;
        linearLayout.addView(this.z, layoutParams8);
        if (z) {
            CheckBox checkBox = new CheckBox(context);
            this.B = checkBox;
            checkBox.setClickable(false);
            this.B.setFocusable(false);
            FrameLayout.LayoutParams layoutParams9 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams9.gravity = JF5.g() ? 19 : 21;
            JF5.m(layoutParams9, iA);
            frameLayout2.addView(this.B, layoutParams9);
        } else if (z2) {
            W0(context);
            O0();
        }
        View view = new View(context);
        this.Y = view;
        view.setBackgroundColor(c5495Jo7.a1());
        FrameLayout.LayoutParams layoutParams10 = new FrameLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(AbstractC14008hB5.div_size));
        layoutParams10.gravity = 80;
        JF5.l(layoutParams10, C22078ud6.a(64.0f));
        frameLayout2.addView(view, layoutParams10);
    }

    private void H0() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = JF5.g() ? 19 : 21;
        layoutParams.width = C22078ud6.a(38.0f);
        layoutParams.height = C22078ud6.a(38.0f);
        JF5.m(layoutParams, C22078ud6.a(12.0f));
        this.G.addView(this.D, layoutParams);
    }

    private void L0(PI7 pi7) {
        String strW = C14593iA1.w(this.z.getContext(), pi7);
        if (pi7.u().equals(PI7.a.ONLINE)) {
            this.z.setTextColor(C5495Jo7.a.e2());
            this.w.setImageResource(KB5.ic_online_circle);
        } else {
            this.z.setTextColor(C5495Jo7.a.n0());
            this.w.setImageResource(KB5.ic_online_circle_gray);
        }
        this.z.setText(strW);
    }

    private void M0(final Context context) {
        ImageView imageView = new ImageView(context);
        this.D = imageView;
        imageView.setImageDrawable(AbstractC4043Dl1.f(context, KB5.ba_sendmony_1));
        ImageView imageView2 = this.D;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        imageView2.setColorFilter(c5495Jo7.S0(), PorterDuff.Mode.SRC_IN);
        this.D.setBackground(AbstractC4310Eo7.f(C22078ud6.a(46.0f), c5495Jo7.Q0(), c5495Jo7.R0()));
        this.D.setPadding(C22078ud6.a(6.0f), C22078ud6.a(6.0f), C22078ud6.a(6.0f), C22078ud6.a(6.0f));
        this.D.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.cf1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.U0(context, view);
            }
        });
    }

    private void N0(boolean z) {
        if (z) {
            O0();
        } else {
            Y0();
        }
    }

    private void O0() {
        ImageView imageView = this.D;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q0(C3512Be1 c3512Be1, View view) {
        this.J.e(c3512Be1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean S0(C3512Be1 c3512Be1, View view) {
        return this.J.v(c3512Be1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C19938rB7 T0(PI7 pi7) {
        if (pi7 != null) {
            this.w.setVisibility(0);
            L0(pi7);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U0(Context context, View view) {
        X0(context);
    }

    private void V0() {
        this.z.setText(this.Z.getString(AbstractC12217eE5.members_adapter_bot_online_status));
        this.z.setTextColor(C5495Jo7.a.n0());
        this.w.setVisibility(8);
    }

    private void W0(Context context) {
        M0(context);
        H0();
    }

    private void X0(Context context) {
        CardPaymentActivity.INSTANCE.i(context, this.z0);
        C3343Am.g("c2c_open_from_contacts");
    }

    private void Y0() {
        ImageView imageView = this.D;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    public void J0(final C3512Be1 c3512Be1, String str, String str2, boolean z, boolean z2, boolean z3) {
        CheckBox checkBox;
        if (z3) {
            this.G.setClickable(false);
            this.G.setEnabled(false);
            this.y.setTextColor(C5495Jo7.a.m0());
            this.x.setAlpha(127);
            this.z.setAlpha(0.5f);
        } else {
            this.G.setClickable(true);
            this.G.setEnabled(true);
            this.y.setTextColor(C5495Jo7.a.g0());
            this.x.setAlpha(255);
            this.z.setAlpha(1.0f);
        }
        if (this.H && (checkBox = this.B) != null) {
            checkBox.setEnabled(!z3);
        }
        if (str == null) {
            this.A.setVisibility(8);
        } else {
            this.A.setVisibility(8);
            this.A.setText(str);
        }
        this.x.o(c3512Be1);
        if (str2.length() > 0) {
            this.y.setText(C18449og6.d(c3512Be1.getName(), str2, C5495Jo7.a.t2()));
        } else {
            this.y.setText(R62.S(c3512Be1.getName(), this.y.getPaint().getFontMetricsInt(), AbstractC7426Rr.z(14.0f), false));
        }
        this.z0 = c3512Be1.r();
        if (this.H) {
            this.B.setChecked(z);
        }
        this.G.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Ze1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Q0(c3512Be1, view);
            }
        });
        this.G.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.nasim.af1
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.a.S0(c3512Be1, view);
            }
        });
        if (z2) {
            this.Y.setVisibility(8);
        } else {
            this.Y.setVisibility(0);
        }
        if (c3512Be1.s()) {
            V0();
        } else {
            AbstractC5969Lp4.d().e0().C(this.A0, c3512Be1.r(), new UA2() { // from class: ir.nasim.bf1
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return this.a.T0((PI7) obj);
                }
            });
        }
        N0(c3512Be1.s());
    }

    public void P0() {
        TextView textView = this.y;
        if (textView != null) {
            textView.invalidate();
        }
    }

    public void a() {
        this.x.D();
        TextView textView = this.z;
        if (textView != null) {
            textView.setText("");
        }
        ImageView imageView = this.w;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    @Override // ir.nasim.InterfaceC18633oz3
    public androidx.lifecycle.j getLifecycle() {
        return this.A0;
    }
}
