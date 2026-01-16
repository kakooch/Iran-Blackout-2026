package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.BM7;
import ir.nasim.EnumC16902m35;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class UsersOuterClass$RequestImportContacts extends GeneratedMessageLite implements U64 {
    private static final UsersOuterClass$RequestImportContacts DEFAULT_INSTANCE;
    public static final int OPTIMIZATIONS_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int PHONES_FIELD_NUMBER = 1;
    private static final B.h.a optimizations_converter_ = new a();
    private int optimizationsMemoizedSerializedSize;
    private B.j phones_ = GeneratedMessageLite.emptyProtobufList();
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
            ((UsersOuterClass$RequestImportContacts) this.b).addAllOptimizations(iterable);
            return this;
        }

        public b B(UsersStruct$PhoneToImport usersStruct$PhoneToImport) {
            q();
            ((UsersOuterClass$RequestImportContacts) this.b).addPhones(usersStruct$PhoneToImport);
            return this;
        }

        private b() {
            super(UsersOuterClass$RequestImportContacts.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersOuterClass$RequestImportContacts usersOuterClass$RequestImportContacts = new UsersOuterClass$RequestImportContacts();
        DEFAULT_INSTANCE = usersOuterClass$RequestImportContacts;
        GeneratedMessageLite.registerDefaultInstance(UsersOuterClass$RequestImportContacts.class, usersOuterClass$RequestImportContacts);
    }

    private UsersOuterClass$RequestImportContacts() {
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

    private void addAllPhones(Iterable<? extends UsersStruct$PhoneToImport> iterable) {
        ensurePhonesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.phones_);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void addPhones(UsersStruct$PhoneToImport usersStruct$PhoneToImport) {
        usersStruct$PhoneToImport.getClass();
        ensurePhonesIsMutable();
        this.phones_.add(usersStruct$PhoneToImport);
    }

    private void clearOptimizations() {
        this.optimizations_ = GeneratedMessageLite.emptyIntList();
    }

    private void clearPhones() {
        this.phones_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureOptimizationsIsMutable() {
        B.g gVar = this.optimizations_;
        if (gVar.u()) {
            return;
        }
        this.optimizations_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    private void ensurePhonesIsMutable() {
        B.j jVar = this.phones_;
        if (jVar.u()) {
            return;
        }
        this.phones_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static UsersOuterClass$RequestImportContacts getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersOuterClass$RequestImportContacts parseDelimitedFrom(InputStream inputStream) {
        return (UsersOuterClass$RequestImportContacts) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$RequestImportContacts parseFrom(ByteBuffer byteBuffer) {
        return (UsersOuterClass$RequestImportContacts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removePhones(int i) {
        ensurePhonesIsMutable();
        this.phones_.remove(i);
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

    private void setPhones(int i, UsersStruct$PhoneToImport usersStruct$PhoneToImport) {
        usersStruct$PhoneToImport.getClass();
        ensurePhonesIsMutable();
        this.phones_.set(i, usersStruct$PhoneToImport);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (p2.a[gVar.ordinal()]) {
            case 1:
                return new UsersOuterClass$RequestImportContacts();
            case 2:
                return new b();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0002\u0000\u0001\u001b\u0003,", new Object[]{"phones_", UsersStruct$PhoneToImport.class, "optimizations_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersOuterClass$RequestImportContacts.class) {
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

    public UsersStruct$PhoneToImport getPhones(int i) {
        return (UsersStruct$PhoneToImport) this.phones_.get(i);
    }

    public int getPhonesCount() {
        return this.phones_.size();
    }

    public List<UsersStruct$PhoneToImport> getPhonesList() {
        return this.phones_;
    }

    public BM7 getPhonesOrBuilder(int i) {
        return (BM7) this.phones_.get(i);
    }

    public List<? extends BM7> getPhonesOrBuilderList() {
        return this.phones_;
    }

    public static b newBuilder(UsersOuterClass$RequestImportContacts usersOuterClass$RequestImportContacts) {
        return (b) DEFAULT_INSTANCE.createBuilder(usersOuterClass$RequestImportContacts);
    }

    public static UsersOuterClass$RequestImportContacts parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$RequestImportContacts) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$RequestImportContacts parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersOuterClass$RequestImportContacts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersOuterClass$RequestImportContacts parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersOuterClass$RequestImportContacts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addPhones(int i, UsersStruct$PhoneToImport usersStruct$PhoneToImport) {
        usersStruct$PhoneToImport.getClass();
        ensurePhonesIsMutable();
        this.phones_.add(i, usersStruct$PhoneToImport);
    }

    public static UsersOuterClass$RequestImportContacts parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersOuterClass$RequestImportContacts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersOuterClass$RequestImportContacts parseFrom(byte[] bArr) {
        return (UsersOuterClass$RequestImportContacts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersOuterClass$RequestImportContacts parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersOuterClass$RequestImportContacts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersOuterClass$RequestImportContacts parseFrom(InputStream inputStream) {
        return (UsersOuterClass$RequestImportContacts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$RequestImportContacts parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$RequestImportContacts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$RequestImportContacts parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersOuterClass$RequestImportContacts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersOuterClass$RequestImportContacts parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersOuterClass$RequestImportContacts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
