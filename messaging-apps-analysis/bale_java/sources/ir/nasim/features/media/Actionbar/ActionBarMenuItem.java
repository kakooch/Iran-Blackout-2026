package ir.nasim.features.media.Actionbar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/* loaded from: classes6.dex */
public abstract class ActionBarMenuItem extends FrameLayout {
    protected ImageView a;
    public boolean b;

    public static class a {
        public abstract boolean a();

        public abstract void b(EditText editText);

        public abstract void c(EditText editText);
    }

    public ActionBarMenuItem(Context context) {
        super(context);
        this.b = false;
    }

    public abstract TextView a(int i, String str, int i2);

    public abstract void b();

    public abstract boolean c();

    public abstract void d(int i);

    public abstract boolean e();

    public abstract void f(boolean z);

    public abstract ActionBarMenuItem g(a aVar);

    public abstract EditText getSearchField();

    public abstract ActionBarMenuItem h(boolean z);

    public abstract void i(int i);

    public abstract boolean j(boolean z);

    public abstract void k();

    public abstract void setIcon(int i);

    public ActionBarMenuItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = false;
    }

    public ActionBarMenuItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = false;
    }
}
