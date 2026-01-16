package ir.nasim;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.textview.MaterialTextView;
import ir.nasim.C20919sp4;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.designsystem.TintImageView;
import ir.nasim.features.story.avatarwithstory.DialogHolderAvatarWithStory;
import java.text.Bidi;
import java.util.HashMap;
import java.util.concurrent.CancellationException;

/* renamed from: ir.nasim.sN1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C20649sN1 extends AbstractC22092uf0 implements InterfaceC24886zN1 {
    private ConstraintLayout A;
    private TextView A0;
    private LinearLayout B;
    private MaterialTextView B0;
    private TextView C0;
    private FrameLayout D;
    private TextView D0;
    private TintImageView E0;
    protected TextView F0;
    private CheckBox G;
    private ImageView G0;
    private final Context H;
    private View H0;
    private C17067mL1 I0;
    private DialogHolderAvatarWithStory J;
    private C24292yN1 J0;
    private AJ4 K0;
    private boolean L0;
    private final Drawable M0;
    private final Drawable N0;
    private C22042ua0 O0;
    private BN1 P0;
    private final int Q0;
    int R0;
    private int S0;
    private View T0;
    private C20919sp4.b U0;
    private boolean V0;
    private InterfaceC13730gj3 W0;
    private long X0;
    private ImageView Y;
    public Boolean Y0;
    private ImageView Z;
    private LinearLayout w;
    private Guideline x;
    private Guideline y;
    private ImageView z;
    private LottieAnimationView z0;

    /* renamed from: ir.nasim.sN1$a */
    class a extends HashMap {
        a() {
            put("back_stage", 1);
        }
    }

    /* renamed from: ir.nasim.sN1$b */
    class b extends ImageSpan {
        b(Drawable drawable, int i) {
            super(drawable, i);
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
            Drawable drawable = getDrawable();
            canvas.save();
            int iE = C5161Id6.e(2.0f);
            if (!JF5.j(C20649sN1.this.A0.getText().toString())) {
                iE = C5161Id6.e(3.0f);
            }
            int intrinsicHeight = drawable.getIntrinsicHeight();
            canvas.translate(f, ((i5 - drawable.getBounds().bottom) + (((intrinsicHeight - paint.getFontMetricsInt().descent) + paint.getFontMetricsInt().ascent) / 2)) - iE);
            drawable.draw(canvas);
            canvas.restore();
        }
    }

    /* renamed from: ir.nasim.sN1$c */
    static /* synthetic */ class c {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ExPeerType.values().length];
            a = iArr;
            try {
                iArr[ExPeerType.GROUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ExPeerType.BOT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ExPeerType.CHANNEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public C20649sN1(Context context, FrameLayout frameLayout, final InterfaceC22483vJ4 interfaceC22483vJ4, C22042ua0 c22042ua0) {
        super(frameLayout);
        this.L0 = false;
        this.Q0 = 2;
        this.R0 = C22078ud6.a(74.0f);
        this.S0 = C22078ud6.a(24.0f);
        this.Y0 = null;
        this.J0 = new C24292yN1(this);
        ConstraintLayout constraintLayout = new ConstraintLayout(context);
        this.A = constraintLayout;
        constraintLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(context);
        this.D = frameLayout2;
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(0, -1));
        AN1 an1A = CN1.a.a();
        this.P0 = an1A;
        this.H = context;
        this.O0 = c22042ua0;
        this.M0 = an1A.e();
        this.N0 = this.P0.d();
        frameLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        frameLayout.setMinimumHeight(C22078ud6.a(72.0f));
        FrameLayout frameLayout3 = new FrameLayout(context);
        frameLayout3.setBackground(AbstractC4310Eo7.g());
        frameLayout.addView(frameLayout3, new FrameLayout.LayoutParams(-1, -1));
        int iA = C22078ud6.a(Avatar.ImageSize + 2);
        FrameLayout frameLayout4 = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA, iA);
        layoutParams.gravity = 8388627;
        JF5.l(layoutParams, C22078ud6.a(8.0f));
        frameLayout4.setLayoutParams(layoutParams);
        Q0(frameLayout4);
        this.Y = new ImageView(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(C22078ud6.a(14.0f), C22078ud6.a(14.0f));
        layoutParams2.gravity = 8388693;
        this.Y.setLayoutParams(layoutParams2);
        N0();
        frameLayout4.addView(this.Y);
        this.Y.setImageResource(KB5.ic_online_circle);
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context);
        this.z0 = lottieAnimationView;
        lottieAnimationView.setScaleX(2.0f);
        this.z0.setScaleY(2.0f);
        this.Z = new ImageView(context);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(C22078ud6.a(16.0f), C22078ud6.a(16.0f));
        layoutParams3.gravity = 8388693;
        this.Z.setLayoutParams(layoutParams3);
        O0();
        frameLayout4.addView(this.Z);
        this.Z.setImageResource(KB5.ic_live_badge);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(C22078ud6.a(19.0f), C22078ud6.a(19.0f));
        layoutParams4.gravity = 8388693;
        this.z0.setLayoutParams(layoutParams4);
        P0();
        frameLayout4.addView(this.z0);
        this.D.addView(frameLayout4);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(48);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-1, -2);
        JF5.m(layoutParams5, 0);
        JF5.l(layoutParams5, this.R0);
        layoutParams5.topMargin = C22078ud6.a(8.0f);
        layoutParams5.bottomMargin = C22078ud6.a(8.0f);
        layoutParams5.gravity = 16;
        linearLayout.setLayoutParams(layoutParams5);
        new ConstraintLayout(context);
        new LinearLayout(context);
        ConstraintLayout constraintLayout2 = new ConstraintLayout(context);
        constraintLayout2.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -2));
        TextView textView = new TextView(context);
        this.A0 = textView;
        textView.setId(View.generateViewId());
        int i = JF5.g() ? 5 : 3;
        this.A0.setGravity(i);
        this.A0.setTextDirection(2);
        TextView textView2 = this.A0;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        textView2.setTextColor(c5495Jo7.g1());
        this.A0.setTypeface(C6011Lu2.k());
        this.A0.setTextSize(2, 16.0f);
        i1(this.A0);
        this.A0.setCompoundDrawablePadding(C22078ud6.a(4.0f));
        JF5.n(this.A0, 0, C22078ud6.a(-4.0f), 0, 0);
        TextView textView3 = this.A0;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView3.setEllipsize(truncateAt);
        ImageView imageView = new ImageView(context);
        this.z = imageView;
        imageView.setId(View.generateViewId());
        this.z.setImageResource(KB5.ic_mute);
        ImageView imageView2 = this.z;
        int iC = AbstractC4043Dl1.c(context, TA5.color8);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        imageView2.setColorFilter(iC, mode);
        this.z.setVisibility(4);
        TextView textView4 = new TextView(context);
        this.C0 = textView4;
        textView4.setId(View.generateViewId());
        this.C0.setTextColor(c5495Jo7.f1());
        this.C0.setTypeface(C6011Lu2.k());
        this.C0.setIncludeFontPadding(false);
        this.C0.setTextSize(2, 13.0f);
        i1(this.C0);
        ConstraintLayout.LayoutParams layoutParams6 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams6.h = 0;
        layoutParams6.k = 0;
        layoutParams6.s = 0;
        layoutParams6.t = this.z.getId();
        layoutParams6.Z = true;
        layoutParams6.F = 0.0f;
        this.A0.setLayoutParams(layoutParams6);
        constraintLayout2.addView(this.A0);
        ConstraintLayout.LayoutParams layoutParams7 = new ConstraintLayout.LayoutParams(C22078ud6.a(16.0f), C22078ud6.a(16.0f));
        layoutParams7.h = 0;
        layoutParams7.k = 0;
        layoutParams7.r = this.A0.getId();
        layoutParams7.t = this.C0.getId();
        layoutParams7.setMargins(C22078ud6.a(8.0f), 0, C22078ud6.a(8.0f), 0);
        this.z.setLayoutParams(layoutParams7);
        constraintLayout2.addView(this.z);
        ConstraintLayout.LayoutParams layoutParams8 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams8.h = 0;
        layoutParams8.k = 0;
        layoutParams8.u = 0;
        layoutParams8.setMargins(C22078ud6.a(12.0f), -C22078ud6.a(4.0f), C22078ud6.a(12.0f), 0);
        this.C0.setLayoutParams(layoutParams8);
        constraintLayout2.addView(this.C0);
        androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
        cVar.p(constraintLayout2);
        cVar.V(this.A0.getId(), 2);
        cVar.U(this.A0.getId(), 0.0f);
        cVar.i(constraintLayout2);
        linearLayout.addView(constraintLayout2);
        LinearLayout linearLayout2 = new LinearLayout(context);
        this.w = linearLayout2;
        linearLayout2.setOrientation(0);
        this.w.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        TextView textView5 = new TextView(context);
        this.D0 = textView5;
        textView5.setTypeface(C6011Lu2.k());
        this.D0.setTextColor(c5495Jo7.B0());
        this.D0.setTextSize(2, 15.0f);
        JF5.n(this.D0, 0, 0, C22078ud6.a(4.0f), 0);
        i1(this.D0);
        this.D0.setEllipsize(truncateAt);
        int i2 = 48 | i;
        this.D0.setGravity(i2);
        this.D0.setTextDirection(2);
        this.D0.setVisibility(8);
        this.w.addView(this.D0);
        MaterialTextView materialTextView = new MaterialTextView(context);
        this.B0 = materialTextView;
        materialTextView.setTypeface(C6011Lu2.k());
        this.B0.setTextColor(c5495Jo7.f1());
        this.B0.setTextSize(2, 15.0f);
        i1(this.B0);
        this.B0.setEllipsize(truncateAt);
        this.B0.setGravity(i2);
        this.B0.setTextDirection(2);
        this.w.addView(this.B0);
        this.B0.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        linearLayout.addView(this.w);
        this.D.addView(linearLayout);
        View view = new View(context);
        this.T0 = view;
        view.setTag("dialog_holder_full_separator");
        this.T0.setBackground(AbstractC4043Dl1.f(context, KB5.special_channel_dialog_shadow));
        View view2 = new View(context);
        this.H0 = view2;
        view2.setTag("dialog_holder_separator");
        this.H0.setBackgroundColor(c5495Jo7.a1());
        FrameLayout.LayoutParams layoutParams9 = new FrameLayout.LayoutParams(-1, context.getResources().getDimensionPixelSize(AbstractC14008hB5.div_size));
        JF5.l(layoutParams9, this.R0);
        layoutParams9.gravity = 80;
        this.D.addView(this.H0, layoutParams9);
        this.E0 = new TintImageView(context);
        e1(JF5.g() ? 83 : 85);
        this.D.addView(this.E0);
        Z0(context);
        int i3 = JF5.g() ? 83 : 85;
        FrameLayout.LayoutParams layoutParams10 = new FrameLayout.LayoutParams(-2, -2, i3);
        layoutParams10.bottomMargin = C22078ud6.a(13.0f);
        JF5.m(layoutParams10, C22078ud6.a(13.0f));
        this.F0.setLayoutParams(layoutParams10);
        this.D.addView(this.F0);
        ImageView imageView3 = new ImageView(context);
        this.G0 = imageView3;
        imageView3.setImageResource(KB5.pin);
        this.G0.setColorFilter(AbstractC4043Dl1.c(context, TA5.color8), mode);
        FrameLayout.LayoutParams layoutParams11 = new FrameLayout.LayoutParams(C22078ud6.a(18.0f), C22078ud6.a(18.0f), i3);
        layoutParams11.bottomMargin = C22078ud6.a(13.0f);
        JF5.m(layoutParams11, C22078ud6.a(16.0f));
        this.G0.setLayoutParams(layoutParams11);
        this.G0.setVisibility(8);
        this.D.addView(this.G0);
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.qN1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                this.a.W0(interfaceC22483vJ4, view3);
            }
        });
        frameLayout.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.nasim.rN1
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view3) {
                return this.a.X0(interfaceC22483vJ4, view3);
            }
        });
        this.B = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(0, C22078ud6.a(48.0f));
        this.B.setGravity(17);
        this.B.setLayoutParams(layoutParams12);
        this.B.setId(View.generateViewId());
        CheckBox checkBox = new CheckBox(context);
        this.G = checkBox;
        checkBox.setButtonDrawable(KB5.dialog_holder_checkbox);
        this.G.setClickable(false);
        this.G.setBackgroundColor(0);
        this.B.addView(this.G);
        this.B.setVisibility(0);
        this.A.addView(this.B);
        Guideline guideline = new Guideline(context);
        this.x = guideline;
        guideline.setId(View.generateViewId());
        ConstraintLayout.LayoutParams layoutParams13 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams13.Y = 1;
        layoutParams13.a = 0;
        this.x.setLayoutParams(layoutParams13);
        Guideline guideline2 = new Guideline(context);
        this.y = guideline2;
        guideline2.setId(View.generateViewId());
        ConstraintLayout.LayoutParams layoutParams14 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams14.Y = 1;
        layoutParams14.a = C22078ud6.a(48.0f);
        this.y.setLayoutParams(layoutParams14);
        this.A.setId(View.generateViewId());
        this.D.setId(View.generateViewId());
        this.x.setId(View.generateViewId());
        this.y.setId(View.generateViewId());
        this.A.addView(this.x);
        this.A.addView(this.y);
        this.A.addView(this.D);
        frameLayout.addView(this.A);
        androidx.constraintlayout.widget.c cVar2 = new androidx.constraintlayout.widget.c();
        cVar2.p(this.A);
        cVar2.t(this.B.getId(), 7, this.x.getId(), 6, 0);
        cVar2.t(this.B.getId(), 6, 0, 6, 0);
        cVar2.t(this.B.getId(), 3, 0, 3, 0);
        cVar2.t(this.B.getId(), 4, 0, 4, 0);
        cVar2.t(this.D.getId(), 7, 0, 7, 0);
        cVar2.t(this.D.getId(), 6, this.x.getId(), 7, 0);
        cVar2.i(this.A);
        this.V0 = AbstractC5969Lp4.d().w0(EnumC4196Ec1.C0);
    }

    private void J0(Boolean bool) {
        if (bool.booleanValue()) {
            j1();
        } else {
            N0();
        }
    }

    private void L0() {
        this.u.setBackgroundColor(C5495Jo7.a.O0());
        a1();
        if (this.v.findViewWithTag("dialog_holder_full_separator") != null) {
            this.v.removeView(this.T0);
        }
        if (this.v.findViewWithTag("dialog_holder_separator") == null) {
            this.v.addView(this.H0);
        }
    }

    private boolean M0(C17067mL1 c17067mL1) {
        return (c17067mL1.K() == null || c17067mL1.K().isEmpty()) ? false : true;
    }

    private void Q0(FrameLayout frameLayout) {
        DialogHolderAvatarWithStory dialogHolderAvatarWithStory = new DialogHolderAvatarWithStory(this.O0);
        this.J = dialogHolderAvatarWithStory;
        dialogHolderAvatarWithStory.setId(BC5.avatar_view);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        frameLayout.addView(this.J, layoutParams);
    }

    private boolean T0(C17067mL1 c17067mL1) {
        return (c17067mL1.Q().F() instanceof LC3) && !((LC3) c17067mL1.Q().F()).s().v().isEmpty();
    }

    private boolean U0() {
        return (JF5.g() && (new Bidi(this.A0.getText().toString(), -1).isMixed() || new Bidi(this.A0.getText().toString(), -1).isRightToLeft())) || (!JF5.g() && new Bidi(this.A0.getText().toString(), -2).isLeftToRight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C19938rB7 V0(Boolean bool, Long l) {
        if (l.longValue() == this.X0) {
            J0(bool);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W0(InterfaceC22483vJ4 interfaceC22483vJ4, View view) {
        C17067mL1 c17067mL1 = this.I0;
        if (c17067mL1 != null) {
            if (c17067mL1.R().getPeerId() == 270066638) {
                C3343Am.i("sapta_page", new a());
            }
            interfaceC22483vJ4.e(this.I0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean X0(InterfaceC22483vJ4 interfaceC22483vJ4, View view) {
        C17067mL1 c17067mL1 = this.I0;
        if (c17067mL1 != null) {
            return interfaceC22483vJ4.v(c17067mL1);
        }
        return false;
    }

    private void Z0(Context context) {
        TextView textView = new TextView(context);
        this.F0 = textView;
        JF5.n(textView, C22078ud6.a(this.P0.g(SS4.a)), C22078ud6.a(this.P0.g(SS4.b)), C22078ud6.a(this.P0.g(SS4.c)), C22078ud6.a(this.P0.g(SS4.d)));
        this.F0.setMinWidth(C22078ud6.a(this.P0.c()));
        this.F0.setTypeface(this.P0.j());
        this.F0.setTextSize(2, 13.0f);
        this.F0.setGravity(17);
        this.F0.setIncludeFontPadding(false);
        this.F0.setMinHeight(C22078ud6.a(20.0f));
    }

    private void a1() {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) this.v.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).height = C22078ud6.a(72.0f);
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = C22078ud6.a(0.0f);
        this.v.setLayoutParams(layoutParams);
    }

    private void c1() {
        this.u.setBackgroundColor(C5495Jo7.a.e1());
    }

    private void d1(C17067mL1 c17067mL1) {
        String string;
        boolean z = c17067mL1.Q().U() == AbstractC5969Lp4.f();
        int i = !this.J0.m(c17067mL1) ? AbstractC12217eE5.dialogs_fragment_muted_dialog : AbstractC12217eE5.empty_text;
        int i2 = c17067mL1.g0() ? AbstractC12217eE5.all_message_state_seen_content_description : c17067mL1.h0() ? AbstractC12217eE5.empty_text : AbstractC12217eE5.all_message_state_not_seen_content_description;
        ExPeerType exPeerType = c17067mL1.getExPeerType();
        if (exPeerType == null) {
            return;
        }
        int i3 = c.a[exPeerType.ordinal()];
        int i4 = i3 != 1 ? i3 != 2 ? i3 != 3 ? AbstractC12217eE5.empty_text : AbstractC12217eE5.dialogs_fragment_channel_dialog_type : AbstractC12217eE5.dialogs_fragment_bot_dialog_type : AbstractC12217eE5.dialogs_fragment_group_dialog_type;
        if (c17067mL1.R().getPeerId() == AbstractC5969Lp4.f()) {
            string = this.H.getString(AbstractC12217eE5.dialogs_fragment_saved_messages_dialog_type);
        } else if (z) {
            Context context = this.H;
            string = context.getString(AbstractC12217eE5.dialogs_fragment_sent_messages_content_description, context.getString(i4), this.A0.getText(), this.H.getString(i), this.C0.getText(), this.H.getString(i2), this.B0.getText());
        } else {
            int i5 = c17067mL1.Y() == 0 ? AbstractC12217eE5.dialogs_fragment_recieved_messages_zero_content_description : AbstractC12217eE5.dialogs_fragment_recieved_messages_non_zero_content_description;
            Context context2 = this.H;
            string = context2.getString(i5, context2.getString(i4), this.A0.getText(), this.H.getString(i), c17067mL1.Y() == 0 ? "" : Integer.valueOf(c17067mL1.Y()), this.C0.getText(), this.B0.getText());
        }
        this.D.setContentDescription(string);
    }

    private void e1(int i) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(C22078ud6.a(28.0f), C22078ud6.a(12.0f), i);
        layoutParams.bottomMargin = C22078ud6.a(16.0f);
        JF5.m(layoutParams, C22078ud6.a(9.0f));
        this.E0.setLayoutParams(layoutParams);
    }

    private void f1(int i) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(C22078ud6.a(28.0f), C22078ud6.a(12.0f), i);
        layoutParams.bottomMargin = C22078ud6.a(16.0f);
        JF5.m(layoutParams, C22078ud6.a(38.0f));
        this.E0.setLayoutParams(layoutParams);
    }

    private void i1(TextView textView) {
        textView.setSingleLine();
        textView.setHorizontallyScrolling(false);
    }

    private void j1() {
        if (this.Y.getVisibility() != 0) {
            this.Y.setVisibility(0);
        }
    }

    private void l1() {
        if (this.Z.getVisibility() != 0) {
            this.Z.setVisibility(0);
        }
    }

    private void n1() {
        if (this.E0.getVisibility() == 0 && this.G0.getVisibility() == 0) {
            this.S0 = C22078ud6.a(76.0f);
        } else if (this.F0.getVisibility() == 0 || this.E0.getVisibility() == 0 || this.G0.getVisibility() == 0) {
            this.S0 = C22078ud6.a(48.0f);
        } else {
            this.S0 = C22078ud6.a(8.0f);
        }
    }

    @Override // ir.nasim.InterfaceC24886zN1
    public void G3() {
        TintImageView tintImageView = this.E0;
        if (tintImageView != null) {
            tintImageView.setVisibility(8);
        }
    }

    public void H0(C17067mL1 c17067mL1, boolean z, Boolean bool, Boolean bool2, AJ4 aj4) {
        Drawable c6214Mq7;
        Drawable drawableF;
        b bVar;
        boolean z2;
        this.K0 = aj4;
        this.X0 = c17067mL1.R().u();
        View view = this.u;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        view.setBackgroundColor(c5495Jo7.O0());
        this.I0 = c17067mL1;
        AbstractC17457n0 abstractC17457n0F = c17067mL1.Q().F();
        if (C8386Vt0.w7() && c17067mL1.P() != null) {
            this.J.setBackground(AbstractC4043Dl1.f(this.H, KB5.ic_live_stream_profile_border));
            l1();
        } else if (c17067mL1.R().s() == W25.b && this.V0 && c17067mL1.d0()) {
            this.z0.setAnimation(AbstractC19954rD5.group_call_enabled);
            this.z0.x();
            this.z0.setRepeatCount(-1);
            this.J.setBackground(AbstractC4043Dl1.f(this.H, KB5.ic_voice_call_profile_border_green));
            this.z0.setVisibility(0);
        } else {
            this.z0.clearAnimation();
            P0();
            this.J.setBackground(null);
            O0();
        }
        if (this.J0.m(c17067mL1)) {
            this.F0.setBackgroundDrawable(this.M0);
            this.F0.setTextColor(this.P0.h());
        } else {
            this.F0.setBackgroundDrawable(this.N0);
            this.F0.setTextColor(this.P0.f());
        }
        if (c17067mL1.e0()) {
            c1();
        } else {
            L0();
        }
        if (c17067mL1.R().getPeerId() == AbstractC5969Lp4.f()) {
            this.A0.setText(AbstractC12217eE5.saved_message_dialog_title);
            if (M0(c17067mL1)) {
                this.B0.setVisibility(0);
            } else {
                this.B0.setVisibility(8);
            }
            this.J.setImage(AbstractC4043Dl1.f(this.H, KB5.ic_saved_message));
        } else {
            this.J.h(c17067mL1);
            this.A0.setText(R62.S(c17067mL1.J(), this.A0.getPaint().getFontMetricsInt(), AbstractC7426Rr.z(14.0f), false));
            this.B0.setVisibility(0);
        }
        g1(c17067mL1);
        this.J0.i(c17067mL1);
        if (c17067mL1.R().s() == W25.b) {
            int i = KB5.ba_chat_group_item_icon;
            if (c17067mL1.getExPeerType() != null && c17067mL1.getExPeerType().equals(ExPeerType.CHANNEL)) {
                i = KB5.ba_chat_channel_icon;
            }
            c6214Mq7 = new C6214Mq7(AbstractC4043Dl1.f(this.H, i), c5495Jo7.g1());
        } else {
            c6214Mq7 = (c17067mL1.R().s() == W25.a && c17067mL1.getExPeerType() != null && c17067mL1.getExPeerType().equals(ExPeerType.BOT)) ? new C6214Mq7(AbstractC4043Dl1.f(this.H, KB5.ba_chat_bot_item_icon), c5495Jo7.g1()) : null;
        }
        if (C8386Vt0.a8() && c17067mL1.U() != null && c17067mL1.U().s()) {
            c6214Mq7 = AbstractC4043Dl1.f(this.H, c17067mL1.U().p());
        }
        if ((abstractC17457n0F instanceof C20360rs6) || (((z2 = abstractC17457n0F instanceof C18285oP1)) && ((C18285oP1) abstractC17457n0F).s() == EnumC18494ol1.SERVICE_CALL_ENDED)) {
            drawableF = AbstractC4043Dl1.f(this.H, KB5.video_call_dialogs);
            this.B0.setCompoundDrawablePadding(C22078ud6.a(4.0f));
        } else if ((abstractC17457n0F instanceof C5980Lq6) || (z2 && ((C18285oP1) abstractC17457n0F).s() == EnumC18494ol1.SERVICE_VIDEO_CALL_ENDED)) {
            drawableF = AbstractC4043Dl1.f(this.H, KB5.voice_call_dialogs);
            this.B0.setCompoundDrawablePadding(C22078ud6.a(4.0f));
        } else {
            drawableF = null;
        }
        Drawable drawableF2 = AbstractC4043Dl1.f(this.H, KB5.blue_tick);
        if (drawableF2 != null) {
            drawableF2.setBounds(0, 0, C22078ud6.a(21.0f), C22078ud6.a(21.0f));
            bVar = new b(drawableF2, 2);
        } else {
            bVar = null;
        }
        boolean z3 = (c17067mL1.S() == null || c17067mL1.S().equals(E25.INFORMAL)) ? false : true;
        if (U0()) {
            if (drawableF2 != null && z3) {
                SpannableString spannableString = new SpannableString("  " + ((Object) this.A0.getText()));
                spannableString.setSpan(bVar, 0, 1, 33);
                this.A0.setText(spannableString);
            }
        } else if (drawableF2 != null && z3) {
            SpannableString spannableString2 = new SpannableString(((Object) this.A0.getText()) + "  ");
            spannableString2.setSpan(bVar, this.A0.getText().length() + 1, this.A0.getText().length() + 2, 33);
            this.A0.setText(spannableString2);
        }
        if (JF5.g()) {
            this.B0.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawableF, (Drawable) null);
            this.A0.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, c6214Mq7, (Drawable) null);
        } else {
            this.B0.setCompoundDrawablesWithIntrinsicBounds(drawableF, (Drawable) null, (Drawable) null, (Drawable) null);
            this.A0.setCompoundDrawablesWithIntrinsicBounds(c6214Mq7, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.J0.l(this.H, c17067mL1);
        this.J0.k(this.H, c17067mL1);
        this.J0.j(c17067mL1);
        if (z) {
            this.H0.setVisibility(8);
        } else {
            this.H0.setVisibility(0);
        }
        if (c17067mL1.R().getPeerId() == AbstractC5969Lp4.f() || c17067mL1.getExPeerType() != ExPeerType.PRIVATE) {
            N0();
        } else {
            this.W0 = AbstractC5969Lp4.d().e0().D(this.O0.getLifecycle(), c17067mL1.R().u(), new InterfaceC14603iB2() { // from class: ir.nasim.pN1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return this.a.V0((Boolean) obj, (Long) obj2);
                }
            });
        }
        UP1.a(bool2.booleanValue(), this.A, this.D, this.B, this.x, this.y, this.Y0);
        this.Y0 = bool2;
        this.G.setChecked(bool.booleanValue());
        n1();
        JF5.n(this.w, 0, 0, this.S0, 0);
        ViewGroup.LayoutParams layoutParams = this.B0.getLayoutParams();
        layoutParams.width = (C22078ud6.c() - this.R0) - this.S0;
        this.B0.setLayoutParams(layoutParams);
        d1(c17067mL1);
    }

    @Override // ir.nasim.InterfaceC24886zN1
    public void J4() {
        TextView textView = this.C0;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public void N0() {
        if (this.Y.getVisibility() != 8) {
            this.Y.setVisibility(8);
        }
    }

    public void O0() {
        if (this.Z.getVisibility() != 8) {
            this.Z.setVisibility(8);
        }
    }

    public void P0() {
        this.z0.setVisibility(8);
    }

    @Override // ir.nasim.InterfaceC24886zN1
    public void P4(EnumC23130wP1 enumC23130wP1) {
        int iA = this.P0.a(enumC23130wP1);
        int i = this.P0.i(enumC23130wP1);
        TintImageView tintImageView = this.E0;
        if (tintImageView != null) {
            tintImageView.setResource(iA);
            this.E0.setTint(i);
            this.E0.setVisibility(0);
            int i2 = JF5.g() ? 83 : 85;
            C17067mL1 c17067mL1 = this.I0;
            if (c17067mL1 == null || !c17067mL1.e0()) {
                e1(i2);
            } else {
                f1(i2);
            }
        }
    }

    public void S0() {
        TextView textView = this.A0;
        if (textView != null) {
            textView.invalidate();
        }
        MaterialTextView materialTextView = this.B0;
        if (materialTextView != null) {
            materialTextView.invalidate();
        }
    }

    @Override // ir.nasim.InterfaceC24886zN1
    public void W(CharSequence charSequence) {
        MaterialTextView materialTextView = this.B0;
        if (materialTextView != null) {
            materialTextView.setText(R62.S(charSequence, materialTextView.getPaint().getFontMetricsInt(), AbstractC7426Rr.z(14.0f), false));
        }
    }

    public void Y0() {
        AJ4 aj4;
        if (!(this.I0.Q().F() instanceof C19751qs6) || this.L0 || this.I0.Y() != 1 || (aj4 = this.K0) == null) {
            return;
        }
        aj4.a(this.I0);
        this.L0 = true;
    }

    @Override // ir.nasim.InterfaceC24886zN1
    public void Y4(int i) {
        MaterialTextView materialTextView = this.B0;
        if (materialTextView != null) {
            materialTextView.setTextColor(i);
        }
    }

    public void a() {
        this.I0 = null;
        this.Y0 = null;
        this.J.m();
        this.J0.p();
        this.X0 = 0L;
        InterfaceC13730gj3 interfaceC13730gj3 = this.W0;
        if (interfaceC13730gj3 != null) {
            interfaceC13730gj3.g(new CancellationException());
            this.W0 = null;
        }
        C20919sp4.b bVar = this.U0;
        if (bVar != null) {
            bVar.b();
            this.U0 = null;
        }
    }

    @Override // ir.nasim.InterfaceC24886zN1
    public void c2(String str) {
        TextView textView = this.C0;
        if (textView != null) {
            textView.setVisibility(0);
            this.C0.setText(str);
        }
    }

    public void g1(C17067mL1 c17067mL1) {
        if (M0(c17067mL1) && c17067mL1.Y() == 0) {
            this.D0.setText(AbstractC12217eE5.dialog_draft);
            this.D0.setVisibility(0);
        } else if (!T0(c17067mL1)) {
            this.D0.setVisibility(8);
        } else {
            this.D0.setText(AbstractC12217eE5.dialog_live);
            this.D0.setVisibility(0);
        }
    }

    @Override // ir.nasim.InterfaceC24886zN1
    public void j3() {
        TextView textView = this.F0;
        if (textView == null || this.G0 == null || this.I0 == null) {
            return;
        }
        textView.setVisibility(8);
        if (this.I0.e0()) {
            this.G0.setVisibility(0);
        } else {
            this.G0.setVisibility(8);
        }
    }

    @Override // ir.nasim.InterfaceC24886zN1
    public void m1(int i) {
        TextView textView = this.F0;
        if (textView == null || this.G0 == null) {
            return;
        }
        textView.setVisibility(0);
        this.F0.setText(this.P0.b(i));
        this.G0.setVisibility(8);
    }
}
