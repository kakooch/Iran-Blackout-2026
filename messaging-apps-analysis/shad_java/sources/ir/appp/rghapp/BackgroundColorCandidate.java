package ir.appp.rghapp;

/* loaded from: classes3.dex */
public class BackgroundColorCandidate {
    float colorDifferenceRatio;
    float colorPopulationRatio;
    int colorRGB;
    float colorWeight;

    public BackgroundColorCandidate(int i, float f, float f2) {
        this.colorDifferenceRatio = f;
        this.colorPopulationRatio = f2;
        this.colorRGB = i;
        this.colorWeight = f + f2;
    }

    public int getColorRGB() {
        return this.colorRGB;
    }

    public float getColorWeight() {
        return this.colorWeight;
    }
}
