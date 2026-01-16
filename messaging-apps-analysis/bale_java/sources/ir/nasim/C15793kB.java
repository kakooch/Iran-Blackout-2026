package ir.nasim;

import ai.bale.proto.UsersStruct$PuppetUser;
import ir.nasim.features.mxp.entity.PuppetUser;

/* renamed from: ir.nasim.kB, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C15793kB implements InterfaceC14123hO3 {
    private final C15202jB a = new C15202jB();

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public PuppetUser a(UsersStruct$PuppetUser usersStruct$PuppetUser) {
        AbstractC13042fc3.i(usersStruct$PuppetUser, "input");
        int uid = usersStruct$PuppetUser.getUserOutPeer().getUid();
        C15202jB c15202jB = this.a;
        FM7 puppeteer = usersStruct$PuppetUser.getPuppeteer();
        AbstractC13042fc3.h(puppeteer, "getPuppeteer(...)");
        return new PuppetUser(uid, c15202jB.a(puppeteer));
    }
}
