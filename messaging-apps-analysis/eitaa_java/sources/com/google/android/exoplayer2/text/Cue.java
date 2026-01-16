package com.google.android.exoplayer2.text;

import android.graphics.Bitmap;
import android.text.Layout;

/* loaded from: classes.dex */
public class Cue {
    public static final Cue EMPTY = new Cue("");
    public final Bitmap bitmap;
    public final float bitmapHeight;
    public final float line;
    public final int lineAnchor;
    public final int lineType;
    public final float position;
    public final int positionAnchor;
    public final float size;
    public final CharSequence text;
    public final Layout.Alignment textAlignment;
    public final float textSize;
    public final int textSizeType;
    public final int windowColor;
    public final boolean windowColorSet;

    public Cue(Bitmap bitmap, float horizontalPosition, int horizontalPositionAnchor, float verticalPosition, int verticalPositionAnchor, float width, float height) {
        this(null, null, bitmap, verticalPosition, 0, verticalPositionAnchor, horizontalPosition, horizontalPositionAnchor, Integer.MIN_VALUE, -3.4028235E38f, width, height, false, -16777216);
    }

    public Cue(CharSequence text) {
        this(text, null, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE, -3.4028235E38f);
    }

    public Cue(CharSequence text, Layout.Alignment textAlignment, float line, int lineType, int lineAnchor, float position, int positionAnchor, float size) {
        this(text, textAlignment, line, lineType, lineAnchor, position, positionAnchor, size, false, -16777216);
    }

    public Cue(CharSequence text, Layout.Alignment textAlignment, float line, int lineType, int lineAnchor, float position, int positionAnchor, float size, int textSizeType, float textSize) {
        this(text, textAlignment, null, line, lineType, lineAnchor, position, positionAnchor, textSizeType, textSize, size, -3.4028235E38f, false, -16777216);
    }

    public Cue(CharSequence text, Layout.Alignment textAlignment, float line, int lineType, int lineAnchor, float position, int positionAnchor, float size, boolean windowColorSet, int windowColor) {
        this(text, textAlignment, null, line, lineType, lineAnchor, position, positionAnchor, Integer.MIN_VALUE, -3.4028235E38f, size, -3.4028235E38f, windowColorSet, windowColor);
    }

    private Cue(CharSequence text, Layout.Alignment textAlignment, Bitmap bitmap, float line, int lineType, int lineAnchor, float position, int positionAnchor, int textSizeType, float textSize, float size, float bitmapHeight, boolean windowColorSet, int windowColor) {
        this.text = text;
        this.textAlignment = textAlignment;
        this.bitmap = bitmap;
        this.line = line;
        this.lineType = lineType;
        this.lineAnchor = lineAnchor;
        this.position = position;
        this.positionAnchor = positionAnchor;
        this.size = size;
        this.bitmapHeight = bitmapHeight;
        this.windowColorSet = windowColorSet;
        this.windowColor = windowColor;
        this.textSizeType = textSizeType;
        this.textSize = textSize;
    }
}
