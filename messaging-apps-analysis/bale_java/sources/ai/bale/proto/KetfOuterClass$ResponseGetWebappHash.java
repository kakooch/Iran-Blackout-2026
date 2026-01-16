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
public final class KetfOuterClass$ResponseGetWebappHash extends GeneratedMessageLite implements U64 {
    public static final int AUTH_DATE_FIELD_NUMBER = 3;
    private static final KetfOuterClass$ResponseGetWebappHash DEFAULT_INSTANCE;
    public static final int HASH_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int QUERY_ID_FIELD_NUMBER = 2;
    private long authDate_;
    private String hash_ = "";
    private String queryId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KetfOuterClass$ResponseGetWebappHash.DEFAULT_INSTANCE);
        }
    }

    static {
        KetfOuterClass$ResponseGetWebappHash ketfOuterClass$ResponseGetWebappHash = new KetfOuterClass$ResponseGetWebappHash();
        DEFAULT_INSTANCE = ketfOuterClass$ResponseGetWebappHash;
        GeneratedMessageLite.registerDefaultInstance(KetfOuterClass$ResponseGetWebappHash.class, ketfOuterClass$ResponseGetWebappHash);
    }

    private KetfOuterClass$ResponseGetWebappHash() {
    }

    private void clearAuthDate() {
        this.authDate_ = 0L;
    }

    private void clearHash() {
        this.hash_ = getDefaultInstance().getHash();
    }

    private void clearQueryId() {
        this.queryId_ = getDefaultInstance().getQueryId();
    }

    public static KetfOuterClass$ResponseGetWebappHash getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KetfOuterClass$ResponseGetWebappHash parseDelimitedFrom(InputStream inputStream) {
        return (KetfOuterClass$ResponseGetWebappHash) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfOuterClass$ResponseGetWebappHash parseFrom(ByteBuffer byteBuffer) {
        return (KetfOuterClass$ResponseGetWebappHash) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAuthDate(long j) {
        this.authDate_ = j;
    }

    private void setHash(String str) {
        str.getClass();
        this.hash_ = str;
    }

    private void setHashBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.hash_ = abstractC2383g.f0();
    }

    private void setQueryId(String str) {
        str.getClass();
        this.queryId_ = str;
    }

    private void setQueryIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.queryId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1888r0.a[gVar.ordinal()]) {
            case 1:
                return new KetfOuterClass$ResponseGetWebappHash();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0002", new Object[]{"hash_", "queryId_", "authDate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KetfOuterClass$ResponseGetWebappHash.class) {
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

    public long getAuthDate() {
        return this.authDate_;
    }

    public String getHash() {
        return this.hash_;
    }

    public AbstractC2383g getHashBytes() {
        return AbstractC2383g.N(this.hash_);
    }

    public String getQueryId() {
        return this.queryId_;
    }

    public AbstractC2383g getQueryIdBytes() {
        return AbstractC2383g.N(this.queryId_);
    }

    public static a newBuilder(KetfOuterClass$ResponseGetWebappHash ketfOuterClass$ResponseGetWebappHash) {
        return (a) DEFAULT_INSTANCE.createBuilder(ketfOuterClass$ResponseGetWebappHash);
    }

    public static KetfOuterClass$ResponseGetWebappHash parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetWebappHash) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfOuterClass$ResponseGetWebappHash parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetWebappHash) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KetfOuterClass$ResponseGetWebappHash parseFrom(AbstractC2383g abstractC2383g) {
        return (KetfOuterClass$ResponseGetWebappHash) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KetfOuterClass$ResponseGetWebappHash parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetWebappHash) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KetfOuterClass$ResponseGetWebappHash parseFrom(byte[] bArr) {
        return (KetfOuterClass$ResponseGetWebappHash) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KetfOuterClass$ResponseGetWebappHash parseFrom(byte[] bArr, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetWebappHash) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KetfOuterClass$ResponseGetWebappHash parseFrom(InputStream inputStream) {
        return (KetfOuterClass$ResponseGetWebappHash) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfOuterClass$ResponseGetWebappHash parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetWebappHash) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfOuterClass$ResponseGetWebappHash parseFrom(AbstractC2384h abstractC2384h) {
        return (KetfOuterClass$ResponseGetWebappHash) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KetfOuterClass$ResponseGetWebappHash parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetWebappHash) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
