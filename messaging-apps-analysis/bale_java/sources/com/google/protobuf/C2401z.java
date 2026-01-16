package com.google.protobuf;

/* renamed from: com.google.protobuf.z, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C2401z implements O {
    private static final C2401z a = new C2401z();

    private C2401z() {
    }

    public static C2401z c() {
        return a;
    }

    @Override // com.google.protobuf.O
    public N a(Class cls) {
        if (!GeneratedMessageLite.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
        }
        try {
            return (N) GeneratedMessageLite.getDefaultInstance(cls.asSubclass(GeneratedMessageLite.class)).buildMessageInfo();
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for " + cls.getName(), e);
        }
    }

    @Override // com.google.protobuf.O
    public boolean b(Class cls) {
        return GeneratedMessageLite.class.isAssignableFrom(cls);
    }
}
