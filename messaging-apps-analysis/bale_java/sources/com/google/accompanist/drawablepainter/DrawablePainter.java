package com.google.accompanist.drawablepainter;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC13472gH6;
import ir.nasim.AbstractC20723sV3;
import ir.nasim.AbstractC23053wG5;
import ir.nasim.AbstractC24975zX0;
import ir.nasim.AbstractC7624Sn;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC8831Xn;
import ir.nasim.C02;
import ir.nasim.EV4;
import ir.nasim.EnumC12613eu3;
import ir.nasim.InterfaceC17460n02;
import ir.nasim.InterfaceC9102Ym4;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.OD6;
import ir.nasim.SA2;
import ir.nasim.UE0;
import ir.nasim.YM5;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u001a\u001a\u00020\u0007*\u00020\u0019H\u0014¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR+\u0010(\u001a\u00020 2\u0006\u0010!\u001a\u00020 8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R4\u0010/\u001a\u00020)2\u0006\u0010!\u001a\u00020)8B@BX\u0082\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b*\u0010#\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001b\u00105\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001d\u00107\u001a\u00020)8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b6\u0010,\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00068"}, d2 = {"Lcom/google/accompanist/drawablepainter/DrawablePainter;", "Lir/nasim/EV4;", "Lir/nasim/YM5;", "Landroid/graphics/drawable/Drawable;", "drawable", "<init>", "(Landroid/graphics/drawable/Drawable;)V", "Lir/nasim/rB7;", "b", "()V", "d", "e", "", "alpha", "", "a", "(F)Z", "Lir/nasim/zX0;", "colorFilter", "c", "(Lir/nasim/zX0;)Z", "Lir/nasim/eu3;", "layoutDirection", "f", "(Lir/nasim/eu3;)Z", "Lir/nasim/n02;", "n", "(Lir/nasim/n02;)V", "g", "Landroid/graphics/drawable/Drawable;", "t", "()Landroid/graphics/drawable/Drawable;", "", "<set-?>", "h", "Lir/nasim/Ym4;", "s", "()I", "v", "(I)V", "drawInvalidateTick", "Lir/nasim/OD6;", "i", "u", "()J", "w", "(J)V", "drawableIntrinsicSize", "Landroid/graphics/drawable/Drawable$Callback;", "j", "Lir/nasim/Yu3;", "r", "()Landroid/graphics/drawable/Drawable$Callback;", "callback", "l", "intrinsicSize", "drawablepainter_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes2.dex */
public final class DrawablePainter extends EV4 implements YM5 {

    /* renamed from: g, reason: from kotlin metadata */
    private final Drawable drawable;

    /* renamed from: h, reason: from kotlin metadata */
    private final InterfaceC9102Ym4 drawInvalidateTick;

    /* renamed from: i, reason: from kotlin metadata */
    private final InterfaceC9102Ym4 drawableIntrinsicSize;

    /* renamed from: j, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 callback;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC12613eu3.values().length];
            try {
                iArr[EnumC12613eu3.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC12613eu3.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    static final class b extends AbstractC8614Ws3 implements SA2 {

        public static final class a implements Drawable.Callback {
            final /* synthetic */ DrawablePainter a;

            a(DrawablePainter drawablePainter) {
                this.a = drawablePainter;
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(Drawable drawable) {
                AbstractC13042fc3.i(drawable, "d");
                DrawablePainter drawablePainter = this.a;
                drawablePainter.v(drawablePainter.s() + 1);
                DrawablePainter drawablePainter2 = this.a;
                drawablePainter2.w(C02.c(drawablePainter2.getDrawable()));
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
                AbstractC13042fc3.i(drawable, "d");
                AbstractC13042fc3.i(runnable, "what");
                C02.d().postAtTime(runnable, j);
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                AbstractC13042fc3.i(drawable, "d");
                AbstractC13042fc3.i(runnable, "what");
                C02.d().removeCallbacks(runnable);
            }
        }

        b() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a invoke() {
            return new a(DrawablePainter.this);
        }
    }

    public DrawablePainter(Drawable drawable) {
        AbstractC13042fc3.i(drawable, "drawable");
        this.drawable = drawable;
        this.drawInvalidateTick = AbstractC13472gH6.d(0, null, 2, null);
        this.drawableIntrinsicSize = AbstractC13472gH6.d(OD6.c(C02.c(drawable)), null, 2, null);
        this.callback = AbstractC13269fw3.a(new b());
        if (drawable.getIntrinsicWidth() < 0 || drawable.getIntrinsicHeight() < 0) {
            return;
        }
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    }

    private final Drawable.Callback r() {
        return (Drawable.Callback) this.callback.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int s() {
        return ((Number) this.drawInvalidateTick.getValue()).intValue();
    }

    private final long u() {
        return ((OD6) this.drawableIntrinsicSize.getValue()).m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(int i) {
        this.drawInvalidateTick.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(long j) {
        this.drawableIntrinsicSize.setValue(OD6.c(j));
    }

    @Override // ir.nasim.EV4
    protected boolean a(float alpha) {
        this.drawable.setAlpha(AbstractC23053wG5.m(AbstractC20723sV3.d(alpha * 255), 0, 255));
        return true;
    }

    @Override // ir.nasim.YM5
    public void b() {
        this.drawable.setCallback(r());
        this.drawable.setVisible(true, true);
        Object obj = this.drawable;
        if (obj instanceof Animatable) {
            ((Animatable) obj).start();
        }
    }

    @Override // ir.nasim.EV4
    protected boolean c(AbstractC24975zX0 colorFilter) {
        this.drawable.setColorFilter(colorFilter != null ? AbstractC8831Xn.b(colorFilter) : null);
        return true;
    }

    @Override // ir.nasim.YM5
    public void d() {
        e();
    }

    @Override // ir.nasim.YM5
    public void e() {
        Object obj = this.drawable;
        if (obj instanceof Animatable) {
            ((Animatable) obj).stop();
        }
        this.drawable.setVisible(false, false);
        this.drawable.setCallback(null);
    }

    @Override // ir.nasim.EV4
    protected boolean f(EnumC12613eu3 layoutDirection) {
        AbstractC13042fc3.i(layoutDirection, "layoutDirection");
        Drawable drawable = this.drawable;
        int i = a.a[layoutDirection.ordinal()];
        int i2 = 1;
        if (i == 1) {
            i2 = 0;
        } else if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return drawable.setLayoutDirection(i2);
    }

    @Override // ir.nasim.EV4
    /* renamed from: l */
    public long getIntrinsicSize() {
        return u();
    }

    @Override // ir.nasim.EV4
    protected void n(InterfaceC17460n02 interfaceC17460n02) {
        AbstractC13042fc3.i(interfaceC17460n02, "<this>");
        UE0 ue0E = interfaceC17460n02.z1().e();
        s();
        this.drawable.setBounds(0, 0, AbstractC20723sV3.d(OD6.i(interfaceC17460n02.d())), AbstractC20723sV3.d(OD6.g(interfaceC17460n02.d())));
        try {
            ue0E.n();
            this.drawable.draw(AbstractC7624Sn.d(ue0E));
        } finally {
            ue0E.i();
        }
    }

    /* renamed from: t, reason: from getter */
    public final Drawable getDrawable() {
        return this.drawable;
    }
}
