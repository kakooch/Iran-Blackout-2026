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
public final class WarriorOuterClass$ResponseGetUserRefers extends GeneratedMessageLite implements U64 {
    public static final int COUNT_FIELD_NUMBER = 1;
    private static final WarriorOuterClass$ResponseGetUserRefers DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int count_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(WarriorOuterClass$ResponseGetUserRefers.DEFAULT_INSTANCE);
        }
    }

    static {
        WarriorOuterClass$ResponseGetUserRefers warriorOuterClass$ResponseGetUserRefers = new WarriorOuterClass$ResponseGetUserRefers();
        DEFAULT_INSTANCE = warriorOuterClass$ResponseGetUserRefers;
        GeneratedMessageLite.registerDefaultInstance(WarriorOuterClass$ResponseGetUserRefers.class, warriorOuterClass$ResponseGetUserRefers);
    }

    private WarriorOuterClass$ResponseGetUserRefers() {
    }

    private void clearCount() {
        this.count_ = 0;
    }

    public static WarriorOuterClass$ResponseGetUserRefers getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static WarriorOuterClass$ResponseGetUserRefers parseDelimitedFrom(InputStream inputStream) {
        return (WarriorOuterClass$ResponseGetUserRefers) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WarriorOuterClass$ResponseGetUserRefers parseFrom(ByteBuffer byteBuffer) {
        return (WarriorOuterClass$ResponseGetUserRefers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCount(int i) {
        this.count_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (w2.a[gVar.ordinal()]) {
            case 1:
                return new WarriorOuterClass$ResponseGetUserRefers();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"count_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (WarriorOuterClass$ResponseGetUserRefers.class) {
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

    public int getCount() {
        return this.count_;
    }

    public static a newBuilder(WarriorOuterClass$ResponseGetUserRefers warriorOuterClass$ResponseGetUserRefers) {
        return (a) DEFAULT_INSTANCE.createBuilder(warriorOuterClass$ResponseGetUserRefers);
    }

    public static WarriorOuterClass$ResponseGetUserRefers parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (WarriorOuterClass$ResponseGetUserRefers) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WarriorOuterClass$ResponseGetUserRefers parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (WarriorOuterClass$ResponseGetUserRefers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static WarriorOuterClass$ResponseGetUserRefers parseFrom(AbstractC2383g abstractC2383g) {
        return (WarriorOuterClass$ResponseGetUserRefers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static WarriorOuterClass$ResponseGetUserRefers parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (WarriorOuterClass$ResponseGetUserRefers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static WarriorOuterClass$ResponseGetUserRefers parseFrom(byte[] bArr) {
        return (WarriorOuterClass$ResponseGetUserRefers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WarriorOuterClass$ResponseGetUserRefers parseFrom(byte[] bArr, C2394s c2394s) {
        return (WarriorOuterClass$ResponseGetUserRefers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static WarriorOuterClass$ResponseGetUserRefers parseFrom(InputStream inputStream) {
        return (WarriorOuterClass$ResponseGetUserRefers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WarriorOuterClass$ResponseGetUserRefers parseFrom(InputStream inputStream, C2394s c2394s) {
        return (WarriorOuterClass$ResponseGetUserRefers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WarriorOuterClass$ResponseGetUserRefers parseFrom(AbstractC2384h abstractC2384h) {
        return (WarriorOuterClass$ResponseGetUserRefers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static WarriorOuterClass$ResponseGetUserRefers parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (WarriorOuterClass$ResponseGetUserRefers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
