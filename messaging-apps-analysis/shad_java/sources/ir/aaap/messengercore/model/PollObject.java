package ir.aaap.messengercore.model;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public class PollObject {
    public boolean allows_multiple_answers;
    public long close_period = 0;
    public Integer correctOptionIndexLocal;
    public String explanationTemp;
    public boolean is_anonymous;
    public ArrayList<String> options;
    public String poll_id;
    public PollStatusObject poll_status;
    public PollStatusObject prev_poll_status;
    public String question;
    public QuizTypeEnum type;

    public enum QuizTypeEnum {
        Quiz,
        Regular
    }
}
