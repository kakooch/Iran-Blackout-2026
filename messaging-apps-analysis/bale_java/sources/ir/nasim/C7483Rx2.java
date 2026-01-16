package ir.nasim;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.radiobutton.MaterialRadioButton;
import ir.nasim.components.textfield.view.CustomInputView;

/* renamed from: ir.nasim.Rx2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7483Rx2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final MaterialCardView e;
    public final Button f;
    public final MaterialCardView g;
    public final RecyclerView h;
    public final MaterialCardView i;
    public final MaterialRadioButton j;
    public final MaterialCardView k;
    public final RecyclerView l;
    public final CustomInputView m;
    public final CustomInputView n;
    public final CustomInputView o;
    public final NestedScrollView p;
    public final TextView q;
    public final MaterialCardView r;
    public final MaterialRadioButton s;

    private C7483Rx2(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, MaterialCardView materialCardView, Button button, MaterialCardView materialCardView2, RecyclerView recyclerView, MaterialCardView materialCardView3, MaterialRadioButton materialRadioButton, MaterialCardView materialCardView4, RecyclerView recyclerView2, CustomInputView customInputView, CustomInputView customInputView2, CustomInputView customInputView3, NestedScrollView nestedScrollView, TextView textView4, MaterialCardView materialCardView5, MaterialRadioButton materialRadioButton2) {
        this.a = constraintLayout;
        this.b = textView;
        this.c = textView2;
        this.d = textView3;
        this.e = materialCardView;
        this.f = button;
        this.g = materialCardView2;
        this.h = recyclerView;
        this.i = materialCardView3;
        this.j = materialRadioButton;
        this.k = materialCardView4;
        this.l = recyclerView2;
        this.m = customInputView;
        this.n = customInputView2;
        this.o = customInputView3;
        this.p = nestedScrollView;
        this.q = textView4;
        this.r = materialCardView5;
        this.s = materialRadioButton2;
    }

    public static C7483Rx2 a(View view) {
        int i = BC5.addImageTitle;
        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
        if (textView != null) {
            i = BC5.addMoreImage;
            TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
            if (textView2 != null) {
                i = BC5.attachImage;
                TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                if (textView3 != null) {
                    i = BC5.attachImages;
                    MaterialCardView materialCardView = (MaterialCardView) AbstractC11738dW7.a(view, i);
                    if (materialCardView != null) {
                        i = BC5.continueBtn;
                        Button button = (Button) AbstractC11738dW7.a(view, i);
                        if (button != null) {
                            i = BC5.destinationSuggestionCard;
                            MaterialCardView materialCardView2 = (MaterialCardView) AbstractC11738dW7.a(view, i);
                            if (materialCardView2 != null) {
                                i = BC5.destinationSuggestionRecycler;
                                RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
                                if (recyclerView != null) {
                                    i = BC5.dynamicAmountCard;
                                    MaterialCardView materialCardView3 = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                    if (materialCardView3 != null) {
                                        i = BC5.dynamicAmountRadio;
                                        MaterialRadioButton materialRadioButton = (MaterialRadioButton) AbstractC11738dW7.a(view, i);
                                        if (materialRadioButton != null) {
                                            i = BC5.imagesCard;
                                            MaterialCardView materialCardView4 = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                            if (materialCardView4 != null) {
                                                i = BC5.importedPhotos;
                                                RecyclerView recyclerView2 = (RecyclerView) AbstractC11738dW7.a(view, i);
                                                if (recyclerView2 != null) {
                                                    i = BC5.inputAmount;
                                                    CustomInputView customInputView = (CustomInputView) AbstractC11738dW7.a(view, i);
                                                    if (customInputView != null) {
                                                        i = BC5.inputDescription;
                                                        CustomInputView customInputView2 = (CustomInputView) AbstractC11738dW7.a(view, i);
                                                        if (customInputView2 != null) {
                                                            i = BC5.inputDestCardNumber;
                                                            CustomInputView customInputView3 = (CustomInputView) AbstractC11738dW7.a(view, i);
                                                            if (customInputView3 != null) {
                                                                i = BC5.nested_scroll_view;
                                                                NestedScrollView nestedScrollView = (NestedScrollView) AbstractC11738dW7.a(view, i);
                                                                if (nestedScrollView != null) {
                                                                    i = BC5.setAmountMethodTitle;
                                                                    TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                                                                    if (textView4 != null) {
                                                                        i = BC5.staticAmountCard;
                                                                        MaterialCardView materialCardView5 = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                                                        if (materialCardView5 != null) {
                                                                            i = BC5.staticAmountRadio;
                                                                            MaterialRadioButton materialRadioButton2 = (MaterialRadioButton) AbstractC11738dW7.a(view, i);
                                                                            if (materialRadioButton2 != null) {
                                                                                return new C7483Rx2((ConstraintLayout) view, textView, textView2, textView3, materialCardView, button, materialCardView2, recyclerView, materialCardView3, materialRadioButton, materialCardView4, recyclerView2, customInputView, customInputView2, customInputView3, nestedScrollView, textView4, materialCardView5, materialRadioButton2);
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
