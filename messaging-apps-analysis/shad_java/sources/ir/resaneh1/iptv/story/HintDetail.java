package ir.resaneh1.iptv.story;

/* loaded from: classes4.dex */
public class HintDetail {
    private int extraDistance;
    private String hintText;
    private int hintX;
    private int hintY;
    private boolean isPointerTop;

    public HintDetail(int i, int i2, int i3, String str, boolean z) {
        this.hintX = i;
        this.hintY = i2;
        this.extraDistance = i3;
        this.hintText = str;
        this.isPointerTop = z;
    }

    public boolean isPointerTop() {
        return this.isPointerTop;
    }

    public int getHintX() {
        return this.hintX;
    }

    public int getHintY() {
        return this.hintY;
    }

    public int getExtraDistance() {
        return this.extraDistance;
    }

    public String getHintText() {
        return this.hintText;
    }
}
