package ir.nasim;

import ai.bale.proto.Misc$ResponseVoid;
import ai.bale.proto.StoryOuterClass$RequestGetStoryReactionEmojis;
import ai.bale.proto.StoryOuterClass$RequestReactToStory;
import ai.bale.proto.StoryOuterClass$ResponseGetStoryReactionEmojis;
import com.google.protobuf.GeneratedMessageLite;

/* renamed from: ir.nasim.bT6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C10330bT6 {
    public static final int b = C6287Mz.e;
    private final C6287Mz a;

    public C10330bT6(C6287Mz c6287Mz) {
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        this.a = c6287Mz;
    }

    public final Object a(InterfaceC20295rm1 interfaceC20295rm1) {
        GeneratedMessageLite generatedMessageLiteA = StoryOuterClass$RequestGetStoryReactionEmojis.newBuilder().a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        StoryOuterClass$ResponseGetStoryReactionEmojis defaultInstance = StoryOuterClass$ResponseGetStoryReactionEmojis.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        return InterfaceC16847ly.c(this.a, new C22871vx5("/bale.story.v1.Story/GetStoryReactionEmojis", generatedMessageLiteA, defaultInstance), 16500L, null, interfaceC20295rm1, 4, null);
    }

    public final Object b(EnumC10088b35 enumC10088b35, StoryOuterClass$RequestReactToStory.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
        if (enumC10088b35 != null) {
            if (enumC10088b35 == EnumC10088b35.ExPeerType_CHANNEL || enumC10088b35 == EnumC10088b35.ExPeerType_GROUP) {
                aVar.E(QU6.StoryType_Channel);
            } else if (enumC10088b35 == EnumC10088b35.ExPeerType_BOT) {
                aVar.E(QU6.StoryType_Bot);
            }
        }
        GeneratedMessageLite generatedMessageLiteA = aVar.a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        return InterfaceC16847ly.c(this.a, new C22871vx5("/bale.story.v1.Story/ReactToStory", generatedMessageLiteA, defaultInstance), 16500L, null, interfaceC20295rm1, 4, null);
    }
}
