package ir.iranlms.asemnavideoplayerlibrary.player.models;

/* loaded from: classes3.dex */
public class SettingItem {
    public BookmarkObject bookmarkObject;
    public boolean isSelected = false;
    public String name;
    public int position;
    public SettingType type;

    public enum SettingType {
        bookmark,
        hideSetting,
        backItem,
        backSubtitle,
        fixedQualityItem,
        smartQuality,
        subtitleItem,
        videoMenu,
        subtitleMenu
    }
}
