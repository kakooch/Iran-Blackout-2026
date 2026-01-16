package ir.nasim;

import ai.bale.proto.PeersStruct$ExPeer;
import ai.bale.proto.StoryStruct$BotStory;
import ai.bale.proto.StoryStruct$MediaStory;
import ai.bale.proto.StoryStruct$StoryReaction;
import ai.bale.proto.StoryStruct$VideoStory;
import ir.nasim.EnumC21310tR6;
import java.util.List;

/* renamed from: ir.nasim.tw, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C21670tw implements InterfaceC14123hO3 {
    private final C10946cT6 a;
    private final KC b;

    public C21670tw(C10946cT6 c10946cT6, KC kc) {
        AbstractC13042fc3.i(c10946cT6, "storyReactionListToStoryReactionsMapper");
        AbstractC13042fc3.i(kc, "apiStoryContentTypeToStoryContentTypeMapper");
        this.a = c10946cT6;
        this.b = kc;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public QQ6 a(StoryStruct$BotStory storyStruct$BotStory) {
        C20091rS7 c20091rS7;
        C14189hV6 c14189hV6;
        AbstractC13042fc3.i(storyStruct$BotStory, "input");
        String id = storyStruct$BotStory.getId();
        AbstractC13042fc3.h(id, "getId(...)");
        StoryStruct$MediaStory storyContent = storyStruct$BotStory.getStoryContent();
        KC kc = this.b;
        JU6 storyContentType = storyStruct$BotStory.getStoryContentType();
        AbstractC13042fc3.h(storyContentType, "getStoryContentType(...)");
        EnumC14144hQ6 enumC14144hQ6A = kc.a(storyContentType);
        long createdAt = storyStruct$BotStory.getCreatedAt();
        int ownerUserId = storyStruct$BotStory.getOwnerUserId();
        C10946cT6 c10946cT6 = this.a;
        List<StoryStruct$StoryReaction> reactionsList = storyStruct$BotStory.getReactionsList();
        AbstractC13042fc3.h(reactionsList, "getReactionsList(...)");
        AbstractC11710dT6 abstractC11710dT6A = c10946cT6.a(reactionsList);
        PeersStruct$ExPeer exPeer = storyStruct$BotStory.getExPeer();
        if (AbstractC13042fc3.d(storyStruct$BotStory.getStoryContent().getVideo(), StoryStruct$VideoStory.getDefaultInstance())) {
            c20091rS7 = null;
        } else {
            EnumC21310tR6.a aVar = EnumC21310tR6.d;
            String format = storyStruct$BotStory.getStoryContent().getVideo().getFormat();
            AbstractC13042fc3.h(format, "getFormat(...)");
            c20091rS7 = new C20091rS7(aVar.a(format), storyStruct$BotStory.getStoryContent().getVideo().getDuration());
        }
        List<Integer> tagIdsList = storyStruct$BotStory.getTagIdsList();
        AbstractC13042fc3.h(tagIdsList, "getTagIdsList(...)");
        if (((Integer) AbstractC15401jX0.s0(tagIdsList)) != null) {
            List<Integer> tagIdsList2 = storyStruct$BotStory.getTagIdsList();
            AbstractC13042fc3.h(tagIdsList2, "getTagIdsList(...)");
            Object objQ0 = AbstractC15401jX0.q0(tagIdsList2);
            AbstractC13042fc3.h(objQ0, "first(...)");
            c14189hV6 = new C14189hV6(((Number) objQ0).intValue(), false);
        } else {
            c14189hV6 = null;
        }
        return new QQ6(0L, id, storyContent, enumC14144hQ6A, createdAt, ownerUserId, abstractC11710dT6A, null, null, exPeer, c20091rS7, false, c14189hV6, null, false, null, storyStruct$BotStory.getHasWidget(), storyStruct$BotStory.getStoryContent().getFastThumb().getThumb(), null, null, 846209, null);
    }
}
