package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes.dex */
public enum PU6 implements B.c {
    StoryReactionType_Unknown(0),
    StoryReactionType_View(1),
    StoryReactionType_Emoji(2),
    StoryReactionType_Remove_Emoji(3),
    StoryReactionType_Link(4),
    UNRECOGNIZED(-1);

    private static final B.d h = new B.d() { // from class: ir.nasim.PU6.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PU6 a(int i2) {
            return PU6.j(i2);
        }
    };
    private final int a;

    PU6(int i2) {
        this.a = i2;
    }

    public static PU6 j(int i2) {
        if (i2 == 0) {
            return StoryReactionType_Unknown;
        }
        if (i2 == 1) {
            return StoryReactionType_View;
        }
        if (i2 == 2) {
            return StoryReactionType_Emoji;
        }
        if (i2 == 3) {
            return StoryReactionType_Remove_Emoji;
        }
        if (i2 != 4) {
            return null;
        }
        return StoryReactionType_Link;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
