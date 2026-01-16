package ir.nasim;

import ai.bale.proto.StoryStruct$Story;
import com.google.protobuf.AbstractC2383g;

/* loaded from: classes7.dex */
public final class MC implements InterfaceC14123hO3 {
    private final KC a;
    private final C10946cT6 b;

    public MC(KC kc, C10946cT6 c10946cT6) {
        AbstractC13042fc3.i(kc, "apiStoryContentTypeToStoryContentTypeMapper");
        AbstractC13042fc3.i(c10946cT6, "storyReactionListToStoryReactionsMapper");
        this.a = kc;
        this.b = c10946cT6;
    }

    private final AbstractC2383g b(StoryStruct$Story storyStruct$Story) {
        if (storyStruct$Story.getStoryContentType() == JU6.StoryContentType_Video) {
            AbstractC2383g thumb = storyStruct$Story.getStoryContent().getMedia().getVideo().getFastThumb().getThumb();
            AbstractC13042fc3.f(thumb);
            return thumb;
        }
        AbstractC2383g thumb2 = storyStruct$Story.getStoryContent().getMedia().getFastThumb().getThumb();
        AbstractC13042fc3.f(thumb2);
        return thumb2;
    }

    private final AbstractC2383g c(StoryStruct$Story storyStruct$Story) {
        AbstractC2383g thumb = storyStruct$Story.getStoryContent().getMedia().getFastThumb().getThumb();
        if (thumb.size() <= 0) {
            thumb = null;
        }
        if (thumb != null) {
            return thumb;
        }
        AbstractC2383g thumb2 = storyStruct$Story.getStoryContent().getMedia().getVideo().getFastThumb().getThumb();
        AbstractC13042fc3.h(thumb2, "getThumb(...)");
        return thumb2;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00cc  */
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ir.nasim.QQ6 a(ai.bale.proto.StoryStruct$Story r28) {
        /*
            r27 = this;
            r0 = r27
            java.lang.String r1 = "input"
            r2 = r28
            ir.nasim.AbstractC13042fc3.i(r2, r1)
            java.lang.String r5 = r28.getId()
            java.lang.String r1 = "getId(...)"
            ir.nasim.AbstractC13042fc3.h(r5, r1)
            ai.bale.proto.StoryStruct$StoryContent r1 = r28.getStoryContent()
            ai.bale.proto.StoryStruct$MediaStory r6 = r1.getMedia()
            ir.nasim.KC r1 = r0.a
            ir.nasim.JU6 r3 = r28.getStoryContentType()
            java.lang.String r4 = "getStoryContentType(...)"
            ir.nasim.AbstractC13042fc3.h(r3, r4)
            ir.nasim.hQ6 r7 = r1.a(r3)
            long r8 = r28.getCreatedAt()
            int r10 = r28.getOwnerUserId()
            ir.nasim.cT6 r1 = r0.b
            java.util.List r3 = r28.getReactionsList()
            java.lang.String r4 = "getReactionsList(...)"
            ir.nasim.AbstractC13042fc3.h(r3, r4)
            ir.nasim.dT6 r11 = r1.a(r3)
            ai.bale.proto.StoryStruct$StoryContent r1 = r28.getStoryContent()
            ai.bale.proto.StoryStruct$MediaStory r1 = r1.getMedia()
            ai.bale.proto.StoryStruct$VideoStory r1 = r1.getVideo()
            ai.bale.proto.StoryStruct$VideoStory r3 = ai.bale.proto.StoryStruct$VideoStory.getDefaultInstance()
            boolean r1 = ir.nasim.AbstractC13042fc3.d(r1, r3)
            r3 = 0
            if (r1 == 0) goto L59
            r15 = r3
            goto L8a
        L59:
            ir.nasim.rS7 r1 = new ir.nasim.rS7
            ir.nasim.tR6$a r4 = ir.nasim.EnumC21310tR6.d
            ai.bale.proto.StoryStruct$StoryContent r12 = r28.getStoryContent()
            ai.bale.proto.StoryStruct$MediaStory r12 = r12.getMedia()
            ai.bale.proto.StoryStruct$VideoStory r12 = r12.getVideo()
            java.lang.String r12 = r12.getFormat()
            java.lang.String r13 = "getFormat(...)"
            ir.nasim.AbstractC13042fc3.h(r12, r13)
            ir.nasim.tR6 r4 = r4.a(r12)
            ai.bale.proto.StoryStruct$StoryContent r12 = r28.getStoryContent()
            ai.bale.proto.StoryStruct$MediaStory r12 = r12.getMedia()
            ai.bale.proto.StoryStruct$VideoStory r12 = r12.getVideo()
            float r12 = r12.getDuration()
            r1.<init>(r4, r12)
            r15 = r1
        L8a:
            java.util.List r1 = r28.getTagIdsList()
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto Lcc
            java.util.List r1 = r28.getTagIdsList()
            java.lang.String r4 = "getTagIdsList(...)"
            ir.nasim.AbstractC13042fc3.h(r1, r4)
            java.lang.Object r1 = ir.nasim.ZW0.q0(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            if (r1 != 0) goto La6
            goto Lad
        La6:
            int r1 = r1.intValue()
            if (r1 != 0) goto Lad
            goto Lcc
        Lad:
            ir.nasim.hV6 r1 = new ir.nasim.hV6
            java.util.List r12 = r28.getTagIdsList()
            ir.nasim.AbstractC13042fc3.h(r12, r4)
            java.lang.Object r4 = ir.nasim.ZW0.q0(r12)
            java.lang.String r12 = "first(...)"
            ir.nasim.AbstractC13042fc3.h(r4, r12)
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            r12 = 0
            r1.<init>(r4, r12)
            r17 = r1
            goto Lce
        Lcc:
            r17 = r3
        Lce:
            boolean r21 = r28.getHasWidget()
            com.google.protobuf.g r1 = r27.b(r28)
            int r4 = r1.size()
            if (r4 <= 0) goto Ldd
            r3 = r1
        Ldd:
            if (r3 != 0) goto Le6
            com.google.protobuf.g r1 = r27.c(r28)
            r22 = r1
            goto Le8
        Le6:
            r22 = r3
        Le8:
            ir.nasim.QQ6 r1 = new ir.nasim.QQ6
            r2 = r1
            r3 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r23 = 0
            r24 = 0
            r25 = 846721(0xceb81, float:1.186509E-39)
            r26 = 0
            r2.<init>(r3, r5, r6, r7, r8, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.MC.a(ai.bale.proto.StoryStruct$Story):ir.nasim.QQ6");
    }
}
