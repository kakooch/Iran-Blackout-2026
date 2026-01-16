package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.enums.EnumContentType;

/* loaded from: classes3.dex */
public class Content {
    public Command command;
    public String content_id;
    public String content_title;
    public EnumContentType type;

    public enum Command {
        play
    }
}
