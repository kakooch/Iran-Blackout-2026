package ir.resaneh1.iptv.model;

import ir.aaap.messengercore.model.MiniFunctionModels;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class WebAppObject {
    public ArrayList<String> allowed_hosts = new ArrayList<>();
    public String app_id;
    public String app_url;
    public ArrayList<MiniFunctionModels.ButtonType> function_types;
    public Properties properties;
    public String selection_url;
    public String start_value;
    public String title;
    public String user_token;

    public static class Properties {
        public boolean is_fullscreen;
    }
}
