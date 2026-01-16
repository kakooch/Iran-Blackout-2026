package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC12000du3;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC18309oR7;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC21430te5;
import ir.nasim.AbstractC22635va3;
import ir.nasim.AbstractC23053wG5;
import ir.nasim.AbstractC3623Bq4;
import ir.nasim.AbstractC6919Pn6;
import ir.nasim.AbstractC7050Qb1;
import ir.nasim.AbstractC7624Sn;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC9868ah5;
import ir.nasim.B98;
import ir.nasim.C15439jb1;
import ir.nasim.C17718nR7;
import ir.nasim.C17833ne1;
import ir.nasim.C19938rB7;
import ir.nasim.C22045ua3;
import ir.nasim.C24898zO4;
import ir.nasim.C25166zq4;
import ir.nasim.C3419Au3;
import ir.nasim.C4414Fa3;
import ir.nasim.C5978Lq4;
import ir.nasim.Ga8;
import ir.nasim.InterfaceC10436bc3;
import ir.nasim.InterfaceC10970cW3;
import ir.nasim.InterfaceC11014cb1;
import ir.nasim.InterfaceC11379cu3;
import ir.nasim.InterfaceC11734dW3;
import ir.nasim.InterfaceC11943do6;
import ir.nasim.InterfaceC12377eW3;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC17460n02;
import ir.nasim.InterfaceC18633oz3;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC22474vI4;
import ir.nasim.InterfaceC23714xO4;
import ir.nasim.InterfaceC24304yO4;
import ir.nasim.InterfaceC5744Kq4;
import ir.nasim.InterfaceC7760Tb6;
import ir.nasim.L93;
import ir.nasim.M73;
import ir.nasim.O98;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.UE0;
import ir.nasim.VX7;
import ir.nasim.WH1;
import ir.nasim.XA4;
import ir.nasim.XX7;
import ir.nasim.YH1;
import ir.nasim.ZG4;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000 r2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001~B9\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001d\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001e\u0010\u001cJ\u001f\u0010!\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\nH\u0014¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u001a¢\u0006\u0004\b#\u0010\u001cJ7\u0010*\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\nH\u0014¢\u0006\u0004\b*\u0010+J\u0011\u0010-\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0004\b-\u0010.J\u0017\u00100\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020$H\u0016¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u001aH\u0014¢\u0006\u0004\b2\u0010\u001cJ\u000f\u00103\u001a\u00020\u001aH\u0014¢\u0006\u0004\b3\u0010\u001cJ%\u00109\u001a\u0004\u0018\u0001082\b\u00105\u001a\u0004\u0018\u0001042\b\u00107\u001a\u0004\u0018\u000106H\u0016¢\u0006\u0004\b9\u0010:J\u001f\u0010=\u001a\u00020\u001a2\u0006\u0010;\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020\u000eH\u0016¢\u0006\u0004\b=\u0010>J\r\u0010?\u001a\u00020\u001a¢\u0006\u0004\b?\u0010\u001cJ\u0017\u0010A\u001a\u00020\u001a2\u0006\u0010@\u001a\u00020\nH\u0014¢\u0006\u0004\bA\u0010BJ\u0019\u0010E\u001a\u00020$2\b\u0010D\u001a\u0004\u0018\u00010CH\u0016¢\u0006\u0004\bE\u0010FJ\u000f\u0010G\u001a\u00020$H\u0016¢\u0006\u0004\bG\u0010HJ/\u0010K\u001a\u00020$2\u0006\u0010;\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020\u000e2\u0006\u0010I\u001a\u00020\n2\u0006\u0010J\u001a\u00020\nH\u0016¢\u0006\u0004\bK\u0010LJ\u000f\u0010M\u001a\u00020\nH\u0016¢\u0006\u0004\bM\u0010NJ/\u0010O\u001a\u00020\u001a2\u0006\u0010;\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020\u000e2\u0006\u0010I\u001a\u00020\n2\u0006\u0010J\u001a\u00020\nH\u0016¢\u0006\u0004\bO\u0010PJ\u001f\u0010Q\u001a\u00020\u001a2\u0006\u0010<\u001a\u00020\u000e2\u0006\u0010J\u001a\u00020\nH\u0016¢\u0006\u0004\bQ\u0010RJG\u0010(\u001a\u00020\u001a2\u0006\u0010<\u001a\u00020\u000e2\u0006\u0010S\u001a\u00020\n2\u0006\u0010T\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\u0006\u0010V\u001a\u00020\n2\u0006\u0010J\u001a\u00020\n2\u0006\u0010W\u001a\u000204H\u0016¢\u0006\u0004\b(\u0010XJ?\u0010'\u001a\u00020\u001a2\u0006\u0010<\u001a\u00020\u000e2\u0006\u0010S\u001a\u00020\n2\u0006\u0010T\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\u0006\u0010V\u001a\u00020\n2\u0006\u0010J\u001a\u00020\nH\u0016¢\u0006\u0004\b'\u0010YJ7\u0010\\\u001a\u00020\u001a2\u0006\u0010<\u001a\u00020\u000e2\u0006\u0010Z\u001a\u00020\n2\u0006\u0010[\u001a\u00020\n2\u0006\u0010W\u001a\u0002042\u0006\u0010J\u001a\u00020\nH\u0016¢\u0006\u0004\b\\\u0010]J/\u0010a\u001a\u00020$2\u0006\u0010<\u001a\u00020\u000e2\u0006\u0010_\u001a\u00020^2\u0006\u0010`\u001a\u00020^2\u0006\u0010W\u001a\u00020$H\u0016¢\u0006\u0004\ba\u0010bJ'\u0010c\u001a\u00020$2\u0006\u0010<\u001a\u00020\u000e2\u0006\u0010_\u001a\u00020^2\u0006\u0010`\u001a\u00020^H\u0016¢\u0006\u0004\bc\u0010dJ\u000f\u0010e\u001a\u00020$H\u0016¢\u0006\u0004\be\u0010HJ\u001f\u0010)\u001a\u00020f2\u0006\u0010K\u001a\u00020\u000e2\u0006\u0010g\u001a\u00020fH\u0016¢\u0006\u0004\b)\u0010hJ'\u0010l\u001a\u00020\n2\u0006\u0010i\u001a\u00020\n2\u0006\u0010j\u001a\u00020\n2\u0006\u0010k\u001a\u00020\nH\u0002¢\u0006\u0004\bl\u0010mJ\u0017\u0010n\u001a\u00020f2\u0006\u0010g\u001a\u00020fH\u0002¢\u0006\u0004\bn\u0010oJ\u0017\u0010r\u001a\u00020p2\u0006\u0010q\u001a\u00020pH\u0002¢\u0006\u0004\br\u0010sJ3\u0010y\u001a\u00020t*\u00020t2\u0006\u0010u\u001a\u00020\n2\u0006\u0010v\u001a\u00020\n2\u0006\u0010w\u001a\u00020\n2\u0006\u0010x\u001a\u00020\nH\u0002¢\u0006\u0004\by\u0010zR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b{\u0010|R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010}R\u0018\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\r\n\u0004\b~\u0010\u007f\u001a\u0005\b\u0080\u0001\u0010\u0016R\u0016\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R@\u0010\u008b\u0001\u001a\t\u0012\u0004\u0012\u00020\u001a0\u0083\u00012\u000e\u0010\u0084\u0001\u001a\t\u0012\u0004\u0012\u00020\u001a0\u0083\u00018\u0006@DX\u0086\u000e¢\u0006\u0018\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0019\u0010\u008e\u0001\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R@\u0010\u0093\u0001\u001a\t\u0012\u0004\u0012\u00020\u001a0\u0083\u00012\u000e\u0010\u008f\u0001\u001a\t\u0012\u0004\u0012\u00020\u001a0\u0083\u00018\u0006@DX\u0086\u000e¢\u0006\u0018\n\u0006\b\u0090\u0001\u0010\u0086\u0001\u001a\u0006\b\u0091\u0001\u0010\u0088\u0001\"\u0006\b\u0092\u0001\u0010\u008a\u0001R?\u0010\u0096\u0001\u001a\t\u0012\u0004\u0012\u00020\u001a0\u0083\u00012\u000e\u0010\u008f\u0001\u001a\t\u0012\u0004\u0012\u00020\u001a0\u0083\u00018\u0006@DX\u0086\u000e¢\u0006\u0017\n\u0005\bO\u0010\u0086\u0001\u001a\u0006\b\u0094\u0001\u0010\u0088\u0001\"\u0006\b\u0095\u0001\u0010\u008a\u0001R3\u0010\u009d\u0001\u001a\u00030\u0097\u00012\b\u0010\u0084\u0001\u001a\u00030\u0097\u00018\u0006@FX\u0086\u000e¢\u0006\u0017\n\u0005\b\u001d\u0010\u0098\u0001\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001\"\u0006\b\u009b\u0001\u0010\u009c\u0001R9\u0010¥\u0001\u001a\u0012\u0012\u0005\u0012\u00030\u0097\u0001\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u009e\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u009f\u0001\u0010 \u0001\u001a\u0006\b¡\u0001\u0010¢\u0001\"\u0006\b£\u0001\u0010¤\u0001R3\u0010¬\u0001\u001a\u00030¦\u00012\b\u0010\u0084\u0001\u001a\u00030¦\u00018\u0006@FX\u0086\u000e¢\u0006\u0017\n\u0005\bQ\u0010§\u0001\u001a\u0006\b¨\u0001\u0010©\u0001\"\u0006\bª\u0001\u0010«\u0001R8\u0010¯\u0001\u001a\u0012\u0012\u0005\u0012\u00030¦\u0001\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u009e\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b&\u0010 \u0001\u001a\u0006\b\u00ad\u0001\u0010¢\u0001\"\u0006\b®\u0001\u0010¤\u0001R7\u0010¶\u0001\u001a\u0005\u0018\u00010°\u00012\n\u0010\u0084\u0001\u001a\u0005\u0018\u00010°\u00018\u0006@FX\u0086\u000e¢\u0006\u0017\n\u0005\b\u001b\u0010±\u0001\u001a\u0006\b²\u0001\u0010³\u0001\"\u0006\b´\u0001\u0010µ\u0001R8\u0010¾\u0001\u001a\u0005\u0018\u00010·\u00012\n\u0010\u0084\u0001\u001a\u0005\u0018\u00010·\u00018\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0006\b¸\u0001\u0010¹\u0001\u001a\u0006\bº\u0001\u0010»\u0001\"\u0006\b¼\u0001\u0010½\u0001R\u0017\u0010Á\u0001\u001a\u0002048\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¿\u0001\u0010À\u0001R\u001f\u0010Ä\u0001\u001a\u00030Â\u00018\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0007\n\u0005\b\\\u0010Ã\u0001R\u0019\u0010g\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u001e\u0010Å\u0001R\u001d\u0010Æ\u0001\u001a\t\u0012\u0004\u0012\u00020\u001a0\u0083\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b(\u0010\u0086\u0001R\u001e\u0010È\u0001\u001a\t\u0012\u0004\u0012\u00020\u001a0\u0083\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÇ\u0001\u0010\u0086\u0001R7\u0010Ë\u0001\u001a\u0011\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u009e\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b'\u0010 \u0001\u001a\u0006\bÉ\u0001\u0010¢\u0001\"\u0006\bÊ\u0001\u0010¤\u0001R\u0016\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÌ\u0001\u0010À\u0001R\u0017\u0010Í\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010|R\u0018\u0010Ï\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÎ\u0001\u0010|R\u0018\u0010Ó\u0001\u001a\u00030Ð\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÑ\u0001\u0010Ò\u0001R\u0019\u0010Õ\u0001\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÔ\u0001\u0010\u008d\u0001R\u001c\u0010Ú\u0001\u001a\u00030Ö\u00018\u0006¢\u0006\u000f\n\u0005\by\u0010×\u0001\u001a\u0006\bØ\u0001\u0010Ù\u0001R\u0016\u0010Ü\u0001\u001a\u00020$8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÛ\u0001\u0010HR\u0018\u0010à\u0001\u001a\u00030Ý\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bÞ\u0001\u0010ß\u0001\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006á\u0001"}, d2 = {"Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "Landroid/view/ViewGroup;", "Lir/nasim/Kq4;", "Lir/nasim/cb1;", "Lir/nasim/yO4;", "Lir/nasim/vI4;", "Landroid/content/Context;", "context", "Lir/nasim/Qb1;", "parentContext", "", "compositeKeyHash", "Lir/nasim/zq4;", "dispatcher", "Landroid/view/View;", "view", "Lir/nasim/xO4;", "owner", "<init>", "(Landroid/content/Context;Lir/nasim/Qb1;ILir/nasim/zq4;Landroid/view/View;Lir/nasim/xO4;)V", "Landroidx/compose/ui/viewinterop/InteropView;", "getInteropView", "()Landroid/view/View;", "", "getAccessibilityClassName", "()Ljava/lang/CharSequence;", "Lir/nasim/rB7;", "m", "()V", "i", "q", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", TokenNames.F, "", "changed", "l", "t", "r", "b", "onLayout", "(ZIIII)V", "Landroid/view/ViewGroup$LayoutParams;", "getLayoutParams", "()Landroid/view/ViewGroup$LayoutParams;", "disallowIntercept", "requestDisallowInterceptTouchEvent", "(Z)V", "onAttachedToWindow", "onDetachedFromWindow", "", "location", "Landroid/graphics/Rect;", "dirty", "Landroid/view/ViewParent;", "invalidateChildInParent", "([ILandroid/graphics/Rect;)Landroid/view/ViewParent;", "child", "target", "onDescendantInvalidated", "(Landroid/view/View;Landroid/view/View;)V", TokenNames.C, "visibility", "onWindowVisibilityChanged", "(I)V", "Landroid/graphics/Region;", "region", "gatherTransparentRegion", "(Landroid/graphics/Region;)Z", "shouldDelayChildPressedState", "()Z", "axes", "type", "v", "(Landroid/view/View;Landroid/view/View;II)Z", "getNestedScrollAxes", "()I", "h", "(Landroid/view/View;Landroid/view/View;II)V", "k", "(Landroid/view/View;I)V", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "consumed", "(Landroid/view/View;IIIII[I)V", "(Landroid/view/View;IIIII)V", "dx", "dy", "p", "(Landroid/view/View;II[II)V", "", "velocityX", "velocityY", "onNestedFling", "(Landroid/view/View;FFZ)Z", "onNestedPreFling", "(Landroid/view/View;FF)Z", "isNestedScrollingEnabled", "Lir/nasim/O98;", "insets", "(Landroid/view/View;Lir/nasim/O98;)Lir/nasim/O98;", "min", "max", "preferred", TokenNames.E, "(III)I", "B", "(Lir/nasim/O98;)Lir/nasim/O98;", "Lir/nasim/B98$a;", "bounds", "A", "(Lir/nasim/B98$a;)Lir/nasim/B98$a;", "Lir/nasim/L93;", "left", "top", "right", "bottom", "z", "(Lir/nasim/L93;IIII)Lir/nasim/L93;", "a", TokenNames.I, "Lir/nasim/zq4;", "c", "Landroid/view/View;", "getView", "d", "Lir/nasim/xO4;", "Lkotlin/Function0;", "value", "e", "Lir/nasim/SA2;", "getUpdate", "()Lir/nasim/SA2;", "setUpdate", "(Lir/nasim/SA2;)V", "update", "f", "Z", "hasUpdateBlock", "<set-?>", "g", "getReset", "setReset", "reset", "getRelease", "setRelease", "release", "Landroidx/compose/ui/e;", "Landroidx/compose/ui/e;", "getModifier", "()Landroidx/compose/ui/e;", "setModifier", "(Landroidx/compose/ui/e;)V", "modifier", "Lkotlin/Function1;", "j", "Lir/nasim/UA2;", "getOnModifierChanged$ui_release", "()Lir/nasim/UA2;", "setOnModifierChanged$ui_release", "(Lir/nasim/UA2;)V", "onModifierChanged", "Lir/nasim/WH1;", "Lir/nasim/WH1;", "getDensity", "()Lir/nasim/WH1;", "setDensity", "(Lir/nasim/WH1;)V", "density", "getOnDensityChanged$ui_release", "setOnDensityChanged$ui_release", "onDensityChanged", "Lir/nasim/oz3;", "Lir/nasim/oz3;", "getLifecycleOwner", "()Lir/nasim/oz3;", "setLifecycleOwner", "(Lir/nasim/oz3;)V", "lifecycleOwner", "Lir/nasim/Tb6;", "n", "Lir/nasim/Tb6;", "getSavedStateRegistryOwner", "()Lir/nasim/Tb6;", "setSavedStateRegistryOwner", "(Lir/nasim/Tb6;)V", "savedStateRegistryOwner", "o", "[I", "position", "Lir/nasim/Fa3;", "J", "size", "Lir/nasim/O98;", "runUpdate", "s", "runInvalidate", "getOnRequestDisallowInterceptTouchEvent$ui_release", "setOnRequestDisallowInterceptTouchEvent$ui_release", "onRequestDisallowInterceptTouchEvent", "u", "lastWidthMeasureSpec", "w", "lastHeightMeasureSpec", "Lir/nasim/Lq4;", "x", "Lir/nasim/Lq4;", "nestedScrollingParentHelper", "y", "isDrawing", "Lir/nasim/Au3;", "Lir/nasim/Au3;", "getLayoutNode", "()Lir/nasim/Au3;", "layoutNode", "Z0", "isValidOwnerScope", "Lir/nasim/zO4;", "getSnapshotObserver", "()Lir/nasim/zO4;", "snapshotObserver", "ui_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes2.dex */
public class AndroidViewHolder extends ViewGroup implements InterfaceC5744Kq4, InterfaceC11014cb1, InterfaceC24304yO4, InterfaceC22474vI4 {
    public static final int B = 8;
    private static final UA2 D = b.e;

    /* renamed from: a, reason: from kotlin metadata */
    private final int compositeKeyHash;

    /* renamed from: b, reason: from kotlin metadata */
    private final C25166zq4 dispatcher;

    /* renamed from: c, reason: from kotlin metadata */
    private final View view;

    /* renamed from: d, reason: from kotlin metadata */
    private final InterfaceC23714xO4 owner;

    /* renamed from: e, reason: from kotlin metadata */
    private SA2 update;

    /* renamed from: f, reason: from kotlin metadata */
    private boolean hasUpdateBlock;

    /* renamed from: g, reason: from kotlin metadata */
    private SA2 reset;

    /* renamed from: h, reason: from kotlin metadata */
    private SA2 release;

    /* renamed from: i, reason: from kotlin metadata */
    private androidx.compose.ui.e modifier;

    /* renamed from: j, reason: from kotlin metadata */
    private UA2 onModifierChanged;

    /* renamed from: k, reason: from kotlin metadata */
    private WH1 density;

    /* renamed from: l, reason: from kotlin metadata */
    private UA2 onDensityChanged;

    /* renamed from: m, reason: from kotlin metadata */
    private InterfaceC18633oz3 lifecycleOwner;

    /* renamed from: n, reason: from kotlin metadata */
    private InterfaceC7760Tb6 savedStateRegistryOwner;

    /* renamed from: o, reason: from kotlin metadata */
    private final int[] position;

    /* renamed from: p, reason: from kotlin metadata */
    private long size;

    /* renamed from: q, reason: from kotlin metadata */
    private O98 insets;

    /* renamed from: r, reason: from kotlin metadata */
    private final SA2 runUpdate;

    /* renamed from: s, reason: from kotlin metadata */
    private final SA2 runInvalidate;

    /* renamed from: t, reason: from kotlin metadata */
    private UA2 onRequestDisallowInterceptTouchEvent;

    /* renamed from: u, reason: from kotlin metadata */
    private final int[] location;

    /* renamed from: v, reason: from kotlin metadata */
    private int lastWidthMeasureSpec;

    /* renamed from: w, reason: from kotlin metadata */
    private int lastHeightMeasureSpec;

    /* renamed from: x, reason: from kotlin metadata */
    private final C5978Lq4 nestedScrollingParentHelper;

    /* renamed from: y, reason: from kotlin metadata */
    private boolean isDrawing;

    /* renamed from: z, reason: from kotlin metadata */
    private final C3419Au3 layoutNode;

    public static final class a extends B98.b {
        a() {
            super(1);
        }

        @Override // ir.nasim.B98.b
        public O98 e(O98 o98, List list) {
            return AndroidViewHolder.this.B(o98);
        }

        @Override // ir.nasim.B98.b
        public B98.a f(B98 b98, B98.a aVar) {
            return AndroidViewHolder.this.A(aVar);
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(SA2 sa2) {
            sa2.invoke();
        }

        public final void b(AndroidViewHolder androidViewHolder) {
            Handler handler = androidViewHolder.getHandler();
            final SA2 sa2 = androidViewHolder.runUpdate;
            handler.post(new Runnable() { // from class: androidx.compose.ui.viewinterop.a
                @Override // java.lang.Runnable
                public final void run() {
                    AndroidViewHolder.b.c(sa2);
                }
            });
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((AndroidViewHolder) obj);
            return C19938rB7.a;
        }
    }

    static final class d extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C3419Au3 e;
        final /* synthetic */ androidx.compose.ui.e f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(C3419Au3 c3419Au3, androidx.compose.ui.e eVar) {
            super(1);
            this.e = c3419Au3;
            this.f = eVar;
        }

        public final void a(androidx.compose.ui.e eVar) {
            this.e.r(eVar.i(this.f));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((androidx.compose.ui.e) obj);
            return C19938rB7.a;
        }
    }

    static final class e extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C3419Au3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(C3419Au3 c3419Au3) {
            super(1);
            this.e = c3419Au3;
        }

        public final void a(WH1 wh1) {
            this.e.f(wh1);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((WH1) obj);
            return C19938rB7.a;
        }
    }

    static final class f extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C3419Au3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(C3419Au3 c3419Au3) {
            super(1);
            this.f = c3419Au3;
        }

        public final void a(InterfaceC23714xO4 interfaceC23714xO4) {
            AndroidComposeView androidComposeView = interfaceC23714xO4 instanceof AndroidComposeView ? (AndroidComposeView) interfaceC23714xO4 : null;
            if (androidComposeView != null) {
                androidComposeView.j0(AndroidViewHolder.this, this.f);
            }
            ViewParent parent = AndroidViewHolder.this.getView().getParent();
            AndroidViewHolder androidViewHolder = AndroidViewHolder.this;
            if (parent != androidViewHolder) {
                androidViewHolder.addView(androidViewHolder.getView());
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC23714xO4) obj);
            return C19938rB7.a;
        }
    }

    static final class g extends AbstractC8614Ws3 implements UA2 {
        g() {
            super(1);
        }

        public final void a(InterfaceC23714xO4 interfaceC23714xO4) {
            if (C15439jb1.e && AndroidViewHolder.this.hasFocus()) {
                interfaceC23714xO4.getFocusOwner().v(true);
            }
            AndroidComposeView androidComposeView = interfaceC23714xO4 instanceof AndroidComposeView ? (AndroidComposeView) interfaceC23714xO4 : null;
            if (androidComposeView != null) {
                androidComposeView.R0(AndroidViewHolder.this);
            }
            AndroidViewHolder.this.removeAllViewsInLayout();
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC23714xO4) obj);
            return C19938rB7.a;
        }
    }

    static final class j extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C3419Au3 f;
        final /* synthetic */ AndroidViewHolder g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(C3419Au3 c3419Au3, AndroidViewHolder androidViewHolder) {
            super(1);
            this.f = c3419Au3;
            this.g = androidViewHolder;
        }

        public final void a(InterfaceC17460n02 interfaceC17460n02) {
            AndroidViewHolder androidViewHolder = AndroidViewHolder.this;
            C3419Au3 c3419Au3 = this.f;
            AndroidViewHolder androidViewHolder2 = this.g;
            UE0 ue0E = interfaceC17460n02.z1().e();
            if (androidViewHolder.getView().getVisibility() != 8) {
                androidViewHolder.isDrawing = true;
                InterfaceC23714xO4 interfaceC23714xO4Z0 = c3419Au3.z0();
                AndroidComposeView androidComposeView = interfaceC23714xO4Z0 instanceof AndroidComposeView ? (AndroidComposeView) interfaceC23714xO4Z0 : null;
                if (androidComposeView != null) {
                    androidComposeView.s0(androidViewHolder2, AbstractC7624Sn.d(ue0E));
                }
                androidViewHolder.isDrawing = false;
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC17460n02) obj);
            return C19938rB7.a;
        }
    }

    static final class k extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C3419Au3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(C3419Au3 c3419Au3) {
            super(1);
            this.f = c3419Au3;
        }

        public final void a(InterfaceC11379cu3 interfaceC11379cu3) {
            WindowInsets windowInsetsY;
            androidx.compose.ui.viewinterop.b.f(AndroidViewHolder.this, this.f);
            AndroidViewHolder.this.owner.e(AndroidViewHolder.this);
            int i = AndroidViewHolder.this.position[0];
            int i2 = AndroidViewHolder.this.position[1];
            AndroidViewHolder.this.getView().getLocationOnScreen(AndroidViewHolder.this.position);
            long j = AndroidViewHolder.this.size;
            AndroidViewHolder.this.size = interfaceC11379cu3.a();
            O98 o98 = AndroidViewHolder.this.insets;
            if (o98 != null) {
                if ((i == AndroidViewHolder.this.position[0] && i2 == AndroidViewHolder.this.position[1] && C4414Fa3.e(j, AndroidViewHolder.this.size)) || (windowInsetsY = AndroidViewHolder.this.B(o98).y()) == null) {
                    return;
                }
                AndroidViewHolder.this.getView().dispatchApplyWindowInsets(windowInsetsY);
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC11379cu3) obj);
            return C19938rB7.a;
        }
    }

    static final class l extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ boolean c;
        final /* synthetic */ AndroidViewHolder d;
        final /* synthetic */ long e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(boolean z, AndroidViewHolder androidViewHolder, long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = z;
            this.d = androidViewHolder;
            this.e = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new l(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (this.c) {
                    C25166zq4 c25166zq4 = this.d.dispatcher;
                    long j = this.e;
                    long jA = C17718nR7.b.a();
                    this.b = 2;
                    if (c25166zq4.a(j, jA, this) == objE) {
                        return objE;
                    }
                } else {
                    C25166zq4 c25166zq42 = this.d.dispatcher;
                    long jA2 = C17718nR7.b.a();
                    long j2 = this.e;
                    this.b = 1;
                    if (c25166zq42.a(jA2, j2, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1 && i != 2) {
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

    static final class m extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return AndroidViewHolder.this.new m(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C25166zq4 c25166zq4 = AndroidViewHolder.this.dispatcher;
                long j = this.d;
                this.b = 1;
                if (c25166zq4.c(j, this) == objE) {
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

    static final class n extends AbstractC8614Ws3 implements SA2 {
        public static final n e = new n();

        n() {
            super(0);
        }

        public final void a() {
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    static final class o extends AbstractC8614Ws3 implements SA2 {
        public static final o e = new o();

        o() {
            super(0);
        }

        public final void a() {
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    static final class p extends AbstractC8614Ws3 implements SA2 {
        p() {
            super(0);
        }

        public final void a() {
            AndroidViewHolder.this.getLayoutNode().M0();
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    static final class q extends AbstractC8614Ws3 implements SA2 {
        q() {
            super(0);
        }

        public final void a() {
            if (AndroidViewHolder.this.hasUpdateBlock && AndroidViewHolder.this.isAttachedToWindow()) {
                ViewParent parent = AndroidViewHolder.this.getView().getParent();
                AndroidViewHolder androidViewHolder = AndroidViewHolder.this;
                if (parent == androidViewHolder) {
                    androidViewHolder.getSnapshotObserver().i(AndroidViewHolder.this, AndroidViewHolder.D, AndroidViewHolder.this.getUpdate());
                }
            }
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    static final class r extends AbstractC8614Ws3 implements SA2 {
        public static final r e = new r();

        r() {
            super(0);
        }

        public final void a() {
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    public AndroidViewHolder(Context context, AbstractC7050Qb1 abstractC7050Qb1, int i2, C25166zq4 c25166zq4, View view, InterfaceC23714xO4 interfaceC23714xO4) {
        super(context);
        this.compositeKeyHash = i2;
        this.dispatcher = c25166zq4;
        this.view = view;
        this.owner = interfaceC23714xO4;
        if (abstractC7050Qb1 != null) {
            Ga8.i(this, abstractC7050Qb1);
        }
        setSaveFromParentEnabled(false);
        addView(view);
        AbstractC12990fW7.N0(this, new a());
        AbstractC12990fW7.E0(this, this);
        this.update = r.e;
        this.reset = o.e;
        this.release = n.e;
        e.a aVar = androidx.compose.ui.e.a;
        this.modifier = aVar;
        this.density = YH1.b(1.0f, 0.0f, 2, null);
        this.position = new int[2];
        this.size = C4414Fa3.b.a();
        this.runUpdate = new q();
        this.runInvalidate = new p();
        this.location = new int[2];
        this.lastWidthMeasureSpec = RecyclerView.UNDEFINED_DURATION;
        this.lastHeightMeasureSpec = RecyclerView.UNDEFINED_DURATION;
        this.nestedScrollingParentHelper = new C5978Lq4(this);
        C3419Au3 c3419Au3 = new C3419Au3(false, 0, 3, null);
        c3419Au3.K1(true);
        c3419Au3.M1(this);
        androidx.compose.ui.e eVarA = androidx.compose.ui.layout.c.a(androidx.compose.ui.draw.b.b(androidx.compose.ui.graphics.b.c(AbstractC9868ah5.a(AbstractC6919Pn6.c(androidx.compose.ui.input.nestedscroll.a.a(aVar, androidx.compose.ui.viewinterop.b.a, c25166zq4), true, i.e), this), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new j(c3419Au3, this)), new k(c3419Au3));
        c3419Au3.h(i2);
        c3419Au3.r(this.modifier.i(eVarA));
        this.onModifierChanged = new d(c3419Au3, eVarA);
        c3419Au3.f(this.density);
        this.onDensityChanged = new e(c3419Au3);
        c3419Au3.S1(new f(c3419Au3));
        c3419Au3.T1(new g());
        c3419Au3.j(new h(c3419Au3));
        this.layoutNode = c3419Au3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final B98.a A(B98.a bounds) {
        XA4 xa4Y = this.layoutNode.Y();
        if (xa4Y.b()) {
            long jD = AbstractC22635va3.d(AbstractC12000du3.e(xa4Y));
            int iK = C22045ua3.k(jD);
            int i2 = iK < 0 ? 0 : iK;
            int iL = C22045ua3.l(jD);
            int i3 = iL < 0 ? 0 : iL;
            long jA = AbstractC12000du3.d(xa4Y).a();
            int i4 = (int) (jA >> 32);
            int i5 = (int) (jA & 4294967295L);
            long jA2 = xa4Y.a();
            long jD2 = AbstractC22635va3.d(xa4Y.p0(ZG4.e((Float.floatToRawIntBits((int) (jA2 >> 32)) << 32) | (4294967295L & Float.floatToRawIntBits((int) (jA2 & 4294967295L))))));
            int iK2 = i4 - C22045ua3.k(jD2);
            int i6 = iK2 < 0 ? 0 : iK2;
            int iL2 = i5 - C22045ua3.l(jD2);
            int i7 = iL2 < 0 ? 0 : iL2;
            if (i2 != 0 || i3 != 0 || i6 != 0 || i7 != 0) {
                int i8 = i2;
                int i9 = i3;
                int i10 = i6;
                int i11 = i7;
                return new B98.a(z(bounds.a(), i8, i9, i10, i11), z(bounds.b(), i8, i9, i10, i11));
            }
        }
        return bounds;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final O98 B(O98 insets) {
        if (!insets.n()) {
            return insets;
        }
        XA4 xa4Y = this.layoutNode.Y();
        if (!xa4Y.b()) {
            return insets;
        }
        long jD = AbstractC22635va3.d(AbstractC12000du3.e(xa4Y));
        int iK = C22045ua3.k(jD);
        if (iK < 0) {
            iK = 0;
        }
        int iL = C22045ua3.l(jD);
        if (iL < 0) {
            iL = 0;
        }
        long jA = AbstractC12000du3.d(xa4Y).a();
        int i2 = (int) (jA >> 32);
        int i3 = (int) (jA & 4294967295L);
        long jA2 = xa4Y.a();
        long jD2 = AbstractC22635va3.d(xa4Y.p0(ZG4.e((Float.floatToRawIntBits((int) (jA2 & 4294967295L)) & 4294967295L) | (Float.floatToRawIntBits((int) (jA2 >> 32)) << 32))));
        int iK2 = i2 - C22045ua3.k(jD2);
        if (iK2 < 0) {
            iK2 = 0;
        }
        int iL2 = i3 - C22045ua3.l(jD2);
        int i4 = iL2 < 0 ? 0 : iL2;
        return (iK == 0 && iL == 0 && iK2 == 0 && i4 == 0) ? insets : insets.p(iK, iL, iK2, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(SA2 sa2) {
        sa2.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int E(int min, int max, int preferred) {
        return (preferred >= 0 || min == max) ? View.MeasureSpec.makeMeasureSpec(AbstractC23053wG5.m(preferred, min, max), 1073741824) : (preferred != -2 || max == Integer.MAX_VALUE) ? (preferred != -1 || max == Integer.MAX_VALUE) ? View.MeasureSpec.makeMeasureSpec(0, 0) : View.MeasureSpec.makeMeasureSpec(max, 1073741824) : View.MeasureSpec.makeMeasureSpec(max, RecyclerView.UNDEFINED_DURATION);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C24898zO4 getSnapshotObserver() {
        if (!isAttachedToWindow()) {
            M73.b("Expected AndroidViewHolder to be attached when observing reads.");
        }
        return this.owner.getSnapshotObserver();
    }

    private final L93 z(L93 l93, int i2, int i3, int i4, int i5) {
        int i6 = l93.a - i2;
        if (i6 < 0) {
            i6 = 0;
        }
        int i7 = l93.b - i3;
        if (i7 < 0) {
            i7 = 0;
        }
        int i8 = l93.c - i4;
        if (i8 < 0) {
            i8 = 0;
        }
        int i9 = l93.d - i5;
        return L93.b(i6, i7, i8, i9 >= 0 ? i9 : 0);
    }

    public final void C() {
        if (!this.isDrawing) {
            this.layoutNode.M0();
            return;
        }
        View view = this.view;
        final SA2 sa2 = this.runInvalidate;
        view.postOnAnimation(new Runnable() { // from class: ir.nasim.as
            @Override // java.lang.Runnable
            public final void run() {
                AndroidViewHolder.D(sa2);
            }
        });
    }

    public final void F() {
        int i2;
        int i3 = this.lastWidthMeasureSpec;
        if (i3 == Integer.MIN_VALUE || (i2 = this.lastHeightMeasureSpec) == Integer.MIN_VALUE) {
            return;
        }
        measure(i3, i2);
    }

    @Override // ir.nasim.InterfaceC24304yO4
    public boolean Z0() {
        return isAttachedToWindow();
    }

    @Override // ir.nasim.InterfaceC22474vI4
    public O98 b(View v, O98 insets) {
        this.insets = new O98(insets);
        return B(insets);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean gatherTransparentRegion(Region region) {
        if (region == null) {
            return true;
        }
        getLocationInWindow(this.location);
        int[] iArr = this.location;
        int i2 = iArr[0];
        region.op(i2, iArr[1], i2 + getWidth(), this.location[1] + getHeight(), Region.Op.DIFFERENCE);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return getClass().getName();
    }

    public final WH1 getDensity() {
        return this.density;
    }

    /* renamed from: getInteropView, reason: from getter */
    public final View getView() {
        return this.view;
    }

    public final C3419Au3 getLayoutNode() {
        return this.layoutNode;
    }

    @Override // android.view.View
    public ViewGroup.LayoutParams getLayoutParams() {
        ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        return layoutParams == null ? new ViewGroup.LayoutParams(-1, -1) : layoutParams;
    }

    public final InterfaceC18633oz3 getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    public final androidx.compose.ui.e getModifier() {
        return this.modifier;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.nestedScrollingParentHelper.a();
    }

    /* renamed from: getOnDensityChanged$ui_release, reason: from getter */
    public final UA2 getOnDensityChanged() {
        return this.onDensityChanged;
    }

    /* renamed from: getOnModifierChanged$ui_release, reason: from getter */
    public final UA2 getOnModifierChanged() {
        return this.onModifierChanged;
    }

    /* renamed from: getOnRequestDisallowInterceptTouchEvent$ui_release, reason: from getter */
    public final UA2 getOnRequestDisallowInterceptTouchEvent() {
        return this.onRequestDisallowInterceptTouchEvent;
    }

    public final SA2 getRelease() {
        return this.release;
    }

    public final SA2 getReset() {
        return this.reset;
    }

    public final InterfaceC7760Tb6 getSavedStateRegistryOwner() {
        return this.savedStateRegistryOwner;
    }

    public final SA2 getUpdate() {
        return this.update;
    }

    public final View getView() {
        return this.view;
    }

    @Override // ir.nasim.InterfaceC5510Jq4
    public void h(View child, View target, int axes, int type) {
        this.nestedScrollingParentHelper.c(child, target, axes, type);
    }

    @Override // ir.nasim.InterfaceC11014cb1
    public void i() {
        this.reset.invoke();
        if (C15439jb1.f && hasFocus() && isInTouchMode() && Build.VERSION.SDK_INT > 28) {
            findFocus().clearFocus();
        }
        removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ViewParent invalidateChildInParent(int[] location, Rect dirty) {
        super.invalidateChildInParent(location, dirty);
        C();
        return null;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.view.isNestedScrollingEnabled();
    }

    @Override // ir.nasim.InterfaceC5510Jq4
    public void k(View target, int type) {
        this.nestedScrollingParentHelper.e(target, type);
    }

    @Override // ir.nasim.InterfaceC11014cb1
    public void m() {
        if (this.view.getParent() != this) {
            addView(this.view);
        } else {
            this.reset.invoke();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.runUpdate.invoke();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onDescendantInvalidated(View child, View target) {
        super.onDescendantInvalidated(child, target);
        C();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getSnapshotObserver().a(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l2, int t, int r2, int b2) {
        this.view.layout(0, 0, r2 - l2, b2 - t);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.view.getParent() != this) {
            setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(heightMeasureSpec));
            return;
        }
        if (this.view.getVisibility() == 8) {
            setMeasuredDimension(0, 0);
            return;
        }
        this.view.measure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(this.view.getMeasuredWidth(), this.view.getMeasuredHeight());
        this.lastWidthMeasureSpec = widthMeasureSpec;
        this.lastHeightMeasureSpec = heightMeasureSpec;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        if (!isNestedScrollingEnabled()) {
            return false;
        }
        AbstractC10533bm0.d(this.dispatcher.e(), null, null, new l(consumed, this, AbstractC18309oR7.a(androidx.compose.ui.viewinterop.b.h(velocityX), androidx.compose.ui.viewinterop.b.h(velocityY)), null), 3, null);
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        if (!isNestedScrollingEnabled()) {
            return false;
        }
        AbstractC10533bm0.d(this.dispatcher.e(), null, null, new m(AbstractC18309oR7.a(androidx.compose.ui.viewinterop.b.h(velocityX), androidx.compose.ui.viewinterop.b.h(velocityY)), null), 3, null);
        return false;
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
    }

    @Override // ir.nasim.InterfaceC5510Jq4
    public void p(View target, int dx, int dy, int[] consumed, int type) {
        if (isNestedScrollingEnabled()) {
            C25166zq4 c25166zq4 = this.dispatcher;
            float fG = androidx.compose.ui.viewinterop.b.g(dx);
            float fG2 = androidx.compose.ui.viewinterop.b.g(dy);
            long jD = c25166zq4.d(ZG4.e((Float.floatToRawIntBits(fG2) & 4294967295L) | (Float.floatToRawIntBits(fG) << 32)), androidx.compose.ui.viewinterop.b.i(type));
            consumed[0] = AbstractC3623Bq4.f(Float.intBitsToFloat((int) (jD >> 32)));
            consumed[1] = AbstractC3623Bq4.f(Float.intBitsToFloat((int) (jD & 4294967295L)));
        }
    }

    @Override // ir.nasim.InterfaceC11014cb1
    public void q() {
        this.release.invoke();
    }

    @Override // ir.nasim.InterfaceC5744Kq4
    public void r(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, int[] consumed) {
        if (isNestedScrollingEnabled()) {
            C25166zq4 c25166zq4 = this.dispatcher;
            float fG = androidx.compose.ui.viewinterop.b.g(dxConsumed);
            float fG2 = androidx.compose.ui.viewinterop.b.g(dyConsumed);
            long jE = ZG4.e((Float.floatToRawIntBits(fG2) & 4294967295L) | (Float.floatToRawIntBits(fG) << 32));
            float fG3 = androidx.compose.ui.viewinterop.b.g(dxUnconsumed);
            float fG4 = androidx.compose.ui.viewinterop.b.g(dyUnconsumed);
            long jB = c25166zq4.b(jE, ZG4.e((Float.floatToRawIntBits(fG4) & 4294967295L) | (Float.floatToRawIntBits(fG3) << 32)), androidx.compose.ui.viewinterop.b.i(type));
            consumed[0] = AbstractC3623Bq4.f(Float.intBitsToFloat((int) (jB >> 32)));
            consumed[1] = AbstractC3623Bq4.f(Float.intBitsToFloat((int) (jB & 4294967295L)));
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        UA2 ua2 = this.onRequestDisallowInterceptTouchEvent;
        if (ua2 != null) {
            ua2.invoke(Boolean.valueOf(disallowIntercept));
        }
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }

    public final void setDensity(WH1 wh1) {
        if (wh1 != this.density) {
            this.density = wh1;
            UA2 ua2 = this.onDensityChanged;
            if (ua2 != null) {
                ua2.invoke(wh1);
            }
        }
    }

    public final void setLifecycleOwner(InterfaceC18633oz3 interfaceC18633oz3) {
        if (interfaceC18633oz3 != this.lifecycleOwner) {
            this.lifecycleOwner = interfaceC18633oz3;
            VX7.b(this, interfaceC18633oz3);
        }
    }

    public final void setModifier(androidx.compose.ui.e eVar) {
        if (eVar != this.modifier) {
            this.modifier = eVar;
            UA2 ua2 = this.onModifierChanged;
            if (ua2 != null) {
                ua2.invoke(eVar);
            }
        }
    }

    public final void setOnDensityChanged$ui_release(UA2 ua2) {
        this.onDensityChanged = ua2;
    }

    public final void setOnModifierChanged$ui_release(UA2 ua2) {
        this.onModifierChanged = ua2;
    }

    public final void setOnRequestDisallowInterceptTouchEvent$ui_release(UA2 ua2) {
        this.onRequestDisallowInterceptTouchEvent = ua2;
    }

    protected final void setRelease(SA2 sa2) {
        this.release = sa2;
    }

    protected final void setReset(SA2 sa2) {
        this.reset = sa2;
    }

    public final void setSavedStateRegistryOwner(InterfaceC7760Tb6 interfaceC7760Tb6) {
        if (interfaceC7760Tb6 != this.savedStateRegistryOwner) {
            this.savedStateRegistryOwner = interfaceC7760Tb6;
            XX7.b(this, interfaceC7760Tb6);
        }
    }

    protected final void setUpdate(SA2 sa2) {
        this.update = sa2;
        this.hasUpdateBlock = true;
        this.runUpdate.invoke();
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // ir.nasim.InterfaceC5510Jq4
    public void t(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        if (isNestedScrollingEnabled()) {
            C25166zq4 c25166zq4 = this.dispatcher;
            float fG = androidx.compose.ui.viewinterop.b.g(dxConsumed);
            float fG2 = androidx.compose.ui.viewinterop.b.g(dyConsumed);
            long jE = ZG4.e((Float.floatToRawIntBits(fG2) & 4294967295L) | (Float.floatToRawIntBits(fG) << 32));
            float fG3 = androidx.compose.ui.viewinterop.b.g(dxUnconsumed);
            float fG4 = androidx.compose.ui.viewinterop.b.g(dyUnconsumed);
            c25166zq4.b(jE, ZG4.e((Float.floatToRawIntBits(fG4) & 4294967295L) | (Float.floatToRawIntBits(fG3) << 32)), androidx.compose.ui.viewinterop.b.i(type));
        }
    }

    @Override // ir.nasim.InterfaceC5510Jq4
    public boolean v(View child, View target, int axes, int type) {
        return ((axes & 2) == 0 && (axes & 1) == 0) ? false : true;
    }

    public static final class h implements InterfaceC10970cW3 {
        final /* synthetic */ C3419Au3 b;

        static final class b extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ AndroidViewHolder e;
            final /* synthetic */ C3419Au3 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(AndroidViewHolder androidViewHolder, C3419Au3 c3419Au3) {
                super(1);
                this.e = androidViewHolder;
                this.f = c3419Au3;
            }

            public final void a(AbstractC21430te5.a aVar) {
                androidx.compose.ui.viewinterop.b.f(this.e, this.f);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((AbstractC21430te5.a) obj);
                return C19938rB7.a;
            }
        }

        h(C3419Au3 c3419Au3) {
            this.b = c3419Au3;
        }

        private final int c(int i) {
            AndroidViewHolder androidViewHolder = AndroidViewHolder.this;
            ViewGroup.LayoutParams layoutParams = androidViewHolder.getLayoutParams();
            AbstractC13042fc3.f(layoutParams);
            androidViewHolder.measure(androidViewHolder.E(0, i, layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
            return AndroidViewHolder.this.getMeasuredHeight();
        }

        private final int e(int i) {
            AndroidViewHolder androidViewHolder = AndroidViewHolder.this;
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            AndroidViewHolder androidViewHolder2 = AndroidViewHolder.this;
            ViewGroup.LayoutParams layoutParams = androidViewHolder2.getLayoutParams();
            AbstractC13042fc3.f(layoutParams);
            androidViewHolder.measure(iMakeMeasureSpec, androidViewHolder2.E(0, i, layoutParams.height));
            return AndroidViewHolder.this.getMeasuredWidth();
        }

        @Override // ir.nasim.InterfaceC10970cW3
        public int a(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
            return c(i);
        }

        @Override // ir.nasim.InterfaceC10970cW3
        public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, List list, long j) {
            if (AndroidViewHolder.this.getChildCount() == 0) {
                return InterfaceC12377eW3.Q1(interfaceC12377eW3, C17833ne1.n(j), C17833ne1.m(j), null, a.e, 4, null);
            }
            if (C17833ne1.n(j) != 0) {
                AndroidViewHolder.this.getChildAt(0).setMinimumWidth(C17833ne1.n(j));
            }
            if (C17833ne1.m(j) != 0) {
                AndroidViewHolder.this.getChildAt(0).setMinimumHeight(C17833ne1.m(j));
            }
            AndroidViewHolder androidViewHolder = AndroidViewHolder.this;
            int iN = C17833ne1.n(j);
            int iL = C17833ne1.l(j);
            ViewGroup.LayoutParams layoutParams = AndroidViewHolder.this.getLayoutParams();
            AbstractC13042fc3.f(layoutParams);
            int iE = androidViewHolder.E(iN, iL, layoutParams.width);
            AndroidViewHolder androidViewHolder2 = AndroidViewHolder.this;
            int iM = C17833ne1.m(j);
            int iK = C17833ne1.k(j);
            ViewGroup.LayoutParams layoutParams2 = AndroidViewHolder.this.getLayoutParams();
            AbstractC13042fc3.f(layoutParams2);
            androidViewHolder.measure(iE, androidViewHolder2.E(iM, iK, layoutParams2.height));
            return InterfaceC12377eW3.Q1(interfaceC12377eW3, AndroidViewHolder.this.getMeasuredWidth(), AndroidViewHolder.this.getMeasuredHeight(), null, new b(AndroidViewHolder.this, this.b), 4, null);
        }

        @Override // ir.nasim.InterfaceC10970cW3
        public int d(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
            return e(i);
        }

        @Override // ir.nasim.InterfaceC10970cW3
        public int h(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
            return e(i);
        }

        @Override // ir.nasim.InterfaceC10970cW3
        public int i(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
            return c(i);
        }

        static final class a extends AbstractC8614Ws3 implements UA2 {
            public static final a e = new a();

            a() {
                super(1);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((AbstractC21430te5.a) obj);
                return C19938rB7.a;
            }

            public final void a(AbstractC21430te5.a aVar) {
            }
        }
    }

    static final class i extends AbstractC8614Ws3 implements UA2 {
        public static final i e = new i();

        i() {
            super(1);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC11943do6) obj);
            return C19938rB7.a;
        }

        public final void a(InterfaceC11943do6 interfaceC11943do6) {
        }
    }
}
