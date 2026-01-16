package ir.nasim;

import android.graphics.RectF;
import android.util.Rational;
import android.util.Size;
import java.util.Comparator;

/* renamed from: ir.nasim.qK, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC19420qK {
    public static final Rational a = new Rational(4, 3);
    public static final Rational b = new Rational(3, 4);
    public static final Rational c = new Rational(16, 9);
    public static final Rational d = new Rational(9, 16);

    /* renamed from: ir.nasim.qK$a */
    public static final class a implements Comparator {
        private final Rational a;
        private final RectF b;
        private final Rational c;

        public a(Rational rational, Rational rational2) {
            this.a = rational;
            this.c = rational2 == null ? new Rational(4, 3) : rational2;
            this.b = d(rational);
        }

        private float b(RectF rectF) {
            return rectF.width() * rectF.height();
        }

        private float c(RectF rectF, RectF rectF2) {
            return (rectF.width() < rectF2.width() ? rectF.width() : rectF2.width()) * (rectF.height() < rectF2.height() ? rectF.height() : rectF2.height());
        }

        private RectF d(Rational rational) {
            return rational.floatValue() == this.c.floatValue() ? new RectF(0.0f, 0.0f, this.c.getNumerator(), this.c.getDenominator()) : rational.floatValue() > this.c.floatValue() ? new RectF(0.0f, 0.0f, this.c.getNumerator(), (rational.getDenominator() * this.c.getNumerator()) / rational.getNumerator()) : new RectF(0.0f, 0.0f, (rational.getNumerator() * this.c.getDenominator()) / rational.getDenominator(), this.c.getDenominator());
        }

        private boolean e(RectF rectF, RectF rectF2) {
            return rectF.width() >= rectF2.width() && rectF.height() >= rectF2.height();
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Rational rational, Rational rational2) {
            if (rational.equals(rational2)) {
                return 0;
            }
            RectF rectFD = d(rational);
            RectF rectFD2 = d(rational2);
            boolean zE = e(rectFD, this.b);
            boolean zE2 = e(rectFD2, this.b);
            if (zE && zE2) {
                return (int) Math.signum(b(rectFD) - b(rectFD2));
            }
            if (zE) {
                return -1;
            }
            if (zE2) {
                return 1;
            }
            return -((int) Math.signum(c(rectFD, this.b) - c(rectFD2, this.b)));
        }
    }

    public static boolean a(Size size, Rational rational) {
        return b(size, rational, AbstractC10811cE6.c);
    }

    public static boolean b(Size size, Rational rational, Size size2) {
        if (rational == null) {
            return false;
        }
        if (rational.equals(new Rational(size.getWidth(), size.getHeight()))) {
            return true;
        }
        if (AbstractC10811cE6.b(size) >= AbstractC10811cE6.b(size2)) {
            return c(size, rational);
        }
        return false;
    }

    private static boolean c(Size size, Rational rational) {
        int width = size.getWidth();
        int height = size.getHeight();
        Rational rational2 = new Rational(rational.getDenominator(), rational.getNumerator());
        int i = width % 16;
        if (i == 0 && height % 16 == 0) {
            return d(Math.max(0, height + (-16)), width, rational) || d(Math.max(0, width + (-16)), height, rational2);
        }
        if (i == 0) {
            return d(height, width, rational);
        }
        if (height % 16 == 0) {
            return d(width, height, rational2);
        }
        return false;
    }

    private static boolean d(int i, int i2, Rational rational) {
        AbstractC4980Hj5.a(i2 % 16 == 0);
        double numerator = (i * rational.getNumerator()) / rational.getDenominator();
        return numerator > ((double) Math.max(0, i2 + (-16))) && numerator < ((double) (i2 + 16));
    }
}
