package ir.aaap.messengercore.model;

/* loaded from: classes3.dex */
public class StatsGraph {
    public String async_token;
    public String error;
    public String graph_schema;
    public Type type;
    public String zoom_token;

    public enum Type {
        Local,
        Async,
        Error
    }
}
