package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import ir.nasim.XK0;
import ir.nasim.ZK0;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class Charnet$RequestGetInternetBundleList extends GeneratedMessageLite implements U64 {
    private static final Charnet$RequestGetInternetBundleList DEFAULT_INSTANCE;
    public static final int OPERATOR_TYPE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int SIM_CARD_TYPE_FIELD_NUMBER = 2;
    private int operatorType_;
    private int simCardType_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Charnet$RequestGetInternetBundleList.DEFAULT_INSTANCE);
        }
    }

    static {
        Charnet$RequestGetInternetBundleList charnet$RequestGetInternetBundleList = new Charnet$RequestGetInternetBundleList();
        DEFAULT_INSTANCE = charnet$RequestGetInternetBundleList;
        GeneratedMessageLite.registerDefaultInstance(Charnet$RequestGetInternetBundleList.class, charnet$RequestGetInternetBundleList);
    }

    private Charnet$RequestGetInternetBundleList() {
    }

    private void clearOperatorType() {
        this.operatorType_ = 0;
    }

    private void clearSimCardType() {
        this.simCardType_ = 0;
    }

    public static Charnet$RequestGetInternetBundleList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Charnet$RequestGetInternetBundleList parseDelimitedFrom(InputStream inputStream) {
        return (Charnet$RequestGetInternetBundleList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Charnet$RequestGetInternetBundleList parseFrom(ByteBuffer byteBuffer) {
        return (Charnet$RequestGetInternetBundleList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setOperatorType(XK0 xk0) {
        this.operatorType_ = xk0.getNumber();
    }

    private void setOperatorTypeValue(int i) {
        this.operatorType_ = i;
    }

    private void setSimCardType(ZK0 zk0) {
        this.simCardType_ = zk0.getNumber();
    }

    private void setSimCardTypeValue(int i) {
        this.simCardType_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1911z.a[gVar.ordinal()]) {
            case 1:
                return new Charnet$RequestGetInternetBundleList();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\f", new Object[]{"operatorType_", "simCardType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Charnet$RequestGetInternetBundleList.class) {
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

    public XK0 getOperatorType() {
        XK0 xk0J = XK0.j(this.operatorType_);
        return xk0J == null ? XK0.UNRECOGNIZED : xk0J;
    }

    public int getOperatorTypeValue() {
        return this.operatorType_;
    }

    public ZK0 getSimCardType() {
        ZK0 zk0J = ZK0.j(this.simCardType_);
        return zk0J == null ? ZK0.UNRECOGNIZED : zk0J;
    }

    public int getSimCardTypeValue() {
        return this.simCardType_;
    }

    public static a newBuilder(Charnet$RequestGetInternetBundleList charnet$RequestGetInternetBundleList) {
        return (a) DEFAULT_INSTANCE.createBuilder(charnet$RequestGetInternetBundleList);
    }

    public static Charnet$RequestGetInternetBundleList parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Charnet$RequestGetInternetBundleList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Charnet$RequestGetInternetBundleList parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Charnet$RequestGetInternetBundleList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Charnet$RequestGetInternetBundleList parseFrom(AbstractC2383g abstractC2383g) {
        return (Charnet$RequestGetInternetBundleList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Charnet$RequestGetInternetBundleList parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Charnet$RequestGetInternetBundleList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Charnet$RequestGetInternetBundleList parseFrom(byte[] bArr) {
        return (Charnet$RequestGetInternetBundleList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Charnet$RequestGetInternetBundleList parseFrom(byte[] bArr, C2394s c2394s) {
        return (Charnet$RequestGetInternetBundleList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Charnet$RequestGetInternetBundleList parseFrom(InputStream inputStream) {
        return (Charnet$RequestGetInternetBundleList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Charnet$RequestGetInternetBundleList parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Charnet$RequestGetInternetBundleList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Charnet$RequestGetInternetBundleList parseFrom(AbstractC2384h abstractC2384h) {
        return (Charnet$RequestGetInternetBundleList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Charnet$RequestGetInternetBundleList parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Charnet$RequestGetInternetBundleList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
