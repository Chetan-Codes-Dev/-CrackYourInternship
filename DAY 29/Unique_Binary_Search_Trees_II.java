class Solution {
    public List<TreeNode> func(int start, int end, Map<Pair<Integer, Integer>, List<TreeNode>> dp) {
        List<TreeNode> ans = new ArrayList<>();
        if (start > end) {
            ans.add(null);
            return ans;
        }
        if (dp.containsKey(new Pair<>(start, end)))
            return dp.get(new Pair<>(start, end));

        for (int i = start; i <= end; i++) {
            List<TreeNode> left = func(start, i - 1, dp);
            List<TreeNode> right = func(i + 1, end, dp);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i, l, r);
                    ans.add(root);
                }
            }
        }

        dp.put(new Pair<>(start, end), ans);
        return ans;
    }

    public List<TreeNode> generateTrees(int n) {
        Map<Pair<Integer, Integer>, List<TreeNode>> dp = new HashMap<>();
        return func(1, n, dp);
    }
}