package ir.eitaa.messenger.camera;

import ir.eitaa.messenger.R;

/* loaded from: classes.dex */
public final class Size {
    public final int mHeight;
    public final int mWidth;

    public Size(int width, int height) {
        this.mWidth = width;
        this.mHeight = height;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        return this.mWidth == size.mWidth && this.mHeight == size.mHeight;
    }

    public String toString() {
        return this.mWidth + "x" + this.mHeight;
    }

    private static NumberFormatException invalidSize(String s) {
        throw new NumberFormatException("Invalid Size: \"" + s + "\"");
    }

    public static Size parseSize(String string) throws NumberFormatException {
        int iIndexOf = string.indexOf(42);
        if (iIndexOf < 0) {
            iIndexOf = string.indexOf(R.styleable.AppCompatTheme_windowNoTitle);
        }
        if (iIndexOf < 0) {
            throw invalidSize(string);
        }
        try {
            return new Size(Integer.parseInt(string.substring(0, iIndexOf)), Integer.parseInt(string.substring(iIndexOf + 1)));
        } catch (NumberFormatException unused) {
            throw invalidSize(string);
        }
    }

    public int hashCode() {
        int i = this.mHeight;
        int i2 = this.mWidth;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }
}
