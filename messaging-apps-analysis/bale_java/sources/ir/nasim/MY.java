package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.AppCompatEditText;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import ir.nasim.O98;

/* loaded from: classes5.dex */
public class MY {
    private androidx.appcompat.app.a a;
    private LottieAnimationView b;
    private ImageView c;
    private CircularProgressIndicator d;
    private TextView e;
    private TextView f;
    private TextView g;
    protected CheckBox h;
    private LinearLayout i;
    private TextView j;
    private TextView k;
    private TextView l;
    private View m;
    private FrameLayout n;
    private final Context o;
    private CompoundButton.OnCheckedChangeListener p;
    private View q;
    private TextView r;
    private MaterialCardView s;
    private AppCompatEditText t;
    private TextView u;
    private TextView v;
    private String w;
    private int x;

    public static final class a implements TextWatcher {
        final /* synthetic */ int a;
        final /* synthetic */ MY b;
        final /* synthetic */ boolean c;

        a(int i, MY my, boolean z) {
            this.a = i;
            this.b = my;
            this.c = z;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AbstractC13042fc3.i(editable, "s");
            this.b.y(editable.toString(), this.a);
            TextView textView = this.b.v;
            if (textView == null || textView.getVisibility() != 0) {
                return;
            }
            this.b.s();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AbstractC13042fc3.i(charSequence, "s");
            if (charSequence.length() >= this.a) {
                AbstractC7426Rr.a.S(this.b.u, 2.0f, 1);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AbstractC13042fc3.i(charSequence, "s");
            this.b.n((AbstractC20762sZ6.n0(charSequence.toString()) && this.c) ? false : true);
        }
    }

    public MY(final NY ny, boolean z) {
        AppCompatEditText appCompatEditText;
        TextView textView;
        AbstractC13042fc3.i(ny, "builder");
        Context context = ny.a;
        this.o = context;
        int i = ny.z;
        this.x = i == -1 ? ny.b ? C5495Jo7.a.e2() : C5495Jo7.a.a0() : i;
        w();
        CharSequence charSequence = ny.i;
        CircularProgressIndicator circularProgressIndicator = null;
        if (charSequence != null) {
            if (charSequence instanceof Spannable) {
                TextView textView2 = this.e;
                if (textView2 == null) {
                    AbstractC13042fc3.y("tvTitle");
                    textView2 = null;
                }
                textView2.setText(ny.i, TextView.BufferType.SPANNABLE);
                TextView textView3 = this.e;
                if (textView3 == null) {
                    AbstractC13042fc3.y("tvTitle");
                    textView3 = null;
                }
                textView3.setVisibility(0);
            } else if (!AbstractC20762sZ6.n0(charSequence.toString())) {
                TextView textView4 = this.e;
                if (textView4 == null) {
                    AbstractC13042fc3.y("tvTitle");
                    textView4 = null;
                }
                textView4.setText(AbstractC5730Kp.g(charSequence.toString()));
                TextView textView5 = this.e;
                if (textView5 == null) {
                    AbstractC13042fc3.y("tvTitle");
                    textView5 = null;
                }
                textView5.setVisibility(0);
            }
            C19938rB7 c19938rB7 = C19938rB7.a;
        }
        n((ny.G || ny.H) ? false : true);
        if (z) {
            CharSequence charSequence2 = ny.k;
            Spannable spannableE = AbstractC5730Kp.e(charSequence2 != null ? String.valueOf(charSequence2) : "");
            TextView textView6 = this.f;
            if (textView6 == null) {
                AbstractC13042fc3.y("tvDescription");
                textView6 = null;
            }
            textView6.setText(spannableE);
            TextView textView7 = this.f;
            if (textView7 == null) {
                AbstractC13042fc3.y("tvDescription");
                textView7 = null;
            }
            textView7.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.HY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MY.f(this.a, view);
                }
            });
        } else {
            TextView textView8 = this.f;
            if (textView8 == null) {
                AbstractC13042fc3.y("tvDescription");
                textView8 = null;
            }
            textView8.setText(ny.k);
        }
        TextView textView9 = this.f;
        if (textView9 == null) {
            AbstractC13042fc3.y("tvDescription");
            textView9 = null;
        }
        textView9.setMovementMethod(LinkMovementMethod.getInstance());
        TextView textView10 = this.f;
        if (textView10 == null) {
            AbstractC13042fc3.y("tvDescription");
            textView10 = null;
        }
        textView10.setLinkTextColor(context.getResources().getColor(TA5.link_color));
        int i2 = JF5.g() ? 4 : 3;
        TextView textView11 = this.e;
        if (textView11 == null) {
            AbstractC13042fc3.y("tvTitle");
            textView11 = null;
        }
        textView11.setTextDirection(i2);
        TextView textView12 = this.e;
        if (textView12 == null) {
            AbstractC13042fc3.y("tvTitle");
            textView12 = null;
        }
        textView12.setTextAlignment(ny.j);
        TextView textView13 = this.f;
        if (textView13 == null) {
            AbstractC13042fc3.y("tvDescription");
            textView13 = null;
        }
        textView13.setTextDirection(i2);
        TextView textView14 = this.f;
        if (textView14 == null) {
            AbstractC13042fc3.y("tvDescription");
            textView14 = null;
        }
        textView14.setTextAlignment(ny.l);
        String str = ny.m;
        if (str != null && str != null && (!AbstractC20762sZ6.n0(str))) {
            TextView textView15 = this.j;
            if (textView15 == null) {
                AbstractC13042fc3.y("messageOk");
                textView15 = null;
            }
            textView15.setText(ny.m);
            TextView textView16 = this.j;
            if (textView16 == null) {
                AbstractC13042fc3.y("messageOk");
                textView16 = null;
            }
            textView16.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.IY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MY.g(ny, this, view);
                }
            });
        }
        String str2 = ny.n;
        if (str2 == null || str2 == null || !(!AbstractC20762sZ6.n0(str2))) {
            TextView textView17 = this.k;
            if (textView17 == null) {
                AbstractC13042fc3.y("messageCancel");
                textView17 = null;
            }
            textView17.setVisibility(8);
            View view = this.m;
            if (view == null) {
                AbstractC13042fc3.y("buttonDivider");
                view = null;
            }
            view.setVisibility(8);
        } else {
            TextView textView18 = this.k;
            if (textView18 == null) {
                AbstractC13042fc3.y("messageCancel");
                textView18 = null;
            }
            textView18.setText(ny.n);
            TextView textView19 = this.k;
            if (textView19 == null) {
                AbstractC13042fc3.y("messageCancel");
                textView19 = null;
            }
            textView19.setVisibility(0);
            View view2 = this.m;
            if (view2 == null) {
                AbstractC13042fc3.y("buttonDivider");
                view2 = null;
            }
            view2.setVisibility(0);
            TextView textView20 = this.k;
            if (textView20 == null) {
                AbstractC13042fc3.y("messageCancel");
                textView20 = null;
            }
            textView20.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.JY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    MY.h(ny, this, view3);
                }
            });
        }
        if (ny.c > 0) {
            ImageView imageView = this.c;
            if (imageView == null) {
                AbstractC13042fc3.y("ivImage");
                imageView = null;
            }
            imageView.setImageResource(ny.c);
            Size size = ny.d;
            if (size != null) {
                ImageView imageView2 = this.c;
                if (imageView2 == null) {
                    AbstractC13042fc3.y("ivImage");
                    imageView2 = null;
                }
                ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
                layoutParams.width = size.getWidth();
                layoutParams.height = size.getHeight();
                ImageView imageView3 = this.c;
                if (imageView3 == null) {
                    AbstractC13042fc3.y("ivImage");
                    imageView3 = null;
                }
                imageView3.setLayoutParams(layoutParams);
            } else {
                new SA2() { // from class: ir.nasim.KY
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return MY.i(this.a, ny);
                    }
                };
            }
            if (ny.f != -1) {
                ImageView imageView4 = this.c;
                if (imageView4 == null) {
                    AbstractC13042fc3.y("ivImage");
                    imageView4 = null;
                }
                imageView4.setColorFilter(ny.f);
            } else if (ny.g != -1) {
                ImageView imageView5 = this.c;
                if (imageView5 == null) {
                    AbstractC13042fc3.y("ivImage");
                    imageView5 = null;
                }
                imageView5.setColorFilter(ny.g);
            }
            LottieAnimationView lottieAnimationView = this.b;
            if (lottieAnimationView == null) {
                AbstractC13042fc3.y("lavAnimate");
                lottieAnimationView = null;
            }
            lottieAnimationView.setVisibility(8);
        } else if (ny.h > 0) {
            LottieAnimationView lottieAnimationView2 = this.b;
            if (lottieAnimationView2 == null) {
                AbstractC13042fc3.y("lavAnimate");
                lottieAnimationView2 = null;
            }
            lottieAnimationView2.setAnimation(ny.h);
            ImageView imageView6 = this.c;
            if (imageView6 == null) {
                AbstractC13042fc3.y("ivImage");
                imageView6 = null;
            }
            imageView6.setVisibility(8);
        } else {
            LottieAnimationView lottieAnimationView3 = this.b;
            if (lottieAnimationView3 == null) {
                AbstractC13042fc3.y("lavAnimate");
                lottieAnimationView3 = null;
            }
            lottieAnimationView3.setVisibility(8);
            ImageView imageView7 = this.c;
            if (imageView7 == null) {
                AbstractC13042fc3.y("ivImage");
                imageView7 = null;
            }
            imageView7.setVisibility(8);
        }
        String str3 = ny.u;
        if (str3 != null && str3 != null && (!AbstractC20762sZ6.n0(str3))) {
            TextView textView21 = this.l;
            if (textView21 == null) {
                AbstractC13042fc3.y("badge");
                textView21 = null;
            }
            textView21.setVisibility(0);
            TextView textView22 = this.l;
            if (textView22 == null) {
                AbstractC13042fc3.y("badge");
                textView22 = null;
            }
            textView22.setText(ny.u);
        }
        if (ny.x != null) {
            FrameLayout frameLayout = this.n;
            if (frameLayout == null) {
                AbstractC13042fc3.y("extraFrame");
                frameLayout = null;
            }
            frameLayout.addView(ny.x);
        }
        if (ny.s != null) {
            androidx.appcompat.app.a aVar = this.a;
            if (aVar == null) {
                AbstractC13042fc3.y("alertDialog");
                aVar = null;
            }
            aVar.setOnDismissListener(ny.s);
        }
        if (ny.t != null) {
            androidx.appcompat.app.a aVar2 = this.a;
            if (aVar2 == null) {
                AbstractC13042fc3.y("alertDialog");
                aVar2 = null;
            }
            aVar2.setOnCancelListener(ny.t);
        }
        androidx.appcompat.app.a aVar3 = this.a;
        if (aVar3 == null) {
            AbstractC13042fc3.y("alertDialog");
            aVar3 = null;
        }
        aVar3.setCanceledOnTouchOutside(ny.o);
        androidx.appcompat.app.a aVar4 = this.a;
        if (aVar4 == null) {
            AbstractC13042fc3.y("alertDialog");
            aVar4 = null;
        }
        aVar4.setCancelable(ny.y);
        if (ny.A != -1) {
            TextView textView23 = this.k;
            if (textView23 == null) {
                AbstractC13042fc3.y("messageCancel");
                textView23 = null;
            }
            textView23.setTextColor(ny.A);
        }
        String str4 = ny.C;
        if (str4 == null || str4 == null || !(!AbstractC20762sZ6.n0(str4))) {
            LinearLayout linearLayout = this.i;
            if (linearLayout == null) {
                AbstractC13042fc3.y("checkBoxContainer");
                linearLayout = null;
            }
            linearLayout.setVisibility(8);
        } else {
            t(ny.C, ny.H);
        }
        if (!ny.E) {
            TextView textView24 = this.f;
            if (textView24 == null) {
                AbstractC13042fc3.y("tvDescription");
                textView24 = null;
            }
            textView24.setVisibility(8);
        }
        if (ny.B) {
            this.w = ny.I;
            v(ny.G, ny.J);
        }
        String str5 = ny.C;
        if (str5 == null || str5 == null || !(!AbstractC20762sZ6.n0(str5))) {
            LinearLayout linearLayout2 = this.i;
            if (linearLayout2 == null) {
                AbstractC13042fc3.y("checkBoxContainer");
                linearLayout2 = null;
            }
            linearLayout2.setVisibility(8);
        } else {
            LinearLayout linearLayout3 = this.i;
            if (linearLayout3 == null) {
                AbstractC13042fc3.y("checkBoxContainer");
                linearLayout3 = null;
            }
            linearLayout3.setVisibility(0);
            TextView textView25 = this.g;
            if (textView25 == null) {
                AbstractC13042fc3.y("checkBoxTxt");
                textView25 = null;
            }
            textView25.setText(ny.C);
            p().setOnCheckedChangeListener(this.p);
            TextView textView26 = this.g;
            if (textView26 == null) {
                AbstractC13042fc3.y("checkBoxTxt");
                textView26 = null;
            }
            textView26.setTypeface(C6011Lu2.i());
        }
        String str6 = ny.v;
        if (str6 != null && (textView = this.r) != null) {
            textView.setText(str6);
            C19938rB7 c19938rB72 = C19938rB7.a;
        }
        String str7 = ny.w;
        if (str7 != null && (appCompatEditText = this.t) != null) {
            appCompatEditText.setHint(str7);
            C19938rB7 c19938rB73 = C19938rB7.a;
        }
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = ny.D;
        if (onCheckedChangeListener != null) {
            this.p = onCheckedChangeListener;
        }
        if (ny.K) {
            CircularProgressIndicator circularProgressIndicator2 = this.d;
            if (circularProgressIndicator2 == null) {
                AbstractC13042fc3.y("progressBar");
                circularProgressIndicator2 = null;
            }
            circularProgressIndicator2.setVisibility(0);
            if (ny.L) {
                CircularProgressIndicator circularProgressIndicator3 = this.d;
                if (circularProgressIndicator3 == null) {
                    AbstractC13042fc3.y("progressBar");
                } else {
                    circularProgressIndicator = circularProgressIndicator3;
                }
                circularProgressIndicator.setIndeterminate(true);
                return;
            }
            CircularProgressIndicator circularProgressIndicator4 = this.d;
            if (circularProgressIndicator4 == null) {
                AbstractC13042fc3.y("progressBar");
                circularProgressIndicator4 = null;
            }
            circularProgressIndicator4.setIndeterminate(false);
            CircularProgressIndicator circularProgressIndicator5 = this.d;
            if (circularProgressIndicator5 == null) {
                AbstractC13042fc3.y("progressBar");
                circularProgressIndicator5 = null;
            }
            circularProgressIndicator5.setMax(ny.M);
            CircularProgressIndicator circularProgressIndicator6 = this.d;
            if (circularProgressIndicator6 == null) {
                AbstractC13042fc3.y("progressBar");
            } else {
                circularProgressIndicator = circularProgressIndicator6;
            }
            circularProgressIndicator.setProgress(ny.N);
        }
    }

    public static /* synthetic */ void B(MY my, String str, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showEditTextErrorWithMessage");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        my.A(str, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(MY my, View view) {
        AbstractC13042fc3.i(my, "this$0");
        TextView textView = my.f;
        androidx.appcompat.app.a aVar = null;
        if (textView == null) {
            AbstractC13042fc3.y("tvDescription");
            textView = null;
        }
        if (textView.getSelectionStart() == -1) {
            TextView textView2 = my.f;
            if (textView2 == null) {
                AbstractC13042fc3.y("tvDescription");
                textView2 = null;
            }
            if (textView2.getSelectionEnd() == -1) {
                return;
            }
        }
        androidx.appcompat.app.a aVar2 = my.a;
        if (aVar2 == null) {
            AbstractC13042fc3.y("alertDialog");
        } else {
            aVar = aVar2;
        }
        aVar.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(NY ny, MY my, View view) {
        AbstractC13042fc3.i(ny, "$builder");
        AbstractC13042fc3.i(my, "this$0");
        if (ny.F) {
            androidx.appcompat.app.a aVar = my.a;
            if (aVar == null) {
                AbstractC13042fc3.y("alertDialog");
                aVar = null;
            }
            aVar.dismiss();
        }
        View.OnClickListener onClickListener = ny.q;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(NY ny, MY my, View view) {
        AbstractC13042fc3.i(ny, "$builder");
        AbstractC13042fc3.i(my, "this$0");
        View.OnClickListener onClickListener = ny.r;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        if (ny.F) {
            androidx.appcompat.app.a aVar = my.a;
            if (aVar == null) {
                AbstractC13042fc3.y("alertDialog");
                aVar = null;
            }
            aVar.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i(MY my, NY ny) {
        AbstractC13042fc3.i(my, "this$0");
        AbstractC13042fc3.i(ny, "$builder");
        ImageView imageView = my.c;
        if (imageView == null) {
            AbstractC13042fc3.y("ivImage");
            imageView = null;
        }
        imageView.setAdjustViewBounds(ny.e);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(boolean z) {
        TextView textView = this.j;
        TextView textView2 = null;
        if (textView == null) {
            AbstractC13042fc3.y("messageOk");
            textView = null;
        }
        textView.setEnabled(z);
        if (z) {
            TextView textView3 = this.j;
            if (textView3 == null) {
                AbstractC13042fc3.y("messageOk");
            } else {
                textView2 = textView3;
            }
            textView2.setTextColor(this.x);
            return;
        }
        TextView textView4 = this.j;
        if (textView4 == null) {
            AbstractC13042fc3.y("messageOk");
        } else {
            textView2 = textView4;
        }
        textView2.setTextColor(C5495Jo7.a.e0());
    }

    private final void t(String str, final boolean z) {
        LinearLayout linearLayout = this.i;
        TextView textView = null;
        if (linearLayout == null) {
            AbstractC13042fc3.y("checkBoxContainer");
            linearLayout = null;
        }
        linearLayout.setVisibility(0);
        TextView textView2 = this.g;
        if (textView2 == null) {
            AbstractC13042fc3.y("checkBoxTxt");
            textView2 = null;
        }
        textView2.setText(str);
        p().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ir.nasim.LY
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                MY.u(z, this, compoundButton, z2);
            }
        });
        TextView textView3 = this.g;
        if (textView3 == null) {
            AbstractC13042fc3.y("checkBoxTxt");
        } else {
            textView = textView3;
        }
        textView.setTypeface(C6011Lu2.i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(boolean z, MY my, CompoundButton compoundButton, boolean z2) {
        AbstractC13042fc3.i(my, "this$0");
        if (z) {
            my.n(z2);
        }
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = my.p;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(compoundButton, z2);
        }
    }

    private final void v(boolean z, int i) {
        Object systemService = this.o.getSystemService("layout_inflater");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        FrameLayout frameLayout = null;
        View viewInflate = ((LayoutInflater) systemService).inflate(AbstractC12208eD5.bale_edit_text, (ViewGroup) null);
        this.q = viewInflate;
        this.r = viewInflate != null ? (TextView) viewInflate.findViewById(BC5.title_editText) : null;
        View view = this.q;
        this.t = view != null ? (AppCompatEditText) view.findViewById(BC5.editText) : null;
        View view2 = this.q;
        this.u = view2 != null ? (TextView) view2.findViewById(BC5.tv_counter) : null;
        View view3 = this.q;
        this.s = view3 != null ? (MaterialCardView) view3.findViewById(BC5.card) : null;
        View view4 = this.q;
        this.v = view4 != null ? (TextView) view4.findViewById(BC5.tv_error) : null;
        TextView textView = this.r;
        if (textView != null) {
            textView.setTextSize(13.0f);
        }
        TextView textView2 = this.r;
        if (textView2 != null) {
            textView2.setTypeface(C6011Lu2.i());
        }
        TextView textView3 = this.r;
        if (textView3 != null) {
            textView3.setTextColor(C5495Jo7.a.d());
        }
        AppCompatEditText appCompatEditText = this.t;
        if (appCompatEditText != null) {
            appCompatEditText.setTextColor(C5495Jo7.a.g());
        }
        AppCompatEditText appCompatEditText2 = this.t;
        if (appCompatEditText2 != null) {
            appCompatEditText2.setTextSize(16.0f);
        }
        AppCompatEditText appCompatEditText3 = this.t;
        if (appCompatEditText3 != null) {
            appCompatEditText3.setTypeface(C6011Lu2.k());
        }
        String str = this.w;
        if (str == null || str == null || !(!AbstractC20762sZ6.n0(str))) {
            y("", i);
        } else {
            AppCompatEditText appCompatEditText4 = this.t;
            if (appCompatEditText4 != null) {
                appCompatEditText4.setText(this.w);
            }
            String str2 = this.w;
            y(str2 != null ? str2 : "", i);
        }
        TextView textView4 = this.u;
        if (textView4 != null) {
            textView4.setTextSize(12.0f);
        }
        TextView textView5 = this.u;
        if (textView5 != null) {
            textView5.setTypeface(C6011Lu2.k());
        }
        TextView textView6 = this.u;
        if (textView6 != null) {
            textView6.setTextColor(C5495Jo7.a.d());
        }
        TextView textView7 = this.v;
        if (textView7 != null) {
            textView7.setTextColor(C5495Jo7.a.g2());
        }
        TextView textView8 = this.v;
        if (textView8 != null) {
            textView8.setTextSize(12.0f);
        }
        TextView textView9 = this.v;
        if (textView9 != null) {
            textView9.setTypeface(C6011Lu2.k());
        }
        TextView textView10 = this.v;
        if (textView10 != null) {
            textView10.setVisibility(8);
        }
        MaterialCardView materialCardView = this.s;
        if (materialCardView != null) {
            materialCardView.setStrokeColor(C5495Jo7.a.Y());
        }
        MaterialCardView materialCardView2 = this.s;
        if (materialCardView2 != null) {
            materialCardView2.setStrokeWidth(C22078ud6.a(1.5f));
        }
        AppCompatEditText appCompatEditText5 = this.t;
        if (appCompatEditText5 != null) {
            appCompatEditText5.addTextChangedListener(new a(i, this, z));
        }
        View view5 = this.q;
        if (view5 != null) {
            view5.setVisibility(0);
        }
        FrameLayout frameLayout2 = this.n;
        if (frameLayout2 == null) {
            AbstractC13042fc3.y("extraFrame");
        } else {
            frameLayout = frameLayout2;
        }
        frameLayout.addView(this.q);
        AppCompatEditText appCompatEditText6 = this.t;
        if (appCompatEditText6 != null) {
            appCompatEditText6.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        }
    }

    private final void w() {
        Object systemService = this.o.getSystemService("layout_inflater");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        androidx.appcompat.app.a aVar = null;
        View viewInflate = ((LayoutInflater) systemService).inflate(AbstractC12208eD5.bale_dialog, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(BC5.dlg_title);
        this.e = textView;
        if (textView == null) {
            AbstractC13042fc3.y("tvTitle");
            textView = null;
        }
        textView.setTypeface(C6011Lu2.i());
        this.d = (CircularProgressIndicator) viewInflate.findViewById(BC5.dlg_progress_bar);
        TextView textView2 = (TextView) viewInflate.findViewById(BC5.dlg_description);
        this.f = textView2;
        if (textView2 == null) {
            AbstractC13042fc3.y("tvDescription");
            textView2 = null;
        }
        textView2.setTypeface(C6011Lu2.k());
        TextView textView3 = (TextView) viewInflate.findViewById(BC5.dlg_message_ok);
        this.j = textView3;
        if (textView3 == null) {
            AbstractC13042fc3.y("messageOk");
            textView3 = null;
        }
        textView3.setTypeface(C6011Lu2.i());
        this.n = (FrameLayout) viewInflate.findViewById(BC5.dialog_frame_extra);
        TextView textView4 = (TextView) viewInflate.findViewById(BC5.dlg_message_cancel);
        this.k = textView4;
        if (textView4 == null) {
            AbstractC13042fc3.y("messageCancel");
            textView4 = null;
        }
        textView4.setTypeface(C6011Lu2.i());
        TextView textView5 = this.k;
        if (textView5 == null) {
            AbstractC13042fc3.y("messageCancel");
            textView5 = null;
        }
        textView5.setTextColor(C5495Jo7.a.c0());
        TextView textView6 = (TextView) viewInflate.findViewById(BC5.dlg_badge);
        this.l = textView6;
        if (textView6 == null) {
            AbstractC13042fc3.y("badge");
            textView6 = null;
        }
        textView6.setTypeface(C6011Lu2.i());
        this.c = (ImageView) viewInflate.findViewById(BC5.dlg_image);
        this.b = (LottieAnimationView) viewInflate.findViewById(BC5.dlg_lottie_animation);
        this.m = viewInflate.findViewById(BC5.dlg_button_divider);
        this.i = (LinearLayout) viewInflate.findViewById(BC5.checkbox_linear);
        this.g = (TextView) viewInflate.findViewById(BC5.checkbox_text);
        x((CheckBox) viewInflate.findViewById(BC5.check_box_dialog));
        a.C0011a c0011a = new a.C0011a(this.o);
        c0011a.setView(viewInflate);
        androidx.appcompat.app.a aVarCreate = c0011a.create();
        this.a = aVarCreate;
        if (aVarCreate == null) {
            AbstractC13042fc3.y("alertDialog");
        } else {
            aVar = aVarCreate;
        }
        Window window = aVar.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(String str, int i) {
        String strH;
        if (JF5.g()) {
            strH = XY6.e(str.length() + Separators.SLASH + i);
        } else {
            strH = XY6.h(str.length() + Separators.SLASH + i);
        }
        TextView textView = this.u;
        if (textView != null) {
            textView.setText(strH);
        }
    }

    public final void A(String str, boolean z) {
        TextView textView = this.v;
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = this.v;
        if (textView2 != null) {
            textView2.setText(str);
        }
        MaterialCardView materialCardView = this.s;
        if (materialCardView != null) {
            materialCardView.setStrokeColor(C5495Jo7.a.g2());
        }
        TextView textView3 = this.r;
        if (textView3 != null) {
            textView3.setTextColor(C5495Jo7.a.g2());
        }
        if (z) {
            n(false);
        }
    }

    public final void C(String str) {
        TextView textView = this.v;
        if (textView != null) {
            textView.setTextColor(C5495Jo7.a.g());
        }
        TextView textView2 = this.v;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        TextView textView3 = this.v;
        if (textView3 != null) {
            textView3.setText(str);
        }
    }

    public final void D() {
        AppCompatEditText appCompatEditText;
        AppCompatEditText appCompatEditText2 = this.t;
        if (appCompatEditText2 != null) {
            appCompatEditText2.requestFocus();
        }
        androidx.appcompat.app.a aVar = this.a;
        if (aVar == null) {
            AbstractC13042fc3.y("alertDialog");
            aVar = null;
        }
        Window window = aVar.getWindow();
        if (window == null || (appCompatEditText = this.t) == null) {
            return;
        }
        AbstractC19329q98.a(window, appCompatEditText).e(O98.m.d());
    }

    public final void o() {
        androidx.appcompat.app.a aVar = this.a;
        if (aVar == null) {
            AbstractC13042fc3.y("alertDialog");
            aVar = null;
        }
        aVar.dismiss();
    }

    protected final CheckBox p() {
        CheckBox checkBox = this.h;
        if (checkBox != null) {
            return checkBox;
        }
        AbstractC13042fc3.y("checkBox");
        return null;
    }

    public final AppCompatEditText q() {
        return this.t;
    }

    public final TextView r() {
        return this.r;
    }

    public final void s() {
        TextView textView = this.v;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = this.v;
        if (textView2 != null) {
            textView2.setText("");
        }
        MaterialCardView materialCardView = this.s;
        if (materialCardView != null) {
            materialCardView.setStrokeColor(C5495Jo7.a.Y());
        }
        TextView textView3 = this.r;
        if (textView3 != null) {
            textView3.setTextColor(C5495Jo7.a.d());
        }
    }

    protected final void x(CheckBox checkBox) {
        AbstractC13042fc3.i(checkBox, "<set-?>");
        this.h = checkBox;
    }

    public final void z() {
        androidx.appcompat.app.a aVar = this.a;
        if (aVar == null) {
            AbstractC13042fc3.y("alertDialog");
            aVar = null;
        }
        aVar.show();
        if (this.t != null) {
            D();
        }
    }
}
