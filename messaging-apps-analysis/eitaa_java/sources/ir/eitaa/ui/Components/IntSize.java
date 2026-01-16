package ir.eitaa.ui.Components;

/* loaded from: classes3.dex */
public class IntSize {
    public int height;
    public int width;

    public IntSize() {
    }

    public IntSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || IntSize.class != o.getClass()) {
            return false;
        }
        IntSize intSize = (IntSize) o;
        return this.width == intSize.width && this.height == intSize.height;
    }

    public int hashCode() {
        return (this.width * 31) + this.height;
    }

    public String toString() {
        return "IntSize(" + this.width + ", " + this.height + ")";
    }
}
