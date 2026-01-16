package ir.resaneh1.iptv.model;

/* loaded from: classes3.dex */
public class EndPointData {
    public CommandEnum command;
    public String id;
    public TypeEnum type;

    public enum CommandEnum {
        installapp
    }

    public enum TypeEnum {
        app,
        qgame
    }
}
