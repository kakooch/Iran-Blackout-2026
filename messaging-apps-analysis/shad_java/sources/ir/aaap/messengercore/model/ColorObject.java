package ir.aaap.messengercore.model;

import android.graphics.Color;

/* loaded from: classes3.dex */
public class ColorObject {
    public int alpha;
    public int blue;
    public int green;
    public int red;

    public ColorObject(int i, int i2, int i3) {
        this.red = 0;
        this.green = 0;
        this.blue = 0;
        this.alpha = 255;
        this.red = i;
        this.green = i2;
        this.blue = i3;
    }

    public ColorObject() {
        this.red = 0;
        this.green = 0;
        this.blue = 0;
        this.alpha = 255;
    }

    public int getColor() {
        try {
            return Color.argb(this.alpha, this.red, this.green, this.blue);
        } catch (Exception unused) {
            return -7829368;
        }
    }

    public int getColor(int i) {
        try {
            return Color.argb(i, this.red, this.green, this.blue);
        } catch (Exception unused) {
            return -7829368;
        }
    }

    public static ColorObject getColorObject(int i) {
        ColorObject colorObject = new ColorObject();
        colorObject.red = Color.red(i);
        colorObject.green = Color.green(i);
        colorObject.blue = Color.blue(i);
        colorObject.alpha = Color.alpha(i);
        return colorObject;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ColorObject)) {
            return false;
        }
        ColorObject colorObject = (ColorObject) obj;
        return this.red == colorObject.red && this.green == colorObject.green && this.blue == colorObject.blue && this.alpha == colorObject.alpha;
    }
}
