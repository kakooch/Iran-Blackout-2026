package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC18097o48;
import ir.nasim.EnumC18688p48;
import ir.nasim.InterfaceC19870r48;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class WarriorStruct$RewardPacket extends GeneratedMessageLite implements InterfaceC19870r48 {
    private static final WarriorStruct$RewardPacket DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int STATUS_FIELD_NUMBER = 2;
    public static final int TYPE_FIELD_NUMBER = 1;
    private int status_;
    private int type_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC19870r48 {
        private a() {
            super(WarriorStruct$RewardPacket.DEFAULT_INSTANCE);
        }
    }

    static {
        WarriorStruct$RewardPacket warriorStruct$RewardPacket = new WarriorStruct$RewardPacket();
        DEFAULT_INSTANCE = warriorStruct$RewardPacket;
        GeneratedMessageLite.registerDefaultInstance(WarriorStruct$RewardPacket.class, warriorStruct$RewardPacket);
    }

    private WarriorStruct$RewardPacket() {
    }

    private void clearStatus() {
        this.status_ = 0;
    }

    private void clearType() {
        this.type_ = 0;
    }

    public static WarriorStruct$RewardPacket getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static WarriorStruct$RewardPacket parseDelimitedFrom(InputStream inputStream) {
        return (WarriorStruct$RewardPacket) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WarriorStruct$RewardPacket parseFrom(ByteBuffer byteBuffer) {
        return (WarriorStruct$RewardPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setStatus(EnumC18097o48 enumC18097o48) {
        this.status_ = enumC18097o48.getNumber();
    }

    private void setStatusValue(int i) {
        this.status_ = i;
    }

    private void setType(EnumC18688p48 enumC18688p48) {
        this.type_ = enumC18688p48.getNumber();
    }

    private void setTypeValue(int i) {
        this.type_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (x2.a[gVar.ordinal()]) {
            case 1:
                return new WarriorStruct$RewardPacket();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\f", new Object[]{"type_", "status_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (WarriorStruct$RewardPacket.class) {
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

    public EnumC18097o48 getStatus() {
        EnumC18097o48 enumC18097o48J = EnumC18097o48.j(this.status_);
        return enumC18097o48J == null ? EnumC18097o48.UNRECOGNIZED : enumC18097o48J;
    }

    public int getStatusValue() {
        return this.status_;
    }

    public EnumC18688p48 getType() {
        EnumC18688p48 enumC18688p48J = EnumC18688p48.j(this.type_);
        return enumC18688p48J == null ? EnumC18688p48.UNRECOGNIZED : enumC18688p48J;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public static a newBuilder(WarriorStruct$RewardPacket warriorStruct$RewardPacket) {
        return (a) DEFAULT_INSTANCE.createBuilder(warriorStruct$RewardPacket);
    }

    public static WarriorStruct$RewardPacket parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (WarriorStruct$RewardPacket) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WarriorStruct$RewardPacket parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (WarriorStruct$RewardPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static WarriorStruct$RewardPacket parseFrom(AbstractC2383g abstractC2383g) {
        return (WarriorStruct$RewardPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static WarriorStruct$RewardPacket parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (WarriorStruct$RewardPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static WarriorStruct$RewardPacket parseFrom(byte[] bArr) {
        return (WarriorStruct$RewardPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WarriorStruct$RewardPacket parseFrom(byte[] bArr, C2394s c2394s) {
        return (WarriorStruct$RewardPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static WarriorStruct$RewardPacket parseFrom(InputStream inputStream) {
        return (WarriorStruct$RewardPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WarriorStruct$RewardPacket parseFrom(InputStream inputStream, C2394s c2394s) {
        return (WarriorStruct$RewardPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WarriorStruct$RewardPacket parseFrom(AbstractC2384h abstractC2384h) {
        return (WarriorStruct$RewardPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static WarriorStruct$RewardPacket parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (WarriorStruct$RewardPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
