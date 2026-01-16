package ir.nasim;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: ir.nasim.ao7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C9940ao7 {
    private final Map a = new LinkedHashMap();

    /* renamed from: ir.nasim.ao7$a */
    public enum a {
        SIZE("TextSize"),
        COLOR("TextColor"),
        GRAVITY("Gravity"),
        FONT_FAMILY("FontFamily"),
        BACKGROUND("Background"),
        TEXT_APPEARANCE("TextAppearance"),
        TEXT_STYLE("TextStyle"),
        TEXT_FLAG("TextFlag"),
        SHADOW("Shadow"),
        BORDER("Border");

        private final String a;

        a(String str) {
            this.a = str;
        }
    }

    /* renamed from: ir.nasim.ao7$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.values().length];
            iArr[a.SIZE.ordinal()] = 1;
            iArr[a.COLOR.ordinal()] = 2;
            iArr[a.FONT_FAMILY.ordinal()] = 3;
            iArr[a.GRAVITY.ordinal()] = 4;
            iArr[a.BACKGROUND.ordinal()] = 5;
            iArr[a.TEXT_APPEARANCE.ordinal()] = 6;
            iArr[a.TEXT_STYLE.ordinal()] = 7;
            iArr[a.TEXT_FLAG.ordinal()] = 8;
            iArr[a.SHADOW.ordinal()] = 9;
            iArr[a.BORDER.ordinal()] = 10;
            a = iArr;
        }
    }

    protected void a(TextView textView, int i) {
        AbstractC13042fc3.i(textView, "textView");
        textView.setBackgroundColor(i);
    }

    protected void b(TextView textView, Drawable drawable) {
        AbstractC13042fc3.i(textView, "textView");
        textView.setBackground(drawable);
    }

    protected void c(TextView textView, Typeface typeface) {
        AbstractC13042fc3.i(textView, "textView");
        textView.setTypeface(typeface);
    }

    protected void d(TextView textView, int i) {
        AbstractC13042fc3.i(textView, "textView");
        textView.setGravity(i);
    }

    public final void e(TextView textView) {
        AbstractC13042fc3.i(textView, "textView");
        for (Map.Entry entry : this.a.entrySet()) {
            a aVar = (a) entry.getKey();
            Object value = entry.getValue();
            switch (b.a[aVar.ordinal()]) {
                case 1:
                    i(textView, ((Float) value).floatValue());
                    break;
                case 2:
                    g(textView, ((Integer) value).intValue());
                    break;
                case 3:
                    c(textView, (Typeface) value);
                    break;
                case 4:
                    d(textView, ((Integer) value).intValue());
                    break;
                case 5:
                    if (value instanceof Drawable) {
                        b(textView, (Drawable) value);
                        break;
                    } else if (value instanceof Integer) {
                        a(textView, ((Number) value).intValue());
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (value instanceof Integer) {
                        f(textView, ((Number) value).intValue());
                        break;
                    } else {
                        break;
                    }
                case 7:
                    j(textView, ((Integer) value).intValue());
                    break;
                case 8:
                    h(textView, ((Integer) value).intValue());
                    break;
            }
        }
    }

    protected void f(TextView textView, int i) {
        AbstractC13042fc3.i(textView, "textView");
        textView.setTextAppearance(i);
    }

    protected void g(TextView textView, int i) {
        AbstractC13042fc3.i(textView, "textView");
        textView.setTextColor(i);
    }

    protected void h(TextView textView, int i) {
        AbstractC13042fc3.i(textView, "textView");
        textView.getPaint().setFlags(i);
    }

    protected void i(TextView textView, float f) {
        AbstractC13042fc3.i(textView, "textView");
        textView.setTextSize(f);
    }

    protected void j(TextView textView, int i) {
        AbstractC13042fc3.i(textView, "textView");
        textView.setTypeface(textView.getTypeface(), i);
    }

    public final void k(int i) {
        this.a.put(a.COLOR, Integer.valueOf(i));
    }

    public final void l(Typeface typeface) {
        AbstractC13042fc3.i(typeface, "textTypeface");
        this.a.put(a.FONT_FAMILY, typeface);
    }

    public final void m(float f) {
        this.a.put(a.SIZE, Float.valueOf(f));
    }
}
