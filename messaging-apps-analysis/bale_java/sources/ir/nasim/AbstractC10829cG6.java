package ir.nasim;

import android.content.res.Resources;
import ir.nasim.WF6;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.cG6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC10829cG6 {
    public static final String a(WF6 wf6, Resources resources) throws Resources.NotFoundException {
        AbstractC13042fc3.i(wf6, "<this>");
        AbstractC13042fc3.i(resources, "resources");
        if (wf6 instanceof WF6.d) {
            String string = resources.getString(FD5.error_folder_limit, Integer.valueOf(((WF6.d) wf6).a()));
            AbstractC13042fc3.h(string, "getString(...)");
            return string;
        }
        if (AbstractC13042fc3.d(wf6, WF6.f.a)) {
            String string2 = resources.getString(FD5.error_time_out);
            AbstractC13042fc3.h(string2, "getString(...)");
            return string2;
        }
        if (wf6 instanceof WF6.b) {
            return ((WF6.b) wf6).a();
        }
        if (wf6 instanceof WF6.c) {
            String string3 = resources.getString(FD5.folder_created);
            AbstractC13042fc3.h(string3, "getString(...)");
            return string3;
        }
        if (AbstractC13042fc3.d(wf6, WF6.a.a)) {
            String string4 = resources.getString(FD5.empty_folder_error);
            AbstractC13042fc3.h(string4, "getString(...)");
            return string4;
        }
        if (!AbstractC13042fc3.d(wf6, WF6.e.a)) {
            throw new NoWhenBranchMatchedException();
        }
        String string5 = resources.getString(FD5.reserved_folder_edit_error);
        AbstractC13042fc3.h(string5, "getString(...)");
        return string5;
    }
}
