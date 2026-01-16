package ir.nasim;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.ListAdapter;
import androidx.appcompat.app.a;

/* loaded from: classes3.dex */
public class TU3 extends a.C0011a {
    private static final int e = AbstractC12181eA5.alertDialogStyle;
    private static final int f = AbstractC21175tE5.MaterialAlertDialog_MaterialComponents;
    private static final int g = AbstractC12181eA5.materialAlertDialogTheme;
    private Drawable c;
    private final Rect d;

    public TU3(Context context) {
        this(context, 0);
    }

    private static Context l(Context context) {
        int iM = m(context);
        Context contextC = AbstractC17750nV3.c(context, null, e, f);
        return iM == 0 ? contextC : new C16731lm1(contextC, iM);
    }

    private static int m(Context context) {
        TypedValue typedValueA = UU3.a(context, g);
        if (typedValueA == null) {
            return 0;
        }
        return typedValueA.data;
    }

    private static int n(Context context, int i) {
        return i == 0 ? m(context) : i;
    }

    @Override // androidx.appcompat.app.a.C0011a
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public TU3 setTitle(CharSequence charSequence) {
        return (TU3) super.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.a.C0011a
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public TU3 setView(View view) {
        return (TU3) super.setView(view);
    }

    @Override // androidx.appcompat.app.a.C0011a
    public androidx.appcompat.app.a create() {
        androidx.appcompat.app.a aVarCreate = super.create();
        Window window = aVarCreate.getWindow();
        View decorView = window.getDecorView();
        Drawable drawable = this.c;
        if (drawable instanceof C10345bV3) {
            ((C10345bV3) drawable).a0(AbstractC12990fW7.v(decorView));
        }
        window.setBackgroundDrawable(XU3.b(this.c, this.d));
        decorView.setOnTouchListener(new K93(aVarCreate, this.d));
        return aVarCreate;
    }

    @Override // androidx.appcompat.app.a.C0011a
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public TU3 a(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
        return (TU3) super.a(listAdapter, onClickListener);
    }

    @Override // androidx.appcompat.app.a.C0011a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public TU3 b(View view) {
        return (TU3) super.b(view);
    }

    @Override // androidx.appcompat.app.a.C0011a
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public TU3 c(Drawable drawable) {
        return (TU3) super.c(drawable);
    }

    @Override // androidx.appcompat.app.a.C0011a
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public TU3 d(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
        return (TU3) super.d(charSequenceArr, onClickListener);
    }

    @Override // androidx.appcompat.app.a.C0011a
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public TU3 e(int i) {
        return (TU3) super.e(i);
    }

    @Override // androidx.appcompat.app.a.C0011a
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public TU3 f(CharSequence charSequence) {
        return (TU3) super.f(charSequence);
    }

    @Override // androidx.appcompat.app.a.C0011a
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public TU3 setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
        return (TU3) super.setNegativeButton(i, onClickListener);
    }

    @Override // androidx.appcompat.app.a.C0011a
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public TU3 g(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        return (TU3) super.g(charSequence, onClickListener);
    }

    @Override // androidx.appcompat.app.a.C0011a
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public TU3 h(DialogInterface.OnKeyListener onKeyListener) {
        return (TU3) super.h(onKeyListener);
    }

    @Override // androidx.appcompat.app.a.C0011a
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public TU3 setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
        return (TU3) super.setPositiveButton(i, onClickListener);
    }

    @Override // androidx.appcompat.app.a.C0011a
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public TU3 i(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        return (TU3) super.i(charSequence, onClickListener);
    }

    @Override // androidx.appcompat.app.a.C0011a
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public TU3 j(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
        return (TU3) super.j(listAdapter, i, onClickListener);
    }

    public TU3(Context context, int i) {
        super(l(context), n(context, i));
        Context context2 = getContext();
        Resources.Theme theme = context2.getTheme();
        int i2 = e;
        int i3 = f;
        this.d = XU3.a(context2, i2, i3);
        int iC = WU3.c(context2, AbstractC12181eA5.colorSurface, getClass().getCanonicalName());
        C10345bV3 c10345bV3 = new C10345bV3(context2, null, i2, i3);
        c10345bV3.Q(context2);
        c10345bV3.b0(ColorStateList.valueOf(iC));
        if (Build.VERSION.SDK_INT >= 28) {
            TypedValue typedValue = new TypedValue();
            theme.resolveAttribute(android.R.attr.dialogCornerRadius, typedValue, true);
            float dimension = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            if (typedValue.type == 5 && dimension >= 0.0f) {
                c10345bV3.Y(dimension);
            }
        }
        this.c = c10345bV3;
    }
}
