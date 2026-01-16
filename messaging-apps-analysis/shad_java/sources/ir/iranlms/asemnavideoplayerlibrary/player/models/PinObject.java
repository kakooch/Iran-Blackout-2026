package ir.iranlms.asemnavideoplayerlibrary.player.models;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes3.dex */
public class PinObject {

    @SerializedName("location")
    public int location;

    @SerializedName("color")
    public int color = -16711936;

    @SerializedName("pinShape")
    public PinShape pinShape = PinShape.rectangle;
    public boolean drawonTop = false;

    public enum PinShape {
        circle,
        rectangle
    }
}
