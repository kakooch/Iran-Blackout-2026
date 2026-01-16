package ir.resaneh1.iptv.model;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public class JJGetMatchDetailsOutput extends StatusOutput {
    public Result result = new Result();

    public class Result {
        public int level;
        public int minutes;
        public int p1;
        public int p2;
        public int pcount;
        public int r1;
        public int r2;
        public Results results;
        public int score1;
        public int score2;
        public int scount;
        public int tcount;
        public ArrayList<ArrayList<String>> topPreds;
        public Venue venue;

        public Result() {
        }
    }

    public class Results {
        public ArrayList<Float> draw;
        public ArrayList<Float> win1;
        public ArrayList<Float> win2;

        public Results() {
        }
    }

    public class Venue {
        public String city;
        public int id;
        public String imageUrl;
        public String name;

        public Venue() {
        }
    }
}
