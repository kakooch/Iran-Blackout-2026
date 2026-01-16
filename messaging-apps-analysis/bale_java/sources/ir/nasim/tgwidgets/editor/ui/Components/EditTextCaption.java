package ir.nasim.tgwidgets.editor.ui.Components;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.CharacterStyle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import ir.nasim.AbstractC18763pC5;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.FH3;
import ir.nasim.R62;
import ir.nasim.TD5;
import ir.nasim.X2;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.ActionBar.AlertDialog;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import ir.nasim.tgwidgets.editor.ui.Components.EditTextCaption;
import ir.nasim.tgwidgets.editor.ui.Components.G;
import java.util.List;

/* loaded from: classes7.dex */
public class EditTextCaption extends EditTextBoldCursor {
    private String B1;
    private StaticLayout C1;
    private int D1;
    private int E1;
    private int F1;
    private int G1;
    private boolean H1;
    private int I1;
    private e J1;
    private int K1;
    private int L1;
    private boolean M1;
    private float N1;
    private int O1;
    private boolean P1;
    private final m.h Q1;

    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (EditTextCaption.this.O1 != EditTextCaption.this.getLineCount()) {
                if (!EditTextCaption.this.P1 && EditTextCaption.this.getMeasuredWidth() > 0) {
                    EditTextCaption editTextCaption = EditTextCaption.this;
                    editTextCaption.c0(editTextCaption.O1, EditTextCaption.this.getLineCount());
                }
                EditTextCaption editTextCaption2 = EditTextCaption.this;
                editTextCaption2.O1 = editTextCaption2.getLineCount();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    class b extends EditTextBoldCursor {
        b(Context context) {
            super(context);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.EditTextBoldCursor, android.widget.TextView, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(AbstractC21455b.F(64.0f), 1073741824));
        }
    }

    class c implements ActionMode.Callback {
        final /* synthetic */ ActionMode.Callback a;

        c(ActionMode.Callback callback) {
            this.a = callback;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            if (EditTextCaption.this.e0(menuItem.getItemId())) {
                actionMode.finish();
                return true;
            }
            try {
                return this.a.onActionItemClicked(actionMode, menuItem);
            } catch (Exception unused) {
                return true;
            }
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            EditTextCaption.this.H1 = true;
            EditTextCaption.this.b0();
            return this.a.onCreateActionMode(actionMode, menu);
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            EditTextCaption.this.H1 = false;
            EditTextCaption.this.a0();
            this.a.onDestroyActionMode(actionMode);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return this.a.onPrepareActionMode(actionMode, menu);
        }
    }

    class d extends ActionMode.Callback2 {
        final /* synthetic */ ActionMode.Callback a;
        final /* synthetic */ ActionMode.Callback b;

        d(ActionMode.Callback callback, ActionMode.Callback callback2) {
            this.a = callback;
            this.b = callback2;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.a.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.a.onCreateActionMode(actionMode, menu);
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            this.a.onDestroyActionMode(actionMode);
        }

        @Override // android.view.ActionMode.Callback2
        public void onGetContentRect(ActionMode actionMode, View view, Rect rect) {
            ActionMode.Callback callback = this.b;
            if (callback instanceof ActionMode.Callback2) {
                ((ActionMode.Callback2) callback).onGetContentRect(actionMode, view, rect);
            } else {
                super.onGetContentRect(actionMode, view, rect);
            }
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return this.a.onPrepareActionMode(actionMode, menu);
        }
    }

    public interface e {
        void a();
    }

    public EditTextCaption(Context context, m.h hVar) {
        super(context);
        this.G1 = 0;
        this.K1 = -1;
        this.L1 = -1;
        this.Q1 = hVar;
        addTextChangedListener(new a());
        setClipToPadding(true);
    }

    private void O(G g) {
        if (this.K1 < 0 || this.L1 < 0) {
            getSelectionStart();
            getSelectionEnd();
        } else {
            this.L1 = -1;
            this.K1 = -1;
        }
        e eVar = this.J1;
        if (eVar != null) {
            eVar.a();
        }
    }

    private int P(int i) {
        return ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(i, this.Q1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(int i, int i2, EditTextBoldCursor editTextBoldCursor, DialogInterface dialogInterface, int i3) {
        Editable text = getText();
        CharacterStyle[] characterStyleArr = (CharacterStyle[]) text.getSpans(i, i2, CharacterStyle.class);
        if (characterStyleArr != null && characterStyleArr.length > 0) {
            for (CharacterStyle characterStyle : characterStyleArr) {
                if (!(characterStyle instanceof AnimatedEmojiSpan)) {
                    int spanStart = text.getSpanStart(characterStyle);
                    int spanEnd = text.getSpanEnd(characterStyle);
                    text.removeSpan(characterStyle);
                    if (spanStart < i) {
                        text.setSpan(characterStyle, spanStart, i, 33);
                    }
                    if (spanEnd > i2) {
                        text.setSpan(characterStyle, i2, spanEnd, 33);
                    }
                }
            }
        }
        try {
            text.setSpan(new URLSpanReplacement(editTextBoldCursor.getText().toString()), i, i2, 33);
        } catch (Exception unused) {
        }
        e eVar = this.J1;
        if (eVar != null) {
            eVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void R(EditTextBoldCursor editTextBoldCursor, DialogInterface dialogInterface) {
        editTextBoldCursor.requestFocus();
        AbstractC21455b.C1(editTextBoldCursor);
    }

    private ActionMode.Callback d0(ActionMode.Callback callback) {
        return new d(new c(callback), callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e0(int i) {
        if (i == AbstractC18763pC5.menu_regular) {
            V();
            return true;
        }
        if (i == AbstractC18763pC5.menu_bold) {
            S();
            return true;
        }
        if (i == AbstractC18763pC5.menu_italic) {
            T();
            return true;
        }
        if (i == AbstractC18763pC5.menu_mono) {
            U();
            return true;
        }
        if (i == AbstractC18763pC5.menu_link) {
            Z();
            return true;
        }
        if (i == AbstractC18763pC5.menu_strike) {
            X();
            return true;
        }
        if (i == AbstractC18763pC5.menu_underline) {
            Y();
            return true;
        }
        if (i != AbstractC18763pC5.menu_spoiler) {
            return false;
        }
        W();
        return true;
    }

    public void S() {
        G.a aVar = new G.a();
        aVar.a |= 1;
        O(new G(aVar));
    }

    public void T() {
        G.a aVar = new G.a();
        aVar.a |= 2;
        O(new G(aVar));
    }

    public void U() {
        G.a aVar = new G.a();
        aVar.a |= 4;
        O(new G(aVar));
    }

    public void V() {
        O(null);
    }

    public void W() {
        G.a aVar = new G.a();
        aVar.a |= 256;
        O(new G(aVar));
        i();
    }

    public void X() {
        G.a aVar = new G.a();
        aVar.a |= 8;
        O(new G(aVar));
    }

    public void Y() {
        G.a aVar = new G.a();
        aVar.a |= 16;
        O(new G(aVar));
    }

    public void Z() {
        final int selectionEnd;
        AlertDialog.i iVar = new AlertDialog.i(getContext(), this.Q1);
        iVar.j(FH3.E("CreateLink", TD5.tgwidget_CreateLink));
        final b bVar = new b(getContext());
        bVar.setTextSize(1, 18.0f);
        bVar.setText("http://");
        bVar.setTextColor(P(ir.nasim.tgwidgets.editor.ui.ActionBar.m.V3));
        bVar.setHintText(FH3.E("URL", TD5.tgwidget_URL));
        bVar.setHeaderHintColor(P(ir.nasim.tgwidgets.editor.ui.ActionBar.m.u5));
        bVar.setSingleLine(true);
        bVar.setFocusable(true);
        bVar.setTransformHintToHeader(true);
        bVar.setLineColors(P(ir.nasim.tgwidgets.editor.ui.ActionBar.m.T4), P(ir.nasim.tgwidgets.editor.ui.ActionBar.m.U4), P(ir.nasim.tgwidgets.editor.ui.ActionBar.m.X5));
        bVar.setImeOptions(6);
        bVar.setBackgroundDrawable(null);
        bVar.requestFocus();
        bVar.setPadding(0, 0, 0, 0);
        iVar.o(bVar);
        final int selectionStart = this.K1;
        if (selectionStart < 0 || (selectionEnd = this.L1) < 0) {
            selectionStart = getSelectionStart();
            selectionEnd = getSelectionEnd();
        } else {
            this.L1 = -1;
            this.K1 = -1;
        }
        iVar.i(FH3.E("OK", TD5.tgwidget_OK), new DialogInterface.OnClickListener() { // from class: ir.nasim.r42
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.a.Q(selectionStart, selectionEnd, bVar, dialogInterface, i);
            }
        });
        iVar.f(FH3.E("Cancel", TD5.tgwidget_Cancel), null);
        iVar.q().setOnShowListener(new DialogInterface.OnShowListener() { // from class: ir.nasim.s42
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                EditTextCaption.R(bVar, dialogInterface);
            }
        });
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) bVar.getLayoutParams();
        if (marginLayoutParams != null) {
            if (marginLayoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) marginLayoutParams).gravity = 1;
            }
            int iF = AbstractC21455b.F(24.0f);
            marginLayoutParams.leftMargin = iF;
            marginLayoutParams.rightMargin = iF;
            marginLayoutParams.height = AbstractC21455b.F(36.0f);
            bVar.setLayoutParams(marginLayoutParams);
        }
        bVar.setSelection(0, bVar.getText().length());
    }

    protected void a0() {
    }

    protected void b0() {
    }

    protected void c0(int i, int i2) {
    }

    public String getCaption() {
        return this.B1;
    }

    public float getOffsetY() {
        return this.N1;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.EditTextBoldCursor, ir.nasim.tgwidgets.editor.ui.Components.EditTextEffects, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) throws IllegalAccessException, IllegalArgumentException {
        canvas.save();
        canvas.translate(0.0f, this.N1);
        super.onDraw(canvas);
        try {
            if (this.C1 != null && this.D1 == length()) {
                TextPaint paint = getPaint();
                int color = getPaint().getColor();
                paint.setColor(this.I1);
                canvas.save();
                canvas.translate(this.E1, this.F1);
                this.C1.draw(canvas);
                canvas.restore();
                paint.setColor(color);
            }
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
        }
        canvas.restore();
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.EditTextBoldCursor, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        X2 x2G1 = X2.g1(accessibilityNodeInfo);
        if (!TextUtils.isEmpty(this.B1)) {
            x2G1.C0(this.B1);
        }
        List listI = x2G1.i();
        int size = listI.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            X2.a aVar = (X2.a) listI.get(i);
            if (aVar.b() == 268435456) {
                x2G1.f0(aVar);
                break;
            }
            i++;
        }
        if (hasSelection()) {
            x2G1.b(new X2.a(AbstractC18763pC5.menu_spoiler, FH3.E("Spoiler", TD5.tgwidget_Spoiler)));
            x2G1.b(new X2.a(AbstractC18763pC5.menu_bold, FH3.E("Bold", TD5.tgwidget_Bold)));
            x2G1.b(new X2.a(AbstractC18763pC5.menu_italic, FH3.E("Italic", TD5.tgwidget_Italic)));
            x2G1.b(new X2.a(AbstractC18763pC5.menu_mono, FH3.E("Mono", TD5.tgwidget_Mono)));
            x2G1.b(new X2.a(AbstractC18763pC5.menu_strike, FH3.E("Strike", TD5.tgwidget_Strike)));
            x2G1.b(new X2.a(AbstractC18763pC5.menu_underline, FH3.E("Underline", TD5.tgwidget_Underline)));
            x2G1.b(new X2.a(AbstractC18763pC5.menu_link, FH3.E("CreateLink", TD5.tgwidget_CreateLink)));
            x2G1.b(new X2.a(AbstractC18763pC5.menu_regular, FH3.E("Regular", TD5.tgwidget_Regular)));
        }
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.EditTextBoldCursor, android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        int iIndexOf;
        try {
            this.P1 = getMeasuredWidth() == 0 && getMeasuredHeight() == 0;
            super.onMeasure(i, i2);
            if (this.P1) {
                this.O1 = getLineCount();
            }
            this.P1 = false;
        } catch (Exception e2) {
            setMeasuredDimension(View.MeasureSpec.getSize(i), AbstractC21455b.F(51.0f));
            AbstractC6403Nl2.d(e2);
        }
        this.C1 = null;
        String str = this.B1;
        if (str == null || str.length() <= 0) {
            return;
        }
        Editable text = getText();
        if (text.length() <= 1 || text.charAt(0) != '@' || (iIndexOf = TextUtils.indexOf((CharSequence) text, ' ')) == -1) {
            return;
        }
        TextPaint paint = getPaint();
        CharSequence charSequenceSubSequence = text.subSequence(0, iIndexOf + 1);
        int iCeil = (int) Math.ceil(paint.measureText(text, 0, r13));
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        this.D1 = charSequenceSubSequence.length();
        int i3 = measuredWidth - iCeil;
        CharSequence charSequenceEllipsize = TextUtils.ellipsize(this.B1, paint, i3, TextUtils.TruncateAt.END);
        this.E1 = iCeil;
        try {
            StaticLayout staticLayout = new StaticLayout(charSequenceEllipsize, getPaint(), i3, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            this.C1 = staticLayout;
            if (staticLayout.getLineCount() > 0) {
                this.E1 = (int) (this.E1 + (-this.C1.getLineLeft(0)));
            }
            this.F1 = ((getMeasuredHeight() - this.C1.getLineBottom(0)) / 2) + AbstractC21455b.F(0.5f);
        } catch (Exception e3) {
            AbstractC6403Nl2.d(e3);
        }
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i) {
        if (i == 16908322) {
            ClipData primaryClip = ((ClipboardManager) getContext().getSystemService("clipboard")).getPrimaryClip();
            if (primaryClip != null && primaryClip.getItemCount() == 1 && primaryClip.getDescription().hasMimeType("text/html")) {
                try {
                    Spannable spannableNewSpannable = new Spannable.Factory().newSpannable(primaryClip.getItemAt(0).getHtmlText());
                    R62.T(spannableNewSpannable, getPaint().getFontMetricsInt(), AbstractC21455b.F(20.0f), false, null);
                    AnimatedEmojiSpan[] animatedEmojiSpanArr = (AnimatedEmojiSpan[]) spannableNewSpannable.getSpans(0, spannableNewSpannable.length(), AnimatedEmojiSpan.class);
                    if (animatedEmojiSpanArr != null) {
                        for (AnimatedEmojiSpan animatedEmojiSpan : animatedEmojiSpanArr) {
                            animatedEmojiSpan.b(getPaint().getFontMetricsInt(), C21463b.i());
                        }
                    }
                    int iMax = Math.max(0, getSelectionStart());
                    setText(getText().replace(iMax, Math.min(getText().length(), getSelectionEnd()), spannableNewSpannable));
                    setSelection(spannableNewSpannable.length() + iMax, iMax + spannableNewSpannable.length());
                    return true;
                } catch (Exception e2) {
                    AbstractC6403Nl2.d(e2);
                }
            }
        } else {
            try {
                if (i == 16908321) {
                    AbstractC21455b.p(getText().subSequence(Math.max(0, getSelectionStart()), Math.min(getText().length(), getSelectionEnd())));
                    return true;
                }
                if (i == 16908320) {
                    int iMax2 = Math.max(0, getSelectionStart());
                    int iMin = Math.min(getText().length(), getSelectionEnd());
                    AbstractC21455b.p(getText().subSequence(iMax2, iMin));
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    if (iMax2 != 0) {
                        spannableStringBuilder.append(getText().subSequence(0, iMax2));
                    }
                    if (iMin != getText().length()) {
                        spannableStringBuilder.append(getText().subSequence(iMin, getText().length()));
                    }
                    setText(spannableStringBuilder);
                    setSelection(iMax2, iMax2);
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return super.onTextContextMenuItem(i);
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        try {
            super.onWindowFocusChanged(z);
        } catch (Throwable th) {
            AbstractC6403Nl2.d(th);
        }
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        return e0(i) || super.performAccessibilityAction(i, bundle);
    }

    public void setAllowTextEntitiesIntersection(boolean z) {
        this.M1 = z;
    }

    public void setCaption(String str) {
        String str2 = this.B1;
        if ((str2 == null || str2.length() == 0) && (str == null || str.length() == 0)) {
            return;
        }
        String str3 = this.B1;
        if (str3 == null || !str3.equals(str)) {
            this.B1 = str;
            if (str != null) {
                this.B1 = str.replace('\n', ' ');
            }
            requestLayout();
        }
    }

    public void setDelegate(e eVar) {
        this.J1 = eVar;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.EditTextBoldCursor
    public void setHintColor(int i) {
        super.setHintColor(i);
        this.I1 = i;
        invalidate();
    }

    public void setOffsetY(float f) {
        this.N1 = f;
        invalidate();
    }

    public void setSelectionOverride(int i, int i2) {
        this.K1 = i;
        this.L1 = i2;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.EditTextBoldCursor, android.view.View
    public ActionMode startActionMode(ActionMode.Callback callback, int i) {
        return super.startActionMode(d0(callback), i);
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.EditTextBoldCursor, android.view.View
    public ActionMode startActionMode(ActionMode.Callback callback) {
        return super.startActionMode(d0(callback));
    }
}
