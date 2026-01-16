package ir.resaneh1.iptv.story.emojiSlider;

/* loaded from: classes4.dex */
public class ThemeModel {
    private int backgroundColor;
    private boolean isGradient;
    private int seekBarBackgroundColor;
    private int seekBarForegroundColor;
    private int textColor;

    public ThemeModel(int i, int i2, int i3, int i4, boolean z) {
        this.backgroundColor = i;
        this.seekBarBackgroundColor = i2;
        this.seekBarForegroundColor = i3;
        this.textColor = i4;
        this.isGradient = z;
    }

    public int getBackgroundColor() {
        return this.backgroundColor;
    }

    public int getSeekBarBackgroundColor() {
        return this.seekBarBackgroundColor;
    }

    public int getSeekBarForegroundColor() {
        return this.seekBarForegroundColor;
    }

    public int getTextColor() {
        return this.textColor;
    }

    public boolean isGradient() {
        return this.isGradient;
    }
}
