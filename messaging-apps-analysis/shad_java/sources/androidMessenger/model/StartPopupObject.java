package androidMessenger.model;

/* loaded from: classes.dex */
public class StartPopupObject {
    public int count_show;
    public boolean has_link;
    public String id;
    public String ignore_text;
    public ir.resaneh1.iptv.model.Link link;
    public String link_text;
    public Priority priority;
    public String text;
    public String title;

    public enum Priority {
        High,
        Low
    }
}
