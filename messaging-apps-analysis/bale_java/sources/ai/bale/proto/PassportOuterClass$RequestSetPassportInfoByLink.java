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
public final class PassportOuterClass$RequestSetPassportInfoByLink extends GeneratedMessageLite implements U64 {
    private static final PassportOuterClass$RequestSetPassportInfoByLink DEFAULT_INSTANCE;
    public static final int LINK_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private String linkId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(String str) {
            q();
            ((PassportOuterClass$RequestSetPassportInfoByLink) this.b).setLinkId(str);
            return this;
        }

        private a() {
            super(PassportOuterClass$RequestSetPassportInfoByLink.DEFAULT_INSTANCE);
        }
    }

    static {
        PassportOuterClass$RequestSetPassportInfoByLink passportOuterClass$RequestSetPassportInfoByLink = new PassportOuterClass$RequestSetPassportInfoByLink();
        DEFAULT_INSTANCE = passportOuterClass$RequestSetPassportInfoByLink;
        GeneratedMessageLite.registerDefaultInstance(PassportOuterClass$RequestSetPassportInfoByLink.class, passportOuterClass$RequestSetPassportInfoByLink);
    }

    private PassportOuterClass$RequestSetPassportInfoByLink() {
    }

    private void clearLinkId() {
        this.linkId_ = getDefaultInstance().getLinkId();
    }

    public static PassportOuterClass$RequestSetPassportInfoByLink getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PassportOuterClass$RequestSetPassportInfoByLink parseDelimitedFrom(InputStream inputStream) {
        return (PassportOuterClass$RequestSetPassportInfoByLink) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportOuterClass$RequestSetPassportInfoByLink parseFrom(ByteBuffer byteBuffer) {
        return (PassportOuterClass$RequestSetPassportInfoByLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLinkId(String str) {
        str.getClass();
        this.linkId_ = str;
    }

    private void setLinkIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.linkId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (Y0.a[gVar.ordinal()]) {
            case 1:
                return new PassportOuterClass$RequestSetPassportInfoByLink();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"linkId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PassportOuterClass$RequestSetPassportInfoByLink.class) {
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

    public String getLinkId() {
        return this.linkId_;
    }

    public AbstractC2383g getLinkIdBytes() {
        return AbstractC2383g.N(this.linkId_);
    }

    public static a newBuilder(PassportOuterClass$RequestSetPassportInfoByLink passportOuterClass$RequestSetPassportInfoByLink) {
        return (a) DEFAULT_INSTANCE.createBuilder(passportOuterClass$RequestSetPassportInfoByLink);
    }

    public static PassportOuterClass$RequestSetPassportInfoByLink parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportOuterClass$RequestSetPassportInfoByLink) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportOuterClass$RequestSetPassportInfoByLink parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PassportOuterClass$RequestSetPassportInfoByLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PassportOuterClass$RequestSetPassportInfoByLink parseFrom(AbstractC2383g abstractC2383g) {
        return (PassportOuterClass$RequestSetPassportInfoByLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PassportOuterClass$RequestSetPassportInfoByLink parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PassportOuterClass$RequestSetPassportInfoByLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PassportOuterClass$RequestSetPassportInfoByLink parseFrom(byte[] bArr) {
        return (PassportOuterClass$RequestSetPassportInfoByLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PassportOuterClass$RequestSetPassportInfoByLink parseFrom(byte[] bArr, C2394s c2394s) {
        return (PassportOuterClass$RequestSetPassportInfoByLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PassportOuterClass$RequestSetPassportInfoByLink parseFrom(InputStream inputStream) {
        return (PassportOuterClass$RequestSetPassportInfoByLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportOuterClass$RequestSetPassportInfoByLink parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportOuterClass$RequestSetPassportInfoByLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportOuterClass$RequestSetPassportInfoByLink parseFrom(AbstractC2384h abstractC2384h) {
        return (PassportOuterClass$RequestSetPassportInfoByLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PassportOuterClass$RequestSetPassportInfoByLink parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PassportOuterClass$RequestSetPassportInfoByLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
