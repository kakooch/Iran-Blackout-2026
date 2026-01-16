package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.helper.JJAppPreferences;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class JJTableRowObject extends PresenterItem {
    public int draws;
    public int goalsAgainst;
    public int goalsFor;
    public String group;
    public int losts;
    public int number;
    public int played;
    public int points;
    public int teamId;
    public boolean temporary;
    public int wins;

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.jjTableRow;
    }

    public JJTeamObject getTeam() {
        ArrayList<JJTeamObject> arrayList;
        JJGetMatchAndTeamListOutput matchAndTeam = JJAppPreferences.getInstance().getMatchAndTeam();
        if (matchAndTeam == null || (arrayList = matchAndTeam.result.teamUpdates) == null) {
            return null;
        }
        Iterator<JJTeamObject> it = arrayList.iterator();
        while (it.hasNext()) {
            JJTeamObject next = it.next();
            if (next.id == this.teamId) {
                return next;
            }
        }
        return null;
    }
}
