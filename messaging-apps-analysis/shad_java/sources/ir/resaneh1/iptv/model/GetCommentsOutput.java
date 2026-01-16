package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class GetCommentsOutput extends PresenterItem {
    public ArrayList<EndPointCommentObject> comments;
    public ArrayList<String> disliked_comments;
    public ArrayList<String> liked_comments;
    public String next_start_id;
}
