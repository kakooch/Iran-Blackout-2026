package ir.nasim.tgwidgets.editor.ui.Components;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import ir.nasim.N57;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;

/* loaded from: classes7.dex */
public class G extends MetricAffectingSpan {
    private int a;
    private int b;
    private a c;

    public static class a {
        public int a;
        public int b;
        public int c;
        public N57 d;

        public a() {
        }

        public void a(TextPaint textPaint) {
            Typeface typefaceB = b();
            if (typefaceB != null) {
                textPaint.setTypeface(typefaceB);
            }
            if ((this.a & 16) != 0) {
                textPaint.setFlags(textPaint.getFlags() | 8);
            } else {
                textPaint.setFlags(textPaint.getFlags() & (-9));
            }
            if ((this.a & 8) != 0) {
                textPaint.setFlags(textPaint.getFlags() | 16);
            } else {
                textPaint.setFlags(textPaint.getFlags() & (-17));
            }
            if ((this.a & 512) != 0) {
                textPaint.bgColor = ir.nasim.tgwidgets.editor.ui.ActionBar.m.i0(ir.nasim.tgwidgets.editor.ui.ActionBar.m.x8);
            }
        }

        public Typeface b() {
            int i = this.a;
            if ((i & 4) != 0 || (i & 32) != 0) {
                return Typeface.MONOSPACE;
            }
            if ((i & 1) != 0 && (i & 2) != 0) {
                return AbstractC21455b.q0("fonts/rmediumitalic.ttf");
            }
            if ((i & 1) != 0) {
                return AbstractC21455b.q0("fonts/rmedium.ttf");
            }
            if ((i & 2) != 0) {
                return AbstractC21455b.q0("fonts/ritalic.ttf");
            }
            return null;
        }

        public void c(a aVar) {
            N57 n57;
            this.a |= aVar.a;
            if (this.d != null || (n57 = aVar.d) == null) {
                return;
            }
            this.d = n57;
        }

        public a(a aVar) {
            this.a = aVar.a;
            this.b = aVar.b;
            this.c = aVar.c;
            this.d = aVar.d;
        }
    }

    public G(a aVar) {
        this(aVar, 0, 0);
    }

    public boolean a() {
        return (this.c.a & 256) > 0;
    }

    public void b(boolean z) {
        if (z) {
            this.c.a |= 512;
        } else {
            this.c.a &= -513;
        }
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        int i = this.a;
        if (i != 0) {
            textPaint.setTextSize(i);
        }
        int i2 = this.b;
        if (i2 != 0) {
            textPaint.setColor(i2);
        }
        textPaint.setFlags(textPaint.getFlags() | 128);
        this.c.a(textPaint);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        int i = this.a;
        if (i != 0) {
            textPaint.setTextSize(i);
        }
        textPaint.setFlags(textPaint.getFlags() | 128);
        this.c.a(textPaint);
    }

    public G(a aVar, int i, int i2) {
        this.c = aVar;
        if (i > 0) {
            this.a = i;
        }
        this.b = i2;
    }
}
