package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.C75;
import ir.nasim.InterfaceC23559x75;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PfmStruct$PfmTransactionId extends GeneratedMessageLite implements InterfaceC23559x75 {
    public static final int ACCOUNT_NUMBER_FIELD_NUMBER = 1;
    public static final int DATE_FIELD_NUMBER = 3;
    private static final PfmStruct$PfmTransactionId DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 4;
    private long accountNumber_;
    private long date_;
    private long id_;
    private int type_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC23559x75 {
        public a A(long j) {
            q();
            ((PfmStruct$PfmTransactionId) this.b).setAccountNumber(j);
            return this;
        }

        public a B(long j) {
            q();
            ((PfmStruct$PfmTransactionId) this.b).setDate(j);
            return this;
        }

        public a C(long j) {
            q();
            ((PfmStruct$PfmTransactionId) this.b).setId(j);
            return this;
        }

        public a D(C75 c75) {
            q();
            ((PfmStruct$PfmTransactionId) this.b).setType(c75);
            return this;
        }

        private a() {
            super(PfmStruct$PfmTransactionId.DEFAULT_INSTANCE);
        }
    }

    static {
        PfmStruct$PfmTransactionId pfmStruct$PfmTransactionId = new PfmStruct$PfmTransactionId();
        DEFAULT_INSTANCE = pfmStruct$PfmTransactionId;
        GeneratedMessageLite.registerDefaultInstance(PfmStruct$PfmTransactionId.class, pfmStruct$PfmTransactionId);
    }

    private PfmStruct$PfmTransactionId() {
    }

    private void clearAccountNumber() {
        this.accountNumber_ = 0L;
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearId() {
        this.id_ = 0L;
    }

    private void clearType() {
        this.type_ = 0;
    }

    public static PfmStruct$PfmTransactionId getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PfmStruct$PfmTransactionId parseDelimitedFrom(InputStream inputStream) {
        return (PfmStruct$PfmTransactionId) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmStruct$PfmTransactionId parseFrom(ByteBuffer byteBuffer) {
        return (PfmStruct$PfmTransactionId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAccountNumber(long j) {
        this.accountNumber_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDate(long j) {
        this.date_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setId(long j) {
        this.id_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setType(C75 c75) {
        this.type_ = c75.getNumber();
    }

    private void setTypeValue(int i) {
        this.type_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1851e1.a[gVar.ordinal()]) {
            case 1:
                return new PfmStruct$PfmTransactionId();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0002\u0002\u0002\u0003\u0002\u0004\f", new Object[]{"accountNumber_", "id_", "date_", "type_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PfmStruct$PfmTransactionId.class) {
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

    public long getAccountNumber() {
        return this.accountNumber_;
    }

    public long getDate() {
        return this.date_;
    }

    public long getId() {
        return this.id_;
    }

    public C75 getType() {
        C75 c75J = C75.j(this.type_);
        return c75J == null ? C75.UNRECOGNIZED : c75J;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public static a newBuilder(PfmStruct$PfmTransactionId pfmStruct$PfmTransactionId) {
        return (a) DEFAULT_INSTANCE.createBuilder(pfmStruct$PfmTransactionId);
    }

    public static PfmStruct$PfmTransactionId parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmStruct$PfmTransactionId) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmStruct$PfmTransactionId parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PfmStruct$PfmTransactionId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PfmStruct$PfmTransactionId parseFrom(AbstractC2383g abstractC2383g) {
        return (PfmStruct$PfmTransactionId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PfmStruct$PfmTransactionId parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PfmStruct$PfmTransactionId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PfmStruct$PfmTransactionId parseFrom(byte[] bArr) {
        return (PfmStruct$PfmTransactionId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PfmStruct$PfmTransactionId parseFrom(byte[] bArr, C2394s c2394s) {
        return (PfmStruct$PfmTransactionId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PfmStruct$PfmTransactionId parseFrom(InputStream inputStream) {
        return (PfmStruct$PfmTransactionId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmStruct$PfmTransactionId parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmStruct$PfmTransactionId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmStruct$PfmTransactionId parseFrom(AbstractC2384h abstractC2384h) {
        return (PfmStruct$PfmTransactionId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PfmStruct$PfmTransactionId parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PfmStruct$PfmTransactionId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
