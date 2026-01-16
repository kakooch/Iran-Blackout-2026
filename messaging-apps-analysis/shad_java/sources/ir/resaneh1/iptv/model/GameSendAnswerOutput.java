package ir.resaneh1.iptv.model;

/* loaded from: classes3.dex */
public class GameSendAnswerOutput {
    public int next_level;
    public StateEnum state;

    public enum StateEnum {
        IsAllowed,
        NotAllowed,
        NotInTime,
        AnsweredBefore
    }
}
