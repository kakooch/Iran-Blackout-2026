package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes.dex */
public enum JU6 implements B.c {
    StoryContentType_Photo(0),
    StoryContentType_Video(1),
    StoryContentType_Text(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.JU6.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public JU6 a(int i) {
            return JU6.j(i);
        }
    };
    private final int a;

    JU6(int i) {
        this.a = i;
    }

    public static JU6 j(int i) {
        if (i == 0) {
            return StoryContentType_Photo;
        }
        if (i == 1) {
            return StoryContentType_Video;
        }
        if (i != 2) {
            return null;
        }
        return StoryContentType_Text;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
