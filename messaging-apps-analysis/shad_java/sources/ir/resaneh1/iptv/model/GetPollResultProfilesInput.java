package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.model.Rubino;

/* loaded from: classes3.dex */
public class GetPollResultProfilesInput extends Rubino.BaseInput {
    public int choice_number;
    public int limit;
    public String start_id;
    public String story_id;

    public GetPollResultProfilesInput(String str) {
        super(str);
    }
}
