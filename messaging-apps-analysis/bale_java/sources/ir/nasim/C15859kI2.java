package ir.nasim;

import ai.bale.proto.CollectionsStruct$StringValue;
import ai.bale.proto.FilesStruct$FileLocation;
import ai.bale.proto.ImagesOuterClass$RequestAddGif;
import ai.bale.proto.ImagesOuterClass$RequestGetSavedGifs;
import ai.bale.proto.ImagesOuterClass$RequestUseGif;
import ai.bale.proto.ImagesOuterClass$ResponseGetSavedGifs;
import ai.bale.proto.Misc$ResponseSeq;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;

/* renamed from: ir.nasim.kI2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15859kI2 {
    public static final a b = new a(null);
    public static final int c = 8;
    private final C6287Mz a;

    /* renamed from: ir.nasim.kI2$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C15859kI2(C6287Mz c6287Mz) {
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        this.a = c6287Mz;
    }

    public final Object a(long j, long j2, int i, String str, byte[] bArr, InterfaceC20295rm1 interfaceC20295rm1) {
        GeneratedMessageLite generatedMessageLiteA = ImagesOuterClass$RequestAddGif.newBuilder().A((FilesStruct$FileLocation) FilesStruct$FileLocation.newBuilder().B(j).A(j2).C(Int32Value.of(i)).a()).B((CollectionsStruct$StringValue) CollectionsStruct$StringValue.newBuilder().A(str).a()).C(AbstractC2383g.F(bArr)).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseSeq defaultInstance = Misc$ResponseSeq.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        return InterfaceC16847ly.c(this.a, new C22871vx5("/bale.v1.Images/AddGif", generatedMessageLiteA, defaultInstance), 16500L, null, interfaceC20295rm1, 4, null);
    }

    public final Object b(String str, InterfaceC20295rm1 interfaceC20295rm1) {
        ImagesOuterClass$RequestGetSavedGifs.a aVarNewBuilder = ImagesOuterClass$RequestGetSavedGifs.newBuilder();
        if (str != null) {
            aVarNewBuilder.A((CollectionsStruct$StringValue) CollectionsStruct$StringValue.newBuilder().A(str).a());
        }
        GeneratedMessageLite generatedMessageLiteA = aVarNewBuilder.a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        ImagesOuterClass$ResponseGetSavedGifs defaultInstance = ImagesOuterClass$ResponseGetSavedGifs.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        return InterfaceC16847ly.c(this.a, new C22871vx5("/bale.v1.Images/GetSavedGifs", generatedMessageLiteA, defaultInstance), 16500L, null, interfaceC20295rm1, 4, null);
    }

    public final Object c(long j, long j2, int i, InterfaceC20295rm1 interfaceC20295rm1) {
        GeneratedMessageLite generatedMessageLiteA = ImagesOuterClass$RequestAddGif.newBuilder().A((FilesStruct$FileLocation) FilesStruct$FileLocation.newBuilder().B(j).A(j2).C(Int32Value.of(i)).a()).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseSeq defaultInstance = Misc$ResponseSeq.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        return InterfaceC16847ly.c(this.a, new C22871vx5("/bale.v1.Images/RemoveGif", generatedMessageLiteA, defaultInstance), 16500L, null, interfaceC20295rm1, 4, null);
    }

    public final Object d(long j, long j2, int i, long j3, InterfaceC20295rm1 interfaceC20295rm1) {
        GeneratedMessageLite generatedMessageLiteA = ImagesOuterClass$RequestUseGif.newBuilder().A((FilesStruct$FileLocation) FilesStruct$FileLocation.newBuilder().B(j).A(j2).C(Int32Value.of(i)).a()).B(j3).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseSeq defaultInstance = Misc$ResponseSeq.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        return InterfaceC16847ly.c(this.a, new C22871vx5("/bale.v1.Images/UseGif", generatedMessageLiteA, defaultInstance), 16500L, null, interfaceC20295rm1, 4, null);
    }
}
