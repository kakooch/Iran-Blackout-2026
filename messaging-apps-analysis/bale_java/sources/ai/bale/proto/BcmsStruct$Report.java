package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC12450ee0;
import ir.nasim.InterfaceC11838de0;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class BcmsStruct$Report extends GeneratedMessageLite implements U64 {
    private static final BcmsStruct$Report DEFAULT_INSTANCE;
    public static final int GROUP_ID_FIELD_NUMBER = 1;
    public static final int MESSAGE_FIELD_NUMBER = 8;
    private static volatile KW4 PARSER = null;
    public static final int REASON_FIELD_NUMBER = 6;
    public static final int TIMESTAMP_FIELD_NUMBER = 5;
    public static final int TYPE_FIELD_NUMBER = 7;
    public static final int USER_ID_FIELD_NUMBER = 2;
    private long groupId_;
    private long timestamp_;
    private int type_;
    private long userId_;
    private String reason_ = "";
    private B.j message_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BcmsStruct$Report.DEFAULT_INSTANCE);
        }
    }

    static {
        BcmsStruct$Report bcmsStruct$Report = new BcmsStruct$Report();
        DEFAULT_INSTANCE = bcmsStruct$Report;
        GeneratedMessageLite.registerDefaultInstance(BcmsStruct$Report.class, bcmsStruct$Report);
    }

    private BcmsStruct$Report() {
    }

    private void addAllMessage(Iterable<? extends BcmsStruct$ReportMessage> iterable) {
        ensureMessageIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.message_);
    }

    private void addMessage(BcmsStruct$ReportMessage bcmsStruct$ReportMessage) {
        bcmsStruct$ReportMessage.getClass();
        ensureMessageIsMutable();
        this.message_.add(bcmsStruct$ReportMessage);
    }

    private void clearGroupId() {
        this.groupId_ = 0L;
    }

    private void clearMessage() {
        this.message_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearReason() {
        this.reason_ = getDefaultInstance().getReason();
    }

    private void clearTimestamp() {
        this.timestamp_ = 0L;
    }

    private void clearType() {
        this.type_ = 0;
    }

    private void clearUserId() {
        this.userId_ = 0L;
    }

    private void ensureMessageIsMutable() {
        B.j jVar = this.message_;
        if (jVar.u()) {
            return;
        }
        this.message_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static BcmsStruct$Report getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BcmsStruct$Report parseDelimitedFrom(InputStream inputStream) {
        return (BcmsStruct$Report) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BcmsStruct$Report parseFrom(ByteBuffer byteBuffer) {
        return (BcmsStruct$Report) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeMessage(int i) {
        ensureMessageIsMutable();
        this.message_.remove(i);
    }

    private void setGroupId(long j) {
        this.groupId_ = j;
    }

    private void setMessage(int i, BcmsStruct$ReportMessage bcmsStruct$ReportMessage) {
        bcmsStruct$ReportMessage.getClass();
        ensureMessageIsMutable();
        this.message_.set(i, bcmsStruct$ReportMessage);
    }

    private void setReason(String str) {
        str.getClass();
        this.reason_ = str;
    }

    private void setReasonBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.reason_ = abstractC2383g.f0();
    }

    private void setTimestamp(long j) {
        this.timestamp_ = j;
    }

    private void setType(EnumC12450ee0 enumC12450ee0) {
        this.type_ = enumC12450ee0.getNumber();
    }

    private void setTypeValue(int i) {
        this.type_ = i;
    }

    private void setUserId(long j) {
        this.userId_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1885q.a[gVar.ordinal()]) {
            case 1:
                return new BcmsStruct$Report();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\b\u0006\u0000\u0001\u0000\u0001\u0003\u0002\u0003\u0005\u0003\u0006Ȉ\u0007\f\b\u001b", new Object[]{"groupId_", "userId_", "timestamp_", "reason_", "type_", "message_", BcmsStruct$ReportMessage.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BcmsStruct$Report.class) {
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

    public long getGroupId() {
        return this.groupId_;
    }

    public BcmsStruct$ReportMessage getMessage(int i) {
        return (BcmsStruct$ReportMessage) this.message_.get(i);
    }

    public int getMessageCount() {
        return this.message_.size();
    }

    public List<BcmsStruct$ReportMessage> getMessageList() {
        return this.message_;
    }

    public InterfaceC11838de0 getMessageOrBuilder(int i) {
        return (InterfaceC11838de0) this.message_.get(i);
    }

    public List<? extends InterfaceC11838de0> getMessageOrBuilderList() {
        return this.message_;
    }

    public String getReason() {
        return this.reason_;
    }

    public AbstractC2383g getReasonBytes() {
        return AbstractC2383g.N(this.reason_);
    }

    public long getTimestamp() {
        return this.timestamp_;
    }

    public EnumC12450ee0 getType() {
        EnumC12450ee0 enumC12450ee0J = EnumC12450ee0.j(this.type_);
        return enumC12450ee0J == null ? EnumC12450ee0.UNRECOGNIZED : enumC12450ee0J;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public long getUserId() {
        return this.userId_;
    }

    public static a newBuilder(BcmsStruct$Report bcmsStruct$Report) {
        return (a) DEFAULT_INSTANCE.createBuilder(bcmsStruct$Report);
    }

    public static BcmsStruct$Report parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BcmsStruct$Report) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BcmsStruct$Report parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BcmsStruct$Report) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BcmsStruct$Report parseFrom(AbstractC2383g abstractC2383g) {
        return (BcmsStruct$Report) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addMessage(int i, BcmsStruct$ReportMessage bcmsStruct$ReportMessage) {
        bcmsStruct$ReportMessage.getClass();
        ensureMessageIsMutable();
        this.message_.add(i, bcmsStruct$ReportMessage);
    }

    public static BcmsStruct$Report parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BcmsStruct$Report) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BcmsStruct$Report parseFrom(byte[] bArr) {
        return (BcmsStruct$Report) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BcmsStruct$Report parseFrom(byte[] bArr, C2394s c2394s) {
        return (BcmsStruct$Report) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BcmsStruct$Report parseFrom(InputStream inputStream) {
        return (BcmsStruct$Report) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BcmsStruct$Report parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BcmsStruct$Report) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BcmsStruct$Report parseFrom(AbstractC2384h abstractC2384h) {
        return (BcmsStruct$Report) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BcmsStruct$Report parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BcmsStruct$Report) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
