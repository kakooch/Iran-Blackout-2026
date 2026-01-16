package ir.resaneh1.iptv.model;

/* loaded from: classes3.dex */
public class ReportCommentInput {
    public String cat_id;
    public String comment_id;
    public String object_id;
    public ReportTypeEnum report_type;

    public enum ReportTypeEnum {
        Spam,
        Ads
    }

    public ReportCommentInput(String str, String str2, String str3, ReportTypeEnum reportTypeEnum) {
        this.cat_id = str;
        this.object_id = str2;
        this.comment_id = str3;
        this.report_type = reportTypeEnum;
    }
}
