package ir.iranlms.asemnavideoplayerlibrary.player.models;

import com.google.gson.annotations.SerializedName;
import io.github.inflationx.calligraphy3.BuildConfig;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class PlayObject {

    @SerializedName("alert")
    public AlertObject alert;

    @SerializedName("preview_image")
    public String imageUrl;

    @SerializedName("stream_url")
    public String streamUrl;

    @SerializedName("thumbnails")
    public ArrayList<ThumbnailItem> thumbnailItems = new ArrayList<>();

    @SerializedName("bookmarks")
    public ArrayList<BookmarkObject> bookmarkObjects = new ArrayList<>();

    @SerializedName("subtitles")
    public ArrayList<SubtitleObject> subtitleObjects = new ArrayList<>();

    @SerializedName("qualities")
    public ArrayList<QualityObject> qualityObjects = new ArrayList<>();

    @SerializedName("default")
    public Setting setting = new Setting();

    @SerializedName("ads")
    public ArrayList<AdsObject> adsObjectArrayList = new ArrayList<>();

    @SerializedName("type")
    public EnumStreamType type = EnumStreamType.vod;
    public String viewId = BuildConfig.FLAVOR;
    public boolean isHls = true;
    public boolean isForInsta = false;
    public long startTimeForInsta = -1;
    public long endTimeForInsta = -1;
    public boolean isForExplore = false;

    public static class AlertObject {
    }

    public static class Setting {

        @SerializedName("isJustFullScreen")
        public boolean isJustFullScreen = false;

        @SerializedName("isTouchControllerAlwaysEnabled")
        public boolean isTouchControllerAlwaysEnabled = false;

        @SerializedName("isForcePlayFromFirst")
        public boolean isForcePlayFromFirst = false;

        @SerializedName("start_time")
        public int startTime = -1;

        @SerializedName("auto_start")
        public boolean autoStart = true;

        @SerializedName("subtitle_id")
        public int subtitle_id = -1;

        @SerializedName("quality_id")
        public int quality_id = -1;
    }
}
