package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC11867dh;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$ResponseGetDialogAdOrderDetails extends GeneratedMessageLite implements U64 {
    private static final AdvertisementOuterClass$ResponseGetDialogAdOrderDetails DEFAULT_INSTANCE;
    public static final int DIALOG_AD_ORDER_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private B.j dialogAdOrder_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$ResponseGetDialogAdOrderDetails.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$ResponseGetDialogAdOrderDetails advertisementOuterClass$ResponseGetDialogAdOrderDetails = new AdvertisementOuterClass$ResponseGetDialogAdOrderDetails();
        DEFAULT_INSTANCE = advertisementOuterClass$ResponseGetDialogAdOrderDetails;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$ResponseGetDialogAdOrderDetails.class, advertisementOuterClass$ResponseGetDialogAdOrderDetails);
    }

    private AdvertisementOuterClass$ResponseGetDialogAdOrderDetails() {
    }

    private void addAllDialogAdOrder(Iterable<? extends AdvertisementStruct$DialogAdOrder> iterable) {
        ensureDialogAdOrderIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.dialogAdOrder_);
    }

    private void addDialogAdOrder(AdvertisementStruct$DialogAdOrder advertisementStruct$DialogAdOrder) {
        advertisementStruct$DialogAdOrder.getClass();
        ensureDialogAdOrderIsMutable();
        this.dialogAdOrder_.add(advertisementStruct$DialogAdOrder);
    }

    private void clearDialogAdOrder() {
        this.dialogAdOrder_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureDialogAdOrderIsMutable() {
        B.j jVar = this.dialogAdOrder_;
        if (jVar.u()) {
            return;
        }
        this.dialogAdOrder_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static AdvertisementOuterClass$ResponseGetDialogAdOrderDetails getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$ResponseGetDialogAdOrderDetails parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetDialogAdOrderDetails) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetDialogAdOrderDetails parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$ResponseGetDialogAdOrderDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeDialogAdOrder(int i) {
        ensureDialogAdOrderIsMutable();
        this.dialogAdOrder_.remove(i);
    }

    private void setDialogAdOrder(int i, AdvertisementStruct$DialogAdOrder advertisementStruct$DialogAdOrder) {
        advertisementStruct$DialogAdOrder.getClass();
        ensureDialogAdOrderIsMutable();
        this.dialogAdOrder_.set(i, advertisementStruct$DialogAdOrder);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$ResponseGetDialogAdOrderDetails();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0001\u0000\u0002\u001b", new Object[]{"dialogAdOrder_", AdvertisementStruct$DialogAdOrder.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$ResponseGetDialogAdOrderDetails.class) {
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

    public AdvertisementStruct$DialogAdOrder getDialogAdOrder(int i) {
        return (AdvertisementStruct$DialogAdOrder) this.dialogAdOrder_.get(i);
    }

    public int getDialogAdOrderCount() {
        return this.dialogAdOrder_.size();
    }

    public List<AdvertisementStruct$DialogAdOrder> getDialogAdOrderList() {
        return this.dialogAdOrder_;
    }

    public InterfaceC11867dh getDialogAdOrderOrBuilder(int i) {
        return (InterfaceC11867dh) this.dialogAdOrder_.get(i);
    }

    public List<? extends InterfaceC11867dh> getDialogAdOrderOrBuilderList() {
        return this.dialogAdOrder_;
    }

    public static a newBuilder(AdvertisementOuterClass$ResponseGetDialogAdOrderDetails advertisementOuterClass$ResponseGetDialogAdOrderDetails) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$ResponseGetDialogAdOrderDetails);
    }

    public static AdvertisementOuterClass$ResponseGetDialogAdOrderDetails parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetDialogAdOrderDetails) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetDialogAdOrderDetails parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetDialogAdOrderDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetDialogAdOrderDetails parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$ResponseGetDialogAdOrderDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addDialogAdOrder(int i, AdvertisementStruct$DialogAdOrder advertisementStruct$DialogAdOrder) {
        advertisementStruct$DialogAdOrder.getClass();
        ensureDialogAdOrderIsMutable();
        this.dialogAdOrder_.add(i, advertisementStruct$DialogAdOrder);
    }

    public static AdvertisementOuterClass$ResponseGetDialogAdOrderDetails parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetDialogAdOrderDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetDialogAdOrderDetails parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$ResponseGetDialogAdOrderDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$ResponseGetDialogAdOrderDetails parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetDialogAdOrderDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetDialogAdOrderDetails parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetDialogAdOrderDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetDialogAdOrderDetails parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetDialogAdOrderDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetDialogAdOrderDetails parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$ResponseGetDialogAdOrderDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$ResponseGetDialogAdOrderDetails parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetDialogAdOrderDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
