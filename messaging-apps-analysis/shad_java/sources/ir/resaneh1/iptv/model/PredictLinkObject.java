package ir.resaneh1.iptv.model;

/* loaded from: classes3.dex */
public class PredictLinkObject {
    public String id;
    public String match_id;
    public PredictType type;

    public enum PredictType {
        table,
        tabs,
        myranking,
        champion,
        match
    }
}
