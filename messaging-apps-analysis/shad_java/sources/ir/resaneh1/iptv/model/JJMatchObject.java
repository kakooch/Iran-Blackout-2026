package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.helper.JJAppPreferences;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class JJMatchObject extends PresenterItem {
    public String date;
    public String group;
    public int id;
    public int level;
    public boolean manual;
    public int minutes;
    public int order;
    public int p1;
    public int p2;
    public int point;
    public int pred1;
    public int pred2;
    public int r1;
    public int r2;
    public JJScoreObject score;
    public String share_link;
    public int status;
    public int team1;
    public int team2;
    public String time;
    public int votes;
    public int vweek;
    public String week;

    public class JJScoreObject {
        public int score1;
        public int score2;

        public JJScoreObject() {
        }
    }

    public int getHostScor() {
        int i;
        JJScoreObject jJScoreObject = this.score;
        if (jJScoreObject != null && (i = jJScoreObject.score1) >= 0) {
            return i;
        }
        return 0;
    }

    public int getGuestScor() {
        int i;
        JJScoreObject jJScoreObject = this.score;
        if (jJScoreObject != null && (i = jJScoreObject.score2) >= 0) {
            return i;
        }
        return 0;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.jjMatch;
    }

    public JJTeamObject getHostTeam() {
        ArrayList<JJTeamObject> arrayList;
        JJGetMatchAndTeamListOutput matchAndTeam = JJAppPreferences.getInstance().getMatchAndTeam();
        if (matchAndTeam == null || (arrayList = matchAndTeam.result.teamUpdates) == null) {
            return null;
        }
        Iterator<JJTeamObject> it = arrayList.iterator();
        while (it.hasNext()) {
            JJTeamObject next = it.next();
            if (next.id == this.team1) {
                return next;
            }
        }
        return null;
    }

    public JJTeamObject getGuestTeam() {
        ArrayList<JJTeamObject> arrayList;
        JJGetMatchAndTeamListOutput matchAndTeam = JJAppPreferences.getInstance().getMatchAndTeam();
        if (matchAndTeam == null || (arrayList = matchAndTeam.result.teamUpdates) == null) {
            return null;
        }
        Iterator<JJTeamObject> it = arrayList.iterator();
        while (it.hasNext()) {
            JJTeamObject next = it.next();
            if (next.id == this.team2) {
                return next;
            }
        }
        return null;
    }
}
