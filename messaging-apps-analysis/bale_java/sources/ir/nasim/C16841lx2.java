package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.contact.ui.add.widget.EditTextWithPrefix;
import ir.nasim.contact.ui.add.widget.PhoneNumberEditText;

/* renamed from: ir.nasim.lx2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C16841lx2 implements InterfaceC9764aW7 {
    private final ScrollView a;
    public final MaterialButton b;
    public final TextView c;
    public final MaterialCardView d;
    public final EditTextWithPrefix e;
    public final EditText f;
    public final PhoneNumberEditText g;
    public final TextView h;
    public final MaterialCardView i;
    public final MaterialCardView j;
    public final TextView k;
    public final TextView l;
    public final BaleToolbar m;

    private C16841lx2(ScrollView scrollView, MaterialButton materialButton, TextView textView, MaterialCardView materialCardView, EditTextWithPrefix editTextWithPrefix, EditText editText, PhoneNumberEditText phoneNumberEditText, TextView textView2, MaterialCardView materialCardView2, MaterialCardView materialCardView3, TextView textView3, TextView textView4, BaleToolbar baleToolbar) {
        this.a = scrollView;
        this.b = materialButton;
        this.c = textView;
        this.d = materialCardView;
        this.e = editTextWithPrefix;
        this.f = editText;
        this.g = phoneNumberEditText;
        this.h = textView2;
        this.i = materialCardView2;
        this.j = materialCardView3;
        this.k = textView3;
        this.l = textView4;
        this.m = baleToolbar;
    }

    public static C16841lx2 a(View view) {
        int i = AbstractC10176bC5.button;
        MaterialButton materialButton = (MaterialButton) AbstractC11738dW7.a(view, i);
        if (materialButton != null) {
            i = AbstractC10176bC5.country_name;
            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
            if (textView != null) {
                i = AbstractC10176bC5.country_picker_layout;
                MaterialCardView materialCardView = (MaterialCardView) AbstractC11738dW7.a(view, i);
                if (materialCardView != null) {
                    i = AbstractC10176bC5.input_country_code;
                    EditTextWithPrefix editTextWithPrefix = (EditTextWithPrefix) AbstractC11738dW7.a(view, i);
                    if (editTextWithPrefix != null) {
                        i = AbstractC10176bC5.input_name;
                        EditText editText = (EditText) AbstractC11738dW7.a(view, i);
                        if (editText != null) {
                            i = AbstractC10176bC5.input_numbers;
                            PhoneNumberEditText phoneNumberEditText = (PhoneNumberEditText) AbstractC11738dW7.a(view, i);
                            if (phoneNumberEditText != null) {
                                i = AbstractC10176bC5.name_helper;
                                TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                                if (textView2 != null) {
                                    i = AbstractC10176bC5.name_input_layout;
                                    MaterialCardView materialCardView2 = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                    if (materialCardView2 != null) {
                                        i = AbstractC10176bC5.phone_input_layout;
                                        MaterialCardView materialCardView3 = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                        if (materialCardView3 != null) {
                                            i = AbstractC10176bC5.title_name;
                                            TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                                            if (textView3 != null) {
                                                i = AbstractC10176bC5.title_phone;
                                                TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                                                if (textView4 != null) {
                                                    i = AbstractC10176bC5.toolbar;
                                                    BaleToolbar baleToolbar = (BaleToolbar) AbstractC11738dW7.a(view, i);
                                                    if (baleToolbar != null) {
                                                        return new C16841lx2((ScrollView) view, materialButton, textView, materialCardView, editTextWithPrefix, editText, phoneNumberEditText, textView2, materialCardView2, materialCardView3, textView3, textView4, baleToolbar);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C16841lx2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC10801cD5.fragment_add_contact, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ScrollView getRoot() {
        return this.a;
    }
}
