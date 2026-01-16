package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.model.Rubino;

/* loaded from: classes3.dex */
public class AddEmojiSliderAnswerInput extends Rubino.BaseInput {
    public float float_answer;
    public String story_id;
    public String story_profile_id;

    public AddEmojiSliderAnswerInput(String str, String str2, String str3, float f) {
        super(str);
        this.story_id = str2;
        this.story_profile_id = str3;
        this.float_answer = f;
    }
}
