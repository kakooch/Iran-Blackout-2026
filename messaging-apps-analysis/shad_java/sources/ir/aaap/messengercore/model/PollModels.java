package ir.aaap.messengercore.model;

import ir.aaap.messengercore.model.PollObject;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class PollModels {

    public enum ActionEnum {
        Retract,
        Stop
    }

    public static class CreatePollInput {
        public boolean allows_multiple_answers;
        public Integer correct_option_index = 0;
        public String explanation;
        public boolean is_anonymous;
        public boolean is_mute;
        public String object_guid;
        public ArrayList<String> options;
        public String question;
        public Long reply_to_message_id;
        public long rnd;
        public PollObject.QuizTypeEnum type;
    }

    public static class GetPollOptionVotersInput {
        public String poll_id;
        public String selection_index;
        public String start_id;
    }

    public static class GetPollOptionVotersOutput {
        public boolean has_continue;
        public String next_start_id;
        public ArrayList<ChatAbsObject> voters_abs_objects;
    }

    public static class GetPollStatusInput {
        public String poll_id;
    }

    public static class PollOutput {
        public PollStatusObject poll_status;
    }

    public static class SetPollActionInput {
        public ActionEnum action;
        public String poll_id;
    }

    public static class VotePollInput {
        public String poll_id;
        public String selection_index;
    }
}
