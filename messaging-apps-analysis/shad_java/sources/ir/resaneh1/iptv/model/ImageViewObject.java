package ir.resaneh1.iptv.model;

import io.github.inflationx.calligraphy3.BuildConfig;

/* loaded from: classes3.dex */
public class ImageViewObject extends SimpleViewObject {
    public float corner;
    public boolean has_placeholder = false;
    public String placeholder_url = BuildConfig.FLAVOR;
    public TypeEnum type;
    public String url;

    public enum TypeEnum {
        Rectangle,
        Circle
    }
}
