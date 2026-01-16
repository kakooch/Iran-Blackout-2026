package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class PresenceOuterClass$RequestGetUsersPresence extends GeneratedMessageLite implements U64 {
    private static final PresenceOuterClass$RequestGetUsersPresence DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int USERIDS_FIELD_NUMBER = 1;
    private int userIdsMemoizedSerializedSize = -1;
    private B.g userIds_ = GeneratedMessageLite.emptyIntList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(Iterable iterable) {
            q();
            ((PresenceOuterClass$RequestGetUsersPresence) this.b).addAllUserIds(iterable);
            return this;
        }

        private a() {
            super(PresenceOuterClass$RequestGetUsersPresence.DEFAULT_INSTANCE);
        }
    }

    static {
        PresenceOuterClass$RequestGetUsersPresence presenceOuterClass$RequestGetUsersPresence = new PresenceOuterClass$RequestGetUsersPresence();
        DEFAULT_INSTANCE = presenceOuterClass$RequestGetUsersPresence;
        GeneratedMessageLite.registerDefaultInstance(PresenceOuterClass$RequestGetUsersPresence.class, presenceOuterClass$RequestGetUsersPresence);
    }

    private PresenceOuterClass$RequestGetUsersPresence() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllUserIds(Iterable<? extends Integer> iterable) {
        ensureUserIdsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.userIds_);
    }

    private void addUserIds(int i) {
        ensureUserIdsIsMutable();
        this.userIds_.b1(i);
    }

    private void clearUserIds() {
        this.userIds_ = GeneratedMessageLite.emptyIntList();
    }

    private void ensureUserIdsIsMutable() {
        B.g gVar = this.userIds_;
        if (gVar.u()) {
            return;
        }
        this.userIds_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static PresenceOuterClass$RequestGetUsersPresence getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PresenceOuterClass$RequestGetUsersPresence parseDelimitedFrom(InputStream inputStream) {
        return (PresenceOuterClass$RequestGetUsersPresence) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PresenceOuterClass$RequestGetUsersPresence parseFrom(ByteBuffer byteBuffer) {
        return (PresenceOuterClass$RequestGetUsersPresence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setUserIds(int i, int i2) {
        ensureUserIdsIsMutable();
        this.userIds_.U(i, i2);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1866j1.a[gVar.ordinal()]) {
            case 1:
                return new PresenceOuterClass$RequestGetUsersPresence();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001'", new Object[]{"userIds_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PresenceOuterClass$RequestGetUsersPresence.class) {
                        try {
                            cVar = PARSER;
                            if (cVar == null) {
                                cVar = new GeneratedMessageLite.c(DEFAULT_INSTANCE);
                                PARSER = cVar;
                            }
                        } finally {
                        }
                    }
                }
                return cVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public int getUserIds(int i) {
        return this.userIds_.getInt(i);
    }

    public int getUserIdsCount() {
        return this.userIds_.size();
    }

    public List<Integer> getUserIdsList() {
        return this.userIds_;
    }

    public static a newBuilder(PresenceOuterClass$RequestGetUsersPresence presenceOuterClass$RequestGetUsersPresence) {
        return (a) DEFAULT_INSTANCE.createBuilder(presenceOuterClass$RequestGetUsersPresence);
    }

    public static PresenceOuterClass$RequestGetUsersPresence parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PresenceOuterClass$RequestGetUsersPresence) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PresenceOuterClass$RequestGetUsersPresence parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PresenceOuterClass$RequestGetUsersPresence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PresenceOuterClass$RequestGetUsersPresence parseFrom(AbstractC2383g abstractC2383g) {
        return (PresenceOuterClass$RequestGetUsersPresence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PresenceOuterClass$RequestGetUsersPresence parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PresenceOuterClass$RequestGetUsersPresence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PresenceOuterClass$RequestGetUsersPresence parseFrom(byte[] bArr) {
        return (PresenceOuterClass$RequestGetUsersPresence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PresenceOuterClass$RequestGetUsersPresence parseFrom(byte[] bArr, C2394s c2394s) {
        return (PresenceOuterClass$RequestGetUsersPresence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PresenceOuterClass$RequestGetUsersPresence parseFrom(InputStream inputStream) {
        return (PresenceOuterClass$RequestGetUsersPresence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PresenceOuterClass$RequestGetUsersPresence parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PresenceOuterClass$RequestGetUsersPresence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PresenceOuterClass$RequestGetUsersPresence parseFrom(AbstractC2384h abstractC2384h) {
        return (PresenceOuterClass$RequestGetUsersPresence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PresenceOuterClass$RequestGetUsersPresence parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PresenceOuterClass$RequestGetUsersPresence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
