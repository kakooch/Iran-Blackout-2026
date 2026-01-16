package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ai.bale.proto.SetUpdatesStruct$ComposedUpdates;
import ir.nasim.InterfaceC5446Jj3;
import java.nio.ByteBuffer;
import java.util.List;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

/* renamed from: ir.nasim.uV, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C21996uV extends D0 {
    private static final /* synthetic */ InterfaceC5446Jj3.a A = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a A0 = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a B = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a B0 = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a C0 = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a D = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a D0 = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a E0 = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a G = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a H = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a J = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a Y = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a Z = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a k = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a l = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a m = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a n = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a o = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a p = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a q = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a r = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a s = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a t = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a u = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a v = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a w = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a x = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a y = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a z = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a z0 = null;
    public C22586vV j;

    static {
        n();
    }

    public C21996uV() {
        super("avcC");
        this.j = new C22586vV();
    }

    private static /* synthetic */ void n() {
        C20224rf2 c20224rf2 = new C20224rf2("AvcConfigurationBox.java", C21996uV.class);
        k = c20224rf2.f("method-execution", c20224rf2.e("1", "getConfigurationVersion", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 44);
        l = c20224rf2.f("method-execution", c20224rf2.e("1", "getAvcProfileIndication", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 48);
        u = c20224rf2.f("method-execution", c20224rf2.e("1", "setAvcLevelIndication", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "avcLevelIndication", "", "void"), 84);
        v = c20224rf2.f("method-execution", c20224rf2.e("1", "setLengthSizeMinusOne", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "lengthSizeMinusOne", "", "void"), 88);
        w = c20224rf2.f("method-execution", c20224rf2.e("1", "setSequenceParameterSets", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "java.util.List", "sequenceParameterSets", "", "void"), 92);
        x = c20224rf2.f("method-execution", c20224rf2.e("1", "setPictureParameterSets", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "java.util.List", "pictureParameterSets", "", "void"), 96);
        y = c20224rf2.f("method-execution", c20224rf2.e("1", "getChromaFormat", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 100);
        z = c20224rf2.f("method-execution", c20224rf2.e("1", "setChromaFormat", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "chromaFormat", "", "void"), 104);
        A = c20224rf2.f("method-execution", c20224rf2.e("1", "getBitDepthLumaMinus8", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), Type.EUI48);
        B = c20224rf2.f("method-execution", c20224rf2.e("1", "setBitDepthLumaMinus8", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "bitDepthLumaMinus8", "", "void"), SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER);
        D = c20224rf2.f("method-execution", c20224rf2.e("1", "getBitDepthChromaMinus8", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 116);
        G = c20224rf2.f("method-execution", c20224rf2.e("1", "setBitDepthChromaMinus8", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "bitDepthChromaMinus8", "", "void"), SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
        m = c20224rf2.f("method-execution", c20224rf2.e("1", "getProfileCompatibility", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 52);
        H = c20224rf2.f("method-execution", c20224rf2.e("1", "getSequenceParameterSetExts", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "java.util.List"), 124);
        J = c20224rf2.f("method-execution", c20224rf2.e("1", "setSequenceParameterSetExts", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "java.util.List", "sequenceParameterSetExts", "", "void"), 128);
        Y = c20224rf2.f("method-execution", c20224rf2.e("1", "hasExts", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "boolean"), WKSRecord.Service.CISCO_SYS);
        Z = c20224rf2.f("method-execution", c20224rf2.e("1", "setHasExts", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "boolean", "hasExts", "", "void"), 136);
        z0 = c20224rf2.f("method-execution", c20224rf2.e("1", "getContentSize", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "long"), 147);
        A0 = c20224rf2.f("method-execution", c20224rf2.e("1", "getContent", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "java.nio.ByteBuffer", "byteBuffer", "", "void"), SetRpcStruct$ComposedRpc.GET_GROUP_STATE_FIELD_NUMBER);
        B0 = c20224rf2.f("method-execution", c20224rf2.e("1", "getSPS", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "[Ljava.lang.String;"), 158);
        C0 = c20224rf2.f("method-execution", c20224rf2.e("1", "getPPS", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "[Ljava.lang.String;"), SetUpdatesStruct$ComposedUpdates.MESSAGE_CONTENT_CHANGED_FIELD_NUMBER);
        D0 = c20224rf2.f("method-execution", c20224rf2.e("1", "getavcDecoderConfigurationRecord", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "com.mp4parser.iso14496.part15.AvcDecoderConfigurationRecord"), 167);
        E0 = c20224rf2.f("method-execution", c20224rf2.e("1", "toString", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "java.lang.String"), 172);
        n = c20224rf2.f("method-execution", c20224rf2.e("1", "getAvcLevelIndication", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 56);
        o = c20224rf2.f("method-execution", c20224rf2.e("1", "getLengthSizeMinusOne", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 60);
        p = c20224rf2.f("method-execution", c20224rf2.e("1", "getSequenceParameterSets", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "java.util.List"), 64);
        q = c20224rf2.f("method-execution", c20224rf2.e("1", "getPictureParameterSets", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "java.util.List"), 68);
        r = c20224rf2.f("method-execution", c20224rf2.e("1", "setConfigurationVersion", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "configurationVersion", "", "void"), 72);
        s = c20224rf2.f("method-execution", c20224rf2.e("1", "setAvcProfileIndication", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "avcProfileIndication", "", "void"), 76);
        t = c20224rf2.f("method-execution", c20224rf2.e("1", "setProfileCompatibility", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "profileCompatibility", "", "void"), 80);
    }

    @Override // ir.nasim.D0
    public void a(ByteBuffer byteBuffer) {
        this.j = new C22586vV(byteBuffer);
    }

    @Override // ir.nasim.D0
    public void b(ByteBuffer byteBuffer) {
        C18943pW5.b().c(C20224rf2.d(A0, this, this, byteBuffer));
        this.j.a(byteBuffer);
    }

    @Override // ir.nasim.D0
    public long c() {
        C18943pW5.b().c(C20224rf2.c(z0, this, this));
        return this.j.b();
    }

    public void o(int i) {
        C18943pW5.b().c(C20224rf2.d(u, this, this, AbstractC5480Jn1.d(i)));
        this.j.d = i;
    }

    public void p(int i) {
        C18943pW5.b().c(C20224rf2.d(s, this, this, AbstractC5480Jn1.d(i)));
        this.j.b = i;
    }

    public void q(int i) {
        C18943pW5.b().c(C20224rf2.d(G, this, this, AbstractC5480Jn1.d(i)));
        this.j.k = i;
    }

    public void r(int i) {
        C18943pW5.b().c(C20224rf2.d(B, this, this, AbstractC5480Jn1.d(i)));
        this.j.j = i;
    }

    public void s(int i) {
        C18943pW5.b().c(C20224rf2.d(z, this, this, AbstractC5480Jn1.d(i)));
        this.j.i = i;
    }

    public void t(int i) {
        C18943pW5.b().c(C20224rf2.d(r, this, this, AbstractC5480Jn1.d(i)));
        this.j.a = i;
    }

    public String toString() {
        C18943pW5.b().c(C20224rf2.c(E0, this, this));
        return "AvcConfigurationBox{avcDecoderConfigurationRecord=" + this.j + '}';
    }

    public void u(int i) {
        C18943pW5.b().c(C20224rf2.d(v, this, this, AbstractC5480Jn1.d(i)));
        this.j.e = i;
    }

    public void v(List list) {
        C18943pW5.b().c(C20224rf2.d(x, this, this, list));
        this.j.g = list;
    }

    public void w(int i) {
        C18943pW5.b().c(C20224rf2.d(t, this, this, AbstractC5480Jn1.d(i)));
        this.j.c = i;
    }

    public void x(List list) {
        C18943pW5.b().c(C20224rf2.d(w, this, this, list));
        this.j.f = list;
    }
}
