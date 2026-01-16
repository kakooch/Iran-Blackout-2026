package ir.aaap.messengercore.model;

import java.util.ArrayList;
import java.util.Set;

/* loaded from: classes3.dex */
public class PollStatusObject {
    public int correct_option_index;
    public String explanation;
    public Set<Integer> multiple_selections;
    public ArrayList<Integer> percent_vote_options;
    public int selection_index = -1;
    public boolean show_total_votes;
    public StateEnum state;
    public long total_vote;
    public ArrayList<String> voters_object_guids;

    public enum StateEnum {
        Open,
        Closed
    }
}
