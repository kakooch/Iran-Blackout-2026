package ir.eitaa.ui.Components;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.tgnet.TLRPC$MessageEntity;

/* loaded from: classes3.dex */
public class TextStyleSpan extends MetricAffectingSpan {
    private int color;
    private TextStyleRun style;
    private int textSize;

    public static class TextStyleRun {
        public int end;
        public int flags;
        public int start;
        public TLRPC$MessageEntity urlEntity;

        public TextStyleRun() {
        }

        public TextStyleRun(TextStyleRun run) {
            this.flags = run.flags;
            this.start = run.start;
            this.end = run.end;
            this.urlEntity = run.urlEntity;
        }

        public void merge(TextStyleRun run) {
            TLRPC$MessageEntity tLRPC$MessageEntity;
            this.flags |= run.flags;
            if (this.urlEntity != null || (tLRPC$MessageEntity = run.urlEntity) == null) {
                return;
            }
            this.urlEntity = tLRPC$MessageEntity;
        }

        public void replace(TextStyleRun run) {
            this.flags = run.flags;
            this.urlEntity = run.urlEntity;
        }

        public void applyStyle(TextPaint p) {
            Typeface typeface = getTypeface();
            if (typeface != null) {
                p.setTypeface(typeface);
            }
            if ((this.flags & 16) != 0) {
                p.setFlags(p.getFlags() | 8);
            } else {
                p.setFlags(p.getFlags() & (-9));
            }
            if ((this.flags & 8) != 0) {
                p.setFlags(p.getFlags() | 16);
            } else {
                p.setFlags(p.getFlags() & (-17));
            }
        }

        public Typeface getTypeface() {
            int i = this.flags;
            if ((i & 4) != 0 || (i & 32) != 0) {
                return AndroidUtilities.getFontFamily(false);
            }
            if ((i & 1) != 0 && (i & 2) != 0) {
                return AndroidUtilities.getFontFamily(true, true);
            }
            if ((i & 1) != 0) {
                return AndroidUtilities.getFontFamily(true);
            }
            if ((i & 2) != 0) {
                return AndroidUtilities.getFontFamily(false, true);
            }
            return AndroidUtilities.getFontFamily(false);
        }
    }

    public TextStyleSpan(TextStyleRun run) {
        this(run, 0, 0);
    }

    public TextStyleSpan(TextStyleRun run, int size, int textColor) {
        this.style = run;
        if (size > 0) {
            this.textSize = size;
        }
        this.color = textColor;
    }

    public int getStyleFlags() {
        return this.style.flags;
    }

    public TextStyleRun getTextStyleRun() {
        return this.style;
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint p) {
        int i = this.textSize;
        if (i != 0) {
            p.setTextSize(i);
        }
        p.setFlags(p.getFlags() | 128);
        this.style.applyStyle(p);
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint p) {
        int i = this.textSize;
        if (i != 0) {
            p.setTextSize(i);
        }
        int i2 = this.color;
        if (i2 != 0) {
            p.setColor(i2);
        }
        p.setFlags(p.getFlags() | 128);
        this.style.applyStyle(p);
    }
}
