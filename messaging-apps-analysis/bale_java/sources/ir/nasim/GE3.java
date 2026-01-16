package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes8.dex */
public enum GE3 implements B.c {
    SERVER(0),
    CONTROLLER(1),
    MEDIA(2),
    TURN(4),
    SWEEPER(5),
    DIRECTOR(6),
    HOSTED_AGENT(7),
    UNRECOGNIZED(-1);

    private static final B.d j = new B.d() { // from class: ir.nasim.GE3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GE3 a(int i) {
            return GE3.j(i);
        }
    };
    private final int a;

    GE3(int i) {
        this.a = i;
    }

    public static GE3 j(int i) {
        if (i == 0) {
            return SERVER;
        }
        if (i == 1) {
            return CONTROLLER;
        }
        if (i == 2) {
            return MEDIA;
        }
        if (i == 4) {
            return TURN;
        }
        if (i == 5) {
            return SWEEPER;
        }
        if (i == 6) {
            return DIRECTOR;
        }
        if (i != 7) {
            return null;
        }
        return HOSTED_AGENT;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
