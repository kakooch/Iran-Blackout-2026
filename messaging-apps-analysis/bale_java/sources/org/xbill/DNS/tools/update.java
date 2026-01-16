package org.xbill.DNS.tools;

import android.gov.nist.core.Separators;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import org.xbill.DNS.DClass;
import org.xbill.DNS.Message;
import org.xbill.DNS.Name;
import org.xbill.DNS.Rcode;
import org.xbill.DNS.Record;
import org.xbill.DNS.Resolver;
import org.xbill.DNS.SOARecord;
import org.xbill.DNS.Section;
import org.xbill.DNS.SimpleResolver;
import org.xbill.DNS.TTL;
import org.xbill.DNS.TextParseException;
import org.xbill.DNS.Tokenizer;
import org.xbill.DNS.Type;

/* loaded from: classes8.dex */
public class update {
    int defaultClass;
    long defaultTTL;
    PrintStream log = null;
    Message query;
    Resolver res;
    Message response;
    String server;
    Name zone;

    /* JADX WARN: Removed duplicated region for block: B:123:0x01fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public update(java.io.InputStream r10) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1160
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xbill.DNS.tools.update.<init>(java.io.InputStream):void");
    }

    static void help(String str) {
        String lowerCase;
        PrintStream printStream = System.out;
        printStream.println();
        if (str == null) {
            printStream.println("The following are supported commands:\nadd      assert   class    clear    date     delete\necho     edns     file     glue     help     key\nlog      port     prohibit query    quit     require\nsend     server   show     sleep    tcp      ttl\nzone     #\n");
        }
        lowerCase = str.toLowerCase();
        lowerCase.hashCode();
        switch (lowerCase) {
            case "assert":
                printStream.println("assert <field> <value> [msg]\n\nasserts that the value of the field in the last\nresponse matches the value specified.  If not,\nthe message is printed (if present) and the\nprogram exits.  The field may be any of <rcode>,\n<serial>, <tsig>, <qu>, <an>, <au>, or <ad>.\n");
                break;
            case "delete":
                printStream.println("delete <name> [ttl] [class] <type> <data> \ndelete <name> <type> \ndelete <name>\n\nspecify a record or set to be deleted, or that\nall records at a name should be deleted\n");
                break;
            case "origin":
            case "zone":
                printStream.println("zone <zone>\n\nzone to update (default: .\n");
                break;
            case "prohibit":
                printStream.println("prohibit <name> <type> \nprohibit <name>\n\nrequire that a set or name is not present\n");
                break;
            case "server":
                printStream.println("server <name> [port]\n\nserver that receives send updates/queries\n");
                break;
            case "#":
                printStream.println("# <text>\n\na comment\n");
                break;
            case "q":
            case "quit":
                printStream.println("quit\n\nquits the program\n");
                break;
            case "add":
                printStream.println("add <name> [ttl] [class] <type> <data>\n\nspecify a record to be added\n");
                break;
            case "key":
                printStream.println("key <name> <data>\n\nTSIG key used to sign messages\n");
                break;
            case "log":
                printStream.println("log <file>\n\nopens the specified file and uses it to log output\n");
                break;
            case "tcp":
                printStream.println("tcp\n\nTCP should be used to send all messages\n");
                break;
            case "ttl":
                printStream.println("ttl <ttl>\n\ndefault ttl of added records (default: 0)\n");
                break;
            case "date":
                printStream.println("date [-ms]\n\nprints the current date and time in human readable\nformat or as the number of milliseconds since the\nepoch");
                break;
            case "echo":
                printStream.println("echo <text>\n\nprints the text\n");
                break;
            case "edns":
                printStream.println("edns <level>\n\nEDNS level specified when sending messages\n");
                break;
            case "file":
                printStream.println("file <file>\n\nopens the specified file as the new input source\n(- represents stdin)\n");
                break;
            case "glue":
                printStream.println("glue <name> [ttl] [class] <type> <data>\n\nspecify an additional record\n");
                break;
            case "help":
                printStream.println("help\nhelp [topic]\n\nprints a list of commands or help about a specific\ncommand\n");
                break;
            case "port":
                printStream.println("port <port>\n\nUDP/TCP port messages are sent to (default: 53)\n");
                break;
            case "send":
                printStream.println("send\n\nsends and resets the current update packet\n");
                break;
            case "show":
                printStream.println("show\n\nshows the current update packet\n");
                break;
            case "class":
                printStream.println("class <class>\n\nclass of the zone to be updated (default: IN)\n");
                break;
            case "clear":
                printStream.println("clear\n\nclears the current update packet\n");
                break;
            case "query":
                printStream.println("query <name> [type [class]] \n\nissues a query\n");
                break;
            case "sleep":
                printStream.println("sleep <milliseconds>\n\npause for interval before next command\n");
                break;
            case "require":
                printStream.println("require <name> [ttl] [class] <type> <data> \nrequire <name> <type> \nrequire <name>\n\nrequire that a record, set, or name is present\n");
                break;
            default:
                printStream.println("Topic '" + lowerCase + "' unrecognized\n");
                break;
        }
    }

    public static void main(String[] strArr) {
        InputStream fileInputStream;
        if (strArr.length >= 1) {
            try {
                fileInputStream = new FileInputStream(strArr[0]);
            } catch (FileNotFoundException unused) {
                System.out.println(strArr[0] + " not found.");
                System.exit(1);
                fileInputStream = null;
            }
        } else {
            fileInputStream = System.in;
        }
        new update(fileInputStream);
    }

    void doAdd(Tokenizer tokenizer) throws IOException {
        Record rr = parseRR(tokenizer, this.defaultClass, this.defaultTTL);
        this.query.addRecord(rr, 2);
        print(rr);
    }

    boolean doAssert(Tokenizer tokenizer) throws TextParseException {
        String string = tokenizer.getString();
        String string2 = tokenizer.getString();
        boolean z = true;
        if (this.response == null) {
            print("No response has been received");
            return true;
        }
        String string3 = null;
        if (string.equalsIgnoreCase("rcode")) {
            int rcode = this.response.getHeader().getRcode();
            if (rcode != Rcode.value(string2)) {
                string3 = Rcode.string(rcode);
                z = false;
            }
        } else if (string.equalsIgnoreCase("serial")) {
            List<Record> section = this.response.getSection(1);
            if (section.isEmpty() || !(section.get(0) instanceof SOARecord)) {
                print("Invalid response (no SOA)");
            } else {
                long serial = ((SOARecord) section.get(0)).getSerial();
                if (serial != Long.parseLong(string2)) {
                    string3 = Long.toString(serial);
                    z = false;
                }
            }
        } else if (string.equalsIgnoreCase("tsig")) {
            string3 = this.response.isSigned() ? this.response.isVerified() ? "ok" : "failed" : "unsigned";
            if (!string3.equalsIgnoreCase(string2)) {
                z = false;
            }
        } else {
            int iValue = Section.value(string);
            if (iValue >= 0) {
                int count = this.response.getHeader().getCount(iValue);
                if (count != Integer.parseInt(string2)) {
                    string3 = Integer.toString(count);
                    z = false;
                }
            } else {
                print("Invalid assertion keyword: " + string);
            }
        }
        if (!z) {
            print("Expected " + string + Separators.SP + string2 + ", received " + string3);
            while (true) {
                Tokenizer.Token token = tokenizer.get();
                if (!token.isString()) {
                    break;
                }
                print(token.value());
            }
            tokenizer.unget();
        }
        return z;
    }

    void doDelete(Tokenizer tokenizer) throws IOException {
        Record recordNewRecord;
        Name name = tokenizer.getName(this.zone);
        Tokenizer.Token token = tokenizer.get();
        if (token.isString()) {
            String strValue = token.value();
            if (DClass.value(strValue) >= 0) {
                strValue = tokenizer.getString();
            }
            int iValue = Type.value(strValue);
            if (iValue < 0) {
                throw new IOException("Invalid type: " + strValue);
            }
            boolean zIsEOL = tokenizer.get().isEOL();
            tokenizer.unget();
            recordNewRecord = !zIsEOL ? Record.fromString(name, iValue, 254, 0L, tokenizer, this.zone) : Record.newRecord(name, iValue, 255, 0L);
        } else {
            recordNewRecord = Record.newRecord(name, 255, 255, 0L);
        }
        this.query.addRecord(recordNewRecord, 2);
        print(recordNewRecord);
    }

    void doFile(Tokenizer tokenizer, List<BufferedReader> list, List<InputStream> list2) throws TextParseException {
        String string = tokenizer.getString();
        try {
            InputStream fileInputStream = string.equals("-") ? System.in : new FileInputStream(string);
            list2.add(0, fileInputStream);
            list.add(0, new BufferedReader(new InputStreamReader(fileInputStream)));
        } catch (FileNotFoundException unused) {
            print(string + " not found");
        }
    }

    void doGlue(Tokenizer tokenizer) throws IOException {
        Record rr = parseRR(tokenizer, this.defaultClass, this.defaultTTL);
        this.query.addRecord(rr, 3);
        print(rr);
    }

    void doLog(Tokenizer tokenizer) throws IOException {
        String string = tokenizer.getString();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(string);
            try {
                this.log = new PrintStream(fileOutputStream);
                fileOutputStream.close();
            } finally {
            }
        } catch (Exception unused) {
            print("Error opening " + string);
        }
    }

    void doProhibit(Tokenizer tokenizer) throws IOException {
        int iValue;
        Name name = tokenizer.getName(this.zone);
        Tokenizer.Token token = tokenizer.get();
        if (token.isString()) {
            iValue = Type.value(token.value());
            if (iValue < 0) {
                throw new IOException("Invalid type: " + token.value());
            }
        } else {
            iValue = 255;
        }
        Record recordNewRecord = Record.newRecord(name, iValue, 254, 0L);
        this.query.addRecord(recordNewRecord, 1);
        print(recordNewRecord);
    }

    void doQuery(Tokenizer tokenizer) throws IOException {
        int iValue;
        int iValue2 = this.defaultClass;
        Name name = tokenizer.getName(this.zone);
        Tokenizer.Token token = tokenizer.get();
        if (token.isString()) {
            iValue = Type.value(token.value());
            if (iValue < 0) {
                throw new IOException("Invalid type");
            }
            Tokenizer.Token token2 = tokenizer.get();
            if (token2.isString() && (iValue2 = DClass.value(token2.value())) < 0) {
                throw new IOException("Invalid class");
            }
        } else {
            iValue = 1;
        }
        Message messageNewQuery = Message.newQuery(Record.newRecord(name, iValue, iValue2));
        if (this.res == null) {
            this.res = new SimpleResolver(this.server);
        }
        Message messageSend = this.res.send(messageNewQuery);
        this.response = messageSend;
        print(messageSend);
    }

    void doRequire(Tokenizer tokenizer) throws IOException {
        Record recordNewRecord;
        Name name = tokenizer.getName(this.zone);
        Tokenizer.Token token = tokenizer.get();
        if (token.isString()) {
            int iValue = Type.value(token.value());
            if (iValue < 0) {
                throw new IOException("Invalid type: " + token.value());
            }
            boolean zIsEOL = tokenizer.get().isEOL();
            tokenizer.unget();
            recordNewRecord = !zIsEOL ? Record.fromString(name, iValue, this.defaultClass, 0L, tokenizer, this.zone) : Record.newRecord(name, iValue, 255, 0L);
        } else {
            recordNewRecord = Record.newRecord(name, 255, 255, 0L);
        }
        this.query.addRecord(recordNewRecord, 1);
        print(recordNewRecord);
    }

    public Message newMessage() {
        Message message = new Message();
        message.getHeader().setOpcode(5);
        return message;
    }

    Record parseRR(Tokenizer tokenizer, int i, long j) throws IOException {
        long j2;
        Name name = tokenizer.getName(this.zone);
        String string = tokenizer.getString();
        try {
            long ttl = TTL.parseTTL(string);
            string = tokenizer.getString();
            j2 = ttl;
        } catch (NumberFormatException unused) {
            j2 = j;
        }
        if (DClass.value(string) >= 0) {
            i = DClass.value(string);
            string = tokenizer.getString();
        }
        int i2 = i;
        int iValue = Type.value(string);
        if (iValue >= 0) {
            return Record.fromString(name, iValue, i2, j2, tokenizer, this.zone);
        }
        throw new IOException("Invalid type: " + string);
    }

    void print(Object obj) {
        System.out.println(obj);
        PrintStream printStream = this.log;
        if (printStream != null) {
            printStream.println(obj);
        }
    }

    void sendUpdate() throws IOException {
        if (this.query.getHeader().getCount(2) == 0) {
            print("Empty update message.  Ignoring.");
            return;
        }
        if (this.query.getHeader().getCount(0) == 0) {
            Name name = this.zone;
            int dClass = this.defaultClass;
            if (name == null) {
                Iterator<Record> it = this.query.getSection(2).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Record next = it.next();
                    if (name == null) {
                        name = new Name(next.getName(), 1);
                    }
                    if (next.getDClass() != 254 && next.getDClass() != 255) {
                        dClass = next.getDClass();
                        break;
                    }
                }
            }
            this.query.addRecord(Record.newRecord(name, 6, dClass), 0);
        }
        if (this.res == null) {
            this.res = new SimpleResolver(this.server);
        }
        Message messageSend = this.res.send(this.query);
        this.response = messageSend;
        print(messageSend);
    }
}
