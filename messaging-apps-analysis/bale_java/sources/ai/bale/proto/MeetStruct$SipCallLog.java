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
public final class MeetStruct$SipCallLog extends GeneratedMessageLite implements U64 {
    public static final int CALLEE_PHONE_FIELD_NUMBER = 7;
    public static final int CALLER_PHONE_FIELD_NUMBER = 6;
    public static final int CALLER_UID_FIELD_NUMBER = 5;
    public static final int CREATED_AT_FIELD_NUMBER = 2;
    private static final MeetStruct$SipCallLog DEFAULT_INSTANCE;
    public static final int DURATION_FIELD_NUMBER = 3;
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int PRICE_FIELD_NUMBER = 4;
    private int callerUid_;
    private long createdAt_;
    private long duration_;
    private long id_;
    private double price_;
    private String callerPhone_ = "";
    private String calleePhone_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MeetStruct$SipCallLog.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetStruct$SipCallLog meetStruct$SipCallLog = new MeetStruct$SipCallLog();
        DEFAULT_INSTANCE = meetStruct$SipCallLog;
        GeneratedMessageLite.registerDefaultInstance(MeetStruct$SipCallLog.class, meetStruct$SipCallLog);
    }

    private MeetStruct$SipCallLog() {
    }

    private void clearCalleePhone() {
        this.calleePhone_ = getDefaultInstance().getCalleePhone();
    }

    private void clearCallerPhone() {
        this.callerPhone_ = getDefaultInstance().getCallerPhone();
    }

    private void clearCallerUid() {
        this.callerUid_ = 0;
    }

    private void clearCreatedAt() {
        this.createdAt_ = 0L;
    }

    private void clearDuration() {
        this.duration_ = 0L;
    }

    private void clearId() {
        this.id_ = 0L;
    }

    private void clearPrice() {
        this.price_ = 0.0d;
    }

    public static MeetStruct$SipCallLog getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetStruct$SipCallLog parseDelimitedFrom(InputStream inputStream) {
        return (MeetStruct$SipCallLog) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetStruct$SipCallLog parseFrom(ByteBuffer byteBuffer) {
        return (MeetStruct$SipCallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCalleePhone(String str) {
        str.getClass();
        this.calleePhone_ = str;
    }

    private void setCalleePhoneBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.calleePhone_ = abstractC2383g.f0();
    }

    private void setCallerPhone(String str) {
        str.getClass();
        this.callerPhone_ = str;
    }

    private void setCallerPhoneBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.callerPhone_ = abstractC2383g.f0();
    }

    private void setCallerUid(int i) {
        this.callerUid_ = i;
    }

    private void setCreatedAt(long j) {
        this.createdAt_ = j;
    }

    private void setDuration(long j) {
        this.duration_ = j;
    }

    private void setId(long j) {
        this.id_ = j;
    }

    private void setPrice(double d) {
        this.price_ = d;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (G0.a[gVar.ordinal()]) {
            case 1:
                return new MeetStruct$SipCallLog();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001\u0002\u0002\u0002\u0003\u0002\u0004\u0000\u0005\u0004\u0006Ȉ\u0007Ȉ", new Object[]{"id_", "createdAt_", "duration_", "price_", "callerUid_", "callerPhone_", "calleePhone_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetStruct$SipCallLog.class) {
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

    public String getCalleePhone() {
        return this.calleePhone_;
    }

    public AbstractC2383g getCalleePhoneBytes() {
        return AbstractC2383g.N(this.calleePhone_);
    }

    public String getCallerPhone() {
        return this.callerPhone_;
    }

    public AbstractC2383g getCallerPhoneBytes() {
        return AbstractC2383g.N(this.callerPhone_);
    }

    public int getCallerUid() {
        return this.callerUid_;
    }

    public long getCreatedAt() {
        return this.createdAt_;
    }

    public long getDuration() {
        return this.duration_;
    }

    public long getId() {
        return this.id_;
    }

    public double getPrice() {
        return this.price_;
    }

    public static a newBuilder(MeetStruct$SipCallLog meetStruct$SipCallLog) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetStruct$SipCallLog);
    }

    public static MeetStruct$SipCallLog parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetStruct$SipCallLog) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetStruct$SipCallLog parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetStruct$SipCallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetStruct$SipCallLog parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetStruct$SipCallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MeetStruct$SipCallLog parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetStruct$SipCallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetStruct$SipCallLog parseFrom(byte[] bArr) {
        return (MeetStruct$SipCallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetStruct$SipCallLog parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetStruct$SipCallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetStruct$SipCallLog parseFrom(InputStream inputStream) {
        return (MeetStruct$SipCallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetStruct$SipCallLog parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetStruct$SipCallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetStruct$SipCallLog parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetStruct$SipCallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetStruct$SipCallLog parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetStruct$SipCallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
