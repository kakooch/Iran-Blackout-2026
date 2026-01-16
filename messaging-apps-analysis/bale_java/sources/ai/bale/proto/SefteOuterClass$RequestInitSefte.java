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
public final class SefteOuterClass$RequestInitSefte extends GeneratedMessageLite implements U64 {
    public static final int AMOUNT_FIELD_NUMBER = 1;
    private static final SefteOuterClass$RequestInitSefte DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 2;
    public static final int DUE_TO_FIELD_NUMBER = 3;
    public static final int NATIONAL_CODE_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int RECIPIENT_ID_FIELD_NUMBER = 4;
    private long amount_;
    private String description_ = "";
    private String dueTo_ = "";
    private String nationalCode_ = "";
    private long recipientId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SefteOuterClass$RequestInitSefte.DEFAULT_INSTANCE);
        }
    }

    static {
        SefteOuterClass$RequestInitSefte sefteOuterClass$RequestInitSefte = new SefteOuterClass$RequestInitSefte();
        DEFAULT_INSTANCE = sefteOuterClass$RequestInitSefte;
        GeneratedMessageLite.registerDefaultInstance(SefteOuterClass$RequestInitSefte.class, sefteOuterClass$RequestInitSefte);
    }

    private SefteOuterClass$RequestInitSefte() {
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    private void clearDueTo() {
        this.dueTo_ = getDefaultInstance().getDueTo();
    }

    private void clearNationalCode() {
        this.nationalCode_ = getDefaultInstance().getNationalCode();
    }

    private void clearRecipientId() {
        this.recipientId_ = 0L;
    }

    public static SefteOuterClass$RequestInitSefte getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SefteOuterClass$RequestInitSefte parseDelimitedFrom(InputStream inputStream) {
        return (SefteOuterClass$RequestInitSefte) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SefteOuterClass$RequestInitSefte parseFrom(ByteBuffer byteBuffer) {
        return (SefteOuterClass$RequestInitSefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(long j) {
        this.amount_ = j;
    }

    private void setDescription(String str) {
        str.getClass();
        this.description_ = str;
    }

    private void setDescriptionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.description_ = abstractC2383g.f0();
    }

    private void setDueTo(String str) {
        str.getClass();
        this.dueTo_ = str;
    }

    private void setDueToBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.dueTo_ = abstractC2383g.f0();
    }

    private void setNationalCode(String str) {
        str.getClass();
        this.nationalCode_ = str;
    }

    private void setNationalCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.nationalCode_ = abstractC2383g.f0();
    }

    private void setRecipientId(long j) {
        this.recipientId_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (P1.a[gVar.ordinal()]) {
            case 1:
                return new SefteOuterClass$RequestInitSefte();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u0002\u0002Ȉ\u0003Ȉ\u0004\u0002\u0005Ȉ", new Object[]{"amount_", "description_", "dueTo_", "recipientId_", "nationalCode_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SefteOuterClass$RequestInitSefte.class) {
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

    public long getAmount() {
        return this.amount_;
    }

    public String getDescription() {
        return this.description_;
    }

    public AbstractC2383g getDescriptionBytes() {
        return AbstractC2383g.N(this.description_);
    }

    public String getDueTo() {
        return this.dueTo_;
    }

    public AbstractC2383g getDueToBytes() {
        return AbstractC2383g.N(this.dueTo_);
    }

    public String getNationalCode() {
        return this.nationalCode_;
    }

    public AbstractC2383g getNationalCodeBytes() {
        return AbstractC2383g.N(this.nationalCode_);
    }

    public long getRecipientId() {
        return this.recipientId_;
    }

    public static a newBuilder(SefteOuterClass$RequestInitSefte sefteOuterClass$RequestInitSefte) {
        return (a) DEFAULT_INSTANCE.createBuilder(sefteOuterClass$RequestInitSefte);
    }

    public static SefteOuterClass$RequestInitSefte parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SefteOuterClass$RequestInitSefte) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SefteOuterClass$RequestInitSefte parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SefteOuterClass$RequestInitSefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SefteOuterClass$RequestInitSefte parseFrom(AbstractC2383g abstractC2383g) {
        return (SefteOuterClass$RequestInitSefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SefteOuterClass$RequestInitSefte parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SefteOuterClass$RequestInitSefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SefteOuterClass$RequestInitSefte parseFrom(byte[] bArr) {
        return (SefteOuterClass$RequestInitSefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SefteOuterClass$RequestInitSefte parseFrom(byte[] bArr, C2394s c2394s) {
        return (SefteOuterClass$RequestInitSefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SefteOuterClass$RequestInitSefte parseFrom(InputStream inputStream) {
        return (SefteOuterClass$RequestInitSefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SefteOuterClass$RequestInitSefte parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SefteOuterClass$RequestInitSefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SefteOuterClass$RequestInitSefte parseFrom(AbstractC2384h abstractC2384h) {
        return (SefteOuterClass$RequestInitSefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SefteOuterClass$RequestInitSefte parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SefteOuterClass$RequestInitSefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
