package ir.nasim;

import ai.bale.proto.UsersOuterClass$UpdateContactRegistered;

/* renamed from: ir.nasim.fD7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C12819fD7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C12210eD7 a(UsersOuterClass$UpdateContactRegistered usersOuterClass$UpdateContactRegistered) {
        AbstractC13042fc3.i(usersOuterClass$UpdateContactRegistered, "input");
        return new C12210eD7(usersOuterClass$UpdateContactRegistered.getUid(), usersOuterClass$UpdateContactRegistered.getIsSilent(), usersOuterClass$UpdateContactRegistered.getDate(), usersOuterClass$UpdateContactRegistered.getRid());
    }
}
