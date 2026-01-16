package ir.resaneh1.iptv.model;

/* loaded from: classes3.dex */
public class GameStateObject {
    public int allowed_level;
    public GameAnswerObject answer;
    public boolean isFromNextState = false;
    public DynamicEndpointDataObject no_game_endpoint;
    public GameQuestionObject question;
    public String state_id;
    public GameStatusEnum status;

    public enum GameStatusEnum {
        NoGame,
        ShowQuestion,
        ShowAnswer,
        Host
    }

    public String toString() {
        return "state_id: " + this.state_id + " GameStatusEnum: " + this.status + " question: " + getQuestionString() + " answer: " + getAnswerString() + " allowedLevel: " + this.allowed_level;
    }

    private String getQuestionString() {
        GameQuestionObject gameQuestionObject = this.question;
        return gameQuestionObject == null ? "null!" : gameQuestionObject.toString();
    }

    private String getAnswerString() {
        GameAnswerObject gameAnswerObject = this.answer;
        return gameAnswerObject == null ? "null!" : gameAnswerObject.toString();
    }
}
