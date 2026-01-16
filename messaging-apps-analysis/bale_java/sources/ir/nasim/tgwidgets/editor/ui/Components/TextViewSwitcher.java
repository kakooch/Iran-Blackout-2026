package ir.nasim.tgwidgets.editor.ui.Components;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ViewSwitcher;

/* loaded from: classes7.dex */
public class TextViewSwitcher extends ViewSwitcher {
    public TextViewSwitcher(Context context) {
        super(context);
    }

    public void a() {
        getCurrentView().invalidate();
        getNextView().invalidate();
    }

    @Override // android.widget.ViewSwitcher, android.widget.ViewAnimator, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof TextView)) {
            throw new IllegalArgumentException();
        }
        super.addView(view, i, layoutParams);
    }

    public void setText(CharSequence charSequence) {
        setText(charSequence, true);
    }

    @Override // android.widget.ViewAnimator
    public TextView getCurrentView() {
        return (TextView) super.getCurrentView();
    }

    @Override // android.widget.ViewSwitcher
    public TextView getNextView() {
        return (TextView) super.getNextView();
    }

    public void setText(CharSequence charSequence, boolean z) {
        if (TextUtils.equals(charSequence, getCurrentView().getText())) {
            return;
        }
        if (!z) {
            getCurrentView().setText(charSequence);
        } else {
            getNextView().setText(charSequence);
            showNext();
        }
    }
}
