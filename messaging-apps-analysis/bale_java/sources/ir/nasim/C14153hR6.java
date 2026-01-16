package ir.nasim;

import android.app.Dialog;
import android.content.Context;
import android.gov.nist.core.Separators;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.google.android.material.card.MaterialCardView;
import ir.nasim.designsystem.button.BaleButton;
import ir.nasim.story.model.StoryWidget;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 =2\u00020\u0001:\u0001>B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u0003J\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001b\u0010\u000fJ\u000f\u0010\u001c\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u0003J\u000f\u0010\u001d\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u0003J\u000f\u0010\u001e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u0003J\u000f\u0010\u001f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010\u0003J+\u0010'\u001a\u00020&2\u0006\u0010!\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b'\u0010(J!\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b*\u0010+J\u0019\u0010-\u001a\u00020,2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0004H\u0016¢\u0006\u0004\b/\u0010\u0003R\u001b\u00105\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006?"}, d2 = {"Lir/nasim/hR6;", "Lcom/google/android/material/bottomsheet/b;", "<init>", "()V", "Lir/nasim/rB7;", "i9", "Landroidx/appcompat/widget/AppCompatEditText;", "g9", "()Landroidx/appcompat/widget/AppCompatEditText;", "h9", "()Lir/nasim/rB7;", "e9", "", "it", "Z8", "(Ljava/lang/String;)V", "appCompatEditText", "Lir/nasim/PZ;", "baleEditTextBinding", "c9", "(Landroidx/appcompat/widget/AppCompatEditText;Lir/nasim/PZ;)V", "link", "", "j9", "(Ljava/lang/String;)Z", "m9", "error", "o9", "n9", "k9", "l9", "a9", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "B8", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "U6", "Lir/nasim/mk0;", "n1", "Lir/nasim/bW7;", "b9", "()Lir/nasim/mk0;", "binding", "Lir/nasim/story/model/StoryWidget$LinkWidget;", "o1", "Lir/nasim/story/model/StoryWidget$LinkWidget;", "storyLink", "p1", "Z", "firstInit", "q1", "a", "story_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.hR6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C14153hR6 extends com.google.android.material.bottomsheet.b {

    /* renamed from: o1, reason: from kotlin metadata */
    private StoryWidget.LinkWidget storyLink;
    static final /* synthetic */ InterfaceC5239Im3[] r1 = {AbstractC10882cM5.i(new C25226zw5(C14153hR6.class, "binding", "getBinding()Lir/nasim/databinding/BottomSheetStoryLinkBinding;", 0))};

    /* renamed from: q1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int s1 = 8;

    /* renamed from: n1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new e(), AbstractC20046rN7.c());

    /* renamed from: p1, reason: from kotlin metadata */
    private boolean firstInit = true;

    /* renamed from: ir.nasim.hR6$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C14153hR6 a(StoryWidget.LinkWidget linkWidget) {
            C14153hR6 c14153hR6 = new C14153hR6();
            Bundle bundle = new Bundle();
            bundle.putString("BUNDLE_STORY_LINK", linkWidget != null ? linkWidget.a() : null);
            bundle.putString("BUNDLE_STORY_LINK_TITLE", linkWidget != null ? linkWidget.getTitle() : null);
            c14153hR6.a8(bundle);
            return c14153hR6;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.hR6$d */
    public static final class d extends com.google.android.material.bottomsheet.a {
        d(Context context, int i) {
            super(context, i);
            o().J0(3);
        }
    }

    /* renamed from: ir.nasim.hR6$e */
    public static final class e extends AbstractC8614Ws3 implements UA2 {
        public e() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C17301mk0.a(fragment.V7());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z8(String it) {
        if (j9(it)) {
            l9();
            m9();
        } else {
            k9();
            String strH6 = h6(AbstractC12217eE5.story_wrong_link);
            AbstractC13042fc3.h(strH6, "getString(...)");
            o9(strH6);
        }
    }

    private final void a9() {
        ConstraintLayout root = b9().getRoot();
        AbstractC13042fc3.f(root);
        AbstractC16172kp3.a(root);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C17301mk0 b9() {
        Object objA = this.binding.a(this, r1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C17301mk0) objA;
    }

    private final void c9(AppCompatEditText appCompatEditText, final PZ baleEditTextBinding) {
        appCompatEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.gR6
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                C14153hR6.d9(baleEditTextBinding, view, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d9(PZ pz, View view, boolean z) {
        AbstractC13042fc3.i(pz, "$baleEditTextBinding");
        if (z) {
            pz.b.setStrokeColor(C5495Jo7.a.Y());
        } else {
            pz.b.setStrokeColor(C5495Jo7.a.B2());
        }
    }

    private final void e9() {
        BaleButton baleButton = b9().c;
        baleButton.setText(h6(AbstractC12217eE5.story_save_link));
        k9();
        baleButton.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.fR6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C14153hR6.f9(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f9(C14153hR6 c14153hR6, View view) {
        AbstractC13042fc3.i(c14153hR6, "this$0");
        c14153hR6.firstInit = false;
        String strValueOf = String.valueOf(c14153hR6.b9().h.c.getText());
        c14153hR6.Z8(strValueOf);
        if (c14153hR6.j9(strValueOf)) {
            Bundle bundle = new Bundle();
            bundle.putString("KEY_LINK", strValueOf);
            bundle.putString("KEY_LINK_TITLE", String.valueOf(c14153hR6.b9().g.c.getText()));
            c14153hR6.a9();
            AbstractC18623oy2.c(c14153hR6, "REQUEST_CODE_LINK_BOTTOM_SHEET", bundle);
            AbstractC16494lN1.a(c14153hR6);
        }
    }

    private final AppCompatEditText g9() {
        PZ pz = b9().h;
        TextView textView = pz.e;
        AbstractC13042fc3.h(textView, "tvCounter");
        textView.setVisibility(8);
        TextView textView2 = pz.d;
        textView2.setText(h6(AbstractC12217eE5.story_link));
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        textView2.setTextColor(c5495Jo7.v0());
        MaterialCardView materialCardView = pz.b;
        materialCardView.setStrokeColor(c5495Jo7.B2());
        materialCardView.setStrokeWidth(C22078ud6.a(1.5f));
        TextView textView3 = pz.f;
        textView3.setTypeface(C6011Lu2.k());
        textView3.setText(h6(AbstractC12217eE5.story_link_guide));
        textView3.setTextColor(c5495Jo7.v0());
        AppCompatEditText appCompatEditText = pz.c;
        appCompatEditText.setTextAlignment(2);
        appCompatEditText.setTextColor(c5495Jo7.w0());
        appCompatEditText.setHintTextColor(c5495Jo7.u0());
        appCompatEditText.setHint("bale.ai/terms");
        StoryWidget.LinkWidget linkWidget = this.storyLink;
        if (linkWidget != null) {
            appCompatEditText.setText(linkWidget.a());
        }
        appCompatEditText.setSingleLine();
        appCompatEditText.setMaxLines(1);
        ViewGroup.LayoutParams layoutParams = appCompatEditText.getLayoutParams();
        AbstractC13042fc3.g(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMargins(C22078ud6.a(16.0f), C22078ud6.a(-8.0f), C22078ud6.a(16.0f), C22078ud6.a(0.0f));
        appCompatEditText.setLayoutParams(marginLayoutParams);
        AbstractC13042fc3.f(appCompatEditText);
        appCompatEditText.addTextChangedListener(new b());
        AbstractC13042fc3.f(pz);
        c9(appCompatEditText, pz);
        AbstractC13042fc3.h(appCompatEditText, "with(...)");
        return appCompatEditText;
    }

    private final C19938rB7 h9() {
        String title;
        PZ pz = b9().g;
        TextView textView = pz.e;
        AbstractC13042fc3.h(textView, "tvCounter");
        textView.setVisibility(8);
        TextView textView2 = pz.f;
        AbstractC13042fc3.h(textView2, "tvError");
        textView2.setVisibility(8);
        TextView textView3 = pz.d;
        textView3.setText(h6(AbstractC12217eE5.story_link_title));
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        textView3.setTextColor(c5495Jo7.v0());
        MaterialCardView materialCardView = pz.b;
        materialCardView.setStrokeColor(c5495Jo7.B2());
        materialCardView.setStrokeWidth(C22078ud6.a(1.5f));
        AppCompatEditText appCompatEditText = pz.c;
        appCompatEditText.setTextColor(c5495Jo7.w0());
        appCompatEditText.setHintTextColor(c5495Jo7.u0());
        appCompatEditText.setHint(h6(AbstractC12217eE5.story_link_title_hint));
        appCompatEditText.setSingleLine();
        appCompatEditText.setMaxLines(1);
        ViewGroup.LayoutParams layoutParams = appCompatEditText.getLayoutParams();
        AbstractC13042fc3.g(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMargins(C22078ud6.a(16.0f), C22078ud6.a(-8.0f), C22078ud6.a(16.0f), C22078ud6.a(0.0f));
        appCompatEditText.setLayoutParams(marginLayoutParams);
        AbstractC13042fc3.f(appCompatEditText);
        appCompatEditText.addTextChangedListener(new c());
        AbstractC13042fc3.f(pz);
        c9(appCompatEditText, pz);
        StoryWidget.LinkWidget linkWidget = this.storyLink;
        if (linkWidget == null || (title = linkWidget.getTitle()) == null) {
            return null;
        }
        pz.c.setText(title);
        return C19938rB7.a;
    }

    private final void i9() {
        g9();
        h9();
        e9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j9(String link) {
        return AbstractC20762sZ6.X(link, Separators.DOT, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k9() {
        BaleButton baleButton = b9().c;
        baleButton.setEnabled(false);
        baleButton.setBackgroundColor(AbstractC4043Dl1.c(baleButton.getContext(), TA5.color10));
        baleButton.setTextColor(AbstractC4043Dl1.c(baleButton.getContext(), TA5.color12));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l9() {
        BaleButton baleButton = b9().c;
        baleButton.setEnabled(true);
        baleButton.setBackgroundColor(AbstractC4043Dl1.c(baleButton.getContext(), TA5.primary));
        baleButton.setTextColor(AbstractC4043Dl1.c(baleButton.getContext(), TA5.surface_light));
    }

    private final void m9() {
        b9().h.f.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n9() {
        PZ pz = b9().h;
        pz.f.setText(h6(AbstractC12217eE5.story_link_guide));
        TextView textView = pz.f;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        textView.setTextColor(c5495Jo7.v0());
        pz.b.setStrokeColor(c5495Jo7.B2());
    }

    private final void o9(String error) {
        PZ pz = b9().h;
        pz.f.setText(error);
        TextView textView = pz.f;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        textView.setTextColor(c5495Jo7.B0());
        pz.b.setStrokeColor(c5495Jo7.B0());
    }

    @Override // com.google.android.material.bottomsheet.b, ir.nasim.ZD, androidx.fragment.app.l
    public Dialog B8(Bundle savedInstanceState) {
        return new d(S7(), AbstractC23035wE5.Theme_StoryLinkDialogStyle);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        ConstraintLayout root = C17301mk0.c(inflater, container, false).getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.l, androidx.fragment.app.Fragment
    public void U6() {
        a9();
        super.U6();
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        String string;
        AbstractC13042fc3.i(view, "view");
        Bundle bundleE5 = E5();
        if (bundleE5 != null && (string = bundleE5.getString("BUNDLE_STORY_LINK")) != null) {
            String string2 = bundleE5.getString("BUNDLE_STORY_LINK_TITLE");
            if (string2 == null) {
                string2 = "";
            }
            this.storyLink = new StoryWidget.LinkWidget(string, string2, null, 4, null);
        }
        i9();
    }

    /* renamed from: ir.nasim.hR6$b */
    public static final class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String strValueOf = String.valueOf(editable);
            if (strValueOf.length() <= 0) {
                C14153hR6.this.k9();
                C14153hR6.this.n9();
            } else if (C14153hR6.this.firstInit) {
                C14153hR6.this.l9();
            } else {
                C14153hR6.this.Z8(strValueOf);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: ir.nasim.hR6$c */
    public static final class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String.valueOf(editable);
            if (C14153hR6.this.j9(String.valueOf(C14153hR6.this.b9().h.c.getText()))) {
                C14153hR6.this.l9();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
