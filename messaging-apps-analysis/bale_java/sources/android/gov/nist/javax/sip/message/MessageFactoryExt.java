package android.gov.nist.javax.sip.message;

import ir.nasim.B64;
import ir.nasim.InterfaceC10981cX5;
import ir.nasim.InterfaceC12560ep0;
import ir.nasim.InterfaceC17560nA2;
import ir.nasim.InterfaceC18560or7;
import ir.nasim.InterfaceC18819pI7;
import ir.nasim.InterfaceC19085pl1;
import ir.nasim.InterfaceC21662tv0;
import ir.nasim.InterfaceC21815uA7;
import ir.nasim.InterfaceC5044Hq6;
import ir.nasim.UP5;
import ir.nasim.VV3;
import java.util.List;

/* loaded from: classes.dex */
public interface MessageFactoryExt extends B64 {
    MultipartMimeContent createMultipartMimeContent(InterfaceC19085pl1 interfaceC19085pl1, String[] strArr, String[] strArr2, String[] strArr3);

    /* synthetic */ UP5 createRequest(InterfaceC21815uA7 interfaceC21815uA7, String str, InterfaceC21662tv0 interfaceC21662tv0, InterfaceC12560ep0 interfaceC12560ep0, InterfaceC17560nA2 interfaceC17560nA2, InterfaceC18560or7 interfaceC18560or7, List list, VV3 vv3);

    /* synthetic */ UP5 createRequest(InterfaceC21815uA7 interfaceC21815uA7, String str, InterfaceC21662tv0 interfaceC21662tv0, InterfaceC12560ep0 interfaceC12560ep0, InterfaceC17560nA2 interfaceC17560nA2, InterfaceC18560or7 interfaceC18560or7, List list, VV3 vv3, InterfaceC19085pl1 interfaceC19085pl1, Object obj);

    /* synthetic */ UP5 createRequest(InterfaceC21815uA7 interfaceC21815uA7, String str, InterfaceC21662tv0 interfaceC21662tv0, InterfaceC12560ep0 interfaceC12560ep0, InterfaceC17560nA2 interfaceC17560nA2, InterfaceC18560or7 interfaceC18560or7, List list, VV3 vv3, InterfaceC19085pl1 interfaceC19085pl1, byte[] bArr);

    /* synthetic */ UP5 createRequest(String str);

    /* synthetic */ InterfaceC10981cX5 createResponse(int i, UP5 up5);

    /* synthetic */ InterfaceC10981cX5 createResponse(int i, UP5 up5, InterfaceC19085pl1 interfaceC19085pl1, Object obj);

    /* synthetic */ InterfaceC10981cX5 createResponse(int i, UP5 up5, InterfaceC19085pl1 interfaceC19085pl1, byte[] bArr);

    /* synthetic */ InterfaceC10981cX5 createResponse(int i, InterfaceC21662tv0 interfaceC21662tv0, InterfaceC12560ep0 interfaceC12560ep0, InterfaceC17560nA2 interfaceC17560nA2, InterfaceC18560or7 interfaceC18560or7, List list, VV3 vv3);

    /* synthetic */ InterfaceC10981cX5 createResponse(int i, InterfaceC21662tv0 interfaceC21662tv0, InterfaceC12560ep0 interfaceC12560ep0, InterfaceC17560nA2 interfaceC17560nA2, InterfaceC18560or7 interfaceC18560or7, List list, VV3 vv3, InterfaceC19085pl1 interfaceC19085pl1, Object obj);

    /* synthetic */ InterfaceC10981cX5 createResponse(int i, InterfaceC21662tv0 interfaceC21662tv0, InterfaceC12560ep0 interfaceC12560ep0, InterfaceC17560nA2 interfaceC17560nA2, InterfaceC18560or7 interfaceC18560or7, List list, VV3 vv3, InterfaceC19085pl1 interfaceC19085pl1, byte[] bArr);

    /* synthetic */ InterfaceC10981cX5 createResponse(String str);

    void setDefaultContentEncodingCharset(String str);

    void setDefaultServerHeader(InterfaceC5044Hq6 interfaceC5044Hq6);

    void setDefaultUserAgentHeader(InterfaceC18819pI7 interfaceC18819pI7);
}
