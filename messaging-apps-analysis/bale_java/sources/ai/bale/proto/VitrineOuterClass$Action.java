package ai.bale.proto;

import ai.bale.proto.VitrineOuterClass$ActionPayload;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC17790nZ7;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class VitrineOuterClass$Action extends GeneratedMessageLite implements U64 {
    private static final VitrineOuterClass$Action DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PAYLOAD_FIELD_NUMBER = 2;
    public static final int TYPE_FIELD_NUMBER = 1;
    private int bitField0_;
    private VitrineOuterClass$ActionPayload payload_;
    private int type_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(VitrineOuterClass$Action.DEFAULT_INSTANCE);
        }
    }

    static {
        VitrineOuterClass$Action vitrineOuterClass$Action = new VitrineOuterClass$Action();
        DEFAULT_INSTANCE = vitrineOuterClass$Action;
        GeneratedMessageLite.registerDefaultInstance(VitrineOuterClass$Action.class, vitrineOuterClass$Action);
    }

    private VitrineOuterClass$Action() {
    }

    private void clearPayload() {
        this.payload_ = null;
        this.bitField0_ &= -2;
    }

    private void clearType() {
        this.type_ = 0;
    }

    public static VitrineOuterClass$Action getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePayload(VitrineOuterClass$ActionPayload vitrineOuterClass$ActionPayload) {
        vitrineOuterClass$ActionPayload.getClass();
        VitrineOuterClass$ActionPayload vitrineOuterClass$ActionPayload2 = this.payload_;
        if (vitrineOuterClass$ActionPayload2 == null || vitrineOuterClass$ActionPayload2 == VitrineOuterClass$ActionPayload.getDefaultInstance()) {
            this.payload_ = vitrineOuterClass$ActionPayload;
        } else {
            this.payload_ = (VitrineOuterClass$ActionPayload) ((VitrineOuterClass$ActionPayload.a) VitrineOuterClass$ActionPayload.newBuilder(this.payload_).v(vitrineOuterClass$ActionPayload)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static VitrineOuterClass$Action parseDelimitedFrom(InputStream inputStream) {
        return (VitrineOuterClass$Action) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VitrineOuterClass$Action parseFrom(ByteBuffer byteBuffer) {
        return (VitrineOuterClass$Action) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPayload(VitrineOuterClass$ActionPayload vitrineOuterClass$ActionPayload) {
        vitrineOuterClass$ActionPayload.getClass();
        this.payload_ = vitrineOuterClass$ActionPayload;
        this.bitField0_ |= 1;
    }

    private void setType(EnumC17790nZ7 enumC17790nZ7) {
        this.type_ = enumC17790nZ7.getNumber();
    }

    private void setTypeValue(int i) {
        this.type_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (r2.a[gVar.ordinal()]) {
            case 1:
                return new VitrineOuterClass$Action();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002ဉ\u0000", new Object[]{"bitField0_", "type_", "payload_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (VitrineOuterClass$Action.class) {
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

    public VitrineOuterClass$ActionPayload getPayload() {
        VitrineOuterClass$ActionPayload vitrineOuterClass$ActionPayload = this.payload_;
        return vitrineOuterClass$ActionPayload == null ? VitrineOuterClass$ActionPayload.getDefaultInstance() : vitrineOuterClass$ActionPayload;
    }

    public EnumC17790nZ7 getType() {
        EnumC17790nZ7 enumC17790nZ7J = EnumC17790nZ7.j(this.type_);
        return enumC17790nZ7J == null ? EnumC17790nZ7.UNRECOGNIZED : enumC17790nZ7J;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public boolean hasPayload() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(VitrineOuterClass$Action vitrineOuterClass$Action) {
        return (a) DEFAULT_INSTANCE.createBuilder(vitrineOuterClass$Action);
    }

    public static VitrineOuterClass$Action parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (VitrineOuterClass$Action) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static VitrineOuterClass$Action parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (VitrineOuterClass$Action) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static VitrineOuterClass$Action parseFrom(AbstractC2383g abstractC2383g) {
        return (VitrineOuterClass$Action) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static VitrineOuterClass$Action parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (VitrineOuterClass$Action) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static VitrineOuterClass$Action parseFrom(byte[] bArr) {
        return (VitrineOuterClass$Action) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static VitrineOuterClass$Action parseFrom(byte[] bArr, C2394s c2394s) {
        return (VitrineOuterClass$Action) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static VitrineOuterClass$Action parseFrom(InputStream inputStream) {
        return (VitrineOuterClass$Action) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VitrineOuterClass$Action parseFrom(InputStream inputStream, C2394s c2394s) {
        return (VitrineOuterClass$Action) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static VitrineOuterClass$Action parseFrom(AbstractC2384h abstractC2384h) {
        return (VitrineOuterClass$Action) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static VitrineOuterClass$Action parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (VitrineOuterClass$Action) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
