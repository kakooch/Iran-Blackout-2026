package ir.nasim.features.root;

import ai.bale.proto.MeetOuterClass$ResponseGetCallLinkDetails;
import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.ComposeView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.G;
import androidx.lifecycle.j;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.tabs.TabLayout;
import ir.nasim.A98;
import ir.nasim.AD4;
import ir.nasim.AbstractC10026ax1;
import ir.nasim.AbstractC10222bH6;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC10721c52;
import ir.nasim.AbstractC10882cM5;
import ir.nasim.AbstractC11024cc1;
import ir.nasim.AbstractC11456d23;
import ir.nasim.AbstractC12208eD5;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC13040fc1;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC13463gG6;
import ir.nasim.AbstractC13472gH6;
import ir.nasim.AbstractC13778go1;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC15226jD5;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC16751lo1;
import ir.nasim.AbstractC17590nD5;
import ir.nasim.AbstractC19224pz3;
import ir.nasim.AbstractC19242q11;
import ir.nasim.AbstractC19555qZ;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20051rO3;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC20507s76;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC21375tZ;
import ir.nasim.AbstractC21387ta2;
import ir.nasim.AbstractC21393ta8;
import ir.nasim.AbstractC21710u02;
import ir.nasim.AbstractC22105ug3;
import ir.nasim.AbstractC22163um1;
import ir.nasim.AbstractC22884vz0;
import ir.nasim.AbstractC3742Cd6;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC4179Ea2;
import ir.nasim.AbstractC4310Eo7;
import ir.nasim.AbstractC4616Fw7;
import ir.nasim.AbstractC5963Lo7;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.AbstractC6392Nk0;
import ir.nasim.AbstractC6459Nq2;
import ir.nasim.AbstractC6550Nz2;
import ir.nasim.AbstractC6797Pa1;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC9273Zf4;
import ir.nasim.AbstractC9287Zh0;
import ir.nasim.AbstractC9323Zl0;
import ir.nasim.AbstractC9339Zm7;
import ir.nasim.AbstractC9747aV;
import ir.nasim.AbstractC9796aa3;
import ir.nasim.BC5;
import ir.nasim.C10600bs7;
import ir.nasim.C11458d25;
import ir.nasim.C12366eV1;
import ir.nasim.C12889fL5;
import ir.nasim.C14819iX7;
import ir.nasim.C15225jD4;
import ir.nasim.C16848ly0;
import ir.nasim.C16913m46;
import ir.nasim.C17067mL1;
import ir.nasim.C17213mb2;
import ir.nasim.C17468n10;
import ir.nasim.C17784nZ1;
import ir.nasim.C18712p72;
import ir.nasim.C18987pb3;
import ir.nasim.C19406qI3;
import ir.nasim.C19818qz6;
import ir.nasim.C19938rB7;
import ir.nasim.C20085rS1;
import ir.nasim.C20158ra2;
import ir.nasim.C20477s46;
import ir.nasim.C21448tg3;
import ir.nasim.C22042ua0;
import ir.nasim.C22055ub3;
import ir.nasim.C22078ud6;
import ir.nasim.C24254yJ;
import ir.nasim.C24398yZ;
import ir.nasim.C24480yh2;
import ir.nasim.C3343Am;
import ir.nasim.C5495Jo7;
import ir.nasim.C5598Ka2;
import ir.nasim.C5721Ko;
import ir.nasim.C5735Kp4;
import ir.nasim.C6011Lu2;
import ir.nasim.C6399Nk7;
import ir.nasim.C6879Pj2;
import ir.nasim.C7183Qq;
import ir.nasim.C7252Qx5;
import ir.nasim.C8386Vt0;
import ir.nasim.C9348Zn7;
import ir.nasim.C9475a16;
import ir.nasim.D20;
import ir.nasim.DG7;
import ir.nasim.DY6;
import ir.nasim.ED1;
import ir.nasim.EV4;
import ir.nasim.EX2;
import ir.nasim.EnumC11622dK;
import ir.nasim.EnumC12613eu3;
import ir.nasim.EnumC12874fK;
import ir.nasim.EnumC14097hL4;
import ir.nasim.EnumC16477lL2;
import ir.nasim.EnumC18608ow5;
import ir.nasim.F27;
import ir.nasim.F84;
import ir.nasim.FD7;
import ir.nasim.FV0;
import ir.nasim.G10;
import ir.nasim.GD7;
import ir.nasim.HQ0;
import ir.nasim.InterfaceC10040ay6;
import ir.nasim.InterfaceC10258bL6;
import ir.nasim.InterfaceC10970cW3;
import ir.nasim.InterfaceC11677dQ0;
import ir.nasim.InterfaceC11819dc1;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC13157fl1;
import ir.nasim.InterfaceC13356g53;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC14088hK4;
import ir.nasim.InterfaceC14538i46;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC15247jG;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC16806lt6;
import ir.nasim.InterfaceC17936no4;
import ir.nasim.InterfaceC18060o11;
import ir.nasim.InterfaceC18633oz3;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC19868r46;
import ir.nasim.InterfaceC20208rd6;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC21680tx0;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC22258uv6;
import ir.nasim.InterfaceC22474vI4;
import ir.nasim.InterfaceC22634va2;
import ir.nasim.InterfaceC22848vv0;
import ir.nasim.InterfaceC23422wt4;
import ir.nasim.InterfaceC23769xU5;
import ir.nasim.InterfaceC24823zG1;
import ir.nasim.InterfaceC3570Bk5;
import ir.nasim.InterfaceC4557Fq2;
import ir.nasim.InterfaceC4662Ga2;
import ir.nasim.InterfaceC4806Gq2;
import ir.nasim.InterfaceC7258Qy2;
import ir.nasim.InterfaceC7565Sg3;
import ir.nasim.InterfaceC9102Ym4;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.InterfaceC9664aL6;
import ir.nasim.InterfaceC9687aO2;
import ir.nasim.J66;
import ir.nasim.JF5;
import ir.nasim.KB5;
import ir.nasim.L93;
import ir.nasim.M10;
import ir.nasim.M66;
import ir.nasim.N46;
import ir.nasim.O98;
import ir.nasim.PP0;
import ir.nasim.QJ5;
import ir.nasim.R14;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.UN2;
import ir.nasim.UY6;
import ir.nasim.W06;
import ir.nasim.W25;
import ir.nasim.W81;
import ir.nasim.XY6;
import ir.nasim.YR1;
import ir.nasim.ZH6;
import ir.nasim.ZN2;
import ir.nasim.ZY0;
import ir.nasim.components.appbar.view.DrawerToolbar;
import ir.nasim.core.modules.file.storage.d;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.core.modules.settings.entity.ChangeLogData;
import ir.nasim.core.network.RpcException;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.database.entity.ContactEntity;
import ir.nasim.designsystem.modal.dialog.AlertDialog;
import ir.nasim.features.call.ui.AvatarAsyncImagePainterKt;
import ir.nasim.features.eventbar.data.model.EventBarData;
import ir.nasim.features.pfm.PFMActivity;
import ir.nasim.features.root.AbstractC13083a;
import ir.nasim.features.root.AbstractC13089g;
import ir.nasim.features.root.C13090h;
import ir.nasim.features.root.G;
import ir.nasim.features.root.J;
import ir.nasim.features.root.L;
import ir.nasim.features.root.RootActivity;
import ir.nasim.features.scanner.SimpleScannerActivity;
import ir.nasim.features.share.ShareData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000ü\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b$\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 î\u00032\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0002Ô\u0001B\t\b\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\bJ\u0017\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001e\u0010\u000bJ\u0017\u0010!\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\tH\u0002¢\u0006\u0004\b#\u0010\u000bJ\u0017\u0010&\u001a\u00020\f2\u0006\u0010%\u001a\u00020$H\u0003¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\f2\u0006\u0010%\u001a\u00020$H\u0003¢\u0006\u0004\b(\u0010'J\u0017\u0010)\u001a\u00020\f2\u0006\u0010%\u001a\u00020$H\u0003¢\u0006\u0004\b)\u0010'J\u001f\u0010-\u001a\u00020\u00142\u0006\u0010*\u001a\u00020$2\u0006\u0010,\u001a\u00020+H\u0003¢\u0006\u0004\b-\u0010.J\u0017\u00101\u001a\u00020\f2\u0006\u00100\u001a\u00020/H\u0002¢\u0006\u0004\b1\u00102J\u0019\u00105\u001a\u00020\f2\b\u00104\u001a\u0004\u0018\u000103H\u0002¢\u0006\u0004\b5\u00106J\u0019\u00107\u001a\u00020\f2\b\u00104\u001a\u0004\u0018\u000103H\u0002¢\u0006\u0004\b7\u00106J\u0019\u00108\u001a\u00020\f2\b\u00104\u001a\u0004\u0018\u000103H\u0002¢\u0006\u0004\b8\u00106J\u0019\u00109\u001a\u00020\f2\b\u00104\u001a\u0004\u0018\u000103H\u0002¢\u0006\u0004\b9\u00106J\u0019\u0010:\u001a\u00020\f2\b\u00104\u001a\u0004\u0018\u000103H\u0002¢\u0006\u0004\b:\u00106J\u000f\u0010;\u001a\u00020\fH\u0002¢\u0006\u0004\b;\u0010\bJ\u0017\u0010>\u001a\u00020+2\u0006\u0010=\u001a\u00020<H\u0002¢\u0006\u0004\b>\u0010?J\u0017\u0010A\u001a\u00020\f2\u0006\u0010@\u001a\u00020<H\u0002¢\u0006\u0004\bA\u0010BJ\u0019\u0010D\u001a\u0004\u0018\u00010\u001f2\u0006\u0010C\u001a\u00020<H\u0002¢\u0006\u0004\bD\u0010EJ\u0017\u0010F\u001a\u00020<2\u0006\u0010@\u001a\u00020<H\u0002¢\u0006\u0004\bF\u0010GJ\u0017\u0010H\u001a\u00020\f2\u0006\u0010@\u001a\u00020<H\u0002¢\u0006\u0004\bH\u0010BJ\u0017\u0010K\u001a\u00020\f2\u0006\u0010J\u001a\u00020IH\u0002¢\u0006\u0004\bK\u0010LJ\u0017\u0010M\u001a\u00020\f2\u0006\u0010J\u001a\u00020IH\u0002¢\u0006\u0004\bM\u0010LJ\u0019\u0010N\u001a\u00020\f2\b\u00104\u001a\u0004\u0018\u000103H\u0002¢\u0006\u0004\bN\u00106J\u0019\u0010O\u001a\u00020\f2\b\u00104\u001a\u0004\u0018\u000103H\u0002¢\u0006\u0004\bO\u00106J'\u0010Q\u001a\u00020\f2\n\b\u0002\u00104\u001a\u0004\u0018\u0001032\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\bQ\u0010RJ\u000f\u0010T\u001a\u00020SH\u0002¢\u0006\u0004\bT\u0010UJ\u000f\u0010V\u001a\u00020\fH\u0002¢\u0006\u0004\bV\u0010\bJ\u0019\u0010W\u001a\u00020\f2\b\u00104\u001a\u0004\u0018\u000103H\u0002¢\u0006\u0004\bW\u00106J\u000f\u0010X\u001a\u00020\fH\u0002¢\u0006\u0004\bX\u0010\bJ\u000f\u0010Y\u001a\u00020+H\u0002¢\u0006\u0004\bY\u0010ZJ\u000f\u0010[\u001a\u00020\fH\u0002¢\u0006\u0004\b[\u0010\bJ\u000f\u0010\\\u001a\u00020\fH\u0002¢\u0006\u0004\b\\\u0010\bJ\u000f\u0010]\u001a\u00020\fH\u0002¢\u0006\u0004\b]\u0010\bJ\u0017\u0010^\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b^\u0010\"J\u0017\u0010_\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b_\u0010\"J\u0017\u0010`\u001a\u00020\f2\u0006\u0010@\u001a\u00020<H\u0002¢\u0006\u0004\b`\u0010BJ\u0017\u0010a\u001a\u00020\f2\u0006\u0010@\u001a\u00020<H\u0002¢\u0006\u0004\ba\u0010BJ\u0017\u0010c\u001a\u00020\f2\u0006\u0010b\u001a\u00020<H\u0002¢\u0006\u0004\bc\u0010BJ\u000f\u0010d\u001a\u00020\fH\u0002¢\u0006\u0004\bd\u0010\bJ\u000f\u0010e\u001a\u00020\fH\u0002¢\u0006\u0004\be\u0010\bJ\u0017\u0010h\u001a\u00020\f2\u0006\u0010g\u001a\u00020fH\u0002¢\u0006\u0004\bh\u0010iJ\u0017\u0010k\u001a\u00020\f2\u0006\u0010j\u001a\u00020<H\u0002¢\u0006\u0004\bk\u0010BJ\u0013\u0010m\u001a\u00020\f*\u00020lH\u0002¢\u0006\u0004\bm\u0010nJ-\u0010t\u001a\u00020\f2\u0006\u0010o\u001a\u00020<2\f\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00140p2\u0006\u0010s\u001a\u00020rH\u0002¢\u0006\u0004\bt\u0010uJ\u000f\u0010v\u001a\u00020+H\u0002¢\u0006\u0004\bv\u0010ZJ\u000f\u0010w\u001a\u00020\fH\u0002¢\u0006\u0004\bw\u0010\bJ\u000f\u0010x\u001a\u00020\fH\u0002¢\u0006\u0004\bx\u0010\bJ+\u0010{\u001a\u00020\f2\f\u0010y\u001a\b\u0012\u0004\u0012\u00020<0p2\f\u0010z\u001a\b\u0012\u0004\u0012\u00020<0pH\u0002¢\u0006\u0004\b{\u0010|J\u000f\u0010}\u001a\u00020\fH\u0002¢\u0006\u0004\b}\u0010\bJ\u001a\u0010\u0080\u0001\u001a\u00020\u007f2\u0006\u0010~\u001a\u00020\u001fH\u0002¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u001c\u0010\u0084\u0001\u001a\u00020\f2\b\u0010\u0083\u0001\u001a\u00030\u0082\u0001H\u0002¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J$\u0010\u0086\u0001\u001a\u00020\f2\b\u0010\u0083\u0001\u001a\u00030\u0082\u00012\u0006\u0010j\u001a\u00020<H\u0002¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u0013\u0010\u0088\u0001\u001a\u00020\fH\u0082@¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\u001b\u0010\u008b\u0001\u001a\u00020\f2\u0007\u0010\u008a\u0001\u001a\u00020+H\u0002¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u001c\u0010\u008f\u0001\u001a\u00020\f2\b\u0010\u008e\u0001\u001a\u00030\u008d\u0001H\u0002¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\u0011\u0010\u0091\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b\u0091\u0001\u0010\bJ\u0011\u0010\u0092\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b\u0092\u0001\u0010\bJ\u0011\u0010\u0093\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b\u0093\u0001\u0010\bJ\u0011\u0010\u0094\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b\u0094\u0001\u0010\bJ3\u0010\u009a\u0001\u001a\u00020\f2\b\u0010\u0096\u0001\u001a\u00030\u0095\u00012\n\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0097\u00012\t\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J1\u0010¡\u0001\u001a\u00020\f2\b\u0010\u009d\u0001\u001a\u00030\u009c\u00012\b\u0010\u009f\u0001\u001a\u00030\u009e\u00012\t\u0010 \u0001\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0006\b¡\u0001\u0010¢\u0001J\u0011\u0010£\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b£\u0001\u0010\bJ\u0011\u0010¤\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b¤\u0001\u0010\bJ\u001c\u0010¦\u0001\u001a\u00020\f2\t\u0010¥\u0001\u001a\u0004\u0018\u000103H\u0016¢\u0006\u0005\b¦\u0001\u00106J\u0011\u0010§\u0001\u001a\u00020\fH\u0016¢\u0006\u0005\b§\u0001\u0010\bJ\u0011\u0010¨\u0001\u001a\u00020+H\u0016¢\u0006\u0005\b¨\u0001\u0010ZJ\u001a\u0010ª\u0001\u001a\u00020\f2\u0007\u0010©\u0001\u001a\u00020<H\u0016¢\u0006\u0005\bª\u0001\u0010BJ2\u0010¯\u0001\u001a\u00020\u001f2\b\u0010¬\u0001\u001a\u00030«\u00012\n\u0010®\u0001\u001a\u0005\u0018\u00010\u00ad\u00012\b\u00104\u001a\u0004\u0018\u000103H\u0016¢\u0006\u0006\b¯\u0001\u0010°\u0001J\u001b\u0010±\u0001\u001a\u00020\f2\b\u00104\u001a\u0004\u0018\u000103H\u0016¢\u0006\u0005\b±\u0001\u00106J\u001c\u0010´\u0001\u001a\u00020\f2\b\u0010³\u0001\u001a\u00030²\u0001H\u0016¢\u0006\u0006\b´\u0001\u0010µ\u0001J\u001c\u0010¶\u0001\u001a\u00020\f2\b\u0010³\u0001\u001a\u00030²\u0001H\u0016¢\u0006\u0006\b¶\u0001\u0010µ\u0001J\u0011\u0010·\u0001\u001a\u00020\fH\u0016¢\u0006\u0005\b·\u0001\u0010\bJ\u0011\u0010¸\u0001\u001a\u00020\fH\u0016¢\u0006\u0005\b¸\u0001\u0010\bJ\u0019\u0010¹\u0001\u001a\u00020\f2\u0006\u0010j\u001a\u00020<H\u0016¢\u0006\u0005\b¹\u0001\u0010BJ$\u0010º\u0001\u001a\u00020\f2\u0006\u0010~\u001a\u00020\u001f2\b\u00104\u001a\u0004\u0018\u000103H\u0016¢\u0006\u0006\bº\u0001\u0010»\u0001J\u001a\u0010½\u0001\u001a\u00020\f2\u0007\u0010¼\u0001\u001a\u000203H\u0016¢\u0006\u0005\b½\u0001\u00106J]\u0010Å\u0001\u001a\u00020\f2\t\u0010¾\u0001\u001a\u0004\u0018\u00010\u00142\t\u0010¿\u0001\u001a\u0004\u0018\u00010\u00142\u001d\u0010Â\u0001\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0018\u00010À\u0001j\u000b\u0012\u0004\u0012\u00020\u0014\u0018\u0001`Á\u00012\t\u0010Ã\u0001\u001a\u0004\u0018\u00010\u00142\t\u0010Ä\u0001\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001J\u0011\u0010Ç\u0001\u001a\u00020\fH\u0016¢\u0006\u0005\bÇ\u0001\u0010\bJ$\u0010Ê\u0001\u001a\u00020\f2\u0007\u0010È\u0001\u001a\u00020\u00142\u0007\u0010É\u0001\u001a\u00020+H\u0016¢\u0006\u0006\bÊ\u0001\u0010Ë\u0001J\u0011\u0010Ì\u0001\u001a\u00020\fH\u0016¢\u0006\u0005\bÌ\u0001\u0010\bJ\u0011\u0010Í\u0001\u001a\u00020\fH\u0016¢\u0006\u0005\bÍ\u0001\u0010\bJ/\u0010Ñ\u0001\u001a\u00020\f2\u0006\u0010o\u001a\u00020<2\u0007\u0010Î\u0001\u001a\u00020<2\n\u0010Ð\u0001\u001a\u0005\u0018\u00010Ï\u0001H\u0016¢\u0006\u0006\bÑ\u0001\u0010Ò\u0001J/\u0010Ó\u0001\u001a\u00020\f2\u0006\u0010o\u001a\u00020<2\f\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00140p2\u0006\u0010s\u001a\u00020rH\u0016¢\u0006\u0005\bÓ\u0001\u0010uJ\u0011\u0010Ô\u0001\u001a\u00020+H\u0016¢\u0006\u0005\bÔ\u0001\u0010ZJ\u001e\u0010Õ\u0001\u001a\u00020\f2\n\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009c\u0001H\u0016¢\u0006\u0006\bÕ\u0001\u0010Ö\u0001J\u001d\u0010Ø\u0001\u001a\u00020\f2\t\u0010×\u0001\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0006\bØ\u0001\u0010Ù\u0001J\u001e\u0010Û\u0001\u001a\u00020\f2\n\u0010Ú\u0001\u001a\u0005\u0018\u00010\u009c\u0001H\u0016¢\u0006\u0006\bÛ\u0001\u0010Ö\u0001J\u001a\u0010Ý\u0001\u001a\u00020\f2\u0007\u0010Ü\u0001\u001a\u00020<H\u0016¢\u0006\u0005\bÝ\u0001\u0010BJ\u001c\u0010Þ\u0001\u001a\u00020\f2\b\u0010P\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0006\bÞ\u0001\u0010Ù\u0001J$\u0010á\u0001\u001a\u00020\f2\u0007\u0010ß\u0001\u001a\u00020\u00142\u0007\u0010à\u0001\u001a\u00020+H\u0016¢\u0006\u0006\bá\u0001\u0010Ë\u0001J\u001d\u0010ã\u0001\u001a\u00020\f2\t\u0010â\u0001\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0006\bã\u0001\u0010Ù\u0001J\u001a\u0010å\u0001\u001a\u00020\f2\u0007\u0010ä\u0001\u001a\u000203H\u0016¢\u0006\u0005\bå\u0001\u00106JB\u0010í\u0001\u001a\u00020\f2\u0007\u0010æ\u0001\u001a\u00020<2\b\u0010è\u0001\u001a\u00030ç\u00012\b\u0010é\u0001\u001a\u00030ç\u00012\u0007\u0010ê\u0001\u001a\u00020+2\b\u0010ì\u0001\u001a\u00030ë\u0001H\u0016¢\u0006\u0006\bí\u0001\u0010î\u0001J\u0011\u0010ï\u0001\u001a\u00020\fH\u0016¢\u0006\u0005\bï\u0001\u0010\bJ%\u0010ð\u0001\u001a\u00020\f2\b\u0010\u009d\u0001\u001a\u00030\u009c\u00012\t\u0010 \u0001\u001a\u0004\u0018\u00010\u0014¢\u0006\u0006\bð\u0001\u0010ñ\u0001J\\\u0010÷\u0001\u001a\u00020\f2\b\u0010\u009d\u0001\u001a\u00030\u009c\u00012\n\u0010ò\u0001\u001a\u0005\u0018\u00010ç\u00012\n\u0010ó\u0001\u001a\u0005\u0018\u00010ç\u00012\u0007\u0010ô\u0001\u001a\u00020+2\t\u0010 \u0001\u001a\u0004\u0018\u00010\u00142\t\u0010õ\u0001\u001a\u0004\u0018\u00010\u00142\u0007\u0010ö\u0001\u001a\u00020+H\u0016¢\u0006\u0006\b÷\u0001\u0010ø\u0001J\u008f\u0001\u0010ÿ\u0001\u001a\u00020\f2\b\u0010\u009d\u0001\u001a\u00030\u009c\u00012\n\u0010ò\u0001\u001a\u0005\u0018\u00010ç\u00012\n\u0010ó\u0001\u001a\u0005\u0018\u00010ç\u00012\u0007\u0010ô\u0001\u001a\u00020+2\t\u0010 \u0001\u001a\u0004\u0018\u00010\u00142\t\u0010õ\u0001\u001a\u0004\u0018\u00010\u00142\u0007\u0010ö\u0001\u001a\u00020+2\u0007\u0010ù\u0001\u001a\u00020+2\n\u0010ú\u0001\u001a\u0005\u0018\u00010\u009c\u00012\t\u0010û\u0001\u001a\u0004\u0018\u00010+2\u0007\u0010ü\u0001\u001a\u00020+2\b\u0010þ\u0001\u001a\u00030ý\u0001H\u0016¢\u0006\u0006\bÿ\u0001\u0010\u0080\u0002J/\u0010\u0082\u0002\u001a\u00020\f2\b\u0010\u009d\u0001\u001a\u00030\u009c\u00012\b\u0010ò\u0001\u001a\u00030ç\u00012\u0007\u0010\u0081\u0002\u001a\u00020\u0014H\u0016¢\u0006\u0006\b\u0082\u0002\u0010\u0083\u0002J\u001c\u0010\u0086\u0002\u001a\u00020\f2\b\u0010\u0085\u0002\u001a\u00030\u0084\u0002H\u0016¢\u0006\u0006\b\u0086\u0002\u0010\u0087\u0002J\u0011\u0010\u0088\u0002\u001a\u00020\fH\u0016¢\u0006\u0005\b\u0088\u0002\u0010\bJ\u001b\u0010\u0089\u0002\u001a\u00020\f2\u0007\u0010\u008e\u0001\u001a\u00020\u0014H\u0016¢\u0006\u0006\b\u0089\u0002\u0010Ù\u0001J\u0011\u0010\u008a\u0002\u001a\u00020\fH\u0016¢\u0006\u0005\b\u008a\u0002\u0010\bJ\u0011\u0010\u008b\u0002\u001a\u00020\fH\u0016¢\u0006\u0005\b\u008b\u0002\u0010\bJ\u0011\u0010\u008c\u0002\u001a\u00020\fH\u0016¢\u0006\u0005\b\u008c\u0002\u0010\bJ\u0011\u0010\u008d\u0002\u001a\u00020\fH\u0016¢\u0006\u0005\b\u008d\u0002\u0010\bJ1\u0010\u0090\u0002\u001a\u00020\f2\u0006\u0010]\u001a\u00020<2\u0015\u0010\u008f\u0002\u001a\u000b\u0012\u0007\b\u0001\u0012\u00030\u008e\u00020p\"\u00030\u008e\u0002H\u0016¢\u0006\u0006\b\u0090\u0002\u0010\u0091\u0002J\u001b\u0010\u0093\u0002\u001a\u00020\f2\u0007\u0010\u0092\u0002\u001a\u00020+H\u0016¢\u0006\u0006\b\u0093\u0002\u0010\u008c\u0001J\u0011\u0010\u0094\u0002\u001a\u00020\fH\u0016¢\u0006\u0005\b\u0094\u0002\u0010\bJ\u0011\u0010\u0095\u0002\u001a\u00020\fH\u0016¢\u0006\u0005\b\u0095\u0002\u0010\bJ\u0019\u0010\u0096\u0002\u001a\u00020\f2\u0007\u0010 \u0001\u001a\u00020\u0014¢\u0006\u0006\b\u0096\u0002\u0010Ù\u0001J/\u0010\u0097\u0002\u001a\u00020\f2\b\u0010\u009d\u0001\u001a\u00030\u009c\u00012\b\u0010\u009f\u0001\u001a\u00030\u009e\u00012\t\u0010 \u0001\u001a\u0004\u0018\u00010\u0014¢\u0006\u0006\b\u0097\u0002\u0010¢\u0001J$\u0010\u009a\u0002\u001a\u00020\f2\u0007\u0010\u0098\u0002\u001a\u00020\u001f2\u0007\u0010\u0099\u0002\u001a\u00020\u001fH\u0016¢\u0006\u0006\b\u009a\u0002\u0010\u009b\u0002J\u0011\u0010\u009c\u0002\u001a\u00020\fH\u0016¢\u0006\u0005\b\u009c\u0002\u0010\bJ\u0011\u0010\u009d\u0002\u001a\u00020\fH\u0016¢\u0006\u0005\b\u009d\u0002\u0010\bJ\u0011\u0010\u009e\u0002\u001a\u00020\fH\u0016¢\u0006\u0005\b\u009e\u0002\u0010\bJ\u0011\u0010\u009f\u0002\u001a\u00020\fH\u0016¢\u0006\u0005\b\u009f\u0002\u0010\bJ\u0011\u0010 \u0002\u001a\u00020\fH\u0016¢\u0006\u0005\b \u0002\u0010\bR(\u0010¤\u0002\u001a\u00020+8\u0016@\u0016X\u0096\u000e¢\u0006\u0017\n\u0006\b\u008d\u0002\u0010¡\u0002\u001a\u0005\b¢\u0002\u0010Z\"\u0006\b£\u0002\u0010\u008c\u0001R'\u0010\u0011\u001a\u00020\u00108\u0016@\u0016X\u0096\u000e¢\u0006\u0017\n\u0006\b¥\u0002\u0010¦\u0002\u001a\u0006\b§\u0002\u0010¨\u0002\"\u0005\b©\u0002\u0010\u0013R,\u0010¯\u0002\u001a\u0005\u0018\u00010\u009c\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\bª\u0002\u0010«\u0002\u001a\u0006\b¬\u0002\u0010\u00ad\u0002\"\u0006\b®\u0002\u0010Ö\u0001R\u001b\u0010¾\u0001\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0002\u0010±\u0002R\u001b\u0010¿\u0001\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b²\u0002\u0010±\u0002R\"\u0010Â\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0014\u0018\u00010³\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b´\u0002\u0010µ\u0002R\u001b\u0010Ã\u0001\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¶\u0002\u0010±\u0002R\u001b\u0010Ä\u0001\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b·\u0002\u0010±\u0002R\u001c\u0010Ú\u0001\u001a\u0005\u0018\u00010\u009c\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¸\u0002\u0010«\u0002R\u001b\u0010×\u0001\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¹\u0002\u0010±\u0002R\u001c\u0010½\u0002\u001a\u0005\u0018\u00010º\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b»\u0002\u0010¼\u0002R!\u0010Ã\u0002\u001a\u00030¾\u00028BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b¿\u0002\u0010À\u0002\u001a\u0006\bÁ\u0002\u0010Â\u0002R\u001c\u0010Ç\u0002\u001a\u0005\u0018\u00010Ä\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÅ\u0002\u0010Æ\u0002R-\u0010Ì\u0002\u001a\u0004\u0018\u00010S2\t\u0010È\u0002\u001a\u0004\u0018\u00010S8\u0006@BX\u0086\u000e¢\u0006\u000f\n\u0006\bÉ\u0002\u0010Ê\u0002\u001a\u0005\bË\u0002\u0010UR\u001c\u0010Ð\u0002\u001a\u0005\u0018\u00010Í\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÎ\u0002\u0010Ï\u0002R\u001c\u0010Ô\u0002\u001a\u0005\u0018\u00010Ñ\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÒ\u0002\u0010Ó\u0002R\u001a\u0010Ø\u0002\u001a\u00030Õ\u00028\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bÖ\u0002\u0010×\u0002R\u001c\u0010Ú\u0002\u001a\u0005\u0018\u00010Ä\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÙ\u0002\u0010Æ\u0002R\u0019\u0010Ý\u0002\u001a\u00020<8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÛ\u0002\u0010Ü\u0002R\u0019\u0010ß\u0002\u001a\u00020<8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÞ\u0002\u0010Ü\u0002R\u0019\u0010á\u0002\u001a\u00020<8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bà\u0002\u0010Ü\u0002R\u001f\u0010ä\u0002\u001a\b\u0012\u0004\u0012\u00020<0p8\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bâ\u0002\u0010ã\u0002R\u001e\u0010y\u001a\b\u0012\u0004\u0012\u00020<0p8\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bå\u0002\u0010ã\u0002R\u001f\u0010è\u0002\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\u000f\n\u0006\bæ\u0002\u0010À\u0002\u001a\u0005\bç\u0002\u0010ZR%\u0010z\u001a\b\u0012\u0004\u0012\u00020<0p8BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bé\u0002\u0010À\u0002\u001a\u0006\bê\u0002\u0010ë\u0002R\u001b\u0010î\u0002\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bì\u0002\u0010í\u0002R\u0019\u0010ð\u0002\u001a\u00020f8\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bï\u0002\u0010í\u0002R\u001c\u0010ô\u0002\u001a\u0005\u0018\u00010ñ\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bò\u0002\u0010ó\u0002R\u001c\u0010÷\u0002\u001a\u0005\u0018\u00010\u0082\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bõ\u0002\u0010ö\u0002R\u001c\u0010ù\u0002\u001a\u0005\u0018\u00010\u0082\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bø\u0002\u0010ö\u0002R\u001c\u0010û\u0002\u001a\u0005\u0018\u00010\u0082\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bú\u0002\u0010ö\u0002R\u001c\u0010ý\u0002\u001a\u0005\u0018\u00010\u0082\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bü\u0002\u0010ö\u0002R\u001c\u0010ÿ\u0002\u001a\u0005\u0018\u00010\u0082\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bþ\u0002\u0010ö\u0002R\u0019\u0010\u0081\u0003\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0003\u0010¡\u0002R\u0019\u0010\u0083\u0003\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0003\u0010¡\u0002R\u0019\u0010\u0085\u0003\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0003\u0010¡\u0002R\u001c\u0010\u0089\u0003\u001a\u0005\u0018\u00010\u0086\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0003\u0010\u0088\u0003R\u0019\u0010\u008b\u0003\u001a\u00020<8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0003\u0010Ü\u0002R\u001c\u0010\u008e\u0003\u001a\u0005\u0018\u00010\u008c\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b·\u0001\u0010\u008d\u0003R\u0019\u0010\u0090\u0003\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0003\u0010¡\u0002R\u001c\u0010\u0093\u0003\u001a\u0005\u0018\u00010\u0091\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b§\u0001\u0010\u0092\u0003R\u001c\u0010\u0097\u0003\u001a\u0005\u0018\u00010\u0094\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0003\u0010\u0096\u0003R\u001c\u0010\u0099\u0003\u001a\u0005\u0018\u00010\u0094\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0098\u0003\u0010\u0096\u0003R\u0018\u0010\u009d\u0003\u001a\u00030\u009a\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009b\u0003\u0010\u009c\u0003R\u001b\u0010 \u0003\u001a\u0004\u0018\u00010l8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0003\u0010\u009f\u0003R*\u0010¨\u0003\u001a\u00030¡\u00038\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b¢\u0003\u0010£\u0003\u001a\u0006\b¤\u0003\u0010¥\u0003\"\u0006\b¦\u0003\u0010§\u0003R*\u0010°\u0003\u001a\u00030©\u00038\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\bª\u0003\u0010«\u0003\u001a\u0006\b¬\u0003\u0010\u00ad\u0003\"\u0006\b®\u0003\u0010¯\u0003R*\u0010¸\u0003\u001a\u00030±\u00038\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b²\u0003\u0010³\u0003\u001a\u0006\b´\u0003\u0010µ\u0003\"\u0006\b¶\u0003\u0010·\u0003R*\u0010À\u0003\u001a\u00030¹\u00038\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\bº\u0003\u0010»\u0003\u001a\u0006\b¼\u0003\u0010½\u0003\"\u0006\b¾\u0003\u0010¿\u0003R*\u0010È\u0003\u001a\u00030Á\u00038\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\bÂ\u0003\u0010Ã\u0003\u001a\u0006\bÄ\u0003\u0010Å\u0003\"\u0006\bÆ\u0003\u0010Ç\u0003R*\u0010Ð\u0003\u001a\u00030É\u00038\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\bÊ\u0003\u0010Ë\u0003\u001a\u0006\bÌ\u0003\u0010Í\u0003\"\u0006\bÎ\u0003\u0010Ï\u0003R!\u0010Õ\u0003\u001a\u00030Ñ\u00038BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bÒ\u0003\u0010À\u0002\u001a\u0006\bÓ\u0003\u0010Ô\u0003R*\u0010Ý\u0003\u001a\u00030Ö\u00038\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b×\u0003\u0010Ø\u0003\u001a\u0006\bÙ\u0003\u0010Ú\u0003\"\u0006\bÛ\u0003\u0010Ü\u0003R\u001f\u0010à\u0003\u001a\n\u0012\u0005\u0012\u00030²\u00010À\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÞ\u0003\u0010ß\u0003R\u001e\u0010ä\u0003\u001a\t\u0012\u0004\u0012\u00020\f0á\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\bâ\u0003\u0010ã\u0003R\u0017\u0010ç\u0003\u001a\u00020<8BX\u0082\u0004¢\u0006\b\u001a\u0006\bå\u0003\u0010æ\u0003R\u0018\u0010ë\u0003\u001a\u00030è\u00038BX\u0082\u0004¢\u0006\b\u001a\u0006\bé\u0003\u0010ê\u0003R\u0016\u0010í\u0003\u001a\u00020+8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bì\u0003\u0010Z¨\u0006ô\u0003²\u0006\u000e\u0010ð\u0003\u001a\u00030ï\u00038\nX\u008a\u0084\u0002²\u0006\u000f\u0010ñ\u0003\u001a\u00020+8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010ó\u0003\u001a\u00030ò\u00038\nX\u008a\u0084\u0002"}, d2 = {"Lir/nasim/features/root/h;", "Lir/nasim/features/root/g;", "Lir/nasim/i46;", "Lir/nasim/jD4$b;", "Lir/nasim/Ka2$c;", "Lir/nasim/Ka2$d;", "Lir/nasim/Ka2$b;", "<init>", "()V", "Lir/nasim/gj3;", "Qb", "()Lir/nasim/gj3;", "Lir/nasim/rB7;", "Rb", "Hd", "rd", "Lir/nasim/features/root/g$b;", "dialogsMode", "Mb", "(Lir/nasim/features/root/g$b;)V", "", "title", "desc", "Lir/nasim/ax1;", "action", "Gd", "(Ljava/lang/String;Ljava/lang/String;Lir/nasim/ax1;)V", "Lir/nasim/ax1$b;", "Tc", "(Lir/nasim/ax1$b;)V", "Lc", "Landroid/view/View;", "parentView", "ud", "(Landroid/view/View;)V", "Ic", "Lir/nasim/features/root/a$c;", "groupPreviewModel", "eb", "(Lir/nasim/features/root/a$c;Lir/nasim/ub1;I)V", "ab", "cb", "it", "", "useAndSeparator", "yc", "(Lir/nasim/features/root/a$c;ZLir/nasim/ub1;I)Ljava/lang/String;", "Lir/nasim/vz0$a;", "callToast", "qc", "(Lir/nasim/vz0$a;)V", "Landroid/os/Bundle;", "savedInstanceState", "Yc", "(Landroid/os/Bundle;)V", "md", "ed", "Zc", "gd", "qd", "", "position", "Pc", "(I)Z", "currentPosition", "Ec", "(I)V", "i", "ac", "(I)Landroid/view/View;", "tc", "(I)I", "Fd", "Landroid/widget/LinearLayout;", "tabStrip", "od", "(Landroid/widget/LinearLayout;)V", "Bc", "nd", "pd", "query", "ad", "(Landroid/os/Bundle;Ljava/lang/String;)V", "Lir/nasim/no4;", "fc", "()Lir/nasim/no4;", "Id", "kd", "xc", "wd", "()Z", "Md", "xd", "id", "td", "sd", "pc", "Nb", "currentTabPosition", "Ob", "Tb", "Lb", "Landroid/widget/FrameLayout;", "res", "fd", "(Landroid/widget/FrameLayout;)V", "tabIndex", "jd", "Landroidx/compose/ui/platform/ComposeView;", "Sb", "(Landroidx/compose/ui/platform/ComposeView;)V", "requestCode", "", "permissions", "", "grantResults", "Wc", "(I[Ljava/lang/String;[I)V", "Vc", "Uc", "Od", "tabIcons", "tabTitles", "Kb", "([Ljava/lang/Integer;[Ljava/lang/Integer;)V", "vd", "view", "Ljava/lang/Runnable;", "ic", "(Landroid/view/View;)Ljava/lang/Runnable;", "Landroid/widget/TextView;", "badge", "dd", "(Landroid/widget/TextView;)V", "cd", "(Landroid/widget/TextView;I)V", "Fc", "(Lir/nasim/rm1;)Ljava/lang/Object;", "isNeedToShowFeedBack", "Vb", "(Z)V", "", "count", "hd", "(Ljava/lang/CharSequence;)V", "rc", "Kd", "sc", "Sc", "Landroid/content/Context;", "context", "Lir/nasim/core/modules/settings/entity/ChangeLogData;", "changeLogData", "changeLogHash", "zd", "(Landroid/content/Context;Lir/nasim/core/modules/settings/entity/ChangeLogData;Ljava/lang/String;)V", "Lir/nasim/d25;", "peer", "Lir/nasim/core/modules/profile/entity/ExPeerType;", DialogEntity.COLUMN_EX_PEER_TYPE, DialogEntity.COLUMN_MESSAGE, "Ed", "(Lir/nasim/d25;Lir/nasim/core/modules/profile/entity/ExPeerType;Ljava/lang/String;)V", "Hc", "Xc", "saveInstance", "M6", "Z1", "Z3", "messageRes", "sa", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "G6", "Lir/nasim/xU5;", "listener", "ua", "(Lir/nasim/xU5;)V", "ta", "X1", "O9", "ma", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "outState", "i7", "sendText", "sendUriString", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "sendUriMultiple", "sendMimeType", "peerIdDirectShare", "la", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)V", "P9", "token", "isOpenOutSideOfBale", "ca", "(Ljava/lang/String;Z)V", "h7", "c7", "resultCode", "Landroid/content/Intent;", "data", "H6", "(IILandroid/content/Intent;)V", "g7", "a", "na", "(Lir/nasim/d25;)V", "pendingMessage", "oa", "(Ljava/lang/String;)V", "pendingPeer", "pa", "index", "ia", "ha", "tabName", "openStory", "ja", "storyId", "da", "bundle", "V9", "discussionGroupId", "", "topId", "topDate", "shouldLoadComment", "Lir/nasim/HQ0;", "spot", "W9", "(IJJZLir/nasim/HQ0;)V", "ra", "Rc", "(Lir/nasim/d25;Ljava/lang/String;)V", DialogEntity.COLUMN_RID, ContactEntity.COLUMN_SORT_KEY, "shouldLoadMessage", "jaryanTabType", "isAllowingStateLossEnabled", "Y9", "(Lir/nasim/d25;Ljava/lang/Long;Ljava/lang/Long;ZLjava/lang/String;Ljava/lang/String;Z)V", "openComment", "intendedPeer", "joinViaLink", "isOpenedFromDialogListOrDialogAd", "Lir/nasim/features/root/EmptyStateOnboardingItemAction;", "emptyStateOnboardingItemAction", "Z9", "(Lir/nasim/d25;Ljava/lang/Long;Ljava/lang/Long;ZLjava/lang/String;Ljava/lang/String;ZZLir/nasim/d25;Ljava/lang/Boolean;ZLir/nasim/features/root/EmptyStateOnboardingItemAction;)V", "param", "T9", "(Lir/nasim/d25;JLjava/lang/String;)V", "Lir/nasim/hL4;", "openedPFMFrom", "ea", "(Lir/nasim/hL4;)V", "T6", "b1", "r0", "p0", "q3", "k1", "", "args", "didReceivedNotification", "(I[Ljava/lang/Object;)V", "withAnimation", "x4", "B0", "h4", "Jd", "Bd", "insetView", "paddingView", "l4", "(Landroid/view/View;Landroid/view/View;)V", "ga", "fa", "U9", "S0", "a1", "Z", "S9", "qa", "isSharingDialogSelected", "l1", "Lir/nasim/features/root/g$b;", "R9", "()Lir/nasim/features/root/g$b;", "ld", "m1", "Lir/nasim/d25;", "Q9", "()Lir/nasim/d25;", "ka", "currentPeer", "n1", "Ljava/lang/String;", "o1", "", "p1", "Ljava/util/List;", "q1", "r1", "s1", "t1", "Lir/nasim/features/root/G;", "u1", "Lir/nasim/features/root/G;", "presenter", "Lir/nasim/features/root/I;", "v1", "Lir/nasim/Yu3;", "oc", "()Lir/nasim/features/root/I;", "viewModel", "Landroidx/fragment/app/Fragment;", "w1", "Landroidx/fragment/app/Fragment;", "dialogsContainerFragment", "value", "x1", "Lir/nasim/no4;", "gc", "myBankFragmentPageInterface", "Lir/nasim/ua0;", "y1", "Lir/nasim/ua0;", "jaryanFragment", "Lir/nasim/features/bank/mybank/webview/a;", "z1", "Lir/nasim/features/bank/mybank/webview/a;", "aiChatFragment", "Landroidx/fragment/app/FragmentManager;", "A1", "Landroidx/fragment/app/FragmentManager;", "rootSupportFragmentManager", "B1", "activeFragment", "C1", TokenNames.I, "lastSelectedPageIndex", "D1", "tabActiveColor", "E1", "tabDisableColor", "F1", "[Ljava/lang/Integer;", "tabIconsSelected", "G1", "H1", "uc", "isAiTabEnabled", "I1", "mc", "()[Ljava/lang/Integer;", "J1", "Landroid/widget/FrameLayout;", "bottomNavigationContainer", "K1", "shadowTabLayout", "Lcom/google/android/material/tabs/TabLayout;", "L1", "Lcom/google/android/material/tabs/TabLayout;", "tabLayout", "M1", "Landroid/widget/TextView;", "chatBadgeTextView", "N1", "storyBadgeView", "O1", "moreBadgeView", "P1", "myBankBadgeView", "Q1", "myAiBadgeView", "R1", "isShowingSuggestDialogBefore", "S1", "shouldCalculateTabSelectionForFirstTime", "U1", "isInGoldenTimeForCountTabClick", "Lir/nasim/features/root/RootActivity;", "V1", "Lir/nasim/features/root/RootActivity;", "parent", "W1", "currentDefaultTab", "Lir/nasim/r46;", "Lir/nasim/r46;", "rootFragmentTheme", "Y1", "isFromNotifications", "Lir/nasim/Ka2;", "Lir/nasim/Ka2;", "eventBarViewHandler", "Lir/nasim/n10;", "a2", "Lir/nasim/n10;", "baleSnackBar", "b2", "deleteChatSnackBar", "Lir/nasim/Bk5;", "c2", "Lir/nasim/Bk5;", "jaryanAndroidProperties", "d2", "Landroidx/compose/ui/platform/ComposeView;", "composeView", "Lir/nasim/dQ0;", "e2", "Lir/nasim/dQ0;", "Yb", "()Lir/nasim/dQ0;", "setChatNavigator", "(Lir/nasim/dQ0;)V", "chatNavigator", "Lir/nasim/Sg3;", "f2", "Lir/nasim/Sg3;", "ec", "()Lir/nasim/Sg3;", "setJaryanNavigator", "(Lir/nasim/Sg3;)V", "jaryanNavigator", "Lir/nasim/lt6;", "g2", "Lir/nasim/lt6;", "hc", "()Lir/nasim/lt6;", "setServicesNavigator", "(Lir/nasim/lt6;)V", "servicesNavigator", "Lir/nasim/aO2;", "h2", "Lir/nasim/aO2;", "dc", "()Lir/nasim/aO2;", "setGroupTypeMakerNavigator", "(Lir/nasim/aO2;)V", "groupTypeMakerNavigator", "Lir/nasim/uv6;", "i2", "Lir/nasim/uv6;", "getSettingNavigator", "()Lir/nasim/uv6;", "setSettingNavigator", "(Lir/nasim/uv6;)V", "settingNavigator", "Lir/nasim/FD7;", "j2", "Lir/nasim/FD7;", "nc", "()Lir/nasim/FD7;", "setUpdateGateway", "(Lir/nasim/FD7;)V", "updateGateway", "Lir/nasim/Qy2;", "k2", "cc", "()Lir/nasim/Qy2;", "fragmentOnAttachListener", "Lir/nasim/wt4;", "l2", "Lir/nasim/wt4;", "bc", "()Lir/nasim/wt4;", "setDialogListNavigator", "(Lir/nasim/wt4;)V", "dialogListNavigator", "m2", "Ljava/util/ArrayList;", "requestPermissionsResultListeners", "Lkotlin/Function0;", "n2", "Lir/nasim/SA2;", "onServicesBalloonClick", "Zb", "()I", "correctCurrentDefaultTab", "Lir/nasim/features/share/ShareData;", "lc", "()Lir/nasim/features/share/ShareData;", "shareData", "wc", "isLastFragment", "o2", "Lir/nasim/features/root/H;", "viewState", "showBottomSheet", "Lir/nasim/features/eventbar/data/model/EventBarData;", "evenBarUiState", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.features.root.h, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C13090h extends EX2 implements InterfaceC14538i46, C15225jD4.b, C5598Ka2.c, C5598Ka2.d, C5598Ka2.b {

    /* renamed from: o2, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int p2 = 8;
    private static final int q2;
    private static final int r2;
    private static final int s2;
    private static final int t2;
    private static boolean u2;

    /* renamed from: A1, reason: from kotlin metadata */
    private FragmentManager rootSupportFragmentManager;

    /* renamed from: B1, reason: from kotlin metadata */
    private Fragment activeFragment;

    /* renamed from: C1, reason: from kotlin metadata */
    private int lastSelectedPageIndex;

    /* renamed from: F1, reason: from kotlin metadata */
    private Integer[] tabIconsSelected;

    /* renamed from: G1, reason: from kotlin metadata */
    private Integer[] tabIcons;

    /* renamed from: J1, reason: from kotlin metadata */
    private FrameLayout bottomNavigationContainer;

    /* renamed from: K1, reason: from kotlin metadata */
    private FrameLayout shadowTabLayout;

    /* renamed from: L1, reason: from kotlin metadata */
    private TabLayout tabLayout;

    /* renamed from: M1, reason: from kotlin metadata */
    private TextView chatBadgeTextView;

    /* renamed from: N1, reason: from kotlin metadata */
    private TextView storyBadgeView;

    /* renamed from: O1, reason: from kotlin metadata */
    private TextView moreBadgeView;

    /* renamed from: P1, reason: from kotlin metadata */
    private TextView myBankBadgeView;

    /* renamed from: Q1, reason: from kotlin metadata */
    private TextView myAiBadgeView;

    /* renamed from: R1, reason: from kotlin metadata */
    private boolean isShowingSuggestDialogBefore;

    /* renamed from: V1, reason: from kotlin metadata */
    private RootActivity parent;

    /* renamed from: W1, reason: from kotlin metadata */
    private int currentDefaultTab;

    /* renamed from: X1, reason: from kotlin metadata */
    private InterfaceC19868r46 rootFragmentTheme;

    /* renamed from: Y1, reason: from kotlin metadata */
    private boolean isFromNotifications;

    /* renamed from: Z1, reason: from kotlin metadata */
    private C5598Ka2 eventBarViewHandler;

    /* renamed from: a2, reason: from kotlin metadata */
    private C17468n10 baleSnackBar;

    /* renamed from: b2, reason: from kotlin metadata */
    private C17468n10 deleteChatSnackBar;

    /* renamed from: c2, reason: from kotlin metadata */
    private final InterfaceC3570Bk5 jaryanAndroidProperties;

    /* renamed from: d2, reason: from kotlin metadata */
    private ComposeView composeView;

    /* renamed from: e2, reason: from kotlin metadata */
    public InterfaceC11677dQ0 chatNavigator;

    /* renamed from: f2, reason: from kotlin metadata */
    public InterfaceC7565Sg3 jaryanNavigator;

    /* renamed from: g2, reason: from kotlin metadata */
    public InterfaceC16806lt6 servicesNavigator;

    /* renamed from: h2, reason: from kotlin metadata */
    public InterfaceC9687aO2 groupTypeMakerNavigator;

    /* renamed from: i2, reason: from kotlin metadata */
    public InterfaceC22258uv6 settingNavigator;

    /* renamed from: j2, reason: from kotlin metadata */
    public FD7 updateGateway;

    /* renamed from: k1, reason: from kotlin metadata */
    private boolean isSharingDialogSelected;

    /* renamed from: k2, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 fragmentOnAttachListener;

    /* renamed from: l2, reason: from kotlin metadata */
    public InterfaceC23422wt4 dialogListNavigator;

    /* renamed from: m1, reason: from kotlin metadata */
    private C11458d25 currentPeer;

    /* renamed from: m2, reason: from kotlin metadata */
    private final ArrayList requestPermissionsResultListeners;

    /* renamed from: n1, reason: from kotlin metadata */
    private String sendText;

    /* renamed from: n2, reason: from kotlin metadata */
    private final SA2 onServicesBalloonClick;

    /* renamed from: o1, reason: from kotlin metadata */
    private String sendUriString;

    /* renamed from: p1, reason: from kotlin metadata */
    private List sendUriMultiple;

    /* renamed from: q1, reason: from kotlin metadata */
    private String sendMimeType;

    /* renamed from: r1, reason: from kotlin metadata */
    private String peerIdDirectShare;

    /* renamed from: s1, reason: from kotlin metadata */
    private C11458d25 pendingPeer;

    /* renamed from: t1, reason: from kotlin metadata */
    private String pendingMessage;

    /* renamed from: u1, reason: from kotlin metadata */
    private G presenter;

    /* renamed from: w1, reason: from kotlin metadata */
    private Fragment dialogsContainerFragment;

    /* renamed from: x1, reason: from kotlin metadata */
    private InterfaceC17936no4 myBankFragmentPageInterface;

    /* renamed from: y1, reason: from kotlin metadata */
    private C22042ua0 jaryanFragment;

    /* renamed from: z1, reason: from kotlin metadata */
    private ir.nasim.features.bank.mybank.webview.a aiChatFragment;

    /* renamed from: l1, reason: from kotlin metadata */
    private AbstractC13089g.b dialogsMode = AbstractC13089g.b.a;

    /* renamed from: v1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(I.class), new x(this), new y(null, this), new z(this));

    /* renamed from: D1, reason: from kotlin metadata */
    private int tabActiveColor = -1;

    /* renamed from: E1, reason: from kotlin metadata */
    private int tabDisableColor = -1;

    /* renamed from: H1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 isAiTabEnabled = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.T36
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return Boolean.valueOf(C13090h.vc());
        }
    });

    /* renamed from: I1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 tabTitles = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.U36
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C13090h.Nd(this.a);
        }
    });

    /* renamed from: S1, reason: from kotlin metadata */
    private boolean shouldCalculateTabSelectionForFirstTime = true;

    /* renamed from: U1, reason: from kotlin metadata */
    private boolean isInGoldenTimeForCountTabClick = true;

    /* renamed from: ir.nasim.features.root.h$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final int a() {
            return C13090h.r2;
        }

        public final int b() {
            return C13090h.s2;
        }

        public final int c() {
            return C13090h.t2;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.features.root.h$b */
    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ int a;
        final /* synthetic */ AbstractC13083a.c b;

        b(int i, AbstractC13083a.c cVar) {
            this.a = i;
            this.b = cVar;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13083a.c cVar;
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            C24254yJ.f fVarO = C24254yJ.a.o(C17784nZ1.q(-10.0f));
            InterfaceC12529em.a aVar = InterfaceC12529em.a;
            InterfaceC12529em.c cVarI = aVar.i();
            int i2 = this.a;
            AbstractC13083a.c cVar2 = this.b;
            e.a aVar2 = androidx.compose.ui.e.a;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(fVarO, cVarI, interfaceC22053ub1, 48);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, aVar2);
            InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar3.a();
            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1.G();
            if (interfaceC22053ub1.h()) {
                interfaceC22053ub1.g(sa2A);
            } else {
                interfaceC22053ub1.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            M66 m66 = M66.a;
            interfaceC22053ub1.W(-1125705211);
            if (i2 > 0) {
                G10 g10 = G10.a;
                int i3 = G10.b;
                androidx.compose.ui.e eVarF = AbstractC9287Zh0.f(androidx.compose.foundation.layout.t.t(androidx.compose.foundation.b.c(aVar2, g10.a(interfaceC22053ub1, i3).B(), N46.g()), C17784nZ1.q(32.0f)), C17784nZ1.q(2.0f), g10.a(interfaceC22053ub1, i3).D(), N46.g());
                InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar.e(), false);
                int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarF);
                SA2 sa2A2 = aVar3.a();
                if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1.G();
                if (interfaceC22053ub1.h()) {
                    interfaceC22053ub1.g(sa2A2);
                } else {
                    interfaceC22053ub1.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A2 = DG7.a(interfaceC22053ub1);
                DG7.c(interfaceC22053ub1A2, interfaceC10970cW3G, aVar3.e());
                DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar3.g());
                InterfaceC14603iB2 interfaceC14603iB2B2 = aVar3.b();
                if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                    interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                    interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
                }
                DG7.c(interfaceC22053ub1A2, eVarE2, aVar3.f());
                androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
                cVar = cVar2;
                AbstractC9339Zm7.b(XY6.v("+" + i2), null, g10.a(interfaceC22053ub1, i3).G(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i3).m(), interfaceC22053ub1, 0, 0, 65530);
                interfaceC22053ub1.u();
            } else {
                cVar = cVar2;
            }
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-1125679261);
            for (R14 r14 : AbstractC15401jX0.T0(cVar.g())) {
                e.a aVar4 = androidx.compose.ui.e.a;
                androidx.compose.ui.e eVarC = androidx.compose.foundation.b.c(aVar4, G10.a.a(interfaceC22053ub1, G10.b).M(), N46.g());
                InterfaceC10970cW3 interfaceC10970cW3G2 = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.o(), false);
                int iA3 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q3 = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarC);
                InterfaceC16030kb1.a aVar5 = InterfaceC16030kb1.d0;
                SA2 sa2A3 = aVar5.a();
                if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1.G();
                if (interfaceC22053ub1.h()) {
                    interfaceC22053ub1.g(sa2A3);
                } else {
                    interfaceC22053ub1.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A3 = DG7.a(interfaceC22053ub1);
                DG7.c(interfaceC22053ub1A3, interfaceC10970cW3G2, aVar5.e());
                DG7.c(interfaceC22053ub1A3, interfaceC11819dc1Q3, aVar5.g());
                InterfaceC14603iB2 interfaceC14603iB2B3 = aVar5.b();
                if (interfaceC22053ub1A3.h() || !AbstractC13042fc3.d(interfaceC22053ub1A3.B(), Integer.valueOf(iA3))) {
                    interfaceC22053ub1A3.s(Integer.valueOf(iA3));
                    interfaceC22053ub1A3.v(Integer.valueOf(iA3), interfaceC14603iB2B3);
                }
                DG7.c(interfaceC22053ub1A3, eVarE3, aVar5.f());
                androidx.compose.foundation.layout.h hVar2 = androidx.compose.foundation.layout.h.a;
                AbstractC11456d23.b(AvatarAsyncImagePainterKt.h(r14.a(), null, false, 0, interfaceC22053ub1, 0, 14), null, AbstractC9747aV.k(FV0.a(androidx.compose.foundation.layout.t.t(androidx.compose.foundation.layout.q.i(aVar4, C17784nZ1.q(2.0f)), C17784nZ1.q(32.0f)), N46.g()), r14.b(), r14.c(), 0.0f, false, null, 28, null), null, null, 0.0f, null, interfaceC22053ub1, 48, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
                interfaceC22053ub1.u();
            }
            interfaceC22053ub1.Q();
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.features.root.h$c */
    static final class c implements InterfaceC14603iB2 {
        final /* synthetic */ C19818qz6 b;
        final /* synthetic */ InterfaceC9102Ym4 c;
        final /* synthetic */ AbstractC13083a.c d;
        final /* synthetic */ InterfaceC20315ro1 e;

        /* renamed from: ir.nasim.features.root.h$c$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C13090h a;
            final /* synthetic */ C19818qz6 b;
            final /* synthetic */ InterfaceC9102Ym4 c;
            final /* synthetic */ AbstractC13083a.c d;
            final /* synthetic */ InterfaceC20315ro1 e;

            /* renamed from: ir.nasim.features.root.h$c$a$a, reason: collision with other inner class name */
            static final class C1215a implements InterfaceC14603iB2 {
                public static final C1215a a = new C1215a();

                C1215a() {
                }

                public final A98 a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    interfaceC22053ub1.W(-728950188);
                    A98 a98A = AbstractC21393ta8.a(0, 0, 0, 0);
                    interfaceC22053ub1.Q();
                    return a98A;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                }
            }

            /* renamed from: ir.nasim.features.root.h$c$a$b */
            static final class b implements InterfaceC15796kB2 {
                final /* synthetic */ C13090h a;
                final /* synthetic */ AbstractC13083a.c b;
                final /* synthetic */ InterfaceC20315ro1 c;
                final /* synthetic */ C19818qz6 d;
                final /* synthetic */ InterfaceC9102Ym4 e;

                /* renamed from: ir.nasim.features.root.h$c$a$b$a, reason: collision with other inner class name */
                static final class C1216a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    final /* synthetic */ C19818qz6 c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C1216a(C19818qz6 c19818qz6, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.c = c19818qz6;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        return new C1216a(this.c, interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        Object objE = AbstractC14862ic3.e();
                        int i = this.b;
                        if (i == 0) {
                            AbstractC10685c16.b(obj);
                            C19818qz6 c19818qz6 = this.c;
                            this.b = 1;
                            if (c19818qz6.j(this) == objE) {
                                return objE;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            AbstractC10685c16.b(obj);
                        }
                        return C19938rB7.a;
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    /* renamed from: n, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                        return ((C1216a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* renamed from: ir.nasim.features.root.h$c$a$b$b, reason: collision with other inner class name */
                static final class C1217b extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    final /* synthetic */ C19818qz6 c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C1217b(C19818qz6 c19818qz6, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.c = c19818qz6;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        return new C1217b(this.c, interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        Object objE = AbstractC14862ic3.e();
                        int i = this.b;
                        if (i == 0) {
                            AbstractC10685c16.b(obj);
                            C19818qz6 c19818qz6 = this.c;
                            this.b = 1;
                            if (c19818qz6.j(this) == objE) {
                                return objE;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            AbstractC10685c16.b(obj);
                        }
                        return C19938rB7.a;
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    /* renamed from: n, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                        return ((C1217b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* renamed from: ir.nasim.features.root.h$c$a$b$c, reason: collision with other inner class name */
                static final class C1218c extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    final /* synthetic */ C19818qz6 c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C1218c(C19818qz6 c19818qz6, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.c = c19818qz6;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        return new C1218c(this.c, interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        Object objE = AbstractC14862ic3.e();
                        int i = this.b;
                        if (i == 0) {
                            AbstractC10685c16.b(obj);
                            C19818qz6 c19818qz6 = this.c;
                            this.b = 1;
                            if (c19818qz6.j(this) == objE) {
                                return objE;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            AbstractC10685c16.b(obj);
                        }
                        return C19938rB7.a;
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    /* renamed from: n, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                        return ((C1218c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                b(C13090h c13090h, AbstractC13083a.c cVar, InterfaceC20315ro1 interfaceC20315ro1, C19818qz6 c19818qz6, InterfaceC9102Ym4 interfaceC9102Ym4) {
                    this.a = c13090h;
                    this.b = cVar;
                    this.c = interfaceC20315ro1;
                    this.d = c19818qz6;
                    this.e = interfaceC9102Ym4;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 k(final C13090h c13090h, final AbstractC13083a.c cVar, final InterfaceC20315ro1 interfaceC20315ro1, final C19818qz6 c19818qz6, final InterfaceC9102Ym4 interfaceC9102Ym4) {
                    AbstractC13042fc3.i(c13090h, "this$0");
                    AbstractC13042fc3.i(cVar, "$groupPreviewModel");
                    AbstractC13042fc3.i(interfaceC20315ro1, "$scope");
                    AbstractC13042fc3.i(c19818qz6, "$sheetState");
                    AbstractC13042fc3.i(interfaceC9102Ym4, "$showBottomSheet$delegate");
                    c13090h.oc().e2(cVar.i(), new UA2() { // from class: ir.nasim.features.root.m
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C13090h.c.a.b.n(c13090h, cVar, interfaceC20315ro1, c19818qz6, interfaceC9102Ym4, (C9475a16) obj);
                        }
                    });
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 n(final C13090h c13090h, AbstractC13083a.c cVar, InterfaceC20315ro1 interfaceC20315ro1, final C19818qz6 c19818qz6, final InterfaceC9102Ym4 interfaceC9102Ym4, C9475a16 c9475a16) {
                    AbstractC13042fc3.i(c13090h, "this$0");
                    AbstractC13042fc3.i(cVar, "$groupPreviewModel");
                    AbstractC13042fc3.i(interfaceC20315ro1, "$scope");
                    AbstractC13042fc3.i(c19818qz6, "$sheetState");
                    AbstractC13042fc3.i(interfaceC9102Ym4, "$showBottomSheet$delegate");
                    Object objL = c9475a16.l();
                    Throwable thE = C9475a16.e(objL);
                    if (thE != null) {
                        c13090h.Jd(UN2.a(thE instanceof RpcException ? (Exception) thE : new Exception(thE), cVar.d()));
                        AbstractC10533bm0.d(interfaceC20315ro1, null, null, new C1217b(c19818qz6, null), 3, null).s(new UA2() { // from class: ir.nasim.features.root.n
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return C13090h.c.a.b.o(c19818qz6, c13090h, interfaceC9102Ym4, (Throwable) obj);
                            }
                        });
                    }
                    if (C9475a16.j(objL)) {
                        int iIntValue = ((Number) objL).intValue();
                        C3343Am.i("Group_join_source", AbstractC20051rO3.p(AbstractC4616Fw7.a("user_id", Integer.valueOf(AbstractC5969Lp4.f())), AbstractC4616Fw7.a("date", Long.valueOf(System.currentTimeMillis())), AbstractC4616Fw7.a("peer_id", Integer.valueOf(C11458d25.y(iIntValue).getPeerId())), AbstractC4616Fw7.a("peer_type", Integer.valueOf(W25.b.ordinal() + 1)), AbstractC4616Fw7.a("event_type", "dialogue"), AbstractC4616Fw7.a("action_type", "link")));
                        C18987pb3 c18987pb3 = C18987pb3.a;
                        C11458d25 c11458d25Y = C11458d25.y(iIntValue);
                        AbstractC13042fc3.h(c11458d25Y, "group(...)");
                        C18987pb3.x1(c18987pb3, c11458d25Y, null, null, false, null, null, false, null, null, false, null, 2046, null);
                        AbstractC10533bm0.d(interfaceC20315ro1, null, null, new C1218c(c19818qz6, null), 3, null).s(new UA2() { // from class: ir.nasim.features.root.o
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return C13090h.c.a.b.p(c19818qz6, c13090h, interfaceC9102Ym4, (Throwable) obj);
                            }
                        });
                    }
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 o(C19818qz6 c19818qz6, C13090h c13090h, InterfaceC9102Ym4 interfaceC9102Ym4, Throwable th) {
                    AbstractC13042fc3.i(c19818qz6, "$sheetState");
                    AbstractC13042fc3.i(c13090h, "this$0");
                    AbstractC13042fc3.i(interfaceC9102Ym4, "$showBottomSheet$delegate");
                    if (!c19818qz6.k()) {
                        ComposeView composeView = c13090h.composeView;
                        if (composeView != null) {
                            c13090h.Sb(composeView);
                        }
                        C13090h.gb(interfaceC9102Ym4, false);
                        c13090h.oc().A2();
                    }
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 p(C19818qz6 c19818qz6, C13090h c13090h, InterfaceC9102Ym4 interfaceC9102Ym4, Throwable th) {
                    AbstractC13042fc3.i(c19818qz6, "$sheetState");
                    AbstractC13042fc3.i(c13090h, "this$0");
                    AbstractC13042fc3.i(interfaceC9102Ym4, "$showBottomSheet$delegate");
                    if (!c19818qz6.k()) {
                        ComposeView composeView = c13090h.composeView;
                        if (composeView != null) {
                            c13090h.Sb(composeView);
                        }
                        C13090h.gb(interfaceC9102Ym4, false);
                        c13090h.oc().A2();
                    }
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 t(InterfaceC20315ro1 interfaceC20315ro1, final C19818qz6 c19818qz6, final C13090h c13090h, final InterfaceC9102Ym4 interfaceC9102Ym4) {
                    AbstractC13042fc3.i(interfaceC20315ro1, "$scope");
                    AbstractC13042fc3.i(c19818qz6, "$sheetState");
                    AbstractC13042fc3.i(c13090h, "this$0");
                    AbstractC13042fc3.i(interfaceC9102Ym4, "$showBottomSheet$delegate");
                    AbstractC10533bm0.d(interfaceC20315ro1, null, null, new C1216a(c19818qz6, null), 3, null).s(new UA2() { // from class: ir.nasim.features.root.l
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C13090h.c.a.b.v(c19818qz6, c13090h, interfaceC9102Ym4, (Throwable) obj);
                        }
                    });
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 v(C19818qz6 c19818qz6, C13090h c13090h, InterfaceC9102Ym4 interfaceC9102Ym4, Throwable th) {
                    AbstractC13042fc3.i(c19818qz6, "$sheetState");
                    AbstractC13042fc3.i(c13090h, "this$0");
                    AbstractC13042fc3.i(interfaceC9102Ym4, "$showBottomSheet$delegate");
                    if (!c19818qz6.k()) {
                        ComposeView composeView = c13090h.composeView;
                        if (composeView != null) {
                            c13090h.Sb(composeView);
                        }
                        C13090h.gb(interfaceC9102Ym4, false);
                        c13090h.oc().A2();
                    }
                    return C19938rB7.a;
                }

                /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
                    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r3v20 ??, still in use, count: 1, list:
                      (r3v20 ?? I:java.lang.Object) from 0x034f: INVOKE (r47v0 ?? I:ir.nasim.ub1), (r3v20 ?? I:java.lang.Object) INTERFACE call: ir.nasim.ub1.s(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:848)
                    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
                    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
                    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
                    	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
                    	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
                    	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
                    */
                public final void i(
                /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
                    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r3v20 ??, still in use, count: 1, list:
                      (r3v20 ?? I:java.lang.Object) from 0x034f: INVOKE (r47v0 ?? I:ir.nasim.ub1), (r3v20 ?? I:java.lang.Object) INTERFACE call: ir.nasim.ub1.s(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:848)
                    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
                    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
                    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
                    	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
                    	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
                    */
                /*  JADX ERROR: Method generation error
                    jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r46v0 ??
                    	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
                    	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
                    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:405)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                    */

                @Override // ir.nasim.InterfaceC15796kB2
                public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                    i((ZY0) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                    return C19938rB7.a;
                }
            }

            a(C13090h c13090h, C19818qz6 c19818qz6, InterfaceC9102Ym4 interfaceC9102Ym4, AbstractC13083a.c cVar, InterfaceC20315ro1 interfaceC20315ro1) {
                this.a = c13090h;
                this.b = c19818qz6;
                this.c = interfaceC9102Ym4;
                this.d = cVar;
                this.e = interfaceC20315ro1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 c(C13090h c13090h, InterfaceC9102Ym4 interfaceC9102Ym4) {
                AbstractC13042fc3.i(c13090h, "this$0");
                AbstractC13042fc3.i(interfaceC9102Ym4, "$showBottomSheet$delegate");
                ComposeView composeView = c13090h.composeView;
                if (composeView != null) {
                    c13090h.Sb(composeView);
                }
                C13090h.gb(interfaceC9102Ym4, false);
                ComposeView composeView2 = c13090h.composeView;
                if (composeView2 != null) {
                    composeView2.setVisibility(8);
                }
                c13090h.oc().A2();
                return C19938rB7.a;
            }

            public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null);
                long jM = G10.a.a(interfaceC22053ub1, G10.b).M();
                interfaceC22053ub1.W(1302271326);
                boolean zD = interfaceC22053ub1.D(this.a);
                final C13090h c13090h = this.a;
                final InterfaceC9102Ym4 interfaceC9102Ym4 = this.c;
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.features.root.i
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C13090h.c.a.c(c13090h, interfaceC9102Ym4);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                C19818qz6 c19818qz6 = this.b;
                AbstractC9273Zf4.a((SA2) objB, eVarH, c19818qz6, 0.0f, null, jM, 0L, 0.0f, 0L, null, C1215a.a, null, AbstractC19242q11.e(2136532360, true, new b(this.a, this.d, this.e, c19818qz6, this.c), interfaceC22053ub1, 54), interfaceC22053ub1, 805306416, 384, 2520);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        c(C19818qz6 c19818qz6, InterfaceC9102Ym4 interfaceC9102Ym4, AbstractC13083a.c cVar, InterfaceC20315ro1 interfaceC20315ro1) {
            this.b = c19818qz6;
            this.c = interfaceC9102Ym4;
            this.d = cVar;
            this.e = interfaceC20315ro1;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                F27.a(null, null, 0L, 0L, 0.0f, 0.0f, null, AbstractC19242q11.e(-74811797, true, new a(C13090h.this, this.b, this.c, this.d, this.e), interfaceC22053ub1, 54), interfaceC22053ub1, 12582912, 127);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.features.root.h$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.features.root.h$d$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C13090h d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C13090h c13090h, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c13090h;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                GD7 gd7 = (GD7) this.c;
                C13090h c13090h = this.d;
                String strC = gd7.c();
                String strB = gd7.b();
                AbstractC10026ax1 abstractC10026ax1A = gd7.a();
                if (abstractC10026ax1A == null) {
                    abstractC10026ax1A = AbstractC10026ax1.a.a;
                }
                c13090h.Gd(strC, strB, abstractC10026ax1A);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(GD7 gd7, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(gd7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.features.root.h$d$b */
        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.features.root.h$d$b$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.features.root.h$d$b$a$a, reason: collision with other inner class name */
                public static final class C1219a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C1219a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r6, ir.nasim.InterfaceC20295rm1 r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof ir.nasim.features.root.C13090h.d.b.a.C1219a
                        if (r0 == 0) goto L13
                        r0 = r7
                        ir.nasim.features.root.h$d$b$a$a r0 = (ir.nasim.features.root.C13090h.d.b.a.C1219a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.features.root.h$d$b$a$a r0 = new ir.nasim.features.root.h$d$b$a$a
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r7)
                        goto L50
                    L29:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L31:
                        ir.nasim.AbstractC10685c16.b(r7)
                        ir.nasim.Gq2 r7 = r5.a
                        r2 = r6
                        ir.nasim.GD7 r2 = (ir.nasim.GD7) r2
                        ir.nasim.ax1 r4 = r2.a()
                        if (r4 == 0) goto L50
                        ir.nasim.ax1 r2 = r2.a()
                        boolean r2 = r2 instanceof ir.nasim.AbstractC10026ax1.c
                        if (r2 != 0) goto L50
                        r0.b = r3
                        java.lang.Object r6 = r7.a(r6, r0)
                        if (r6 != r1) goto L50
                        return r1
                    L50:
                        ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.root.C13090h.d.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.features.root.h$d$c */
        public static final class c implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.features.root.h$d$c$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.features.root.h$d$c$a$a, reason: collision with other inner class name */
                public static final class C1220a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C1220a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof ir.nasim.features.root.C13090h.d.c.a.C1220a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.features.root.h$d$c$a$a r0 = (ir.nasim.features.root.C13090h.d.c.a.C1220a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.features.root.h$d$c$a$a r0 = new ir.nasim.features.root.h$d$c$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L43
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.Gq2 r6 = r4.a
                        boolean r2 = r5 instanceof ir.nasim.GD7
                        if (r2 == 0) goto L43
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L43
                        return r1
                    L43:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.root.C13090h.d.c.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public c(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C13090h.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                b bVar = new b(new c(C13090h.this.nc().c()));
                a aVar = new a(C13090h.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(bVar, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.features.root.h$e */
    public static final class e implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.features.root.h$e$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.features.root.h$e$a$a, reason: collision with other inner class name */
            public static final class C1221a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1221a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                this.a = interfaceC4806Gq2;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof ir.nasim.features.root.C13090h.e.a.C1221a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.features.root.h$e$a$a r0 = (ir.nasim.features.root.C13090h.e.a.C1221a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.features.root.h$e$a$a r0 = new ir.nasim.features.root.h$e$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L43
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Gq2 r6 = r4.a
                    boolean r2 = r5 instanceof ir.nasim.core.modules.file.storage.d.a
                    if (r2 == 0) goto L43
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L43
                    return r1
                L43:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.root.C13090h.e.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public e(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.features.root.h$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C13090h.this.new f(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C13090h.this.Hd();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(d.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(aVar, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.features.root.h$g */
    static final class g extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C13090h.this.Fc(this);
        }
    }

    /* renamed from: ir.nasim.features.root.h$h, reason: collision with other inner class name */
    static final class C1222h implements InterfaceC4806Gq2 {
        C1222h() {
        }

        @Override // ir.nasim.InterfaceC4806Gq2
        public /* bridge */ /* synthetic */ Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return b(((Boolean) obj).booleanValue(), interfaceC20295rm1);
        }

        public final Object b(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            C13090h.this.Vb(z);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.features.root.h$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.features.root.h$i$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C13090h d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C13090h c13090h, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c13090h;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                C20085rS1.f fVar = (C20085rS1.f) this.c;
                if (fVar.b() == ExPeerType.PRIVATE || fVar.b() == ExPeerType.BOT) {
                    C13090h c13090h = this.d;
                    String string = c13090h.S7().getString(AbstractC12217eE5.toast_unable_delete_chat);
                    AbstractC13042fc3.h(string, "getString(...)");
                    c13090h.Jd(string);
                } else {
                    this.d.Jd(UN2.a(fVar.a(), fVar.b() == ExPeerType.GROUP ? ZN2.GROUP : ZN2.CHANNEL));
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C20085rS1.f fVar, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(fVar, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C13090h.this.new i(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10040ay6 interfaceC10040ay6N1 = C13090h.this.oc().N1();
                a aVar = new a(C13090h.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10040ay6N1, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.features.root.h$j */
    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.features.root.h$j$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C13090h c;

            /* renamed from: ir.nasim.features.root.h$j$a$a, reason: collision with other inner class name */
            static final class C1223a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ C13090h d;

                /* renamed from: ir.nasim.features.root.h$j$a$a$a, reason: collision with other inner class name */
                static final class C1224a implements InterfaceC14603iB2 {
                    final /* synthetic */ C13090h a;
                    final /* synthetic */ AbstractC13083a b;

                    C1224a(C13090h c13090h, AbstractC13083a abstractC13083a) {
                        this.a = c13090h;
                        this.b = abstractC13083a;
                    }

                    public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                            interfaceC22053ub1.L();
                        } else {
                            this.a.eb((AbstractC13083a.c) this.b, interfaceC22053ub1, 0);
                        }
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.features.root.h$j$a$a$b */
                public /* synthetic */ class b {
                    public static final /* synthetic */ int[] a;

                    static {
                        int[] iArr = new int[EnumC16477lL2.values().length];
                        try {
                            iArr[EnumC16477lL2.b.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[EnumC16477lL2.c.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        try {
                            iArr[EnumC16477lL2.d.ordinal()] = 3;
                        } catch (NoSuchFieldError unused3) {
                        }
                        a = iArr;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1223a(C13090h c13090h, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = c13090h;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 y(C13090h c13090h, AbstractC13083a abstractC13083a, C9475a16 c9475a16) {
                    Object objL = c9475a16.l();
                    Throwable thE = C9475a16.e(objL);
                    if (thE != null) {
                        c13090h.Jd(UN2.a(thE instanceof RpcException ? (Exception) thE : new Exception(thE), ((AbstractC13083a.c) abstractC13083a).d()));
                    }
                    if (C9475a16.j(objL)) {
                        int iIntValue = ((Number) objL).intValue();
                        C3343Am.i("Group_join_source", AbstractC20051rO3.p(AbstractC4616Fw7.a("user_id", Integer.valueOf(AbstractC5969Lp4.f())), AbstractC4616Fw7.a("date", Long.valueOf(System.currentTimeMillis())), AbstractC4616Fw7.a("peer_id", Integer.valueOf(C11458d25.y(iIntValue).getPeerId())), AbstractC4616Fw7.a("peer_type", Integer.valueOf(W25.b.ordinal() + 1)), AbstractC4616Fw7.a("event_type", "dialogue"), AbstractC4616Fw7.a("action_type", "link")));
                        C18987pb3 c18987pb3 = C18987pb3.a;
                        C11458d25 c11458d25Y = C11458d25.y(iIntValue);
                        AbstractC13042fc3.h(c11458d25Y, "group(...)");
                        C18987pb3.x1(c18987pb3, c11458d25Y, null, null, false, null, null, false, null, null, false, null, 2046, null);
                    }
                    return C19938rB7.a;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C1223a c1223a = new C1223a(this.d, interfaceC20295rm1);
                    c1223a.c = obj;
                    return c1223a;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    final AbstractC13083a abstractC13083a = (AbstractC13083a) this.c;
                    if (abstractC13083a instanceof AbstractC13083a.C1214a) {
                        C13090h c13090h = this.d;
                        String strH6 = c13090h.h6(AbstractC12217eE5.error_unknown);
                        AbstractC13042fc3.h(strH6, "getString(...)");
                        c13090h.Jd(strH6);
                    } else if (abstractC13083a instanceof AbstractC13083a.c) {
                        AbstractC13083a.c cVar = (AbstractC13083a.c) abstractC13083a;
                        int i = b.a[cVar.a().ordinal()];
                        if (i == 1) {
                            this.d.oc().C2(cVar.e());
                        } else if (i == 2) {
                            I iOc = this.d.oc();
                            String strI = cVar.i();
                            final C13090h c13090h2 = this.d;
                            iOc.e2(strI, new UA2() { // from class: ir.nasim.features.root.p
                                @Override // ir.nasim.UA2
                                public final Object invoke(Object obj2) {
                                    return C13090h.j.a.C1223a.y(c13090h2, abstractC13083a, (C9475a16) obj2);
                                }
                            });
                        } else {
                            if (i != 3) {
                                throw new NoWhenBranchMatchedException();
                            }
                            ComposeView composeView = this.d.composeView;
                            if (composeView != null) {
                                composeView.setVisibility(0);
                            }
                            ComposeView composeView2 = this.d.composeView;
                            if (composeView2 != null) {
                                composeView2.g();
                            }
                            ComposeView composeView3 = this.d.composeView;
                            if (composeView3 != null) {
                                composeView3.setContent(AbstractC19242q11.c(1526083266, true, new C1224a(this.d, abstractC13083a)));
                            }
                        }
                    }
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: w, reason: merged with bridge method [inline-methods] */
                public final Object invoke(AbstractC13083a abstractC13083a, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C1223a) create(abstractC13083a, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C13090h c13090h, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c13090h;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC10258bL6 interfaceC10258bL6Q1 = this.c.oc().Q1();
                    C1223a c1223a = new C1223a(this.c, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC10258bL6Q1, c1223a, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        j(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C13090h.this.new j(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C13090h c13090h = C13090h.this;
                j.b bVar = j.b.STARTED;
                a aVar = new a(c13090h, null);
                this.b = 1;
                if (androidx.lifecycle.w.b(c13090h, bVar, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.features.root.h$k */
    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.features.root.h$k$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C13090h c;

            /* renamed from: ir.nasim.features.root.h$k$a$a, reason: collision with other inner class name */
            static final class C1225a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ C13090h d;

                /* renamed from: ir.nasim.features.root.h$k$a$a$a, reason: collision with other inner class name */
                static final class C1226a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    /* synthetic */ Object c;
                    final /* synthetic */ C13090h d;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C1226a(C13090h c13090h, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.d = c13090h;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        C1226a c1226a = new C1226a(this.d, interfaceC20295rm1);
                        c1226a.c = obj;
                        return c1226a;
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        AbstractC14862ic3.e();
                        if (this.b != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        List<AbstractC22884vz0> list = (List) this.c;
                        C13090h c13090h = this.d;
                        for (AbstractC22884vz0 abstractC22884vz0 : list) {
                            AbstractC13042fc3.g(abstractC22884vz0, "null cannot be cast to non-null type ir.nasim.features.call.data.CallToast.Invite");
                            c13090h.qc((AbstractC22884vz0.a) abstractC22884vz0);
                        }
                        return C19938rB7.a;
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    /* renamed from: n, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                        return ((C1226a) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1225a(C13090h c13090h, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = c13090h;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C1225a c1225a = new C1225a(this.d, interfaceC20295rm1);
                    c1225a.c = obj;
                    return c1225a;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        H h = (H) this.c;
                        boolean z = (h.d() == null || h.e() == null) ? false : true;
                        boolean z2 = !this.d.oc().d2();
                        if (z && z2) {
                            C13090h c13090h = this.d;
                            Context contextS7 = c13090h.S7();
                            AbstractC13042fc3.h(contextS7, "requireContext(...)");
                            c13090h.zd(contextS7, h.d(), h.e());
                        }
                        InterfaceC10040ay6 interfaceC10040ay6C = h.c();
                        C1226a c1226a = new C1226a(this.d, null);
                        this.b = 1;
                        if (AbstractC6459Nq2.l(interfaceC10040ay6C, c1226a, this) == objE) {
                            return objE;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                    }
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(H h, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C1225a) create(h, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C13090h c13090h, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c13090h;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC10258bL6 interfaceC10258bL6V1 = this.c.oc().V1();
                    C1225a c1225a = new C1225a(this.c, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC10258bL6V1, c1225a, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C13090h.this.new k(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C13090h c13090h = C13090h.this;
                j.b bVar = j.b.STARTED;
                a aVar = new a(c13090h, null);
                this.b = 1;
                if (androidx.lifecycle.w.b(c13090h, bVar, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.features.root.h$l */
    static final class l extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.features.root.h$l$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ C13090h d;

            /* renamed from: ir.nasim.features.root.h$l$a$a, reason: collision with other inner class name */
            static final class C1227a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C13090h c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1227a(C13090h c13090h, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c13090h;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C1227a(this.c, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        C13090h c13090h = this.c;
                        this.b = 1;
                        if (c13090h.Fc(this) == objE) {
                            return objE;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                    }
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C1227a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C13090h c13090h, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c13090h;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x0059 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:18:0x005a  */
            /* JADX WARN: Removed duplicated region for block: B:21:0x0065  */
            /* JADX WARN: Removed duplicated region for block: B:43:0x00f1  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0071 -> B:42:0x00ee). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00c8 -> B:42:0x00ee). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00d1 -> B:42:0x00ee). Please report as a decompilation issue!!! */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r12) {
                /*
                    Method dump skipped, instructions count: 244
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.root.C13090h.l.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        l(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C13090h.this.new l(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C13090h c13090h = C13090h.this;
                j.b bVar = j.b.STARTED;
                a aVar = new a(c13090h, null);
                this.b = 1;
                if (androidx.lifecycle.w.b(c13090h, bVar, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((l) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.features.root.h$m */
    static final class m extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.features.root.h$m$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C13090h c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C13090h c13090h, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c13090h;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC7565Sg3 interfaceC7565Sg3Ec = this.c.ec();
                    this.b = 1;
                    if (interfaceC7565Sg3Ec.a(this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        m(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C13090h.this.new m(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                AbstractC13778go1 abstractC13778go1B = C12366eV1.b();
                a aVar = new a(C13090h.this, null);
                this.b = 1;
                if (AbstractC9323Zl0.g(abstractC13778go1B, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((m) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.features.root.h$n */
    public static final class n implements G.a {
        final /* synthetic */ C11458d25 b;
        final /* synthetic */ long c;
        final /* synthetic */ String d;

        n(C11458d25 c11458d25, long j, String str) {
            this.b = c11458d25;
            this.c = j;
            this.d = str;
        }

        @Override // ir.nasim.features.root.G.a
        public void a(ExPeerType exPeerType) {
            AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
            Fragment fragmentB = InterfaceC11677dQ0.b(C13090h.this.Yb(), this.b, exPeerType, Long.valueOf(this.c), null, false, null, null, null, null, 1500L, null, null, this.d, false, null, null, null, null, null, false, null, null, null, null, null, false, null, 134209536, null);
            C13090h.this.ka(this.b);
            C13090h.this.qa(true);
            C22042ua0.A9(C13090h.this, fragmentB, false, null, 6, null);
            C13090h.this.Vc();
        }
    }

    /* renamed from: ir.nasim.features.root.h$o */
    static final class o extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;

        /* renamed from: ir.nasim.features.root.h$o$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C13090h c;
            final /* synthetic */ String d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C13090h c13090h, String str, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c13090h;
                this.d = str;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    I iOc = this.c.oc();
                    String str = this.d;
                    this.b = 1;
                    if (iOc.g2(str, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    ((C9475a16) obj).l();
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y(C13090h c13090h, String str) {
            AbstractC10533bm0.d(AbstractC19224pz3.a(c13090h), null, null, new a(c13090h, str, null), 3, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C13090h.this.new o(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objO1;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                I iOc = C13090h.this.oc();
                String str = this.d;
                this.b = 1;
                objO1 = iOc.O1(str, this);
                if (objO1 == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objO1 = ((C9475a16) obj).l();
            }
            final C13090h c13090h = C13090h.this;
            final String str2 = this.d;
            if (C9475a16.j(objO1)) {
                MeetOuterClass$ResponseGetCallLinkDetails meetOuterClass$ResponseGetCallLinkDetails = (MeetOuterClass$ResponseGetCallLinkDetails) objO1;
                c13090h.oc().u2(new InterfaceC22848vv0.c(0, 1, null), meetOuterClass$ResponseGetCallLinkDetails.getGroupCall().getId());
                if (C8386Vt0.a.b5()) {
                    C22042ua0.w9(c13090h, C16848ly0.INSTANCE.a(meetOuterClass$ResponseGetCallLinkDetails.getGroupCall().getId(), meetOuterClass$ResponseGetCallLinkDetails.getGroupCall().getTitle(), meetOuterClass$ResponseGetCallLinkDetails.getGroupCall().getLink(), meetOuterClass$ResponseGetCallLinkDetails.getGroupCall().getInitiatorUserId(), AbstractC6392Nk0.e(meetOuterClass$ResponseGetCallLinkDetails.getGroupCall().getCreateDate().getValue()), !meetOuterClass$ResponseGetCallLinkDetails.getGroupCall().getIsPublic()), false, null, 6, null);
                } else {
                    C24398yZ c24398yZ = C24398yZ.a;
                    Context contextS7 = c13090h.S7();
                    AbstractC13042fc3.h(contextS7, "requireContext(...)");
                    c24398yZ.d(contextS7, c13090h, AbstractC12217eE5.open_call, AbstractC12217eE5.open_call_description, new SA2() { // from class: ir.nasim.features.root.q
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C13090h.o.y(c13090h, str2);
                        }
                    });
                }
            }
            C13090h c13090h2 = C13090h.this;
            if (C9475a16.e(objO1) != null) {
                String strH6 = c13090h2.h6(AbstractC12217eE5.toast_invalid_call_link);
                AbstractC13042fc3.h(strH6, "getString(...)");
                c13090h2.Jd(strH6);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((o) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.features.root.h$p */
    static final class p extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ boolean c;
        final /* synthetic */ C13090h d;
        final /* synthetic */ long e;
        final /* synthetic */ long f;
        final /* synthetic */ int g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        p(boolean z, C13090h c13090h, long j, long j2, int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = z;
            this.d = c13090h;
            this.e = j;
            this.f = j2;
            this.g = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new p(this.c, this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (this.c) {
                    I iOc = this.d.oc();
                    long j = this.e;
                    long j2 = this.f;
                    int i2 = this.g;
                    this.b = 1;
                    if (iOc.h2(j, j2, i2, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((p) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.features.root.h$q */
    public static final class q implements G.a {
        final /* synthetic */ C11458d25 b;
        final /* synthetic */ Long c;
        final /* synthetic */ Long d;
        final /* synthetic */ boolean e;
        final /* synthetic */ String f;
        final /* synthetic */ String g;
        final /* synthetic */ C11458d25 h;
        final /* synthetic */ Boolean i;
        final /* synthetic */ boolean j;
        final /* synthetic */ EmptyStateOnboardingItemAction k;
        final /* synthetic */ boolean l;

        q(C11458d25 c11458d25, Long l, Long l2, boolean z, String str, String str2, C11458d25 c11458d252, Boolean bool, boolean z2, EmptyStateOnboardingItemAction emptyStateOnboardingItemAction, boolean z3) {
            this.b = c11458d25;
            this.c = l;
            this.d = l2;
            this.e = z;
            this.f = str;
            this.g = str2;
            this.h = c11458d252;
            this.i = bool;
            this.j = z2;
            this.k = emptyStateOnboardingItemAction;
            this.l = z3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(C13090h c13090h, C11458d25 c11458d25, ExPeerType exPeerType, Long l, Long l2, boolean z, String str, String str2, C11458d25 c11458d252, Boolean bool, boolean z2, EmptyStateOnboardingItemAction emptyStateOnboardingItemAction, boolean z3, List list) {
            AbstractC13042fc3.i(c13090h, "this$0");
            AbstractC13042fc3.i(c11458d25, "$peer");
            AbstractC13042fc3.i(exPeerType, "$exPeerType");
            AbstractC13042fc3.i(emptyStateOnboardingItemAction, "$emptyStateOnboardingItemAction");
            C19406qI3.a("RootFragment", "consumeSharedContents() returned: " + list, new Object[0]);
            c13090h.oc().z1(c11458d25.u());
            Fragment fragmentB = InterfaceC11677dQ0.b(c13090h.Yb(), c11458d25, exPeerType, l, l2, z, c13090h.getDialogsMode(), c13090h.lc(), list, str, 0L, null, null, null, str2 != null, str2, null, null, null, null, false, null, null, c11458d252, bool, null, z2, emptyStateOnboardingItemAction, 20946432, null);
            c13090h.ka(c11458d25);
            c13090h.qa(true);
            if (z3) {
                C22042ua0.C9(c13090h, fragmentB, false, null, 6, null);
            } else {
                C22042ua0.A9(c13090h, fragmentB, false, null, 6, null);
            }
            c13090h.Vc();
            return C19938rB7.a;
        }

        @Override // ir.nasim.features.root.G.a
        public void a(final ExPeerType exPeerType) {
            AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
            I iOc = C13090h.this.oc();
            final C13090h c13090h = C13090h.this;
            final C11458d25 c11458d25 = this.b;
            final Long l = this.c;
            final Long l2 = this.d;
            final boolean z = this.e;
            final String str = this.f;
            final String str2 = this.g;
            final C11458d25 c11458d252 = this.h;
            final Boolean bool = this.i;
            final boolean z2 = this.j;
            final EmptyStateOnboardingItemAction emptyStateOnboardingItemAction = this.k;
            final boolean z3 = this.l;
            iOc.B1(new UA2() { // from class: ir.nasim.Y36
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C13090h.q.c(c13090h, c11458d25, exPeerType, l, l2, z, str, str2, c11458d252, bool, z2, emptyStateOnboardingItemAction, z3, (List) obj);
                }
            });
        }
    }

    /* renamed from: ir.nasim.features.root.h$r */
    public static final class r implements TabLayout.d {
        r() {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(TabLayout.g gVar) {
            AbstractC13042fc3.i(gVar, "tab");
            HashMap map = new HashMap();
            if (C13090h.this.uc() && gVar.h() == C13090h.INSTANCE.a()) {
                map.put("tab_title", "nav.ai");
                map.put("tab_num", 6);
            } else {
                map.put("tab_title", String.valueOf(gVar.k()));
                map.put("tab_num", Integer.valueOf(gVar.h() + 1));
            }
            C3343Am.i("navigation_select_tab", map);
            if (C13090h.this.Pc(gVar.h())) {
                return;
            }
            C13090h.this.oc().l2(gVar);
            C13090h.this.Ec(gVar.h());
            C17468n10 c17468n10 = C13090h.this.deleteChatSnackBar;
            if (c17468n10 != null) {
                c17468n10.f();
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(TabLayout.g gVar) {
            AbstractC13042fc3.i(gVar, "tab");
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(TabLayout.g gVar) {
            AbstractC13042fc3.i(gVar, "tab");
            HashMap map = new HashMap();
            if (C13090h.this.uc() && gVar.h() == C13090h.INSTANCE.a()) {
                map.put("tab_title", "nav.ai");
                map.put("tab_num", 6);
            } else {
                map.put("tab_title", String.valueOf(gVar.k()));
                map.put("tab_num", Integer.valueOf(gVar.h() + 1));
            }
            C3343Am.i("navigation_reselect_tab", map);
            if (C13090h.this.Pc(gVar.h())) {
                return;
            }
            if (gVar.h() != 0) {
                if (gVar.h() != 1 || C13090h.this.jaryanFragment == null) {
                    return;
                }
                C15225jD4.b().c(C15225jD4.E, new Object[0]);
                return;
            }
            androidx.lifecycle.h hVar = C13090h.this.dialogsContainerFragment;
            InterfaceC14088hK4 interfaceC14088hK4 = hVar instanceof InterfaceC14088hK4 ? (InterfaceC14088hK4) hVar : null;
            if (interfaceC14088hK4 != null) {
                interfaceC14088hK4.H2();
            }
        }
    }

    /* renamed from: ir.nasim.features.root.h$s */
    static final class s implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.features.root.h$s$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ EventBarData.Enabled a;
            final /* synthetic */ C13090h b;

            a(EventBarData.Enabled enabled, C13090h c13090h) {
                this.a = enabled;
                this.b = c13090h;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 f(C13090h c13090h) {
                AbstractC13042fc3.i(c13090h, "this$0");
                c13090h.oc().X1(InterfaceC4662Ga2.c.a);
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 h(C13090h c13090h) {
                AbstractC13042fc3.i(c13090h, "this$0");
                c13090h.oc().X1(InterfaceC4662Ga2.a.a);
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 i(C13090h c13090h) {
                AbstractC13042fc3.i(c13090h, "this$0");
                c13090h.oc().X1(InterfaceC4662Ga2.b.a);
                return C19938rB7.a;
            }

            public final void d(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                String titleText = this.a.getTitleText();
                String buttonText = this.a.getButtonText();
                C20158ra2 c20158ra2C = AbstractC21387ta2.c(this.a.getColorsSetNumber());
                long expireTimeInMills = this.a.getExpireTimeInMills();
                boolean hasTimer = this.a.getHasTimer();
                boolean z = this.a.getEventBarType() == EventBarData.Enabled.a.b;
                interfaceC22053ub1.W(1236024187);
                boolean zD = interfaceC22053ub1.D(this.b);
                final C13090h c13090h = this.b;
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.features.root.r
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C13090h.s.a.f(c13090h);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                SA2 sa2 = (SA2) objB;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(1236029334);
                boolean zD2 = interfaceC22053ub1.D(this.b);
                final C13090h c13090h2 = this.b;
                Object objB2 = interfaceC22053ub1.B();
                if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new SA2() { // from class: ir.nasim.features.root.s
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C13090h.s.a.h(c13090h2);
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                SA2 sa22 = (SA2) objB2;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(1236034358);
                boolean zD3 = interfaceC22053ub1.D(this.b);
                final C13090h c13090h3 = this.b;
                Object objB3 = interfaceC22053ub1.B();
                if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                    objB3 = new SA2() { // from class: ir.nasim.features.root.t
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C13090h.s.a.i(c13090h3);
                        }
                    };
                    interfaceC22053ub1.s(objB3);
                }
                interfaceC22053ub1.Q();
                AbstractC4179Ea2.f(titleText, buttonText, c20158ra2C, expireTimeInMills, hasTimer, z, sa2, sa22, (SA2) objB3, interfaceC22053ub1, 0, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                d((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.features.root.h$s$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C13090h c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C13090h c13090h, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c13090h;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.c.oc().X1(InterfaceC4662Ga2.c.a);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        s() {
        }

        private static final EventBarData b(InterfaceC9664aL6 interfaceC9664aL6) {
            return (EventBarData) interfaceC9664aL6.getValue();
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            EventBarData eventBarDataB = b(AbstractC10222bH6.b(C13090h.this.oc().K1(), null, interfaceC22053ub1, 0, 1));
            EventBarData.Enabled enabled = eventBarDataB instanceof EventBarData.Enabled ? (EventBarData.Enabled) eventBarDataB : null;
            interfaceC22053ub1.W(-683723534);
            if (enabled != null) {
                M10.f(false, AbstractC19242q11.e(-626179873, true, new a(enabled, C13090h.this), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
            interfaceC22053ub1.Q();
            C19938rB7 c19938rB72 = C19938rB7.a;
            interfaceC22053ub1.W(-683690267);
            boolean zD = interfaceC22053ub1.D(C13090h.this);
            C13090h c13090h = C13090h.this;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new b(c13090h, null);
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC10721c52.e(c19938rB72, (InterfaceC14603iB2) objB, interfaceC22053ub1, 6);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.features.root.h$t */
    static final class t implements InterfaceC14603iB2 {
        final /* synthetic */ ComposeView b;

        /* renamed from: ir.nasim.features.root.h$t$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C13090h c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C13090h c13090h, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c13090h;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.c.oc().Y1(InterfaceC13356g53.c.a);
                this.c.oc().i2();
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.features.root.h$t$b */
        static final class b implements InterfaceC14603iB2 {
            final /* synthetic */ C13090h a;

            b(C13090h c13090h) {
                this.a = c13090h;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 d(C13090h c13090h) {
                AbstractC13042fc3.i(c13090h, "this$0");
                c13090h.oc().Y1(InterfaceC13356g53.d.a);
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 f(C13090h c13090h) {
                AbstractC13042fc3.i(c13090h, "this$0");
                c13090h.oc().Y1(InterfaceC13356g53.b.a);
                return C19938rB7.a;
            }

            public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                interfaceC22053ub1.W(-1184237648);
                boolean zD = interfaceC22053ub1.D(this.a);
                final C13090h c13090h = this.a;
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.features.root.u
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C13090h.t.b.d(c13090h);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                SA2 sa2 = (SA2) objB;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(-1184234146);
                boolean zD2 = interfaceC22053ub1.D(this.a);
                final C13090h c13090h2 = this.a;
                Object objB2 = interfaceC22053ub1.B();
                if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new SA2() { // from class: ir.nasim.features.root.v
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C13090h.t.b.f(c13090h2);
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                interfaceC22053ub1.Q();
                AbstractC9796aa3.d(sa2, (SA2) objB2, interfaceC22053ub1, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        t(ComposeView composeView) {
            this.b = composeView;
        }

        private static final H b(InterfaceC9664aL6 interfaceC9664aL6) {
            return (H) interfaceC9664aL6.getValue();
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            C19938rB7 c19938rB7 = C19938rB7.a;
            interfaceC22053ub1.W(613923305);
            boolean zD = interfaceC22053ub1.D(C13090h.this);
            C13090h c13090h = C13090h.this;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new a(c13090h, null);
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC10721c52.e(c19938rB7, (InterfaceC14603iB2) objB, interfaceC22053ub1, 6);
            if (!b(AbstractC10222bH6.b(C13090h.this.oc().V1(), null, interfaceC22053ub1, 0, 1)).g()) {
                this.b.setVisibility(8);
            } else {
                this.b.setVisibility(0);
                M10.f(false, AbstractC19242q11.e(351381659, true, new b(C13090h.this), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.features.root.h$u */
    static final class u extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ C11458d25 e;
        final /* synthetic */ String f;
        final /* synthetic */ C12889fL5 g;
        final /* synthetic */ ExPeerType h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        u(C11458d25 c11458d25, String str, C12889fL5 c12889fL5, ExPeerType exPeerType, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = c11458d25;
            this.f = str;
            this.g = c12889fL5;
            this.h = exPeerType;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 D(C13090h c13090h, C11458d25 c11458d25, ExPeerType exPeerType, boolean z) {
            c13090h.oc().u1(c11458d25.getPeerId());
            if (!z) {
                c13090h.oc().C1(c11458d25, exPeerType);
            }
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 z(C13090h c13090h, DialogEntity dialogEntity) {
            c13090h.oc().s2(dialogEntity.getPeerUid());
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            u uVar = C13090h.this.new u(this.e, this.f, this.g, this.h, interfaceC20295rm1);
            uVar.c = obj;
            return uVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                I iOc = C13090h.this.oc();
                int peerId = this.e.getPeerId();
                W25 w25S = this.e.s();
                AbstractC13042fc3.h(w25S, "getPeerType(...)");
                InterfaceC24823zG1 interfaceC24823zG1I1 = iOc.I1(peerId, w25S);
                this.c = interfaceC20315ro1;
                this.b = 1;
                obj = interfaceC24823zG1I1.y(this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            final DialogEntity dialogEntity = (DialogEntity) obj;
            if (dialogEntity == null) {
                C19406qI3.b("RootFragment", "temp dialog in DialogContainerFragment is null with id:" + this.e.getPeerId());
                return C19938rB7.a;
            }
            String string = C13090h.this.S7().getString(AbstractC12217eE5.snackbar_action_undo);
            Integer numD = AbstractC6392Nk0.d(KB5.undo);
            final C13090h c13090h = C13090h.this;
            AbstractC13463gG6 aVar = new AbstractC13463gG6.a(string, numD, true, new SA2() { // from class: ir.nasim.features.root.w
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C13090h.u.z(c13090h, dialogEntity);
                }
            });
            C13090h.this.oc().D1(this.e);
            String str = this.f;
            if (str == null || AbstractC20762sZ6.n0(str)) {
                ExPeerType exPeerType = this.h;
                if (exPeerType == ExPeerType.PRIVATE || exPeerType == ExPeerType.BOT) {
                    this.g.a = C13090h.this.S7().getString(AbstractC12217eE5.delete_chat_in_dialogs_container);
                } else if (exPeerType == ExPeerType.CHANNEL) {
                    this.g.a = C13090h.this.S7().getString(AbstractC12217eE5.delete_channel_in_dialogs_container);
                } else {
                    this.g.a = C13090h.this.S7().getString(AbstractC12217eE5.delete_group_in_dialogs_container);
                }
            } else {
                this.g.a = this.f;
                aVar = new AbstractC13463gG6.b(KB5.admin);
            }
            C17468n10 c17468n10 = C13090h.this.deleteChatSnackBar;
            if (c17468n10 != null) {
                String str2 = (String) this.g.a;
                final C13090h c13090h2 = C13090h.this;
                final C11458d25 c11458d25 = this.e;
                final ExPeerType exPeerType2 = this.h;
                c17468n10.n(str2, aVar, new UA2() { // from class: ir.nasim.features.root.x
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj2) {
                        return C13090h.u.D(c13090h2, c11458d25, exPeerType2, ((Boolean) obj2).booleanValue());
                    }
                });
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((u) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.features.root.h$v */
    static final class v implements InterfaceC15796kB2 {
        final /* synthetic */ AbstractC10026ax1 a;
        final /* synthetic */ C13090h b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;

        /* renamed from: ir.nasim.features.root.h$v$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ String a;

            a(String str) {
                this.a = str;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC19555qZ.B0(this.a, interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.features.root.h$v$b */
        static final class b implements InterfaceC14603iB2 {
            final /* synthetic */ String a;

            b(String str) {
                this.a = str;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC19555qZ.e0(this.a, interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.features.root.h$v$c */
        static final class c implements InterfaceC14603iB2 {
            final /* synthetic */ String a;

            c(String str) {
                this.a = str;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC19555qZ.B0(this.a, interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.features.root.h$v$d */
        static final class d implements InterfaceC14603iB2 {
            final /* synthetic */ String a;

            d(String str) {
                this.a = str;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC19555qZ.e0(this.a, interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.features.root.h$v$e */
        static final class e implements InterfaceC14603iB2 {
            final /* synthetic */ String a;

            e(String str) {
                this.a = str;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC19555qZ.B0(this.a, interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.features.root.h$v$f */
        static final class f implements InterfaceC14603iB2 {
            final /* synthetic */ String a;

            f(String str) {
                this.a = str;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC19555qZ.e0(this.a, interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.features.root.h$v$g */
        static final class g implements InterfaceC14603iB2 {
            final /* synthetic */ String a;

            g(String str) {
                this.a = str;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC19555qZ.B0(this.a, interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.features.root.h$v$h, reason: collision with other inner class name */
        static final class C1228h implements InterfaceC14603iB2 {
            final /* synthetic */ String a;

            C1228h(String str) {
                this.a = str;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC19555qZ.e0(this.a, interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        v(AbstractC10026ax1 abstractC10026ax1, C13090h c13090h, String str, String str2) {
            this.a = abstractC10026ax1;
            this.b = c13090h;
            this.c = str;
            this.d = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 k(C13090h c13090h, Dialog dialog, boolean z) {
            AbstractC13042fc3.i(c13090h, "this$0");
            AbstractC13042fc3.i(dialog, "$dialog");
            c13090h.oc().z2(z);
            dialog.dismiss();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 n(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$dialog");
            dialog.dismiss();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 o(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$dialog");
            dialog.dismiss();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 p(C13090h c13090h, Dialog dialog, AbstractC10026ax1 abstractC10026ax1, boolean z) {
            AbstractC13042fc3.i(c13090h, "this$0");
            AbstractC13042fc3.i(dialog, "$dialog");
            AbstractC13042fc3.i(abstractC10026ax1, "$action");
            c13090h.oc().z2(z);
            dialog.dismiss();
            c13090h.Tc((AbstractC10026ax1.b) abstractC10026ax1);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 t(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$dialog");
            dialog.dismiss();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 v(Dialog dialog, C13090h c13090h, AbstractC10026ax1 abstractC10026ax1) {
            AbstractC13042fc3.i(dialog, "$dialog");
            AbstractC13042fc3.i(c13090h, "this$0");
            AbstractC13042fc3.i(abstractC10026ax1, "$action");
            dialog.dismiss();
            c13090h.Tc((AbstractC10026ax1.b) abstractC10026ax1);
            return C19938rB7.a;
        }

        public final void i(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "dialog");
            boolean z = !C8386Vt0.a.x5();
            AbstractC10026ax1 abstractC10026ax1 = this.a;
            if (abstractC10026ax1 instanceof AbstractC10026ax1.a) {
                interfaceC22053ub1.W(918621389);
                if (z) {
                    interfaceC22053ub1.W(918639400);
                    AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
                    AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
                    InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
                    String strC = UY6.c(AbstractC12217eE5.check_box_general_message, interfaceC22053ub1, 0);
                    String strC2 = UY6.c(AbstractC12217eE5.dialog_positive_button_i_got_it, interfaceC22053ub1, 0);
                    InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(-497490722, true, new c(this.c), interfaceC22053ub1, 54);
                    InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(1244152476, true, new d(this.d), interfaceC22053ub1, 54);
                    interfaceC22053ub1.W(1138026792);
                    boolean zD = interfaceC22053ub1.D(this.b) | interfaceC22053ub1.D(dialog);
                    final C13090h c13090h = this.b;
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new UA2() { // from class: ir.nasim.features.root.y
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return C13090h.v.k(c13090h, dialog, ((Boolean) obj).booleanValue());
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC19555qZ.W(interfaceC18060o11E, cVar, interfaceC18060o11E2, cVar2, null, aVar, (UA2) objB, strC2, strC, interfaceC22053ub1, (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.a.b << 15), 16);
                    interfaceC22053ub1.Q();
                } else {
                    interfaceC22053ub1.W(919519366);
                    InterfaceC18060o11 interfaceC18060o11E3 = AbstractC19242q11.e(-1044416898, true, new e(this.c), interfaceC22053ub1, 54);
                    AbstractC10289bP1.b.c cVar3 = AbstractC10289bP1.b.c.b;
                    InterfaceC18060o11 interfaceC18060o11E4 = AbstractC19242q11.e(-661743428, true, new f(this.d), interfaceC22053ub1, 54);
                    AbstractC10289bP1.a.c cVar4 = AbstractC10289bP1.a.c.a;
                    InterfaceC19114po0.b.a aVar2 = InterfaceC19114po0.b.a.a;
                    interfaceC22053ub1.W(1138054901);
                    boolean zD2 = interfaceC22053ub1.D(dialog);
                    Object objB2 = interfaceC22053ub1.B();
                    if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new SA2() { // from class: ir.nasim.features.root.z
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C13090h.v.o(dialog);
                            }
                        };
                        interfaceC22053ub1.s(objB2);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC19555qZ.T(interfaceC18060o11E3, cVar3, interfaceC18060o11E4, cVar4, null, aVar2, (SA2) objB2, UY6.c(AbstractC12217eE5.dialog_positive_button_i_got_it, interfaceC22053ub1, 0), interfaceC22053ub1, (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.a.b << 15), 16);
                    interfaceC22053ub1.Q();
                }
                interfaceC22053ub1.Q();
                return;
            }
            if (!(abstractC10026ax1 instanceof AbstractC10026ax1.b)) {
                interfaceC22053ub1.W(922428127);
                interfaceC22053ub1.Q();
                return;
            }
            interfaceC22053ub1.W(920274619);
            if (z) {
                interfaceC22053ub1.W(920281997);
                AbstractC10289bP1.b.c cVar5 = AbstractC10289bP1.b.c.b;
                AbstractC10289bP1.a.c cVar6 = AbstractC10289bP1.a.c.a;
                InterfaceC19114po0.b.a aVar3 = InterfaceC19114po0.b.a.a;
                String strA = ((AbstractC10026ax1.b) this.a).a();
                InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
                String strC3 = UY6.c(AbstractC12217eE5.dialog_negative_button_cancel, interfaceC22053ub1, 0);
                String strC4 = UY6.c(AbstractC12217eE5.check_box_general_message, interfaceC22053ub1, 0);
                InterfaceC18060o11 interfaceC18060o11E5 = AbstractC19242q11.e(-88887320, true, new g(this.c), interfaceC22053ub1, 54);
                InterfaceC18060o11 interfaceC18060o11E6 = AbstractC19242q11.e(-1029807962, true, new C1228h(this.d), interfaceC22053ub1, 54);
                interfaceC22053ub1.W(1138080184);
                boolean zD3 = interfaceC22053ub1.D(this.b) | interfaceC22053ub1.D(dialog) | interfaceC22053ub1.V(this.a);
                final C13090h c13090h2 = this.b;
                final AbstractC10026ax1 abstractC10026ax12 = this.a;
                Object objB3 = interfaceC22053ub1.B();
                if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                    objB3 = new UA2() { // from class: ir.nasim.features.root.A
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C13090h.v.p(c13090h2, dialog, abstractC10026ax12, ((Boolean) obj).booleanValue());
                        }
                    };
                    interfaceC22053ub1.s(objB3);
                }
                UA2 ua2 = (UA2) objB3;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(1138096277);
                boolean zD4 = interfaceC22053ub1.D(dialog);
                Object objB4 = interfaceC22053ub1.B();
                if (zD4 || objB4 == InterfaceC22053ub1.a.a()) {
                    objB4 = new SA2() { // from class: ir.nasim.features.root.B
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C13090h.v.t(dialog);
                        }
                    };
                    interfaceC22053ub1.s(objB4);
                }
                interfaceC22053ub1.Q();
                AbstractC19555qZ.I(interfaceC18060o11E5, cVar5, interfaceC18060o11E6, cVar6, aVar3, ua2, strA, c1454b, (SA2) objB4, strC3, null, strC4, false, interfaceC22053ub1, (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.a.b << 12) | (InterfaceC19114po0.b.C1454b.b << 21), 0, 5120);
                interfaceC22053ub1.Q();
            } else {
                interfaceC22053ub1.W(921444559);
                AbstractC10289bP1.b.c cVar7 = AbstractC10289bP1.b.c.b;
                AbstractC10289bP1.a.c cVar8 = AbstractC10289bP1.a.c.a;
                InterfaceC19114po0.b.a aVar4 = InterfaceC19114po0.b.a.a;
                String strA2 = ((AbstractC10026ax1.b) this.a).a();
                InterfaceC19114po0.b.C1454b c1454b2 = InterfaceC19114po0.b.C1454b.a;
                String strC5 = UY6.c(AbstractC12217eE5.dialog_negative_button_cancel, interfaceC22053ub1, 0);
                InterfaceC18060o11 interfaceC18060o11E7 = AbstractC19242q11.e(-389491000, true, new a(this.c), interfaceC22053ub1, 54);
                InterfaceC18060o11 interfaceC18060o11E8 = AbstractC19242q11.e(1806732294, true, new b(this.d), interfaceC22053ub1, 54);
                interfaceC22053ub1.W(1138117409);
                boolean zD5 = interfaceC22053ub1.D(dialog) | interfaceC22053ub1.D(this.b) | interfaceC22053ub1.V(this.a);
                final C13090h c13090h3 = this.b;
                final AbstractC10026ax1 abstractC10026ax13 = this.a;
                Object objB5 = interfaceC22053ub1.B();
                if (zD5 || objB5 == InterfaceC22053ub1.a.a()) {
                    objB5 = new SA2() { // from class: ir.nasim.features.root.C
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C13090h.v.v(dialog, c13090h3, abstractC10026ax13);
                        }
                    };
                    interfaceC22053ub1.s(objB5);
                }
                SA2 sa2 = (SA2) objB5;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(1138130805);
                boolean zD6 = interfaceC22053ub1.D(dialog);
                Object objB6 = interfaceC22053ub1.B();
                if (zD6 || objB6 == InterfaceC22053ub1.a.a()) {
                    objB6 = new SA2() { // from class: ir.nasim.features.root.D
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C13090h.v.n(dialog);
                        }
                    };
                    interfaceC22053ub1.s(objB6);
                }
                interfaceC22053ub1.Q();
                AbstractC19555qZ.F(interfaceC18060o11E7, cVar7, interfaceC18060o11E8, cVar8, aVar4, sa2, strA2, c1454b2, (SA2) objB6, strC5, null, interfaceC22053ub1, (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.a.b << 12) | (InterfaceC19114po0.b.C1454b.b << 21), 0, 1024);
                interfaceC22053ub1.Q();
            }
            interfaceC22053ub1.Q();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            i((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.features.root.h$w */
    static final class w implements InterfaceC15796kB2 {
        w() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(Dialog dialog, C13090h c13090h) {
            AbstractC13042fc3.i(dialog, "$it");
            AbstractC13042fc3.i(c13090h, "this$0");
            dialog.dismiss();
            C22042ua0.A9(c13090h, new ir.nasim.features.settings.a(), false, null, 6, null);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$it");
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void c(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "it");
            W81 w81 = W81.a;
            InterfaceC14603iB2 interfaceC14603iB2A = w81.a();
            AbstractC10289bP1.b.C0905b c0905b = AbstractC10289bP1.b.C0905b.b;
            InterfaceC14603iB2 interfaceC14603iB2B = w81.b();
            AbstractC10289bP1.a.c cVar = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
            interfaceC22053ub1.W(-421799571);
            boolean zD = interfaceC22053ub1.D(dialog) | interfaceC22053ub1.D(C13090h.this);
            final C13090h c13090h = C13090h.this;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.features.root.E
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C13090h.w.d(dialog, c13090h);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            int i2 = AbstractC12217eE5.settings_clear_cache;
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(-421790055);
            boolean zD2 = interfaceC22053ub1.D(dialog);
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.features.root.F
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C13090h.w.f(dialog);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.E(interfaceC14603iB2A, c0905b, interfaceC14603iB2B, cVar, aVar, sa2, i2, c1454b, (SA2) objB2, AbstractC12217eE5.dialog_negative_button_cancel, null, interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 21) | (AbstractC10289bP1.b.C0905b.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.a.b << 12), 0, 1024);
            dialog.setCanceledOnTouchOutside(false);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.features.root.h$x */
    public static final class x extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            C14819iX7 c14819iX7D1 = this.e.Q7().d1();
            AbstractC13042fc3.h(c14819iX7D1, "requireActivity().viewModelStore");
            return c14819iX7D1;
        }
    }

    /* renamed from: ir.nasim.features.root.h$y */
    public static final class y extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ Fragment f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(SA2 sa2, Fragment fragment) {
            super(0);
            this.e = sa2;
            this.f = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC20375ru1 invoke() {
            AbstractC20375ru1 abstractC20375ru1;
            SA2 sa2 = this.e;
            if (sa2 != null && (abstractC20375ru1 = (AbstractC20375ru1) sa2.invoke()) != null) {
                return abstractC20375ru1;
            }
            AbstractC20375ru1 abstractC20375ru1P3 = this.f.Q7().p3();
            AbstractC13042fc3.h(abstractC20375ru1P3, "requireActivity().defaultViewModelCreationExtras");
            return abstractC20375ru1P3;
        }
    }

    /* renamed from: ir.nasim.features.root.h$z */
    public static final class z extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            G.c cVarN3 = this.e.Q7().n3();
            AbstractC13042fc3.h(cVarN3, "requireActivity().defaultViewModelProviderFactory");
            return cVarN3;
        }
    }

    static {
        C8386Vt0 c8386Vt0 = C8386Vt0.a;
        q2 = c8386Vt0.h4() ? 4 : 3;
        r2 = c8386Vt0.h4() ? 2 : -1;
        s2 = c8386Vt0.h4() ? 3 : 2;
        t2 = c8386Vt0.h4() ? 4 : 3;
    }

    public C13090h() {
        InterfaceC3570Bk5 interfaceC3570Bk5Q = C7183Qq.q(EnumC18608ow5.k);
        AbstractC13042fc3.h(interfaceC3570Bk5Q, "getInstance(...)");
        this.jaryanAndroidProperties = interfaceC3570Bk5Q;
        this.fragmentOnAttachListener = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.V36
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C13090h.Wb(this.a);
            }
        });
        this.requestPermissionsResultListeners = new ArrayList();
        a8(new Bundle());
        B8(true);
        C5735Kp4.w().u(this);
        this.onServicesBalloonClick = new SA2() { // from class: ir.nasim.W36
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C13090h.Nc(this.a);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence Ac(C13090h c13090h, R14 r14) {
        AbstractC13042fc3.i(c13090h, "this$0");
        AbstractC13042fc3.i(r14, "member");
        String strI6 = c13090h.i6(AbstractC12217eE5.member_preview_group, r14.c());
        AbstractC13042fc3.h(strI6, "getString(...)");
        return strI6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ad(Context context) {
        AbstractC13042fc3.i(context, "$context");
        C22055ub3.p(context, "RootFragment");
        return C19938rB7.a;
    }

    private final void Bc(LinearLayout tabStrip) {
        int childCount = tabStrip.getChildCount();
        for (final int i2 = 0; i2 < childCount; i2++) {
            tabStrip.getChildAt(i2).setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.nasim.S36
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return C13090h.Cc(i2, this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Cc(final int i2, final C13090h c13090h, View view) {
        AbstractC13042fc3.i(c13090h, "this$0");
        if ((!C8386Vt0.a.h4() || i2 != r2) && c13090h.Zb() != i2) {
            PopupMenu popupMenu = new PopupMenu(c13090h.G5(), view);
            popupMenu.inflate(AbstractC15226jD5.select_default_tab_menu);
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: ir.nasim.z36
                @Override // android.widget.PopupMenu.OnMenuItemClickListener
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    return C13090h.Dc(this.a, i2, menuItem);
                }
            });
            popupMenu.show();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Cd(C13090h c13090h, C17067mL1 c17067mL1) {
        AbstractC13042fc3.i(c13090h, "this$0");
        AbstractC13042fc3.i(c17067mL1, "$tempDialog");
        c13090h.oc().t2(c17067mL1);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Dc(C13090h c13090h, int i2, MenuItem menuItem) {
        AbstractC13042fc3.i(c13090h, "this$0");
        AbstractC13042fc3.i(menuItem, "item");
        if (menuItem.getItemId() != BC5.popup_menu_action_default) {
            return false;
        }
        c13090h.jd(i2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Dd(C13090h c13090h, C11458d25 c11458d25, ExPeerType exPeerType, boolean z2) {
        AbstractC13042fc3.i(c13090h, "this$0");
        AbstractC13042fc3.i(c11458d25, "$peer");
        AbstractC13042fc3.i(exPeerType, "$exPeerType");
        c13090h.oc().u1(c11458d25.getPeerId());
        if (!z2) {
            c13090h.oc().C1(c11458d25, exPeerType);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ec(int currentPosition) {
        C7183Qq.p().g("user_select_another_tab", true);
        C21448tg3.a(this.lastSelectedPageIndex, currentPosition);
        if (currentPosition == 0) {
            if (wd()) {
                C7183Qq.p().putInt("dialog_tab_click_after_default_tab", C7183Qq.p().getInt("dialog_tab_click_after_default_tab", 0) + 1);
            }
            C17213mb2.j("New_Chat_Click");
        } else if (currentPosition == s2) {
            G g2 = this.presenter;
            if (g2 != null) {
                g2.O();
            }
            if (wd()) {
                C7183Qq.p().putInt("my_bank_tab_click_after_default_tab", C7183Qq.p().getInt("my_bank_tab_click_after_default_tab", 0) + 1);
            }
            InterfaceC17936no4 interfaceC17936no4 = this.myBankFragmentPageInterface;
            if (interfaceC17936no4 != null && interfaceC17936no4 != null) {
                interfaceC17936no4.x1();
            }
            C17213mb2.j("New_My_Bank_Click");
            Xc();
        } else if (currentPosition == 1) {
            C21448tg3.b();
            oc().H2();
        }
        View viewAc = ac(this.lastSelectedPageIndex);
        TextView textView = viewAc != null ? (TextView) viewAc.findViewById(BC5.title) : null;
        View viewAc2 = ac(currentPosition);
        TextView textView2 = viewAc2 != null ? (TextView) viewAc2.findViewById(BC5.title) : null;
        Resources resourcesB6 = b6();
        Integer[] numArr = this.tabIconsSelected;
        if (numArr == null) {
            AbstractC13042fc3.y("tabIconsSelected");
            numArr = null;
        }
        Drawable drawableL = AbstractC21710u02.l(resourcesB6.getDrawable(numArr[currentPosition].intValue()));
        AbstractC13042fc3.h(drawableL, "wrap(...)");
        Resources resourcesB62 = b6();
        Integer[] numArr2 = this.tabIcons;
        if (numArr2 == null) {
            AbstractC13042fc3.y("tabIcons");
            numArr2 = null;
        }
        Drawable drawableL2 = AbstractC21710u02.l(resourcesB62.getDrawable(numArr2[tc(this.lastSelectedPageIndex)].intValue()));
        AbstractC13042fc3.h(drawableL2, "wrap(...)");
        AbstractC21710u02.h(drawableL, this.tabActiveColor);
        AbstractC21710u02.h(drawableL2, this.tabDisableColor);
        if (textView2 != null) {
            textView2.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, drawableL, (Drawable) null, (Drawable) null);
        }
        if (textView2 != null) {
            textView2.setTextColor(this.tabActiveColor);
        }
        if (textView != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, drawableL2, (Drawable) null, (Drawable) null);
        }
        if (textView != null) {
            textView.setTextColor(this.tabDisableColor);
        }
        this.lastSelectedPageIndex = currentPosition;
        C5735Kp4.w().v(currentPosition);
        pc(currentPosition);
        if (wd()) {
            Md();
            this.shouldCalculateTabSelectionForFirstTime = false;
        }
        Fd(currentPosition);
    }

    private final void Ed(C11458d25 peer, ExPeerType exPeerType, String message) {
        C12889fL5 c12889fL5 = new C12889fL5();
        c12889fL5.a = "";
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new u(peer, message, c12889fL5, exPeerType, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object Fc(ir.nasim.InterfaceC20295rm1 r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ir.nasim.features.root.C13090h.g
            if (r0 == 0) goto L13
            r0 = r5
            ir.nasim.features.root.h$g r0 = (ir.nasim.features.root.C13090h.g) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.features.root.h$g r0 = new ir.nasim.features.root.h$g
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.a
            ir.nasim.features.root.h r0 = (ir.nasim.features.root.C13090h) r0
            ir.nasim.AbstractC10685c16.b(r5)
            goto L5f
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            ir.nasim.AbstractC10685c16.b(r5)
            ir.nasim.Yh4 r5 = ir.nasim.AbstractC5969Lp4.e()
            ir.nasim.oe4 r5 = r5.H()
            ir.nasim.Ec1 r2 = ir.nasim.EnumC4196Ec1.Z
            boolean r5 = r5.w0(r2)
            if (r5 == 0) goto L69
            ir.nasim.Pj2 r5 = ir.nasim.C6879Pj2.a
            ir.nasim.Fq2 r5 = r5.p()
            ir.nasim.features.root.h$h r2 = new ir.nasim.features.root.h$h
            r2.<init>()
            r0.a = r4
            r0.d = r3
            java.lang.Object r5 = r5.b(r2, r0)
            if (r5 != r1) goto L5e
            return r1
        L5e:
            r0 = r4
        L5f:
            ir.nasim.Pj2 r5 = ir.nasim.C6879Pj2.a
            ir.nasim.H36 r1 = new ir.nasim.H36
            r1.<init>()
            r5.t(r1)
        L69:
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.root.C13090h.Fc(ir.nasim.rm1):java.lang.Object");
    }

    private final void Fd(int currentPosition) {
        try {
            Fragment fragment = this.activeFragment;
            if (fragment != null) {
                FragmentManager fragmentManager = null;
                if (currentPosition == 0) {
                    if (this.dialogsContainerFragment == null) {
                        kd(null);
                        Fragment fragment2 = this.dialogsContainerFragment;
                        if (fragment2 != null) {
                            FragmentManager fragmentManager2 = this.rootSupportFragmentManager;
                            if (fragmentManager2 == null) {
                                AbstractC13042fc3.y("rootSupportFragmentManager");
                                fragmentManager2 = null;
                            }
                            fragmentManager2.s().c(BC5.fragment_container, fragment2, "dialogsContainerFragment").h();
                        }
                    } else {
                        xc();
                    }
                    Fragment fragment3 = this.dialogsContainerFragment;
                    if (fragment3 != null) {
                        FragmentManager fragmentManager3 = this.rootSupportFragmentManager;
                        if (fragmentManager3 == null) {
                            AbstractC13042fc3.y("rootSupportFragmentManager");
                        } else {
                            fragmentManager = fragmentManager3;
                        }
                        fragmentManager.s().n(fragment).x(fragment3).h();
                        this.activeFragment = fragment3;
                        return;
                    }
                    return;
                }
                if (currentPosition == 1) {
                    if (this.jaryanFragment == null) {
                        nd(null);
                        C22042ua0 c22042ua0 = this.jaryanFragment;
                        if (c22042ua0 != null) {
                            FragmentManager fragmentManager4 = this.rootSupportFragmentManager;
                            if (fragmentManager4 == null) {
                                AbstractC13042fc3.y("rootSupportFragmentManager");
                                fragmentManager4 = null;
                            }
                            fragmentManager4.s().c(BC5.fragment_container, c22042ua0, "jaryanFragment").h();
                        }
                    }
                    C22042ua0 c22042ua02 = this.jaryanFragment;
                    if (c22042ua02 != null) {
                        FragmentManager fragmentManager5 = this.rootSupportFragmentManager;
                        if (fragmentManager5 == null) {
                            AbstractC13042fc3.y("rootSupportFragmentManager");
                        } else {
                            fragmentManager = fragmentManager5;
                        }
                        fragmentManager.s().n(fragment).x(c22042ua02).h();
                        this.activeFragment = c22042ua02;
                    }
                    sc();
                    return;
                }
                if (currentPosition == s2) {
                    if (this.myBankFragmentPageInterface == null) {
                        pd(null);
                        InterfaceC17936no4 interfaceC17936no4 = this.myBankFragmentPageInterface;
                        if (interfaceC17936no4 != null) {
                            FragmentManager fragmentManager6 = this.rootSupportFragmentManager;
                            if (fragmentManager6 == null) {
                                AbstractC13042fc3.y("rootSupportFragmentManager");
                                fragmentManager6 = null;
                            }
                            fragmentManager6.s().c(BC5.fragment_container, interfaceC17936no4.J0(), "myBankPage").h();
                        }
                    }
                    InterfaceC17936no4 interfaceC17936no42 = this.myBankFragmentPageInterface;
                    if (interfaceC17936no42 != null) {
                        FragmentManager fragmentManager7 = this.rootSupportFragmentManager;
                        if (fragmentManager7 == null) {
                            AbstractC13042fc3.y("rootSupportFragmentManager");
                        } else {
                            fragmentManager = fragmentManager7;
                        }
                        fragmentManager.s().n(fragment).x(interfaceC17936no42.J0()).h();
                        this.activeFragment = interfaceC17936no42.J0();
                        return;
                    }
                    return;
                }
                if (currentPosition == r2 && uc()) {
                    if (this.aiChatFragment == null) {
                        bd(this, null, null, 2, null);
                        ir.nasim.features.bank.mybank.webview.a aVar = this.aiChatFragment;
                        if (aVar != null) {
                            FragmentManager fragmentManager8 = this.rootSupportFragmentManager;
                            if (fragmentManager8 == null) {
                                AbstractC13042fc3.y("rootSupportFragmentManager");
                                fragmentManager8 = null;
                            }
                            fragmentManager8.s().c(BC5.fragment_container, aVar.J0(), "myAiPage").h();
                        }
                    }
                    ir.nasim.features.bank.mybank.webview.a aVar2 = this.aiChatFragment;
                    if (aVar2 != null) {
                        FragmentManager fragmentManager9 = this.rootSupportFragmentManager;
                        if (fragmentManager9 == null) {
                            AbstractC13042fc3.y("rootSupportFragmentManager");
                        } else {
                            fragmentManager = fragmentManager9;
                        }
                        fragmentManager.s().n(fragment).x(aVar2.J0()).h();
                        this.activeFragment = aVar2.J0();
                    }
                }
            }
        } catch (Exception e2) {
            C19406qI3.b("RootFragment", "Error: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Gc(C13090h c13090h) {
        AbstractC13042fc3.i(c13090h, "this$0");
        String strH6 = c13090h.h6(AbstractC12217eE5.feedback_submit_successfully);
        AbstractC13042fc3.h(strH6, "getString(...)");
        c13090h.Jd(strH6);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Gd(String title, String desc, AbstractC10026ax1 action) {
        if ((action instanceof AbstractC10026ax1.c) || oc().L1()) {
            return;
        }
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(-1906223159, true, new v(action, this, title, desc)), 4, null).show();
    }

    private final void Hc() {
        AbstractC16751lo1.c(this, j.b.STARTED, new i(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Hd() {
        if (oc().F2()) {
            Context contextS7 = S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            AbstractC21375tZ.c(contextS7, this, null, AbstractC19242q11.c(-1820392741, true, new w()), 4, null).show();
            oc().k2();
        }
    }

    private final InterfaceC13730gj3 Ic() {
        return AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new j(null), 3, null);
    }

    private final void Id() {
        if (oc().G1() && wc()) {
            int i2 = this.lastSelectedPageIndex;
            int i3 = s2;
            if (i2 == i3) {
                return;
            }
            try {
                TabLayout tabLayout = this.tabLayout;
                if ((tabLayout != null ? tabLayout.y(i3) : null) != null) {
                    oc().Z1(J.a.a);
                }
            } catch (Exception e2) {
                C19406qI3.c("RootFragment", "showServicesTooltip", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Jc(View view, final View view2, final View view3, View view4) {
        AbstractC13042fc3.i(view, "$insetView");
        AbstractC13042fc3.i(view2, "$targetPaddingView");
        AbstractC13042fc3.i(view4, "it");
        AbstractC12990fW7.E0(view, new InterfaceC22474vI4() { // from class: ir.nasim.D36
            @Override // ir.nasim.InterfaceC22474vI4
            public final O98 b(View view5, O98 o98) {
                return C13090h.Kc(view2, view3, view5, o98);
            }
        });
        return C19938rB7.a;
    }

    private final void Kb(Integer[] tabIcons, Integer[] tabTitles) {
        TabLayout tabLayout;
        if (this.parent == null || (tabLayout = this.tabLayout) == null) {
            return;
        }
        int length = tabTitles.length;
        for (int i2 = 0; i2 < length; i2++) {
            tabLayout.e(tabLayout.B().x(tabTitles[i2].intValue()).s(tabIcons[i2].intValue()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final O98 Kc(View view, View view2, View view3, O98 o98) {
        AbstractC13042fc3.i(view, "$targetPaddingView");
        AbstractC13042fc3.i(view3, "<unused var>");
        AbstractC13042fc3.i(o98, "insets");
        L93 l93F = o98.f(O98.m.g());
        AbstractC13042fc3.h(l93F, "getInsets(...)");
        view.setPadding(l93F.a, 0, l93F.c, l93F.d);
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                viewGroup.getChildAt(i2).onApplyWindowInsets(o98.y());
            }
        }
        return o98;
    }

    private final void Kd() {
        TextView textView;
        TextView textView2 = this.storyBadgeView;
        if (textView2 == null || this.lastSelectedPageIndex == 1) {
            return;
        }
        if ((textView2 == null || textView2.getVisibility() != 0) && (textView = this.storyBadgeView) != null) {
            textView.setVisibility(0);
        }
    }

    private final void Lb() {
        try {
            C15225jD4.b().a(this, C15225jD4.i);
        } catch (Exception e2) {
            C19406qI3.a("RootFragment", e2.getMessage(), new Object[0]);
        }
    }

    private final InterfaceC13730gj3 Lc() {
        return AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new k(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ld(C13090h c13090h, DialogInterface dialogInterface, int i2) {
        AbstractC13042fc3.i(c13090h, "this$0");
        c13090h.id();
    }

    private final void Mb(AbstractC13089g.b dialogsMode) {
        ld(dialogsMode);
        Fragment fragment = this.dialogsContainerFragment;
        if (fragment != null && (fragment instanceof YR1)) {
            AbstractC13042fc3.g(fragment, "null cannot be cast to non-null type ir.nasim.features.dialogs.DialogsContainerFragment");
            ((YR1) fragment).tb(dialogsMode);
        } else if (fragment != null) {
            if (fragment != null) {
                bc().c(fragment, dialogsMode);
            }
        } else {
            C19406qI3.b("RootFragment", "changeDialogsMode: dialogsContainerFragment is null in dialogsMode: " + dialogsMode);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mc(C13090h c13090h, String str) {
        AbstractC13042fc3.i(c13090h, "this$0");
        AbstractC13042fc3.i(str, "$it");
        C11458d25 c11458d25R = C11458d25.r(Long.parseLong(str));
        AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
        c13090h.Rc(c11458d25R, null);
    }

    private final void Md() {
        G g2 = this.presenter;
        if (g2 != null) {
            g2.S();
        }
    }

    private final void Nb(int currentPosition) {
        G g2 = this.presenter;
        if (g2 != null) {
            if (g2.R(currentPosition)) {
                C5598Ka2 c5598Ka2 = this.eventBarViewHandler;
                if (c5598Ka2 != null) {
                    c5598Ka2.G();
                    return;
                }
                return;
            }
            C5598Ka2 c5598Ka22 = this.eventBarViewHandler;
            if (c5598Ka22 != null) {
                c5598Ka22.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Nc(C13090h c13090h) {
        AbstractC13042fc3.i(c13090h, "this$0");
        c13090h.ia(s2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer[] Nd(C13090h c13090h) {
        AbstractC13042fc3.i(c13090h, "this$0");
        return c13090h.uc() ? new Integer[]{Integer.valueOf(AbstractC12217eE5.tab_title_chat), Integer.valueOf(AbstractC12217eE5.tab_title_jaryan), Integer.valueOf(AbstractC12217eE5.tab_title_ai), Integer.valueOf(AbstractC12217eE5.tab_title_khadamat)} : new Integer[]{Integer.valueOf(AbstractC12217eE5.tab_title_chat), Integer.valueOf(AbstractC12217eE5.tab_title_jaryan), Integer.valueOf(AbstractC12217eE5.tab_title_khadamat)};
    }

    private final void Ob(final int currentTabPosition) {
        final G g2 = this.presenter;
        if (g2 != null) {
            AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.R36
                @Override // java.lang.Runnable
                public final void run() {
                    C13090h.Pb(g2, currentTabPosition, this);
                }
            }, 1500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oc() {
        AbstractC5969Lp4.d().o2().n0();
    }

    private final void Od() {
        try {
            C15225jD4.b().e(this, C15225jD4.i);
            C15225jD4.b().e(this, C15225jD4.n);
            C15225jD4.b().e(this, C15225jD4.x);
            C15225jD4.b().e(this, C15225jD4.y);
        } catch (Exception e2) {
            C19406qI3.a("RootFragment", e2.getMessage(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Pb(G g2, int i2, C13090h c13090h) {
        AbstractC13042fc3.i(g2, "$it");
        AbstractC13042fc3.i(c13090h, "this$0");
        if (g2.R(i2)) {
            c13090h.Tb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Pc(int position) {
        if (!uc() || !C8386Vt0.a.f4() || position != r2) {
            return false;
        }
        C11458d25 c11458d25R = C11458d25.r(oc().E1());
        AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
        C22042ua0.A9(this, InterfaceC11677dQ0.b(Yb(), c11458d25R, ExPeerType.BOT, null, null, false, null, null, null, null, 0L, null, null, null, false, null, null, null, null, null, false, null, null, null, null, null, false, null, 134217724, null), false, null, 6, null);
        ka(c11458d25R);
        qa(true);
        Vc();
        return true;
    }

    private final InterfaceC13730gj3 Qb() {
        return AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new d(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Qc(C13090h c13090h, int i2, long j2, long j3, HQ0 hq0, Throwable th) {
        AbstractC13042fc3.i(c13090h, "this$0");
        AbstractC13042fc3.i(hq0, "$spot");
        if (c13090h.h9() || F84.l.a() == null) {
            return C19938rB7.a;
        }
        InterfaceC11677dQ0 interfaceC11677dQ0Yb = c13090h.Yb();
        C11458d25 c11458d25Y = C11458d25.y(i2);
        AbstractC13042fc3.h(c11458d25Y, "group(...)");
        C22042ua0.A9(c13090h, InterfaceC11677dQ0.b(interfaceC11677dQ0Yb, c11458d25Y, ExPeerType.GROUP, null, null, false, null, null, null, null, 0L, null, null, null, false, null, Long.valueOf(j2), Long.valueOf(j3), null, null, false, null, hq0, null, null, null, false, null, 132022268, null), false, null, 6, null);
        return C19938rB7.a;
    }

    private final void Rb() {
        AbstractC6459Nq2.W(AbstractC6459Nq2.b0(new e(oc().T1()), new f(null)), AbstractC19224pz3.a(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Sb(ComposeView composeView) {
        composeView.h();
        composeView.setVisibility(8);
    }

    private final void Sc() {
        G g2 = this.presenter;
        if (g2 == null) {
            return;
        }
        InterfaceC22634va2 interfaceC22634va2W = g2 != null ? g2.w() : null;
        if (interfaceC22634va2W == null || !interfaceC22634va2W.s()) {
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(interfaceC22634va2W.q()));
        C18987pb3 c18987pb3 = C18987pb3.a;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        if (c18987pb3.k0(intent, fragmentActivityQ7)) {
            return;
        }
        n8(intent);
    }

    private final void Tb() {
        G g2 = this.presenter;
        if (g2 != null) {
            InterfaceC17936no4 interfaceC17936no4 = this.myBankFragmentPageInterface;
            if (interfaceC17936no4 != null) {
                interfaceC17936no4.F2(g2.w().a());
            }
            C5598Ka2 c5598Ka2 = this.eventBarViewHandler;
            if (c5598Ka2 != null) {
                c5598Ka2.H(new SA2() { // from class: ir.nasim.A36
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C13090h.Ub();
                    }
                });
            }
            g2.W();
            oc().E2(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Tc(AbstractC10026ax1.b action) {
        if (!action.b()) {
            AbstractC7426Rr.a.B(Uri.parse(action.c()));
            return;
        }
        AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        aVar.A(contextS7, Uri.parse(action.c()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ub() {
        u2 = true;
        return C19938rB7.a;
    }

    private final void Uc() {
        this.sendText = null;
        this.sendUriString = null;
        this.sendUriMultiple = null;
        this.sendMimeType = null;
        this.peerIdDirectShare = null;
        if (C8386Vt0.ra()) {
            oc().y1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Vb(boolean isNeedToShowFeedBack) {
        if (isNeedToShowFeedBack) {
            C22042ua0.w9(this, InterfaceC21680tx0.INSTANCE.c().getDialog(), false, null, 6, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Vc() {
        if (getDialogsMode() != AbstractC13089g.b.c) {
            return false;
        }
        Mb(AbstractC13089g.b.a);
        Uc();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC7258Qy2 Wb(final C13090h c13090h) {
        AbstractC13042fc3.i(c13090h, "this$0");
        return new InterfaceC7258Qy2() { // from class: ir.nasim.F36
            @Override // ir.nasim.InterfaceC7258Qy2
            public final void d(FragmentManager fragmentManager, Fragment fragment) {
                C13090h.Xb(this.a, fragmentManager, fragment);
            }
        };
    }

    private final void Wc(int requestCode, String[] permissions, int[] grantResults) {
        Iterator it = this.requestPermissionsResultListeners.iterator();
        AbstractC13042fc3.h(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            AbstractC13042fc3.h(next, "next(...)");
            ((InterfaceC23769xU5) next).a(requestCode, permissions, grantResults);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xb(C13090h c13090h, FragmentManager fragmentManager, Fragment fragment) {
        C17468n10 c17468n10;
        AbstractC13042fc3.i(c13090h, "this$0");
        AbstractC13042fc3.i(fragment, "fragment");
        if (AbstractC13042fc3.d(fragment, c13090h) || (c17468n10 = c13090h.deleteChatSnackBar) == null || c17468n10 == null) {
            return;
        }
        c17468n10.f();
    }

    private final void Xc() {
        oc().y2();
    }

    private final void Yc(Bundle savedInstanceState) {
        TabLayout.g gVarY;
        if (this.tabLayout == null) {
            return;
        }
        int iZb = Zb();
        if (iZb == 0) {
            gd(savedInstanceState);
        } else if (iZb == 1) {
            md(savedInstanceState);
        } else if (iZb == s2) {
            ed(savedInstanceState);
        } else if (iZb == r2) {
            if (!uc() || C8386Vt0.a.f4()) {
                gd(savedInstanceState);
            } else {
                Zc(savedInstanceState);
            }
        }
        TabLayout tabLayout = this.tabLayout;
        if (tabLayout == null || (gVarY = tabLayout.y(this.lastSelectedPageIndex)) == null) {
            return;
        }
        gVarY.n();
    }

    private final int Zb() {
        int iT = AbstractC5969Lp4.d().T();
        return iT != -1 ? iT : this.currentDefaultTab;
    }

    private final void Zc(Bundle savedInstanceState) {
        FragmentManager fragmentManager = null;
        bd(this, savedInstanceState, null, 2, null);
        ir.nasim.features.bank.mybank.webview.a aVar = this.aiChatFragment;
        if (aVar != null) {
            this.activeFragment = aVar.J0();
            FragmentManager fragmentManager2 = this.rootSupportFragmentManager;
            if (fragmentManager2 == null) {
                AbstractC13042fc3.y("rootSupportFragmentManager");
            } else {
                fragmentManager = fragmentManager2;
            }
            fragmentManager.s().c(BC5.fragment_container, aVar.J0(), "myAiPage").h();
            int i2 = r2;
            this.lastSelectedPageIndex = i2;
            C5735Kp4.w().v(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ab(final AbstractC13083a.c cVar, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        String strC;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(763773389);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.D(cVar) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i3 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            EV4 ev4H = AvatarAsyncImagePainterKt.h(cVar.b(), null, false, 0, interfaceC22053ub1J, 0, 14);
            String strC2 = UY6.c(cVar.d() == ZN2.GROUP ? AbstractC12217eE5.join_to_group : AbstractC12217eE5.join_to_channel, interfaceC22053ub1J, 0);
            InterfaceC13157fl1 interfaceC13157fl1A = InterfaceC13157fl1.a.a();
            e.a aVar = androidx.compose.ui.e.a;
            AbstractC11456d23.b(ev4H, strC2, AbstractC9747aV.k(FV0.a(androidx.compose.foundation.layout.t.t(aVar, C17784nZ1.q(68.0f)), N46.g()), cVar.e(), cVar.h(), 0.0f, false, null, 28, null), null, interfaceC13157fl1A, 0.0f, null, interfaceC22053ub1J, 24576, 104);
            G10 g10 = G10.a;
            int i4 = G10.b;
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1J, i4).b().b()), interfaceC22053ub1J, 0);
            String strH = cVar.h();
            C9348Zn7 c9348Zn7M = g10.d(interfaceC22053ub1J, i4).m();
            C6399Nk7.a aVar2 = C6399Nk7.b;
            AbstractC9339Zm7.b(strH, null, g10.a(interfaceC22053ub1J, i4).F(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7M.b((16744447 & 1) != 0 ? c9348Zn7M.a.g() : 0L, (16744447 & 2) != 0 ? c9348Zn7M.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7M.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7M.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7M.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7M.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7M.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7M.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7M.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7M.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7M.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7M.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7M.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7M.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7M.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7M.b.h() : aVar2.a(), (16744447 & 65536) != 0 ? c9348Zn7M.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7M.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7M.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7M.c : null, (16744447 & 1048576) != 0 ? c9348Zn7M.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7M.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7M.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7M.b.k() : null), interfaceC22053ub1J, 0, 0, 65530);
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1J, i4).b().g()), interfaceC22053ub1J, 0);
            if (cVar.c() == W06.PRIVATE) {
                interfaceC22053ub1J.W(38286328);
                strC = UY6.c(AbstractC12217eE5.private_group_name, interfaceC22053ub1J, 0);
                interfaceC22053ub1J.Q();
            } else {
                interfaceC22053ub1J.W(38379545);
                strC = UY6.c(AbstractC12217eE5.public_group_name, interfaceC22053ub1J, 0);
                interfaceC22053ub1J.Q();
            }
            String strA = AbstractC5969Lp4.a(strC, cVar.d());
            AbstractC13042fc3.h(strA, "formatGroupType(...)");
            C9348Zn7 c9348Zn7E = g10.d(interfaceC22053ub1J, i4).e();
            AbstractC9339Zm7.b(strA, null, g10.a(interfaceC22053ub1J, i4).z(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7E.b((16744447 & 1) != 0 ? c9348Zn7E.a.g() : 0L, (16744447 & 2) != 0 ? c9348Zn7E.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7E.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7E.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7E.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7E.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7E.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7E.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7E.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7E.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7E.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7E.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7E.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7E.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7E.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7E.b.h() : aVar2.a(), (16744447 & 65536) != 0 ? c9348Zn7E.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7E.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7E.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7E.c : null, (16744447 & 1048576) != 0 ? c9348Zn7E.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7E.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7E.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7E.b.k() : null), interfaceC22053ub1J, 0, 0, 65530);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.M36
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C13090h.bb(this.a, cVar, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private final View ac(int i2) {
        TabLayout.g gVarY;
        TabLayout tabLayout = this.tabLayout;
        if (tabLayout == null || (gVarY = tabLayout.y(i2)) == null) {
            return null;
        }
        return gVarY.e();
    }

    private final void ad(Bundle savedInstanceState, String query) {
        if (this.aiChatFragment == null || savedInstanceState == null) {
            this.aiChatFragment = ir.nasim.features.bank.mybank.webview.a.r1.a(oc().F1(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 bb(C13090h c13090h, AbstractC13083a.c cVar, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c13090h, "$tmp2_rcvr");
        AbstractC13042fc3.i(cVar, "$groupPreviewModel");
        c13090h.ab(cVar, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    static /* synthetic */ void bd(C13090h c13090h, Bundle bundle, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bundle = null;
        }
        if ((i2 & 2) != 0) {
            str = null;
        }
        c13090h.ad(bundle, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cb(final AbstractC13083a.c cVar, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        String strYc;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-503507107);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.D(cVar) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.D(this) ? 32 : 16;
        }
        if ((i3 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            int iF = cVar.f() - cVar.g().size();
            interfaceC22053ub1J.W(2145294666);
            if (!cVar.g().isEmpty()) {
                AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.a), AbstractC19242q11.e(-1469552776, true, new b(iF, cVar), interfaceC22053ub1J, 54), interfaceC22053ub1J, C7252Qx5.i | 48);
            }
            interfaceC22053ub1J.Q();
            e.a aVar = androidx.compose.ui.e.a;
            G10 g10 = G10.a;
            int i4 = G10.b;
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1J, i4).b().b()), interfaceC22053ub1J, 0);
            if (iF == 0) {
                interfaceC22053ub1J.W(2081891959);
                strYc = yc(cVar, true, interfaceC22053ub1J, ((i3 << 3) & 896) | (i3 & 14) | 48);
                interfaceC22053ub1J.Q();
            } else if (iF > 0) {
                interfaceC22053ub1J.W(2082000614);
                strYc = yc(cVar, false, interfaceC22053ub1J, ((i3 << 3) & 896) | (i3 & 14) | 48) + Separators.SP + XY6.v(UY6.b(AbstractC17590nD5.member_preview_group_member_expect, iF, new Object[]{String.valueOf(iF)}, interfaceC22053ub1J, 0));
                interfaceC22053ub1J.Q();
            } else {
                interfaceC22053ub1J.W(2082340126);
                interfaceC22053ub1J.Q();
                strYc = "";
            }
            AbstractC9339Zm7.b(strYc, null, g10.a(interfaceC22053ub1J, i4).z(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1J, i4).e(), interfaceC22053ub1J, 0, 0, 65530);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.N36
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C13090h.db(this.a, cVar, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private final InterfaceC7258Qy2 cc() {
        return (InterfaceC7258Qy2) this.fragmentOnAttachListener.getValue();
    }

    private final void cd(TextView badge, int tabIndex) {
        if (tabIndex != 0) {
            badge.setBackground(AbstractC4043Dl1.f(C5721Ko.a.d(), KB5.ba_badge_bnav_icon));
            return;
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.getPaint().setColor(C5495Jo7.a.B0());
        shapeDrawable.getPaint().setAntiAlias(true);
        badge.setBackground(shapeDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 db(C13090h c13090h, AbstractC13083a.c cVar, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c13090h, "$tmp2_rcvr");
        AbstractC13042fc3.i(cVar, "$groupPreviewModel");
        c13090h.cb(cVar, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    private final void dd(TextView badge) {
        ViewGroup.LayoutParams layoutParams = badge.getLayoutParams();
        AbstractC13042fc3.g(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.height = C22078ud6.a(14.0f);
        layoutParams2.width = C22078ud6.a(14.0f);
        layoutParams2.leftMargin = C22078ud6.a(10.0f);
        layoutParams2.topMargin = C22078ud6.a(3.0f);
        badge.setMinHeight(C22078ud6.a(5.0f));
        badge.setMinWidth(C22078ud6.a(5.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void eb(final AbstractC13083a.c cVar, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(575487078);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.D(cVar) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.D(this) ? 32 : 16;
        }
        if ((i3 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = AbstractC10721c52.k(C18712p72.a, interfaceC22053ub1J);
                interfaceC22053ub1J.s(objB);
            }
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) objB;
            C19818qz6 c19818qz6L = AbstractC9273Zf4.l(true, null, interfaceC22053ub1J, 6, 2);
            interfaceC22053ub1J.W(1852730470);
            Object objB2 = interfaceC22053ub1J.B();
            if (objB2 == aVar.a()) {
                ComposeView composeView = this.composeView;
                objB2 = AbstractC13472gH6.d(Boolean.valueOf(composeView != null && composeView.getVisibility() == 0), null, 2, null);
                interfaceC22053ub1J.s(objB2);
            }
            InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB2;
            interfaceC22053ub1J.Q();
            if (fb(interfaceC9102Ym4)) {
                M10.f(false, AbstractC19242q11.e(2000541990, true, new c(c19818qz6L, interfaceC9102Ym4, cVar, interfaceC20315ro1), interfaceC22053ub1J, 54), interfaceC22053ub1J, 48, 1);
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.E36
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C13090h.hb(this.a, cVar, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private final void ed(Bundle savedInstanceState) {
        pd(savedInstanceState);
        InterfaceC17936no4 interfaceC17936no4 = this.myBankFragmentPageInterface;
        if (interfaceC17936no4 != null) {
            this.activeFragment = interfaceC17936no4.J0();
            FragmentManager fragmentManager = this.rootSupportFragmentManager;
            if (fragmentManager == null) {
                AbstractC13042fc3.y("rootSupportFragmentManager");
                fragmentManager = null;
            }
            fragmentManager.s().c(BC5.fragment_container, interfaceC17936no4.J0(), "myBankPage").h();
            int i2 = s2;
            this.lastSelectedPageIndex = i2;
            C5735Kp4.w().v(i2);
        }
    }

    private static final boolean fb(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    private final InterfaceC17936no4 fc() {
        androidx.lifecycle.h hVarA = hc().a();
        AbstractC13042fc3.g(hVarA, "null cannot be cast to non-null type ir.nasim.features.bank.mybank.MyBankFragmentPageInterface");
        return (InterfaceC17936no4) hVarA;
    }

    private final void fd(FrameLayout res) {
        int iD;
        ImageView imageView = (ImageView) res.findViewById(BC5.bottom_event_image);
        InterfaceC19868r46 interfaceC19868r46 = this.rootFragmentTheme;
        if (interfaceC19868r46 == null || (iD = interfaceC19868r46.d()) == 0) {
            return;
        }
        imageView.setVisibility(0);
        imageView.setImageResource(iD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gb(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z2) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z2));
    }

    private final void gd(Bundle savedInstanceState) {
        kd(savedInstanceState);
        Fragment fragment = this.dialogsContainerFragment;
        if (fragment != null) {
            this.activeFragment = fragment;
            FragmentManager fragmentManager = this.rootSupportFragmentManager;
            if (fragmentManager == null) {
                AbstractC13042fc3.y("rootSupportFragmentManager");
                fragmentManager = null;
            }
            fragmentManager.s().c(BC5.fragment_container, fragment, "dialogsContainerFragment").h();
            this.lastSelectedPageIndex = 0;
            C5735Kp4.w().v(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 hb(C13090h c13090h, AbstractC13083a.c cVar, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c13090h, "$tmp1_rcvr");
        AbstractC13042fc3.i(cVar, "$groupPreviewModel");
        c13090h.eb(cVar, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    private final void hd(CharSequence count) {
        TextView textView;
        if (TextUtils.isEmpty(count)) {
            rc();
            return;
        }
        TextView textView2 = this.chatBadgeTextView;
        if (textView2 != null) {
            if (textView2 != null) {
                textView2.setText(count);
            }
            TextView textView3 = this.chatBadgeTextView;
            if ((textView3 == null || textView3.getVisibility() != 0) && (textView = this.chatBadgeTextView) != null) {
                textView.setVisibility(0);
            }
        }
    }

    public static final /* synthetic */ void ib(C13090h c13090h, AbstractC13083a.c cVar, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        c13090h.ab(cVar, interfaceC22053ub1, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Runnable ic(final View view) {
        return new Runnable() { // from class: ir.nasim.K36
            @Override // java.lang.Runnable
            public final void run() {
                C13090h.jc(view, this);
            }
        };
    }

    private final void id() {
        int iX;
        G g2 = this.presenter;
        if (g2 == null || (iX = g2.x()) < 0) {
            return;
        }
        jd(iX);
        xd();
    }

    public static final /* synthetic */ void jb(C13090h c13090h, AbstractC13083a.c cVar, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        c13090h.cb(cVar, interfaceC22053ub1, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void jc(View view, final C13090h c13090h) {
        AbstractC13042fc3.i(view, "$view");
        AbstractC13042fc3.i(c13090h, "this$0");
        boolean zG = JF5.g();
        float f2 = zG ? 0.1f : 0.9f;
        int iApplyDimension = (int) TypedValue.applyDimension(1, 32, view.getResources().getDisplayMetrics());
        D20.a aVarA1 = C10600bs7.a.a(c13090h.p6()).X1(c13090h.oc().S1()).b2(17).X0(EnumC11622dK.b).c1(EnumC12874fK.a).a1(f2);
        Integer numR1 = c13090h.oc().R1();
        if (numR1 != null) {
            aVarA1.k2((int) ((numR1.doubleValue() * AbstractC3742Cd6.c()) + 0.5d));
        }
        if (zG) {
            aVarA1.I1(iApplyDimension);
        } else {
            aVarA1.J1(iApplyDimension);
        }
        D20 d20A = aVarA1.H1(8).N1(new UA2() { // from class: ir.nasim.L36
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C13090h.kc(this.a, (View) obj);
            }
        }).a();
        if (!c13090h.wc() || c13090h.lastSelectedPageIndex == s2) {
            return;
        }
        D20.K0(d20A, view, 0, 0, 6, null);
        c13090h.oc().Z1(J.c.a);
    }

    private final void jd(int tabIndex) {
        oc().v1(tabIndex, false);
        this.currentDefaultTab = tabIndex;
        HashMap map = new HashMap();
        map.put("tab_title", h6(mc()[tabIndex].intValue()));
        map.put("tab_num", Integer.valueOf(tabIndex + 1));
        map.put("back_stage", 1);
        C3343Am.i("navigation_set_default_tab", map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 kc(C13090h c13090h, View view) {
        AbstractC13042fc3.i(c13090h, "this$0");
        AbstractC13042fc3.i(view, "it");
        c13090h.onServicesBalloonClick.invoke();
        return C19938rB7.a;
    }

    private final void kd(Bundle savedInstanceState) {
        Boolean boolValueOf;
        InterfaceC22634va2 interfaceC22634va2W;
        if (this.dialogsContainerFragment == null || savedInstanceState == null) {
            if (C8386Vt0.J5()) {
                boolValueOf = null;
            } else {
                G g2 = this.presenter;
                boolean z2 = false;
                if (g2 != null && (interfaceC22634va2W = g2.w()) != null && interfaceC22634va2W.h()) {
                    z2 = true;
                }
                boolValueOf = Boolean.valueOf(z2);
            }
            this.dialogsContainerFragment = C8386Vt0.u8() ? bc().b(boolValueOf) : new YR1();
            if (boolValueOf != null) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("is_event_bar_enabled_argument", boolValueOf.booleanValue());
                Fragment fragment = this.dialogsContainerFragment;
                if (fragment != null) {
                    fragment.a8(bundle);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ShareData lc() {
        return new ShareData(this.sendText, this.sendUriString, this.sendUriMultiple, this.sendMimeType);
    }

    private final Integer[] mc() {
        return (Integer[]) this.tabTitles.getValue();
    }

    private final void md(Bundle savedInstanceState) {
        nd(savedInstanceState);
        C22042ua0 c22042ua0 = this.jaryanFragment;
        if (c22042ua0 != null) {
            this.activeFragment = c22042ua0;
            FragmentManager fragmentManager = this.rootSupportFragmentManager;
            if (fragmentManager == null) {
                AbstractC13042fc3.y("rootSupportFragmentManager");
                fragmentManager = null;
            }
            fragmentManager.s().c(BC5.fragment_container, c22042ua0, "jaryanFragment").h();
            this.lastSelectedPageIndex = 1;
            C5735Kp4.w().v(1);
        }
    }

    private final void nd(Bundle savedInstanceState) {
        InterfaceC22634va2 interfaceC22634va2W;
        if (this.jaryanFragment == null || savedInstanceState == null) {
            G g2 = this.presenter;
            this.jaryanFragment = InterfaceC7565Sg3.c(ec(), (g2 == null || (interfaceC22634va2W = g2.w()) == null) ? false : interfaceC22634va2W.h(), false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final I oc() {
        return (I) this.viewModel.getValue();
    }

    private final void od(LinearLayout tabStrip) {
        Bc(tabStrip);
    }

    private final void pc(int currentPosition) {
        if (u2) {
            Nb(currentPosition);
        } else {
            Ob(currentPosition);
        }
    }

    private final void pd(Bundle savedInstanceState) {
        if (this.myBankFragmentPageInterface == null || savedInstanceState == null) {
            this.myBankFragmentPageInterface = fc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void qc(AbstractC22884vz0.a callToast) {
        String str;
        if (callToast instanceof AbstractC22884vz0.a.f) {
            DY6 dy6 = DY6.a;
            String strH6 = h6(callToast.a());
            AbstractC13042fc3.h(strH6, "getString(...)");
            str = String.format(strH6, Arrays.copyOf(new Object[]{((AbstractC22884vz0.a.f) callToast).b()}, 1));
            AbstractC13042fc3.h(str, "format(...)");
        } else if (callToast instanceof AbstractC22884vz0.a.b) {
            DY6 dy62 = DY6.a;
            String strH62 = h6(callToast.a());
            AbstractC13042fc3.h(strH62, "getString(...)");
            str = String.format(strH62, Arrays.copyOf(new Object[]{((AbstractC22884vz0.a.b) callToast).b()}, 1));
            AbstractC13042fc3.h(str, "format(...)");
        } else if (callToast instanceof AbstractC22884vz0.a.c) {
            DY6 dy63 = DY6.a;
            String strH63 = h6(callToast.a());
            AbstractC13042fc3.h(strH63, "getString(...)");
            str = String.format(strH63, Arrays.copyOf(new Object[]{((AbstractC22884vz0.a.c) callToast).b()}, 1));
            AbstractC13042fc3.h(str, "format(...)");
        } else if (callToast instanceof AbstractC22884vz0.a.g) {
            DY6 dy64 = DY6.a;
            String strH64 = h6(callToast.a());
            AbstractC13042fc3.h(strH64, "getString(...)");
            str = String.format(strH64, Arrays.copyOf(new Object[]{Integer.valueOf(((AbstractC22884vz0.a.g) callToast).b())}, 1));
            AbstractC13042fc3.h(str, "format(...)");
        } else {
            str = null;
        }
        if (str != null) {
            Jd(str);
        }
    }

    private final void qd() {
        TabLayout tabLayout = this.tabLayout;
        if (tabLayout != null) {
            tabLayout.d(new r());
        }
    }

    private final void rc() {
        TextView textView;
        TextView textView2 = this.chatBadgeTextView;
        if (textView2 == null || textView2 == null || textView2.getVisibility() != 0 || (textView = this.chatBadgeTextView) == null) {
            return;
        }
        textView.setVisibility(4);
    }

    private final void rd() {
        String strE = C7183Qq.p().e("user_segment");
        String strValueOf = String.valueOf(String.valueOf(AbstractC5969Lp4.e().H().X0()).charAt(0));
        if (AbstractC13042fc3.d(strValueOf, strE)) {
            return;
        }
        C17213mb2.i("user_segment", strValueOf);
        C7183Qq.p().putString("user_segment", strValueOf);
    }

    private final void sc() {
        TextView textView;
        TextView textView2 = this.storyBadgeView;
        if (textView2 != null) {
            if ((textView2 == null || textView2.getVisibility() != 8) && (textView = this.storyBadgeView) != null) {
                textView.setVisibility(8);
            }
        }
    }

    private final void sd(View parentView) {
        ((ComposeView) parentView.findViewById(BC5.custom_event_bar)).setContent(AbstractC19242q11.c(20823616, true, new s()));
    }

    private final int tc(int currentPosition) {
        return currentPosition;
    }

    private final void td(View parentView) {
        G g2 = this.presenter;
        if (g2 != null) {
            InterfaceC22634va2 interfaceC22634va2W = g2.w();
            C5598Ka2 c5598Ka2 = new C5598Ka2(interfaceC22634va2W, this, this);
            this.eventBarViewHandler = c5598Ka2;
            try {
                c5598Ka2.f(parentView);
                if (interfaceC22634va2W.h()) {
                    oc().E2(true);
                    C5598Ka2 c5598Ka22 = this.eventBarViewHandler;
                    if (c5598Ka22 != null) {
                        c5598Ka22.h(parentView);
                    }
                    Lb();
                    Ob(this.lastSelectedPageIndex);
                }
            } catch (Exception e2) {
                C19406qI3.a("RootFragment", e2.getMessage(), new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean uc() {
        return ((Boolean) this.isAiTabEnabled.getValue()).booleanValue();
    }

    private final void ud(View parentView) {
        ComposeView composeView = (ComposeView) parentView.findViewById(BC5.install_update_bar);
        composeView.setContent(AbstractC19242q11.c(-564347557, true, new t(composeView)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean vc() {
        return C8386Vt0.a.h4();
    }

    private final void vd() {
        TabLayout.g gVarY;
        if (this.parent == null) {
            return;
        }
        Integer[] numArr = this.tabIcons;
        if (numArr == null) {
            AbstractC13042fc3.y("tabIcons");
            numArr = null;
        }
        Kb(numArr, mc());
        int i2 = q2;
        int i3 = 0;
        while (i3 < i2) {
            View viewInflate = LayoutInflater.from(this.parent).inflate(AbstractC12208eD5.navigation_bottom_tab, (ViewGroup) null);
            AbstractC13042fc3.g(viewInflate, "null cannot be cast to non-null type android.widget.FrameLayout");
            FrameLayout frameLayout = (FrameLayout) viewInflate;
            TextView textView = (TextView) frameLayout.findViewById(BC5.title);
            TextView textView2 = (TextView) frameLayout.findViewById(BC5.badge);
            textView.setTextColor(this.tabDisableColor);
            textView2.setTypeface(C6011Lu2.i());
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            frameLayout.setBackgroundDrawable(AbstractC4310Eo7.g());
            if (i3 == 0) {
                this.chatBadgeTextView = textView2;
                AbstractC13042fc3.f(textView2);
                cd(textView2, i3);
            }
            if (i3 == 1) {
                this.storyBadgeView = textView2;
                AbstractC13042fc3.f(textView2);
                cd(textView2, i3);
                dd(textView2);
            }
            if (uc() && i3 == r2) {
                this.myAiBadgeView = textView2;
                AbstractC13042fc3.f(textView2);
                cd(textView2, i3);
                dd(textView2);
            }
            if (i3 == s2) {
                this.myBankBadgeView = textView2;
                AbstractC13042fc3.f(textView2);
                cd(textView2, i3);
                dd(textView2);
            }
            Resources resourcesB6 = b6();
            Integer[] numArr2 = this.tabIcons;
            if (numArr2 == null) {
                AbstractC13042fc3.y("tabIcons");
                numArr2 = null;
            }
            Drawable drawableL = AbstractC21710u02.l(resourcesB6.getDrawable(numArr2[i3].intValue()));
            AbstractC13042fc3.h(drawableL, "wrap(...)");
            if (this.isFromNotifications) {
                AbstractC21710u02.h(drawableL, i3 == 0 ? this.tabActiveColor : this.tabDisableColor);
                if (i3 == 0) {
                    textView.setTextColor(this.tabActiveColor);
                }
            } else if (i3 == Zb()) {
                textView.setTextColor(this.tabActiveColor);
                Resources resourcesB62 = b6();
                Integer[] numArr3 = this.tabIconsSelected;
                if (numArr3 == null) {
                    AbstractC13042fc3.y("tabIconsSelected");
                    numArr3 = null;
                }
                drawableL = AbstractC21710u02.l(resourcesB62.getDrawable(numArr3[i3].intValue()));
                AbstractC21710u02.h(drawableL, this.tabActiveColor);
            } else {
                AbstractC21710u02.h(drawableL, this.tabDisableColor);
            }
            textView.setText(mc()[i3].intValue());
            textView.setTypeface(C6011Lu2.k());
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, drawableL, (Drawable) null, (Drawable) null);
            textView.setCompoundDrawablePadding(C22078ud6.a(-4.0f));
            TabLayout tabLayout = this.tabLayout;
            if (tabLayout != null && (gVarY = tabLayout.y(i3)) != null) {
                gVarY.r(frameLayout);
            }
            TabLayout tabLayout2 = this.tabLayout;
            if (tabLayout2 != null) {
                tabLayout2.setTabRippleColor(null);
            }
            i3++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean wc() {
        List listC0 = Q7().B0().C0();
        AbstractC13042fc3.h(listC0, "getFragments(...)");
        if (listC0.size() > 0) {
            return listC0.get(listC0.size() - 1) instanceof AbstractC13089g;
        }
        return false;
    }

    private final boolean wd() {
        return !this.isShowingSuggestDialogBefore && this.shouldCalculateTabSelectionForFirstTime && this.isInGoldenTimeForCountTabClick;
    }

    private final void xc() {
        RootActivity.Companion companion = RootActivity.INSTANCE;
        if (companion.c()) {
            FragmentManager fragmentManager = null;
            kd(null);
            Fragment fragment = this.dialogsContainerFragment;
            if (fragment != null) {
                FragmentManager fragmentManager2 = this.rootSupportFragmentManager;
                if (fragmentManager2 == null) {
                    AbstractC13042fc3.y("rootSupportFragmentManager");
                    fragmentManager2 = null;
                }
                fragmentManager2.s().p(fragment);
                FragmentManager fragmentManager3 = this.rootSupportFragmentManager;
                if (fragmentManager3 == null) {
                    AbstractC13042fc3.y("rootSupportFragmentManager");
                } else {
                    fragmentManager = fragmentManager3;
                }
                fragmentManager.s().c(BC5.fragment_container, fragment, "dialogsContainerFragment").h();
            }
            companion.d(false);
        }
    }

    private final void xd() {
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        AlertDialog alertDialogA = new AlertDialog.a(contextS7).m(h6(AbstractC12217eE5.set_default_tab_description_title)).i(h6(AbstractC12217eE5.set_default_tab_description_text)).l(h6(AbstractC12217eE5.permission_ok), new DialogInterface.OnClickListener() { // from class: ir.nasim.J36
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                C13090h.yd(dialogInterface, i2);
            }
        }).a();
        q9(alertDialogA);
        alertDialogA.setCanceledOnTouchOutside(false);
    }

    private final String yc(AbstractC13083a.c cVar, boolean z2, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        String str;
        String strD;
        interfaceC22053ub1.W(1975965969);
        if (z2) {
            interfaceC22053ub1.W(1092393918);
            str = UY6.c(AbstractC12217eE5.member_preview_group_and_seprator, interfaceC22053ub1, 0) + Separators.SP;
            interfaceC22053ub1.Q();
        } else {
            interfaceC22053ub1.W(1092492002);
            str = Separators.SP + UY6.c(AbstractC12217eE5.member_preview_group_seprator, interfaceC22053ub1, 0);
            interfaceC22053ub1.Q();
        }
        String str2 = str;
        int size = cVar.g().size();
        if (size == 1) {
            interfaceC22053ub1.W(-1488774127);
            strD = UY6.d(AbstractC12217eE5.member_preview_group, new Object[]{((R14) cVar.g().get(0)).c()}, interfaceC22053ub1, 0);
            interfaceC22053ub1.Q();
        } else if (size != 2) {
            interfaceC22053ub1.W(-1488758227);
            List listF1 = AbstractC15401jX0.f1(cVar.g(), 2);
            String str3 = Separators.SP + UY6.c(AbstractC12217eE5.member_preview_group_seprator, interfaceC22053ub1, 0);
            interfaceC22053ub1.W(-1488761014);
            boolean zD = interfaceC22053ub1.D(this);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.P36
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C13090h.Ac(this.a, (R14) obj);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            strD = AbstractC15401jX0.A0(listF1, str3, null, null, 0, null, (UA2) objB, 30, null) + str2 + UY6.d(AbstractC12217eE5.member_preview_group, new Object[]{((R14) cVar.g().get(2)).c()}, interfaceC22053ub1, 0);
            interfaceC22053ub1.Q();
        } else {
            interfaceC22053ub1.W(-1488770611);
            List listG = cVar.g();
            interfaceC22053ub1.W(-1488768534);
            boolean zD2 = interfaceC22053ub1.D(this);
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new UA2() { // from class: ir.nasim.O36
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C13090h.zc(this.a, (R14) obj);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            strD = AbstractC15401jX0.A0(listG, str2, null, null, 0, null, (UA2) objB2, 30, null);
            interfaceC22053ub1.Q();
        }
        interfaceC22053ub1.Q();
        return strD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yd(DialogInterface dialogInterface, int i2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence zc(C13090h c13090h, R14 r14) {
        AbstractC13042fc3.i(c13090h, "this$0");
        AbstractC13042fc3.i(r14, "member");
        String strI6 = c13090h.i6(AbstractC12217eE5.member_preview_group, r14.c());
        AbstractC13042fc3.h(strI6, "getString(...)");
        return strI6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zd(final Context context, ChangeLogData changeLogData, String changeLogHash) {
        if (changeLogData == null || changeLogHash == null || changeLogData.getChangeLog() == null) {
            return;
        }
        C24398yZ.e(context, changeLogData.getVersionName(), changeLogData.getChangeLog(), new SA2() { // from class: ir.nasim.Q36
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C13090h.Ad(context);
            }
        }).f();
        oc().G2(new ChangeLogData(null, null, 3, null));
    }

    @Override // ir.nasim.C5598Ka2.d
    public void B0() {
        InterfaceC17936no4 interfaceC17936no4 = this.myBankFragmentPageInterface;
        if (interfaceC17936no4 != null) {
            interfaceC17936no4.F2(0);
        }
    }

    public final void Bd(final C11458d25 peer, final ExPeerType exPeerType, String message) {
        AbstractC13042fc3.i(peer, "peer");
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        if (o6() == null || G5() == null) {
            return;
        }
        if (C8386Vt0.u8()) {
            Ed(peer, exPeerType, message);
            return;
        }
        I iOc = oc();
        int peerId = peer.getPeerId();
        W25 w25S = peer.s();
        AbstractC13042fc3.h(w25S, "getPeerType(...)");
        final C17067mL1 c17067mL1J1 = iOc.J1(peerId, w25S);
        if (c17067mL1J1 == null) {
            C19406qI3.b("RootFragment", "temp dialog in DialogContainerFragment is null with id:" + peer.getPeerId());
            return;
        }
        AbstractC13463gG6 aVar = new AbstractC13463gG6.a(S7().getString(AbstractC12217eE5.snackbar_action_undo), Integer.valueOf(KB5.undo), true, new SA2() { // from class: ir.nasim.B36
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C13090h.Cd(this.a, c17067mL1J1);
            }
        });
        oc().D1(peer);
        if (message == null || AbstractC20762sZ6.n0(message)) {
            message = (exPeerType == ExPeerType.PRIVATE || exPeerType == ExPeerType.BOT) ? S7().getString(AbstractC12217eE5.delete_chat_in_dialogs_container) : exPeerType == ExPeerType.CHANNEL ? S7().getString(AbstractC12217eE5.delete_channel_in_dialogs_container) : S7().getString(AbstractC12217eE5.delete_group_in_dialogs_container);
        } else {
            aVar = new AbstractC13463gG6.b(KB5.admin);
        }
        C17468n10 c17468n10 = this.deleteChatSnackBar;
        if (c17468n10 != null) {
            c17468n10.n(message, aVar, new UA2() { // from class: ir.nasim.C36
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C13090h.Dd(this.a, peer, exPeerType, ((Boolean) obj).booleanValue());
                }
            });
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void G6(Bundle savedInstanceState) {
        super.G6(savedInstanceState);
        AbstractC5969Lp4.d().w();
    }

    @Override // androidx.fragment.app.Fragment
    public void H6(int requestCode, int resultCode, Intent data) {
        Bundle extras;
        Bundle extras2;
        super.H6(requestCode, resultCode, data);
        if (resultCode == -1 && requestCode == 1099) {
            Long lValueOf = (data == null || (extras2 = data.getExtras()) == null) ? null : Long.valueOf(extras2.getLong("catchIdExtra", -1L));
            Long lValueOf2 = (data == null || (extras = data.getExtras()) == null) ? null : Long.valueOf(extras.getLong("payIdExtra", -1L));
            if ((lValueOf != null && lValueOf.longValue() == -1) || (lValueOf2 != null && lValueOf2.longValue() == -1)) {
                L2(AbstractC12217eE5.toast_scanner_noValid_result);
                return;
            }
            String str = "/barCode*" + lValueOf + Separators.STAR + lValueOf2;
            G g2 = this.presenter;
            C11458d25 c11458d25V = g2 != null ? g2.v() : null;
            if (c11458d25V != null) {
                Rc(c11458d25V, str);
            }
        }
    }

    public final void Jd(String message) {
        AbstractC13042fc3.i(message, DialogEntity.COLUMN_MESSAGE);
        try {
            C17468n10 c17468n10 = this.baleSnackBar;
            if (c17468n10 == null || this.bottomNavigationContainer == null || c17468n10 == null) {
                return;
            }
            c17468n10.o(message);
        } catch (Exception e2) {
            C19406qI3.j("RootFragment", "showSnackBar error: " + e2.getMessage(), new Object[0]);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle saveInstance) {
        super.M6(saveInstance);
        Rb();
        G g2 = new G(this);
        this.presenter = g2;
        this.basePresenter = g2;
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        AbstractC5963Lo7.c(contextS7);
        Bundle bundleE5 = E5();
        if (bundleE5 != null) {
            this.sendText = bundleE5.getString("send_text", null);
            this.sendUriString = bundleE5.getString("send_uri", null);
            this.sendUriMultiple = bundleE5.getStringArrayList("send_uri_multiple");
            this.sendMimeType = bundleE5.getString("send_mime", null);
            this.isFromNotifications = bundleE5.getBoolean("is_from_notification", false);
            if (this.sendText != null || this.sendUriString != null || this.sendUriMultiple != null) {
                ld(AbstractC13089g.b.c);
                this.peerIdDirectShare = bundleE5.getString("peer_id_direct_share", null);
            }
        }
        if (AbstractC5969Lp4.e().H() != null) {
            int iT = AbstractC5969Lp4.e().H().T();
            if (iT == -1) {
                iT = oc().H1();
            }
            this.currentDefaultTab = iT;
            G g3 = this.presenter;
            if (g3 != null) {
                this.isShowingSuggestDialogBefore = g3.D();
                g3.n();
            }
        }
        rd();
        Q7().B0().m(cc());
        C15225jD4.b().a(this, C15225jD4.n);
        C15225jD4.b().a(this, C15225jD4.y);
        C15225jD4.b().a(this, C15225jD4.x);
        if (C8386Vt0.a.I6()) {
            Qb();
        }
    }

    @Override // ir.nasim.features.root.AbstractC13089g
    public void O9() {
        G g2 = this.presenter;
        if (g2 != null) {
            g2.l();
        }
    }

    @Override // ir.nasim.features.root.AbstractC13089g
    public void P9() {
        FragmentManager fragmentManagerB0 = Q7().B0();
        AbstractC13042fc3.h(fragmentManagerB0, "getSupportFragmentManager(...)");
        List listC0 = fragmentManagerB0.C0();
        AbstractC13042fc3.h(listC0, "getFragments(...)");
        Iterator it = listC0.iterator();
        while (it.hasNext()) {
            if (!(((Fragment) it.next()) instanceof AbstractC13089g)) {
                fragmentManagerB0.m1();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Drawable drawableF;
        AbstractC13042fc3.i(inflater, "inflater");
        this.parent = (RootActivity) A5();
        View viewInflate = inflater.inflate(AbstractC12208eD5.fragment_root, container, false);
        AbstractC13042fc3.g(viewInflate, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) viewInflate;
        C16913m46 c16913m46A = C20477s46.a.a();
        this.tabIcons = c16913m46A.f();
        this.tabIconsSelected = c16913m46A.e();
        this.rootFragmentTheme = c16913m46A;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        this.tabActiveColor = c5495Jo7.x2();
        this.tabDisableColor = c5495Jo7.z2();
        this.tabLayout = (TabLayout) frameLayout.findViewById(BC5.tabs);
        this.composeView = (ComposeView) frameLayout.findViewById(BC5.compose_bottom_sheet);
        this.bottomNavigationContainer = (FrameLayout) frameLayout.findViewById(BC5.bottomNavigation_container);
        this.shadowTabLayout = (FrameLayout) frameLayout.findViewById(BC5.bottomNavigation_shadow_container);
        this.rootSupportFragmentManager = F5();
        if (c5495Jo7.J2() && (drawableF = AbstractC4043Dl1.f(S7(), KB5.tab_bar_shadow)) != null) {
            AbstractC21710u02.h(drawableF, c5495Jo7.v2());
            FrameLayout frameLayout2 = this.shadowTabLayout;
            if (frameLayout2 == null) {
                AbstractC13042fc3.y("shadowTabLayout");
                frameLayout2 = null;
            }
            frameLayout2.setBackground(drawableF);
        }
        C17468n10 c17468n10 = new C17468n10(frameLayout, null, 0, 6, null);
        this.baleSnackBar = c17468n10;
        FrameLayout frameLayout3 = this.bottomNavigationContainer;
        if (frameLayout3 != null) {
            c17468n10.k(frameLayout3);
        }
        C17468n10 c17468n102 = new C17468n10(frameLayout, null, 0, 6, null);
        this.deleteChatSnackBar = c17468n102;
        FrameLayout frameLayout4 = this.bottomNavigationContainer;
        if (frameLayout4 != null) {
            c17468n102.k(frameLayout4);
            C17468n10 c17468n103 = this.deleteChatSnackBar;
            if (c17468n103 != null) {
                c17468n103.m(5000);
            }
        }
        vd();
        Yc(savedInstanceState);
        if (C8386Vt0.J5()) {
            sd(frameLayout);
        } else {
            td(frameLayout);
        }
        TabLayout tabLayout = this.tabLayout;
        View childAt = tabLayout != null ? tabLayout.getChildAt(0) : null;
        AbstractC13042fc3.g(childAt, "null cannot be cast to non-null type android.widget.LinearLayout");
        od((LinearLayout) childAt);
        qd();
        fd(frameLayout);
        if (AbstractC5969Lp4.d().T() != -1) {
            AbstractC5969Lp4.d().E1(-1);
        }
        Lc();
        if (oc().d2()) {
            ud(frameLayout);
        }
        Hc();
        Ic();
        return frameLayout;
    }

    @Override // ir.nasim.features.root.AbstractC13089g
    /* renamed from: Q9, reason: from getter */
    public C11458d25 getCurrentPeer() {
        return this.currentPeer;
    }

    @Override // ir.nasim.features.root.AbstractC13089g
    /* renamed from: R9, reason: from getter */
    public AbstractC13089g.b getDialogsMode() {
        return this.dialogsMode;
    }

    public final void Rc(C11458d25 peer, String message) {
        AbstractC13042fc3.i(peer, "peer");
        AbstractC13089g.aa(this, peer, null, null, false, message, null, false, 64, null);
    }

    @Override // ir.nasim.InterfaceC19822r00
    public void S0() {
        List listC0 = F5().C0();
        AbstractC13042fc3.h(listC0, "getFragments(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : listC0) {
            if (obj instanceof AbstractC22105ug3) {
                arrayList.add(obj);
            }
        }
        AbstractC22105ug3 abstractC22105ug3 = (AbstractC22105ug3) AbstractC15401jX0.s0(arrayList);
        if (abstractC22105ug3 == null || !abstractC22105ug3.D6()) {
            return;
        }
        abstractC22105ug3.O9();
    }

    @Override // ir.nasim.features.root.AbstractC13089g
    /* renamed from: S9, reason: from getter */
    public boolean getIsSharingDialogSelected() {
        return this.isSharingDialogSelected;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        FragmentManager fragmentManagerB0;
        super.T6();
        G g2 = this.presenter;
        if (g2 != null) {
            g2.b();
        }
        Od();
        DrawerToolbar.INSTANCE.a(false);
        this.baleSnackBar = null;
        TabLayout tabLayout = this.tabLayout;
        if (tabLayout != null) {
            tabLayout.o();
        }
        FragmentActivity fragmentActivityA5 = A5();
        if (fragmentActivityA5 != null && (fragmentManagerB0 = fragmentActivityA5.B0()) != null) {
            fragmentManagerB0.v1(cc());
        }
        this.deleteChatSnackBar = null;
        C6879Pj2.a.t(null);
        C5735Kp4.w().u(null);
        this.dialogsContainerFragment = null;
        this.activeFragment = null;
        this.jaryanFragment = null;
        this.aiChatFragment = null;
        this.myBankFragmentPageInterface = null;
    }

    @Override // ir.nasim.features.root.AbstractC13089g
    public void T9(C11458d25 peer, long rid, String param) {
        AbstractC13042fc3.i(peer, "peer");
        AbstractC13042fc3.i(param, "param");
        PP0.a.b(Long.valueOf(System.currentTimeMillis()));
        G g2 = this.presenter;
        if (g2 != null) {
            g2.t(peer, new n(peer, rid, param));
        }
    }

    @Override // ir.nasim.features.root.AbstractC13089g
    public void U9() {
        C22042ua0.A9(this, InterfaceC21680tx0.INSTANCE.a().a(), false, null, 6, null);
    }

    @Override // ir.nasim.features.root.AbstractC13089g
    public void V9(Bundle bundle) {
        Fragment fragment;
        TabLayout.g gVarY;
        AbstractC13042fc3.i(bundle, "bundle");
        TabLayout tabLayout = this.tabLayout;
        if (tabLayout != null && (gVarY = tabLayout.y(0)) != null) {
            gVarY.n();
        }
        Fragment fragment2 = this.dialogsContainerFragment;
        if (fragment2 != null && (fragment2 instanceof YR1)) {
            YR1 yr1 = fragment2 instanceof YR1 ? (YR1) fragment2 : null;
            if (yr1 != null) {
                yr1.pd(0);
            }
        } else if (C8386Vt0.u8() && (fragment = this.dialogsContainerFragment) != null && fragment != null) {
            bc().a(fragment);
        }
        if (!C8386Vt0.s7()) {
            String strH6 = h6(AbstractC12217eE5.toast_call_link_not_supported);
            AbstractC13042fc3.h(strH6, "getString(...)");
            Jd(strH6);
        } else {
            String string = bundle.getString("EXTRA_CALL_LINK_INTENT");
            if (string != null) {
                AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new o(string, null), 3, null);
            }
        }
    }

    @Override // ir.nasim.features.root.AbstractC13089g
    public void W9(final int discussionGroupId, final long topId, final long topDate, boolean shouldLoadComment, final HQ0 spot) {
        AbstractC13042fc3.i(spot, "spot");
        if (oc().c2()) {
            return;
        }
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new p(shouldLoadComment, this, topId, topDate, discussionGroupId, null), 3, null).s(new UA2() { // from class: ir.nasim.I36
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C13090h.Qc(this.a, discussionGroupId, topId, topDate, spot, (Throwable) obj);
            }
        });
    }

    @Override // ir.nasim.InterfaceC14538i46
    public void X1() {
        G g2 = this.presenter;
        if (g2 != null) {
            Context contextS7 = S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            AlertDialog.a aVar = new AlertDialog.a(contextS7);
            String strH6 = h6(AbstractC12217eE5.set_default_tab_text);
            AbstractC13042fc3.h(strH6, "getString(...)");
            AlertDialog alertDialogA = aVar.i(AbstractC20153rZ6.M(strH6, "{1}", g2.z(), false, 4, null)).l(h6(AbstractC12217eE5.set_default_tab_ok), new DialogInterface.OnClickListener() { // from class: ir.nasim.G36
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    C13090h.Ld(this.a, dialogInterface, i2);
                }
            }).j(h6(AbstractC12217eE5.set_default_tab_cancel), null).a();
            q9(alertDialogA);
            alertDialogA.setCanceledOnTouchOutside(false);
        }
    }

    @Override // ir.nasim.features.root.AbstractC13089g
    public void Y9(C11458d25 peer, Long rid, Long sortKey, boolean shouldLoadMessage, String message, String jaryanTabType, boolean isAllowingStateLossEnabled) {
        AbstractC13042fc3.i(peer, "peer");
        AbstractC13089g.ba(this, peer, rid, sortKey, shouldLoadMessage, message, jaryanTabType, false, false, null, null, false, null, 3840, null);
    }

    public final InterfaceC11677dQ0 Yb() {
        InterfaceC11677dQ0 interfaceC11677dQ0 = this.chatNavigator;
        if (interfaceC11677dQ0 != null) {
            return interfaceC11677dQ0;
        }
        AbstractC13042fc3.y("chatNavigator");
        return null;
    }

    @Override // ir.nasim.InterfaceC14538i46
    public void Z1() {
        this.isInGoldenTimeForCountTabClick = false;
    }

    @Override // ir.nasim.InterfaceC14538i46
    public boolean Z3() {
        return oc().d2();
    }

    @Override // ir.nasim.features.root.AbstractC13089g
    public void Z9(C11458d25 peer, Long rid, Long sortKey, boolean shouldLoadMessage, String message, String jaryanTabType, boolean isAllowingStateLossEnabled, boolean openComment, C11458d25 intendedPeer, Boolean joinViaLink, boolean isOpenedFromDialogListOrDialogAd, EmptyStateOnboardingItemAction emptyStateOnboardingItemAction) {
        AbstractC13042fc3.i(peer, "peer");
        AbstractC13042fc3.i(emptyStateOnboardingItemAction, "emptyStateOnboardingItemAction");
        PP0.a.b(Long.valueOf(System.currentTimeMillis()));
        G g2 = this.presenter;
        if (g2 != null) {
            g2.t(peer, new q(peer, rid, sortKey, shouldLoadMessage, message, jaryanTabType, intendedPeer, joinViaLink, isOpenedFromDialogListOrDialogAd, emptyStateOnboardingItemAction, isAllowingStateLossEnabled));
        }
    }

    @Override // ir.nasim.C22042ua0
    public boolean a() {
        TabLayout.g gVarY;
        if (this.lastSelectedPageIndex == 0) {
            Fragment fragment = this.dialogsContainerFragment;
            YR1 yr1 = fragment instanceof YR1 ? (YR1) fragment : null;
            if (yr1 != null && yr1.a()) {
                return true;
            }
        }
        if (this.lastSelectedPageIndex == Zb()) {
            return Vc();
        }
        TabLayout tabLayout = this.tabLayout;
        if (tabLayout != null && (gVarY = tabLayout.y(Zb())) != null) {
            gVarY.n();
        }
        return true;
    }

    @Override // ir.nasim.InterfaceC19822r00
    public void a1() {
        C24480yh2.a.c().h();
    }

    @Override // ir.nasim.InterfaceC14538i46
    public void b1(String count) {
        AbstractC13042fc3.i(count, "count");
        hd(count);
    }

    public final InterfaceC23422wt4 bc() {
        InterfaceC23422wt4 interfaceC23422wt4 = this.dialogListNavigator;
        if (interfaceC23422wt4 != null) {
            return interfaceC23422wt4;
        }
        AbstractC13042fc3.y("dialogListNavigator");
        return null;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void c7() {
        super.c7();
        C24480yh2.a.c().h();
        C21448tg3.c();
        G g2 = this.presenter;
        if (g2 != null) {
            g2.M();
        }
    }

    @Override // ir.nasim.features.root.AbstractC13089g
    public void ca(String token, boolean isOpenOutSideOfBale) {
        AbstractC13042fc3.i(token, "token");
        oc().M1(token, isOpenOutSideOfBale);
    }

    @Override // ir.nasim.features.root.AbstractC13089g
    public void da(String storyId) {
        if (storyId != null) {
            C22042ua0.A9(this, ec().g(AbstractC5969Lp4.f(), storyId), false, null, 6, null);
        }
    }

    public final InterfaceC9687aO2 dc() {
        InterfaceC9687aO2 interfaceC9687aO2 = this.groupTypeMakerNavigator;
        if (interfaceC9687aO2 != null) {
            return interfaceC9687aO2;
        }
        AbstractC13042fc3.y("groupTypeMakerNavigator");
        return null;
    }

    @Override // ir.nasim.C15225jD4.b
    public void didReceivedNotification(int id, Object... args) {
        AbstractC13042fc3.i(args, "args");
        if (id == C15225jD4.i) {
            C5598Ka2 c5598Ka2 = this.eventBarViewHandler;
            if (c5598Ka2 == null || c5598Ka2 == null) {
                return;
            }
            c5598Ka2.j();
            return;
        }
        if (id == C15225jD4.x) {
            Kd();
        } else if (id == C15225jD4.y) {
            sc();
        }
    }

    @Override // ir.nasim.features.root.AbstractC13089g
    public void ea(EnumC14097hL4 openedPFMFrom) {
        AbstractC13042fc3.i(openedPFMFrom, "openedPFMFrom");
        RootActivity rootActivity = this.parent;
        if (rootActivity != null) {
            n8(PFMActivity.INSTANCE.a(rootActivity, openedPFMFrom));
        }
    }

    public final InterfaceC7565Sg3 ec() {
        InterfaceC7565Sg3 interfaceC7565Sg3 = this.jaryanNavigator;
        if (interfaceC7565Sg3 != null) {
            return interfaceC7565Sg3;
        }
        AbstractC13042fc3.y("jaryanNavigator");
        return null;
    }

    @Override // ir.nasim.features.root.AbstractC13089g
    public void fa() {
        C22042ua0.A9(this, ec().b(), false, null, 6, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void g7(int requestCode, String[] permissions, int[] grantResults) {
        AbstractC13042fc3.i(permissions, "permissions");
        AbstractC13042fc3.i(grantResults, "grantResults");
        super.g7(requestCode, permissions, grantResults);
        Wc(requestCode, permissions, grantResults);
        if (requestCode == 1011) {
            if ((!(grantResults.length == 0)) && grantResults[0] == 0) {
                startActivityForResult(new Intent(this.parent, (Class<?>) SimpleScannerActivity.class), 1099);
            }
        }
    }

    @Override // ir.nasim.features.root.AbstractC13089g
    public void ga() {
        C22042ua0.A9(this, ec().i(), false, null, 6, null);
    }

    /* renamed from: gc, reason: from getter */
    public final InterfaceC17936no4 getMyBankFragmentPageInterface() {
        return this.myBankFragmentPageInterface;
    }

    @Override // ir.nasim.C5598Ka2.b
    public void h4() {
        Sc();
        G g2 = this.presenter;
        if (g2 != null) {
            g2.J();
        }
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void h7() {
        C11458d25 c11458d25;
        if (getBaleResumed()) {
            S0();
        }
        super.h7();
        C5735Kp4.w().u(this);
        if (this.parent == null) {
            this.parent = (RootActivity) A5();
        }
        try {
            G g2 = this.presenter;
            if (g2 != null) {
                g2.K();
            }
            this.currentDefaultTab = oc().H1();
            AbstractC13089g.b dialogsMode = getDialogsMode();
            AbstractC13089g.b bVar = AbstractC13089g.b.c;
            if (dialogsMode == bVar && (this.sendText != null || this.sendUriString != null || this.sendUriMultiple != null || (C8386Vt0.ra() && !(((H) oc().V1().getValue()).f() instanceof L.a)))) {
                Mb(bVar);
                final String str = this.peerIdDirectShare;
                if (str != null) {
                    new Handler().postDelayed(new Runnable() { // from class: ir.nasim.x36
                        @Override // java.lang.Runnable
                        public final void run() {
                            C13090h.Mc(this.a, str);
                        }
                    }, 100L);
                    return;
                }
                return;
            }
            if (getDialogsMode() != AbstractC13089g.b.a || (c11458d25 = this.pendingPeer) == null) {
                return;
            }
            Rc(c11458d25, this.pendingMessage);
            this.pendingPeer = null;
            this.pendingMessage = null;
        } catch (Exception e2) {
            C19406qI3.b("RootFragment", "Error: " + e2.getMessage());
        }
    }

    @Override // ir.nasim.features.root.AbstractC13089g
    public void ha(String query) {
        String strF1;
        TabLayout tabLayout;
        TabLayout.g gVarY;
        if (uc()) {
            int i2 = r2;
            if (Pc(i2)) {
                return;
            }
            P9();
            ir.nasim.features.bank.mybank.webview.a aVar = this.aiChatFragment;
            if (aVar == null || (strF1 = aVar.oa()) == null) {
                strF1 = oc().F1();
            }
            Uri.Builder builderBuildUpon = Uri.parse(strF1).buildUpon();
            if (query != null) {
                builderBuildUpon.encodedQuery(query);
            }
            String string = builderBuildUpon.build().toString();
            AbstractC13042fc3.h(string, "toString(...)");
            ir.nasim.features.bank.mybank.webview.a aVar2 = this.aiChatFragment;
            if (aVar2 != null) {
                aVar2.ka(string);
            } else {
                ir.nasim.features.bank.mybank.webview.a aVarA = ir.nasim.features.bank.mybank.webview.a.r1.a(string, false);
                this.aiChatFragment = aVarA;
                if (aVarA != null) {
                    FragmentManager fragmentManager = this.rootSupportFragmentManager;
                    if (fragmentManager == null) {
                        AbstractC13042fc3.y("rootSupportFragmentManager");
                        fragmentManager = null;
                    }
                    fragmentManager.s().c(BC5.fragment_container, aVarA.J0(), "myAiPage").h();
                }
            }
            if (i2 < 0 || (tabLayout = this.tabLayout) == null || (gVarY = tabLayout.y(i2)) == null) {
                return;
            }
            gVarY.n();
        }
    }

    public final InterfaceC16806lt6 hc() {
        InterfaceC16806lt6 interfaceC16806lt6 = this.servicesNavigator;
        if (interfaceC16806lt6 != null) {
            return interfaceC16806lt6;
        }
        AbstractC13042fc3.y("servicesNavigator");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void i7(Bundle outState) {
        AbstractC13042fc3.i(outState, "outState");
        try {
            outState.putString("Keep it from crashing", "Don't remove this.");
            super.i7(outState);
        } catch (Exception e2) {
            C19406qI3.b("RootFragment", "Error: " + e2.getMessage());
        }
    }

    @Override // ir.nasim.features.root.AbstractC13089g
    public void ia(int index) {
        TabLayout.g gVarY;
        TabLayout tabLayout = this.tabLayout;
        if (tabLayout == null || (gVarY = tabLayout.y(index)) == null) {
            return;
        }
        gVarY.n();
    }

    @Override // ir.nasim.features.root.AbstractC13089g
    public void ja(String tabName, boolean openStory) {
        AbstractC13042fc3.i(tabName, "tabName");
        this.jaryanAndroidProperties.putString("LAST_JARYAN_TAB_SELECTED_KEY", tabName);
        C15225jD4.b().c(C15225jD4.A, tabName, Boolean.valueOf(openStory));
    }

    @Override // ir.nasim.InterfaceC14538i46
    public void k1() {
        TextView textView;
        TextView textView2 = this.myBankBadgeView;
        if (textView2 != null) {
            if ((textView2 == null || textView2.getVisibility() != 8) && (textView = this.myBankBadgeView) != null) {
                textView.setVisibility(8);
            }
        }
    }

    @Override // ir.nasim.features.root.AbstractC13089g
    public void ka(C11458d25 c11458d25) {
        this.currentPeer = c11458d25;
    }

    @Override // ir.nasim.InterfaceC24762z98
    public void l4(final View insetView, View paddingView) {
        AbstractC13042fc3.i(insetView, "insetView");
        AbstractC13042fc3.i(paddingView, "paddingView");
        final View viewFindViewById = V7().findViewById(BC5.fragment_container);
        final View viewV7 = V7();
        AbstractC13042fc3.h(viewV7, "requireView(...)");
        AbstractC13042fc3.f(viewFindViewById);
        N3(viewFindViewById, new UA2() { // from class: ir.nasim.X36
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C13090h.Jc(insetView, viewV7, viewFindViewById, (View) obj);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        AbstractC20507s76.D(new Runnable() { // from class: ir.nasim.y36
            @Override // java.lang.Runnable
            public final void run() {
                C13090h.Oc();
            }
        }, 1000L);
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC10533bm0.d(AbstractC19224pz3.a(interfaceC18633oz3P6), null, null, new l(null), 3, null);
        Id();
        Context contextG5 = G5();
        if (contextG5 != null) {
            I iOc = oc();
            AD4 ad4E = AD4.e(contextG5);
            AbstractC13042fc3.h(ad4E, "from(...)");
            iOc.x1(ad4E);
        }
        C19406qI3.a("RootFragment", "G S C R", new Object[0]);
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new m(null), 3, null);
    }

    @Override // ir.nasim.features.root.AbstractC13089g
    public void la(String sendText, String sendUriString, ArrayList sendUriMultiple, String sendMimeType, String peerIdDirectShare) {
        TabLayout tabLayout;
        TabLayout.g gVarY;
        P9();
        this.sendText = sendText;
        this.sendUriString = sendUriString;
        this.sendUriMultiple = sendUriMultiple;
        this.sendMimeType = sendMimeType;
        this.peerIdDirectShare = peerIdDirectShare;
        ld(AbstractC13089g.b.c);
        if (this.lastSelectedPageIndex == 0 || (tabLayout = this.tabLayout) == null || (gVarY = tabLayout.y(0)) == null) {
            return;
        }
        gVarY.n();
    }

    public void ld(AbstractC13089g.b bVar) {
        AbstractC13042fc3.i(bVar, "<set-?>");
        this.dialogsMode = bVar;
    }

    @Override // ir.nasim.features.root.AbstractC13089g
    public void ma(int tabIndex) {
        oc().v1(tabIndex, false);
        this.currentDefaultTab = tabIndex;
    }

    @Override // ir.nasim.features.root.AbstractC13089g
    public void na(C11458d25 peer) {
        C5735Kp4.w().s(peer);
    }

    public final FD7 nc() {
        FD7 fd7 = this.updateGateway;
        if (fd7 != null) {
            return fd7;
        }
        AbstractC13042fc3.y("updateGateway");
        return null;
    }

    @Override // ir.nasim.features.root.AbstractC13089g
    public void oa(String pendingMessage) {
        this.pendingMessage = pendingMessage;
    }

    @Override // ir.nasim.InterfaceC14538i46
    public void p0() {
        TextView textView;
        TextView textView2 = this.moreBadgeView;
        if (textView2 != null) {
            if ((textView2 == null || textView2.getVisibility() != 0) && (textView = this.moreBadgeView) != null) {
                textView.setVisibility(0);
            }
        }
    }

    @Override // ir.nasim.features.root.AbstractC13089g
    public void pa(C11458d25 pendingPeer) {
        this.pendingPeer = pendingPeer;
    }

    @Override // ir.nasim.InterfaceC14538i46
    public void q3() {
        TextView textView;
        TextView textView2 = this.myBankBadgeView;
        if (textView2 != null) {
            if ((textView2 == null || textView2.getVisibility() != 0) && (textView = this.myBankBadgeView) != null) {
                textView.setVisibility(0);
            }
        }
    }

    @Override // ir.nasim.features.root.AbstractC13089g
    public void qa(boolean z2) {
        this.isSharingDialogSelected = z2;
    }

    @Override // ir.nasim.InterfaceC14538i46
    public void r0() {
        rc();
    }

    @Override // ir.nasim.features.root.AbstractC13089g
    public void ra() {
        C22042ua0.A9(this, dc().a(ZN2.CHANNEL), false, "GroupTypeMakerFragment", 2, null);
    }

    @Override // ir.nasim.features.root.AbstractC13089g
    public void sa(int messageRes) {
        String strH6 = h6(messageRes);
        AbstractC13042fc3.h(strH6, "getString(...)");
        Jd(strH6);
    }

    @Override // ir.nasim.features.root.AbstractC13089g
    public void ta(InterfaceC23769xU5 listener) {
        AbstractC13042fc3.i(listener, "listener");
        this.requestPermissionsResultListeners.add(listener);
    }

    @Override // ir.nasim.features.root.AbstractC13089g
    public void ua(InterfaceC23769xU5 listener) {
        AbstractC13042fc3.i(listener, "listener");
        this.requestPermissionsResultListeners.remove(listener);
    }

    @Override // ir.nasim.C5598Ka2.c
    public void x4(boolean withAnimation) {
        oc().E2(false);
        C15225jD4.b().c(C15225jD4.z, new Object[0]);
        G g2 = this.presenter;
        if (g2 != null) {
            g2.I();
        }
        if (withAnimation) {
            C5598Ka2 c5598Ka2 = this.eventBarViewHandler;
            if (c5598Ka2 != null) {
                c5598Ka2.g(this);
                return;
            }
            return;
        }
        C5598Ka2 c5598Ka22 = this.eventBarViewHandler;
        if (c5598Ka22 != null) {
            c5598Ka22.e();
        }
    }
}
