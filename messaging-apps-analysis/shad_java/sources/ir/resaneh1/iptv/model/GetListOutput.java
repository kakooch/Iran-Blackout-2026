package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class GetListOutput<T extends PresenterItem> extends StatusOutput {
    public boolean has_continue;
    public boolean isRemovePrevious = false;
    public ArrayList<T> results;
    public String start_id;
    public int total_count;
}
