package ir.resaneh1.iptv.model;

import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;

/* loaded from: classes3.dex */
public class JJTeamObject extends PresenterItem {
    public String ename;
    public String flag;
    public String group;
    public int id;
    private String name;
    public int status;

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.jjTeam;
    }

    public String getName() {
        if (this.status == -1) {
            if (this.ename.length() < 2) {
                return "?";
            }
            if (this.ename.startsWith("W")) {
                return "برنده " + NumberUtils.toPersian(this.ename.substring(1));
            }
            if (this.ename.startsWith("L")) {
                return "بازنده " + NumberUtils.toPersian(this.ename.substring(1));
            }
            if (!this.ename.startsWith("A") && !this.ename.startsWith("B") && !this.ename.startsWith("C") && !this.ename.startsWith("D") && !this.ename.startsWith("E") && !this.ename.startsWith("F") && !this.ename.startsWith("G") && !this.ename.startsWith("H")) {
                return "?";
            }
            return "تیم " + NumberUtils.toPersian(this.ename.substring(1)) + " از " + this.ename.substring(0, 1);
        }
        String str = this.name;
        return (str == null || str.equals(BuildConfig.FLAVOR)) ? "?" : this.name;
    }
}
