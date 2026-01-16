package ir.nasim;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.wP5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C23134wP5 extends RecyclerView.C {
    public static final a w = new a(null);
    private final AppCompatTextView u;
    private final UA2 v;

    /* renamed from: ir.nasim.wP5$a */
    public static final class a {
        private a() {
        }

        public final C23134wP5 a(ViewGroup viewGroup, UA2 ua2) {
            AbstractC13042fc3.i(viewGroup, "parent");
            AbstractC13042fc3.i(ua2, "onItemClicked");
            AppCompatTextView appCompatTextView = new AppCompatTextView(viewGroup.getContext());
            appCompatTextView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            appCompatTextView.setTypeface(C6011Lu2.k());
            Context context = appCompatTextView.getContext();
            AbstractC13042fc3.h(context, "getContext(...)");
            appCompatTextView.setTextColor(OY0.b(context, AbstractC15199jA5.n500));
            AbstractC15575jo7.p(appCompatTextView, AbstractC17008mE5.TextAppearance_Bale_Label_1);
            int iC = (int) ((12 * AbstractC3742Cd6.c()) + 0.5d);
            int iC2 = (int) ((16 * AbstractC3742Cd6.c()) + 0.5d);
            appCompatTextView.setPadding(iC, iC2, iC, iC2);
            TypedValue typedValue = new TypedValue();
            if (appCompatTextView.getContext().getTheme().resolveAttribute(AbstractC15199jA5.selectableItemBackground, typedValue, true)) {
                appCompatTextView.setBackgroundResource(typedValue.resourceId);
            }
            appCompatTextView.setClickable(true);
            appCompatTextView.setFocusable(true);
            return new C23134wP5(appCompatTextView, ua2, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C23134wP5(AppCompatTextView appCompatTextView, UA2 ua2, ED1 ed1) {
        this(appCompatTextView, ua2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(C23134wP5 c23134wP5, C21948uP5 c21948uP5, View view) {
        AbstractC13042fc3.i(c23134wP5, "this$0");
        AbstractC13042fc3.i(c21948uP5, "$reportItem");
        c23134wP5.v.invoke(c21948uP5);
    }

    public final void D0(final C21948uP5 c21948uP5) {
        AbstractC13042fc3.i(c21948uP5, "reportItem");
        AppCompatTextView appCompatTextView = this.u;
        appCompatTextView.setText(c21948uP5.c());
        Drawable drawableF = AbstractC4043Dl1.f(appCompatTextView.getContext(), c21948uP5.a());
        if (drawableF != null) {
            Context context = appCompatTextView.getContext();
            AbstractC13042fc3.h(context, "getContext(...)");
            AbstractC21710u02.h(drawableF, OY0.b(context, AbstractC15199jA5.n300));
        } else {
            drawableF = null;
        }
        appCompatTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawableF, (Drawable) null, (Drawable) null, (Drawable) null);
        appCompatTextView.setCompoundDrawablePadding((int) ((16 * AbstractC3742Cd6.c()) + 0.5d));
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.vP5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C23134wP5.E0(this.a, c21948uP5, view);
            }
        });
    }

    public final void a() {
        AppCompatTextView appCompatTextView = this.u;
        appCompatTextView.setOnClickListener(null);
        appCompatTextView.setCompoundDrawablesRelative(null, null, null, null);
    }

    private C23134wP5(AppCompatTextView appCompatTextView, UA2 ua2) {
        super(appCompatTextView);
        this.u = appCompatTextView;
        this.v = ua2;
    }
}
