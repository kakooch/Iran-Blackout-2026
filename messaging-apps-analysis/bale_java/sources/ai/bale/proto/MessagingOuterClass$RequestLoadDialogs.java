package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC10088b35;
import ir.nasim.EnumC16902m35;
import ir.nasim.EnumC5834La4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes9.dex */
public final class MessagingOuterClass$RequestLoadDialogs extends GeneratedMessageLite implements U64 {
    public static final int ARCHIVE_FILTER_FIELD_NUMBER = 6;
    private static final MessagingOuterClass$RequestLoadDialogs DEFAULT_INSTANCE;
    public static final int DIALOG_TYPE_FIELD_NUMBER = 4;
    public static final int EXCLUDE_PINNED_DIALOGS_FIELD_NUMBER = 5;
    public static final int LIMIT_FIELD_NUMBER = 2;
    public static final int MIN_DATE_FIELD_NUMBER = 1;
    public static final int OPTIMIZATIONS_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER;
    private static final B.h.a optimizations_converter_ = new a();
    private int archiveFilter_;
    private int dialogType_;
    private boolean excludePinnedDialogs_;
    private int limit_;
    private long minDate_;
    private int optimizationsMemoizedSerializedSize;
    private B.g optimizations_ = GeneratedMessageLite.emptyIntList();

    class a implements B.h.a {
        a() {
        }

        @Override // com.google.protobuf.B.h.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC16902m35 a(Integer num) {
            EnumC16902m35 enumC16902m35J = EnumC16902m35.j(num.intValue());
            return enumC16902m35J == null ? EnumC16902m35.UNRECOGNIZED : enumC16902m35J;
        }
    }

    public static final class b extends GeneratedMessageLite.b implements U64 {
        public b A(Iterable iterable) {
            q();
            ((MessagingOuterClass$RequestLoadDialogs) this.b).addAllOptimizations(iterable);
            return this;
        }

        public b B(EnumC10088b35 enumC10088b35) {
            q();
            ((MessagingOuterClass$RequestLoadDialogs) this.b).setDialogType(enumC10088b35);
            return this;
        }

        public b C(boolean z) {
            q();
            ((MessagingOuterClass$RequestLoadDialogs) this.b).setExcludePinnedDialogs(z);
            return this;
        }

        public b D(int i) {
            q();
            ((MessagingOuterClass$RequestLoadDialogs) this.b).setLimit(i);
            return this;
        }

        public b E(long j) {
            q();
            ((MessagingOuterClass$RequestLoadDialogs) this.b).setMinDate(j);
            return this;
        }

        private b() {
            super(MessagingOuterClass$RequestLoadDialogs.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$RequestLoadDialogs messagingOuterClass$RequestLoadDialogs = new MessagingOuterClass$RequestLoadDialogs();
        DEFAULT_INSTANCE = messagingOuterClass$RequestLoadDialogs;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$RequestLoadDialogs.class, messagingOuterClass$RequestLoadDialogs);
    }

    private MessagingOuterClass$RequestLoadDialogs() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllOptimizations(Iterable<? extends EnumC16902m35> iterable) {
        ensureOptimizationsIsMutable();
        Iterator<? extends EnumC16902m35> it = iterable.iterator();
        while (it.hasNext()) {
            this.optimizations_.b1(it.next().getNumber());
        }
    }

    private void addAllOptimizationsValue(Iterable<Integer> iterable) {
        ensureOptimizationsIsMutable();
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            this.optimizations_.b1(it.next().intValue());
        }
    }

    private void addOptimizations(EnumC16902m35 enumC16902m35) {
        enumC16902m35.getClass();
        ensureOptimizationsIsMutable();
        this.optimizations_.b1(enumC16902m35.getNumber());
    }

    private void addOptimizationsValue(int i) {
        ensureOptimizationsIsMutable();
        this.optimizations_.b1(i);
    }

    private void clearArchiveFilter() {
        this.archiveFilter_ = 0;
    }

    private void clearDialogType() {
        this.dialogType_ = 0;
    }

    private void clearExcludePinnedDialogs() {
        this.excludePinnedDialogs_ = false;
    }

    private void clearLimit() {
        this.limit_ = 0;
    }

    private void clearMinDate() {
        this.minDate_ = 0L;
    }

    private void clearOptimizations() {
        this.optimizations_ = GeneratedMessageLite.emptyIntList();
    }

    private void ensureOptimizationsIsMutable() {
        B.g gVar = this.optimizations_;
        if (gVar.u()) {
            return;
        }
        this.optimizations_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static MessagingOuterClass$RequestLoadDialogs getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingOuterClass$RequestLoadDialogs parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$RequestLoadDialogs) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$RequestLoadDialogs parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$RequestLoadDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setArchiveFilter(EnumC5834La4 enumC5834La4) {
        this.archiveFilter_ = enumC5834La4.getNumber();
    }

    private void setArchiveFilterValue(int i) {
        this.archiveFilter_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDialogType(EnumC10088b35 enumC10088b35) {
        this.dialogType_ = enumC10088b35.getNumber();
    }

    private void setDialogTypeValue(int i) {
        this.dialogType_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExcludePinnedDialogs(boolean z) {
        this.excludePinnedDialogs_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLimit(int i) {
        this.limit_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMinDate(long j) {
        this.minDate_ = j;
    }

    private void setOptimizations(int i, EnumC16902m35 enumC16902m35) {
        enumC16902m35.getClass();
        ensureOptimizationsIsMutable();
        this.optimizations_.U(i, enumC16902m35.getNumber());
    }

    private void setOptimizationsValue(int i, int i2) {
        ensureOptimizationsIsMutable();
        this.optimizations_.U(i, i2);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingOuterClass$RequestLoadDialogs();
            case 2:
                return new b();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0001\u0000\u0001\u0002\u0002\u0004\u0003,\u0004\f\u0005\u0007\u0006\f", new Object[]{"minDate_", "limit_", "optimizations_", "dialogType_", "excludePinnedDialogs_", "archiveFilter_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$RequestLoadDialogs.class) {
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

    public EnumC5834La4 getArchiveFilter() {
        EnumC5834La4 enumC5834La4J = EnumC5834La4.j(this.archiveFilter_);
        return enumC5834La4J == null ? EnumC5834La4.UNRECOGNIZED : enumC5834La4J;
    }

    public int getArchiveFilterValue() {
        return this.archiveFilter_;
    }

    public EnumC10088b35 getDialogType() {
        EnumC10088b35 enumC10088b35J = EnumC10088b35.j(this.dialogType_);
        return enumC10088b35J == null ? EnumC10088b35.UNRECOGNIZED : enumC10088b35J;
    }

    public int getDialogTypeValue() {
        return this.dialogType_;
    }

    public boolean getExcludePinnedDialogs() {
        return this.excludePinnedDialogs_;
    }

    public int getLimit() {
        return this.limit_;
    }

    public long getMinDate() {
        return this.minDate_;
    }

    public EnumC16902m35 getOptimizations(int i) {
        EnumC16902m35 enumC16902m35J = EnumC16902m35.j(this.optimizations_.getInt(i));
        return enumC16902m35J == null ? EnumC16902m35.UNRECOGNIZED : enumC16902m35J;
    }

    public int getOptimizationsCount() {
        return this.optimizations_.size();
    }

    public List<EnumC16902m35> getOptimizationsList() {
        return new B.h(this.optimizations_, optimizations_converter_);
    }

    public int getOptimizationsValue(int i) {
        return this.optimizations_.getInt(i);
    }

    public List<Integer> getOptimizationsValueList() {
        return this.optimizations_;
    }

    public static b newBuilder(MessagingOuterClass$RequestLoadDialogs messagingOuterClass$RequestLoadDialogs) {
        return (b) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$RequestLoadDialogs);
    }

    public static MessagingOuterClass$RequestLoadDialogs parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadDialogs) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$RequestLoadDialogs parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$RequestLoadDialogs parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$RequestLoadDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingOuterClass$RequestLoadDialogs parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$RequestLoadDialogs parseFrom(byte[] bArr) {
        return (MessagingOuterClass$RequestLoadDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$RequestLoadDialogs parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$RequestLoadDialogs parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$RequestLoadDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$RequestLoadDialogs parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$RequestLoadDialogs parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$RequestLoadDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$RequestLoadDialogs parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
