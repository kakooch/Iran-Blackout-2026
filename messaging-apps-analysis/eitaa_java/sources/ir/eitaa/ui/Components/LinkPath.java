package ir.eitaa.ui.Components;

import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.text.StaticLayout;
import ir.eitaa.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class LinkPath extends Path {
    private int baselineShift;
    private StaticLayout currentLayout;
    private int currentLine;
    private float heightOffset;
    private int lineHeight;
    private RectF rect;
    private boolean useRoundRect;
    private float lastTop = -1.0f;
    private boolean allowReset = true;

    public LinkPath() {
    }

    public LinkPath(boolean roundRect) {
        this.useRoundRect = roundRect;
    }

    public void setCurrentLayout(StaticLayout layout, int start, float yOffset) {
        int lineCount;
        this.currentLayout = layout;
        this.currentLine = layout.getLineForOffset(start);
        this.lastTop = -1.0f;
        this.heightOffset = yOffset;
        if (Build.VERSION.SDK_INT < 28 || (lineCount = layout.getLineCount()) <= 0) {
            return;
        }
        int i = lineCount - 1;
        this.lineHeight = layout.getLineBottom(i) - layout.getLineTop(i);
    }

    public void setAllowReset(boolean value) {
        this.allowReset = value;
    }

    public void setUseRoundRect(boolean value) {
        this.useRoundRect = value;
    }

    public void setBaselineShift(int value) {
        this.baselineShift = value;
    }

    @Override // android.graphics.Path
    public void addRect(float left, float top, float right, float bottom, Path.Direction dir) {
        float f = this.heightOffset;
        float f2 = top + f;
        float spacingAdd = bottom + f;
        float f3 = this.lastTop;
        if (f3 == -1.0f) {
            this.lastTop = f2;
        } else if (f3 != f2) {
            this.lastTop = f2;
            this.currentLine++;
        }
        float lineRight = this.currentLayout.getLineRight(this.currentLine);
        float lineLeft = this.currentLayout.getLineLeft(this.currentLine);
        if (left < lineRight) {
            if (left > lineLeft || right > lineLeft) {
                float f4 = right > lineRight ? lineRight : right;
                float f5 = left < lineLeft ? lineLeft : left;
                if (Build.VERSION.SDK_INT < 28) {
                    spacingAdd -= spacingAdd != ((float) this.currentLayout.getHeight()) ? this.currentLayout.getSpacingAdd() : 0.0f;
                } else if (spacingAdd - f2 > this.lineHeight) {
                    spacingAdd = this.heightOffset + (spacingAdd != ((float) this.currentLayout.getHeight()) ? this.currentLayout.getLineBottom(this.currentLine) - this.currentLayout.getSpacingAdd() : 0.0f);
                }
                int i = this.baselineShift;
                if (i < 0) {
                    spacingAdd += i;
                } else if (i > 0) {
                    f2 += i;
                }
                float f6 = f2;
                float f7 = spacingAdd;
                if (this.useRoundRect) {
                    if (this.rect == null) {
                        this.rect = new RectF();
                    }
                    this.rect.set(f5 - AndroidUtilities.dp(4.0f), f6, f4 + AndroidUtilities.dp(4.0f), f7);
                    super.addRoundRect(this.rect, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), dir);
                    return;
                }
                super.addRect(f5, f6, f4, f7, dir);
            }
        }
    }

    @Override // android.graphics.Path
    public void reset() {
        if (this.allowReset) {
            super.reset();
        }
    }
}
