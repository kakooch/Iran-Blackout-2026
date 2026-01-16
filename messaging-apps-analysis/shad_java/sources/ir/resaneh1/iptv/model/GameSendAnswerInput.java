package ir.resaneh1.iptv.model;

/* loaded from: classes3.dex */
public class GameSendAnswerInput {
    public String answer_option_id;
    public String game_id;
    public String question_id;

    public GameSendAnswerInput(String str, String str2, String str3) {
        this.question_id = str;
        this.answer_option_id = str2;
        this.game_id = str3;
    }
}
