package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.model.ViewTagObject;

/* loaded from: classes3.dex */
public class DynamicPagePartDataObject {
    public int itemCount;
    public int itemWidthPx;
    public DynamicListPagePartDataObject list_page_part_data;
    public ObjectTypeEnum object_type;
    public String page_part_data_id;
    public ViewTagObject.TypeEnum show_type;
    public DynamicTagPagePartDataObject tag_page_part_data;
    public String view_key;

    public enum ObjectTypeEnum {
        List,
        Tag
    }
}
