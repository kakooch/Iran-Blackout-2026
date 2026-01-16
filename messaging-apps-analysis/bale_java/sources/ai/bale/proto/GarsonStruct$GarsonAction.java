package ai.bale.proto;

import ai.bale.proto.GarsonStruct$GarsonActionPayload;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC12214eE2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GarsonStruct$GarsonAction extends GeneratedMessageLite implements U64 {
    private static final GarsonStruct$GarsonAction DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PAYLOAD_FIELD_NUMBER = 2;
    public static final int TYPE_FIELD_NUMBER = 1;
    private int bitField0_;
    private GarsonStruct$GarsonActionPayload payload_;
    private int type_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GarsonStruct$GarsonAction.DEFAULT_INSTANCE);
        }
    }

    static {
        GarsonStruct$GarsonAction garsonStruct$GarsonAction = new GarsonStruct$GarsonAction();
        DEFAULT_INSTANCE = garsonStruct$GarsonAction;
        GeneratedMessageLite.registerDefaultInstance(GarsonStruct$GarsonAction.class, garsonStruct$GarsonAction);
    }

    private GarsonStruct$GarsonAction() {
    }

    private void clearPayload() {
        this.payload_ = null;
        this.bitField0_ &= -2;
    }

    private void clearType() {
        this.type_ = 0;
    }

    public static GarsonStruct$GarsonAction getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePayload(GarsonStruct$GarsonActionPayload garsonStruct$GarsonActionPayload) {
        garsonStruct$GarsonActionPayload.getClass();
        GarsonStruct$GarsonActionPayload garsonStruct$GarsonActionPayload2 = this.payload_;
        if (garsonStruct$GarsonActionPayload2 == null || garsonStruct$GarsonActionPayload2 == GarsonStruct$GarsonActionPayload.getDefaultInstance()) {
            this.payload_ = garsonStruct$GarsonActionPayload;
        } else {
            this.payload_ = (GarsonStruct$GarsonActionPayload) ((GarsonStruct$GarsonActionPayload.a) GarsonStruct$GarsonActionPayload.newBuilder(this.payload_).v(garsonStruct$GarsonActionPayload)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GarsonStruct$GarsonAction parseDelimitedFrom(InputStream inputStream) {
        return (GarsonStruct$GarsonAction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonStruct$GarsonAction parseFrom(ByteBuffer byteBuffer) {
        return (GarsonStruct$GarsonAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPayload(GarsonStruct$GarsonActionPayload garsonStruct$GarsonActionPayload) {
        garsonStruct$GarsonActionPayload.getClass();
        this.payload_ = garsonStruct$GarsonActionPayload;
        this.bitField0_ |= 1;
    }

    private void setType(EnumC12214eE2 enumC12214eE2) {
        this.type_ = enumC12214eE2.getNumber();
    }

    private void setTypeValue(int i) {
        this.type_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1850e0.a[gVar.ordinal()]) {
            case 1:
                return new GarsonStruct$GarsonAction();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002ဉ\u0000", new Object[]{"bitField0_", "type_", "payload_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GarsonStruct$GarsonAction.class) {
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

    public GarsonStruct$GarsonActionPayload getPayload() {
        GarsonStruct$GarsonActionPayload garsonStruct$GarsonActionPayload = this.payload_;
        return garsonStruct$GarsonActionPayload == null ? GarsonStruct$GarsonActionPayload.getDefaultInstance() : garsonStruct$GarsonActionPayload;
    }

    public EnumC12214eE2 getType() {
        EnumC12214eE2 enumC12214eE2J = EnumC12214eE2.j(this.type_);
        return enumC12214eE2J == null ? EnumC12214eE2.UNRECOGNIZED : enumC12214eE2J;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public boolean hasPayload() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(GarsonStruct$GarsonAction garsonStruct$GarsonAction) {
        return (a) DEFAULT_INSTANCE.createBuilder(garsonStruct$GarsonAction);
    }

    public static GarsonStruct$GarsonAction parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonStruct$GarsonAction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonStruct$GarsonAction parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GarsonStruct$GarsonAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GarsonStruct$GarsonAction parseFrom(AbstractC2383g abstractC2383g) {
        return (GarsonStruct$GarsonAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GarsonStruct$GarsonAction parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GarsonStruct$GarsonAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GarsonStruct$GarsonAction parseFrom(byte[] bArr) {
        return (GarsonStruct$GarsonAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GarsonStruct$GarsonAction parseFrom(byte[] bArr, C2394s c2394s) {
        return (GarsonStruct$GarsonAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GarsonStruct$GarsonAction parseFrom(InputStream inputStream) {
        return (GarsonStruct$GarsonAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonStruct$GarsonAction parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonStruct$GarsonAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonStruct$GarsonAction parseFrom(AbstractC2384h abstractC2384h) {
        return (GarsonStruct$GarsonAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GarsonStruct$GarsonAction parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GarsonStruct$GarsonAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
