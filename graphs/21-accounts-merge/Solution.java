class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        var unionFind = new UnionFind();
        Map<String, String> emailToUser = new HashMap<>();
        Map<String, List<String>> groupEmails = new HashMap<>();
        List<List<String>> mergedAccounts = new ArrayList<>();

        for (var account : accounts) {
            String user = account.get(0);
            String email = account.get(1);
            unionFind.add(email);
            emailToUser.put(email, user);
            for (int i = 2; i < account.size(); i++) {
                String currentEmail = account.get(i);
                emailToUser.put(currentEmail, user);
                unionFind.union(currentEmail, email);
            }
        }

        for (var email : emailToUser.keySet()) {
            groupEmails.computeIfAbsent(unionFind.find(email), x -> new ArrayList<>()).add(email);
        }

        for (var group : groupEmails.entrySet()) {
            List<String> merged = new ArrayList<>();
            String root = group.getKey();
            String user = emailToUser.get(root);
            merged.add(user);
            List<String> emails = group.getValue();
            Collections.sort(emails);
            merged.addAll(emails);
            mergedAccounts.add(merged);
        }

        return mergedAccounts;
    }

    private class UnionFind {
        Map<String, String> parent = new HashMap<>();

        public void add(String x) {
            if (!parent.containsKey(x)) parent.put(x, x);
        }

        public String find(String x) {
            if (!parent.containsKey(x)) { add(x); return x; }
            if (!parent.get(x).equals(x)) parent.put(x, find(parent.get(x)));
            return parent.get(x);
        }

        public void union(String x, String y) {
            String px = find(x), py = find(y);
            if (px.equals(py)) return;
            parent.put(py, px);
        }
    }
}
