package ir.nasim;

import ai.bale.proto.UsersStruct$PuppetGroup;
import ai.bale.proto.UsersStruct$PuppetUser;
import ir.nasim.features.mxp.entity.PuppetGroup;
import ir.nasim.features.mxp.entity.PuppetUser;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.iB, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C14600iB implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public PuppetGroup a(UsersStruct$PuppetGroup usersStruct$PuppetGroup) {
        List listM;
        AbstractC13042fc3.i(usersStruct$PuppetGroup, "input");
        String name = usersStruct$PuppetGroup.getName();
        if (name == null) {
            name = "";
        }
        List<UsersStruct$PuppetUser> puppetsList = usersStruct$PuppetGroup.getPuppetsList();
        if (puppetsList != null) {
            List<UsersStruct$PuppetUser> list = puppetsList;
            listM = new ArrayList(AbstractC10976cX0.x(list, 10));
            for (UsersStruct$PuppetUser usersStruct$PuppetUser : list) {
                int uid = usersStruct$PuppetUser.getUserOutPeer().getUid();
                C15202jB c15202jB = new C15202jB();
                FM7 puppeteer = usersStruct$PuppetUser.getPuppeteer();
                AbstractC13042fc3.h(puppeteer, "getPuppeteer(...)");
                listM.add(new PuppetUser(uid, c15202jB.a(puppeteer)));
            }
        } else {
            listM = AbstractC10360bX0.m();
        }
        return new PuppetGroup(name, listM);
    }
}
