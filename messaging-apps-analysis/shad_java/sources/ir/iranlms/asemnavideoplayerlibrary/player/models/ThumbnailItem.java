package ir.iranlms.asemnavideoplayerlibrary.player.models;

import android.graphics.Bitmap;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes3.dex */
public class ThumbnailItem {
    public Bitmap bitmap;

    @SerializedName("image_url")
    public String imageUrl;

    @SerializedName("count_x")
    public int countX = 0;

    @SerializedName("count_y")
    public int countY = 0;

    @SerializedName("start_time")
    public int startTime = 0;

    @SerializedName("end_time")
    public int endTime = 0;

    public int getCount() {
        return this.countX * this.countY;
    }
}
