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
public final class FalakeOuterClass$RequestGetLinkStatus extends GeneratedMessageLite implements U64 {
    private static final FalakeOuterClass$RequestGetLinkStatus DEFAULT_INSTANCE;
    public static final int LINK_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private String link_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(String str) {
            q();
            ((FalakeOuterClass$RequestGetLinkStatus) this.b).setLink(str);
            return this;
        }

        private a() {
            super(FalakeOuterClass$RequestGetLinkStatus.DEFAULT_INSTANCE);
        }
    }

    static {
        FalakeOuterClass$RequestGetLinkStatus falakeOuterClass$RequestGetLinkStatus = new FalakeOuterClass$RequestGetLinkStatus();
        DEFAULT_INSTANCE = falakeOuterClass$RequestGetLinkStatus;
        GeneratedMessageLite.registerDefaultInstance(FalakeOuterClass$RequestGetLinkStatus.class, falakeOuterClass$RequestGetLinkStatus);
    }

    private FalakeOuterClass$RequestGetLinkStatus() {
    }

    private void clearLink() {
        this.link_ = getDefaultInstance().getLink();
    }

    public static FalakeOuterClass$RequestGetLinkStatus getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static FalakeOuterClass$RequestGetLinkStatus parseDelimitedFrom(InputStream inputStream) {
        return (FalakeOuterClass$RequestGetLinkStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FalakeOuterClass$RequestGetLinkStatus parseFrom(ByteBuffer byteBuffer) {
        return (FalakeOuterClass$RequestGetLinkStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLink(String str) {
        str.getClass();
        this.link_ = str;
    }

    private void setLinkBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.link_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (X.a[gVar.ordinal()]) {
            case 1:
                return new FalakeOuterClass$RequestGetLinkStatus();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"link_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (FalakeOuterClass$RequestGetLinkStatus.class) {
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

    public String getLink() {
        return this.link_;
    }

    public AbstractC2383g getLinkBytes() {
        return AbstractC2383g.N(this.link_);
    }

    public static a newBuilder(FalakeOuterClass$RequestGetLinkStatus falakeOuterClass$RequestGetLinkStatus) {
        return (a) DEFAULT_INSTANCE.createBuilder(falakeOuterClass$RequestGetLinkStatus);
    }

    public static FalakeOuterClass$RequestGetLinkStatus parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (FalakeOuterClass$RequestGetLinkStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static FalakeOuterClass$RequestGetLinkStatus parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (FalakeOuterClass$RequestGetLinkStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static FalakeOuterClass$RequestGetLinkStatus parseFrom(AbstractC2383g abstractC2383g) {
        return (FalakeOuterClass$RequestGetLinkStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static FalakeOuterClass$RequestGetLinkStatus parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (FalakeOuterClass$RequestGetLinkStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static FalakeOuterClass$RequestGetLinkStatus parseFrom(byte[] bArr) {
        return (FalakeOuterClass$RequestGetLinkStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static FalakeOuterClass$RequestGetLinkStatus parseFrom(byte[] bArr, C2394s c2394s) {
        return (FalakeOuterClass$RequestGetLinkStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static FalakeOuterClass$RequestGetLinkStatus parseFrom(InputStream inputStream) {
        return (FalakeOuterClass$RequestGetLinkStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FalakeOuterClass$RequestGetLinkStatus parseFrom(InputStream inputStream, C2394s c2394s) {
        return (FalakeOuterClass$RequestGetLinkStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static FalakeOuterClass$RequestGetLinkStatus parseFrom(AbstractC2384h abstractC2384h) {
        return (FalakeOuterClass$RequestGetLinkStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static FalakeOuterClass$RequestGetLinkStatus parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (FalakeOuterClass$RequestGetLinkStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
