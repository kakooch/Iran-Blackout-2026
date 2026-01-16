package ir.nasim;

import android.content.Context;
import android.view.View;
import ir.nasim.core.modules.profile.entity.ExPeerType;

/* renamed from: ir.nasim.cU7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC10956cU7 {
    static /* synthetic */ void a(InterfaceC10956cU7 interfaceC10956cU7, Context context, C11458d25 c11458d25, ExPeerType exPeerType, InterfaceC18963pY7 interfaceC18963pY7, View view, EnumC24384yX3 enumC24384yX3, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigate");
        }
        if ((i & 16) != 0) {
            view = null;
        }
        View view2 = view;
        if ((i & 32) != 0) {
            enumC24384yX3 = EnumC24384yX3.a;
        }
        interfaceC10956cU7.b(context, c11458d25, exPeerType, interfaceC18963pY7, view2, enumC24384yX3);
    }

    void b(Context context, C11458d25 c11458d25, ExPeerType exPeerType, InterfaceC18963pY7 interfaceC18963pY7, View view, EnumC24384yX3 enumC24384yX3);
}
