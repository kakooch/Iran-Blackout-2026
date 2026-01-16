package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PushStruct$APNUnregister extends GeneratedMessageLite implements U64 {
    private static final PushStruct$APNUnregister DEFAULT_INSTANCE;
    public static final int DEVICE_TOKEN_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int VOIP_DEVICE_TOKEN_FIELD_NUMBER = 2;
    private String deviceToken_ = "";
    private String voIPDeviceToken_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PushStruct$APNUnregister.DEFAULT_INSTANCE);
        }
    }

    static {
        PushStruct$APNUnregister pushStruct$APNUnregister = new PushStruct$APNUnregister();
        DEFAULT_INSTANCE = pushStruct$APNUnregister;
        GeneratedMessageLite.registerDefaultInstance(PushStruct$APNUnregister.class, pushStruct$APNUnregister);
    }

    private PushStruct$APNUnregister() {
    }

    private void clearDeviceToken() {
        this.deviceToken_ = getDefaultInstance().getDeviceToken();
    }

    private void clearVoIPDeviceToken() {
        this.voIPDeviceToken_ = getDefaultInstance().getVoIPDeviceToken();
    }

    public static PushStruct$APNUnregister getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PushStruct$APNUnregister parseDelimitedFrom(InputStream inputStream) {
        return (PushStruct$APNUnregister) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PushStruct$APNUnregister parseFrom(ByteBuffer byteBuffer) {
        return (PushStruct$APNUnregister) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDeviceToken(String str) {
        str.getClass();
        this.deviceToken_ = str;
    }

    private void setDeviceTokenBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.deviceToken_ = abstractC2383g.f0();
    }

    private void setVoIPDeviceToken(String str) {
        str.getClass();
        this.voIPDeviceToken_ = str;
    }

    private void setVoIPDeviceTokenBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.voIPDeviceToken_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1881o1.a[gVar.ordinal()]) {
            case 1:
                return new PushStruct$APNUnregister();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"deviceToken_", "voIPDeviceToken_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PushStruct$APNUnregister.class) {
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

    public String getDeviceToken() {
        return this.deviceToken_;
    }

    public AbstractC2383g getDeviceTokenBytes() {
        return AbstractC2383g.N(this.deviceToken_);
    }

    public String getVoIPDeviceToken() {
        return this.voIPDeviceToken_;
    }

    public AbstractC2383g getVoIPDeviceTokenBytes() {
        return AbstractC2383g.N(this.voIPDeviceToken_);
    }

    public static a newBuilder(PushStruct$APNUnregister pushStruct$APNUnregister) {
        return (a) DEFAULT_INSTANCE.createBuilder(pushStruct$APNUnregister);
    }

    public static PushStruct$APNUnregister parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PushStruct$APNUnregister) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PushStruct$APNUnregister parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PushStruct$APNUnregister) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PushStruct$APNUnregister parseFrom(AbstractC2383g abstractC2383g) {
        return (PushStruct$APNUnregister) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PushStruct$APNUnregister parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PushStruct$APNUnregister) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PushStruct$APNUnregister parseFrom(byte[] bArr) {
        return (PushStruct$APNUnregister) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PushStruct$APNUnregister parseFrom(byte[] bArr, C2394s c2394s) {
        return (PushStruct$APNUnregister) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PushStruct$APNUnregister parseFrom(InputStream inputStream) {
        return (PushStruct$APNUnregister) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PushStruct$APNUnregister parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PushStruct$APNUnregister) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PushStruct$APNUnregister parseFrom(AbstractC2384h abstractC2384h) {
        return (PushStruct$APNUnregister) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PushStruct$APNUnregister parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PushStruct$APNUnregister) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
