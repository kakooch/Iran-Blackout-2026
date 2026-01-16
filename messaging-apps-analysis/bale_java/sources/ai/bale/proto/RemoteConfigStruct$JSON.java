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
public final class RemoteConfigStruct$JSON extends GeneratedMessageLite implements U64 {
    private static final RemoteConfigStruct$JSON DEFAULT_INSTANCE;
    public static final int JSON_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private String json_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(RemoteConfigStruct$JSON.DEFAULT_INSTANCE);
        }
    }

    static {
        RemoteConfigStruct$JSON remoteConfigStruct$JSON = new RemoteConfigStruct$JSON();
        DEFAULT_INSTANCE = remoteConfigStruct$JSON;
        GeneratedMessageLite.registerDefaultInstance(RemoteConfigStruct$JSON.class, remoteConfigStruct$JSON);
    }

    private RemoteConfigStruct$JSON() {
    }

    private void clearJson() {
        this.json_ = getDefaultInstance().getJson();
    }

    public static RemoteConfigStruct$JSON getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static RemoteConfigStruct$JSON parseDelimitedFrom(InputStream inputStream) {
        return (RemoteConfigStruct$JSON) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RemoteConfigStruct$JSON parseFrom(ByteBuffer byteBuffer) {
        return (RemoteConfigStruct$JSON) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setJson(String str) {
        str.getClass();
        this.json_ = str;
    }

    private void setJsonBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.json_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1904w1.a[gVar.ordinal()]) {
            case 1:
                return new RemoteConfigStruct$JSON();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"json_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (RemoteConfigStruct$JSON.class) {
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

    public String getJson() {
        return this.json_;
    }

    public AbstractC2383g getJsonBytes() {
        return AbstractC2383g.N(this.json_);
    }

    public static a newBuilder(RemoteConfigStruct$JSON remoteConfigStruct$JSON) {
        return (a) DEFAULT_INSTANCE.createBuilder(remoteConfigStruct$JSON);
    }

    public static RemoteConfigStruct$JSON parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (RemoteConfigStruct$JSON) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static RemoteConfigStruct$JSON parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (RemoteConfigStruct$JSON) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static RemoteConfigStruct$JSON parseFrom(AbstractC2383g abstractC2383g) {
        return (RemoteConfigStruct$JSON) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static RemoteConfigStruct$JSON parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (RemoteConfigStruct$JSON) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static RemoteConfigStruct$JSON parseFrom(byte[] bArr) {
        return (RemoteConfigStruct$JSON) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RemoteConfigStruct$JSON parseFrom(byte[] bArr, C2394s c2394s) {
        return (RemoteConfigStruct$JSON) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static RemoteConfigStruct$JSON parseFrom(InputStream inputStream) {
        return (RemoteConfigStruct$JSON) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RemoteConfigStruct$JSON parseFrom(InputStream inputStream, C2394s c2394s) {
        return (RemoteConfigStruct$JSON) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static RemoteConfigStruct$JSON parseFrom(AbstractC2384h abstractC2384h) {
        return (RemoteConfigStruct$JSON) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static RemoteConfigStruct$JSON parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (RemoteConfigStruct$JSON) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
