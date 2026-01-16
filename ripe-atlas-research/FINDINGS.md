# Iran Internet Infrastructure - RIPE Atlas Findings

Date: 2026-01-15 

---

## Answered Questions

### Q3: DNS Upstream Behavior
**Answer:** DNS is poisoned at the network level. Queries to external resolvers (8.8.8.8, 1.1.1.1) return block page IPs for censored domains.

**Evidence:**
- Measurement [149088147](https://atlas.ripe.net/measurements/149088147/)
  - Query: `telegram.org` via 8.8.8.8 from inside Iran
  - Response: `10.10.34.36` (block page IP)
- Control measurement [149083552](https://atlas.ripe.net/measurements/149083552/)
  - Same query from outside Iran → `149.154.167.99` (correct answer)

### Q4: ICMP to ArvanCloud
**Answer:** Yes, ArvanCloud is reachable internally at 3.5ms latency.

**Evidence:**
- Measurement [149088153](https://atlas.ripe.net/measurements/149088153/)
  - Target: `185.143.232.1` (ArvanCloud)
  - Result: 3.5ms RTT from probe 25407
- Also tested [149088159](https://atlas.ripe.net/measurements/149088159/)
  - Target: `185.53.142.188` (sibapp.com on ArvanCloud)
  - Result: 8.8ms RTT

---

## Unanswered Questions

### Q1: Fake google.com cert on ArvanCloud
**Status:** Cannot test externally
**Why:** ArvanCloud IPs not globally routable. Measurement [149083401](https://atlas.ripe.net/measurements/149083401/) shows 100% timeout from global probes.

### Q2: Whitelisted domains (sibapp.com) on ArvanCloud
**Status:** Cannot test TLS handshake
**Why:** Same limitation. We confirmed sibapp.com resolves and is pingable internally, but cannot test certificate behavior.

### Q5-Q6: Bale/Ita protocols, STUN servers
**Status:** Requires pcap capture from inside Iran

---

## Raw Data

All measurements: [measurements_20260115.json](data/atlas/measurements_20260115.json)

| ID | Link | Type | Description |
|----|------|------|-------------|
| 149088147 | [View](https://atlas.ripe.net/measurements/149088147/) | DNS | telegram.org from Iran (poisoned) |
| 149088153 | [View](https://atlas.ripe.net/measurements/149088153/) | Ping | ArvanCloud from Iran (3.5ms) |
| 149088004 | [View](https://atlas.ripe.net/measurements/149088004/) | Ping | 8.8.8.8 from Iran (61.1ms) |
| 149083552 | [View](https://atlas.ripe.net/measurements/149083552/) | DNS | telegram.org from global (correct) |
| 149083401 | [View](https://atlas.ripe.net/measurements/149083401/) | Ping | ArvanCloud from global (timeout) |

---

## Infrastructure Note
- Only 1 active RIPE Atlas probe in Iran: [25407](https://atlas.ripe.net/probes/25407/) (AS14593, Tehran)
- All 12 anchor probes disconnected as of 2026-01-15
