package ir.aaap.messengercore.model;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ChatReactionSetting {
    public ReactionType reaction_type;
    public ArrayList<String> selected_reactions;

    public enum ReactionType {
        All,
        Selected,
        Disabled
    }
}
