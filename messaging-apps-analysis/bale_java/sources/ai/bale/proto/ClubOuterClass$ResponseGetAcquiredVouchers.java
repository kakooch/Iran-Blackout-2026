package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC21349tW0;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class ClubOuterClass$ResponseGetAcquiredVouchers extends GeneratedMessageLite implements U64 {
    private static final ClubOuterClass$ResponseGetAcquiredVouchers DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int VOUCHERS_FIELD_NUMBER = 1;
    private B.j vouchers_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(ClubOuterClass$ResponseGetAcquiredVouchers.DEFAULT_INSTANCE);
        }
    }

    static {
        ClubOuterClass$ResponseGetAcquiredVouchers clubOuterClass$ResponseGetAcquiredVouchers = new ClubOuterClass$ResponseGetAcquiredVouchers();
        DEFAULT_INSTANCE = clubOuterClass$ResponseGetAcquiredVouchers;
        GeneratedMessageLite.registerDefaultInstance(ClubOuterClass$ResponseGetAcquiredVouchers.class, clubOuterClass$ResponseGetAcquiredVouchers);
    }

    private ClubOuterClass$ResponseGetAcquiredVouchers() {
    }

    private void addAllVouchers(Iterable<? extends ClubStruct$ClubVoucher> iterable) {
        ensureVouchersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.vouchers_);
    }

    private void addVouchers(ClubStruct$ClubVoucher clubStruct$ClubVoucher) {
        clubStruct$ClubVoucher.getClass();
        ensureVouchersIsMutable();
        this.vouchers_.add(clubStruct$ClubVoucher);
    }

    private void clearVouchers() {
        this.vouchers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureVouchersIsMutable() {
        B.j jVar = this.vouchers_;
        if (jVar.u()) {
            return;
        }
        this.vouchers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static ClubOuterClass$ResponseGetAcquiredVouchers getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ClubOuterClass$ResponseGetAcquiredVouchers parseDelimitedFrom(InputStream inputStream) {
        return (ClubOuterClass$ResponseGetAcquiredVouchers) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ClubOuterClass$ResponseGetAcquiredVouchers parseFrom(ByteBuffer byteBuffer) {
        return (ClubOuterClass$ResponseGetAcquiredVouchers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeVouchers(int i) {
        ensureVouchersIsMutable();
        this.vouchers_.remove(i);
    }

    private void setVouchers(int i, ClubStruct$ClubVoucher clubStruct$ClubVoucher) {
        clubStruct$ClubVoucher.getClass();
        ensureVouchersIsMutable();
        this.vouchers_.set(i, clubStruct$ClubVoucher);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (B.a[gVar.ordinal()]) {
            case 1:
                return new ClubOuterClass$ResponseGetAcquiredVouchers();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"vouchers_", ClubStruct$ClubVoucher.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ClubOuterClass$ResponseGetAcquiredVouchers.class) {
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

    public ClubStruct$ClubVoucher getVouchers(int i) {
        return (ClubStruct$ClubVoucher) this.vouchers_.get(i);
    }

    public int getVouchersCount() {
        return this.vouchers_.size();
    }

    public List<ClubStruct$ClubVoucher> getVouchersList() {
        return this.vouchers_;
    }

    public InterfaceC21349tW0 getVouchersOrBuilder(int i) {
        return (InterfaceC21349tW0) this.vouchers_.get(i);
    }

    public List<? extends InterfaceC21349tW0> getVouchersOrBuilderList() {
        return this.vouchers_;
    }

    public static a newBuilder(ClubOuterClass$ResponseGetAcquiredVouchers clubOuterClass$ResponseGetAcquiredVouchers) {
        return (a) DEFAULT_INSTANCE.createBuilder(clubOuterClass$ResponseGetAcquiredVouchers);
    }

    public static ClubOuterClass$ResponseGetAcquiredVouchers parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ClubOuterClass$ResponseGetAcquiredVouchers) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ClubOuterClass$ResponseGetAcquiredVouchers parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ClubOuterClass$ResponseGetAcquiredVouchers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ClubOuterClass$ResponseGetAcquiredVouchers parseFrom(AbstractC2383g abstractC2383g) {
        return (ClubOuterClass$ResponseGetAcquiredVouchers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addVouchers(int i, ClubStruct$ClubVoucher clubStruct$ClubVoucher) {
        clubStruct$ClubVoucher.getClass();
        ensureVouchersIsMutable();
        this.vouchers_.add(i, clubStruct$ClubVoucher);
    }

    public static ClubOuterClass$ResponseGetAcquiredVouchers parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ClubOuterClass$ResponseGetAcquiredVouchers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ClubOuterClass$ResponseGetAcquiredVouchers parseFrom(byte[] bArr) {
        return (ClubOuterClass$ResponseGetAcquiredVouchers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ClubOuterClass$ResponseGetAcquiredVouchers parseFrom(byte[] bArr, C2394s c2394s) {
        return (ClubOuterClass$ResponseGetAcquiredVouchers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ClubOuterClass$ResponseGetAcquiredVouchers parseFrom(InputStream inputStream) {
        return (ClubOuterClass$ResponseGetAcquiredVouchers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ClubOuterClass$ResponseGetAcquiredVouchers parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ClubOuterClass$ResponseGetAcquiredVouchers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ClubOuterClass$ResponseGetAcquiredVouchers parseFrom(AbstractC2384h abstractC2384h) {
        return (ClubOuterClass$ResponseGetAcquiredVouchers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ClubOuterClass$ResponseGetAcquiredVouchers parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ClubOuterClass$ResponseGetAcquiredVouchers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
