package ir.nasim;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/* renamed from: ir.nasim.Lk7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C5927Lk7 extends AbstractC18241oK2 {
    private final ViewGroup f;
    private final ViewOnTouchListenerC5933Ll4 g;
    private final C24159y85 h;
    private final Typeface i;
    private final C19423qK2 j;
    private TextView k;

    /* JADX WARN: Illegal instructions before constructor call */
    public C5927Lk7(ViewGroup viewGroup, ViewOnTouchListenerC5933Ll4 viewOnTouchListenerC5933Ll4, C24159y85 c24159y85, Typeface typeface, C19423qK2 c19423qK2) {
        AbstractC13042fc3.i(viewGroup, "mPhotoEditorView");
        AbstractC13042fc3.i(viewOnTouchListenerC5933Ll4, "mMultiTouchListener");
        AbstractC13042fc3.i(c24159y85, "mViewState");
        AbstractC13042fc3.i(c19423qK2, "mGraphicManager");
        Context context = viewGroup.getContext();
        ZX7 zx7 = ZX7.TEXT;
        int i = VC5.view_photo_editor_text;
        AbstractC13042fc3.h(context, "context");
        super(context, i, zx7, c19423qK2);
        this.f = viewGroup;
        this.g = viewOnTouchListenerC5933Ll4;
        this.h = c24159y85;
        this.i = typeface;
        this.j = c19423qK2;
        l();
    }

    private final void l() {
        this.g.j(b(this.f, this.h));
        d().setOnTouchListener(this.g);
    }

    @Override // ir.nasim.AbstractC18241oK2
    public void h(View view) {
        AbstractC13042fc3.i(view, "rootView");
        TextView textView = (TextView) view.findViewById(AbstractC20554sC5.tvPhotoEditorText);
        this.k = textView;
        if (textView == null) {
            return;
        }
        textView.setGravity(17);
        textView.setTypeface(this.i);
    }

    @Override // ir.nasim.AbstractC18241oK2
    public void j(View view) {
        TextView textView = this.k;
        String strValueOf = String.valueOf(textView == null ? null : textView.getText());
        TextView textView2 = this.k;
        int currentTextColor = textView2 == null ? 0 : textView2.getCurrentTextColor();
        LJ4 lj4B = this.j.b();
        if (lj4B == null) {
            return;
        }
        lj4B.j0(view, strValueOf, currentTextColor);
    }

    public final void k(String str, C9940ao7 c9940ao7) {
        TextView textView = this.k;
        if (textView == null) {
            return;
        }
        textView.setText(str);
        if (c9940ao7 == null) {
            return;
        }
        c9940ao7.e(textView);
    }
}
