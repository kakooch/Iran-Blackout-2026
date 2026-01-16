package ai.bale.proto;

import ai.bale.proto.GarsonStruct$GarsonBot;
import ai.bale.proto.GarsonStruct$GarsonServiceItem;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GarsonStruct$GarsonItem extends GeneratedMessageLite implements InterfaceC1856g0 {
    public static final int BOT_FIELD_NUMBER = 2;
    private static final GarsonStruct$GarsonItem DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SERVICE_FIELD_NUMBER = 1;
    private int itemCase_ = 0;
    private Object item_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC1856g0 {
        private a() {
            super(GarsonStruct$GarsonItem.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        SERVICE(1),
        BOT(2),
        ITEM_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return ITEM_NOT_SET;
            }
            if (i == 1) {
                return SERVICE;
            }
            if (i != 2) {
                return null;
            }
            return BOT;
        }
    }

    static {
        GarsonStruct$GarsonItem garsonStruct$GarsonItem = new GarsonStruct$GarsonItem();
        DEFAULT_INSTANCE = garsonStruct$GarsonItem;
        GeneratedMessageLite.registerDefaultInstance(GarsonStruct$GarsonItem.class, garsonStruct$GarsonItem);
    }

    private GarsonStruct$GarsonItem() {
    }

    private void clearBot() {
        if (this.itemCase_ == 2) {
            this.itemCase_ = 0;
            this.item_ = null;
        }
    }

    private void clearItem() {
        this.itemCase_ = 0;
        this.item_ = null;
    }

    private void clearService() {
        if (this.itemCase_ == 1) {
            this.itemCase_ = 0;
            this.item_ = null;
        }
    }

    public static GarsonStruct$GarsonItem getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeBot(GarsonStruct$GarsonBot garsonStruct$GarsonBot) {
        garsonStruct$GarsonBot.getClass();
        if (this.itemCase_ != 2 || this.item_ == GarsonStruct$GarsonBot.getDefaultInstance()) {
            this.item_ = garsonStruct$GarsonBot;
        } else {
            this.item_ = ((GarsonStruct$GarsonBot.a) GarsonStruct$GarsonBot.newBuilder((GarsonStruct$GarsonBot) this.item_).v(garsonStruct$GarsonBot)).j();
        }
        this.itemCase_ = 2;
    }

    private void mergeService(GarsonStruct$GarsonServiceItem garsonStruct$GarsonServiceItem) {
        garsonStruct$GarsonServiceItem.getClass();
        if (this.itemCase_ != 1 || this.item_ == GarsonStruct$GarsonServiceItem.getDefaultInstance()) {
            this.item_ = garsonStruct$GarsonServiceItem;
        } else {
            this.item_ = ((GarsonStruct$GarsonServiceItem.a) GarsonStruct$GarsonServiceItem.newBuilder((GarsonStruct$GarsonServiceItem) this.item_).v(garsonStruct$GarsonServiceItem)).j();
        }
        this.itemCase_ = 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GarsonStruct$GarsonItem parseDelimitedFrom(InputStream inputStream) {
        return (GarsonStruct$GarsonItem) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonStruct$GarsonItem parseFrom(ByteBuffer byteBuffer) {
        return (GarsonStruct$GarsonItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBot(GarsonStruct$GarsonBot garsonStruct$GarsonBot) {
        garsonStruct$GarsonBot.getClass();
        this.item_ = garsonStruct$GarsonBot;
        this.itemCase_ = 2;
    }

    private void setService(GarsonStruct$GarsonServiceItem garsonStruct$GarsonServiceItem) {
        garsonStruct$GarsonServiceItem.getClass();
        this.item_ = garsonStruct$GarsonServiceItem;
        this.itemCase_ = 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1850e0.a[gVar.ordinal()]) {
            case 1:
                return new GarsonStruct$GarsonItem();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000", new Object[]{"item_", "itemCase_", GarsonStruct$GarsonServiceItem.class, GarsonStruct$GarsonBot.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GarsonStruct$GarsonItem.class) {
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

    public GarsonStruct$GarsonBot getBot() {
        return this.itemCase_ == 2 ? (GarsonStruct$GarsonBot) this.item_ : GarsonStruct$GarsonBot.getDefaultInstance();
    }

    public b getItemCase() {
        return b.j(this.itemCase_);
    }

    public GarsonStruct$GarsonServiceItem getService() {
        return this.itemCase_ == 1 ? (GarsonStruct$GarsonServiceItem) this.item_ : GarsonStruct$GarsonServiceItem.getDefaultInstance();
    }

    public boolean hasBot() {
        return this.itemCase_ == 2;
    }

    public boolean hasService() {
        return this.itemCase_ == 1;
    }

    public static a newBuilder(GarsonStruct$GarsonItem garsonStruct$GarsonItem) {
        return (a) DEFAULT_INSTANCE.createBuilder(garsonStruct$GarsonItem);
    }

    public static GarsonStruct$GarsonItem parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonStruct$GarsonItem) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonStruct$GarsonItem parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GarsonStruct$GarsonItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GarsonStruct$GarsonItem parseFrom(AbstractC2383g abstractC2383g) {
        return (GarsonStruct$GarsonItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GarsonStruct$GarsonItem parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GarsonStruct$GarsonItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GarsonStruct$GarsonItem parseFrom(byte[] bArr) {
        return (GarsonStruct$GarsonItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GarsonStruct$GarsonItem parseFrom(byte[] bArr, C2394s c2394s) {
        return (GarsonStruct$GarsonItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GarsonStruct$GarsonItem parseFrom(InputStream inputStream) {
        return (GarsonStruct$GarsonItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonStruct$GarsonItem parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonStruct$GarsonItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonStruct$GarsonItem parseFrom(AbstractC2384h abstractC2384h) {
        return (GarsonStruct$GarsonItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GarsonStruct$GarsonItem parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GarsonStruct$GarsonItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
