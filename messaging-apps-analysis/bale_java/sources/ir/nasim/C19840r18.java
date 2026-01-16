package ir.nasim;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.r18, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19840r18 extends RecyclerView.C {
    private final int u;
    private final UA2 v;
    private final FU w;
    private final ImageView x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C19840r18(View view, int i, UA2 ua2) {
        super(view);
        AbstractC13042fc3.i(view, "itemView");
        this.u = i;
        this.v = ua2;
        Context context = view.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        this.w = new FU(context);
        View viewFindViewById = view.findViewById(AbstractC19354qC5.image);
        AbstractC13042fc3.h(viewFindViewById, "findViewById(...)");
        this.x = (ImageView) viewFindViewById;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 H0() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 J0(C19840r18 c19840r18, Drawable drawable) {
        AbstractC13042fc3.i(c19840r18, "this$0");
        AbstractC13042fc3.i(drawable, "resource");
        c19840r18.x.setImageDrawable(drawable);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(C19840r18 c19840r18, C20610sI7 c20610sI7, View view) {
        AbstractC13042fc3.i(c19840r18, "this$0");
        AbstractC13042fc3.i(c20610sI7, "$user");
        UA2 ua2 = c19840r18.v;
        if (ua2 != null) {
            ua2.invoke(c20610sI7);
        }
    }

    public final void F0(final C20610sI7 c20610sI7) {
        AbstractC13042fc3.i(c20610sI7, "user");
        this.x.setImageDrawable(c20610sI7.c());
        this.w.e(c20610sI7, this.u, new SA2() { // from class: ir.nasim.o18
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C19840r18.H0();
            }
        }, new UA2() { // from class: ir.nasim.p18
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C19840r18.J0(this.a, (Drawable) obj);
            }
        });
        this.x.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.q18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C19840r18.L0(this.a, c20610sI7, view);
            }
        });
    }

    public final void a() {
        this.x.setImageDrawable(null);
        this.x.setOnClickListener(null);
        this.w.d();
    }
}
