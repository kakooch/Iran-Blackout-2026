package ir.nasim;

import ai.bale.proto.MeetStruct$Call;
import ai.bale.proto.MeetStruct$GroupCall;
import java.util.List;

/* renamed from: ir.nasim.Hy0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC5110Hy0 {
    static /* synthetic */ void c(InterfaceC5110Hy0 interfaceC5110Hy0, boolean z, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: acceptIncomingCall");
        }
        if ((i & 2) != 0) {
            j = -1;
        }
        interfaceC5110Hy0.a(z, j);
    }

    void a(boolean z, long j);

    void b(List list);

    void d(EnumC12029dv0 enumC12029dv0, int i);

    void e();

    void f();

    void g(InterfaceC9449Zz0 interfaceC9449Zz0);

    void h(int i, MeetStruct$Call meetStruct$Call, boolean z);

    void i(MeetStruct$GroupCall meetStruct$GroupCall);
}
