package ir.resaneh1.iptv.model;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public class JJGetRankOutput extends StatusOutput {
    public Result result = new Result();

    public class Result {
        public ArrayList<JJRankObject> myRanks;
        public ArrayList<JJRankObject> topRanks;

        public Result() {
        }
    }
}
