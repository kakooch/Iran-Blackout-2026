package com.google.protobuf;

import com.google.protobuf.B;

/* loaded from: classes3.dex */
public enum Y implements B.c {
    NULL_VALUE(0),
    UNRECOGNIZED(-1);

    private static final B.d d = new B.d() { // from class: com.google.protobuf.Y.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Y a(int i) {
            return Y.a(i);
        }
    };
    private final int a;

    Y(int i) {
        this.a = i;
    }

    public static Y a(int i) {
        if (i != 0) {
            return null;
        }
        return NULL_VALUE;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
