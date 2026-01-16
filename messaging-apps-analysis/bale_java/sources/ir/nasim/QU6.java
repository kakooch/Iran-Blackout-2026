package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes.dex */
public enum QU6 implements B.c {
    StoryType_User(0),
    StoryType_Channel(1),
    StoryType_Bot(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.QU6.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QU6 a(int i) {
            return QU6.j(i);
        }
    };
    private final int a;

    QU6(int i) {
        this.a = i;
    }

    public static QU6 j(int i) {
        if (i == 0) {
            return StoryType_User;
        }
        if (i == 1) {
            return StoryType_Channel;
        }
        if (i != 2) {
            return null;
        }
        return StoryType_Bot;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
