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

/* loaded from: classes.dex */
public final class WarriorOuterClass$RequestSendReferral extends GeneratedMessageLite implements U64 {
    private static final WarriorOuterClass$RequestSendReferral DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int USER_ID_FIELD_NUMBER = 1;
    private int userIdMemoizedSerializedSize = -1;
    private B.g userId_ = GeneratedMessageLite.emptyIntList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(WarriorOuterClass$RequestSendReferral.DEFAULT_INSTANCE);
        }
    }

    static {
        WarriorOuterClass$RequestSendReferral warriorOuterClass$RequestSendReferral = new WarriorOuterClass$RequestSendReferral();
        DEFAULT_INSTANCE = warriorOuterClass$RequestSendReferral;
        GeneratedMessageLite.registerDefaultInstance(WarriorOuterClass$RequestSendReferral.class, warriorOuterClass$RequestSendReferral);
    }

    private WarriorOuterClass$RequestSendReferral() {
    }

    private void addAllUserId(Iterable<? extends Integer> iterable) {
        ensureUserIdIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.userId_);
    }

    private void addUserId(int i) {
        ensureUserIdIsMutable();
        this.userId_.b1(i);
    }

    private void clearUserId() {
        this.userId_ = GeneratedMessageLite.emptyIntList();
    }

    private void ensureUserIdIsMutable() {
        B.g gVar = this.userId_;
        if (gVar.u()) {
            return;
        }
        this.userId_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static WarriorOuterClass$RequestSendReferral getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static WarriorOuterClass$RequestSendReferral parseDelimitedFrom(InputStream inputStream) {
        return (WarriorOuterClass$RequestSendReferral) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WarriorOuterClass$RequestSendReferral parseFrom(ByteBuffer byteBuffer) {
        return (WarriorOuterClass$RequestSendReferral) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setUserId(int i, int i2) {
        ensureUserIdIsMutable();
        this.userId_.U(i, i2);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (w2.a[gVar.ordinal()]) {
            case 1:
                return new WarriorOuterClass$RequestSendReferral();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001'", new Object[]{"userId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (WarriorOuterClass$RequestSendReferral.class) {
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

    public int getUserId(int i) {
        return this.userId_.getInt(i);
    }

    public int getUserIdCount() {
        return this.userId_.size();
    }

    public List<Integer> getUserIdList() {
        return this.userId_;
    }

    public static a newBuilder(WarriorOuterClass$RequestSendReferral warriorOuterClass$RequestSendReferral) {
        return (a) DEFAULT_INSTANCE.createBuilder(warriorOuterClass$RequestSendReferral);
    }

    public static WarriorOuterClass$RequestSendReferral parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (WarriorOuterClass$RequestSendReferral) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WarriorOuterClass$RequestSendReferral parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (WarriorOuterClass$RequestSendReferral) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static WarriorOuterClass$RequestSendReferral parseFrom(AbstractC2383g abstractC2383g) {
        return (WarriorOuterClass$RequestSendReferral) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static WarriorOuterClass$RequestSendReferral parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (WarriorOuterClass$RequestSendReferral) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static WarriorOuterClass$RequestSendReferral parseFrom(byte[] bArr) {
        return (WarriorOuterClass$RequestSendReferral) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WarriorOuterClass$RequestSendReferral parseFrom(byte[] bArr, C2394s c2394s) {
        return (WarriorOuterClass$RequestSendReferral) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static WarriorOuterClass$RequestSendReferral parseFrom(InputStream inputStream) {
        return (WarriorOuterClass$RequestSendReferral) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WarriorOuterClass$RequestSendReferral parseFrom(InputStream inputStream, C2394s c2394s) {
        return (WarriorOuterClass$RequestSendReferral) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WarriorOuterClass$RequestSendReferral parseFrom(AbstractC2384h abstractC2384h) {
        return (WarriorOuterClass$RequestSendReferral) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static WarriorOuterClass$RequestSendReferral parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (WarriorOuterClass$RequestSendReferral) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
