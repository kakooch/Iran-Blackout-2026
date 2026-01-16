package ir.nasim;

import ai.bale.proto.StoryStruct$StoryReaction;
import ai.bale.proto.StoryStruct$Viewer;
import java.util.List;

/* loaded from: classes7.dex */
public final class NC implements InterfaceC14123hO3 {
    private final C10946cT6 a;

    public NC(C10946cT6 c10946cT6) {
        AbstractC13042fc3.i(c10946cT6, "storyReactionListToStoryReactionsMapper");
        this.a = c10946cT6;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C20744sX6 a(StoryStruct$Viewer storyStruct$Viewer) {
        AbstractC13042fc3.i(storyStruct$Viewer, "input");
        int userId = storyStruct$Viewer.getUserId();
        long reactedAt = storyStruct$Viewer.getReactedAt();
        C10946cT6 c10946cT6 = this.a;
        List<StoryStruct$StoryReaction> reactionDataList = storyStruct$Viewer.getReactionDataList();
        AbstractC13042fc3.h(reactionDataList, "getReactionDataList(...)");
        return new C20744sX6(userId, reactedAt, c10946cT6.a(reactionDataList));
    }
}
