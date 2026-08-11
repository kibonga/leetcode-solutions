class Solution {
    public static List<Integer> dailyTemperatures(List<Integer> t) {
        Deque<Integer> stackIdx = new ArrayDeque<>();
        int[] answerIdx = new int[t.size()];
        for (int i = 0; i < t.size(); i++) {
            int temperature = t.get(i);
            while (!stackIdx.isEmpty() && temperature > t.get(stackIdx.peek())) {
                answerIdx[stackIdx.peek()] = i - stackIdx.pop();
            }
            stackIdx.push(i);
        }
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < answerIdx.length; i++) {
            answer.add(answerIdx[i]);
        }
        return answer;
    }
}
