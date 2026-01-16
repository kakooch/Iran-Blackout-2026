package com.google.protobuf;

import com.google.protobuf.B;

/* loaded from: classes3.dex */
public enum j0 implements B.c {
    SYNTAX_PROTO2(0),
    SYNTAX_PROTO3(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: com.google.protobuf.j0.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public j0 a(int i) {
            return j0.a(i);
        }
    };
    private final int a;

    j0(int i) {
        this.a = i;
    }

    public static j0 a(int i) {
        if (i == 0) {
            return SYNTAX_PROTO2;
        }
        if (i != 1) {
            return null;
        }
        return SYNTAX_PROTO3;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
