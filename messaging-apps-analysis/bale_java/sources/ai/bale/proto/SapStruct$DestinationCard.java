package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC7046Qa6;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SapStruct$DestinationCard extends GeneratedMessageLite implements InterfaceC7046Qa6 {
    private static final SapStruct$DestinationCard DEFAULT_INSTANCE;
    public static final int HOLDER_NAME_FIELD_NUMBER = 3;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int NUMBER_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private String id_ = "";
    private String number_ = "";
    private String holderName_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC7046Qa6 {
        public a A(String str) {
            q();
            ((SapStruct$DestinationCard) this.b).setHolderName(str);
            return this;
        }

        public a B(String str) {
            q();
            ((SapStruct$DestinationCard) this.b).setId(str);
            return this;
        }

        public a C(String str) {
            q();
            ((SapStruct$DestinationCard) this.b).setNumber(str);
            return this;
        }

        private a() {
            super(SapStruct$DestinationCard.DEFAULT_INSTANCE);
        }
    }

    static {
        SapStruct$DestinationCard sapStruct$DestinationCard = new SapStruct$DestinationCard();
        DEFAULT_INSTANCE = sapStruct$DestinationCard;
        GeneratedMessageLite.registerDefaultInstance(SapStruct$DestinationCard.class, sapStruct$DestinationCard);
    }

    private SapStruct$DestinationCard() {
    }

    private void clearHolderName() {
        this.holderName_ = getDefaultInstance().getHolderName();
    }

    private void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    private void clearNumber() {
        this.number_ = getDefaultInstance().getNumber();
    }

    public static SapStruct$DestinationCard getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SapStruct$DestinationCard parseDelimitedFrom(InputStream inputStream) {
        return (SapStruct$DestinationCard) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapStruct$DestinationCard parseFrom(ByteBuffer byteBuffer) {
        return (SapStruct$DestinationCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHolderName(String str) {
        str.getClass();
        this.holderName_ = str;
    }

    private void setHolderNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.holderName_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setId(String str) {
        str.getClass();
        this.id_ = str;
    }

    private void setIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.id_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNumber(String str) {
        str.getClass();
        this.number_ = str;
    }

    private void setNumberBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.number_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (I1.a[gVar.ordinal()]) {
            case 1:
                return new SapStruct$DestinationCard();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ", new Object[]{"id_", "number_", "holderName_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SapStruct$DestinationCard.class) {
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

    public String getHolderName() {
        return this.holderName_;
    }

    public AbstractC2383g getHolderNameBytes() {
        return AbstractC2383g.N(this.holderName_);
    }

    public String getId() {
        return this.id_;
    }

    public AbstractC2383g getIdBytes() {
        return AbstractC2383g.N(this.id_);
    }

    public String getNumber() {
        return this.number_;
    }

    public AbstractC2383g getNumberBytes() {
        return AbstractC2383g.N(this.number_);
    }

    public static a newBuilder(SapStruct$DestinationCard sapStruct$DestinationCard) {
        return (a) DEFAULT_INSTANCE.createBuilder(sapStruct$DestinationCard);
    }

    public static SapStruct$DestinationCard parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SapStruct$DestinationCard) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapStruct$DestinationCard parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SapStruct$DestinationCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SapStruct$DestinationCard parseFrom(AbstractC2383g abstractC2383g) {
        return (SapStruct$DestinationCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SapStruct$DestinationCard parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SapStruct$DestinationCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SapStruct$DestinationCard parseFrom(byte[] bArr) {
        return (SapStruct$DestinationCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SapStruct$DestinationCard parseFrom(byte[] bArr, C2394s c2394s) {
        return (SapStruct$DestinationCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SapStruct$DestinationCard parseFrom(InputStream inputStream) {
        return (SapStruct$DestinationCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapStruct$DestinationCard parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SapStruct$DestinationCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapStruct$DestinationCard parseFrom(AbstractC2384h abstractC2384h) {
        return (SapStruct$DestinationCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SapStruct$DestinationCard parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SapStruct$DestinationCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
