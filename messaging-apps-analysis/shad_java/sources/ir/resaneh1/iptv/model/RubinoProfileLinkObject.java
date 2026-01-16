package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.helper.DataGenerator;
import ir.resaneh1.iptv.model.Link;

/* loaded from: classes3.dex */
public class RubinoProfileLinkObject {
    public String image_url;
    public Link link;
    public String title;

    public static RubinoProfileLinkObject generate() {
        RubinoProfileLinkObject rubinoProfileLinkObject = new RubinoProfileLinkObject();
        rubinoProfileLinkObject.title = DataGenerator.randomName();
        if (DataGenerator.randomBoolean()) {
            rubinoProfileLinkObject.image_url = "https://scs442.iranlms.ir/picture/2022-02-17-16/790d9dcb-902c-479c-9aec-12d0e91efa69/32-4";
        } else {
            rubinoProfileLinkObject.image_url = "https://scs433.iranlms.ir/picture/2022-02-25-12/247794fc-d018-47d8-9f24-e58b39e2d8ef/32-4";
        }
        Link link = new Link();
        rubinoProfileLinkObject.link = link;
        link.type = Link.LinkTypeEnum.action;
        link.action = Link.EnumBannerAction.mychat;
        return rubinoProfileLinkObject;
    }
}
