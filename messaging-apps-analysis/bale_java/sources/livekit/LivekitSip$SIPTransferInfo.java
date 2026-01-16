package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EF3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import livekit.LivekitSip$SIPStatus;

/* loaded from: classes8.dex */
public final class LivekitSip$SIPTransferInfo extends GeneratedMessageLite implements U64 {
    public static final int CALL_ID_FIELD_NUMBER = 2;
    private static final LivekitSip$SIPTransferInfo DEFAULT_INSTANCE;
    public static final int ERROR_FIELD_NUMBER = 7;
    private static volatile KW4 PARSER = null;
    public static final int TRANSFER_COMPLETED_AT_NS_FIELD_NUMBER = 5;
    public static final int TRANSFER_ID_FIELD_NUMBER = 1;
    public static final int TRANSFER_INITIATED_AT_NS_FIELD_NUMBER = 4;
    public static final int TRANSFER_STATUS_CODE_FIELD_NUMBER = 8;
    public static final int TRANSFER_STATUS_FIELD_NUMBER = 6;
    public static final int TRANSFER_TO_FIELD_NUMBER = 3;
    private long transferCompletedAtNs_;
    private long transferInitiatedAtNs_;
    private LivekitSip$SIPStatus transferStatusCode_;
    private int transferStatus_;
    private String transferId_ = "";
    private String callId_ = "";
    private String transferTo_ = "";
    private String error_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(t tVar) {
            this();
        }

        private a() {
            super(LivekitSip$SIPTransferInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitSip$SIPTransferInfo livekitSip$SIPTransferInfo = new LivekitSip$SIPTransferInfo();
        DEFAULT_INSTANCE = livekitSip$SIPTransferInfo;
        GeneratedMessageLite.registerDefaultInstance(LivekitSip$SIPTransferInfo.class, livekitSip$SIPTransferInfo);
    }

    private LivekitSip$SIPTransferInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCallId() {
        this.callId_ = getDefaultInstance().getCallId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearError() {
        this.error_ = getDefaultInstance().getError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTransferCompletedAtNs() {
        this.transferCompletedAtNs_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTransferId() {
        this.transferId_ = getDefaultInstance().getTransferId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTransferInitiatedAtNs() {
        this.transferInitiatedAtNs_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTransferStatus() {
        this.transferStatus_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTransferStatusCode() {
        this.transferStatusCode_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTransferTo() {
        this.transferTo_ = getDefaultInstance().getTransferTo();
    }

    public static LivekitSip$SIPTransferInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeTransferStatusCode(LivekitSip$SIPStatus livekitSip$SIPStatus) {
        livekitSip$SIPStatus.getClass();
        LivekitSip$SIPStatus livekitSip$SIPStatus2 = this.transferStatusCode_;
        if (livekitSip$SIPStatus2 == null || livekitSip$SIPStatus2 == LivekitSip$SIPStatus.getDefaultInstance()) {
            this.transferStatusCode_ = livekitSip$SIPStatus;
        } else {
            this.transferStatusCode_ = (LivekitSip$SIPStatus) ((LivekitSip$SIPStatus.a) LivekitSip$SIPStatus.newBuilder(this.transferStatusCode_).v(livekitSip$SIPStatus)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitSip$SIPTransferInfo parseDelimitedFrom(InputStream inputStream) {
        return (LivekitSip$SIPTransferInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$SIPTransferInfo parseFrom(ByteBuffer byteBuffer) {
        return (LivekitSip$SIPTransferInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCallId(String str) {
        str.getClass();
        this.callId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCallIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.callId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setError(String str) {
        str.getClass();
        this.error_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setErrorBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.error_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTransferCompletedAtNs(long j) {
        this.transferCompletedAtNs_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTransferId(String str) {
        str.getClass();
        this.transferId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTransferIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.transferId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTransferInitiatedAtNs(long j) {
        this.transferInitiatedAtNs_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTransferStatus(EF3 ef3) {
        this.transferStatus_ = ef3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTransferStatusCode(LivekitSip$SIPStatus livekitSip$SIPStatus) {
        livekitSip$SIPStatus.getClass();
        this.transferStatusCode_ = livekitSip$SIPStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTransferStatusValue(int i) {
        this.transferStatus_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTransferTo(String str) {
        str.getClass();
        this.transferTo_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTransferToBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.transferTo_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        t tVar = null;
        switch (t.a[gVar.ordinal()]) {
            case 1:
                return new LivekitSip$SIPTransferInfo();
            case 2:
                return new a(tVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0000\u0001\b\b\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004\u0002\u0005\u0002\u0006\f\u0007Ȉ\b\t", new Object[]{"transferId_", "callId_", "transferTo_", "transferInitiatedAtNs_", "transferCompletedAtNs_", "transferStatus_", "error_", "transferStatusCode_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitSip$SIPTransferInfo.class) {
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

    public String getCallId() {
        return this.callId_;
    }

    public AbstractC2383g getCallIdBytes() {
        return AbstractC2383g.N(this.callId_);
    }

    public String getError() {
        return this.error_;
    }

    public AbstractC2383g getErrorBytes() {
        return AbstractC2383g.N(this.error_);
    }

    public long getTransferCompletedAtNs() {
        return this.transferCompletedAtNs_;
    }

    public String getTransferId() {
        return this.transferId_;
    }

    public AbstractC2383g getTransferIdBytes() {
        return AbstractC2383g.N(this.transferId_);
    }

    public long getTransferInitiatedAtNs() {
        return this.transferInitiatedAtNs_;
    }

    public EF3 getTransferStatus() {
        EF3 ef3J = EF3.j(this.transferStatus_);
        return ef3J == null ? EF3.UNRECOGNIZED : ef3J;
    }

    public LivekitSip$SIPStatus getTransferStatusCode() {
        LivekitSip$SIPStatus livekitSip$SIPStatus = this.transferStatusCode_;
        return livekitSip$SIPStatus == null ? LivekitSip$SIPStatus.getDefaultInstance() : livekitSip$SIPStatus;
    }

    public int getTransferStatusValue() {
        return this.transferStatus_;
    }

    public String getTransferTo() {
        return this.transferTo_;
    }

    public AbstractC2383g getTransferToBytes() {
        return AbstractC2383g.N(this.transferTo_);
    }

    public boolean hasTransferStatusCode() {
        return this.transferStatusCode_ != null;
    }

    public static a newBuilder(LivekitSip$SIPTransferInfo livekitSip$SIPTransferInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitSip$SIPTransferInfo);
    }

    public static LivekitSip$SIPTransferInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$SIPTransferInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$SIPTransferInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitSip$SIPTransferInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitSip$SIPTransferInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitSip$SIPTransferInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitSip$SIPTransferInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitSip$SIPTransferInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitSip$SIPTransferInfo parseFrom(byte[] bArr) {
        return (LivekitSip$SIPTransferInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitSip$SIPTransferInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitSip$SIPTransferInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitSip$SIPTransferInfo parseFrom(InputStream inputStream) {
        return (LivekitSip$SIPTransferInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$SIPTransferInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$SIPTransferInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$SIPTransferInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitSip$SIPTransferInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitSip$SIPTransferInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitSip$SIPTransferInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
