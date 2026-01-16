package bale.anonymous_contact.v1;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class AnonymousContactOuterClass$LangPair extends GeneratedMessageLite implements U64 {
    private static final AnonymousContactOuterClass$LangPair DEFAULT_INSTANCE;
    public static final int EN_FIELD_NUMBER = 2;
    public static final int FA_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private String fa_ = "";
    private String en_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AnonymousContactOuterClass$LangPair.DEFAULT_INSTANCE);
        }
    }

    static {
        AnonymousContactOuterClass$LangPair anonymousContactOuterClass$LangPair = new AnonymousContactOuterClass$LangPair();
        DEFAULT_INSTANCE = anonymousContactOuterClass$LangPair;
        GeneratedMessageLite.registerDefaultInstance(AnonymousContactOuterClass$LangPair.class, anonymousContactOuterClass$LangPair);
    }

    private AnonymousContactOuterClass$LangPair() {
    }

    private void clearEn() {
        this.en_ = getDefaultInstance().getEn();
    }

    private void clearFa() {
        this.fa_ = getDefaultInstance().getFa();
    }

    public static AnonymousContactOuterClass$LangPair getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AnonymousContactOuterClass$LangPair parseDelimitedFrom(InputStream inputStream) {
        return (AnonymousContactOuterClass$LangPair) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AnonymousContactOuterClass$LangPair parseFrom(ByteBuffer byteBuffer) {
        return (AnonymousContactOuterClass$LangPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setEn(String str) {
        str.getClass();
        this.en_ = str;
    }

    private void setEnBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.en_ = abstractC2383g.f0();
    }

    private void setFa(String str) {
        str.getClass();
        this.fa_ = str;
    }

    private void setFaBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.fa_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (bale.anonymous_contact.v1.a.a[gVar.ordinal()]) {
            case 1:
                return new AnonymousContactOuterClass$LangPair();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"fa_", "en_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AnonymousContactOuterClass$LangPair.class) {
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

    public String getEn() {
        return this.en_;
    }

    public AbstractC2383g getEnBytes() {
        return AbstractC2383g.N(this.en_);
    }

    public String getFa() {
        return this.fa_;
    }

    public AbstractC2383g getFaBytes() {
        return AbstractC2383g.N(this.fa_);
    }

    public static a newBuilder(AnonymousContactOuterClass$LangPair anonymousContactOuterClass$LangPair) {
        return (a) DEFAULT_INSTANCE.createBuilder(anonymousContactOuterClass$LangPair);
    }

    public static AnonymousContactOuterClass$LangPair parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AnonymousContactOuterClass$LangPair) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AnonymousContactOuterClass$LangPair parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AnonymousContactOuterClass$LangPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AnonymousContactOuterClass$LangPair parseFrom(AbstractC2383g abstractC2383g) {
        return (AnonymousContactOuterClass$LangPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AnonymousContactOuterClass$LangPair parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AnonymousContactOuterClass$LangPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AnonymousContactOuterClass$LangPair parseFrom(byte[] bArr) {
        return (AnonymousContactOuterClass$LangPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AnonymousContactOuterClass$LangPair parseFrom(byte[] bArr, C2394s c2394s) {
        return (AnonymousContactOuterClass$LangPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AnonymousContactOuterClass$LangPair parseFrom(InputStream inputStream) {
        return (AnonymousContactOuterClass$LangPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AnonymousContactOuterClass$LangPair parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AnonymousContactOuterClass$LangPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AnonymousContactOuterClass$LangPair parseFrom(AbstractC2384h abstractC2384h) {
        return (AnonymousContactOuterClass$LangPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AnonymousContactOuterClass$LangPair parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AnonymousContactOuterClass$LangPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
