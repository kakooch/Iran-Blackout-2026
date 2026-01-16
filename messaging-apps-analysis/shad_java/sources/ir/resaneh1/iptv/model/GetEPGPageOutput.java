package ir.resaneh1.iptv.model;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public class GetEPGPageOutput extends StatusOutput {
    public TimeObject current_time;
    public ArrayList<TVChannelAbs> tv_channels = new ArrayList<>();
    public ArrayList<TimeObject> avail_dates = new ArrayList<>();
}
