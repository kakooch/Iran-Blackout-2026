package ir.resaneh1.iptv.model;

import java.util.HashMap;

/* loaded from: classes3.dex */
public class SendAppUsageInput {
    public HashMap<String, Integer> hourly_usage;

    public SendAppUsageInput(HashMap<String, Integer> map) {
        this.hourly_usage = map;
    }
}
