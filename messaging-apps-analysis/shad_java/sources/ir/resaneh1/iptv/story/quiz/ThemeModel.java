package ir.resaneh1.iptv.story.quiz;

/* loaded from: classes4.dex */
public class ThemeModel {
    private int endColor;
    private boolean isGradient;
    private int startColor;

    public ThemeModel(int i, int i2, boolean z) {
        this.startColor = i;
        this.endColor = i2;
        this.isGradient = z;
    }

    public int getStartColor() {
        return this.startColor;
    }

    public int getEndColor() {
        return this.endColor;
    }

    public boolean isGradient() {
        return this.isGradient;
    }
}
