# Iran Internet Infrastructure Research Plan

## Context
Someone asked 6 technical questions about the current internet situation in Iran. We need to investigate existing RIPE Atlas/Stat/DNSmon measurements and plan new ones to answer these questions.

## Scope & Constraints
- **RIPE Atlas**: API key + credits available for creating new measurements
- **Local Access**: No volunteer in Iran - limited to external measurements
- **Priority**: Questions 1-4 (network reachability via ArvanCloud, DNS, ICMP)
- **Deferred**: Questions 5-6 (Bale/Ita protocols, STUN servers) - require local pcap capture

---

## Part 1: Existing RIPE Infrastructure Available

### RIPE Atlas Probes in Iran
- **Only 1 active probe** (ID: 25407) on AS14593 - a home DSL connection
- Connected since August 2015, IPv4 only, behind NAT
- Very limited measurement capability from inside Iran

### Existing RIPE Atlas Measurements for Iranian ASNs
- **14 active measurements** for AS58224 (TCI backbone):
  - 4 ping measurements
  - 5 traceroute measurements
  - 5 HTTP measurements
  - Targets: `ir-mhd-as58224-client.anchors.atlas.ripe.net`, `ir-syz-as58224-client.anchors.atlas.ripe.net`

### K-Root in Iran (Tehran)
- **3 instances** hosted by 3 separate organizations in Tehran
- Deployed April 2015, provides significant latency improvement for Iranian users
- Historical issue: One host had improperly scoped routes that leaked globally (fixed Sept 2015)
- Source: [RIPE Labs - Iran and K-root](https://labs.ripe.net/author/emileaben/iran-and-k-root-the-rest-of-the-story/)

### I-Root (Netnod)
- **No confirmed instances in Iran** - Netnod operates 41 instances globally but Tehran not listed
- Closest instances likely in Stockholm (main), possibly Dubai

### DNSmon
- Monitors K-root and I-root globally using RIPE Atlas probes
- Access via: `https://dnsmon.ripe.net/`
- Can view latency to root servers from Iranian probes (limited to the 1 active probe)

---

## Part 2: Research Questions & Investigation Plan

### Q1: ArvanCloud + Fake google.com Cert Reachability (Irancell)

**What We Know:**
- Iran uses SNI-based DPI blocking, not IP-based blocking for most cases
- MCI/Irancell (AS197207) implements whitelist model - unknown SNI = blocked/throttled
- The GFW resets connections after ClientHello for blocked SNIs

**Investigation Approach:**
1. Check existing OONI measurements for `google.com` from AS197207
2. Use RIPE Atlas SSL/TLS measurement to ArvanCloud IP with custom SNI
3. Set up traceroute from AS197207 probe to ArvanCloud IPs

**Key API Endpoints:**
- OONI: `https://api.ooni.io/api/v1/measurements?probe_cc=IR&probe_asn=AS197207&domain=google.com`
- RIPE Atlas: POST to `https://atlas.ripe.net/api/v2/measurements/` with SSL type

**Answer Hypothesis:** Connection will be **blocked** because:
- SNI `google.com` is blocked by DPI
- Certificate itself doesn't matter - block happens at ClientHello before cert exchange

### Q2: Whitelisted Domains (sibapp.com) on ArvanCloud

**What We Know:**
- Sibapp is Iran's iOS app store - definitely whitelisted
- ArvanCloud serves whitelisted content without issues
- The whitelist is SNI-based, not IP-based

**Investigation Approach:**
1. Query OONI for `sibapp.com` measurements
2. Compare traceroute paths for sibapp.com vs google.com from same probe
3. Measure TLS handshake success rate to sibapp.com from RIPE Atlas

**Answer Hypothesis:** Connection will **succeed** - the SNI whitelist allows traffic regardless of server location

### Q3: DNS Upstream Behavior

**What We Know from RIPE Labs Research:**
- [Part 1](https://labs.ripe.net/author/babak_farrokhi/a-tale-of-using-public-dns-servers-in-iran-part-1/): Iranian ISPs redirect DNS to public servers (8.8.8.8 common)
- Average latency to Google DNS: 177ms, Level3: 182ms from Iran
- DNS hijacking possible - no DNSSEC validation on most resolvers
- K-root in Tehran provides fast root queries

**Investigation Approach:**
1. Use RIPE Atlas DNS measurement from Iran probe to test resolution:
   - Query blocked domain (e.g., telegram.org)
   - Query whitelisted domain (e.g., sibapp.com)
   - Query neutral domain and compare with global result
2. Test propagation delay by querying recently changed records

**Key Questions to Answer:**
- Are DNS queries poisoned/redirected?
- Is there a national DNS filter in place?
- Propagation timing for record updates

### Q4: ICMP/Ping to ArvanCloud IPs

**What We Know:**
- ArvanCloud operates from AS202468 and uses 185.220.x.x, 185.143.x.x ranges
- ICMP is generally allowed for internal Iran traffic
- External ICMP often blocked/throttled

**Investigation Approach:**
1. Use existing RIPE Atlas ping measurements to AS58224 as baseline
2. Create new ping measurement from Iran probe (ID: 25407) to ArvanCloud IPs
3. Compare with traceroute to see where ICMP fails

**API Call:**
```json
{
  "definitions": [{
    "target": "185.220.0.1",
    "af": 4,
    "packets": 3,
    "size": 48,
    "type": "ping",
    "description": "Ping to ArvanCloud from Iran"
  }],
  "probes": [{
    "requested": 1,
    "type": "probes",
    "value": "25407"
  }]
}
```

### Q5: Bale/Ita Video Call Protocol

**What We Know:**
- No public documentation on Bale's architecture found
- Historically Iran messengers used XMPP (Jabber-based)
- Modern video calls typically use WebRTC with STUN/TURN

**Investigation Approach:**
1. Capture pcap of Bale video call (requires Iranian device/volunteer)
2. Analyze protocols: look for STUN binding, TURN allocation, RTP streams
3. Check for centralized media server vs P2P WebRTC

**What to Look For in pcap:**
- STUN packets (3478/UDP or 5349/TCP)
- TURN relay addresses
- ICE candidate exchange
- Media codec negotiation (VP8/VP9/H.264 for video)

**Likely Architecture:** Centralized SFU (Selective Forwarding Unit) due to:
- Easier control/monitoring by government
- NAT traversal complexity in Iran
- Group call scalability requirements

### Q6: STUN Server Availability in Iran

**What We Know:**
- Global public STUN servers (Google, Twilio) are likely blocked/throttled
- Iranian apps likely run their own STUN/TURN infrastructure
- [WebRTC ICE servers list](https://www.metered.ca/blog/list-of-webrtc-ice-servers/) - none in Iran

**Investigation Approach:**
1. Enumerate STUN servers via scanning Iranian IP ranges (port 3478)
2. Test connectivity to Google STUN (`stun.l.google.com:19302`) from Iran
3. Use RIPE Atlas to probe UDP 3478 to known STUN servers

**Expected Finding:**
- External STUN servers blocked or extremely slow
- Local STUN servers exist on Bale/Ita/Rubika infrastructure
- Likely government-controlled media relay for monitoring

---

## Part 3: Implementation Steps

### Phase A: Query Existing Data (Immediate)

**1. OONI Measurements for Irancell (AS197207)**
```bash
# Query web connectivity tests from Irancell
curl "https://api.ooni.io/api/v1/measurements?probe_cc=IR&probe_asn=AS197207&test_name=web_connectivity&since=2026-01-01&limit=100"

# Query DNS tests
curl "https://api.ooni.io/api/v1/measurements?probe_cc=IR&test_name=dns_consistency&since=2026-01-01"
```

**2. RIPE Atlas Existing Measurements**
```bash
# Check existing measurements for TCI
curl "https://atlas.ripe.net/api/v2/measurements/?target_asn=58224&status=2"

# Check active probes in Iran (only 1 exists!)
curl "https://atlas.ripe.net/api/v2/probes/?country_code=IR&status=1"

# Get results from existing measurements
curl "https://atlas.ripe.net/api/v2/measurements/{msm_id}/results/"
```

**3. DNSmon K-root Data**
- Access: `https://dnsmon.ripe.net/dns-servfail/K-root/`
- Export latency data for probe 25407 to K-root Tehran

**4. RIPEStat DNS Resolver Check**
```bash
# Check what DNS resolver is used by Iranian networks
curl "https://stat.ripe.net/data/dns-chain/data.json?resource=google.com&country=IR"
```

### Phase B: Create New RIPE Atlas Measurements

**RIPE Atlas API Key:** `a97c740a-13d7-485c-bc1e-3eaca93e2dbf`

**Note:** Iran has only 1 active probe (ID: 25407 on AS14593). We can also measure FROM external probes TO Iranian IPs.

**Measurement 1: Ping to ArvanCloud from Iran**
```bash
curl -X POST "https://atlas.ripe.net/api/v2/measurements/" \
  -H "Authorization: Key a97c740a-13d7-485c-bc1e-3eaca93e2dbf" \
  -H "Content-Type: application/json" \
  -d '{"definitions":[{"target":"185.220.0.1","af":4,"packets":3,"size":48,"type":"ping","description":"Ping ArvanCloud from Iran"}],"probes":[{"requested":1,"type":"probes","value":"25407"}],"is_oneoff":true}'
```

**Measurement 2: DNS Query for Blocked Domain (telegram.org)**
```bash
curl -X POST "https://atlas.ripe.net/api/v2/measurements/" \
  -H "Authorization: Key a97c740a-13d7-485c-bc1e-3eaca93e2dbf" \
  -H "Content-Type: application/json" \
  -d '{"definitions":[{"target":"8.8.8.8","af":4,"type":"dns","query_class":"IN","query_type":"A","query_argument":"telegram.org","use_probe_resolver":false,"description":"DNS telegram.org from Iran"}],"probes":[{"requested":1,"type":"probes","value":"25407"}],"is_oneoff":true}'
```

**Measurement 3: DNS Query for Whitelisted Domain (sibapp.com)**
```bash
curl -X POST "https://atlas.ripe.net/api/v2/measurements/" \
  -H "Authorization: Key a97c740a-13d7-485c-bc1e-3eaca93e2dbf" \
  -H "Content-Type: application/json" \
  -d '{"definitions":[{"target":"8.8.8.8","af":4,"type":"dns","query_class":"IN","query_type":"A","query_argument":"sibapp.com","description":"DNS sibapp.com from Iran"}],"probes":[{"requested":1,"type":"probes","value":"25407"}],"is_oneoff":true}'
```

**Measurement 4: SSL/TLS to ArvanCloud with google.com SNI**
```bash
curl -X POST "https://atlas.ripe.net/api/v2/measurements/" \
  -H "Authorization: Key a97c740a-13d7-485c-bc1e-3eaca93e2dbf" \
  -H "Content-Type: application/json" \
  -d '{"definitions":[{"target":"185.220.0.1","af":4,"type":"sslcert","port":443,"hostname":"google.com","description":"TLS ArvanCloud with google.com SNI"}],"probes":[{"requested":1,"type":"probes","value":"25407"}],"is_oneoff":true}'
```

**Measurement 5: Traceroute to K-root from global probes**
```bash
curl -X POST "https://atlas.ripe.net/api/v2/measurements/" \
  -H "Authorization: Key a97c740a-13d7-485c-bc1e-3eaca93e2dbf" \
  -H "Content-Type: application/json" \
  -d '{"definitions":[{"target":"193.0.14.129","af":4,"type":"traceroute","protocol":"ICMP","description":"Traceroute to K-root global"}],"probes":[{"requested":50,"type":"area","value":"WW"}],"is_oneoff":true}'
```

**Fetch Measurement Results:**
```bash
# After creating measurements, get results (replace {id} with measurement ID)
curl "https://atlas.ripe.net/api/v2/measurements/{id}/results/" \
  -H "Authorization: Key a97c740a-13d7-485c-bc1e-3eaca93e2dbf"
```

### Phase C: Analysis Scripts to Create

**`investigation/scripts/ripe_atlas.py`** - RIPE Atlas API wrapper
```python
#!/usr/bin/env python3
"""RIPE Atlas measurement creation and retrieval"""
import requests
import os
import json

class RIPEAtlas:
    API_KEY = os.environ.get('RIPE_ATLAS_API_KEY')
    BASE_URL = "https://atlas.ripe.net/api/v2"
    IRAN_PROBE = "25407"  # Only active probe in Iran

    def create_ping(self, target_ip, description):
        """Create one-off ping measurement from Iran"""

    def create_dns(self, resolver, query_domain, use_probe_resolver=False):
        """Create DNS measurement to test blocking"""

    def create_sslcert(self, target_ip, sni_hostname, port=443):
        """Create SSL cert measurement to test SNI filtering"""

    def get_results(self, measurement_id):
        """Fetch measurement results"""

    def list_iran_probes(self):
        """List all probes in Iran (connected and disconnected)"""
```

**`investigation/scripts/ooni_analysis.py`** - OONI data analysis
```python
#!/usr/bin/env python3
"""Analyze OONI measurements for Iranian ISPs"""

def get_measurements_by_asn(asn, test_name, since):
    """Fetch OONI measurements for specific ASN"""

def analyze_blocking_patterns(measurements):
    """Identify DNS vs TCP vs HTTP blocking"""

def compare_isps(asns=['AS197207', 'AS44244', 'AS58224']):
    """Compare blocking behavior across ISPs"""
```

---

## Part 4: Files to Modify/Create

### Existing Files to Extend
| File | Change |
|------|--------|
| `investigation/scripts/fetch_signals.py` | Add RIPE Atlas measurement retrieval |
| `interface/lib/data-processor.ts` | Add DNS analysis data processing |
| `interface/app/data.json` | Add DNS/K-root metrics to dashboard |

### New Files to Create
| File | Purpose |
|------|---------|
| `investigation/scripts/ripe_atlas.py` | RIPE Atlas API wrapper for measurements |
| `investigation/scripts/ooni_analysis.py` | OONI data fetching and analysis |
| `investigation/data/atlas/` | Directory for RIPE Atlas results |

---

## Part 5: Verification

### How to Test
1. **Run RIPE Atlas measurements** via `ripe_atlas.py`
2. **Check results** at https://atlas.ripe.net/measurements/{id}
3. **Cross-reference** with OONI Explorer: https://explorer.ooni.org/search?probe_cc=IR
4. **DNSmon K-root**: Verify Tehran instance latency at https://dnsmon.ripe.net/

### Expected Outcomes
| Question | Expected Finding |
|----------|------------------|
| Q1: Fake google.com cert | Connection reset at ClientHello (SNI block) |
| Q2: Whitelisted domain | TLS handshake succeeds |
| Q3: DNS upstream | Likely poisoned for blocked domains |
| Q4: ICMP to ArvanCloud | Probably allowed (internal traffic) |

---

## Part 6: Deferred Items (Q5-Q6)

**Requires local volunteer in Iran:**
- Bale/Ita video call protocol analysis (pcap capture)
- STUN server enumeration from inside Iran
- WebRTC ICE candidate testing

**Fallback approach if no volunteer:**
- Reverse engineer Bale APK for server endpoints
- Scan Iranian IP ranges for STUN ports (3478/UDP)
- Analyze DNS records for stun.*.ir domains

---

## Sources & References

- [RIPE Atlas API Reference](https://atlas.ripe.net/docs/apis/rest-api-reference/)
- [RIPE Atlas User-Defined Measurements](https://atlas.ripe.net/docs/getting-started/user-defined-measurements/)
- [RIPE Atlas Credits System](https://atlas.ripe.net/docs/getting-started/credits.html)
- [Iran and K-root - RIPE Labs](https://labs.ripe.net/author/emileaben/iran-and-k-root-the-rest-of-the-story/)
- [DNS in Iran Part 1 - RIPE Labs](https://labs.ripe.net/author/babak_farrokhi/a-tale-of-using-public-dns-servers-in-iran-part-1/)
- [DNS in Iran Part 2 - RIPE Labs](https://labs.ripe.net/author/babak_farrokhi/a-tale-of-using-public-dns-servers-in-iran-part-2/)
- [Iran GFW Technical Report - net4people](https://github.com/net4people/bbs/issues/253)
- [OONI API Documentation](https://api.ooni.io/)
- [DNSmon by RIPE NCC](https://dnsmon.ripe.net/)
