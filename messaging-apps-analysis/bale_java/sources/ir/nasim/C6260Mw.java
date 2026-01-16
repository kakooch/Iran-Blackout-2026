package ir.nasim;

/* renamed from: ir.nasim.Mw, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C6260Mw implements InterfaceC14123hO3 {
    private final C10946cT6 a;
    private final KC b;
    private final boolean c;

    /* renamed from: ir.nasim.Mw$a */
    public interface a {
        C6260Mw a(boolean z);
    }

    public C6260Mw(C10946cT6 c10946cT6, KC kc, boolean z) {
        AbstractC13042fc3.i(c10946cT6, "storyReactionListToStoryReactionsMapper");
        AbstractC13042fc3.i(kc, "apiStoryContentTypeToStoryContentTypeMapper");
        this.a = c10946cT6;
        this.b = kc;
        this.c = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00c2  */
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ir.nasim.QQ6 a(ai.bale.proto.StoryStruct$ChannelStory r29) {
        /*
            r28 = this;
            r0 = r28
            java.lang.String r1 = "input"
            r2 = r29
            ir.nasim.AbstractC13042fc3.i(r2, r1)
            java.lang.String r6 = r29.getId()
            java.lang.String r1 = "getId(...)"
            ir.nasim.AbstractC13042fc3.h(r6, r1)
            ai.bale.proto.StoryStruct$MediaStory r7 = r29.getStoryContent()
            ir.nasim.KC r1 = r0.b
            ir.nasim.JU6 r3 = r29.getStoryContentType()
            java.lang.String r4 = "getStoryContentType(...)"
            ir.nasim.AbstractC13042fc3.h(r3, r4)
            ir.nasim.hQ6 r8 = r1.a(r3)
            long r9 = r29.getCreatedAt()
            int r11 = r29.getOwnerUserId()
            ir.nasim.cT6 r1 = r0.a
            java.util.List r3 = r29.getReactionsList()
            java.lang.String r4 = "getReactionsList(...)"
            ir.nasim.AbstractC13042fc3.h(r3, r4)
            ir.nasim.dT6 r12 = r1.a(r3)
            ai.bale.proto.PeersStruct$ExPeer r15 = r29.getExPeer()
            ai.bale.proto.StoryStruct$MediaStory r1 = r29.getStoryContent()
            ai.bale.proto.StoryStruct$VideoStory r1 = r1.getVideo()
            ai.bale.proto.StoryStruct$VideoStory r3 = ai.bale.proto.StoryStruct$VideoStory.getDefaultInstance()
            boolean r1 = ir.nasim.AbstractC13042fc3.d(r1, r3)
            r3 = 0
            if (r1 == 0) goto L56
            r16 = r3
            goto L80
        L56:
            ir.nasim.rS7 r1 = new ir.nasim.rS7
            ir.nasim.tR6$a r4 = ir.nasim.EnumC21310tR6.d
            ai.bale.proto.StoryStruct$MediaStory r5 = r29.getStoryContent()
            ai.bale.proto.StoryStruct$VideoStory r5 = r5.getVideo()
            java.lang.String r5 = r5.getFormat()
            java.lang.String r13 = "getFormat(...)"
            ir.nasim.AbstractC13042fc3.h(r5, r13)
            ir.nasim.tR6 r4 = r4.a(r5)
            ai.bale.proto.StoryStruct$MediaStory r5 = r29.getStoryContent()
            ai.bale.proto.StoryStruct$VideoStory r5 = r5.getVideo()
            float r5 = r5.getDuration()
            r1.<init>(r4, r5)
            r16 = r1
        L80:
            java.util.List r1 = r29.getTagIdsList()
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto Lc2
            java.util.List r1 = r29.getTagIdsList()
            java.lang.String r4 = "getTagIdsList(...)"
            ir.nasim.AbstractC13042fc3.h(r1, r4)
            java.lang.Object r1 = ir.nasim.ZW0.q0(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            if (r1 != 0) goto L9c
            goto La3
        L9c:
            int r1 = r1.intValue()
            if (r1 != 0) goto La3
            goto Lc2
        La3:
            ir.nasim.hV6 r1 = new ir.nasim.hV6
            java.util.List r3 = r29.getTagIdsList()
            ir.nasim.AbstractC13042fc3.h(r3, r4)
            java.lang.Object r3 = ir.nasim.ZW0.q0(r3)
            java.lang.String r4 = "first(...)"
            ir.nasim.AbstractC13042fc3.h(r3, r4)
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            r4 = 0
            r1.<init>(r3, r4)
            r18 = r1
            goto Lc4
        Lc2:
            r18 = r3
        Lc4:
            boolean r22 = r29.getHasWidget()
            ai.bale.proto.StoryStruct$MediaStory r1 = r29.getStoryContent()
            ai.bale.proto.FilesStruct$FastThumb r1 = r1.getFastThumb()
            com.google.protobuf.g r23 = r1.getThumb()
            boolean r1 = r0.c
            r17 = r1
            ir.nasim.QQ6 r1 = new ir.nasim.QQ6
            r3 = r1
            r26 = 844161(0xce181, float:1.182922E-39)
            r27 = 0
            r4 = 0
            r13 = 0
            r14 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r24 = 0
            r25 = 0
            r3.<init>(r4, r6, r7, r8, r9, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6260Mw.a(ai.bale.proto.StoryStruct$ChannelStory):ir.nasim.QQ6");
    }
}
