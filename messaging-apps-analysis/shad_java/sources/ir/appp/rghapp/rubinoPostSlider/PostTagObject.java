package ir.appp.rghapp.rubinoPostSlider;

import ir.resaneh1.iptv.model.RubinoProfileObject;

/* loaded from: classes3.dex */
public class PostTagObject {
    public String name;
    public String price;
    public String profileId;
    public RubinoProfileObject profileObject;
    public int tagId;
    public PostTagType tagType;
    public float xPositionPercent;
    public float yPositionPercent;

    public String toString() {
        return "PostTagObject{tagId=" + this.tagId + ", tagType=" + this.tagType + ", xPositionPercent=" + this.xPositionPercent + ", yPositionPercent=" + this.yPositionPercent + ", name='" + this.name + "', price='" + this.price + "'}";
    }
}
