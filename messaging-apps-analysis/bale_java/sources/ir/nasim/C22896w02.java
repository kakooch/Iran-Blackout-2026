package ir.nasim;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import ir.nasim.InterfaceC22855vv7;

/* renamed from: ir.nasim.w02, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C22896w02 implements InterfaceC22855vv7 {
    private final int a;
    private final boolean b;

    public C22896w02(int i, boolean z) {
        this.a = i;
        this.b = z;
    }

    @Override // ir.nasim.InterfaceC22855vv7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean a(Drawable drawable, InterfaceC22855vv7.a aVar) {
        Drawable drawableD = aVar.d();
        if (drawableD == null) {
            drawableD = new ColorDrawable(0);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{drawableD, drawable});
        transitionDrawable.setCrossFadeEnabled(this.b);
        transitionDrawable.startTransition(this.a);
        aVar.b(transitionDrawable);
        return true;
    }
}
