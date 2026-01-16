package ir.resaneh1.iptv.model;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public class JJVoteOutput extends StatusOutput {
    public ArrayList<JJVoteResult> result = new ArrayList<>();

    public enum StatusEnum {
        OK,
        OK_DUP,
        FAIL,
        FAIL_DUP,
        FAIL_EXCL,
        FAIL_PERM,
        FAIL_INVALID,
        FAIL_LATE,
        FAIL_DUP_ONLINE,
        FAIL_DUP_OFFLINE
    }

    public class JJVoteResult {
        public int id;
        public boolean push;
        public String result;
        public StatusEnum status;

        public JJVoteResult() {
        }
    }
}
