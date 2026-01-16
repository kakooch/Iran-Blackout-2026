package ir.resaneh1.iptv.model;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public class JJGetMatchAndTeamListOutput extends StatusOutput {
    public Result result = new Result();

    public class Result {
        public int curWeek;
        public ArrayList<JJMatchObject> matchUpdates = new ArrayList<>();
        public ArrayList<JJTeamObject> teamUpdates = new ArrayList<>();
        public Long timestamp;

        public Result() {
        }
    }
}
