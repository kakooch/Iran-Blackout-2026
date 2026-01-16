package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC16902m35;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class UsersOuterClass$RequestGetContacts extends GeneratedMessageLite implements U64 {
    public static final int CONTACTS_HASH_FIELD_NUMBER = 1;
    private static final UsersOuterClass$RequestGetContacts DEFAULT_INSTANCE;
    public static final int OPTIMIZATIONS_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private static final B.h.a optimizations_converter_ = new a();
    private int optimizationsMemoizedSerializedSize;
    private String contactsHash_ = "";
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
            ((UsersOuterClass$RequestGetContacts) this.b).addAllOptimizations(iterable);
            return this;
        }

        public b B(String str) {
            q();
            ((UsersOuterClass$RequestGetContacts) this.b).setContactsHash(str);
            return this;
        }

        private b() {
            super(UsersOuterClass$RequestGetContacts.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersOuterClass$RequestGetContacts usersOuterClass$RequestGetContacts = new UsersOuterClass$RequestGetContacts();
        DEFAULT_INSTANCE = usersOuterClass$RequestGetContacts;
        GeneratedMessageLite.registerDefaultInstance(UsersOuterClass$RequestGetContacts.class, usersOuterClass$RequestGetContacts);
    }

    private UsersOuterClass$RequestGetContacts() {
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

    private void clearContactsHash() {
        this.contactsHash_ = getDefaultInstance().getContactsHash();
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

    public static UsersOuterClass$RequestGetContacts getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersOuterClass$RequestGetContacts parseDelimitedFrom(InputStream inputStream) {
        return (UsersOuterClass$RequestGetContacts) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$RequestGetContacts parseFrom(ByteBuffer byteBuffer) {
        return (UsersOuterClass$RequestGetContacts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setContactsHash(String str) {
        str.getClass();
        this.contactsHash_ = str;
    }

    private void setContactsHashBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.contactsHash_ = abstractC2383g.f0();
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
        switch (p2.a[gVar.ordinal()]) {
            case 1:
                return new UsersOuterClass$RequestGetContacts();
            case 2:
                return new b();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002,", new Object[]{"contactsHash_", "optimizations_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersOuterClass$RequestGetContacts.class) {
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

    public String getContactsHash() {
        return this.contactsHash_;
    }

    public AbstractC2383g getContactsHashBytes() {
        return AbstractC2383g.N(this.contactsHash_);
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

    public static b newBuilder(UsersOuterClass$RequestGetContacts usersOuterClass$RequestGetContacts) {
        return (b) DEFAULT_INSTANCE.createBuilder(usersOuterClass$RequestGetContacts);
    }

    public static UsersOuterClass$RequestGetContacts parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$RequestGetContacts) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$RequestGetContacts parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersOuterClass$RequestGetContacts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersOuterClass$RequestGetContacts parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersOuterClass$RequestGetContacts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UsersOuterClass$RequestGetContacts parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersOuterClass$RequestGetContacts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersOuterClass$RequestGetContacts parseFrom(byte[] bArr) {
        return (UsersOuterClass$RequestGetContacts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersOuterClass$RequestGetContacts parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersOuterClass$RequestGetContacts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersOuterClass$RequestGetContacts parseFrom(InputStream inputStream) {
        return (UsersOuterClass$RequestGetContacts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$RequestGetContacts parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$RequestGetContacts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$RequestGetContacts parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersOuterClass$RequestGetContacts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersOuterClass$RequestGetContacts parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersOuterClass$RequestGetContacts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
