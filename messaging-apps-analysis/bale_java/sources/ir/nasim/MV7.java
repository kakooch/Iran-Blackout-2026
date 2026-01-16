package ir.nasim;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

/* loaded from: classes5.dex */
public final class MV7 implements InterfaceC20718sU7 {
    private final ImageView a;
    private final Drawable b;
    private final Drawable c;
    private final UA2 d;
    private Boolean e;

    public MV7(ImageView imageView, Drawable drawable, Drawable drawable2, UA2 ua2) {
        AbstractC13042fc3.i(imageView, "volumeStateImageView");
        AbstractC13042fc3.i(ua2, "onItemClicked");
        this.a = imageView;
        this.b = drawable;
        this.c = drawable2;
        this.d = ua2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(MV7 mv7, boolean z, View view) {
        AbstractC13042fc3.i(mv7, "this$0");
        mv7.d.invoke(Boolean.valueOf(z));
    }

    @Override // ir.nasim.InterfaceC20718sU7
    public void a() {
        this.e = null;
        ImageView imageView = this.a;
        imageView.setOnClickListener(null);
        imageView.setImageDrawable(null);
        imageView.setVisibility(8);
    }

    @Override // ir.nasim.InterfaceC20718sU7
    public void h(long j, final boolean z) {
        if (AbstractC13042fc3.d(this.e, Boolean.valueOf(z))) {
            return;
        }
        this.e = Boolean.valueOf(z);
        ImageView imageView = this.a;
        imageView.setImageDrawable(z ? this.b : this.c);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.LV7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MV7.c(this.a, z, view);
            }
        });
        imageView.setVisibility(0);
    }

    @Override // ir.nasim.InterfaceC20718sU7
    public void j(float f, float f2) {
        this.e = null;
        ImageView imageView = this.a;
        imageView.setOnClickListener(null);
        imageView.setImageDrawable(null);
        imageView.setVisibility(8);
    }

    @Override // ir.nasim.InterfaceC20718sU7
    public void l(com.google.android.exoplayer2.E0 e0, float f) {
        AbstractC13042fc3.i(e0, "player");
        this.e = null;
        ImageView imageView = this.a;
        imageView.setOnClickListener(null);
        imageView.setImageDrawable(null);
        imageView.setVisibility(8);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ MV7(ImageView imageView, Drawable drawable, Drawable drawable2, UA2 ua2, int i, ED1 ed1) {
        Drawable drawableF;
        Drawable drawable3 = null;
        if ((i & 2) != 0) {
            drawableF = AbstractC4043Dl1.f(imageView.getContext(), KB5.icon_volume_off);
            if (drawableF != null) {
                Context context = imageView.getContext();
                AbstractC13042fc3.h(context, "getContext(...)");
                drawableF.setTint(OY0.b(context, AbstractC21139tA5.colorOnPrimary));
                double d = 24;
                drawableF.setBounds(0, 0, (int) ((AbstractC3742Cd6.c() * d) + 0.5d), (int) ((d * AbstractC3742Cd6.c()) + 0.5d));
            } else {
                drawableF = null;
            }
        } else {
            drawableF = drawable;
        }
        if ((i & 4) != 0) {
            Drawable drawableF2 = AbstractC4043Dl1.f(imageView.getContext(), KB5.icon_volume_up);
            if (drawableF2 != null) {
                Context context2 = imageView.getContext();
                AbstractC13042fc3.h(context2, "getContext(...)");
                drawableF2.setTint(OY0.b(context2, AbstractC21139tA5.colorOnPrimary));
                double d2 = 24;
                drawableF2.setBounds(0, 0, (int) ((AbstractC3742Cd6.c() * d2) + 0.5d), (int) ((d2 * AbstractC3742Cd6.c()) + 0.5d));
                drawable3 = drawableF2;
            }
        } else {
            drawable3 = drawable2;
        }
        this(imageView, drawableF, drawable3, ua2);
    }
}
