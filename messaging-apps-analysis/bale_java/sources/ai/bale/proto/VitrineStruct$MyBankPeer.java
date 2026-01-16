package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC16311l35;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class VitrineStruct$MyBankPeer extends GeneratedMessageLite implements U64 {
    public static final int ACCESS_HASH_FIELD_NUMBER = 3;
    private static final VitrineStruct$MyBankPeer DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 2;
    public static final int MESSAGEDATE_FIELD_NUMBER = 5;
    public static final int MESSAGEID_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 1;
    private long accessHash_;
    private long id_;
    private long messageDate_;
    private long messageId_;
    private int type_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(VitrineStruct$MyBankPeer.DEFAULT_INSTANCE);
        }
    }

    static {
        VitrineStruct$MyBankPeer vitrineStruct$MyBankPeer = new VitrineStruct$MyBankPeer();
        DEFAULT_INSTANCE = vitrineStruct$MyBankPeer;
        GeneratedMessageLite.registerDefaultInstance(VitrineStruct$MyBankPeer.class, vitrineStruct$MyBankPeer);
    }

    private VitrineStruct$MyBankPeer() {
    }

    private void clearAccessHash() {
        this.accessHash_ = 0L;
    }

    private void clearId() {
        this.id_ = 0L;
    }

    private void clearMessageDate() {
        this.messageDate_ = 0L;
    }

    private void clearMessageId() {
        this.messageId_ = 0L;
    }

    private void clearType() {
        this.type_ = 0;
    }

    public static VitrineStruct$MyBankPeer getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static VitrineStruct$MyBankPeer parseDelimitedFrom(InputStream inputStream) {
        return (VitrineStruct$MyBankPeer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VitrineStruct$MyBankPeer parseFrom(ByteBuffer byteBuffer) {
        return (VitrineStruct$MyBankPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAccessHash(long j) {
        this.accessHash_ = j;
    }

    private void setId(long j) {
        this.id_ = j;
    }

    private void setMessageDate(long j) {
        this.messageDate_ = j;
    }

    private void setMessageId(long j) {
        this.messageId_ = j;
    }

    private void setType(EnumC16311l35 enumC16311l35) {
        this.type_ = enumC16311l35.getNumber();
    }

    private void setTypeValue(int i) {
        this.type_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (t2.a[gVar.ordinal()]) {
            case 1:
                return new VitrineStruct$MyBankPeer();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001\f\u0002\u0002\u0003\u0002\u0004\u0002\u0005\u0002", new Object[]{"type_", "id_", "accessHash_", "messageId_", "messageDate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (VitrineStruct$MyBankPeer.class) {
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

    public long getAccessHash() {
        return this.accessHash_;
    }

    public long getId() {
        return this.id_;
    }

    public long getMessageDate() {
        return this.messageDate_;
    }

    public long getMessageId() {
        return this.messageId_;
    }

    public EnumC16311l35 getType() {
        EnumC16311l35 enumC16311l35J = EnumC16311l35.j(this.type_);
        return enumC16311l35J == null ? EnumC16311l35.UNRECOGNIZED : enumC16311l35J;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public static a newBuilder(VitrineStruct$MyBankPeer vitrineStruct$MyBankPeer) {
        return (a) DEFAULT_INSTANCE.createBuilder(vitrineStruct$MyBankPeer);
    }

    public static VitrineStruct$MyBankPeer parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (VitrineStruct$MyBankPeer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static VitrineStruct$MyBankPeer parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (VitrineStruct$MyBankPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static VitrineStruct$MyBankPeer parseFrom(AbstractC2383g abstractC2383g) {
        return (VitrineStruct$MyBankPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static VitrineStruct$MyBankPeer parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (VitrineStruct$MyBankPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static VitrineStruct$MyBankPeer parseFrom(byte[] bArr) {
        return (VitrineStruct$MyBankPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static VitrineStruct$MyBankPeer parseFrom(byte[] bArr, C2394s c2394s) {
        return (VitrineStruct$MyBankPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static VitrineStruct$MyBankPeer parseFrom(InputStream inputStream) {
        return (VitrineStruct$MyBankPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VitrineStruct$MyBankPeer parseFrom(InputStream inputStream, C2394s c2394s) {
        return (VitrineStruct$MyBankPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static VitrineStruct$MyBankPeer parseFrom(AbstractC2384h abstractC2384h) {
        return (VitrineStruct$MyBankPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static VitrineStruct$MyBankPeer parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (VitrineStruct$MyBankPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
