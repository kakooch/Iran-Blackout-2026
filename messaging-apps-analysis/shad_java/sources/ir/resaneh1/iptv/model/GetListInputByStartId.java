package ir.resaneh1.iptv.model;

/* loaded from: classes3.dex */
public class GetListInputByStartId {
    public String cat_id;
    public Integer limit;
    public String object_id;
    public String related_object_id;
    public CommentSortEnum sort_by;
    public String start_id;
    public String tag_id;
    public String type;
    public String view_version;

    public enum CommentSortEnum {
        NewFirst,
        BestFirst
    }
}
