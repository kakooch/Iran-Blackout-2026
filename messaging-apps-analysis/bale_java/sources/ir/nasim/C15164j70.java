package ir.nasim;

import android.app.AlertDialog;
import android.content.Context;
import android.gov.nist.core.Separators;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import ir.nasim.database.dailogLists.DialogEntity;

/* renamed from: ir.nasim.j70, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15164j70 implements InterfaceC12737f70 {
    private final Context a;
    private AlertDialog b;

    public C15164j70(Context context) {
        AbstractC13042fc3.i(context, "context");
        this.a = context;
    }

    static /* synthetic */ void A(C15164j70 c15164j70, int i, CharSequence charSequence, SA2 sa2, String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            str = c15164j70.a.getString(AbstractC12217eE5.banking_dialog_ok_text);
        }
        String str2 = str;
        if ((i3 & 16) != 0) {
            i2 = 4;
        }
        c15164j70.z(i4, charSequence, sa2, str2, i2);
    }

    private final void B(View view, float f, float f2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
        builder.setView(view);
        builder.setCancelable(false);
        AlertDialog alertDialogCreate = builder.create();
        this.b = alertDialogCreate;
        AlertDialog alertDialog = null;
        if (alertDialogCreate == null) {
            AbstractC13042fc3.y("dialog");
            alertDialogCreate = null;
        }
        alertDialogCreate.show();
        AlertDialog alertDialog2 = this.b;
        if (alertDialog2 == null) {
            AbstractC13042fc3.y("dialog");
            alertDialog2 = null;
        }
        Window window = alertDialog2.getWindow();
        if (window != null) {
            window.addFlags(8192);
            int iB = C22078ud6.b() < C22078ud6.c() ? C22078ud6.b() : C22078ud6.c();
            if (iB > C22078ud6.a(32.0f)) {
                window.setLayout(iB - C22078ud6.a(32.0f), -2);
            }
            window.setBackgroundDrawableResource(android.R.color.transparent);
            window.setGravity(17);
            window.setDimAmount(0.5f);
        }
        if (f2 == 0.0f && f == 0.0f) {
            return;
        }
        AlertDialog alertDialog3 = this.b;
        if (alertDialog3 == null) {
            AbstractC13042fc3.y("dialog");
        } else {
            alertDialog = alertDialog3;
        }
        Window window2 = alertDialog.getWindow();
        if (window2 != null) {
            window2.setLayout(C22078ud6.a(f), C22078ud6.a(f2));
        }
    }

    static /* synthetic */ void C(C15164j70 c15164j70, View view, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            f2 = 0.0f;
        }
        c15164j70.B(view, f, f2);
    }

    private final View o(int i, CharSequence charSequence, String str, SA2 sa2, int i2) {
        Object systemService = this.a.getSystemService("layout_inflater");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View viewInflate = ((LayoutInflater) systemService).inflate(AbstractC12208eD5.banking_dialog_layout, (ViewGroup) null);
        viewInflate.setBackgroundColor(C5495Jo7.a.q());
        AbstractC13042fc3.f(viewInflate);
        x(viewInflate, i);
        y(viewInflate, charSequence, i2);
        v(viewInflate, sa2, str);
        return viewInflate;
    }

    private final SpannableStringBuilder p(CharSequence charSequence, String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + Separators.RETURN);
        spannableStringBuilder.setSpan(new T10(C6011Lu2.i()), 0, spannableStringBuilder.length(), 33);
        spannableStringBuilder.setSpan(new RelativeSizeSpan(1.2f), 0, spannableStringBuilder.length(), 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private final void q(TextView textView, String str, final SA2 sa2, int i) {
        textView.setBackgroundResource(KB5.light_button_background_selector);
        textView.setTypeface(C6011Lu2.i());
        if (i != 0) {
            textView.setTextColor(AbstractC4043Dl1.c(textView.getContext(), i));
        }
        if (!AbstractC13042fc3.d(str, "")) {
            textView.setText(str);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.i70
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C15164j70.r(this.a, sa2, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(C15164j70 c15164j70, SA2 sa2, View view) {
        AbstractC13042fc3.i(c15164j70, "this$0");
        AlertDialog alertDialog = c15164j70.b;
        if (alertDialog == null) {
            AbstractC13042fc3.y("dialog");
            alertDialog = null;
        }
        alertDialog.dismiss();
        if (sa2 != null) {
            sa2.invoke();
        }
    }

    private final void s(View view, Spannable spannable) {
        TextView textView = (TextView) view.findViewById(BC5.dialog_text);
        textView.setTypeface(C6011Lu2.k());
        textView.setText(spannable);
    }

    private final void t(View view, String str) {
        TextView textView = (TextView) view.findViewById(BC5.dialog_title);
        textView.setTypeface(C6011Lu2.i());
        textView.setText(str);
    }

    private final Spannable u(String str) {
        String name;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        try {
            if (AbstractC20762sZ6.X(str, "<b>", false, 2, null) && AbstractC20762sZ6.X(str, "</b>", false, 2, null)) {
                int iL0 = AbstractC20762sZ6.l0(str, "<b>", 0, false, 6, null);
                int iL02 = AbstractC20762sZ6.l0(str, "</b>", 0, false, 6, null);
                if (iL0 > 0 && iL02 > 0) {
                    spannableStringBuilder.setSpan(new T10(C6011Lu2.i()), iL0, iL02, 33);
                    spannableStringBuilder.replace(iL0, iL0 + 3, (CharSequence) "");
                    spannableStringBuilder.replace(iL02 - 3, iL02 + 1, (CharSequence) "");
                }
            }
        } catch (Exception e) {
            if (C15164j70.class.isAnonymousClass()) {
                name = C15164j70.class.getName();
                int length = name.length();
                AbstractC13042fc3.f(name);
                if (length > 23) {
                    name = name.substring(name.length() - 23, name.length());
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            } else {
                name = C15164j70.class.getSimpleName();
                int length2 = name.length();
                AbstractC13042fc3.f(name);
                if (length2 > 23) {
                    name = name.substring(0, 23);
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            }
            C19406qI3.c(name, "processMessage", e);
        }
        return spannableStringBuilder;
    }

    private final void v(View view, final SA2 sa2, String str) {
        TextView textView = (TextView) view.findViewById(BC5.dialog_button);
        textView.setText(str);
        textView.setTextColor(AbstractC4043Dl1.c(textView.getContext(), TA5.secondary));
        textView.setTypeface(C6011Lu2.i());
        textView.setTextSize(1, 16.0f);
        textView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.h70
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C15164j70.w(this.a, sa2, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(C15164j70 c15164j70, SA2 sa2, View view) {
        AbstractC13042fc3.i(c15164j70, "this$0");
        AlertDialog alertDialog = c15164j70.b;
        if (alertDialog == null) {
            AbstractC13042fc3.y("dialog");
            alertDialog = null;
        }
        alertDialog.dismiss();
        if (sa2 != null) {
            sa2.invoke();
        }
    }

    private final void x(View view, int i) {
        ImageView imageView = (ImageView) view.findViewById(BC5.dialog_icon);
        if (i != 0) {
            imageView.setImageResource(i);
        } else {
            imageView.setVisibility(8);
        }
    }

    private final void y(View view, CharSequence charSequence, int i) {
        TextView textView = (TextView) view.findViewById(BC5.dialog_text);
        textView.setText(charSequence);
        textView.setTextColor(C5495Jo7.a.g0());
        textView.setTypeface(C6011Lu2.k());
        textView.setTextSize(1, 13.0f);
        textView.setTextAlignment(i);
    }

    private final void z(int i, CharSequence charSequence, SA2 sa2, String str, int i2) {
        C(this, o(i, charSequence, str, sa2, i2), 0.0f, 0.0f, 6, null);
    }

    @Override // ir.nasim.InterfaceC12737f70
    public void b(String str, String str2, String str3, String str4, SA2 sa2, SA2 sa22, int i, int i2) {
        AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(str2, "title");
        AbstractC13042fc3.i(str3, "leftButtonTitle");
        AbstractC13042fc3.i(str4, "rightButtonTitle");
        Object systemService = this.a.getSystemService("layout_inflater");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View viewInflate = ((LayoutInflater) systemService).inflate(AbstractC12208eD5.banking_confirm_dialog, (ViewGroup) null);
        AbstractC13042fc3.f(viewInflate);
        t(viewInflate, str2);
        s(viewInflate, u(str));
        TextView textView = (TextView) viewInflate.findViewById(BC5.left_button);
        AbstractC13042fc3.f(textView);
        q(textView, str3, sa2, i);
        TextView textView2 = (TextView) viewInflate.findViewById(BC5.right_button);
        AbstractC13042fc3.f(textView2);
        q(textView2, str4, sa22, i2);
        AbstractC13042fc3.f(viewInflate);
        C(this, viewInflate, 0.0f, 0.0f, 6, null);
    }

    @Override // ir.nasim.InterfaceC12737f70
    public void d(String str, String str2, String str3, SA2 sa2) {
        AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(str2, "title");
        AbstractC13042fc3.i(str3, "buttonText");
        A(this, KB5.ba_dialog_info, p(str, str2), sa2, str3, 0, 16, null);
    }

    @Override // ir.nasim.InterfaceC12737f70
    public void e(int i, int i2, SA2 sa2) {
        String string = this.a.getString(i);
        AbstractC13042fc3.h(string, "getString(...)");
        String string2 = this.a.getString(i2);
        AbstractC13042fc3.h(string2, "getString(...)");
        A(this, KB5.banking_dialog_negative, p(string, string2), sa2, null, 0, 24, null);
    }

    @Override // ir.nasim.InterfaceC12737f70
    public void g(CharSequence charSequence, String str, String str2, SA2 sa2, int i) {
        AbstractC13042fc3.i(charSequence, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(str2, "buttonText");
        z(0, p(charSequence, str), sa2, str2, i);
    }

    @Override // ir.nasim.InterfaceC12737f70
    public void h(String str, String str2, SA2 sa2) {
        AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(str2, "title");
        A(this, KB5.banking_dialog_negative, p(str, str2), sa2, null, 0, 24, null);
    }

    @Override // ir.nasim.InterfaceC12737f70
    public void i(int i, int i2, SA2 sa2) {
        String string = this.a.getString(i);
        AbstractC13042fc3.h(string, "getString(...)");
        String string2 = this.a.getString(i2);
        AbstractC13042fc3.h(string2, "getString(...)");
        A(this, 0, p(string, string2), sa2, null, 0, 25, null);
    }

    @Override // ir.nasim.InterfaceC12737f70
    public void j(int i, int i2, SA2 sa2) {
        String string = this.a.getString(i);
        AbstractC13042fc3.h(string, "getString(...)");
        String string2 = this.a.getString(i2);
        AbstractC13042fc3.h(string2, "getString(...)");
        A(this, KB5.banking_dialog_positive, p(string, string2), sa2, null, 0, 24, null);
    }
}
