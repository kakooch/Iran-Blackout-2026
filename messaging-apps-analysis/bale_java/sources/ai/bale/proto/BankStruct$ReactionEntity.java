package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.X60;
import ir.nasim.Y60;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class BankStruct$ReactionEntity extends GeneratedMessageLite implements X60 {
    private static final BankStruct$ReactionEntity DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SIZE_FIELD_NUMBER = 2;
    public static final int TYPE_FIELD_NUMBER = 1;
    private long size_;
    private int type_;

    public static final class a extends GeneratedMessageLite.b implements X60 {
        private a() {
            super(BankStruct$ReactionEntity.DEFAULT_INSTANCE);
        }
    }

    static {
        BankStruct$ReactionEntity bankStruct$ReactionEntity = new BankStruct$ReactionEntity();
        DEFAULT_INSTANCE = bankStruct$ReactionEntity;
        GeneratedMessageLite.registerDefaultInstance(BankStruct$ReactionEntity.class, bankStruct$ReactionEntity);
    }

    private BankStruct$ReactionEntity() {
    }

    private void clearSize() {
        this.size_ = 0L;
    }

    private void clearType() {
        this.type_ = 0;
    }

    public static BankStruct$ReactionEntity getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BankStruct$ReactionEntity parseDelimitedFrom(InputStream inputStream) {
        return (BankStruct$ReactionEntity) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankStruct$ReactionEntity parseFrom(ByteBuffer byteBuffer) {
        return (BankStruct$ReactionEntity) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setSize(long j) {
        this.size_ = j;
    }

    private void setType(Y60 y60) {
        this.type_ = y60.getNumber();
    }

    private void setTypeValue(int i) {
        this.type_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1879o.a[gVar.ordinal()]) {
            case 1:
                return new BankStruct$ReactionEntity();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u0002", new Object[]{"type_", "size_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BankStruct$ReactionEntity.class) {
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

    public long getSize() {
        return this.size_;
    }

    public Y60 getType() {
        Y60 y60J = Y60.j(this.type_);
        return y60J == null ? Y60.UNRECOGNIZED : y60J;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public static a newBuilder(BankStruct$ReactionEntity bankStruct$ReactionEntity) {
        return (a) DEFAULT_INSTANCE.createBuilder(bankStruct$ReactionEntity);
    }

    public static BankStruct$ReactionEntity parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BankStruct$ReactionEntity) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankStruct$ReactionEntity parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BankStruct$ReactionEntity) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BankStruct$ReactionEntity parseFrom(AbstractC2383g abstractC2383g) {
        return (BankStruct$ReactionEntity) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BankStruct$ReactionEntity parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BankStruct$ReactionEntity) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BankStruct$ReactionEntity parseFrom(byte[] bArr) {
        return (BankStruct$ReactionEntity) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BankStruct$ReactionEntity parseFrom(byte[] bArr, C2394s c2394s) {
        return (BankStruct$ReactionEntity) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BankStruct$ReactionEntity parseFrom(InputStream inputStream) {
        return (BankStruct$ReactionEntity) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankStruct$ReactionEntity parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BankStruct$ReactionEntity) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankStruct$ReactionEntity parseFrom(AbstractC2384h abstractC2384h) {
        return (BankStruct$ReactionEntity) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BankStruct$ReactionEntity parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BankStruct$ReactionEntity) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
