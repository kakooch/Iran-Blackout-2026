package ir.nasim;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;

/* renamed from: ir.nasim.ez7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C12664ez7 {
    public static final C12664ez7 a = new C12664ez7();
    private static ThreadLocal b = new ThreadLocal();

    /* renamed from: ir.nasim.ez7$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ WH1 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(WH1 wh1) {
            super(1);
            this.e = wh1;
        }

        public final CharSequence a(InterfaceC4125Du2 interfaceC4125Du2) {
            return '\'' + interfaceC4125Du2.b() + "' " + interfaceC4125Du2.a(this.e);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            AbstractC18350oW3.a(obj);
            return a(null);
        }
    }

    private C12664ez7() {
    }

    private final String b(C4359Eu2 c4359Eu2, Context context) {
        return AbstractC12806fC3.e(c4359Eu2.a(), null, null, null, 0, null, new a(AbstractC6427No.a(context)), 31, null);
    }

    public final Typeface a(Typeface typeface, C4359Eu2 c4359Eu2, Context context) {
        if (typeface == null) {
            return null;
        }
        if (c4359Eu2.a().isEmpty()) {
            return typeface;
        }
        Paint paint = (Paint) b.get();
        if (paint == null) {
            paint = new Paint();
            b.set(paint);
        }
        paint.setFontVariationSettings(null);
        paint.setTypeface(typeface);
        paint.setFontVariationSettings(b(c4359Eu2, context));
        return paint.getTypeface();
    }
}
