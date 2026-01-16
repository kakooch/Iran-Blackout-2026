package ir.resaneh1.iptv.model;

/* loaded from: classes3.dex */
public class CardViewObject {
    public ColorObject background_color;
    public float corner_size;
    public ShadowObject shadow;

    public enum ShadowTypeEnum {
        Small,
        Medium,
        Big,
        None
    }

    public class ShadowObject {
        public ShadowTypeEnum type;

        public ShadowObject() {
        }
    }

    public CardViewObject(ColorObject colorObject, ShadowTypeEnum shadowTypeEnum, float f) {
        this.background_color = colorObject;
        this.corner_size = f;
    }
}
