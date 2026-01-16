package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC11822dc4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class SharedMedia$ResponseGetActiveSharedMedia extends GeneratedMessageLite implements U64 {
    public static final int ACTIVE_TAB_FIELD_NUMBER = 1;
    private static final SharedMedia$ResponseGetActiveSharedMedia DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private static final B.h.a activeTab_converter_ = new a();
    private int activeTabMemoizedSerializedSize;
    private B.g activeTab_ = GeneratedMessageLite.emptyIntList();

    class a implements B.h.a {
        a() {
        }

        @Override // com.google.protobuf.B.h.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC11822dc4 a(Integer num) {
            EnumC11822dc4 enumC11822dc4J = EnumC11822dc4.j(num.intValue());
            return enumC11822dc4J == null ? EnumC11822dc4.UNRECOGNIZED : enumC11822dc4J;
        }
    }

    public static final class b extends GeneratedMessageLite.b implements U64 {
        private b() {
            super(SharedMedia$ResponseGetActiveSharedMedia.DEFAULT_INSTANCE);
        }
    }

    static {
        SharedMedia$ResponseGetActiveSharedMedia sharedMedia$ResponseGetActiveSharedMedia = new SharedMedia$ResponseGetActiveSharedMedia();
        DEFAULT_INSTANCE = sharedMedia$ResponseGetActiveSharedMedia;
        GeneratedMessageLite.registerDefaultInstance(SharedMedia$ResponseGetActiveSharedMedia.class, sharedMedia$ResponseGetActiveSharedMedia);
    }

    private SharedMedia$ResponseGetActiveSharedMedia() {
    }

    private void addActiveTab(EnumC11822dc4 enumC11822dc4) {
        enumC11822dc4.getClass();
        ensureActiveTabIsMutable();
        this.activeTab_.b1(enumC11822dc4.getNumber());
    }

    private void addActiveTabValue(int i) {
        ensureActiveTabIsMutable();
        this.activeTab_.b1(i);
    }

    private void addAllActiveTab(Iterable<? extends EnumC11822dc4> iterable) {
        ensureActiveTabIsMutable();
        Iterator<? extends EnumC11822dc4> it = iterable.iterator();
        while (it.hasNext()) {
            this.activeTab_.b1(it.next().getNumber());
        }
    }

    private void addAllActiveTabValue(Iterable<Integer> iterable) {
        ensureActiveTabIsMutable();
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            this.activeTab_.b1(it.next().intValue());
        }
    }

    private void clearActiveTab() {
        this.activeTab_ = GeneratedMessageLite.emptyIntList();
    }

    private void ensureActiveTabIsMutable() {
        B.g gVar = this.activeTab_;
        if (gVar.u()) {
            return;
        }
        this.activeTab_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static SharedMedia$ResponseGetActiveSharedMedia getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static SharedMedia$ResponseGetActiveSharedMedia parseDelimitedFrom(InputStream inputStream) {
        return (SharedMedia$ResponseGetActiveSharedMedia) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SharedMedia$ResponseGetActiveSharedMedia parseFrom(ByteBuffer byteBuffer) {
        return (SharedMedia$ResponseGetActiveSharedMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setActiveTab(int i, EnumC11822dc4 enumC11822dc4) {
        enumC11822dc4.getClass();
        ensureActiveTabIsMutable();
        this.activeTab_.U(i, enumC11822dc4.getNumber());
    }

    private void setActiveTabValue(int i, int i2) {
        ensureActiveTabIsMutable();
        this.activeTab_.U(i, i2);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (Z1.a[gVar.ordinal()]) {
            case 1:
                return new SharedMedia$ResponseGetActiveSharedMedia();
            case 2:
                return new b();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001,", new Object[]{"activeTab_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SharedMedia$ResponseGetActiveSharedMedia.class) {
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

    public EnumC11822dc4 getActiveTab(int i) {
        EnumC11822dc4 enumC11822dc4J = EnumC11822dc4.j(this.activeTab_.getInt(i));
        return enumC11822dc4J == null ? EnumC11822dc4.UNRECOGNIZED : enumC11822dc4J;
    }

    public int getActiveTabCount() {
        return this.activeTab_.size();
    }

    public List<EnumC11822dc4> getActiveTabList() {
        return new B.h(this.activeTab_, activeTab_converter_);
    }

    public int getActiveTabValue(int i) {
        return this.activeTab_.getInt(i);
    }

    public List<Integer> getActiveTabValueList() {
        return this.activeTab_;
    }

    public static b newBuilder(SharedMedia$ResponseGetActiveSharedMedia sharedMedia$ResponseGetActiveSharedMedia) {
        return (b) DEFAULT_INSTANCE.createBuilder(sharedMedia$ResponseGetActiveSharedMedia);
    }

    public static SharedMedia$ResponseGetActiveSharedMedia parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SharedMedia$ResponseGetActiveSharedMedia) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SharedMedia$ResponseGetActiveSharedMedia parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SharedMedia$ResponseGetActiveSharedMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SharedMedia$ResponseGetActiveSharedMedia parseFrom(AbstractC2383g abstractC2383g) {
        return (SharedMedia$ResponseGetActiveSharedMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SharedMedia$ResponseGetActiveSharedMedia parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SharedMedia$ResponseGetActiveSharedMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SharedMedia$ResponseGetActiveSharedMedia parseFrom(byte[] bArr) {
        return (SharedMedia$ResponseGetActiveSharedMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SharedMedia$ResponseGetActiveSharedMedia parseFrom(byte[] bArr, C2394s c2394s) {
        return (SharedMedia$ResponseGetActiveSharedMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SharedMedia$ResponseGetActiveSharedMedia parseFrom(InputStream inputStream) {
        return (SharedMedia$ResponseGetActiveSharedMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SharedMedia$ResponseGetActiveSharedMedia parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SharedMedia$ResponseGetActiveSharedMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SharedMedia$ResponseGetActiveSharedMedia parseFrom(AbstractC2384h abstractC2384h) {
        return (SharedMedia$ResponseGetActiveSharedMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SharedMedia$ResponseGetActiveSharedMedia parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SharedMedia$ResponseGetActiveSharedMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
