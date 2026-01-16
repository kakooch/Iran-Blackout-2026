package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.model.Rubino;

/* loaded from: classes3.dex */
public class AddPollAnswerInput extends Rubino.BaseInput {
    public int choice_number;
    public String story_id;
    public String story_profile_id;

    public AddPollAnswerInput(String str, String str2, String str3, int i) {
        super(str);
        this.story_id = str2;
        this.story_profile_id = str3;
        this.choice_number = i;
    }
}
