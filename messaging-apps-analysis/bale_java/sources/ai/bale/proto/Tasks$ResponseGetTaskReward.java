package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class Tasks$ResponseGetTaskReward extends GeneratedMessageLite implements U64 {
    public static final int AMOUNT_RECEIVED_FIELD_NUMBER = 1;
    private static final Tasks$ResponseGetTaskReward DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int amountReceived_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Tasks$ResponseGetTaskReward.DEFAULT_INSTANCE);
        }
    }

    static {
        Tasks$ResponseGetTaskReward tasks$ResponseGetTaskReward = new Tasks$ResponseGetTaskReward();
        DEFAULT_INSTANCE = tasks$ResponseGetTaskReward;
        GeneratedMessageLite.registerDefaultInstance(Tasks$ResponseGetTaskReward.class, tasks$ResponseGetTaskReward);
    }

    private Tasks$ResponseGetTaskReward() {
    }

    private void clearAmountReceived() {
        this.amountReceived_ = 0;
    }

    public static Tasks$ResponseGetTaskReward getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Tasks$ResponseGetTaskReward parseDelimitedFrom(InputStream inputStream) {
        return (Tasks$ResponseGetTaskReward) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Tasks$ResponseGetTaskReward parseFrom(ByteBuffer byteBuffer) {
        return (Tasks$ResponseGetTaskReward) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmountReceived(int i) {
        this.amountReceived_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (g2.a[gVar.ordinal()]) {
            case 1:
                return new Tasks$ResponseGetTaskReward();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"amountReceived_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Tasks$ResponseGetTaskReward.class) {
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

    public int getAmountReceived() {
        return this.amountReceived_;
    }

    public static a newBuilder(Tasks$ResponseGetTaskReward tasks$ResponseGetTaskReward) {
        return (a) DEFAULT_INSTANCE.createBuilder(tasks$ResponseGetTaskReward);
    }

    public static Tasks$ResponseGetTaskReward parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Tasks$ResponseGetTaskReward) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Tasks$ResponseGetTaskReward parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Tasks$ResponseGetTaskReward) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Tasks$ResponseGetTaskReward parseFrom(AbstractC2383g abstractC2383g) {
        return (Tasks$ResponseGetTaskReward) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Tasks$ResponseGetTaskReward parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Tasks$ResponseGetTaskReward) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Tasks$ResponseGetTaskReward parseFrom(byte[] bArr) {
        return (Tasks$ResponseGetTaskReward) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Tasks$ResponseGetTaskReward parseFrom(byte[] bArr, C2394s c2394s) {
        return (Tasks$ResponseGetTaskReward) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Tasks$ResponseGetTaskReward parseFrom(InputStream inputStream) {
        return (Tasks$ResponseGetTaskReward) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Tasks$ResponseGetTaskReward parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Tasks$ResponseGetTaskReward) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Tasks$ResponseGetTaskReward parseFrom(AbstractC2384h abstractC2384h) {
        return (Tasks$ResponseGetTaskReward) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Tasks$ResponseGetTaskReward parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Tasks$ResponseGetTaskReward) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
