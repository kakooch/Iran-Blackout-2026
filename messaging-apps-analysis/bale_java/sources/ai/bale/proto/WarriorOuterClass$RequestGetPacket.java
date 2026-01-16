package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC18688p48;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class WarriorOuterClass$RequestGetPacket extends GeneratedMessageLite implements U64 {
    private static final WarriorOuterClass$RequestGetPacket DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 1;
    private int type_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(WarriorOuterClass$RequestGetPacket.DEFAULT_INSTANCE);
        }
    }

    static {
        WarriorOuterClass$RequestGetPacket warriorOuterClass$RequestGetPacket = new WarriorOuterClass$RequestGetPacket();
        DEFAULT_INSTANCE = warriorOuterClass$RequestGetPacket;
        GeneratedMessageLite.registerDefaultInstance(WarriorOuterClass$RequestGetPacket.class, warriorOuterClass$RequestGetPacket);
    }

    private WarriorOuterClass$RequestGetPacket() {
    }

    private void clearType() {
        this.type_ = 0;
    }

    public static WarriorOuterClass$RequestGetPacket getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static WarriorOuterClass$RequestGetPacket parseDelimitedFrom(InputStream inputStream) {
        return (WarriorOuterClass$RequestGetPacket) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WarriorOuterClass$RequestGetPacket parseFrom(ByteBuffer byteBuffer) {
        return (WarriorOuterClass$RequestGetPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setType(EnumC18688p48 enumC18688p48) {
        this.type_ = enumC18688p48.getNumber();
    }

    private void setTypeValue(int i) {
        this.type_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (w2.a[gVar.ordinal()]) {
            case 1:
                return new WarriorOuterClass$RequestGetPacket();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"type_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (WarriorOuterClass$RequestGetPacket.class) {
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

    public EnumC18688p48 getType() {
        EnumC18688p48 enumC18688p48J = EnumC18688p48.j(this.type_);
        return enumC18688p48J == null ? EnumC18688p48.UNRECOGNIZED : enumC18688p48J;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public static a newBuilder(WarriorOuterClass$RequestGetPacket warriorOuterClass$RequestGetPacket) {
        return (a) DEFAULT_INSTANCE.createBuilder(warriorOuterClass$RequestGetPacket);
    }

    public static WarriorOuterClass$RequestGetPacket parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (WarriorOuterClass$RequestGetPacket) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WarriorOuterClass$RequestGetPacket parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (WarriorOuterClass$RequestGetPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static WarriorOuterClass$RequestGetPacket parseFrom(AbstractC2383g abstractC2383g) {
        return (WarriorOuterClass$RequestGetPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static WarriorOuterClass$RequestGetPacket parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (WarriorOuterClass$RequestGetPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static WarriorOuterClass$RequestGetPacket parseFrom(byte[] bArr) {
        return (WarriorOuterClass$RequestGetPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WarriorOuterClass$RequestGetPacket parseFrom(byte[] bArr, C2394s c2394s) {
        return (WarriorOuterClass$RequestGetPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static WarriorOuterClass$RequestGetPacket parseFrom(InputStream inputStream) {
        return (WarriorOuterClass$RequestGetPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WarriorOuterClass$RequestGetPacket parseFrom(InputStream inputStream, C2394s c2394s) {
        return (WarriorOuterClass$RequestGetPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WarriorOuterClass$RequestGetPacket parseFrom(AbstractC2384h abstractC2384h) {
        return (WarriorOuterClass$RequestGetPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static WarriorOuterClass$RequestGetPacket parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (WarriorOuterClass$RequestGetPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
