package ir.nasim;

import android.graphics.Typeface;
import android.text.Html;
import android.text.Spanned;
import android.text.method.MovementMethod;
import android.widget.TextView;
import com.skydoves.balloon.vectortext.VectorTextView;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.ko7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC16166ko7 {

    /* renamed from: ir.nasim.ko7$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC22897w03.values().length];
            try {
                iArr[EnumC22897w03.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC22897w03.c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC22897w03.d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC22897w03.b.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0125  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void a(android.widget.TextView r9, ir.nasim.YQ7 r10) {
        /*
            Method dump skipped, instructions count: 403
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC16166ko7.a(android.widget.TextView, ir.nasim.YQ7):void");
    }

    public static final /* synthetic */ void b(VectorTextView vectorTextView, C22301v03 c22301v03) {
        AbstractC13042fc3.i(vectorTextView, "<this>");
        AbstractC13042fc3.i(c22301v03, "iconForm");
        if (c22301v03.a() != null) {
            int iH = c22301v03.h();
            int iF = c22301v03.f();
            int iG = c22301v03.g();
            CharSequence charSequenceD = c22301v03.d();
            Integer numValueOf = Integer.valueOf(c22301v03.c());
            if (!(numValueOf.intValue() != Integer.MIN_VALUE)) {
                numValueOf = null;
            }
            YQ7 yq7 = new YQ7(null, null, null, null, null, null, null, null, false, charSequenceD, Integer.valueOf(iG), Integer.valueOf(iH), Integer.valueOf(iF), null, numValueOf, null, null, null, 238079, null);
            int i = a.a[c22301v03.e().ordinal()];
            if (i == 1) {
                yq7.w(c22301v03.a());
                yq7.x(c22301v03.b());
            } else if (i == 2) {
                yq7.y(c22301v03.a());
                yq7.z(c22301v03.b());
            } else if (i == 3) {
                yq7.s(c22301v03.a());
                yq7.t(c22301v03.b());
            } else if (i == 4) {
                yq7.u(c22301v03.a());
                yq7.v(c22301v03.b());
            }
            vectorTextView.setDrawableTextViewParams(yq7);
        }
    }

    public static final /* synthetic */ void c(TextView textView, C3351Am7 c3351Am7) {
        CharSequence charSequenceC;
        C19938rB7 c19938rB7;
        AbstractC13042fc3.i(textView, "<this>");
        AbstractC13042fc3.i(c3351Am7, "textForm");
        boolean zF = c3351Am7.f();
        if (zF) {
            charSequenceC = d(c3351Am7.c().toString());
        } else {
            if (zF) {
                throw new NoWhenBranchMatchedException();
            }
            charSequenceC = c3351Am7.c();
        }
        textView.setText(charSequenceC);
        textView.setTextSize(c3351Am7.i());
        textView.setGravity(c3351Am7.e());
        textView.setTextColor(c3351Am7.d());
        textView.setIncludeFontPadding(c3351Am7.a());
        Float fH = c3351Am7.h();
        if (fH != null) {
            textView.setLineSpacing(fH.floatValue(), 1.0f);
        }
        Float fG = c3351Am7.g();
        if (fG != null) {
            textView.setLetterSpacing(fG.floatValue());
        }
        Typeface typefaceK = c3351Am7.k();
        if (typefaceK != null) {
            textView.setTypeface(typefaceK);
            c19938rB7 = C19938rB7.a;
        } else {
            c19938rB7 = null;
        }
        if (c19938rB7 == null) {
            textView.setTypeface(textView.getTypeface(), c3351Am7.j());
        }
        MovementMethod movementMethodB = c3351Am7.b();
        if (movementMethodB != null) {
            textView.setMovementMethod(movementMethodB);
        }
    }

    private static final Spanned d(String str) {
        return Html.fromHtml(str, 0);
    }
}
