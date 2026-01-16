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

/* loaded from: classes.dex */
public final class SefteOuterClass$RequestSignSefte extends GeneratedMessageLite implements U64 {
    private static final SefteOuterClass$RequestSignSefte DEFAULT_INSTANCE;
    public static final int NATIONAL_CODE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int PASSWORD_FIELD_NUMBER = 1;
    public static final int REQ_ID_FIELD_NUMBER = 2;
    private String password_ = "";
    private String reqId_ = "";
    private String nationalCode_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SefteOuterClass$RequestSignSefte.DEFAULT_INSTANCE);
        }
    }

    static {
        SefteOuterClass$RequestSignSefte sefteOuterClass$RequestSignSefte = new SefteOuterClass$RequestSignSefte();
        DEFAULT_INSTANCE = sefteOuterClass$RequestSignSefte;
        GeneratedMessageLite.registerDefaultInstance(SefteOuterClass$RequestSignSefte.class, sefteOuterClass$RequestSignSefte);
    }

    private SefteOuterClass$RequestSignSefte() {
    }

    private void clearNationalCode() {
        this.nationalCode_ = getDefaultInstance().getNationalCode();
    }

    private void clearPassword() {
        this.password_ = getDefaultInstance().getPassword();
    }

    private void clearReqId() {
        this.reqId_ = getDefaultInstance().getReqId();
    }

    public static SefteOuterClass$RequestSignSefte getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SefteOuterClass$RequestSignSefte parseDelimitedFrom(InputStream inputStream) {
        return (SefteOuterClass$RequestSignSefte) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SefteOuterClass$RequestSignSefte parseFrom(ByteBuffer byteBuffer) {
        return (SefteOuterClass$RequestSignSefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setNationalCode(String str) {
        str.getClass();
        this.nationalCode_ = str;
    }

    private void setNationalCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.nationalCode_ = abstractC2383g.f0();
    }

    private void setPassword(String str) {
        str.getClass();
        this.password_ = str;
    }

    private void setPasswordBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.password_ = abstractC2383g.f0();
    }

    private void setReqId(String str) {
        str.getClass();
        this.reqId_ = str;
    }

    private void setReqIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.reqId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (P1.a[gVar.ordinal()]) {
            case 1:
                return new SefteOuterClass$RequestSignSefte();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ", new Object[]{"password_", "reqId_", "nationalCode_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SefteOuterClass$RequestSignSefte.class) {
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

    public String getNationalCode() {
        return this.nationalCode_;
    }

    public AbstractC2383g getNationalCodeBytes() {
        return AbstractC2383g.N(this.nationalCode_);
    }

    public String getPassword() {
        return this.password_;
    }

    public AbstractC2383g getPasswordBytes() {
        return AbstractC2383g.N(this.password_);
    }

    public String getReqId() {
        return this.reqId_;
    }

    public AbstractC2383g getReqIdBytes() {
        return AbstractC2383g.N(this.reqId_);
    }

    public static a newBuilder(SefteOuterClass$RequestSignSefte sefteOuterClass$RequestSignSefte) {
        return (a) DEFAULT_INSTANCE.createBuilder(sefteOuterClass$RequestSignSefte);
    }

    public static SefteOuterClass$RequestSignSefte parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SefteOuterClass$RequestSignSefte) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SefteOuterClass$RequestSignSefte parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SefteOuterClass$RequestSignSefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SefteOuterClass$RequestSignSefte parseFrom(AbstractC2383g abstractC2383g) {
        return (SefteOuterClass$RequestSignSefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SefteOuterClass$RequestSignSefte parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SefteOuterClass$RequestSignSefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SefteOuterClass$RequestSignSefte parseFrom(byte[] bArr) {
        return (SefteOuterClass$RequestSignSefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SefteOuterClass$RequestSignSefte parseFrom(byte[] bArr, C2394s c2394s) {
        return (SefteOuterClass$RequestSignSefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SefteOuterClass$RequestSignSefte parseFrom(InputStream inputStream) {
        return (SefteOuterClass$RequestSignSefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SefteOuterClass$RequestSignSefte parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SefteOuterClass$RequestSignSefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SefteOuterClass$RequestSignSefte parseFrom(AbstractC2384h abstractC2384h) {
        return (SefteOuterClass$RequestSignSefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SefteOuterClass$RequestSignSefte parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SefteOuterClass$RequestSignSefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
