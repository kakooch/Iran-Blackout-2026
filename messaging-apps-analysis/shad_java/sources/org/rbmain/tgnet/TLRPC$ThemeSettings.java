package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class TLRPC$ThemeSettings extends TLObject {
    public int accent_color;
    public TLRPC$BaseTheme base_theme;
    public int flags;
    public ArrayList<Integer> message_colors = new ArrayList<>();
    public boolean message_colors_animated;
    public int outbox_accent_color;
    public TLRPC$WallPaper wallpaper;
}
