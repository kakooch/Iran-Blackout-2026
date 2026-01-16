package ir.resaneh1.iptv.model;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public class JJGetGroupsTabsOutput extends StatusOutput {
    public Result result = new Result();

    public static class Result {
        public ArrayList<JJTableGroupNameObject> groups;
        public ArrayList<JJTabObject> tabs;
    }
}
